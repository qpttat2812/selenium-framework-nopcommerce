package pagesObject.user;

import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.SearchPageUI;

public class SearchPageObject extends BasePages{
	private WebDriver driver;
	
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click on 'Search' button")
	public void clickOnSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickOnElement(driver, SearchPageUI.SEARCH_BUTTON);
	}

	@Step("Get Warning error message")
	public String getWarningErrorMessage() {
		waitForElementVisibility(driver, SearchPageUI.SEARCH_WARNING_MESSAGE);
		return getTextElement(driver, SearchPageUI.SEARCH_WARNING_MESSAGE);
	}
	
	@Step("Get Search error message")
	public String getSearchErrorMessage() {
		waitForElementVisibility(driver, SearchPageUI.SEARCH_ERROR_MESSAGE);
		return getTextElement(driver, SearchPageUI.SEARCH_ERROR_MESSAGE);
	}

	@Step("Input to 'Search' textbox")
	public void inputToSearchTextbox(String searchKeyword) {
		waitForElementVisibility(driver, SearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, searchKeyword);
	}

	@Step("Get Product Quantity value")
	public int getProductQuantityValue() {
		waitForAllElementsVisibility(driver, SearchPageUI.SEARCHED_PRODUCT_LIST_TITLE);
		return getElementSize(driver, SearchPageUI.SEARCHED_PRODUCT_LIST_TITLE);
	}

	@Step("Get list of Product name")
	public List<String> getProductNameList() {
		waitForAllElementsVisibility(driver, SearchPageUI.SEARCHED_PRODUCT_LIST_TITLE);
		return getAllTextElements(driver, SearchPageUI.SEARCHED_PRODUCT_LIST_TITLE);
	}

	@Step("Click on 'Advanced Search' checkbox")
	public void clickOnAdvancedSearchCheckbox() {
		waitForElementVisibility(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
		clickOnElement(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
	}

	@Step("Select 'Search Category' dropdownlist")
	public void selectSearchCategoryDropdownlist(String expectedItem) {
		waitForElementVisibility(driver, SearchPageUI.SEARCH_CATEGORY_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, SearchPageUI.SEARCH_CATEGORY_DROPDOWNLIST, expectedItem);
	}

	@Step("Click on 'Search Sub Category' checkbox")
	public void clickOnSearchSubCategoryCheckbox() {
		waitForElementVisibility(driver, SearchPageUI.SEARCH_SUB_CATEGORY_CHECKBOX);
		clickOnElement(driver, SearchPageUI.SEARCH_SUB_CATEGORY_CHECKBOX);
	}

	@Step("Select 'Manufacturer' dropdownlist")
	public void selectOnManufacturerDropdownlist(String expectedItem) {
		waitForElementVisibility(driver, SearchPageUI.MANUFACTURER_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, SearchPageUI.MANUFACTURER_DROPDOWNLIST, expectedItem);
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
