Feature: GitHub API Automation

  Background:
    * url 'https://api.github.com'
    * def token = 'sample'
    * def authorizationToken = 'Bearer ' + token
    * header Authorization = 'Bearer ' + token
    * header Content-Type = 'application/json'
    * def username = 'sample'
    #please replace github account username with username field and personal access token for token field

  Scenario: Create a New Repository
    Given path '/user/repos'
    And request { name: 'test-repo', description: 'Sample repo created using Karate', private: false }
    When method post
    Then status 201
    And match response.name == 'test-repo'

  Scenario: Fetching of Repository Details
    Given path '/repos/' + username + '/test-repo'
    When method get
    Then status 200
    And match response.name == 'test-repo'
    And match response.private == false

  Scenario: Issue Creation
    Given path '/repos/' + username + '/test-repo/issues'
    And request { title: 'Sample Issue', body: 'Issue created by Karate' }
    When method post
    Then status 201
    And match response.title == 'Sample Issue'

  Scenario: List Issues
    Given path '/repos/' + username + '/test-repo/issues'
    When method get
    Then status 200
    And match response[0].title == 'Sample Issue'

  Scenario: Create Initial Commit in main branch
    Given path '/repos/' + username + '/test-repo/contents/README.md'
    And def rawContent = '# Test Repo Karate\nTest content'
    And def base64Content = java.util.Base64.getEncoder().encodeToString(rawContent.getBytes())
    And def requestBody =
    """
    {
      "message": "Initial commit",
      "content": "#(base64Content)",
      "branch": "main"
    }
    """
    And request requestBody
    When method put
    Then status 201
    And match response.content.name == 'README.md'

  Scenario: Create a New Branch
    # Fetch commit SHA from the main branch
    Given path '/repos/' + username + '/test-repo/git/refs/heads/main'
    When method get
    Then status 200
    * def commitShaNew = response.object.sha
    * print 'Commit SHA:', commitShaNew

    Given url 'https://api.github.com/repos/' + username + '/test-repo/git/refs'
    And def authHeader = { Authorization: authorizationToken }
    And headers authHeader
    And request {"ref": "refs/heads/new-branch", "sha": '#(commitShaNew)'}
    When method post
    Then status 201
    And match response.ref == 'refs/heads/new-branch'

  Scenario: Create Commit in New Branch
    Given path '/repos/' + username + '/test-repo/contents/sample.txt'
    And def rawContent = '# Test Repo Karate\nsample content'
    And def base64Content = java.util.Base64.getEncoder().encodeToString(rawContent.getBytes())
    And def requestBody =
    """
    {
      "message": "New commit",
      "content": "#(base64Content)",
      "branch": "new-branch"
    }
    """
    And request requestBody
    When method put
    Then status 201
    And match response.content.name == 'sample.txt'

  Scenario: Create a Pull Request
    Given path '/repos/' + username + '/test-repo/pulls'
    And request {"title": "Add new feature", "body": "Pull request created by Karate", "head": "new-branch", "base": "main"}
    When method post
    Then status 201
    And match response.title == 'Add new feature'
    And match response.body == 'Pull request created by Karate'
    And match response.state == 'open'

  Scenario: Authentication and Permissions
    Given header Authorization = 'Bearer invalid_token'
    And path '/user/repos'
    When method get
    Then status 401
    And match response.message == 'Bad credentials'