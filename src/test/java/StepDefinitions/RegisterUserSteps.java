package StepDefinitions;

import java.util.List;

import com.myshopping.base.BasePage;
import com.myshopping.base.SeleniumDriver;
import com.myshopping.pages.LoginPage;
import com.myshopping.pages.TopNavigation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterUserSteps {

	LoginPage login = new LoginPage();
	
	@Given("user navigates to https:\\/\\/www.automationexercise.com\\/")
	public void user_navigates_to_https_www_automationexercise_com() {
		SeleniumDriver.openPage("https://www.automationexercise.com/");
	}

	@When("user clicks on SignUp\\/Login button")
	public void user_clicks_on_sign_up_login_button() {
		BasePage.topMenu.goToSignIn_signUp();
		login.checkTitleLogin();
		
	}

	@When("enter Name and email")
	public void enter_name_and_email(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> list = dataTable.asLists(String.class);
		for (List<String> li:list) {
			login.enterName(li.get(0));
			login.enterSignUpEmail(li.get(1));
		}
	}

	@And("click button Signup")
	public void click_button_signup() {
		login.clickSignUp();
	}

	@And("user fills detail: <title>, <Name>, <Password>, <Date of birth>")
	public void user_fills_detail_title_name_password_date_of_birth(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		List<List<String>> list = dataTable.asLists(String.class);
		for (List<String> li:list) {
			login.enterTilte(li.get(0));
			login.enterPasswordSignUp(li.get(2));
			login.enterDatOfBirth(li.get(3));
		}
		
	}

	@And("Click Create Account button")
	public void click_create_account_button() {
		login.createAccount();
	}

	@And("Select checkbox {string}")
	public void select_checkbox(String nameChkBox) {
		if (nameChkBox.contains("Sign up for our newsletter!")) {
			login.checkedNewsleter();
		} else if (nameChkBox.contains("Receive special offers from our partners!")) {
			login.checkedSpecialOffer();
		}
	}

	@And("fills details: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void fills_details(String firstname, String lastname, String company, String adress1, String adress2,
			String country, String state, String city, String zipcode, String phoneNumber) {
		login.enterFirstname(firstname);
		login.enterLastname(lastname);
		login.enterCompany(company);
		login.enterAdress1(adress1);
		login.enterAdress2(adress2);
		login.enterCountry(country);
		login.enterState(state);
		login.enterCity(city);
		login.enterZipcode(zipcode);
		login.enterMobile(phoneNumber);
	}


	@When("uses clicks button Continued")
	public void uses_clicks_button_continued() {
	    login.clickContinueBtn();
	}


	@Then("{string} is visible")
	public void is_visible(String Actual) {
	    if(Actual.equals("Account Created!")) {
	    	login.checkTitle(Actual);
	    } else if(Actual.equals("Logged in as name1")) {
	    	BasePage.topMenu.checkLoggedName(Actual);
	    }
	}

	@Then("error {string} is visible")
	public void error_is_visible(String ErrorMsg) {
	    login.checkErrorEmailExistMsg(ErrorMsg);
	}
}
