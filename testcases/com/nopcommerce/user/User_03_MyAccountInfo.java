package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pagesObject.AddressPageObject;
import pagesObject.BookDetailedPageObject;
import pagesObject.BookPageObject;
import pagesObject.ChangePasswordPageObject;
import pagesObject.HomePageObject;
import pagesObject.LoginPageObject;
import pagesObject.MyAccountPageObject;
import pagesObject.MyProductReviewPageObject;
import pagesObject.RegisterPageObject;

public class User_03_MyAccountInfo extends BaseTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private MyAccountPageObject myAccountPage;
	private AddressPageObject addressPage;
	private LoginPageObject loginPage;
	private ChangePasswordPageObject changePasswordPage;
	private BookPageObject bookPage;
	private MyProductReviewPageObject myProductReviewPage;
	private RegisterPageObject registerPage;
	private BookDetailedPageObject bookDetailedPage;
	
	private String registeredFirstName, registeredLastName, companyName, newFirstName, newLastName;
	private String dayOfBirth, monthOfBirth, yearOfBirth, gender;
	private String country, state, city, phoneNumber, faxNumber, address_1, address_2, zipCode;
	private String addressPageName;
	private String changePasswordPageName;
	private String registeredPassword, registeredEmail;
	private String newEmail, newPassword;
	private String bookTitle;
	private String reviewTitle;
	private String reviewContent;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void BeforeClass(String browserName, String pageURL) {
		registeredEmail = "testtest" + randomNumber() + "@gmail.com";
		registeredPassword = "111222";
		registeredFirstName = "Auto";
		registeredLastName = "Test";
		newFirstName = "automation";
		newLastName = "fc";
		newEmail = "automate" + randomNumber() + "@yopmail.com";
		newPassword = "22222223";
		companyName = "Amazon";
		dayOfBirth = "25";
		monthOfBirth = "September";
		yearOfBirth = "2001";
		gender = "F";
		country = "United States";
		state = "Alaska";
		city = "Helsinki";
		address_1 = "Tampere";
		address_2 = "Turku";
		zipCode = "222333";
		phoneNumber = "99333666";
		faxNumber = "99333667";
		addressPageName = "Addresses";
		changePasswordPageName = "Change password";
		bookTitle = "Fahrenheit 451 by Ray Bradbury";
		reviewTitle = "recommended";
		reviewContent = "it's worth to buy.\nAll books of this author are good.";
		
		driver = getBrowserName(browserName, pageURL);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		
		//register account
		registerPage = homePage.clickOnRegisterLink();
		registerPage.inputToFirstNameTextbox(registeredFirstName);
		registerPage.inputToLastNameTextbox(registeredLastName);
		registerPage.inputToEmailTextbox(registeredEmail);
		registerPage.inputToPasswordTextbox(registeredPassword);
		registerPage.inputToConfirmPasswordTextbox(registeredPassword);
		registerPage.clickOnRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessfullyMessage(), "Your registration completed");
		
		//login account
		loginPage = homePage.clickOnLoginLink();
		loginPage.inputToEmailTextbox(registeredEmail);
		loginPage.inputToPasswordTextbox(registeredPassword);
		homePage = loginPage.clickOnLoginButton();
		myAccountPage = homePage.clickOnMyAccountLink();
		
	}
	
	 @Test 
	public void MyAccount_01_UpdateCustomerInfo() {
		myAccountPage.selectGenderRadioButton();
		myAccountPage.updateFirstNameTextbox(newFirstName);
		myAccountPage.updateLastNameTextbox(newLastName);
		myAccountPage.updateDayOfBirthDropdownList(dayOfBirth);
		myAccountPage.updateMonthOfBirthDropdownList(monthOfBirth);
		myAccountPage.updateYearOfBirthDropdownList(yearOfBirth);
		myAccountPage.updateEmailTextbox(newEmail);
		myAccountPage.updateCompanyNameTextbox(companyName);
		myAccountPage.clickOnSaveButton();
		
		//The customer info has been updated successfully.
		Assert.assertTrue(myAccountPage.isBarNotificationSuccessDisplayed());
		myAccountPage.clickOnCloseButton();
		Assert.assertEquals(myAccountPage.getGenderValue("value"), gender);
		Assert.assertEquals(myAccountPage.getFirstNameValue("value"), newFirstName);
		Assert.assertEquals(myAccountPage.getLastNameValue("value"), newLastName);
		Assert.assertEquals(myAccountPage.getDayOfBirthValue(), dayOfBirth);
		Assert.assertEquals(myAccountPage.getMonthOfBirthValue(), monthOfBirth);
		Assert.assertEquals(myAccountPage.getYearOfBirthValue(), yearOfBirth);
		Assert.assertEquals(myAccountPage.getEmailValue("value"), newEmail);
		Assert.assertEquals(myAccountPage.getCompanyNameValue("value"), companyName);
	}
	
	 @Test 
	public void MyAccount_02_AddAddressInfo() {
		myAccountPage.clickOnSideBarMenu(driver, addressPageName);
		addressPage = PageGeneratorManager.getAddressPageObject(driver);
		
		addressPage.clickOnAddNewAddressButton();
		addressPage.inputToFirstNameTextbox(newFirstName);
		addressPage.inputToLastNameTextbox(newLastName);
		addressPage.inputToEmailTextbox(newEmail);
		addressPage.inputToCompanyTextbox(companyName);
		addressPage.selectCountryDropdownList(country);
		addressPage.selectStateDropdownList(state);
		addressPage.inputToCityTextbox(city);
		addressPage.inputToAddressITextbox(address_1);
		addressPage.inputToAddressIITextbox(address_2);
		addressPage.inputToZipCodeTextbox(zipCode);
		addressPage.inputToPhoneNumberTextbox(phoneNumber);
		addressPage.inputToFaxNumberTextbox(faxNumber);
		addressPage.clickOnSaveButton();
		
		Assert.assertTrue(addressPage.isBarNotificationSuccessDisplayed());
		addressPage.clickOnCloseButton();
		Assert.assertEquals(addressPage.getNameTitle(), newFirstName + " " + newLastName);
		Assert.assertEquals(addressPage.getNameText(), newFirstName + " " + newLastName);
		Assert.assertTrue(addressPage.getEmailText().contains(newEmail));
		Assert.assertTrue(addressPage.getPhoneNumberText().contains(phoneNumber));
		Assert.assertTrue(addressPage.getFaxNumberText().contains(faxNumber));
		Assert.assertTrue(addressPage.getCompanyText().contains(companyName));
		Assert.assertTrue(addressPage.getAddressIText().contains(address_1));
		Assert.assertTrue(addressPage.getAddressIIText().contains(address_2));
		Assert.assertTrue(addressPage.getCityText().contains(city));
		Assert.assertTrue(addressPage.getZipCodeText().contains(zipCode));
		Assert.assertTrue(addressPage.getStateText(state));
		Assert.assertEquals(addressPage.getcountryText(), country);
	}
	
	@Test
	public void MyAccount_03_ChangePassword() {
		myAccountPage.clickOnSideBarMenu(driver, changePasswordPageName);
		changePasswordPage = PageGeneratorManager.getChangePasswordPageObject(driver);
		
		changePasswordPage.inputToOldPasswordTextbox(registeredPassword);
		changePasswordPage.inputToNewPasswordTextbox(newPassword);
		changePasswordPage.inputToConfirmPasswordTextbox(newPassword);
		changePasswordPage.clickOnChangePasswordButton();
		
		Assert.assertTrue(changePasswordPage.isBarNotificationSuccessDisplayed());
		changePasswordPage.clickOnCloseButton();
		
		homePage.clickOnLogoutLink();
		
		loginPage = homePage.clickOnLoginLink();
		loginPage.inputToEmailTextbox(newEmail);
		loginPage.inputToPasswordTextbox(registeredPassword);
		loginPage.clickOnLoginButton();
		
		Assert.assertTrue(loginPage.getInvalidErrorMessageText().contains("Login was unsuccessful"));
		
		loginPage = homePage.clickOnLoginLink();
		loginPage.inputToEmailTextbox(newEmail);
		loginPage.inputToPasswordTextbox(newPassword);
		homePage = loginPage.clickOnLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void MyAccount_04_MyProductReview() {
		homePage.clickOnProductTab(driver, "Books");
		bookPage = PageGeneratorManager.getBookPageObject(driver);
		Assert.assertTrue(bookPage.isBookPageDisplayed());
		
		bookPage.clickOnProductTitleLink(driver, bookTitle);
		bookDetailedPage = PageGeneratorManager.getBookDetailedPageObject(driver);
		bookDetailedPage.clickOnAddReviewLink();
		
		bookDetailedPage.inputToReviewTitleTextbox(reviewTitle);
		bookDetailedPage.inputToReviewContentTextArea(reviewContent);
		bookDetailedPage.selectRatingLevelRadioButton("Good");
		bookDetailedPage.clickOnSubmitReviewButton();
		
		myAccountPage = homePage.clickOnMyAccountLink();
		myAccountPage.clickOnSideBarMenu(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getMyProductReviewPageObject(driver);
		
		Assert.assertEquals(myProductReviewPage.getReviewTitleText(), reviewTitle);
		Assert.assertEquals(myProductReviewPage.getReviewText(), reviewContent);
		Assert.assertEquals(myProductReviewPage.getBookReviewText(bookTitle), bookTitle);
	}
	
	public int randomNumber() {
		Random rnd = new Random();
		return rnd.nextInt(9999);
	}
	
	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();
	}
}
