package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

import junit.framework.Assert;

/**
 * Page Class Modeling for Order Entry Home Page
 * @author Priyanka Goud CR 
 * @since December 2015
 */

public class LoginFailureTest 
{
	/**
	 * This test login to Adit 2.0 with invalid credentials
	 */
	@Test(groups = {"Login"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void loginFailure(Map<String, String> userData) throws Exception
	{
		try
		   {
			   WebDriver driver = WebDriverManager.getDriver();
			   Logger.info("Webdriver is initiated");
			   
			   TribuneUtils utilities = new TribuneUtils();
		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
		       utilities.implementWait(driver);
		       
		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
		       signinPageinstance.login("failure");
		       
		       WebElement element = driver.findElement(By.xpath("//div[@class='text-danger wrapper text-center ng-binding']"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   flag = true;
		    	   Logger.info("login failed");
		    	   Logger.info("Error message displayed is as below");
		    	   Logger.info("'"+element.getText()+"'");
		       }
		       Assert.assertEquals(true, flag);
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
