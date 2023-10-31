package pagesUI.user;

public class BasePageUI {
	public static final String DYNAMIC_SIDEBAR_MY_ACCOUNT_LINKS = "//div[contains(@class, 'block-account-navigation')]//a[text()='%s']";
	public static final String DYNAMIC_FOOTER_LINKS = "//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_PRODUCT_TAB = "//ul[@class='top-menu notmobile']//a[contains(text(), '%s')]";
	public static final String DYNAMIC_PRODUCT_NAME_IN_CATEGORY_PAGE = "//h2[@class='product-title']/a[text()='%s']";
	public static final String DYNAMIC_ACTION_BUTTONS_IN_PRODUCT_DETAILED_PAGE = "//h1[text()='%s']/parent::div[@class='product-name']/following-sibling::div//button[text()='%s']";
	public static final String DYNAMIC_PRODUCT_PRICE_TEXT = "//h1[text()='%s']/parent::div[@class='product-name']/following-sibling::div[@class='prices']//span";
	public static final String DYNAMIC_PRODUCT_NAME_AT_PRODUCT_DETAILED_PAGE = "//div[@class='product-name']/h1[text()='%s']";
}
