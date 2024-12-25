package Base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarBasePage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	/*
	 * This class is meant for all the common functionalities of
	 * the Car pages only [As the different car pages have similar 
	 * xpaths for their webelements on their respective pages, the methods will be 
	 * implemented in the CarBasePage] 
	 */
	public CarBasePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div[2]/section/header/h1")
	public WebElement carTitle;
	public String getCarTitle() {
		
		return wait.until(ExpectedConditions.elementToBeClickable(carTitle)).getText();
		
	}
	
	@FindBy(xpath="//div/div/div/div/a/h3")
	public List <WebElement> carNames;
	
	@FindBy(xpath="//div[3]/div/span/span[1]")
	public List <WebElement> carPrices;
	
	public void getCarNamesAndPrices(){
		//Operating for loop on carprices as the prices are not shown for 'not rated' car models on the page.
		//so if we take carNames, the array will go out of bound for carprice rates.
		for(int i = 0; i < carPrices.size()-1; i++) {
			System.out.println(carNames.get(i).getText() + " Price: " + carPrices.get(i).getText());
		}
	}
}
