package Com.class01;

/* Task 2: Executing different test based TestNG annotations
● Create class that will have:
● Before and After Class annotation
● Before and After Method annotation
● 2 methods with Test annotation
Observe the results!
 */
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskTwo {// BeforeClass execute at first and only one time and AfterClass will execute at the end and only one time
                       //BeforeMethod will execute before for each test cases(@Test) ,AfterMethod will execute after for each test cases
	                   
	@Test
	public void firstTest() {
		System.out.println("Hi, I am a first test");
	}

	@Test
	public void secondTest() {
		System.out.println("Hi, I am a second test");
	}
	@Test
	public void secondThree() {
		System.out.println("Hi, I am a third test");
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
