package pagesUI.user;

public class ComputersPageUI {
	public static final String COMPUTER_PAGE_TITLE = "//div[@class='page category-page']//h1[text()='Computers']";
	public static final String NOTEBOOK_CATEGORY_LINK = "//h1[text()='Computers']/parent::div/following-sibling::div//a[contains(text(), 'Notebooks')]";
	public static final String DESKTOP_CATEGORY_LINK = "//h1[text()='Computers']/parent::div/following-sibling::div//a[contains(text(), 'Desktops')]";
}
