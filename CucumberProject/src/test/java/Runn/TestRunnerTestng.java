package Runn;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/java/Features"},
		glue={"StepDefinitions"},
		dryRun =false,
		monochrome=true)
		//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestRunnerTestng extends AbstractTestNGCucumberTests {

}
