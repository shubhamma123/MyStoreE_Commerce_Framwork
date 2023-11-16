package com.myStore.PageObjectLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.TestbaseLayer.TestBaseComn;

public class ProductSearchPage_Product extends TestBaseComn {
	WebDriver driver;	
	public ProductSearchPage_Product (WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);

	}


	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	WebElement MOre_Element;



	@FindBy(xpath="(//a[@class='product-name'])[10]")
	WebElement search_result_product;
	
	
	@FindBy(xpath="//a[@title='Log me out']")
	WebElement clicksignoutbuttonlink;



	//Actiom more link

	public String getserchresultproductname() {
		return search_result_product.getText();
	}
	public void clickonMorelink() {
		
		MOre_Element.click();
	}	
		public void ClickSignoutbutton() {
			clicksignoutbuttonlink.click();
	}
}