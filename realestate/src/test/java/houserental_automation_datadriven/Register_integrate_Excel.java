package houserental_automation_datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class Register_integrate_Excel {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Pavithra\\Desktop\\user registration.xlsx"); 
		  Workbook wb = WorkbookFactory.create(fis); //loading all the keys inside pobj variable by using load() method
		  String username = wb.getSheet("login").getRow(1).getCell(1).getStringCellValue();
			  String password = wb.getSheet("login").getRow(1).getCell(4).getStringCellValue();
			  String url = wb.getSheet("login").getRow(1).getCell(5).getStringCellValue();
			  String browser = wb.getSheet("login").getRow(1).getCell(6).getStringCellValue();
			  
			  
		  Scanner s=new Scanner(System.in);             // creating scanner class to read the browser data from user
		System.out.println("enter browser name");
		 String BROWSER = s.nextLine();                // storing browser name into BROWSER variable
		
		WebDriver driver;           // creating driver variable
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));        // waiting statement
		driver.get(url);   //  enter the URL
		driver.findElement(By.xpath("//a[text()='Register']")).click();       //  click on register tab
		
		Random ran=new Random();   // creating random class for random values i.e for unique values
		int email = ran.nextInt(200);
		driver.findElement(By.id("fullname")).sendKeys("Pavithra");         //  enter full name text box
		driver.findElement(By.id("username")).sendKeys("pavi");          //  enter user name
		driver.findElement(By.id("mobile")).sendKeys("9876543219");      //  enter mobile number
		driver.findElement(By.id("email")).sendKeys("pavi"+email+"@gmail.com");   //enter email id 
		driver.findElement(By.id("password")).sendKeys("pavi");   //  enter password 
		driver.findElement(By.id("c_password")).sendKeys("pavi");            //  enter confirm password
		driver.findElement(By.name("register")).click();                //  click on register button
		
		//WebDriver driver=new ChromeDriver();// open the browser
		
		driver.findElement(By.xpath("//a[text()='Login']")).click();              //  click on login tab
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(username);        //  enter username
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);     // enter password
		driver.findElement(By.xpath("//button[text()='Submit']")).click();      // click on submit button
		
		
		String register = driver.findElement(By.xpath("//b[text()='Registered Users: ']/child::span")).getText(); //getting the text of registered user to count the user
		System.out.println(register);  // printing the count of registered users
		
		driver.findElement(By.xpath("//a[.='Register']")).click();               //  click on register button
		
		int randomname = ran.nextInt(100);  // random values for name text field
	                  	//int randomnum=ran.nextInt(3000);    // random values for number text field
		int randomid = ran.nextInt(300);    // random values for email id text field
		

		  String fullname = wb.getSheet("register").getRow(1).getCell(2).getStringCellValue();
		  String mobile = wb.getSheet("register").getRow(1).getCell(3).getStringCellValue();
		  String Email = wb.getSheet("register").getRow(1).getCell(5).getStringCellValue();
		  String plotnum = wb.getSheet("register").getRow(1).getCell(6).getStringCellValue();
		  String avairoom = wb.getSheet("register").getRow(1).getCell(7).getStringCellValue();
		  String country = wb.getSheet("register").getRow(1).getCell(8).getStringCellValue();
		  String state = wb.getSheet("register").getRow(1).getCell(9).getStringCellValue();
		  String city = wb.getSheet("register").getRow(1).getCell(10).getStringCellValue();
		  String rent = wb.getSheet("register").getRow(1).getCell(11).getStringCellValue();
		  String deposit = wb.getSheet("register").getRow(1).getCell(12).getStringCellValue();
		  String adress = wb.getSheet("register").getRow(1).getCell(16).getStringCellValue();
		  String image = wb.getSheet("register").getRow(1).getCell(19).getStringCellValue();
		
		driver.findElement(By.id("fullname")).sendKeys(fullname+randomname);        //  enter to full name textbox
		driver.findElement(By.id("mobile")).sendKeys(mobile);           //  enter to mobile textbox
		driver.findElement(By.id("email")).sendKeys(Email+randomid);    //  enter to email textbox
		driver.findElement(By.id("plot_number")).sendKeys(plotnum);                 //  enter to plot_number textbox
		driver.findElement(By.id("rooms")).sendKeys(avairoom);                     //  enter to rooms textbox
		driver.findElement(By.id("country")).sendKeys(country);                  //  enter to country textbox
		driver.findElement(By.id("state")).sendKeys(state);                //  enter to state textbox
		driver.findElement(By.id("city")).sendKeys(city);                    //  enter to city textbox
		driver.findElement(By.id("rent")).sendKeys(rent);                      //  enter to rent textbox 
		driver.findElement(By.id("deposit")).sendKeys(deposit);                  //  enter to deposit textbox
		        //driver.findElement(By.id("accommodation")).sendKeys("24*7 water availability");   //  enter to accommodation textbox
		         //driver.findElement(By.id("description")).sendKeys("good environment");    //  enter to description textbox
		          //driver.findElement(By.id("landmark")).sendKeys("IB circle");              //  enter to landmark textbox
		driver.findElement(By.id("address")).sendKeys(adress);                //  enter to address textbox
		          //WebElement vacant = driver.findElement(By.id("vacant"));                  //  enter to vacant textbox
		           //Select s1=new Select(vacant);
	                //	s1.selectByValue("1");
		
		 File f=new File(image);    //  select image from folder
		 String abpath = f.getAbsolutePath(); // converting the relative path into absolute path
		 driver.findElement(By.id("image")).sendKeys(abpath);   //  passing the absolute path into the sendkeys method
		 driver.findElement(By.name("register_individuals")).click();    //  enter register button
		 
		 boolean text = driver.findElement(By.xpath("//h2[text()='Register Room']/preceding::div[text()='Registration successfull. Thank you']")).isDisplayed(); // to check the successfull message of register user
		 if(text==true)      // comparing whether register is successfull or not 
			 System.out.println("registration successfull");
		 else
			 System.out.println("registration not successfull");
		
		
		driver.findElement(By.linkText("Home")).click();    // click on home tab
		String register1 = driver.findElement(By.xpath("//b[text()='Registered Users: ']/child::span")).getText();  //getting the text of registered user to count the user
		System.out.println(register1); 
		if(register.equals(register1))  // comparing the registered user is counted or not
			System.out.println("registered user counted");
		else
			System.out.println("registered user not counted");
		driver.close();
	}

}
