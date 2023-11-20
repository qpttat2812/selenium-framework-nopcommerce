package pagesObject.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.admin.DashboardPageUI;

public class DashboardPageObject extends BasePages{
	private WebDriver driver;
	
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Verify Dashboard page is displayed")
	public boolean isDashboardPageDisplayed() {
		waitForElementInvisibility(driver, DashboardPageUI.AJAX_BUSY_ICON);
		return isElementDisplayed(driver, DashboardPageUI.DASHBOARD_TITLE);
	}
}
