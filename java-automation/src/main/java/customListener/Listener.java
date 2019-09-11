package customListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println("*************************Test Started****************************");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("***********************Test Successfull***********************************");
	}

	
	public void onTestFailure(ITestResult result) {
		 System.out.println("***********************Test failed***********************************");
	}

	
	public void onTestSkipped(ITestResult result) {
		 System.out.println("***********************Test skipped***********************************");
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		System.out.println("#####################################Before Class##########################################");
		
	}

	
	public void onFinish(ITestContext context) {
		System.out.println("#####################################After Class##########################################");
		
	}
	


}
