Feature: Login functionality
  @Positive
  Scenario Outline: Ensure user successfully login
    Given user is at SauceDemo login page
    When user inputs registered account username <username>
    And user inputs registered account password <password>
    And user clicks login button
    Then user is redirected to product page

    Examples:
      | username                | password      |
      | standard_user           | secret_sauce  |
      | performance_glitch_user | secret_sauce  |
      | problem_user            | secret_sauce  |

  @Negative
  Scenario: Ensure user failed login with unregistered account
    Given user is at SauceDemo login page
    When user inputs unregistered account username
    And user inputs unregistered account password
    And user clicks login button
    Then user is notified error message

  @Negative
  Scenario: Ensure user failed login with locked account
    Given user is at SauceDemo login page
    When user inputs locked account username
    And user inputs locked account password
    And user clicks login button
    Then user is notified error message
