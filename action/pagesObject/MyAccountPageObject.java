package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.MyAccountPageUI;

public class MyAccountPageObject extends BasePages{
	private WebDriver driver;
	
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Select 'Gender' radio button with value is {0}")
	public void selectGenderRadioButton(String expectedGender) {
		waitForElementVisibility(driver, MyAccountPageUI.FEMALE_GENDER_RADIO_BUTTON, expectedGender);
		clickOnRadioButton(driver, MyAccountPageUI.FEMALE_GENDER_RADIO_BUTTON, expectedGender);
	}
	
	@Step("Update 'First Name' textbox with value is {0}")
	public void updateFirstNameTextbox(String firstName) {
		waitForElementVisibility(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	
	@Step("Update 'Last Name' textbox with value is {0}")
	public void updateLastNameTextbox(String lastName) {
		waitForElementVisibility(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	
	@Step("Select 'Day Of Birth' dropdownlist with value is {0}")
	public void updateDayOfBirthDropdownList(String expectedDay) {
		waitForElementVisibility(driver, MyAccountPageUI.DAY_OF_BIRTH_DROPDOWNLIST);
		selectDefaultItemInDropdownList(driver, MyAccountPageUI.DAY_OF_BIRTH_DROPDOWNLIST, expectedDay);
	}
	
	@Step("Select 'Month Of Birth' dropdownlist with value is {0}")
	public void updateMonthOfBirthDropdownList(String expectedMonth) {
		waitForElementVisibility(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWNLIST);
		selectDefaultItemInDropdownList(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWNLIST, expectedMonth);
	}
	
	@Step("Update 'Year Of Birth' dropdownlist with value is {0}")
	public void updateYearOfBirthDropdownList(String expectedYear) {
		waitForElementVisibility(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWNLIST);
		selectDefaultItemInDropdownList(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWNLIST, expectedYear);
	}
	
	@Step("Update 'Email' textbox with value is {0}")
	public void updateEmailTextbox(String email) {
		waitForElementVisibility(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, email);
	}
	
	@Step("Update 'Company Name' textbox with value is {0}")
	public void updateCompanyNameTextbox(String companyName) {
		waitForElementVisibility(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}
	
	@Step("Click on 'Save' button")
	public void clickOnSaveButton() {
		waitForElementClickable(driver, MyAccountPageUI.SAVE_BUTTON);
		clickOnElement(driver, MyAccountPageUI.SAVE_BUTTON);
	}

	@Step("Get Notification Success Bar message")
	public String getBarNotificationSuccessMessage() {
		waitForElementVisibility(driver, MyAccountPageUI.BAR_NOTIFICATION_SUCCESS_MESSAGE);
		return getTextElement(driver, MyAccountPageUI.BAR_NOTIFICATION_SUCCESS_MESSAGE);
	}
	
	@Step("Verify Notification Success Bar is displayed")
	public void clickOnCloseButton() {
		waitForElementClickable(driver, MyAccountPageUI.BAR_CLOSE_BUTTON);
		clickOnElement(driver, MyAccountPageUI.BAR_CLOSE_BUTTON);
		waitForElementInvisibility(driver, MyAccountPageUI.BAR_CLOSE_BUTTON);
	}

	@Step("Get Gender value")
	public String getGenderValue(String value, String gender) {
		waitForElementVisibility(driver, MyAccountPageUI.FEMALE_GENDER_RADIO_BUTTON, gender);
		return getAttributeValue(driver, MyAccountPageUI.FEMALE_GENDER_RADIO_BUTTON, value, gender);
	}
	
	@Step("Get First Name value")
	public String getFirstNameValue(String value) {
		waitForElementVisibility(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, value);
	}
	
	@Step("Get Last Name value")
	public String getLastNameValue(String value) {
		waitForElementVisibility(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, value);
	}
	
	@Step("Get Day Of Birth value")
	public String getDayOfBirthValue() {
		waitForElementVisibility(driver, MyAccountPageUI.DAY_OF_BIRTH_DROPDOWNLIST);
		return getFirstSelectedItemInDropdown(driver, MyAccountPageUI.DAY_OF_BIRTH_DROPDOWNLIST);
	}
	
	@Step("Get Month Of Birth value")
	public String getMonthOfBirthValue() {
		waitForElementVisibility(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWNLIST);
		return getFirstSelectedItemInDropdown(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWNLIST);
	}
	
	@Step("Get Year Of Birth value")
	public String getYearOfBirthValue() {
		waitForElementVisibility(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWNLIST);
		return getFirstSelectedItemInDropdown(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWNLIST);
	}
	
	@Step("Get Email value")
	public String getEmailValue(String value) {
		waitForElementVisibility(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.EMAIL_TEXTBOX, value);
	}
	
	@Step("Get Company Name value")
	public String getCompanyNameValue(String value) {
		waitForElementVisibility(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX, value);
	}
}
