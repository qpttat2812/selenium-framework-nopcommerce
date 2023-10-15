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
import common.GlobalConstants;
import common.PageGeneratorManager;
import pagesObject.AddressPageObject;
import pagesObject.BookProductPageObject;
import pagesObject.ChangePasswordPageObject;
import pagesObject.HomePageObject;
import pagesObject.LoginPageObject;
import pagesObject.MyAccountPageObject;
import pagesObject.MyProductReviewPageObject;

public class User_03_MyAccountInfo extends BaseTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private MyAccountPageObject myAccountPage;
	private AddressPageObject addressPage;
	private LoginPageObject loginPage;
	private ChangePasswordPageObject changePasswordPage;
	private BookProductPageObject bookProductPage;
	private MyProductReviewPageObject myProductReviewPage;
	
	private String firstName, lastName, newEmail, companyName;
	private String dayOfBirth, monthOfBirth, yearOfBirth, gender;
	private String country, state, city, phoneNumber, faxNumber, address_1, address_2, zipCode;
	private String addressPageName;
	private String changePasswordPageName;
	private String oldPassword, newPassword, loginEmail;
	private String bookTitle;
	private String reviewTitle;
	private String reviewContent;
	
	@Parameters("browser")
	@BeforeClass
	public void BeforeClass(String browserName) {
		driver = getBrowserName(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		firstName = "Auto";
		lastName = "Test";
		newEmail = "automate" + randomNumber() + "@yopmail.com";
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
		oldPassword = User_01_RegisterNewAccount.password;
		loginEmail = User_01_RegisterNewAccount.emailAddress;
		newPassword = "22222223";
		addressPageName = "Addresses";
		changePasswordPageName = "Change password";
		bookTitle = "Fahrenheit 451 by Ray Bradbury";
		reviewTitle = "recommended";
		reviewContent = "it's worth to buy.\nAll books of this author are good.";
		
		driver.get(GlobalConstants.USER_URL);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		//login account
		loginPage = homePage.clickOnLoginLink();
		loginPage.inputToEmailTextbox(loginEmail);
		loginPage.inputToPasswordTextbox(oldPassword);
		homePage = loginPage.clickOnLoginButton();
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
		myAccountPage.updateEmailTextbox(newEmail);
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
		Assert.assertEquals(myAccountPage.getEmailValue("value"), newEmail);
		Assert.assertEquals(myAccountPage.getCompanyNameValue("value"), companyName);
	}
	
	 @Test 
	public void MyAccount_02_AddAddressInfo() {
		myAccountPage.clickOnSideBarPage(driver, addressPageName);
		addressPage = PageGeneratorManager.getAddressPageObject(driver);
		
		addressPage.clickOnAddNewAddressButton();
		addressPage.inputToFirstNameTextbox(firstName);
		addressPage.inputToLastNameTextbox(lastName);
		addressPage.inputToEmailTextbox(newEmail);
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
		myAccountPage.clickOnSideBarPage(driver, changePasswordPageName);
		changePasswordPage = PageGeneratorManager.getChangePasswordPageObject(driver);
		
		changePasswordPage.inputToOldPasswordTextbox(oldPassword);
		changePasswordPage.inputToNewPasswordTextbox(newPassword);
		changePasswordPage.inputToConfirmPasswordTextbox(newPassword);
		changePasswordPage.clickOnChangePasswordButton();
		
		Assert.assertTrue(changePasswordPage.isNotificationSuccessDisplayed());
		changePasswordPage.clickOnCloseButton();
		
		homePage.clickOnLogoutLink();
		
		loginPage = homePage.clickOnLoginLink();
		loginPage.inputToEmailTextbox(newEmail);
		loginPage.inputToPasswordTextbox(oldPassword);
		loginPage.clickOnLoginButton();
		
		Assert.assertTrue(loginPage.getInvalidErrorMessageText().contains("Login was unsuccessful"));
		
		loginPage = homePage.clickOnLoginLink();
		loginPage.inputToEmailTextbox(newEmail);
		loginPage.inputToPasswordTextbox(newPassword);
		homePage = loginPage.clickOnLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountDisplayed());
	}
	
	@Test
	public void MyAccount_04_MyProductReview() {
		homePage.clickOnProductTab("Books");
		bookProductPage = PageGeneratorManager.getBookProductPageObject(driver);
		
		bookProductPage.clickOnBookTitle(bookTitle);
		bookProductPage.clickOnAddReviewLink();
		
		bookProductPage.inputToReviewTitle(reviewTitle);
		bookProductPage.inputToReviewContent(reviewContent);
		bookProductPage.selectRatingLevelRadioButton("Good");
		bookProductPage.clickOnSubmitReviewButton();
		
		myAccountPage = homePage.clickOnMyAccountLink();
		myAccountPage.clickOnSideBarPage(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getMyProductReviewPageObject(driver);
		
		Assert.assertEquals(myProductReviewPage.getReviewTitleText(), reviewTitle);
		Assert.assertEquals(myProductReviewPage.getReviewText(), reviewContent);
		Assert.assertEquals(myProductReviewPage.getBookReviewText(bookTitle), bookTitle);
	}
	
	public int randomNumber() {
		Random rnd = new Random();
		return rnd.nextInt(9999);
	}
	
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
}
