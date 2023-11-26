package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManagerUser;
import io.qameta.allure.Step;
import pagesUI.user.HomePageUI;

public class HomePageObject extends BasePages{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@Step("Click on 'Register' link")
	public RegisterPageObject clickOnRegisterLink() {
		waitForElementClickable(HomePageUI.REGISTER_LINK);
		clickOnElement(HomePageUI.REGISTER_LINK);
		return PageGeneratorManagerUser.getRegisterPageObject(driver);
	}
	
	@Step("Click on 'Login' link")
	public LoginPageObject clickOnLoginLink() {
		waitForElementClickable(HomePageUI.LOGIN_LINK);
		clickOnElement(HomePageUI.LOGIN_LINK);
		return PageGeneratorManagerUser.getLoginPageObject(driver);
	}

	@Step("Verify My account link is displayed")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisibility(HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(HomePageUI.MY_ACCOUNT_LINK);
	}

	@Step("Click on 'My Account' link")
	public MyAccountPageObject clickOnMyAccountLink() {
		waitForElementVisibility(HomePageUI.MY_ACCOUNT_LINK);
		clickOnElement(HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManagerUser.getMyAccountPageObject(driver);
	}

	@Step("Click on 'Log out' link")
	public HomePageObject clickOnLogoutLink() {
		waitForElementVisibility(HomePageUI.LOGOUT_LINK);
		clickOnElement(HomePageUI.LOGOUT_LINK);
		return PageGeneratorManagerUser.getHomePageObject(driver);
	}
	
	@Step("Click on 'Wishlist' link")
	public WishlistPageObject clickOnWishlistLink() {
		waitForElementVisibility(HomePageUI.WISHLIST_LINK);
		clickOnElement(HomePageUI.WISHLIST_LINK);
		return PageGeneratorManagerUser.getWishlistPageObject(driver);
	}
	
	@Step("Get product quantity from Cart")
	public int getShoppingCartQuantity() {
		waitForElementVisibility(HomePageUI.SHOPPING_CART_QUANTITY_VALUE);
		return Integer.valueOf(getTextElement(HomePageUI.SHOPPING_CART_QUANTITY_VALUE).substring(1, 2));
	}

	@Step("Get quantity from wishlist")
	public int getWishlistLinkQuantity() {
		waitForElementVisibility(HomePageUI.WISHLIST_QUANTITY_VALUE);
		return Integer.valueOf(getTextElement(HomePageUI.WISHLIST_QUANTITY_VALUE).substring(1, 2));
	}

	@Step("Get Summary Message in Minicart")
	public String getMiniCartSummaryMessage() {
		waitForElementPresence(HomePageUI.COUNT_IN_MINICART_VALUE);
		System.out.println(getTextElement(HomePageUI.COUNT_IN_MINICART_VALUE));
		return getInnerTextByJS(getElement(HomePageUI.COUNT_IN_MINICART_VALUE));
	}

	@Step("Get selected components info in Minicart")
	public String getMiniCartProductInfo() {
		waitForElementPresence(HomePageUI.MINICART_COMPONENT_ITEM_INFO);
		return getInnerTextByJS(getElement(HomePageUI.MINICART_COMPONENT_ITEM_INFO));
	}

	@Step("Get unit price of product in Minicart")
	public String getMiniCartUnitPriceInfo() {
		waitForElementPresence(HomePageUI.MINICART_UNIT_PRICE_VALUE);
		return getInnerTextByJS(getElement(HomePageUI.MINICART_UNIT_PRICE_VALUE));
	}

	@Step("Get quantity of product in Minicart")
	public String getMiniCartQuantityInfo() {
		waitForElementPresence(HomePageUI.MINICART_QUANTITY_VALUE);
		return getInnerTextByJS(getElement(HomePageUI.MINICART_QUANTITY_VALUE));
	}

	@Step("Get sub-total price of product in Minicart")
	public String getMiniCartSubTotalPriceValue() {
		waitForElementPresence(HomePageUI.MINICART_SUB_TOTAL_PRICE_VALUE);
		return getInnerTextByJS(getElement(HomePageUI.MINICART_SUB_TOTAL_PRICE_VALUE));
	}

	@Step("Click On Shopping Cart link")
	public AddToCartPageObject clickOnShoppingCartLink() {
		waitForElementVisibility(HomePageUI.SHOPPING_CART_LINK);
		clickOnElement(HomePageUI.SHOPPING_CART_LINK);
		return PageGeneratorManagerUser.getAddToCartPageObject(driver);
	}

	@Step("Click on Logo link")
	public void clickOnLogoLink() {
		waitForElementVisibility(HomePageUI.LOGO_NOPCOMMERCE_LINK);
		clickOnElement(HomePageUI.LOGO_NOPCOMMERCE_LINK);
	}
}
