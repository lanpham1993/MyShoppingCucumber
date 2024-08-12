package StepDefinitions;


import com.myshopping.base.BasePage;
import com.myshopping.pages.CartPage;
import com.myshopping.pages.DetailProductPage;
import com.myshopping.pages.ProductPage;

import cucumber.api.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class ProductSteps {

	ProductPage product;
	DetailProductPage detail;
	CartPage cart;
	

	@When("user clicks Product button")
	public void user_clicks_product_button() {
		product = BasePage.topMenu.goToProduct();
	}

	@Then("user is navigated to ALL PRODUCT PAGE")
	public void user_is_navigated_to_all_product_page() {
		product.checkUrl("https://www.automationexercise.com/products");
	}

	@And("list product is visible")
	public void list_product_is_visible() {
		product.checkProductList();
	}

	
	@Then("{string} is displayed")
	public void is_displayed(String url) {
		product.checkUrl(url);
	}


	@And("detail is visible: {string}, {string}, {string}, {string}, {string}, {string}")
	public void detail_is_visible(String productName, String category, String price, String availability,
			String condition, String brand) {
		detail.checkDetailProduct(productName, category, price, availability, condition, brand);
	}

	@When("user enters {string} in search textbox")
	public void user_enters_in_search_textbox(String value) {
		product.inputSearchProduct(value);
	}

	@And("clicks button Search")
	public void clicks_button_search() {
		product.clickSearch();
	}


	@When("user clicks View product on {int} product")
	public void user_clicks_view_product_on_product(Integer productItem) {
		detail = product.viewItem(productItem);
	}

	@And("detail is visible: {string},{string},{string},{string},{string},{string}")
	public void detail_is_visible_name_product_category_women_dress_rs_availability_in_stock_condition_new_brand_madame(String productName, String category, String price, String availability,
			String condition, String brand) {
		detail.checkDetailProduct(productName, category, price, availability, condition, brand);
	}

	

}
