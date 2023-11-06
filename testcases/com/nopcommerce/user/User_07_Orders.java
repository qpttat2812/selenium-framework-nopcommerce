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
import pagesObject.ComputersPageObject;
import pagesObject.DesktopsDetailedPageObject;
import pagesObject.DesktopsPageObject;
import pagesObject.HomePageObject;

public class User_07_Orders extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private ComputersPageObject computersPage;
	private DesktopsPageObject desktopsPage;
	private DesktopsDetailedPageObject desktopsDetailedPage;
	private String productTab, productName;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeClass(String browserName, String pageURL) {
		productTab = "Computers";
		productName = "Build your own computer";

		driver = getBrowserName(browserName, pageURL);

		homePage = PageGeneratorManager.getHomePageObject(driver);
		homePage.setCookie(driver, Common_01_RegisterAccountAndGetCookie.loggedCookies);
		homePage.refreshBrowser(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		homePage.clickOnProductTabLink(driver, productTab);
		computersPage = PageGeneratorManager.getComputersPageObject(driver);

		desktopsPage = computersPage.clickOnDesktopsLink();
		Assert.assertTrue(desktopsPage.isDesktopsPageTitleDisplayed());

		desktopsPage.clickOnProductNameLinkAtSubCategory(driver, productName);

		desktopsDetailedPage = PageGeneratorManager.getDesktopsDetailedPageObject(driver);
		Assert.assertTrue(desktopsDetailedPage.isProductNameOfDetailedPageDisplayed(driver, productName));
	}

	@Test
	public void Orders_01_AddProductToCart() {
		desktopsDetailedPage.selectProcessorDropdownlist();
		desktopsDetailedPage.selectRamDropdownlist();
		desktopsDetailedPage.selectHddRadioButton();
		desktopsDetailedPage.selectOsRadioButton();
		desktopsDetailedPage.checkOnSoftwareCheckbox();
		desktopsDetailedPage.clickOnAddToCartButton();

		Assert.assertEquals(desktopsDetailedPage.getBarNotificationSuccessText(), "The product has been added to your shopping cart");
		desktopsDetailedPage.clickOnCloseButton();

		int countItem = homePage.getShoppingCartQuantity();
		Assert.assertEquals(countItem, 1);
		Assert.assertEquals(homePage.getMiniCartSummaryText(), "There are " + countItem + " item(s) in your cart.");

		Assert.assertTrue(homePage.getMiniCartProcessorText().contains(expectedProcessor));
		Assert.assertTrue(homePage.getMiniCartRamText().contains(expectedRam));
		Assert.assertTrue(homePage.getMiniCartHddText().contains(expectedHdd));
		Assert.assertTrue(homePage.getMiniCartOsText().contains(expectedOs));
		Assert.assertTrue(homePage.getMiniCartSoftwareText().contains(expectedSoftware));
		Assert.assertEquals(homePage.getMiniCartUnitPriceText(), expectedProductPrice);
		Assert.assertEquals(homePage.getMiniCartQuantityValue(), expectedQuantity);
		Assert.assertEquals(homePage.getMiniCartSubTotalPriceValue(), expectedSubTotalPrice);
	}

	@Test
	public void Orders_02_EditProductInShoppingCart() {
		addToCartPage = homePage.clickOnShoppingCartLink();
		Assert.assertTrue(addToCartPage.isAddToCartPageTitleDisplayed());
		
		desktopsDetailedPage = addToCartPage.clickOnEditLink();

		desktopsDetailedPage.selectProcessorDropdownlist();
		desktopsDetailedPage.selectRamDropdownlist();
		desktopsDetailedPage.selectHddRadioButton();
		desktopsDetailedPage.selectOsRadioButton();
		desktopsDetailedPage.checkOnSoftwareCheckbox();
		desktopsDetailedPage.inputQuantityToTextbox();

		Assert.assertTrue(desktopsDetailedPage.isSubTotalPriceDisplayedCorrect());

		desktopsDetailedPage.clickOnUpdateButton();
		Assert.assertEquals(desktopsDetailedPage.getBarNotificationSuccessText(), "The product has been added to your shopping cart");
		desktopsDetailedPage.clickOnCloseButton();

		int countItem = homePage.getShoppingCartQuantity();
		Assert.assertEquals(countItem, 1);
		Assert.assertEquals(homePage.getMiniCartSummaryText(), "There are " + countItem + " item(s) in your cart.");

		Assert.assertTrue(homePage.getMiniCartProcessorText().contains(expectedProcessor));
		Assert.assertTrue(homePage.getMiniCartRamText().contains(expectedRam));
		Assert.assertTrue(homePage.getMiniCartHddText().contains(expectedHdd));
		Assert.assertTrue(homePage.getMiniCartOsText().contains(expectedOs));
		Assert.assertTrue(homePage.getMiniCartSoftwareText().contains(expectedSoftware));
		Assert.assertEquals(homePage.getMiniCartUnitPriceText(), expectedProductPrice);
		Assert.assertEquals(homePage.getMiniCartQuantityValue(), expectedQuantity);
		Assert.assertEquals(homePage.getMiniCartSubTotalPriceValue(), expectedSubTotalPrice);
	}

	@Test
	public void Orders_03_RemoveFromCart() {
		addToCartPage = homePage.clickOnShoppingCartLink();
		Assert.assertTrue(addToCartPage.isAddToCartPageTitleDisplayed());
		
		addToCartPage.clickOnRemoveIcon();
		Assert.assertTrue(addToCartPage.getEmptyCartText(), "Your Shopping Cart is empty!");
		Assert.assertTrue(addToCartPage.isProductUndisplayed());
	}

	@Test
	public void Orders_04_UpdateShoppingCart() {
		String desktopsName = "Lenovo IdeaCentre 600 All-in-One PC";
		
		homePage.clickOnProductTabLink(driver, productTab);
		
		computersPage = PageGeneratorManager.getComputersPageObject(driver);
		Assert.assertTrue(computersPage.isComputersPageTitleDisplayed());
		
		desktopsPage = computersPage.clickOnDesktopsLink();
		Assert.assertTrue(desktopsPage.isDesktopsPageTitleDisplayed());
		
		desktopsPage.clickOnProductNameLinkAtSubCategory(driver, desktopsName);
		
		desktopsDetailedPage = PageGeneratorManager.getDesktopsDetailedPageObject(driver);
		Assert.assertTrue(desktopsDetailedPage.isProductNameOfDetailedPageDisplayed(driver, desktopsName));
		
		desktopsDetailedPage.clickOnAddToCartButton();
		float desktopsPrice = desktopsDetailedPage.getPriceOfProductAtProductDetailedPage(driver, desktopsName);
		
		Assert.assertEquals(homePage.getBarNotificationSuccessText(), "The product has been added to your shopping cart");
		desktopsDetailedPage.clickOnCloseButton();
		
		Assert.assertEquals(homePage.getShoppingCartQuantity(), 1);
		
		addToCartPage = homePage.clickOnShoppingCartLink();
		Assert.assertTrue(addToCartPage.isAddToCartPageTitleDisplayed());
		
		addToCartPage.inputQuantityToTextBox();
		addToCartPage.clickOnUpdateCartButton();
		
		Assert.assert
	}

	@Test
	public void Orders_05_Checkout_QueuePaymentMethod() {

	}

	@Test
	public void Orders_06_Checkout_CardPaymentMethod() {

	}

	@Test
	public void Orders_07_ReOrder() {

	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();
	}

}
