package com.myStore.PageObjectLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class My_Account_Page {
	WebDriver driver;	
	public My_Account_Page (WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}
	//identify web element
	@FindBy(xpath="//input[@id='email_create']")
	WebElement Email_create_TExtbox;

	@FindBy(xpath="//span[normalize-space()='Create an account']")
	WebElement ClickOnCreatacnt;

	@FindBy(xpath="//input[@id='email']")
	WebElement Enter_Email_adres_v;

	@FindBy(xpath="//input[@id='passwd']")
	WebElement Enter_password_v;

	@FindBy(xpath="//span[normalize-space()='Sign in']")
	WebElement clic_on_login_button;

	//action perforem
	public void enteremaialdresstextbox(String Emailname) {
		Email_create_TExtbox.sendKeys(Emailname);
	}

	public void click_Creat_acct_button() {
		ClickOnCreatacnt.click();
	}
	public void enteremailaddressv(String emailenter ) {
		Enter_Email_adres_v.sendKeys(emailenter);
	}
	public void entere_passwordv(String password ) {
		Enter_password_v.sendKeys( password);
	}
	public void clickonSigninbutn() {
		clic_on_login_button.click();
	}

}