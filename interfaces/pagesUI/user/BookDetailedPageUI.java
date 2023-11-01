package pagesUI.user;

public class BookDetailedPageUI {
	public static final String ADD_REVIEW_LINK = "//div[@class='product-reviews-overview']//a[text()='Add your review']";
	public static final String REVIEW_ITEM_TITLE = "//input[@id='AddProductReview_Title']";
	public static final String REIVEW_ITEM_CONTENT = "//textarea[@id='AddProductReview_ReviewText']";
	public static final String RATING_LEVEL = "//div[@class='rating-options']/input[contains(@aria-label,'%s')]";
	public static final String SUBMIT_REVIEW_BUTTON = "//button[@name='add-review']";
	public static final String REVIEW_PRODUCT_TITLE = "//div[@class='page-title']/h1";
}
