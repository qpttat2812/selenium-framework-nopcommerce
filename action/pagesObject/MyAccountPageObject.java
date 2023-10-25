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
	
	@Step("Select Gender radio button with Female value")
	public void selectGenderRadioButton() {
		waitForElementVisibility(driver, MyAccountPageUI.FEMALE_GENDER);
		clickOnRadioButton(driver, MyAccountPageUI.FEMALE_GENDER);
	}
	
	@Step("Update First name textbox with value {0}")
	public void updateFirstNameTextbox(String firstName) {
		waitForElementVisibility(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	
	@Step("Update Last name textbox with value {0}")
	public void updateLastNameTextbox(String lastName) {
		waitForElementVisibility(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	
	@Step("Select Day of birth dropdownlist with value {0}")
	public void updateDayOfBirthDropdownList(String expectedDay) {
		waitForElementVisibility(driver, MyAccountPageUI.DAY_OF_BIRTH_DROPDOWNLIST);
		selectDefaultItemInDropdownList(driver, MyAccountPageUI.DAY_OF_BIRTH_DROPDOWNLIST, expectedDay);
	}
	
	@Step("Select Month of birth dropdownlist with value {0}")
	public void updateMonthOfBirthDropdownList(String expectedMonth) {
		waitForElementVisibility(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWNLIST);
		selectDefaultItemInDropdownList(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWNLIST, expectedMonth);
	}
	
	@Step("Update Year of birth dropdownlist with value {0}")
	public void updateYearOfBirthDropdownList(String expectedYear) {
		waitForElementVisibility(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWNLIST);
		selectDefaultItemInDropdownList(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWNLIST, expectedYear);
	}
	
	@Step("Update Last name textbox with value {0}")
	public void updateEmailTextbox(String email) {
		waitForElementVisibility(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, email);
	}
	
	@Step("Update Company name textbox with value {0}")
	public void updateCompanyNameTextbox(String companyName) {
		waitForElementVisibility(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}
	
	@Step("Click on Save button")
	public void clickOnSaveButton() {
		waitForElementVisibility(driver, MyAccountPageUI.SAVE_BUTTON);
		clickOnRadioButton(driver, MyAccountPageUI.SAVE_BUTTON);
	}

	@Step("Verify Notification Success Bar is displayed")
	public boolean isNotificationSuccessBarDisplayed() {
		waitForElementVisibility(driver, MyAccountPageUI.NOTIFICATION_SUCCESS_TEXT);
		return isElementDisplayed(driver, MyAccountPageUI.NOTIFICATION_SUCCESS_TEXT);
	}
	
	@Step("Verify Notification Success Bar is displayed")
	public void closeNotificationSuccessBar() {
		waitForElementVisibility(driver, MyAccountPageUI.CLOSE_NOTIFICATION_SUCCESS_BUTTON);
		clickOnElement(driver, MyAccountPageUI.CLOSE_NOTIFICATION_SUCCESS_BUTTON);
	}

	@Step("Get Gender value")
	public String getGenderValue(String value) {
		waitForElementVisibility(driver, MyAccountPageUI.FEMALE_GENDER);
		return getAttributeValue(driver, MyAccountPageUI.FEMALE_GENDER, value);
	}
	
	@Step("Get First name value")
	public String getFirstNameValue(String value) {
		waitForElementVisibility(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, value);
	}
	
	@Step("Get Last name value")
	public String getLastNameValue(String value) {
		waitForElementVisibility(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, value);
	}
	
	@Step("Get Day of birth value")
	public String getDayOfBirthValue() {
		waitForElementVisibility(driver, MyAccountPageUI.DAY_OF_BIRTH_DROPDOWNLIST);
		return getFirstSelectedItemInDropdown(driver, MyAccountPageUI.DAY_OF_BIRTH_DROPDOWNLIST);
	}
	
	@Step("Get Month of birth value")
	public String getMonthOfBirthValue() {
		waitForElementVisibility(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWNLIST);
		return getFirstSelectedItemInDropdown(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWNLIST);
	}
	
	@Step("Get Year of birth value")
	public String getYearOfBirthValue() {
		waitForElementVisibility(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWNLIST);
		return getFirstSelectedItemInDropdown(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWNLIST);
	}
	
	@Step("Get Email value")
	public String getEmailValue(String value) {
		waitForElementVisibility(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.EMAIL_TEXTBOX, value);
	}
	
	@Step("Get Company name value")
	public String getCompanyNameValue(String value) {
		waitForElementVisibility(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX, value);
	}
}
