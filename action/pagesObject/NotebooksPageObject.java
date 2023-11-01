package pagesObject;

import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.NotebooksPageUI;

public class NotebooksPageObject extends BasePages{
	private WebDriver driver;
	
	public NotebooksPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Verify Notebook title is displayed")
	public boolean isNoteBookPageTitleDisplayed() {
		waitForElementVisibility(driver, NotebooksPageUI.NOTEBOOK_TITLE);
		return isElementDisplayed(driver, NotebooksPageUI.NOTEBOOK_TITLE);
	}

	public List<String> getItemListBeforeSortingByName() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForAllElementsVisibility(driver, NotebooksPageUI.LIST_ITEM_TITLES);
		return getAllItemsBeforeSortingByName(driver, NotebooksPageUI.LIST_ITEM_TITLES);
	}
	
	@Step("Get Item List before clicking on sorting by name with ascending order")
	public List<String> getItemListBeforeSortingByNameWithAscendingOrder(){
		return sortAscendingByName(getItemListBeforeSortingByName());
	}
	
	@Step("Get Item List before clicking on sorting by name with descending order")
	public List<String> getItemListBeforeSortingByNameWithDescendingOrder(){
		return sortDescendingByName(getItemListBeforeSortingByName());
	}

	@Step("Select sort type")
	public void selectSortType(String expectedSortType) {
		waitForElementVisibility(driver, NotebooksPageUI.BASE_SORT_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, NotebooksPageUI.BASE_SORT_DROPDOWNLIST, expectedSortType);
	}
	
	@Step("Get Item List after sorting by name")
	public List<String> getItemListAfterSortingByName(){
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForAllElementsVisibility(driver, NotebooksPageUI.LIST_ITEM_TITLES);
		return getAllItemsAfterSortingByName(driver, NotebooksPageUI.LIST_ITEM_TITLES);
	}

	public List<Double> getItemListBeforeSortingByPrice() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForAllElementsVisibility(driver, NotebooksPageUI.LIST_ITEM_PRICES);
		return getAllItemsBeforeSortingByPrice(driver, NotebooksPageUI.LIST_ITEM_PRICES);
	}
	
	@Step("Get Item List before clicking on sorting by price with ascending order")
	public List<Double> getItemListBeforeSortingByPriceWithAscendingOrder() {
		return sortAscendingByPrice(getItemListBeforeSortingByPrice());
	}

	@Step("Get Item List before clicking on sorting by price with descending order")
	public List<Double> getItemListBeforeSortingByPriceWithDescendingOrder() {
		return sortDescendingByPrice(getItemListBeforeSortingByPrice());
	}
	
	@Step("Get Item List after sorting by price")
	public List<Double> getItemListAfterSortingByPrice(){
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForAllElementsVisibility(driver, NotebooksPageUI.LIST_ITEM_PRICES);
		return getAllItemsAfterSortingByPrice(driver, NotebooksPageUI.LIST_ITEM_PRICES);
	}

	@Step("Select display type")
	public void selectDisplayType(String expectedType) {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForElementVisibility(driver, NotebooksPageUI.DISPLAY_TYPE_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, NotebooksPageUI.DISPLAY_TYPE_DROPDOWNLIST, expectedType);
	}

	@Step("Verify Item Size is displayed correctly")
	public boolean isItemSizeDisplayedCorrect(int expectedSize) {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForElementVisibility(driver, NotebooksPageUI.LIST_ITEMS_DISPLAY);
		
		if(getElementSize(driver, NotebooksPageUI.LIST_ITEMS_DISPLAY) <= expectedSize) {
			return true;
		}
		else {
			return false;
		}
	}

	@Step("Verify Next paging icon is displayed")
	public boolean isNextPagingIconDisplayed() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForElementVisibility(driver, NotebooksPageUI.NEXT_PAGING_ICON);
		return isElementDisplayed(driver, NotebooksPageUI.NEXT_PAGING_ICON);
	}

	@Step("Verify Previous paging icon is displayed")
	public boolean isPreviousPagingIconDisplayed() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForElementVisibility(driver, NotebooksPageUI.PREVIOUS_PAGING_ICON);
		return isElementDisplayed(driver, NotebooksPageUI.PREVIOUS_PAGING_ICON);
	}
	
	@Step("Verify Next paging icon is undisplayed")
	public boolean isNextPagingIconUndisplayed() {
		return isElementUndisplayed(driver, NotebooksPageUI.NEXT_PAGING_ICON);
	}
	
	@Step("Verify Previous paging icon is undisplayed")
	public boolean isPreviousPagingIconUndisplayed() {
		return isElementUndisplayed(driver, NotebooksPageUI.PREVIOUS_PAGING_ICON);
	}

	@Step("Click on Next page")
	public void clickOnNextPage() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForElementVisibility(driver, NotebooksPageUI.NEXT_PAGING_ICON);
		clickOnElement(driver, NotebooksPageUI.NEXT_PAGING_ICON);
	}
	
	@Step("Click on Previous page")
	public void clickOnPreviousPage() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForElementVisibility(driver, NotebooksPageUI.PREVIOUS_PAGING_ICON);
		clickOnElement(driver, NotebooksPageUI.PREVIOUS_PAGING_ICON);
	}
}
