package commons;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	
	@BeforeSuite
	public void deleteFileInReport() {
		deleteAllFileInFolder("allure-json");
	}
	
	protected WebDriver getBrowserName(String browserName, String url) {
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
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.manage().window().maximize();
		return driver;
	}
	
	//create getter 
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void deleteAllFileInFolder(String folderName) {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + folderName;
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			if (listOfFiles.length != 0) {
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
						new File(listOfFiles[i].toString()).delete();
					}
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
