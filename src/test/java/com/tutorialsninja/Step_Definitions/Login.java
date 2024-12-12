package com.tutorialsninja.Step_Definitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver_factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Login {

	public WebDriver driver;
	
	
	 @Given("user navigates to LoginPage")
	 public void user_navigates_to_LoginPage() {
		 driver=DriverFactory.getDriver();
		 driver.findElement(By.linkText("My Account")).click();
		 driver.findElement(By.linkText("Login")).click();
	 }
    @And("^user enters valid email (.+)$")
    public void user_enters_valid_email (String emailText){
    	driver.findElement(By.id("input-email")).sendKeys(emailText);
    }
    
    @And("^user enters valid password (.+)$")
    public void user_enters_valid_password (String validPassword){
    	driver.findElement(By.id("input-password")).sendKeys(validPassword);
    	
    }
	@When("user clicks on Login button")
	public void user_clicks_on_Login_button() {
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
     }
	@Then("user is re-directed to Accountpage")
	public void user_is_redirected_to_accountPage(){
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
	}
	@And("^user enters invalid email (.+)$")
	public void user_enters_invalid_email (String InvalidEmailText) {
		driver.findElement(By.id("input-password")).sendKeys(InvalidEmailText);
		
	}
	@And("^user enters invalid password (.+$)")
	public void user_enters_invalid_password (String InvalidPasswordText) {
		driver.findElement(By.id("input-password")).sendKeys(InvalidPasswordText);
	}	
	@Then("user gets warning message about credentials mismatch")
	public void user_gets_warning_message_about_credentials_mismatch() {
		String expectedWarningMessage = "Warning: No MAtch for E-Mail Adress and/or Password.";
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	}
	
	
}
