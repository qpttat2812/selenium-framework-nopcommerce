package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.BookDetailedPageUI;

public class BookDetailedPageObject extends BasePages{
	private WebDriver driver;
	
	public BookDetailedPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click on Add your review textlink")
	public void clickOnAddReviewLink() {
		waitForElementVisibility(driver, BookDetailedPageUI.ADD_REVIEW_LINK);
		clickOnElement(driver, BookDetailedPageUI.ADD_REVIEW_LINK);
	}

	@Step("Input to Review title textbox with value {0}")
	public void inputToReviewTitleTextbox(String reviewTitle) {
		waitForElementVisibility(driver, BookDetailedPageUI.REVIEW_ITEM_TITLE);
		sendkeyToElement(driver, BookDetailedPageUI.REVIEW_ITEM_TITLE, reviewTitle);
	}
	
	@Step("Input to Review content textarea with value {0}")
	public void inputToReviewContentTextArea(String reviewContent) {
		waitForElementVisibility(driver, BookDetailedPageUI.REIVEW_ITEM_CONTENT);
		sendkeyToElement(driver, BookDetailedPageUI.REIVEW_ITEM_CONTENT, reviewContent);
	}

	@Step("Select rating level radio button with value {0}")
	public void selectRatingLevelRadioButton(String level) {
		waitForElementVisibility(driver, BookDetailedPageUI.RATING_LEVEL, level);
		clickOnRadioButton(driver, BookDetailedPageUI.RATING_LEVEL, level);
	}

	@Step("Click on Submit Review button")
	public void clickOnSubmitReviewButton() {
		waitForElementVisibility(driver, BookDetailedPageUI.SUBMIT_REVIEW_BUTTON);
		clickOnElement(driver, BookDetailedPageUI.SUBMIT_REVIEW_BUTTON);
	}

	@Step("Get Review title of product")
	public String getReviewProductTitle() {
		waitForElementVisibility(driver, BookDetailedPageUI.REVIEW_PRODUCT_TITLE);
		return getTextElement(driver, BookDetailedPageUI.REVIEW_PRODUCT_TITLE);
	}
}
