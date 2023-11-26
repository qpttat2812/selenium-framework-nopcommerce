package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.ProductReviewsPageUI;

public class ProductReviewsPageObject extends BasePages{
	public ProductReviewsPageObject(WebDriver driver) {
		super(driver);
	}

	@Step("Input to 'Review Title' textbox with value is {0}")
	public void inputToReviewTitleTextbox(String reviewTitle) {
		waitForElementVisibility(ProductReviewsPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(ProductReviewsPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
	}
	
	@Step("Input to 'Review Content' textarea with value is {0}")
	public void inputToReviewContentTextArea(String reviewContent) {
		waitForElementVisibility(ProductReviewsPageUI.REVIEW_CONTENT_TEXTAREA);
		sendkeyToElement(ProductReviewsPageUI.REVIEW_CONTENT_TEXTAREA, reviewContent);
	}

	@Step("Select 'Rating' Level radio button with value is {0}")
	public void selectRatingLevelRadioButton(String level) {
		waitForElementVisibility(ProductReviewsPageUI.RATING_LEVEL_RADIO_BUTTON, level);
		clickOnRadioButton(ProductReviewsPageUI.RATING_LEVEL_RADIO_BUTTON, level);
	}

	@Step("Click on 'Submit Review' button")
	public void clickOnSubmitReviewButton() {
		waitForElementVisibility(ProductReviewsPageUI.SUBMIT_BUTTON);
		clickOnElement(ProductReviewsPageUI.SUBMIT_BUTTON);
	}

	@Step("Get Review Product title")
	public String getReviewProductTitle() {
		waitForElementVisibility(ProductReviewsPageUI.REVIEW_TITLE);
		return getTextElement(ProductReviewsPageUI.REVIEW_TITLE);
	}

	@Step("Get Product Review Success message")
	public String getProductReviewsSuccessMessage() {
		waitForElementVisibility(ProductReviewsPageUI.PRODUCT_REVIEW_SUCCESS_MESSAGE);
		return getTextElement(ProductReviewsPageUI.PRODUCT_REVIEW_SUCCESS_MESSAGE);
	}

}
