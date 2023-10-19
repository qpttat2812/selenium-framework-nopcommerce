package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import pagesUI.user.MyProductReviewUI;

public class MyProductReviewPageObject extends BasePages{
	private WebDriver driver;
	
	public MyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getReviewTitleText() {
		waitForElementVisibility(driver, MyProductReviewUI.REVIEWED_TITLE); 
		return getTextElement(driver, MyProductReviewUI.REVIEWED_TITLE); 
	}

	public String getReviewText() {
		waitForElementVisibility(driver, MyProductReviewUI.REVIEWED_CONTENT); 
		return getTextElement(driver, MyProductReviewUI.REVIEWED_CONTENT); 
	}

	public String getBookReviewText(String bookName) {
		waitForElementVisibility(driver, MyProductReviewUI.REVIEWED_PRODUCT, bookName); 
		return getTextElement(driver, MyProductReviewUI.REVIEWED_PRODUCT, bookName); 
	}
	
}
