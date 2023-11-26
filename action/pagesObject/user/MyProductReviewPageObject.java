package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.MyProductReviewUI;

public class MyProductReviewPageObject extends BasePages{
	public MyProductReviewPageObject(WebDriver driver) {
		super(driver);
	}

	@Step("Get Review title value")
	public String getReviewTitleText() {
		waitForElementVisibility(MyProductReviewUI.REVIEWED_TITLE); 
		return getTextElement(MyProductReviewUI.REVIEWED_TITLE); 
	}

	@Step("Get Review text value")
	public String getReviewText() {
		waitForElementVisibility(MyProductReviewUI.REVIEWED_CONTENT); 
		return getTextElement(MyProductReviewUI.REVIEWED_CONTENT); 
	}

	@Step("Get Product Name that is reviewed with value is {0}")
	public String getProductReviewText(String productName) {
		waitForElementVisibility(MyProductReviewUI.REVIEWED_PRODUCT, productName); 
		return getTextElement(MyProductReviewUI.REVIEWED_PRODUCT, productName); 
	}
	
}
