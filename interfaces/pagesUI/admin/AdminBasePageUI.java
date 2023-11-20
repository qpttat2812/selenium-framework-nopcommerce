package pagesUI.admin;

public class AdminBasePageUI {
	public static final String DYNAMIC_PARENT_SIDEBAR_MENU = "//ul[@role='menu']/li[contains(@class,'nav-item')]/a/i/following-sibling::p[contains(text(), '%s')]";
	public static final String DYNAMIC_SUB_SIDEBAR_MENU = "//p[contains(text(), '%s')]/parent::a/following-sibling::ul//p[contains(text(), '%s')]";
}
