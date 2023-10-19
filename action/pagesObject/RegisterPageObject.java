package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import pagesUI.user.RegisterPageUI;

public class RegisterPageObject extends BasePages{
	private WebDriver driver; 
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickOnElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	
	public String getRegisterSuccessfullyMessage() {
		waitForElementVisibility(driver, RegisterPageUI.REGISTER_SUCCESSFULLY_MESSAGE);
		return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESSFULLY_MESSAGE); 
	}

	public void clickOnRegisterLink() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickOnElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	
	public String getInvalidErrorMessageText() {
		waitForElementVisibility(driver, RegisterPageUI.INVALID_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.INVALID_ERROR_MESSAGE); 
	}

	public String getFirstNameErrorMessage() {
		waitForElementVisibility(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}
	
	public String getLastNameErrorMessage() {
		waitForElementVisibility(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}
	
	public String getEmailErrorMessage() {
		waitForElementVisibility(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	public String getPasswordErrorMessage() {
		waitForElementVisibility(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}
	
	public String getConfirmPasswordErrorMessage() {
		waitForElementVisibility(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisibility(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	
	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisibility(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	
	public void inputToEmailTextbox(String email) {
		waitForElementVisibility(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementVisibility(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public void inputToConfirmPasswordTextbox(String password) {
		waitForElementVisibility(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}
}
