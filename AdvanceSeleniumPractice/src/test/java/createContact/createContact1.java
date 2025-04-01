package createContact;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ObjectRepository.ContactPage;
import ObjectRepository.CreateCamapaignPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.campaignPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListnerImplement;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.webDriverUtility;
  


// @Listeners(ListnerImplement.class)

public class createContact1 extends BaseClass
{
	@Test
	public void createContactWithCampaignTest() throws InterruptedException, IOException {
	
	JavaUtility jutil=new JavaUtility();
    int randomnum = jutil.getRandumNum(5000);
	
    ExcelFileUtility  exUtil=new ExcelFileUtility();
    String Campaign = exUtil.readingDatafromExcel("DDT", 1, 2)+randomnum;
    
    String targetSize = exUtil.readingDatafromExcel("DDT", 1, 3);
    String organization = exUtil.readingDatafromExcel("Contact", 1, 2)+randomnum;
    String title = exUtil.readingDatafromExcel("Contact", 1, 3)+randomnum;
    String contactName = exUtil.readingDatafromExcel("Contact", 1, 4);
    String mobile = exUtil.readingDatafromExcel("Contact", 1, 5);
    String closeDate = jutil.generateReqdate(30);
    
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	
	
	DashboardPage dp=new DashboardPage(driver);
	dp.getCampaignsLink().click();

	
	campaignPage cp=new campaignPage(driver);
	cp.getCreateCampaignBtn().click();
	
	CreateCamapaignPage ccp=new CreateCamapaignPage(driver);
	ccp.createCampaignwithClosedate(Campaign,targetSize,closeDate);
	
  
	Thread.sleep(3000);
	
	WebElement contactLink = dp.getContactsLink();
	webDriverUtility wutil=new webDriverUtility();
	wutil.waitForElementClickable(driver, contactLink,20);
	contactLink.click();
	
	Thread.sleep(5000);
	ContactPage ccp1=new ContactPage(driver);
	WebElement createContactBtn = ccp1.getCreateContactBtn();
	wutil.waitForElementClickable(driver, createContactBtn,20);
	createContactBtn.click();
	
	CreateContactPage cct=new CreateContactPage(driver);
	cct.createContactWithCampaign(organization, title, contactName, mobile, "selectCampaign", "create-contact", Campaign);
	
	 Thread.sleep(3000);
   String ConfirmationMsg = ccp1.getConfmsg().getText();
   boolean status = ConfirmationMsg.contains(contactName);
   Assert.assertTrue(status);
   Thread.sleep(3000);
  
}
}


	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	//@Parameters("browser")
	@Test                           //(groups= {"SmokeTest"})
	public void createContactWithCampaignTest() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		/*FileInputStream fis=new FileInputStream("C:\\Users\\sudha\\eclipse-workspace\\newjavaproject\\src\\sudha\\AdvanceSeleniumPractice\\src\\test\\resources\\commonData.properties");
	       Properties prop=new Properties();
	       prop.load(fis);
	       String BROWSER = prop.getProperty("browser");
	       String URL = prop.getProperty("url");
	       String UNAME = prop.getProperty("uname");
	       String PWD = prop.getProperty("pwd");
	       System.out.println(BROWSER);
	       System.out.println(URL);
	       System.out.println(UNAME);
	       System.out.println(PWD);*/
		/*PropertyFileUtility propUtil=new PropertyFileUtility();
		String BROWSER = propUtil.readingDataFromPropFile("browser");
		
		String URL = propUtil.readingDataFromPropFile("url");
		String UNAME = propUtil.readingDataFromPropFile("uname");
		String PWD = propUtil.readingDataFromPropFile("pwd");*/
		
	       
	      /* Random ran=new Random();
		    int randomnum = ran.nextInt(1000);
		    
		
		JavaUtility jutil=new JavaUtility();
	       int randomnum = jutil.getRandumNum(5000);
	       
		   // FileInputStream fis1=new FileInputStream("C:\\Users\\sudha\\eclipse-workspace\\newjavaproject\\src\\sudha\\AdvanceSeleniumPractice\\src\\test\\resources\\BoTestScript.xlsx");
		   	//Workbook wb = WorkbookFactory.create(fis1);
		   	
		   	
			/*String Campaign = wb.getSheet("DDT").getRow(1).getCell(2).getStringCellValue()+randomnum;
		   	System.out.println(Campaign);
		     String targetSize = wb.getSheet("DDT").getRow(1).getCell(3).getStringCellValue();
		    System.out.println(targetSize);
		    String organization = wb.getSheet("Contact").getRow(1).getCell(2).getStringCellValue()+randomnum;
		   	System.out.println(organization);
		   	String title = wb.getSheet("Contact").getRow(1).getCell(3).getStringCellValue()+randomnum;
		   	System.out.println(title);
		   	String contactName = wb.getSheet("Contact").getRow(1).getCell(4).getStringCellValue()+randomnum;
		   	System.out.println(contactName);
		   	String mobile = wb.getSheet("Contact").getRow(1).getCell(5).getStringCellValue()+randomnum;
		   	System.out.println(mobile);
		   	
		   	          //else
		   	//using generic utility
		   	
		    
		    ExcelFileUtility  exUtil=new ExcelFileUtility();
		    String Campaign = exUtil.readingDatafromExcel("DDT", 1, 2)+randomnum;
		    
		    String targetSize = exUtil.readingDatafromExcel("DDT", 1, 3);
		    String organization = exUtil.readingDatafromExcel("Contact", 1, 2)+randomnum;
		    String title = exUtil.readingDatafromExcel("Contact", 1, 3)+randomnum;
		    String contactName = exUtil.readingDatafromExcel("Contact", 1, 4);
		    String mobile = exUtil.readingDatafromExcel("Contact", 1, 5);
		   
		    
		    
	       
		    
		    
	       
	    /*  Date dateobj=new Date();
	       SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
	       String todayDate = sim.format(dateobj);
	       System.out.println(todayDate);
	       
	       Calendar cal=sim.getCalendar();
	       cal.add(Calendar.DAY_OF_MONTH,10);
	       String closeDate = sim.format(cal.getTime());
	       System.out.println(closeDate);  
		    
		    String closeDate = jutil.generateReqdate(30);
	       
	       
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
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		/*driver.get(URL);
		
		driver.findElement(By.id("username")).sendKeys(UNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PWD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();

		 Thread.sleep(2000);
		String actualRes = driver.getCurrentUrl();
		if(actualRes.equals(expectedResult))
		{
			System.out.println("validation is pass");
			
			
			
		}
		else
		{
			
			System.out.println("fail");
		}

		

		
		
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(Campaign);
		WebElement targetsize = driver.findElement(By.name("targetSize"));
		targetsize.clear();
		targetsize.sendKeys(targetSize);
		driver.findElement(By.name("expectedCloseDate")).sendKeys(closeDate);
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		Thread.sleep(5000);
		String ConfMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		boolean status = ConfMsg.contains(Campaign);
		Assert.assertEquals(status, true,"camapign not added");
		Reporter.log("Campaign"+Campaign+"added successfully",true);

		/*if(ConfMsg.contains(Campaign))
		{
			Reporter.log("campaign added successfully");
		}
		else
		{
			Reporter.log("campaign not added");
		}
		
		Thread.sleep(5000);
		
		
		WebElement contactLink = driver.findElement(By.linkText("Contacts"));
		webDriverUtility wutil=new webDriverUtility();
		wutil.waitForElementClickable(driver,contactLink,20);
		contactLink.click();
		driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		driver.findElement(By.name("contactName")).sendKeys(contactName);
        driver.findElement(By.name("organizationName")).sendKeys(organization);
		driver.findElement(By.name("title")).sendKeys(title);
		driver.findElement(By.name("mobile")).sendKeys(mobile);
		driver.findElement(By.xpath("//button[@style='white-space: nowrap; margin: 5px 10px 16px 0px; padding: 8px; background-color: green; font-size: 12px; display: flex; align-items: center; justify-content: center;']")).click();
		//String parentWindow = driver.getWindowHandle();
		
/*		 Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {
		     {
		        driver.switchTo().window(window); 
		     
			String actURL = driver.getCurrentUrl();
			if(actURL.contains("selectCampaign"))
			{
				break;
			}
		       
		    }
		}
		
		
		wutil.switchToWindow(driver,"selectCampaign");

		  WebElement selectTypeDD = driver.findElement(By.id("search-criteria"));
		 /* Select select1=new Select(selectTypeDD);
		  select1.selectByVisibleText("Campaign Name");
		  wutil.select("Campaign Name", selectTypeDD);
		  
		driver.findElement(By.id("search-input")).sendKeys(Campaign);
		 driver.findElement(By.xpath("//button[@class='select-btn']")).click();

        /* for(String Window:allWindows)
 		{
 			driver.switchTo().window(Window);
 			String actUrl = driver.getCurrentUrl();
 			if(actUrl.contains("create-contact"))
 			{
 				break;
 			}
 		}
         
		 
		 wutil.switchToWindow(driver, "create-contact");
         
        driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
          Thread.sleep(3000);
	       String ConfirmationMsg = driver.findElement(By.xpath("//div[text()='Contact "+contactName+" Successfully Added']")).getText();
	       boolean status1 = ConfirmationMsg.contains(contactName);
			Assert.assertEquals(status, true,"contact not added");
			Reporter.log("contact"+contactName+"added successfully",true);

	       
	       /* if(ConfirmationMsg.contains(contactName))
	        
	        
	        {
	        	Reporter.log("Contact added Successfully"+true);
	        }
	        else
	        {
	        	Reporter.log("Contact not added"+true);
	        }*/
	    /*   Thread.sleep(5000);
	       driver.findElement(By.xpath("//*[name()='svg' and @role=\"img\"]")).click();
	       WebElement logout = driver.findElement(By.xpath("//div[text()='Logout ']"));
	       /*Actions action=new Actions(driver);
	       action.moveToElement(logout).click().perform();
	       wutil.actionmoveToElement(driver, logout);
	       driver.quit();
		}
}*/