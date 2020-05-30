package Com.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.BaseClass;

public class PersonalDetailsPageElements {
	
	
	@FindBy(id= "personal_txtEmpFirstName")
	public WebElement firstname;
	@FindBy(id= "personal_txtEmpLastName")
	public WebElement lasstname;
	
	@FindBy(id = "personal_cmbNation")
	public WebElement nationalityDD;

	@FindBy(name = "personal[optGender]")
	public List<WebElement> genderRadioGroup;
	@FindBy(xpath= "//input[@value='1'and @id='personal_optGender_1']")
	public WebElement Gndmale;
	@FindBy(xpath = "//div[@id='pdMainContainer']/div[1]/h1")
	public WebElement lblPersonalDetails;
	
	@FindBy(id = "personal_txtEmployeeId")
	public WebElement employeeId;
	
	
	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
		
	
	
	
	}
}