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

public class IODashboardDisplayCounts 
{
	/**
	 * This test clicks on new orders and verifies the order entry search page. 
	 * count of the new orders is viewed
	 */
	@Test(groups = {"DashboardIO","Regression","dashboardCounts","dashboardNewOrdersProd"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void dashboardCounts(Map<String, String> userData) throws Exception
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
		       int countOfOrders = dashboardPageInstance.getCountOfNewOrders();
		       Logger.info("countOfOrders = "+countOfOrders);
		       Thread.sleep(2000);
		       int countOfReservations = dashboardPageInstance.getCountOfReservations();
		       Logger.info("countOfReservations = "+countOfReservations);
		       Thread.sleep(2000);
		       int countOfQuote = dashboardPageInstance.getCountOfQuotes();
		       Logger.info("countOfQuotes = "+countOfQuote);
		       Thread.sleep(2000);
		       int countOfInsertionOrders = dashboardPageInstance.getCountOfInsertionOrders();
		       Logger.info("countOfInsertionOrders = "+countOfInsertionOrders);
		       Thread.sleep(2000);
		       int countOfOrdersErrorOut = dashboardPageInstance.getCountOfOrdersErrOut();
		       Logger.info("countOf Orders error out = "+countOfOrdersErrorOut);
		       Thread.sleep(2000);
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
