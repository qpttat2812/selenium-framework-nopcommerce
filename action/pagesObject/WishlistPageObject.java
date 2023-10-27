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

	@Step("Get Product title in wishlist page")
	public String getProductTitle() {
		waitForElementVisibility(driver, WishlistPageUI.PRODUCT_TITLE);
		return getTextElement(driver, WishlistPageUI.PRODUCT_TITLE);
	}
	
	@Step("Click on wishlist sharing url")
	public void clickOnWishlistSharingURL() {
		waitForElementVisibility(driver, WishlistPageUI.WISHLIST_SHARING_URL);
		clickOnElement(driver, WishlistPageUI.WISHLIST_SHARING_URL);
	}
	
	@Step("Get Wishlist sharing title")
	public String getWishlistSharingTitle() {
		waitForElementVisibility(driver, WishlistPageUI.WISHLIST_SHARING_TITLE);
		return getTextElement(driver, WishlistPageUI.WISHLIST_SHARING_TITLE);
	}

	public void checkOnAddToCartCheckbox() {
		waitForElementVisibility(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
		checkOnCheckbox(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
	}

	public AddToCartPageObject clickOnAddToCartButton() {
		waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		clickOnElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		return PageGeneratorManager.getAddToCartPageObject(driver);
	}

	public boolean isProductUndisplayed() {
		return isElementUndisplayed(driver, WishlistPageUI.PRODUCT_TITLE);
	}
}
