package Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {   // Create  testClass In different Package  to see if we test in other package we need to import this class

	public static WebDriver driver;
	
@BeforeMethod(alwaysRun=true)// to make this method run before every @Test method
	public static WebDriver setUp() {
		                                                            //create reader path to property file 
ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
	
		switch (ConfigsReader.getProperty("browser").toLowerCase()) {

		case "chrome":

			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);

			driver = new ChromeDriver();
			break;

		case "firefox":

			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		default:

			throw new RuntimeException("Browser is not supported");
		}
		
		driver.manage().window().maximize();//we added to do page full
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
	
		
		driver.get(ConfigsReader.getProperty("url"));
		
		
		//initialize all page objects as part of setup
				PageInitializer.initialize();
				
		return driver;
	}
   //  @AfterClass
	@AfterMethod(alwaysRun=true) //to make this method to run after every @Test method
	public static void tearDown() {// To close  page
	
		if(driver!=null) {
			driver.quit();
	}
  }
}
