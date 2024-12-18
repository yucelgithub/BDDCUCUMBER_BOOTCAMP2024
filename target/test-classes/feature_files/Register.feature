@TutorialsNinjaRegister
Feature: Register functionality of Tutorialsninja Application
  

@MandatoryFields
Scenario: Register with mandatory fields
Given User navigates to RegisterPage
And User enters below mandatory fields
|firstname           |yucel                 |
|lastname            |kahraman              |
|telephone           |123456789             |
|password            |yucelselenium@123     |
|confirmpassword     |yucelselenium@123     |
And User selects privacy policy checkbox
When User clicks on continue button
Then User is redirected to AccountSuccessPage
    
@AllFields
Scenario Outline: Register with all fields
Given User navigates to RegisterPage
And User enters firstname <firstname>
And User enters lastname <lastname>
And User enters telephone <telephone>
And User enters password <password>
And User enter confirmpassword <confirmpassword>

And User selects Yes for subscribe newsletter radiobutton
And User selects privacy policy checkbox
When User clicks on continue button
Then User is redirected to AccountSuccessPage
    
Examples:
|firstname    | lastname        | telephone  | password          | confirmpasword     |
|yucel        | kahraman				| 123456     | yucelselenium@123 | yuucelselenium@123 |
|yucel1       | kahraman        | 123456     | yucelselenium@123 | yucelselenium@123  |
|yucel2       | kahraman        | 123456     | yucelselenium@123 | yucelselwnium@123  |
|yucel3       | kahraman        | 123456     | yucelselenium@123 | yucelselenium@123  |
|yucel4       | kahraman        | 123456     | yucelselenium@123 | yucelselenium@123  |


@DuplicateEmail
Scenario: Register with existing email
Given User navigates to RegisterPage
And User enters below mandatory fields with existing email
|firstname           | yucel                       |
|lastname            |kahraman                     |
|email               |yucelselenium@gmail.com      |
|telephone           |123456789                    |
|password            |yucelselenium@123            |
|confirmpassword     |yucelselenium@123            |
And User selects privacy policy checkbox
When User clicks on continue button
Then User gets warning message of duplicate email
    
@IncorrectConfirmPassword
Scenario: Register with incorrect confirm password
Given User navigates to RegisterPage
And User enters below mandatory fields with incorrect ConfirmPassword
|firstname           |  yucel                 |
|lastname            |kahraman                |
|telephone           |1234656789              |
|password            |yucelselenium@123       |
|confirmpassword     |yucelselenium@123456    | 
And User selects privacy policy checkbox
When User clicks on continue button
Then User gets warning message of incorrect confirm password   
    
@NoFields
Scenario: Register with no fields
Given User navigates to RegisterPage
When User clicks on continue button
Then User gets warning message for every mandatory field
    
    
     
 