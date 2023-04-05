package test.cases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pages.HomePageOHRM;
import utility.BaseClass;
import utility.ExcelUtility;

public class LoginTestCase  extends BaseClass {
	
	@DataProvider
	Object readData() throws IOException
	{
		String location=".\\resources\\HRMData.xlsx";
		ExcelUtility xlData=new ExcelUtility(location);
	  int rows=xlData.getRowCount("LogData");
	  int cols=xlData.getCellCount("LogData", rows);	
	
	Object [][] data=new Object[rows][cols]; 
	
	for (int i = 1; i <=rows; i++) {
		for (int j = 0; j <cols; j++) {
			data[i-1][j]=xlData.getCellData("LogData", i, j);
		}
	}	
		return  data;	
	}
	
	//Data Driven for Null Values	
		@DataProvider
		Object readNullData() throws IOException {
			
			Object[][] data = new Object[3][2];

			
			  data[0][0]="Admin"; data[0][1]="";
			  data[1][0]=""; data[1][1]="admin123"; 
			  data[2][0]=""; data[2][1]="";
		
			return data;
		}

		@Test
		public void verifyLoginWithValidCredendial()
		{ 
			HomePageOHRM loginPage=new HomePageOHRM(driver);                  
			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		logger.info("open login page");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 loginPage.enterUsername(global_userName);
         loginPage.enterPassword(global_password);

		loginPage.clickLoginButton();
		loginPage.verifyHomePage();
		loginPage.logOut();
	
		
		}
		@Test(dataProvider = "readData")
		public void verifyLoginWithInValidCredendial(String user , String pass)
		
		{ 
		
			HomePageOHRM loginPage=new HomePageOHRM(driver);                  
			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		logger.info("open login page");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPage.enterUsername(user);
		loginPage.enterPassword(pass);
		loginPage.clickLoginButton();
		loginPage.verifyInvalidCredential();
	
		
		}
		@Test(dataProvider = "readNullData")
		public void verifyLogInWithNullValues(String user , String pass)
		
		{ 
		
			HomePageOHRM loginPage=new HomePageOHRM(driver);                  
			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		logger.info("open login page");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPage.enterUsername(user);
		loginPage.enterPassword(pass);
		loginPage.clickLoginButton();
		loginPage.verifyingRequirdMsg();
	
		
		}
		
	}


