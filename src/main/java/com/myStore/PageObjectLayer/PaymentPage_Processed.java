package com.myStore.PageObjectLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage_Processed {
	WebDriver driver;	
	public PaymentPage_Processed(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//a[@title='Pay by check.']")
	WebElement cliconPaymentOptionpaycheck;



	public void clickonPaycheckPaymentOptin() {
		cliconPaymentOptionpaycheck.click();

	}
}