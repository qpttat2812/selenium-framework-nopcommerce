package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.RegisterPageUI;

public class RegisterPageObject extends BasePages{
	private WebDriver driver; 
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click on Register button")
	public void clickOnRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickOnElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	
	@Step("Get Register successfully message")
	public String getRegisterSuccessfullyMessage() {
		waitForElementVisibility(driver, RegisterPageUI.REGISTER_SUCCESSFULLY_MESSAGE);
		return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESSFULLY_MESSAGE); 
	}

	@Step("Click on Register link")
	public void clickOnRegisterLink() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickOnElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	
	@Step("Get Invalid error message")
	public String getInvalidErrorMessage() {
		waitForElementVisibility(driver, RegisterPageUI.INVALID_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.INVALID_ERROR_MESSAGE); 
	}

	@Step("Get First name error message")
	public String getFirstNameErrorMessage() {
		waitForElementVisibility(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}
	
	@Step("Get Last name error message")
	public String getLastNameErrorMessage() {
		waitForElementVisibility(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}
	
	@Step("Get Email error message")
	public String getEmailErrorMessage() {
		waitForElementVisibility(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	@Step("Get Password error error message")
	public String getPasswordErrorMessage() {
		waitForElementVisibility(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}
	
	@Step("Get Confirm password error message")
	public String getConfirmPasswordErrorMessage() {
		waitForElementVisibility(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	@Step("Input to First name textbox with value {0}")
	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisibility(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	
	@Step("Input to Last name textbox with value {0}")
	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisibility(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	
	@Step("Input to Email textbox with value {0}")
	public void inputToEmailTextbox(String email) {
		waitForElementVisibility(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}
	
	@Step("Input to Password textbox with value {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisibility(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}
	
	@Step("Input to Confirm password textbox with value {0}")
	public void inputToConfirmPasswordTextbox(String password) {
		waitForElementVisibility(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}
}
