package parallelTest;

import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestBrowser {
	
	@Parameters({"browser", "env"})
	@Test
	public void doLogin(String b, String e) throws InterruptedException {
		
		Date d = new Date(); //adding date so as to see that the tests are executed in parallel ie at same time
		System.out.println("Browser is: " + b +"_"+ d +" Environment is: " + e);
		Thread.sleep(2000);
	}
}
