package houserental_POM;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.realestate.generic.DetailPage;
import com.realestate.generic.ExcelUtlity;
import com.realestate.generic.FileUtlity;
import com.realestate.generic.HomePage;
import com.realestate.generic.JavaUtlity;
import com.realestate.generic.LoginPage;
import com.realestate.generic.MakeComplaintPage;
import com.realestate.generic.VerifyComplaintPage;



public class DetailSystemPOM {

	public static void main(String[] args) throws Throwable {
		//WebDriverManager.chromedriver().setup();
		
		FileUtlity f=new FileUtlity();
		String ENV_DATA_PATH = f.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String URL = f.getDataFromProperties(ENV_DATA_PATH, "url");
		String USERNAME = f.getDataFromProperties(ENV_DATA_PATH, "username");
		String PASSWORD = f.getDataFromProperties(ENV_DATA_PATH, "password");
		String BROWSER = f.getDataFromProperties(ENV_DATA_PATH, "browser");
		
		Scanner s=new Scanner(System.in);
		System.out.println("enter browser name");
		 BROWSER=s.nextLine();
		
		WebDriver driver;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		if(BROWSER.equals("ie")) {
			driver=new InternetExplorerDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);   //  enter the URL
		
		HomePage h=new HomePage(driver);
	
		h.homeLogin().click();
		
		LoginPage lg=new LoginPage(driver);
		lg.validLogin(USERNAME, PASSWORD);
		
		
		
		DetailPage d=new DetailPage(driver);
		d.clickonDetail();
		ExcelUtlity e=new ExcelUtlity();
		String path="./testdata/homeCredentatial.xlsx";
		String otherdata = e.getDataFromExcel(path, "other", 1, 3);
		d.clickonEdit(otherdata);
		
		//JavaUtlity j=new JavaUtlity();
		//int name = j.getRandomNumber();
		String username = e.getDataFromExcel(path, "homeregister", 1, 2);
		String complaint = e.getDataFromExcel(path, "complaint", 1, 1);
		MakeComplaintPage c=new MakeComplaintPage(driver);
		c.getComplaint(username, complaint);
		
	     VerifyComplaintPage v=new VerifyComplaintPage(driver);
		v.verifyComplaintList();
		
	}

}

		