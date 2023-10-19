package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManager;
import pagesUI.user.LoginPageUI;

public class LoginPageObject extends BasePages{
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageObject clickOnLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickOnElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public String getEmailErrorMessage() {
		waitForElementVisibility(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementClickable(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public String getInvalidErrorMessageText() {
		waitForElementVisibility(driver, LoginPageUI.INVALID_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.INVALID_ERROR_MESSAGE);
	}
}
