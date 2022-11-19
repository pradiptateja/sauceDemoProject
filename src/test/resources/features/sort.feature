Feature: Sort Functionality

  @Positive
  Scenario: Ensure user successfully sorts product by Price low to high
    Given user is at SauceDemo login page
    When user inputs standard account username
    And user inputs standard account password
    And user clicks login button
    When user see current product view
    When user clicks sort button
    And user chooses sort product by price low to high
    Then user successfully rearranges the product list by price

  @Positive
  Scenario: Ensure user successfully sorts product by Name Z to A
    Given user is at SauceDemo login page
    When user inputs standard account username
    And user inputs standard account password
    And user clicks login button
    When user see current product view
    And user clicks sort button
    And user chooses sort product by price Z to A
    Then user successfully rearranges the product list by name
