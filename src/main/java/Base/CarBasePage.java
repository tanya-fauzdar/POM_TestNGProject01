package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarBasePage {
	
	public WebDriver driver;
	
	/*
	 * This class is meant for all the common functionalities of
	 * the Car pages only [As the different car pages have similar 
	 * xpaths for their webelements on their respective pages, the methods will be 
	 * implemented in the CarBasePage] 
	 */
	public CarBasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div[2]/section/header/h1")
	public WebElement carTitle;
	
	public String getCarTitle() {
		//System.out.println("Inside the carBase.getCarTitle() ");
		return carTitle.getText();
		
	}
}
