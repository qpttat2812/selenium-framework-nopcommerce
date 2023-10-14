package common;

import org.openqa.selenium.WebDriver;

import pagesObject.HomePageObject;
import pagesObject.LoginPageObject;
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
}
