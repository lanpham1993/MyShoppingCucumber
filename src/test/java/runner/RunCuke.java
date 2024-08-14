package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
//import org.testng.annotations.BeforeClass;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = { "StepDefinitions" }, plugin = {
		"html:target/cucumber-html-report/cucumber.html", "pretty", "json:target/cucumber-reports/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true)
public class RunCuke extends AbstractTestNGCucumberTests {

}
