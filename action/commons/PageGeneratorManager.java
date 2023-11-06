package commons;

import org.openqa.selenium.WebDriver;

import pagesObject.AddToCartPageObject;
import pagesObject.AddressPageObject;
import pagesObject.BookDetailedPageObject;
import pagesObject.BookPageObject;
import pagesObject.ChangePasswordPageObject;
import pagesObject.CompareProductPageObject;
import pagesObject.ComputersPageObject;
import pagesObject.DesktopsDetailedPageObject;
import pagesObject.DesktopsPageObject;
import pagesObject.HomePageObject;
import pagesObject.LoginPageObject;
import pagesObject.MyAccountPageObject;
import pagesObject.MyProductReviewPageObject;
import pagesObject.NotebooksDetailedPageObject;
import pagesObject.NotebooksPageObject;
import pagesObject.ProductReviewsPageObject;
import pagesObject.RecentProductViewPageObject;
import pagesObject.RegisterPageObject;
import pagesObject.SearchPageObject;
import pagesObject.WishlistPageObject;

public class PageGeneratorManager {
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static MyAccountPageObject getMyAccountPageObject(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
	
	public static AddressPageObject getAddressPageObject(WebDriver driver) {
		return new AddressPageObject(driver);
	}
	
	public static ChangePasswordPageObject getChangePasswordPageObject(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}

	public static BookPageObject getBookPageObject(WebDriver driver) {
		return new BookPageObject(driver);
	}
	
	public static BookDetailedPageObject getBookDetailedPageObject(WebDriver driver) {
		return new BookDetailedPageObject(driver);
	}

	public static MyProductReviewPageObject getMyProductReviewPageObject(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}
	
	public static SearchPageObject getSearchPageObject(WebDriver driver) {
		return new SearchPageObject(driver);
	}
	
	public static ComputersPageObject getComputersPageObject(WebDriver driver) {
		return new ComputersPageObject(driver);
	}
	
	public static NotebooksPageObject getNotebooksPageObject(WebDriver driver) {
		return new NotebooksPageObject(driver);
	}
	
	public static NotebooksDetailedPageObject getNotebooksDetailedPageObject(WebDriver driver) {
		return new NotebooksDetailedPageObject(driver);
	}
	
	public static WishlistPageObject getWishlistPageObject(WebDriver driver) {
		return new WishlistPageObject(driver);
	}
	
	public static AddToCartPageObject getAddToCartPageObject(WebDriver driver) {
		return new AddToCartPageObject(driver);
	}
	
	public static CompareProductPageObject getCompareProductPageObject(WebDriver driver) {
		return new CompareProductPageObject(driver);
	}
	
	public static RecentProductViewPageObject getRecentProductViewPageObject(WebDriver driver) {
		return new RecentProductViewPageObject(driver);
	}
	
	public static DesktopsPageObject getDesktopsPageObject(WebDriver driver) {
		return new DesktopsPageObject(driver);
	}

	public static DesktopsDetailedPageObject getDesktopsDetailedPageObject(WebDriver driver) {
		return new DesktopsDetailedPageObject(driver);
	}
	
	public static ProductReviewsPageObject getProductReviewsPageObject(WebDriver driver) {
		return new ProductReviewsPageObject(driver);
	}
}
