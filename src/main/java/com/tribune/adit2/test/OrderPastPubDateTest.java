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

public class OrderPastPubDateTest 
{
	/**
	 * This test will create a new order with past pub date
	 */
	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrder(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectSoldToCustomerBU("bu_CTC");
		       newOrderInstance.enterSoldToCustomer("CU00037236");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",12, 0);
		       //newOrderInstance.enterPubDate("1","29", "Nov", "2016");
		       newOrderInstance.selectProductType("1",12, 1);
		       newOrderInstance.selectProduct("1",12, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",12, 3);
		       newOrderInstance.selectSection("1",12, 4);
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
		       Thread.sleep(2000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(2000);
		       newOrderInstance.clickOnContinuePastPubDate();
		       Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(1000);
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