package HOMEWORK;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Utils.CommonMethods;

/*TC 1: HRMS Add Employee:
1. Open chrome browser
2. Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
3. Login into the application
4. Add 5 different Employees and create login credentials by providing:
● First Name
● Last Name
● Username
● Password
5. Provide Employee First and Last Name
6. Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
7. Close the browser Specify group for this test case, add it into specific suite and execute from xml file.  */
public class DataProviderclass03 extends CommonMethods {
@Test(dataProvider = "userData",groups="smoke")
public void AddFiveEmply(String username,String password,String empfirstnme,String lastnme,
		                 String empusername,String emppassword) {
		sendText(login.username, username);
		sendText(login.password, password);
		
		click(login.loginBtn);
		click(dashboard.PIM);                                                                                               
		wait(2);
		click(dashboard.addemp);
		 wait(2);
		sendText(addEmp.empfirstnme, empfirstnme);
		sendText(addEmp.lastnme, lastnme);

		jsClick(addEmp.loginDetls);
		
		sendText(addEmp.username, empusername);
		sendText(addEmp.userpassword, emppassword);
		sendText(addEmp.reuserpassword, emppassword);
		jsClick(addEmp.BtnSave);
		TakesScreenshot TscSht = (TakesScreenshot) driver;
		File sourceFile = TscSht.getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(sourceFile,new File("ScreenShots/AddEmployee/"+empfirstnme+lastnme+".png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Screenshot was not taken");
		}
		
		Boolean DisplayName = addEmp.empfirstnme.isDisplayed();
		Boolean DisplayLastName = addEmp.lastnme.isDisplayed();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(DisplayName, "First Name is Not Displayed");
		soft.assertTrue(DisplayLastName, "Last Name is NotDisplayed");
		System.out.println("Employee has been added successfully");
		
		wait(4);
		soft.assertAll();
	}
@DataProvider(name="userData")// we can write name inside ther and then we can use it inside test as @Test (dataProvider = "userData")
                              //also if we do not write name we can use method name @Test (dataProvider = "getData")
public Object[][] getData() {
Object[][] data={{"Admin","Hum@nhrm123","Adilee","Karadeniz","adlL@Krdnz","Adl@KrdNz11" },
				{ "Admin", "Hum@nhrm123", "Tugbaa", "Akca", "TugB.#akca", "Tug@aAkc22KK " },
				{ "Admin", "Hum@nhrm123", "Arzu ", "Kaya", "Aarzu$Kaya", "Krdnz@5wdT361" },
				{ "Admin", "Hum@nhrm123", "Hulya ", "Yavuz", "YaV&vuzHly", "Hly#3425SYAV" },
				{ "Admin", "Hum@nhrm123", "fatmaa ", "Simsek", "SmsSk%Ftm", "Fatm@SmsekK32" }, };
		return data;
	}

}
