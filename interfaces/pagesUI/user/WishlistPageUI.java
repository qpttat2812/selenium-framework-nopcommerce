package pagesUI.user;

public class WishlistPageUI {
	public static final String WISHLIST_PRODUCT_NAME = "//td[@class='product']/a[@class='product-name']";
	public static final String WISHLIST_SHARING_URL = "//div[@class='share-info']/a";
	public static final String WISHLIST_SHARING_TITLE = "//div[@class='page-title']/h1";
	public static final String ADD_TO_CART_CHECKBOX = "//input[@name='addtocart']";
	public static final String ADD_TO_CART_BUTTON = "//button[@name='addtocartbutton']";
	public static final String REMOVE_WISHLIST_PRODUCT_ICON = "//td[@class='remove-from-cart']/button[@class='remove-btn']";
	public static final String AJAX_LOADING_ICON = "//div[@class='ajax-loading-block-window']";
	public static final String WISHLIST_EMPTY_MESSAGE = "//div[@class='no-data' and contains(text(),'The wishlist is empty!')]";
}
