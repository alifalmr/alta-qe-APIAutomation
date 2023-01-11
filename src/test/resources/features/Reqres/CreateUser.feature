Feature: Testing Reqres API for endpoint CREATE USER
  @Latihan
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "alifa" and job "SDET"

  @Tugas
  Scenario: Post create new user with invalid json
    Given Post create user with invalid json
    When Send request post create user
    Then Should return status code 400