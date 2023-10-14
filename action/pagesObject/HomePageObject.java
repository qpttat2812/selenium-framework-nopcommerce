package pagesObject;

import org.openqa.selenium.WebDriver;

import common.BasePages;
import common.PageGeneratorManager;
import pagesUI.user.HomePageUI;

public class HomePageObject extends BasePages{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public RegisterPageObject clickOnRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickOnElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}
	
	public LoginPageObject clickOnLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickOnElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPageObject(driver);
	}
}
