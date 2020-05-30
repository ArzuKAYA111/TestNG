package Com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonMethods;

public class sauceDemoLoginPage extends CommonMethods  {

	@FindBy(id="user-name")
	public WebElement username;
	

	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(xpath="// input[@class='btn_action']")
	public WebElement loginButton;
	
	@FindBy(xpath="//h3[ contains(text(),'Epic sadface:')]")
	public WebElement errorMsg;
	
	
	 public sauceDemoLoginPage() {
		 PageFactory.initElements(driver, this);
	 }
	
	

	
	
	
	
	
	
	
	
}
