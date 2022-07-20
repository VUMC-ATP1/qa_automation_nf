Feature: Inventory feature
  As a user,
  I want to be able to log in
  So I can purchase product

  Scenario: Success login and product purchase
    Given I have navigated to login page
    When I login with "standard_user" and "secret_sauce"
    Then I am successfully logged in
    Then I select "Sauce Labs Bike Light" product
    Then I click 'Add to cart' button
    Then I see shopping cart badge for one product
    Then I click shopping cart link
    Then I see "Sauce Labs Bike Light" product
    Then I click 'Checkout' button
    Then I enter firstname as "Jānis", lastname as "Bērziņš" and postal code as "LV-1234"
    Then I click 'Continue' button
    Then I see "Sauce Labs Bike Light" product in quantity of "1"
    Then I click 'Finish' button
    Then I click 'Back Home' button