package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.NotebooksDetailedPageUI;

public class NotebooksDetailedPageObject extends BasePages{
	private WebDriver driver;
	
	public NotebooksDetailedPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Get Bar notification success message")
	public String getBarNotificationSuccessText() {
		waitForElementVisibility(driver, NotebooksDetailedPageUI.BAR_NOTIFICATION_SUCCESS_MESSSAGE);
		return getTextElement(driver, NotebooksDetailedPageUI.BAR_NOTIFICATION_SUCCESS_MESSSAGE);
	}
	
	@Step("Click on Close button in Bar notification success")
	public void clickOnCloseButton() {
		waitForElementClickable(driver, NotebooksDetailedPageUI.BAR_CLOSE_BUTTON);
		clickOnElement(driver, NotebooksDetailedPageUI.BAR_CLOSE_BUTTON);
		waitForElementInvisibility(driver, NotebooksDetailedPageUI.BAR_CLOSE_BUTTON);
	}
	
	
	@Step("Get product title at header in product detailed page")
	public String getProductNameAtHeader() {
		waitForElementVisibility(driver, NotebooksDetailedPageUI.PRODUCT_DETAILED_TITLE);
		return getTextElement(driver, NotebooksDetailedPageUI.PRODUCT_DETAILED_TITLE);
	}
}
