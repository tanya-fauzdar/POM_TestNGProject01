package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import Base.BasePage;
import pages.HomePage;
import pages.NewCarsPage;

import utilities.DataUtil;


public class FindNewCarsTest extends BaseTest{
	
	@Test(dataProvider = "dp", dataProviderClass = DataUtil.class)
	public void findNewCars(String browser, String runMode, String carBrand, String carTitle) {
		
		if(runMode.equals("N")){
			//If run mode is 'N' skip the test case
			throw new SkipException("Skipping the test as the run mode is No");
		}
		
		setUp(browser);
		HomePage home = new HomePage(driver);
		NewCarsPage newCars = home.findNewCars();
		//newCars.goToToyota();
		//BasePage.carBase.getCarTitle();
		System.out.println("Car brand is: "+ carBrand);
		
		if(carBrand.equals("audi")) {
			newCars.goToAudi();
			System.out.println("Went to Audi");
		}else if (carBrand.equals("bmw")) {
			newCars.goToBMW();
			System.out.println("Went to BMW");
		}else if (carBrand.equals("toyota")) {
			newCars.goToToyota();
			System.out.println("TOYOTA");
		}
		System.out.println("Actual CarTitle is: " + BasePage.carBase.getCarTitle());
		
		Assert.assertEquals(BasePage.carBase.getCarTitle(), carTitle);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
