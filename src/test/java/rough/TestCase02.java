package rough;

import org.testng.annotations.Test;

//System.out.println();

public class TestCase02 {
	
	@Test ( dependsOnMethods = "goToHomePage",  groups = {"Smoke"} )
	public static void goToPage01() {
		
		System.out.println("Go to page 01 test---");
	}
	
	@Test (groups = {"Smoke"} )
	public static void goToHomePage() {
		
		System.out.println("Go to Home page  test---");
	}
	

}
