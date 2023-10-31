package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pagesUI.user.ComputersPageUI;

public class ComputersPageObject extends BasePages{
	private WebDriver driver;
	
	public ComputersPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click on Notebook link from Computer page")
	public NotebooksPageObject clickOnNotebooksLink() {
		waitForElementClickable(driver, ComputersPageUI.NOTEBOOK_CATEGORY_LINK);
		clickOnElement(driver, ComputersPageUI.NOTEBOOK_CATEGORY_LINK);
		return PageGeneratorManager.getNotebooksPageObject(driver);
	}
	
	@Step("Click on Desktop link from Computer page")
	public DesktopsPageObject clickOnDesktopsLink() {
		waitForElementClickable(driver, ComputersPageUI.DESKTOP_CATEGORY_LINK);
		clickOnElement(driver, ComputersPageUI.DESKTOP_CATEGORY_LINK);
		return PageGeneratorManager.getDesktopsPageObject(driver);
	}

	@Step("Verify Computers title is displayed")
	public boolean isComputerPageTitleDisplayed() {
		waitForElementVisibility(driver, ComputersPageUI.COMPUTER_PAGE_TITLE);
		return isElementDisplayed(driver, ComputersPageUI.COMPUTER_PAGE_TITLE);
	}
}
