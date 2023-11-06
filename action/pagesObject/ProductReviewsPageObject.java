package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.ProductReviewsPageUI;

public class ProductReviewsPageObject extends BasePages{
	private WebDriver driver;
	
	public ProductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Input to 'Review Title' textbox with value {0}")
	public void inputToReviewTitleTextbox(String reviewTitle) {
		waitForElementVisibility(driver, ProductReviewsPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, ProductReviewsPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
	}
	
	@Step("Input to 'Review Content' textarea with value {0}")
	public void inputToReviewContentTextArea(String reviewContent) {
		waitForElementVisibility(driver, ProductReviewsPageUI.REVIEW_CONTENT_TEXTAREA);
		sendkeyToElement(driver, ProductReviewsPageUI.REVIEW_CONTENT_TEXTAREA, reviewContent);
	}

	@Step("Select 'Rating' Level radio button with value {0}")
	public void selectRatingLevelRadioButton(String level) {
		waitForElementVisibility(driver, ProductReviewsPageUI.RATING_LEVEL_RADIO_BUTTON, level);
		clickOnRadioButton(driver, ProductReviewsPageUI.RATING_LEVEL_RADIO_BUTTON, level);
	}

	@Step("Click on 'Submit Review' button")
	public void clickOnSubmitReviewButton() {
		waitForElementVisibility(driver, ProductReviewsPageUI.SUBMIT_BUTTON);
		clickOnElement(driver, ProductReviewsPageUI.SUBMIT_BUTTON);
	}

	@Step("Get Review Product title")
	public String getReviewProductTitle() {
		waitForElementVisibility(driver, ProductReviewsPageUI.REVIEW_TITLE);
		return getTextElement(driver, ProductReviewsPageUI.REVIEW_TITLE);
	}

	@Step("Get Product Review Success message")
	public String getProductReviewsSuccessMessage() {
		waitForElementVisibility(driver, ProductReviewsPageUI.PRODUCT_REVIEW_SUCCESS_MESSAGE);
		return getTextElement(driver, ProductReviewsPageUI.PRODUCT_REVIEW_SUCCESS_MESSAGE);
	}

}
