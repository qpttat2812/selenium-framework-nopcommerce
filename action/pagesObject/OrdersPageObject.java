package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pagesUI.user.OrdersPageUI;

public class OrdersPageObject extends BasePages{
	private WebDriver driver;
	
	public OrdersPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Get Order Number value")
	public String getOrderNumberValue(String index) {
		waitForElementVisibility(driver, OrdersPageUI.DYNAMIC_ORDER_NUMBER_VALUE, index);
		return getTextElement(driver, OrdersPageUI.DYNAMIC_ORDER_NUMBER_VALUE, index).toUpperCase();
	}

	@Step("Get Total Price value")
	public Object getTotalPriceValue(String index) {
		waitForElementVisibility(driver, OrdersPageUI.DYNAMIC_ORDER_TOTAL_VALUE, index);
		return getTextElement(driver, OrdersPageUI.DYNAMIC_ORDER_TOTAL_VALUE, index);
	}

	@Step("Get Order Date value")
	public String getOrderDateValue(String index) {
		waitForElementVisibility(driver, OrdersPageUI.DYNAMIC_ORDER_DATE_VALUE, index);
		return getTextElement(driver, OrdersPageUI.DYNAMIC_ORDER_DATE_VALUE, index);
	}

	@Step("Get Order Status value")
	public boolean isOrderStatusDisplayed(String index) {
		waitForElementVisibility(driver, OrdersPageUI.DYNAMIC_ORDER_STATUS_VALUE, index);
		return isElementDisplayed(driver, OrdersPageUI.DYNAMIC_ORDER_STATUS_VALUE, index);
	}

	@Step("Click on 'Order Details'")
	public void clickOnOrderDetails(String index) {
		waitForElementClickable(driver, OrdersPageUI.DYNAMIC_ORDER_DETAIL_ICON, index);
		clickOnElement(driver, OrdersPageUI.DYNAMIC_ORDER_DETAIL_ICON, index);
	}

	@Step("Click on 'Re-order' button")
	public AddToCartPageObject clickReOrderButton() {
		waitForElementClickable(driver, OrdersPageUI.RE_ORDER_BUTTON);
		clickOnElement(driver, OrdersPageUI.RE_ORDER_BUTTON);
		return PageGeneratorManager.getAddToCartPageObject(driver);
	}
}
