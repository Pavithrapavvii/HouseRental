package com.realestate.generic;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	
	@FindBy(xpath = "//b[text()='Registered Users: ']/child::span")
	private WebElement countregtab;
	
	
	
	@FindBy(id = "fullname")
	private WebElement fullnametbx;
	
	@FindBy(id = "mobile")
	private WebElement mobiletbx;
	
	@FindBy(id = "email")
	private WebElement emailtbx;
	
	@FindBy(id = "plot_number")
	private WebElement plotnotbx;
	
	@FindBy(id = "rooms")
	private WebElement roomstbx;
	
	@FindBy(id = "country")
	private WebElement countrytbx;
	
	@FindBy(id = "state")
	private WebElement statetbx;
	
	@FindBy(id = "city")
	private WebElement citytbx;
	
	@FindBy(id = "rent")
	private WebElement renttbx;
	
	@FindBy(id = "deposit")
	private WebElement deposittbx;
	
	@FindBy(id = "accommodation")
	private WebElement accommodationtbx;
	
	@FindBy(id = "description")
	private WebElement descriptiontbx;
	
	@FindBy(id = "landmark")
	private WebElement landmarktbx;
	
	@FindBy(id = "address")
	private WebElement addresstbx;
	
	@FindBy(id = "vacant")
	private WebElement vacantdp;
	
	@FindBy(id = "image")
	private WebElement imagetbx;
	
	@FindBy(name= "register_individuals")
	private WebElement submitbtn;
	
	
	
	@FindBy(xpath = "//h2[text()='Register Room']/preceding::div[text()='Registration successfull. Thank you']")
	private WebElement regsuccessmsg;
	
	@FindBy(xpath = "//b[text()='Registered Users: ']/child::span")
	private WebElement countregafterreg;
	
	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCountregtab() {
		return countregtab;
	}

	

	public WebElement getFullnametbx() {
		return fullnametbx;
	}

	public WebElement getMobiletbx() {
		return mobiletbx;
	}

	public WebElement getEmailtbx() {
		return emailtbx;
	}

	public WebElement getPlotnotbx() {
		return plotnotbx;
	}

	public WebElement getRoomstbx() {
		return roomstbx;
	}

	public WebElement getCountrytbx() {
		return countrytbx;
	}

	public WebElement getStatetbx() {
		return statetbx;
	}

	public WebElement getCitytbx() {
		return citytbx;
	}

	public WebElement getRenttbx() {
		return renttbx;
	}

	public WebElement getDeposittbx() {
		return deposittbx;
	}

	public WebElement getAccommodationtbx() {
		return accommodationtbx;
	}

	public WebElement getDescriptiontbx() {
		return descriptiontbx;
	}

	public WebElement getLandmarktbx() {
		return landmarktbx;
	}

	public WebElement getAddresstbx() {
		return addresstbx;
	}

	public WebElement getVacantdp() {
		return vacantdp;
	}

	public WebElement getImagetbx() {
		return imagetbx;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	

	

	public WebElement getRegsuccessmsg() {
		return regsuccessmsg;
	}
	
	JavaUtlity j=new JavaUtlity();
	

	
	public void countRegisterUser()
	{
		String exptext = countregtab.getText();
		String acttext = countregafterreg.getText();
		if(exptext.equals(acttext))
		{
			System.out.println("user not registered");
		}
		else
		{
			System.out.println("user registered");
		}
		
	}
	int name = j.getRandomNumber();
	String mobile = j.getRandomPhNumber();
	int email = j.getRandomNumber();
	
	
	
	public void homeRegisterUser1(String fullname,String phone,String email,String plotno,String room) throws Throwable 
	{
		fullnametbx.sendKeys(fullname);
		mobiletbx.sendKeys(phone);
		emailtbx.sendKeys(email);
		plotnotbx.sendKeys(plotno);
		roomstbx.sendKeys(room);
	}
	public void homeRegisterUser2(String country,String state,String city,String rent,String deposit) throws Throwable 
	{
		countrytbx.sendKeys(country);
		statetbx.sendKeys(state);
		citytbx.sendKeys(city);
		renttbx.sendKeys(rent);
		deposittbx.sendKeys(deposit);
	}
	
	public void homeRegisterUser3(String accomodation,String descrip,String landmark,String address) throws Throwable 
	{
		accommodationtbx.sendKeys(accomodation);
		descriptiontbx.sendKeys(descrip);
		landmarktbx.sendKeys(landmark);
		addresstbx.sendKeys(address);
	}
	
	public void homeRegisterUser4() throws Throwable 
	{
		WebDriver driver = null;
		WebActionUtility w=new WebActionUtility(driver);
		w.select(vacantdp, "Vacant");
		File f1=new File("./data/85_leaves dead PBR texture-seamless.jpg");   
		 String abpath = f1.getAbsolutePath(); 
		imagetbx.sendKeys(abpath);
		submitbtn.click();
	}
		
		
		public void countUSer()
	{
		boolean text = regsuccessmsg.isDisplayed();
		if(text==true)
		{
			System.out.println("registration successfull");
		}
		else
		{
			System.out.println("registration not successfull");
		}
	}
	
	

}
