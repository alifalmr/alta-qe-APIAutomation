Feature: Testing Reqres API for endpoint DELETE USER
  @Latihan
  Scenario Outline: Delete user with valid id
    Given Delete user with id <id>
    When Send request delete user
    Then Should return status code 204
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas
  Scenario: Delete user with invalid id
    Given Delete user with id 27
    When Send request delete user
    Then Should return status code 404
