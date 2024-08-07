package StepDefinitions;

import com.myshopping.base.BasePage;
import com.myshopping.pages.DeletedAccountPage;
import com.myshopping.pages.TopNavigation;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteAccountSteps {
	DeletedAccountPage deleteAccount;
	
	@When("user clicks Delete Account")
	public void user_clicks_delete_account() {
	   deleteAccount= BasePage.topMenu.goToDeleteAccount();
	}

	@Then("button continue is visble")
	public void button_continue_is_visble() {
	  deleteAccount.checkContinueBtnIsPresent();
	}

	@When("user click button continue")
	public void user_click_button_continue() {
		 deleteAccount.goToContinued();
	}

	

}
