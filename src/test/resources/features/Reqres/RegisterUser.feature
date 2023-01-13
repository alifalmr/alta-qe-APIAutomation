Feature: Testing Reqres API for endpoint REGISTER SUCCESSFUL
  @Tugas
  Scenario: Post register user with valid json
    Given Post register user with valid json
    When Send request post register user
    Then Should return status code 200
    And Response body id should be 4
    And Validate json schema register user

