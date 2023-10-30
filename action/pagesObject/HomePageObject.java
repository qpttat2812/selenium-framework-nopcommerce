package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pagesUI.user.HomePageUI;

public class HomePageObject extends BasePages{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click on Register link")
	public RegisterPageObject clickOnRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickOnElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}
	
	@Step("Click on Login link")
	public LoginPageObject clickOnLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickOnElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPageObject(driver);
	}

	@Step("Verify My account link is displayed")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisibility(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	@Step("Click on My account link")
	public MyAccountPageObject clickOnMyAccountLink() {
		waitForElementVisibility(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickOnElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPageObject(driver);
	}

	@Step("Click on Log out link")
	public HomePageObject clickOnLogoutLink() {
		waitForElementVisibility(driver, HomePageUI.LOGOUT_LINK);
		clickOnElement(driver, HomePageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePageObject(driver);
	}
	
	@Step("Click on Wishlist link")
	public WishlistPageObject clickOnWishlistLink() {
		waitForElementVisibility(driver, HomePageUI.WISHLIST_LINK);
		clickOnElement(driver, HomePageUI.WISHLIST_LINK);
		return PageGeneratorManager.getWishlistPageObject(driver);
	}
	
	@Step("Get product quantity from cart")
	public int getShoppingCartQuantity() {
		waitForElementVisibility(driver, HomePageUI.SHOPPING_CART_QUANTITY_TEXT);
		return Integer.valueOf(getTextElement(driver, HomePageUI.SHOPPING_CART_QUANTITY_TEXT).substring(1, 2));
	}

	@Step("Get quantity from wishlist")
	public int getWishlistLinkQuantity() {
		waitForElementVisibility(driver, HomePageUI.WISHLIST_QUANTITY_TEXT);
		return Integer.valueOf(getTextElement(driver, HomePageUI.WISHLIST_QUANTITY_TEXT).substring(1, 2));
	}
	
	@Step("Click on header logo")
	public void clickOnHeaderLogo() {
		waitForAllElementsVisibility(driver, HomePageUI.HEADER_LOGO_LINK);
		clickOnElement(driver, HomePageUI.HEADER_LOGO_LINK);
	}
}
