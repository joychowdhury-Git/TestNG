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
 * @since February 2016 
 */

public class InsrtnOrderWithSpotNumTest 
{
	/**
	 * This test will create a new Insertion Order with spot number and 
	 * validates whether spot number field is visible for display, preprint and online orders
	 */
	@Test(groups = {"InsertionOrder"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ioDisplayWithSpotNum(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",2, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2017");
		       newOrderInstance.selectProductType("1",2, 1);
		       Thread.sleep(2000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.editColor("1", "4C");
		       boolean flag1 = newOrderInstance.checkSpotNumFieldVisibility("1");
		       newOrderInstance.enterSpot("1", 4);
		       Assert.assertEquals(flag1, true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("2",2, 0);
		       newOrderInstance.enterPubDate("2","30", "Dec", "2017");
		       newOrderInstance.selectProductType("2",9, 1);
		       newOrderInstance.viewInsertionDetails("2");
		       boolean flag2 = newOrderInstance.checkSpotNumFieldVisibility("2");
		       Assert.assertEquals(flag2, false);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("3",2, 0);
		       newOrderInstance.enterPubDate("3","30", "Dec", "2017");
		       newOrderInstance.selectProductType("3",10, 1);
		       newOrderInstance.viewInsertionDetails("3");
		       boolean flag3 = newOrderInstance.checkSpotNumFieldVisibility("3");
		       Assert.assertEquals(flag3, false);
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
