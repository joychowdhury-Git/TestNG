package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.WebDriver;
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

public class OrderWithHiveId {
	
	
	/**
	 * Validate after "copy to IO" an IO order HIVE ID and HIVE line id both gets blank
	 *
	 *///swagata
	
	@Test(groups = {"hiveIDBlanksCopyIO","insertionOrders","HiveId","NewRegression3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void hiveIDBlanksCopyIO(Map<String, String> userData) throws Exception
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
			Thread.sleep(2000);

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.enterComments();
			String HiveId= newOrderInstance.enterHiveId();
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",17, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",17,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",17, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",17, 2);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			String HiveLineId=newOrderInstance.enterHiveLineId();
			newOrderInstance.collapseInsertionDetails("1");
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			newOrderInstance.submitOrder();
			/*newOrderInstance.clickYesLegacyAutoInsertionCreation();
			Thread.sleep(1000);
			

			String orderID = orderEntryPageInstance.getOrderNumber();*/
			newOrderInstance.ClickContinueButton();
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order: "+orderID);
			Thread.sleep(3000);


			orderEntryPageInstance.clickOnOrder(orderID);
			WebDriverWait wait = new WebDriverWait(driver,120);
			wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement));
			Assert.assertEquals( newOrderInstance.getHiveId(), HiveId); 
			newOrderInstance.viewInsertionDetails("1");
			Assert.assertEquals( newOrderInstance.getHiveLineId(), HiveLineId);
			newOrderInstance.clickCopyOrder();
			Thread.sleep(5000);
			Assert.assertEquals( newOrderInstance.getHiveId(), "None"); 
			newOrderInstance.viewInsertionDetails("1");
			Assert.assertEquals( newOrderInstance.getHiveLineId(), "");  
			Logger.info(" HIVE ID and HIVE line id both gets blank after copying a IO to IO");




		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/**
	 * Verify Order search by giving HIVE ID irrespective of any other filter given
	 */
	//swagata

	@Test(groups = {"SMaintenance","performOrderSearchWithHiveId","HiveId","displayOrder","NewRegression3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void performOrderSearchWithHiveId(Map<String, String> userData) throws Exception
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
			basicOrderSearch.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			String HiveId= newOrderInstance.enterHiveId();
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1",10, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",9 , 27);
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1",8, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",8, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",8, 3);
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			String orderid = orderEntryPageInstance.getOrderNumber();
			Logger.info("orderid:" + orderid);
			basicOrderSearch.clickOnAdvancedLink();
			//basicOrderSearch.selectStatus("Killed");
			basicOrderSearch.enterHiveId(HiveId);
			basicOrderSearch.selectBussinessUnit("DPR-Daily Press");
			basicOrderSearch.clickOnOrderSearchBtn(); 
			Thread.sleep(3000);
			basicOrderSearch.validateOrderNum(orderid);
			Logger.info("Order with HIVE id given opened irrespective on any other filter given");
			dashboardPageInstance.clickOnLogout();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/**
	 * Show Hive ID updates in History log for Orders 
	 */
	//swagata

	@Test(groups = {"HiveIdUpdatesHistory","HiveId","displayOrders","NewRegression3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void HiveIdUpdatesHistory(Map<String, String> userData) throws Exception
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
			basicOrderSearch.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			String HiveId= newOrderInstance.enterHiveId();
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1",10, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",9 , 27);
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1",8, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",8, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",8, 3);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			String HiveLineId=newOrderInstance.enterHiveLineId();
			newOrderInstance.collapseInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			newOrderInstance.saveOrder();
			String HiveIdChange= newOrderInstance.enterHiveId();
			newOrderInstance.viewInsertionDetails("1");
			String HiveLineIdChange=newOrderInstance.enterHiveLineId();
			newOrderInstance.collapseInsertionDetails("1");
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.clickOnHistoryButton();
			newOrderInstance.getOrderHistoryActivity(2);
			String HiveIdHistoryLog=newOrderInstance.hiveIdHistoryLog(2);
			Assert.assertEquals("plus_hive id- "+HiveId+" change to "+HiveIdChange+"order insertion 1-0 - plus_hive orderline id- "+HiveLineId+" change to "+HiveLineIdChange, HiveIdHistoryLog);

			Logger.info(" Hive ID updates are showing in History log for Orders");
			dashboardPageInstance.clickOnLogout();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
