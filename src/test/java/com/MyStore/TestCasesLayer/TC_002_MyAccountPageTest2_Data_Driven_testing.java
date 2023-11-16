package com.MyStore.TestCasesLayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.myStore.PageObjectLayer.AccounCreation_Details;
import com.myStore.PageObjectLayer.Login_Index_Page;
import com.myStore.PageObjectLayer.My_Account_Page;
import com.myStore.PageObjectLayer.registeruseraccount;
import com.myStore.TestbaseLayer.TestBaseComn;
import com.myStore.UtilityLayer.ReadExcelFile_DataPRovider;
import com.myStore.UtilityLayer.UtilBase_class;

public class TC_002_MyAccountPageTest2_Data_Driven_testing extends TestBaseComn{

	@Test(dataProvider="logindataprovider",enabled = false)
	public void verifyRegistrationAndLogin(String fname,String lname,String emailad,String password,String acepted) throws InterruptedException, IOException {

		Login_Index_Page obj=new Login_Index_Page(driver);
		obj.clickonsign();
		logs.info("click on sign");

		My_Account_Page obj1=new My_Account_Page(driver);
		Thread.sleep(2000);
		logs.info("click on acount page");
		obj1.enteremaialdresstextbox(emailad);
		obj1.click_Creat_acct_button();

		AccounCreation_Details obj2=new AccounCreation_Details(driver);
		logs.info("fill the detail information");
		obj2.selecttitlepage();
		obj2.EnterFirstname(fname);
		obj2.Enterlarstname(lname);
		obj2.enterpassword(password);
		obj2.checkboxsignupnewletterclick();
		obj2.clickonregisterbutn();
		registeruseraccount obj4=new registeruseraccount (driver);	
		String username=obj4.getusername();
		
		Assert.assertEquals(username,acepted);		
		if(username.equals(acepted)) {
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
		

	}
	@Test(dataProvider="logindataprovider",dataProviderClass = ReadExcelFile_DataPRovider.class)
	public void verifylogin(String useremail,String password,String expected) throws IOException, InterruptedException {
		Login_Index_Page obj6=new Login_Index_Page(driver);
		obj6.clickonsign();
		logs.info("click on login");
		My_Account_Page obj7=new My_Account_Page(driver);
		obj7.enteremailaddressv(useremail);
		logs.info("enter emai adess");
		obj7.entere_passwordv(password);
		logs.info("enter password");
		obj7.clickonSigninbutn();
		logs.info("click on sign button");
		
		registeruseraccount obj4=new registeruseraccount (driver);
		String username=obj4.getusername();
		
//		String exp="My account - My Shop";
//		String actu=driver.getTitle();
		
		if(username.equals(expected)) {
			logs.info("verify login passs");
			Assert.assertTrue(true);
			
			obj4.ClickSignoutbutton();
		}

		else {
			logs.info("verify login fail");
			Assert.assertTrue(false);
			//takescreenshot clss object creation
		    UtilBase_class ob=new UtilBase_class();
		   ob.capture_Screen_Shot("verifylogin3");
			
			//Assert.assertEquals(username,expected);
		}
		

	}
	//important note:- this data provide in other class maintan "ReadExcelFile_DataPRovider.java" maintain data class
	
//	@DataProvider(name="logindataprovider")
//	public String[][] dataprovide() throws IOException{
//		String pathfile=System.getProperty("user.dir")+"\\TestDataStore\\DataExcel.xlsx";
//		int ttrow=ReadExcelFile_DataPRovider.getrowcount(pathfile, "Sheet1");
//		int ttcom=ReadExcelFile_DataPRovider.getcolmcunt(pathfile, "Sheet1");
//		String [][] data=new String[ttrow-1][ttcom];
//		 for(int i=1;i<ttrow;i++) {
//			 for(int j=0;j<ttcom;j++) {
//				 
//				 data[i-1][j]=ReadExcelFile_DataPRovider.ReadDataExcelSheetcellvalue(pathfile,"Sheet1",i,j );
//			 }
//		 }
//			 
//		return data;
//	}


}
