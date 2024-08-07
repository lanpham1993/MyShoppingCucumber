package com.myshopping.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.myshopping.base.BasePage;

public class ProductPage extends BasePage{

	
	public ProductPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(css=".choose a")
	List<WebElement> productList;
	
	@FindBy(css="input#search")
	WebElement searchTxt;
	
	@FindBy(css="button#submit_search")
	WebElement searchBtn;
	
	@FindBy(css="a[href='/product_details/5']")
	WebElement productItem;
	
	public void clickSearchBtn() {
		searchBtn.click();
	}
	
	public void search(String value) {
		sendKey(searchTxt,value);
	}
	
	public void checkProductList() {
		Assert.assertEquals(productList.size(), 34);
	}
	
	public DetailProductPage selectItem(int item) {
		productList.get(item).click();
		return new DetailProductPage();
	}
}
