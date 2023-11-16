package com.myStore.TestbaseLayer;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;

import com.beust.jcommander.Parameter;
import com.myStore.UtilityLayer.ReadConfig;
import com.myStore.UtilityLayer.UtilBase_class;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseComn{	

	public static WebDriver driver;
	public static Logger logs;
	ReadConfig config=new ReadConfig();
	String url=config.getBaseUrl3();
	String broswers=config.getBrowser1();
	public String emailad=config.getEmail();
	public String password=config.getPassword();
	
	
	
	public UtilBase_class Util_base;




	@BeforeClass
	public void setup() throws InterruptedException
	{
		//launch browser
		switch(broswers.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}

		Util_base=new  UtilBase_class();

		//implicity waits//

		driver.get(url);



		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 

		driver.manage().window().maximize();

		//logger for logs

		logs = LogManager.getLogger("CodeStudio_DataDrivenFrameWork_Framework_Sessions");

	}
	@AfterClass
	public void teardown() {
		driver.close();
		driver.quit();
	}

}






//