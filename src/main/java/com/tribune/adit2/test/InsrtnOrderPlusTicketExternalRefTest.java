package com.tribune.adit2.test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

import junit.framework.Assert;

/**
 * Page Class Modeling for Order Entry Home Page
 * @author Priyanka Goud CR 
 * @since February 2016 
 */

public class InsrtnOrderPlusTicketExternalRefTest 
{
	/**
	 * This test will create a new Insertion Order for an online product type with the default values
	 */
	@Test(groups = {"InsertionOrdercreateNewOnlineOrder", "RegressionLatest","Grp1", "Reg1","Group3","NewRegression","G3","RerunF2", "insertionOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewOnlineOrder(Map<String, String> userData) throws Exception
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
		      // newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",9, 0);
		       newOrderInstance.enterPubDate("1","28", "Dec", "2019");
		       newOrderInstance.selectProductType("1",9, 1);
		       newOrderInstance.selectProduct("1",9, 2);
		       newOrderInstance.selectAdType("1",9, 3);
		       newOrderInstance.selectSection("1",9, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.enterOnlineIODescription("1");
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
		       Thread.sleep(2000);
		       String orderID = orderEntryPageInstance.getOrderID();
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       orderEntryPageInstance.clickOnOrder(orderID);
		       boolean flag1 = newOrderInstance.checkIOExternalReferenceNo();
		       boolean flag2 = false;
		       if(flag1 = true)
		       {
		    	   String externalReferenceNo = newOrderInstance.getIOExternalReferenceNo();
		    	   Logger.info("externalReferenceNo "+externalReferenceNo);
		    	   if(externalReferenceNo.length()>0)
		    	   {
		    		   flag2 = true;
		    	   }
		    	   
		       }
		       Assert.assertEquals(true, flag1);
		       Assert.assertEquals(true, flag2);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}