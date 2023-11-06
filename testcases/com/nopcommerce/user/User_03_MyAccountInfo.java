package com.nopcommerce.user;

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
import pagesObject.ProductReviewsPageObject;
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
	private ProductReviewsPageObject productReviewsPage;
	
	private String registeredFirstName;
	private String registeredLastName;
	private String companyName;
	private String newFirstName;
	private String newLastName;
	private String dayOfBirth; 
	private String monthOfBirth; 
	private String yearOfBirth;
	private String genderValue;
	private String country; 
	private String state;
	private String city; 
	private String phoneNumber; 
	private String faxNumber; 
	private String firstAddress; 
	private String secondAddress; 
	private String zipCode;
	private String addressPageName;
	private String changePasswordPageName;
	private String registeredPassword; 
	private String registeredEmail;
	private String newEmail;
	private String newPassword;
	private String bookName;
	private String reviewTitle;
	private String reviewContent;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void BeforeClass(String browserName, String pageURL) {
		registeredFirstName = "Auto";
		registeredLastName = "Test";
		companyName  = "AirBnB";
		newFirstName = "automation";
		newLastName = "fc";
		dayOfBirth = "25"; 
		monthOfBirth = "September"; 
		yearOfBirth = "2001";
		genderValue = "F";
		country = "United States"; 
		state = "Alaska";
		city = "Helsinki"; 
		phoneNumber = "99333666"; 
		faxNumber = "99333667"; 
		firstAddress = "Tampere"; 
		secondAddress = "Turku"; 
		zipCode = "222333";
		addressPageName = "Addresses";
		changePasswordPageName = "Change password";
		registeredPassword = "111222"; 
		registeredEmail = "testtest" + getRandomNumber() + "@gmail.com";
		newEmail = "automate" + getRandomNumber() + "@yopmail.com";
		newPassword = "22222223";
		bookName = "Fahrenheit 451 by Ray Bradbury";
		reviewTitle  = "recommended";
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
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		myAccountPage = homePage.clickOnMyAccountLink();
	}
	
	 @Test 
	public void MyAccount_01_UpdateCustomerInfo() {
		myAccountPage.selectGenderRadioButton("Female");
		myAccountPage.updateFirstNameTextbox(newFirstName);
		myAccountPage.updateLastNameTextbox(newLastName);
		myAccountPage.updateDayOfBirthDropdownList(dayOfBirth);
		myAccountPage.updateMonthOfBirthDropdownList(monthOfBirth);
		myAccountPage.updateYearOfBirthDropdownList(yearOfBirth);
		myAccountPage.updateEmailTextbox(newEmail);
		myAccountPage.updateCompanyNameTextbox(companyName);
		myAccountPage.clickOnSaveButton();
		
		//The customer info has been updated successfully.
		Assert.assertEquals(myAccountPage.getBarNotificationSuccessMessage(), "The customer info has been updated successfully.");
		myAccountPage.clickOnCloseButton();
		
		Assert.assertEquals(myAccountPage.getGenderValue("value", "Female"), genderValue);
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
		addressPage.inputToAddressITextbox(firstAddress);
		addressPage.inputToAddressIITextbox(secondAddress);
		addressPage.inputToZipCodeTextbox(zipCode);
		addressPage.inputToPhoneNumberTextbox(phoneNumber);
		addressPage.inputToFaxNumberTextbox(faxNumber);
		addressPage.clickOnSaveButton();
		
		Assert.assertEquals(addressPage.getBarNotificationSuccessMessage(), "The new address has been added successfully.");
		addressPage.clickOnCloseButtonInBar();
		
		Assert.assertEquals(addressPage.getTitleName(), newFirstName + " " + newLastName);
		Assert.assertEquals(addressPage.getNameValue(), newFirstName + " " + newLastName);
		Assert.assertTrue(addressPage.getEmailValue().contains(newEmail));
		Assert.assertTrue(addressPage.getPhoneNumberValue().contains(phoneNumber));
		Assert.assertTrue(addressPage.getFaxNumberValue().contains(faxNumber));
		Assert.assertTrue(addressPage.getCompanyValue().contains(companyName));
		Assert.assertTrue(addressPage.getFirstAddressValue().contains(firstAddress));
		Assert.assertTrue(addressPage.getSecondAddressValue().contains(secondAddress));
		Assert.assertTrue(addressPage.getCityValue().contains(city));
		Assert.assertTrue(addressPage.getZipCodeValue().contains(zipCode));
		Assert.assertTrue(addressPage.getStateValue(state));
		Assert.assertEquals(addressPage.getcountryValue(), country);
	}
	
	@Test
	public void MyAccount_03_ChangePassword() {
		myAccountPage.clickOnSideBarMenu(driver, changePasswordPageName);
		
		changePasswordPage = PageGeneratorManager.getChangePasswordPageObject(driver);
		changePasswordPage.inputToOldPasswordTextbox(registeredPassword);
		changePasswordPage.inputToNewPasswordTextbox(newPassword);
		changePasswordPage.inputToConfirmPasswordTextbox(newPassword);
		changePasswordPage.clickOnChangePasswordButton();
		
		Assert.assertEquals(changePasswordPage.getBarNotificationSuccessMessage(), "Password was changed");
		changePasswordPage.clickOnCloseButtonInBar();
		
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
		homePage.clickOnProductTabLink(driver, "Books");
		
		bookPage = PageGeneratorManager.getBookPageObject(driver);
		bookPage.clickOnProductNameLinkAtSubCategory(driver, bookName);
		
		bookDetailedPage = PageGeneratorManager.getBookDetailedPageObject(driver);
		productReviewsPage = bookDetailedPage.clickOnAddReviewLink();
		Assert.assertEquals(productReviewsPage.getReviewProductTitle(), "Product reviews for " + bookName);
		
		productReviewsPage.inputToReviewTitleTextbox(reviewTitle);
		productReviewsPage.inputToReviewContentTextArea(reviewContent);
		productReviewsPage.selectRatingLevelRadioButton("Good");
		productReviewsPage.clickOnSubmitReviewButton();
		
		Assert.assertEquals(productReviewsPage.getProductReviewsSuccessMessage(), "Product review is successfully added.");
		
		myAccountPage = homePage.clickOnMyAccountLink();
		myAccountPage.clickOnSideBarMenu(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getMyProductReviewPageObject(driver);
		
		Assert.assertEquals(myProductReviewPage.getReviewTitleText(), reviewTitle);
		Assert.assertEquals(myProductReviewPage.getReviewText(), reviewContent);
		Assert.assertEquals(myProductReviewPage.getBookReviewText(bookName), bookName);
	}
	
	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();
	}
}
