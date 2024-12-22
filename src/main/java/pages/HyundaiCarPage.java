package pages;

import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class HyundaiCarPage extends BasePage{

	public HyundaiCarPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getTitle() {
		
		System.out.println("Inside the Hyundai Cars page");
		return carBase.getCarTitle();
	}
}
