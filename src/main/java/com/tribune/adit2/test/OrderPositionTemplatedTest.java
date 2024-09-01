package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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

public class OrderPositionTemplatedTest 
{
	/* This test creates a new Order for a display product type
	 *  by selecting a specific position in the template
	 */
	@Test(groups = {"Order","orderPositionTemplated"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void orderPositionTemplated(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectBU("1",6, 0);
		       newOrderInstance.enterPubDate("1","29", "Dec", "2017");
		       newOrderInstance.selectProductType("1",7, 1);
		       newOrderInstance.selectProduct("1",7, 2);
		       newOrderInstance.selectAdType("1",7, 3);
		       newOrderInstance.selectSection("1",7, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       //newOrderInstance.selectMaterialSource("1","NewBuild");
		       newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
		       newOrderInstance.clickOnPositionSelector();
		       Thread.sleep(4000);
		       newOrderInstance.selectAdSizeForPosition();
		       Thread.sleep(3000);
		       newOrderInstance.clickOnSearchPositionInPSWindw();
		       Thread.sleep(4000);
		       newOrderInstance.selectPostionFrmPositionSlctr("10", "0, 0");
		       newOrderInstance.savePositionSelection();
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
		       Thread.sleep(3000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(2000);
		       orderEntryPageInstance.getOrderID();
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(4000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
