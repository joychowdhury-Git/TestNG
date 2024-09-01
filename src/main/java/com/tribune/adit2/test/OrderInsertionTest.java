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
 * @since January 2015
 */

public class OrderInsertionTest 
{
	/**
	 * This test performs searches for an order and creates 
	 * a duplicate insertion for an order 
	 */
	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void duplicateInsertion(Map<String, String> userData) throws Exception
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
		       
		       OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       basicOrderSearch.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",9, 0);
		       newOrderInstance.enterPubDate("1","21", "Dec", "2019");
		       newOrderInstance.selectProductType("1",9, 1);
		       newOrderInstance.selectProduct("1",9, 2);
		       newOrderInstance.selectAdType("1",9, 3);
		       Thread.sleep(5000);
		       newOrderInstance.selectSection("1",9, 4);
		       Thread.sleep(4000);
		       /*newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.enterOnlineIODescription("1");
		       newOrderInstance.addSalesPerson("SA00011");*/
		       Logger.info("First insertion number version "+newOrderInstance.getVersionsInInsertion("1"));
		       Logger.info("First insertion Material ID "+newOrderInstance.getMaterialID("1"));
		     //  newOrderInstance.clickOnInsertionSalesRepSection(1);
		     //  newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
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
		       Thread.sleep(2000);
		      newOrderInstance.submitOrder();
		       Thread.sleep(1000);
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       String orderID = orderEntryPageInstance.getOrderID();
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Logger.info(orderEntryPageInstance.getOrderID());
		       Thread.sleep(1000);
		       
		       orderEntryPageInstance.clickOnOrder(orderID);
		       
		       
		       NewOrderPage orderViewPage = PageFactory.initElements(driver, NewOrderPage.class);
		       WebDriverWait wait = new WebDriverWait(driver,120);
		       wait.until(ExpectedConditions.visibilityOf(orderViewPage.orderViewPageElement));
		       int totalInsertiosnBeforeAction = orderViewPage.getInsertionsCount();
		       Logger.info("totalInsertiosnBeforeAction : "+totalInsertiosnBeforeAction);

			      newOrderInstance.createDuplicateInsertion("1");
			      Thread.sleep(4000);	
		       int totalInsertiosnAfterAction = orderViewPage.getInsertionsCount();
		       Logger.info("totalInsertiosnAfterAction : "+totalInsertiosnAfterAction);
		       if(totalInsertiosnAfterAction>totalInsertiosnBeforeAction)
		       {
		    	   Logger.info("An insertion is made");
		       }
		       
		 //      orderViewPage.validateDuplicateInsertion("1");
		       Thread.sleep(2000);
		       Logger.info("Duplicate insertion number "+orderViewPage.getInsertionNumber(2));
		       Logger.info("Duplicate insertion number version "+orderViewPage.getVersionsInInsertion("2"));
		       Logger.info("Duplicate insertion Material ID "+orderViewPage.getMaterialID("2"));
		       Logger.info("Duplicate insertion Sales Rep "+orderViewPage.getSalesRepOnInsertion(2));
		       Assert.assertEquals(orderViewPage.getInsertionPrice("2", "total"), orderViewPage.getInsertionPrice("1", "total"), 0.00);
		       Assert.assertEquals(orderViewPage.getInsertionNumber(2), orderViewPage.getInsertionNumber(1)+1);
		       Assert.assertEquals(orderViewPage.getVersionsInInsertion("2"), orderViewPage.getVersionsInInsertion("1"));
		       Assert.assertEquals(orderViewPage.getMaterialID("2"), orderViewPage.getMaterialID("1"));
		       Assert.assertEquals(orderViewPage.getSalesRepOnInsertion(2), orderViewPage.getSalesRepOnInsertion(1));
		       
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	
	/**
	 * This test performs creates a new order, creates 
	 * a new version for an existing insertion and update the version ID for the existing version
	 */
	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void newInsertionVersion(Map<String, String> userData) throws Exception
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
		       newOrderInstance.enterPubDate("1","24", "Dec", "2019");
		       newOrderInstance.selectProductType("1",2, 1);
		       newOrderInstance.selectProduct("1",2, 2);
		       newOrderInstance.selectAdType("1",2, 3);
		       newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       double price = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("Total price of the order placed is $"+price);
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       Thread.sleep(2000);
		       String versionID = newOrderInstance.getInsersionVerisonID("1");
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
		       Thread.sleep(1000);
		      
		       String orderID = orderEntryPageInstance.getOrderID();
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		      
		       Thread.sleep(1000);
		       
		       orderEntryPageInstance.clickOnOrder(orderID);
		       int insertionVersionBefore = newOrderInstance.getVersionsInInsertion("01");
		       newOrderInstance.createNewInsertionVersion("1");
		       newOrderInstance.addOrEditInsersionVerisonID("2", 2);
		       Thread.sleep(2000);
		      int insertionVersionAfter = newOrderInstance.getVersionsInInsertion("01");
		       boolean newVersionFlag = false;
		       if(insertionVersionAfter>insertionVersionBefore)
		       {
		    	   newVersionFlag = true;
		    	   Logger.info("new version is created");
		       }
		       
		       boolean versionIDFlag = false;
		       if(versionID.equalsIgnoreCase("1"))
		       {
		    	   versionIDFlag = true;
		    	   Logger.info("versionID addition is validated");
		       }
		     //  newOrderInstance.validateDuplicateInsertion("1");
		       Thread.sleep(2000);
		       Logger.info("new insertion number "+newOrderInstance.getInsertionNumber(2));
		       Logger.info("new insertion number version "+newOrderInstance.getVersionsInInsertion("02"));
		       Logger.info("new insertion Material ID "+newOrderInstance.getMaterialID("2"));
		       Logger.info("new insertion Sales Rep "+newOrderInstance.getSalesRepOnInsertion(2));		       		       
		       Assert.assertEquals(newVersionFlag, true);
		       Assert.assertEquals(versionIDFlag, true);
		       /*newOrderInstance.clickOnInsertionSalesRepSection(2);
		       newOrderInstance.addNewSalesRepOnInsertion(2, "SA00443");*/
		       Thread.sleep(2000);		      
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
}
