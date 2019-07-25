package assertionDemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {

	@Test
	public void testSoft()
	{
		SoftAssert assertion = new SoftAssert();
		
		System.out.println("test 1 started");
		
		assertion.assertEquals(12, 13);
		
		System.out.println("test compleasted");
		
		assertion.assertAll();
		
	}
	@Test(priority=1)
	public void testHardAssert()
	{
			
		System.out.println("testHardAssert started");
		
		Assert.assertEquals(12, 13);
		
		System.out.println("test compleasted");
		
	}
}
