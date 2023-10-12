package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalConstants;
import common.PageGeneratorManager;
import pagesObject.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_RegisterNewAccount extends BaseTest {
	private WebDriver driver;
	private RegisterPageObject registerPage;

	String firstName, lastName, emailAddress, password;

	@Parameters("browser")
	@BeforeClass
	public void BeforeClass(String browserName) {
		driver = getBrowserName(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));

		driver.get(GlobalConstants.REGISTER_URL);

		emailAddress = "autotest" + randomNumber() + "@yopmail.com";
		firstName = "Auto";
		lastName = "Test";
		password = "123123";

	}

	@Test
	public void Register_01_InputEmptyData() {
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
		
		registerPage.clickOnRegisterButton();
		Assert.assertTrue(registerPage.isRequiredErrorMessageDisplayedAtTextbox("First name"));
		Assert.assertTrue(registerPage.isRequiredErrorMessageDisplayedAtTextbox("Last name"));
		Assert.assertTrue(registerPage.isRequiredErrorMessageDisplayedAtTextbox("Email"));
		Assert.assertTrue(registerPage.isRequiredErrorMessageDisplayedAtTextbox("Password"));
		Assert.assertTrue(registerPage.isRequiredErrorMessageDisplayedAtTextbox("Password"));
		
	}
	
	@Test
	public void Register_02_InputInvalidEmail() {
		registerPage.inputToTextboxAtRegisterPage(firstName, "FirstName");
		registerPage.inputToTextboxAtRegisterPage(lastName, "LastName");
		registerPage.inputToTextboxAtRegisterPage("123@234", "Email");
		registerPage.inputToTextboxAtRegisterPage(password, "Password");
		registerPage.inputToTextboxAtRegisterPage(password, "ConfirmPassword");
		registerPage.clickOnRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageTextAtHeader(), "Wrong email");
	}
	
	@Test
	public void Register_03_InputValidInfo() {
		registerPage.inputToTextboxAtRegisterPage(firstName, "FirstName");
		registerPage.inputToTextboxAtRegisterPage(lastName, "LastName");
		registerPage.inputToTextboxAtRegisterPage(emailAddress, "Email");
		registerPage.inputToTextboxAtRegisterPage(password, "Password");
		registerPage.inputToTextboxAtRegisterPage(password, "ConfirmPassword");
		registerPage.clickOnRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessfullyText(), "Your registration completed");
	}
	
	@Test
	public void Register_04_InputExistedEmail() {
		registerPage.clickTextLinkAtHeaderOfPages(driver, "Register");
		
		registerPage.inputToTextboxAtRegisterPage(firstName, "FirstName");
		registerPage.inputToTextboxAtRegisterPage(lastName, "LastName");
		registerPage.inputToTextboxAtRegisterPage(emailAddress, "Email");
		registerPage.inputToTextboxAtRegisterPage(password, "Password");
		registerPage.inputToTextboxAtRegisterPage(password, "ConfirmPassword");
		registerPage.clickOnRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageTextAtHeader(), "The specified email already exists");
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
