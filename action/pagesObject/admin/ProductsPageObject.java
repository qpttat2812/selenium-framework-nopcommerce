package pagesObject.admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.admin.ProductsPageUI;

public class ProductsPageObject extends BasePages {
	public ProductsPageObject(WebDriver driver) {
		super(driver);
	}

	@Step("Click on Show Items with value is {0}")
	public void clickOnShowItems(String expectedValue) {
		waitForElementVisibility(ProductsPageUI.SHOW_ITEMS);
		selectDefaultItemDropdownList(ProductsPageUI.SHOW_ITEMS, expectedValue);
	}

	@Step("Input to 'Product name' textbox with value is {0}")
	public void inputToProductNameTextbox(String productName) {
		waitForElementInvisibility(ProductsPageUI.AJAX_LOADING_ICON);
		sendkeyToElement(ProductsPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}

	@Step("Click on 'Search' button")
	public void clickOnSearchButton() {
		waitForElementClickable(ProductsPageUI.SEARCH_BUTTON);
		clickOnElement(ProductsPageUI.SEARCH_BUTTON);
	}

	public boolean isProductImageDisplayed(String pictureLabel) {
		waitForElementInvisibility(ProductsPageUI.AJAX_LOADING_ICON);
		
		int columnIndex = getElements(ProductsPageUI.DYNAMIC_PRODUCT_COLUMN_INDEX, pictureLabel).size() + 1;

		List<WebElement> nameListElement = getElements(ProductsPageUI.DYNAMIC_PRODUCT_PICTURE_ROW_INDEX, String.valueOf(columnIndex));
		
		boolean imageDisplayed = false;
		
		for (WebElement name : nameListElement) {
			if (checkImageLoadedAndDisplayed(name)) {
				imageDisplayed = true;
				break;
			}
		}
		
		return imageDisplayed;
	}

	@Step("Get Product Name in table")
	public String getProductNameValue(String productNameLabel, String expectedProductName) {
		waitForElementInvisibility(ProductsPageUI.AJAX_LOADING_ICON);
		return getValueFromDataTable(ProductsPageUI.DYNAMIC_PRODUCT_COLUMN_INDEX, ProductsPageUI.DYNAMIC_PRODUCT_INFO_ROW_INDEX, productNameLabel, expectedProductName);
	}

	@Step("Get Product SKU in table")
	public String getProductSKUValue(String skuLabel, String expectedSKUValue) {
		waitForElementInvisibility(ProductsPageUI.AJAX_LOADING_ICON);
		return getValueFromDataTable(ProductsPageUI.DYNAMIC_PRODUCT_COLUMN_INDEX, ProductsPageUI.DYNAMIC_PRODUCT_INFO_ROW_INDEX, skuLabel, expectedSKUValue);
	}

	@Step("Get Product Price value in the table")
	public String getProductPriceValue(String priceLabel, String expectedPriceValue) {
		waitForElementInvisibility(ProductsPageUI.AJAX_LOADING_ICON);
		return getValueFromDataTable(ProductsPageUI.DYNAMIC_PRODUCT_COLUMN_INDEX, ProductsPageUI.DYNAMIC_PRODUCT_INFO_ROW_INDEX, priceLabel, expectedPriceValue);
	}

	@Step("Get Product Quantity value in the table")
	public String getProductQuantityValue(String quantityLabel, String expectedQuantityValue) {
		waitForElementInvisibility(ProductsPageUI.AJAX_LOADING_ICON);
		return getValueFromDataTable(ProductsPageUI.DYNAMIC_PRODUCT_COLUMN_INDEX, ProductsPageUI.DYNAMIC_PRODUCT_INFO_ROW_INDEX, quantityLabel, expectedQuantityValue);
	}

	@Step("Get Product Published Status")
	public String getProductPublishedStatus(String publishedLabel, String expectedStatus) {
		waitForElementInvisibility(ProductsPageUI.AJAX_LOADING_ICON);

		String statusResult = "";
		int columnIndex = getElements(ProductsPageUI.DYNAMIC_PRODUCT_COLUMN_INDEX, publishedLabel).size() + 1;

		List<WebElement> statusListElement = getElements(ProductsPageUI.DYNAMIC_PRODUCT_PUBLISHED_ROW_INDEX, String.valueOf(columnIndex));

		for (WebElement status : statusListElement) {
			if (status.getAttribute("nop-value").contains(expectedStatus)) {
				statusResult = status.getAttribute("nop-value");
				break;
			}
		}
		return statusResult;
	}

	@Step("Verify 'Edit' button is displayed")
	public boolean isProductEditButtonDisplayed(String editLabel) {
		waitForElementInvisibility(ProductsPageUI.AJAX_LOADING_ICON);

		int columnIndex = getElements(ProductsPageUI.DYNAMIC_PRODUCT_COLUMN_INDEX, editLabel).size() + 1;
		List<WebElement> editButtonList = getElements(ProductsPageUI.DYNAMIC_PRODUCT_EDIT_ROW_INDEX, String.valueOf(columnIndex));
		boolean flag = false;
		
		for(WebElement edit : editButtonList) {
			if (edit.isDisplayed() && edit.isEnabled()) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Step("Select 'Category' dropdownlist with value is {0}")
	public void selectCategoryDropdownlist(String expectedCategoryValue) {
		waitForElementVisibility(ProductsPageUI.CATEGORY_DROPDOWNLIST);
		selectDefaultItemDropdownList(ProductsPageUI.CATEGORY_DROPDOWNLIST, expectedCategoryValue);
	}

	@Step("Check on 'Search subcategories' checkbox")
	public void checkOnSubCategoryCheckbox() {
		waitForElementClickable(ProductsPageUI.SUB_CATEGORY_CHECKBOX);
		checkOnCheckbox(ProductsPageUI.SUB_CATEGORY_CHECKBOX);
	}

	@Step("Get No Data message")
	public String getNoDataMessage() {
		waitForElementVisibility(ProductsPageUI.NO_DATA_MESSAGE);
		return getTextElement(ProductsPageUI.NO_DATA_MESSAGE);
	}
}
