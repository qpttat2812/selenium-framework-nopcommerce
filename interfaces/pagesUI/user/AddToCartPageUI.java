package pagesUI.user;

public class AddToCartPageUI {
	public static final String ADD_TO_CART_PRODUCT_NAME = "//table[@class='cart']//a[@class='product-name']";
	public static final String AJAX_LOADING_ICON = "//div[@class='ajax-loading-block-window']";
	public static final String EDIT_ICON = "//div[@class='edit-item']/a[text()='Edit']";
	public static final String PRODUCT_SKU_VALUE = "//label[@class='td-title' and contains(text(),'SKU')]/following-sibling::span";
	public static final String PRODUCT_IMAGE = "//td[@class='product-picture']//img";
	public static final String PRODUCT_NAME_VALUE = "//a[@class='product-name']";
	public static final String PRODUCT_COMPONENT_INFO = "//td[@class='product']/div[@class='attributes']";
	public static final String PRODUCT_UNIT_PRICE_VALUE = "//td[@class='unit-price']/span[@class='product-unit-price']";
	public static final String PRODUCT_QUANTITY_VALUE = "//td[@class='quantity']/input";
	public static final String PRODUCT_SUB_TOTAL_VALUE = "//td[@class='subtotal']/span";
	public static final String REMOVE_ICON = "//button[@class='remove-btn']";
	public static final String EMPTY_CART_MESSAGE = "//div[@class='no-data']";
	public static final String UPDATE_SHOPPING_CART_BUTTON = "//button[@id='updatecart']";
	public static final String GIFT_WRAPPING_DROPDOWNLIST = "//label[contains(text(),'Gift wrapping')]/parent::dt/following-sibling::dd/select";
	public static final String SELECTED_GIFT_WRAPPING_VALUE = "//div[@class='selected-checkout-attributes']"; 
	public static final String SUMMARY_SHIPPING_COST_VALUE = "//tr[@class='shipping-cost']//span[@class='value-summary']";
	public static final String SUMMARY_TAX_VALUE = "//tr[@class='tax-value']//span[@class='value-summary']";
	public static final String SUMMARY_EARNING_POINT_VALUE = "//tr[@class='earn-reward-points']//span[@class='value-summary']";
	public static final String SUMMARY_TOTAL_PRICE_VALUE = "//tr[@class='order-total']//span[@class='value-summary']/strong";
	public static final String TERM_OF_SERVICES_CHECKBOX = "//input[@id='termsofservice']";
	public static final String CHECKOUT_BUTTON = "//button[@id='checkout']";
	public static final String SUMMARY_SUB_TOTAL_PRICE = "//tr[@class='order-subtotal']//span[@class='value-summary']";
}
