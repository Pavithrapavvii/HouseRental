package com.realestate.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MakeComplaintPage {
	
	@FindBy(linkText = "Details/Update")
	private WebElement detailtab;
	
	@FindBy(xpath="((//b[.='Owner Name: '])[last()]/../../../../../../a)[last()]")
	private WebElement ownercomp;
	
	@FindBy(id = "name")
	private WebElement usercomp;
	
	@FindBy(id = "cmp")
	private WebElement comptbx;
	
	@FindBy(name = "register")
	private WebElement subbtn;
	
	@FindBy(xpath="//div[text()='Sent Successfully']")
	private WebElement compsuccessmsg;
	
	public MakeComplaintPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOwnercomp() {
		return ownercomp;
	}

	public WebElement getUsercomp() {
		return usercomp;
	}

	public WebElement getComptbx() {
		return comptbx;
	}

	public WebElement getSubbtn() {
		return subbtn;
	}

	public WebElement getCompsuccessmsg() {
		return compsuccessmsg;
	}
	
	
	
	public WebElement getDetailtab() {
		return detailtab;
	}

	

	public void getComplaint(String Username,String complaint)
	{
		detailtab.click();
		ownercomp.click();
		usercomp.sendKeys(Username);
		comptbx.sendKeys(complaint);
		subbtn.click();
		boolean text = compsuccessmsg.isDisplayed();
		if(text==true)
		{
			System.out.println("complaint sent successsfully");
		}
		else {
			System.out.println("complaint not sent successsfully");
		}
		
	}

}
