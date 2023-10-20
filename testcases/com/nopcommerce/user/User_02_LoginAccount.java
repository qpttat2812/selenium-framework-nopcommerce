package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
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

	String emailAddress, password;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void BeforeClass(String browserName, String pageURL) {
		driver = getBrowserName(browserName, pageURL);

		homePage = PageGeneratorManager.getHomePageObject(driver);
		
		emailAddress = User_01_RegisterNewAccount.emailAddress;
		password = User_01_RegisterNewAccount.password;
		
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

		loginPage.inputToEmailTextbox("auto22@yopmail.com");
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.getInvalidErrorMessageText(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_InputRegisteredEmailAndNoPassword() {
		loginPage = homePage.clickOnLoginLink();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.getInvalidErrorMessageText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_InputRegisteredEmailAndWrongPassword() {
		loginPage = homePage.clickOnLoginLink();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("222111");
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.getInvalidErrorMessageText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_InputRegisteredEmailAndPassword() {
		loginPage = homePage.clickOnLoginLink();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickOnLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountDisplayed());
	}

	public int randomNumber() {
		Random rnd = new Random();
		return rnd.nextInt(999);
	}

	@AfterClass
	public void AfterClass() {
		driver.quit();
	}

}
