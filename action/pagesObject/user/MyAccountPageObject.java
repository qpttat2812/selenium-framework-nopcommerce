package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.MyAccountPageUI;

public class MyAccountPageObject extends BasePages{
	public MyAccountPageObject(WebDriver driver) {
		super(driver);
	}
	
	@Step("Select 'Gender' radio button with value is {0}")
	public void selectGenderRadioButton(String expectedGender) {
		waitForElementVisibility(MyAccountPageUI.FEMALE_GENDER_RADIO_BUTTON, expectedGender);
		clickOnRadioButton(MyAccountPageUI.FEMALE_GENDER_RADIO_BUTTON, expectedGender);
	}
	
	@Step("Update 'First Name' textbox with value is {0}")
	public void updateFirstNameTextbox(String firstName) {
		waitForElementVisibility(MyAccountPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(MyAccountPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	
	@Step("Update 'Last Name' textbox with value is {0}")
	public void updateLastNameTextbox(String lastName) {
		waitForElementVisibility(MyAccountPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(MyAccountPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	
	@Step("Select 'Day Of Birth' dropdownlist with value is {0}")
	public void updateDayOfBirthDropdownList(String expectedDay) {
		waitForElementVisibility(MyAccountPageUI.DAY_OF_BIRTH_DROPDOWNLIST);
		selectDefaultItemInDropdownList(MyAccountPageUI.DAY_OF_BIRTH_DROPDOWNLIST, expectedDay);
	}
	
	@Step("Select 'Month Of Birth' dropdownlist with value is {0}")
	public void updateMonthOfBirthDropdownList(String expectedMonth) {
		waitForElementVisibility(MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWNLIST);
		selectDefaultItemInDropdownList(MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWNLIST, expectedMonth);
	}
	
	@Step("Update 'Year Of Birth' dropdownlist with value is {0}")
	public void updateYearOfBirthDropdownList(String expectedYear) {
		waitForElementVisibility(MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWNLIST);
		selectDefaultItemInDropdownList(MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWNLIST, expectedYear);
	}
	
	@Step("Update 'Email' textbox with value is {0}")
	public void updateEmailTextbox(String email) {
		waitForElementVisibility(MyAccountPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(MyAccountPageUI.EMAIL_TEXTBOX, email);
	}
	
	@Step("Update 'Company Name' textbox with value is {0}")
	public void updateCompanyNameTextbox(String companyName) {
		waitForElementVisibility(MyAccountPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(MyAccountPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}
	
	@Step("Click on 'Save' button")
	public void clickOnSaveButton() {
		waitForElementClickable(MyAccountPageUI.SAVE_BUTTON);
		clickOnElement(MyAccountPageUI.SAVE_BUTTON);
	}

	@Step("Get Notification Success Bar message")
	public String getBarNotificationSuccessMessage() {
		waitForElementVisibility(MyAccountPageUI.BAR_NOTIFICATION_SUCCESS_MESSAGE);
		return getTextElement(MyAccountPageUI.BAR_NOTIFICATION_SUCCESS_MESSAGE);
	}
	
	@Step("Verify Notification Success Bar is displayed")
	public void clickOnCloseButton() {
		waitForElementClickable(MyAccountPageUI.BAR_CLOSE_BUTTON);
		clickOnElement(MyAccountPageUI.BAR_CLOSE_BUTTON);
	}

	@Step("Get Gender value")
	public String getGenderValue(String value, String gender) {
		waitForElementVisibility(MyAccountPageUI.FEMALE_GENDER_RADIO_BUTTON, gender);
		return getAttributeValue(MyAccountPageUI.FEMALE_GENDER_RADIO_BUTTON, value, gender);
	}
	
	@Step("Get First Name value")
	public String getFirstNameValue(String value) {
		waitForElementVisibility(MyAccountPageUI.FIRST_NAME_TEXTBOX);
		return getAttributeValue(MyAccountPageUI.FIRST_NAME_TEXTBOX, value);
	}
	
	@Step("Get Last Name value")
	public String getLastNameValue(String value) {
		waitForElementVisibility(MyAccountPageUI.LAST_NAME_TEXTBOX);
		return getAttributeValue(MyAccountPageUI.LAST_NAME_TEXTBOX, value);
	}
	
	@Step("Get Day Of Birth value")
	public String getDayOfBirthValue() {
		waitForElementVisibility(MyAccountPageUI.DAY_OF_BIRTH_DROPDOWNLIST);
		return getFirstSelectedItemInDropdown(MyAccountPageUI.DAY_OF_BIRTH_DROPDOWNLIST);
	}
	
	@Step("Get Month Of Birth value")
	public String getMonthOfBirthValue() {
		waitForElementVisibility(MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWNLIST);
		return getFirstSelectedItemInDropdown(MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWNLIST);
	}
	
	@Step("Get Year Of Birth value")
	public String getYearOfBirthValue() {
		waitForElementVisibility(MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWNLIST);
		return getFirstSelectedItemInDropdown(MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWNLIST);
	}
	
	@Step("Get Email value")
	public String getEmailValue(String value) {
		waitForElementVisibility(MyAccountPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(MyAccountPageUI.EMAIL_TEXTBOX, value);
	}
	
	@Step("Get Company Name value")
	public String getCompanyNameValue(String value) {
		waitForElementVisibility(MyAccountPageUI.COMPANY_NAME_TEXTBOX);
		return getAttributeValue(MyAccountPageUI.COMPANY_NAME_TEXTBOX, value);
	}

	@Step("Get customer info page url")
	public String getCustomerInfoPageURL() {
		return getCurrentURL();
	}

	@Step("Open Customer Info page by URL")
	public void openCustomerInfoPageByURL(String pageURL) {
		openPageURL(pageURL);
	}
}
