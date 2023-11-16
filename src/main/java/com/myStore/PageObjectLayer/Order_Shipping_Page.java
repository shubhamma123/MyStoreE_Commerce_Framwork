package com.myStore.PageObjectLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Order_Shipping_Page {
	 WebDriver driver;	
		public Order_Shipping_Page(WebDriver d) {
			driver=d;
			PageFactory.initElements(driver, this);
}
		
		@FindBy(xpath="//input[@id='cgv']")
		WebElement click_onCheck_box_confirm;
		
		@FindBy(xpath="//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
		WebElement click_processtocheck;
		
		
		public void check_box_click_confirm () {
			click_onCheck_box_confirm.click();
		}
		public void clickprocessCheckout() {
			click_processtocheck.click();
		}
		
		}

		
