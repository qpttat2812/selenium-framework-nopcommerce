package pagesObject.user;

import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.SearchPageUI;

public class SearchPageObject extends BasePages{
	public SearchPageObject(WebDriver driver) {
		super(driver);
	}

	@Step("Click on 'Search' button")
	public void clickOnSearchButton() {
		waitForElementClickable(SearchPageUI.SEARCH_BUTTON);
		clickOnElement(SearchPageUI.SEARCH_BUTTON);
	}

	@Step("Get Warning error message")
	public String getWarningErrorMessage() {
		waitForElementVisibility(SearchPageUI.SEARCH_WARNING_MESSAGE);
		return getTextElement(SearchPageUI.SEARCH_WARNING_MESSAGE);
	}
	
	@Step("Get Search error message")
	public String getSearchErrorMessage() {
		waitForElementVisibility(SearchPageUI.SEARCH_ERROR_MESSAGE);
		return getTextElement(SearchPageUI.SEARCH_ERROR_MESSAGE);
	}

	@Step("Input to 'Search' textbox")
	public void inputToSearchTextbox(String searchKeyword) {
		waitForElementVisibility(SearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(SearchPageUI.SEARCH_TEXTBOX, searchKeyword);
	}

	@Step("Get Product Quantity value")
	public int getProductQuantityValue() {
		waitForAllElementsVisibility(SearchPageUI.SEARCHED_PRODUCT_LIST_TITLE);
		return getElementSize(SearchPageUI.SEARCHED_PRODUCT_LIST_TITLE);
	}

	@Step("Get list of Product name")
	public List<String> getProductNameList() {
		waitForAllElementsVisibility(SearchPageUI.SEARCHED_PRODUCT_LIST_TITLE);
		return getAllTextElements(SearchPageUI.SEARCHED_PRODUCT_LIST_TITLE);
	}

	@Step("Click on 'Advanced Search' checkbox")
	public void clickOnAdvancedSearchCheckbox() {
		waitForElementVisibility(SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
		clickOnElement(SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
	}

	@Step("Select 'Search Category' dropdownlist")
	public void selectSearchCategoryDropdownlist(String expectedItem) {
		waitForElementVisibility(SearchPageUI.SEARCH_CATEGORY_DROPDOWNLIST);
		selectDefaultItemDropdownList(SearchPageUI.SEARCH_CATEGORY_DROPDOWNLIST, expectedItem);
	}

	@Step("Click on 'Search Sub Category' checkbox")
	public void clickOnSearchSubCategoryCheckbox() {
		waitForElementVisibility(SearchPageUI.SEARCH_SUB_CATEGORY_CHECKBOX);
		clickOnElement(SearchPageUI.SEARCH_SUB_CATEGORY_CHECKBOX);
	}

	@Step("Select 'Manufacturer' dropdownlist")
	public void selectOnManufacturerDropdownlist(String expectedItem) {
		waitForElementVisibility(SearchPageUI.MANUFACTURER_DROPDOWNLIST);
		selectDefaultItemDropdownList(SearchPageUI.MANUFACTURER_DROPDOWNLIST, expectedItem);
	}

	@Step("Verify expected item is displayed after searching")
	public boolean isContainedExpectedItem(String expectedItem) {
		List<String> itemList = getProductNameList();
		boolean flag = false;
		for(String item:itemList) {
			if(item.contains(expectedItem)) {
				flag = true;
			}
		}
		return flag;
	}
}
