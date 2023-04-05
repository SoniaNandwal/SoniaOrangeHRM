package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;




public class HomePageOHRM {
static WebDriver ldriver;
	
	public HomePageOHRM(WebDriver driver) 
	{
		ldriver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//button[@type='submit']") WebElement loginButton;
	@FindBy(xpath="//p[text()='Invalid credentials']") WebElement validationText;
	@FindBy(xpath="//h6[normalize-space()='Dashboard']") WebElement verifyHomePage;
	@FindBy(xpath="//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")
	WebElement dropDown;
	@FindBy(linkText="Logout")
	WebElement logOutButton;
	@FindBy(xpath="//p[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]")
	WebElement invalidCredentialMsg;
	@FindBy(xpath = "//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]")
	WebElement requirdMsg;
	

	public void enterUsername(String username)
	{
		this.username.sendKeys(username);
	}
	
	
	public void enterPassword(String password)
	{
		this.password.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	public String getText()
	{
		return validationText.getText();
		 
	}
	public void verifyHomePage() {
		String dasbrdLable=verifyHomePage.getText();
		 Assert.assertEquals("Dashboard", dasbrdLable);
	}
	public void logOut() {
		dropDown.click();
		logOutButton.click();
		
	}
   public void verifyInvalidCredential() {
	   
	   String verifyMsg=invalidCredentialMsg.getText();
	   Assert.assertEquals("Invalid credentials", verifyMsg);
	
}
	
public void verifyingRequirdMsg() {
	   
	   String verifyMsg=requirdMsg.getText();
	   Assert.assertEquals("Required", verifyMsg);
	
}
@FindBy(linkText="PIM")
WebElement pimLink;

@FindBy(linkText="Reports")
WebElement reportsLink;

public void navigateToPIMReports() {
    pimLink.click();
    reportsLink.click();
}

	}








