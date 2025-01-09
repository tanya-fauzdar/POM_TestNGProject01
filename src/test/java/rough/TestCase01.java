package rough;

import org.testng.annotations.Test;

//System.out.println();

public class TestCase01 {
	
	@Test (dependsOnMethods = "regTest", alwaysRun = true , groups = "Regression")
	public static void loginTest() {
		System.out.println("Login Test---");
	}
	
	@Test (priority = 1, groups = {"Smoke", "Regression"} )
	public static void regTest() {
		
		System.out.println("User Registration test---");
	}
	

}
