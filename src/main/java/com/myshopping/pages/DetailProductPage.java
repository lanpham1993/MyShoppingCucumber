package com.myshopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.myshopping.base.BasePage;

public class DetailProductPage extends BasePage{
	
	public DetailProductPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(css=".product-information h2")
	WebElement lblProductName;
	
	@FindBy(css="div.product-information p:nth-child(3)")
	WebElement lblCategory;
	
	@FindBy(css="div.product-information > span")
	WebElement lblPrice;
	
	@FindBy(css="div.product-information p:nth-child(6)")
	WebElement lblAvailability;
	
	@FindBy(css="div.product-information p:nth-child(7)")
	WebElement lblCondition;
	
	@FindBy(css="div.product-information p:last-child")
	WebElement lblBrand;
	
	
	public void checkDetailProduct(String productName, String category, String price, String availability, String condition, String brand) {
		Assert.assertEquals(lblProductName.getText(), productName);
		Assert.assertEquals(lblCategory.getText(), category);
		Assert.assertEquals(lblPrice.getText(), price);
		Assert.assertEquals(lblAvailability.getText(), availability);
		Assert.assertEquals(lblCondition.getText(), condition);
		Assert.assertEquals(lblBrand.getText(), brand);
	}
	
}
