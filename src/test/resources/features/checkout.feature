Feature: Checkout Functionality

  @Positive
  Scenario: Ensure user directed to summary checkout page before buying
    Given user is at SauceDemo login page
    When user inputs standard account username
    And user inputs standard account password
    And user clicks login button
    When user clicks Add-to-card button
    And user clicks cart button
    And user clicks checkout button
    And user fills personal information
    And user clicks continue on personal information page
    Then user will be directed to summary checkout page
    And user can see the desired product name
    And user can see the similar product price

  @Negative
  Scenario: Ensure user failed to be directed to summary checkout with empty data
    Given user is at SauceDemo login page
    When user inputs standard account username
    And user inputs standard account password
    And user clicks login button
    When user clicks Add-to-card button
    And user clicks cart button
    And user clicks checkout button
    And user clicks continue on personal information page
    Then user will be notified error message to fill the form
    And user will not be directed to summary checkout page

  @Positive
  Scenario: Ensure user successfully buying product
    Given user is at SauceDemo login page
    When user inputs standard account username
    And user inputs standard account password
    And user clicks login button
    When user clicks Add-to-card button
    And user clicks cart button
    And user clicks checkout button
    And user fills personal information
    And user clicks continue on personal information page
    And user clicks finish button
    Then user will be notified order complete
    And user will see thank you message