package pagesUI.user;

public class DesktopsDetailedPageUI {
	public static final String DYNAMIC_PRODUCT_COMPONENT_DROPDOWNLIST = "//label[contains(text(),'%s')]/parent::dt/following-sibling::dd/select";
	public static final String BAR_NOTIFICATION_SUCCESS_MESSAGE = "//div[@class='bar-notification success']/p";
	public static final String DYNAMIC_PRODUCT_COMPONENT_RADIO_BUTTON = "//label[contains(text(),'%s')]/parent::dt/following-sibling::dd//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_PRODUCT_SOFTWARE_CHECKBOX = "//label[contains(text(),'Software')]/parent::dt/following-sibling::dd//label[text()='%s']/preceding-sibling::input";
	public static final String BAR_CLOSE_BUTTON = "//div[@class='bar-notification success']//span[@class='close']";
	public static final String ADD_TO_CART_BUTTON = "//button[contains(@id, 'add-to-cart-button')]";
	public static final String PRODUCT_UNIT_PRICE_VALUE = "//div[@class='product-price']/span";
	public static final String QUANTITY_TEXTBOX = "//input[@class='qty-input']";
	public static final String PRODUCT_SKU = "//div[@class='sku']/span[contains(@id, 'sku')]";
}
