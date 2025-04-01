package genericBaseClassUtility;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import genericUtility.DataBaseUtility;
import genericUtility.PropertyFileUtility;

public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sdriver;
	
	DataBaseUtility dutil=new DataBaseUtility();
	PropertyFileUtility propUtil=new PropertyFileUtility();
	
@BeforeSuite
	public void beforesuite()
	{
		System.out.println("establish database connection");
		dutil.getDBConnection("jdbc:mysql://localhost:3306/Ninza_pro","root","tiger");
		
		
	}

@BeforeTest
public void beforeTest()
{
	System.out.println("pre configure set up");
}
@BeforeClass
public void beforeClass() throws IOException
{
	System.out.println("launch the browser");
	String BROWSER = propUtil.readingDataFromPropFile("browser");
	
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
	}
	
sdriver=driver;
}
@BeforeMethod
public void beforeMethod() throws IOException
{
	System.out.println("login");
	
	String URL = propUtil.readingDataFromPropFile("url");
	String UNAME = propUtil.readingDataFromPropFile("uname");
	String PWD = propUtil.readingDataFromPropFile("pwd");
	driver.get(URL);
	LoginPage lp=new LoginPage(driver);
	lp.login(UNAME,PWD);
}

@AfterMethod
public void afterMethod()
{
	System.out.println("logout");
	DashboardPage dp=new DashboardPage(driver);
	dp.logout();
}
@AfterClass
public void afterClass()
{
	System.out.println("close the browser");
	driver.quit();
}
@AfterTest
public void afterTest()
{
	System.out.println("post config set up");
}
@AfterSuite
public void afterSuite()
{
	System.out.println("close the db connection");
	dutil.closeDBConnection();
}
}
