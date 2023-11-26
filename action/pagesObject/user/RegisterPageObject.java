package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.RegisterPageUI;

public class RegisterPageObject extends BasePages{
	public RegisterPageObject(WebDriver driver) {
		super(driver);
	}
	
	@Step("Click on 'Register' button")
	public void clickOnRegisterButton() {
		waitForElementClickable(RegisterPageUI.REGISTER_BUTTON);
		clickOnElement(RegisterPageUI.REGISTER_BUTTON);
	}
	
	@Step("Get Register successfully message")
	public String getRegisterSuccessfullyMessage() {
		waitForElementVisibility(RegisterPageUI.REGISTER_SUCCESSFULLY_MESSAGE);
		return getTextElement(RegisterPageUI.REGISTER_SUCCESSFULLY_MESSAGE); 
	}

	@Step("Click on 'Register' link")
	public void clickOnRegisterLink() {
		waitForElementClickable(RegisterPageUI.REGISTER_BUTTON);
		clickOnElement(RegisterPageUI.REGISTER_BUTTON);
	}
	
	@Step("Get invalid error message")
	public String getInvalidErrorMessage() {
		waitForElementVisibility(RegisterPageUI.INVALID_ERROR_MESSAGE);
		return getTextElement(RegisterPageUI.INVALID_ERROR_MESSAGE); 
	}

	@Step("Get First Name error message")
	public String getFirstNameErrorMessage() {
		waitForElementVisibility(RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getTextElement(RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}
	
	@Step("Get Last Name error message")
	public String getLastNameErrorMessage() {
		waitForElementVisibility(RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getTextElement(RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}
	
	@Step("Get Email error message")
	public String getEmailErrorMessage() {
		waitForElementVisibility(RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getTextElement(RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	@Step("Get Password error error message")
	public String getPasswordErrorMessage() {
		waitForElementVisibility(RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getTextElement(RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}
	
	@Step("Get Confirm Password error message")
	public String getConfirmPasswordErrorMessage() {
		waitForElementVisibility(RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getTextElement(RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	@Step("Input to 'First Name' textbox with value is {0}")
	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisibility(RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	
	@Step("Input to 'Last Name' textbox with value is {0}")
	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisibility(RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	
	@Step("Input to 'Email' textbox with value is {0}")
	public void inputToEmailTextbox(String email) {
		waitForElementVisibility(RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(RegisterPageUI.EMAIL_TEXTBOX, email);
	}
	
	@Step("Input to 'Password' textbox with value is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisibility(RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(RegisterPageUI.PASSWORD_TEXTBOX, password);
	}
	
	@Step("Input to 'Confirm Password' textbox with value is {0}")
	public void inputToConfirmPasswordTextbox(String password) {
		waitForElementVisibility(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}
}
