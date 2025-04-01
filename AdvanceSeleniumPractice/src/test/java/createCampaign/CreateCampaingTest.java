package createCampaign;

import java.io.IOException;

import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ObjectRepository.CreateCamapaignPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import ObjectRepository.campaignPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListnerImplement;

import java.io.FileInputStream;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.webDriverUtility;

 @Listeners(ListnerImplement.class)
public class CreateCampaingTest extends BaseClass{

@Test                     
public void createCampaignTest() throws InterruptedException, IOException {
	JavaUtility jutil=new JavaUtility();
    int randomnum = jutil.getRandumNum(5000);
    
     ExcelFileUtility  exUtil=new ExcelFileUtility();
    String Campaign = exUtil.readingDatafromExcel("DDT", 1, 2)+randomnum;
    
    String targetSize = exUtil.readingDatafromExcel("DDT", 1, 3);
    String expectedResult="http://49.249.28.218:8098/dashboard";
	//Launching the browser
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	DashboardPage dp=new DashboardPage(driver);
	Thread.sleep(2000);
	dp.getCampaignsLink().click();
	campaignPage cp=new campaignPage(driver);
	cp.getCreateCampaignBtn().click();

	CreateCamapaignPage ccp=new CreateCamapaignPage(driver);
	ccp.createCampaignwithMandatoryField(Campaign,targetSize);
	
	Thread.sleep(5000);
	String ConfMsg = cp.getConfmsg().getText();
	boolean status = ConfMsg.contains(Campaign);
	Assert.assertEquals(status, true, "campaign not added");
	//Assert.assertTrue(status, "Campaign not added");
	Reporter.log("Campaign "+Campaign+" added successfully",true);
	Thread.sleep(5000);
	
	

}


//@Parameters("browser")
@Test()
public void createCampaignWithDateTest() throws InterruptedException, IOException
{
	
	JavaUtility jutil=new JavaUtility();
    int randomnum = jutil.getRandumNum(5000);
    
     ExcelFileUtility  exUtil=new ExcelFileUtility();
    String Campaign = exUtil.readingDatafromExcel("DDT", 1, 2)+randomnum;
    
    String targetSize = exUtil.readingDatafromExcel("DDT", 1, 3);
    String expectedResult="http://49.249.28.218:8098/dashboard";
	
	String closeDate = jutil.generateReqdate(30);
	
	String expectedURL="http://49.249.28.218:8098/dashboard";
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	DashboardPage dp=new DashboardPage(driver);
	Thread.sleep(2000);
	dp.getCampaignsLink().click();

	campaignPage cp=new campaignPage(driver);
	cp.getCreateCampaignBtn().click();
	
	CreateCamapaignPage ccp=new CreateCamapaignPage(driver);
	ccp.createCampaignwithClosedate(Campaign,targetSize,closeDate);
	Thread.sleep(5000);
	String ConfMsg = cp.getConfmsg().getText();
	boolean status = ConfMsg.contains(Campaign);
	Assert.assertEquals(status, true, "Campaign not added");
	//Assert.assertTrue(status, "Campaign not added");
    Reporter.log("campaign "+Campaign+" added successfully",true);
	Thread.sleep(5000);
	
}
}






     /*           @Listeners(ListnerImplement.class)
public class CreateCampaingTest extends BaseClass{
  
	@Test                      (groups= {"integration"},priority = 1)  //   invocationCount = 5,threadPoolSize = 3)
	public void createCampaignTest() throws InterruptedException, IOException {
		
		PropertyFileUtility propUtil=new PropertyFileUtility();
		String BROWSER = propUtil.readingDataFromPropFile("browser");
		
		String URL = propUtil.readingDataFromPropFile("url");
		String UNAME = propUtil.readingDataFromPropFile("uname");
		String PWD = propUtil.readingDataFromPropFile("pwd");
		
	       
		    Random ran=new Random();
		    int randomnum = ran.nextInt(1000);
		    
		JavaUtility jutil=new JavaUtility();
	       int randomnum = jutil.getRandumNum(5000);
	       
		    
		    ExcelFileUtility  exUtil=new ExcelFileUtility();
		    String Campaign = exUtil.readingDatafromExcel("DDT", 1, 2)+randomnum;
		    
		    String targetSize = exUtil.readingDatafromExcel("DDT", 1, 3);
	        String expectedResult="http://49.249.28.218:8098/dashboard";
		 WebDriver driver=null;
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
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		 
		//LoginPage lp=new LoginPage(driver);
		//lp.login(UNAME, PWD);
		
		/*driver.findElement(By.id("username")).sendKeys(UNAME);
		driver.findElement(By.id("inputPassword")).clear();
		driver.findElement(By.id("inputPassword")).sendKeys(PWD);
		//driver.findElement(By.xpath("//button[text()='Sign In']")).click();

		DashboardPage dp=new DashboardPage(driver);
		dp.getCampaignsLink().click();
		//driver.findElement(By.linkText("Campaigns")).click();
		
		campaignPage cp=new campaignPage(driver);
		cp.getCreateCampaignBtn().click();
		
		CreateCamapaignPage ccp=new CreateCamapaignPage(driver);
		ccp.createCampaignwithMandatoryField(Campaign,targetSize);
		/*driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
	  driver.findElement(By.name("campaignName")).sendKeys(Campaign);
	
	  WebElement targetsize = driver.findElement(By.name("targetSize"));
		targetsize.clear();
		targetsize.sendKeys(targetSize);
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		Thread.sleep(2000);
		
		String ConfMsg = cp.getConfmsg().getText();
		boolean status = ConfMsg.contains(Campaign);
		Assert.assertEquals(status, true,"camapign not added");
		Reporter.log("Campaign"+Campaign+"added successfully",true);

		
		
		
		
		//String ConfMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		/*if(ConfMsg.contains(Campaign))
		{
			System.out.println("campaign"+Campaign+" added successfully");
		}
		else
		{
			System.out.println("campaign not added");
		}
		Thread.sleep(4000);
		
		
		//dp.logout();
		//driver.findElement(By.xpath("//div[@class='user-icon']")).click();
       // WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
      /* Actions action=new Actions(driver);
        action.moveToElement(logoutBtn).click().perform();
        
       // webDriverUtility wutil=new webDriverUtility();
       // wutil.actionmoveToElement(driver, logoutBtn);
        
        
        //close the browser
       // driver.quit();
		
		
	
	}
	
	/*@Test()                             //(groups= {"SmokeTest"},priority = 2,invocationCount = 0)
	public void createCampaignDateTest() throws IOException, InterruptedException
	{
	
	/*PropertyFileUtility propUtil=new PropertyFileUtility();
	String BROWSER = propUtil.readingDataFromPropFile("browser");
	
	String URL = propUtil.readingDataFromPropFile("url");
	String UNAME = propUtil.readingDataFromPropFile("uname");
	String PWD = propUtil.readingDataFromPropFile("pwd");
	*/
       
      /* Random ran=new Random();
	    int randomnum = ran.nextInt(1000);
       
       
       //using java utility
       JavaUtility jutil=new JavaUtility();
       int randomnum = jutil.getRandumNum(5000);
       
	/*    FileInputStream fis1=new FileInputStream("C:\\Users\\sudha\\eclipse-workspace\\newjavaproject\\src\\sudha\\AdvanceSeleniumPractice\\src\\test\\resources\\BoTestScript.xlsx");
	   	Workbook wb = WorkbookFactory.create(fis1);
	   	String Campaign = wb.getSheet("DDT").getRow(1).getCell(2).getStringCellValue()+randomnum;
	   	System.out.println(Campaign);
	     String targetSize = wb.getSheet("DDT").getRow(1).getCell(3).getStringCellValue();
	    System.out.println(targetSize);
	    
	    //using generic utility file
	    
	    ExcelFileUtility  exUtil=new ExcelFileUtility();
	    String Campaign = exUtil.readingDatafromExcel("DDT", 1, 2)+randomnum;
	    
	    String targetSize = exUtil.readingDatafromExcel("DDT", 1, 3);
       */
       
    /*  Date dateobj=new Date();
       SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
       String todayDate = sim.format(dateobj);
       System.out.println(todayDate);
       
       Calendar cal=sim.getCalendar();
       cal.add(Calendar.DAY_OF_MONTH,10);
       String closeDate = sim.format(cal.getTime());
       System.out.println(closeDate);*/
	    
	   // String closeDate = jutil.generateReqdate(30);
	    
       
      
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
	
	
	//driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//driver.get(URL);
	
	//driver.findElement(By.id("username")).sendKeys(UNAME);
	//driver.findElement(By.id("inputPassword")).sendKeys(PWD);
	//driver.findElement(By.xpath("//button[text()='Sign In']")).click();

	// Thread.sleep(2000);
	
	

	
	
	/*driver.findElement(By.linkText("Campaigns")).click();
	driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
	driver.findElement(By.name("campaignName")).sendKeys(Campaign);
	WebElement targetsize = driver.findElement(By.name("targetSize"));
	targetsize.clear();
	targetsize.sendKeys(targetSize);
	driver.findElement(By.name("expectedCloseDate")).sendKeys(closeDate);
	driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
	*/
	 
	/* DashboardPage dp=new DashboardPage(driver);
		dp.getCampaignsLink().click();

		
		campaignPage cp=new campaignPage(driver);
		cp.getCreateCampaignBtn().click();
		
		CreateCamapaignPage ccp=new CreateCamapaignPage(driver);
		ccp.createCampaignwithClosedate(Campaign,targetSize,closeDate);
		
	    Thread.sleep(2000);
	    String ConfMsg = cp.getConfmsg().getText();
	    boolean status = ConfMsg.contains(Campaign);
		Assert.assertEquals(status, true,"camapign not added");
		Reporter.log("Campaign"+Campaign+"added successfully",true);*/

	    
	//String ConfMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
	/*if(ConfMsg.contains(Campaign))
	{
		Reporter.log("campaign added successfully"+true);
	}
	else
	{
		Reporter.log("campaign not added"+true);
	}
	//Thread.sleep(2000);
	/*driver.findElement(By.xpath("//div[@class='user-icon']")).click();
    WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
    Actions action=new Actions(driver);
    action.moveToElement(logoutBtn).click().perform();
    //close the browser
    driver.quit();*/
	
	







