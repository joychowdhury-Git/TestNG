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
 * @author Sunny 
 * @since May 2017
 */

public class InsrtnOrderConvertToOrder 
{
	/**
	 * This test performs searches for an order with single insertion
	 * and converts the existing insertion into order
	 */
	@Test(groups = {"convertInsertion","SanityTestNew", "RegressionLatest","Grp1","PrioritizedReg1", "Reg1","ProductionTest","Group3","TestPriority","PriorityDFP","PriorityVulnerability","ProductionTestCI","ProdTestCI","NANT","NewRegression1","NewRegression","G3", "insertionOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	   public void convertInsertion(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewInsertionOrderBtn();
		       Thread.sleep(2000);
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.enterComments();
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",2, 0);
		       Thread.sleep(4000);
		      // newOrderInstance.enterPubDateFromExcel("1",60,27);
		       newOrderInstance.enterPubDate("1","23", "Dec", "2021");
		       //newOrderInstance.validateListOfProductTypes("1");
		       Thread.sleep(2000);
		       newOrderInstance.selectProductType("1",2, 1);
		       Thread.sleep(2000);
		       newOrderInstance.selectProduct("1",2, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",2, 3);
		       //Thread.sleep(2000);
		       //newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           //newOrderInstance.removeSalesRepOnInsertion(1);
			   Thread.sleep(4000);				      
	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			   Thread.sleep(4000);
			  newOrderInstance.clickOnInsertionSalesRepSection(1);
			 //  Thread.sleep(4000);
			 //  newOrderInstance.applytoAllSalesRepOnInsertion(1);
			   Thread.sleep(2000);
		       Thread.sleep(4000);
		      // newOrderInstance.addServiceRep("203486");
			//   Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(1000);
		       WebDriverWait wait = new WebDriverWait(driver,120);
		       
		       String orderID = orderEntryPageInstance.getOrderID();
		       Logger.info("Order: "+orderID);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       
		       
		       orderEntryPageInstance.clickOnOrder(orderID);
		       
		       NewOrderPage orderViewPage = PageFactory.initElements(driver, NewOrderPage.class);
		       wait.until(ExpectedConditions.visibilityOf(orderViewPage.orderViewPageElement));
		       orderViewPage.convertInsertion();
		       Thread.sleep(5000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(1000);
		      // String orderID = orderEntryPageInstance.getOrderID();
		      //orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		     // Thread.sleep(3000);
		      //WebDriverWait wait = new WebDriverWait(driver,120);
		      orderEntryPageInstance.getOrderNumber();
		    //   orderEntryPageInstance.clickOnOrder(orderID);
		    //   Thread.sleep(5000);
		    //   newOrderInstance.verifyFieldsUneditable();
		    //   Thread.sleep(2000);
		   //    dashboardPageInstance.clickOnLogout();
		      
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
}
