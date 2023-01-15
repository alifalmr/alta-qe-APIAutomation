Feature: Testing Reqres API for endpoint REGISTER SUCCESSFUL
  @Tugas
  Scenario: Post register user with valid email and password
    Given Post register user with valid email and password
    When Send request post register user
    Then Should return status code 200
    And Response body id should be 4
    And Validate json schema register user

  @Tugas
  Scenario: Post register user with valid username and password
    Given Post register user with username and password
    When Send request post register user
    Then Should return status code 200
    And Response body id should be 4
    And Validate json schema register user

  @Tugas
  Scenario: Post register user without password
    Given Post register user without password
    When Send request post register user
    Then Should return status code 400
    And Response body error should be "Missing password"

  @Tugas
  Scenario: Post register user without email or username
    Given Post register user without email or username
    When Send request post register user
    Then Should return status code 400
    And Response body error should be "Missing email or username"



