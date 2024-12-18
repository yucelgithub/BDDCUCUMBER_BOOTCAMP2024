package com.tutorialsninja.Step_Definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver_factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

	public WebDriver driver;
	
		
		
	@Given("User navigates to LoginPage")
	public void User_navigates_to_LoginPage() {	
		driver= DriverFactory.getDriver();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
			
	}
	@And("^User enters valid email (.+)$")
	public void User_enters_valid_email(String validEmail) {
		driver.findElement(By.id("input-email")).sendKeys(validEmail);
		
	}
	
	@And("^User enters valid password (.+)$")
	public void User_enters_valid_password (String validPassword) {
		driver.findElement(By.id("input-password")).sendKeys("validPassword");
	}
	@When("User clicks the Login button")
	public void User_clicks_the_Login_button() {
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		
	}
		
	@Then("User is redirected to Accountpage")
	public void User_is_redirected_to_Accountpage() {
	Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
	}
	@And("^User enters invalid email (.+)$")
	public void User_enters_invalid_email(String invalidEmail) {
		driver.findElement(By.id("input-email")).sendKeys(invalidEmail);
			
	}
	@And("^User enters invalid password (.+)$")
	public void User_enters_invalid_password (String InvalidPassword) {
		driver.findElement(By.id("input-password")).sendKeys("InvalidPassword");
	   		
	}
	
	@Then("User gets warning message about credentials mismatch")
	public void User_gets_warning_message_about_credentials_mismatch() {
		String expectedWarningMessage ="Warning: No Match for E-Mail and/or Password";
		String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
    }
	
}
	


