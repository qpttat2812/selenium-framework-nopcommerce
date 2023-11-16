package pagesUI.user;

public class NotebooksDetailedPageUI {
	public static final String BAR_NOTIFICATION_SUCCESS_MESSSAGE = "//div[@class='bar-notification success']/p";
	public static final String BAR_CLOSE_BUTTON = "//div[@class='bar-notification success']//span[@class='close']";
	public static final String DYNAMIC_ACTION_BUTTONS = "//h1[text()='%s']/parent::div[@class='product-name']/following-sibling::div//button[text()='%s']";
	public static final String DYNAMIC_PRODUCT_PRICE_VALUE = "//h1[text()='%s']/parent::div[@class='product-name']/following-sibling::div[@class='prices']//span";
	public static final String ADD_REVIEW_LINK = "//div[@class='product-reviews-overview']//a[text()='Add your review']";
	public static final String ADD_TO_CART_BUTTON = "//button[contains(@id,'add-to-cart-button')]";
	public static final String PRODUCT_SKU = "//div[@class='sku']/span[contains(@id, 'sku')]";
	public static final String PRODUCT_UNIT_PRICE_VALUE = "//div[@class='product-price']/span";
}
