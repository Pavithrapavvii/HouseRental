package houserental_automateTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.realestate.generic.BaseClass;
import com.realestate.generic.DemoClassPage;
import com.realestate.generic.DetailPage;
import com.realestate.generic.ExcelUtlity;
import com.realestate.generic.FileUtlity;
import com.realestate.generic.HomePage;
import com.realestate.generic.JavaUtlity;
import com.realestate.generic.LoginPage;
import com.realestate.generic.MakeComplaintPage;
import com.realestate.generic.RegisterPage;
import com.realestate.generic.VerifyComplaintPage;
import com.realestate.generic.WebActionUtility;

public class DetailmoduSyBaseClassTest extends BaseClass {

	@Test(groups = "regression")
	public void details() throws IOException, Throwable
	{
		
        DetailPage d=new DetailPage(driver);
		HomePage h=new HomePage(driver);
		DemoClassPage dLib=new DemoClassPage();
        Thread.sleep(2000);
        ExcelUtlity e=new ExcelUtlity();
		String path="./testdata/homeCredentatial.xlsx";
		JavaUtlity j=new JavaUtlity();
		int em = j.getRandomNumber();
        String fullname = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "register", 1, 1)+em;
		//String phno = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "register", 3, 2);
        String phno = j.getRandomPhNumber();
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
		Thread.sleep(2000);
		r.homeRegisterUser1(fullname, phno, emailid, plotno, room);
		Thread.sleep(2000);
		r.homeRegisterUser2(country, state, city, rent, deposit);
		Thread.sleep(2000);
		r.homeRegisterUser3(facility, descrip, landmark, address);
		Thread.sleep(2000);
		r.homeRegisterUser4();
		Thread.sleep(2000);
		r.countUSer();
		Thread.sleep(2000);
		d.clickonDetail();
	
		
		//d.getDetailtab().click();
		
		String otherdata = e.getDataFromExcel(path, "other", 1, 3);
		Thread.sleep(2000);
		d.clickonEdit1();
		Thread.sleep(2000);
		d.clickonEdit(otherdata);

		MakeComplaintPage c=new MakeComplaintPage(driver);
		
		int name = j.getRandomNumber();
		
		String uname = e.getDataFromExcel(path, "homeregister", 1, 2)+name;
		String complaint = e.getDataFromExcel(path, "complaint", 1, 1);
	   c.getComplaint(uname, complaint);

		VerifyComplaintPage v=new VerifyComplaintPage(driver);
		v.verifyComplaintList();

	}







		/*	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);   //  enter the URL


		driver.findElement(By.xpath("//a[text()='Login']")).click();              //  click on login tab
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("admin");        //  enter username
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("admin");     // enter password
		driver.findElement(By.xpath("//button[text()='Submit']")).click();       // click on submit button

		driver.findElement(By.linkText("Details/Update")).click();
		driver.findElement(By.xpath("(//b[.='Owner Name: '])[last()]/../../../../a")).click();
		driver.findElement(By.id("other")).sendKeys("wifi");
		driver.findElement(By.id("mobile")).sendKeys("6666666666");
		driver.findElement(By.name("register_individuals")).click();

		driver.findElement(By.linkText("Details/Update")).click();
		driver.findElement(By.xpath("((//b[.='Owner Name: '])[last()]/../../../../../../a)[last()]")).click();
		driver.findElement(By.id("name")).sendKeys("mallikarjun");
		driver.findElement(By.id("cmp")).sendKeys("no electricity");
		driver.findElement(By.name("register")).click();
		boolean sent = driver.findElement(By.xpath("//div[text()='Sent Successfully']")).isDisplayed();
		if(sent==true)
			System.out.println("complaint sent successfully");
		else
			System.out.println("complaint not sent successfully");

		driver.findElement(By.linkText("Complaint List")).click();
		String cplist = driver.findElement(By.xpath("//td[text()='mallikarjun']")).getText();
		if(cplist.equals("mallikarjun"))
			System.out.println("complaint is displayed");
		else
			System.out.println("complaint is not displayed");               */



	

}
