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


public class OrderSelectPickUpTest 
{
	/**
	 * This test creates a new order using the pick material from a previous order placed
	 */
	@Test(groups = {"Order","newOrderPickUpMaterial"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void newOrderPickUpMaterial(Map<String, String> userData) throws Exception
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
		       WebDriverWait wait = new WebDriverWait(driver,120);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00298715");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",6, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2017");
		       newOrderInstance.selectProductType("1",7, 1);
		       newOrderInstance.selectProduct("1",7, 2);
		       newOrderInstance.selectAdType("1",7, 3);
		       newOrderInstance.selectSection("1",7, 4);
		       Thread.sleep(4000);
		       double price = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("Total price of the order placed is "+price);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.selectMaterialSource("1", "PickupWithChanges");
		       newOrderInstance.clickOnPickUpSearch();
		       Thread.sleep(2000);
		       newOrderInstance.enterFromDatePickUpWndw("12", "Dec", "2014");
		       newOrderInstance.enterOrderId("3391408");
		       newOrderInstance.clickOnSearchOrder();
		       Thread.sleep(3000);
		       newOrderInstance.clickOnOrderInPickUpWindw();
		       newOrderInstance.clickOnSelectBtnPickUpWindw();
		       Thread.sleep(2000);
		       String pickUpValue = newOrderInstance.pickUpNumValue.getAttribute("value");
		       int index = pickUpValue.indexOf("(");
		       String orderPickedUp = pickUpValue.substring(0, index);
		       boolean flag = false;
		       if(orderPickedUp.contentEquals("3391408"))
		       {
		    	   flag = true;
		    	   Logger.info("Validation success");
		       }
		       Assert.assertEquals(true, flag);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
		       newOrderInstance.submitOrder();
		       Thread.sleep(2000);
		       orderEntryPageInstance.getOrderID();
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(5000);
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
}
