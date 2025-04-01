package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//select[@class='form-control'")
	WebElement searchBarDD;

	@FindBy(xpath="//input[@type='text' and @placeholder='Search by product Id' ]")
	WebElement productSearch;
	
	@FindBy(xpath="//span[text()='Add Product']")
	WebElement productBtn;
	

	public WebElement getSearchBarDD() {
		return searchBarDD;
	}

	public WebElement getProductSearch() {
		return productSearch;
	}

	public WebElement getProductBtn() {
		return productBtn;
	}
	

}
