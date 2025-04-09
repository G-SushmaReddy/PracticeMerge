Feature: User Authentication

  Scenario: Successful Registration
    Given I have valid user details
    When I send a registration request
    Then I should get a response with status code 201