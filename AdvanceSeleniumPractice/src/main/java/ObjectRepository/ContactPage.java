package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	WebDriver driver;
	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	


	
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement searchBarDD;

	@FindBy(xpath="//input[@placeholder='Search by Contact Id']")
	private WebElement contactSearchBar;
	

	@FindBy(xpath="//span[text()='Create Contact']")
	private WebElement createContactBtn;
	
	 @FindBy(xpath="//div[@role='alert']")
	  private WebElement confmsg;
	  
	

	public WebElement getConfmsg() {
		return confmsg;
	}


	


	public WebDriver getDriver() {
		return driver;
	}





public WebElement getSearchBarDD() {
		return searchBarDD;
	}


	public WebElement getContactSearchBar() {
		return contactSearchBar;
	}


	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}
	
	

}
