package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	
	protected WebDriver getBrowserName(String browserName) {
		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();		
		} 
		else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
		else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
		}
		else if (browserName.equals("h_firefox")) {
			System.setProperty("webdriver.gecko.driver", GlobalConstants.FIREFOX_DRIVER_PATH);
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window_size=1920x1080");
			driver = new FirefoxDriver(options);
		}
		else if (browserName.equals("h_chrome")) {
			System.setProperty("webdriver.chrome.driver", GlobalConstants.CHROME_DRIVER_PATH);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window_size=1920x1080");
			driver = new ChromeDriver(options);
		}
		else {
			throw new RuntimeException("Invalid Browser");
		}

		return driver;
	}
}
