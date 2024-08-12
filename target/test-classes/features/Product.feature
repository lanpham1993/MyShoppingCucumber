Feature: Check product page fucntionality
  I want to use this to verify All product and product detail
  I want to use this to search product

  Background: 
    Given user navigates to https://www.automationexercise.com/
    And homepage is displayed
    When user clicks Product button

  Scenario Outline: verify all products and detail page
    Then user is navigated to ALL PRODUCT PAGE
    And list product is visible
    When user clicks View product on <random> product
    Then '<product detail>' is displayed
    And detail is visible: '<nameProduct>','<Category>','<Price>','<Availability>','<Condition>','<Brand>'

    Examples: 
      | random | product detail                                        | nameProduct                         | Category                | Price    | Availability           | Condition      | Brand                     |
      |      2 | https://www.automationexercise.com/product_details/2  | Men Tshirt                          | Category: Men > Tshirts | Rs. 400  | Availability: In Stock | Condition: New | Brand: H&M                |
      |     16 | https://www.automationexercise.com/product_details/19 | Sleeves Top and Short - Blue & Pink | Category: Kids > Dress  | Rs. 1050 | Availability: In Stock | Condition: New | Brand: Allen Solly Junior |

  Scenario Outline: Verify search product functionality
    When user enters '<Criteria>' in search textbox
    And clicks button Search
    Then Verify '<Search results>' is visible

    Examples: 
      | Criteria | Search results |
      | top      |             14 |
      | dress    |              9 |
      | polo     |              1 |
      | aaaa     |              0 |
