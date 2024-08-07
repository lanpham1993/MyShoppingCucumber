package com.myshopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;


public class TopNavigation {

	WebDriver driver;
	public TopNavigation(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(css="header[id='header'] li:nth-child(1) a:nth-child(1)")
	WebElement home;
	
	@FindBy(css="a[href='/products']")
	WebElement product;
	
	@FindBy(css="a[href='/view_cart']")
	WebElement cart;
	
	@FindBy(css="a[href='/login']")
	WebElement signUp_signIn;
	
	@FindBy(css="a[href='/contact_us']")
	WebElement contactUs;
	
	@FindBy(css="a[href='/delete_account']")
	WebElement deleteAccount;
	
	@FindBy(css="a[href='/logout']")
	WebElement logout;
	
	@FindBy(css = "li:nth-child(10) a:last-child")
	WebElement loggedNameTxt;
	
	public HomePage goToHome() {
		home.click();
		return new HomePage();
	}
	
	public ProductPage goToProduct() {
		product.click();
		return new ProductPage();
	}
	
	public CartPage goToCart() {
		cart.click();
		return new CartPage();
	}
	public LoginPage goToSignIn_signUp() {
		signUp_signIn.click();
		return new LoginPage();
	}
	
	public LoginPage goToLogout() {
		logout.click();
		return new LoginPage();
	}
	
	public ContactUsPage goToContactUs() {
		contactUs.click();
		return new ContactUsPage();
		
	}
	
	public DeletedAccountPage goToDeleteAccount() {
		deleteAccount.click();
		return new DeletedAccountPage();
	}
/*	
	public void checkBtnDeleteAccountIsPresented() {
		Assert.assertTrue(isPresented(deleteAccount),"button delete Account is visible");
	}


	public void checkBtnLogoutIsPresented() {
		Assert.assertTrue(isPresented(logout),"button Logout is visible");	
	}
	
	public void checkBtnLoginIsPresented() {
		Assert.assertTrue(isPresented(signUp_signIn),"button delete Account is visible");
	}
	
	public void checkBtnDeleteAccountIsNOTPresented() {
		Assert.assertFalse(isPresented(deleteAccount),"button delete Account is invisible");
	}
	
	public void checkBtnLogoutIsNOTPresented() {
		Assert.assertFalse(isPresented(logout),"button Logout is invisible");
	}
	
	public void checkBtnLoginIsNOTPresented() {
		Assert.assertFalse(isPresented(signUp_signIn),"button delete Account is invisible");
	}
	
	public void checkLoggedNameIsNOTPresented() {
		Assert.assertFalse(isPresented(loggedNameTxt),"Logged as username is invisible");
	}*/
	
	public void checkLoggedName(String expected) {
		String actual = loggedNameTxt.getText();
		Assert.assertEquals(actual, expected);
	}

}
