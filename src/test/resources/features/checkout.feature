Feature: Checkout feature
  As a user,
  I want to be able to log in
  So I can validate the required fields in Checkout page

  Scenario: Required field validation
    Given I have navigated to login page
    When I login with "standard_user" and "secret_sauce"
    Then I am successfully logged in
    Then I click shopping cart link
    Then I click 'Checkout' button
    Then I enter firstname as "", lastname as "Bērziņš" and postal code as "LV-1234"
    Then I click 'Continue' button
    Then I see error message "Error: First Name is required"
    Then I refresh the page
    Then I enter firstname as "Jānis", lastname as "" and postal code as "LV-1234"
    Then I click 'Continue' button
    Then I see error message "Error: Last Name is required"
    Then I refresh the page
    Then I enter firstname as "Jānis", lastname as "Bērziņš" and postal code as ""
    Then I click 'Continue' button
    Then I see error message "Error: Postal Code is required"
    Then I refresh the page
    Then I enter firstname as "Jānis", lastname as "Bērziņš" and postal code as "LV-1234"
    Then I click 'Continue' button
    Then I have successfully navigated to "https://www.saucedemo.com/checkout-step-two.html"
    Then I click 'Finish' button
    Then I click 'Back Home' button