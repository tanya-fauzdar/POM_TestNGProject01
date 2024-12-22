package pages;

import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class BMWCarPage extends BasePage{
	
	public BMWCarPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getTitle() {
		
		System.out.println("Inside the BMW Cars page");
		return carBase.getCarTitle();
	}


}
