package common;

import java.io.File;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseCode {

	public static WebDriver driver;

	public static void openBrowserAndURL(String url) {
		System.out.println("Starting the test.");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Opened Chrome browser.");
		driver.get(url);
		System.out.println(url + " - URL has been opened.");
	}

	public static void openBrowserAndURL_Google(String url, String user) {
		System.out.println("Starting the test.");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();		
		options.addArguments("--user-data-dir=C:\\Users\\"+user+"\\AppData\\Local\\Google\\Chrome\\User Data\\");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver =  new ChromeDriver(options); 
        pause(10);
		System.out.println("Opened Chrome browser.");
		driver.get(url);
		System.out.println(url + " - URL has been opened.");
	}

	public static void closeBrowser() {
		driver.close();
		driver.quit();
		System.out.println("Closing browser.");
		System.out.println("Ending the test.");
	}

	public static void pause(Integer seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void verifyPageElementDisplayed(String locator) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			System.out.println("PASSED: Element '" + locator + "' is displayed in the screen.");
		} catch (NoSuchElementException e) {
			System.out.println("FAILED: Element '" + locator + "' is NOT displayed in the screen.");
		}
	}

	public static void verifyTextInPageElement(String locator, String expectedValue) {
		String actualValue = findElement(locator).getText();

		if (expectedValue.equals(actualValue)) {
			System.out.println("PASSED: Value '" + expectedValue + "' is displayed in" + "; element " + locator
					+ " in the screen.");
		} else {
			System.out.println("FAILED: Value '" + expectedValue + "' is NOT displayed in" + "Element " + locator
					+ " in the screen. Actual value is " + actualValue);
		}
	}

	public static void verifyCurrentURL(String urlToCheck) {
		String actualURL = driver.getCurrentUrl();

		if (urlToCheck.equals(actualURL)) {
			System.out.println("PASSED: Value '" + urlToCheck + "' is the current page.");
		} else {
			System.out.println(
					"FAILED: Value '" + urlToCheck + "' is NOT the current URL. Actual value is '" + actualURL + "'.");
		}

	}

	public static void click(String locator) {
		WebElement element = findElement(locator);
		element.click();
		System.out.println("PASSED: Element '" + locator + "' has been clicked.");
	}

	public static void clickJS(String locator) {
		Actions actions = new Actions(driver);
		actions.moveToElement(findElement(locator)).click().build().perform();
		System.out.println("PASSED: Element '" + locator + "' has been clicked.");
	}

	public static void inputValue(String locator, String value) {
		WebElement element = findElement(locator);
		element.clear();
		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		element.sendKeys(value);
		System.out.println("PASSED: Element '" + locator + "' has been entered with value '" + value + "'.");
	}
	
	public static void inputValue_actionkey(String locator, String value) {
		Actions actions = new Actions(driver);
		actions.moveToElement(findElement(locator)).sendKeys(value).build().perform();
		actions.moveToElement(findElement(locator)).sendKeys(Keys.ENTER).build().perform();
		System.out.println("PASSED: Element '" + locator + "' has been entered with value '" + value + "'.");
	}

	public static WebElement findElement(String locator) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}

}
