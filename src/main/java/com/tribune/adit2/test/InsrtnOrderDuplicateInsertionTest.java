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

public class InsrtnOrderDuplicateInsertionTest 
{
	/**
	 * This test performs searches for an order and creates 
	 * a duplicate insertion for an insertion order 
	 */
	@Test(groups = {"InsertionOrder"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
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
		       basicOrderSearch.clickOnNewInsertionOrderBtn();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",9, 0);
		       newOrderInstance.enterPubDate("1","29", "Dec", "2017");
		       newOrderInstance.selectProductType("1",9, 1);
		       newOrderInstance.selectProduct("1",9, 2);
		       newOrderInstance.selectAdType("1",9, 3);
		       Thread.sleep(1000);
		       newOrderInstance.selectSection("1",9, 4);
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       String orderNum = basicOrderSearch.getOrderID();
		       basicOrderSearch.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       basicOrderSearch.enterOrderNumber(orderNum);
		       basicOrderSearch.clickOnOrderSearchBtn();
		       Thread.sleep(2000);
		       basicOrderSearch.clickOnOrder(orderNum);
		       
		       NewOrderPage orderViewPage = PageFactory.initElements(driver, NewOrderPage.class);
		       WebDriverWait wait = new WebDriverWait(driver,120);
		       wait.until(ExpectedConditions.visibilityOf(orderViewPage.orderViewPageElement));
		       int totalInsertiosnBeforeAction = orderViewPage.getInsertionsCount();
		       Logger.info("totalInsertiosnBeforeAction : "+totalInsertiosnBeforeAction);
		       orderViewPage.createDuplicateInsertion("1");
		       int totalInsertiosnAfterAction = orderViewPage.getInsertionsCount();
		       Logger.info("totalInsertionsAfterAction : "+totalInsertiosnAfterAction);
		       if(totalInsertiosnAfterAction>totalInsertiosnBeforeAction)
		       {
		    	   Logger.info("An insertion is made");
		       }
		       
		       orderViewPage.validateDuplicateInsertion("1");
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
		       orderViewPage.submitOrder();
		       Thread.sleep(4000);
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
}
