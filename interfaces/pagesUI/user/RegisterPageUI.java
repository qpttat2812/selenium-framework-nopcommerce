package pagesUI.user;

public class RegisterPageUI {
	public static final String DYNAMIC_TEXTBOX_AT_REGISTER_PAGE_XPATH = "//input[@id='%s']";
	public static final String REGISTER_BUTTON_XPATH = "//button[@id='register-button']";
	public static final String DYNAMIC_REQUIRED_ERROR_MESSAGE_XPATH = "//span[text()='%s is required.']";
	public static final String ERROR_MESSAGE_AT_HEADER_AREA_XPATH = "//div[contains(@class, 'validation-summary-errors')]//li";
	public static final String REGISTER_SUCCESSFULLY_MESSAGE_XPATH = "//div[@class='result']";
}
