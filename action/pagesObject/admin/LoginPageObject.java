package pagesObject.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManagerAdmin;
import io.qameta.allure.Step;
import pagesUI.admin.LoginPageUI;

public class LoginPageObject extends BasePages{
	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@Step("Input to 'Email' textbox with value is {0}")
	public void inputToEmailTextbox(String expectedEmail) {
		waitForElementVisibility(LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(LoginPageUI.EMAIL_TEXTBOX, expectedEmail);
	}
	
	@Step("Input to 'Password' textbox with value is {0}")
	public void inputToPasswordTextbox(String expectedPassword) {
		waitForElementVisibility(LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(LoginPageUI.PASSWORD_TEXTBOX, expectedPassword);
	}
	
	@Step("Click on 'Login' button")
	public DashboardPageObject clickOnLoginButton() {
		waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
		clickOnElement(LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManagerAdmin.getDashboardPageObject(driver);
	}
}
