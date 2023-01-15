Feature: Testing Reqres API for endpoint LOGIN SUCCESSFUL
  @Tugas
  Scenario: Post login user with valid email and password
    Given Post login user with valid email and password
    When Send request post login user
    Then Should return status code 200
    And Validate json schema login user

  @Tugas
  Scenario: Post login user with valid username and password
    Given Post login user with valid username and password
    When Send request post login user
    Then Should return status code 200
    And Validate json schema login user

  @Tugas
  Scenario: Post login user without password
    Given Post login user without password
    When Send request post login user
    Then Should return status code 400
    And Response body error should be "Missing password"

  @Tugas
  Scenario: Post login user without email
    Given Post login user without email
    When Send request post login user
    Then Should return status code 400
    And Response body error should be "Missing email or username"