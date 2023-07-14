package com.realestate.generic;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	
	public WebDriver driver=null;
	public FileUtlity fLib=new FileUtlity();
	public JavaUtlity jLib=new JavaUtlity();
	public ExcelUtlity eLib=new ExcelUtlity();
	public DataBaseUtility dLib=new DataBaseUtility();
	WebActionUtility wLib=new WebActionUtility(driver);
	public String pathOfTheFile;
	
	@BeforeSuite(groups = {"smoke","regression"})
	public void connectToDB() throws SQLException 
	{
		dLib.connectDB();
		Reporter.log("connected to database",true);
	}
	
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smoke","regression"})
	public void launchTheBrowser() throws Throwable
	{	
		WebDriverManager.chromedriver().setup();
		pathOfTheFile=fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String BROWSER = fLib.getDataFromProperties(pathOfTheFile, "browser");
		String URL = fLib.getDataFromProperties(pathOfTheFile, "url");
		
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		if(BROWSER.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		if(BROWSER.equals("ie")) {
			driver=new InternetExplorerDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(URL);
		Reporter.log("Browser is launched",true);
		}
	
	@BeforeMethod(groups = {"smoke","regression"})
	public void loginToApplication() throws Throwable
	{
		pathOfTheFile=fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		LoginPage l=new LoginPage(driver);
		String USERNAME = fLib.getDataFromProperties(pathOfTheFile, "username");
		String PASSWORD = fLib.getDataFromProperties(pathOfTheFile, "password");
		HomePage h=new HomePage(driver);
		h.homeLogin().click();
		l.validLogin(USERNAME, PASSWORD);
		
		}
	
	@AfterMethod(groups = {"smoke","regression"})
	public void logoutFromTheApplication()
	{
		
	}
	
	 
	@AfterClass(groups = {"smoke","regression"})
	public void closeTheBrowser()
	{
		driver.quit();
		Reporter.log("browser is closed",true);
	}
	
	@AfterSuite(groups = {"smoke","regression"})
	public void closeDB() throws SQLException
	{
		dLib.closeDB();
		Reporter.log("database connection is closed");
	}
	
	
	

	
}
