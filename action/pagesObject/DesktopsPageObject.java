package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;

public class DesktopsPageObject extends BasePages{
	private WebDriver driver;
	
	public DesktopsPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
