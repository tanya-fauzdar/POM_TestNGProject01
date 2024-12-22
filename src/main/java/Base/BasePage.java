package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	
	public WebDriver driver;
	public static CarBasePage carBase;
	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		carBase = new CarBasePage(driver);
	}

}
