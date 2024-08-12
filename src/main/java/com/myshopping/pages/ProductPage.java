package com.myshopping.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.myshopping.base.BasePage;
import com.myshopping.base.SeleniumDriver;

public class ProductPage extends BasePage{

	
	public ProductPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(css=".choose a")
	List<WebElement> lstViewProduct;
	
	@FindBy(css=".productinfo.text-center > a")
	List<WebElement> lstSingleProduct;
	
	@FindBy(css=".overlay-content > a")
	List<WebElement> lstAddToCart;
	
	@FindBy(css=".btn.btn-success.close-modal.btn-block")
	WebElement btnContinueShopping;
	
	@FindBy(css="input#search_product")
	WebElement txtSearch;
	
	@FindBy(css="button#submit_search")
	WebElement btnSearch;
	
	@FindBy(css="a[href='/product_details/5']")
	WebElement productItem;
	
	@FindBy(css="p.text-center a")
	WebElement lnkViewCart;
	
	public void clickSearch() {
		btnSearch.click();
	}
	
	public void clickContinueShopping() {
		btnContinueShopping.click();
	}
	
	public CartPage clickViewCart() {
		lnkViewCart.click();
		return new CartPage();
	}
	
	
	public void inputSearchProduct(String value) {
		sendKey(txtSearch,value);
	}
	
	public void checkProductList() {
		Assert.assertEquals(lstViewProduct.size(), 34);
	}
	
	public DetailProductPage viewItem(int item) {
		WebElement e = lstViewProduct.get(item-1);
		scrollDown(e);
		e.click();
		return new DetailProductPage();
	}
	
	public void clickAddToCart(String item) {
		WebElement e = lstSingleProduct.get(Integer.parseInt(item)-1);
		scrollDown(e);
		mouseOverAndClick(e);
		
	}

	public void checkSearchResult(String result) {
		Assert.assertEquals(lstViewProduct.size(), Integer.parseInt(result));
	}
}
