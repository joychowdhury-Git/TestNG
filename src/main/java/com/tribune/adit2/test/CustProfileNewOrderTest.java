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

import com.tribune.adit2.Customers.CustomerPage;
import com.tribune.adit2.Customers.CustomerProfilePage;
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

public class CustProfileNewOrderTest 
{
	/**
	 * This test will create a new display order from a customer profile
	 */
	@Test(groups = {"SMaintenance","CustomerProfile","SanityTestNew", "RegressionLatest","ProductionTest","custProfileNewOrder","Group3","ProductionTestPriority","TestPriority","ProductionTestCI","NewRegression","NewRegression1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void custProfileNewOrder(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnCustomerModule();
		       
		       CustomerPage customerSearchPage = PageFactory.initElements(driver, CustomerPage.class);
		       //customerSearchPage.getCustomerName(userData);
		       customerSearchPage.enterCustomerName("Test Ad Do Not Run");	
		       customerSearchPage.clickOnCustomersSearchBtn();
		       Thread.sleep(7000);
		       customerSearchPage.clickOnCustomerLink1("Test Ad Do Not Run");
		       //customerSearchPage.searchCustomerByCUNumber("CU00037236");
		       Thread.sleep(7000);
		       
		       
		       CustomerProfilePage customerProfile = PageFactory.initElements(driver, CustomerProfilePage.class);
		       customerProfile.getCustomerProfile();
		       customerProfile.clickOnNewOrder();
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		      // orderEntryPageInstance.clickOnNewGeneralOrder();
//		       newOrderInstance.selectBillToCustomerBU("bu_LAT");
//		       newOrderInstance.enterBillToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.checkUncheckOwnLocalOptOut(false);
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",6, 0);
		       Thread.sleep(4000);
				 newOrderInstance.enterPubDateFromExcel("1",29,27);
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",7, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",7, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",7, 3);
		       Thread.sleep(4000);
		      // newOrderInstance.selectSection("1",7, 4);
		     ///  Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           //newOrderInstance.removeSalesRepOnInsertion(1);
			   Thread.sleep(4000);				      
	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			   Thread.sleep(4000);
			  newOrderInstance.clickOnInsertionSalesRepSection(1);
			   Thread.sleep(4000);
		      // newOrderInstance.addServiceRep("203486");
		     //  Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       newOrderInstance.clickOnContinuePastPubDate(); //joy
		       Thread.sleep(3000);
		    //   OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       //orderEntryPageInstance.getOrderNumber();
		       dashboardPageInstance.clickondropdownforlogout();//joy
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				//Assert.fail();
				//throw e;
		   }
	   }	
}
