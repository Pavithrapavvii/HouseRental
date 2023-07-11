package houserentalregister;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;



public class DetailmoduleSystem {
 // by using edit button in detail/update module
	public static void main(String[] args) {
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();// open the browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/House_Rental_Application/");   //  enter the URL
		
		
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
			System.out.println("complaint is not displayed");
		
		

	}

}
