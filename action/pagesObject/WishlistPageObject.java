package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pagesUI.user.WishlistPageUI;

public class WishlistPageObject extends BasePages{
	private WebDriver driver;
	
	public WishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Get Product name of Wishlist page")
	public String getWishlistProductName() {
		waitForElementVisibility(driver, WishlistPageUI.WISHLIST_PRODUCT_NAME);
		return getTextElement(driver, WishlistPageUI.WISHLIST_PRODUCT_NAME);
	}
	
	@Step("Click on 'Wishlist Sharing Url'")
	public void clickOnWishlistSharingURL() {
		waitForElementVisibility(driver, WishlistPageUI.WISHLIST_SHARING_URL);
		clickOnElement(driver, WishlistPageUI.WISHLIST_SHARING_URL);
	}
	
	@Step("Get Wishlist Sharing Title")
	public String getWishlistSharingTitle() {
		waitForElementVisibility(driver, WishlistPageUI.WISHLIST_SHARING_TITLE);
		return getTextElement(driver, WishlistPageUI.WISHLIST_SHARING_TITLE);
	}

	@Step("Check on 'Add to cart' checkbox")
	public void checkOnAddToCartCheckbox() {
		waitForElementVisibility(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
		checkOnCheckbox(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
	}

	@Step("Click On 'Add to cart' button")
	public AddToCartPageObject clickOnAddToCartButton() {
		waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		clickOnElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		return PageGeneratorManager.getAddToCartPageObject(driver);
	}

	@Step("Verify product is undisplayed")
	public boolean isProductUndisplayed() {
		return isElementUndisplayed(driver, WishlistPageUI.WISHLIST_PRODUCT_NAME);
	}

	@Step("Click on 'Remove' icon")
	public void clickOnRemoveIcon() {
		waitForElementVisibility(driver, WishlistPageUI.REMOVE_WISHLIST_PRODUCT_ICON);
		clickOnElement(driver, WishlistPageUI.REMOVE_WISHLIST_PRODUCT_ICON);
	}

	@Step("Verify Wishlist page is empty")
	public boolean isWishlistPageEmpty() {
		waitForElementInvisibility(driver, WishlistPageUI.AJAX_LOADING_ICON);
		return isElementDisplayed(driver, WishlistPageUI.WISHLIST_EMPTY_MESSAGE);
	}
}
