package login;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListnerImplement;
import genericUtility.PropertyFileUtility;
import genericUtility.webDriverUtility;

   // @Listeners(ListnerImplement.class)
public class Login_Test extends BaseClass
{

	//@Parameters("browser")
	@Test                     //(groups= {"Regression"})
	public void loginTest() throws IOException, InterruptedException {
		
		
		/*PropertyFileUtility propUtil=new PropertyFileUtility();
		String BROWSER = propUtil.readingDataFromPropFile("browser");
		//String BROWSER=browser;
		String URL = propUtil.readingDataFromPropFile("url");
		String UNAME = propUtil.readingDataFromPropFile("uname");
		String PWD = propUtil.readingDataFromPropFile("pwd");*/
		
       String expectedResult="http://49.249.28.218:8098/dashboard";
	/*WebDriver driver=null;
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
		
	}
	else if (BROWSER.equalsIgnoreCase("firefox")) 
	{
		driver=new FirefoxDriver();
		
	}
	else if (BROWSER.equalsIgnoreCase("edge")) 
	{
		driver=new EdgeDriver();
		
	}
	else
		
	{
		driver=new ChromeDriver();
	}*/
	
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//driver.get(URL);
	
	/*driver.findElement(By.id("username")).sendKeys(UNAME);
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[text()='Sign In']")).click();
    */
	
	/*LoginPage lp=new LoginPage(driver);
	lp.login(UNAME,PWD);
	 Thread.sleep(2000);
	String actualRes = driver.getCurrentUrl();
	
	Assert.assertEquals(actualRes, expectedResult,"validation is failed");
	Reporter.log("validation pass"+true);
	
	/*if(actualRes.equals(expectedResult))
	{
		Reporter.log("validation is pass"+true);
		
		
		
	}
	else
	{
		
		Reporter.log("fail"+true);
	}*/
	

	//DashboardPage dp=new DashboardPage(driver);
	//dp.logout();
	
	/*driver.findElement(By.xpath("//*[name()='svg' and @role=\"img\"]")).click();
    WebElement logout = driver.findElement(By.xpath("//div[text()='Logout ']"));
	webDriverUtility wutil=new webDriverUtility();
	wutil.actionmoveToElement(driver, logout);*/
     // driver.quit();

}
}
