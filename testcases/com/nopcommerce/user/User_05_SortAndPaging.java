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
import commons.PageGeneratorManagerUser;
import pagesObject.user.ComputersPageObject;
import pagesObject.user.HomePageObject;
import pagesObject.user.LoginPageObject;
import pagesObject.user.NotebooksPageObject;

public class User_05_SortAndPaging extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private ComputersPageObject computersPage;
	private NotebooksPageObject notebooksPage;
	private LoginPageObject loginPage;
	
	private String productCategoryName;
	private List<String> itemListBeforeSortingByName, itemListAfterSortingByName;
	private List<Float> itemListBeforeSortingByPrice, itemListAfterSortingByPrice;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeClass(String browserName, String pageURL) {
		productCategoryName = "Computers";
		
		driver = getBrowserName(browserName, pageURL);
		
		homePage = PageGeneratorManagerUser.getHomePageObject(driver);
		
		loginPage = homePage.clickOnLoginLink();
		loginPage.setCookie(driver, Common_01_RegisterAccountAndGetCookie.loggedCookies);
		loginPage.refreshBrowser(driver);

		homePage.clickOnProductTabLink(driver, productCategoryName);
		computersPage = PageGeneratorManagerUser.getComputersPageObject(driver);
		notebooksPage = computersPage.clickOnNotebooksLink();
	}

	@Test
	public void SortAndPaging_01_SortWithNameAscending() {
		itemListBeforeSortingByName = notebooksPage.getBeforeListByProductNameAndSort("Name: A to Z");
		itemListAfterSortingByName = notebooksPage.getAfterSortListByProductName();

		Assert.assertEquals(itemListAfterSortingByName, itemListBeforeSortingByName);
	}

	@Test
	public void SortAndPaging_02_SortWithNameDescending() {
		itemListBeforeSortingByName = notebooksPage.getBeforeListByProductNameAndSort("Name: Z to A");
		itemListAfterSortingByName = notebooksPage.getAfterSortListByProductName();

		Assert.assertEquals(itemListAfterSortingByName, itemListBeforeSortingByName);
	}

	@Test
	public void SortAndPaging_03_SortWithPriceAscending() {
		itemListBeforeSortingByPrice = notebooksPage.getBeforeListByProductPriceAndSort("Price: Low to High");
		itemListAfterSortingByPrice = notebooksPage.getAfterSortListByProductPrice();

		Assert.assertEquals(itemListAfterSortingByPrice, itemListBeforeSortingByPrice);
	}

	@Test
	public void SortAndPaging_04_SortWithPriceDescending() {
		itemListBeforeSortingByPrice = notebooksPage.getBeforeListByProductPriceAndSort("Price: High to Low");
		itemListAfterSortingByPrice = notebooksPage.getAfterSortListByProductPrice();

		Assert.assertEquals(itemListAfterSortingByPrice, itemListBeforeSortingByPrice);
	}

	@Test
	public void SortAndPaging_05_DisplayThreeProductsInPage() {
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
