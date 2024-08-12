package runner;


//import org.testng.annotations.BeforeClass;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/resources/features", glue= {"StepDefinitions"},
plugin= {"html:target/cucumber-html-report/cucumber.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
		},
monochrome=true)
public class RunCuke extends AbstractTestNGCucumberTests {
	 
}
