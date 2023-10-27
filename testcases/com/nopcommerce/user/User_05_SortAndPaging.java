package com.nopcommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pagesObject.ComputersPageObject;
import pagesObject.HomePageObject;
import pagesObject.NotebooksPageObject;

public class User_05_SortAndPaging extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private ComputersPageObject computersPage;
	private NotebooksPageObject notebooksPage;
	private String productCategoryName = "Computers";
	private List<String> itemListBeforeSortingByName, itemListAfterSortingByName;
	private List<Double> itemListBeforeSortingByPrice, itemListAfterSortingByPrice;
	private String defaultSortType = "Position";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeClass(String browserName, String pageURL) {
		driver = getBrowserName(browserName, pageURL);

		homePage = PageGeneratorManager.getHomePageObject(driver);
		homePage.clickOnProductTab(driver, productCategoryName);

		computersPage = PageGeneratorManager.getComputersPageObject(driver);
		notebooksPage = computersPage.clickOnNotebookSubCategory();

		Assert.assertTrue(notebooksPage.isNoteBookPageDisplayed());
	}

	@Test
	public void SortAndPaging_01_SortWithNameAscending() {
		itemListBeforeSortingByName = notebooksPage.getBeforeSortingListByNameWithAscendingOrder();
		notebooksPage.selectSortType("Name: A to Z");
		itemListAfterSortingByName = notebooksPage.getItemListAfterSortingByName();

		Assert.assertEquals(itemListAfterSortingByName, itemListBeforeSortingByName);
	}

	@Test
	public void SortAndPaging_02_SortWithNameDescending() {
		notebooksPage.selectSortType(defaultSortType);

		itemListBeforeSortingByName = notebooksPage.getBeforeSortingListByNameWithDescendingOrder();
		notebooksPage.selectSortType("Name: Z to A");
		itemListAfterSortingByName = notebooksPage.getItemListAfterSortingByName();

		Assert.assertEquals(itemListAfterSortingByName, itemListBeforeSortingByName);
	}

	@Test
	public void SortAndPaging_03_SortWithPriceAscending() {
		notebooksPage.selectSortType(defaultSortType);

		itemListBeforeSortingByPrice = notebooksPage.getBeforeSortingListByPriceWithAscendingOrder();
		notebooksPage.selectSortType("Price: Low to High");
		itemListAfterSortingByPrice = notebooksPage.getItemListAfterSortingByPrice();

		Assert.assertEquals(itemListAfterSortingByPrice, itemListBeforeSortingByPrice);
	}

	@Test
	public void SortAndPaging_04_SortWithPriceDescending() {
		notebooksPage.selectSortType(defaultSortType);

		itemListBeforeSortingByPrice = notebooksPage.getBeforeSortingListByPriceWithDescendingOrder();
		notebooksPage.selectSortType("Price: High to Low");
		itemListAfterSortingByPrice = notebooksPage.getItemListAfterSortingByPrice();

		Assert.assertEquals(itemListAfterSortingByPrice, itemListBeforeSortingByPrice);
	}

	@Test
	public void SortAndPaging_05_DisplayThreeProductsInPage() {
		int expectedSize = 3;

		notebooksPage.selectSortType(defaultSortType);

		notebooksPage.selectDisplayType("3");
		Assert.assertTrue(notebooksPage.isItemSizeDisplayedCorrect(expectedSize));
		Assert.assertTrue(notebooksPage.isNextPagingIconDisplayed());
		
		notebooksPage.clickOnNextPage();
		Assert.assertTrue(notebooksPage.isPreviousPagingIconDisplayed());
	}

	@Test
	public void SortAndPaging_06_DisplaySixProductsInPage() {
		int expectedSize = 6;

		notebooksPage.selectDisplayType("6");

		Assert.assertTrue(notebooksPage.isItemSizeDisplayedCorrect(expectedSize));
		Assert.assertTrue(notebooksPage.isNextPagingIconUndisplayed());
		Assert.assertTrue(notebooksPage.isPreviousPagingIconUndisplayed());
	}

	@Test
	public void SortAndPaging_07_DisplayNineProductsInPage() {
		int expectedSize = 9;

		notebooksPage.selectDisplayType("9");

		Assert.assertTrue(notebooksPage.isItemSizeDisplayedCorrect(expectedSize));
		Assert.assertTrue(notebooksPage.isNextPagingIconUndisplayed());
		Assert.assertTrue(notebooksPage.isPreviousPagingIconUndisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();
	}
}
