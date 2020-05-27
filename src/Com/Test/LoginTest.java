package Com.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.Pages.DashBoardPageElements;
import Com.Pages.LoginPageElements;
import Utils.CommonMethods;
import Utils.ConfigsReader;


public class LoginTest extends CommonMethods {
	
//	@BeforeMethod
//	public void openBrowser() {  We Do not need anymore becuse we added them into BaseClass
//		setUp();
//		initialize();
//	}
//@AfterMethod
//public void closeBrowser() {
//	tearDown();
//}


@Test
public void ValidAdminlogin() {
	
//LoginPageElements login=new LoginPageElements();
sendText(login.username, ConfigsReader.getProperty("username"));
sendText(login.password, ConfigsReader.getProperty("password"));
click(login.loginBtn) ;

//DashBoardPageElements dashboard=new DashBoardPageElements();
String expextedUser="Welcome Admin";
String actualUser=dashboard.welcome.getText();
Assert.assertEquals(actualUser, expextedUser, "Admin is NOT Logged in");

}

@Test
public void InvalidPasswordlogin() {

	//LoginPageElements login=new LoginPageElements();
	sendText(login.username, ConfigsReader.getProperty("username"));
	sendText(login.password, "uiuguig");
	click(login.loginBtn) ;	
	String expected = "Invalid credentials";
	Assert.assertEquals(login.errorMsg.getText(), expected,"Error message text is not match");
}

@Test(enabled=true)
public void emptyUsernamelogin() {

//	LoginPageElements login=new LoginPageElements();
	//sendText(login.username, ConfigsReader.getProperty("username")); // common out to make empty user name
	sendText(login.password, ConfigsReader.getProperty("password"));
	click(login.loginBtn) ;	
	String expected = "Username cannot be empty";
	Assert.assertEquals(login.errorMsg.getText(), expected,"Error message text is not match");
}







}
