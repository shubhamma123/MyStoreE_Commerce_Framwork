package com.myStore.PageObjectLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Index_Page {
	  WebDriver driver;	
	public Login_Index_Page(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}	

	//identify web elements//
	@FindBy(xpath="//a[@class='login']")
	WebElement signinbttn;
	
//identify Action perform
	public void clickonsign(){
		signinbttn.click();
	}


}
