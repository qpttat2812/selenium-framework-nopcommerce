package pagesUI.user;

public class MyAccountPageUI {
	public static final String FEMALE_GENDER = "//label[text()='Female']/preceding-sibling::input";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
	public static final String DAY_OF_BIRTH_DROPDOWNLIST = "//select[@name='DateOfBirthDay']";
	public static final String MONTH_OF_BIRTH_DROPDOWNLIST = "//select[@name='DateOfBirthMonth']";
	public static final String YEAR_OF_BIRTH_DROPDOWNLIST = "//select[@name='DateOfBirthYear']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String COMPANY_NAME_TEXTBOX = "//input[@id='Company']";
	public static final String SAVE_BUTTON = "//button[@id='save-info-button']";
	public static final String NOTIFICATION_SUCCESS_TEXT = "//div[@class='bar-notification success']/p[@class='content']";
	public static final String CLOSE_NOTIFICATION_SUCCESS_BUTTON = "//div[@class='bar-notification success']/span[@class='close']";
}
