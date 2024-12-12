@TutorialsNinjaSearchProduct
Feature: Search product functionality of the Tutorialsninja application

  @ValidProduct
  Scenario: Search with valid product
    Given user opens the application
    When user enters valid product "HP"
    And user clicks on search button
    Then user gets valid product info display in the ProductPage
    
  @InvalidProduct
  Scenario: Search with invalid product
    Given user opens the application
    When user enters invalid product "DELL"
    And user clicks on search button
    Then user gets warning message no product found in the ProductPackage
    
    @NoProduct
    Scenario: Search with no product
    Given user opens the application
    And user clicks on search button
    Then user gets warning message no product found in the ProductPackage
     
  