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

	@Step("Get Product Name that is reviewed with value {0}")
	public String getProductReviewText(String productName) {
		waitForElementVisibility(driver, MyProductReviewUI.REVIEWED_PRODUCT, productName); 
		return getTextElement(driver, MyProductReviewUI.REVIEWED_PRODUCT, productName); 
	}
	
}
