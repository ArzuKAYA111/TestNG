package Utils;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener{

public void onStart(ISuite suite) {
		    System.out.println(suite +" Testind started");
		  }
	
public void onFinish(ISuite suite) {
	   System.out.println(suite +" Testind Finished");
  }

}
