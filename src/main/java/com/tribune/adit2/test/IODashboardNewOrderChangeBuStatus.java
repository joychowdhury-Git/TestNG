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
import com.tribune.adit2.OrderEntry.NewOrderPage;
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

public class IODashboardNewOrderChangeBuStatus 
{
	/**
	 * This test clicks on new orders and verifies the order entry search page. 
	 * count of the new orders is viewed
	 */
	@Test(groups = {"DashboardIO","Regression","dashboardOrderTypeChangeBuDPRStatusKilled","dashboardNewOrdersProd", "RegressionLatest","Grp1", "Reg1","Group3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void dashboardOrderTypeChangeBuDPRStatusKilled(Map<String, String> userData) throws Exception
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
		       OrderEntryHomePage orderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       int countOfOrders = dashboardPageInstance.getCountOfNewOrders();
		       Logger.info("countOfOrders = "+countOfOrders);
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnNewOrdersLink();
		       Thread.sleep(5000);
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       String orderBu = orderEntryPageInstance.getBuSelected();
		       Logger.info("BU Selected By  Default is: "+orderBu);
		       Assert.assertEquals(orderBu,"CTC-CTMG"); 
		       orderSearch.verifyOrderStatusSelectedText("All");
		       Logger.info("Status Selected By  Default is as expected ");
		      
		       orderEntryPageInstance.selectBussinessUnit("DPR-Daily Press");
		       Thread.sleep(3000);
		       orderEntryPageInstance.selectStatus("Killed");
		       Thread.sleep(3000);
		       orderEntryPageInstance.clickOnOrderSearchBtn(); 
		       Thread.sleep(55000);
		       dashboardPageInstance.clickOnNewsPaperLayoutModule();
		       Thread.sleep(4000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       Thread.sleep(4000);
		       String orderBu1 = orderEntryPageInstance.getBuSelected();
		       Logger.info("BU Selected By  Default is: "+orderBu1);
		       Assert.assertEquals(orderBu1,"DPR-Daily Press"); 
		       orderSearch.verifyOrderStatusSelectedText("Killed");
		       Logger.info("Status Selected By  Default is as expected ");
		       
		       dashboardPageInstance.clickOnLogout();
		   }
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			Assert.fail();
			throw e;
		}
	}
	
	@Test(groups = {"DashboardIO","Regression","dashboardOrderTypeChangeBuDPR","dashboardNewOrdersProd", "RegressionLatest","Grp1", "Reg1","Group3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void dashboardOrderTypeChangeBuDPR(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnNewOrdersLink();
		       Thread.sleep(5000);
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       String orderBu = orderEntryPageInstance.getBuSelected();
		       Logger.info("BU Selected By  Default is: "+orderBu);
		       Assert.assertEquals(orderBu,"CTC-CTMG"); 
		       String orderStatus= orderEntryPageInstance.getCustomerEnteredInOrderSearch();
		       Logger.info("User Selected By  Default is: "+orderStatus);
		       Assert.assertEquals(orderStatus,"Sunny Mukherjee"); 
		       orderEntryPageInstance.selectBussinessUnit("DPR-Daily Press");
		       Thread.sleep(3000);
		      // orderEntryPageInstance.selectStatus("Killed");
		      // Thread.sleep(3000);
		       orderEntryPageInstance.clickOnOrderSearchBtn(); 
		       Thread.sleep(55000);
		       orderEntryPageInstance.clickOnSearchedOrder();
		       Thread.sleep(3000);
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       String product = newOrderInstance.getProductOnInsertion(1);
		       Logger.info("Product of searched order is: "+product);
		       String productType = newOrderInstance.getProductTypeOnInsertion(1);
		       Logger.info("Product of searched order is: "+productType);
		       dashboardPageInstance.clickOnNewsPaperLayoutModule();
		       Thread.sleep(4000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       Thread.sleep(4000);
		       String orderBu1 = orderEntryPageInstance.getBuSelected();
		       Logger.info("BU Selected By  Default is: "+orderBu1);
		       Assert.assertEquals(orderBu1,"DPR-Daily Press"); 
		       String orderStatus1= orderEntryPageInstance.getCustomerEnteredInOrderSearch();
		       Logger.info("User Selected By  Default is: "+orderStatus1);
		       Assert.assertEquals(orderStatus1,"Sunny Mukherjee"); 
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
