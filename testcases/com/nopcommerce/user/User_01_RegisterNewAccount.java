package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_RegisterAccountAndGetCookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pagesObject.HomePageObject;
import pagesObject.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_RegisterNewAccount extends BaseTest {
	private WebDriver driver;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private String firstName, lastName, registeredEmail, registeredPassword, validPassword, validEmail;
	private String  invalidEmail, invalidPassword, noMatchconfirmPassword;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void BeforeClass(String browserName, String pageURL) {
		firstName = Common_01_RegisterAccountAndGetCookie.firstName;
		lastName = Common_01_RegisterAccountAndGetCookie.lastName;
		registeredEmail = Common_01_RegisterAccountAndGetCookie.emailAddress;
		invalidEmail = "123@123";
		validEmail = "auto111@gmail.com";
		validPassword = "12345678";
		invalidPassword = "123";
		noMatchconfirmPassword = "1234561";
		registeredPassword = Common_01_RegisterAccountAndGetCookie.password;
		
		driver = getBrowserName(browserName, pageURL);
		
		homePage = PageGeneratorManager.getHomePageObject(driver);
		registerPage = homePage.clickOnRegisterLink();
	}

	@Test
	public void Register_01_InputEmptyData() {
		registerPage.clickOnRegisterButton();
		
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
	}

	@Test
	public void Register_02_InputInvalidEmail() {
		registerPage = homePage.clickOnRegisterLink();
		
		registerPage.inputToFirstNameTextbox(firstName);
		
		registerPage.inputToLastNameTextbox(lastName);
		
		registerPage.inputToEmailTextbox(invalidEmail);
		
		registerPage.inputToPasswordTextbox(validPassword);
		
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		registerPage.clickOnRegisterButton();

		Assert.assertEquals(registerPage.getInvalidErrorMessage(), "Wrong email");
	}

	@Test
	public void Register_03_InputExistedEmail() {
		registerPage = homePage.clickOnRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(registeredEmail);
		registerPage.inputToPasswordTextbox(registeredPassword);
		registerPage.inputToConfirmPasswordTextbox(registeredPassword);
		registerPage.clickOnRegisterButton();

		Assert.assertEquals(registerPage.getInvalidErrorMessage(), "The specified email already exists");
	}

	@Test
	public void Register_04_InputPasswordLessThanSixCharacters() {
		registerPage = homePage.clickOnRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(validEmail);
		registerPage.inputToPasswordTextbox(invalidPassword);
		registerPage.inputToConfirmPasswordTextbox(invalidPassword);
		registerPage.clickOnRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_05_InputConfirmPasswordNotMatchPassword() {
		registerPage = homePage.clickOnRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(validEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(noMatchconfirmPassword);
		registerPage.clickOnRegisterButton();

		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();
	}

}
