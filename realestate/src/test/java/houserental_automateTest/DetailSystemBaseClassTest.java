 package houserental_automateTest;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.realestate.generic.BaseClass;
import com.realestate.generic.DetailPage;
import com.realestate.generic.ExcelUtlity;
import com.realestate.generic.FileUtlity;
import com.realestate.generic.HomePage;
import com.realestate.generic.JavaUtlity;
import com.realestate.generic.LoginPage;
import com.realestate.generic.MakeComplaintPage;
import com.realestate.generic.VerifyComplaintPage;



public class DetailSystemBaseClassTest extends BaseClass{
	@Test(groups = "smoke")
	public void detailSystemBase() throws IOException, Throwable
	{
		HomePage h=new HomePage(driver);
		LoginPage lg=new LoginPage(driver);
		DetailPage d=new DetailPage(driver);
		MakeComplaintPage c=new MakeComplaintPage(driver);
		ExcelUtlity e=new ExcelUtlity();
		VerifyComplaintPage v=new VerifyComplaintPage(driver);
		d.clickonDetail();
		String path="./testdata/homeCredentatial.xlsx";
		String otherdata = e.getDataFromExcel(path, "other", 1, 3);
		d.clickonEdit1();
		d.clickonEdit(otherdata);
		String username = e.getDataFromExcel(path, "homeregister", 1, 2);
		String complaint = e.getDataFromExcel(path, "complaint", 1, 1);
	
		c.getComplaint(username, complaint);
		v.verifyComplaintList();
	}

}

		