package rough;

import org.testng.Assert;
import org.testng.annotations.Test;

//System.out.println();

public class TestCase03 {
	
	
	@Test (groups = {"Regression"} )
	public static void regressionM01() {
		
		System.out.println("Regression method01  test---");
	}
	
	
	@Test (groups = {"Regression"} )
	public static void regressionM02() {
		
		System.out.println("Regression method02  test---");
	}
	
	@Test (groups = {"Regression" , "Smoke"} )
	public static void validateTitle() {
		
		String expectedTtile = "LeBloom.com";
		String actualTtile = "LaBloom.com";
		
		System.out.println("Validate Title  test---");
		
		Assert.assertEquals(actualTtile, expectedTtile);
	}

}
