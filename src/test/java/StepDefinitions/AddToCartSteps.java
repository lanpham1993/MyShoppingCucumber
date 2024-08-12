package StepDefinitions;

import java.util.List;

import com.myshopping.base.BasePage;
import com.myshopping.pages.CartPage;
import com.myshopping.pages.DetailProductPage;
import com.myshopping.pages.ProductPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartSteps {
	ProductPage product = new ProductPage();
	DetailProductPage detail;
	CartPage cart;

	@Then("Verify {string} is visible")
	public void verify_is_visible(String result) {
		product.checkSearchResult(result);
	}

	@And("clicks button Continue Shopping")
	public void clicks_button_continue_shopping() {
		product.clickContinueShopping();
	}

	@When("clicks Cart")
	public void clicks_Cart() {
		cart = BasePage.topMenu.goToCart();
	}

	@Then("{string} products are added to Cart")
	public void products_are_added_to_cart(String quantity) {
		cart.checkQuantityProductAddToCart(quantity);
	}

	@And("check detail products are displayed correctly")
	public void check_detail_products_are_displayed_correctly(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> list = dataTable.asLists(String.class);
		for (List<String> l : list) {
			String productID = "product-";
			cart.checkProductAddToCart(productID.concat(l.get(0)), l.get(1), l.get(2), l.get(3));
		}
	}

	@When("user clicks product {string} add to cart")
	public void user_clicks_product_add_to_cart(String value) {
		product.clickAddToCart(value);
	}

	@And("clicks View Cart")
	public void clicks_view_cart() {
		cart = product.clickViewCart();
	}

	@And("edit Quanity to {string}")
	public void edit_quanity_to(String value) {
       detail.editQuantity(value);
	}

	@And("clicks button Add to Cart")
	public void clicks_button_add_to_cart() {
          detail.clickAddtoCart();
	}

	@And("Clicks View Cart on Popup")
	public void clicks_view_cart_on_popup() {
		cart = detail.clickViewCart();
	}

	@When("user clicks View product on random product")
	public void user_clicks_view_product_on_random_product() {
		detail = product.viewItem(5);
	}
}
