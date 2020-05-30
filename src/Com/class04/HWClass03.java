package Com.class04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.CommonMethods;
import Utils.ConfigsReader;
import Utils.ExcelUtility;

public class HWClass03 {
	public class HW extends CommonMethods {
	//	@Test(dataProvider = "userData")
	@Test(dataProvider = "userDataFromExcel")
		public void test(String firstName, String lastName, String username, String password) {
			// System.out.println(firstName + " " + lastName + " " + username + " " +
			// password);

			// login into HRMS
			login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

			// navigate to Add Employee page
			dashboard.navigateToAddEmployee();
			wait(1);

			// add employee information
			sendText(addEmp.empfirstnme, firstName);
			sendText(addEmp.lastnme, lastName);
			// get EmployeeID
			String expectedEmpId = addEmp.empid.getAttribute("value");

			// click on Create Login Details
			click(addEmp.loginDetls);
			wait(1);
			sendText(addEmp.username, username);
			sendText(addEmp.userpassword, password);
			sendText(addEmp.reuserpassword, password);
			wait(1);
			jsClick(addEmp.BtnSave);
			wait(1);

			// validation
			waitForVisibilityOfElemet(pdetails.lblPersonalDetails);
			String actualEmpId = pdetails.employeeId.getAttribute("value");
			Assert.assertEquals(actualEmpId, expectedEmpId, "Employee ID did not match!");

			// take screeshot
			takeScreenshot(firstName + "_" + lastName);
		}

		@DataProvider(name = "userData")
		public Object[][] getData() {
			Object[][] data = { { "Raj", "Capoor", "raj123", "AmirKhan_@123" },
					{ "John", "Smith", "john123", "AmirKhan_@123" }, { "Mary", "Ann", "mary123", "AmirKhan_@123" },
					{ "Rohani", "Sakhi", "rohani123", "AmirKhan_@123" }, { "Ali", "Tarlaci", "ali123", "AmirKhan_@123" }, };
			return data;
		}

		@DataProvider(name = "userDataFromExcel")
		public Object[][] getData2() {
			
			//return ExcelUtility.excelIntoArray(filePath, sheetName)
			return ExcelUtility.excelIntoArray(System.getProperty("user.dir") + "/Excel/Class03HW.xlsx", "Employee");
		}

	}}