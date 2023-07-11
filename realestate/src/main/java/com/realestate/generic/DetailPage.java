package com.realestate.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailPage {
	
	// declaration
	
	@FindBy(xpath = "//a[text()='Details/Update']")
	private WebElement detailTab;
	
	@FindBy(xpath = "(//b[.='Owner Name: '])[last()]/../../../../a")
	private WebElement editbtn;     
	
	/* @FindBy(linkText="Edit")
	 private WebElement editbtn;  */   
	
	@FindBy(id = "other")
	private WebElement other;
	
	@FindBy(name = "register_individuals")
	private WebElement registerindi;
	
	 @FindBy(linkText="Register")
	 private WebElement registerTab;
	
	
	// initialization
	
	public DetailPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getDetailtab() {
		return detailTab;
	}

	public WebElement geteditbtn() {
		return editbtn;
	}

	public WebElement getOther() {
		return other;
	}

	public WebElement getRegisterindi() {
		return registerindi;
	}

	
	public void clickonEdit1()
	{
		editbtn.click();
	}
	
	public void clickonEdit(String otherdata)
	{
		
		other.sendKeys(otherdata);
		registerindi.click();
		
	}
	public WebElement getRegisterTab() {
		return registerTab;
	}
	
	public void clickonDetail()
	{
		detailTab.click();
	}

	
	

}
