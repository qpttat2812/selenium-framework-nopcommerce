package pagesUI.user;

public class BasePageUI {
	public static final String DYNAMIC_SIDEBAR_MY_ACCOUNT_LINKS = "//div[contains(@class, 'block-account-navigation')]//a[text()='%s']";
	public static final String DYNAMIC_FOOTER_LINKS = "//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_PRODUCT_TAB = "//ul[@class='top-menu notmobile']//a[contains(text(), '%s')]";
	public static final String DYNAMIC_PRODUCT_DETAILED_TITLE = "//h2[@class='product-title']/a[text()='%s']";
	public static final String DYNAMIC_ACTION_BUTTONS_IN_PRODUCT_DETAILED_PAGE = "//h1[text()='%s']/parent::div[@class='product-name']/following-sibling::div//button[text()='%s']";
}
