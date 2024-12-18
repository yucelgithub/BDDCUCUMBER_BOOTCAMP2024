package com.tutorialsninja.Step_Definitions;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class SearchProduct {

	
	public WebDriver driver;
	
	
	@Before
	public void openApplication() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
				
	}

	@Given("user opens the application")
	public void user_opens_the_application() {
		driver.get("https://tutorialsninja.com/demo");	
		
	}
	@When("user enters valid product {string}")
	public void user_enters_valid_product (String productName) {
		driver.findElement(By.cssSelector("input.form-control.input-lg")).sendKeys(productName);
		
	}
    @And("user clicks on search button")
    public void user_clicks_on_search_button() {
    	driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
    }
    @Then("user gets valid product info display in the ProductPage")
    public void user_gets_valid_product_info_display_in_the_ProductPage() {
     	Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
    	
    	
    }
    @When("user enters invalid product {string}")
    public void user_enters_invalid_product(String InvaLidProductName){
    	driver.findElement(By.cssSelector("input.form-control.input-lg")).sendKeys(InvaLidProductName);
    	
    	
    }
    @Then("user gets warning message no product found in the ProductPackage")
    public void user_gets_warning_message_no_product_found_in_the_ProductPackage() {
    	Assert.assertTrue(driver.findElement(By.xpath("//p[text()= 'There is no product that matches the search criteria.']")).isDisplayed());
    }
    
    @After
    public void tearDown() {
    	driver.quit();
    }
	
	
}
