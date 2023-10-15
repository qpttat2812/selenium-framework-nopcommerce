package common;

import org.openqa.selenium.WebDriver;

import pagesObject.AddressPageObject;
import pagesObject.BookProductPageObject;
import pagesObject.ChangePasswordPageObject;
import pagesObject.HomePageObject;
import pagesObject.LoginPageObject;
import pagesObject.MyAccountPageObject;
import pagesObject.MyProductReviewPageObject;
import pagesObject.RegisterPageObject;

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
}
