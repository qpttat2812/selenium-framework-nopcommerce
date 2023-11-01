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
import pagesObject.DesktopsPageObject;
import pagesObject.HomePageObject;

public class User_07_Orders extends BaseTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private ComputersPageObject computersPage;
	private DesktopsPageObject desktopsPage;
	private String productTab, productName;
	
	@Parameters({"browser", "url"})
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
		desktopsPage.clickOnProductNameLinkAtSubCategory(driver, productName);
	}
	
	@Test
	public void Orders_01_() {
		
	}
	
	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();
	}
}
