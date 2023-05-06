package com.Banking.Utilities;

import java.util.Properties;
import java.io.*;

public class ReadConfig {

	Properties pro;
	public ReadConfig()
	{
		File f= new File("./Configuration/config.properties");
		
		try 
		{
		FileInputStream fis = new FileInputStream(f);
		pro = new Properties();
		pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is : "+e.getMessage());
		}
	}
	
	public String getApplicationUrl()
	{
		String url = pro.getProperty("baseurl");
		return url;
	}
	
	public String getUsername()
	{
		String uname = pro.getProperty("uname");
		return uname;
	}
	
	public String getPassword()
	{
		String pwd = pro.getProperty("pwd");
		return pwd;
	}
}
