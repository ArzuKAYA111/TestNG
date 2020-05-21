package Com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.BaseClass;

public class LoginPageElements {
	// Not using PageFactory, You have to extend CommonMethods or BaseClass
	// public WebElement username2=driver.findElement(By.id("txtUsername"));

	// Using PageFactory and @FindBy Annotation
	@FindBy(id = "txtUsername")
	public WebElement username;

	@FindBy(name = "txtPassword")
	public WebElement password;

	@FindBy(css = "input#btnLogin")
	public WebElement loginBtn;

	@FindBy(xpath = "//div[@id='divLogo']/img")
	public WebElement logo;

	@FindBy(id = "spanMessage")
	public WebElement errorMsg;

	public LoginPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
