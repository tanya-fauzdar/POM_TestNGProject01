package CustomListeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFailure {
	
	@Test (groups = {"Regression", "Smoke"} )
	public static void testFail() {
		
		Assert.fail("Failing the tets to see the ITestListeners implementation.");
		System.out.println("Capture Screenshot.");
	}

}
