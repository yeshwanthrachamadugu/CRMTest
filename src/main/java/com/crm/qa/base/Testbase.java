package com.crm.qa.base;
/*
 * @author: Yeshwanth
 * 
 * */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class Testbase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public Testbase(){
		try {
			prop=new Properties();
			FileInputStream fis= new FileInputStream("C:\\Users\\Yeshwant\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");


			prop.load(fis);
		}
		catch(FileNotFoundException e) {

			e.printStackTrace();
		}
		catch(IOException e) {

			e.printStackTrace();
		}


	}
	public static void initialization() throws Exception
	{
		String browser=prop.getProperty("browser");
		//if(browser=="chrome") {
		System.setProperty("webdriver.chrome.driver", "R:\\jars\\chromedriver_win32 (2)\\chromedriver.exe");
		driver=new ChromeDriver();
		//}
		//else {

		//  Start Getko Driver
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		//}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
