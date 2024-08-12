package com.myshopping.pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.myshopping.base.BasePage;

public class CartPage extends BasePage{

	public CartPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(css="tbody tr")
	List<WebElement> tblProduct;
	
	@FindBy(css="tbody td[class='cart_description'] a")
	List<WebElement> lstproductDesc;
	
	@FindBy(css="tbody td.cart_price p")
	List<WebElement> lstProductPrice;
	
	@FindBy(css="tbody td.cart_quantity button")
	List<WebElement> lstProductQuantity;
	
	@FindBy(css="tbody td.cart_total p")
	List<WebElement> lstProductTotal;
	

	
	
	public void checkProductAddToCart(String item,String price, String quantity, String total) {
	for(int i = 0; i< tblProduct.size();i++) {
			if(tblProduct.get(i).getAttribute("id").equals(item)) {
				Assert.assertEquals(lstProductPrice.get(i).getText(), price);
				Assert.assertEquals(lstProductQuantity.get(i).getText(), quantity);
				Assert.assertEquals(lstProductTotal.get(i).getText(), total);
				//System.out.println("*****" +lstProductPrice.get(i).getText()+ lstProductQuantity.get(i).getText() +lstProductTotal.get(i).getText());
				break;
			}
		}
	}
	
public void checkQuantityProductAddToCart(String quantity) {
		Assert.assertEquals(tblProduct.size(), Integer.parseInt(quantity));
		
	}

}
