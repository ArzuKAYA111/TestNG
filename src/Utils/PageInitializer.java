package Utils;

import Com.Pages.AddEmployeePageElements;
import Com.Pages.DashBoardPageElements;
import Com.Pages.LoginPageElements;
import Com.Pages.PersonalDetailsPageElements;

public class PageInitializer extends BaseClass {

	public static LoginPageElements login;
	public static DashBoardPageElements dashboard;
	public static AddEmployeePageElements addEmp;
	public static PersonalDetailsPageElements pdetails;
	
	public static void initialize() {
	 login=new LoginPageElements();
	 dashboard=new DashBoardPageElements();
	 addEmp= new AddEmployeePageElements();
	 pdetails=new PersonalDetailsPageElements();
		
	}
	
	
	
	
	
	
	
	
}
