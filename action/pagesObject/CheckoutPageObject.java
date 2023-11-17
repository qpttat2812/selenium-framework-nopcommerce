package pagesObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.GlobalConstants;
import io.qameta.allure.Step;
import pagesUI.user.CheckoutPageUI;
import utilities.DataHelper;

public class CheckoutPageObject extends BasePages {
	private WebDriver driver;

	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Check on 'Ship same address' checkbox")
	public void unCheckOnShipSameAddressCheckbox() {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_SAME_ADDRESS_CHECKBOX);
		uncheckCheckbox(driver, CheckoutPageUI.SHIPPING_SAME_ADDRESS_CHECKBOX);
	}

	@Step("Input to 'Billing First Name' textbox with value is {0}")
	public void inputToBillingFirstNameTextbox(String expectedFirstName) {
		waitForElementVisibility(driver, CheckoutPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.FIRST_NAME_TEXTBOX, expectedFirstName);
	}

	@Step("Input to 'Billing Last Name' textbox with value is {0}")
	public void inputToBillingLastNameTextbox(String expectedLastName) {
		waitForElementVisibility(driver, CheckoutPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.LAST_NAME_TEXTBOX, expectedLastName);
	}

	@Step("Input to 'Billing Email' textbox with value is {0}")
	public void inputToBillingEmailTextbox(String expectedEmail) {
		waitForElementVisibility(driver, CheckoutPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.EMAIL_TEXTBOX, expectedEmail);
	}

	@Step("Select 'Billing Country' dropdownlist with value is {0}")
	public void selectBillingCountryDropdownlist(String expectedCountry) {
		waitForElementVisibility(driver, CheckoutPageUI.COUNTRY_DROPDOWNLIST);
		List<String> countries = getAllTextElements(driver, CheckoutPageUI.BILLING_COUNTRY_OPTIONS_IN_DROPDOWNLIST);
		String[] expectedCountryArr = expectedCountry.split(" ");
		for (String country : countries) {
			String[] countryArr = country.split(" ");
			if (countryArr[0].equals(expectedCountryArr[0]) && countryArr[countryArr.length - 1].equals(expectedCountryArr[expectedCountryArr.length - 1])) {
				selectDefaultItemDropdownList(driver, CheckoutPageUI.COUNTRY_DROPDOWNLIST, expectedCountry);
				break;
			}
		}
		sleepInSecond(5);
	}

	@Step("Select 'Billing State' dropdownlist with value is {0}")
	public void selectBillingStateDropdownlist(String expectedState) {
		waitForElementInvisibility(driver, CheckoutPageUI.BILLING_STATE_LOADING_ICON);
		waitForElementVisibility(driver, CheckoutPageUI.STATE_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, CheckoutPageUI.STATE_DROPDOWNLIST, expectedState);
	}

	@Step("Input to 'Billing City' textbox with value is {0}")
	public void inputToBillingCityTextbox(String expectedCity) {
		waitForElementVisibility(driver, CheckoutPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.CITY_TEXTBOX, expectedCity);
	}

	@Step("Input to 'Billing Address 1' textbox with value is {0}")
	public void inputToBillingFirstAddressTextbox(String expectedAddress) {
		waitForElementVisibility(driver, CheckoutPageUI.FIRST_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.FIRST_ADDRESS_TEXTBOX, expectedAddress);
	}

	@Step("Input to 'Billing Zipcode' textbox with value is {0}")
	public void inputToBillingZipCodeTextbox(String expectedZipcode) {
		waitForElementVisibility(driver, CheckoutPageUI.ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.ZIPCODE_TEXTBOX, expectedZipcode);
	}

	@Step("Input to 'Billing Phone Number' textbox with value is {0}")
	public void inputToBillingPhoneNumberTextbox(String expectedPhoneNumber) {
		waitForElementVisibility(driver, CheckoutPageUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.PHONE_NUMBER_TEXTBOX, expectedPhoneNumber);
	}

	@Step("Click on 'Continue' button at Billing Address section")
	public void clickOnBillingAddressContinueButton() {
		waitForElementClickable(driver, CheckoutPageUI.BILLING_ADDRESS_CONTINUE_BUTTON);
		clickOnElement(driver, CheckoutPageUI.BILLING_ADDRESS_CONTINUE_BUTTON);
	}

	@Step("Choose 'State' base on Country")
	public String chooseStateBaseOnCountry(String expectedCountry) {
		if (expectedCountry.equals("United States")) {
			DataHelper dataHelp = new DataHelper();
			String state = dataHelp.getState();
			return state;
		} else {
			return "Other";
		}
	}

	@Step("Choose 'Shipping Method' radio button with value is {0}")
	public void selectShippingMethod(String expectedShippingMethod) {
		waitForElementVisibility(driver, CheckoutPageUI.DYNAMIC_SHIPPING_METHOD_RADIO_BUTTON, expectedShippingMethod);
		clickOnElement(driver, CheckoutPageUI.DYNAMIC_SHIPPING_METHOD_RADIO_BUTTON, expectedShippingMethod);
	}

	@Step("Choose 'Payment Method' radio button with value is {0}")
	public void clickOnPaymentMethod(String expectedPaymentMethod) {
		waitForElementVisibility(driver, CheckoutPageUI.DYNAMIC_PAYMENT_METHOD_RADIO_BUTTON, expectedPaymentMethod);
		clickOnElement(driver, CheckoutPageUI.DYNAMIC_PAYMENT_METHOD_RADIO_BUTTON, expectedPaymentMethod);
	}

	@Step("Click on 'Continue' button at Shipping Method section")
	public void clickOnShippingMethodContinueButton() {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_METHOD_CONTINUE_BUTTON);
		clickOnElement(driver, CheckoutPageUI.SHIPPING_METHOD_CONTINUE_BUTTON);
	}

	@Step("Click on 'Continue' button at Payment Method section")
	public void clickOnPaymentMethodContinueButton() {
		waitForElementVisibility(driver, CheckoutPageUI.PAYMENT_METHOD_CONTINUE_BUTTON);
		clickOnElement(driver, CheckoutPageUI.PAYMENT_METHOD_CONTINUE_BUTTON);
	}

	@Step("Get Payment Info message at Payment Info section")
	public String getPaymentInfoMessage() {
		waitForElementVisibility(driver, CheckoutPageUI.PAYMENT_INFO_MESSAGE);
		return getTextElement(driver, CheckoutPageUI.PAYMENT_INFO_MESSAGE);
	}

	@Step("Click on 'Continue' button at Payment Info section")
	public void clickOnContinueButton() {
		waitForElementVisibility(driver, CheckoutPageUI.PAYMENT_INFO_CONTINUE_BUTTON);
		clickOnElement(driver, CheckoutPageUI.PAYMENT_INFO_CONTINUE_BUTTON);
	}

	@Step("Get Billing Name value")
	public String getBillingNameValue() {
		waitForElementVisibility(driver, CheckoutPageUI.BILLING_NAME_VALUE);
		return getTextElement(driver, CheckoutPageUI.BILLING_NAME_VALUE);
	}

	@Step("Get Billing Email value")
	public String getBillingEmailValue() {
		waitForElementVisibility(driver, CheckoutPageUI.BILLING_EMAIL_VALUE);
		return getTextElement(driver, CheckoutPageUI.BILLING_EMAIL_VALUE);
	}

	@Step("Get Billing Phone Number value")
	public String getBillingPhoneNumberValue() {
		waitForElementVisibility(driver, CheckoutPageUI.BILLING_PHONE_NUMBER_VALUE);
		return getTextElement(driver, CheckoutPageUI.BILLING_PHONE_NUMBER_VALUE);
	}

	@Step("Get Billing First Address value")
	public String getBillingFirstAddressValue() {
		waitForElementVisibility(driver, CheckoutPageUI.BILLING_FIRST_ADDRESS_VALUE);
		return getTextElement(driver, CheckoutPageUI.BILLING_FIRST_ADDRESS_VALUE);
	}

	@Step("Get Billing City - State - Zipcode value")
	public String getBillingDetailedCityAddressValue() {
		waitForElementVisibility(driver, CheckoutPageUI.BILLING_DETAILED_CITY_ADDRESS_VALUE);
		return getTextElement(driver, CheckoutPageUI.BILLING_DETAILED_CITY_ADDRESS_VALUE);
	}

	@Step("Get Payment Method value")
	public String getPaymentMethodValue() {
		waitForElementVisibility(driver, CheckoutPageUI.BILLING_PAYMENT_METHOD_VALUE);
		return getTextElement(driver, CheckoutPageUI.BILLING_PAYMENT_METHOD_VALUE);
	}

	@Step("Handle the displaying city - state - zipcode format")
	public String getDetailedCityAddressValue(String expectedCity, String expectedState, String expectedZipcode) {
		String result = "";
		if (expectedState.equals("Other")) {
			result = expectedCity + "," + expectedZipcode;
		} else {
			result = expectedCity + "," + expectedState + "," + expectedZipcode;
		}
		return result;
	}

	@Step("Get Shipping Name value")
	public String getShippingNameValue() {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_NAME_VALUE);
		return getTextElement(driver, CheckoutPageUI.SHIPPING_NAME_VALUE);
	}

	@Step("Get Shipping Email value")
	public String getShippingEmailValue() {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_EMAIL_VALUE);
		return getTextElement(driver, CheckoutPageUI.SHIPPING_EMAIL_VALUE);
	}

	@Step("Get Shipping Phone Number value")
	public String getShippingPhoneNumberValue() {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_PHONE_NUMBER_VALUE);
		return getTextElement(driver, CheckoutPageUI.SHIPPING_PHONE_NUMBER_VALUE);
	}

	@Step("Get Shipping Address 1 value")
	public String getShippingFirstAddressValue() {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_FIRST_ADDRESS_VALUE);
		return getTextElement(driver, CheckoutPageUI.SHIPPING_FIRST_ADDRESS_VALUE);
	}

	@Step("Get Shipping City - State - Zipcode value")
	public String getShippingDetailedCityAddressValue() {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_DETAILED_CITY_ADDRESS_VALUE);
		return getTextElement(driver, CheckoutPageUI.SHIPPING_DETAILED_CITY_ADDRESS_VALUE);
	}

	@Step("Get Shipping Method value")
	public String getShippingMethodValue() {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_METHOD_VALUE);
		return getTextElement(driver, CheckoutPageUI.SHIPPING_METHOD_VALUE);
	}

	@Step("Get Billing Country value")
	public String getBillingCountryValue() {
		waitForElementVisibility(driver, CheckoutPageUI.BILLING_COUNTRY_VALUE);
		return getTextElement(driver, CheckoutPageUI.BILLING_COUNTRY_VALUE);
	}

	@Step("Get Shipping Country value")
	public String getShippingCountryValue() {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_COUNTRY_VALUE);
		return getTextElement(driver, CheckoutPageUI.SHIPPING_COUNTRY_VALUE);
	}

	@Step("Get Product SKU value")
	public String getProductSKUValue() {
		waitForElementVisibility(driver, CheckoutPageUI.PRODUCT_SKU_NUMBER_VALUE);
		return getTextElement(driver, CheckoutPageUI.PRODUCT_SKU_NUMBER_VALUE);
	}

	@Step("Verify product image is displayed")
	public boolean isProductImageDisplayed() {
		waitForElementVisibility(driver, CheckoutPageUI.PRODUCT_IMAGE);
		return checkImageLoadedAndDisplayed(driver, CheckoutPageUI.PRODUCT_IMAGE);
	}

	@Step("Get Product Name value")
	public String getProductNameValue() {
		waitForElementVisibility(driver, CheckoutPageUI.PRODUCT_NAME_VALUE);
		return getTextElement(driver, CheckoutPageUI.PRODUCT_NAME_VALUE);
	}

	@Step("Get Product Unit Price value")
	public String getProductUnitPriceValue() {
		waitForElementVisibility(driver, CheckoutPageUI.PRODUCT_UNIT_PRICE_VALUE);
		return getTextElement(driver, CheckoutPageUI.PRODUCT_UNIT_PRICE_VALUE);
	}

	@Step("Get Product Quantity value")
	public int getProductQuantityValue(String string) {
		waitForElementVisibility(driver, CheckoutPageUI.PRODUCT_QUANTITY_VALUE);
		return Integer.valueOf(getTextElement(driver, CheckoutPageUI.PRODUCT_QUANTITY_VALUE));
	}

	@Step("Get Product sub-total price")
	public String getProductSubTotalPriceValue() {
		waitForElementVisibility(driver, CheckoutPageUI.PRODUCT_SUB_TOTAL_PRICE_VALUE);
		return getTextElement(driver, CheckoutPageUI.PRODUCT_SUB_TOTAL_PRICE_VALUE);
	}

	@Step("Get Product Gift Wrapping value")
	public String getProductGiftWrappingValue() {
		waitForElementVisibility(driver, CheckoutPageUI.PRODUCT_GIFT_WRAPPING_VALUE);
		return getTextElement(driver, CheckoutPageUI.PRODUCT_GIFT_WRAPPING_VALUE);
	}

	@Step("Get Product Tax value")
	public String getProductTaxValue() {
		waitForElementVisibility(driver, CheckoutPageUI.PRODUCT_TAX_PRICE_VALUE);
		return getTextElement(driver, CheckoutPageUI.PRODUCT_TAX_PRICE_VALUE);
	}

	@Step("Get Product Shipping value")
	public String getProductShippingValue() {
		waitForElementVisibility(driver, CheckoutPageUI.PRODUCT_SHIPPING_PRICE_VALUE);
		return getTextElement(driver, CheckoutPageUI.PRODUCT_SHIPPING_PRICE_VALUE);
	}

	@Step("Get Product Total Price value")
	public String getProductTotalPriceValue() {
		waitForElementVisibility(driver, CheckoutPageUI.TOTAL_PRICE_VALUE);
		return getTextElement(driver, CheckoutPageUI.TOTAL_PRICE_VALUE);
	}

	@Step("Get Product Earning Point value")
	public String getProductEarningPointValue() {
		waitForElementVisibility(driver, CheckoutPageUI.PRODUCT_EARNING_POINT_VALUE);
		return getTextElement(driver, CheckoutPageUI.PRODUCT_EARNING_POINT_VALUE);
	}

	@Step("Click on 'Continue' button at Shipping Address section")
	public void selectShippingAddressInDropdownlist(String expectedCountry) {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_ADDRESS_DROPDOWNLIST);
		List<String> textArr = getAllTextElements(driver, CheckoutPageUI.SHIPPING_ADDRESS_OPTIONS_IN_DROPDOWNLIST);

		for (String text : textArr) {
			if (text.contains(expectedCountry)) {
				selectDefaultItemDropdownList(driver, CheckoutPageUI.SHIPPING_ADDRESS_DROPDOWNLIST, text);
				break;
			}
		}
		waitForElementPresence(driver, CheckoutPageUI.SHIPPING_EDIT_FORM);
	}

	@Step("Click on 'Continue' button at Shipping Address section")
	public void clickOnShippingAddressContinueButton() {
		waitForElementClickable(driver, CheckoutPageUI.SHIPPING_ADDRESS_CONTINUE_BUTTON);
		clickOnElement(driver, CheckoutPageUI.SHIPPING_ADDRESS_CONTINUE_BUTTON);
	}

	@Step("Click on 'Confirm' button at Confirm Order section and get Order Date")
	public String clickOnConfirmButton() {
		waitForElementClickable(driver, CheckoutPageUI.CONFIRM_ORDER_CONTINUE_BUTTON);
		clickOnElement(driver, CheckoutPageUI.CONFIRM_ORDER_CONTINUE_BUTTON);

		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		df.setTimeZone(cal.getTimeZone());
		return df.format(cal.getTime());
	}

	@Step("Verify Successful Order message is displayed")
	public boolean isOrderMessageSuccessDisplayed() {
		waitForElementVisibility(driver, CheckoutPageUI.SUCCESSFUL_ORDER_MESSAGE);
		return isElementDisplayed(driver, CheckoutPageUI.SUCCESSFUL_ORDER_MESSAGE);
	}

	@Step("Verify Order Number is displayed after ordering successfully")
	public boolean isOrderNumberDisplayed() {
		waitForElementVisibility(driver, CheckoutPageUI.SUCCESSFUL_ORDER_NUMBER);
		return isElementDisplayed(driver, CheckoutPageUI.SUCCESSFUL_ORDER_NUMBER);
	}

	@Step("Get Order Number")
	public String getOrderNumber() {
		waitForElementVisibility(driver, CheckoutPageUI.SUCCESSFUL_ORDER_NUMBER);
		return getTextElement(driver, CheckoutPageUI.SUCCESSFUL_ORDER_NUMBER);
	}

	@Step("Select 'Credit Card Type'")
	public void selectCreditCardType(String expectedCardType) {
		waitForElementVisibility(driver, CheckoutPageUI.CREDIT_CARD_TYPE_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, CheckoutPageUI.CREDIT_CARD_TYPE_DROPDOWNLIST, expectedCardType);
	}

	@Step("Input to 'Card Holder Name' textbox")
	public void inputToCardHolderNameTextbox(String expectedCardName) {
		waitForElementVisibility(driver, CheckoutPageUI.CARD_HOLDER_NAME_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.CARD_HOLDER_NAME_TEXTBOX, expectedCardName);
	}

	@Step("Input to 'Card Number' textbox")
	public void inputToCardNumberTextbox(String expectedCardNumber) {
		waitForElementVisibility(driver, CheckoutPageUI.CARD_NUMBER_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.CARD_NUMBER_TEXTBOX, expectedCardNumber);
	}

	@Step("Select 'Expiration Month' dropdownlist")
	public void selectExpirationMonthDropdownlist(String expectedExpirationMonth) {
		waitForElementVisibility(driver, CheckoutPageUI.EXPIRE_MONTH_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, CheckoutPageUI.EXPIRE_MONTH_DROPDOWNLIST, expectedExpirationMonth);
	}

	@Step("Select 'Expiration Year' dropdownlist")
	public void selectExpirationYearDropdownlist(String expectedExpirationYear) {
		waitForElementVisibility(driver, CheckoutPageUI.EXPIRE_YEAR_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, CheckoutPageUI.EXPIRE_YEAR_DROPDOWNLIST, expectedExpirationYear);
	}

	@Step("Input to 'Card Code' textbox")
	public void inputToCardCodeTextbox(String expectedCardCode) {
		waitForElementVisibility(driver, CheckoutPageUI.CARD_CODE_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.CARD_CODE_TEXTBOX, expectedCardCode);
	}

	@Step("Click On 'Continue' button")
	public void clickOnPaymentInfoContinueButton() {
		waitForElementClickable(driver, CheckoutPageUI.PAYMENT_CARD_CONTINUE_BUTTON);
		clickOnElement(driver, CheckoutPageUI.PAYMENT_CARD_CONTINUE_BUTTON);
	}

	@Step("Select Billing Address dropdownlist")
	public void selectBillindAddressInDropdownlist(String value) {
		waitForElementVisibility(driver, CheckoutPageUI.BILLING_ADDRESS_DROPDOWNLIST);
		List<String> textArr = getAllTextElements(driver, CheckoutPageUI.BILLING_ADDRESS_OPTIONS_IN_DROPDOWNLIST);

		for (String text : textArr) {
			if (text.contains(value)) {
				selectDefaultItemDropdownList(driver, CheckoutPageUI.BILLING_ADDRESS_DROPDOWNLIST, text);
				break;
			}
		}
		waitForElementPresence(driver, CheckoutPageUI.BILLING_EDIT_FORM);
	}

	@Step("Input to 'Shipping First Name' textbox")
	public void inputToShippingFirstNameTextbox(String expectedFirstName) {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.SHIPPING_FIRST_NAME_TEXTBOX, expectedFirstName);
	}

	@Step("Input to 'Shipping Last Name' textbox")
	public void inputToShippingLastNameTextbox(String expectedLastName) {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.SHIPPING_LAST_NAME_TEXTBOX, expectedLastName);
	}

	@Step("Input to 'Shipping Email' textbox")
	public void inputToShippingEmailTextbox(String expectedEmail) {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_EMAIL_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.SHIPPING_EMAIL_TEXTBOX, expectedEmail);
	}

	@Step("Input to 'Shipping Country' dropdownlist")
	public void selectShippingCountryDropdownlist(String expectedCountry) {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_COUNTRY_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, CheckoutPageUI.SHIPPING_COUNTRY_DROPDOWNLIST, expectedCountry);
		sleepInSecond(5);
	}

	@Step("Select 'Shipping State' dropdownlist")
	public void selectShippingStateDropdownlist(String expectedState) {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_STATE_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, CheckoutPageUI.SHIPPING_STATE_DROPDOWNLIST, expectedState);
	}

	@Step("Input to 'Shipping City' textbox ")
	public void inputToShippingCityTextbox(String expectedCity) {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_CITY_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.SHIPPING_CITY_TEXTBOX, expectedCity);
	}

	@Step("Input to 'Shipping First Address' textbox")
	public void inputToShippingFirstAddressTextbox(String expectedFirstAddress) {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_FIRST_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.SHIPPING_FIRST_ADDRESS_TEXTBOX, expectedFirstAddress);
	}

	@Step("Input to 'Shipping Zip Code' textbox")
	public void inputToShippingZipCodeTextbox(String expectedZipcode) {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_ZIP_CODE_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.SHIPPING_ZIP_CODE_TEXTBOX, expectedZipcode);
	}

	@Step("Input to 'Shipping Phone Number' textbox")
	public void inputToShippingPhoneNumberTextbox(String expectedPhoneNumber) {
		waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.SHIPPING_PHONE_NUMBER_TEXTBOX, expectedPhoneNumber);
	}

	@Step("Verify Checkout page is displayed successfully")
	public boolean isCheckoutPageDisplayedSuccessfully() {
		return isJQueryOrJSLoadedSuccess(driver);
	}

	@Step("Wait 30 seconds before clicking on 'Confirm' button")
	public void waitForClickOnConfirmButton() {
		sleepInSecond(GlobalConstants.LONG_TIMEOUT);
	}
}
