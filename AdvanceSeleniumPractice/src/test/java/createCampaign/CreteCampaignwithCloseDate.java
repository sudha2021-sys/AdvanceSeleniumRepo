package createCampaign;

import java.io.FileInputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

import ObjectRepository.CreateCamapaignPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.campaignPage;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;

public class CreteCampaignwithCloseDate {
	public static void main(String[] args) throws InterruptedException, IOException {
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
		
		
		PropertyFileUtility propUtil=new PropertyFileUtility();
		String BROWSER = propUtil.readingDataFromPropFile("browser");
		String URL = propUtil.readingDataFromPropFile("url");
		String UNAME = propUtil.readingDataFromPropFile("uname");
		String PWD = propUtil.readingDataFromPropFile("pwd");
		
	       
	      /* Random ran=new Random();
		    int randomnum = ran.nextInt(1000);*/
	       
	       
	       //using java utility
	       JavaUtility jutil=new JavaUtility();
	       int randomnum = jutil.getRandumNum(2000);
	       
		/*    FileInputStream fis1=new FileInputStream("C:\\Users\\sudha\\eclipse-workspace\\newjavaproject\\src\\sudha\\AdvanceSeleniumPractice\\src\\test\\resources\\BoTestScript.xlsx");
		   	Workbook wb = WorkbookFactory.create(fis1);
		   	String Campaign = wb.getSheet("DDT").getRow(1).getCell(2).getStringCellValue()+randomnum;
		   	System.out.println(Campaign);
		     String targetSize = wb.getSheet("DDT").getRow(1).getCell(3).getStringCellValue();
		    System.out.println(targetSize);
		    */
		    //using generic utility file
		    
		    ExcelFileUtility  exUtil=new ExcelFileUtility();
		    String Campaign = exUtil.readingDatafromExcel("DDT", 1, 2)+randomnum;
		    
		    String targetSize = exUtil.readingDatafromExcel("DDT", 1, 3);
	       
	       
	    /*  Date dateobj=new Date();
	       SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
	       String todayDate = sim.format(dateobj);
	       System.out.println(todayDate);
	       
	       Calendar cal=sim.getCalendar();
	       cal.add(Calendar.DAY_OF_MONTH,10);
	       String closeDate = sim.format(cal.getTime());
	       System.out.println(closeDate);*/
		    
		    String closeDate = jutil.generateReqdate(30);
		    
	       
	      
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
		
		driver.findElement(By.id("username")).sendKeys(UNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PWD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();

		 Thread.sleep(2000);
		
		

		
		
		/*driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(Campaign);
		WebElement targetsize = driver.findElement(By.name("targetSize"));
		targetsize.clear();
		targetsize.sendKeys(targetSize);
		driver.findElement(By.name("expectedCloseDate")).sendKeys(closeDate);
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		*/
		 
		 DashboardPage dp=new DashboardPage(driver);
			dp.getCampaignsLink().click();
	
			
			campaignPage cp=new campaignPage(driver);
			cp.getCreateCampaignBtn().click();
			
			CreateCamapaignPage ccp=new CreateCamapaignPage(driver);
			ccp.createCampaignwithClosedate(Campaign,targetSize,closeDate);
			
		    Thread.sleep(2000);
		    String ConfMsg = cp.getConfmsg().getText();
		    
		//String ConfMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		if(ConfMsg.contains(Campaign))
		{
			System.out.println("campaign added successfully");
		}
		else
		{
			System.out.println("campaign not added");
		}
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='user-icon']")).click();
        WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
        Actions action=new Actions(driver);
        action.moveToElement(logoutBtn).click().perform();
        //close the browser
        driver.quit();
		
		
	
	}

}




