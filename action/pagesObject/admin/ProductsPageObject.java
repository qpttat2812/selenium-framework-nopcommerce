package pagesObject.admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePages;
import io.qameta.allure.Step;
import pagesUI.admin.ProductsPageUI;

public class ProductsPageObject extends BasePages {
	private WebDriver driver;

	public ProductsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click on Show Items with value is {0}")
	public void clickOnShowItems(String expectedValue) {
		waitForElementVisibility(driver, ProductsPageUI.SHOW_ITEMS);
		selectDefaultItemDropdownList(driver, ProductsPageUI.SHOW_ITEMS, expectedValue);
	}

	@Step("Input to 'Product name' textbox with value is {0}")
	public void inputToProductNameTextbox(String productName) {
		waitForElementInvisibility(driver, ProductsPageUI.AJAX_LOADING_ICON);
		sendkeyToElement(driver, ProductsPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}

	@Step("Click on 'Search' button")
	public void clickOnSearchButton() {
		waitForElementClickable(driver, ProductsPageUI.SEARCH_BUTTON);
		clickOnElement(driver, ProductsPageUI.SEARCH_BUTTON);
	}

	public boolean isProductImageDisplayed(String pictureLabel) {
		waitForElementInvisibility(driver, ProductsPageUI.AJAX_LOADING_ICON);
		
		int columnIndex = getElements(driver, ProductsPageUI.DYNAMIC_PRODUCT_COLUMN_INDEX, pictureLabel).size() + 1;

		List<WebElement> nameListElement = getElements(driver, ProductsPageUI.DYNAMIC_PRODUCT_PICTURE_ROW_INDEX, String.valueOf(columnIndex));
		
		boolean imageDisplayed = false;
		
		for (WebElement name : nameListElement) {
			if (checkImageLoadedAndDisplayed(driver, name)) {
				imageDisplayed = true;
				break;
			}
		}
		
		return imageDisplayed;
	}

	@Step("Get Product Name in table")
	public String getProductNameValue(String productNameLabel, String expectedProductName) {
		waitForElementInvisibility(driver, ProductsPageUI.AJAX_LOADING_ICON);

		String productName = "";
		int columnIndex = getElements(driver, ProductsPageUI.DYNAMIC_PRODUCT_COLUMN_INDEX, productNameLabel).size() + 1;

		List<WebElement> nameListElement = getElements(driver, ProductsPageUI.DYNAMIC_PRODUCT_INFO_ROW_INDEX, String.valueOf(columnIndex));

		for (WebElement name : nameListElement) {
			if (name.getText().contains(expectedProductName)) {
				productName = name.getText();
				break;
			}
		}

		return productName;
	}

	@Step("Get Product SKU in table")
	public String getProductSKUValue(String skuLabel, String expectedSKUValue) {
		waitForElementInvisibility(driver, ProductsPageUI.AJAX_LOADING_ICON);

		String skuName = "";
		int columnIndex = getElements(driver, ProductsPageUI.DYNAMIC_PRODUCT_COLUMN_INDEX, skuLabel).size() + 1;

		List<WebElement> skuListElement = getElements(driver, ProductsPageUI.DYNAMIC_PRODUCT_INFO_ROW_INDEX, String.valueOf(columnIndex));

		for (WebElement sku : skuListElement) {
			if (sku.getText().contains(expectedSKUValue)) {
				skuName = sku.getText();
				break;
			}
		}
		return skuName;
	}

	@Step("Get Product Price value in the table")
	public String getProductPriceValue(String priceLabel, String expectedPriceValue) {
		waitForElementInvisibility(driver, ProductsPageUI.AJAX_LOADING_ICON);

		String priceValue = "";
		int columnIndex = getElements(driver, ProductsPageUI.DYNAMIC_PRODUCT_COLUMN_INDEX, priceLabel).size() + 1;

		List<WebElement> priceListElement = getElements(driver, ProductsPageUI.DYNAMIC_PRODUCT_INFO_ROW_INDEX, String.valueOf(columnIndex));

		for (WebElement price : priceListElement) {
			if (price.getText().contains(expectedPriceValue)) {
				priceValue = price.getText();
				break;
			}
		}
		return priceValue;
	}

	@Step("Get Product Quantity value in the table")
	public String getProductQuantityValue(String quantityLabel, String expectedQuantityValue) {
		waitForElementInvisibility(driver, ProductsPageUI.AJAX_LOADING_ICON);

		String quantityValue = "";
		int columnIndex = getElements(driver, ProductsPageUI.DYNAMIC_PRODUCT_COLUMN_INDEX, quantityLabel).size() + 1;

		List<WebElement> quantityListElement = getElements(driver, ProductsPageUI.DYNAMIC_PRODUCT_INFO_ROW_INDEX, String.valueOf(columnIndex));

		for (WebElement quantity : quantityListElement) {
			if (quantity.getText().contains(expectedQuantityValue)) {
				quantityValue = quantity.getText();
				break;
			}
		}
		return quantityValue;
	}

	@Step("Get Product Published Status")
	public String getProductPublishedStatus(String publishedLabel, String expectedStatus) {
		waitForElementInvisibility(driver, ProductsPageUI.AJAX_LOADING_ICON);

		String statusResult = "";
		int columnIndex = getElements(driver, ProductsPageUI.DYNAMIC_PRODUCT_COLUMN_INDEX, publishedLabel).size() + 1;

		List<WebElement> statusListElement = getElements(driver, ProductsPageUI.DYNAMIC_PRODUCT_PUBLISHED_ROW_INDEX, String.valueOf(columnIndex));

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
		waitForElementInvisibility(driver, ProductsPageUI.AJAX_LOADING_ICON);

		int columnIndex = getElements(driver, ProductsPageUI.DYNAMIC_PRODUCT_COLUMN_INDEX, editLabel).size() + 1;
		List<WebElement> editButtonList = getElements(driver, ProductsPageUI.DYNAMIC_PRODUCT_EDIT_ROW_INDEX, String.valueOf(columnIndex));
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
		waitForElementVisibility(driver, ProductsPageUI.CATEGORY_DROPDOWNLIST);
		selectDefaultItemDropdownList(driver, ProductsPageUI.CATEGORY_DROPDOWNLIST, expectedCategoryValue);
	}

	@Step("Check on 'Search subcategories' checkbox")
	public void checkOnSubCategoryCheckbox() {
		waitForElementClickable(driver, ProductsPageUI.SUB_CATEGORY_CHECKBOX);
		checkOnCheckbox(driver, ProductsPageUI.SUB_CATEGORY_CHECKBOX);
	}

	@Step("Get No Data message")
	public String getNoDataMessage() {
		waitForElementVisibility(driver, ProductsPageUI.NO_DATA_MESSAGE);
		return getTextElement(driver, ProductsPageUI.NO_DATA_MESSAGE);
	}
}
