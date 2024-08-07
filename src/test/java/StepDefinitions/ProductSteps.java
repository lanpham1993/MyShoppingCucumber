package StepDefinitions;

import com.myshopping.base.BasePage;
import com.myshopping.pages.DetailProductPage;
import com.myshopping.pages.ProductPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {
	
	ProductPage product;
	DetailProductPage detail ;

	@When("user clicks Product button")
	public void user_clicks_product_button() {
		product =  BasePage.topMenu.goToProduct();
	}

	@Then("user is navigated to ALL PRODUCT PAGE")
	public void user_is_navigated_to_all_product_page() {
	 product.checkUrl("https://www.automationexercise.com/products");
	}

	@And("list product is visible")
	public void list_product_is_visible() {
	    product.checkProductList();
	}

	@When("user clicks on random product")
	public void user_clicks_on_random_product() {
	detail =	product.selectItem(2);
	}

	@Then("product detail is displayed")
	public void product_detail_is_displayed() {
		product.checkUrl("https://www.automationexercise.com/product_details/3");
	}
	
	@And("detail is visible: {string}, {string}, {string}, {string}, {string}, {string}")
	public void detail_is_visible(String productName, String category, String price, String availability, String condition, String brand) {
	    detail.checkDetailProduct(productName, category, price, availability, condition, brand);
	}

}
