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

public class ListenerImplimentation implements ITestListener{

	public void onTestStart(ITestResult result) {
		Random random=new Random();
		int randNum = random.nextInt(1000);
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
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
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	

}
