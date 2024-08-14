package com.myshopping.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.myshopping.base.BasePage;

public class CheckoutPage extends BasePage {

	public CheckoutPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	@FindBy(css = ".text-center a[href='/login']")
	WebElement lnkBtnResgister_login;

	public LoginPage goToResgister_login() {
		lnkBtnResgister_login.click();
		return new LoginPage();
	}

}
