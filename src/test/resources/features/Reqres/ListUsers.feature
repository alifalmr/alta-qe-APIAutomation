Feature: Testing Reqres API for endpoint LIST USERS
  @Latihan
  Scenario Outline: Get list users with valid parameter page reqresAPI
    Given Get list users with page <page>
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
    Given Get list users with page "<param>"
    When Send request get list users
    Then Should return status code 404
  Examples:
    | param |
    | #     |
    | i     |
    | bnm   |

  @Tugas
  Scenario: Get list users with parameter per_page
    Given Get list users with parameter per_page 4
    When Send request get list users with parameter per_page
    Then Should return status code 200
    And Response body per_page should be 4 and total_pages should be 3
    And Validate json schema list users per_page

  @Tugas
  Scenario Outline: Get list users with parameter per_page
    Given Get list users with parameter per_page <perPage>
    When Send request get list users with parameter per_page
    Then Should return status code 200
    And Response body per_page should be <perPage> and total_pages should be <totalPages>
  Examples:
    | perPage | totalPages |
    | 4       | 3          |
    | 6       | 2          |

  @Tugas
  Scenario: Get list users with parameter per_page and page
    Given Get list users with parameter per_page 3 and page 2
    When Send request get list users with parameter per_page and page
    Then Should return status code 200
    And Response body page should be 2, per_page should be 3 and total_pages should be 4