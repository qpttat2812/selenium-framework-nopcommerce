package commons;

import org.openqa.selenium.WebDriver;

import pagesObject.AddressPageObject;
import pagesObject.BookProductPageObject;
import pagesObject.ChangePasswordPageObject;
import pagesObject.ComputersPageObject;
import pagesObject.HomePageObject;
import pagesObject.LoginPageObject;
import pagesObject.MyAccountPageObject;
import pagesObject.MyProductReviewPageObject;
import pagesObject.NotebooksPageObject;
import pagesObject.RegisterPageObject;
import pagesObject.SearchPageObject;

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

	public static BookProductPageObject getBookProductPageObject(WebDriver driver) {
		return new BookProductPageObject(driver);
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
}
