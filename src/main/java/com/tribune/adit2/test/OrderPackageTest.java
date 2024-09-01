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
 * @since January 2016
 */

public class OrderPackageTest 
{
	/**
	 * This test creates a new package and loads it
	 *  Validation : 1) check if the number of insertions in the package are loaded correctly
	 *  	 		 2) check if the BU, product type, product, ad type and section matching as per the package
	 *  			 3) check if the pub date is not copied from the insertions in the package
	 *  			 4) check if the package name, effective from date and effective to date are showing correctly on the load package window
	 */
	@Test(groups = {"Order", "Package","saveAndLoadPackage","Grp4","RegressionLatestN","Group6","NewRegression2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void saveAndLoadPackage(Map<String, String> userData) throws Exception
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
		        newOrderInstance.selectOrderType("OrderType_Standard"); newOrderInstance.checkUncheckOwnLocalOptOut(false); Thread.sleep(4000);
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",6, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDateFromExcel("1", 7, 27);//swagata
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",7, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",7, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",7, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",7, 4);
		       Thread.sleep(4000);
		      
		       double priceFirstInsertion = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("FirstInsertion price= "+priceFirstInsertion);
		       Thread.sleep(2000);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("2",2, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDateFromExcel("2", 2, 27);//swagata
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("2",2, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("2",2, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("2",2, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("2",2, 4);
		       Thread.sleep(4000);
		      
		       //newOrderInstance.selectMaterialSource("2","NewBuild");
		       double priceSecondInsertion = newOrderInstance.getInsertionPrice("2", "total");
		       Logger.info("SecondInsertion price "+priceSecondInsertion);
		       Thread.sleep(1000);
		       int count = newOrderInstance.getInsertionsCount();
		       
		       newOrderInstance.clickOnSavePackage();
		       String pkgName = newOrderInstance.enterPackageName("unique");
		       newOrderInstance.clickOnCancelPackage(pkgName);
		       Thread.sleep(2000);
		       
		       newOrderInstance.clickOnSavePackage();
		       String packageName = newOrderInstance.enterPackageName("unique");
		       newOrderInstance.enterPackageEffectiveFromDate(03, 17, 2019);
		       newOrderInstance.enterPackageEffectiveToDate(12, 25, 2025);
		       newOrderInstance.enterPackageDescription();
		       newOrderInstance.clickOnCreatePackage();
		       Thread.sleep(6000);
		       
		       String initialOrderLine1BU = newOrderInstance.getBUOnInsertion(1);
		       String initialOrderLine1PubDate = newOrderInstance.getPubDateOnInsertion(1);
		       String initialOrderLine1ProductType = newOrderInstance.getProductTypeOnInsertion(1);
		       String initialOrderLine1Product = newOrderInstance.getProductOnInsertion(1);
		       String initialOrderLine1AdType = newOrderInstance.getAdTypeOnInsertion(1);
		       String initialOrderLine1Section = newOrderInstance.getSectionOnInsertion(1);
		       
		       String initialOrderLine2BU = newOrderInstance.getBUOnInsertion(2);
		       String initialOrderLine2PubDate = newOrderInstance.getPubDateOnInsertion(2);
		       String initialOrderLine2ProductType = newOrderInstance.getProductTypeOnInsertion(2);
		       String initialOrderLine2Product = newOrderInstance.getProductOnInsertion(2);
		       String initialOrderLine2AdType = newOrderInstance.getAdTypeOnInsertion(2);
		       String initialOrderLine2Section = newOrderInstance.getSectionOnInsertion(2);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);
		       newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");
		       Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
		       newOrderInstance.applytoAllSalesRepOnInsertion(2);Thread.sleep(2000);Thread.sleep(4000);		       
		       newOrderInstance.submitOrder();
		       //Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       OrderEntryHomePage orderEntryInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage orderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       orderInstance.selectSoldToCustomerBU("bu_LAT");
		       orderInstance.enterSoldToCustomer("CU00059747");
		       orderInstance.selectBilltoSameAsSoldTo();
		      // orderInstance.selectOrderType("OrderType_Standard");
		       //orderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       
		       Thread.sleep(2000);
		       orderInstance.clickOnLoadPackage();
		       Thread.sleep(3000);
		       boolean packageCreationFlag = orderInstance.newPackageValidationInLoadPkg(packageName, "03/17/2019", "12/25/2025");
		       Assert.assertEquals(packageCreationFlag, true);
		       orderInstance.selectPackageToLoad(packageName);
		       orderInstance.loadPackageInPackageLoadWindow();
		       Thread.sleep(3000);
		       
		       Assert.assertEquals(orderInstance.getInsertionsCount(), count);
		       String actualOrderLine1PubDate = orderInstance.getPubDateOnInsertion(1);
		       boolean pubDateFirstInsertionFlag = false;
		       if(!actualOrderLine1PubDate.equalsIgnoreCase(initialOrderLine1PubDate))
		       {
		    	   Logger.info("Validation success- pub date on insertion 1 is not copied");
		    	   pubDateFirstInsertionFlag = true;
		    	   
		       }
		       /*
		       Assert.assertEquals(pubDateFirstInsertionFlag, true);
		       Assert.assertEquals(orderInstance.getBUOnInsertion(1), initialOrderLine1BU);
		       Assert.assertEquals(orderInstance.getProductTypeOnInsertion(1), initialOrderLine1ProductType);
		       Assert.assertEquals(orderInstance.getProductOnInsertion(1), initialOrderLine1Product);
		       Assert.assertEquals(orderInstance.getAdTypeOnInsertion(1), initialOrderLine1AdType);
		       Assert.assertEquals(orderInstance.getSectionOnInsertion(1), initialOrderLine1Section);		       
		       Assert.assertEquals(orderInstance.getBUOnInsertion(2), initialOrderLine2BU);
		       */
		       String actualOrderLine2PubDate = orderInstance.getPubDateOnInsertion(2);
		       boolean pubDateSecondInsertionFlag = false;
		       if(!actualOrderLine2PubDate.equalsIgnoreCase(initialOrderLine2PubDate))
		       {
		    	   Logger.info("Validation success- pub date on insertion 2 is not copied");
		    	   pubDateSecondInsertionFlag = true;
		    	   
		       }
		       /*
		       Assert.assertEquals(pubDateSecondInsertionFlag, true);
		       Assert.assertEquals(orderInstance.getProductTypeOnInsertion(2), initialOrderLine2ProductType);
		       Assert.assertEquals(orderInstance.getProductOnInsertion(2), initialOrderLine2Product);
		       Assert.assertEquals(orderInstance.getAdTypeOnInsertion(2), initialOrderLine2AdType);
		       Assert.assertEquals(orderInstance.getSectionOnInsertion(2), initialOrderLine2Section);
		       */
		       newOrderInstance.enterPubDateFromExcel("1", 7, 27);//swagata
		       newOrderInstance.enterPubDateFromExcel("2", 2, 27);//swagata
		   //    orderInstance.clickOnInsertionSalesRepSection(1);
		   //    orderInstance.addNewSalesRepOnInsertion(1, "SA00443");
		   //    orderInstance.clickOnInsertionSalesRepSection(2);
		  //     orderInstance.addNewSalesRepOnInsertion(2, "SA00443");
		       Thread.sleep(8000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(2);Thread.sleep(2000);Thread.sleep(4000);
		       orderInstance.submitOrder();
		      // Thread.sleep(3000);
		       Logger.info(orderEntryInstance.getOrderID());
		       orderEntryInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	
	@Test(groups = {"SMaintenance","Order", "Package","saveUpdateAndLoadPackage","Grp4","RegressionLatestN","Group6","NewRegression2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void saveUpdateAndLoadPackage(Map<String, String> userData) throws Exception
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
		        newOrderInstance.selectOrderType("OrderType_Standard"); newOrderInstance.checkUncheckOwnLocalOptOut(false); Thread.sleep(4000);
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",6, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2021");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",7, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",7, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",7, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",7, 4);
		       Thread.sleep(4000);
		       double priceFirstInsertion = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("FirstInsertion price= "+priceFirstInsertion);
		       Thread.sleep(2000);
		       newOrderInstance.clickOnSavePackage();
		       String packageName = newOrderInstance.enterPackageName("unique");
		       newOrderInstance.enterPackageEffectiveFromDate(03, 17, 2019);
		       newOrderInstance.enterPackageEffectiveToDate(12, 25, 2022);
		       newOrderInstance.enterPackageDescription();
		       newOrderInstance.clickOnCreatePackage();
		       Thread.sleep(6000);
		       
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("2",2, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("2","22", "Dec", "2021");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("2",2, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("2",2, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("2",2, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("2",2, 4);
		       Thread.sleep(4000);
		      
		       double priceSecondInsertion = newOrderInstance.getInsertionPrice("2", "total");
		       Logger.info("SecondInsertion price "+priceSecondInsertion);
		       Thread.sleep(1000);
		       int count = newOrderInstance.getInsertionsCount();
		       //newOrderInstance.saveOrder();
		       Thread.sleep(4000);
		       newOrderInstance.clickOnSavePackage();	
		      
		       newOrderInstance.clickOnUpdatePackageTab();
		       newOrderInstance.selectPackageToLoad(packageName);
		       newOrderInstance.clickOnUpdatePackageButton();
		       Thread.sleep(7000);
		       newOrderInstance.saveOrder();
		       Thread.sleep(4000);
		      
		       String initialOrderLine1BU = newOrderInstance.getBUOnInsertion(1);
		       String initialOrderLine1PubDate = newOrderInstance.getPubDateOnInsertion(1);
		       String initialOrderLine1ProductType = newOrderInstance.getProductTypeOnInsertion(1);
		       String initialOrderLine1Product = newOrderInstance.getProductOnInsertion(1);
		       String initialOrderLine1AdType = newOrderInstance.getAdTypeOnInsertion(1);
		       String initialOrderLine1Section = newOrderInstance.getSectionOnInsertion(1);
		       
		       String initialOrderLine2BU = newOrderInstance.getBUOnInsertion(2);
		       String initialOrderLine2PubDate = newOrderInstance.getPubDateOnInsertion(2);
		       String initialOrderLine2ProductType = newOrderInstance.getProductTypeOnInsertion(2);
		       String initialOrderLine2Product = newOrderInstance.getProductOnInsertion(2);
		       String initialOrderLine2AdType = newOrderInstance.getAdTypeOnInsertion(2);
		       String initialOrderLine2Section = newOrderInstance.getSectionOnInsertion(2);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");
		       Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);	   
		       newOrderInstance.applytoAllSalesRepOnInsertion(2);
		       Thread.sleep(2000);
		       Thread.sleep(4000);      
		       newOrderInstance.submitOrder();
		       //Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       OrderEntryHomePage orderEntryInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage orderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       orderInstance.selectSoldToCustomerBU("bu_LAT");
		       orderInstance.enterSoldToCustomer("CU00059747");
		       orderInstance.selectBilltoSameAsSoldTo();
		      // orderInstance.selectOrderType("OrderType_Standard");
		       //orderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       
		       Thread.sleep(2000);
		       orderInstance.clickOnLoadPackage();
		       Thread.sleep(3000);
		       boolean packageCreationFlag = orderInstance.newPackageValidationInLoadPkg(packageName, "03/17/2019", "12/25/2022");
		       Assert.assertEquals(packageCreationFlag, true);
		       orderInstance.selectPackageToLoad(packageName);
		       orderInstance.loadPackageInPackageLoadWindow();
		       Thread.sleep(3000);
		       
		       Assert.assertEquals(orderInstance.getInsertionsCount(), count);
		       String actualOrderLine1PubDate = orderInstance.getPubDateOnInsertion(1);
		       boolean pubDateFirstInsertionFlag = false;
		       if(!actualOrderLine1PubDate.equalsIgnoreCase(initialOrderLine1PubDate))
		       {
		    	   Logger.info("Validation success- pub date on insertion 1 is not copied");
		    	   pubDateFirstInsertionFlag = true;
		    	   
		       }
		       /*
		       Assert.assertEquals(pubDateFirstInsertionFlag, true);
		       Assert.assertEquals(orderInstance.getBUOnInsertion(1), initialOrderLine1BU);
		       Assert.assertEquals(orderInstance.getProductTypeOnInsertion(1), initialOrderLine1ProductType);
		       Assert.assertEquals(orderInstance.getProductOnInsertion(1), initialOrderLine1Product);
		       Assert.assertEquals(orderInstance.getAdTypeOnInsertion(1), initialOrderLine1AdType);
		       Assert.assertEquals(orderInstance.getSectionOnInsertion(1), initialOrderLine1Section);		       
		       Assert.assertEquals(orderInstance.getBUOnInsertion(2), initialOrderLine2BU);
		       */
		       String actualOrderLine2PubDate = orderInstance.getPubDateOnInsertion(2);
		       
		       boolean pubDateSecondInsertionFlag = false;
		       if(!actualOrderLine2PubDate.equalsIgnoreCase(initialOrderLine2PubDate))
		       {
		    	   Logger.info("Validation success- pub date on insertion 2 is not copied");
		    	   pubDateSecondInsertionFlag = true;
		    	   
		       }
		       /*
		       Assert.assertEquals(pubDateSecondInsertionFlag, true);
		       Assert.assertEquals(orderInstance.getProductTypeOnInsertion(2), initialOrderLine2ProductType);
		       Assert.assertEquals(orderInstance.getProductOnInsertion(2), initialOrderLine2Product);
		       Assert.assertEquals(orderInstance.getAdTypeOnInsertion(2), initialOrderLine2AdType);
		       Assert.assertEquals(orderInstance.getSectionOnInsertion(2), initialOrderLine2Section);
		       */
		       orderInstance.enterPubDate("1","22", "Dec", "2021");
		       orderInstance.enterPubDate("2","22", "Dec", "2021");
		   //    orderInstance.clickOnInsertionSalesRepSection(1);
		   //    orderInstance.addNewSalesRepOnInsertion(1, "SA00443");
		   //    orderInstance.clickOnInsertionSalesRepSection(2);
		  //     orderInstance.addNewSalesRepOnInsertion(2, "SA00443");
		       Thread.sleep(8000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(2);Thread.sleep(2000);Thread.sleep(4000);
		       orderInstance.submitOrder();
		      // Thread.sleep(3000);
		       Logger.info(orderEntryInstance.getOrderID());
		       orderEntryInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	
	
	/**
	 * @description This test method creates a new package and tries to another package with the same name
	 * Validation: 1) Error message should be displayed when a duplicate package name is given for a new package
	 * 			   2) Correct error message is displayed
	 */
	@Test(groups = {"Order", "Package","duplicatePackage","Grp4","RegressionLatestN","Group3","NewRegression2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void duplicatePackage(Map<String, String> userData) throws Exception
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
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       Thread.sleep(4000);
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",6, 0);
		       Thread.sleep(4000);
/*		       newOrderInstance.enterPubDate("1","22", "Dec", "2021");
*/		     newOrderInstance.enterPubDateFromExcel("1",7,27);//swagata
                Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",7, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",7, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",7, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",7, 4);
		       Thread.sleep(4000);
		      // newOrderInstance.clickOnInsertionSalesRepSection(1);
		     //  newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
		     //  Thread.sleep(2000);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);
		       newOrderInstance.selectBU("2",2, 0);
		       Thread.sleep(4000);
		   	     newOrderInstance.enterPubDateFromExcel("2",2,27);//swagata
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("2",2, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("2",2, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("2",2, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("2",2, 4);
		       Thread.sleep(4000);
		     //  newOrderInstance.clickOnInsertionSalesRepSection(2);
		     //  newOrderInstance.addNewSalesRepOnInsertion(2, "SA00443");
		     //  Thread.sleep(1000);
		       
		       newOrderInstance.clickOnSavePackage();
		       String packageName = newOrderInstance.enterPackageName("unique");
		       newOrderInstance.enterPackageEffectiveFromDate(03, 17, 2017);
		       newOrderInstance.enterPackageEffectiveToDate(12, 25, 2020);
		       newOrderInstance.enterPackageDescription();
		       newOrderInstance.clickOnCreatePackage();
		       Thread.sleep(6000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);
		       newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");
		       Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(2);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       
		       OrderEntryHomePage orderEntryInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage orderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       orderInstance.selectSoldToCustomerBU("bu_LAT");
		       orderInstance.enterSoldToCustomer("CU00059747");
		       orderInstance.selectBilltoSameAsSoldTo();
		       orderInstance.selectOrderType("OrderType_Standard");
		       orderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       orderInstance.createNewInsertion();
		       orderInstance.selectBU("1",6, 0);
		       Thread.sleep(4000);
		   	   newOrderInstance.enterPubDateFromExcel("1",7,27);//swagata
		       Thread.sleep(4000);
		       orderInstance.selectProductType("1",7, 1);
		       Thread.sleep(4000);
		       orderInstance.selectProduct("1",7, 2);
		       Thread.sleep(4000);
		       orderInstance.selectAdType("1",7, 3);
		       Thread.sleep(4000);
		       orderInstance.selectSection("1",7, 4);
		       Thread.sleep(4000);
		       Thread.sleep(2000);
		       orderInstance.createNewInsertion();
		       orderInstance.selectBU("2",2, 0);
		   	     newOrderInstance.enterPubDateFromExcel("2",2,27);//swagata
		       orderInstance.selectProductType("2",2, 1);
		       orderInstance.selectProduct("2",2, 2);
		       orderInstance.selectAdType("2",2, 3);
		       Thread.sleep(4000);
		       orderInstance.selectSection("2",2, 4);
		       Thread.sleep(4000);
		       Thread.sleep(1000);
		       
		       orderInstance.clickOnSavePackage();
		       orderInstance.enterPackageName(packageName);
		       orderInstance.enterPackageEffectiveFromDate(03, 17, 2017);
		       orderInstance.enterPackageEffectiveToDate(12, 28, 2020);
		       orderInstance.enterPackageDescription();
		       orderInstance.clickOnCreatePackage();
		       Thread.sleep(2000);
		       
		       orderInstance.duplicatePackageMessageValidation(packageName);//swagata
		       orderInstance.clickOnCancelPackage(packageName);
		       Thread.sleep(4000);
		       driver.navigate().refresh();
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	
	/**
	 * @description This test method tries to create a new package without adding any orderlines
	 * Validation: 1) Warning message should be displayed 
	 * 			   2) Correct message is displayed
	 */
	@Test(groups = {"Order", "PackageTest",}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void insufficientOrderlinesCreatePackage(Map<String, String> userData) throws Exception
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
		        newOrderInstance.selectOrderType("OrderType_Standard"); newOrderInstance.checkUncheckOwnLocalOptOut(false); Thread.sleep(4000);
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",6, 0);
		       newOrderInstance.enterPubDate("1","29", "Dec", "2021");
		       newOrderInstance.selectProductType("1",7, 1);
		       newOrderInstance.selectProduct("1",7, 2);
		       newOrderInstance.selectAdType("1",7, 3);
		       newOrderInstance.selectSection("1",7, 4);
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
		       Thread.sleep(2000);

		       newOrderInstance.clickOnSavePackage();
		       Thread.sleep(2000);
		       newOrderInstance.displayErrorMessage();
		       newOrderInstance.compareErrorMessageSingleErr(userData, "NoOrderlinePackageError");
		       driver.navigate().refresh();
		       
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	
	/**
	 * @description This test method validates save/load package visibility for an existing order
	 * 
	 */
	@Test(groups = {"existingOrderSavePackage", "Package","Grp2","RegressionLatestN","Group6","NewRegression2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void existingOrderSavePackage(Map<String, String> userData) throws Exception
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
		        newOrderInstance.checkUncheckOwnLocalOptOut(true); 
		        Thread.sleep(4000);
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",6, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDateFromExcel("1", 7, 27);//swagata
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",7, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",7, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",7, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",7, 4);
		       
		       Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
		       Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);
		       Thread.sleep(2000);
		       WebDriverWait wait = new WebDriverWait(driver,120);
		       newOrderInstance.submitOrder();
		      // Thread.sleep(3000);
		       String orderID = orderEntryPageInstance.getOrderID();

		       Logger.info("Order: " + orderID);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       orderEntryPageInstance.clickOnOrder(orderID);
		       wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement));
		       
		      
		       
		       Assert.assertEquals(newOrderInstance.checkVisibilityOfSavePackage(), false);
		       newOrderInstance.packageButton.click();
		       Assert.assertEquals(newOrderInstance.checkVisibilityOfLoadPackage(), true);
		   
		      // dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	
	/**
	 * @description This test method validates load package functionality based on the effective date range
	 * 
	 */
	@Test(groups = {"Order", "Package","packageEffectiveDateRange","Grp4","RegressionLatestN","Group6","NewRegression2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void packageEffectiveDateRange(Map<String, String> userData) throws Exception
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
		        newOrderInstance.checkUncheckOwnLocalOptOut(true); 
		        Thread.sleep(4000);
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",6, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDateFromExcel("1", 7, 27);//swagata
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",7, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",7, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",7, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",7, 4);
		       Thread.sleep(4000);
		      
		       
		       newOrderInstance.clickOnSavePackage();
		       newOrderInstance.selectPackageBU("CTC");//swagata
		       String packageName = newOrderInstance.enterPackageName("unique");
		       newOrderInstance.enterPackageEffectiveFromDate(03, 17, 2019);
		       newOrderInstance.enterPackageEffectiveToDate(12, 27, 2025);//swagata
		       newOrderInstance.enterPackageDescription();
		       newOrderInstance.clickOnCreatePackage();
		       Thread.sleep(6000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   
		       newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		      // Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       
		       OrderEntryHomePage orderEntryInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage orderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       orderInstance.selectSoldToCustomerBU("bu_LAT");
		       orderInstance.enterSoldToCustomer("CU00059747");
		       orderInstance.selectBilltoSameAsSoldTo();
		       orderInstance.selectOrderType("OrderType_Standard");
		       orderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       
		       Thread.sleep(5000);
		       orderInstance.clickOnLoadPackage();
		       Thread.sleep(5000);
		       boolean packageCreationFlag = orderInstance.newPackageValidationInLoadPkg(packageName, "03/17/2019", "12/27/2025");//swagata
		       Logger.info("Package Created Found: "+packageCreationFlag);
		       Assert.assertEquals(packageCreationFlag, true);
		       orderInstance.cancelPackageToLoad();
		       Thread.sleep(3000);
		       
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	
	/**
	 * @description This test method creates a new package and loads the package in an order where already orderlines are added 
	 * (Replace existing orderlines check box is not selected) 
	 */
	@Test(groups = {"Order", "Package","replaceExistingOrderLinesPackage","Grp4","RegressionLatestN","Group6","NewRegression2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void replaceExistingOrderLinesPackage(Map<String, String> userData) throws Exception
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
		        newOrderInstance.checkUncheckOwnLocalOptOut(true); Thread.sleep(4000);
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);
		       newOrderInstance.selectBU("1",6, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDateFromExcel("1", 7, 27);//swagata
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",7, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",7, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",7, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",7, 4);
		       Thread.sleep(4000);
		       
		       String initialOrderLine1BU = newOrderInstance.getBUOnInsertion(1);
		       String initialOrderLine1ProductType = newOrderInstance.getProductTypeOnInsertion(1);
		       String initialOrderLine1Product = newOrderInstance.getProductOnInsertion(1);
		       String initialOrderLine1AdType = newOrderInstance.getAdTypeOnInsertion(1);
		       String initialOrderLine1Section = newOrderInstance.getSectionOnInsertion(1);
		       
		       newOrderInstance.clickOnSavePackage();
		       String packageName = newOrderInstance.enterPackageName("unique");
		       Logger.info(packageName);
		       newOrderInstance.enterPackageEffectiveFromDate(03, 17, 2019);
		       newOrderInstance.enterPackageEffectiveToDate(12, 25, 2025);//swagata
		       newOrderInstance.enterPackageDescription();
		       newOrderInstance.clickOnCreatePackage();
		       Thread.sleep(6000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);	   
		       newOrderInstance.applytoAllSalesRepOnInsertion(1);
		       Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		      // Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       
		       OrderEntryHomePage orderEntryInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage orderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       orderInstance.selectSoldToCustomerBU("bu_LAT");
		       orderInstance.enterSoldToCustomer("CU00059747");
		       orderInstance.selectBilltoSameAsSoldTo();
		       orderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true); Thread.sleep(4000);
		       orderInstance.createNewInsertion();
		       orderInstance.selectBU("1",2, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDateFromExcel("1", 2, 27);//swagata
		       Thread.sleep(4000);
		       orderInstance.selectProductType("1",2, 1);
		       Thread.sleep(4000);
		       orderInstance.selectProduct("1",2, 2);
		       Thread.sleep(4000);
		       orderInstance.selectAdType("1",2, 3);
		       Thread.sleep(4000);
		       orderInstance.selectSection("1",2, 4);
		       Thread.sleep(4000);
		       orderInstance.clickOnLoadPackage();
		       Thread.sleep(3000);
		       boolean packageCreationFlag = orderInstance.newPackageValidationInLoadPkg(packageName, "03/17/2019", "12/25/2025");//swagata
		       Assert.assertEquals(packageCreationFlag, true);
		       orderInstance.selectPackageToLoad(packageName);
		       orderInstance.clickOnReplaceExistingInsertionsLoadPkg();
		       orderInstance.loadPackageInPackageLoadWindow();
		       Thread.sleep(8000);
		       orderInstance.clickOnPackageReplaceConfirmationBtn();
		       Thread.sleep(4000);
		       /*
		       Assert.assertEquals(orderInstance.getBUOnInsertion(1), initialOrderLine1BU);
		       Assert.assertEquals(orderInstance.getProductTypeOnInsertion(1), initialOrderLine1ProductType);
		       Assert.assertEquals(orderInstance.getProductOnInsertion(1), initialOrderLine1Product);
		       Assert.assertEquals(orderInstance.getAdTypeOnInsertion(1), initialOrderLine1AdType);
		       Assert.assertEquals(orderInstance.getSectionOnInsertion(1), initialOrderLine1Section);
		      */
		       Thread.sleep(4000);
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	
	/**
	 * @description This test method creates a new package and loads the package in an order where already orderlines are added 
	 * (Replace existing orderlines check box is not selected) 
	 */
	@Test(groups = {"Order", "Package","withoutReplaceExistingOrderLinesPackage","Grp4","RegressionLatestN","Group6"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void withoutReplaceExistingOrderLinesPackage(Map<String, String> userData) throws Exception
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
		        newOrderInstance.selectOrderType("OrderType_Standard"); newOrderInstance.checkUncheckOwnLocalOptOut(false); Thread.sleep(4000);
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);
		       newOrderInstance.selectBU("1",6, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2021");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",7, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",7, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",7, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",7, 4);
		       Thread.sleep(4000);
		       
		       int packageInsertionCount = newOrderInstance.getInsertionsCount();
		       newOrderInstance.clickOnSavePackage();
		       String packageName = newOrderInstance.enterPackageName("unique");
		       newOrderInstance.enterPackageEffectiveFromDate(03, 17, 2017);
		       newOrderInstance.enterPackageEffectiveToDate(12, 25, 2019);
		       newOrderInstance.enterPackageDescription();
		       newOrderInstance.clickOnCreatePackage();
		       Thread.sleep(6000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		      // Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       
		       OrderEntryHomePage orderEntryInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage orderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       orderInstance.selectSoldToCustomerBU("bu_LAT");
		       orderInstance.enterSoldToCustomer("CU00059747");
		       orderInstance.selectBilltoSameAsSoldTo();
		       orderInstance.selectOrderType("OrderType_Standard");
		     //  orderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       
		       Thread.sleep(4000);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(8000);
		       newOrderInstance.selectBU("1",2, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2021");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",2, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",2, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",2, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(4000);
		      
		       orderInstance.clickOnLoadPackage();
		       Thread.sleep(3000);
		       boolean packageCreationFlag = orderInstance.newPackageValidationInLoadPkg(packageName, "03/17/2017", "12/25/2019");
		       Assert.assertEquals(packageCreationFlag, true);
		       orderInstance.selectPackageToLoad(packageName);
		       orderInstance.loadPackageInPackageLoadWindow();
		       Thread.sleep(3000);
		       
		       int newInsertionCount = newOrderInstance.getInsertionsCount();
		       
		       boolean flag = false;
		       if(newInsertionCount>packageInsertionCount)
		       {
		    	   Logger.info("package orderlines are appended to the existing orderlines");
		    	   flag = true;
		       }
		       Thread.sleep(6000);
		      // Assert.assertEquals(flag, true);
		       
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	
	@Test(groups = {"Order", "Package","packagePositionTemplate","Grp4","RegressionLatestN","Group6","NewRegression2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void packagePositionTemplate(Map<String, String> userData) throws Exception
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
		       newOrderInstance.enterSoldToCustomer("CU00000113");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		        newOrderInstance.selectOrderType("OrderType_Standard"); newOrderInstance.checkUncheckOwnLocalOptOut(false); Thread.sleep(4000);
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);
		       newOrderInstance.selectBU("1",29, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDateFromExcel("1", 29, 27);//swagata
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",29, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",29, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",29, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",29, 4);
		       Thread.sleep(4000);
		       newOrderInstance.enterClassCodeForAnInsertion(1, "10330");
		       Thread.sleep(3000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
		       newOrderInstance.clickOnPositionSelector();
		       Thread.sleep(10000);
		      newOrderInstance.selectAdSizeForPosition();
			      Thread.sleep(3000);
			     // newOrderInstance.clickOnSearchPositionInPSWindw();
			    //  Thread.sleep(8000);
			    //  newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
			      newOrderInstance.selectFirstPostionFrmPositionSlctr();
			       newOrderInstance.savePositionSelection();
			       Thread.sleep(5000);
		       double priceFirstInsertion = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("FirstInsertion price= "+priceFirstInsertion);
		       newOrderInstance.collapseInsertionDetails("1");//swagata
		       Thread.sleep(2000);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("2",30, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDateFromExcel("2", 29,27);//swagata
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("2",30, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("2",30, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("2",30, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("2",30, 4);
		       Thread.sleep(4000);
		       newOrderInstance.enterClassCodeForAnInsertion(2, "10330");
			      Thread.sleep(6000);
		       double priceSecondInsertion = newOrderInstance.getInsertionPrice("2", "total");
		       Logger.info("SecondInsertion price "+priceSecondInsertion);
		       Thread.sleep(1000);
		       newOrderInstance.collapseInsertionDetails("2");//swagata
		       Logger.info("initial insertion count "+newOrderInstance.getInsertionsCount());
		       
		       newOrderInstance.clickOnSavePackage();
		       String packageName = newOrderInstance.enterPackageName("unique");
		       newOrderInstance.enterPackageEffectiveFromDate(03, 17, 2017);
		       newOrderInstance.enterPackageEffectiveToDate(12, 30, 2020);//swagata
		       newOrderInstance.enterPackageDescription();
		       newOrderInstance.clickOnCreatePackage();
		       Thread.sleep(6000);
		       
		       Logger.info("initialOrderLine1BU "+newOrderInstance.getBUOnInsertion(1));
		       Logger.info("initialOrderLine1PubDate "+newOrderInstance.getPubDateOnInsertion(1));
		       Logger.info("initialOrderLine1ProductType "+newOrderInstance.getProductTypeOnInsertion(1));
		       Logger.info("initialOrderLine1Product "+newOrderInstance.getProductOnInsertion(1));
		       Logger.info("initialOrderLine1AdType "+newOrderInstance.getAdTypeOnInsertion(1));
		       Logger.info("initialOrderLine1Section "+newOrderInstance.getSectionOnInsertion(1));
		       
		       Logger.info("initialOrderLine2BU "+newOrderInstance.getBUOnInsertion(2));
		       Logger.info("initialOrderLine2PubDate "+newOrderInstance.getPubDateOnInsertion(2));
		       Logger.info("initialOrderLine2ProductType "+newOrderInstance.getProductTypeOnInsertion(2));
		       Logger.info("initialOrderLine2Product "+newOrderInstance.getProductOnInsertion(2));
		       Logger.info("initialOrderLine2AdType "+newOrderInstance.getAdTypeOnInsertion(2));
		       Logger.info("initialOrderLine2Section "+newOrderInstance.getSectionOnInsertion(2));
		       Thread.sleep(3000);		      
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
		       newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   
		       newOrderInstance.applytoAllSalesRepOnInsertion(2);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       //Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       String orderID = orderEntryPageInstance.getOrderID();
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       //partha
		       orderEntryPageInstance.clickOnOrder(orderID);
				Thread.sleep(8000);
				newOrderInstance.clickOnKill();
				Thread.sleep(8000);
				newOrderInstance.clickOnKillOnConfirmation();
				Thread.sleep(8000);
				Thread.sleep(10000);
				String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
				Logger.info("orderStatus "+orderStatus);
		       //
		       OrderEntryHomePage orderEntryInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage orderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       orderInstance.selectSoldToCustomerBU("bu_DPR");
		       orderInstance.enterSoldToCustomer("CU00000113");
		       orderInstance.selectBilltoSameAsSoldTo();
		       orderInstance.selectOrderType("OrderType_Standard");
		       orderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       orderInstance.createNewInsertion();
		       Thread.sleep(4000);
		       orderInstance.selectBU("1",31, 0);
		       Thread.sleep(4000);
		       orderInstance.enterPubDateFromExcel("1", 29, 27);//swagata
		       Thread.sleep(3000);
		       orderInstance.selectProductType("1",31, 1);
		       Thread.sleep(3000);
		       orderInstance.selectProduct("1",31, 2);
		      // orderInstance.selectAdType("1",31, 3);
		     //  orderInstance.selectSection("1",31, 4);
		       Thread.sleep(4000);
		       orderInstance.enterClassCodeForAnInsertion(1, "10330");
		       Thread.sleep(3000);
		       orderInstance.clickOnSavePackage();
		       orderInstance.clickOnUpdatePackageTab();
		       orderInstance.selectPackageToLoad(packageName);
		       orderInstance.clickOnUpdatePackageButton();
		       Thread.sleep(3000);
		       
//		       driver.navigate().refresh();
//		       orderInstance.selectSoldToCustomerBU("bu_DPR");
//		       orderInstance.enterSoldToCustomer("CU00000113");
//		       orderInstance.selectBilltoSameAsSoldTo();
//		       orderInstance.selectOrderType("OrderType_Standard");
//		    //   orderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		       orderInstance.clickOnLoadPackage();
//		       orderInstance.selectPackageToLoad(packageName);
//		       orderInstance.loadPackageInPackageLoadWindow();
//		       
//		       Logger.info("updated OrderLine1BU "+orderInstance.getBUOnInsertion(1));
//		       Logger.info("updated OrderLine1PubDate "+orderInstance.getPubDateOnInsertion(1));
//		       Logger.info("updated OrderLine1ProductType "+orderInstance.getProductTypeOnInsertion(1));
//		       Logger.info("updated OrderLine1Product "+orderInstance.getProductOnInsertion(1));
//		       Logger.info("updated OrderLine1AdType "+orderInstance.getAdTypeOnInsertion(1));
//		       Logger.info("updated OrderLine1Section "+orderInstance.getSectionOnInsertion(1));
//		      /* 
//		       Assert.assertEquals(orderInstance.getBUOnInsertion(1), TribuneUtils.getStringCellValues("Product", 31, 0));
//		       Assert.assertEquals(orderInstance.getProductTypeOnInsertion(1), TribuneUtils.getStringCellValues("Product", 31, 1));
//		       Assert.assertEquals(orderInstance.getProductOnInsertion(1), TribuneUtils.getStringCellValues("Product", 31, 2));
//		       Assert.assertEquals(orderInstance.getAdTypeOnInsertion(1), TribuneUtils.getStringCellValues("Product", 31, 3));
//		       Assert.assertEquals(orderInstance.getSectionOnInsertion(1), TribuneUtils.getStringCellValues("Product", 31, 4));		       
//		       */
//		       orderInstance.enterPubDate("1","24", "Dec", "2021");
//		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	       newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   	
		       newOrderInstance.applytoAllSalesRepOnInsertion(1);
		       Thread.sleep(4000);
		       
		       orderInstance.submitOrder();
		      // Thread.sleep(3000);
		       Logger.info(orderEntryInstance.getOrderID());
		       orderID=orderEntryInstance.getOrderID();
		       orderEntryInstance.closeOrderSuccessSubmissionMessage();
		       
		     //partha
		       orderEntryPageInstance.clickOnOrder(orderID);
				Thread.sleep(8000);
				newOrderInstance.clickOnKill();
				Thread.sleep(8000);
				newOrderInstance.clickOnKillOnConfirmation();
				Thread.sleep(8000);
				Thread.sleep(10000);
				orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
				Logger.info("orderStatus "+orderStatus);
		       //
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	
	@Test(groups = {"Order", "Package","validateBUFilterLoadPackage","Grp4","RegressionLatestN","Group6"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void validateBUFilterLoadPackage(Map<String, String> userData) throws Exception
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
		        newOrderInstance.selectOrderType("OrderType_Standard"); newOrderInstance.checkUncheckOwnLocalOptOut(false); Thread.sleep(4000);
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",6, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2021");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",7, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",7, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",7, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",7, 4);
		       Thread.sleep(4000);
		       double priceFirstInsertion = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("FirstInsertion price= "+priceFirstInsertion);
		       Thread.sleep(2000);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("2",2, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("2","22", "Dec", "2021");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("2",2, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("2",2, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("2",2, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("2",2, 4);
		       Thread.sleep(4000);
		       //newOrderInstance.selectMaterialSource("2","NewBuild");
		       double priceSecondInsertion = newOrderInstance.getInsertionPrice("2", "total");
		       Logger.info("SecondInsertion price "+priceSecondInsertion);
		       Thread.sleep(1000);
		     
		       newOrderInstance.clickOnSavePackage();
		       newOrderInstance.selectPackageBU("LAT");
		       String packageName = newOrderInstance.enterPackageName("unique");
		       newOrderInstance.enterPackageEffectiveFromDate(03, 17, 2017);
		       newOrderInstance.enterPackageEffectiveToDate(12, 25, 2019);
		       newOrderInstance.enterPackageDescription();
		       Thread.sleep(4000);
		       newOrderInstance.clickOnCreatePackage();
		       Thread.sleep(7000);	
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(2);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       //Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       OrderEntryHomePage orderEntryInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage orderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       orderInstance.selectSoldToCustomerBU("bu_LAT");
		       orderInstance.enterSoldToCustomer("CU00059747");
		       orderInstance.selectBilltoSameAsSoldTo();
		      // orderInstance.selectOrderType("OrderType_Standard");
		       //orderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       
		       Thread.sleep(2000);
		       orderInstance.clickOnLoadPackage();
		       Thread.sleep(3000);
		       boolean packageCreationFlag = orderInstance.newPackageValidationInLoadPkg(packageName, "03/17/2017", "12/25/2019");
		       Assert.assertEquals(packageCreationFlag, true);
		       orderInstance.validatePackageAvailableForBUFilter("LAT",packageName);
		       
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	@Test(groups = {"Order", "Package","saveAndLoadPackageBlankEndDate","Grp4","RegressionLatestN","Group6"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void saveAndLoadPackageBlankEndDate(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectSoldToCustomerBU("bu_SSC");
		       newOrderInstance.enterSoldToCustomer("CU00117844");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		        newOrderInstance.selectOrderType("OrderType_Standard"); 
		        newOrderInstance.checkUncheckOwnLocalOptOut(false); Thread.sleep(4000);
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);	
		       newOrderInstance.selectBU("1",39, 0);
		       Thread.sleep(4000);	
		       newOrderInstance.enterPubDate("1","22", "Dec", "2021");
		       Thread.sleep(6000);
		       newOrderInstance.selectProductTypeByIndex("1",0);
		       Thread.sleep(4000);		     
		       Thread.sleep(4000);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);	
		       newOrderInstance.selectBU("2",39, 0);
		       Thread.sleep(4000);	
		       newOrderInstance.enterPubDate("2","21", "Dec", "2021");
		       Thread.sleep(6000);
		       newOrderInstance.selectProductTypeByIndex("2",0);
		       Thread.sleep(4000);
		     
		       Thread.sleep(4000);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);	
		       newOrderInstance.selectBU("3",39, 0);
		       Thread.sleep(4000);	
		       newOrderInstance.enterPubDate("3","20", "Dec", "2021");
		       Thread.sleep(6000);
		       newOrderInstance.selectProductTypeByIndex("3",0);
		       Thread.sleep(4000);
		     
		       Thread.sleep(4000);
		       int count = newOrderInstance.getInsertionsCount();
		       
		       
		       newOrderInstance.clickOnSavePackage();
		       newOrderInstance.selectBUpackage("SSC");
		       String packageName = newOrderInstance.enterPackageName("unique");
		       newOrderInstance.enterPackageEffectiveFromDate(03, 17, 2017);
		      
		       newOrderInstance.enterPackageDescription();
		       Thread.sleep(4000);
		       newOrderInstance.clickOnCreatePackage();
		       Thread.sleep(6000);    
		      
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
		       newOrderInstance.addNewSalesRepOnInsertion(3, "SA01380");
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);	   
		       newOrderInstance.applytoAllSalesRepOnInsertion(3);
		      Thread.sleep(4000);	       
		       newOrderInstance.submitOrder();
		       //Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       OrderEntryHomePage orderEntryInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage orderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       orderInstance.selectSoldToCustomerBU("bu_SSC");
		       orderInstance.enterSoldToCustomer("CU00117844");
		       orderInstance.selectBilltoSameAsSoldTo();
		      // orderInstance.selectOrderType("OrderType_Standard");
		       //orderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       Thread.sleep(2000);
		       orderInstance.clickOnLoadPackage();
		       Thread.sleep(3000);
		       
		       orderInstance.validatePackageAvailableForBUFilter("SSC",packageName);
		       orderInstance.selectPackageToLoad(packageName);
		       orderInstance.loadPackageInPackageLoadWindow();
		       Thread.sleep(5000);	       
		     
		       
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	
	@Test(groups = {"Order", "Package","saveUpdateAndLoadPackageBlankEndDate","Grp4","RegressionLatestN","Group6"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void saveUpdateAndLoadPackageBlankEndDate(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectSoldToCustomerBU("bu_SSC");
		       newOrderInstance.enterSoldToCustomer("CU00117844");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		        newOrderInstance.selectOrderType("OrderType_Standard"); newOrderInstance.checkUncheckOwnLocalOptOut(false); Thread.sleep(4000);
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);	
		       newOrderInstance.selectBU("1",39, 0);
		       Thread.sleep(4000);	
		       newOrderInstance.enterPubDate("1","22", "Dec", "2021");
		       Thread.sleep(6000);
		       		     
		       Thread.sleep(4000);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);	
		       newOrderInstance.selectBU("2",39, 0);
		       Thread.sleep(4000);	
		       newOrderInstance.enterPubDate("2","21", "Dec", "2021");
		       Thread.sleep(6000);
		      
		     
		       Thread.sleep(4000);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);	
		       newOrderInstance.selectBU("3",39, 0);
		       Thread.sleep(4000);	
		       newOrderInstance.enterPubDate("3","20", "Dec", "2021");
		       Thread.sleep(6000);
		      
		     
		       Thread.sleep(4000);
		       int count = newOrderInstance.getInsertionsCount();
		       newOrderInstance.clickOnSavePackage();
		       newOrderInstance.selectBUpackage("SSC");
		       String packageName = newOrderInstance.enterPackageName("unique");
		       newOrderInstance.enterPackageEffectiveFromDate(03, 17, 2017);
		      
		       newOrderInstance.enterPackageDescription();
		       Thread.sleep(4000);
		       newOrderInstance.clickOnCreatePackage();
		       Thread.sleep(6000);    
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);	
		       newOrderInstance.selectBU("4",39, 0);
		       Thread.sleep(4000);	
		       newOrderInstance.enterPubDate("4","20", "Dec", "2021");
		       Thread.sleep(6000);
		      
		       Thread.sleep(4000);
		     
		       newOrderInstance.clickOnSavePackage();		       
		       newOrderInstance.clickOnUpdatePackageTab();
		       newOrderInstance.selectPackageToLoad(packageName);
		       newOrderInstance.clickOnUpdatePackageButton();
		       Thread.sleep(7000);       
		      
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);
		       newOrderInstance.addNewSalesRepOnInsertion(4, "SA01380");
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);	   
		       newOrderInstance.applytoAllSalesRepOnInsertion(4);
		       Thread.sleep(2000);
		       Thread.sleep(4000);		       
		       newOrderInstance.submitOrder();
		       //Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       OrderEntryHomePage orderEntryInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage orderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       orderInstance.selectSoldToCustomerBU("bu_SSC");
		       orderInstance.enterSoldToCustomer("CU00117844");
		       orderInstance.selectBilltoSameAsSoldTo();
		      // orderInstance.selectOrderType("OrderType_Standard");
		       //orderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       
		       Thread.sleep(2000);
		       orderInstance.clickOnLoadPackage();
		       Thread.sleep(3000);
		       
		       orderInstance.validatePackageAvailableForBUFilter("SSC",packageName);
		       orderInstance.selectPackageToLoad(packageName);
		       orderInstance.loadPackageInPackageLoadWindow();
		       Thread.sleep(5000);	  
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	/*
	 * Verify filter added in load package
	 *///swagata
	@Test(groups = {"Package","filterAddedInLoadPackage","NewRegression2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void filterAddedInLoadPackage(Map<String, String> userData) throws Exception
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
		       NewOrderPage orderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       orderInstance.selectSoldToCustomerBU("bu_SSC");
		       orderInstance.enterSoldToCustomer("CU00117844");
		       orderInstance.selectBilltoSameAsSoldTo();
		       
		       Thread.sleep(2000);
		       orderInstance.clickOnLoadPackage();
		       orderInstance.validatePackageNameDescriptionFilter("Text", "Description");
		       orderInstance.cancelPackageToLoad();
		       Thread.sleep(2000);
		       orderInstance.clickOnLoadPackage();
		       orderInstance.validatePackageNameDescriptionFilter("Text", "Name");
		       orderInstance.cancelPackageToLoad();
		       Logger.info("Verified that filter is added in load package");
		       dashboardPageInstance.clickOnLogout();
		       //orderEntryPageInstance.WarngMsgYesOptn.click();


		       
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
}
