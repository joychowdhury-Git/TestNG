package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

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

public class OrderChangeWithLockUnlockSalesPriceTest 
{
	
	/**
	 * This test will create a new order and change the color 
	 * of the layout by unlocking the sales price
	 */
	@Test(groups = {"Order","newOrderUnlockSalesPrice"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void newOrderUnlockSalesPrice(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnOrderEntryModule();
		       
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",2, 0);
		       newOrderInstance.enterPubDate("1","31", "Dec", "2017");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",2, 1);
		       newOrderInstance.selectProduct("1",2, 2);
		       newOrderInstance.selectAdType("1",2, 3);
		       newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(2000);
		       double priceBeforeEdit = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("Total price of the order placed is "+priceBeforeEdit);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.selectMaterialSource("1","NewBuild");
		       double salesPriceBeforeEdit = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("Sales price before editing " +salesPriceBeforeEdit);
		       newOrderInstance.checkUncheckSalesPrice(1,true);
		       newOrderInstance.editColor("1","4C");
		       Thread.sleep(2000);
		       double priceAfterEdit = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("Total price of the order placed is "+priceAfterEdit);
		       if(priceBeforeEdit!=priceAfterEdit)
		       {
		    	   Logger.info("Validation Success - Total price is changed");
		       }
		   	   Assert.assertNotEquals(priceBeforeEdit, priceAfterEdit);
		   	   newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
		   	   Thread.sleep(3000);
		       //newOrderInstance.addSalesPerson("SA00011");
		       newOrderInstance.submitOrder();
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * This test will create a new order and change the color 
	 * of the layout by locking the sales price
	 */
	@Test(groups = {"Order","newOrderLockSalesPrice"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void newOrderLockSalesPrice(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnOrderEntryModule();
		       
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",2, 0);
		       newOrderInstance.enterPubDate("1","31", "Dec", "2017");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",2, 1);
		       newOrderInstance.selectProduct("1",2, 2);
		       newOrderInstance.selectAdType("1",2, 3);
		       newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(2000);
		       double priceBeforeEdit = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("Total price of the order placed is "+priceBeforeEdit);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.selectMaterialSource("1","NewBuild");
		       double salesPriceBeforeEdit = newOrderInstance.getInsertionPrice("1","sales");
		       Logger.info("Sales price before editing" +salesPriceBeforeEdit);
		       boolean salesPriceToolTipFlag1 = newOrderInstance.getSalesPriceToolTip(1);
		       newOrderInstance.checkUncheckSalesPrice(1, false);
		       boolean salesPriceToolTipFlag2 = newOrderInstance.getSalesPriceToolTip(1);
		       newOrderInstance.editColor("1","4C");
		       Assert.assertEquals(salesPriceToolTipFlag1, true);
		       Assert.assertEquals(salesPriceToolTipFlag2, true);
		       Thread.sleep(2000);
		       double priceAfterEdit = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("Total price of the order placed is "+priceAfterEdit);
		       if(priceBeforeEdit==priceAfterEdit)
		       {
		    	   Logger.info("Validation Success - Total price is not changed");
		       }
		 	   Assert.assertEquals(priceBeforeEdit, priceAfterEdit);
		 	   Thread.sleep(3000);
		       newOrderInstance.submitOrder();
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}