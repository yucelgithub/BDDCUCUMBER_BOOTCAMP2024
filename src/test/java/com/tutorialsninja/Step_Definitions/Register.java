package com.tutorialsninja.Step_Definitions;

import java.util.Map;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Util;



public class Register {
	
	public WebDriver driver;
	
	@Before
	public void openApplication() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo");		
        driver.findElement(By.linkText("My Account")).click();
        
			
		}
	 @Given("User navigates to RegisterPage")
	 public void User_navigates_to_RegisterPage() {
		 driver.findElement(By.linkText("Register")).click();
		 
	 }
	 @And("User enters below mandatory fields")
	 public void User_enters_below_mandatory_fields(DataTable datatable) {
		 
		Map<String,String> dataMap = datatable.asMap(String.class,String.class);
		
		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(Util.EmailWithDateTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
		
			 
	 }
	 @And("User selects privacy policy checkbox")
	 public void User_selects_privacy_policy_checkbox() {
		 driver.findElement(By.name("agree")).click();
		 
	 }
	 @When("User clicks on continue button")
	 public void User_clicks_on_continue_button() {
		 driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	 }
	 @Then("User is redirected to AccountSuccessPage")
	 public void User_is_redirected_to_AccountSuccessPage() {
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Congratulations! Your new account has been successfully created!']")).isDisplayed());
		 
	 }
	 @And("^User enters firstname (.+)$")
	 public void User_enters_firstname (String firstName) {
		 driver.findElement(By.id("input-firstname")).sendKeys(firstName);
		 
	 }
	 @And("^User enters lastname (.+)$")
	 public void User_enters_lastname (String lastName) {
		 driver.findElement(By.id("input-lastname")).sendKeys(lastName);
		 
	 }
	 @And("^User enters telephone (.+)$")
	 public void User_enters_telephone (String phoneNumber) {
		 driver.findElement(By.id("input-telephone")).sendKeys(phoneNumber);
		 
	 }
	 @And("^User enters password (.+)$")
	 public void User_enters_password(String Passwordtext) {
		 driver.findElement(By.id("input-password")).sendKeys(Passwordtext);
		 
	 }
	  @And("^User enter confirmpassword (.+)$")
	  public void User_enter_confirmpassword(String confirmPasswordText) {
		  driver.findElement(By.id("input-confirm")).sendKeys(confirmPasswordText);	  
	
	  }
	  @And("User selects Yes for subscribe newsletter radiobutton")
	  public void User_selects_Yes_for_subscribe_newsletter_radiobutton() {
		  driver.findElement(By.xpath("//input[@name = 'newsletter' and @value = '1']")).click();
	  }
	  @And("User enters below mandatory fields with existing email")
		 public void User_enters_below_mandatory_fields_with_existing_email(DataTable datatable) {
			 
			Map<String,String> dataMap = datatable.asMap(String.class,String.class);
			
			driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
			driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
			driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
			driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
			driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
			driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
			
	  }		
	  @And("User enters below mandatory fields with incorrect ConfirmPassword")
		 public void User_enters_below_mandatory_fields_with_incorrect_ConfirmPassword(DataTable datatable) {
			 
			Map<String,String> dataMap = datatable.asMap(String.class,String.class);
			
			driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
			driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
			driver.findElement(By.id("input-email")).sendKeys(Util.EmailWithDateTimeStamp());
			driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
			driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
			driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
	  
	}
	 @Then("User gets warning message of duplicate email")
	 public void User_gets_warning_message_of_duplicate_email() {
		 String expectedWarningMessage ="Warning: E-Mail Adress is already registered!";
		 String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		 Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	
		 
	 }
	 @Then("User gets warning message of incorrect confirm password")
	 public void User_gets_warning_message_of_incorrect_confirm_password() {
	  Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'Password confirmation does not match password!']")).isDisplayed());
		 
	 }
	 
	    @Then("User gets warning message for every mandatory field")
	    public void User_gets_warning_message_for_every_mandatory_field() {
	    Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert dismissible')]")).getText().contains("Warning:You must agree to the Privacy Policy!"));
	    Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText().contains("First Name must be between 1 abd 32 characters!"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText().contains("Last Name must be between 1 abd 32 characters!"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText().contains("E-Mail Address does not appear to ber valid!"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText().contains("Telephone must be between 3 abd 32 characters!"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText().contains("Password be between 4 abd 20 characters!"));	    
	    }
@After
public void tearDown() {
	driver.quit();
	
    }
	    
}


