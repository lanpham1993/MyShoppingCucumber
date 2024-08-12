package com.myshopping.base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {

	private static SeleniumDriver seleniumDriver;
	private static WebDriver driver;
	public static WebDriverWait waitDriver;

	//public static Properties config = new Properties();
	//public static Properties OR = new Properties();

	//private FileInputStream fis;

	private SeleniumDriver() {
		if (Constants.browser.equals("chrome")) {
			 WebDriverManager.chromedriver().setup();
			 Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");
				options.addArguments("--disable-search-engine-choice-screen");
				options.addArguments("--disable-notifications");

				  driver = new ChromeDriver(options);

		} else if (Constants.browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		waitDriver = new WebDriverWait(driver, Duration.ofSeconds(Constants.explicit));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.implicitwait));
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setUpDriver() {
		if(seleniumDriver == null) {
			seleniumDriver =  new SeleniumDriver();
			}
	}
	
	public static void openPage(String url) {
		driver.get(url);
		waitDriver.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.fc-consent-root button[aria-label='Consent'] p.fc-button-label"))).click();
	}
	
public static void tearDown() {
		
		
		if(driver !=null) {
			
			//driver.close();
			driver.quit();
			
		}
		
		seleniumDriver = null;
		
	}
}
