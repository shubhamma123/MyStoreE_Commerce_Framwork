package com.myStore.PageObjectLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccounCreation_Details {
	WebDriver driver;	
	public AccounCreation_Details (WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//input[@name='id_gender'])[1]")
	WebElement select_title_Radio_Button;

	@FindBy(xpath = "//input[@id='customer_firstname']")
	WebElement Enter_FirstName;

	@FindBy(xpath = "//input[@id='customer_lastname']")
	WebElement Enter_lastName;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement Enter_password;

	@FindBy(xpath = "//input[@id='newsletter']")
	WebElement click_check_box_signupfor_newletter;

	@FindBy(xpath = "//span[normalize-space()='Register']")
	WebElement click_Register_buttn;

	// After click on Register buttn --continue information Detail--//
	@FindBy(xpath = "//span[normalize-space()='Add my first address']")
	WebElement click_on_AddMyFirst_Address_Option_butn;

	@FindBy(xpath = "//input[@id='firstname']")
	WebElement Add_EnterFirstName_textbox;

	@FindBy(xpath = "//input[@id='lastname']")
	WebElement Add_EnterlasttName_textbox;
	
	@FindBy(xpath = "//input[@id='address1']")
	WebElement Add_adressName_textbox;

	@FindBy(xpath = "//input[@id='city']")
	WebElement Add_cityName_textbox;
	
	@FindBy(xpath = "//select[@id='id_state']")
	WebElement Add_DropDown_State_Select;
	
	@FindBy(xpath = "//input[@id='postcode']")
	WebElement Add_postal_code_enter;
	
	@FindBy(xpath = "//select[@id='id_country']")
	WebElement Add_DropDown_country_Select;
		
	@FindBy(xpath = "//input[@id='phone_mobile']")
	WebElement Add_Mobile_number;
	
	@FindBy(xpath = "//input[@id='alias']")
	WebElement Add_refernce_adress;
	
	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement click_on_save_button;
	
	//action perform web lement
	
	public void selecttitlepage() {
		select_title_Radio_Button.click();
	}
	
	public void EnterFirstname(String nfirsname) {
		Enter_FirstName.sendKeys(nfirsname);
	}
	public void Enterlarstname(String lname) {
		Enter_lastName.sendKeys(lname);
	}
	public void enterpassword(String password) {
		Enter_password.sendKeys(password);
	}
	public void checkboxsignupnewletterclick() {
		click_check_box_signupfor_newletter.click();
	}
	public void clickonregisterbutn() {
		click_Register_buttn.click();
	}
	public void clickonaddmyadressoption() {
		click_on_AddMyFirst_Address_Option_butn.click();
	}
	public void enternameaddfirst(String namefirst) {
		Add_EnterFirstName_textbox.sendKeys(namefirst);
	}
	public void enternlasrnmaeadd(String namelast) {
		Add_EnterlasttName_textbox.sendKeys(namelast);
	}
	public void  enteradressnametextbox(String adress) {
		Add_adressName_textbox.sendKeys( adress);
	}
	public void entercitynametextbox (String cityname ) {
		Add_cityName_textbox.sendKeys(cityname);
	}
	public void selectstate_dropdownoption (String dropdown ) {
		Select statedropdown= new Select(Add_DropDown_State_Select);
		statedropdown.selectByVisibleText(dropdown);
	}
	public void enterpostalcode (String postalcode ) {
		Add_postal_code_enter.sendKeys(postalcode);
	}
	public void countrydropdownselect(String countryselect ) {
	
		Select countrydropdown= new Select(Add_DropDown_country_Select);
		countrydropdown.selectByVisibleText(countryselect);
	}
	public void entermobileno (String mobilnume ) {
		 Add_Mobile_number.sendKeys(mobilnume);
	}
	public void refernceadress (String referadress ) {
		 Add_refernce_adress.sendKeys(referadress);
	}
	public void clickonsavebutton() {
		click_on_save_button.click();
	
}
}