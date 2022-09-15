package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
//		 features = "./src/main/java/Features/mmt.feature",
features = "./src/main/java/Features/Email.feature", 
//		tags = {"@Testing" },
		glue = { "StepDefination" }, 
		plugin = { "json:target/cucumber.html" },
		format = { "html:test-output" },
		monochrome = true

)

public class TestRunner {

}
