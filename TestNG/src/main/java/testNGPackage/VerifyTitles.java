package testNGPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTitles 
{
	WebDriver driver;
	@Test
	public void verifyApplicationTitle()
	{
		//Firefox browser
	     String projectLocation =	System.getProperty("user.dir");
	     //convert back shlashes to forword slashes
	     String ExactProjectLocationpath =projectLocation.replace("\\", "/");
		System.setProperty("webdriver.gecko.driver",ExactProjectLocationpath+"/src/main/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	/*	title =Mozilla Discourse*/
		driver .get("https://discourse.mozilla.org/");
		/*String myTitle = driver.getTitle();
		System.out.println("This is my Title  "+myTitle);
		String expectedTitle = "Mozilla Discourse";
		Assert.assertEquals(expectedTitle, myTitle);*/
		boolean pageSource = driver.getPageSource().contains("Mozilla Discourse");
		Assert.assertTrue(pageSource);
		
		
	}

}
