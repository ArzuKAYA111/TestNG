package Com.class01;

import org.testng.annotations.Test;

public class TestNdDemo { // print alphabetic order of Test Names 
	
	@Test  // it is name of the Test Interface
	public void testOne() {        // to execute one by one test we need to select test name and right click run as  Test NG tes
		
		System.out.println("Step 1");
		
		
		System.out.println("Step 2");
		System.out.println("Step 3");	
	}

	@Test // if we use that annotation we need to import//add a testNG library
	      // we need to inport test annotation
	public void testTwo() {
		
		System.out.println("Test Case 2");
		
	}

	@Test  
	public void testThree() {
		
		System.out.println("Test Case  3");
		
	}
	

}
