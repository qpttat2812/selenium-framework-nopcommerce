package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.DesktopsPageUI;

public class DesktopsPageObject extends BasePages{
	private WebDriver driver;
	
	public DesktopsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Verify Desktops Page title is displayed")
	public boolean isDesktopsPageDisplayed() {
		waitForElementVisibility(driver, DesktopsPageUI.DESKTOPS_PAGE_TITLE);
		return isElementDisplayed(driver, DesktopsPageUI.DESKTOPS_PAGE_TITLE);
	}
}
