package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_RegisterAccountAndGetCookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pagesObject.HomePageObject;
import pagesObject.LoginPageObject;
import utilities.DataHelper;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_02_LoginAccount extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private DataHelper dataFake;
	
	private String unregisteredEmail;
	private String unregisteredPassword;
	private String registeredEmail;
	private String registeredPassword;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void BeforeClass(String browserName, String pageURL) {
		dataFake = DataHelper.getData();
		
		unregisteredEmail = dataFake.getEmailAddress();
		unregisteredPassword = dataFake.getPassword();
		registeredEmail = Common_01_RegisterAccountAndGetCookie.emailAddress;
		registeredPassword = Common_01_RegisterAccountAndGetCookie.password;;
		
		driver = getBrowserName(browserName, pageURL);

		homePage = PageGeneratorManager.getHomePageObject(driver);
		loginPage = homePage.clickOnLoginLink();
	}

	@Test
	public void Login_01_InputEmptyData() {
		loginPage.clickOnLoginButton();
		
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter your email");
	}
	
	@Test
	public void Login_02_InvalidEmail() {
		loginPage = homePage.clickOnLoginLink();
		
		loginPage.inputToEmailTextbox("123");
		loginPage.clickOnLoginButton();
		
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void Login_03_InputUnregisteredEmail() {
		loginPage = homePage.clickOnLoginLink();
		
		loginPage.inputToEmailTextbox(unregisteredEmail);
		loginPage.inputToPasswordTextbox(unregisteredPassword);
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.getInvalidErrorMessageText(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_InputRegisteredEmailAndNoPassword() {
		loginPage = homePage.clickOnLoginLink();
		
		loginPage.inputToEmailTextbox(registeredEmail);
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.getInvalidErrorMessageText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_InputRegisteredEmailAndWrongPassword() {
		loginPage = homePage.clickOnLoginLink();
		
		loginPage.inputToEmailTextbox(registeredEmail);
		loginPage.inputToPasswordTextbox(unregisteredPassword);
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.getInvalidErrorMessageText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_InputRegisteredEmailAndPassword() {
		loginPage = homePage.clickOnLoginLink();
		
		loginPage.inputToEmailTextbox(registeredEmail);
		loginPage.inputToPasswordTextbox(registeredPassword);
		homePage = loginPage.clickOnLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();
	}

}
