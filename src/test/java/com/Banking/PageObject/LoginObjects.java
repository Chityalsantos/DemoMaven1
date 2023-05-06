package com.Banking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjects {
	
	WebDriver ldriver;
	//constructor
	public LoginObjects(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//find the WebElements
	@FindBy(xpath = "//input[@name='uid']")
	WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement loginBtn; 
	
	@FindBy(xpath ="//a[normalize-space()='Log out']")
	WebElement logoutBtn;
	
	public void setUsername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}
	
	public void clickLogoutButton()
	{
		logoutBtn.click();
	}
}
