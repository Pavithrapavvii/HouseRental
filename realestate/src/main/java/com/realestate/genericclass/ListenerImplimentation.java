package com.realestate.genericclass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.realestate.generic.WebActionUtility;

public class ListenerImplimentation implements ITestListener{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());  
		
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
		
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		
		String methodName = result.getMethod().getMethodName();
		TakesScreenshot takescreenshot=(TakesScreenshot)BaseClass.sdriver;
		File src = takescreenshot.getScreenshotAs(OutputType.FILE);
		LocalDateTime dt = LocalDateTime.now();
		String dateTime = dt.toString().replace(" ", "_").replace(":", "_");
		File dst=new File("./screenshot/"+methodName+"_"+dateTime+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		Random random=new Random();
		int randNum = random.nextInt(1000); 
		
		ExtentSparkReporter spark=new  ExtentSparkReporter("ExtentReport/Report.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("ExtentReport");
		spark.config().setReportName("pavithra");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("platform","windows10");
		report.setSystemInfo("Excuted by", "pavithra");
		report.setSystemInfo("reviewed by", "kiran");
		
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
		
	}
	

}
