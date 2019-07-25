package ListenersDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenersDemo.TestNGListener.class)
public class myFirstTestCaseWithListener {
	
	WebDriver driver;
	
	@Test
	public void GoogleTitleVarify()
	{
		String projectLocation =	System.getProperty("user.dir");
	     //convert back shlashes to forword slashes
	     String ExactProjectLocationpath =projectLocation.replace("\\", "/");
		System.setProperty("webdriver.gecko.driver",ExactProjectLocationpath+"/src/main/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");
	}

}
