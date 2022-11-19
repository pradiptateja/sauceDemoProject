Feature: Burger Menu Functionality

  @Positive
  Scenario: Ensure all-item menu is working
    Given user is at SauceDemo login page
    When user inputs standard account username
    And user inputs standard account password
    And user clicks login button
    And user clicks cart button
    And user clicks burger menu button
    And user clicks all-item option
    Then user is redirected to product page

  @Positive
  Scenario: Ensure about menu is working
    Given user is at SauceDemo login page
    When user inputs standard account username
    And user inputs standard account password
    And user clicks login button
    And user clicks burger menu button
    And user clicks about option
    Then user will be directed to SauceLab website

  @Positive
  Scenario: Ensure user successfully logout
    Given user is at SauceDemo login page
    When user inputs standard account username
    And user inputs standard account password
    And user clicks login button
    And user clicks burger menu button
    And user clicks Logout option
    Then user is at SauceDemo login page

