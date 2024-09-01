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

public class IODashboardNewInsertionOrderCountUpdate 
{
	/**
	 * This test clicks on new orders and verifies the order entry search page. 
	 * count of the new orders is viewed
	 */
	@Test(groups = {"DashboardIO","Regression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void dashboardNewInsertionOrderCountUpdate(Map<String, String> userData) throws Exception
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
		       Thread.sleep(7000);
		       int countOfOrders_pre = dashboardPageInstance.getCountOfInsertionOrders();
		       Logger.info("countOfInsertionOrders initially= "+countOfOrders_pre);
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryPageInstance.clickOnNewInsertionOrderBtn();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",9, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2019");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",9, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",9, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",9, 3);
		       Thread.sleep(4000);
		     //  newOrderInstance.selectSection("1",9, 4);
		     //  Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		       newOrderInstance.enterOnlineIODescription("1");
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
		       //newOrderInstance.addSalesPerson("SA00011");
		       Thread.sleep(3000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();		       
		       Thread.sleep(5000);
		       dashboardPageInstance.clickOnDashboardModule();
		       Thread.sleep(3000);
		       int countOfOrders_post = dashboardPageInstance.getCountOfInsertionOrders();
		       Logger.info("countOfInsertionOrders after placing new insertion order= "+countOfOrders_post);
		       Thread.sleep(2000);
		       Assert.assertNotEquals(countOfOrders_pre, countOfOrders_post);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			Assert.fail();
			throw e;
		}
	}
}
