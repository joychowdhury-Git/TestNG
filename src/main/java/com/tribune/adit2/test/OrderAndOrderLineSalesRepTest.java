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


public class OrderAndOrderLineSalesRepTest 
{
	/**
	 * This test is to validate the sales rep that is added on the order/orderline/auto insertion
	 * Scenario: Customer used has a primary sales rep assigned in Ax and also has a sales rep assigned in 
	 * Territory Management for the product used in this test.
	 */
	@Test(groups = {"Order2", "ProductionTest4"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void validaeSaleRep(Map<String, String> userData) throws Exception
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
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",13, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2017");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",13, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",13, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",13, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",13, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		       newOrderInstance.validateSaleRepAdded(2, 2, 3);
		       Thread.sleep(4000);
		       String salesRepOnInsertion = newOrderInstance.getSalesRepOnInsertion(1);
		       //String salesRepOnOwnLocal = newOrderInstance.getSalesRepOnInsertion(2);
		       Logger.info("salesRepOnInsertion " +salesRepOnInsertion);
		       //Logger.info("salesRepOnOwnLocal "+salesRepOnOwnLocal);
		     //  Assert.assertEquals(salesRepOnInsertion, TribuneUtils.getStringCellValues("Sales", 2, 4));
		       //Assert.assertEquals(salesRepOnOwnLocal, TribuneUtils.getStringCellValues("Sales", 2, 5));
		       Thread.sleep(4000);
		       
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"Order2","SanityTestNew", "ProductionTest","ProductionSanityTest1","PrioritizedReg1","validateSaleRepPercentageError","salesRepReg","Grp2","RegressionLatest","Group5","DownRun","TestPriority","NewRegression1","NewRegression","G1", "salesRepValidation"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void validateSaleRepPercentageError(Map<String, String> userData) throws Exception
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
		       Thread.sleep(2000);
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       Thread.sleep(2000);
		       newOrderInstance.createNewInsertion();		       
		       Thread.sleep(2000);
		       newOrderInstance.selectBU("1",17, 0);
		       Thread.sleep(2000);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2021");
		       Thread.sleep(2000);
		       newOrderInstance.selectProductType("1",17, 1);
		       Thread.sleep(2000);
		       newOrderInstance.selectProduct("1",17, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",17, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("1",17, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           //newOrderInstance.removeSalesRepOnInsertion(1);
			   Thread.sleep(4000);				      
	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02433");
			   Thread.sleep(4000);
			   newOrderInstance.clickOnInsertionSalesRepSection(1);
			   Thread.sleep(4000);
			   newOrderInstance.clickOnInsertionSalesRepSection(1);
			   Thread.sleep(4000);
		   //    newOrderInstance.validateSalesRepError();
		       
//		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"SMaintenance","Order", "salesRep","salesRepTC01","salesRepReg","PrioritizedReg1","Grp4","RegressionLatest","Group5","DownRun","NewRegression","NewRegression1","G1", "salesRepValidation"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void salesRepTC01(Map<String, String> userData) throws Exception
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
		       
		       //S11_AAS922_TC01
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",18, 0);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2021");
		       newOrderInstance.selectProductType("1",18, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",18, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",18, 3);
		       Thread.sleep(4000);
		      // newOrderInstance.selectSection("1",18, 4);
		     //  Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		       String salesRepOnInsertion = newOrderInstance.getSalesRepOnInsertion(1);
		       Logger.info("salesRepOnInsertion " +salesRepOnInsertion);
		       //Assert.assertEquals(salesRepOnInsertion, "ADSS-CTC");
		       if(salesRepOnInsertion.contains("ADSS-CTC"))
		       {
		    	   Logger.info("salesrep displayed as expected");
		       }
		       else {
		    	   Logger.error("salesrep not displayed as expected");
		       }
		       Thread.sleep(2000);
		       newOrderInstance.submitOrder();
		      // Thread.sleep(2000);
		      
		       newOrderInstance.clickOnwarningConfirmation();//swagata
		       //Thread.sleep(2000);
		       //dashboardPageInstance.clickondropdownforlogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"Order", "salesRep","salesRepTC02"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void salesRepTC02(Map<String, String> userData) throws Exception
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
		       
		       //S11_AAS922_TC02
	   		    NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
	       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
	       newOrderInstance.enterSoldToCustomer("CU00059747");
	       newOrderInstance.selectBillToCustomerBU("bu_LAT");
	       newOrderInstance.enterBillToCustomer("CU00072464");
	       newOrderInstance.selectOrderType("OrderType_Standard");
	       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
	       newOrderInstance.createNewInsertion();
	       newOrderInstance.selectBU("1",18, 0);
	       newOrderInstance.enterPubDate("1","27", "Jan", "2017");
	       newOrderInstance.selectProductType("1",18, 1);
	       newOrderInstance.selectProduct("1",18, 2);
	       Thread.sleep(2000);
	       newOrderInstance.selectAdType("1",18, 3);
	       newOrderInstance.selectSection("1",18, 4);
	       Thread.sleep(4000);
	       newOrderInstance.viewInsertionDetails("1");
	       Thread.sleep(2000);
	       String salesRepOnInsertion2 = newOrderInstance.getSalesRepOnInsertion(1);
	       Logger.info("salesRepOnInsertion " +salesRepOnInsertion2);
	       Assert.assertEquals(salesRepOnInsertion2, TribuneUtils.getStringCellValues("Sales", 4, 4));
	       Thread.sleep(4000);

	       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"Order", "salesRep"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void salesRepTC03(Map<String, String> userData) throws Exception
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
		       
		     //S11_AAS922_TC03
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBillToCustomerBU("bu_LAT");
		       newOrderInstance.enterBillToCustomer("CU00072503");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",12, 0);
		       newOrderInstance.enterPubDate("1","27", "Jan", "2017");
		       newOrderInstance.selectProductType("1",12, 1);
		       newOrderInstance.selectProduct("1",12, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",12, 3);
		       newOrderInstance.selectSection("1",12, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(2000);
		       String salesRepOnInsertion3 = newOrderInstance.getSalesRepOnInsertion(1);
		       Logger.info("salesRepOnInsertion " +salesRepOnInsertion3);
		       Assert.assertEquals(salesRepOnInsertion3, TribuneUtils.getStringCellValues("Sales", 5, 4));
		       Thread.sleep(4000);

		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"Order", "salesRep","salesRepReg","salesRepTC04","salesRepReg","Grp4","RegressionLatest","Group5","DownRun"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void salesRepTC04(Map<String, String> userData) throws Exception
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
		       
		     //S11_AAS922_TC04
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBillToCustomerBU("bu_LAT");
		       newOrderInstance.enterBillToCustomer("CU00072530");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",30, 0);
		       newOrderInstance.enterPubDate("1","29", "Dec", "2017");
		       Thread.sleep(2000);		       
		       newOrderInstance.selectProductType("1",30, 1);
		       Thread.sleep(3000);
		       newOrderInstance.selectProduct("1",30, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",30, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("1",30, 4);
		       Thread.sleep(5000);
		       int SalesRepCount = newOrderInstance.getNoOfSalesRepOnInsertion(1);
		       Logger.info("Count of salesRepOnInsertion " +SalesRepCount);
		       Assert.assertEquals(SalesRepCount, 0);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");	
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
		      dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"Order", "salesRep","salesRepTC05"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void salesRepTC05(Map<String, String> userData) throws Exception
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
		       
		     //S11_AAS922_TC05
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBillToCustomerBU("bu_LAT");
		       newOrderInstance.enterBillToCustomer("CU00072532");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",20, 0);
		       newOrderInstance.enterPubDate("1","28", "Jan", "2017");
		       newOrderInstance.selectProductType("1",20, 1);
		       newOrderInstance.selectProduct("1",20, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",20, 3);
		       newOrderInstance.selectSection("1",20, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(2000);
		       String salesRepOnInsertion5 = newOrderInstance.getSalesRepOnInsertion(1);
		       Logger.info("salesRepOnInsertion " +salesRepOnInsertion5);
		       Assert.assertEquals(salesRepOnInsertion5, TribuneUtils.getStringCellValues("Sales", 7, 4));
		       Thread.sleep(4000);

		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"Order", "salesRep","salesRepTC06","salesRepReg","Grp4","RegressionLatest","Group5","DownRun"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void salesRepTC06(Map<String, String> userData) throws Exception
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
		       
		     //S11_AAS922_TC06
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBillToCustomerBU("bu_LAT");
		       newOrderInstance.enterBillToCustomer("CU00059747");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",20, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2017");
		       newOrderInstance.selectProductType("1",20, 1);
		       newOrderInstance.selectProduct("1",20, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",20, 3);
		     //  newOrderInstance.selectSection("1",20, 4);
		       Thread.sleep(5000);
		       String salesRepOnInsertion1 = newOrderInstance.getSalesRepOnInsertion(1);
		       Logger.info("salesRepOnInsertion " +salesRepOnInsertion1);
		     //  Assert.assertEquals(salesRepOnInsertion1, TribuneUtils.getStringCellValues("Sales", 10, 4));
		       Thread.sleep(3000);
		       
		       newOrderInstance.enterBillToCustomer("CU00072532");
		       Thread.sleep(3000);
		       String salesRepOnInsertion2 = newOrderInstance.getSalesRepOnInsertion(1);
		       Logger.info("salesRepOnInsertion " +salesRepOnInsertion2);
		     //  Assert.assertEquals(salesRepOnInsertion2, TribuneUtils.getStringCellValues("Sales", 7, 4));
		       Thread.sleep(3000);
		       
		       newOrderInstance.enterSoldToCustomer("CU00072532");
		       Thread.sleep(3000);
		       String salesRepOnInsertion3 = newOrderInstance.getSalesRepOnInsertion(1);
		       Logger.info("salesRepOnInsertion " +salesRepOnInsertion3);
		      // Assert.assertEquals(salesRepOnInsertion3, TribuneUtils.getStringCellValues("Sales", 12, 4));
		       Thread.sleep(3000);

		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"Order", "salesRep","salesRepTC07"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void salesRepTC07(Map<String, String> userData) throws Exception
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
		       
		     //S11_AAS922_TC07
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00000859");
		       newOrderInstance.selectBillToCustomerBU("bu_LAT");
		       newOrderInstance.enterBillToCustomer("CU00000859");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",21, 0);
		       newOrderInstance.enterPubDate("1","31", "Dec", "2017");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",21, 1);
		       newOrderInstance.selectProduct("1",21, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",21, 3);
		       newOrderInstance.selectSection("1",21, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(2000);
		       String salesRepOnInsertion7 = newOrderInstance.getSalesRepOnInsertion(1);
		       Logger.info("salesRepOnInsertion " +salesRepOnInsertion7);
		       Assert.assertEquals(salesRepOnInsertion7, TribuneUtils.getStringCellValues("Sales", 8, 4));
		       Thread.sleep(4000);
		       
		       newOrderInstance.enterBillToCustomer("CU00001508");
		       Thread.sleep(3000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(2000);
		       String salesRepOnInsertion8 = newOrderInstance.getSalesRepOnInsertion(1);
		       Logger.info("salesRepOnInsertion " +salesRepOnInsertion8);
		       Assert.assertEquals(salesRepOnInsertion8, TribuneUtils.getStringCellValues("Sales", 9, 4));
		       Thread.sleep(4000);
		       
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"Order", "salesRep","salesRepTC08"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void salesRepTC08(Map<String, String> userData) throws Exception
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
		       
		       //S11_AAS922_TC08
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBillToCustomerBU("bu_LAT");
		       newOrderInstance.enterBillToCustomer("CU00072464");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",20, 0);
		       newOrderInstance.enterPubDate("1","28", "Dec", "2017");
		       newOrderInstance.selectProductType("1",20, 1);
		       newOrderInstance.selectProduct("1",20, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",20, 3);
		       newOrderInstance.selectSection("1",20, 4);
		       Thread.sleep(4000);
		       
		       int count = newOrderInstance.getNoOfSalesRepOnInsertion(1);
		       Logger.info("SalesRepCount " +count);
		       Assert.assertEquals(newOrderInstance.getNoOfSalesRepOnInsertion(1), 1);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00716");
		       Thread.sleep(4000);
		       
		       newOrderInstance.submitOrder();
		       Thread.sleep(4000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBillToCustomerBU("bu_LAT");
		       newOrderInstance.enterBillToCustomer("CU00072464");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",20, 0);
		       newOrderInstance.enterPubDate("1","28", "Dec", "2017");
		       newOrderInstance.selectProductType("1",20, 1);
		       newOrderInstance.selectProduct("1",20, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",20, 3);
		       newOrderInstance.selectSection("1",20, 4);
		       Thread.sleep(4000);
		       
		       Assert.assertEquals(newOrderInstance.getNoOfSalesRepOnInsertion(1), 1);
		      // Logger.info("Sales Rep is blank");
		       
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"Order", "salesRep","salesRepTC09"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void salesRepTC09(Map<String, String> userData) throws Exception
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
		       
		       //S11_AAS922_TC09
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBillToCustomerBU("bu_LAT");
		       newOrderInstance.enterBillToCustomer("CU00072532");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",20, 0);
		       newOrderInstance.enterPubDate("1","28", "Dec", "2017");
		       newOrderInstance.selectProductType("1",20, 1);
		       newOrderInstance.selectProduct("1",20, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",20, 3);
		       newOrderInstance.selectSection("1",20, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(2000);
		       String salesRepOnInsertion1 = newOrderInstance.getSalesRepOnInsertion(1);
		       Logger.info("salesRepOnInsertion " +salesRepOnInsertion1);
		       Assert.assertEquals(salesRepOnInsertion1, TribuneUtils.getStringCellValues("Sales", 7, 4));
		       Thread.sleep(4000);
		       
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       
		       String orderNum = orderEntryPageInstance.getOrderID();
		       Logger.info("OrderID " +orderNum);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       
		       orderEntryPageInstance.clickOnOrder(orderNum);
		       Thread.sleep(2000);
		       
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       Thread.sleep(3000);
		       String salesRepOnInsertion2 = newOrderInstance.getSalesRepOnInsertion(1);
		       Logger.info("salesRepOnInsertion " +salesRepOnInsertion2);
		       Assert.assertEquals(salesRepOnInsertion2, TribuneUtils.getStringCellValues("Sales", 10, 7));
		       Thread.sleep(4000);
		       
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"Order", "salesRep","salesRepTC10"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void salesRepTC10(Map<String, String> userData) throws Exception
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
		       
		       //S11_AAS922_TC10
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBillToCustomerBU("bu_LAT");
		       newOrderInstance.enterBillToCustomer("CU00059747");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",18, 0);
		       newOrderInstance.enterPubDate("1","27", "Dec", "2017");
		       newOrderInstance.selectProductType("1",18, 1);
		       newOrderInstance.selectProduct("1",18, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",18, 3);
		       newOrderInstance.selectSection("1",18, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(2000);
		       String salesRepOnInsertion1 = newOrderInstance.getSalesRepOnInsertion(1);
		       Logger.info("salesRepOnInsertion1 " +salesRepOnInsertion1);
		       Assert.assertEquals(salesRepOnInsertion1, TribuneUtils.getStringCellValues("Sales", 3, 7));
		       Thread.sleep(4000);
		       
		       newOrderInstance.enterBillToCustomer("CU00072464");
		       Thread.sleep(4000);
		       String salesRepOnInsertion2 = newOrderInstance.getSalesRepOnInsertion(1);
		       Logger.info("salesRepOnInsertion2 " +salesRepOnInsertion2);
		       Assert.assertEquals(salesRepOnInsertion2, TribuneUtils.getStringCellValues("Sales", 4, 4));
		       Thread.sleep(4000);
		       
		       newOrderInstance.enterBillToCustomer("CU00072457");
		       Thread.sleep(4000);
		       String salesRepOnInsertion3 = newOrderInstance.getSalesRepOnInsertion(1);
		       Logger.info("salesRepOnInsertion3 " +salesRepOnInsertion3);
		       Assert.assertEquals(salesRepOnInsertion3, TribuneUtils.getStringCellValues("Sales", 3, 4));
		       Thread.sleep(4000);

		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"Order", "salesRep"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void salesRepTC11(Map<String, String> userData) throws Exception
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
		       
		       //S11_AAS922_TC11
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBillToCustomerBU("bu_LAT");
		       newOrderInstance.enterBillToCustomer("CU00072457");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",8, 0);
		       newOrderInstance.enterPubDate("1","27", "Jan", "2017");
		       newOrderInstance.selectProductType("1",8, 1);
		       newOrderInstance.selectProduct("1",8, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",8, 3);
		       newOrderInstance.selectSection("1",8, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(2000);
		       String salesRepOnInsertion4 = newOrderInstance.getSalesRepOnInsertion(1);
		       Logger.info("salesRepOnInsertion " +salesRepOnInsertion4);
		       Assert.assertEquals(salesRepOnInsertion4, TribuneUtils.getStringCellValues("Sales", 11, 4));
		       Thread.sleep(4000);
		       
		       newOrderInstance.enterBillToCustomer("CU00072532");
		       Thread.sleep(3000);
		       int salesRepCount = newOrderInstance.getNoOfSalesRepOnInsertion(1);
		       Logger.info("Sales Rep Count "+salesRepCount);
		       Assert.assertEquals(salesRepCount, 1);
		       Thread.sleep(2000);

		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"Order", "salesRep","salesRepTC12"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void salesRepTC12(Map<String, String> userData) throws Exception
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
		       
		       //S11_AAS922_TC12
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBillToCustomerBU("bu_LAT");
		       newOrderInstance.enterBillToCustomer("CU00072464");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",12, 0);
		       newOrderInstance.enterPubDate("1","28", "Dec", "2017");
		       newOrderInstance.selectProductType("1",12, 1);
		       newOrderInstance.selectProduct("1",12, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",12, 3);
		       newOrderInstance.selectSection("1",12, 4);
		       Thread.sleep(4000);
		       
		       String salesRepOnInsertion = newOrderInstance.getSalesRepOnInsertion(1);
		       Logger.info("salesRepOnInsertion " +salesRepOnInsertion);
		       Assert.assertEquals(salesRepOnInsertion, TribuneUtils.getStringCellValues("Sales", 4, 4));
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00716");
		       Thread.sleep(3000);
		       
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBillToCustomerBU("bu_LAT");
		       newOrderInstance.enterBillToCustomer("CU00072464");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",12, 0);
		       newOrderInstance.enterPubDate("1","28", "Dec", "2017");
		       newOrderInstance.selectProductType("1",12, 1);
		       newOrderInstance.selectProduct("1",12, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",12, 3);
		       newOrderInstance.selectSection("1",12, 4);
		       Thread.sleep(4000);
		       Logger.info("Sales RepOnInsertion "+newOrderInstance.getSalesRepOnInsertion(1));
		       Assert.assertEquals(newOrderInstance.getSalesRepOnInsertion(1), TribuneUtils.getStringCellValues("Sales", 4, 4));
		       Logger.info("Sales Rep is same as earlier");
		       
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"Order", "salesRep","salesRepTC13"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void salesRepTC13(Map<String, String> userData) throws Exception
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
		       
		       //S11_AAS922_TC13
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBillToCustomerBU("bu_LAT");
		       newOrderInstance.enterBillToCustomer("CU00072464");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",12, 0);
		       newOrderInstance.enterPubDate("1","28", "Dec", "2017");
		       newOrderInstance.selectProductType("1",12, 1);
		       newOrderInstance.selectProduct("1",12, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",12, 3);
		       newOrderInstance.selectSection("1",12, 4);
		       Thread.sleep(4000);
		       
		       String salesRepOnInsertion = newOrderInstance.getSalesRepOnInsertion(1);
		       Logger.info("salesRepOnInsertion " +salesRepOnInsertion);
		       Assert.assertEquals(salesRepOnInsertion, TribuneUtils.getStringCellValues("Sales", 4, 4));
		       Thread.sleep(4000);
		       
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBillToCustomerBU("bu_LAT");
		       newOrderInstance.enterBillToCustomer("CU00072532");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",12, 0);
		       newOrderInstance.enterPubDate("1","28", "Dec", "2017");
		       newOrderInstance.selectProductType("1",12, 1);
		       newOrderInstance.selectProduct("1",12, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",12, 3);
		       newOrderInstance.selectSection("1",12, 4);
		       Thread.sleep(4000);
		       Logger.info("Sales RepOnInsertion "+newOrderInstance.getSalesRepOnInsertion(1));
		       Assert.assertEquals(newOrderInstance.getSalesRepOnInsertion(1), TribuneUtils.getStringCellValues("Sales", 5, 4));
		       Logger.info("Sales Rep is same as earlier");
		       
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"Order2", "salesRepRetainProductChange"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void salesRepRetainProductChange(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectSoldToCustomerBU("bu_All");
		       newOrderInstance.enterSoldToCustomer("CU00007934");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       Thread.sleep(4000);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",18, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","21", "Dec", "2021");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",18, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",18, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",18, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",18, 4);
		       Thread.sleep(4000);
		       
		       String salesRepOnInsertion = newOrderInstance.getSalesRepOnInsertion(1);
		       Logger.info("salesRepOnInsertion " +salesRepOnInsertion);
		       Assert.assertEquals(salesRepOnInsertion, "");
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           //newOrderInstance.removeSalesRepOnInsertion(1);
			   Thread.sleep(4000);				      
	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01296");
			   Thread.sleep(4000);
			   Logger.info("salesRepOnInsertion " +newOrderInstance.getSalesRepOnInsertion(1));
		       Assert.assertEquals(newOrderInstance.getSalesRepOnInsertion(1), "Chiang,Jonathan");
		     
		       Thread.sleep(4000);
		       newOrderInstance.selectProductByIndex("1",3);
		       Thread.sleep(4000);
		       Logger.info("Sales RepOnInsertion "+newOrderInstance.getSalesRepOnInsertion(1));
		       Assert.assertEquals(newOrderInstance.getSalesRepOnInsertion(1), "Chiang,Jonathan");
		       Logger.info("Sales Rep is same as earlier");
		       
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
