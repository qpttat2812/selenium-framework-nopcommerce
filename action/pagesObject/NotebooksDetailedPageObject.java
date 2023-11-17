package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pagesUI.user.NotebooksDetailedPageUI;

public class NotebooksDetailedPageObject extends BasePages{
	private WebDriver driver;
	
	public NotebooksDetailedPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Get Bar notification success message")
	public String getBarNotificationSuccessMessage() {
		waitForElementVisibility(driver, NotebooksDetailedPageUI.BAR_NOTIFICATION_SUCCESS_MESSSAGE);
		return getTextElement(driver, NotebooksDetailedPageUI.BAR_NOTIFICATION_SUCCESS_MESSSAGE);
	}
	
	@Step("Click on {1} button of {0} item in product detailed page")
	public void clickOnActionButton(String productName, String buttonName) {
		waitForElementVisibility(driver, NotebooksDetailedPageUI.DYNAMIC_ACTION_BUTTONS, productName, buttonName);
		clickOnElement(driver, NotebooksDetailedPageUI.DYNAMIC_ACTION_BUTTONS, productName, buttonName);
	}
	
	@Step("Get price of product in product detailed page")
	public String getPriceOfProduct(String productName) {
		waitForElementVisibility(driver, NotebooksDetailedPageUI.DYNAMIC_PRODUCT_PRICE_VALUE, productName);
		return getTextElement(driver, NotebooksDetailedPageUI.DYNAMIC_PRODUCT_PRICE_VALUE, productName);
	}
	
	@Step("Click on 'Add Your Review' textlink")
	public ProductReviewsPageObject clickOnAddReviewLink() {
		waitForElementVisibility(driver, NotebooksDetailedPageUI.ADD_REVIEW_LINK);
		clickOnElement(driver, NotebooksDetailedPageUI.ADD_REVIEW_LINK);
		return PageGeneratorManager.getProductReviewsPageObject(driver);
	}

	@Step("Click on 'Add to cart' button")
	public void clickOnAddToCartButton() {
		waitForElementClickable(driver, NotebooksDetailedPageUI.ADD_TO_CART_BUTTON);
		clickOnElement(driver, NotebooksDetailedPageUI.ADD_TO_CART_BUTTON);
	}

	@Step("Get Notebooks SKU value")
	public String getProductSKUValue() {
		waitForElementVisibility(driver, NotebooksDetailedPageUI.PRODUCT_SKU);
		return getTextElement(driver, NotebooksDetailedPageUI.PRODUCT_SKU);
	}

	@Step("Get Notebooks unit price value")
	public float getProductUnitPriceValue() {
		waitForElementVisibility(driver, NotebooksDetailedPageUI.PRODUCT_UNIT_PRICE_VALUE);
		String price = getTextElement(driver, NotebooksDetailedPageUI.PRODUCT_UNIT_PRICE_VALUE).replace("$", "").replace(",", "");
		return Float.valueOf(price);
	}
}
