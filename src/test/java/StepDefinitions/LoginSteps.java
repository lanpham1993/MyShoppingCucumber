package StepDefinitions;

import java.util.List;

import com.myshopping.base.BasePage;
import com.myshopping.pages.DeletedAccountPage;
import com.myshopping.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	LoginPage login = new LoginPage();
	DeletedAccountPage deleteAccount;
	
	@When("user enters correct email and password")
	public void user_enters_correct_email_and_password(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> list = dataTable.asLists(String.class);
		for (List<String> li:list) {
			login.enterLoginEmail(li.get(0));
			login.enterPasswordLogin(li.get(1));
		}
	}

	@And("clicks button Login")
	public void clicks_button_login() {
	    login.clickLogin();
	}

	@Then("homepage is displayed")
	public void homepage_is_displayed() {
	   login.checkUrl("https://www.automationexercise.com/");
	}

	@When("user enters incorrect email and password")
	public void user_enters_incorrect_email_and_password(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> list = dataTable.asLists(String.class);
		for (List<String> li:list) {
			login.enterLoginEmail(li.get(0));
			login.enterPasswordLogin(li.get(1));
		}
	}

	@Then("verify error {string} is visible")
	public void verify_error_is_visible(String ActualMsg) {
	    login.checkErrorLoginIncorrectMsg(ActualMsg);
	}

	@When("user clicks logout")
	public void user_clicks_logout() {
	  login = BasePage.topMenu.goToLogout();
	}

	@Then("user is navigated to login page")
	public void user_is_navigated_to_login_page() {
	    login.checkUrl("https://www.automationexercise.com/login");
	}


}
