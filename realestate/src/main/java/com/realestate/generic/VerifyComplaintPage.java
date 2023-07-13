package com.realestate.generic;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyComplaintPage {
	
	
	@FindBy(linkText = "Complaint List")
	private WebElement complainttab;
	
	@FindBy(xpath = "//td[contains(text(),'Mallikarjun')]")
	private WebElement verifyname;
	
	public VerifyComplaintPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getComplainttab() {
		return complainttab;
	}

	public WebElement getVerifyname() {
		return verifyname;
	}
	
	
	
	public void verifyComplaintList( )
	{
		complainttab.click();
		verifyname.isDisplayed();
		
	}

}
