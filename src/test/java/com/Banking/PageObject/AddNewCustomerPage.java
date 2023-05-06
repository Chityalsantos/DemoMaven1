package com.Banking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {

	WebDriver ldriver;
	
	public AddNewCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='New Customer']")
	WebElement newCustomerLink;
	
	@FindBy(how = How.NAME, using = "name")
	WebElement customerName;
	
	@FindBy(how = How.NAME, using = "rad1")
	WebElement genderRadioBtn;
	
	@FindBy(how = How.NAME, using = "dob")
	WebElement dateOfBirth;
	
	@FindBy(how = How.NAME, using = "addr")
	WebElement addressField;
	
	@FindBy(how = How.NAME, using = "city")
	WebElement cityField;
	
	@FindBy(how = How.NAME, using = "state")
	WebElement stateField;
	
	@FindBy(how = How.NAME, using = "pinno")
	WebElement pinField;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement phoneField;
	
	@FindBy(how = How.NAME, using = "emailid")
	WebElement emailField;
	
	@FindBy(how = How.NAME, using = "password")
	WebElement passwordField;
	
	@FindBy(how = How.XPATH, using = "//input[@name='sub']")
	WebElement submitBtn;
	
	public void clickOnNewCustomerLink()
	{
		newCustomerLink.click();
	}
	
	public void SetCustomerName(String cName)
	{
		customerName.sendKeys(cName);
	}
	
	public void clickOnGenderRadioBtn()
	{
		genderRadioBtn.click();
	}
	
	public void setDateOfBirth(String mm, String dd, String yyyy)
	{
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(yyyy);
	}
	
	public void setAddress(String address)
	{
		addressField.sendKeys(address);
	}
	
	public void enterCityName(String city)
	{
		cityField.sendKeys(city);
	}
	
	public void enterStateName(String sName)
	{
		stateField.sendKeys(sName);
	}
	
	public void enterPinCode(int code)
	{
		pinField.sendKeys(String.valueOf(code));
	}
	
	public void enterPhoneNumber(String phone)
	{
		phoneField.sendKeys(phone);
	}
	
	public void enterEmailAddress(String email)
	{
		emailField.sendKeys(email);
	}
	
	public void enterPassword(String pwd)
	{
		passwordField.sendKeys(pwd);
	}
	
	public void clickOnSubmitButton()
	{
		submitBtn.click();
	}
}
