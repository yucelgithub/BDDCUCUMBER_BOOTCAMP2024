@TutorialsNinjaLogin
Feature: Login functionality of TutorialsNinja


@ValidCredentials
Scenario Outline: Login with valid credentials
Given User navigates to LoginPage
And User enters valid email <email>
And User enters valid password <password>
When User clicks the Login button
Then User is redirected to Accountpage
Examples:
|  email                      | password           |    
|yucelselenium@gmail.com      | yucelselenium@123  |
|yucelselenium1@gmail.com     | yucelselenium@123   |
|yucelselenium2@gmail.com     | yucelselenium@123   |
|yucelselenium3@gmail.com     | yucelselenium@123  |
|yucelselenium4@gmail.com     | yucelselenium@123  |


@InvalidCredentials
Scenario: Login with invalid credentials
Given User navigates to LoginPage
And User enters invalid email "yucelselenium@gamill.com"
And User enters invalid password "yucelselenium@12345"
When User clicks the Login button
Then User gets warning message about credentials mismatch

@InvalidEmailValidPassword
Scenario: Login with invalid email valid password
Given User navigates to LoginPage
And User enters invalid email "yucelselenium@gmaill.com"
And User enters invalid password "yucelselenium@12345"
When User clicks the Login button
Then User gets warning message about credentials mismatch



@ValidEmailInvalidPassword
Scenario: Login with valid email invalid password
Given User navigates to LoginPage
And User enters invalid email "yucelselenium@gmaill.com"
And User enters invalid password "selenium@12345"
When User clicks the Login button
Then User gets warning message about credentials mismatch


@NoCredentials
Scenario: Login with no credentials
Given User navigates to LoginPage
When User clicks the Login button
Then User gets warning message about credentials mismatch



