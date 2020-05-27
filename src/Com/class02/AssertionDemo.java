package Com.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.Pages.LoginPageElements;
import Utils.CommonMethods;

public class AssertionDemo extends CommonMethods {
	// This is also called Hard Assert
	@BeforeMethod
	public void openBrowserAndNavigate() {
		setUp();
	}
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
	// AssertionError is handled within TestNG
	// Even if one Test Case fails, the others will executed
	@Test
	public void titleValidation() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();

		// 1st way
		// Assert.assertEquals(actualTitle, expectedTitle);

		// 2nd way, You are giving a msg
		Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");//it printing out in console when the test fails as an assertion error massage
		// if the (hard) assertion fails
		// the statements after assertion will not be executed.
		System.out.println("Text after assertion");
	}

	@Test(priority = 2, dependsOnMethods = { "titleValidation" })
	public void logoValidation() {
		LoginPageElements login = new LoginPageElements();
		boolean logoDisplayed = login.logo.isDisplayed();

		// 1st way
		// Assert.assertEquals(logoDisplayed, true, "Logo is not displayed");

		// 2nd way
		Assert.assertTrue(logoDisplayed, "Logo is not displayed");//Assert.assertFalse(logoDisplayed, "Logo is not displayed"); Also there ar with " false " condition
		
	}
	
}
