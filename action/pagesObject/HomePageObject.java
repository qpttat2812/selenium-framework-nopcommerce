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
	
	@Step("Click on 'Register' link")
	public RegisterPageObject clickOnRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickOnElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}
	
	@Step("Click on 'Login' link")
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

	@Step("Click on 'My Account' link")
	public MyAccountPageObject clickOnMyAccountLink() {
		waitForElementVisibility(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickOnElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPageObject(driver);
	}

	@Step("Click on 'Log out' link")
	public HomePageObject clickOnLogoutLink() {
		waitForElementVisibility(driver, HomePageUI.LOGOUT_LINK);
		clickOnElement(driver, HomePageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePageObject(driver);
	}
	
	@Step("Click on 'Wishlist' link")
	public WishlistPageObject clickOnWishlistLink() {
		waitForElementVisibility(driver, HomePageUI.WISHLIST_LINK);
		clickOnElement(driver, HomePageUI.WISHLIST_LINK);
		return PageGeneratorManager.getWishlistPageObject(driver);
	}
	
	@Step("Get product quantity from Cart")
	public int getShoppingCartQuantity() {
		waitForElementVisibility(driver, HomePageUI.SHOPPING_CART_QUANTITY_VALUE);
		return Integer.valueOf(getTextElement(driver, HomePageUI.SHOPPING_CART_QUANTITY_VALUE).substring(1, 2));
	}

	@Step("Get quantity from wishlist")
	public int getWishlistLinkQuantity() {
		waitForElementVisibility(driver, HomePageUI.WISHLIST_QUANTITY_VALUE);
		return Integer.valueOf(getTextElement(driver, HomePageUI.WISHLIST_QUANTITY_VALUE).substring(1, 2));
	}

	@Step("Get Summary Message in Minicart")
	public String getMiniCartSummaryMessage() {
		waitForElementPresence(driver, HomePageUI.COUNT_IN_MINICART_VALUE);
		System.out.println(getTextElement(driver, HomePageUI.COUNT_IN_MINICART_VALUE));
		return getInnerTextByJS(driver, getElement(driver, HomePageUI.COUNT_IN_MINICART_VALUE));
	}

	@Step("Get selected components info in Minicart")
	public String getMiniCartProductInfo() {
		waitForElementPresence(driver, HomePageUI.MINICART_COMPONENT_ITEM_INFO);
		return getInnerTextByJS(driver, getElement(driver, HomePageUI.MINICART_COMPONENT_ITEM_INFO));
	}

	@Step("Get unit price of product in Minicart")
	public String getMiniCartUnitPriceInfo() {
		waitForElementPresence(driver, HomePageUI.MINICART_UNIT_PRICE_VALUE);
		return getInnerTextByJS(driver, getElement(driver, HomePageUI.MINICART_UNIT_PRICE_VALUE));
	}

	@Step("Get quantity of product in Minicart")
	public String getMiniCartQuantityInfo() {
		waitForElementPresence(driver, HomePageUI.MINICART_QUANTITY_VALUE);
		return getInnerTextByJS(driver, getElement(driver, HomePageUI.MINICART_QUANTITY_VALUE));
	}

	@Step("Get sub-total price of product in Minicart")
	public String getMiniCartSubTotalPriceValue() {
		waitForElementPresence(driver, HomePageUI.MINICART_SUB_TOTAL_PRICE_VALUE);
		return getInnerTextByJS(driver, getElement(driver, HomePageUI.MINICART_SUB_TOTAL_PRICE_VALUE));
	}

	@Step("Click On Shopping Cart link")
	public AddToCartPageObject clickOnShoppingCartLink() {
		waitForElementVisibility(driver, HomePageUI.SHOPPING_CART_LINK);
		clickOnElement(driver, HomePageUI.SHOPPING_CART_LINK);
		return PageGeneratorManager.getAddToCartPageObject(driver);
	}

	@Step("Click on Logo link")
	public void clickOnLogoLink() {
		waitForElementVisibility(driver, HomePageUI.LOGO_NOPCOMMERCE_LINK);
		clickOnElement(driver, HomePageUI.LOGO_NOPCOMMERCE_LINK);
	}
}
