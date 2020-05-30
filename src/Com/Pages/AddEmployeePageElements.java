package Com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.BaseClass;
import Utils.CommonMethods;

public class AddEmployeePageElements extends CommonMethods{
	@FindBy(id="firstName")
	public WebElement empfirstnme;
	
	@FindBy(id="lastName")
	public WebElement lastnme;
	
	@FindBy(id="employeeId")
	public WebElement empid;
	
	@FindBy(id="personal_txtEmployeeId")
	public WebElement lablempid;
	
	@FindBy(id="photofile")
	public WebElement empPrfl;
	
	@FindBy(id="chkLogin")
	public WebElement loginDetls;
	
	@FindBy(id="user_name")
	public WebElement username;
	
	@FindBy(id="user_password")
	public WebElement userpassword;
	
	@FindBy(id="re_password")
	public WebElement reuserpassword;
	
	@FindBy(xpath="//span[@for='firstName']")
	public WebElement errmsgname;
	
	@FindBy(xpath="//span[@for='lastName']")
	public WebElement errmsgLname;
	
	@FindBy(id="btnSave")
	public WebElement BtnSave;
	
	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
