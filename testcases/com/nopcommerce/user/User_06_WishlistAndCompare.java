package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_RegisterAccountAndGetCookie;

import commons.BaseTest;
import commons.PageGeneratorManagerUser;
import pagesObject.user.AddToCartPageObject;
import pagesObject.user.CompareProductPageObject;
import pagesObject.user.ComputersPageObject;
import pagesObject.user.HomePageObject;
import pagesObject.user.LoginPageObject;
import pagesObject.user.NotebooksDetailedPageObject;
import pagesObject.user.NotebooksPageObject;
import pagesObject.user.RecentProductViewPageObject;
import pagesObject.user.WishlistPageObject;

public class User_06_WishlistAndCompare extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private NotebooksPageObject notebooksPage;
	private ComputersPageObject computersPage;
	private WishlistPageObject wishlistPage;
	private NotebooksDetailedPageObject notebooksDetailedPage;
	private AddToCartPageObject addToCartPage;
	private CompareProductPageObject compareProductPage;
	private RecentProductViewPageObject recentProductView;
	
	private String firstProductName; 
	private String productCategoryName;
	private String secondProductName;
	private String wishlistButton; 
	private String compareButton; 
	private String expectedBarNotificationMessage; 
	private String expectedWishlistSharingName;
	private String pageName;
	private String barNotificationSuccessMessage; 
	private int expectedCartQuantity; 
	private int expectedWishlistQuantity;
	private String notebooksURL;
	private String firstProductPrice; 
	private String secondProductPrice;
	private String homePageURL;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeClass(String browserName, String pageURL) {
		firstProductName = "HP Envy 6-1180ca 15.6-Inch Sleekbook"; 
		productCategoryName = "Computers";
		secondProductName = "Lenovo Thinkpad X1 Carbon Laptop";
		wishlistButton = "Add to wishlist"; 
		compareButton = "Add to compare list"; 
		expectedBarNotificationMessage = "The product has been added to your wishlist"; 
		expectedWishlistSharingName = "Wishlist of " + Common_01_RegisterAccountAndGetCookie.firstName + " " + Common_01_RegisterAccountAndGetCookie.lastName;
		pageName = "Compare products list";
		barNotificationSuccessMessage = "The product has been added to your product comparison"; 
		expectedCartQuantity = 1; 
		expectedWishlistQuantity = 0;
		
		driver = getBrowserName(browserName, pageURL);
		
		homePage = PageGeneratorManagerUser.getHomePageObject(driver);
		
		loginPage = homePage.clickOnLoginLink();
		loginPage.setCookie(driver, Common_01_RegisterAccountAndGetCookie.loggedCookies);
		loginPage.refreshBrowser(driver);
		
		homePage.clickOnProductTabLink(driver, productCategoryName);
		homePageURL = homePage.getCurrentURL(driver);
		
		computersPage = PageGeneratorManagerUser.getComputersPageObject(driver);
		notebooksPage = computersPage.clickOnNotebooksLink();
	}

	@Test
	public void WishlistAndCompare_01_AddToWishlist() {
		notebooksPage.clickOnProductNameLinkAtSubCategory(driver, firstProductName);

		notebooksDetailedPage = PageGeneratorManagerUser.getNotebooksDetailedPageObject(driver);
		notebooksDetailedPage.clickOnActionButton(firstProductName, wishlistButton);
		Assert.assertEquals(notebooksDetailedPage.getBarNotificationSuccessMessage(), expectedBarNotificationMessage);
		homePage.refreshBrowser(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		wishlistPage = homePage.clickOnWishlistLink();
		Assert.assertEquals(wishlistPage.getWishlistProductName(), firstProductName);
		wishlistPage.clickOnWishlistSharingURL();
		Assert.assertEquals(wishlistPage.getWishlistSharingTitle(), expectedWishlistSharingName);
	}

	@Test
	public void WishlistAndCompare_02_AddProductToCartFromWishlist() {
		homePage.openPageURL(driver, homePageURL);
		
		wishlistPage = homePage.clickOnWishlistLink();
		wishlistPage.checkOnAddToCartCheckbox();
		
		addToCartPage = wishlistPage.clickOnAddToCartButton();
		Assert.assertEquals(addToCartPage.getAddToCartProductName(), firstProductName);
		
		Assert.assertEquals(homePage.getShoppingCartQuantity(), expectedCartQuantity);
		Assert.assertEquals(homePage.getWishlistLinkQuantity(), expectedWishlistQuantity);
		
		wishlistPage = homePage.clickOnWishlistLink();
		Assert.assertTrue(wishlistPage.isProductUndisplayed());
		
		addToCartPage = homePage.clickOnShoppingCartLink();
		addToCartPage.clickOnRemoveIcon();
		Assert.assertEquals(addToCartPage.getEmptyCartText(), "Your Shopping Cart is empty!");
	}

	@Test
	public void WishlistAndCompare_03_RemoveProductFromWishlist() {
		homePage.clickOnProductTabLink(driver, productCategoryName);
		
		computersPage = PageGeneratorManagerUser.getComputersPageObject(driver);
		notebooksPage = computersPage.clickOnNotebooksLink();

		notebooksPage.clickOnProductNameLinkAtSubCategory(driver, firstProductName);
		
		notebooksDetailedPage = PageGeneratorManagerUser.getNotebooksDetailedPageObject(driver);
		notebooksDetailedPage.clickOnActionButton(firstProductName, wishlistButton);
		Assert.assertEquals(notebooksDetailedPage.getBarNotificationSuccessMessage(), expectedBarNotificationMessage);
		homePage.refreshBrowser(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		wishlistPage = homePage.clickOnWishlistLink();
		Assert.assertEquals(wishlistPage.getWishlistProductName(), firstProductName);
		wishlistPage.clickOnRemoveIcon();
		Assert.assertTrue(wishlistPage.isWishlistPageEmpty());
	}

	@Test
	public void WishlistAndCompare_04_AddProductToCompare() {
		homePage.clickOnProductTabLink(driver, productCategoryName);
		
		computersPage = PageGeneratorManagerUser.getComputersPageObject(driver);
		notebooksPage = computersPage.clickOnNotebooksLink();
		
		notebooksURL = notebooksPage.getCurrentURL(driver);
		notebooksPage.clickOnProductNameLinkAtSubCategory(driver, firstProductName);
		
		//first product
		notebooksDetailedPage = PageGeneratorManagerUser.getNotebooksDetailedPageObject(driver);
		notebooksDetailedPage.clickOnActionButton(firstProductName, compareButton);
		Assert.assertEquals(notebooksDetailedPage.getBarNotificationSuccessMessage(), barNotificationSuccessMessage);
		
		firstProductPrice = notebooksDetailedPage.getPriceOfProduct(firstProductName);
		
		notebooksDetailedPage.openPageURL(driver, notebooksURL);
		
		//second product
		notebooksPage = PageGeneratorManagerUser.getNotebooksPageObject(driver);
		notebooksPage.clickOnProductNameLinkAtSubCategory(driver, secondProductName);
		
		notebooksDetailedPage = PageGeneratorManagerUser.getNotebooksDetailedPageObject(driver);
		notebooksDetailedPage.clickOnActionButton(secondProductName, compareButton);
		Assert.assertEquals(notebooksDetailedPage.getBarNotificationSuccessMessage(), barNotificationSuccessMessage);
		
		secondProductPrice = notebooksDetailedPage.getPriceOfProduct(secondProductName);
		
		notebooksDetailedPage.clickOnFooterLink(driver, pageName);
		
		compareProductPage = PageGeneratorManagerUser.getCompareProductPageObject(driver);
		Assert.assertEquals(compareProductPage.getProductNameText(firstProductName), firstProductName);
		Assert.assertEquals(compareProductPage.getProductNameText(secondProductName), secondProductName);
		Assert.assertEquals(compareProductPage.getProductPriceText(firstProductName), firstProductPrice);
		Assert.assertEquals(compareProductPage.getProductPriceText(secondProductName), secondProductPrice);
		
		compareProductPage.clickClearListButton();
		Assert.assertEquals(compareProductPage.getCompareEmptyProductText(), "You have no items to compare.");
		Assert.assertTrue(compareProductPage.isCompareProductUndisplayed());
	}

	@Test
	public void WishlistAndCompare_05_RecentlyViewedProduct() {
		String thirdProductName = "Apple MacBook Pro 13-inch";
		String fourthProductName = "Asus N551JK-XO076H Laptop";
		String fifthProductName = "Samsung Series 9 NP900X4C Premium Ultrabook";
		
		homePage.clickOnProductTabLink(driver, productCategoryName);
		
		computersPage = PageGeneratorManagerUser.getComputersPageObject(driver);
		notebooksPage = computersPage.clickOnNotebooksLink();
		
		notebooksURL = notebooksPage.getCurrentURL(driver);
		
		//click on first product and back to category page
		notebooksPage.clickOnProductNameLinkAtSubCategory(driver, firstProductName);
		
		notebooksDetailedPage = PageGeneratorManagerUser.getNotebooksDetailedPageObject(driver);
		notebooksDetailedPage.openPageURL(driver, notebooksURL);
		
		//click on second product and back to category page
		notebooksPage = PageGeneratorManagerUser.getNotebooksPageObject(driver);
		notebooksPage.clickOnProductNameLinkAtSubCategory(driver, secondProductName);
		
		notebooksDetailedPage = PageGeneratorManagerUser.getNotebooksDetailedPageObject(driver);
		notebooksDetailedPage.openPageURL(driver, notebooksURL);
		
		//click on third product and back to category page
		notebooksPage = PageGeneratorManagerUser.getNotebooksPageObject(driver);
		notebooksPage.clickOnProductNameLinkAtSubCategory(driver, thirdProductName);
		
		notebooksDetailedPage = PageGeneratorManagerUser.getNotebooksDetailedPageObject(driver);
		notebooksDetailedPage.openPageURL(driver, notebooksURL);
		
		//click on fourth product and back to category page
		notebooksPage = PageGeneratorManagerUser.getNotebooksPageObject(driver);
		notebooksPage.clickOnProductNameLinkAtSubCategory(driver, fourthProductName);
		
		notebooksDetailedPage = PageGeneratorManagerUser.getNotebooksDetailedPageObject(driver);
		notebooksDetailedPage.openPageURL(driver, notebooksURL);
		
		//click on fifth product
		notebooksPage = PageGeneratorManagerUser.getNotebooksPageObject(driver);
		notebooksPage.clickOnProductNameLinkAtSubCategory(driver, fifthProductName);
		
		notebooksDetailedPage = PageGeneratorManagerUser.getNotebooksDetailedPageObject(driver);
		
		homePage.clickOnFooterLink(driver, "Recently viewed products");
		recentProductView = PageGeneratorManagerUser.getRecentProductViewPageObject(driver);
		
		Assert.assertEquals(recentProductView.getSizeOfRecentProducts(), 3);
		Assert.assertEquals(recentProductView.getProductNameText(thirdProductName), thirdProductName);
		Assert.assertEquals(recentProductView.getProductNameText(fourthProductName), fourthProductName);
		Assert.assertEquals(recentProductView.getProductNameText(fifthProductName), fifthProductName);
		Assert.assertEquals(recentProductView.getProductPriceValue(thirdProductName), thirdProductName);
		Assert.assertEquals(recentProductView.getProductPriceValue(fourthProductName), fourthProductName);
		Assert.assertEquals(recentProductView.getProductPriceValue(fifthProductName), fifthProductName);
		
	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();
	}
}
