Feature: Login into Github application by creating new account

  #Please note that the values provided in username and password for valid credentials are not correct.
  # Please provide valid credentials while running the test cases
  Scenario: Verify Signup Page
    Given user launches the browser "chrome" and github url "https://github.com/login"
   And user creates a new account using username "sample@gmail.com" and password "ABC@12345abcefghi" and ueername "sample"

    Scenario:Verify signup page with invalid email,password amd username
      Given user launches the browser "chrome" and github url "https://github.com/login"
      And validate whether invalid credentials throw error message
        | Key             | Value             |
        | Invalidemail    | mmm               |
        | Validemail      | sample@gmail.com  |
        | InvalidPassword | abcef             |
        | ValidPassword   | ABC@12345abcefghi |
        | Invalidusername | mmmmm             |
        | ValidUsername   | sample                 |
