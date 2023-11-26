package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManagerUser;
import io.qameta.allure.Step;
import pagesUI.user.NotebooksDetailedPageUI;

public class NotebooksDetailedPageObject extends BasePages{
	private WebDriver driver;
	
	public NotebooksDetailedPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@Step("Get Bar notification success message")
	public String getBarNotificationSuccessMessage() {
		waitForElementVisibility(NotebooksDetailedPageUI.BAR_NOTIFICATION_SUCCESS_MESSSAGE);
		return getTextElement(NotebooksDetailedPageUI.BAR_NOTIFICATION_SUCCESS_MESSSAGE);
	}
	
	@Step("Click on {1} button of {0} item in product detailed page")
	public void clickOnActionButton(String productName, String buttonName) {
		waitForElementVisibility(NotebooksDetailedPageUI.DYNAMIC_ACTION_BUTTONS, productName, buttonName);
		clickOnElement(NotebooksDetailedPageUI.DYNAMIC_ACTION_BUTTONS, productName, buttonName);
	}
	
	@Step("Get price of product in product detailed page")
	public String getPriceOfProduct(String productName) {
		waitForElementVisibility(NotebooksDetailedPageUI.DYNAMIC_PRODUCT_PRICE_VALUE, productName);
		return getTextElement(NotebooksDetailedPageUI.DYNAMIC_PRODUCT_PRICE_VALUE, productName);
	}
	
	@Step("Click on 'Add Your Review' textlink")
	public ProductReviewsPageObject clickOnAddReviewLink() {
		waitForElementVisibility(NotebooksDetailedPageUI.ADD_REVIEW_LINK);
		clickOnElement(NotebooksDetailedPageUI.ADD_REVIEW_LINK);
		return PageGeneratorManagerUser.getProductReviewsPageObject(driver);
	}

	@Step("Click on 'Add to cart' button")
	public void clickOnAddToCartButton() {
		waitForElementClickable(NotebooksDetailedPageUI.ADD_TO_CART_BUTTON);
		clickOnElement(NotebooksDetailedPageUI.ADD_TO_CART_BUTTON);
	}

	@Step("Get Notebooks SKU value")
	public String getProductSKUValue() {
		waitForElementVisibility(NotebooksDetailedPageUI.PRODUCT_SKU);
		return getTextElement(NotebooksDetailedPageUI.PRODUCT_SKU);
	}

	@Step("Get Notebooks unit price value")
	public float getProductUnitPriceValue() {
		waitForElementVisibility(NotebooksDetailedPageUI.PRODUCT_UNIT_PRICE_VALUE);
		String price = getTextElement(NotebooksDetailedPageUI.PRODUCT_UNIT_PRICE_VALUE).replace("$", "").replace(",", "");
		return Float.valueOf(price);
	}
}
