package Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {   // Create  testClass In different Package  to see if we test in other package we need to import this class

	public static WebDriver driver;
	
	public static WebDriver setUp() {
		                                                            //create reader path to property file 
ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

	
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
		return driver;
	}

	public static void tearDown() {// To close  page
	
		if(driver!=null) {
			driver.quit();
	}
  }
}
