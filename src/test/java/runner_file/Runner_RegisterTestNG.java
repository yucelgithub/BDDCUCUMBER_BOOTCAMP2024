package runner_file;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions( 
		         dryRun = false,
		        features = "src/test/resources/feature_files/Register.feature",
		        glue ="com.tutorialsninja.Step_Definitions",
		        tags = "@TutorialsNinjaRegister",	     		 
                monochrome = true,
		         plugin = {"pretty","html:target/site/cucumber/cucumber.html", "json:target/cucumber1.json"}
				)





public class Runner_RegisterTestNG extends AbstractTestNGCucumberTests {

}
