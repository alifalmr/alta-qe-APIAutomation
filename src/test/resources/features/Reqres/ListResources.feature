Feature: Testing Reqres API for endpoint LIST RESOURCES
  @Latihan
  Scenario: Get list resources
    Given Get list resources
    When Send request get list resources
    Then Should return status code 200
    And Response body should page should be 1
    And Validate json schema list resources

  @Tugas
  Scenario: Get list resources with parameter page
    Given Get list resources with page 2
    When Send request get list resources with page
    Then Should return status code 200
    And Response body should page should be 2
    And Validate json schema list resources

  @Tugas
  Scenario Outline: Get list resources with parameter per_page
    Given Get list resources with per_page <perPage>
    When Send request get list resources with per_page
    Then Should return status code 200
    And Response body per_page should be <perPage> and total_pages should be <totalPages>
  Examples:
    | perPage | totalPages |
    | 2       | 6          |
    | 1       | 12         |

  @Tugas
  Scenario: Get list resources with parameter per_page and page
    Given Get list resources with per_page 1 and page 7
    When Send request get list resources with per_page and page
    Then Should return status code 200
    And Response body page should be 7, per_page should be 1 and total_pages should be 12
