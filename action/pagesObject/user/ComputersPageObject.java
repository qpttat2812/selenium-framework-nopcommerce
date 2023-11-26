package pagesObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePages;
import commons.PageGeneratorManagerUser;
import io.qameta.allure.Step;
import pagesUI.user.ComputersPageUI;

public class ComputersPageObject extends BasePages{
	private WebDriver driver;
	
	public ComputersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@Step("Click on 'Notebooks' link from Computer page")
	public NotebooksPageObject clickOnNotebooksLink() {
		waitForElementClickable(ComputersPageUI.NOTEBOOK_CATEGORY_LINK);
		clickOnElement(ComputersPageUI.NOTEBOOK_CATEGORY_LINK);
		return PageGeneratorManagerUser.getNotebooksPageObject(driver);
	}
	
	@Step("Click on 'Desktops' link from Computer page")
	public DesktopsPageObject clickOnDesktopsLink() {
		waitForElementClickable(ComputersPageUI.DESKTOP_CATEGORY_LINK);
		clickOnElement(ComputersPageUI.DESKTOP_CATEGORY_LINK);
		return PageGeneratorManagerUser.getDesktopsPageObject(driver);
	}
}
