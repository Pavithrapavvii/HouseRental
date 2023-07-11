package com.realestate.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoClassPage {
	
		@FindBy(linkText = "Details/Update")
		private WebElement detailTab;

		public WebElement getDetail() {
			return detailTab;
		}
		
		public void getDetailTab()
		{
			detailTab.click();
		}
		
	

}
