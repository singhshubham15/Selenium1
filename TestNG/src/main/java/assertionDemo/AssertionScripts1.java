package assertionDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionScripts1 
{
	//Hard Assert
	
	// whenevery you want to verify anything in TestNG we use Assert Class methods
	
	@Test
	public void test1()
	{
		String myStr ="shubham Thakur";
		
		Assert.assertTrue(myStr.contains("Thakur"));
		
	}
	
	@Test
	public void test2()
	{
       String myStr ="shubham Thakur";
		
		Assert.assertTrue(myStr.contains("sachin"),"Names are not matching");
	}


}
