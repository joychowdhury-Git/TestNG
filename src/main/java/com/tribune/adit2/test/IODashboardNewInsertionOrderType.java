package com.tribune.adit2.test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tribune.adit2.Customers.CustomerPage;
import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Order Entry Home Page
 * @author Priyanka Goud CR 
 * @since January 2016
 */

public class IODashboardNewInsertionOrderType 
{
	/**
	 * This test clicks on new orders and verifies the order entry search page. 
	 * count of the new orders is viewed
	 */
	@Test(groups = {"DashboardIO","Regression","dashboardNewInsertionOrderType"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void dashboardNewInsertionOrderType(Map<String, String> userData) throws Exception
	{
		try
		   {
			   WebDriver driver = WebDriverManager.getDriver();
			   Logger.info("Webdriver is initiated");
			   
			   TribuneUtils utilities = new TribuneUtils();
		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
		       utilities.implementWait(driver);
		     
		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
		       signinPageinstance.login("success");
		       
		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       Thread.sleep(7000);
		       int countOfOrders = dashboardPageInstance.getCountOfInsertionOrders();
		       Logger.info("countOfOrders = "+countOfOrders);
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnInsertionOrdersLink();
		       Thread.sleep(5000);
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       String orderType = orderEntryPageInstance.getTypeSelected();
		       Logger.info("Order Type Selected By  Default is: "+orderType);
		       Assert.assertEquals(orderType,"Insertion Order"); 
		       dashboardPageInstance.clickOnLogout();
		   }
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			Assert.fail();
			throw e;
		}
	}
}
