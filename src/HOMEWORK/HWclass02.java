package HOMEWORK;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Com.Pages.DashBoardPageElements;
import Com.Pages.LoginPageElements;
import Com.Pages.PersonalDetailsPageElements;
import Utils.CommonMethods;
import Utils.ConfigsReader;
/*TC 1: HRMS Add Employee:
1. Open chrome browser
2. Go to
“http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
3. Login into the application
4. Click on Add Employee
5. Verify labels: Full Name, Employee Id, Photograph are displayed
6. Provide Employee First and Last Name
7. Add a picture to the profile
8. Verify Employee has been added successfully
9. Close the browser */
public class HWclass02 extends CommonMethods {
//@BeforeClass
//	
//	public void OpenBrowserAndNavigate() {
//	setUp();
//}
//
//@AfterClass
//public void quitBrowser() {
//	tearDown();
//}

@Test
public void LoginPage() {
	
    LoginPageElements login=new LoginPageElements();
          sendText(login.username, ConfigsReader.getProperty("username"));
	      sendText(login.password, ConfigsReader.getProperty("password"));
	      click(login.loginBtn) ;

	DashBoardPageElements addemplyee=new DashBoardPageElements();
        click(addemplyee.PIM);
	
        click(addemplyee.addemp);
	
sendText(addemplyee.empfirstnme,ConfigsReader.getProperty("employeename"));
sendText(addemplyee.lastnme,ConfigsReader.getProperty("employeelastname"));
sendText(addemplyee.empPrfl,ConfigsReader.getProperty("photopath"));
   click(addemplyee.BtnSave);
	     
TakesScreenshot TscSht= (TakesScreenshot)driver;
	
File sourceFile=TscSht.getScreenshotAs(OutputType.FILE);
   try {
  FileUtils.copyFile(sourceFile, new File("ScreenShots/AddEmployee/Employee1.png"));
  }catch(IOException e) {
		  e.printStackTrace();
System.out.println("Screenshot was not taken");	
	        }}

@Test(dependsOnMethods= {"LoginPage"})
public void  VerfyEmployeelabel() {
	 
       sendText(login.username, ConfigsReader.getProperty("username"));
	      sendText(login.password, ConfigsReader.getProperty("password"));
	      click(login.loginBtn) ;

     click(dashboard.PIM);
	wait(2);
     click(dashboard.addemp);
     
     
     sendText(addEmp.empfirstnme,ConfigsReader.getProperty("employeename"));
     sendText(addEmp.lastnme,ConfigsReader.getProperty("employeelastname"));
     sendText(addEmp.empPrfl,ConfigsReader.getProperty("photopath"));
        click(addEmp.BtnSave);
     
Boolean DisplayName=pdetails.firstname.isDisplayed();

Boolean DisplayLastName=pdetails.lasstname.isDisplayed();

SoftAssert soft=new SoftAssert();
soft.assertTrue(DisplayName, "First Name is Not Displayed");
soft.assertTrue(DisplayLastName,"Last Name is NotDisplayed");
	
System.out.println("Employee has been added successfully");
	soft.assertAll();
	
	
	
}








}