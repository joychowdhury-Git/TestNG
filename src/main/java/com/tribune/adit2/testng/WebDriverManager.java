package com.tribune.adit2.testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {

	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	public static String browserName="";//swagata




	public static WebDriver getDriver() {
	  //  String browserName = System.getProperty("browserName");//swagata
	     browserName = System.getProperty("browserName");//swagata
		//String browserName = null;//swagata
		if (browserName == null) {
			//browserName = "firefox";//swagata
			browserName = "chrome";//swagata

		}
		WebDriver driver = WebDriverFactory.createInstance(browserName);
		driver.manage().window().maximize();
		setWebDriver(driver);
		return webDriver.get();
	}


	static void setWebDriver(WebDriver driver) {
		webDriver.set(driver);
	}

	static void quitDriver() throws IOException {
		if (webDriver.get() != null) {

			//webDriver.get().quit();
			
		
           	                                                          	

		}
	}

	 
}
