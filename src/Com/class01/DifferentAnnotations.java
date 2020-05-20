package Com.class01;

import org.testng.annotations.*;

public class DifferentAnnotations {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@Test
	public void test() {

		System.out.println(" ");

	}

}
