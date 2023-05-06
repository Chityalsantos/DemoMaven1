package com.Banking.Utilities;
import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting implements ITestListener{

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void onStart(ITestContext context)
	{
		htmlReporter = new ExtentSparkReporter("Extent Reports");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		reports.setSystemInfo("Machine", "Linux");
		reports.setSystemInfo("Tester", "Santhosh");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("Report", "Html");
		
		htmlReporter.config().setDocumentTitle("Banking Demo Login Test");
		htmlReporter.config().setReportName("Functional Test Automation Report");
		htmlReporter.config().setTimeStampFormat("yy-MM-dd HH:mm:ss");
		htmlReporter.config().setTheme(Theme.DARK);
		
		
	}
	public void onTestSuccess(ITestResult result)
	{
		test = reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		
	}
	public void onTestFailure(ITestResult result)
	{
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		
		String screenshotPath = System.getProperty("user.dir"+"\\Screenshots\\"+result.getName()+".png");
		File f = new File(screenshotPath);
		
		if(f.exists())
		{
			test.fail("Screenshot is added below :"+test.addScreenCaptureFromPath(screenshotPath));
		}
				
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
	}
	
	public void onFinish(ITestContext context)
	{
		reports.flush();
	}
}
