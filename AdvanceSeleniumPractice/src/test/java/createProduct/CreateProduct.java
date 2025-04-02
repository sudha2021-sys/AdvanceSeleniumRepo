package createProduct;

import java.io.FileInputStream;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ObjectRepository.CreateproductPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListnerImplement;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.webDriverUtility;
//@Listeners(ListnerImplement.class)
public class CreateProduct extends BaseClass

{
	//@Parameters("browser")
	@Test                               //(groups= {"Regression"})
	public void addProductTest() throws InterruptedException, IOException {
		
		JavaUtility jutil=new JavaUtility();
	    int randomnum = jutil.getRandumNum(2000);
	    
		ExcelFileUtility exutil=new ExcelFileUtility();
	   	String ProductID = exutil.readingDatafromExcel("Product", 1, 2)+randomnum;
	   	String ProductName = exutil.readingDatafromExcel("Product", 1, 3)+randomnum;
	  	String Quantity = exutil.readingDatafromExcel("Product", 1, 4);
	  	String Price = exutil.readingDatafromExcel("Product", 1, 5);
	  	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		    
		 Thread.sleep(2000);
			
		 DashboardPage dp=new DashboardPage(driver);
		dp.getProductLink().click();
		ProductPage pp=new ProductPage(driver);
		pp.getProductBtn().click();
		CreateproductPage cpp=new CreateproductPage(driver);
		cpp.getAddBtn().click();
		
		
		cpp.createProduct(ProductName,ProductID, Quantity, Price, "proCatagory", "vendorid");
		
       Thread.sleep(5000);
     String ConfMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        boolean status = ConfMsg.contains(ProductID);
		Assert.assertEquals(status, true,"product not added");
		Reporter.log("product"+ProductID+"added successfully",true);
		   
}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		/*
		PropertyFileUtility propUtil=new PropertyFileUtility();
		String BROWSER = propUtil.readingDataFromPropFile("browser");
	
		String URL = propUtil.readingDataFromPropFile("url");
		String UNAME = propUtil.readingDataFromPropFile("uname");
		String PWD = propUtil.readingDataFromPropFile("pwd");
		

		
		JavaUtility jutil=new JavaUtility();
	    int randomnum = jutil.getRandumNum(2000);
		    
		  /*  FileInputStream fis1=new FileInputStream("C:\\Users\\sudha\\eclipse-workspace\\newjavaproject\\src\\sudha\\AdvanceSeleniumPractice\\src\\test\\resources\\BoTestScript.xlsx");
		   	Workbook wb = WorkbookFactory.create(fis1);
			String ProductID = wb.getSheet("Product").getRow(1).getCell(2).getStringCellValue()+randomnum;
		   	System.out.println(ProductID);
		   	String ProductName = wb.getSheet("Product").getRow(1).getCell(3).getStringCellValue()+randomnum;
		   	System.out.println(ProductName);
		   	String Quantity = wb.getSheet("Product").getRow(1).getCell(4).getStringCellValue();
		   	System.out.println(Quantity);
		   	String Price = wb.getSheet("Product").getRow(1).getCell(5).getStringCellValue();
		   	System.out.println(Price);
		   	
		   	ExcelFileUtility exutil=new ExcelFileUtility();
		   	String ProductID = exutil.readingDatafromExcel("Product", 1, 2)+randomnum;
		   	String ProductName = exutil.readingDatafromExcel("Product", 1, 3)+randomnum;
		  	String Quantity = exutil.readingDatafromExcel("Product", 1, 4);
		  	String Price = exutil.readingDatafromExcel("Product", 1, 5);

		   	
		  /* 	WebDriver driver=null;
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
			//driver.get(URL);
	        //LoginPage lp=new LoginPage(driver);
	         //lp.login(UNAME, PWD);
			
			
			
			 Thread.sleep(2000);
			
			 DashboardPage dp=new DashboardPage(driver);
			dp.getProductLink().click();
			ProductPage pp=new ProductPage(driver);
			pp.getProductBtn().click();
			CreateproductPage cpp=new CreateproductPage(driver);
			cpp.getAddBtn().click();
			
			
			cpp.createProduct(ProductName,ProductID, Quantity, Price, "proCatagory", "vendorid");
			
           Thread.sleep(5000);
	     String ConfMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
	        boolean status = ConfMsg.contains(ProductID);
			Assert.assertEquals(status, true,"product not added");
			Reporter.log("product"+ProductID+"added successfully",true);

          
			/*if(ConfMsg.contains(ProductID))
			{
				Reporter.log("product added successfully"+true);
			}
			else
			{
				Reporter.log("product not added"+true);
			}
			//Thread.sleep(5000);
			//dp.logout();
		     
		      // driver.quit();
	      
	
	
		   
}
}*/
