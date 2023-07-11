package houserental_automation_datadriven;

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

public class DetailtoSMS_System_datadriven {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Pavithra\\Desktop\\commondata1.property");
		Properties pobj=new Properties();
		pobj.load(fis);
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		String BROWSER = pobj.getProperty("browser");
		
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
		//WebDriver driver=new ChromeDriver();// open the browser
		driver.get(URL);   //  enter the URL
		driver.findElement(By.xpath("//a[text()='Register']")).click();           //  click on register tab
		driver.findElement(By.id("fullname")).sendKeys("Pavithra");               //  enter full name text box
		driver.findElement(By.id("username")).sendKeys("pavi");                   //  enter user name
		driver.findElement(By.id("mobile")).sendKeys("9876543219");               //  enter mobile number
		driver.findElement(By.id("email")).sendKeys("pavi123@gmail.com");         //enter email id 
		driver.findElement(By.id("password")).sendKeys("pavi");                   //  enter password 
		driver.findElement(By.id("c_password")).sendKeys("pavi");                 //  enter confirm password
		driver.findElement(By.name("register")).click();                          //  click on register button
		
		driver.findElement(By.xpath("//a[text()='Login']")).click();              //  click on login tab
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(USERNAME);        //  enter username
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);     // enter password
		driver.findElement(By.xpath("//button[text()='Submit']")).click();       // click on submit button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Random ran=new Random();
		int randomname = ran.nextInt(100);
		int randomnum=ran.nextInt(3000);
		int randomid = ran.nextInt(300);
		driver.findElement(By.xpath("//a[.='Register']")).click();               //  click on register button
		driver.findElement(By.id("fullname")).sendKeys("Mallikarjun"+randomname);        //  enter to full name textbox
		driver.findElement(By.id("mobile")).sendKeys("666666"+randomnum);           //  enter to mobile textbox
		driver.findElement(By.id("email")).sendKeys("malli"+randomid+"@gmail.com");    //  enter to email textbox
		driver.findElement(By.id("plot_number")).sendKeys("15");                 //  enter to plot_number textbox
		driver.findElement(By.id("rooms")).sendKeys("3bhk");                     //  enter to rooms textbox
		driver.findElement(By.id("country")).sendKeys("India");                  //  enter to country textbox
		driver.findElement(By.id("state")).sendKeys("Karnataka");                //  enter to state textbox
		driver.findElement(By.id("city")).sendKeys("Hassan");                    //  enter to city textbox
		driver.findElement(By.id("rent")).sendKeys("8000");                      //  enter to rent textbox 
		driver.findElement(By.id("deposit")).sendKeys("50000");                  //  enter to deposit textbox
		driver.findElement(By.id("accommodation")).sendKeys("24*7 water availability");   //  enter to accommodation textbox
		driver.findElement(By.id("description")).sendKeys("good environment");    //  enter to description textbox
		driver.findElement(By.id("landmark")).sendKeys("IB circle");              //  enter to landmark textbox
		driver.findElement(By.id("address")).sendKeys("Arsikere");                //  enter to address textbox
		WebElement vacant = driver.findElement(By.id("vacant"));                  //  enter to vacant textbox
		Select s1=new Select(vacant);
		s1.selectByValue("1");
		
		 File f=new File("./data/85_leaves dead PBR texture-seamless.jpg");        //  select image from folder
		 String abpath = f.getAbsolutePath();
		 driver.findElement(By.id("image")).sendKeys(abpath);
		 driver.findElement(By.name("register_individuals")).click();             //  enter register button
		 
		 boolean text = driver.findElement(By.xpath("//h2[text()='Register Room']/preceding::div[text()='Registration successfull. Thank you']")).isDisplayed();
		 if(text==true)
			 System.out.println("found");
		 else
			 System.out.println("not found");
		 
		 driver.findElement(By.linkText("Send SMS")).click();
		 String sms = driver.findElement(By.xpath("//h2[text()='List Of Usres']")).getText();
		 if(sms.equals("List Of Usres"))
			 System.out.println("list of users page is displayed and pass");
		 else
			 System.out.println("list of users page is not displayed and fail");
		 
		 driver.findElement(By.name("check[]"));  //incomplete  //td[text()='Mallikarjun']/../child::th/input)[last()]
		 driver.findElement(By.name("message")).sendKeys("contact the user");
		 driver.findElement(By.name("sms_alert")).click();

	}

}
