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
import pagesObject.AddToCartPageObject;
import pagesObject.ComputersPageObject;
import pagesObject.HomePageObject;
import pagesObject.LoginPageObject;
import pagesObject.NotebooksDetailedPageObject;
import pagesObject.NotebooksPageObject;
import pagesObject.WishlistPageObject;

public class User_06_WishlistAndCompare extends BaseTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private String productCategoryName;
	private NotebooksPageObject notebooksPage;
	private ComputersPageObject computersPage;
	private WishlistPageObject wishlistPage;
	private NotebooksDetailedPageObject notebooksDetailedPage;
	private AddToCartPageObject addToCartPage;
	private String productTitle, buttonName, expectedBarNotificationMessage, expectedWishlistSharingTitle;
	private int expectedCartQuantity, expectedWishlistQuantity;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void BeforeClass(String browserName, String pageURL) {
		productCategoryName = "Computers";
		productTitle = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
		buttonName = "Add to wishlist";
		expectedBarNotificationMessage = "The product has been added to your wishlist";
		expectedWishlistSharingTitle = "Wishlist of " + Common_01_RegisterAccountAndGetCookie.firstName + " " + Common_01_RegisterAccountAndGetCookie.lastName;
		expectedCartQuantity = 1;
		expectedWishlistQuantity = 0;
		
		driver = getBrowserName(browserName, pageURL);
		
		homePage = PageGeneratorManager.getHomePageObject(driver);
		loginPage = homePage.clickOnLoginLink();
		loginPage.setCookie(driver, Common_01_RegisterAccountAndGetCookie.loggedCookies);
		loginPage.refreshBrowser(driver);
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		homePage.clickOnProductTab(driver, productCategoryName);
		computersPage = PageGeneratorManager.getComputersPageObject(driver);
		notebooksPage = computersPage.clickOnNotebookSubCategory();
		
		Assert.assertTrue(notebooksPage.isNoteBookPageDisplayed());
	}
	
	@Test
	public void WishlistAndCompare_01_AddToWishlist() {
		notebooksPage.clickOnProductTitleLink(driver, productTitle);
		
		notebooksDetailedPage = PageGeneratorManager.getNotebooksDetailedPageObject(driver);
		notebooksDetailedPage.clickOnActionButton(driver, productTitle, buttonName);
		
		Assert.assertEquals(notebooksDetailedPage.getBarNotificationSuccessText(), expectedBarNotificationMessage);
		notebooksDetailedPage.clickOnCloseButton();
		
		wishlistPage = homePage.clickOnWishlistLink();
		Assert.assertEquals(wishlistPage.getProductTitle(), productTitle);
		
		wishlistPage.clickOnWishlistSharingURL();
		Assert.assertEquals(wishlistPage.getWishlistSharingTitle(), expectedWishlistSharingTitle);
	}
	
	@Test
	public void WishlistAndCompare_02_AddProductToCartFromWishlist() {
		homePage.clickOnHeaderLogo();
		wishlistPage = homePage.clickOnWishlistLink();
		
		wishlistPage.checkOnAddToCartCheckbox();
		addToCartPage = wishlistPage.clickOnAddToCartButton();
		
		Assert.assertEquals(addToCartPage.getProductTitle(), productTitle);
		Assert.assertEquals(homePage.getShoppingCartQuantity(), expectedCartQuantity);
		Assert.assertEquals(homePage.getWishlistLinkQuantity(), expectedWishlistQuantity);
		wishlistPage = homePage.clickOnWishlistLink();
		Assert.assertTrue(wishlistPage.isProductUndisplayed());
	}
	
	@Test
	public void WishlistAndCompare_03_RemoveProductFromWishlist() {
		
	}
	
	@Test
	public void WishlistAndCompare_04_AddProductToCompare() {
		
	}
	
	@Test
	public void WishlistAndCompare_05_RecentlyViewedProduct() {
		
	}
	
	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();
	}
}
