package pagesUI.user;

public class CompareProductPageUI {
	public static final String PRODUCT_NAME_LIST = "//label[text()='Name']/parent::td/following-sibling::td/a";
	public static final String DYNAMIC_COMPARE_PRODUCT_PRICE = "//label[text()='Price']/parent::td/following-sibling::td[%s]";
	public static final String CLEAR_LIST_BUTTON = "//a[@class='clear-list']";
	public static final String EMPTY_PRODUCT_MESSSAGE = "//div[contains(@class, 'compare-products-page')]//div[@class='no-data']";
}
