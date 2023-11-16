package com.MyStore.TestCasesLayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myStore.PageObjectLayer.AccounCreation_Details;
import com.myStore.PageObjectLayer.Login_Index_Page;
import com.myStore.PageObjectLayer.My_Account_Page;
import com.myStore.PageObjectLayer.registeruseraccount;
import com.myStore.TestbaseLayer.TestBaseComn;
import com.myStore.UtilityLayer.UtilBase_class;

public class TC_001_MyAccountPageTest extends TestBaseComn{

	@Test(enabled=false)
	public void verifyRegistrationAndLogin() throws InterruptedException, IOException {

		Login_Index_Page obj=new Login_Index_Page(driver);
		obj.clickonsign();
		logs.info("click on sign");

		My_Account_Page obj1=new My_Account_Page(driver);
		Thread.sleep(2000);
		logs.info("click on acount page");
		obj1.enteremaialdresstextbox("shubhammahajan34@gmail.com");
		obj1.click_Creat_acct_button();

		AccounCreation_Details obj2=new AccounCreation_Details(driver);
		logs.info("fill the detail information");
		obj2.selecttitlepage();
		obj2.EnterFirstname("Shubham");
		obj2.Enterlarstname("Mahajan");
		obj2.enterpassword("Shubham123@");
		obj2.checkboxsignupnewletterclick();
		obj2.clickonregisterbutn();
		registeruseraccount obj4=new registeruseraccount (driver);	
		String username=obj4.getusername();
		Assert.assertEquals(username,"Shubham Mahajan");		
		if(username.equals("Shubham Mahajan")) {
			logs.info("verify login passs");
			Assert.assertTrue(true);
		}

		else {
			logs.info("verify login fail");
			//takescreenshot clss object creation
			UtilBase_class ob=new UtilBase_class();
			ob.capture_Screen_Shot("verifyRegistrationAndLogin");
			Assert.assertTrue(false);
		}
		//		obj2.clickonaddmyadressoption();
		//		obj2.enternameaddfirst("shubham");
		//		obj2.enternlasrnmaeadd("mahajan");
		//		obj2.enteradressnametextbox("nagpur dighori ");
		//		obj2.entercitynametextbox("nagpur");
		//		obj2.selectstate_dropdownoption("California");
		//		obj2.enterpostalcode("00000");
		//		obj2.countrydropdownselect("United States");
		//		obj2.entermobileno("9637418886");
		//		obj2.refernceadress("mumbai worli");
		//		obj2.clickonsavebutton();

	}
	@Test
	public void verifylogin() throws IOException, InterruptedException {
		Login_Index_Page obj6=new Login_Index_Page(driver);
		obj6.clickonsign();
		logs.info("click on login");
		My_Account_Page obj7=new My_Account_Page(driver);
		obj7.enteremailaddressv("shubhammahajan2495@gmail.com");
		logs.info("enter emai adess");
		obj7.entere_passwordv("Shubham123@");
		logs.info("enter password");
		obj7.clickonSigninbutn();
		logs.info("click on sign button");
		
//		registeruseraccount obj4=new registeruseraccount (driver);	
//		String username=obj4.getusername();
		String exp="My account - My Shop";
		String actu=driver.getTitle();
		
		if(actu.equals(exp)) {
			logs.info("verify login passs");
			Assert.assertTrue(true);
		}

		else {
			logs.info("verify login fail");
			//takescreenshot clss object creation
		    UtilBase_class ob=new UtilBase_class();
		   ob.capture_Screen_Shot("verifylogin1");
			Assert.assertTrue(false);
			Assert.assertEquals(actu,exp);
		}

	}

}
