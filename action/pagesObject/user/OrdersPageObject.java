package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManagerUser;
import io.qameta.allure.Step;
import pagesUI.user.OrdersPageUI;

public class OrdersPageObject extends BasePages{
	private WebDriver driver;
	
	public OrdersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Get Order Number value")
	public String getOrderNumberValue(String index) {
		waitForElementVisibility(OrdersPageUI.DYNAMIC_ORDER_NUMBER_VALUE, index);
		return getTextElement(OrdersPageUI.DYNAMIC_ORDER_NUMBER_VALUE, index).toUpperCase();
	}

	@Step("Get Total Price value")
	public Object getTotalPriceValue(String index) {
		waitForElementVisibility(OrdersPageUI.DYNAMIC_ORDER_TOTAL_VALUE, index);
		return getTextElement(OrdersPageUI.DYNAMIC_ORDER_TOTAL_VALUE, index);
	}

	@Step("Get Order Date value")
	public String getOrderDateValue(String index) {
		waitForElementVisibility(OrdersPageUI.DYNAMIC_ORDER_DATE_VALUE, index);
		return getTextElement(OrdersPageUI.DYNAMIC_ORDER_DATE_VALUE, index);
	}

	@Step("Get Order Status value")
	public boolean isOrderStatusDisplayed(String index) {
		waitForElementVisibility(OrdersPageUI.DYNAMIC_ORDER_STATUS_VALUE, index);
		return isElementDisplayed(OrdersPageUI.DYNAMIC_ORDER_STATUS_VALUE, index);
	}

	@Step("Click on 'Order Details'")
	public void clickOnOrderDetails(String index) {
		waitForElementClickable(OrdersPageUI.DYNAMIC_ORDER_DETAIL_ICON, index);
		clickOnElement(OrdersPageUI.DYNAMIC_ORDER_DETAIL_ICON, index);
	}

	@Step("Click on 'Re-order' button")
	public AddToCartPageObject clickReOrderButton() {
		waitForElementClickable(OrdersPageUI.RE_ORDER_BUTTON);
		clickOnElement(OrdersPageUI.RE_ORDER_BUTTON);
		return PageGeneratorManagerUser.getAddToCartPageObject(driver);
	}
}
