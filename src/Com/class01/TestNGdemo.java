package Com.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGdemo {

	@Test
	public void firstTest() {
		System.out.println("This is Test annotation");
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is Before Method annotation");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("This is After Method annotation");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is Before Class annotation");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("This is After Classs annotation");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is Before Test annotation");
	}
		
	
	@AfterTest
	public void afterTest() {
		System.out.println("This is After Test annotation");
	}
	
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is Before Suite annotation");
	}
	
	
	@AfterTest
	public void afterSuite() {
		System.out.println("This is After Suite annotation");
	}
	
	
	
	
	
	
	
	
	
	
	

}
