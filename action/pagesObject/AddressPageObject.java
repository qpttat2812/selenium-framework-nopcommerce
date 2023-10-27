package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.AddressPageUI;

public class AddressPageObject extends BasePages {
	private WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click on ADD NEW button")
	public void clickOnAddNewAddressButton() {
		waitForElementClickable(driver, AddressPageUI.ADD_ADDRESS_BUTTON);
		clickOnElement(driver, AddressPageUI.ADD_ADDRESS_BUTTON);
	}
	
	@Step("Input to First name textbox with value {0}")
	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisibility(driver, AddressPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	@Step("Input to Last name textbox with value {0}")
	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisibility(driver, AddressPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	@Step("Input to Email textbox with value {0}")
	public void inputToEmailTextbox(String email) {
		waitForElementVisibility(driver, AddressPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.EMAIL_TEXTBOX, email);
	}

	@Step("Input to Company textbox with value {0}")
	public void inputToCompanyTextbox(String companyName) {
		waitForElementVisibility(driver, AddressPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.COMPANY_TEXTBOX, companyName);
	}

	@Step("Select Country dropdownlist with value {0}")
	public void selectCountryDropdownList(String expectedCountry) {
		waitForElementVisibility(driver, AddressPageUI.COUNTRY_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, AddressPageUI.COUNTRY_DROPDOWNLIST, expectedCountry);
	}

	@Step("Select State/province dropdownlist with value {0}")
	public void selectStateDropdownList(String expectedState) {
		waitForElementVisibility(driver, AddressPageUI.STATE_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, AddressPageUI.STATE_DROPDOWNLIST, expectedState);
	}

	@Step("Input to City textbox with value {0}")
	public void inputToCityTextbox(String city) {
		waitForElementVisibility(driver, AddressPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.CITY_TEXTBOX, city);
	}

	@Step("Input to Address 1 textbox with value {0}")
	public void inputToAddressITextbox(String address1) {
		waitForElementVisibility(driver, AddressPageUI.ADDRESS_I_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.ADDRESS_I_TEXTBOX, address1);
	}

	@Step("Input to Address 2 textbox with value {0}")
	public void inputToAddressIITextbox(String address2) {
		waitForElementVisibility(driver, AddressPageUI.ADDRESS_II_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.ADDRESS_II_TEXTBOX, address2);
	}

	@Step("Input to Zip/postal code textbox with value {0}")
	public void inputToZipCodeTextbox(String zipCode) {
		waitForElementVisibility(driver, AddressPageUI.ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.ZIPCODE_TEXTBOX, zipCode);
	}

	@Step("Input to Phone number textbox with value {0}")
	public void inputToPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisibility(driver, AddressPageUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	@Step("Input to Fax number textbox with value {0}")
	public void inputToFaxNumberTextbox(String faxNumber) {
		waitForElementVisibility(driver, AddressPageUI.FAX_NUMBER_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
	}

	@Step("Click on SAVE button")
	public void clickOnSaveButton() {
		waitForElementClickable(driver, AddressPageUI.SAVE_BUTTON);
		clickOnElement(driver, AddressPageUI.SAVE_BUTTON);
	}

	@Step("Verify Notification Success Bar is displayed")
	public boolean isBarNotificationSuccessDisplayed() {
		waitForElementVisibility(driver, AddressPageUI.NOTIFICATION_SUCCESS_TEXT);
		return isElementDisplayed(driver, AddressPageUI.NOTIFICATION_SUCCESS_TEXT);
	}

	@Step("Click on Close icon on Notification Success Bar")
	public void clickOnCloseButton() {
		waitForElementClickable(driver, AddressPageUI.BAR_CLOSE_BUTTON);
		clickOnElement(driver, AddressPageUI.BAR_CLOSE_BUTTON);
		waitForElementInvisibility(driver, AddressPageUI.BAR_CLOSE_BUTTON);
	}

	@Step("Get Name value")
	public String getNameText() {
		waitForElementVisibility(driver, AddressPageUI.NAME_TEXT);
		return getTextElement(driver, AddressPageUI.NAME_TEXT);
	}

	@Step("Get Name value at Title Position")
	public String getNameTitle() {
		waitForElementVisibility(driver, AddressPageUI.NAME_TITLE);
		return getTextElement(driver, AddressPageUI.NAME_TITLE);
	}

	@Step("Get Email value")
	public String getEmailText() {
		waitForElementVisibility(driver, AddressPageUI.EMAIL_TEXT);
		return getTextElement(driver, AddressPageUI.EMAIL_TEXT);
	}

	@Step("Get Phone number value")
	public String getPhoneNumberText() {
		waitForElementVisibility(driver, AddressPageUI.PHONE_NUMBER_TEXT);
		return getTextElement(driver, AddressPageUI.PHONE_NUMBER_TEXT);
	}

	@Step("Get Fax number value")
	public String getFaxNumberText() {
		waitForElementVisibility(driver, AddressPageUI.FAX_NUMBER_TEXT);
		return getTextElement(driver, AddressPageUI.FAX_NUMBER_TEXT);
	}

	@Step("Get Address 1 value")
	public String getAddressIText() {
		waitForElementVisibility(driver, AddressPageUI.ADDRESS_I_TEXT);
		return getTextElement(driver, AddressPageUI.ADDRESS_I_TEXT);
	}

	@Step("Get Address 2 value")
	public String getAddressIIText() {
		waitForElementVisibility(driver, AddressPageUI.ADDRESS_II_TEXT);
		return getTextElement(driver, AddressPageUI.ADDRESS_II_TEXT);
	}

	@Step("Get City value")
	public String getCityText() {
		waitForElementVisibility(driver, AddressPageUI.CITY_STATE_ZIPCODE_TEXT);
		return getTextElement(driver, AddressPageUI.CITY_STATE_ZIPCODE_TEXT);
	}

	@Step("Get State value")
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

	@Step("Get Zip/postal code value")
	public String getZipCodeText() {
		waitForElementVisibility(driver, AddressPageUI.CITY_STATE_ZIPCODE_TEXT);
		return getTextElement(driver, AddressPageUI.CITY_STATE_ZIPCODE_TEXT);
	}
	
	@Step("Get Country value")
	public String getcountryText() {
		waitForElementVisibility(driver, AddressPageUI.COUNTRY_TEXT);
		return getTextElement(driver, AddressPageUI.COUNTRY_TEXT);
	}

	@Step("Get Company value")
	public String getCompanyText() {
		waitForElementVisibility(driver, AddressPageUI.COMPANY_TEXT);
		return getTextElement(driver, AddressPageUI.COMPANY_TEXT);
	}
}
