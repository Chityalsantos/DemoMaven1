package com.Banking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Banking.PageObject.LoginObjects;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void LoginTest() throws IOException
	{
		
		
		logger.info("URL is opened" );
		
		//Create object of PageObject class
		LoginObjects page = new LoginObjects(driver);
		
		
		
		//call the methods using page object
		
		page.setUsername(uname);
		logger.info("Entered Username. ");
		page.setPassword(pwd);
		logger.info("Password Entered.");
		page.clickOnLoginBtn();
		logger.info("Clicked on Login Button.");
		
		if(driver.getTitle().equals(" Guru99 Bank Manager HomePage "))
		{
			Assert.assertTrue(true);
			logger.info("Test Case is Passed");
		}
		else
		{
			captureScreenshot(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("Test case is Failed.");
		}
		
	}
}
