package com.realestate.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendSMSPage {
	
	@FindBy(linkText = "Send SMS")
	private WebElement smstab;
	
	@FindBy(xpath = "//h2[text()='List Of Usres']")
	private WebElement listofusertext;
	
	@FindBy(xpath = "(//td[text()='Mallikarjun']/../child::th/input)[last()]")
	private WebElement checkbox;
	
	@FindBy(name = "message")
	private WebElement msgtbx;
	
	@FindBy(name = "sms_alert")
	private WebElement sendbtn;
	
	public SendSMSPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getSmstab() {
		return smstab;
	}

	public WebElement getListofusertext() {
		return listofusertext;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getMsgtbx() {
		return msgtbx;
	}

	public WebElement getSendbtn() {
		return sendbtn;
	}
	
	public void clickOnSMSModule()
	{
		smstab.click();
	}
	
	public void verifySMSPage()
	{
		String smstext = listofusertext.getText();
		if(smstext.equals("List Of Usres"))
		{
			System.out.println("list of users page is displayed");
		}
		else {
			System.out.println("list of users page not is displayed");
		}
	}
	
	public void sendSMSFromHome(String msg)
	
	{
		checkbox.click();
		msgtbx.sendKeys(msg);
		sendbtn.click();
	}
	
	

}
