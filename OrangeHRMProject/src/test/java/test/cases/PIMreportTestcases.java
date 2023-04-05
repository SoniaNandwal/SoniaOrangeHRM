package test.cases;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import pages.HomePageOHRM;
import pages.PIMReportsPage;
import utility.BaseClass;

public class PIMreportTestcases extends BaseClass {
	
	 @Test
	    public void reprotEndToEnd()
	    { 
	        try {
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	            driver.get(url);
	            HomePageOHRM loginPage=new HomePageOHRM(driver);        
	            logger.info("open login page");
	            loginPage.enterUsername(global_userName);
	            loginPage.enterPassword(global_password);;
	            loginPage.clickLoginButton();
	            loginPage.verifyHomePage();
	            
	            PIMReportsPage pimReportsPage=new PIMReportsPage(driver);
	            pimReportsPage.clickPim();
	            pimReportsPage.clickReport();
	            pimReportsPage.verifyReportPage();
	            
	        } catch (Exception e) {
	            logger.error("An error occurred during verifyLoginWithValidCredendial test case: " + e.getMessage());
	        } finally {
	        	  HomePageOHRM loginPage=new HomePageOHRM(driver);     
	            loginPage.logOut();
	        }
	    }
	 @Test
	    public void addReportPageVerify()
	    { 
	        try {
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	            driver.get(url);
	            HomePageOHRM loginPage=new HomePageOHRM(driver);        
	            logger.info("open login page");
	            loginPage.enterUsername(global_userName);
	            loginPage.enterPassword(global_password);
	            loginPage.clickLoginButton();
	            loginPage.verifyHomePage();
	            
	            PIMReportsPage pimReportsPage=new PIMReportsPage(driver);
	            pimReportsPage.clickPim();
	            pimReportsPage.clickReport();
	           pimReportsPage.clickAddReport();
	           pimReportsPage.verifyAddReportPage();
	             
	        } catch (Exception e) {
	            logger.error("An error occurred during verifyLoginWithValidCredendial test case: " + e.getMessage());
	        } finally {
	        	  HomePageOHRM loginPage=new HomePageOHRM(driver);     
	            loginPage.logOut();
	        }
	    }
	 @Test
	    public void verifySearchbtnInvalidData()
	    { 
	        try {
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	            driver.get(url);
	            HomePageOHRM loginPage=new HomePageOHRM(driver);        
	            logger.info("open login page");
	            loginPage.enterUsername(global_userName);
	            loginPage.enterPassword(global_password);
	            loginPage.clickLoginButton();
	            loginPage.verifyHomePage();
	            
	            PIMReportsPage pimReportsPage=new PIMReportsPage(driver);
	            pimReportsPage.clickPim();
	            pimReportsPage.clickReport();
	           pimReportsPage.enterReportName("abcdefgh");
	           pimReportsPage.clickSearch();
	           pimReportsPage.verifyInvalidLable();
	          
	        } catch (Exception e) {
	            logger.error("An error occurred during verifyLoginWithValidCredendial test case: " + e.getMessage());
	        } finally {
	        	  HomePageOHRM loginPage=new HomePageOHRM(driver);     
	            loginPage.logOut();
	        }
	    }
	 
	}

	
	  