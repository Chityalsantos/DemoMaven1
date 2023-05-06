package com.Banking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Banking.PageObject.AddNewCustomerPage;
import com.Banking.PageObject.LoginObjects;

public class TC_AddNewCustomer_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginObjects loginPg = new LoginObjects(driver);
		
		loginPg.setUsername(uname);
		logger.info("User name is provided..");
		loginPg.setPassword(pwd);
		logger.info("password is provided...");
		loginPg.clickOnLoginBtn();
		logger.info("Login button is clicked...");
		
		Thread.sleep(3000);
		
		AddNewCustomerPage addCustomerPg = new AddNewCustomerPage(driver);
		
		addCustomerPg.clickOnNewCustomerLink();
		logger.info("Clicked on new customer...");
		
		logger.info("user enter the customer details....");
		addCustomerPg.SetCustomerName("Santhosh");
		addCustomerPg.clickOnGenderRadioBtn();
		addCustomerPg.setDateOfBirth("10", "20", "1998");
		addCustomerPg.setAddress("Hig-78");
		addCustomerPg.enterCityName("Hyderabad");
		addCustomerPg.enterStateName("Telengana");
		addCustomerPg.enterPinCode(520018);
		addCustomerPg.enterPhoneNumber("12345678");
		addCustomerPg.enterEmailAddress(randomString()+"@gmail.com");
		addCustomerPg.enterPassword("avbxf");
		addCustomerPg.clickOnSubmitButton();
		
		String msg = "Customer Registered Successfully!!!";
		boolean res = driver.getPageSource().contains(msg);
		
		if(res == true)
		{
			Assert.assertTrue(true);
			logger.info("Test case is passed.....");
		}
		else
		{
			captureScreenshot(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test case is failed....");
		}
		
		
	}
}
