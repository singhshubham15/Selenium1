package assertionDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionScripts 
{
	//Hard Assert
	
	// whenevery you want to verify anything in TestNG we use Assert Class methods
	
	@Test
	public void test1()
	{
		Assert.assertEquals(12, 13);
		
	}
	//Assertion message display
	@Test
	public void test2()
	{
		Assert.assertEquals(12, 13,"Dropudown count does not match please check with developer");
		
	}
	
	@Test
	public void test3()
	{
		System.out.println("Test case 3 Started");
		Assert.assertEquals("hello", "hello","Words does not match,Please raise a bug");
		System.out.println("Test case 3 Completed");
	}

}
