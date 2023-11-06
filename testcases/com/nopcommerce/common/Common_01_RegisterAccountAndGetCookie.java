package com.nopcommerce.common;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pagesObject.HomePageObject;
import pagesObject.LoginPageObject;
import pagesObject.RegisterPageObject;

public class Common_01_RegisterAccountAndGetCookie extends BaseTest {
	private WebDriver driver;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	
	public static Set<Cookie> loggedCookies;
	public static String firstName, lastName, emailAddress, password;
	
	@BeforeTest
	@Parameters({"browser", "url"})
	public void RegisterAndGetLoginCookie(String browsername, String pageURL) {
		emailAddress = "autotest" + randomNumber() + "@gmail.com";
		firstName = "Auto";
		lastName = "Test";
		password = "123456";
		
		driver = getBrowserName(browsername, pageURL);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		registerPage = homePage.clickOnRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickOnRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessfullyMessage(), "Your registration completed");
		
		loginPage = homePage.clickOnLoginLink();
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickOnLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		loggedCookies = homePage.getAllCookies(driver);
		
		driver.quit();
	}

	public int randomNumber() {
		Random rnd = new Random();
		return rnd.nextInt(999);
	}
}
