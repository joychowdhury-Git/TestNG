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
 * @since Janember 2015
 */

public class OrderOnlineTest 
{
	/**
	 * This test will create a new insertion order for a display product type
	 */
	@Test(groups = {"SanityTestNew","ProductionTest","onlineOrder","PrdSanityNew","OrderDisplayOnlineTest","Grp4", "OnlnReg","PriorityDFP","PTest1","TestPriority","ProductionTestCI","Patch14","ProductionTestLock"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void onlineOrder(Map<String, String> userData) throws Exception
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
		     //  newOrderInstance.enterSoldToCustomer("CA11004600");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		     //  newOrderInstance.entercampaignName("AutoTestCampaign");
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);
		       newOrderInstance.selectBU("1",9, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","23", "Dec", "2019");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",9, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",9, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",9, 3);
		       Thread.sleep(2000);
		      // newOrderInstance.selectSection("1",9, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		       boolean totalPriceFlag = false;
		       double totalInsertionPrice = newOrderInstance.getOnlineInsertionPrice("1", "total");
		       Logger.info("total insertion price "+totalInsertionPrice);
		   /*    if(totalInsertionPrice==TribuneUtils.getDoubleCellValues("Product",9, 17))
		       {
		    	   totalPriceFlag = true;
		    	   Logger.info("total insertion price "+totalInsertionPrice+" is as per the pricing logics");
		       }

		       Assert.assertEquals(totalPriceFlag, true);*/
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       //Thread.sleep(4000);//swagata
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(1000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(1000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"duplicateOnlineOrder","OrderDisplayOnlineTest","Grp2","RegressionLatest", "OnlnReg","Group1","PriorityDFP"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void duplicateOnlineOrder(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectBU("1",9, 0);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2019");
		       newOrderInstance.selectProductType("1",9, 1);
		     //  newOrderInstance.selectProduct("1",9, 2);
		       Thread.sleep(2000);
		    //   newOrderInstance.selectAdType("1",9, 3);
		    //   Thread.sleep(2000);
		    //   newOrderInstance.selectSection("1",9, 4);
		       Thread.sleep(4000);
		      // newOrderInstance.viewInsertionDetails("1");
		     //  boolean totalPriceFlag = false;
		       double totalInsertionPrice = newOrderInstance.getOnlineInsertionPrice("1", "total");
		       Logger.info("total insertion price "+totalInsertionPrice);
		      
		       Thread.sleep(2000);
		       newOrderInstance.createDuplicateInsertion("1");
		       Thread.sleep(7000);
		       
		       int insertionCount = newOrderInstance.getInsertionsCount();
		       Assert.assertEquals(insertionCount, 2);
		   //    boolean totalPriceFlag1 = false;
		       double totalInsertionPrice1 = newOrderInstance.getOnlineInsertionPrice("2", "total");
		       Logger.info("total insertion price "+totalInsertionPrice1);
		       

		       Assert.assertEquals(totalInsertionPrice, totalInsertionPrice1);
		       Assert.assertEquals(insertionCount, 2);
		       Assert.assertEquals(newOrderInstance.getProductOnInsertion(1), newOrderInstance.getProductOnInsertion(2));
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion2(2);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(1000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"newVersionOnlineOrder"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void newVersionOnlineOrder(Map<String, String> userData) throws Exception
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

		       newOrderInstance.selectBU("1",9, 0);
		       Thread.sleep(2000);//swagata new 

		       newOrderInstance.enterPubDate("1","24", "Dec", "2019");
		       Thread.sleep(2000);//swagata new 

		       newOrderInstance.selectProductType("1",9, 1);
		       Thread.sleep(2000);//swagata new 

		       newOrderInstance.selectProduct("1",9, 2);
		       Thread.sleep(2000);//swagata new 
		       newOrderInstance.selectAdType("1",9, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("1",9, 4);
		       Thread.sleep(4000);
		     //  newOrderInstance.viewInsertionDetails("1");
		      
		       double totalInsertionPrice = newOrderInstance.getOnlineInsertionPrice("1", "total");
		       Logger.info("total insertion price "+totalInsertionPrice);
		       
		       newOrderInstance.createNewInsertionVersion("1");
		       Thread.sleep(7000);
		       
		       int insertionCount = newOrderInstance.getInsertionsCount();
		       Assert.assertEquals(insertionCount, 2);
		      
		       double totalInsertionPrice1 = newOrderInstance.getOnlineInsertionPrice("2", "total");
		       Logger.info("total insertion price "+totalInsertionPrice1);
		      /* newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);	  
		       newOrderInstance.applytoAllSalesRepOnInsertion(1);
		       Thread.sleep(2000);
		       Thread.sleep(4000);
		       newOrderInstance.createNewInsertionVersion("2");
		       Thread.sleep(7000);*///swagata new 
		       Assert.assertEquals(totalInsertionPrice, totalInsertionPrice1);
		       Thread.sleep(2000);//swagata new 
		       newOrderInstance.submitOrder();
		       Thread.sleep(1000);//swagata new 
		     String orderID = orderEntryPageInstance.getOrderID();//swagata new
				Logger.info("Order ID: "+orderID);//swagata new 
				orderEntryPageInstance.closeOrderSuccessSubmissionMessage();//swagata new 
				Thread.sleep(3000);
			       dashboardPageInstance.clickOnLogout();


			
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"Order","onlineMultipleOrder","OrderDisplayOnlineTest","Grp4","RegressionLatest", "OnlnReg","Group1","RerunO","PriorityDFP","RegFailed3","Group1F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void onlineMultipleOrder(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectBU("1",9, 0);
		       Thread.sleep(3000);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2019");
		       Thread.sleep(3000);
		       newOrderInstance.selectProductType("1",9, 1);
		       newOrderInstance.selectProduct("1",9, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",9, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("1",9, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       boolean totalPriceFlag = false;
		       double totalInsertionPrice = newOrderInstance.getOnlineInsertionPrice("1", "total");
		       Logger.info("total insertion price "+totalInsertionPrice);
		  /*     if(totalInsertionPrice==TribuneUtils.getDoubleCellValues("Product",9, 17))
		       {
		    	   totalPriceFlag = true;
		    	   Logger.info("total insertion price "+totalInsertionPrice+" is as per the pricing logics");
		       }

		       Assert.assertEquals(totalPriceFlag, true); */
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("2",9, 0);
		       Thread.sleep(3000);
		       newOrderInstance.enterPubDate("2","22", "Dec", "2019");
		       Thread.sleep(3000);
		       newOrderInstance.selectProductType("2",9, 1);
		       newOrderInstance.selectProduct("2",9, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("2",9, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("2",9, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("2");
		       boolean totalPriceFlag1 = false;
		       double totalInsertionPrice1 = newOrderInstance.getOnlineInsertionPrice("1", "total");
		       Logger.info("total insertion price "+totalInsertionPrice1);
		   /*    if(totalInsertionPrice==TribuneUtils.getDoubleCellValues("Product",9, 17))
		       {
		    	   totalPriceFlag1 = true;
		    	   Logger.info("total insertion price "+totalInsertionPrice1+" is as per the pricing logics");
		       }

		       Assert.assertEquals(totalPriceFlag, true);*/
		       Thread.sleep(4000); 		       
		       newOrderInstance.saveOrder();
		       Thread.sleep(3000);
		       Logger.info("Saved Order# : "+newOrderInstance.getOrderNo() );
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(2);Thread.sleep(2000);Thread.sleep(4000);
		       Thread.sleep(5000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(1000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"Order", "onlineOrderWithMMTag","OrderDisplayOnlineTest","Grp4","RegressionLatest", "OnlnReg","Group1","TestPriority","PriorityDFP","PriorityVulnerability","RegFailed3","Group1F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void onlineOrderWithMMTag(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectBU("1",9, 0);
		       newOrderInstance.enterPubDate("1","23", "Dec", "2019");
		       newOrderInstance.selectProductType("1",9, 1);
		       newOrderInstance.selectProduct("1",9, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",9, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("1",9, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       boolean totalPriceFlag = false;
		       double totalInsertionPrice = newOrderInstance.getOnlineInsertionPrice("1", "total");
		       Logger.info("total insertion price "+totalInsertionPrice);
		   /*    if(totalInsertionPrice==TribuneUtils.getDoubleCellValues("Product",9, 17))
		       {
		    	   totalPriceFlag = true;
		    	   Logger.info("total insertion price "+totalInsertionPrice+" is as per the pricing logics");
		       }

		       Assert.assertEquals(totalPriceFlag, true);*/
		    //   newOrderInstance.clickOnInsertionSalesRepSection(1);
		     //  newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
		       Thread.sleep(6000);
		       newOrderInstance.selectMMTag("1", "One Day Sale");
		       Thread.sleep(4000);		
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       Thread.sleep(4000);
		      newOrderInstance.submitOrder();
		       Thread.sleep(5000);		       
		       String orderID = orderEntryPageInstance.getOrderID();
		       Logger.info("Order ID: "+orderID);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       orderEntryPageInstance.clickOnOrder(orderID);
		       
		       Thread.sleep(3000);
		        
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	@Test(groups = {"Order", "onlineOrderProgramPriceChange","OrderDisplayOnlineTest","Grp4", "OnlnReg","Group1","PriorityDFP"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void onlineOrderProgramPriceChange(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectSoldToCustomerBU("bu_DPR");
		       newOrderInstance.enterSoldToCustomer("CU00013249");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       Thread.sleep(4000);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",56, 0);
		       Thread.sleep(2000);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2019");
		       Thread.sleep(2000);
		       newOrderInstance.selectProductType("1",56, 1);
		     //  newOrderInstance.selectProduct("1",56, 2);
		     //  Thread.sleep(2000);
		    //   newOrderInstance.selectAdType("1",56, 3);
		    //   Thread.sleep(2000);
		      // newOrderInstance.selectSection("1",9, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		      
		       double totalInsertionPrice = newOrderInstance.getOnlineInsertionPrice("1", "total");
		       Logger.info("total insertion price "+totalInsertionPrice);
		       Thread.sleep(2000);
		       String programPrice= newOrderInstance.getProgramPriceForAnInsertion(1);
		       Thread.sleep(2000);
		       String programPriceRate = newOrderInstance.getProgramPriceRateForAnInsertion(1);
		       Thread.sleep(2000);
		       Assert.assertEquals(programPrice, "None");
		       Thread.sleep(2000);
		       Assert.assertEquals(programPriceRate, "0");
		       Thread.sleep(2000);
		       newOrderInstance.clickOnProgramPriceSelector();
		       Thread.sleep(4000);
		       newOrderInstance.selectProgramPromotion("DP Print/Online-A1/Section Fronts 2016-2017");
		       Thread.sleep(4000);
		       double totalInsertionPrice1 = newOrderInstance.getOnlineInsertionPrice("1", "total");
		       Logger.info("total insertion price after selecting program "+totalInsertionPrice1);
		       String programPrice1= newOrderInstance.getProgramPriceForAnInsertion(1);
		       Thread.sleep(2000);
		       String programPriceRate1 = newOrderInstance.getProgramPriceRateForAnInsertion(1);
		       Thread.sleep(2000);
		       boolean flag = false;
		       if (programPriceRate1!=programPriceRate && programPrice1!=programPrice && totalInsertionPrice1!=totalInsertionPrice)
		       {
		    	   flag = true;
		       }
		       
		       Assert.assertEquals(flag, true);
		       newOrderInstance.clearProgramPromotion();
		       Thread.sleep(5000);
		       String programPrice2= newOrderInstance.getProgramPriceForAnInsertion(1);
		       Thread.sleep(2000);
		       String programPriceRate2 = newOrderInstance.getProgramPriceRateForAnInsertion(1);
		       Thread.sleep(2000);
		       Assert.assertEquals(programPrice2, "None");
		       Thread.sleep(2000);
		       Assert.assertEquals(programPriceRate2, "0");
		       Thread.sleep(2000);
		       newOrderInstance.clickOnProgramPriceSelector();
		       Thread.sleep(4000);
		       newOrderInstance.selectProgramPromotion("DP Print/Online-A1/Section Fronts 2016-2017");
		       Thread.sleep(4000);
		       String programPrice3= newOrderInstance.getProgramPriceForAnInsertion(1);
		       Thread.sleep(2000);
		       String programPriceRate3 = newOrderInstance.getProgramPriceRateForAnInsertion(1);
		       Thread.sleep(2000);
		       boolean flag1 = false;
		       if (programPriceRate3!=programPriceRate2 && programPrice3!=programPrice2)
		       {
		    	   flag1 = true;
		       }
		       
		       Assert.assertEquals(flag1, true);
		       newOrderInstance.selectProductByIndex("1", 3);
		       Thread.sleep(2000);
		      
		       String programPrice4= newOrderInstance.getProgramPriceForAnInsertion(1);
		       Thread.sleep(2000);
		       String programPriceRate4 = newOrderInstance.getProgramPriceRateForAnInsertion(1);
		       Thread.sleep(2000);
		       Assert.assertEquals(programPrice4, "None");
		       Thread.sleep(2000);
		       Assert.assertEquals(programPriceRate4, "0");
		       Thread.sleep(2000);
		       newOrderInstance.selectProductByIndex("1", 0);
		       Thread.sleep(5000);
		       newOrderInstance.clickOnProgramPriceSelector();
		       Thread.sleep(4000);
		       newOrderInstance.selectProgramPromotion("DP Print/Online-A1/Section Fronts 2016-2017");
		       Thread.sleep(4000);
		       String programPrice5= newOrderInstance.getProgramPriceForAnInsertion(1);
		       Thread.sleep(2000);
		       String programPriceRate5 = newOrderInstance.getProgramPriceRateForAnInsertion(1);
		       Thread.sleep(2000);
		       boolean flag2 = false;
		       if (programPriceRate5!=programPriceRate4 && programPrice5!=programPrice4)
		       {
		    	   flag2 = true;
		       }
		       Assert.assertEquals(flag2, true);
		      /* newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA02514");
		       Thread.sleep(2000);
		       newOrderInstance.addServiceRep("027440");		       
		       Thread.sleep(4000);*/
		       
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(1000);
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
	
	@Test(groups = {"Order","onlineOrderColourValidation","Grp4","RegressionLatest", "OnlnReg","Group1","TestPriority","RerunO","PriorityDFP","RegFailed3","Group1F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void onlineOrderColourValidation(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectSoldToCustomerBU("bu_DPR");
		       newOrderInstance.enterSoldToCustomer("CU00013249");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       Thread.sleep(4000);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);
		       newOrderInstance.selectBU("1",56, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDateFromExcel("1",56,27);
		       Thread.sleep(5000);
		       newOrderInstance.selectProductType("1",56, 1);
		       Thread.sleep(4000);
		    /*   newOrderInstance.selectProduct("1",56, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",56, 3);
		       Thread.sleep(5000);
		       newOrderInstance.selectSection("1",56, 4);		       
		       Thread.sleep(6000); */
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		      
		       newOrderInstance.enterItemDescription("CUBE",1);
		       Thread.sleep(4000);
		       newOrderInstance.enterItemQuantity("1000",1);
		       Thread.sleep(4000);    
		       newOrderInstance.selectMaterialSource("1", "New Build");
		       Thread.sleep(4000);  
		       String defaultColour = newOrderInstance.getValueofSelectedColourOptionOnline(1);
		       Logger.info("defaultColour for insertion 1"+defaultColour);
		       Thread.sleep(4000); 
		       Assert.assertEquals(defaultColour, "");
		     //  newOrderInstance.selectColourForAnInsertionAltDig(1,"");
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);
		       newOrderInstance.selectBU("2",56, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDateFromExcel("2",56,27);
		       Thread.sleep(5000);
		       newOrderInstance.selectProductType("2",56, 1);
		       Thread.sleep(4000);
		    /*   newOrderInstance.selectProduct("2",56, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("2",56, 3);
		       Thread.sleep(5000);
		       newOrderInstance.selectSection("2",56, 4);		       
		       Thread.sleep(6000); */
		       newOrderInstance.viewInsertionDetails("2");
		       Thread.sleep(4000);
		       
		       newOrderInstance.enterItemDescription("CUBE",2);
		       Thread.sleep(4000);
		       newOrderInstance.enterItemQuantity("1000",2);
		       Thread.sleep(4000);
		       newOrderInstance.selectMaterialSource("2", "New Build");
		       Thread.sleep(4000);  

		       String defaultColour1 = newOrderInstance.getValueofSelectedColourOptionOnline(2);
		       Logger.info("defaultColour for insertion 2"+defaultColour1);
		       Thread.sleep(4000); 
		    //   Assert.assertEquals(defaultColour, "B/W");
		    //   newOrderInstance.selectColourForAnInsertionAltDig(2,"B/W");
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           //newOrderInstance.removeSalesRepOnInsertion(1);
			   Thread.sleep(4000);				      
	           newOrderInstance.addNewSalesRepOnInsertion(2, "SA02514");
			   Thread.sleep(4000);
			  newOrderInstance.clickOnInsertionSalesRepSection(1);
			   Thread.sleep(4000);
			   newOrderInstance.applytoAllSalesRepOnInsertion(2);
			   Thread.sleep(2000);
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       String orderID = orderEntryPageInstance.getOrderNumber();
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(1000);
		       
		       orderEntryPageInstance.clickOnOrder(orderID);
		       Thread.sleep(6000);
		       
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		       newOrderInstance.selectColourForAnInsertionAltDig(1,"4C");
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("2");
		       Thread.sleep(4000);
		       newOrderInstance.selectColourForAnInsertionAltDig(2,"Spot Color");
		       Thread.sleep(4000);
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(1000);		      
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(1000);
		       
		       orderEntryPageInstance.clickOnOrder(orderID);
		       Thread.sleep(5000);
		       
		       
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
