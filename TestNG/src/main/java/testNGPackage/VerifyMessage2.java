package testNGPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyMessage2
{
	WebDriver driver;
	@Test
	public void VerifyErrorMessageWithAttribute() throws InterruptedException
	{
		
		 String projectLocation =	System.getProperty("user.dir");
	     //convert back shlashes to forword slashes
	     String ExactProjectLocationpath =projectLocation.replace("\\", "/");
		System.setProperty("webdriver.gecko.driver",ExactProjectLocationpath+"/src/main/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/span/span")).click();
		Thread.sleep(2000);
		
		String errormessageActual = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div"
				+ "/div/div[2]/div/div[1]/div/form/span/section/div/span/div[1]/div/div[2]/div[2]/div")).getAttribute("innerHTML");
		System.out.println("errormessageActual"+errormessageActual);
		
		//String expectErrorText = "Enter an email or phone number";
		
		/*//Type 1
		Assert.assertEquals(errormessageActual, expectErrorText);
		System.out.println("Type 1 verified");*/
		
		//Type 2
		Assert.assertTrue(errormessageActual.contains("Enter an email or phone"));
		System.out.println("Type 2 verified");
		Thread.sleep(2000);
		driver.quit();
	}

}
