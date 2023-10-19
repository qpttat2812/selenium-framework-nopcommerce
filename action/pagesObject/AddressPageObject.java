package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import pagesUI.user.AddressPageUI;

public class AddressPageObject extends BasePages {
	private WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAddNewAddressButton() {
		waitForElementClickable(driver, AddressPageUI.ADD_ADDRESS_BUTTON);
		clickOnElement(driver, AddressPageUI.ADD_ADDRESS_BUTTON);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisibility(driver, AddressPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisibility(driver, AddressPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisibility(driver, AddressPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToCompanyTextbox(String companyName) {
		waitForElementVisibility(driver, AddressPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.COMPANY_TEXTBOX, companyName);
	}

	public void selectCountryDropdownList(String expectedCountry) {
		waitForElementVisibility(driver, AddressPageUI.COUNTRY_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, AddressPageUI.COUNTRY_DROPDOWNLIST, expectedCountry);
	}

	public void selectStateDropdownList(String expectedState) {
		waitForElementVisibility(driver, AddressPageUI.STATE_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, AddressPageUI.STATE_DROPDOWNLIST, expectedState);
	}

	public void inputToCityTextbox(String city) {
		waitForElementVisibility(driver, AddressPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.CITY_TEXTBOX, city);
	}

	public void inputToAddreessITextbox(String address1) {
		waitForElementVisibility(driver, AddressPageUI.ADDRESS_I_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.ADDRESS_I_TEXTBOX, address1);
	}

	public void inputToAddressIITextbox(String address2) {
		waitForElementVisibility(driver, AddressPageUI.ADDRESS_II_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.ADDRESS_II_TEXTBOX, address2);
	}

	public void inputToZipCodeTextbox(String zipCode) {
		waitForElementVisibility(driver, AddressPageUI.ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.ZIPCODE_TEXTBOX, zipCode);
	}

	public void inputToPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisibility(driver, AddressPageUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void inputToFaxNumberTextbox(String faxNumber) {
		waitForElementVisibility(driver, AddressPageUI.FAX_NUMBER_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
	}

	public void clickOnSaveButoon() {
		waitForElementClickable(driver, AddressPageUI.SAVE_BUTTON);
		clickOnElement(driver, AddressPageUI.SAVE_BUTTON);
	}

	public boolean isNotificationSuccessDisplayed() {
		waitForElementVisibility(driver, AddressPageUI.NOTIFICATION_SUCCESS_TEXT);
		return isElementDisplayed(driver, AddressPageUI.NOTIFICATION_SUCCESS_TEXT);
	}

	public void clickOnCloseButton() {
		waitForElementVisibility(driver, AddressPageUI.CLOSE_BUTTON);
		clickOnElement(driver, AddressPageUI.CLOSE_BUTTON);
		waitForElementInvisibility(driver, AddressPageUI.CLOSE_BUTTON);
	}

	public String getNameText() {
		waitForElementVisibility(driver, AddressPageUI.NAME_TEXT);
		return getTextElement(driver, AddressPageUI.NAME_TEXT);
	}

	public String getNameTitle() {
		waitForElementVisibility(driver, AddressPageUI.NAME_TITLE);
		return getTextElement(driver, AddressPageUI.NAME_TITLE);
	}

	public String getEmailText() {
		waitForElementVisibility(driver, AddressPageUI.EMAIL_TEXT);
		return getTextElement(driver, AddressPageUI.EMAIL_TEXT);
	}

	public String getPhoneNumberText() {
		waitForElementVisibility(driver, AddressPageUI.PHONE_NUMBER_TEXT);
		return getTextElement(driver, AddressPageUI.PHONE_NUMBER_TEXT);
	}

	public String getFaxNumberText() {
		waitForElementVisibility(driver, AddressPageUI.FAX_NUMBER_TEXT);
		return getTextElement(driver, AddressPageUI.FAX_NUMBER_TEXT);
	}

	public String getAddressIText() {
		waitForElementVisibility(driver, AddressPageUI.ADDRESS_I_TEXT);
		return getTextElement(driver, AddressPageUI.ADDRESS_I_TEXT);
	}

	public String getAddressIIText() {
		waitForElementVisibility(driver, AddressPageUI.ADDRESS_II_TEXT);
		return getTextElement(driver, AddressPageUI.ADDRESS_II_TEXT);
	}

	public String getCityText() {
		waitForElementVisibility(driver, AddressPageUI.CITY_STATE_ZIPCODE_TEXT);
		return getTextElement(driver, AddressPageUI.CITY_STATE_ZIPCODE_TEXT);
	}

	public boolean getStateText(String state) {
		waitForElementVisibility(driver, AddressPageUI.CITY_STATE_ZIPCODE_TEXT);
		boolean flag = false;
		if (!state.equals("Other")) {
			if(getTextElement(driver, AddressPageUI.CITY_STATE_ZIPCODE_TEXT).contains(state)) {
				flag = true;
			}
		}
		return flag;
	}

	public String getZipCodeText() {
		waitForElementVisibility(driver, AddressPageUI.CITY_STATE_ZIPCODE_TEXT);
		return getTextElement(driver, AddressPageUI.CITY_STATE_ZIPCODE_TEXT);
	}

	public String getcountryText() {
		waitForElementVisibility(driver, AddressPageUI.COUNTRY_TEXT);
		return getTextElement(driver, AddressPageUI.COUNTRY_TEXT);
	}

	public String getCompanyText() {
		waitForElementVisibility(driver, AddressPageUI.COMPANY_TEXT);
		return getTextElement(driver, AddressPageUI.COMPANY_TEXT);
	}
}
