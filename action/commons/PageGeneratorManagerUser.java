package commons;

import org.openqa.selenium.WebDriver;

import pagesObject.user.AddToCartPageObject;
import pagesObject.user.AddressPageObject;
import pagesObject.user.ChangePasswordPageObject;
import pagesObject.user.CheckoutPageObject;
import pagesObject.user.CompareProductPageObject;
import pagesObject.user.ComputersPageObject;
import pagesObject.user.DesktopsDetailedPageObject;
import pagesObject.user.DesktopsPageObject;
import pagesObject.user.HomePageObject;
import pagesObject.user.LoginPageObject;
import pagesObject.user.MyAccountPageObject;
import pagesObject.user.MyProductReviewPageObject;
import pagesObject.user.NotebooksDetailedPageObject;
import pagesObject.user.NotebooksPageObject;
import pagesObject.user.OrdersPageObject;
import pagesObject.user.ProductReviewsPageObject;
import pagesObject.user.RecentProductViewPageObject;
import pagesObject.user.RegisterPageObject;
import pagesObject.user.SearchPageObject;
import pagesObject.user.WishlistPageObject;

public class PageGeneratorManagerUser {
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
	
	public static CheckoutPageObject getCheckoutPageObject(WebDriver driver) {
		return new CheckoutPageObject(driver);
	}

	public static OrdersPageObject getOrdersPageObject(WebDriver driver) {
		return new OrdersPageObject(driver);
	}
}
