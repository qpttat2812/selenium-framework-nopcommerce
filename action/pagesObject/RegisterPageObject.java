package pagesObject;

import org.openqa.selenium.WebDriver;

import common.BasePages;
import pagesUI.user.RegisterPageUI;

public class RegisterPageObject extends BasePages{
	private WebDriver driver; 
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON_XPATH);
		clickOnElement(driver, RegisterPageUI.REGISTER_BUTTON_XPATH);
	}
	
	public void inputToTextboxAtRegisterPage(String inputText, String... fieldName) {
		waitForElementVisibility(driver, RegisterPageUI.DYNAMIC_TEXTBOX_AT_REGISTER_PAGE_XPATH, fieldName);
		sendkeyToElement(driver, RegisterPageUI.DYNAMIC_TEXTBOX_AT_REGISTER_PAGE_XPATH, inputText, fieldName);
	}
	
	public boolean isRequiredErrorMessageDisplayedAtTextbox(String... fieldName) {
		waitForElementVisibility(driver, RegisterPageUI.DYNAMIC_REQUIRED_ERROR_MESSAGE_XPATH, fieldName);
		return isElementDisplayed(driver, RegisterPageUI.DYNAMIC_REQUIRED_ERROR_MESSAGE_XPATH, fieldName); 
	}
	
	public String getErrorMessageTextAtHeader() {
		waitForElementVisibility(driver, RegisterPageUI.ERROR_MESSAGE_AT_HEADER_AREA_XPATH);
		return getTextElement(driver, RegisterPageUI.ERROR_MESSAGE_AT_HEADER_AREA_XPATH); 
	}
	
	public String getRegisterSuccessfullyText() {
		waitForElementVisibility(driver, RegisterPageUI.REGISTER_SUCCESSFULLY_MESSAGE_XPATH);
		return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESSFULLY_MESSAGE_XPATH); 
	}

	public void clickOnRegisterLink() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON_XPATH);
		clickOnElement(driver, RegisterPageUI.REGISTER_BUTTON_XPATH);
	}
}
