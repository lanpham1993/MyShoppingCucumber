package com.myshopping.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.myshopping.base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	@FindBy(css = "input[name='name']")
	WebElement signUpName;

	@FindBy(css = "input[data-qa='signup-email']")
	WebElement signUpEmail;

	@FindBy(css = "button[data-qa='signup-button']")
	WebElement signUpBtn;

	@FindBy(css = "input[data-qa='login-email']")
	WebElement loginEmail;

	@FindBy(css = "input[data-qa='login-password']")
	WebElement passwordLogin;

	@FindBy(css = "button[data-qa='login-button']")
	WebElement loginBtn;

	@FindBy(css = "input#id_gender1")
	WebElement mrRadioBtn;

	@FindBy(css = "input#id_gender2")
	WebElement mrsRadioBtn;

	@FindBy(css = "input#password")
	WebElement signUpPassword;

	@FindBy(css = "select#days")
	WebElement days;

	@FindBy(css = "select#months")
	WebElement months;

	@FindBy(css = "select#years")
	WebElement years;

	@FindBy(css = "input#newsletter")
	WebElement newsletterChkbox;

	@FindBy(css = "input#optin")
	WebElement receiveSpecialOfferChkbox;

	@FindBy(css = "input#first_name")
	WebElement firstnameTxt;

	@FindBy(css = "input#last_name")
	WebElement lastnameTxt;

	@FindBy(css = "input#company")
	WebElement companyTxt;

	@FindBy(css = "input#address1")
	WebElement adress1Txt;

	@FindBy(css = "input#address2")
	WebElement adress2Txt;

	@FindBy(css = "select#country")
	WebElement countryDropDwn;

	@FindBy(css = "input#state")
	WebElement stateTxt;

	@FindBy(css = "input#city")
	WebElement cityTxt;

	@FindBy(css = "input#zipcode")
	WebElement zipcodeTxt;

	@FindBy(css = "input#mobile_number")
	WebElement mobile_numberTxt;

	@FindBy(css = "button[data-qa='create-account']")
	WebElement createAccBtn;

	@FindBy(css = "h2[class='title text-center'] b")
	WebElement titleAccCreated;


	@FindBy(css=".btn.btn-primary")
	WebElement continuedBtn;

	@FindBy(css="input[type='hidden'] + p")
    WebElement errorEmailExistMsg;
	
	@FindBy(css="form[action='/login'] > p")
    WebElement errorLoginIncorrectMsg;
	
	
	@FindBy(css="div[class='login-form'] h2")
	WebElement loginTilte;
	
	@FindBy(css="div[class='signup-form'] h2")
	WebElement signUpTilte;
	
	
	public void enterLoginEmail(String emailLogin) {
		loginEmail.sendKeys(emailLogin);
	}
	public void enterPasswordLogin(String password) {
		passwordLogin.sendKeys(password);
	}
	public void enterName(String name) {
		signUpName.sendKeys(name);
	}

	public void enterTilte(String tilte) {
		if (tilte.equals("mr.")) {
			mrRadioBtn.click();
		} else {
			mrsRadioBtn.click();
		}
	}

	public void enterPasswordSignUp(String password) {
		signUpPassword.sendKeys(password);
	}

	public void enterDatOfBirth(String date) {
		String[] date1ist = date.split("\\.");
		System.out.println(date1ist[0].toString() + date1ist[1].toString() + date1ist[2].toString());
		select(days, date1ist[0]);
		select(months, date1ist[1]);
		select(years, date1ist[2]);
	}

	public void enterSignUpEmail(String email) {
		signUpEmail.sendKeys(email);
	}

	public void enterFirstname(String firstname) {
		firstnameTxt.sendKeys(firstname);
	}

	public void enterLastname(String lastname) {
		lastnameTxt.sendKeys(lastname);
	}

	public void enterCompany(String company) {
		companyTxt.sendKeys(company);
	}

	public void enterAdress1(String Adress) {
		adress1Txt.sendKeys(Adress);
	}

	public void enterAdress2(String Adress) {
		scroll(adress2Txt);
		adress2Txt.sendKeys(Adress);
	}

	public void enterCountry(String country) {
		scrollDown();
		select(countryDropDwn, country);
	}

	public void enterState(String state) {
		stateTxt.sendKeys(state);
	}

	public void enterCity(String city) {
		cityTxt.sendKeys(city);
	}

	public void enterZipcode(String zipcode) {
		zipcodeTxt.sendKeys(zipcode);
	}

	public void enterMobile(String phone) {
		mobile_numberTxt.sendKeys(phone);
	}

	public void clickSignUp() {
		signUpBtn.click();
	}

	public void clickLogin() {
		loginBtn.click();
	}

	public void createAccount() {
		scrollDown();
		createAccBtn.click();
	}

	public void checkedNewsleter() {
		newsletterChkbox.click();
	}

	public void checkedSpecialOffer() {
		receiveSpecialOfferChkbox.click();
	}

	public void checkTitle(String expected) {
		String title = titleAccCreated.getText();
		Assert.assertEquals(title, expected);
	}
	
	public void checkTitleLogin() {
		Assert.assertEquals(loginTilte.getText(), "Login to your account");
		Assert.assertEquals(signUpTilte.getText(), "New User Signup!");
	}

	
	public void clickContinueBtn() {
		continuedBtn.click();
	}
	
	public void checkErrorEmailExistMsg(String ActualMsg) {
		String Expect = errorEmailExistMsg.getText();
		Assert.assertEquals(ActualMsg, Expect);
	}
	
	public void checkErrorLoginIncorrectMsg(String ActualMsg) {
		String Expect = errorLoginIncorrectMsg.getText();
		Assert.assertEquals(ActualMsg, Expect);
	}
}
