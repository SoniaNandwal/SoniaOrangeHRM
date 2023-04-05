package test.cases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import pages.HomePageOHRM;
import pages.PIMReportsPage;
import pages.UserManagePage;
import utility.BaseClass;

public class UserManagementTestCase extends BaseClass {

	@Test
	public void userManagementUI() {
	  try {
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
          HomePageOHRM loginPage=new HomePageOHRM(driver);        
          logger.info("open login page");
          loginPage.enterUsername("Admin");
          loginPage.enterPassword("admin123");
          loginPage.clickLoginButton();
          loginPage.verifyHomePage();
          UserManagePage usermngmnt=new UserManagePage(driver);
          usermngmnt.clickAdmin();
          usermngmnt.verifyUserManageMentPage();  
      } catch (Exception e) {
          logger.error("An error occurred during verifyLoginWithValidCredendial test case: " + e.getMessage());
      } finally {
      	  HomePageOHRM loginPage=new HomePageOHRM(driver);     
          loginPage.logOut();
      }
  }
	@Test
	public void verifyAddUserPage() {
	  try {
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          driver.get(url);
          HomePageOHRM loginPage=new HomePageOHRM(driver);        
          logger.info("open login page");
          loginPage.enterUsername(global_userName);
          loginPage.enterPassword(global_password);
          loginPage.clickLoginButton();
          loginPage.verifyHomePage();
          UserManagePage usermngmnt=new UserManagePage(driver);
          usermngmnt.clickAdmin();
         usermngmnt.clickAdd();
         usermngmnt.verifyAddUserPage();
      } catch (Exception e) {
          logger.error("An error occurred during verifyLoginWithValidCredendial test case: " + e.getMessage());
      } finally {
      	  HomePageOHRM loginPage=new HomePageOHRM(driver);     
          loginPage.logOut();
      }
  }
}
