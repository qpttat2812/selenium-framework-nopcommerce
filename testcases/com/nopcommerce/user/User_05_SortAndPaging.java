package com.nopcommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_RegisterAccountAndGetCookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pagesObject.ComputersPageObject;
import pagesObject.HomePageObject;
import pagesObject.LoginPageObject;
import pagesObject.NotebooksPageObject;

public class User_05_SortAndPaging extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private ComputersPageObject computersPage;
	private NotebooksPageObject notebooksPage;
	private LoginPageObject loginPage;
	private String productCategoryName;
	private List<String> itemListBeforeSortingByName, itemListAfterSortingByName;
	private List<Double> itemListBeforeSortingByPrice, itemListAfterSortingByPrice;
	private String defaultSortType;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeClass(String browserName, String pageURL) {
		productCategoryName = "Computers";
		defaultSortType = "Position";
		
		driver = getBrowserName(browserName, pageURL);
		
		homePage = PageGeneratorManager.getHomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageTitleDisplayed());
		
		loginPage = homePage.clickOnLoginLink();
		loginPage.setCookie(driver, Common_01_RegisterAccountAndGetCookie.loggedCookies);
		loginPage.refreshBrowser(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		homePage.clickOnProductTabLink(driver, productCategoryName);

		computersPage = PageGeneratorManager.getComputersPageObject(driver);
		Assert.assertTrue(computersPage.isComputersPageTitleDisplayed());
		
		notebooksPage = computersPage.clickOnNotebooksLink();
		Assert.assertTrue(notebooksPage.isNoteBookPageTitleDisplayed());
	}

	@Test
	public void SortAndPaging_01_SortWithNameAscending() {
		itemListBeforeSortingByName = notebooksPage.getItemListBeforeSortingByNameWithAscendingOrder();
		notebooksPage.selectSortType("Name: A to Z");
		itemListAfterSortingByName = notebooksPage.getItemListAfterSortingByName();

		Assert.assertEquals(itemListAfterSortingByName, itemListBeforeSortingByName);
	}

	@Test
	public void SortAndPaging_02_SortWithNameDescending() {
		notebooksPage.selectSortType(defaultSortType);

		itemListBeforeSortingByName = notebooksPage.getItemListBeforeSortingByNameWithDescendingOrder();
		notebooksPage.selectSortType("Name: Z to A");
		itemListAfterSortingByName = notebooksPage.getItemListAfterSortingByName();

		Assert.assertEquals(itemListAfterSortingByName, itemListBeforeSortingByName);
	}

	@Test
	public void SortAndPaging_03_SortWithPriceAscending() {
		notebooksPage.selectSortType(defaultSortType);

		itemListBeforeSortingByPrice = notebooksPage.getItemListBeforeSortingByPriceWithAscendingOrder();
		notebooksPage.selectSortType("Price: Low to High");
		itemListAfterSortingByPrice = notebooksPage.getItemListAfterSortingByPrice();

		Assert.assertEquals(itemListAfterSortingByPrice, itemListBeforeSortingByPrice);
	}

	@Test
	public void SortAndPaging_04_SortWithPriceDescending() {
		notebooksPage.selectSortType(defaultSortType);

		itemListBeforeSortingByPrice = notebooksPage.getItemListBeforeSortingByPriceWithDescendingOrder();
		notebooksPage.selectSortType("Price: High to Low");
		itemListAfterSortingByPrice = notebooksPage.getItemListAfterSortingByPrice();

		Assert.assertEquals(itemListAfterSortingByPrice, itemListBeforeSortingByPrice);
	}

	@Test
	public void SortAndPaging_05_DisplayThreeProductsInPage() {
		notebooksPage.selectSortType(defaultSortType);

		notebooksPage.selectDisplayType("3");
		Assert.assertTrue(notebooksPage.isItemSizeDisplayedCorrect(3));
		Assert.assertTrue(notebooksPage.isNextPagingIconDisplayed());
		
		notebooksPage.clickOnNextPage();
		Assert.assertTrue(notebooksPage.isPreviousPagingIconDisplayed());
	}

	@Test
	public void SortAndPaging_06_DisplaySixProductsInPage() {
		notebooksPage.selectDisplayType("6");

		Assert.assertTrue(notebooksPage.isItemSizeDisplayedCorrect(6));
		Assert.assertTrue(notebooksPage.isNextPagingIconUndisplayed());
		Assert.assertTrue(notebooksPage.isPreviousPagingIconUndisplayed());
	}

	@Test
	public void SortAndPaging_07_DisplayNineProductsInPage() {
		notebooksPage.selectDisplayType("9");

		Assert.assertTrue(notebooksPage.isItemSizeDisplayedCorrect(9));
		Assert.assertTrue(notebooksPage.isNextPagingIconUndisplayed());
		Assert.assertTrue(notebooksPage.isPreviousPagingIconUndisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();
	}
}
