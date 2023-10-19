package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManager;
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

	public boolean isMyAccountDisplayed() {
		waitForElementVisibility(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public MyAccountPageObject clickOnMyAccountLink() {
		waitForElementVisibility(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickOnElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPageObject(driver);
	}

	public HomePageObject clickOnLogoutLink() {
		waitForElementVisibility(driver, HomePageUI.LOGOUT_LINK);
		clickOnElement(driver, HomePageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public void clickOnProductTab(String items) {
		waitForElementVisibility(driver, HomePageUI.PRODUCT_TAB, items);
		clickOnElement(driver, HomePageUI.PRODUCT_TAB, items);
	}

}
