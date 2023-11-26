package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.RecentProductViewPageUI;

public class RecentProductViewPageObject extends BasePages{
	public RecentProductViewPageObject(WebDriver driver) {
		super(driver);
	}
	
	@Step("Verify Recent Product View title is displayed")
	public boolean isRecentProductViewTitleDisplayed() {
		waitForElementVisibility(RecentProductViewPageUI.RECENT_PRODUCT_VIEW_TITLE);
		return isElementDisplayed(RecentProductViewPageUI.RECENT_PRODUCT_VIEW_TITLE);
	}
	
	@Step("Get size of recent products")
	public int getSizeOfRecentProducts() {
		waitForElementVisibility(RecentProductViewPageUI.RECENT_PRODUCT_LIST_SIZE);
		return getElementSize(RecentProductViewPageUI.RECENT_PRODUCT_LIST_SIZE);
	}

	@Step("Get Product Name value")
	public String getProductNameText(String expectedProductName) {
		waitForElementVisibility(RecentProductViewPageUI.DYNAMIC_RECENT_PRODUCT_NAME_TEXT, expectedProductName);
		return getTextElement(RecentProductViewPageUI.DYNAMIC_RECENT_PRODUCT_NAME_TEXT, expectedProductName);
	}
	
	@Step("Get Product Price value")
	public String getProductPriceValue(String expectedProductName) {
		waitForElementVisibility(RecentProductViewPageUI.DYNAMIC_RECENT_PRODUCT_NAME_TEXT, expectedProductName);
		return getTextElement(RecentProductViewPageUI.DYNAMIC_RECENT_PRODUCT_NAME_TEXT, expectedProductName);
	}
}
