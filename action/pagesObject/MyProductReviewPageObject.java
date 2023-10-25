package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.MyProductReviewUI;

public class MyProductReviewPageObject extends BasePages{
	private WebDriver driver;
	
	public MyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Get Review title value")
	public String getReviewTitleText() {
		waitForElementVisibility(driver, MyProductReviewUI.REVIEWED_TITLE); 
		return getTextElement(driver, MyProductReviewUI.REVIEWED_TITLE); 
	}

	@Step("Get Review text value")
	public String getReviewText() {
		waitForElementVisibility(driver, MyProductReviewUI.REVIEWED_CONTENT); 
		return getTextElement(driver, MyProductReviewUI.REVIEWED_CONTENT); 
	}

	@Step("Get Book review value")
	public String getBookReviewText(String bookName) {
		waitForElementVisibility(driver, MyProductReviewUI.REVIEWED_PRODUCT, bookName); 
		return getTextElement(driver, MyProductReviewUI.REVIEWED_PRODUCT, bookName); 
	}
	
}
