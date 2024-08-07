
@tag
Feature: Check product page fucntionality
  I want to use this to verify All product and product detail
  I want to use this to search product

Background: 
    Given user navigates to https://www.automationexercise.com/
    And homepage is displayed
    
  
  Scenario: verify all products and detail page
    When user clicks Product button
    Then user is navigated to ALL PRODUCT PAGE
    And list product is visible
    When user clicks on random product
    Then product detail is displayed
    And detail is visible: 'Sleeveless Dress', 'Women > Dress', 'Rs. 1000', 'In Stock', 'New', 'Madame'
      

 
