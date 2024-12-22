package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class NewCarsPage extends BasePage{
	
	public NewCarsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath="//img[@title='Toyota Cars']")
	WebElement toyotaCar;
	
	public ToyotaCarPage goToToyota() {
		//driver.findElement(By.xpath("//img[@title='Toyota Cars']")).click();
		toyotaCar.click();
		System.out.println("Went to Toyota page");
		carBase.getCarTitle();
		
		//return PageFactory.initElements(driver, ToyotaCarPage.class);
		return new ToyotaCarPage(driver);
	}
	
	@FindBy (xpath="//img[@title='BMW Cars']")
	WebElement bmwCar;	
	
	public BMWCarPage goToBMW() {
		
		//driver.findElement(By.xpath("//img[@title='BMW Cars']")).click();
		bmwCar.click();
		System.out.println("Went to BMW page");
		
		//return PageFactory.initElements(driver, BMWCarPage.class);
		return new BMWCarPage(driver);
		
	}
	
	@FindBy (xpath="//img[@title='Audi Cars']")
	WebElement audiCar;	
	
	public AudiCarPage goToAudi() {
		
	//	driver.findElement(By.xpath("//img[@title='Audi Cars']")).click();
		audiCar.click();
		System.out.println("Went to Audi page");
		
		//return PageFactory.initElements(driver, AudiCarPage.class);
		
		return new AudiCarPage(driver);
		
	}

}
