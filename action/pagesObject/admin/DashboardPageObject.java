package pagesObject.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.admin.DashboardPageUI;

public class DashboardPageObject extends BasePages{
	public DashboardPageObject(WebDriver driver) {
		super(driver);
	}
	
	@Step("Verify Dashboard page is displayed")
	public boolean isDashboardPageDisplayed() {
		waitForElementInvisibility(DashboardPageUI.AJAX_BUSY_ICON);
		return isElementDisplayed(DashboardPageUI.DASHBOARD_TITLE);
	}
}
