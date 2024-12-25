package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testProperties {
	
	public static FileInputStream fis;
	public static WebDriver driver;
	public static Properties orProperties = new Properties();
	public static Properties configProperties = new Properties();
	public static WebDriverWait wait;
	public static Logger log = Logger.getLogger(testProperties.class);
	
	public static void click(String locatorKey) {
		
		if(locatorKey.endsWith("_xpath")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath((orProperties.getProperty(locatorKey))))).click();
		}else if(locatorKey.endsWith("_id")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id((orProperties.getProperty(locatorKey))))).click();
		}else if(locatorKey.endsWith("_cssSelector")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector((orProperties.getProperty(locatorKey))))).click();
		}else if(locatorKey.endsWith("_className")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className((orProperties.getProperty(locatorKey))))).click();
		}else if(locatorKey.endsWith("_name")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name((orProperties.getProperty(locatorKey))))).click();
		}else if(locatorKey.endsWith("_tagName")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName((orProperties.getProperty(locatorKey))))).click();
		}else if(locatorKey.endsWith("_linkText")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText((orProperties.getProperty(locatorKey))))).click();
		}else if(locatorKey.endsWith("_partialLinkText")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText((orProperties.getProperty(locatorKey))))).click();
		}
		
		log.info("--Clicking the: "+ locatorKey +" button.");
	}
	
	public static void type(String locatorKey, String value) {
		if(locatorKey.endsWith("_xpath")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath((orProperties.getProperty(locatorKey))))).sendKeys(value);
		}else if(locatorKey.endsWith("_id")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id((orProperties.getProperty(locatorKey))))).sendKeys(value);
		}else if(locatorKey.endsWith("_cssSelector")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector((orProperties.getProperty(locatorKey))))).sendKeys(value);
		}else if(locatorKey.endsWith("_className")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className((orProperties.getProperty(locatorKey))))).sendKeys(value);
		}else if(locatorKey.endsWith("_name")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name((orProperties.getProperty(locatorKey))))).sendKeys(value);
		}else if(locatorKey.endsWith("_tagName")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName((orProperties.getProperty(locatorKey))))).sendKeys(value);
		}else if(locatorKey.endsWith("_linkText")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText((orProperties.getProperty(locatorKey))))).sendKeys(value);
		}else if(locatorKey.endsWith("_partialLinkText")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText((orProperties.getProperty(locatorKey))))).sendKeys(value);
		}
		
		log.info("--Typing in input: "+ locatorKey +" value as: " + value);
	}
	
	public static boolean isElementPresent(String locatorKey) {
		try {
			if(locatorKey.endsWith("_ID")) {
				driver.findElement(By.id(orProperties.getProperty(locatorKey)));
			}else if(locatorKey.endsWith("_XPATH")) {
				System.out.println("Looking for the xpath of ele");
				driver.findElement(By.xpath(orProperties.getProperty(locatorKey)));
			}else if(locatorKey.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(orProperties.getProperty(locatorKey)));
			}else if(locatorKey.endsWith("_TAG")) {
				driver.findElement(By.tagName(orProperties.getProperty(locatorKey)));
			}else if(locatorKey.endsWith("_CLASS")) {
				driver.findElement(By.className(orProperties.getProperty(locatorKey)));
			}else if(locatorKey.endsWith("_NAME")) {
				driver.findElement(By.name(orProperties.getProperty(locatorKey)));
			}
			
		}catch(NoSuchElementException e) {
			
			//System.out.println("Exception caught: " + e.getMessage());
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		log.info("---Test execution Start---");
		
		//Loading the log4j.properties file to configure log4j
		PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");
		log.info("---Configured the log4j---");
		
		//Taking object of 'Properties' class of java.util. I have moved it to global params after testing simple implementation.
		//Properties orProperties = new Properties();
		
		//Now we need to read the OR properties file to get the locators from it so using FileInputStream
		
			fis = new FileInputStream(".\\src\\test\\resources\\properties\\OR.properties");
	
		//Now we need to load the file
			orProperties.load(fis);
			log.info("----Loaded the OR properties---");
			
		
		//once the file is loaded we will read the key-value pairs
		//System.out.println(orProperties.getProperty("username_xpath"));
		
		//Properties configProperties = new Properties(); I have moved it to global params
		fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
		
		configProperties.load(fis);
		log.info("---Loaded the config properties---");
		
		//System.out.println(configProperties.getProperty("browser"));
		//System.out.println(configProperties.getProperty("testsiteurl"));
		
		String browser = configProperties.getProperty("browser");
		String url = configProperties.getProperty("testsiteurl");
		
		if(browser.equals("chrome")) {
			log.info("---Launching the chrome driver---");
			 driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			
			
			//System.out.println("Explicit wait duration is: "+ configProperties.getProperty("explicit.wait"));
			wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(configProperties.getProperty("explicit.wait"))));
			
			//System.out.println("implicit wait duration is: "+ configProperties.getProperty("implicit.wait"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(configProperties.getProperty("implicit.wait"))));
			
			/*log.info("---Typing in the input mail address---");
			* WebElement uname = driver.findElement(By.xpath(orProperties.getProperty("username_xpath")));
			  System.out.println(uname);
			
			  uname.sendKeys("tanyasingh@gmail.com");
			*/
			
			type("username_xpath","mayank123@gmail.com");
			
			
			/* example for utilizing the explicit wait for clicking on the 'next button' after having entered the email.phone
			* wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath((orProperties.getProperty("nextBtn_xpath"))))).click();
			* log.info("---Clicking the newxt button after awaiting until the web element is present----");
			*
			*	or simply click on next button:
			*	driver.findElement(By.xpath(orProperties.getProperty("nextBtn_xpath"))).click();
			*/
			
			click("nextBtn_xpath");
			log.info("---Test Execution Completed!!---");
		}
		
		
		fis.close();
	}

}
