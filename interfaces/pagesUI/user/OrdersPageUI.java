package pagesUI.user;

public class OrdersPageUI {
	public static final String DYNAMIC_ORDER_NUMBER_VALUE = "//div[@class='section order-item']//strong[%s]";
	public static final String DYNAMIC_ORDER_STATUS_VALUE = "//div[@class='section order-item']//ul[@class='info']/li[contains(text(), 'Order status:')]/span[text()='Pending'][%s]";
	public static final String DYNAMIC_ORDER_TOTAL_VALUE = "//div[@class='section order-item']//ul[@class='info']/li[contains(text(), 'Order Total:')]/span[%s]";
	public static final String DYNAMIC_ORDER_DATE_VALUE = "//div[@class='section order-item']//ul[@class='info']/li[contains(text(), 'Order Date:')]/span[%s]";
	public static final String DYNAMIC_ORDER_DETAIL_ICON = "//div[@class='buttons']/button[text()='Details'][%s]";
	public static final String RE_ORDER_BUTTON = "//div[@class='actions']/button[text()='Re-order']";
}
