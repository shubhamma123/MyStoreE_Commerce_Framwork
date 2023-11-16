package com.myStore.PageObjectLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Buy_Product_Page {
	WebDriver driver;	
	public Buy_Product_Page(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);

	}
	@FindBy(id="quantity_wanted")
	WebElement addQuntyEntry;

	@FindBy(id="group_1")
	WebElement addSizeproduct;

	@FindBy(xpath="//span[normalize-space()='Add to cart']")
	WebElement clickonAddtocartbutton ;

	@FindBy(xpath="//span[normalize-space()='Proceed to checkout']")
	WebElement processedToCheckout;

//Action Method Perform
	
	public void SetQunty(String qty) {
		addQuntyEntry.clear();
		addQuntyEntry.sendKeys(qty);
	}
	public void SetSize(String setsize) {
		Select select=new Select(addSizeproduct);
		select.selectByVisibleText(setsize);
	}
	public void clickaddtocart() {
		clickonAddtocartbutton.click();
	}
	public void procesdecheckout() {
		processedToCheckout.click();
	}
}
