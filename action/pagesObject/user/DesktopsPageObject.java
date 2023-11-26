package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.DesktopsPageUI;

public class DesktopsPageObject extends BasePages{
	public DesktopsPageObject(WebDriver driver) {
		super(driver);
	}
	
	@Step("Verify Desktops Page title is displayed")
	public boolean isDesktopsPageDisplayed() {
		waitForElementVisibility(DesktopsPageUI.DESKTOPS_PAGE_TITLE);
		return isElementDisplayed(DesktopsPageUI.DESKTOPS_PAGE_TITLE);
	}
}
