package com.myshopping.base;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.myshopping.pages.TopNavigation;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExtentTest test;
    public String e;
    public static TopNavigation topMenu;
    JavascriptExecutor js;
	public BasePage() {
		driver = SeleniumDriver.getDriver();
		topMenu = new TopNavigation(driver);
		js = (JavascriptExecutor) driver;
	}

	public void Click(WebElement element) {
		element.click();
		//log.debug("Clicking on an Element : " + element);
		//test.log(LogStatus.INFO, "Clicking on : " + element);
	}

	public void sendKey(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
		//log.debug("Typing in an Element : " + element + " entered value as : " + value);

		//test.log(LogStatus.INFO, "Typing in : " + element + " entered value as " + value);

	}

	public void mouseOver(WebElement element) {

		new Actions(driver).moveToElement(element).perform();
	}
	
	public void mouseOverAndClick(WebElement element) {

		new Actions(driver).moveToElement(element).click().build().perform();
	}

	public void select(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);

	}
	
	public void select(List<WebElement> element, String value) {
		System.out.println("insiDe dropdown" + element.size());
	   for(WebElement e: element) {
		 if( e.getAttribute("innerHTML").equals(value)) {
			 e.click();
		 }
		   
	   }

	}
	
	
	public void scrollDown(WebElement element) {
		new Actions(driver).scrollToElement(element).perform();
        js.executeScript("window.scrollBy(0,140)", "");
	}
	
	public static void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-400)", "");
	}
	
	public boolean isPresented(WebElement element) {
		try{
            if(element.getSize() != null) {
            	
            return true;
            }
        }
        catch(NoSuchElementException e){
            return false;
        }
		return false;
	}
	
	public void checkUrl(String Expected) {
		Assert.assertEquals(driver.getCurrentUrl().toString(), Expected);
	}
}
