package HOMEWORK;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Com.Pages.LoginPageElements;
import Utils.CommonMethods;
import Utils.ConfigsReader;

/*TC 2: HRMS Application Negative Login:
1. Open chrome browser
2. Go to“http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
3. Enter valid username
4. Leave password field empty
5. Verify error message with text “Password cannot be empty” is displayed. 
 */
public class NegativeLogInClass01 extends CommonMethods{

	
	@BeforeClass
	public void OpenBrowser() {
		setUp();
	}
	
	@Test
	public void inValidLogin() {
		
		LoginPageElements login=new LoginPageElements();
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		//sendText(login.password, ConfigsReader.getProperty("password"));
		
		click(login.loginBtn);
		
		String expectedmsg="Password cannot be empty";
		
	String actualmsg=login.errorMsg.getText();
	  boolean errorDisplay=login.errorMsg.isDisplayed();
	  
	 if(errorDisplay) {
		 System.out.println("Error msg is displayed");

   if(expectedmsg.equals(actualmsg)) {
	   System.out.println("Error msg is correct");
   }else {
	   System.out.println("Error msg is not corret");
   }
	
	
	}
	
	}
	
}
