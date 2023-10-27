package pagesObject;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManager;
import pagesUI.user.ComputersPageUI;

public class ComputersPageObject extends BasePages{
	private WebDriver driver;
	
	public ComputersPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public NotebooksPageObject clickOnNotebookSubCategory() {
		waitForElementClickable(driver, ComputersPageUI.NOTEBOOK_SUB_CATEGORY_LINK);
		clickOnElement(driver, ComputersPageUI.NOTEBOOK_SUB_CATEGORY_LINK);
		return PageGeneratorManager.getNotebooksPageObject(driver);
	}
}
