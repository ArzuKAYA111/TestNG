package Com.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGdemo2 {
	//Test Class Based ANNOTATIONS
	
@Test
	public void firstTest() {
		System.out.println("Hi, I am a first test");
	}
@Test	
	public void secondTest() {
		System.out.println("Hi, I am a second test");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Hi, I am Before Method annotation, I run before each and every test");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("Hi, I am After Method annotation, I run after each and every test");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Hi, I am Before Class annotation, I run first in Class ");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Hi, I am After Class annotation, I run last in Class");
	}



}
