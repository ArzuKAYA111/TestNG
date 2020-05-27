package Com.class02;

/* TC 1: HRMS Application Login:
1. Open chrome browser
2. Go to
“http://166.62.36.207/humanresources/symfony/web/index.php/
auth/login”
3. Enter valid username and password
4. Click on login button
5. Then verify Syntax Logo is displayed
6. Close the browser

TC 2: HRMS Application Negative Login:
1. Open chrome browser
2. Go to“http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
3. Enter valid username
4. Leave password field empty
5. Verify error message with text “Password cannot be empty” is displayed. 
 */
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Com.Pages.DashBoardPageElements;
import Com.Pages.LoginPageElements;
import Utils.CommonMethods;
import Utils.ConfigsReader;

public class HW extends CommonMethods {
//
//	@BeforeMethod
//	public void openBrowserAndNavigate() {
//		setUp();
//	}
//
//	@AfterMethod
//	public void quitBrowser() {
//		tearDown();
//	}
//     // 1st way
	// @Test(dependsOnMethods = "invalidLogin" )
	// 2nd way
	// @Test(dependsOnMethods = { "invalidLogin" })
	// depending on multiple methods
	// @Test(dependsOnMethods = { "invalidLogin", "method2", "method3" })

	@Test(priority = 1, dependsOnMethods = { "invalidLogin" })
	
	public void validLogin() {
		
// WebElement username = driver.findElement(By.id("txtUsername"));

// 1st way
		// username.sendKeys(ConfigsReader.getProperty("username"));

// 2nd way
		// sendText(username, ConfigsReader.getProperty("username"));

		// 3rd way, using Page Object Model and PageFactory
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));

		sendText(login.password, ConfigsReader.getProperty("password"));
// 1st way
		// WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		// wait.until(ExpectedConditions.elementToBeClickable(login.loginBtn));
		// login.loginBtn.click();

// 2nd way
		// waitForClickability(login.loginBtn);
		// login.loginBtn.click();
		
// 3rd way
		click(login.loginBtn);

		DashBoardPageElements dashboard = new DashBoardPageElements();

		boolean displayed = dashboard.logo.isDisplayed();
		if (displayed) {
			System.out.println("Logo is displayed");
		} else {
			System.out.println("Logo not is displayed");
		}

		// 1st way
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//
//			e.printStackTrace();
//		}
		// 2nd way
		wait(1);

	}

	// @Test means Test Case = Scenario = Test Method
		// Case 1: if this test method is commented, it will not run
		// Depending method will throw an exception
		// @Test(priority = 3, enabled = true)

		// Case 2: if this test method is disabled, it will not run
		// Depending method will throw an exception
		// @Test(priority = 3, enabled = false)

		// Case 3: if this test method fails, it will run but fail
		// Depending method will not execute

		// Case 4: if this test method passes, it will run and pass
		// Depending method will execute


	@Test(priority = 2)
	public void invalidLogin() throws Exception {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		click(login.loginBtn);

		String expectedText = "Password cannot be empty";
		String actualText = login.errorMsg.getText();
		boolean errorDisplayed = login.errorMsg.isDisplayed();

		if (errorDisplayed) {
			System.out.println("Error msg is displayed");

			if (expectedText.equals(actualText)) {
				System.out.println("Error msg is correct");
			} else {
				System.out.println("Error msg is not correct");
			}

		} else {
			System.out.println("Error msg is not displayed");
		}
		wait(1);

		// When the test fails an Exception is thrown
	throw new Exception();    // BUNU eklediginde neden test fail oluyor ben tam olarak anlamadim anlayan yazabilir mi ?
		
	}
}
