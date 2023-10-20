package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pagesObject.HomePageObject;
import pagesObject.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_RegisterNewAccount extends BaseTest {
	private WebDriver driver;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;

	private String firstName, lastName;
	public static String emailAddress, password;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void BeforeClass(String browserName, String pageURL) {
		driver = getBrowserName(browserName, pageURL);
		
		homePage = PageGeneratorManager.getHomePageObject(driver);
		registerPage = homePage.clickOnRegisterLink();
		
		emailAddress = "autotest" + randomNumber() + "@yopmail.com";
		firstName = "Auto";
		lastName = "Test";
		password = "123456";
	}

	@Test
	public void Register_01_InputEmptyData() {
		log.info("Register - Step 01: Click on <Register> button");
		registerPage.clickOnRegisterButton();
		
		log.info("Register - Step 02: Verify error message is displayed at <First Name> textbox");
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
		log.info("Register - Step 03: Verify error message is displayed at <Last Name> textbox");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required");
		
		log.info("Register - Step 04: Verify error message is displayed at <Email> textbox");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required");
		
		log.info("Register - Step 05: Verify error message is displayed at <Password> textbox");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required");
		
		log.info("Register - Step 06: Verify error message is displayed at <Confirm Password> textbox");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required");
	}

	@Test
	public void Register_02_InputInvalidEmail() {
		log.info("Register - Step 01: Navigate to Register page by clicking on Register link from Home Page");
		registerPage = homePage.clickOnRegisterLink();
		
		log.info("Register - Step 02: Input to <First Name> textbox with value is " + firstName);
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("Register - Step 03: Input to <Last Name> textbox with value is " + lastName);
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Register - Step 05: Input to <Email> textbox with value is " + emailAddress);
		registerPage.inputToEmailTextbox("123@123");
		
		log.info("Register - Step 06: Input to <Password> textbox with value is " + password);
		registerPage.inputToPasswordTextbox("123123");
		
		log.info("Register - Step 07: Input to <Confirm Password> textbox with value is " + password);
		registerPage.inputToConfirmPasswordTextbox("123123");
		
		log.info("Register - Step 08: Click on <Register> button");
		registerPage.clickOnRegisterButton();

		log.info("Register - Step 09: Verify error message is displayed at <Email> textbox.");
		Assert.assertEquals(registerPage.getInvalidErrorMessageText(), "Wrong email");
	}

	@Test
	public void Register_03_InputValidInfo() {
		registerPage = homePage.clickOnRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		registerPage.clickOnRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessfullyMessage(), "Your registration completed");
	}

	@Test
	public void Register_04_InputExistedEmail() {
		registerPage = homePage.clickOnRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		registerPage.clickOnRegisterButton();

		Assert.assertEquals(registerPage.getInvalidErrorMessageText(), "The specified email already exists");
	}

	@Test
	public void Register_05_InputPasswordLessThanSixCharacters() {
		registerPage = homePage.clickOnRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");
		registerPage.clickOnRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_InputConfirmPasswordNotMatchPassword() {
		registerPage = homePage.clickOnRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("1234561");
		registerPage.clickOnRegisterButton();

		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
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
