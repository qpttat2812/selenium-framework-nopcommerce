package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.BookPageUI;

public class BookPageObject extends BasePages{
	private WebDriver driver;
	
	public BookPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Verify Book title is displayed")
	public boolean isBookPageDisplayed() {
		waitForElementVisibility(driver,BookPageUI.BOOK_TITLE);
		return isElementDisplayed(driver, BookPageUI.BOOK_TITLE);
	}
}
