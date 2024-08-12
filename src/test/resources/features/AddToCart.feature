Feature: Verify Add to Cart functionality

  Background: 
    Given user navigates to https://www.automationexercise.com/
    And homepage is displayed
    And user clicks Product button

  Scenario Outline: Verify user adds product to cart from product page 
    When user clicks product '8' add to cart
    And clicks button Continue Shopping
    When user clicks product '16' add to cart
    And clicks View Cart
    Then '2' products are added to Cart
    And check detail products are displayed correctly
      |  8 | Rs. 700  | 1 | Rs. 700  |
      | 16 | Rs. 1050 | 1 | Rs. 1050 |

  Scenario: Verify user adds product to cart from detail product page 
     When user clicks View product on random product
     And edit Quanity to '5'
     And clicks button Add to Cart
     And Clicks View Cart on Popup
     Then '1' products are added to Cart
    And check detail products are displayed correctly
      |  5 | Rs. 600  | 5 | Rs. 30000  |
      