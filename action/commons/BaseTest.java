package commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

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

	protected WebDriver getBrowserName(String browserName, String environmentName, String siteType) {
		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("h_firefox")) {
			System.setProperty("webdriver.gecko.driver", GlobalConstants.FIREFOX_DRIVER_PATH);
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window_size=1920x1080");
			driver = new FirefoxDriver(options);
		} else if (browserName.equals("h_chrome")) {
			System.setProperty("webdriver.chrome.driver", GlobalConstants.CHROME_DRIVER_PATH);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window_size=1920x1080");
			driver = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Invalid Browser");
		}

		driver.get(getURLBaseOnEnvironment(environmentName, siteType));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.manage().window().maximize();
		return driver;
	}

	private String getURLBaseOnEnvironment(String environmentName, String siteType) {
		String pageURL = "";

		EnvironmentList environment = EnvironmentList.valueOf(environmentName.toUpperCase());

		if (siteType.equals("user")) {
			switch (environment) {
			case DEV:
				pageURL = "https://demo.nopcommerce.com/";
				break;
			case TEST:
				pageURL = "https://test-demo.nopcommerce.com/";
				break;
			case STAGING:
				pageURL = "https://stg-demo.nopcommerce.com/";
				break;
			case PRE_PROD:
				pageURL = "https://pre-demo.nopcommerce.com/";
				break;
			case PROD:
				pageURL = "https://prod-demo.nopcommerce.com/";
				break;
			default:
				break;
			}
		} else {
			switch (environment) {
			case DEV:
				pageURL = "https://admin-demo.nopcommerce.com/";
				break;
			case TEST:
				pageURL = "https://test-admin-demo.nopcommerce.com/";
				break;
			case STAGING:
				pageURL = "https://stg-admin-demo.nopcommerce.com/";
				break;
			case PRE_PROD:
				pageURL = "https://pre-admin-demo.nopcommerce.com/";
				break;
			case PROD:
				pageURL = "https://prod-admin-demo.nopcommerce.com/";
				break;
			default:
				break;
			}
		}
		return pageURL;

	}

	// create getter
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

	protected void closeBrowserDriver() {
		String cmd = null;

		try {
			String osName = System.getProperty("os.name").toLowerCase();

			String driverInstanceName = driver.toString().toLowerCase();

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected int getRandomNumber() {
		Random rnd = new Random();
		return rnd.nextInt(99999);
	}
}
