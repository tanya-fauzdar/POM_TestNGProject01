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
		
		log.info("----Tanya: Car brand is: "+ carBrand + "---");
		
		if(runMode.equals("N")){
			//If run mode is 'N' skip the test case
			throw new SkipException("Skipping the test as the run mode is No");
		}
		
		//setUp(browser);
		HomePage home = new HomePage(driver);
		NewCarsPage newCars = home.findNewCars();
		
		if(carBrand.equals("audi")) {
			newCars.goToAudi();
			log.info("----Tanya: Went to Audi---");
		}else if (carBrand.equals("bmw")) {
			newCars.goToBMW();
			log.info("----Tanya: Went to BMW---");
		}else if (carBrand.equals("toyota")) {
			newCars.goToToyota();
			log.info("----Tanya: Went to Toyota---");
			
		}
		else if (carBrand.equals("kia")) {
			newCars.goToKia();
			log.info("----Tanya: Went to Kia---");
			
		}
		else if (carBrand.equals("hyundai")) {
			newCars.goToHyundai();
			log.info("----Tanya: Went to Hyundai---");
			
		}
		log.info("Actual CarTitle is: " + BasePage.carBase.getCarTitle());
		
		Assert.assertEquals(BasePage.carBase.getCarTitle(), carTitle);
		
	}

}
