package com.myshopping.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.myshopping.base.BasePage;

public class DeletedAccountPage extends BasePage {

	public DeletedAccountPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(css="h2[class='title text-center'] b")
	WebElement title;
	
	@FindBy(css=".btn.btn-primary")
	WebElement continuedBtn;
	
	
	public void checkTitle(String expected) {
		String actual = title.getText();
		Assert.assertEquals(actual.toUpperCase(), expected);
	}
	
	public void goToContinued() {
		continuedBtn.click();
	}
	
	public void checkContinueBtnIsPresent() {
		Assert.assertTrue(isPresented(continuedBtn),"button continue Account is visible");
	}
}
