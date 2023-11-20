package pagesUI.admin;

public class ProductsPageUI {
	public static final String SHOW_ITEMS = "//select[@name='products-grid_length']";
	public static final String ALL_TABLE_ITEMS = "//div[@class='dataTables_scroll']";
	public static final String AJAX_LOADING_ICON = "//div[@id='ajaxBusy']/span";
	public static final String DYNAMIC_PRODUCT_COLUMN_INDEX = "//thead//th[text()='%s']/preceding-sibling::th";
	public static final String DYNAMIC_PRODUCT_PICTURE_ROW_INDEX = "//tbody/tr/td[%s]/img";
	public static final String DYNAMIC_PRODUCT_INFO_ROW_INDEX = "//tbody/tr/td[%s]";
	public static final String DYNAMIC_PRODUCT_PUBLISHED_ROW_INDEX = "//tbody/tr/td[%s]/i";
	public static final String DYNAMIC_PRODUCT_EDIT_ROW_INDEX = "//tbody/tr/td[%s]/a";
	public static final String PRODUCT_NAME_TEXTBOX = "//input[@id='SearchProductName']";
	public static final String SEARCH_BUTTON = "//button[@id='search-products']";
	public static final String CATEGORY_DROPDOWNLIST = "//select[@id='SearchCategoryId']";
	public static final String SUB_CATEGORY_CHECKBOX = "//input[@id='SearchIncludeSubCategories']";
	public static final String NO_DATA_MESSAGE = "//td[@class='dataTables_empty']";
}
