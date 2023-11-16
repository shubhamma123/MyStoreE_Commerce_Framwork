package com.myStore.UtilityLayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties propertie;

	String path = "C:\\Users\\shubh\\eclipse-workspace\\.metadata\\.metadata\\CodeStudio_DataDrivenFrameWork_Framework_Sessions\\ConFiguration.properties\\config2.property";

	//constructor
	public ReadConfig() {
		try {
			propertie = new Properties();

			FileInputStream  fis = new FileInputStream(path);
			propertie.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public String getBaseUrl3()
	{
		String value = propertie.getProperty("baseUrl");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");

	}
	public String getBrowser1()
	{
		String value = propertie.getProperty("browser");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");

	}
	public String getEmail()
	{
		String email = propertie.getProperty("email");
		if(email!=null)
			return email;
		else
			throw new RuntimeException("email not specified in config file.");

	}

	public String getPassword()
	{
		String password = propertie.getProperty("password");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("password not specified in config file.");
}
}
