package testNGlisteners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("******* Test is started"+result.getName());	
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("******* Test is Scusses"+result.getName());	
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("******* Test is failed"+result.getName());	
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("******* Test is skipped"+result.getName());	
	}
	
	public void onStart(ITestContext context) {
		System.out.println("******* Test is started"+context.getName());
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("******* Test is success"+result.getName());
	}
	public void onFinish(ITestContext context) {
		System.out.println("******* Test is completed"+context.getName());
	}
}
