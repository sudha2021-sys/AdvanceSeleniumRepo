package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webDriverUtility {
	public void waitForElementpresent(WebDriver driver,WebElement element,long sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void waitForElementClickable(WebDriver driver,WebElement element,long sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	public void switchToWindow(WebDriver driver,String partialUrl)
	{
		Set<String> allWindowsId = driver.getWindowHandles();
		for(String window:allWindowsId)
		{
			driver.switchTo().window(window);
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains(partialUrl))
			{
				break;
			}
		}
	}
	
		
			public void switchToFrame(WebDriver driver,int index)
			{
				driver.switchTo().frame(index);
			}

			public void switchToFrame(WebDriver driver,String nameId)
			{
				driver.switchTo().frame(nameId);
			}

			public void switchToFrame(WebDriver driver,WebElement element)
			{
				driver.switchTo().frame(element);
			}
			public void select(WebElement element,String value)
			{
				Select sel=new Select(element);
				sel.selectByValue(value);
			}
			public void select(String visibleText,WebElement element)
			{
				Select sel=new Select(element);
				sel.selectByVisibleText(visibleText);
			}
			public void select(WebElement element,int index)
			{
				Select sel=new Select(element);
				sel.selectByIndex(index);
			}
			public void actionmoveToElement(WebDriver driver,WebElement element)
			{
				Actions action=new Actions(driver);
				action.moveToElement(element).perform();
			}
			public void actionDoubleClick(WebDriver driver,WebElement element)
			{
				Actions action=new Actions(driver);
				action.doubleClick(element).perform();
			}
			public void actionRight(WebDriver driver,WebElement element)
			{
				Actions action=new Actions(driver);
				action.contextClick(element).perform();
			}
		public void takingScreenshotWebpage(WebDriver driver,String fileName) throws IOException
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/filename.png/");
		FileHandler.copy(temp,dest);
		}
			
			
}

		
