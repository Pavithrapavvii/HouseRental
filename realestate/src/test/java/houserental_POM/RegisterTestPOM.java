package houserental_POM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.realestate.generic.DetailPage;
import com.realestate.generic.ExcelUtlity;
import com.realestate.generic.FileUtlity;
import com.realestate.generic.HomePage;
import com.realestate.generic.JavaUtlity;
import com.realestate.generic.LoginPage;
import com.realestate.generic.RegisterPage;
import com.realestate.generic.WebActionUtility;



public class RegisterTestPOM {
	
	public static void main(String[] args) throws Throwable {
		//WebDriverManager.chromedriver().setup();
		FileUtlity f=new FileUtlity();
		String ENV_DATA_PATH = f.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String URL = f.getDataFromProperties(ENV_DATA_PATH, "url");
		String USERNAME = f.getDataFromProperties(ENV_DATA_PATH, "username");
		String PASSWORD = f.getDataFromProperties(ENV_DATA_PATH, "password");
		String BROWSER = f.getDataFromProperties(ENV_DATA_PATH, "browser");
		
		Scanner s=new Scanner(System.in);             // creating scanner class to read the browser data from user
    	System.out.println("enter browser name");
		 BROWSER=s.nextLine();                // storing browser name into BROWSER variable
		
		WebDriver driver=new ChromeDriver();         // creating driver variable
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
		
		WebActionUtility w=new WebActionUtility(driver);
		w.waitForElementInDOM(driver);
		
		driver.get(URL);   		
		HomePage h=new HomePage(driver);
		
		DetailPage d=new DetailPage(driver);
		
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
		//h.homeLogin().click();
		LoginPage l=new LoginPage(driver);
		l.validLogin(USERNAME, PASSWORD);
		Thread.sleep(2000);
		
		String fullname = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "register", 1, 1)+em;
		String phno = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "register", 3, 2);
		String emailid = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "register", 1, 3)+em;
		String plotno = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "register", 1, 4);
		String room = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "register", 1, 5);
		String country = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "register", 1, 6);
		String state = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "register", 1, 7);
		String city = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "register", 1, 8);
		String rent = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "register", 1, 9);
		String deposit = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "register", 1, 10);
		String facility = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "register", 1, 11);
		String descrip = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "register", 1, 12);
		String landmark = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "register", 1, 13);
		String address = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "register", 1, 14);
		
		h.registerModule();
		RegisterPage r=new RegisterPage(driver);
		r.homeRegisterUser1(fullname, phno, emailid, plotno, room);
		r.homeRegisterUser2(country, state, city, rent, deposit);
		r.homeRegisterUser3(facility, descrip, landmark, address);
		r.homeRegisterUser4();
		r.countUSer();
		
		HomePage h1=new HomePage(driver);
		h1.clickOnHome();
		
		r.countRegisterUser();
		
		
		
		//h.homeLogin();
	/*	h.verifyHomeRegister();
		h.homeRegisterLogin();
		h.homeLogin();
		
		LoginPage l=new LoginPage(driver);
		l.validLogin(USERNAME, PASSWORD);
		
		
		
		
		
		
		
		   */
		
		
	}


}
