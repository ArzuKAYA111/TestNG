package Utils;

import Com.Pages.AddEmployeePageElements;
import Com.Pages.DashBoardPageElements;
import Com.Pages.LoginPageElements;
import Com.Pages.PersonalDetailsPageElements;
import Com.Pages.SauceProductPage;
import Com.Pages.sauceDemoLoginPage;

public class PageInitializer extends BaseClass {

	public static LoginPageElements login;
	public static DashBoardPageElements dashboard;
	public static AddEmployeePageElements addEmp;
	public static PersonalDetailsPageElements pdetails;
	public static sauceDemoLoginPage sauceDemoPage;
	public static SauceProductPage   sauceProdct;
	
	
	
	public static void initialize() {
	 login=new LoginPageElements();
	 dashboard=new DashBoardPageElements();     //we are calling the constructor of page calsses
	 addEmp= new AddEmployeePageElements();
	 pdetails=new PersonalDetailsPageElements();
	 sauceDemoPage=new sauceDemoLoginPage();
	 sauceProdct=new SauceProductPage();
	 
	}
	
	
	
	
	
	
	
	
}
