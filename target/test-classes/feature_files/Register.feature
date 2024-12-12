@TutorialsNinjaRegister
Feature: Register functionality of Tutorialsninja Application
  

  @ManDatoryFields
  Scenario: Regsiter with mandatory fields
    Given user navigates to RegisterPage
    And user enters below mandatory fields
    |firstname           |  Selenium     |
    |lastname            |Panda          |
    |telephone           |9876543210     |
    |password            |Selenium@123   |
    |confirmpassword     | Selenium@123  |
    And user select privacy policy checkbox
    When user clicks on continue button
    Then user is re-directed to AccountSuccessPage
    
    @AllFields
    Scenario Outline: Register with all fields
    Given user navigates to RegisterPage
    And user enters firtsname <firstname>
    And user enters lastname <lastname>
    And user enters telephone <telephone>
    And user enters password <password>
    And user enter confirmpassword <confirmpassword>
    And user selects Yes for subscribe newsletter radiobutton
    And user select privacy policy checkbox
    When user clicks on continue button
    Then user is re-directed to AccountPage
    Examples:
    |firstname       |lastname       |telephone         | password        | confirmpassword | 
    |Selenium        | Panda         | 9876543          |   Selenium@123  | Selenium@123    |
    |Selenium1       | Panda         | 9876543          |   Selenium@123  | Selenium@123    |
    |Selenium2       | Panda         | 9876543          |   Selenium@123  | Selenium@123    |
    |Selenium3       | Panda         | 9876543          |   Selenium@123  | Selenium@123    |
    |Selenium4       | Panda         | 9876543          |   Selenium@123  | Selenium@123    |
    |Selenium5       | Panda         | 9876543          |   Selenium@123  | Selenium@123    |
    |Selenium6       | Panda         | 9876543          |   Selenium@123  | Selenium@123    |
    
   
    
    @DuplicateEmail
    Scenario: Register with wexeisting email
    Given uswer navigates to RegisterPage
    And user enters below mandatory fields withn existing email
    |firstname           |  Selenium               |
    |lastname            |Panda                    |
    |email               |seleniumpanda@gmail.com  |
    |telephone           |9876543210               |
    |password            |Selenium@123             |
    |confirmpassword     | Selenium@123            |
    And user select privacy policy checkbox
    When user clicks on continue button
    Then user gets warning message of duplicate email
    
    @IncorrectConfirmPassword
    Scenario: Register with incorrect confirm password
    Given user navigates to registerPage
    And user enters below mandatory fields with incorrect ConfirmPassword
    |firstname           |  Selenium     |
    |lastname            |Panda          |
    |telephone           |9876543210     |
    |password            |Selenium@123   |
    |confirmpassword     | Selenium@123456  | 
    And user select privacy policy
    When user clicks on continue button
    Then user gets warning message of incorrect confirm password   
    
    @NoFields
    Scenario: Register with no fields
    Given user navigates to RegisterPage
    When user clicks on continue button
    Then user gets warning message for every mandatory field
    
    
     
 