package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.ChangePasswordPageUI;

public class ChangePasswordPageObject extends BasePages{
	public ChangePasswordPageObject(WebDriver driver) {
		super(driver);
	}

	@Step("Input to 'Old Password' textbox with value {0}")
	public void inputToOldPasswordTextbox(String oldPassword) {
		waitForElementVisibility(ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, oldPassword);
	}

	@Step("Input to 'New Password' textbox with value {0}")
	public void inputToNewPasswordTextbox(String newPassword) {
		waitForElementVisibility(ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}

	@Step("Input to 'Confirm Password' textbox with value {0}")
	public void inputToConfirmPasswordTextbox(String newPassword) {
		waitForElementVisibility(ChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(ChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX, newPassword);		
	}

	@Step("Click on 'Change Password' button")
	public void clickOnChangePasswordButton() {
		waitForElementClickable(ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickOnElement(ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);		
	}

	@Step("Verify Notification Success Bar is displayed")
	public String getBarNotificationSuccessMessage() {
		waitForElementVisibility(ChangePasswordPageUI.NOTIFICATION_SUCCESS_MESSAGE);
		return getTextElement(ChangePasswordPageUI.NOTIFICATION_SUCCESS_MESSAGE);
	}
}
