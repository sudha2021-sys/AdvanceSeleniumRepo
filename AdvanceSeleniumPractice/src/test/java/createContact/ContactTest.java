package createContact;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericBaseClassUtility.BaseClass;

public class ContactTest extends BaseClass {
		
		public static void main(String[] args) throws IOException, InterruptedException {
			FileInputStream fis=new FileInputStream("C:\\Users\\sudha\\eclipse-workspace\\newjavaproject\\src\\sudha\\AdvanceSeleniumPractice\\src\\test\\resources\\commonData.properties");
	       Properties prop=new Properties();
	       prop.load(fis);
	       String BROWSER = prop.getProperty("browser");
	       String URL = prop.getProperty("url");
	       String UNAME = prop.getProperty("uname");
	       String PWD = prop.getProperty("pwd");
	       System.out.println(BROWSER);
	       System.out.println(URL);
	       System.out.println(UNAME);
	       System.out.println(PWD);
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
		
		driver.findElement(By.id("username")).sendKeys(UNAME);
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
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
driver.findElement(By.linkText("Contacts")).click();
driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
driver.findElement(By.name("contactName")).sendKeys("sudha");
driver.findElement(By.name("organizationName")).sendKeys("qspider");
driver.findElement(By.name("title")).sendKeys("advertisement");
driver.findElement(By.name("mobile")).sendKeys("909876545");
driver.findElement(By.xpath("//button[@style='white-space: nowrap; margin: 5px 10px 16px 0px; padding: 8px; background-color: green; font-size: 12px; display: flex; align-items: center; justify-content: center;']")).click();




driver.findElement(By.xpath("//button[text()='Create Contact']"));
	}
		
	}
