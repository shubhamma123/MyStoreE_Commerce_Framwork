package com.myStore.UtilityLayer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.myStore.TestbaseLayer.TestBaseComn;

public class Extent_Listners_class extends  TestBaseComn implements ITestListener{
	ReadConfig config=new ReadConfig(); //browser read and name mention in systen
	
	ExtentSparkReporter  htmlreport;
	ExtentReports reports;
	ExtentTest test;
	 
	public void configure() {
		String timestamp=new SimpleDateFormat("yyyy.mm.dd  hh.mm.ss").format(new Date());
		String reportfileName="MyStoreApplication-"+timestamp+".html";
		htmlreport= new ExtentSparkReporter(System.getProperty("user.dir")+"//ReportFolder//" +reportfileName);  //  note:-according path change kar sakata ha/
		 reports=new ExtentReports();
		 reports.attachReporter(htmlreport);
		 
		 //add system informations
		 reports.setSystemInfo("Machine", "testpc1");
		 reports.setSystemInfo("os", "windows");
		 reports.setSystemInfo("browser",  config.getBrowser1());
		 reports.setSystemInfo("name", "shubham");
		 
		 //configure look and feel to change 
		 htmlreport.config().setDocumentTitle("Extent report");
		 htmlreport.config().setReportName("this my report first shubham");
		 htmlreport.config().setTheme(Theme.STANDARD);
		 htmlreport.config().setTimeStampFormat("mm yyyy dd  hh mm sss");
		 
	}
	

	@Override
	//onstart method when any test starts
	public void onTestStart(ITestResult result) {
		System.out.println("On test start method ....."+ result.getName());
		
	}	

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On pass of the method....."+ result.getName());
		test= reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("test case pass" +result.getName(),ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Ontest failed of the method ....." +result.getName());
		UtilBase_class base_class=new UtilBase_class();
		try {
			base_class.capture_Screen_Shot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test= reports.createTest(result.getName()); // Extent Report create entery in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("test case failed " +result.getName(),ExtentColor.RED));	
		
		//test.addScreenCaptureFromPath
		
		String screenshotpath=System.getProperty("user.dir")+"\\ScreenShotFolder\\"+result.getName()+".png";
		File Screenshotfile = new File(screenshotpath);
		if(Screenshotfile.exists()) {
			test.fail("capture screenshot is below" + test.addScreenCaptureFromPath(screenshotpath));
		}
		
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Ontest skipped method ....."+ result.getName());
		test= reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("test case skiiped " +result.getName(),ExtentColor.YELLOW));
	}
		

	@Override
	public void onStart(ITestContext context) {
		configure();
		System.out.println("on start method start");
	}


	@Override
	public void onFinish(ITestContext context) {
		System.out.println("finish method ");
		reports.flush();  //it is mandatory to call flush method to ensure information
			
	}	
}	

	
	

	

