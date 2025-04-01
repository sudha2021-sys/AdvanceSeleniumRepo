package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="username")
	WebElement usernameField;
	
	@FindBy(id="inputPassword")
	WebElement passwordField;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement loginbtn;
	@FindBy(linkText="Forgot password?")
	WebElement forgotPassword;
	
	@FindBy(linkText="Create Account")
	WebElement createAccount;
																																								

	public WebElement getUsernameField() {
		return usernameField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getForgotPassword() {
		return forgotPassword;
	}

	public WebElement getCreateAccount() {
		return createAccount;
	}
	public void login(String uname,String pwd)
	{
		usernameField.sendKeys(uname);
		passwordField.clear();
		passwordField.sendKeys(pwd);
		loginbtn.click();
	}
	
}
