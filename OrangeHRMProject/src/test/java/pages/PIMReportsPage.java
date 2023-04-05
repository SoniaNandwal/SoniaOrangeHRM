package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
public class PIMReportsPage  {
	
	protected static WebDriver ldriver;

    public PIMReportsPage(WebDriver driver) {
        ldriver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//span[normalize-space()=\"PIM\"]")
	WebElement clickPim;
    @FindBy (linkText = "Reports")
    WebElement reportPageElement;
  @FindBy(xpath="//h5[normalize-space()=\"Employee Reports\"]")
  WebElement reportPageLable;
@FindBy(xpath="//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]") 
WebElement addReportElement;
@FindBy(xpath="//input[@placeholder=\"Type for hints...\"]")
WebElement reportNameElement;
@FindBy(xpath="//h6[normalize-space()=\"Add Report\"]")
WebElement addReportPage;

@FindBy(xpath="//button[normalize-space()=\"Search\"]")
WebElement searchBtn;
@FindBy(xpath = "//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]")
WebElement invalidLable;
@FindBy(xpath="//div[@role=\"columnheader\"]//i[@class=\"oxd-icon bi-check oxd-checkbox-input-icon\"]")
WebElement selectMutliplereport;
@FindBy(xpath = "//button[normalize-space()=\"Delete Selected\"]")
WebElement clickDelete;
@FindBy(xpath = "//button[normalize-space()=\"Yes, Delete\"]")
WebElement clickConform;
@FindBy(xpath="//div[@id='oxd-toaster_1']")
WebElement verifyLableElmt; 
	public void clickPim() {
		   clickPim.click();
		
	}
public void clickReport() {
reportPageElement.click();

}
public void verifyReportPage() {
  String reprotpage=reportPageLable.getText();
 Assert.assertEquals("Employee Reports", reprotpage);

}
    public void clickAddReport() {
        addReportElement.click();
    }
    public void enterReportName(String name) {
       reportNameElement.sendKeys(name);
    }
    
public void verifyAddReportPage() {
	String Addreport=addReportPage.getText();
	Assert.assertEquals("Add Report", Addreport);
	
}

public void clickSearch() {
	searchBtn.click();
}
public void verifyInvalidLable() {
	String invalid=invalidLable.getText();
	Assert.assertEquals("Invalid", invalid);
}
public void selectMultipleReports() {
	selectMutliplereport.click();
	
}
public void clickDelete() {
	clickDelete.click();
}
public void conformDelete() {
clickConform.click();	
}
public void verifyDeleteLable() {
	 String elemnt=verifyLableElmt.getText();
	 Assert.assertNotNull(elemnt);
	
}
	
}
