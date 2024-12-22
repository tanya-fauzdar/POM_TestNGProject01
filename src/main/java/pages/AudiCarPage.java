package pages;

import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class AudiCarPage extends BasePage{
		
	public AudiCarPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		
		System.out.println("Inside the Audi Cars page");
		return carBase.getCarTitle();
	}


}
