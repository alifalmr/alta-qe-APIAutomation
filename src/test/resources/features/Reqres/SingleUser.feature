Feature: Testing Reqres API for endpoin SINGLE USER
  @Tugas
  Scenario Outline: Get a user with valid parameter
    Given Get a user with id <id>
    When Send request get a user
    Then Should return status code 200
    And Response body data.id should be <id>
    And Validate json schema single user
  Examples:
    | id |
    | 3  |
    | 6  |

  @Tugas
  Scenario Outline: Get a user with invalid id
    Given Get a user with id <id>
    When Send request get a user
    Then Should return status code 404
  Examples:
    | id |
    | 14 |
    | 23 |
