/*
 * This is simple java test class for learning and testing the page classes.
 * Hence it includes everything in main() method here.
 * But, going forward we will be keeping our design as per TestNG or Cucumber framworks
 * i.e Common functionalities in a Base class, different test cases in different test case classes
 * etc.
 * 
 */

package rough;

import java.time.Duration;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;
import pages.NewCarsPage;

public class FindNewCarsTest {
	
	public static void main (String args[]) {
		
		//Handling the chrome browser notification pop-up
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("prefs", prefs);
		
		
		WebDriver driver = new ChromeDriver(opt);
	
		driver.get("https://www.carwale.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		/* 
		 * Step-1 for learning
		 * HomePage home = new HomePage(driver); 
		 * NewCarsPage newCars = home.findNewCars(); 
		 * newCars.goToToyota().getTitle();
		 */
		
		
		/*
		 * After having implemented the 'return of page objects from the method' ,
		 * we can access method through method chaining too like:
		 * home.findNewCars().goToToyota().getTitle();
		 * But here we are not doing so cause if one method fails, it will cause the following to fail, as in not execute
		 */ 
		
		/*
		 * Step-2 for learning
		 * Introducing the Page Factory approach
		 * Initializing the page factory for the Home page class
		 */
		
		HomePage home = new HomePage(driver);
		NewCarsPage newCars = home.findNewCars();
		newCars.goToToyota();

	}
}
