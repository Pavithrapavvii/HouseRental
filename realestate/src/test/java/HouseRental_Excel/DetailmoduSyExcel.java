package HouseRental_Excel;

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
import com.realestate.generic.VerifyComplaintPage;
import com.realestate.generic.WebActionUtility;



public class DetailmoduSyExcel extends BaseClass {

	@Test
	public void details() throws InterruptedException
	{
		
        DetailPage d=new DetailPage(driver);
		HomePage h=new HomePage(driver);
		DemoClassPage dLib=new DemoClassPage();
        Thread.sleep(2000);
		dLib.getDetail();
	}
		
		//d.getDetailtab().click();
	/*	d.clickonEdit();

		MakeComplaintPage c=new MakeComplaintPage(driver);
		c.getComplaint();

		VerifyComplaintPage v=new VerifyComplaintPage(driver);
		v.verifyComplaintList();*/









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
