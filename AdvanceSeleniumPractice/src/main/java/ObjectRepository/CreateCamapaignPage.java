package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCamapaignPage {
	
	WebDriver driver;
	public CreateCamapaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="campaignName")
	private WebElement campaignNameTextfield;

	@FindBy(name="campaignStatus")
	private WebElement campaignStatusTextfield;

	@FindBy(name="targetSize")
	private WebElement targetSizeTextfield;

	
	@FindBy(name="expectedCloseDate")
	private WebElement expectedCloseDateTextfield;

	@FindBy(name="targetAudience")
	private WebElement targetAudienceTextfield;
	

	@FindBy(name="description")
	private WebElement descriptionTextfield;
	

	@FindBy(xpath="//button[text()='Create Campaign']")
	private WebElement createCampaignButton;
	


	public WebElement getCampaignNameTextfield() {
		return campaignNameTextfield;
	}


	public WebElement getCampaignStatusTextfield() {
		return campaignStatusTextfield;
	}


	public WebElement getTargetSizeTextfield() {
		return targetSizeTextfield;
	}


	public WebElement getExpectedCloseDateTextfield() {
		return expectedCloseDateTextfield;
	}


	public WebElement getTargetAudienceTextfield() {
		return targetAudienceTextfield;
	}


	public WebElement getDescriptionTextfield() {
		return descriptionTextfield;
	}


	public WebElement getCreateCampaignButton() {
		return createCampaignButton;
	}
	
	public void createCampaignwithMandatoryField(String campName,String target)
	{
		campaignNameTextfield.sendKeys(campName);
		targetSizeTextfield.clear();
		targetSizeTextfield.sendKeys(target);
		createCampaignButton.click();
		
	}
	
	public void createCampaignwithClosedate(String campName,String target,String date)
	{
		campaignNameTextfield.sendKeys(campName);
		targetSizeTextfield.clear();
		targetSizeTextfield.sendKeys(target);
		expectedCloseDateTextfield.sendKeys(date);
		createCampaignButton.click();
		
	}
	
	

}
