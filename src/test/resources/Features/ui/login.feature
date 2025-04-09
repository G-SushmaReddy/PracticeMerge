Feature: Login User

  Scenario Outline: The user login with valid credentials
    Given the user is on the home page
    When the user enters into the login page
    And the user enters the username "<username>" and password "<password>"
    And the user clicks on the sign in button
    Then the user is redirected to the homepage

    Examples:

    |username|password|
    |admin   |admin   |
    |user    |user    |

  Scenario Outline: User login failed with invalid credentials
    Given the user is on the home page
    When the user enters into the login page
    And the user enters the username "<username>" and password "<password>"
    And the user clicks on the sign in button
    Then the error message is displayed

    Examples:
    |username|password|
    |sushma  |sushma  |
    |sindhu  |sindhu  |



