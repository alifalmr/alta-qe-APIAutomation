Feature: Testing Reqres API for endpoint LOGIN SUCCESSFUL
  @Tugas
  Scenario: Post login user with valid json
    Given Post login user with valid json
    When Send request post login user
    Then Should return status code 200
    And Validate json schema login user

  @Tugas
  Scenario: Post login user with invalid json
    Given Post login user with invalid json
    When Send request post login user
    Then Should return status code 400