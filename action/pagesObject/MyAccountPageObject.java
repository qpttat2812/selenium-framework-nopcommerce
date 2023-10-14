package pagesObject;

import org.openqa.selenium.WebDriver;

import common.BasePages;
import pagesUI.user.MyAccountPageUI;

public class MyAccountPageObject extends BasePages{
	private WebDriver driver;
	
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectGenderRadioButton() {
		waitForElementVisibility(driver, MyAccountPageUI.FEMALE_GENDER);
		clickOnRadioButton(driver, MyAccountPageUI.FEMALE_GENDER);
	}
	
	public void updateFirstNameTextbox(String firstName) {
		waitForElementVisibility(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	
	public void updateLastNameTextbox(String lastName) {
		waitForElementVisibility(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	
	public void updateDayOfBirthDropdownList(String expectedDay) {
		waitForElementVisibility(driver, MyAccountPageUI.DAY_OF_BIRTH_DROPDOWNLIST);
		selectDefaultItemInDropdownList(driver, MyAccountPageUI.DAY_OF_BIRTH_DROPDOWNLIST, expectedDay);
	}
	
	public void updateMonthOfBirthDropdownList(String expectedMonth) {
		waitForElementVisibility(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWNLIST);
		selectDefaultItemInDropdownList(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWNLIST, expectedMonth);
	}
	
	public void updateYearOfBirthDropdownList(String expectedYear) {
		waitForElementVisibility(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWNLIST);
		selectDefaultItemInDropdownList(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWNLIST, expectedYear);
	}
	
	public void updateEmailTextbox(String email) {
		waitForElementVisibility(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void updateCompanyNameTextbox(String companyName) {
		waitForElementVisibility(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}
	
	public void clickOnSaveButton() {
		waitForElementVisibility(driver, MyAccountPageUI.SAVE_BUTTON);
		clickOnRadioButton(driver, MyAccountPageUI.SAVE_BUTTON);
	}

	public boolean isNotificationSuccessDisplayed() {
		waitForElementVisibility(driver, MyAccountPageUI.NOTIFICATION_SUCCESS_TEXT);
		return isElementDisplayed(driver, MyAccountPageUI.NOTIFICATION_SUCCESS_TEXT);
	}
	
	public void closeNotificationSuccessDisplayed() {
		waitForElementVisibility(driver, MyAccountPageUI.CLOSE_NOTIFICATION_SUCCESS_BUTTON);
		clickOnElement(driver, MyAccountPageUI.CLOSE_NOTIFICATION_SUCCESS_BUTTON);
	}

	public String getGenderValue(String value) {
		waitForElementVisibility(driver, MyAccountPageUI.FEMALE_GENDER);
		return getAttributeValue(driver, MyAccountPageUI.FEMALE_GENDER, value);
	}
	
	public String getFirstNameValue(String value) {
		waitForElementVisibility(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, value);
	}
	
	public String getLastNameValue(String value) {
		waitForElementVisibility(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, value);
	}
	
	public String getDayOfBirthValue() {
		waitForElementVisibility(driver, MyAccountPageUI.DAY_OF_BIRTH_DROPDOWNLIST);
		return getFirstSelectedItemInDropdown(driver, MyAccountPageUI.DAY_OF_BIRTH_DROPDOWNLIST);
	}
	
	public String getMonthOfBirthValue() {
		waitForElementVisibility(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWNLIST);
		return getFirstSelectedItemInDropdown(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWNLIST);
	}
	
	public String getYearOfBirthValue() {
		waitForElementVisibility(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWNLIST);
		return getFirstSelectedItemInDropdown(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWNLIST);
	}
	
	public String getEmailValue(String value) {
		waitForElementVisibility(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.EMAIL_TEXTBOX, value);
	}
	
	public String getCompanyNameValue(String value) {
		waitForElementVisibility(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX, value);
	}
}
