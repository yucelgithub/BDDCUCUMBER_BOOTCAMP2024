package runner_file;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions( 
		         dryRun = false,
		         features = "src/test/resources/feature_files/login.feature",
		         glue = {"com.tutorialsninja.Step_Definitions","hooks"},
		         tags = "(@TutorialsNinjaLogin and @TutorialsNinjaRegister and @TutorialsNinjaSearchProduct)",	     		 
		         monochrome = true,
		         plugin = {"pretty","html:target/site/cucumber/cucumber.html", "json:target/cucumber1.json"}
				)





public class Runner_TestNG extends AbstractTestNGCucumberTests {

}
