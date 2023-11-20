package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.ChangePasswordPageUI;

public class ChangePasswordPageObject extends BasePages{
	private WebDriver driver;
	
	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Input to 'Old Password' textbox with value {0}")
	public void inputToOldPasswordTextbox(String oldPassword) {
		waitForElementVisibility(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, oldPassword);
	}

	@Step("Input to 'New Password' textbox with value {0}")
	public void inputToNewPasswordTextbox(String newPassword) {
		waitForElementVisibility(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}

	@Step("Input to 'Confirm Password' textbox with value {0}")
	public void inputToConfirmPasswordTextbox(String newPassword) {
		waitForElementVisibility(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX, newPassword);		
	}

	@Step("Click on 'Change Password' button")
	public void clickOnChangePasswordButton() {
		waitForElementClickable(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickOnElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);		
	}

	@Step("Verify Notification Success Bar is displayed")
	public String getBarNotificationSuccessMessage() {
		waitForElementVisibility(driver, ChangePasswordPageUI.NOTIFICATION_SUCCESS_MESSAGE);
		return getTextElement(driver, ChangePasswordPageUI.NOTIFICATION_SUCCESS_MESSAGE);
	}
}
