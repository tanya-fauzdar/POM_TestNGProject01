package rough;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParamtersFromXML {
	
	@Parameters({"browser", "env"})
	@Test
	public void getBrowser(String browser, String env) {
		System.out.println("Browser is: " + browser+ "& --env is: " + env);
		
	}

}
