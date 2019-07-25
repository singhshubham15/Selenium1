package testNGPackage;

import org.testng.annotations.Test;

public class FirstTestNGScript 
{
	@Test(priority=1,description="This test case will verify login functionality")
	public void loginApplication() {
		System.out.println("login to appliction");
	}
	
	@Test(priority=2,description="This test case will add certain items into Cart")
	public void selectItems() {
		System.out.println("item selected");
	}
	
	@Test(priority=3,description="This test case will perform checkouts")
	public void checkOut() {
		System.out.println("chekout Completed");
	}

}
