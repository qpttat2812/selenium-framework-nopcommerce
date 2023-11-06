package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.AddToCartPageUI;

public class AddToCartPageObject extends BasePages{
	private WebDriver driver;
	
	public AddToCartPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Get Product name of Add To Cart page")
	public String getAddToCartProductName() {
		waitForElementInvisibility(driver, AddToCartPageUI.AJAX_LOADING_ICON);
		waitForElementVisibility(driver, AddToCartPageUI.ADD_TO_CART_PRODUCT_NAME);
		return getTextElement(driver, AddToCartPageUI.ADD_TO_CART_PRODUCT_NAME);
	}
}
