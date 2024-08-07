@tag
Feature: Check Login fucntionality
  I want to use this template for my feature Login

  Background: 
    Given user navigates to https://www.automationexercise.com/
    And user clicks on SignUp/Login button

  @tag1
  Scenario: Login User with correct email and password
    When user enters correct email and password
      | NameTesting12345@outlook.com | 123456 |
    And clicks button Login
    Then homepage is displayed
    And 'Logged in as name1' is visible

  Scenario: Login User with incorrect email and password
    When user enters incorrect email and password
      | NameTesting12345@outlook.com | 1234567 |
    And clicks button Login
    Then verify error 'Your email or password is incorrect!' is visible

    
    Scenario: user logout successful
    Given user enters correct email and password
      | NameTesting12345@outlook.com | 123456 |
    And clicks button Login
    When user clicks logout 
    Then user is navigated to login page
   
     

    
    

    
