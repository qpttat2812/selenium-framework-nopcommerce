package pagesObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.user.NotebooksPageUI;

public class NotebooksPageObject extends BasePages {
	private WebDriver driver;

	public NotebooksPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Get product name list and select sort type with value {0}")
	public List<String> getBeforeListByProductNameAndSort(String expectedSortType) {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);

		List<WebElement> elements = getElements(driver, NotebooksPageUI.ITEM_NAME_LIST);
		List<String> beforeList = new ArrayList<String>();

		for (WebElement element : elements) {
			beforeList.add(element.getText().trim());
		}

		selectDefaultItemDropdownList(driver, NotebooksPageUI.BASE_SORT_DROPDOWNLIST, expectedSortType);

		if (expectedSortType.contains("Z to A")) {
			Collections.reverse(beforeList);
		} else {
			Collections.sort(beforeList);
		}

		return beforeList;
	}

	@Step("Get product name list after sorting")
	public List<String> getAfterSortListByProductName() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);

		List<WebElement> elements = getElements(driver, NotebooksPageUI.ITEM_NAME_LIST);
		List<String> afterList = new ArrayList<String>();

		for (WebElement element : elements) {
			afterList.add(element.getText().trim());
		}

		return afterList;
	}

	@Step("Get product price list and select sort type with value {0}")
	public List<Float> getBeforeListByProductPriceAndSort(String expectedSortType) {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);

		List<WebElement> elements = getElements(driver, NotebooksPageUI.ITEM_PRICE_LIST);
		List<Float> beforeList = new ArrayList<Float>();

		for (WebElement element : elements) {
			beforeList.add(Float.valueOf(element.getText().trim().replace("$", "").replace(",", "")));
		}

		selectDefaultItemDropdownList(driver, NotebooksPageUI.BASE_SORT_DROPDOWNLIST, expectedSortType);

		if (expectedSortType.contains("High to Low")) {
			Collections.reverse(beforeList);
		} else {
			Collections.sort(beforeList);
		}
		
		return beforeList;
	}

	@Step("Get product price after sorting")
	public List<Float> getAfterSortListByProductPrice() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);

		List<WebElement> elements = getElements(driver, NotebooksPageUI.ITEM_PRICE_LIST);
		List<Float> afterList = new ArrayList<Float>();

		for (WebElement element : elements) {
			afterList.add(Float.valueOf(element.getText().trim().replace("$", "").replace(",", "")));
		}
		
		return afterList;
	}

	@Step("Select 'Display' Type")
	public void selectDisplayType(String expectedType) {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		selectDefaultItemDropdownList(driver, NotebooksPageUI.DISPLAY_TYPE_DROPDOWNLIST, expectedType);
	}

	@Step("Verify Item Size is displayed correctly")
	public boolean isItemSizeDisplayedCorrect(int expectedSize) {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);

		if (getElementSize(driver, NotebooksPageUI.ITEM_DISPLAY_LIST) <= expectedSize) {
			return true;
		} else {
			return false;
		}
	}

	@Step("Verify Next Paging icon is displayed")
	public boolean isNextPagingIconDisplayed() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		return isElementDisplayed(driver, NotebooksPageUI.NEXT_PAGING_ICON);
	}

	@Step("Verify Previous Paging icon is displayed")
	public boolean isPreviousPagingIconDisplayed() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		waitForElementVisibility(driver, NotebooksPageUI.PREVIOUS_PAGING_ICON);
		return isElementDisplayed(driver, NotebooksPageUI.PREVIOUS_PAGING_ICON);
	}

	@Step("Verify Next Paging icon is undisplayed")
	public boolean isNextPagingIconUndisplayed() {
		return isElementUndisplayed(driver, NotebooksPageUI.NEXT_PAGING_ICON);
	}

	@Step("Verify Previous Paging icon is undisplayed")
	public boolean isPreviousPagingIconUndisplayed() {
		return isElementUndisplayed(driver, NotebooksPageUI.PREVIOUS_PAGING_ICON);
	}

	@Step("Click on 'Next' Page")
	public void clickOnNextPage() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		clickOnElement(driver, NotebooksPageUI.NEXT_PAGING_ICON);
	}

	@Step("Click on 'Previous' Page")
	public void clickOnPreviousPage() {
		waitForElementInvisibility(driver, NotebooksPageUI.AJAX_PRODUCT_LOADING_ICON);
		clickOnElement(driver, NotebooksPageUI.PREVIOUS_PAGING_ICON);
	}
}
