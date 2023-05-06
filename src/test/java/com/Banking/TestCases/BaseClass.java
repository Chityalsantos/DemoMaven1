package com.Banking.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Banking.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public String baseurl = readconfig.getApplicationUrl();
	public String uname = readconfig.getUsername();
	public String pwd = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)    
	{
		
		
		//for logging
		logger = LogManager.getLogger("BankingDemo");
		
		if(br.equals("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseurl);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public void captureScreenshot(WebDriver driver,String filename) throws IOException
	 {
		 TakesScreenshot screenshot = ((TakesScreenshot)driver); 
		 File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		 
		 File destFile = new File("C:\\Users\\santhoshreddy\\eclipse-workspace\\SeleniumFramework\\Screenshots\\"+filename+".png");
		 
		 FileUtils.copyFile(srcFile, destFile);
		 System.out.println("Screenshot Captured Successfully");
	 }
	
	public String randomString()
	{
		String email = RandomStringUtils.randomAlphabetic(6);
		return email;
	}
}
