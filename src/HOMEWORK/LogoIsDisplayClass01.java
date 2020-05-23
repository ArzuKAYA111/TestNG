package HOMEWORK;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.CommonMethods;
import Utils.ConfigsReader;

/*
 * TC 1: HRMS Application Login:
1. Open chrome browser
2. Go to
“http://166.62.36.207/humanresources/symfony/web/index.php/
auth/login”
3. Enter valid username and password
4. Click on login button
5. Then verify Syntax Logo is displayed
6. Close the browser
 */
public class LogoIsDisplayClass01 extends CommonMethods {

	@BeforeClass
	public void OpenAndNavigate() {
		setUp();
	}
	
	@Test
	public void ValidLogIn() {
		
	WebElement userName=driver.findElement(By.xpath("//input[@id='txtUsername']"))	;
		
		sendText(userName,ConfigsReader.getProperty("username"));
		wait(2);
	WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"))	;	
	
	  sendText(password,ConfigsReader.getProperty("password"));	
	  
	  
	  WebElement login=driver.findElement(By.xpath("//input[@id='btnLogin']"))	;	
		click(login);
	  
		
	}
	
	@Test(dependsOnMethods="ValidLogIn")
	public void  verifyLogo(){
		WebElement logo=driver.findElement(By.xpath("//img[@width='283']"));
		logo.isDisplayed();
	}
	

	
	@AfterClass
	public void close() {
		tearDown();
	}
}
