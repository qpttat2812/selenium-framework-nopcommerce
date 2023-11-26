package commons;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import pagesUI.admin.AdminBasePageUI;
import pagesUI.user.UserBasePageUI;

public class BasePages {
	private long longTimeOut = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeOut = GlobalConstants.SHORT_TIMEOUT;
	private WebDriver driver;

	public BasePages(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openPageURL(String url) {
		driver.get(url);
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public void navigateToPreviousPage() {
		driver.navigate().back();
	}

	public void forwardBrowser() {
		driver.navigate().forward();
	}

	public void refreshBrowser() {
		driver.navigate().refresh();
	}

	public void waitForAlertPresence() {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public Alert getAlert() {
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		getAlert().accept();
	}

	public void cancelAlert() {
		getAlert().dismiss();
	}

	public String getAlertText() {
		return getAlert().getText();
	}

	public void sendkeyToAlert(String text) {
		getAlert().sendKeys(text);
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public Set<String> getAllWindowsHandle() {
		return driver.getWindowHandles();
	}

	public void switchWindowByID(String baseWindowID) {
		Set<String> allWindowsID = getAllWindowsHandle();

		for (String windowID : allWindowsID) {
			if (!windowID.equals(baseWindowID)) {
				driver.switchTo().window(windowID);
				break;
			}
		}
	}

	public void switchWindowByTitle(String expectedTitle) {
		Set<String> allWindowsID = getAllWindowsHandle();

		for (String windowID : allWindowsID) {
			driver.switchTo().window(windowID);
			if (driver.getTitle().equals(expectedTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutBaseWindow(String baseWindowTitle) {
		Set<String> allWindowsID = getAllWindowsHandle();

		for (String windowID : allWindowsID) {
			driver.switchTo().window(windowID);
			if (!driver.getTitle().equals(baseWindowTitle)) {
				driver.close();
			}
		}
	}

	public WebElement getElement(String xpathLocator) {
		return driver.findElement(getByXpathLocator(xpathLocator));
	}

	public WebElement getElement(String xpathLocator, String... valuesForXpathLocator) {
		return driver.findElement(getByDynamicXpath(xpathLocator, valuesForXpathLocator));
	}

	public List<WebElement> getElements(String xpathLocator) {
		return driver.findElements(getByXpathLocator(xpathLocator));
	}

	public List<WebElement> getElements(String xpathLocator, String... valuesForXpathLocator) {
		return driver.findElements(getByDynamicXpath(xpathLocator, valuesForXpathLocator));
	}

	public By getByXpathLocator(String locator) {
		return By.xpath(locator);
	}

	public void clickOnElement(String xpathLocator) {
		getElement(xpathLocator).click();
	}

	public void clickOnElement(String xpathLocator, String... valuesForXpathLocator) {
		getElement(xpathLocator, valuesForXpathLocator).click();
	}

	public void checkOnCheckbox(String xpathLocator) {
		if (!getElement(xpathLocator).isSelected()) {
			getElement(xpathLocator).click();
		}
	}

	public void checkOnCheckbox(String xpathLocator, String... valuesForXpathLocator) {
		if (!getElement(xpathLocator, valuesForXpathLocator).isSelected()) {
			getElement(xpathLocator, valuesForXpathLocator).click();
		}
	}

	public void uncheckCheckbox(String xpathLocator) {
		if (getElement(xpathLocator).isSelected()) {
			getElement(xpathLocator).click();
		}
	}

	public void uncheckCheckbox(String xpathLocator, String... valuesForXpathLocator) {
		if (getElement(xpathLocator, valuesForXpathLocator).isSelected()) {
			getElement(xpathLocator, valuesForXpathLocator).click();
		}
	}

	public void clickOnRadioButton(String xpathLocator) {
		if (!getElement(xpathLocator).isSelected()) {
			getElement(xpathLocator).click();
		}
	}

	public void clickOnRadioButton(String xpathLocator, String... valuesForXpath) {
		if (!getElement(xpathLocator, valuesForXpath).isSelected()) {
			getElement(xpathLocator, valuesForXpath).click();
		}
	}

	public void sendkeyToElement(String xpathLocator, String sendkeyValue) {
		getElement(xpathLocator).clear();
		getElement(xpathLocator).sendKeys(sendkeyValue);
	}

	public void sendkeyToElement(String xpathLocator, String sendkeyText, String... valuesForXpathLocator) {
		getElement(xpathLocator, valuesForXpathLocator).clear();
		getElement(xpathLocator, valuesForXpathLocator).sendKeys(sendkeyText);
	}

	public void sendkeyAndSelectItemCustomDropdownList(String baseDropdownListXpath, String itemsInDropdownListXpath, String expectedItem) {
		getElement(baseDropdownListXpath).sendKeys(expectedItem);

		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpathLocator(itemsInDropdownListXpath)));

		List<WebElement> allItems = getElements(itemsInDropdownListXpath);

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				scrollIntoViewByJS(item);
				item.click();
				break;
			}
		}
	}

	public void selectItemCustomDropdownList(String baseDropdownListXpath, String itemsInDropdownListXpath, String expectedItem) {
		getElement(baseDropdownListXpath).click();

		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpathLocator(itemsInDropdownListXpath)));

		List<WebElement> elements = getElements(itemsInDropdownListXpath);

		for (WebElement element : elements) {
			if (element.getText().trim().equals(expectedItem)) {
				scrollIntoViewByJS(element);
				element.click();
				break;
			}
		}
	}

	public void selectDefaultItemDropdownList(String baseDropdownListXpath, String expectedText) {
		new Select(getElement(baseDropdownListXpath)).selectByVisibleText(expectedText);
	}

	public void selectDefaultItemInDropdownList(String baseDropdownListXpath, String expectedText, String... valuesForXpathLocator) {
		new Select(getElement(baseDropdownListXpath, valuesForXpathLocator)).selectByVisibleText(expectedText);
	}

	public void uploadSingleFile(String xpathLocator, String fileName) {
		String filePath = GlobalConstants.UPLOAD_FILE + File.separator + fileName;
		getElement(xpathLocator).sendKeys(filePath);
	}

	public void uploadMultipleFiles(String xpathLocator, String... filesName) {
		String basePath = GlobalConstants.UPLOAD_FILE + File.separator;
		String filePath = "";
		for (String file : filesName) {
			filePath = basePath + file + "\n";
			getElement(xpathLocator).sendKeys(filePath.trim());
		}
	}

	public String getFirstSelectedItemInDropdown(String xpathLocator) {
		return new Select(getElement(xpathLocator)).getFirstSelectedOption().getText();
	}

	public List<String> getListSelectedItemInDropdown(String xpathLocator) {
		List<WebElement> elements = new Select(getElement(xpathLocator)).getAllSelectedOptions();
		List<String> textResults = new ArrayList<String>();

		for (WebElement element : elements) {
			textResults.add(element.getText());
		}

		return textResults;
	}

	public String getTextElement(String xpathLocator) {
		return getElement(xpathLocator).getText().trim();
	}

	public List<String> getAllTextElements(String xpathLocator) {
		List<WebElement> elements = getElements(xpathLocator);
		List<String> textResults = new ArrayList<>();
		for (WebElement element : elements) {
			textResults.add(element.getText().trim());
		}
		return textResults;
	}

	public String getTextElement(String xpathLocator, String... valuesForXpathLocator) {
		return getElement(xpathLocator, valuesForXpathLocator).getText().trim();
	}

	public boolean isDropdownMultiple(String xpathLocator) {
		return new Select(getElement(xpathLocator)).isMultiple();
	}

	public void scrollIntoViewByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public String getAttributeValue(String xpathLocator, String attributeName) {
		return getElement(xpathLocator).getAttribute(attributeName);
	}

	public String getAttributeValue(String xpathLocator, String attributeName, String... valuesForXpathLocator) {
		return getElement(xpathLocator, valuesForXpathLocator).getAttribute(attributeName);
	}

	public String getCSSValue(String xpathLocator, String cssAttributName) {
		return getElement(xpathLocator).getCssValue(cssAttributName);
	}

	public String getCSSValue(String xpathLocator, String cssAttributName, String... valuesForXpathLocator) {
		return getElement(xpathLocator, valuesForXpathLocator).getCssValue(cssAttributName);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(String xpathLocator) {
		return getElements(xpathLocator).size();
	}

	public int getElementSize(String locatorString, String... parameters) {
		return getElements(locatorString, parameters).size();
	}

	public boolean isElementDisplayed(String xpathLocator) {
		overrideTimeOut(shortTimeOut);
		if (!getElement(xpathLocator).isDisplayed()) {
			overrideTimeOut(longTimeOut);
			return false;
		}
		else {
			overrideTimeOut(longTimeOut);
			return true;
		}
		 
	}

	public boolean isElementDisplayed(String xpathLocator, String... valuesForXpathLocator) {
		return getElement(xpathLocator, valuesForXpathLocator).isDisplayed();
	}

	public boolean isElementEnabled(String xpathLocator) {
		return getElement(xpathLocator).isEnabled();
	}

	public boolean isElementEnabled(String xpathLocator, String... valuesForXpathLocator) {
		return getElement(xpathLocator, valuesForXpathLocator).isEnabled();
	}

	public boolean isElementSelected(String xpathLocator) {
		return getElement(xpathLocator).isSelected();
	}

	public boolean isElementSelected(String xpathLocator, String... valuesForXpathLocator) {
		return getElement(xpathLocator, valuesForXpathLocator).isSelected();
	}

	public void switchToFrameOrIframe(String xpathLocator) {
		driver.switchTo().frame(getElement(xpathLocator));
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public void doubleClickOnElement(String xpathLocator) {
		new Actions(driver).doubleClick(getElement(xpathLocator)).perform();
	}

	public void hoverElement(String xpathLocator) {
		new Actions(driver).moveToElement(getElement(xpathLocator)).perform();
	}

	public void rightClickOnElement(String xpathLocator) {
		new Actions(driver).contextClick(getElement(xpathLocator)).perform();
	}

	public void dragAndDropElement(String sourceXpath, String targetXpath) {
		new Actions(driver).dragAndDrop(getElement(sourceXpath), getElement(targetXpath)).perform();
	}

	public void sendkeyToElement(String xpathLocator, Keys key) {
		new Actions(driver).sendKeys(getElement(xpathLocator), key).perform();
	}

	public void navigateURLByJS(String xpathLocator, String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location = '" + url + "'", getElement(xpathLocator));
	}

	public String getDomainByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return document.domain;");
	}

	public String getURLByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return document.URL;");
	}

	public void clickOnElementByJS(String xpathLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getElement(xpathLocator));
	}

	public String getInnerHTMLContentByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return document.documentElement.innerHTML;");
	}
	
	public String getInnerTextByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return ((String) js.executeScript("return arguments[0].innerText;", element)).trim();
	}

	public String getTitleByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return document.title;");
	}

	public void scrollToBottomPageByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	}

	public void scrollHorizontalPageByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(document.body.scrollWidth, 0)");
	}

	public void hightlightToElement(String xpathLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement highlightElement = getElement(xpathLocator);
		String styleValue = highlightElement.getAttribute("style");
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", highlightElement, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", highlightElement, "style", styleValue);
	}

	public void hightlightToElement(String xpathLocator, String... valuesForXpathLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement highlightElement = getElement(xpathLocator, valuesForXpathLocator);
		String styleValue = highlightElement.getAttribute("style");
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", highlightElement, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", highlightElement, "style", styleValue);
	}

	public void removeAttributeElementByJS(String xpathLocator, String attribute) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attribute + "');", getElement(xpathLocator));
	}

	public void removeAttributeElementByJS(String xpathLocator, String attribute, String... valuesForXpathLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attribute + "');", getElement(xpathLocator, valuesForXpathLocator));
	}

	public boolean checkImageLoadedAndDisplayed(String xpathLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean status = (boolean) js.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getElement(xpathLocator));

		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkImageLoadedAndDisplayed(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean status = (boolean) js.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				element);
		
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTextInInnerTextByJS(String expectedText) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String actualText = (String) js.executeScript("return document.documentElement.innerText.match('" + expectedText + "')");
		return actualText.equals(expectedText);
	}

	public String getValidationMessage(String xpathLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return arguments[0].validationMessage", getElement(xpathLocator));
	}

	public boolean isJQueryOrJSLoadedSuccess() {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForElementVisibility(String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpathLocator(xpathLocator)));
	}

	public void waitForElementVisibility(String xpathLocator, String... valuesForXpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByDynamicXpath(xpathLocator, valuesForXpathLocator)));
	}
	
	public void waitForElementPresence(String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByXpathLocator(xpathLocator)));
	}
	
	public void waitForElementPresence(String xpathLocator, String... valuesForXpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByDynamicXpath(xpathLocator, valuesForXpathLocator)));
	}

	public void waitForAllElementsVisibility(String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(getElements(xpathLocator)));
	}

	public void waitForElementClickable(String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpathLocator(xpathLocator)));
	}

	public void waitForElementClickable(String xpathLocator, String... valuesForXpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByDynamicXpath(xpathLocator, valuesForXpathLocator)));
	}

	public void waitForElementInvisibility(String xpathLocator) {
		overrideTimeOut(shortTimeOut);
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(shortTimeOut));
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpathLocator(xpathLocator)));
		overrideTimeOut(longTimeOut);
	}

	public void waitForElementInvisibility(String xpathLocator, String... valuesForXpathLocator) {
		overrideTimeOut(shortTimeOut);
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(shortTimeOut));
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByDynamicXpath(xpathLocator, valuesForXpathLocator)));
		overrideTimeOut(longTimeOut);
	}

	private By getByDynamicXpath(String xpathLocator, String... values) {
		By by = null;
		by = By.xpath(String.format(xpathLocator, (Object[]) values));
		return by;
	}

	private void overrideTimeOut(long timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}

	public boolean isElementUndisplayed(String xpathLocator) {
		overrideTimeOut(shortTimeOut);
		List<WebElement> elements = getElements(xpathLocator);
		overrideTimeOut(longTimeOut);
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public Set<Cookie> getAllCookies() {
		return driver.manage().getCookies();
	}

	public void setCookie(Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(5);
	}
	
	public String getValueFromDataTable(String columnXpathLocator, String rowXpathLocator, String columnLabel, String expectedValue) {
		String result = "";
		int columnIndex = getElements(columnXpathLocator, columnLabel).size() + 1;

		List<WebElement> elements = getElements(rowXpathLocator, String.valueOf(columnIndex));

		for (WebElement element : elements) {
			if (element.getText().contains(expectedValue)) {
				result = element.getText();
				break;
			}
		}

		return result;
	}
	// -------------------- OTHER COMMON SPECIFIC FUNCTIONS IN NOPCOMMERCE -----------------------------

	/**
	 * Function for clicking on textlink at Sidebar
	 * 
	 * @param driver
	 * @param valuesForXpathLocator - textlink names of Sidebar
	 */
	@Step("Click on {1} link at Sidebar")
	public void clickOnSideBarMenu(String valuesForXpathLocator) {
		waitForElementVisibility(UserBasePageUI.DYNAMIC_SIDEBAR_MY_ACCOUNT_LINKS, valuesForXpathLocator);
		clickOnElement(UserBasePageUI.DYNAMIC_SIDEBAR_MY_ACCOUNT_LINKS, valuesForXpathLocator);
	}

	/**
	 * Function for clicking on textlink at Footer
	 * 
	 * @param driver
	 * @param valuesForXpathLocator - textlink names of Footer
	 */
	@Step("Click on {1} link at Footer")
	public void clickOnFooterLink(String valuesForXpathLocator) {
		waitForElementVisibility(UserBasePageUI.DYNAMIC_FOOTER_LINKS, valuesForXpathLocator);
		clickOnElement(UserBasePageUI.DYNAMIC_FOOTER_LINKS, valuesForXpathLocator);
	}

	/**
	 * Function for clicking on tab name link
	 * 
	 * @param driver
	 * @param valuesForXpathLocator - tab name
	 */
	@Step("Click on {1} tab link")
	public void clickOnProductTabLink(String valuesForXpathLocator) {
		waitForElementVisibility(UserBasePageUI.DYNAMIC_PRODUCT_TAB, valuesForXpathLocator);
		clickOnElement(UserBasePageUI.DYNAMIC_PRODUCT_TAB, valuesForXpathLocator);
	}
	
	/**
	 * Fuction for clicking on product title in Sub Category page
	 * 
	 * @param driver
	 * @param productName
	 */
	@Step("Click on product name with value {0}")
	public void clickOnProductNameLinkAtSubCategory(String productName) {
		waitForElementVisibility(UserBasePageUI.DYNAMIC_PRODUCT_NAME_IN_SUB_CATEGORY_PAGE, productName);
		clickOnElement(UserBasePageUI.DYNAMIC_PRODUCT_NAME_IN_SUB_CATEGORY_PAGE, productName);
	}
	
	/** ADMIN
	 * Fuction for clicking on Parent Sidebar
	 * 
	 * @param driver
	 * @param sideBarName
	 */
	@Step("Click on product name with value {0}")
	public void clickOnParentSidebarMenuOfAdmin(String sideBarName) {
		waitForElementClickable(AdminBasePageUI.DYNAMIC_PARENT_SIDEBAR_MENU, sideBarName);
		clickOnElement(AdminBasePageUI.DYNAMIC_PARENT_SIDEBAR_MENU, sideBarName);
	}
	
	/** ADMIN
	 * Fuction for clicking on Sub-Sidebar
	 * 
	 * @param driver
	 * @param subSidebarName
	 */
	@Step("Click on product name with value {0}")
	public void clickOnSubSidebarMenuOfAdmin(String sidebarName, String subSidebarName) {
		waitForElementClickable(AdminBasePageUI.DYNAMIC_SUB_SIDEBAR_MENU, sidebarName, subSidebarName);
		clickOnElement(AdminBasePageUI.DYNAMIC_SUB_SIDEBAR_MENU, sidebarName, subSidebarName);
	}
}
