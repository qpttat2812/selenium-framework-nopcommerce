package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;

public class AddToCartPageObject extends BasePages{
	private WebDriver driver;
	
	public AddToCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductTitle() {
		waitForElementInvisibility(driver, AddToCartPageUI.AJAX_LOADING_ICON);
		waitForElementVisibility(driver, AddToCartPageUI.PRODUCT_TITLE);
		return getTextElement(driver, AddToCartPageUI.PRODUCT_TITLE);
	}
}
