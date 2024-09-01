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
 * @since November 2015
 */

public class InsrtnOrderCreateNewInsertionVersionTest 
{
	/**
	 * This test performs creates a new Insertion order, creates 
	 * a new version for an existing insertion and update the version ID for the existing version
	 */
	@Test(groups = {"newInsertionVersion", "RegressionLatest","Grp1", "Reg1","Group3", "RegressionLatest1","NewRegression1","NewRegression","G3","RerunF2", "insertionOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
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
		       orderEntryPageInstance.clickOnNewInsertionOrderBtn();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.checkUncheckOwnLocalOptOut(false);
		      // newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		     //  newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",6, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","23", "Dec", "2021");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",7, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",7, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",7, 3);
		       Thread.sleep(4000);
		      // newOrderInstance.selectSection("1",7, 4);
		     ///  Thread.sleep(4000);
		       newOrderInstance.selectMMTag("1", "BlueSky");
		       Thread.sleep(4000);
		       
		       newOrderInstance.viewInsertionDetails("1");
		       //newOrderInstance.selectMaterialSource("1","NewBuild");
		       double price = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("Total price of the order placed is $"+price);
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       
		       String versionID = newOrderInstance.getInsersionVerisonID("1");
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
		       String orderID = orderEntryPageInstance.getOrderID();
		       Logger.info("Order ID: "+orderID);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       orderEntryPageInstance.clickOnOrder(orderID);
		       Thread.sleep(2000);
		       int insertionVersionBefore = newOrderInstance.getVersionsInInsertion("01");
		       newOrderInstance.createNewInsertionVersion("1");
		       newOrderInstance.addOrEditInsersionVerisonID("2", 2);
		      int insertionVersionAfter = newOrderInstance.getVersionsInInsertion("01");
		       boolean newVersionFlag = false;
		       if(insertionVersionAfter>insertionVersionBefore)
		       {
		    	   newVersionFlag = true;
		    	   Logger.info("new version is created");
		       }
		       
		  //     boolean versionIDFlag = false;
		   /*    if(versionID.equalsIgnoreCase("1"))
		       {
		    	   versionIDFlag = true;
		    	   Logger.info("versionID addition is validated");
		       }*/
		       Assert.assertEquals(newVersionFlag, true);
		 //      Assert.assertEquals(versionIDFlag, true);
		    //   newOrderInstance.clickOnInsertionSalesRepSection(1);
	           //newOrderInstance.removeSalesRepOnInsertion(1);
			//   Thread.sleep(4000);				      
	        //   newOrderInstance.addNewSalesRepOnInsertion(1, "SA02433");
			//   Thread.sleep(4000);
			//  newOrderInstance.clickOnInsertionSalesRepSection(1);
			//   Thread.sleep(4000);
			 //  newOrderInstance.applytoAllSalesRepOnInsertion(1);
			   Thread.sleep(2000);
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		      
		       Thread.sleep(3000);
		      
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
}
