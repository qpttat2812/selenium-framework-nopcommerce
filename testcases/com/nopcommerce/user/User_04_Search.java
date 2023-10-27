package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_RegisterAccountAndGetCookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pagesObject.HomePageObject;
import pagesObject.LoginPageObject;
import pagesObject.SearchPageObject;

public class User_04_Search extends BaseTest {
	private WebDriver driver;
	private SearchPageObject searchPage;
	private LoginPageObject loginPage;
	private HomePageObject homePage;

	private String pageName;
	private String appleProduct;
	private String searchCategory;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeClass(String browserName, String pageURl) {
		pageName = "Search";
		appleProduct = "Apple MacBook Pro";
		searchCategory = "Computers";

		driver = getBrowserName(browserName, pageURl);

		homePage = PageGeneratorManager.getHomePageObject(driver);
		loginPage = homePage.clickOnLoginLink();
		loginPage.setCookie(driver, Common_01_RegisterAccountAndGetCookie.loggedCookies);
		loginPage.refreshBrowser(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		homePage.clickOnFooterLink(driver, pageName);
		searchPage = PageGeneratorManager.getSearchPageObject(driver);
	}

	@Test
	public void Search_01_InputEmptyData() {
		searchPage.clickOnSearchButton();

		Assert.assertEquals(searchPage.getWarningErrorMessage(), "Search term minimum length is 3 characters");
	}

	@Test
	public void Search_02_InputNotExistedData() {
		homePage.clickOnFooterLink(driver, pageName);
		searchPage = PageGeneratorManager.getSearchPageObject(driver);

		searchPage.inputToSearchTextbox("Macbook Pro 2050");
		searchPage.clickOnSearchButton();

		Assert.assertEquals(searchPage.getSearchErrorMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_03_InputRelativeKeyword() {
		homePage.clickOnFooterLink(driver, pageName);
		searchPage = PageGeneratorManager.getSearchPageObject(driver);

		searchPage.inputToSearchTextbox("Lenovo");
		searchPage.clickOnSearchButton();

		Assert.assertEquals(searchPage.getProductQuantityValue(), 2);
		Assert.assertTrue(searchPage.isContainedExpectedItem("Lenovo"));
	}

	@Test
	public void Search_04_InputAbsoluteKeyword() {
		homePage.clickOnFooterLink(driver, pageName);
		searchPage = PageGeneratorManager.getSearchPageObject(driver);

		searchPage.inputToSearchTextbox("Lenovo IdeaCentre 600 All-in-One PC");
		searchPage.clickOnSearchButton();

		Assert.assertEquals(searchPage.getProductQuantityValue(), 1);
		Assert.assertTrue(searchPage.isContainedExpectedItem("Lenovo IdeaCentre 600 All-in-One PC"));
	}

	@Test
	public void Search_05_AdvancedSearchWithParentCategories() {
		homePage.clickOnFooterLink(driver, pageName);
		searchPage = PageGeneratorManager.getSearchPageObject(driver);

		searchPage.inputToSearchTextbox(appleProduct);
		searchPage.clickOnAdvancedSearchCheckbox();
		searchPage.selectSearchCategoryDropdownlist(searchCategory);
		searchPage.clickOnSearchButton();

		Assert.assertEquals(searchPage.getSearchErrorMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_06_AdvancedSearchWithSubCategories() {
		homePage.clickOnFooterLink(driver, pageName);
		searchPage = PageGeneratorManager.getSearchPageObject(driver);

		searchPage.inputToSearchTextbox(appleProduct);
		searchPage.clickOnAdvancedSearchCheckbox();
		searchPage.selectSearchCategoryDropdownlist(searchCategory);
		searchPage.clickOnSearchSubCategoryCheckbox();
		searchPage.clickOnSearchButton();

		Assert.assertEquals(searchPage.getProductQuantityValue(), 1);
		Assert.assertTrue(searchPage.isContainedExpectedItem("Apple MacBook Pro 13-inch"));
	}

	@Test
	public void Search_07_AdvancedSearchWithIncorrectManufacturer() {
		homePage.clickOnFooterLink(driver, pageName);
		searchPage = PageGeneratorManager.getSearchPageObject(driver);

		searchPage.inputToSearchTextbox(appleProduct);
		searchPage.clickOnAdvancedSearchCheckbox();
		searchPage.selectSearchCategoryDropdownlist(searchCategory);
		searchPage.clickOnSearchSubCategoryCheckbox();
		searchPage.selectOnManufacturerDropdownlist("HP");
		searchPage.clickOnSearchButton();

		Assert.assertEquals(searchPage.getSearchErrorMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_08_AdvancedSearchWithCorrectManufacturer() {
		homePage.clickOnFooterLink(driver, pageName);
		searchPage = PageGeneratorManager.getSearchPageObject(driver);

		searchPage.inputToSearchTextbox(appleProduct);
		searchPage.clickOnAdvancedSearchCheckbox();
		searchPage.selectSearchCategoryDropdownlist(searchCategory);
		searchPage.clickOnSearchSubCategoryCheckbox();
		searchPage.selectOnManufacturerDropdownlist("Apple");
		searchPage.clickOnSearchButton();

		Assert.assertEquals(searchPage.getProductQuantityValue(), 1);
		Assert.assertTrue(searchPage.isContainedExpectedItem("Apple MacBook Pro 13-inch"));
	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();
	}
}
