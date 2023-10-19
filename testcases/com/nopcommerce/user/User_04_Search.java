package com.nopcommerce.user;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pagesObject.HomePageObject;
import pagesObject.LoginPageObject;
import pagesObject.SearchPageObject;

public class User_04_Search extends BaseTest{
	private WebDriver driver;
	private SearchPageObject searchPage;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	
	private String pageName = "Search";
	private String appleProduct = "Apple MacBook Pro";
	private String searchCategory = "Computers";
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void BeforeClass(String browserName, String pageURl) {
		driver = getBrowserName(browserName, pageURl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get(GlobalConstants.USER_URL);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		loginPage = homePage.clickOnLoginLink();
		loginPage.inputToEmailTextbox(User_03_MyAccountInfo.newEmail);
		loginPage.inputToPasswordTextbox(User_03_MyAccountInfo.newPassword);
		homePage = loginPage.clickOnLoginButton();
		
		homePage.clickOnSearchLink(driver, pageName);
		searchPage = PageGeneratorManager.getSearchPageObject(driver);
	}
	
	@Test
	public void Search_01_InputEmptyData() {
		searchPage.clickOnSearchButton();
		
		Assert.assertEquals(searchPage.getWarningErrorMessage(), "Search term minimum length is 3 characters");
	}
	
	@Test
	public void Search_02_InputNotExistedData() {
		homePage.clickOnSearchLink(driver, pageName);
		searchPage = PageGeneratorManager.getSearchPageObject(driver);
		
		searchPage.inputToSearchTextbox("Macbook Pro 2050");
		searchPage.clickOnSearchButton();
		
		Assert.assertEquals(searchPage.getSearchErrorMessage(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void Search_03_InputRelativeKeyword() {
		homePage.clickOnSearchLink(driver, pageName);
		searchPage = PageGeneratorManager.getSearchPageObject(driver);
		
		searchPage.inputToSearchTextbox("Lenovo");
		searchPage.clickOnSearchButton();
		
		Assert.assertEquals(searchPage.getProductQuantity(), 2);
		Assert.assertTrue(searchPage.isContainedExpectedItem("Lenovo"));
	}
	
	@Test
	public void Search_04_InputAbsoluteKeyword() {
		homePage.clickOnSearchLink(driver, pageName);
		searchPage = PageGeneratorManager.getSearchPageObject(driver);
		
		searchPage.inputToSearchTextbox("Lenovo IdeaCentre 600 All-in-One PC");
		searchPage.clickOnSearchButton();
		
		Assert.assertEquals(searchPage.getProductQuantity(), 1);
		Assert.assertTrue(searchPage.isContainedExpectedItem("Lenovo IdeaCentre 600 All-in-One PC"));
	}
	
	@Test
	public void Search_05_AdvancedSearchWithParentCategories() {
		homePage.clickOnSearchLink(driver, pageName);
		searchPage = PageGeneratorManager.getSearchPageObject(driver);
		
		searchPage.inputToSearchTextbox(appleProduct);		
		searchPage.clickOnAdvancedSearch();
		searchPage.selectSearchCategory(searchCategory);
		searchPage.clickOnSearchButton();
		
		Assert.assertEquals(searchPage.getSearchErrorMessage(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void Search_06_AdvancedSearchWithSubCategories() {
		homePage.clickOnSearchLink(driver, pageName);
		searchPage = PageGeneratorManager.getSearchPageObject(driver);
		
		searchPage.inputToSearchTextbox(appleProduct);		
		searchPage.clickOnAdvancedSearch();
		searchPage.selectSearchCategory(searchCategory);
		searchPage.clickOnSearchSubCategory(); 
		searchPage.clickOnSearchButton();
		
		Assert.assertEquals(searchPage.getProductQuantity(), 1);
		Assert.assertTrue(searchPage.isContainedExpectedItem("Apple MacBook Pro 13-inch"));
	}
	
	@Test
	public void Search_07_AdvancedSearchWithIncorrectManufacturer() {
		homePage.clickOnSearchLink(driver, pageName);
		searchPage = PageGeneratorManager.getSearchPageObject(driver);
		
		searchPage.inputToSearchTextbox(appleProduct);		
		searchPage.clickOnAdvancedSearch();
		searchPage.selectSearchCategory(searchCategory);
		searchPage.clickOnSearchSubCategory(); 
		searchPage.selectOnManufacturer("HP");
		searchPage.clickOnSearchButton();
		
		Assert.assertEquals(searchPage.getSearchErrorMessage(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void Search_08_AdvancedSearchWithCorrectManufacturer() {
		homePage.clickOnSearchLink(driver, pageName);
		searchPage = PageGeneratorManager.getSearchPageObject(driver);
		
		searchPage.inputToSearchTextbox(appleProduct);		
		searchPage.clickOnAdvancedSearch();
		searchPage.selectSearchCategory(searchCategory);
		searchPage.clickOnSearchSubCategory(); 
		searchPage.selectOnManufacturer("Apple");
		searchPage.clickOnSearchButton();
		
		Assert.assertEquals(searchPage.getProductQuantity(), 1);
		Assert.assertTrue(searchPage.isContainedExpectedItem("Apple MacBook Pro 13-inch"));
	}
	
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
}
