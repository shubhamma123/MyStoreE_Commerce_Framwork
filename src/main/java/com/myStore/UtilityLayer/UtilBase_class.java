package com.myStore.UtilityLayer;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.myStore.TestbaseLayer.TestBaseComn;

public class UtilBase_class extends TestBaseComn {

	public  void capture_Screen_Shot(String testname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver ;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir") +"\\ScreenShotFolder\\"+testname+".png");

		FileUtils.copyFile(src, des);
	}
	
	public String gettext_Message(WebElement element) {
		
		return element.getText();
	}
	
	public String GetTilePages() {
		return driver.getTitle();
	}
	
	
	
}