package pagesObject;

import java.util.List;

import org.openqa.selenium.WebDriver;

import common.BasePages;
import pagesUI.user.SearchPageUI;

public class SearchPageObject extends BasePages{
	private WebDriver driver;
	
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickOnElement(driver, SearchPageUI.SEARCH_BUTTON);
	}

	public String getWarningErrorMessage() {
		waitForElementVisibility(driver, SearchPageUI.SEARCH_WARNING_MESSAGE);
		return getTextElement(driver, SearchPageUI.SEARCH_WARNING_MESSAGE);
	}
	
	public String getSearchErrorMessage() {
		waitForElementVisibility(driver, SearchPageUI.SEARCH_ERROR_MESSAGE);
		return getTextElement(driver, SearchPageUI.SEARCH_ERROR_MESSAGE);
	}

	public void inputToSearchTextbox(String searchKeyword) {
		waitForElementVisibility(driver, SearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, searchKeyword);
	}

	public int getProductQuantity() {
		waitForAllElementsVisibility(driver, SearchPageUI.SEARCHED_PRODUCT_LIST_TITLE);
		return getElementSize(driver, SearchPageUI.SEARCHED_PRODUCT_LIST_TITLE);
	}

	public List<String> getProductName() {
		waitForAllElementsVisibility(driver, SearchPageUI.SEARCHED_PRODUCT_LIST_TITLE);
		return getAllTextElements(driver, SearchPageUI.SEARCHED_PRODUCT_LIST_TITLE);
	}

	public void clickOnAdvancedSearch() {
		waitForElementVisibility(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
		clickOnElement(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
	}

	public void selectSearchCategory(String expectedItem) {
		waitForElementVisibility(driver, SearchPageUI.SEARCH_CATEGORY_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, SearchPageUI.SEARCH_CATEGORY_DROPDOWNLIST, expectedItem);
	}

	public void clickOnSearchSubCategory() {
		waitForElementVisibility(driver, SearchPageUI.SEARCH_SUB_CATEGORY_CHECKBOX);
		clickOnElement(driver, SearchPageUI.SEARCH_SUB_CATEGORY_CHECKBOX);
	}

	public void selectOnManufacturer(String expectedItem) {
		waitForElementVisibility(driver, SearchPageUI.MANUFACTURER_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, SearchPageUI.MANUFACTURER_DROPDOWNLIST, expectedItem);
	}

	public boolean isContainedExpectedItem(String expectedItem) {
		List<String> itemList = getProductName();
		boolean flag = false;
		for(String item:itemList) {
			if(item.contains(expectedItem)) {
				flag = true;
			}
		}
		return flag;
	}
}
