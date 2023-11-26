package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.AddressPageUI;

public class AddressPageObject extends BasePages {
	public AddressPageObject(WebDriver driver) {
		super(driver);
	}

	@Step("Click on 'Add New' button")
	public void clickOnAddNewAddressButton() {
		waitForElementClickable(AddressPageUI.ADD_ADDRESS_BUTTON);
		clickOnElement(AddressPageUI.ADD_ADDRESS_BUTTON);
	}

	@Step("Input to 'First Name' textbox with value is{0}")
	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisibility(AddressPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(AddressPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	@Step("Input to 'Last Name' textbox with value is {0}")
	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisibility(AddressPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(AddressPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	@Step("Input to 'Email' textbox with value is {0}")
	public void inputToEmailTextbox(String email) {
		waitForElementVisibility(AddressPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(AddressPageUI.EMAIL_TEXTBOX, email);
	}

	@Step("Input to 'Company' textbox with value is {0}")
	public void inputToCompanyTextbox(String companyName) {
		waitForElementVisibility(AddressPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(AddressPageUI.COMPANY_TEXTBOX, companyName);
	}

	@Step("Select 'Country' dropdownlist with value is {0}")
	public void selectCountryDropdownList(String expectedCountry) {
		waitForElementVisibility(AddressPageUI.COUNTRY_DROPDOWNLIST);
		selectDefaultItemDropdownList(AddressPageUI.COUNTRY_DROPDOWNLIST, expectedCountry);
	}

	@Step("Select 'State/Province' dropdownlist with value is {0}")
	public void selectStateDropdownList(String expectedState) {
		waitForElementVisibility(AddressPageUI.STATE_DROPDOWNLIST);
		selectDefaultItemDropdownList(AddressPageUI.STATE_DROPDOWNLIST, expectedState);
	}

	@Step("Input to 'City' textbox with value is {0}")
	public void inputToCityTextbox(String expectedCity) {
		waitForElementVisibility(AddressPageUI.CITY_TEXTBOX);
		sendkeyToElement(AddressPageUI.CITY_TEXTBOX, expectedCity);
	}

	@Step("Input to 'Address 1' textbox with value is {0}")
	public void inputToAddressITextbox(String expectedFirstAddress) {
		waitForElementVisibility(AddressPageUI.FIRST_ADDRESS_TEXTBOX);
		sendkeyToElement(AddressPageUI.FIRST_ADDRESS_TEXTBOX, expectedFirstAddress);
	}

	@Step("Input to 'Address 2' textbox with value is {0}")
	public void inputToAddressIITextbox(String expectedSecondAddress) {
		waitForElementVisibility(AddressPageUI.SECOND_ADDRESS_TEXTBOX);
		sendkeyToElement(AddressPageUI.SECOND_ADDRESS_TEXTBOX, expectedSecondAddress);
	}

	@Step("Input to 'Zip/Postal Code' textbox with value is {0}")
	public void inputToZipCodeTextbox(String zipCode) {
		waitForElementVisibility(AddressPageUI.ZIPCODE_TEXTBOX);
		sendkeyToElement(AddressPageUI.ZIPCODE_TEXTBOX, zipCode);
	}

	@Step("Input to 'Phone Number' textbox with value is {0}")
	public void inputToPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisibility(AddressPageUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(AddressPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	@Step("Input to 'Fax Number' textbox with value is {0}")
	public void inputToFaxNumberTextbox(String faxNumber) {
		waitForElementVisibility(AddressPageUI.FAX_NUMBER_TEXTBOX);
		sendkeyToElement(AddressPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
	}

	@Step("Click on 'Save' button")
	public void clickOnSaveButton() {
		waitForElementClickable(AddressPageUI.SAVE_BUTTON);
		clickOnElement(AddressPageUI.SAVE_BUTTON);
	}

	@Step("Verify Notification Success Bar is displayed")
	public String getBarNotificationSuccessMessage() {
		waitForElementVisibility(AddressPageUI.NOTIFICATION_SUCCESS_MESSAGE);
		return getTextElement(AddressPageUI.NOTIFICATION_SUCCESS_MESSAGE);
	}

	@Step("Click on Close icon on Notification Success Bar")
	public void clickOnCloseButtonInBar() {
		waitForElementClickable(AddressPageUI.BAR_CLOSE_BUTTON);
		clickOnElement(AddressPageUI.BAR_CLOSE_BUTTON);
	}

	@Step("Get Name value")
	public String getNameValue() {
		waitForElementVisibility(AddressPageUI.NAME_TEXT);
		return getTextElement(AddressPageUI.NAME_TEXT);
	}

	@Step("Get Title Name")
	public String getTitleName() {
		waitForElementVisibility(AddressPageUI.NAME_TITLE);
		return getTextElement(AddressPageUI.NAME_TITLE);
	}

	@Step("Get Email value")
	public String getEmailValue() {
		waitForElementVisibility(AddressPageUI.EMAIL_TEXT);
		return getTextElement(AddressPageUI.EMAIL_TEXT);
	}

	@Step("Get Phone Number value")
	public String getPhoneNumberValue() {
		waitForElementVisibility(AddressPageUI.PHONE_NUMBER_TEXT);
		return getTextElement(AddressPageUI.PHONE_NUMBER_TEXT);
	}

	@Step("Get Fax Number value")
	public String getFaxNumberValue() {
		waitForElementVisibility(AddressPageUI.FAX_NUMBER_TEXT);
		return getTextElement(AddressPageUI.FAX_NUMBER_TEXT);
	}

	@Step("Get Address 1 value")
	public String getFirstAddressValue() {
		waitForElementVisibility(AddressPageUI.ADDRESS_I_TEXT);
		return getTextElement(AddressPageUI.ADDRESS_I_TEXT);
	}

	@Step("Get Address 2 value")
	public String getSecondAddressValue() {
		waitForElementVisibility(AddressPageUI.ADDRESS_II_TEXT);
		return getTextElement(AddressPageUI.ADDRESS_II_TEXT);
	}

	@Step("Get City value")
	public String getCityValue() {
		waitForElementVisibility(AddressPageUI.CITY_STATE_ZIPCODE_TEXT);
		return getTextElement(AddressPageUI.CITY_STATE_ZIPCODE_TEXT);
	}

	@Step("Get State value")
	public boolean getStateValue(String state) {
		waitForElementVisibility(AddressPageUI.CITY_STATE_ZIPCODE_TEXT);
		boolean flag = false;
		if (!state.equals("Other")) {
			if (getTextElement(AddressPageUI.CITY_STATE_ZIPCODE_TEXT).contains(state)) {
				flag = true;
			}
		}
		return flag;
	}

	@Step("Get Zip/Postal Code value")
	public String getZipCodeValue() {
		waitForElementVisibility(AddressPageUI.CITY_STATE_ZIPCODE_TEXT);
		return getTextElement(AddressPageUI.CITY_STATE_ZIPCODE_TEXT);
	}

	@Step("Get Country value")
	public String getcountryValue() {
		waitForElementVisibility(AddressPageUI.COUNTRY_TEXT);
		return getTextElement(AddressPageUI.COUNTRY_TEXT);
	}

	@Step("Get Company value")
	public String getCompanyValue() {
		waitForElementVisibility(AddressPageUI.COMPANY_TEXT);
		return getTextElement(AddressPageUI.COMPANY_TEXT);
	}

	@Step("Get Address Page url")
	public String getAddressPageURL() {
		return getCurrentURL();
	}

	@Step("Open Address Page by URL")
	public void openAddressPageByURL(String pageURL) {
		openPageURL(pageURL);
	}

}
