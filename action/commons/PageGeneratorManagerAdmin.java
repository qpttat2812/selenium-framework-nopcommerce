package commons;

import org.openqa.selenium.WebDriver;

import pagesObject.admin.DashboardPageObject;
import pagesObject.admin.LoginPageObject;
import pagesObject.admin.ProductsPageObject;

public class PageGeneratorManagerAdmin {
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static DashboardPageObject getDashboardPageObject(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	
	public static ProductsPageObject getProductsPageObject(WebDriver driver) {
		return new ProductsPageObject(driver);
	}
}
