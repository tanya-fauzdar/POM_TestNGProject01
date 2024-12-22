package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testCheckElePresence {

		public static WebDriver driver;
		public static Properties orProperties = new Properties();
		public static Properties configProperties = new Properties();
		public static FileInputStream fis;
	
	public static boolean isElementPresent(String locatorKey) {
		int traversed;
		try {
			if(locatorKey.endsWith("_ID")) {
				driver.findElement(By.id(orProperties.getProperty(locatorKey)));
				traversed = 1;
			}else if(locatorKey.endsWith("_XPATH")) {
				System.out.println("Looking for the xpath of ele");
				driver.findElement(By.xpath(orProperties.getProperty(locatorKey)));
				traversed = 1;
			}else if(locatorKey.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(orProperties.getProperty(locatorKey)));
				traversed = 1;
			}else if(locatorKey.endsWith("_TAG")) {
				driver.findElement(By.tagName(orProperties.getProperty(locatorKey)));
				traversed = 1;
			}else if(locatorKey.endsWith("_CLASS")) {
				driver.findElement(By.className(orProperties.getProperty(locatorKey)));
				traversed = 1;
			}else if(locatorKey.endsWith("_NAME")) {
				driver.findElement(By.name(orProperties.getProperty(locatorKey)));
				traversed = 1;
			}else {
				traversed = 0;
			}
		}catch(NoSuchElementException e) {
			traversed = 1;
			System.out.println("Exception caught: " + e.getMessage());
			return false;
		}
		if(traversed == 1) {
			return true;
		}else {
			System.out.println("Did not match with any locator  Key to find the desired Web Element.");
			return false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		 driver = new ChromeDriver();
		driver.get("https:gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		fis = new FileInputStream(".\\src\\test\\resources\\properties\\OR.properties");
		orProperties.load(fis);
		
		fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
		
		configProperties.load(fis);
		
			//driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
			System.out.println(isElementPresent("input_xPATH"));
			driver.quit();
	}

}
