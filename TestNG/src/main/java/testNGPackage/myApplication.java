package testNGPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class myApplication
{
	WebDriver driver;
	
	@BeforeClass
	public void startBrowser()
	{
		
		String projectLocation =	System.getProperty("user.dir");
	     //convert back shlashes to forword slashes
	     String ExactProjectLocationpath =projectLocation.replace("\\", "/");
		System.setProperty("webdriver.gecko.driver",ExactProjectLocationpath+"/src/main/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		System.out.println("Browser is started");
		
	}

	@Test
	public void startApp() throws InterruptedException
	{
		
		driver.get("http://localhost:8080/MavenWebApp/login.xhtml");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("MavenWebApp/login"));
		Thread.sleep(2000);
         		System.out.println("application loaded");
	}
	
	@Test(dependsOnMethods="startApp")
	public void login()
	{
		driver.findElement(By.xpath("//*[@id=\"j_idt2:username\"]")).sendKeys("shubham");
		driver.findElement(By.xpath("//*[@id=\"j_idt2:password\"]")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id=\"j_idt2\"]/input[4]")).click();
	}
	
	@Test(dependsOnMethods="login")
	public void logout() throws InterruptedException
	{
         
		
         /*boolean status = driver.findElement(By.xpath("//*[@id=\"j_idt5\"]/text()")).isDisplayed();
		Assert.assertTrue(status);*/
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("MavenWebApp/home"));
		String userName=driver.findElement(By.xpath("//*[@id=\"userName\"]")).getText();
		System.out.println("userName  "+userName);
		Assert.assertTrue(userName.equalsIgnoreCase("shubham"));
		System.out.println("Login successful");
		Thread.sleep(10000);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("Browser Closed");
	}
	
	
	
}
