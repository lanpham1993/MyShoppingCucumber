Feature: check register functionalty
  In order to register
  As a User
  I have to navigate to www.automationexercise.com/

Background: 
Given user navigates to https://www.automationexercise.com/
And user clicks on SignUp/Login button


  @tag1
  Scenario: Register user successful    
    When enter Name and email
      | lan | lanpham09111993@outlook.com.vn|
    And click button Signup
    And user fills detail: <title>, <Name>, <Password>, <Date of birth>
      | Mr. | name1 | 123456 | 1.February.2020 |
    And Select checkbox 'Sign up for our newsletter!'
    And Select checkbox 'Receive special offers from our partners!'
    And fills details: 'First name', 'Last name', 'Company', 'Address', 'Address2', 'Australia', 'State', 'Sydney', '1234', '123456'
    And Click Create Account button
    Then 'ACCOUNT CREATED!' is visible
    When uses clicks button Continued
    And  'Logged in as lan' is visible

  Scenario: Register User with existing email
   When enter Name and email
      | name1 | lanpham09111993@outlook.com.vn |
    And click button Signup
   Then error 'Email Address already exist!' is visible
   
   Scenario: delete account successful
   When user enters correct email and password
      | lanpham09111993@outlook.com.vn | 123456 |
    And clicks button Login
    And user clicks Delete Account
    Then 'ACCOUNT DELETED!' is visible
    And button continue is visble
    When user click button continue
    Then homepage is displayed
   # And  'Logged in as lan' is invisible
    
   