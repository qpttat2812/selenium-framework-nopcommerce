package pagesObject;

import org.openqa.selenium.WebDriver;

import common.BasePages;
import pagesUI.user.BookProductPageUI;

public class BookProductPageObject extends BasePages{
	private WebDriver driver;
	
	public BookProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnBookTitle(String... title) {
		waitForElementVisibility(driver, BookProductPageUI.BOOK_TITLE, title);
		clickOnElement(driver, BookProductPageUI.BOOK_TITLE, title);
	}

	public void clickOnAddReviewLink() {
		waitForElementVisibility(driver, BookProductPageUI.ADD_REVIEW_LINK);
		clickOnElement(driver, BookProductPageUI.ADD_REVIEW_LINK);
	}

	public void inputToReviewTitle(String reviewTitle) {
		waitForElementVisibility(driver, BookProductPageUI.REVIEW_ITEM_TITLE);
		sendkeyToElement(driver, BookProductPageUI.REVIEW_ITEM_TITLE, reviewTitle);
	}
	
	public void inputToReviewContent(String reviewContent) {
		waitForElementVisibility(driver, BookProductPageUI.REIVEW_ITEM_CONTENT);
		sendkeyToElement(driver, BookProductPageUI.REIVEW_ITEM_CONTENT, reviewContent);
	}

	public void selectRatingLevelRadioButton(String... level) {
		waitForElementVisibility(driver, BookProductPageUI.RATING_LEVEL, level);
		clickOnRadioButton(driver, BookProductPageUI.RATING_LEVEL, level);
	}

	public void clickOnSubmitReviewButton() {
		waitForElementVisibility(driver, BookProductPageUI.SUBMIT_REVIEW_BUTTON);
		clickOnElement(driver, BookProductPageUI.SUBMIT_REVIEW_BUTTON);
	}
}
