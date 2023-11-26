package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManagerUser;
import io.qameta.allure.Step;
import pagesUI.user.WishlistPageUI;

public class WishlistPageObject extends BasePages{
	private WebDriver driver;
	
	public WishlistPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Get Product name of Wishlist page")
	public String getWishlistProductName() {
		waitForElementVisibility(WishlistPageUI.WISHLIST_PRODUCT_NAME);
		return getTextElement(WishlistPageUI.WISHLIST_PRODUCT_NAME);
	}
	
	@Step("Click on 'Wishlist Sharing Url'")
	public void clickOnWishlistSharingURL() {
		waitForElementVisibility(WishlistPageUI.WISHLIST_SHARING_URL);
		clickOnElement(WishlistPageUI.WISHLIST_SHARING_URL);
	}
	
	@Step("Get Wishlist Sharing Title")
	public String getWishlistSharingTitle() {
		waitForElementVisibility(WishlistPageUI.WISHLIST_SHARING_TITLE);
		return getTextElement(WishlistPageUI.WISHLIST_SHARING_TITLE);
	}

	@Step("Check on 'Add to cart' checkbox")
	public void checkOnAddToCartCheckbox() {
		waitForElementVisibility(WishlistPageUI.ADD_TO_CART_CHECKBOX);
		checkOnCheckbox(WishlistPageUI.ADD_TO_CART_CHECKBOX);
	}

	@Step("Click On 'Add to cart' button")
	public AddToCartPageObject clickOnAddToCartButton() {
		waitForElementClickable(WishlistPageUI.ADD_TO_CART_BUTTON);
		clickOnElement(WishlistPageUI.ADD_TO_CART_BUTTON);
		return PageGeneratorManagerUser.getAddToCartPageObject(driver);
	}

	@Step("Verify product is undisplayed")
	public boolean isProductUndisplayed() {
		return isElementUndisplayed(WishlistPageUI.WISHLIST_PRODUCT_NAME);
	}

	@Step("Click on 'Remove' icon")
	public void clickOnRemoveIcon() {
		waitForElementVisibility(WishlistPageUI.REMOVE_WISHLIST_PRODUCT_ICON);
		clickOnElement(WishlistPageUI.REMOVE_WISHLIST_PRODUCT_ICON);
	}

	@Step("Verify Wishlist page is empty")
	public boolean isWishlistPageEmpty() {
		waitForElementInvisibility(WishlistPageUI.AJAX_LOADING_ICON);
		return isElementDisplayed(WishlistPageUI.WISHLIST_EMPTY_MESSAGE);
	}
}
