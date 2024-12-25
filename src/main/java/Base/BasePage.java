package Base;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	public static CarBasePage carBase;
	public static Logger log = Logger.getLogger(BasePage.class);
	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		PropertyConfigurator.configure("./src/main/resources/properties/log4j.properties");
		carBase = new CarBasePage(driver, wait);
	}

}
