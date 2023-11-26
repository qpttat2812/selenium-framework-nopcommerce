package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManagerUser;
import io.qameta.allure.Step;
import pagesUI.user.AddToCartPageUI;

public class AddToCartPageObject extends BasePages{
	private WebDriver driver;
	
	public AddToCartPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@Step("Get Product name of Add To Cart page")
	public String getAddToCartProductName() {
		waitForElementInvisibility(AddToCartPageUI.AJAX_LOADING_ICON);
		waitForElementVisibility(AddToCartPageUI.ADD_TO_CART_PRODUCT_NAME);
		return getTextElement(AddToCartPageUI.ADD_TO_CART_PRODUCT_NAME);
	}

	@Step("Click on 'Edit' icon")
	public DesktopsDetailedPageObject clickOnEditLink() {
		waitForElementVisibility(AddToCartPageUI.EDIT_ICON);
		clickOnElement(AddToCartPageUI.EDIT_ICON);
		return PageGeneratorManagerUser.getDesktopsDetailedPageObject(driver);
	}

	@Step("Get Product SKU Value")
	public String getProductSKUValue() {
		waitForElementVisibility(AddToCartPageUI.PRODUCT_SKU_VALUE);
		return getTextElement(AddToCartPageUI.PRODUCT_SKU_VALUE);
	}

	@Step("Verify product image is loaded and displayed")
	public boolean isProductImageDisplayed() {
		waitForElementVisibility(AddToCartPageUI.PRODUCT_IMAGE);
		return checkImageLoadedAndDisplayed(AddToCartPageUI.PRODUCT_IMAGE);
	}

	@Step("Get Desktop Components info ")
	public String getCartProductInfo() {
		waitForElementVisibility(AddToCartPageUI.PRODUCT_COMPONENT_INFO);
		return getTextElement(AddToCartPageUI.PRODUCT_COMPONENT_INFO);
	}
	
	@Step("Get Unit Price value")
	public float getUnitPriceValue() {
		waitForElementVisibility(AddToCartPageUI.PRODUCT_UNIT_PRICE_VALUE);
		return Float.valueOf(getTextElement(AddToCartPageUI.PRODUCT_UNIT_PRICE_VALUE).replace("$", "").replace(",", ""));
	}

	@Step("Get Quantity value")
	public int getQuantityValue(String expectedAttribute) {
		waitForElementVisibility(AddToCartPageUI.PRODUCT_QUANTITY_VALUE);
		return Integer.valueOf(getAttributeValue(AddToCartPageUI.PRODUCT_QUANTITY_VALUE, expectedAttribute));
	}

	@Step("Get Sub-total price value")
	public String getSubTotalPriceValue() {
		waitForElementVisibility(AddToCartPageUI.PRODUCT_SUB_TOTAL_VALUE);
		return getTextElement(AddToCartPageUI.PRODUCT_SUB_TOTAL_VALUE);
	}

	@Step("Get Product Name value")
	public String getProductNameValue() {
		waitForElementVisibility(AddToCartPageUI.PRODUCT_NAME_VALUE);
		return getTextElement(AddToCartPageUI.PRODUCT_NAME_VALUE);
	}

	@Step("Click on 'Remove' icon")
	public void clickOnRemoveIcon() {
		waitForElementVisibility(AddToCartPageUI.REMOVE_ICON);
		clickOnElement(AddToCartPageUI.REMOVE_ICON);
	}

	@Step("Get empty cart message")
	public String getEmptyCartText() {
		waitForElementVisibility(AddToCartPageUI.EMPTY_CART_MESSAGE);
		return getTextElement(AddToCartPageUI.EMPTY_CART_MESSAGE);
	}

	@Step("Verify Product is undisplayed in cart")
	public boolean isProductUndisplayedInCart() {
		return isElementUndisplayed(AddToCartPageUI.PRODUCT_NAME_VALUE);
	}

	@Step("Input quantity to Quantity textbox with value is {0}")
	public void inputToQuantityTextbox(String expectedQuantity) {
		waitForElementVisibility(AddToCartPageUI.PRODUCT_QUANTITY_VALUE);
		clickOnElement(AddToCartPageUI.PRODUCT_QUANTITY_VALUE);
		sendkeyToElement(AddToCartPageUI.PRODUCT_QUANTITY_VALUE, expectedQuantity);
	}

	@Step("Click on 'Shopping Cart' button")
	public void clickOnUpdateCartButton() {
		waitForElementClickable(AddToCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
		clickOnElement(AddToCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
	}

	@Step("Select Gift Wrapping dropdownlist")
	public void selectGiftWrappingDropdownlist(String expectedOption) {
		waitForElementVisibility(AddToCartPageUI.GIFT_WRAPPING_DROPDOWNLIST);
		selectDefaultItemDropdownList(AddToCartPageUI.GIFT_WRAPPING_DROPDOWNLIST, expectedOption);
		sleepInSecond(5);
	}

	@Step("Get Gift Wrapping value")
	public float getGiftWrappingValue() {
		waitForElementVisibility(AddToCartPageUI.SELECTED_GIFT_WRAPPING_VALUE);
		String giftWrappingText = getTextElement(AddToCartPageUI.SELECTED_GIFT_WRAPPING_VALUE);
		return Float.valueOf(giftWrappingText.substring(giftWrappingText.indexOf("$"), giftWrappingText.indexOf("]")).replace("$", ""));
	}

	@Step("Verify Gift Wrapping Text displayed")
	public boolean isGiftWrappingTextDisplayed() {
		waitForElementVisibility(AddToCartPageUI.SELECTED_GIFT_WRAPPING_VALUE);
		return isElementDisplayed(AddToCartPageUI.SELECTED_GIFT_WRAPPING_VALUE);
	}

	@Step("Get summary Shipping value")
	public float getSummaryShippingValue() {
		waitForElementVisibility(AddToCartPageUI.SUMMARY_SHIPPING_COST_VALUE);
		return Float.valueOf(getTextElement(AddToCartPageUI.SUMMARY_SHIPPING_COST_VALUE).replace("$", ""));
	}

	@Step("Get summary Tax value")
	public float getSummaryTaxValue() {
		waitForElementVisibility(AddToCartPageUI.SUMMARY_TAX_VALUE);
		return Float.valueOf(getTextElement(AddToCartPageUI.SUMMARY_TAX_VALUE).replace("$", ""));
	}

	@Step("Get summary Earning Point value")
	public int getSummaryEarningPointValue() {
		waitForElementVisibility(AddToCartPageUI.SUMMARY_EARNING_POINT_VALUE);
		String point = getTextElement(AddToCartPageUI.SUMMARY_EARNING_POINT_VALUE);
		return Integer.valueOf(point.substring(0, point.indexOf(" ")).trim());
	}

	@Step("Get summary Total Price value")
	public Float getSummaryTotalPriceValue() {
		waitForElementVisibility(AddToCartPageUI.SUMMARY_TOTAL_PRICE_VALUE);
		return Float.valueOf(getTextElement(AddToCartPageUI.SUMMARY_TOTAL_PRICE_VALUE).replace("$", "").replace(",", ""));
	}

	@Step("Click on Term of Service checkbox")
	public void clickOnTermOfServiceCheckbox() {
		waitForElementVisibility(AddToCartPageUI.TERM_OF_SERVICES_CHECKBOX);
		checkOnCheckbox(AddToCartPageUI.TERM_OF_SERVICES_CHECKBOX);
	}

	@Step("Click on 'Checkout' button")
	public CheckoutPageObject clickOnCheckoutButton() {
		waitForElementVisibility(AddToCartPageUI.CHECKOUT_BUTTON);
		clickOnElement(AddToCartPageUI.CHECKOUT_BUTTON);
		return PageGeneratorManagerUser.getCheckoutPageObject(driver);
	}

	@Step("Get summary sub-total price value")
	public float getSummarySubTotalPriceValue() {
		waitForElementVisibility(AddToCartPageUI.SUMMARY_SUB_TOTAL_PRICE);
		return Float.valueOf(getTextElement(AddToCartPageUI.SUMMARY_SUB_TOTAL_PRICE).replace("$", "").replace(",", ""));
	}

	@Step("Verify Add to Cart page is loaded")
	public boolean isAddToCartPageLoadedSuccessfully() {
		return isJQueryOrJSLoadedSuccess();
	}
}
