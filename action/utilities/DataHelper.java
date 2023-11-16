package utilities;

import java.text.NumberFormat;
import java.util.Locale;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class DataHelper {
	@SuppressWarnings("deprecation")
	private Locale local = new Locale("en", "US");
	private Faker faker = new Faker(local);
	
	public static DataHelper getData() {
		return new DataHelper();
	}
	
	public String getFirstName() {
		return faker.address().firstName();
	}
	
	public String getLastName() {
		return faker.address().lastName();
	}
	
	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}
	
	public String getPassword() {
		return faker.internet().password();
	}
	
	public String getCountry() {
		return faker.address().country();
	}
	
	public String getState() {
		return faker.address().state();
	}
	
	public String getCity() {
		return faker.address().city();
	}
	
	public String getZipCode() {
		return faker.address().zipCode();
	}
	
	public String getCompany() {
		return faker.company().name();
	}
	
	public String getPhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}
	
	public String getFaxNumber() {
		return faker.phoneNumber().phoneNumber();
	}
	
	public String getAddress() {
		return faker.address().secondaryAddress();
	}
	
	public String getCurrencyFormat(float money) {
		NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(local);
		return dollarFormat.format(money);
	}
	
	public String getBankCardNumber() {
		return faker.finance().creditCard(CreditCardType.MASTERCARD);
	}
}
