package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.webDriverUtility;

public class CreateproductPage {

	WebDriver driver;
	public CreateproductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="productId")
	WebElement productId;
	
	@FindBy(name="productName")
	WebElement productName;
	
	@FindBy(name="quantity")
	WebElement quantity;
	
	@FindBy(name="price")
	WebElement price;
	
	@FindBy(name="productCategory")
	WebElement productCategory;
	
	@FindBy(name="vendorId")
	WebElement vendorId;
	
	@FindBy(xpath="//button[text()='Add']")
	WebElement addBtn;
	
	

	public WebElement getProductId() {
		return productId;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getProductCategory() {
		return productCategory;
	}

	public WebElement getVendorId() {
		return vendorId;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}
	
	public void createProduct(String proid,String proName,String qnty,String priceUnit, String procategory,String vendorid)
	{
		productId.sendKeys(proid);
		productName.sendKeys(proName);
		quantity.clear();
		quantity.sendKeys(qnty);
		price.clear();
		price.sendKeys(priceUnit);
		webDriverUtility wutil=new webDriverUtility();
        wutil.select(productCategory, 2);
		wutil.select(vendorId, 3);
		addBtn.click();
		
	}
	
	
	
}
