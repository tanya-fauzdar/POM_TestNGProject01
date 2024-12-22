package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class ToyotaCarPage extends BasePage{

	public ToyotaCarPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getTitle() {
		
		//driver.findElement(By.xpath("//div[2]/ul/li[1]/div/div/div/div/a/h3")).click();
		System.out.println("Inside the Toyota Cars page");
		return carBase.getCarTitle();
	}

}
