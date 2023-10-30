package pagesUI.user;

public class RecentProductViewPageUI {
	public static final String RECENT_PRODUCT_VIEW_TITLE = "//h1[text()='Recently viewed products']";
	public static final String DYNAMIC_RECENT_PRODUCT_NAME_TEXT = "//div[@class='product-item']//h2[@class='product-title']/a[text()='%s']";
	public static final String RECENT_PRODUCT_LIST_SIZE = "//div[@class='product-item']";
	public static final String DYNAMIC_RECENT_PRODUCT_PRICE = "//a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']/div[@class='prices']";
}
