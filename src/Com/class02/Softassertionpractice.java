package Com.class02;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utils.CommonMethods;
import Utils.ConfigsReader;
/*Open Application
 Verify logo is displayed
 Enter valid credentials
 Verify user successfully logged in
 by verifying welcome message */
public class Softassertionpractice extends CommonMethods{

@BeforeTest
public void openBrowser(){
	setUp();
	initialize();	
}

@AfterMethod	
public void CloseBrowser() {
	tearDown();
}

@Test	
public void verifyLogoLoggin() {
	Boolean logoDisplay=login.logo.isDisplayed();
sendText(login.username, ConfigsReader.getProperty("username"));	
sendText(login.password,ConfigsReader.getProperty("password"));	
click(login.loginBtn);
wait(2);

    Boolean welcomeDisplayed=dashboard.welcome.isDisplayed();

//1  Way  Hard Assertion
    
// Assert.assertTrue(logoDisplay,"Logo is not displayed ");// Logo assertion
//Assert.assertTrue(welcomeDisplayed, "Login is failed");   //welcome asssertion            //     hard assertion
// System.out.println("welcome message is displayed");


//2  Way   Soft asssertion 

SoftAssert softassert=new SoftAssert();
softassert.assertTrue(logoDisplay,"logo is Not displayed");// Logo assertion
softassert.assertTrue(welcomeDisplayed,"welcome message is Not displayed");//welcome asssertion 
System.out.println("welcome message is displayed");
System.out.println("Successfully logged in ");

softassert.assertAll();   // If we use soft assertion we must be use this assertAll() method at the end of the code
System.out.println("After assertAll");
}








}
