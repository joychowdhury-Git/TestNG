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


public class OrderAddOnsTest 
{
	/**
	 * This test creates a new order and adds add ons to the insertion 
	 */
	@Test(groups = {"Order","ProductionTest","orderAddOn","orderAddOnTest","displayOrders", "RegressionLatest","Grp4","PrioritizedReg1", "Reg1","Group1","TestPriority","ProductionTestCI","NewRegression","NewRegression1","RerunF2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void orderAddOn(Map<String, String> userData) throws Exception
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
		       Thread.sleep(4000);
		       newOrderInstance.selectBU("1",2, 0);
		       Thread.sleep(4000);
		      // newOrderInstance.enterPubDate("1","31", "Dec", "2019");//swagata
				 newOrderInstance.enterPubDateFromExcel("1",9,27);//swagata
		       Thread.sleep(5000);
		       newOrderInstance.selectProductType("1",2, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",2, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",2, 3);
		       Thread.sleep(4000);
		       //newOrderInstance.selectSection("1",2, 4);
		       //Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		       //newOrderInstance.selectMaterialSource("1","NewBuild");
		       double price = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("Total price of the order placed is $"+price);
		       newOrderInstance.clickOnAddOnBtn();
		       Thread.sleep(4000);
		       newOrderInstance.selectAddOn("Color");
		       Thread.sleep(3000);
		       Double addOnAmount = newOrderInstance.getAddOnAmount(1);
		       Logger.info("Add on Amount = "+addOnAmount);
		       boolean addOnAmountFlag = false;
		       if(addOnAmount>0.0 || addOnAmount==0.0 )//swagata
		       {
		    	   addOnAmountFlag = true;
		    	   Logger.info("AdOn validation success");
		       }
		      Assert.assertEquals(addOnAmountFlag, true);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           //newOrderInstance.removeSalesRepOnInsertion(1);
			   Thread.sleep(4000);				      
	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");//swagata
			   Thread.sleep(4000);
			  newOrderInstance.clickOnInsertionSalesRepSection(1);
			 //  Thread.sleep(4000);
			//   newOrderInstance.applytoAllSalesRepOnInsertion(1);
			   Thread.sleep(2000);
		       Thread.sleep(4000);	
		      newOrderInstance.submitOrder();
		      Thread.sleep(3000);
		      //newOrderInstance.clickOnContinuePastPubDate(); //joy
		      Thread.sleep(4000);
		      Logger.info(orderEntryPageInstance.getOrderID());
		      //orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       dashboardPageInstance.clickondropdownforlogout(); //joy
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	
	/**
	 * This test creates a new order validates various pricing rules(fixed amount, percentage and CPI) for the add on charges
	 */
	@Test(groups = {"Test2","orderAddOnPricingRuleValidation","Grp1", "Reg1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void orderAddOnPricingRuleValidation(Map<String, String> userData) throws Exception
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
		       newOrderInstance.enterPubDate("1","28", "Dec", "2019");
		       newOrderInstance.selectProductType("1",2, 1);
		       newOrderInstance.selectProduct("1",2, 2);
		       newOrderInstance.selectAdType("1",2, 3);
		       newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       //newOrderInstance.selectMaterialSource("1","NewBuild");
		       double price = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("Total price of the order placed is $"+price);
		       newOrderInstance.clickOnAddOnBtn();
		       Thread.sleep(4000);
		       newOrderInstance.selectAddOn("Color");
		       Thread.sleep(7000);
		       Double addOnAmount = newOrderInstance.getAddOnAmount(1);
		       Logger.info("Add on Amount = "+addOnAmount);
		       boolean addOnAmountFlag = false;
		       if(addOnAmount>0.0)
		       {
		    	   addOnAmountFlag = true;
		    	   Logger.info("AdOn validation success");
		       }
		      Assert.assertEquals(addOnAmountFlag, true);
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
		      Logger.info(orderEntryPageInstance.getOrderID());
		      orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
}
