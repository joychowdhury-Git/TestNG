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
 * @since January 2016
 */

public class IODashboardCustomerLinkTest 
{
	/**
	 * This test clicks on a the customer link and validates whether customer profile page for
	 * that customer is loaded
	 */
	@Test(groups = {"DashboardIO","Regression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void dashboardIOCustomerProfile(Map<String, String> userData) throws Exception
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
		       newOrderInstance.clickOnNewCustomer();
		       String customerName = newOrderInstance.enterCustomerInfo("CustomerInfo");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       //newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",2, 0);
		       newOrderInstance.enterPubDate("1","31", "Dec", "2017");
		       newOrderInstance.selectProductType("1",2, 1);
		       Thread.sleep(2000);
		       newOrderInstance.selectProduct("1",2, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",2, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(2000);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00011");
		       /*newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.selectMaterialSource("1","NewBuild");*/
		       newOrderInstance.clickOnInsertionSalesRepSection(2);
		       newOrderInstance.addNewSalesRepOnInsertion(2, "SA00011");
		       newOrderInstance.addSalesPerson("SA00011");
		       newOrderInstance.submitOrder();
		       Thread.sleep(2000);
		      // newOrderInstance.continueWithProvidedAddress();
		      // Thread.sleep(2000);
		       newOrderInstance.confirmProvidedAddress();
		       Thread.sleep(5000);
		       orderEntryPageInstance.getOrderID();
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       orderEntryPageInstance.getOrders();
		       
		       dashboardPageInstance.clickOnDashboardModule();
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnCustomerLink(customerName);
		       
		       CustomerProfilePage customerProfile =  PageFactory.initElements(driver, CustomerProfilePage.class);
		       customerProfile.getCustomerProfile();
		       String custName = customerProfile.getCustomerName();
		       
		       boolean custProfileFlag = false;
		       if(custName.equalsIgnoreCase(customerName))
		       {
		    	   custProfileFlag = true;
		    	   Logger.info("customer profile Validation success");
		       }
		       Assert.assertEquals(custProfileFlag, true);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
