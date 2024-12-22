package pages;

import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class KiaCarPage extends BasePage{
	
	public KiaCarPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getTitle() {
		
		System.out.println("Inside the Kia Cars page");
		return carBase.getCarTitle();
	}

}
