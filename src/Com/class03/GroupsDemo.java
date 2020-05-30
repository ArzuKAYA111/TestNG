package Com.class03;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;

public class GroupsDemo {
	// alwaysRun attribute will make sure that this method will always execute
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("beforeClass");
	}
@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("afterClass");
	}	
@Test
public void test1() {
	System.out.println("test 1");
}


@Test(groups= {"smoke"})
public void test2() {
	System.out.println("test 2");
//1.assert	Assert.assertTrue(false);// if this test fails ,test 1 will be skipped
	
//2.assert	
	SoftAssert soft = new SoftAssert();
	soft.assertTrue(true); //true/false
	soft.assertAll(); // this statement will collect all soft assert
						// and decide if test passed or failed
}

@Test(groups="regression")
public void test3() {
	System.out.println("test 3");
}

@Test(groups= {"smoke","regression"})
public void test4() {
	System.out.println("test 4");
}

}
