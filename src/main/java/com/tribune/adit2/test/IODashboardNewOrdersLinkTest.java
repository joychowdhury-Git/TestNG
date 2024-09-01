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

public class IODashboardNewOrdersLinkTest 
{
	/**
	 * This test clicks on new orders and verifies the order entry search page. 
	 * count of the new orders is viewed
	 */
	@Test(groups = {"DashboardIO","Regression","ProductionSanityTest1","ProductionTest","dashboardNewOrdersTest","TestPriority","ProductionTestCI"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void dashboardNewOrders(Map<String, String> userData) throws Exception
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
		       Thread.sleep(2000);
		       int countOfOrders = dashboardPageInstance.getCountOfNewOrders();
		       Logger.info("countOfOrders = "+countOfOrders);
		       dashboardPageInstance.clickOnNewOrdersLink();
		       Thread.sleep(10000);
		       
		       
		       OrderEntryHomePage orderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderSearch.getOrders();
		       String currentURl = driver.getCurrentUrl();
		       Logger.info("current url '"+currentURl+"'");
		       String expectedUrl = "/orders";
		       String type = orderSearch.getTypeSelected();
		       Logger.info("type selected in the order search page '"+type+"'");
		       String bookDate1 = orderSearch.getBookDate();
		       Logger.info("BookDate selected in the order search page '"+bookDate1+"'");
		     
		       orderSearch.verifyOrderStatusSelectedText("All");
		       Logger.info("status selected in the order search page as expected");
		       
		       boolean typeFlag = false;
		       boolean urlFlag = false;
		      
		       if(currentURl.endsWith(expectedUrl))
		       {
		    	   urlFlag = true;
		    	   Logger.info("Url Validation success");
		       }
		       if(type.equalsIgnoreCase("Order"))
		       {
		    	   typeFlag = true;
		    	   Logger.info("type Validation success"); 
		       }
		  
		       
		      Assert.assertEquals(urlFlag, true);
		       Assert.assertEquals(typeFlag, true);
		      
		      
		       
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
