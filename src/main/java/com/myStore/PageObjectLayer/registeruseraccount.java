package com.myStore.PageObjectLayer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registeruseraccount {
	WebDriver driver;	
	public registeruseraccount (WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement useracountverifyvalidetail;
	
	@FindBy(xpath="//a[@title='Log me out']")
	WebElement clicksignoutbuttonlink;
	
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement Click_on_Search_Box_Enter;
	
	public String getusername() {
		return useracountverifyvalidetail.getText();
	}
	public void ClickSignoutbutton() {
		clicksignoutbuttonlink.click();
		
	}
	public void Clickonserchoption(String serchproduct) {
		Click_on_Search_Box_Enter.sendKeys( serchproduct+Keys.ENTER);
}
}
