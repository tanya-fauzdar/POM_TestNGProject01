package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Base.BasePage;

public class NewCarsPage extends BasePage{
	
	public NewCarsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath="//img[@title='Toyota Cars']")
	WebElement toyotaCar;
	public ToyotaCarPage goToToyota() {

		wait.until(ExpectedConditions.elementToBeClickable(toyotaCar)).click();
		log.info("Went to Toyota page");
		carBase.getCarTitle();
		
		return new ToyotaCarPage(driver);
	}
	

	@FindBy (xpath="//div/ul/li[5]/a/div[1]/div/img")
	WebElement bmwCar;		
	public BMWCarPage goToBMW() {
		
		wait.until(ExpectedConditions.elementToBeClickable(bmwCar)).click();
		log.info("Went to BMW page");
		
		return new BMWCarPage(driver);
		
	}
	
	@FindBy (xpath="//img[@title='Audi Cars']")
	WebElement audiCar;	
	public AudiCarPage goToAudi() {
		
		wait.until(ExpectedConditions.elementToBeClickable(audiCar)).click();
		
		log.info("Went to Audi page");
	
		return new AudiCarPage(driver);
		
	}
	
	@FindBy (xpath="//img[@title='Kia Cars']")
	WebElement kiaCar;	
	public KiaCarPage goToKia() {
		
		wait.until(ExpectedConditions.elementToBeClickable(kiaCar)).click();
		
		log.info("Went to Kia page");
		
		return new KiaCarPage(driver);
		
	}
	
	
	@FindBy (xpath="//img[@title='Hyundai Cars']")
	WebElement hyundaiCar;	
	public HyundaiCarPage goToHyundai() {
		
		wait.until(ExpectedConditions.elementToBeClickable(hyundaiCar)).click();
		
		log.info("Went to Hyundai page");
		
		return new HyundaiCarPage(driver);
		
	}

}
