package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.webDriverUtility;

public class CreateContactPage {
	WebDriver driver;
	public CreateContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="contactName")
	private WebElement contactName;
	
	@FindBy(name="organizationName")
	private WebElement organization;
	
	@FindBy(name="title")
	private WebElement title;
	
	@FindBy(name="mobile")
	WebElement mobile;
	
	@FindBy(xpath="(//*[name()='svg' and @role='img'])[2]")
	WebElement selecCampaignBtn;
	
	@FindBy(id="search-criteria")
	WebElement searchDD;
	
	@FindBy(id="search-input")
	WebElement searchInp;
	

	@FindBy(xpath="//button[@class='select-btn']")
	WebElement selectBtn;
	
	@FindBy(xpath="//button[text()='Create Contact']")
	WebElement createContact;
	
	

	public WebElement getContactName() {
		return contactName;
	}

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getSelecCampaignBtn() {
		return selecCampaignBtn;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchInp() {
		return searchInp;
	}

	public WebElement getSelectBtn() {
		return selectBtn;
	}

	public WebElement getCreateContact() {
		return createContact;
	}
	
	public void createContactWithCampaign(String contact,String org,String titleName,String mob,String childURl,String parentURl,String campName)
	{
		contactName.sendKeys(contact);
		organization.sendKeys(org);
		title.sendKeys(titleName);
		mobile.sendKeys(mob);
		selecCampaignBtn.click();
		webDriverUtility wutil=new webDriverUtility();
		wutil.switchToWindow(driver, childURl);
		wutil.select(searchDD,1);
		searchInp.sendKeys(campName);
		selectBtn.click();
		wutil.switchToWindow(driver, parentURl);
		createContact.click();
		
		}
	}
