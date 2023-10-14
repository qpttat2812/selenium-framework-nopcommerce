package pagesObject;

import org.openqa.selenium.WebDriver;

import common.BasePages;
import pagesUI.user.HomePageUI;

public class ChangePasswordPageObject extends BasePages{
	private WebDriver driver;
	
	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToOldPasswordTextbox(String oldPassword) {
		waitForElementVisibility(driver, HomePageUI.OLD_PASSWORD_TEXTBOX);
		clickOnElement(driver, HomePageUI.OLD_PASSWORD_TEXTBOX);
	}

	public void inputToNewPasswordTextbox(String newPassword) {
		waitForElementVisibility(driver, HomePageUI.NEW_PASSWORD_TEXTBOX);
		clickOnElement(driver, HomePageUI.NEW_PASSWORD_TEXTBOX);
	}

	public void inputToConfirmPasswordTextbox(String newPassword) {
		waitForElementVisibility(driver, HomePageUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
		clickOnElement(driver, HomePageUI.CONFIRM_NEW_PASSWORD_TEXTBOX);		
	}

	public void clickOnChangePasswordButton() {
		waitForElementVisibility(driver, HomePageUI.OLD_PASSWORD_TEXTBOX);
		clickOnElement(driver, HomePageUI.OLD_PASSWORD_TEXTBOX);		
	}

	public boolean isNotificationSuccessDisplayed() {
		return false;
	}
}
