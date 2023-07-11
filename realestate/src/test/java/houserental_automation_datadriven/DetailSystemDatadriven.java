package houserental_automation_datadriven;

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
public class DetailSystemDatadriven {

	public static void main(String[] args) throws Throwable {
		
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = null;
		FileUtlity f=new FileUtlity();
		ExcelUtlity e=new ExcelUtlity();
		LoginPage lg=new LoginPage(driver);
		HomePage h=new HomePage(driver);
		String ENV_DATA_PATH = f.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String URL = f.getDataFromProperties(ENV_DATA_PATH, "url");
		String USERNAME = f.getDataFromProperties(ENV_DATA_PATH, "username");
		String PASSWORD = f.getDataFromProperties(ENV_DATA_PATH, "password");
		String BROWSER = f.getDataFromProperties(ENV_DATA_PATH, "browser");
	    Scanner s=new Scanner(System.in);
		System.out.println("enter browser name");
		 BROWSER=s.nextLine();
		
		
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
		//WebDriver driver=new ChromeDriver();// open the browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get(URL);   //  enter the URL
		
		 JavaUtlity j=new JavaUtlity();
			int name = j.getRandomNumber();
			String path="./testdata/homeCredentatial.xlsx";
			String usern = e.getDataFromExcel(path, "homeregister", 1, 1)+name;
			String fulln = e.getDataFromExcel(path, "homeregister", 1, 2);
			int em = j.getRandomNumber();
			String email = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "homeregister", 1, 3)+em;
			String password = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "homeregister", 1, 4);
			String conpassword = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "homeregister", 1, 5);
			String mobile = j.getRandomPhNumber();
			
			h.homeRegister(fulln, usern, mobile, email, password, conpassword);
			h.verifyHomeRegister();
			h.homeLogin().click();
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
		
		
		DetailPage d=new DetailPage(driver);
		d.clickonDetail();
		String otherdata = e.getDataFromExcel(path, "other", 1, 3);
		d.clickonEdit(otherdata);
		/* driver.findElement(By.linkText("Details/Update")).click();      //click on details module
		driver.findElement(By.xpath("(//b[.='Owner Name: '])[last()]/../../../../a")).click();
		driver.findElement(By.id("other")).sendKeys("wifi");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		driver.findElement(By.id("mobile")).sendKeys("6666666666");
		r.keyRelease(KeyEvent.VK_CONTROL);
		driver.findElement(By.name("register_individuals")).click();   */
	
		MakeComplaintPage c=new MakeComplaintPage(driver);
		
		String username = e.getDataFromExcel(path, "homeregister", 1, 2);
		String complaint = e.getDataFromExcel(path, "complaint", 1, 1);
	
		c.getComplaint(username, complaint);
		
	/*	driver.findElement(By.linkText("Details/Update")).click();
		driver.findElement(By.xpath("((//b[.='Owner Name: '])[last()]/../../../../../../a)[last()]")).click();
		driver.findElement(By.id("name")).sendKeys("mallikarjun");
		driver.findElement(By.id("cmp")).sendKeys("no electricity");
		driver.findElement(By.name("register")).click();
		boolean sent = driver.findElement(By.xpath("//div[text()='Sent Successfully']")).isDisplayed();
		if(sent==true)
			System.out.println("complaint sent successfully");
		else
			System.out.println("complaint not sent successfully");*/
		
		VerifyComplaintPage v=new VerifyComplaintPage(driver);
		v.verifyComplaintList();
		
	/*	driver.findElement(By.linkText("Complaint List")).click();
		String cplist = driver.findElement(By.xpath("//td[text()='mallikarjun']")).getText();
		if(cplist.equals("mallikarjun"))
			System.out.println("complaint is displayed");
		else
			System.out.println("complaint is not displayed");   */


	}

}

		