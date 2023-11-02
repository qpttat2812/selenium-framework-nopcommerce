package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import pagesUI.user.DesktopsPageUI;

public class DesktopsPageObject extends BasePages{
	private WebDriver driver;
	
	public DesktopsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDesktopsPageTitleDisplayed() {
		waitForElementVisibility(driver, DesktopsPageUI.DESKTOPS_PAGE_TITLE);
		return isElementDisplayed(driver, DesktopsPageUI.DESKTOPS_PAGE_TITLE);
	}
}
