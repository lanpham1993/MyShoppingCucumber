package com.myshopping.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.myshopping.base.BasePage;

public class menuCategoryBrand extends BasePage{

	public menuCategoryBrand() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Women']")
	WebElement women;
	
	@FindAll(@FindBy(how = How.CSS, using = "div#Women a"))
	List<WebElement> womenList;
	
	@FindBy (css ="div#Women a[href='/category_products/1']")
	WebElement categoryDress;
	
	@FindBy (css ="div#Women a[href='/category_products/2']")
	WebElement categoryTops;
	
	@FindBy (css ="div#Women a[href='/category_products/3']")
	WebElement categorySarre;
	
	public void goToWomen_dress() throws InterruptedException {
		women.click();
		//select(womenList, "Dress ");
		categoryDress.click();
	}
	
	public void goToWomen_tops() {
		women.click();
		 categoryTops.click();	
		}
	
	public void goToWomen_saree() {
		women.click();
		  categorySarre.click();	
		}
}
