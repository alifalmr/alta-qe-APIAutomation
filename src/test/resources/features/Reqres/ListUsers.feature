Feature: Testing Reqres API for endpoint LIST USERS
  @Latihan
  Scenario Outline: Get list users with valid parameter page reqresAPI
    Given Get list user with page <page>
    When Send request get list users
    Then Should return status code 200
    And Response body should page should be <page>
    And Validate json schema list users
    Examples:
      | page |
      | 1    |
      | 2    |

  @Tugas
  Scenario Outline: Get list users with invalid parameter
    Given Get list user with page "<param>"
    When Send request get list users
    Then Should return status code 404
  Examples:
    | param |
    | #     |
    | i     |
    | bnm   |