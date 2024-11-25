Feature: Github Application end to end verification

  Scenario: Verify Login Page
    Given user launches the browser "firefox" and github url "https://github.com/login"
    And user login into github application using username "sample@gmail.com" and password "ABC123abc"
    And user logout of the application

  Scenario: Creation of repository
    Given user launches the browser "firefox" and github url "https://github.com/login"
    And user login into github application using username "sample@gmail.com" and password "ABD@123abc"
    And user creates a new repository "test99" with "private" access
    And user logout of the application

  Scenario: Issue creation ,Label and assignee addition
    Given user launches the browser "firefox" and github url "https://github.com/login"
    And user login into github application using username "sample@gmail.com" and password "ABCDED@123abc"
    And user creates a new repository "test2" with "private" access
    And user creates issues for the repo
    And user creates label type "documentation" and assignee as the owner
    And user logout of the application

  Scenario: New branch creation
    Given user launches the browser "firefox" and github url "https://github.com/login"
    And user login into github application using username "sample@gmail.com" and password "ABCDED@123abc"
    And user creates a new repository "test67" with "private" access
    And user creates issues for the repo
    And user creates label type "documentation" and assignee as the owner
    And user creates a new branch "sample"
    And user logout of the application

  Scenario: Pullrequest and merging
    Given user launches the browser "firefox" and github url "https://github.com/login"
    And user login into github application using username "sample@gmail.com" and password "ABCDED@123abc"
    And user creates a new repository "test45" with "private" access
    And user creates issues for the repo
    And user creates label type "documentation" and assignee as the owner
    And user creates a new branch "sample"
    And user creates pull requests for the  "sample" to main branch
    And user logout of the application