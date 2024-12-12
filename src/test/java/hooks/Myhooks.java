package hooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import driver_factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class Myhooks {
	
	public WebDriver driver;
	
	@Before
	    public void setup() throws Exception {
		Properties prop = ConfigReader.initializePropertiesFile();
	    DriverFactory.initializeBrowser(prop.getProperty("browser"));
		driver = DriverFactory.getDriver();
		driver.get(prop.getProperty("url"));
		
	   }
	

	@After
	public void tearDown() {
	driver.quit();
   }
 }



