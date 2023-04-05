package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagePage {
	
	protected static WebDriver ldriver;

    public UserManagePage(WebDriver driver) {
        ldriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Admin']")
    WebElement usermanagement;
    @FindBy(xpath="//h5[normalize-space()=\"System Users\"]")
    WebElement usermanagementLable;
    @FindBy(xpath = "//button[normalize-space()=\"Add\"]")
    WebElement clickAdd;
    @FindBy(xpath="//h6[normalize-space()=\"Add User\"]")
    WebElement addUserlable;
    public void clickAdmin() {
    	usermanagement.click();
		
	}
    public void verifyUserManageMentPage() {
    	String usermanagemnt=usermanagementLable.getText();
    	Assert.assertEquals("System Users", usermanagemnt);
		
	}
    public void clickAdd() {
    	clickAdd.click();
		
	}
    public void verifyAddUserPage() {
    	String addUser=addUserlable.getText();
    	Assert.assertEquals("Add User", addUser);
		
	}
 }
