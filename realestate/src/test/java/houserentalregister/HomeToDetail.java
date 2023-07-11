package houserentalregister;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeToDetail {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();// open the browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost/house_rental");   //  enter the URL
		driver.findElement(By.xpath("//a[text()='Register']")).click();           //  click on register tab
		driver.findElement(By.id("fullname")).sendKeys("Pavithra");               //  enter full name text box
		driver.findElement(By.id("username")).sendKeys("pavi");                   //  enter user name
		driver.findElement(By.id("mobile")).sendKeys("9876543219");               //  enter mobile number
		driver.findElement(By.id("email")).sendKeys("pavi123@gmail.com");         //enter email id 
		driver.findElement(By.id("password")).sendKeys("pavi");                   //  enter password 
		driver.findElement(By.id("c_password")).sendKeys("pavi");                 //  enter confirm password
		driver.findElement(By.name("register")).click();                          //  click on register button
		
		driver.findElement(By.xpath("//a[text()='Login']")).click();              //  click on login tab
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("admin");        //  enter username
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("admin");     // enter password
		driver.findElement(By.xpath("//button[text()='Submit']")).click();       // click on submit button
		
		driver.findElement(By.xpath("//div[@class='alert alert-warning']/ancestor::div[2]/div[2]/descendant::b")).click();
		driver.findElement(By.xpath("(//b[.='Owner Name: '])[last()]/../../../../a")).click();
		driver.findElement(By.id("other")).sendKeys("swimming pool");
		driver.findElement(By.name("register_individuals")).click();
		
		driver.findElement(By.xpath("//a[text()='Send SMS']")).click();
		String listuser = driver.findElement(By.xpath("//h2[text()='List Of Usres']")).getText();
		if(listuser.equals("List Of Usres"))
			System.out.println("list of users page is displayed and pass");
		else
			System.out.println("list of users page is not displayed and fail");

	}

}
