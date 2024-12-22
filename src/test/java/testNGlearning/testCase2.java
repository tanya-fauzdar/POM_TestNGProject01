package testNGlearning;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class testCase2 {

	
	@Test
	public void validateTitles() {
	String expectedTitle = "google.com";
	String actualTitle = "yahoo.com";
	
	//To Validate, we don't use if-else statements, rather use Assertions
	
	//Assert.assertEquals(actualTitle, expectedTitle);
	//Assert.assertTrue(false, "Failingthe tets case with assertTrue");
	//Assert.fail("Failing the TC forcefully");
	
	SoftAssert softAssert = new SoftAssert();
	softAssert.assertEquals(actualTitle, expectedTitle);
	
	}
}
