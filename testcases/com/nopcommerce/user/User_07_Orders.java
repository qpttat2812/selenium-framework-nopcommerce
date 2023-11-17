package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_RegisterAccountAndGetCookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pagesObject.AddToCartPageObject;
import pagesObject.CheckoutPageObject;
import pagesObject.ComputersPageObject;
import pagesObject.DesktopsDetailedPageObject;
import pagesObject.DesktopsPageObject;
import pagesObject.HomePageObject;
import pagesObject.LoginPageObject;
import pagesObject.MyAccountPageObject;
import pagesObject.NotebooksDetailedPageObject;
import pagesObject.NotebooksPageObject;
import pagesObject.OrdersPageObject;
import utilities.DataHelper;

public class User_07_Orders extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private ComputersPageObject computersPage;
	private DesktopsPageObject desktopsPage;
	private DesktopsDetailedPageObject desktopsDetailedPage;
	private LoginPageObject loginPage;
	private AddToCartPageObject addToCartPage;
	private NotebooksPageObject notebooksPage;
	private NotebooksDetailedPageObject noteBooksDetailedPage;
	private CheckoutPageObject checkoutPage;
	private MyAccountPageObject myAccountPage;
	private OrdersPageObject ordersPage;
	private DataHelper dataHelp;

	private String productTab;
	private String productName;
	private String expectedProcessor;
	private String expectedRam;
	private String expectedHDD;
	private String expectedOS;
	private String firstExpectedSoftware;
	private String secondExpectedSoftware;
	private String thirdExpectedSoftware;
	private String expectedProductSKU;
	private String expectedShippingMethod, newShippingMethod;
	private String moneyPaymentMethod;
	private String cardPaymentMethod;
	private String expectedGiftOption;
	private String expectedOrderDate;
	private String firstName, lastName, newFirstName, newLastName;
	private String email, expectedCountry, newEmail, newCountry;
	private String expectedState, expectedCity, newState, newCity;
	private String expectedFirstAddress, expectedZipcode, newFirstAddress, newZipcode;
	private String expectedPhoneNumber, newPhoneNumber;
	private String notebooksName;
	private String orderText;
	

	private float expectedProductPrice;
	private float expectedSubTotalPrice;
	private float expectedGiftWrappingPrice;
	private float expectedShippingValue;
	private float expectedTaxValue;
	private int expectedEarningPoint;
	private float expectedTotalPrice;
	private int countItem;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeClass(String browserName, String pageURL) {
		dataHelp = DataHelper.getData();

		productTab = "Computers";
		productName = "Build your own computer";
		notebooksName = "Apple MacBook Pro 13-inch";
		expectedGiftOption = "Yes [+$10.00]";

		firstName = dataHelp.getFirstName();
		lastName = dataHelp.getLastName();
		email = dataHelp.getEmailAddress();
		expectedCountry = dataHelp.getCountry();
		expectedCity = dataHelp.getCity();
		expectedFirstAddress = dataHelp.getAddress();
		expectedZipcode = dataHelp.getZipCode();
		expectedPhoneNumber = dataHelp.getPhoneNumber();
		expectedShippingMethod = "Next Day Air ($0.00)";
		moneyPaymentMethod = "Check / Money Order";
		cardPaymentMethod = "Credit Card";

		driver = getBrowserName(browserName, pageURL);

		homePage = PageGeneratorManager.getHomePageObject(driver);
		loginPage = homePage.clickOnLoginLink();
		loginPage.setCookie(driver, Common_01_RegisterAccountAndGetCookie.loggedCookies);
		loginPage.refreshBrowser(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		homePage.clickOnProductTabLink(driver, productTab);
		computersPage = PageGeneratorManager.getComputersPageObject(driver);

		desktopsPage = computersPage.clickOnDesktopsLink();
		Assert.assertTrue(desktopsPage.isDesktopsPageDisplayed());

		desktopsPage.clickOnProductNameLinkAtSubCategory(driver, productName);

		desktopsDetailedPage = PageGeneratorManager.getDesktopsDetailedPageObject(driver);
	}

	@Test
	public void Orders_01_AddProductToCart() {
		expectedProcessor = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
		expectedRam = "8GB [+$60.00]";
		expectedHDD = "400 GB [+$100.00]";
		expectedOS = "Vista Premium [+$60.00]";
		firstExpectedSoftware = "Microsoft Office [+$50.00]";
		secondExpectedSoftware = "Acrobat Reader [+$10.00]";
		thirdExpectedSoftware = "Total Commander [+$5.00]";

		desktopsDetailedPage.selectDesktopComponentDropdownlist("Processor", expectedProcessor);
		desktopsDetailedPage.selectDesktopComponentDropdownlist("RAM", expectedRam);
		desktopsDetailedPage.selectDesktopComponentRadioButton("HDD", expectedHDD);
		desktopsDetailedPage.selectDesktopComponentRadioButton("OS", expectedOS);
		desktopsDetailedPage.checkOnSoftwareCheckbox(secondExpectedSoftware);
		desktopsDetailedPage.checkOnSoftwareCheckbox(thirdExpectedSoftware);
		desktopsDetailedPage.clickOnAddToCartButton();

		Assert.assertEquals(desktopsDetailedPage.getBarNotificationSuccessMessage(), "The product has been added to your shopping cart");

		expectedProductPrice = desktopsDetailedPage.getProductUnitPriceValue();
		countItem = homePage.getShoppingCartQuantity();
		expectedSubTotalPrice = expectedProductPrice * countItem;

		Assert.assertEquals(homePage.getMiniCartSummaryMessage(), "There are " + countItem + " item(s) in your cart.");
		Assert.assertTrue(homePage.getMiniCartProductInfo().contains("Processor: " + expectedProcessor));
		Assert.assertTrue(homePage.getMiniCartProductInfo().contains("RAM: " + expectedRam));
		Assert.assertTrue(homePage.getMiniCartProductInfo().contains("HDD: " + expectedHDD));
		Assert.assertTrue(homePage.getMiniCartProductInfo().contains("OS: " + expectedOS));
		Assert.assertTrue(homePage.getMiniCartProductInfo().contains("Software: " + firstExpectedSoftware));
		Assert.assertTrue(homePage.getMiniCartProductInfo().contains("Software: " + secondExpectedSoftware));
		Assert.assertTrue(homePage.getMiniCartProductInfo().contains("Software: " + thirdExpectedSoftware));
		Assert.assertTrue(homePage.getMiniCartUnitPriceInfo().contains("Unit price: " + dataHelp.getCurrencyFormat(expectedProductPrice)));
		Assert.assertTrue(homePage.getMiniCartQuantityInfo().contains("Quantity: " + countItem));
		Assert.assertTrue(homePage.getMiniCartSubTotalPriceValue().contains("Sub-Total: " + dataHelp.getCurrencyFormat(expectedSubTotalPrice)));
	}

	@Test
	public void Orders_02_EditProductInShoppingCart() {
		expectedProcessor = "2.2 GHz Intel Pentium Dual-Core E2200";
		expectedRam = "4GB [+$20.00]";
		expectedHDD = "320 GB";
		expectedOS = "Vista Home [+$50.00]";
		firstExpectedSoftware = "Microsoft Office [+$50.00]";
		secondExpectedSoftware = "Acrobat Reader [+$10.00]";
		thirdExpectedSoftware = "Total Commander [+$5.00]";

		homePage.refreshBrowser(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		addToCartPage = homePage.clickOnShoppingCartLink();
		Assert.assertEquals(addToCartPage.getProductNameValue(), productName);

		desktopsDetailedPage = addToCartPage.clickOnEditLink();

		desktopsDetailedPage.selectDesktopComponentDropdownlist("Processor", expectedProcessor);
		desktopsDetailedPage.selectDesktopComponentDropdownlist("RAM", expectedRam);
		desktopsDetailedPage.selectDesktopComponentRadioButton("HDD", expectedHDD);
		desktopsDetailedPage.selectDesktopComponentRadioButton("OS", expectedOS);
		desktopsDetailedPage.checkOnSoftwareCheckbox(secondExpectedSoftware);
		desktopsDetailedPage.checkOnSoftwareCheckbox(thirdExpectedSoftware);
		
		desktopsDetailedPage.inputQuantityToQuantityTextbox("2");
		desktopsDetailedPage.clickOnAddToCartButton();
		Assert.assertEquals(desktopsDetailedPage.getBarNotificationSuccessMessage(), "The product has been added to your shopping cart");

		expectedProductPrice = desktopsDetailedPage.getProductUnitPriceValue();
		expectedProductSKU = desktopsDetailedPage.getProductSKUValue();

		countItem = homePage.getShoppingCartQuantity();
		expectedSubTotalPrice = expectedProductPrice * countItem;

		Assert.assertEquals(homePage.getMiniCartSummaryMessage(), "There are " + countItem + " item(s) in your cart.");

		Assert.assertTrue(homePage.getMiniCartProductInfo().contains("Processor: " + expectedProcessor));
		Assert.assertTrue(homePage.getMiniCartProductInfo().contains("RAM: " + expectedRam));
		Assert.assertTrue(homePage.getMiniCartProductInfo().contains("HDD: " + expectedHDD));
		Assert.assertTrue(homePage.getMiniCartProductInfo().contains("OS: " + expectedOS));
		Assert.assertTrue(homePage.getMiniCartProductInfo().contains("Software: " + firstExpectedSoftware));
		Assert.assertTrue(homePage.getMiniCartUnitPriceInfo().contains("Unit price: " + dataHelp.getCurrencyFormat(expectedProductPrice)));
		Assert.assertTrue(homePage.getMiniCartQuantityInfo().contains("Quantity: " + countItem));
		Assert.assertTrue(homePage.getMiniCartSubTotalPriceValue().contains("Sub-Total: " + dataHelp.getCurrencyFormat(expectedSubTotalPrice)));

		homePage.refreshBrowser(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		addToCartPage = homePage.clickOnShoppingCartLink();

		Assert.assertEquals(addToCartPage.getProductSKUValue(), expectedProductSKU);
		Assert.assertTrue(addToCartPage.isProductImageDisplayed());
		Assert.assertTrue(addToCartPage.getCartProductInfo().contains("Processor: " + expectedProcessor));
		Assert.assertTrue(addToCartPage.getCartProductInfo().contains("RAM: " + expectedRam));
		Assert.assertTrue(addToCartPage.getCartProductInfo().contains("HDD: " + expectedHDD));
		Assert.assertTrue(addToCartPage.getCartProductInfo().contains("OS: " + expectedOS));
		Assert.assertTrue(addToCartPage.getCartProductInfo().contains("Software: " + firstExpectedSoftware));
		Assert.assertEquals(addToCartPage.getUnitPriceValue(), expectedProductPrice);
		Assert.assertEquals(addToCartPage.getQuantityValue("value"), countItem);
		Assert.assertEquals(addToCartPage.getSubTotalPriceValue(), dataHelp.getCurrencyFormat(expectedSubTotalPrice));
	}

	@Test
	public void Orders_03_RemoveFromCart() {
		addToCartPage.clickOnRemoveIcon();
		Assert.assertEquals(addToCartPage.getEmptyCartText(), "Your Shopping Cart is empty!");
		Assert.assertTrue(addToCartPage.isProductUndisplayedInCart());
	}

	@Test
	public void Orders_04_UpdateShoppingCart() {
		String desktopsName = "Lenovo IdeaCentre 600 All-in-One PC";

		addToCartPage.clickOnProductTabLink(driver, productTab);

		computersPage = PageGeneratorManager.getComputersPageObject(driver);
		desktopsPage = computersPage.clickOnDesktopsLink();

		desktopsPage.clickOnProductNameLinkAtSubCategory(driver, desktopsName);

		desktopsDetailedPage = PageGeneratorManager.getDesktopsDetailedPageObject(driver);
		desktopsDetailedPage.clickOnAddToCartButton();

		Assert.assertEquals(desktopsDetailedPage.getBarNotificationSuccessMessage(), "The product has been added to your shopping cart");

		expectedProductSKU = desktopsDetailedPage.getProductSKUValue();
		expectedProductPrice = desktopsDetailedPage.getProductUnitPriceValue();
		countItem = homePage.getShoppingCartQuantity();
		expectedSubTotalPrice = expectedProductPrice * countItem;
		
		homePage.refreshBrowser(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		addToCartPage = homePage.clickOnShoppingCartLink();

		Assert.assertEquals(addToCartPage.getProductSKUValue(), expectedProductSKU);
		Assert.assertTrue(addToCartPage.isProductImageDisplayed());
		Assert.assertEquals(addToCartPage.getProductNameValue(), desktopsName);
		Assert.assertEquals(addToCartPage.getUnitPriceValue(), expectedProductPrice);
		Assert.assertEquals(addToCartPage.getQuantityValue("value"), countItem);
		Assert.assertEquals(addToCartPage.getSubTotalPriceValue(), dataHelp.getCurrencyFormat(expectedSubTotalPrice));

		addToCartPage.inputToQuantityTextbox("5");
		addToCartPage.clickOnUpdateCartButton();

		countItem = homePage.getShoppingCartQuantity();
		expectedSubTotalPrice = expectedProductPrice * countItem;

		Assert.assertEquals(addToCartPage.getQuantityValue("value"), countItem);
		Assert.assertEquals(addToCartPage.getSubTotalPriceValue(), dataHelp.getCurrencyFormat(expectedSubTotalPrice));

		addToCartPage.clickOnRemoveIcon();

		Assert.assertEquals(addToCartPage.getEmptyCartText(), "Your Shopping Cart is empty!");
		Assert.assertTrue(addToCartPage.isProductUndisplayedInCart());
	}

	@Test
	public void Orders_05_Checkout_QueuePaymentMethod() {
		homePage.clickOnProductTabLink(driver, productTab);
		computersPage = PageGeneratorManager.getComputersPageObject(driver);
		notebooksPage = computersPage.clickOnNotebooksLink();
		notebooksPage.clickOnProductNameLinkAtSubCategory(driver, notebooksName);

		noteBooksDetailedPage = PageGeneratorManager.getNotebooksDetailedPageObject(driver);
		noteBooksDetailedPage.clickOnAddToCartButton();

		Assert.assertEquals(noteBooksDetailedPage.getBarNotificationSuccessMessage(), "The product has been added to your shopping cart");

		expectedProductSKU = noteBooksDetailedPage.getProductSKUValue();
		expectedProductPrice = noteBooksDetailedPage.getProductUnitPriceValue();

		countItem = homePage.getShoppingCartQuantity();

		expectedSubTotalPrice = expectedProductPrice * countItem;

		homePage.refreshBrowser(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		addToCartPage = homePage.clickOnShoppingCartLink();
		Assert.assertTrue(addToCartPage.isAddToCartPageLoadedSuccessfully());

		// Verify info in Add to Cart page
		Assert.assertEquals(addToCartPage.getProductSKUValue(), expectedProductSKU);
		Assert.assertTrue(addToCartPage.isProductImageDisplayed());
		Assert.assertEquals(addToCartPage.getProductNameValue(), notebooksName);
		Assert.assertEquals(addToCartPage.getUnitPriceValue(), expectedProductPrice);
		Assert.assertEquals(addToCartPage.getQuantityValue("value"), countItem);
		Assert.assertEquals(addToCartPage.getSubTotalPriceValue(), dataHelp.getCurrencyFormat(expectedSubTotalPrice));

		addToCartPage.selectGiftWrappingDropdownlist(expectedGiftOption);
		Assert.assertTrue(addToCartPage.isGiftWrappingTextDisplayed());

		expectedGiftWrappingPrice = addToCartPage.getGiftWrappingValue();
		expectedSubTotalPrice += expectedGiftWrappingPrice;
		expectedShippingValue = addToCartPage.getSummaryShippingValue();

		expectedTaxValue = addToCartPage.getSummaryTaxValue();
		expectedTotalPrice = expectedSubTotalPrice + expectedShippingValue + expectedTaxValue;
		expectedEarningPoint = (int) (expectedTotalPrice / 10);

		Assert.assertEquals(addToCartPage.getSummarySubTotalPriceValue(), expectedSubTotalPrice);
		Assert.assertEquals(addToCartPage.getSummaryTaxValue(), expectedTaxValue);
		Assert.assertEquals(addToCartPage.getSummaryShippingValue(), expectedShippingValue);
		Assert.assertEquals(addToCartPage.getSummaryTotalPriceValue(), expectedTotalPrice);
		Assert.assertEquals(addToCartPage.getSummaryEarningPointValue(), expectedEarningPoint);

		addToCartPage.clickOnTermOfServiceCheckbox();
		checkoutPage = addToCartPage.clickOnCheckoutButton();
		
		Assert.assertTrue(checkoutPage.isCheckoutPageDisplayedSuccessfully());

		// assign state with value base on country
		expectedState = checkoutPage.chooseStateBaseOnCountry(expectedCountry);

		// input billing address info
		checkoutPage.unCheckOnShipSameAddressCheckbox();
		checkoutPage.inputToBillingFirstNameTextbox(firstName);
		checkoutPage.inputToBillingLastNameTextbox(lastName);
		checkoutPage.inputToBillingEmailTextbox(email);
		checkoutPage.selectBillingCountryDropdownlist(expectedCountry);
		checkoutPage.selectBillingStateDropdownlist(expectedState);
		checkoutPage.inputToBillingCityTextbox(expectedCity);
		checkoutPage.inputToBillingFirstAddressTextbox(expectedFirstAddress);
		checkoutPage.inputToBillingZipCodeTextbox(expectedZipcode);
		checkoutPage.inputToBillingPhoneNumberTextbox(expectedPhoneNumber);
		checkoutPage.clickOnBillingAddressContinueButton();

		// select address that have inputed in address dropdownlist
		checkoutPage.selectShippingAddressInDropdownlist(expectedCountry);
		checkoutPage.clickOnShippingAddressContinueButton();

		// select shipping method at Shipping Method page
		checkoutPage.selectShippingMethod(expectedShippingMethod);
		checkoutPage.clickOnShippingMethodContinueButton();

		// select payment method at Payment Method page
		checkoutPage.clickOnPaymentMethod(moneyPaymentMethod);
		checkoutPage.clickOnPaymentMethodContinueButton();

		Assert.assertTrue(checkoutPage.getPaymentInfoMessage().contains("Mail Personal or Business Check, Cashier's Check"));
		checkoutPage.clickOnContinueButton();

		// verify billing address section
		Assert.assertEquals(checkoutPage.getBillingNameValue(), firstName + " " + lastName);
		Assert.assertEquals(checkoutPage.getBillingEmailValue(), "Email: " + email);
		Assert.assertEquals(checkoutPage.getBillingPhoneNumberValue(), "Phone: " + expectedPhoneNumber);
		Assert.assertEquals(checkoutPage.getBillingFirstAddressValue(), expectedFirstAddress);
		Assert.assertEquals(checkoutPage.getBillingDetailedCityAddressValue(), checkoutPage.getDetailedCityAddressValue(expectedCity, expectedState, expectedZipcode));
		Assert.assertEquals(checkoutPage.getBillingCountryValue(), expectedCountry);
		Assert.assertEquals(checkoutPage.getPaymentMethodValue(), "Payment Method: " + moneyPaymentMethod);

		// verify shipping address section
		Assert.assertEquals(checkoutPage.getShippingNameValue(), firstName + " " + lastName);
		Assert.assertEquals(checkoutPage.getShippingEmailValue(), "Email: " + email);
		Assert.assertEquals(checkoutPage.getShippingPhoneNumberValue(), "Phone: " + expectedPhoneNumber);
		Assert.assertEquals(checkoutPage.getShippingFirstAddressValue(), expectedFirstAddress);
		Assert.assertEquals(checkoutPage.getShippingDetailedCityAddressValue(), checkoutPage.getDetailedCityAddressValue(expectedCity, expectedState, expectedZipcode));
		Assert.assertEquals(checkoutPage.getShippingCountryValue(), expectedCountry);
		Assert.assertTrue(checkoutPage.getShippingMethodValue().contains(getShippingMethodTextWithoutCost(expectedShippingMethod)));

		// verify product info
		Assert.assertEquals(checkoutPage.getProductSKUValue(), expectedProductSKU);
		Assert.assertTrue(checkoutPage.isProductImageDisplayed());
		Assert.assertEquals(checkoutPage.getProductNameValue(), notebooksName);
		Assert.assertEquals(checkoutPage.getProductUnitPriceValue(), dataHelp.getCurrencyFormat(expectedProductPrice));
		Assert.assertEquals(checkoutPage.getProductQuantityValue("value"), countItem);
		Assert.assertEquals(checkoutPage.getProductSubTotalPriceValue(), dataHelp.getCurrencyFormat(expectedSubTotalPrice));
		Assert.assertEquals(checkoutPage.getProductGiftWrappingValue(), "Gift wrapping: " + expectedGiftOption);
		Assert.assertEquals(checkoutPage.getProductTaxValue(), dataHelp.getCurrencyFormat(expectedTaxValue));
		Assert.assertEquals(checkoutPage.getProductShippingValue(), dataHelp.getCurrencyFormat(expectedShippingValue));
		Assert.assertEquals(checkoutPage.getProductTotalPriceValue(), dataHelp.getCurrencyFormat(expectedTotalPrice));
		Assert.assertEquals(checkoutPage.getProductEarningPointValue(), expectedEarningPoint + " points");

		expectedOrderDate = checkoutPage.clickOnConfirmButton();

		Assert.assertTrue(checkoutPage.isOrderMessageSuccessDisplayed());
		Assert.assertTrue(checkoutPage.isOrderNumberDisplayed());

		orderText = checkoutPage.getOrderNumber();

		myAccountPage = homePage.clickOnMyAccountLink();
		myAccountPage.clickOnSideBarMenu(driver, "Orders");

		ordersPage = PageGeneratorManager.getOrdersPageObject(driver);

		Assert.assertEquals(ordersPage.getOrderNumberValue("1"), orderText);
		Assert.assertTrue(ordersPage.isOrderStatusDisplayed("1"));
		Assert.assertEquals(ordersPage.getTotalPriceValue("1"), dataHelp.getCurrencyFormat(expectedTotalPrice));
		Assert.assertTrue(ordersPage.getOrderDateValue("1").contains(getSpecificDate(expectedOrderDate)));
		Assert.assertTrue(ordersPage.getOrderDateValue("1").contains(getSpecificHour(expectedOrderDate)));
		Assert.assertTrue(ordersPage.getOrderDateValue("1").contains(getSpecificHoursPeriod(expectedOrderDate)));
	}

	@Test
	public void Orders_06_Checkout_CardPaymentMethod() {
		homePage.clickOnProductTabLink(driver, productTab);
		computersPage = PageGeneratorManager.getComputersPageObject(driver);
		notebooksPage = computersPage.clickOnNotebooksLink();
		notebooksPage.clickOnProductNameLinkAtSubCategory(driver, notebooksName);

		noteBooksDetailedPage = PageGeneratorManager.getNotebooksDetailedPageObject(driver);
		noteBooksDetailedPage.clickOnAddToCartButton();

		Assert.assertEquals(noteBooksDetailedPage.getBarNotificationSuccessMessage(), "The product has been added to your shopping cart");

		expectedProductSKU = noteBooksDetailedPage.getProductSKUValue();
		expectedProductPrice = noteBooksDetailedPage.getProductUnitPriceValue();

		countItem = homePage.getShoppingCartQuantity();

		expectedSubTotalPrice = expectedProductPrice * countItem;

		homePage.refreshBrowser(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		addToCartPage = homePage.clickOnShoppingCartLink();
		Assert.assertTrue(addToCartPage.isAddToCartPageLoadedSuccessfully());

		// Verify info in Add to Cart page
		Assert.assertEquals(addToCartPage.getProductSKUValue(), expectedProductSKU);
		Assert.assertTrue(addToCartPage.isProductImageDisplayed());
		Assert.assertEquals(addToCartPage.getProductNameValue(), notebooksName);
		Assert.assertEquals(addToCartPage.getUnitPriceValue(), expectedProductPrice);
		Assert.assertEquals(addToCartPage.getQuantityValue("value"), countItem);
		Assert.assertEquals(addToCartPage.getSubTotalPriceValue(), dataHelp.getCurrencyFormat(expectedSubTotalPrice));

		addToCartPage.selectGiftWrappingDropdownlist(expectedGiftOption);
		Assert.assertTrue(addToCartPage.isGiftWrappingTextDisplayed());

		expectedGiftWrappingPrice = addToCartPage.getGiftWrappingValue();
		expectedSubTotalPrice += expectedGiftWrappingPrice;
		expectedShippingValue = addToCartPage.getSummaryShippingValue();

		expectedTaxValue = addToCartPage.getSummaryTaxValue();
		expectedTotalPrice = expectedSubTotalPrice + expectedShippingValue + expectedTaxValue;
		expectedEarningPoint = (int) (expectedTotalPrice / 10);

		Assert.assertEquals(addToCartPage.getSummarySubTotalPriceValue(), expectedSubTotalPrice);
		Assert.assertEquals(addToCartPage.getSummaryTaxValue(), expectedTaxValue);
		Assert.assertEquals(addToCartPage.getSummaryShippingValue(), expectedShippingValue);
		Assert.assertEquals(addToCartPage.getSummaryTotalPriceValue(), expectedTotalPrice);
		Assert.assertEquals(addToCartPage.getSummaryEarningPointValue(), expectedEarningPoint);

		addToCartPage.clickOnTermOfServiceCheckbox();
		checkoutPage = addToCartPage.clickOnCheckoutButton();

		Assert.assertTrue(checkoutPage.isCheckoutPageDisplayedSuccessfully());	
		
		checkoutPage.selectBillindAddressInDropdownlist(firstName);
		checkoutPage.clickOnBillingAddressContinueButton();

		// select shipping method at Shipping Method page
		checkoutPage.selectShippingMethod(expectedShippingMethod);
		checkoutPage.clickOnShippingMethodContinueButton();

		// select payment method at Payment Method page
		checkoutPage.clickOnPaymentMethod(cardPaymentMethod);
		checkoutPage.clickOnPaymentMethodContinueButton();

		// input Payment Information of Visa Card
		checkoutPage.selectCreditCardType("Master card");
		checkoutPage.inputToCardHolderNameTextbox(dataHelp.getFirstName() + dataHelp.getLastName());
		checkoutPage.inputToCardNumberTextbox(dataHelp.getBankCardNumber());
		checkoutPage.selectExpirationMonthDropdownlist("09");
		checkoutPage.selectExpirationYearDropdownlist("2032");
		checkoutPage.inputToCardCodeTextbox("935");
		checkoutPage.clickOnPaymentInfoContinueButton();

		// verify billing address section
		Assert.assertEquals(checkoutPage.getBillingNameValue(), firstName + " " + lastName);
		Assert.assertEquals(checkoutPage.getBillingEmailValue(), "Email: " + email);
		Assert.assertEquals(checkoutPage.getBillingPhoneNumberValue(), "Phone: " + expectedPhoneNumber);
		Assert.assertEquals(checkoutPage.getBillingFirstAddressValue(), expectedFirstAddress);
		Assert.assertEquals(checkoutPage.getBillingDetailedCityAddressValue(), checkoutPage.getDetailedCityAddressValue(expectedCity, expectedState, expectedZipcode));
		Assert.assertEquals(checkoutPage.getBillingCountryValue(), expectedCountry);
		Assert.assertEquals(checkoutPage.getPaymentMethodValue(), "Payment Method: " + cardPaymentMethod);

		// verify shipping address section
		Assert.assertEquals(checkoutPage.getShippingNameValue(), firstName + " " + lastName);
		Assert.assertEquals(checkoutPage.getShippingEmailValue(), "Email: " + email);
		Assert.assertEquals(checkoutPage.getShippingPhoneNumberValue(), "Phone: " + expectedPhoneNumber);
		Assert.assertEquals(checkoutPage.getShippingFirstAddressValue(), expectedFirstAddress);
		Assert.assertEquals(checkoutPage.getShippingDetailedCityAddressValue(), checkoutPage.getDetailedCityAddressValue(expectedCity, expectedState, expectedZipcode));
		Assert.assertEquals(checkoutPage.getShippingCountryValue(), expectedCountry);
		Assert.assertTrue(checkoutPage.getShippingMethodValue().contains(getShippingMethodTextWithoutCost(expectedShippingMethod)));

		// verify product info
		Assert.assertEquals(checkoutPage.getProductSKUValue(), expectedProductSKU);
		Assert.assertTrue(checkoutPage.isProductImageDisplayed());
		Assert.assertEquals(checkoutPage.getProductNameValue(), notebooksName);
		Assert.assertEquals(checkoutPage.getProductUnitPriceValue(), dataHelp.getCurrencyFormat(expectedProductPrice));
		Assert.assertEquals(checkoutPage.getProductQuantityValue("value"), countItem);
		Assert.assertEquals(checkoutPage.getProductSubTotalPriceValue(), dataHelp.getCurrencyFormat(expectedSubTotalPrice));
		Assert.assertEquals(checkoutPage.getProductGiftWrappingValue(), "Gift wrapping: " + expectedGiftOption);
		Assert.assertEquals(checkoutPage.getProductTaxValue(), dataHelp.getCurrencyFormat(expectedTaxValue));
		Assert.assertEquals(checkoutPage.getProductShippingValue(), dataHelp.getCurrencyFormat(expectedShippingValue));
		Assert.assertEquals(checkoutPage.getProductTotalPriceValue(), dataHelp.getCurrencyFormat(expectedTotalPrice));
		Assert.assertEquals(checkoutPage.getProductEarningPointValue(), expectedEarningPoint + " points");

		checkoutPage.waitForClickOnConfirmButton();
		expectedOrderDate = checkoutPage.clickOnConfirmButton();

		Assert.assertTrue(checkoutPage.isOrderMessageSuccessDisplayed());
		Assert.assertTrue(checkoutPage.isOrderNumberDisplayed());

		orderText = checkoutPage.getOrderNumber();

		myAccountPage = homePage.clickOnMyAccountLink();
		myAccountPage.clickOnSideBarMenu(driver, "Orders");

		ordersPage = PageGeneratorManager.getOrdersPageObject(driver);

		Assert.assertEquals(ordersPage.getOrderNumberValue("1"), orderText);
		Assert.assertTrue(ordersPage.isOrderStatusDisplayed("1"));
		Assert.assertEquals(ordersPage.getTotalPriceValue("1"), dataHelp.getCurrencyFormat(expectedTotalPrice));
		Assert.assertTrue(ordersPage.getOrderDateValue("1").contains(getSpecificDate(expectedOrderDate)));
		Assert.assertTrue(ordersPage.getOrderDateValue("1").contains(getSpecificHour(expectedOrderDate)));
		Assert.assertTrue(ordersPage.getOrderDateValue("1").contains(getSpecificHoursPeriod(expectedOrderDate)));
	}

	@Test
	public void Orders_07_ReOrder() {
		newFirstName = dataHelp.getFirstName();
		newLastName = dataHelp.getLastName();
		newEmail = dataHelp.getEmailAddress();
		newCountry = dataHelp.getCountry();
		newCity = dataHelp.getCity();
		newFirstAddress = dataHelp.getAddress();
		newZipcode = dataHelp.getZipCode();
		newPhoneNumber = dataHelp.getPhoneNumber();
		newShippingMethod = "2nd Day Air ($0.00)";
		
		ordersPage.clickOnOrderDetails("1");
		addToCartPage = ordersPage.clickReOrderButton();

		Assert.assertTrue(addToCartPage.isAddToCartPageLoadedSuccessfully());
		
		expectedSubTotalPrice = expectedProductPrice * countItem;

		// Verify info in Add to Cart page
		Assert.assertEquals(addToCartPage.getProductSKUValue(), expectedProductSKU);
		Assert.assertTrue(addToCartPage.isProductImageDisplayed());
		Assert.assertEquals(addToCartPage.getProductNameValue(), notebooksName);
		Assert.assertEquals(addToCartPage.getUnitPriceValue(), expectedProductPrice);
		Assert.assertEquals(addToCartPage.getQuantityValue("value"), countItem);
		Assert.assertEquals(addToCartPage.getSubTotalPriceValue(), dataHelp.getCurrencyFormat(expectedSubTotalPrice));
		Assert.assertTrue(addToCartPage.isGiftWrappingTextDisplayed());

		//input quantity = 10
		addToCartPage.inputToQuantityTextbox("10");
		addToCartPage.clickOnUpdateCartButton();
		
		Assert.assertTrue(addToCartPage.isAddToCartPageLoadedSuccessfully());
		expectedSubTotalPrice = addToCartPage.getSummarySubTotalPriceValue();
		
		Assert.assertEquals(addToCartPage.getQuantityValue("value"), 10);
		
		expectedProductPrice = addToCartPage.getUnitPriceValue();
		countItem = addToCartPage.getQuantityValue("value");
		expectedSubTotalPrice = expectedProductPrice * countItem;
		Assert.assertEquals(addToCartPage.getSubTotalPriceValue(), dataHelp.getCurrencyFormat(expectedSubTotalPrice));
		
		expectedSubTotalPrice += expectedGiftWrappingPrice;
		expectedShippingValue = addToCartPage.getSummaryShippingValue();
		expectedTaxValue = addToCartPage.getSummaryTaxValue();
		
		expectedTotalPrice = expectedSubTotalPrice + expectedShippingValue + expectedTaxValue;
		expectedEarningPoint = (int) (expectedTotalPrice / 10);

		Assert.assertEquals(addToCartPage.getSummarySubTotalPriceValue(), expectedSubTotalPrice);
		Assert.assertEquals(addToCartPage.getSummaryTaxValue(), expectedTaxValue);
		Assert.assertEquals(addToCartPage.getSummaryShippingValue(), expectedShippingValue);
		Assert.assertEquals(addToCartPage.getSummaryTotalPriceValue(), expectedTotalPrice);
		Assert.assertEquals(addToCartPage.getSummaryEarningPointValue(), expectedEarningPoint);

		addToCartPage.clickOnTermOfServiceCheckbox();
		checkoutPage = addToCartPage.clickOnCheckoutButton();
		
		Assert.assertTrue(checkoutPage.isCheckoutPageDisplayedSuccessfully());
		
		newState = checkoutPage.chooseStateBaseOnCountry(newCountry);

		//input user info in Billing Address form
		checkoutPage.unCheckOnShipSameAddressCheckbox();
		checkoutPage.selectBillindAddressInDropdownlist("New Address");
		checkoutPage.inputToBillingFirstNameTextbox(newFirstName);
		checkoutPage.inputToBillingLastNameTextbox(newLastName);
		checkoutPage.inputToBillingEmailTextbox(newEmail);
		checkoutPage.selectBillingCountryDropdownlist(newCountry);
		checkoutPage.selectBillingStateDropdownlist(newState);
		checkoutPage.inputToBillingCityTextbox(newCity);
		checkoutPage.inputToBillingFirstAddressTextbox(newFirstAddress);
		checkoutPage.inputToBillingZipCodeTextbox(newZipcode);
		checkoutPage.inputToBillingPhoneNumberTextbox(newPhoneNumber);
		checkoutPage.clickOnBillingAddressContinueButton();

		//input user info in Shipping Address form
		checkoutPage.selectShippingAddressInDropdownlist("New Address");
		checkoutPage.inputToShippingFirstNameTextbox(newFirstName);
		checkoutPage.inputToShippingLastNameTextbox(newLastName);
		checkoutPage.inputToShippingEmailTextbox(newEmail);
		checkoutPage.selectShippingCountryDropdownlist(newCountry);
		checkoutPage.selectShippingStateDropdownlist(newState);
		checkoutPage.inputToShippingCityTextbox(newCity);
		checkoutPage.inputToShippingFirstAddressTextbox(newFirstAddress);
		checkoutPage.inputToShippingZipCodeTextbox(newZipcode);
		checkoutPage.inputToShippingPhoneNumberTextbox(newPhoneNumber);
		checkoutPage.clickOnShippingAddressContinueButton();
		
		// select shipping method at Shipping Method page
		checkoutPage.selectShippingMethod(newShippingMethod);
		checkoutPage.clickOnShippingMethodContinueButton();

		// select payment method at Payment Method page
		checkoutPage.clickOnPaymentMethod(cardPaymentMethod);
		checkoutPage.clickOnPaymentMethodContinueButton();

		// input Payment Information of Visa Card
		checkoutPage.selectCreditCardType("Visa");
		checkoutPage.inputToCardHolderNameTextbox(dataHelp.getFirstName() + dataHelp.getLastName());
		checkoutPage.inputToCardNumberTextbox(dataHelp.getBankCardNumber());
		checkoutPage.selectExpirationMonthDropdownlist("06");
		checkoutPage.selectExpirationYearDropdownlist("2030");
		checkoutPage.inputToCardCodeTextbox("345");
		checkoutPage.clickOnPaymentInfoContinueButton();

		// verify billing address section
		Assert.assertEquals(checkoutPage.getBillingNameValue(), newFirstName + " " + newLastName);
		Assert.assertEquals(checkoutPage.getBillingEmailValue(), "Email: " + newEmail);
		Assert.assertEquals(checkoutPage.getBillingPhoneNumberValue(), "Phone: " + newPhoneNumber);
		Assert.assertEquals(checkoutPage.getBillingFirstAddressValue(), newFirstAddress);
		Assert.assertEquals(checkoutPage.getBillingDetailedCityAddressValue(), checkoutPage.getDetailedCityAddressValue(newCity, newState, newZipcode));
		Assert.assertEquals(checkoutPage.getBillingCountryValue(), newCountry);
		Assert.assertEquals(checkoutPage.getPaymentMethodValue(), "Payment Method: " + cardPaymentMethod);

		// verify shipping address section
		Assert.assertEquals(checkoutPage.getShippingNameValue(), newFirstName + " " + newLastName);
		Assert.assertEquals(checkoutPage.getShippingEmailValue(), "Email: " + newEmail);
		Assert.assertEquals(checkoutPage.getShippingPhoneNumberValue(), "Phone: " + newPhoneNumber);
		Assert.assertEquals(checkoutPage.getShippingFirstAddressValue(), newFirstAddress);
		Assert.assertEquals(checkoutPage.getShippingDetailedCityAddressValue(), checkoutPage.getDetailedCityAddressValue(newCity, newState, newZipcode));
		Assert.assertEquals(checkoutPage.getShippingCountryValue(), newCountry);
		Assert.assertTrue(checkoutPage.getShippingMethodValue().contains(getShippingMethodTextWithoutCost(newShippingMethod)));

		// verify product info
		Assert.assertEquals(checkoutPage.getProductSKUValue(), expectedProductSKU);
		Assert.assertTrue(checkoutPage.isProductImageDisplayed());
		Assert.assertEquals(checkoutPage.getProductNameValue(), notebooksName);
		Assert.assertEquals(checkoutPage.getProductUnitPriceValue(), dataHelp.getCurrencyFormat(expectedProductPrice));
		Assert.assertEquals(checkoutPage.getProductQuantityValue("value"), countItem);
		Assert.assertEquals(checkoutPage.getProductSubTotalPriceValue(), dataHelp.getCurrencyFormat(expectedSubTotalPrice));
		Assert.assertEquals(checkoutPage.getProductGiftWrappingValue(), "Gift wrapping: " + expectedGiftOption);
		Assert.assertEquals(checkoutPage.getProductTaxValue(), dataHelp.getCurrencyFormat(expectedTaxValue));
		Assert.assertEquals(checkoutPage.getProductShippingValue(), dataHelp.getCurrencyFormat(expectedShippingValue));
		Assert.assertEquals(checkoutPage.getProductTotalPriceValue(), dataHelp.getCurrencyFormat(expectedTotalPrice));
		Assert.assertEquals(checkoutPage.getProductEarningPointValue(), expectedEarningPoint + " points");

		checkoutPage.waitForClickOnConfirmButton();
		expectedOrderDate = checkoutPage.clickOnConfirmButton();

		Assert.assertTrue(checkoutPage.isOrderMessageSuccessDisplayed());
		Assert.assertTrue(checkoutPage.isOrderNumberDisplayed());

		orderText = checkoutPage.getOrderNumber();

		myAccountPage = homePage.clickOnMyAccountLink();
		myAccountPage.clickOnSideBarMenu(driver, "Orders");

		ordersPage = PageGeneratorManager.getOrdersPageObject(driver);

		Assert.assertEquals(ordersPage.getOrderNumberValue("1"), orderText);
		Assert.assertTrue(ordersPage.isOrderStatusDisplayed("1"));
		Assert.assertEquals(ordersPage.getTotalPriceValue("1"), dataHelp.getCurrencyFormat(expectedTotalPrice));
		Assert.assertTrue(ordersPage.getOrderDateValue("1").contains(getSpecificDate(expectedOrderDate)));
		Assert.assertTrue(ordersPage.getOrderDateValue("1").contains(getSpecificHour(expectedOrderDate)));
		Assert.assertTrue(ordersPage.getOrderDateValue("1").contains(getSpecificHoursPeriod(expectedOrderDate)));
	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();
	}

	public String getShippingMethodTextWithoutCost(String expectedShippingMethod) {
		return expectedShippingMethod.substring(0, expectedShippingMethod.indexOf("(")).trim();
	}

	public String getSpecificDate(String expectedOrderDate) {
		return expectedOrderDate.substring(0, 10);
	}

	public String getSpecificHour(String expectedOrderDate) {
		return expectedOrderDate.substring(11, 12);
	}

	public String getSpecificHoursPeriod(String expectedOrderDate) {
		return expectedOrderDate.substring(19, 21);
	}
}
