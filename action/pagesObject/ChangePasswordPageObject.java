package pagesObject;

import org.openqa.selenium.WebDriver;

import common.BasePages;
import pagesUI.user.ChangePasswordPageUI;

public class ChangePasswordPageObject extends BasePages{
	private WebDriver driver;
	
	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToOldPasswordTextbox(String oldPassword) {
		waitForElementVisibility(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, oldPassword);
	}

	public void inputToNewPasswordTextbox(String newPassword) {
		waitForElementVisibility(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}

	public void inputToConfirmPasswordTextbox(String newPassword) {
		waitForElementVisibility(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX, newPassword);		
	}

	public void clickOnChangePasswordButton() {
		waitForElementVisibility(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickOnElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);		
	}

	public boolean isNotificationSuccessDisplayed() {
		waitForElementVisibility(driver, ChangePasswordPageUI.NOTIFICATION_SUCCESS_TEXT);
		return isElementDisplayed(driver, ChangePasswordPageUI.NOTIFICATION_SUCCESS_TEXT);
	}
	
	public void clickOnCloseButton() {
		waitForElementVisibility(driver, ChangePasswordPageUI.CLOSE_BUTTON);
		clickOnElement(driver, ChangePasswordPageUI.CLOSE_BUTTON);
		waitForElementInvisibility(driver, ChangePasswordPageUI.CLOSE_BUTTON);
	}
}
