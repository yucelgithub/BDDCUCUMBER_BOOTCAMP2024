package driver_factory;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	
	
    public static WebDriver driver;
	public static ChromeOptions options;

	
	public static void initializeBrowser(String Browser) {
		if (Browser.equals("chrome")) {
		    options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--start-maximized");
			options.addArguments("---incognito");
			driver = new ChromeDriver(options);
			
		}else if(Browser.equals("firefox")) {
			driver = new FirefoxDriver();
			
		}else if (Browser.equals("Edge")) {
			driver = new EdgeDriver();
		}
	}
		public static WebDriver getDriver() {
		return driver;
	}
}


