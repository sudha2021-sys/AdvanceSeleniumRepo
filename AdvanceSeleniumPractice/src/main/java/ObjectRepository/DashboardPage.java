package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	    
	    WebDriver driver;
	    public DashboardPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		public WebDriver getDriver() {
			return driver;
		}

		
	@FindBy(linkText="Campaigns")
	WebElement campaignsLink;
	
	@FindBy(linkText="Contacts")
	WebElement contactsLink;
	
	@FindBy(linkText="Products")
	WebElement productLink;
	
	
	@FindBy(xpath="//*[name()='svg' and  @role='img']")
	WebElement profileIcon;
	
	@FindBy(xpath="//div[text()='Logout ']")
	WebElement logoutBtn;
	
	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public void logout()
	{
		profileIcon.click();
		Actions action=new Actions(driver);
		action.moveToElement(logoutBtn).click();
	}
	

}
