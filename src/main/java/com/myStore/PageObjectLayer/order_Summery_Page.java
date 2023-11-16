package com.myStore.PageObjectLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class order_Summery_Page {
	  WebDriver driver;	
		public order_Summery_Page(WebDriver d) {
			driver=d;
			PageFactory.initElements(driver, this);
}
	
		@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
		WebElement processedToCeckoutOtherOption;
		
		public void proceesedtocheckoutotheroption() {
			processedToCeckoutOtherOption.click();
			
}
}