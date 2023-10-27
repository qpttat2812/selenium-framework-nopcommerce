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
	public NotebooksPageObject clickOnNotebookSubCategory() {
		waitForElementClickable(driver, ComputersPageUI.NOTEBOOK_SUB_CATEGORY_LINK);
		clickOnElement(driver, ComputersPageUI.NOTEBOOK_SUB_CATEGORY_LINK);
		return PageGeneratorManager.getNotebooksPageObject(driver);
	}
}
