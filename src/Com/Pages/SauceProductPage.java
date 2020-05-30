package Com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonMethods;

public class SauceProductPage extends CommonMethods{
	
	@FindBy(xpath="//div [@id='inventory_filter_container']")
	public WebElement products;
	

	
	
	public SauceProductPage(){
		PageFactory.initElements(driver, this);
	}
	
		
}
