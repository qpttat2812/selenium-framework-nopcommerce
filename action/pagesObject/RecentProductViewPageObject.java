package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import pagesUI.user.RecentProductViewPageUI;

public class RecentProductViewPageObject extends BasePages{
	private WebDriver driver;
	
	public RecentProductViewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isRecentProductViewTitleDisplayed() {
		waitForElementVisibility(driver, RecentProductViewPageUI.RECENT_PRODUCT_VIEW_TITLE);
		return isElementDisplayed(driver, RecentProductViewPageUI.RECENT_PRODUCT_VIEW_TITLE);
	}

	public int getSizeOfRecentProducts() {
		waitForElementVisibility(driver, RecentProductViewPageUI.RECENT_PRODUCT_LIST_SIZE);
		return getElementSize(driver, RecentProductViewPageUI.RECENT_PRODUCT_LIST_SIZE);
	}

	public String getProductNameText(String expectedProductName) {
		waitForElementVisibility(driver, RecentProductViewPageUI.DYNAMIC_RECENT_PRODUCT_NAME_TEXT, expectedProductName);
		return getTextElement(driver, RecentProductViewPageUI.DYNAMIC_RECENT_PRODUCT_NAME_TEXT, expectedProductName);
	}
	
	public String getProductPriceValue(String expectedProductName) {
		waitForElementVisibility(driver, RecentProductViewPageUI.DYNAMIC_RECENT_PRODUCT_NAME_TEXT, expectedProductName);
		return getTextElement(driver, RecentProductViewPageUI.DYNAMIC_RECENT_PRODUCT_NAME_TEXT, expectedProductName);
	}
}
