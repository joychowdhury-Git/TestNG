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

public class InsrtnOrderMultiInsertionWZoneTest 
{
	/* This test creates a new multi insertion with zones insertion order
	 */
	@Test(groups = {"insrtnOrderMultiInsertionWZone"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void insrtnOrderMultiInsertionWZone(Map<String, String> userData) throws Exception
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
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createMultiInsertionWZones();
		       Thread.sleep(2000);
		       newOrderInstance.selectBUZones(7, 0);
		       newOrderInstance.enterPubDateZones("20", "Dec", "2017");
		       newOrderInstance.selectProductTypeZones(7, 1);
		       newOrderInstance.selectProductZones(7, 2);
		       newOrderInstance.selectSectionZones(7, 4);
		       newOrderInstance.selectAdTypeZones(7, 3);
		       newOrderInstance.selectZoneMultiInsrtn("Full Run");
		       newOrderInstance.selectZoneMultiInsrtn("WSCESB");
		       newOrderInstance.saveZoneSelectionMultiInsrtn();
		       Thread.sleep(2000);
		       int insertionCount = newOrderInstance.getInsertionsCount();
		       boolean flag = false;
		       if(insertionCount==2)
		       {
		    	   flag = true;
		    	   Logger.info("Insertions count validation success");
		       }
		       Thread.sleep(1000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.selectMaterialSource("1","New Build");
		       String zoneInsertion1 = newOrderInstance.getZone("1");
		       newOrderInstance.viewInsertionDetails("2");
		       newOrderInstance.selectMaterialSource("2","New Build");
		       String zoneInsertion2 = newOrderInstance.getZone("2");
		       boolean zone1Flag = false;
		       boolean zone2Flag = false;
		       if(zoneInsertion1.equalsIgnoreCase("Full Run"))
		       {
		    	   zone1Flag = true;
		    	   Logger.info("First insertion zone validation success");
		       }
		       if(zoneInsertion2.equalsIgnoreCase("WSCESB"))
		       {
		    	   zone2Flag = true;
		    	   Logger.info("Second insertion zone validation success");
		       }
		       Assert.assertEquals(zone1Flag, true);
		       Assert.assertEquals(zone2Flag, true);
		       Assert.assertEquals(flag, true);
		       //newOrderInstance.addSalesPerson("SA00011");
		       double price1 = newOrderInstance.getInsertionPrice("1", "total");
		       newOrderInstance.editAutoAdjustPrice("1",""+price1);
		       double price2 = newOrderInstance.getInsertionPrice("2", "total");
		       newOrderInstance.editAutoAdjustPrice("2",""+price2);

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
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       orderEntryPageInstance.getOrderNumber();
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
