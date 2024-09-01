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
 * @since December 2015
 */

public class OrderDisplayMultipleOrderlinesPricingTest 
{
	/**
	 * @description This test method submits an order with multiple order lines and later update the adisze of one of the order lines
	 * 	 - Validate price displayed for each order line (before and after the update)
	 *   - Validates the total price of the order (before and after the update)
	 * @param userData
	 * @throws Exception
	 */
	@Test(groups = {"Order1","OrderDisplayMultipleOrderlinesPricingTest"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void multiInsertionPricing(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectBU("1",6, 0);
		       newOrderInstance.enterPubDate("1","29", "Dec", "2017");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",7, 1);
		       //newOrderInstance.selectProduct("1",7, 2);
		       newOrderInstance.selectAdType("1",7, 3);
		       newOrderInstance.selectSection("1",7, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       
		       newOrderInstance.selectAdSize(1,TribuneUtils.getStringCellValues("Product", 7, 5));
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
		       Logger.info("FirstInsertion price= "+newOrderInstance.getInsertionPrice("1","total"));
		       Thread.sleep(2000);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("2",5, 0);
		       newOrderInstance.enterPubDate("2","30", "Dec", "2017");
		       newOrderInstance.selectProductType("2",5, 1);
		       newOrderInstance.selectProduct("2",5, 2);
		       newOrderInstance.selectAdType("2",5, 3);
		       newOrderInstance.selectSection("2",5, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("2");
		       /* Ad Size 2X1 Banner is no more available for selected product, hence assertion at insertion 2 is removed.
		        * 
		        */
		     //  newOrderInstance.selectAdSize(2,TribuneUtils.getStringCellValues("Product", 5, 5));
		       newOrderInstance.clickOnInsertionSalesRepSection(2);
		       newOrderInstance.addNewSalesRepOnInsertion(2, "SA00443");
		       Logger.info("SecondInsertion price "+newOrderInstance.getInsertionPrice("2", "total"));
		       Assert.assertEquals(newOrderInstance.getInsertionPrice("1","total"), TribuneUtils.getDoubleCellValues("Product", 7, 17), 0);
		      // Assert.assertEquals(newOrderInstance.getInsertionPrice("2","total"), TribuneUtils.getDoubleCellValues("Product", 5, 17), 0);
		      // double initialAmount = newOrderInstance.getInsertionPrice("1","total") + newOrderInstance.getInsertionPrice("2","total");
		      // Assert.assertEquals(newOrderInstance.getTotalOrderPrice(), initialAmount, 0);
		       Thread.sleep(1000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       String orderID = orderEntryPageInstance.getOrderID();
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       orderEntryPageInstance.clickOnOrder(orderID);
		       
		       newOrderInstance.viewInsertionDetails("2");
		       newOrderInstance.checkUncheckSalesPrice(2, true);
		       newOrderInstance.selectAdSize(2,TribuneUtils.getStringCellValues("Product", 6, 5));
		       Thread.sleep(2000);
		       Logger.info("SecondInsertion price "+newOrderInstance.getInsertionPrice("2", "total"));
		       Assert.assertEquals(newOrderInstance.getInsertionPrice("2","total"), TribuneUtils.getDoubleCellValues("Product", 6, 22), 0);
		       double updatedAmount = newOrderInstance.getInsertionPrice("1","total") + newOrderInstance.getInsertionPrice("2","total");
		       Assert.assertEquals(newOrderInstance.getTotalOrderPrice(), updatedAmount, 0);
		       
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
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
	 * @description This test method submits an order with multiple order lines and later kills one of the order lines
	 * 	 - Validate price displayed for each order line (before and after the kill)
	 *   - Validates the total price of the order (before and after the kill)
	 * @param userData
	 * @throws Exception
	 */
	@Test(groups = {"Order1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void multiInsertionKillPricing(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectBU("1",6, 0);
		       newOrderInstance.enterPubDate("1","29", "Dec", "2017");
		       newOrderInstance.selectProductType("1",7, 1);
		       newOrderInstance.selectProduct("1",7, 2);
		       newOrderInstance.selectAdType("1",7, 3);
		       newOrderInstance.selectSection("1",7, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       
		       newOrderInstance.selectAdSize(1,TribuneUtils.getStringCellValues("Product", 7, 5));
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
		       Logger.info("FirstInsertion price= "+newOrderInstance.getInsertionPrice("1","total"));
		       Thread.sleep(2000);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("2",5, 0);
		       newOrderInstance.enterPubDate("2","31", "Dec", "2017");
		       newOrderInstance.selectProductType("2",5, 1);
		       newOrderInstance.selectProduct("2",5, 2);
		       newOrderInstance.selectAdType("2",5, 3);
		       newOrderInstance.selectSection("2",5, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("2");
		       newOrderInstance.selectAdSize(2,TribuneUtils.getStringCellValues("Product", 5, 5));
		       newOrderInstance.clickOnInsertionSalesRepSection(2);
		       newOrderInstance.addNewSalesRepOnInsertion(2, "SA00443");
		       Logger.info("SecondInsertion price "+newOrderInstance.getInsertionPrice("2", "total"));
		       Assert.assertEquals(newOrderInstance.getInsertionPrice("1","total"), TribuneUtils.getDoubleCellValues("Product", 7, 17), 0);
		       Assert.assertEquals(newOrderInstance.getInsertionPrice("2","total"), TribuneUtils.getDoubleCellValues("Product", 5, 17), 0);
		       double initialAmount = newOrderInstance.getInsertionPrice("1","total") + newOrderInstance.getInsertionPrice("2","total");
		       Assert.assertEquals(newOrderInstance.getTotalOrderPrice(), initialAmount, 0);
		       Thread.sleep(1000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(2000);
		       String orderID = orderEntryPageInstance.getOrderID();
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       orderEntryPageInstance.clickOnOrder(orderID);
		       newOrderInstance.killInsertion("2");
		       Logger.info("SecondInsertion price "+newOrderInstance.getInsertionPrice("2", "total"));
		       Assert.assertEquals(newOrderInstance.getInsertionPrice("2","total"), TribuneUtils.getDoubleCellValues("Product", 5, 17), 0);
		       double updatedAmount = initialAmount - newOrderInstance.getInsertionPrice("2","total");
		       Assert.assertEquals(newOrderInstance.getTotalOrderPrice(), updatedAmount, 0);
		       
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
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
