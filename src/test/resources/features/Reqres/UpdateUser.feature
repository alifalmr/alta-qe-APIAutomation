Feature: Testing Reqres API for endpoint UPDATE USER
  @Latihan
  Scenario: Put update user with valid json
    Given Put update user with valid json with id 2
    When Send request put update user
    Then Should return status code 200
    And Response body name should be "alifa" and job "SDET"
    And Validate json schema update user

  @Tugas
  Scenario: Put update user with invalid id
    Given Put update user with valid json with id 29
    When Send request put update user
    Then Should return status code 404

  @Tugas
  Scenario: Put update user with invalid json
    Given Put update user with invalid json with id 4
    When Send request put update user
    Then Should return status code 400