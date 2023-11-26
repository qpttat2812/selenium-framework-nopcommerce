package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManagerUser;
import io.qameta.allure.Step;
import pagesUI.user.LoginPageUI;

public class LoginPageObject extends BasePages{
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Click on 'Login' button")
	public HomePageObject clickOnLoginButton() {
		waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
		clickOnElement(LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManagerUser.getHomePageObject(driver);
	}

	@Step("Get Email error message")
	public String getEmailErrorMessage() {
		waitForElementVisibility(LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getTextElement(LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	@Step("Input to 'Email' textbox with value is {0}")
	public void inputToEmailTextbox(String email) {
		waitForElementClickable(LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(LoginPageUI.EMAIL_TEXTBOX, email);
	}

	@Step("Input to 'Password' textbox with value is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Get invalid error message message")
	public String getInvalidErrorMessageText() {
		waitForElementVisibility(LoginPageUI.INVALID_ERROR_MESSAGE);
		return getTextElement(LoginPageUI.INVALID_ERROR_MESSAGE);
	}
}
