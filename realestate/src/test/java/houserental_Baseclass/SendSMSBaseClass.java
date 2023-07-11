package houserental_Baseclass;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.realestate.generic.BaseClass;
import com.realestate.generic.ExcelUtlity;
import com.realestate.generic.FileUtlity;
import com.realestate.generic.HomePage;
import com.realestate.generic.JavaUtlity;
import com.realestate.generic.LoginPage;
import com.realestate.generic.SendSMSPage;
import com.realestate.generic.WebActionUtility;



public class SendSMSBaseClass extends BaseClass{
	@Test
	public void sendSMS() throws IOException, Throwable
	{
		HomePage h=new HomePage(driver);
		String path="./testdata/homeCredentatial.xlsx";
		ExcelUtlity e=new ExcelUtlity();
		JavaUtlity j=new JavaUtlity();
		int name = j.getRandomNumber();
		String usern = e.getDataFromExcel(path, "homeregister", 1, 1);
		String fulln = e.getDataFromExcel(path, "homeregister", 1, 2)+name;
		int em = j.getRandomNumber();
		String email = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "homeregister", 1, 3)+em;
		Thread.sleep(2000);
		String password = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "homeregister", 1, 4);
		String conpassword = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "homeregister", 1, 5);
		String mobile = j.getRandomPhNumber();
		Thread.sleep(2000);
		h.homeRegister(fulln, usern, mobile, email, password, conpassword);
		h.verifyHomeRegister();
		SendSMSPage sp=new SendSMSPage(driver);
		sp.clickOnSMSModule();
		sp.verifySMSPage();
		String sms = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "other", 1, 5);
		sp.sendSMSFromHome(sms);
	}
	
	
		
		
		
}
