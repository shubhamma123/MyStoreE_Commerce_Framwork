package com.MyStore.TestCasesLayer;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myStore.PageObjectLayer.Buy_Product_Page;
import com.myStore.PageObjectLayer.Login_Index_Page;
import com.myStore.PageObjectLayer.My_Account_Page;
import com.myStore.PageObjectLayer.OrderConfirm_Page;
import com.myStore.PageObjectLayer.Order_Shipping_Page;
import com.myStore.PageObjectLayer.PaymentPage_Processed;
import com.myStore.PageObjectLayer.ProcessedTOAdress_Page;
import com.myStore.PageObjectLayer.ProductSearchPage_Product;
import com.myStore.PageObjectLayer.order_Summery_Page;
import com.myStore.PageObjectLayer.registeruseraccount;
import com.myStore.TestbaseLayer.TestBaseComn;

public class TC_003_ProductPage_Test extends TestBaseComn {
	
	
	@Test(enabled=false)
	public void verifysearchproduct() throws IOException, InterruptedException {
		String serchproduct="T-shirts";
		Login_Index_Page obj=new Login_Index_Page(driver);
		obj.clickonsign();
		
		My_Account_Page obj7=new My_Account_Page(driver);
		obj7.enteremailaddressv(emailad);
		
		obj7.entere_passwordv(password);
		
		
		obj7.clickonSigninbutn();
		Thread.sleep(3000);
		
		registeruseraccount obj3=new registeruseraccount(driver);
		obj3.Clickonserchoption(serchproduct);
		Thread.sleep(3000);
		
		ProductSearchPage_Product obj1=new ProductSearchPage_Product(driver);
		String serchresultproductname=obj1.getserchresultproductname();
		
//		ProductSearchPage_Product obj6=new ProductSearchPage_Product(driver);
//		 String Actualname1= obj6.getserchresultproductname();
		Thread.sleep(3000);
		 if(serchresultproductname.equals(serchproduct)) {
			 Assert.assertTrue(true);
			 obj1.ClickSignoutbutton();
		 }
		 else {
			 Util_base.capture_Screen_Shot("verifysearchproduct1");
			 Assert.assertTrue(false);
		 }
		
			 
		 }
	 @Test(enabled=false)
	 public void verifyBuyProduct() throws InterruptedException, IOException {
		 
		 Login_Index_Page obj=new Login_Index_Page(driver);
			obj.clickonsign(); 
			
			My_Account_Page obj7=new My_Account_Page(driver);
			obj7.enteremailaddressv(emailad);
			
			obj7.entere_passwordv(password);
			
			
			obj7.clickonSigninbutn();
			
			registeruseraccount obj3=new registeruseraccount(driver);
			obj3.Clickonserchoption("T_Shirt");
			 
			ProductSearchPage_Product obj4=new ProductSearchPage_Product(driver);
			Thread.sleep(2000);
			obj4.clickonMorelink();
			Thread.sleep(2000);
			
			
			
			Buy_Product_Page obj5=new Buy_Product_Page(driver);
			obj5.SetQunty("1");
			obj5.SetSize("M");
			obj5.clickaddtocart();
			Thread.sleep(2000);
			obj5.procesdecheckout();
			
			
			order_Summery_Page obj6=new order_Summery_Page(driver);
			Thread.sleep(2000);
			obj6.proceesedtocheckoutotheroption();
			Thread.sleep(2000);
			ProcessedTOAdress_Page obj8=new ProcessedTOAdress_Page(driver);
		
//			obj8.enternameaddfirst("Shubham");
//			obj8.enternlasrnmaeadd("Mahajan");
//			obj8.enteradressnametextbox("nagpur dighori");
//			obj8.entercitynametextbox("nagpur");
//			obj8.selectstate_dropdownoption("Florida");
//			obj8.countrydropdownselect("United States");
//			obj8.enterpostalcode("00000");
//			obj8.entermobileno("9637418886");
//			obj8.refernceadress("nagpur");
//			obj8.clickonsavebutton();
			Thread.sleep(2000);
			obj8.clickproceesedtocheckoutadress();
			Thread.sleep(2000);
			
			Order_Shipping_Page obj9=new Order_Shipping_Page(driver);
			Thread.sleep(2000);
			obj9.check_box_click_confirm();
			Thread.sleep(5000);
			
			obj9.clickprocessCheckout();
			Thread.sleep(2000);
			PaymentPage_Processed obj10=new PaymentPage_Processed(driver);
			obj10.clickonPaycheckPaymentOptin();
			
			OrderConfirm_Page obj11=new OrderConfirm_Page(driver);
			Thread.sleep(2000);
			obj11.click_on_confirm_order();
			String confirn = obj11.getconfirmmessage();
			
			if(confirn.equals("Your order on My Shop is complete.")) {
				Assert.assertTrue(true);
				obj11.click_on_Sign_Out_Option_LAst();
			}
			else {
				
				 Util_base.capture_Screen_Shot("verifyBuyProduct");
				 Assert.assertTrue(false);
			}
			
			
	}
	 @Test
	 public void signout() throws IOException {
		 Login_Index_Page obj=new Login_Index_Page(driver);
			obj.clickonsign(); 
			
			My_Account_Page obj7=new My_Account_Page(driver);
			obj7.enteremailaddressv(emailad);
			
			obj7.entere_passwordv(password);
			
			
			obj7.clickonSigninbutn();
			registeruseraccount obj3=new registeruseraccount(driver);
			obj3.ClickSignoutbutton();
			
			if(Util_base.GetTilePages().equals("Login - My Shop")) {
				Assert.assertTrue(true);
				
			}
			else {
				Util_base.capture_Screen_Shot("signout");
				Assert.assertTrue(false);
			}
	 }

}
