package com.myStore.PageObjectLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirm_Page {
	 WebDriver driver;	
		public OrderConfirm_Page(WebDriver d) {
			driver=d;
			PageFactory.initElements(driver, this);
}
	
		@FindBy(xpath = "//span[normalize-space()='I confirm my order']")
		WebElement clickonconfirmorder;
		
		@FindBy(xpath = "//p[@class='alert alert-success']")
		WebElement alertmessage;
		
		@FindBy(xpath = "//a[@title='Log me out']")
		WebElement cliconsignoutoption;
		

		

		public void click_on_confirm_order() {
			 clickonconfirmorder.click();
}
		public String getconfirmmessage() {
			return alertmessage.getText();
		}
		public void click_on_Sign_Out_Option_LAst() {
			cliconsignoutoption.click();
		}
}