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


public class HFOOrderTest 
{
	/**
	 * This test will create a new HFO order that's free
	 */
	@Test(groups = {"Order","HFOmakeOrderFree","Grp4","RegressionLatest","PrioritizedReg1","Group1","HFOSPEC","TestPriority","PriorityDFP","NewRegression","NewRegression1","G1","RerunF2", "displayOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void makeOrderFree(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectOrderType("OrderType_HFO");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",23, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2021");
		       Thread.sleep(5000);
		       newOrderInstance.selectProductType("1",23, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",23, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",23, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",23, 4);
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           //newOrderInstance.removeSalesRepOnInsertion(1);
			   Thread.sleep(4000);				      
	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			   Thread.sleep(4000);
			  newOrderInstance.clickOnInsertionSalesRepSection(1);
			   Thread.sleep(4000);
			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
			   Thread.sleep(2000);
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(4000);		       
		       newOrderInstance.confirmToMakeOrderFree();
		      // Assert.assertEquals(newOrderInstance.getTotalOrderPrice(), TribuneUtils.getDoubleCellValues("Product", 23, 22), 0);
		       Thread.sleep(1000);
		       String orderID = orderEntryPageInstance.getOrderID();
		       Logger.info("OrderID "+orderID);
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Assert.assertEquals(newOrderInstance.getTotalOrderPrice(), TribuneUtils.getDoubleCellValues("Product", 23, 22), 0);
//		       Assert.assertEquals(newOrderInstance.getInsertionPrice("1", "total"), TribuneUtils.getDoubleCellValues("Product", 23, 22), 0);
		       Thread.sleep(2000);
		       dashboardPageInstance.clickondropdownforlogout(); //joy
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"Order","HFOReopenOrder","Grp4","RegressionLatest","Group1","HFOSPEC","TestPriority","PriorityVulnerability","NANT","NewRegression1","NewRegression","G1","RerunF2", "displayOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void HFOReopenOrder(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectOrderType("OrderType_HFO");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",23, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2021");
		       Thread.sleep(5000);
		       newOrderInstance.selectProductType("1",23, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",23, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",23, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",23, 4);
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           //newOrderInstance.removeSalesRepOnInsertion(1);
			   Thread.sleep(4000);				      
	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			   Thread.sleep(4000);
			  newOrderInstance.clickOnInsertionSalesRepSection(1);
			   Thread.sleep(4000);
			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
			   Thread.sleep(2000);
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(4000);
		       newOrderInstance.rejecttoMakeAnOrderFree();
		      // Assert.assertEquals(newOrderInstance.getTotalOrderPrice(), TribuneUtils.getDoubleCellValues("Product", 23, 22), 0);
		       Thread.sleep(1000);
		       String orderID = orderEntryPageInstance.getOrderID();
		       Logger.info("OrderID "+orderID);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(1000);
		       orderEntryPageInstance.clickOnOrder(orderID);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","23", "Dec", "2021");
		       Thread.sleep(5000);
		    //   newOrderInstance.selectProductType("1",43, 1);
		       newOrderInstance.selectProduct("1",32, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",32, 3);
		       Thread.sleep(4000);
		    
		       dashboardPageInstance.clickondropdownforlogout();//joy
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"Order","SPECReopenOrder","Grp4","RegressionLatest","Group1","HFOSPEC"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void SPECReopenOrder(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectOrderType("OrderType_Spec");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",23, 0);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2019");
		       newOrderInstance.selectProductType("1",23, 1);
		       newOrderInstance.selectProduct("1",23, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",23, 3);
		       newOrderInstance.selectSection("1",23, 4);
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           //newOrderInstance.removeSalesRepOnInsertion(1);
			   Thread.sleep(4000);				      
	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			   Thread.sleep(4000);
			  newOrderInstance.clickOnInsertionSalesRepSection(1);
			   Thread.sleep(4000);
			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
			   Thread.sleep(2000);
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(4000);
		       newOrderInstance.rejecttoMakeAnOrderFree();
		      // Assert.assertEquals(newOrderInstance.getTotalOrderPrice(), TribuneUtils.getDoubleCellValues("Product", 23, 22), 0);
		       Thread.sleep(1000);
		       String orderID = orderEntryPageInstance.getOrderID();
		       Logger.info("OrderID "+orderID);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(1000);
		       orderEntryPageInstance.clickOnOrder(orderID);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","23", "Dec", "2019");
		       Thread.sleep(14000);
		    //   newOrderInstance.selectProductType("1",43, 1);
		       newOrderInstance.selectProduct("1",32, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",32, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",32, 4);
		       Thread.sleep(4000);
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
