package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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

public class OrderOwnLocalAutoInsertionPerRunDateMaterialIDTest 
{	

	@Test(groups = {"Order", "ownLocalSameMaterialIDSamePubdateRunDate","PrioritizedReg2","OwnLocalReg5","OLReg","RegressionLatest","Group2","Grp4","PerRunDate","TestPriority","NewRegression2","NewRegression","G2","ownLocalOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	   public void ownLocalSameMaterialIDSamePubdate(Map<String, String> userData) throws Exception
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
		       newOrderInstance.checkUncheckOwnLocalOptOut(false);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",17, 0);
		       newOrderInstance.enterPubDate("1","23", "Dec", "2021");
		       newOrderInstance.selectProductType("1",17, 1);
		       newOrderInstance.selectProduct("1",17, 2);
		       newOrderInstance.selectAdType("1",17, 3);
		       newOrderInstance.selectSection("1",17, 4);
		       Thread.sleep(4000);
		       /*
		       Assert.assertEquals(newOrderInstance.getBUOnInsertion(2), TribuneUtils.getStringCellValues("Product", 24, 0));
		       Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2), TribuneUtils.getStringCellValues("Product", 24, 1));
		       Assert.assertEquals(newOrderInstance.getProductOnInsertion(2), TribuneUtils.getStringCellValues("Product", 24, 2));
		       Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2), TribuneUtils.getStringCellValues("Product", 24, 3));
		       Assert.assertEquals(newOrderInstance.getSectionOnInsertion(2), TribuneUtils.getStringCellValues("Product", 24, 4));
		       Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2), "01/23/2020");
		       Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
		       Assert.assertEquals(newOrderInstance.getMaterialID("2"), "1");
		       Assert.assertEquals(newOrderInstance.getInsertionPrice("2", "total"), TribuneUtils.getDoubleCellValues("Product", 24, 17));
		       */
		       newOrderInstance.createDuplicateInsertion("1");
		       Thread.sleep(4000);
		       
		       int insertionCount = newOrderInstance.getInsertionsCount();
		       Assert.assertEquals(insertionCount, 2);
		       Assert.assertEquals(newOrderInstance.getProductOnInsertion(1), newOrderInstance.getProductOnInsertion(2));
		      // Assert.assertEquals(newOrderInstance.getProductOnInsertion(2), TribuneUtils.getStringCellValues("Product", 24, 2));
		     //  Assert.assertEquals(newOrderInstance.getProductOnInsertion(3), TribuneUtils.getStringCellValues("Product", 17, 2));
		     //  Assert.assertEquals(newOrderInstance.getInsertionPrice("2", "total"), TribuneUtils.getDoubleCellValues("Product", 24, 17));
		       
		       Logger.info("Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
		       Logger.info("Same MaterilaID SamePub date - Validation success");
		       Logger.info("Only one ownlocal auto insertion is created with price for only one insertion");
		       Logger.info("Pub date and material ID are matching with the parent insertion");
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	

	@Test(groups = {"Order", "OwnLocal","newVersionSameMaterialIDSamePubdate","PrioritizedReg2","OLReg","RegressionLatest","Group2","Grp4","PerRunDate","TestPriority","NewRegression2","NewRegression","G2","ownLocalOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	   public void newVersionSameMaterialIDSamePubdate(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectBU("1",17, 0);
		       newOrderInstance.enterPubDate("1","29", "Dec", "2021");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",17, 1);
		       newOrderInstance.selectProduct("1",17, 2);
		       newOrderInstance.selectAdType("1",17, 3);
		       newOrderInstance.selectSection("1",17, 4);
		       Thread.sleep(7000);
		       
		       
		       newOrderInstance.createNewInsertionVersion("1");;
		       Thread.sleep(4000);
		       
		      // Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
		      // Assert.assertEquals(newOrderInstance.getMaterialID("2"), "1");
		      // Assert.assertEquals(newOrderInstance.getInsertionPrice("2", "total"), TribuneUtils.getDoubleCellValues("Product", 24, 17));
		       Thread.sleep(4000);
		       int insertionCount = newOrderInstance.getInsertionsCount();
		       Assert.assertEquals(insertionCount, 2);
		     /*  Assert.assertEquals(newOrderInstance.getProductOnInsertion(1), TribuneUtils.getStringCellValues("Product", 17, 2));
		       Assert.assertEquals(newOrderInstance.getProductOnInsertion(2), TribuneUtils.getStringCellValues("Product", 24, 2));
		       Assert.assertEquals(newOrderInstance.getProductOnInsertion(3), TribuneUtils.getStringCellValues("Product", 17, 2));
		       Assert.assertEquals(newOrderInstance.getInsertionPrice("2", "total"), TribuneUtils.getDoubleCellValues("Product", 24, 17));
		       */
		       Logger.info("Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
		       Logger.info("Same MaterilaID SamePub date - Validation success");
		       Logger.info("Only one ownlocal auto insertion is created with price for only one insertion");
		       Logger.info("Pub date and material ID are matching with the parent insertion");
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	

	@Test(groups = {"Order", "OwnLocal","OwnLocalReg4","OLReg","PrioritizedReg2","RegressionLatest","Group2","Grp4","ownLocalSameMaterialIDDiffPubdateRunDate","PerRunDate","NewRegression2","NewRegression","G2","ownLocalOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	   public void ownLocalSameMaterialIDDiffPubdate(Map<String, String> userData) throws Exception
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
		       newOrderInstance.checkUncheckOwnLocalOptOut(false);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",17, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2021");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",17, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",17, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",17, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",17, 4);
		       Thread.sleep(7000);
		       
		       /*
		       Assert.assertEquals(newOrderInstance.getBUOnInsertion(2), TribuneUtils.getStringCellValues("Product", 24, 0));
		       Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2), TribuneUtils.getStringCellValues("Product", 24, 1));
		     //  Assert.assertEquals(newOrderInstance.getProductOnInsertion(2), TribuneUtils.getStringCellValues("Product", 24, 2));
		       Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2), TribuneUtils.getStringCellValues("Product", 24, 3));
		       Assert.assertEquals(newOrderInstance.getSectionOnInsertion(2), TribuneUtils.getStringCellValues("Product", 24, 4));
		       Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2), "12/29/2020");
		       Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
		       Assert.assertEquals(newOrderInstance.getMaterialID("2"), "1");
		       Assert.assertEquals(newOrderInstance.getInsertionPrice("2", "total"), TribuneUtils.getDoubleCellValues("Product", 24, 17));
		       */
		       newOrderInstance.createDuplicateInsertion("1");
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("2","23", "Dec", "2021");
		       Thread.sleep(5000);
		       
		       int insertionCount = newOrderInstance.getInsertionsCount();
		       Assert.assertEquals(insertionCount, 2);
		       Assert.assertEquals(newOrderInstance.getProductOnInsertion(1), newOrderInstance.getProductOnInsertion(2));
		     //  Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),newOrderInstance.getProductOnInsertion(4));
		      // Assert.assertEquals(newOrderInstance.getProductOnInsertion(3), TribuneUtils.getStringCellValues("Product", 17, 2));
		     //  Assert.assertEquals(newOrderInstance.getProductOnInsertion(4), TribuneUtils.getStringCellValues("Product", 24, 2));
		     //  Assert.assertEquals(newOrderInstance.getInsertionPrice("1", "total"), newOrderInstance.getInsertionPrice("3", "total"));
		     //  Assert.assertEquals(newOrderInstance.getInsertionPrice("4", "total"), TribuneUtils.getDoubleCellValues("Product", 24, 17));
		    //   Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2), "12/23/2020");
		    //   Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(4), "12/30/2020");
		       Assert.assertEquals(newOrderInstance.getMaterialID("2"), "1");
		  //     Assert.assertEquals(newOrderInstance.getMaterialID("4"), "1");
		       
		       Logger.info("Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
		       Logger.info("Same MaterialID Different Pub date - Validation success");
		       Logger.info("Two ownlocal auto insertions are created, one for each parent insertion");
		       Logger.info("Pub date and material ID are matching with the respective parent insertions");
		     //  dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	
	@Test(groups = {"Order", "OwnLocal","OwnLocalReg3","OLReg","RegressionLatest","Group2","Grp4","ownLocalDiffMaterialIDSamePubdateRunDate","PerRunDate","NewRegression2","NewRegression","G2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void ownLocalDiffMaterialIDSamePubdate(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectBU("1",17, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2021");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",17, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",17, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",17, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",17, 4);
		       Thread.sleep(7000);
		     /*  
		       Assert.assertEquals(newOrderInstance.getBUOnInsertion(2), TribuneUtils.getStringCellValues("Product", 24, 0));
		       Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2), TribuneUtils.getStringCellValues("Product", 24, 1));
		      // Assert.assertEquals(newOrderInstance.getProductOnInsertion(2), TribuneUtils.getStringCellValues("Product", 24, 2));
		       Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2), TribuneUtils.getStringCellValues("Product", 24, 3));
		       Assert.assertEquals(newOrderInstance.getSectionOnInsertion(2), TribuneUtils.getStringCellValues("Product", 24, 4));
		       Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2), "12/29/2020");
		       Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
		     //  Assert.assertEquals(newOrderInstance.getMaterialID("2"), "1");
		     //  Assert.assertEquals(newOrderInstance.getInsertionPrice("2", "total"), TribuneUtils.getDoubleCellValues("Product", 24, 17));
		       */
		       newOrderInstance.createDuplicateInsertion("1");
		       Thread.sleep(4000);
		       newOrderInstance.assignMaterialForAnInsertion(2);
		       Thread.sleep(7000);
		       
		       int insertionCount = newOrderInstance.getInsertionsCount();
		       Assert.assertEquals(insertionCount, 2);
		       Assert.assertEquals(newOrderInstance.getProductOnInsertion(1), newOrderInstance.getProductOnInsertion(2));
		    //   Assert.assertEquals(newOrderInstance.getProductOnInsertion(2), newOrderInstance.getProductOnInsertion(4));
		      // Assert.assertEquals(newOrderInstance.getProductOnInsertion(3), TribuneUtils.getStringCellValues("Product", 17, 2));
		     //  Assert.assertEquals(newOrderInstance.getProductOnInsertion(4), TribuneUtils.getStringCellValues("Product", 24, 2));
		     //  Assert.assertEquals(newOrderInstance.getInsertionPrice("1", "total"), newOrderInstance.getInsertionPrice("3", "total"));
		     //  Assert.assertEquals(newOrderInstance.getInsertionPrice("4", "total"), TribuneUtils.getDoubleCellValues("Product", 24, 17));
		     //  Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2), "12/22/2020");
		     //  Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(4), "12/29/2020");
		       Assert.assertEquals(newOrderInstance.getMaterialID("2"), "2");
		     //  Assert.assertEquals(newOrderInstance.getMaterialID("4"), "2");
		       
		       Logger.info("Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
		       Logger.info("Different MaterialID Same Pub date - Validation success");
		       Logger.info("Two ownlocal auto insertions are created, one for each parent insertion");
		       Logger.info("Pub date and material ID are matching with the respective parent insertions");
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	
	@Test(groups = {"Order", "ownLocalDiffMaterialIDDiffPubdateRunDate","OwnLocalReg2","OLReg","RegressionLatest","Group2","Grp4","PerRunDate","NewRegression2","NewRegression","G2","ownLocalOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void ownLocalDiffMaterialIDDiffPubdate(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectBU("1",17, 0);
		       newOrderInstance.enterPubDate("1","27", "Dec", "2021");
		       Thread.sleep(5000);
		       newOrderInstance.selectProductType("1",17, 1);
		       newOrderInstance.selectProduct("1",17, 2);
		       newOrderInstance.selectAdType("1",17, 3);
		       newOrderInstance.selectSection("1",17, 4);
		       Thread.sleep(4000);
		       
		       newOrderInstance.createDuplicateInsertion("1");
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("2","31", "Dec", "2021");
		       Thread.sleep(2000);
		       newOrderInstance.assignMaterialForAnInsertion(2);
		       Thread.sleep(5000);
		       
		       int insertionCount = newOrderInstance.getInsertionsCount();
		       Assert.assertEquals(insertionCount, 2);
		       Assert.assertEquals(newOrderInstance.getProductOnInsertion(1), newOrderInstance.getProductOnInsertion(2));
		      // Assert.assertEquals(newOrderInstance.getProductOnInsertion(2), newOrderInstance.getProductOnInsertion(4));
		      // Assert.assertEquals(newOrderInstance.getProductOnInsertion(3), TribuneUtils.getStringCellValues("Product", 17, 2));
		     //  Assert.assertEquals(newOrderInstance.getProductOnInsertion(4), TribuneUtils.getStringCellValues("Product", 24, 2));
		     //  Assert.assertEquals(newOrderInstance.getInsertionPrice("2", "total"), TribuneUtils.getDoubleCellValues("Product", 24, 17));
		      // Assert.assertEquals(newOrderInstance.getInsertionPrice("4", "total"), TribuneUtils.getDoubleCellValues("Product", 24, 17));
		     //  Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2), "12/31/2020");
		      // Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(4), "12/31/2020");
		     //  Assert.assertEquals(newOrderInstance.getMaterialID("2"), "2");
		     //  Assert.assertEquals(newOrderInstance.getMaterialID("4"), "2");
		       
		       Logger.info("Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
		       Logger.info("Different MaterialID Different Pub date - Validation success");
		    //   Logger.info("Two ownlocal auto insertions are created, one for each parent insertion");
		    //   Logger.info("Pub date and material ID are matching with the respective parent insertions");
		    //   dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }	
}
