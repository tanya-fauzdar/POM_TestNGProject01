package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Base.BasePage;

public class HomePage extends BasePage{
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	/*
	 * Implementing Page Factory to optimize the design.
	 * Syntax: driver.findElement(By.xpath("EleXpath")) will no longer be used
	 * Steps: 1. Initialize the page factory for the class in the test where we are going to access:
	 * 	HomePage home = PageFactory.initi.Elements(driver,HomePage.class);
	 * 
	 * Use @FindBy Annotation to provide the web element locators
	 * 
	 */
	
	@FindBy (xpath = "//nav/ul/li[1]/div")
	private WebElement newCar;
	
	@FindBy (xpath = "//div[normalize-space()='Find New Cars']")
	private WebElement findNewCar;
	
	public NewCarsPage findNewCars() {
		
		Actions act = new Actions(driver);
		
		act.moveToElement(newCar).perform();

		wait.until(ExpectedConditions.elementToBeClickable(findNewCar)).click();
		
		return new NewCarsPage(driver);
	}
	

}
