package StepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.myshopping.base.SeleniumDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

	public WebDriver driver;
	
	@Before
	public void setUp() {
		SeleniumDriver.setUpDriver();
	}
	
	@After
	public void tearDown(Scenario scenario) {
		//capture screenshot
		
		if(scenario.isFailed()) {
			driver = SeleniumDriver.getDriver();
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot");
		}
		SeleniumDriver.tearDown();
	}
	
}
