package common;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

import pagesUI.user.BasePageUI;

public class BasePages {
	private static final long SECOND = GlobalConstants.LONG_TIMEOUT;

	public static BasePages getBasePages() {
		return new BasePages();
	}

	public void openURL(WebDriver driver, String url) {
		driver.get(url);
	}

	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void backBrowser(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardBrowser(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshBrowser(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(SECOND));
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public Alert getAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}

	public void acceptAlert(WebDriver driver) {
		getAlert(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		getAlert(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return getAlert(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String text) {
		getAlert(driver).sendKeys(text);
	}

	public String getWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public Set<String> getAllWindowsHandle(WebDriver driver) {
		return driver.getWindowHandles();
	}

	public void switchWindowByID(WebDriver driver, String baseWindowID) {
		Set<String> allWindowsID = getAllWindowsHandle(driver);

		for (String windowID : allWindowsID) {
			if (!windowID.equals(baseWindowID)) {
				driver.switchTo().window(windowID);
				break;
			}
		}
	}

	public void switchWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindowsID = getAllWindowsHandle(driver);

		for (String windowID : allWindowsID) {
			driver.switchTo().window(windowID);
			if (driver.getTitle().equals(expectedTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutBaseWindow(WebDriver driver, String baseWindowTitle) {
		Set<String> allWindowsID = getAllWindowsHandle(driver);

		for (String windowID : allWindowsID) {
			driver.switchTo().window(windowID);
			if (!driver.getTitle().equals(baseWindowTitle)) {
				driver.close();
			}
		}
	}

	public WebElement getElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(getByXpathLocator(driver, xpathLocator));
	}
	
	public WebElement getElement(WebDriver driver, String xpathLocator, String... valuesForXpathLocator) {
		return driver.findElement(getByDynamicXpath(xpathLocator, valuesForXpathLocator));
	}

	public List<WebElement> getElements(WebDriver driver, String xpathLocator) {
		return driver.findElements(getByXpathLocator(driver, xpathLocator));
	}
	
	public List<WebElement> getElements(WebDriver driver, String xpathLocator, String... valuesForXpathLocator) {
		return driver.findElements(getByDynamicXpath(xpathLocator, valuesForXpathLocator));
	}

	public By getByXpathLocator(WebDriver driver, String locator) {
		return By.xpath(locator);
	}

	public void clickOnElement(WebDriver driver, String xpathLocator) {
		getElement(driver, xpathLocator).click();
	}
	
	public void clickOnElement(WebDriver driver, String xpathLocator, String... valuesForXpathLocator) {
		getElement(driver, xpathLocator, valuesForXpathLocator).click();
	}

	public void checkOnCheckbox(WebDriver driver, String xpathLocator) {
		if (!getElement(driver, xpathLocator).isSelected()) {
			getElement(driver, xpathLocator).click();
		}
	}
	
	public void checkOnCheckbox(WebDriver driver, String xpathLocator, String... valuesForXpathLocator) {
		if (!getElement(driver, xpathLocator, valuesForXpathLocator).isSelected()) {
			getElement(driver, xpathLocator, valuesForXpathLocator).click();
		}
	}

	public void uncheckCheckbox(WebDriver driver, String xpathLocator) {
		if (getElement(driver, xpathLocator).isSelected()) {
			getElement(driver, xpathLocator).click();
		}
	}
	
	public void uncheckCheckbox(WebDriver driver, String xpathLocator, String... valuesForXpathLocator) {
		if (getElement(driver, xpathLocator, valuesForXpathLocator).isSelected()) {
			getElement(driver, xpathLocator, valuesForXpathLocator).click();
		}
	}

	public void clickOnRadioButton(WebDriver driver, String xpathLocator) {
		if (!getElement(driver, xpathLocator).isSelected()) {
			getElement(driver, xpathLocator).click();
		}
	}
	
	public void clickOnRadioButton(WebDriver driver, String xpathLocator, String... valuesForXpath) {
		if (!getElement(driver, xpathLocator, valuesForXpath).isSelected()) {
			getElement(driver, xpathLocator, valuesForXpath).click();
		}
	}

	public void sendkeyToElement(WebDriver driver, String xpathLocator, String sendkeyText) {
		getElement(driver, xpathLocator).clear();
		getElement(driver, xpathLocator).sendKeys(sendkeyText);
	}
	
	public void sendkeyToElement(WebDriver driver, String xpathLocator, String sendkeyText, String... valuesForXpathLocator) {
		getElement(driver, xpathLocator, valuesForXpathLocator).clear();
		getElement(driver, xpathLocator, valuesForXpathLocator).sendKeys(sendkeyText);
	}

	public void sendkeyAndSelectItemCustomDropdownList(WebDriver driver, String baseDropdownListXpath, String itemsInDropdownListXpath, String expectedItem) {
		getElement(driver, baseDropdownListXpath).sendKeys(expectedItem);

		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(SECOND));
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpathLocator(driver, itemsInDropdownListXpath)));

		List<WebElement> allItems = getElements(driver, itemsInDropdownListXpath);

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				scrollIntoViewByJS(driver, item);
				item.click();
				break;
			}
		}
	}

	public void selectItemCustomDropdownList(WebDriver driver, String baseDropdownListXpath, String itemsInDropdownListXpath, String expectedItem) {
		getElement(driver, baseDropdownListXpath).click();

		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(SECOND));
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpathLocator(driver, itemsInDropdownListXpath)));

		List<WebElement> elements = getElements(driver, itemsInDropdownListXpath);

		for (WebElement element : elements) {
			if (element.getText().trim().equals(expectedItem)) {
				scrollIntoViewByJS(driver, element);
				element.click();
				break;
			}
		}
	}

	public void selectItemDefaultDropdownList(WebDriver driver, String baseDropdownListXpath, String expectedText) {
		new Select(getElement(driver, baseDropdownListXpath)).selectByVisibleText(expectedText);
	}
	
	public void selectDefaultItemInDropdownList(WebDriver driver, String baseDropdownListXpath, String expectedText, String... valuesForXpathLocator) {
		new Select(getElement(driver, baseDropdownListXpath, valuesForXpathLocator)).selectByVisibleText(expectedText);
	}

	public void uploadOneFile(WebDriver driver, String xpathLocator, String filePath) {
		getElement(driver, xpathLocator).sendKeys(filePath);
	}
	
	public void uploadOneFile(WebDriver driver, String xpathLocator, String filePath, String... valuesForXpathLocator) {
		getElement(driver, xpathLocator, valuesForXpathLocator).sendKeys(filePath);
	}

	public void uploadMultipleFiles(WebDriver driver, String xpathLocator, List<String> filesPath) {

		for (String filePath : filesPath) {
			getElement(driver, xpathLocator).sendKeys(filePath);
		}
	}

	public String getFirstSelectedItemInDropdown(WebDriver driver, String xpathLocator) {
		return new Select(getElement(driver, xpathLocator)).getFirstSelectedOption().getText();
	}

	public List<String> getListSelectedItemInDropdown(WebDriver driver, String xpathLocator) {
		List<WebElement> elements = new Select(getElement(driver, xpathLocator)).getAllSelectedOptions();
		List<String> textResults = new ArrayList<String>();

		for (WebElement element : elements) {
			textResults.add(element.getText());
		}

		return textResults;
	}

	public String getTextElement(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).getText();
	}
	
	public String getTextElement(WebDriver driver, String xpathLocator, String... valuesForXpathLocator) {
		return getElement(driver, xpathLocator, valuesForXpathLocator).getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		return new Select(getElement(driver, xpathLocator)).isMultiple();
	}

	public void scrollIntoViewByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public String getAttributeValue(WebDriver driver, String xpathLocator, String attributeName) {
		return getElement(driver, xpathLocator).getAttribute(attributeName);
	}
	
	public String getAttributeValue(WebDriver driver, String xpathLocator, String attributeName, String... valuesForXpathLocator) {
		return getElement(driver, xpathLocator, valuesForXpathLocator).getAttribute(attributeName);
	}

	public String getCSSValue(WebDriver driver, String xpathLocator, String cssAttributName) {
		return getElement(driver, xpathLocator).getCssValue(cssAttributName);
	}
	
	public String getCSSValue(WebDriver driver, String xpathLocator, String cssAttributName, String... valuesForXpathLocator) {
		return getElement(driver, xpathLocator, valuesForXpathLocator).getCssValue(cssAttributName);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String xpathLocator) {
		return getElements(driver, xpathLocator).size();
	}
	
	public int getElementSize(WebDriver driver, String locatorString, String... parameters) {
		return getElements(driver, locatorString, parameters).size();
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String xpathLocator, String... valuesForXpathLocator) {
		return getElement(driver, xpathLocator, valuesForXpathLocator).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).isEnabled();
	}
	
	public boolean isElementEnabled(WebDriver driver, String xpathLocator, String... valuesForXpathLocator) {
		return getElement(driver, xpathLocator, valuesForXpathLocator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).isSelected();
	}
	
	public boolean isElementSelected(WebDriver driver, String xpathLocator, String... valuesForXpathLocator) {
		return getElement(driver, xpathLocator, valuesForXpathLocator).isSelected();
	}
	
	public void switchToFrameOrIframe(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getElement(driver, xpathLocator));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void doubleClickOnElement(WebDriver driver, String xpathLocator) {
		new Actions(driver).doubleClick(getElement(driver, xpathLocator)).perform();
	}

	public void hoverElement(WebDriver driver, String xpathLocator) {
		new Actions(driver).moveToElement(getElement(driver, xpathLocator)).perform();
	}

	public void rightClickOnElement(WebDriver driver, String xpathLocator) {
		new Actions(driver).contextClick(getElement(driver, xpathLocator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String sourceXpath, String targetXpath) {
		new Actions(driver).dragAndDrop(getElement(driver, sourceXpath), getElement(driver, targetXpath)).perform();
	}

	public void sendkeyToElement(WebDriver driver, String xpathLocator, Keys key) {
		new Actions(driver).sendKeys(getElement(driver, xpathLocator), key).perform();
	}

	public void navigateURLByJS(WebDriver driver, String xpathLocator, String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location = '" + url + "'", getElement(driver, xpathLocator));
	}

	public String getDomainByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return document.domain;");
	}

	public String getURLByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return document.URL;");
	}

	public void clickToElementByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getElement(driver, xpathLocator));
	}

	public String getInnerTextByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return document.documentElement.innerHTML;");
	}

	public String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return document.title;");
	}

	public void scrollToBottomPageByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	}

	public void scrollHorizontalPageByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(document.body.scrollWidth, 0)");
	}

	public void hightlightToElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement highlightElement = getElement(driver, xpathLocator);
		String styleValue = highlightElement.getAttribute("style");
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", highlightElement, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", highlightElement, "style", styleValue);
	}
	
	public void hightlightToElement(WebDriver driver, String xpathLocator, String... valuesForXpathLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement highlightElement = getElement(driver, xpathLocator, valuesForXpathLocator);
		String styleValue = highlightElement.getAttribute("style");
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", highlightElement, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", highlightElement, "style", styleValue);
	}

	public void removeAttributeElementByJS(WebDriver driver, String xpathLocator, String attribute) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attribute + "';", getElement(driver, xpathLocator));
	}
	
	public void removeAttributeElementByJS(WebDriver driver, String xpathLocator, String attribute, String... valuesForXpathLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attribute + "';", getElement(driver, xpathLocator, valuesForXpathLocator));
	}

	public boolean checkImageLoaded(WebDriver driver, String xpathLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean status = (boolean) js.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getElement(driver, xpathLocator));

		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTextInInnerTextByJS(WebDriver driver, String expectedText) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String actualText = (String) js.executeScript("return document.documentElement.innerText.match('" + expectedText + "')");
		return actualText.equals(expectedText);
	}

	public String getValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return arguments[0].validationMessage", getElement(driver, xpathLocator));
	}

	public boolean isJQueryOrJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(SECOND));
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

	public void waitForElementVisibility(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(SECOND));
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpathLocator(driver, xpathLocator)));
	}
	
	public void waitForElementVisibility(WebDriver driver, String xpathLocator, String... valuesForXpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(SECOND));
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByDynamicXpath(xpathLocator, valuesForXpathLocator)));
	}

	public void waitForElementClickable(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(SECOND));
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpathLocator(driver, xpathLocator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String xpathLocator, String... valuesForXpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(SECOND));
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByDynamicXpath(xpathLocator, valuesForXpathLocator)));
	}

	public void waitForElementInvisibility(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(SECOND));
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpathLocator(driver, xpathLocator)));
	}
	
	public void waitForElementInvisibility(WebDriver driver, String xpathLocator, String... valuesForXpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(SECOND));
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByDynamicXpath(xpathLocator, valuesForXpathLocator)));
	}

	private By getByDynamicXpath(String xpathLocator, String... values) {
		By by = null;
		by = By.xpath(String.format(xpathLocator, (Object[])values));
		return by;
	}
	
	//common dynamic text in Xpath
	public void clickOnSideBarPage(WebDriver driver, String... valuesForXpathLocator) {
		waitForElementVisibility(driver, BasePageUI.DYNAMIC_SIDEBAR_MY_ACCOUNT_LINKS, valuesForXpathLocator);
		clickOnElement(driver, BasePageUI.DYNAMIC_SIDEBAR_MY_ACCOUNT_LINKS, valuesForXpathLocator);
	}
}
