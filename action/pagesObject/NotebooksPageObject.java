package pagesObject;

import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import pagesUI.user.NotebooksPageUI;

public class NotebooksPageObject extends BasePages{
	private WebDriver driver;
	
	public NotebooksPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isNoteBookPageDisplayed() {
		waitForElementVisibility(driver, NotebooksPageUI.NOTEBOOK_TITLE);
		return isElementDisplayed(driver, NotebooksPageUI.NOTEBOOK_TITLE);
	}

	public List<String> getItemListBeforeSortingByName() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForAllElementsVisibility(driver, NotebooksPageUI.LIST_ITEM_TITLES);
		return getAllItemsBeforeSortingByName(driver, NotebooksPageUI.LIST_ITEM_TITLES);
	}
	
	public List<String> getBeforeSortingListByNameWithAscendingOrder(){
		return sortAscendingByName(getItemListBeforeSortingByName());
	}
	
	public List<String> getBeforeSortingListByNameWithDescendingOrder(){
		return sortDescendingByName(getItemListBeforeSortingByName());
	}

	public void selectSortType(String expectedSortType) {
		waitForElementVisibility(driver, NotebooksPageUI.BASE_SORT_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, NotebooksPageUI.BASE_SORT_DROPDOWNLIST, expectedSortType);
	}
	
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
	
	public List<Double> getBeforeSortingListByPriceWithAscendingOrder() {
		return sortAscendingByPrice(getItemListBeforeSortingByPrice());
	}

	public List<Double> getBeforeSortingListByPriceWithDescendingOrder() {
		return sortDescendingByPrice(getItemListBeforeSortingByPrice());
	}
	
	public List<Double> getItemListAfterSortingByPrice(){
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForAllElementsVisibility(driver, NotebooksPageUI.LIST_ITEM_PRICES);
		return getAllItemsAfterSortingByPrice(driver, NotebooksPageUI.LIST_ITEM_PRICES);
	}

	public void selectDisplayType(String expectedType) {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForElementVisibility(driver, NotebooksPageUI.DISPLAY_TYPE_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, NotebooksPageUI.DISPLAY_TYPE_DROPDOWNLIST, expectedType);
	}

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

	public boolean isNextPagingIconDisplayed() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForElementVisibility(driver, NotebooksPageUI.NEXT_PAGING_ICON);
		return isElementDisplayed(driver, NotebooksPageUI.NEXT_PAGING_ICON);
	}

	public boolean isPreviousPagingIconDisplayed() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForElementVisibility(driver, NotebooksPageUI.PREVIOUS_PAGING_ICON);
		return isElementDisplayed(driver, NotebooksPageUI.PREVIOUS_PAGING_ICON);
	}
	
	public boolean isNextPagingIconUndisplayed() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		return isElementUndisplayed(driver, NotebooksPageUI.NEXT_PAGING_ICON);
	}
	
	public boolean isPreviousPagingIconUndisplayed() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		return isElementUndisplayed(driver, NotebooksPageUI.PREVIOUS_PAGING_ICON);
	}

	public void clickOnNextPage() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForElementVisibility(driver, NotebooksPageUI.NEXT_PAGING_ICON);
		clickOnElement(driver, NotebooksPageUI.NEXT_PAGING_ICON);
	}
	
	public void clickOnPreviousPage() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForElementVisibility(driver, NotebooksPageUI.PREVIOUS_PAGING_ICON);
		clickOnElement(driver, NotebooksPageUI.PREVIOUS_PAGING_ICON);
	}
}
