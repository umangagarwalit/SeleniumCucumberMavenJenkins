package testrunner;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		 features = "src/test/resources/Features/Login.feature",
		 glue="stepdefinitions"
		)

public class TestRunner extends AbstractTestNGCucumberTests {

	

}
