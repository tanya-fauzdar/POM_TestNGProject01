package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class HomePage extends BasePage{
	
	/*
	 * //creating constructor with webDriver paramter to pass the driver from the
	 * tets case class //and use that driver instance public HomePage(WebDriver
	 * driver) { this.driver = driver;
	 * 
	 * }
	 */
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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
		
		//WebElement menu = driver.findElement(By.xpath("//nav/ul/li[1]/div"));
		
		act.moveToElement(newCar).perform();
		
		//driver.findElement(By.xpath("//div[normalize-space()='Find New Cars']")).click();
		
		findNewCar.click();
		
		//return PageFactory.initElements(driver, NewCarsPage.class);
		return new NewCarsPage(driver);
	}
	
	@FindBy(xpath = "//*[@id=\\\"root\\\"]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div[2]/div/div/div[1]/div/input")
	private WebElement searchCar;
	
	public void searchCars(String carName) {
		//the Car name in search bar will be read and sent form the test data excel sheet. we'll no hard code it.
		
		//driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div[2]/div/div/div[1]/div/input")).sendKeys("carName");
		searchCar.sendKeys(carName);
	}
	
	public void verifyFeaturedCars() {
		
	}

}
