package Com.Test;
/*Automate user stories below:
US 12678 As an Admin I should be able to create login credentials while adding employee
US 67789 As an admin while adding employee if I leave required fields empty I should see “Required” message
Note: first name and last name are required fields*/
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Utils.CommonMethods;
import Utils.ConfigsReader;
public class AutomateUserStory extends CommonMethods {
	    @Test
	public void loginCredentials() {
//UserStory 1		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		jsClick(login.loginBtn);
		click(dashboard.PIM);
		// WaitForClickability(dashboard.addemp);
		wait(2);
		dashboard.addemp.click();
	//	sendText(addEmp.empfirstnme, ConfigsReader.getProperty("empname"));
	//	sendText(addEmp.lastnme, ConfigsReader.getProperty("emplstname"));
		wait(2);
		sendText(addEmp.empPrfl, ConfigsReader.getProperty("photopath"));

		jsClick(addEmp.loginDetls);
		wait(2);
		sendText(addEmp.username, ConfigsReader.getProperty("empusername"));
		sendText(addEmp.userpassword, ConfigsReader.getProperty("emppassword"));

		sendText(addEmp.reuserpassword, ConfigsReader.getProperty("emppassword"));

		addEmp.BtnSave.click();
//UserStory 2	
		String experrtext="Required"; 
		String acterrtextnm=addEmp.errmsgname.getText();  
		String acterrtextlstnm=addEmp.errmsgLname.getText(); 
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(experrtext, acterrtextnm,"Error msg for name is not found there");
		soft.assertEquals(experrtext, acterrtextlstnm,"Error msg for last name is not found there");
		TakesScreenshot TscSht= (TakesScreenshot)driver;
		File sourceFile=TscSht.getScreenshotAs(OutputType.FILE);
		 try {
		FileUtils.copyFile(sourceFile, new File("ScreenShots/AddEmployee/Employee2.png"));
		}catch(IOException e) {
				  e.printStackTrace();
		System.out.println("Screenshot was not taken");	
			        }
		soft.assertAll();
	
}}
