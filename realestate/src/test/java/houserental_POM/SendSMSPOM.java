package houserental_POM;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.realestate.generic.ExcelUtlity;
import com.realestate.generic.FileUtlity;
import com.realestate.generic.HomePage;
import com.realestate.generic.JavaUtlity;
import com.realestate.generic.LoginPage;
import com.realestate.generic.SendSMSPage;
import com.realestate.generic.WebActionUtility;



public class SendSMSPOM {
	
	public static void main(String[] args) throws Throwable {
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = null;
		FileUtlity f=new FileUtlity();
		WebActionUtility w=new WebActionUtility(driver);
		w.waitForElementInDOM(driver);
		String ENV_DATA_PATH = f.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String URL = f.getDataFromProperties(ENV_DATA_PATH, "url");
		String USERNAME = f.getDataFromProperties(ENV_DATA_PATH, "username");
		String PASSWORD = f.getDataFromProperties(ENV_DATA_PATH, "password");
		String BROWSER = f.getDataFromProperties(ENV_DATA_PATH, "browser");
		
		Scanner s=new Scanner(System.in);             // creating scanner class to read the browser data from user
    	System.out.println("enter browser name");
		 BROWSER=s.nextLine();                // storing browser name into BROWSER variable
		
		//WebDriver driver=new ChromeDriver();         // creating driver variable
		if(BROWSER.equals("chrome")) {      // comparing the user entered browser and open that browser
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
		driver.get(URL);   		
		HomePage h=new HomePage(driver);
		String path="./testdata/homeCredentatial.xlsx";
		ExcelUtlity e=new ExcelUtlity();
		JavaUtlity j=new JavaUtlity();
		int name = j.getRandomNumber();
		String usern = e.getDataFromExcel(path, "homeregister", 1, 1)+name;
		String fulln = e.getDataFromExcel(path, "homeregister", 1, 2);
		System.out.println(usern);
		System.out.println(fulln);
		
		j.getRandomPhNumber();
		int em = j.getRandomNumber();
		String email = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "homeregister", 1, 3)+em;
		String password = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "homeregister", 1, 4);
		String conpassword = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "homeregister", 1, 5);
		String mobile = j.getRandomPhNumber();
		h.homeRegister(fulln, usern, mobile, email, password, conpassword);
		h.verifyHomeRegister();
		
		LoginPage l=new LoginPage(driver);
		h.homeLogin().click();
		Thread.sleep(2000);
		l.validLogin(USERNAME, PASSWORD);
		Thread.sleep(2000);
		
		SendSMSPage sp=new SendSMSPage(driver);
		sp.clickOnSMSModule();
		sp.verifySMSPage();
		sp.sendSMSFromHome(mobile);
		
		}

}
