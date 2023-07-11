package com.realestate.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement lghomebtn;
	
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registertab;
	
	@FindBy(id = "fullname")
	private WebElement fullnametbx;
	
	@FindBy(id = "username")
	private WebElement usernametbx;
	
	@FindBy(id = "mobile")
	private WebElement mobiletbx;
	
	@FindBy(id = "email")
	private WebElement emailtbx;
	
	@FindBy(id = "password")
	private WebElement passwordtbx;
	
	@FindBy(id = "c_password")
	private WebElement conpasswordtbx;
	
	@FindBy(name = "register")
	private WebElement registerbtn;
	
	@FindBy(xpath = "//div[text()='Registration successfull. Now you can login']")
	private WebElement registersuccmsg;
	
	@FindBy(xpath = "//a[@class='nav-link']")
	private WebElement homelgbtn;
	
	@FindBy(linkText =  "Home")
	private WebElement hometab;
	
	@FindBy(xpath = "//a[.='Register']")
	private WebElement registertab1;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	public WebElement getLghomebtn() {
		return lghomebtn;
	}

public WebElement getRegistertab() {
		return registertab;
	}

public WebElement getFullnametbx() {
		return fullnametbx;
	}
public WebElement getUsernametbx() {
		return usernametbx;
	}
public WebElement getMobiletbx() {
		return mobiletbx;
	}
public WebElement getEmailtbx() {
		return emailtbx;
	}
public WebElement getPasswordtbx() {
		return passwordtbx;
	}
public WebElement getConpasswordtbx() {
		return conpasswordtbx;
	}
public WebElement getRegisterbtn() {
		return registerbtn;
	}

public WebElement getRegistersuccmsg() {
	return registersuccmsg;
}


public WebElement getHomelgbtn() {
	return homelgbtn;
}



public WebElement getHometab() {
		return hometab;
	}
public JavaUtlity getJ() {
		return j;
	}

public WebElement homeLogin()
	{
		return lghomebtn;
		
	}
	
	JavaUtlity j=new JavaUtlity();
	
	public void homeRegister(String fullname,String username,String mobile,String email,String password,String conpw) throws InterruptedException
	{
		registertab.click();
		fullnametbx.sendKeys(fullname);
		usernametbx.sendKeys(username);
		mobiletbx.sendKeys(mobile);
		emailtbx.sendKeys(email);
		passwordtbx.sendKeys(password);
		conpasswordtbx.sendKeys(conpw);
		registerbtn.click();
		}
	
	public void verifyHomeRegister()
	{
		String regtext = registersuccmsg.getText();
		if(regtext.contains("Registration successfull. Now you can login"))
		{
			System.out.println("user registered successfully and pass");
		}
		else {
			System.out.println("user not registered successfully and fail");
		}
		homelgbtn.click();
		
	}
	
	/*  public void homeRegisterLogin()
	{
		homelgbtn.click();
	}  */
	
	public void clickOnHome()
	{
		hometab.click();
	}
	
	public void registerModule()
	{
		registertab1.click();
	}

}
