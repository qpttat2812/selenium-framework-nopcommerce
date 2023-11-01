package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_RegisterAccountAndGetCookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pagesObject.HomePageObject;
import pagesObject.LoginPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_02_LoginAccount extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private String unregisteredEmail, registeredEmail, registeredPassword;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void BeforeClass(String browserName, String pageURL) {
		unregisteredEmail = "auto" + randomNumber() + "@yopmail.com";
		registeredEmail = Common_01_RegisterAccountAndGetCookie.emailAddress;
		registeredPassword = Common_01_RegisterAccountAndGetCookie.password;
		
		driver = getBrowserName(browserName, pageURL);

		homePage = PageGeneratorManager.getHomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageTitleDisplayed());
		
		loginPage = homePage.clickOnLoginLink();
		Assert.assertTrue(loginPage.isLoginPageTitleDisplayed());
	}

	@Test
	public void Login_01_InputEmptyData() {
		loginPage.clickOnLoginButton();
		
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter your email");
	}
	
	@Test
	public void Login_02_InvalidEmail() {
		loginPage = homePage.clickOnLoginLink();
		Assert.assertTrue(loginPage.isLoginPageTitleDisplayed());
		
		loginPage.inputToEmailTextbox("123");
		loginPage.clickOnLoginButton();
		
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void Login_03_InputUnregisteredEmail() {
		loginPage = homePage.clickOnLoginLink();
		Assert.assertTrue(loginPage.isLoginPageTitleDisplayed());
		
		loginPage.inputToEmailTextbox(unregisteredEmail);
		loginPage.inputToPasswordTextbox("222333");
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.getInvalidErrorMessageText(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_InputRegisteredEmailAndNoPassword() {
		loginPage = homePage.clickOnLoginLink();
		Assert.assertTrue(loginPage.isLoginPageTitleDisplayed());
		
		loginPage.inputToEmailTextbox(registeredEmail);
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.getInvalidErrorMessageText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_InputRegisteredEmailAndWrongPassword() {
		loginPage = homePage.clickOnLoginLink();
		Assert.assertTrue(loginPage.isLoginPageTitleDisplayed());
		
		loginPage.inputToEmailTextbox(registeredEmail);
		loginPage.inputToPasswordTextbox("222333");
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.getInvalidErrorMessageText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_InputRegisteredEmailAndPassword() {
		loginPage = homePage.clickOnLoginLink();
		Assert.assertTrue(loginPage.isLoginPageTitleDisplayed());
		
		loginPage.inputToEmailTextbox(registeredEmail);
		loginPage.inputToPasswordTextbox(registeredPassword);
		homePage = loginPage.clickOnLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	public int randomNumber() {
		Random rnd = new Random();
		return rnd.nextInt(999);
	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();
	}

}
