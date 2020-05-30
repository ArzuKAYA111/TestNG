package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener {
	
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Functionality Testing Start ");
	}
		
	@Override	
	public void onFinish(ITestContext context)	{
		
		System.out.println("Functionality Testing Finished ");
	}
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+ "Test Case Started ");
	}
	
	@Override
	public  void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+ " Test Passed " );
	  }
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println( result.getName()+"Test Failed " );
	}
	
	
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	    System.out.println("Time is Out "+result.getName()+ " Test Failed ");
	  }
	
	
	@Override
	public  void onTestSkipped(ITestResult result) {
	  System.out.println(result.getName()+"  skipped " );
	  }

	
}
