Feature: Product purchasing process

  Scenario: Go to the demo site and complete a product purchase
    Given I am on the demo site
    When I click on phone product card
    And I click on the Add to cart button in product detail page
    And I click the OK button on the warning screen
    And I click on the Cart menu
    And I click on the Place Order button
    And I fill in the form information
    And I click on the Purchase button
    Then The message that Thank you for your purchase should be displayed
    And The information provided should be accurate with the relevant product information






