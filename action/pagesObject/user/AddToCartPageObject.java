package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManagerUser;
import io.qameta.allure.Step;
import pagesUI.user.AddToCartPageUI;

public class AddToCartPageObject extends BasePages{
	private WebDriver driver;
	
	public AddToCartPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Get Product name of Add To Cart page")
	public String getAddToCartProductName() {
		waitForElementInvisibility(driver, AddToCartPageUI.AJAX_LOADING_ICON);
		waitForElementVisibility(driver, AddToCartPageUI.ADD_TO_CART_PRODUCT_NAME);
		return getTextElement(driver, AddToCartPageUI.ADD_TO_CART_PRODUCT_NAME);
	}

	@Step("Click on 'Edit' icon")
	public DesktopsDetailedPageObject clickOnEditLink() {
		waitForElementVisibility(driver, AddToCartPageUI.EDIT_ICON);
		clickOnElement(driver, AddToCartPageUI.EDIT_ICON);
		return PageGeneratorManagerUser.getDesktopsDetailedPageObject(driver);
	}

	@Step("Get Product SKU Value")
	public String getProductSKUValue() {
		waitForElementVisibility(driver, AddToCartPageUI.PRODUCT_SKU_VALUE);
		return getTextElement(driver, AddToCartPageUI.PRODUCT_SKU_VALUE);
	}

	@Step("Verify product image is loaded and displayed")
	public boolean isProductImageDisplayed() {
		waitForElementVisibility(driver, AddToCartPageUI.PRODUCT_IMAGE);
		return checkImageLoadedAndDisplayed(driver, AddToCartPageUI.PRODUCT_IMAGE);
	}

	@Step("Get Desktop Components info ")
	public String getCartProductInfo() {
		waitForElementVisibility(driver, AddToCartPageUI.PRODUCT_COMPONENT_INFO);
		return getTextElement(driver, AddToCartPageUI.PRODUCT_COMPONENT_INFO);
	}
	
	@Step("Get Unit Price value")
	public float getUnitPriceValue() {
		waitForElementVisibility(driver, AddToCartPageUI.PRODUCT_UNIT_PRICE_VALUE);
		return Float.valueOf(getTextElement(driver, AddToCartPageUI.PRODUCT_UNIT_PRICE_VALUE).replace("$", "").replace(",", ""));
	}

	@Step("Get Quantity value")
	public int getQuantityValue(String expectedAttribute) {
		waitForElementVisibility(driver, AddToCartPageUI.PRODUCT_QUANTITY_VALUE);
		return Integer.valueOf(getAttributeValue(driver, AddToCartPageUI.PRODUCT_QUANTITY_VALUE, expectedAttribute));
	}

	@Step("Get Sub-total price value")
	public String getSubTotalPriceValue() {
		waitForElementVisibility(driver, AddToCartPageUI.PRODUCT_SUB_TOTAL_VALUE);
		return getTextElement(driver, AddToCartPageUI.PRODUCT_SUB_TOTAL_VALUE);
	}

	@Step("Get Product Name value")
	public String getProductNameValue() {
		waitForElementVisibility(driver, AddToCartPageUI.PRODUCT_NAME_VALUE);
		return getTextElement(driver, AddToCartPageUI.PRODUCT_NAME_VALUE);
	}

	@Step("Click on 'Remove' icon")
	public void clickOnRemoveIcon() {
		waitForElementVisibility(driver, AddToCartPageUI.REMOVE_ICON);
		clickOnElement(driver, AddToCartPageUI.REMOVE_ICON);
	}

	@Step("Get empty cart message")
	public String getEmptyCartText() {
		waitForElementVisibility(driver, AddToCartPageUI.EMPTY_CART_MESSAGE);
		return getTextElement(driver, AddToCartPageUI.EMPTY_CART_MESSAGE);
	}

	@Step("Verify Product is undisplayed in cart")
	public boolean isProductUndisplayedInCart() {
		return isElementUndisplayed(driver, AddToCartPageUI.PRODUCT_NAME_VALUE);
	}

	@Step("Input quantity to Quantity textbox with value is {0}")
	public void inputToQuantityTextbox(String expectedQuantity) {
		waitForElementVisibility(driver, AddToCartPageUI.PRODUCT_QUANTITY_VALUE);
		clickOnElement(driver, AddToCartPageUI.PRODUCT_QUANTITY_VALUE);
		sendkeyToElement(driver, AddToCartPageUI.PRODUCT_QUANTITY_VALUE, expectedQuantity);
	}

	@Step("Click on 'Shopping Cart' button")
	public void clickOnUpdateCartButton() {
		waitForElementClickable(driver, AddToCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
		clickOnElement(driver, AddToCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
	}

	@Step("Select Gift Wrapping dropdownlist")
	public void selectGiftWrappingDropdownlist(String expectedOption) {
		waitForElementVisibility(driver, AddToCartPageUI.GIFT_WRAPPING_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, AddToCartPageUI.GIFT_WRAPPING_DROPDOWNLIST, expectedOption);
		sleepInSecond(5);
	}

	@Step("Get Gift Wrapping value")
	public float getGiftWrappingValue() {
		waitForElementVisibility(driver, AddToCartPageUI.SELECTED_GIFT_WRAPPING_VALUE);
		String giftWrappingText = getTextElement(driver, AddToCartPageUI.SELECTED_GIFT_WRAPPING_VALUE);
		return Float.valueOf(giftWrappingText.substring(giftWrappingText.indexOf("$"), giftWrappingText.indexOf("]")).replace("$", ""));
	}

	@Step("Verify Gift Wrapping Text displayed")
	public boolean isGiftWrappingTextDisplayed() {
		waitForElementVisibility(driver, AddToCartPageUI.SELECTED_GIFT_WRAPPING_VALUE);
		return isElementDisplayed(driver, AddToCartPageUI.SELECTED_GIFT_WRAPPING_VALUE);
	}

	@Step("Get summary Shipping value")
	public float getSummaryShippingValue() {
		waitForElementVisibility(driver, AddToCartPageUI.SUMMARY_SHIPPING_COST_VALUE);
		return Float.valueOf(getTextElement(driver, AddToCartPageUI.SUMMARY_SHIPPING_COST_VALUE).replace("$", ""));
	}

	@Step("Get summary Tax value")
	public float getSummaryTaxValue() {
		waitForElementVisibility(driver, AddToCartPageUI.SUMMARY_TAX_VALUE);
		return Float.valueOf(getTextElement(driver, AddToCartPageUI.SUMMARY_TAX_VALUE).replace("$", ""));
	}

	@Step("Get summary Earning Point value")
	public int getSummaryEarningPointValue() {
		waitForElementVisibility(driver, AddToCartPageUI.SUMMARY_EARNING_POINT_VALUE);
		String point = getTextElement(driver, AddToCartPageUI.SUMMARY_EARNING_POINT_VALUE);
		return Integer.valueOf(point.substring(0, point.indexOf(" ")).trim());
	}

	@Step("Get summary Total Price value")
	public Float getSummaryTotalPriceValue() {
		waitForElementVisibility(driver, AddToCartPageUI.SUMMARY_TOTAL_PRICE_VALUE);
		return Float.valueOf(getTextElement(driver, AddToCartPageUI.SUMMARY_TOTAL_PRICE_VALUE).replace("$", "").replace(",", ""));
	}

	@Step("Click on Term of Service checkbox")
	public void clickOnTermOfServiceCheckbox() {
		waitForElementVisibility(driver, AddToCartPageUI.TERM_OF_SERVICES_CHECKBOX);
		checkOnCheckbox(driver, AddToCartPageUI.TERM_OF_SERVICES_CHECKBOX);
	}

	@Step("Click on 'Checkout' button")
	public CheckoutPageObject clickOnCheckoutButton() {
		waitForElementVisibility(driver, AddToCartPageUI.CHECKOUT_BUTTON);
		clickOnElement(driver, AddToCartPageUI.CHECKOUT_BUTTON);
		return PageGeneratorManagerUser.getCheckoutPageObject(driver);
	}

	@Step("Get summary sub-total price value")
	public float getSummarySubTotalPriceValue() {
		waitForElementVisibility(driver, AddToCartPageUI.SUMMARY_SUB_TOTAL_PRICE);
		return Float.valueOf(getTextElement(driver, AddToCartPageUI.SUMMARY_SUB_TOTAL_PRICE).replace("$", "").replace(",", ""));
	}

	@Step("Verify Add to Cart page is loaded")
	public boolean isAddToCartPageLoadedSuccessfully() {
		return isJQueryOrJSLoadedSuccess(driver);
	}
}
