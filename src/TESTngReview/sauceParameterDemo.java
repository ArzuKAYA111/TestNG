package TESTngReview;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utils.CommonMethods;

public class sauceParameterDemo extends CommonMethods {
		
		
		@Parameters({"username","password"})
	    @Test()
		public static void logintosauceDemo(String username,String password) {
			sendText(sauceDemoPage.username,username);
			sendText(sauceDemoPage.password,password);
			sauceDemoPage.loginButton.click();
	}}

	