package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.RecentProductViewPageUI;

public class RecentProductViewPageObject extends BasePages{
	private WebDriver driver;
	
	public RecentProductViewPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Verify Recent Product View title is displayed")
	public boolean isRecentProductViewTitleDisplayed() {
		waitForElementVisibility(driver, RecentProductViewPageUI.RECENT_PRODUCT_VIEW_TITLE);
		return isElementDisplayed(driver, RecentProductViewPageUI.RECENT_PRODUCT_VIEW_TITLE);
	}
	
	@Step("Get size of recent products")
	public int getSizeOfRecentProducts() {
		waitForElementVisibility(driver, RecentProductViewPageUI.RECENT_PRODUCT_LIST_SIZE);
		return getElementSize(driver, RecentProductViewPageUI.RECENT_PRODUCT_LIST_SIZE);
	}

	@Step("Get Product Name value")
	public String getProductNameText(String expectedProductName) {
		waitForElementVisibility(driver, RecentProductViewPageUI.DYNAMIC_RECENT_PRODUCT_NAME_TEXT, expectedProductName);
		return getTextElement(driver, RecentProductViewPageUI.DYNAMIC_RECENT_PRODUCT_NAME_TEXT, expectedProductName);
	}
	
	@Step("Get Product Price value")
	public String getProductPriceValue(String expectedProductName) {
		waitForElementVisibility(driver, RecentProductViewPageUI.DYNAMIC_RECENT_PRODUCT_NAME_TEXT, expectedProductName);
		return getTextElement(driver, RecentProductViewPageUI.DYNAMIC_RECENT_PRODUCT_NAME_TEXT, expectedProductName);
	}
}
