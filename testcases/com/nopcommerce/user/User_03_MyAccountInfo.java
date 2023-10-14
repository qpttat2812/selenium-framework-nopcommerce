package com.nopcommerce.user;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pagesObject.AddressPageObject;
import pagesObject.ChangePasswordPageObject;
import pagesObject.HomePageObject;
import pagesObject.LoginPageObject;
import pagesObject.MyAccountPageObject;

public class User_03_MyAccountInfo extends BaseTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private MyAccountPageObject myAccountPage;
	private AddressPageObject addressPage;
	private LoginPageObject loginPage;
	private ChangePasswordPageObject changePasswordPage;
	
	private String firstName, lastName, email, companyName;
	private String dayOfBirth, monthOfBirth, yearOfBirth, gender;
	private String country, state, city, phoneNumber, faxNumber, address_1, address_2, zipCode;
	private String addressPageName = "Addresses";
	private String changePasswordPageName = "Change password";
	private String oldPassword, newPassword, loginEmail;
	
	@Parameters("browser")
	@BeforeClass
	public void BeforeClass(String browserName) {
		driver = getBrowserName(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		firstName = "Automation";
		lastName = "Test";
		email = "automationfc" + randomNumber() + "@yopmail.com";
		companyName = "Amazon";
		dayOfBirth = "25";
		monthOfBirth = "September";
		yearOfBirth = "2001";
		gender = "F";
		country = "Helsinki";
		state = "Other";
		city = "Helsinki";
		address_1 = "Vuolteenkatu 1, 33100 Tampere";
		address_2 = "Yliopistonkatu 20, 20100 Turku";
		zipCode = "222333";
		phoneNumber = "9999333666";
		faxNumber = "9999333667";
		oldPassword = User_01_RegisterNewAccount.password;
		newPassword = "222000";
		loginEmail = User_01_RegisterNewAccount.emailAddress;
		
		homePage = PageGeneratorManager.getHomePageObject(driver);
		myAccountPage = homePage.clickOnMyAccountLink();
		
	}
	
	@Test
	public void MyAccount_01_UpdateCustomerInfo() {
		myAccountPage.selectGenderRadioButton();
		myAccountPage.updateFirstNameTextbox(firstName);
		myAccountPage.updateLastNameTextbox(lastName);
		myAccountPage.updateDayOfBirthDropdownList(dayOfBirth);
		myAccountPage.updateMonthOfBirthDropdownList(monthOfBirth);
		myAccountPage.updateYearOfBirthDropdownList(yearOfBirth);
		myAccountPage.updateEmailTextbox(email);
		myAccountPage.updateCompanyNameTextbox(companyName);
		myAccountPage.clickOnSaveButton();
		
		//The customer info has been updated successfully.
		Assert.assertTrue(myAccountPage.isNotificationSuccessDisplayed());
		myAccountPage.closeNotificationSuccessDisplayed();
		Assert.assertEquals(myAccountPage.getGenderValue("value"), gender);
		Assert.assertEquals(myAccountPage.getFirstNameValue("value"), firstName);
		Assert.assertEquals(myAccountPage.getLastNameValue("value"), lastName);
		Assert.assertEquals(myAccountPage.getDayOfBirthValue(), dayOfBirth);
		Assert.assertEquals(myAccountPage.getMonthOfBirthValue(), monthOfBirth);
		Assert.assertEquals(myAccountPage.getYearOfBirthValue(), yearOfBirth);
		Assert.assertEquals(myAccountPage.getEmailValue("value"), email);
		Assert.assertEquals(myAccountPage.getCompanyNameValue("value"), companyName);
	}
	
	@Test
	public void MyAccount_02_AddAddressInfo() {
		myAccountPage.clickOnSideBasePage(driver, addressPageName);
		addressPage = PageGeneratorManager.getAddressPageObject(driver);
		
		addressPage.clickOnAddNewAddressButton();
		addressPage.inputToFirstNameTextbox(firstName);
		addressPage.inputToLastNameTextbox(lastName);
		addressPage.inputToEmailTextbox(email);
		addressPage.inputToCompanyTextbox(companyName);
		addressPage.selectCountryDropdownList(country);
		addressPage.selectStateDropdownList(state);
		addressPage.inputToCityTextbox(city);
		addressPage.inputToAddreessITextbox(address_1);
		addressPage.inputToAddressIITextbox(address_2);
		addressPage.inputToZipCodeTextbox(zipCode);
		addressPage.inputToPhoneNumberTextbox(phoneNumber);
		addressPage.inputToFaxNumberTextbox(faxNumber);
		addressPage.clickOnSaveButoon();
		
		Assert.assertTrue(addressPage.isNotificationSuccessDisplayed());
		addressPage.clickOnCloseButton();
		Assert.assertEquals(addressPage.getNameTitle(), firstName + " " + lastName);
		Assert.assertEquals(addressPage.getNameText(), firstName + " " + lastName);
		Assert.assertTrue(addressPage.getEmailText().contains(email));
		Assert.assertTrue(addressPage.getPhoneNumberText().contains(phoneNumber));
		Assert.assertTrue(addressPage.getFaxNumberText().contains(faxNumber));
		Assert.assertTrue(addressPage.getCompanyText().contains(companyName));
		Assert.assertTrue(addressPage.getAddressIText().contains(address_1));
		Assert.assertTrue(addressPage.getAddressIIText().contains(address_2));
		Assert.assertTrue(addressPage.getCityText().contains(city));
		Assert.assertTrue(addressPage.getZipCodeText().contains(zipCode));
		Assert.assertFalse(addressPage.getStateText(state));
		Assert.assertEquals(addressPage.getcountryText(), country);
	}
	
	@Test
	public void MyAccount_03_ChangePassword() {
		myAccountPage.clickOnSideBasePage(driver, changePasswordPageName);
		changePasswordPage = PageGeneratorManager.getChangePasswordPageObject(driver);
		
		changePasswordPage.inputToOldPasswordTextbox(oldPassword);
		changePasswordPage.inputToNewPasswordTextbox(newPassword);
		changePasswordPage.inputToConfirmPasswordTextbox(newPassword);
		changePasswordPage.clickOnChangePasswordButton();
		
		Assert.assertTrue(changePasswordPage.isNotificationSuccessDisplayed());
		
		homePage.clickOnLogoutLink();
		loginPage = homePage.clickOnLoginLink();
		
		loginPage.inputToEmailTextbox(loginEmail);
		loginPage.inputToPasswordTextbox(oldPassword);
		loginPage.clickOnLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidErrorMessageText(), "");
		
		loginPage.inputToPasswordTextbox(newPassword);
		homePage = loginPage.clickOnLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountDisplayed());
	}
	
	@Test
	public void MyAccount_04_MyProductReview() {
		bookProductPage = homePage.clickOnBookProduct();
		
		bookProductPage.clickOnBookTitle();
		bookProductPage.clickOnAddReviewLink();
		
		bookProductPage.inputToReviewTitle();
		bookProductPage.inputToReviewText();
		bookProductPage.selectRatingLevelRadioButton();
		bookProductPage.clickOnSubmitReviewButton();
		
		myAccountPage = homePage.clickOnMyAccountLink();
		myAccountPage.clickOnSideBasePage();
		myProductReviewPage = PageGeneratorManager.getMyProductReviewPageObject();
		
		Assert.assertEquals(myProductReviewPage.getReviewTitleText(), reviewTitle);
		Assert.assertEquals(myProductReviewPage.getReviewText(), reviewText);
		Assert.assertEquals(myProductReviewPage.getBookReviewText(), bookTitle);
	}
	
	public int randomNumber() {
		Random rnd = new Random();
		return rnd.nextInt();
	}
	
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
}
