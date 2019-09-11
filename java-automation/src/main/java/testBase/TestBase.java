package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class TestBase {

	public Properties OR;
	public WebDriver driver;
	public static final Logger logger = Logger.getLogger(TestBase.class.getName());

	@BeforeTest
	public void launchBrowser() throws IOException {
		loadPropertiesFile();
		System.out.println("I am here 2");
		Config cfg = new Config(OR);
		String str = cfg.getBrowser();
		System.out.println("Name of the browser" + str);
		getBrowser(cfg.getBrowser());
		driver.get(cfg.getURL());
	}

	public void getBrowser(String browser) {
		if (System.getProperty("os.name").contains("Windows")) {
			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Malhar\\Downloads\\LearnAutomation\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Malhar\\Downloads\\LearnAutomation\\chromedriver.exe");
				driver = new InternetExplorerDriver();
			} else if (browser.equalsIgnoreCase("Mozilla")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\Malhar\\Downloads\\LearnAutomation\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else {
				System.out.println("Invalid browser Argument Passed");
			}
		} else if (System.getProperty("os.name").contains("mac")) {
			// write code for mac browser
		} else {
			System.out.println("New OS detected, Please implement" + System.getProperty("os.name"));
		}
	}

	public void getScreenShot() throws IOException {
		File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imageLocation = "C:\\Users\\Malhar\\workspace\\java-automation\\src\\main\\java\\screenShots\\";
		File destlocation = new File(imageLocation);
		FileUtils.copyFileToDirectory(image, destlocation);
	}

	public void loadPropertiesFile() throws IOException {
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		OR = new Properties();
		File f1 = new File("C:\\Users\\Malhar\\workspace\\java-automation\\src\\main\\java\\config\\config.properties");
		FileInputStream file1 = new FileInputStream(f1);
		OR.load(file1);
		logger.info("Loading Config File");
		File f2 = new File(
				"C:\\Users\\Malhar\\workspace\\java-automation\\src\\main\\java\\applicationLocators\\loginPage.properties");
		FileInputStream file2 = new FileInputStream(f2);
		OR.load(file2);
	}

	public void implicitWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public WebElement waitForElement(WebDriver driver, long time, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitForElementWithPolling(WebDriver driver, long time, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement getLocator(String locator) {
		String str1 = OR.getProperty(locator, locator + "Not found");
		System.out.println("test" + str1);
		String[] Split = str1.split(":");
		String locatorType = Split[0];
		String locatorValue = Split[1];
		if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(locatorValue));
		}
		return null;
	}

	public static void main(String[] args) {
		TestBase t1 = new TestBase();
		try {
			t1.loadPropertiesFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
