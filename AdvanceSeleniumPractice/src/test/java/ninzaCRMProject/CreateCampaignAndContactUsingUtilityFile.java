package ninzaCRMProject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ObjectRepository.ContactPage;
import ObjectRepository.CreateCamapaignPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import ObjectRepository.campaignPage;
import genericBaseClassUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.webDriverUtility;

public class CreateCampaignAndContactUsingUtilityFile extends BaseClass {
	
	@Test
	public void createCamapaignUtilityFile() throws InterruptedException, IOException {
		/*PropertyFileUtility propUtil=new PropertyFileUtility();
		String BROWSER = propUtil.readingDataFromPropFile("browser");
		String URL = propUtil.readingDataFromPropFile("url");
		String UNAME = propUtil.readingDataFromPropFile("uname");
		String PWD = propUtil.readingDataFromPropFile("pwd");*/
		
		JavaUtility jutil=new JavaUtility();
	    int randomnum = jutil.getRandumNum(2000);
	    
	    
	    ExcelFileUtility  exUtil=new ExcelFileUtility();
	    String Campaign = exUtil.readingDatafromExcel("DDT", 1, 2)+randomnum;
	    
	    String targetSize = exUtil.readingDatafromExcel("DDT", 1, 3);
	    String organization = exUtil.readingDatafromExcel("Contact", 1, 2)+randomnum;
	    String title = exUtil.readingDatafromExcel("Contact", 1, 3)+randomnum;
	    String contactName = exUtil.readingDatafromExcel("Contact", 1, 4);
	    String mobile = exUtil.readingDatafromExcel("Contact", 1, 5);
	   
	    
	    String closeDate = jutil.generateReqdate(30);
	    
	    
	       
	  
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
		*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.get(URL);
		
		/*LoginPage lp=new LoginPage(driver);
		lp.login(UNAME,PWD);  */

		Thread.sleep(2000);


		DashboardPage dp=new DashboardPage(driver);
		dp.getCampaignsLink().click();

		
		campaignPage cp=new campaignPage(driver);
		cp.getCreateCampaignBtn().click();
		
		CreateCamapaignPage ccp=new CreateCamapaignPage(driver);
		ccp.createCampaignwithClosedate(Campaign,targetSize,closeDate);
		
	    Thread.sleep(2000);
	    String ConfMsg = cp.getConfmsg().getText();
	    
		if(ConfMsg.contains(Campaign))
		{
			Reporter.log("campaign"+Campaign+"added successfully"+true);
		}
		else
		{
			Reporter.log("campaign not added"+true);
		}
		
		
        Thread.sleep(5000);
        dp.getContactsLink().click();
        ContactPage ct=new ContactPage(driver);
        ct.getCreateContactBtn().click();
        CreateContactPage cct=new CreateContactPage(driver);
        cct.createContactWithCampaign(contactName, organization, title, mobile, "selectCampaign", "create-contact",Campaign);
        
		 Thread.sleep(3000);
		 String ConfirmationMsg=ct.getConfmsg().getText();
	      if(ConfirmationMsg.contains(contactName))
		   {
	    	  Reporter.log("Contact added Successfully"+true);
		  }
	    else
		 {
	    	Reporter.log("Contact not added"+true);
		  }
		 Thread.sleep(5000);
		
		//dp.logout();
	     // driver.quit();
		
		

	       
	       
	       
	}

}
