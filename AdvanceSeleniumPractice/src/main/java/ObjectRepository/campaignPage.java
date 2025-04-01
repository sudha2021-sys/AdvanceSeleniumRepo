package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class campaignPage {
	
	WebDriver driver;
	public campaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement SearchByDD;
	
  

  @FindBy(xpath="//input[@type='text']")
   private WebElement campaignNameSearchbar;

   @FindBy(xpath="//span[text()='Create Campaign']")
  private WebElement createCampaignBtn;

  @FindBy(xpath="//div[@role='alert']")
  private WebElement confmsg;
  
      WebElement getSearchByDD() {
		return SearchByDD;
	}

	public WebElement getCampaignNameSearchbar() {
		return campaignNameSearchbar;
	}

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getConfmsg() {
		return confmsg;
	}



}
