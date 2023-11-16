package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.DesktopsDetailedPageUI;

public class DesktopsDetailedPageObject extends BasePages{
	private WebDriver driver;
	
	public DesktopsDetailedPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Select desktop component dropdownlist with label is {0} and value is {1}")
	public void selectDesktopComponentDropdownlist(String expectedLabel, String expectedOption) {
		waitForElementVisibility(driver, DesktopsDetailedPageUI.DYNAMIC_PRODUCT_COMPONENT_DROPDOWNLIST, expectedLabel);
		selectDefaultItemInDropdownList(driver, DesktopsDetailedPageUI.DYNAMIC_PRODUCT_COMPONENT_DROPDOWNLIST, expectedOption, expectedLabel);
	}

	@Step("Select desktop component radio button with label is {0} and value is {1}")
	public void selectDesktopComponentRadioButton(String expectedLabel, String expectedOption) {
		waitForElementClickable(driver, DesktopsDetailedPageUI.DYNAMIC_PRODUCT_COMPONENT_RADIO_BUTTON, expectedLabel, expectedOption);
		clickOnElement(driver, DesktopsDetailedPageUI.DYNAMIC_PRODUCT_COMPONENT_RADIO_BUTTON, expectedLabel, expectedOption);
	}

	@Step("Check on Software checkbox with value is {0}")
	public void checkOnSoftwareCheckbox(String expectedSoftware) {
		waitForElementClickable(driver, DesktopsDetailedPageUI.DYNAMIC_PRODUCT_SOFTWARE_CHECKBOX, expectedSoftware);
		clickOnElement(driver, DesktopsDetailedPageUI.DYNAMIC_PRODUCT_SOFTWARE_CHECKBOX, expectedSoftware);
	}

	@Step("Click on 'Add to cart' button")
	public void clickOnAddToCartButton() {
		waitForElementClickable(driver, DesktopsDetailedPageUI.ADD_TO_CART_BUTTON);
		clickOnElement(driver, DesktopsDetailedPageUI.ADD_TO_CART_BUTTON);
	}

	@Step("Get Bar Notification Success message")
	public String getBarNotificationSuccessMessage() {
		waitForElementVisibility(driver, DesktopsDetailedPageUI.BAR_NOTIFICATION_SUCCESS_MESSAGE);
		return getTextElement(driver, DesktopsDetailedPageUI.BAR_NOTIFICATION_SUCCESS_MESSAGE);
	}

	@Step("Click on Close button in bar notification success")
	public void clickOnCloseButton() {
		waitForElementClickable(driver, DesktopsDetailedPageUI.BAR_CLOSE_BUTTON);
		clickOnElement(driver, DesktopsDetailedPageUI.BAR_CLOSE_BUTTON);
		waitForElementInvisibility(driver, DesktopsDetailedPageUI.BAR_CLOSE_BUTTON);
	}

	@Step("Get product unit price")
	public float getProductUnitPriceValue() {
		waitForElementVisibility(driver, DesktopsDetailedPageUI.PRODUCT_UNIT_PRICE_VALUE);
		String price = getTextElement(driver, DesktopsDetailedPageUI.PRODUCT_UNIT_PRICE_VALUE).replace("$", "").replace(",", "");
		return Float.valueOf(price);
	}

	@Step("Input quantity into Quantity Textbox with value is {0}")
	public void inputQuantityToQuantityTextbox(String expectedQuantity) {
		waitForElementVisibility(driver, DesktopsDetailedPageUI.QUANTITY_TEXTBOX);
		sendkeyToElement(driver, DesktopsDetailedPageUI.QUANTITY_TEXTBOX, expectedQuantity);
	}

	@Step("Get Product SKU value")
	public String getProductSKUValue() {
		waitForElementVisibility(driver, DesktopsDetailedPageUI.PRODUCT_SKU);
		return getTextElement(driver, DesktopsDetailedPageUI.PRODUCT_SKU);
	}
}
