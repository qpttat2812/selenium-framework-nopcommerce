package common;

import org.openqa.selenium.WebDriver;

import pagesObject.RegisterPageObject;

public class PageGeneratorManager {
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
}
