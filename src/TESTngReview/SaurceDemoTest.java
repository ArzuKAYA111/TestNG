package TESTngReview;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utils.CommonMethods;

public class SaurceDemoTest extends CommonMethods {
	                                          // url=https://www.saucedemo.com
	@DataProvider(name = "dataProvider")

	public Object[][] setUpData() {

	Object[] [] data= new Object [4] [2];// 4 for howmanyTimes we will use data 
	                                      //2 for how many data we willl use   
	
	
	// 2nd way of initializing a 2D-Array

	data [0][0] = "standard_user";
	data [0][1] = "secret_sauce";
	
	
	data [1][0] = "performance_glitch_user";
    data [1][1] = "secret_sauce";
	
	
	data [2][0] = "problem_user";
	data [2][1] = "secret_sauce!";
	
	
	data [3][0] = "locked_out_user";
	data [3][1] = "secret_sauce!";

		// 2 WAY
		Object[][] data1 = { { "standard_user", "secret_sauce" }, { "performance_glitch_user", "secret_sauce" },
				{ "problem_user", "secret_sauce" }, { "locked_out_user", "secret_sauce" }, };

	return data1;
	}
//
	@Test(dataProvider = "dataProvider")

	public void LoginToSauceDemo(String username, String password) {

		sendText(sauceDemoPage.username, username);
		sendText(sauceDemoPage.password, password);
		wait(2);

		click(sauceDemoPage.loginButton);

		wait(3);

		waitForVisibilityOfElemet(sauceProdct.products);
		Boolean productisDisplay = sauceProdct.products.isDisplayed();
		
//		if(username.equals("locked_out_user")) {
//		Assert.assertFalse(sauceDemoPage.errorMsg.isDisplayed());
//			
//		}else { 
//			Assert.assertTrue(productisDisplay, "Login Page Test Failed ");
//		}
	
		SoftAssert soft=new SoftAssert();
		if(username.equals("locked_out_user")) {
			soft.assertTrue(sauceDemoPage.errorMsg.isDisplayed(), "Login Page Test Failed");
				
			}else { 
				
				soft.assertTrue(productisDisplay,"Login Page Test Failed" );

	}

}}
