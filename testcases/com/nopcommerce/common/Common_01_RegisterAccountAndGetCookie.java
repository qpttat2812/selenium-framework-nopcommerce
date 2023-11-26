package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManagerUser;
import pagesObject.user.HomePageObject;
import pagesObject.user.LoginPageObject;
import pagesObject.user.RegisterPageObject;
import utilities.DataHelper;

public class Common_01_RegisterAccountAndGetCookie extends BaseTest {
	private WebDriver driver;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private DataHelper dataFake;
	
	public static Set<Cookie> loggedCookies;
	public static String firstName, lastName, emailAddress, password;
	
	@BeforeTest
	@Parameters({"browser", "environment", "siteType"})
	public void RegisterAndGetLoginCookie(String browsername, String enviromentName, String siteType) {
		dataFake = DataHelper.getData();
		
		emailAddress = dataFake.getEmailAddress();
		firstName = dataFake.getFirstName();
		lastName = dataFake.getLastName();
		password = dataFake.getPassword();
		
		driver = getBrowserName(browsername, enviromentName, siteType);
		homePage = PageGeneratorManagerUser.getHomePageObject(driver);
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
		
		loggedCookies = homePage.getAllCookies();
		
		driver.quit();
	}
}
