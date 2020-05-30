package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{

@Override
public void onStart(ITestContext context) {
	System.out.println("Functionality Testing Start ");
}
	
@Override	
public void onFinish(ITestContext context)	{
	
	System.out.println("Functionality Testing Finished ");
}

@Override	
public void onTestStart(ITestResult result)	{
	
	System.out.println("Test Started " + result.getName());
}


@Override	
public void onTestSuccess(ITestResult result)	{
	
	System.out.println("Test Passed " + result.getName());
}


@Override
public void onTestFailure(ITestResult result) {
	System.out.println("Test Failed " + result.getName());
}
// I added 

@Override
public void onTestFailedWithTimeout(ITestResult result) {
    onTestFailure(result);
    System.out.println("Time is Out Test Failed "+result.getName());
  }

@Override
public  void onTestSkipped(ITestResult result) {
  System.out.println(result.getName()+"  skipped " );
  }










}
