package pagesObject.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.CompareProductPageUI;

public class CompareProductPageObject extends BasePages {
	public CompareProductPageObject(WebDriver driver) {
		super(driver);
	}

	@Step("Get Product Name text")
	public String getProductNameText(String expectedProductName) {
		waitForElementVisibility(CompareProductPageUI.PRODUCT_NAME_LIST);
		List<WebElement> elements = getElements(CompareProductPageUI.PRODUCT_NAME_LIST);
		String productName = "";

		for (WebElement element : elements) {
			if (element.getText().equals(expectedProductName)) {
				productName = element.getText();
			}
		}
		return productName;
	}
	
	@Step("Get Product Price value with product name is {0}")
	public String getProductPriceText(String expectedProductName) {
		waitForElementVisibility(CompareProductPageUI.PRODUCT_NAME_LIST);
		int productIndex = 0;
		List<WebElement> elements = getElements(CompareProductPageUI.PRODUCT_NAME_LIST);
		
		for(int i = 0; i < elements.size(); i++) {
			if(elements.get(i).getText().equals(expectedProductName)) {
				productIndex = i + 1;
			}
		}
		sleepInSecond(3);
		return getTextElement(CompareProductPageUI.DYNAMIC_COMPARE_PRODUCT_PRICE, String.valueOf(productIndex));
	}
	
	@Step("Click on 'Clear' list button")
	public void clickClearListButton() {
		waitForElementClickable(CompareProductPageUI.CLEAR_LIST_BUTTON);
		clickOnElement(CompareProductPageUI.CLEAR_LIST_BUTTON);
	}

	@Step("Get Text when there's no product in Compare Product Page")
	public String getCompareEmptyProductText() {
		waitForElementVisibility(CompareProductPageUI.EMPTY_PRODUCT_MESSSAGE);
		return getTextElement(CompareProductPageUI.EMPTY_PRODUCT_MESSSAGE);
	}
	
	@Step("Verify Products in Compare product page is undisplayed")
	public boolean isCompareProductUndisplayed() {
		return isElementUndisplayed(CompareProductPageUI.PRODUCT_NAME_LIST);
	}
}
