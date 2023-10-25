package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.BookProductPageUI;

public class BookProductPageObject extends BasePages{
	private WebDriver driver;
	
	public BookProductPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click on book title")
	public void clickOnBookTitleLink(String title) {
		waitForElementVisibility(driver, BookProductPageUI.BOOK_TITLE, title);
		clickOnElement(driver, BookProductPageUI.BOOK_TITLE, title);
	}
	
	@Step("Click on Add your review textlink")
	public void clickOnAddReviewLink() {
		waitForElementVisibility(driver, BookProductPageUI.ADD_REVIEW_LINK);
		clickOnElement(driver, BookProductPageUI.ADD_REVIEW_LINK);
	}

	@Step("Input to Review title textbox with value {0}")
	public void inputToReviewTitleTextbox(String reviewTitle) {
		waitForElementVisibility(driver, BookProductPageUI.REVIEW_ITEM_TITLE);
		sendkeyToElement(driver, BookProductPageUI.REVIEW_ITEM_TITLE, reviewTitle);
	}
	
	@Step("Input to Review content textarea with value {0}")
	public void inputToReviewContentTextArea(String reviewContent) {
		waitForElementVisibility(driver, BookProductPageUI.REIVEW_ITEM_CONTENT);
		sendkeyToElement(driver, BookProductPageUI.REIVEW_ITEM_CONTENT, reviewContent);
	}

	@Step("Select rating level radio button with value {0}")
	public void selectRatingLevelRadioButton(String level) {
		waitForElementVisibility(driver, BookProductPageUI.RATING_LEVEL, level);
		clickOnRadioButton(driver, BookProductPageUI.RATING_LEVEL, level);
	}

	@Step("Click on Submit Review button")
	public void clickOnSubmitReviewButton() {
		waitForElementVisibility(driver, BookProductPageUI.SUBMIT_REVIEW_BUTTON);
		clickOnElement(driver, BookProductPageUI.SUBMIT_REVIEW_BUTTON);
	}
}
