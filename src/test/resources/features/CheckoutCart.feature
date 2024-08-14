Feature: Verify Checkout functionality

  Background: 
    Given user navigates to https://www.automationexercise.com/
    And homepage is displayed
    When user clicks Product button

  Scenario: verify Place Order: Register while Checkout
    When user clicks product '28' add to cart
    And clicks View Cart on Popup
    And clicks button check out
    And clicks button Register / Login
    And user enters correct email and password
      | NameTesting12345@outlook.com | 123456 |
    And clicks button Login
    
