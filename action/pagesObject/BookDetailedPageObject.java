package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pagesUI.user.BookDetailedPageUI;

public class BookDetailedPageObject extends BasePages{
	private WebDriver driver;
	
	public BookDetailedPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click on 'Add Your Review' textlink")
	public ProductReviewsPageObject clickOnAddReviewLink() {
		waitForElementVisibility(driver, BookDetailedPageUI.ADD_REVIEW_LINK);
		clickOnElement(driver, BookDetailedPageUI.ADD_REVIEW_LINK);
		return PageGeneratorManager.getProductReviewsPageObject(driver);
	}
}
