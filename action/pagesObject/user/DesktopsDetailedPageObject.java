package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.DesktopsDetailedPageUI;

public class DesktopsDetailedPageObject extends BasePages{
	public DesktopsDetailedPageObject(WebDriver driver) {
		super(driver);
	}

	@Step("Select desktop component dropdownlist with label is {0} and value is {1}")
	public void selectDesktopComponentDropdownlist(String expectedLabel, String expectedOption) {
		waitForElementVisibility(DesktopsDetailedPageUI.DYNAMIC_PRODUCT_COMPONENT_DROPDOWNLIST, expectedLabel);
		selectDefaultItemInDropdownList(DesktopsDetailedPageUI.DYNAMIC_PRODUCT_COMPONENT_DROPDOWNLIST, expectedOption, expectedLabel);
	}

	@Step("Select desktop component radio button with label is {0} and value is {1}")
	public void selectDesktopComponentRadioButton(String expectedLabel, String expectedOption) {
		waitForElementClickable(DesktopsDetailedPageUI.DYNAMIC_PRODUCT_COMPONENT_RADIO_BUTTON, expectedLabel, expectedOption);
		clickOnElement(DesktopsDetailedPageUI.DYNAMIC_PRODUCT_COMPONENT_RADIO_BUTTON, expectedLabel, expectedOption);
	}

	@Step("Check on Software checkbox with value is {0}")
	public void checkOnSoftwareCheckbox(String expectedSoftware) {
		waitForElementClickable(DesktopsDetailedPageUI.DYNAMIC_PRODUCT_SOFTWARE_CHECKBOX, expectedSoftware);
		clickOnElement(DesktopsDetailedPageUI.DYNAMIC_PRODUCT_SOFTWARE_CHECKBOX, expectedSoftware);
	}

	@Step("Click on 'Add to cart' button")
	public void clickOnAddToCartButton() {
		waitForElementClickable(DesktopsDetailedPageUI.ADD_TO_CART_BUTTON);
		clickOnElement(DesktopsDetailedPageUI.ADD_TO_CART_BUTTON);
	}

	@Step("Get Bar Notification Success message")
	public String getBarNotificationSuccessMessage() {
		waitForElementVisibility(DesktopsDetailedPageUI.BAR_NOTIFICATION_SUCCESS_MESSAGE);
		return getTextElement(DesktopsDetailedPageUI.BAR_NOTIFICATION_SUCCESS_MESSAGE);
	}

	@Step("Get product unit price")
	public float getProductUnitPriceValue() {
		waitForElementVisibility(DesktopsDetailedPageUI.PRODUCT_UNIT_PRICE_VALUE);
		String price = getTextElement(DesktopsDetailedPageUI.PRODUCT_UNIT_PRICE_VALUE).replace("$", "").replace(",", "");
		return Float.valueOf(price);
	}

	@Step("Input quantity into Quantity Textbox with value is {0}")
	public void inputQuantityToQuantityTextbox(String expectedQuantity) {
		waitForElementVisibility(DesktopsDetailedPageUI.QUANTITY_TEXTBOX);
		sendkeyToElement(DesktopsDetailedPageUI.QUANTITY_TEXTBOX, expectedQuantity);
	}

	@Step("Get Product SKU value")
	public String getProductSKUValue() {
		waitForElementVisibility(DesktopsDetailedPageUI.PRODUCT_SKU);
		return getTextElement(DesktopsDetailedPageUI.PRODUCT_SKU);
	}
}
