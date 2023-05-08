package com.Banking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Banking.PageObject.LoginObjects;
import com.Banking.Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String uname, String pwd) throws InterruptedException, IOException
	{
		LoginObjects loginPg = new LoginObjects(driver);
		loginPg.setUsername(uname);
		logger.info("Username is entered.");
		loginPg.setPassword(pwd);
		logger.info("password is entered.");
		loginPg.clickOnLoginBtn();
		//Thread.sleep is used only for practice
		Thread.sleep(3000);
		
		if(isAlertPresent() == true)
		{
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			captureScreenshot(driver,"loginDDT");
			logger.warn("Test case is failed.");
			
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Test case is passed.");
			loginPg.clickLogoutButton();
			Thread.sleep(3000);
			logger.info("clicked on logout button.");
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
		}
	}
	public boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			System.out.println(e);
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	String [][] getData() throws IOException
	{
		String path = "C:\\Users\\santhoshreddy\\eclipse-workspace\\SeleniumFramework\\src\\test\\resources\\Test1.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path,"Sheet1",1);
		
		String loginData[][]= new String[rownum][colcount];
		
		for(int i=1; i<= colcount; i++)
		{
			for(int j=0; j< colcount; j++)
			{
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i,j);
			}
		}
		return loginData;
		
	}
}
