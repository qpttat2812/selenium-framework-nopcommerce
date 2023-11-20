package pagesObject.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManagerAdmin;
import io.qameta.allure.Step;
import pagesUI.admin.LoginPageUI;

public class LoginPageObject extends BasePages{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Input to 'Email' textbox with value is {0}")
	public void inputToEmailTextbox(String expectedEmail) {
		waitForElementVisibility(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, expectedEmail);
	}
	
	@Step("Input to 'Password' textbox with value is {0}")
	public void inputToPasswordTextbox(String expectedPassword) {
		waitForElementVisibility(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, expectedPassword);
	}
	
	@Step("Click on 'Login' button")
	public DashboardPageObject clickOnLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickOnElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManagerAdmin.getDashboardPageObject(driver);
	}
}
