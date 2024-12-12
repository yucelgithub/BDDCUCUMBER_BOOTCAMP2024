@TutorialsNinjaLogin
Feature: Login functionality of Tutorialsninja Application

  @ValidCredentials
  Scenario Outline: Login with valid credentials
    Given user navigates to LoginPage
    And user enters valid email <email>
    And user enters valid password <password>
    When user clicks on Login button
    Then user is re-directed to Accountpage
    
    Examples:
    |    email                  |   password  |
    |seleniumpanda@gmail.com    |Selenium@123 |
    |seleniumpanda1@gmail.com    |Selenium@123 |
    |seleniumpanda2@gmail.com    |Selenium@123 |
    |seleniumpanda3@gmail.com    |Selenium@123 |
    |seleniumpanda4@gmail.com    |Selenium@123 |
    |seleniumpanda5@gmail.com    |Selenium@123 |
    |seleniumpanda6@gmail.com    |Selenium@123 |

  @InvalidCredentials
  Scenario: Login with invalid credentials
    Given user navigates to LoginPage
    And user enters invalid email "seleniumpanda@gmaill.com"
    And user enters invalid password "Selenium@123456"
    When user clicks on Login button
    Then user gets warning message about credentials mismatch
    
    @InvalidEmailValidPassword
    Scenario: Login with invalid email valid password
    Given user navigates to LoginPage
    And user enters invalid email "seleniumpanda@gmaill.com"
    And user enters valid password "Selenium@123"
    When user clicks on Login button
    Then user gets warning message about credentials mismatch
    
    
    @ValidEmailInvalidPassword
    Scenario: Login with valid email invalid password
    Given user navigates to LoginPage
    And user enters valid email "seleniumpanda@gmail.com"
    And user enters invalid password "Selenium@123456"
    Then user clicks on Login button
    Then user gets warning message about credentials mismatch
    
    @NoCredentials
    Scenario: login with no credential
    Given user navigates to LoginPage
    When user clicks on Login button
    Then user gets warning message about credentials mismatch
    
    
    
   
    
   