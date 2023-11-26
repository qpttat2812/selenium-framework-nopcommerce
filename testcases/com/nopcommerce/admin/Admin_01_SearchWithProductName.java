package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagerAdmin;
import pagesObject.admin.DashboardPageObject;
import pagesObject.admin.LoginPageObject;
import pagesObject.admin.ProductsPageObject;

public class Admin_01_SearchWithProductName extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private DashboardPageObject dashboardPage;
	private ProductsPageObject productsPage;

	private String email;
	private String password;
	private String catalogSidebarName;
	private String productsSubSidebarName;
	private String expectedProductName, productNameLabel;
	private String expectedSKUValue, skuLabel;
	private String expectedPriceValue, priceLabel;
	private String expectedQuantityValue, quantityLabel;
	private String expectedPublishedStatus, publishedLabel, editLabel;
	private String pictureLabel;
	private String expectedCategoryValue;
	private String showItem;

	@Parameters({ "browser", "environment", "siteType"})
	@BeforeClass
	public void BeforeClass(String browserName, String environmentName, String siteType) {
		catalogSidebarName = "Catalog";
		productsSubSidebarName = "Products";
		expectedProductName = "Apple MacBook Pro 13-inch";
		expectedSKUValue = "AP_MBP_13";
		expectedPriceValue = "1800";
		expectedQuantityValue = "10000";
		showItem = "100";
		productNameLabel = "Product name";
		priceLabel = "Price";
		quantityLabel = "Stock quantity";
		skuLabel = "SKU";
		publishedLabel = "Published";
		pictureLabel = "Picture";
		expectedPublishedStatus = "true";
		editLabel = "Edit";
		expectedCategoryValue = "Computers >> Desktops";

		driver = getBrowserName(browserName, environmentName, siteType);

		email = GlobalConstants.ADMIN_EMAIL;
		password = GlobalConstants.ADMIN_PASSWORD;

		loginPage = PageGeneratorManagerAdmin.getLoginPageObject(driver);
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		dashboardPage = loginPage.clickOnLoginButton();

		Assert.assertTrue(dashboardPage.isDashboardPageDisplayed());

		dashboardPage.clickOnParentSidebarMenuOfAdmin(catalogSidebarName);
		dashboardPage.clickOnSubSidebarMenuOfAdmin(catalogSidebarName, productsSubSidebarName);

		productsPage = PageGeneratorManagerAdmin.getProductsPageObject(driver);

		productsPage.clickOnShowItems(showItem);
	}

	@Test
	public void TC_01_SearchWithProductName() {
		productsPage.inputToProductNameTextbox(expectedProductName);
		productsPage.clickOnSearchButton();

		Assert.assertTrue(productsPage.isProductImageDisplayed(pictureLabel));
		Assert.assertEquals(productsPage.getProductNameValue(productNameLabel, expectedProductName), expectedProductName);
		Assert.assertEquals(productsPage.getProductSKUValue(skuLabel, expectedSKUValue), expectedSKUValue);
		Assert.assertEquals(productsPage.getProductPriceValue(priceLabel, expectedPriceValue), expectedPriceValue);
		Assert.assertEquals(productsPage.getProductQuantityValue(quantityLabel, expectedQuantityValue), expectedQuantityValue);
		Assert.assertEquals(productsPage.getProductPublishedStatus(publishedLabel, expectedPublishedStatus), expectedPublishedStatus);
		Assert.assertTrue(productsPage.isProductEditButtonDisplayed(editLabel));
	}

	@Test
	public void TC_02_SearchWithSubCategoryIsUnchecked() {
		productsPage.clickOnSubSidebarMenuOfAdmin(catalogSidebarName, productsSubSidebarName);

		productsPage.inputToProductNameTextbox(expectedProductName);
		productsPage.selectCategoryDropdownlist(expectedCategoryValue);
		productsPage.clickOnSearchButton();

		Assert.assertEquals(productsPage.getNoDataMessage(), "No data available in table");
	}

	@Test
	public void TC_03_SearchWithSubCategoryIsChecked() {
		productsPage.clickOnSubSidebarMenuOfAdmin(catalogSidebarName, productsSubSidebarName);

		productsPage.inputToProductNameTextbox(expectedProductName);
		productsPage.selectCategoryDropdownlist(expectedCategoryValue);
		productsPage.checkOnSubCategoryCheckbox();
		productsPage.clickOnSearchButton();

		Assert.assertEquals(productsPage.getNoDataMessage(), "No data available in table");
	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();
	}
}
