package CustomListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//System.out.println();

public class Listeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Passed Test---" + result.getTestName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Capturing screenshot for failed test case--- " + result.getTestName());
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
