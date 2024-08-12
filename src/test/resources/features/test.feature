Feature: test scratch
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
     | random |product detail|nameProduct                         | Category                | Price    | Availability           | Condition      | Brand          |
      |      2 |https://www.automationexercise.com/product_details/2 |Sleeveless Dress                    | Category: Women > Dress | Rs. 1000 | Availability: In Stock | Condition: New | Brand: Madame  |
      |     16 |https://www.automationexercise.com/product_details/16 |Sleeves Top and Short - Blue & Pink | Category: Kids > Dress  | Rs. 478  | Availability: In Stock | Condition: New | Brand: Babyhug |
