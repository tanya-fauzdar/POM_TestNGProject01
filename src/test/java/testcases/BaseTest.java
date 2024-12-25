package testcases;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import utilities.DbManager;
import utilities.ExcelReader;
import utilities.MonitoringMail;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public FileInputStream fis;
	public WebDriver driver;
	public Properties OR = new Properties();
	public Properties config = new Properties();
	public WebDriverWait wait;
	public Logger log = Logger.getLogger(testProperties.class);
	
	public ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
	 
	 
	/*
	 * public static void main (String args[]) { BaseTest bt = new BaseTest();
	 * bt.setUp("chrome"); }
	 */
	 
	@BeforeMethod
	public void setUp(String browser) {

		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");

		log.info("Test Execution started !!!");

		try {
			fis = new FileInputStream("./src/test/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.info("Config properties file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis);
			log.info("OR properties file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (browser.equals("chrome")) {

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);

			driver = new ChromeDriver(options);
			log.info("Chrome browser launched");

		} else if (browser.equals("firefox")) {

			driver = new FirefoxDriver();
			log.info("Firefox browser launched");

		}

		driver.get(config.getProperty("testsiteurl"));
		log.info("Navigated to : " + config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));

		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));

		/*
		 * try { DbManager.setMysqlDbConnection();
		 * log.info("DB Connection established"); } catch (ClassNotFoundException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); } catch (SQLException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
		log.info("Test Execution completed !!!");

	}

}
