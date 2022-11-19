Feature: Cart Functionality

  @Positive
  Scenario: Ensure user successfully add product to cart
    Given user is at SauceDemo login page
    When user inputs standard account username
    And user inputs standard account password
    And user clicks login button
    When user clicks Add-to-card button
    Then user founds increment at cart badge

  @Positive
  Scenario: Ensure user successfully remove product to cart
    Given user is at SauceDemo login page
    When user inputs standard account username
    And user inputs standard account password
    And user clicks login button
    When user clicks Add-to-card button
    When user clicks remove button
    Then user founds decrement at card badge

  @Positive
  Scenario: Ensure user successfully added the correct product to cart
    Given user is at SauceDemo login page
    When user inputs standard account username
    And user inputs standard account password
    And user clicks login button
    When user clicks Add-to-card button
    And user clicks cart button
    Then user will be directed to cart page
    And  user will see the added product on the cart page