package com.tribune.adit2.test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;


public class OrderBundleTest 
{
	/**
	 * This test will create a new bundle of display orders
	 */
	@Test(groups = {"TestBundle","displayOrderBundle"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderBundle(Map<String, String> userData) throws Exception
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
			newOrderInstance.enterPubDate("1","21", "Dec", "2021");
			newOrderInstance.selectProductType("1",7, 1);
			newOrderInstance.selectProduct("1",7, 2);
			newOrderInstance.selectAdType("1",7, 3);
			newOrderInstance.selectSection("1",7, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");

			newOrderInstance.selectAdSize(1,TribuneUtils.getStringCellValues("Product", 7, 5));
			Logger.info("FirstInsertion price= "+newOrderInstance.getInsertionPrice("1","total"));
			//double firstInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("1", "total");
			Thread.sleep(2000);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("2",5, 0);
			newOrderInstance.enterPubDate("2","23", "Dec", "2021");
			newOrderInstance.selectProductType("2",5, 1);
			newOrderInstance.selectProduct("2",5, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("2",5, 3);
			newOrderInstance.selectSection("2",5, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("2");
			newOrderInstance.selectAdSize(2,TribuneUtils.getStringCellValues("Product", 5, 5));
			Logger.info("SecondInsertion price "+newOrderInstance.getInsertionPrice("2", "total"));
			//double s,econdInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("2", "total");
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("3",5, 0);
			newOrderInstance.enterPubDate("3","23", "Dec", "2021");
			newOrderInstance.selectProductType("3",5, 1);
			newOrderInstance.selectProduct("3",5, 2);
			Thread.sleep(3000);
			newOrderInstance.selectAdType("3",5, 3);
			newOrderInstance.selectSection("3",5, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("3");
			Thread.sleep(2000);
			newOrderInstance.selectAdSize(3,TribuneUtils.getStringCellValues("Product", 5, 5));
			Logger.info("Third Insertion price "+newOrderInstance.getInsertionPrice("3", "total"));
			double insertionPriceNotPartOfBundle = newOrderInstance.getInsertionPrice("3", "total");
			Thread.sleep(5000);

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
			double totalOrderPrice = newOrderInstance.getTotalOrderPrice();
			newOrderInstance.selectDeSelectInsertion(1, true);
			newOrderInstance.selectDeSelectInsertion(2, true);
			newOrderInstance.clickOnBundleButton();
			newOrderInstance.clickOnCreateBundleButton();
			String bundleName = newOrderInstance.enterBundleName("unique");
			Double bundleDiscount = newOrderInstance.enterBundleDiscountPercent(10);
			boolean flag1 = newOrderInstance.validateBundleDiscountAmount();
			boolean flag2 = newOrderInstance.validateBundlePriceAfterDiscount(2);
			Assert.assertEquals(newOrderInstance.getTotalBundleBasePrice(), newOrderInstance.getInsertionPrice("1", "total")+newOrderInstance.getInsertionPrice("2", "total"), 0);
			Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(1), newOrderInstance.getInsertionPrice("1", "total"), 0);
			Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(2), newOrderInstance.getInsertionPrice("2", "total"), 0);
			Assert.assertEquals(flag1, true);
			Assert.assertEquals(flag2, true);
			Assert.assertEquals(newOrderInstance.getInsertionPrice("3", "total"),insertionPriceNotPartOfBundle, 0);
			Thread.sleep(1000);
			newOrderInstance.clickOnSaveBundle();
			Thread.sleep(2000);
			Assert.assertEquals(newOrderInstance.getBundleNameOnInsertion(1), bundleName);
			Assert.assertEquals(newOrderInstance.getBundleNameOnInsertion(2), bundleName);
			//  Assert.assertEquals(newOrderInstance.validateVisibilityOfBundleName(3), false);
			newOrderInstance.submitOrder();
			Thread.sleep(4000);
			String orderID = orderEntryPageInstance.getOrderID();
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(4000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(4000);
			//Assert.assertEquals(newOrderInstance.getTotalOrderPrice(),totalOrderPrice, 0);
			Logger.info("Total order price after bundle discount:"+(newOrderInstance.getTotalOrderPrice()));

			Logger.info("First Insertion price after bundle discount:"+(newOrderInstance.getInsertionPrice("1", "total")));
			Logger.info("Second Insertion Price after bundle discount:  "+(newOrderInstance.getInsertionPrice("2", "total")));
			Logger.info("Third Insertion price without bundle discount: "+(newOrderInstance.getInsertionPrice("3", "total")));
			dashboardPageInstance.clickOnLogout();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * This test will create a new bundle of preprint orders 
	 */
	/*
	@Test(groups = {"OrderBundle", "preprintOrderBundle","Grp4","RegressionLatest","Group2","RegFail2","Group2F","NewRegression","G2","RerunF2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderBundle(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectBU("1",10, 0);
		       Thread.sleep(3000);
		       newOrderInstance.enterPubDate("1","21", "Dec", "2021");
		       Thread.sleep(3000);
		       newOrderInstance.selectProductType("1",10, 1);
		       Thread.sleep(3000);
		       newOrderInstance.selectProduct("1",10, 2);		       
		       Thread.sleep(3000);
		       newOrderInstance.selectAdType("1",10, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("1",10, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		      // newOrderInstance.selectMaterialSource("1","N/A");
		       newOrderInstance.clickOnDistributions(1);
		       Thread.sleep(44000);
		       newOrderInstance.selectZonePreprintOrder("Full");
		       newOrderInstance.confirmZoneSelection();
		       Logger.info("FirstInsertion price= "+newOrderInstance.getInsertionPrice("1","total"));
		       double firstInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("1", "total");
		       Thread.sleep(2000);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("2",33, 0);
		       Thread.sleep(3000);
		       newOrderInstance.enterPubDate("2","23", "Dec", "2021");
		       Thread.sleep(3000);
		       newOrderInstance.selectProductType("2",33, 1);
		       Thread.sleep(3000);
		       newOrderInstance.selectProduct("2",33, 2);
		       Thread.sleep(3000);
		       newOrderInstance.selectAdType("2",10, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("2",10, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("2");
		       newOrderInstance.addOrEditInsersionVerisonID("2", 1);
		       newOrderInstance.selectMaterialSource("2","N/A");
		       newOrderInstance.clickOnDistributions(2);
		       Thread.sleep(44000);
		       newOrderInstance.selectZonePreprintOrder("Full");
		       newOrderInstance.confirmZoneSelection();
		       Logger.info("SecondInsertion price "+newOrderInstance.getInsertionPrice("2", "total"));
		       double secondInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("2", "total");
		       Thread.sleep(2000);


		       Thread.sleep(4000);	
		       double totalPrice = newOrderInstance.getTotalOrderPrice();
		       newOrderInstance.selectDeSelectInsertion(1, true);
		       newOrderInstance.selectDeSelectInsertion(2, true);
		       newOrderInstance.clickOnBundleButton();
		       newOrderInstance.clickOnCreateBundleButton();
		       String bundleName = newOrderInstance.enterBundleName("unique");
		       Logger.info("bundleName "+bundleName);
		       Double bundleDiscount = newOrderInstance.enterBundleDiscountPercent(10);
		       Logger.info("bundleDiscount "+bundleDiscount);
		       boolean flag1 = newOrderInstance.validateBundleDiscountAmount();
		       boolean flag2 = newOrderInstance.validateBundlePriceAfterDiscount(2);
		       Assert.assertEquals(newOrderInstance.getTotalBundleBasePrice(), totalPrice, 0);
		       Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(1), firstInsertionPricePartOfBundle, 0);
		       Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(2), secondInsertionPricePartOfBundle, 0);
		       Assert.assertEquals(flag1, true);
		       Assert.assertEquals(flag2, true);
		       Thread.sleep(1000);
		       newOrderInstance.clickOnSaveBundle();
		       Thread.sleep(2000);
		       newOrderInstance.saveOrder();
		       String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
		       Logger.info("Saved Order : "+orderNumber);
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	}

	/**
	 * This test will create a new bundle of preprint orders and clear it
	 */
	//arka
	@Test(groups = {"NovMaintenance","arkadeep","Orderbundle","OrderBundle","ScriptResult","preprintOrderBundle","Grp4","RegressionLatest","Group2","RegFail2","Group2F","NewRegression1","NewRegression","G2","RerunF2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderBundle(Map<String, String> userData) throws Exception
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
			newOrderInstance.selectBU("1",33, 0);
			Thread.sleep(3000);
			newOrderInstance.enterPubDate("1","21", "Dec", "2021");
			Thread.sleep(3000);

			newOrderInstance.selectProductType("1",33, 1);
			Thread.sleep(3000);
			//     newOrderInstance.selectProduct("1",33, 2);		       
			Thread.sleep(3000);
			newOrderInstance.selectAdType("1",33, 3);
			Thread.sleep(2000);
			// newOrderInstance.selectSection("1",33, 4);//swagata
			// Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			Thread.sleep(4000);//swagata


			// newOrderInstance.addOrEditInsersionVerisonID("1", 1);//swagata
			// newOrderInstance.selectMaterialSource("1","N/A");

			/*newOrderInstance.clickOnDistributions(1);
		      Thread.sleep(200000);

		       //new WebDriverWait(driver, 300).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Distributions']/../div/span[@class='input-group-addon pointer']/i)[1]")));
		       newOrderInstance.selectZonePreprintOrder("Full");
		       newOrderInstance.confirmZoneSelection();*///swagata
			newOrderInstance.checkUncheckBillQty(false);
			Thread.sleep(3000);	
			newOrderInstance.enterBilledQty(100);
			Thread.sleep(3000);	
			Logger.info("FirstInsertion price= "+newOrderInstance.getInsertionPrice("1","total"));
			double firstInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("1", "total");
			Thread.sleep(2000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			newOrderInstance.createDuplicateInsertion("1");//mou
			Thread.sleep(4000);//mou
			//  newOrderInstance.createNewInsertion();
			//   newOrderInstance.selectBU("2",33, 0);
			//  Thread.sleep(5000);
			newOrderInstance.enterPubDate("2","23", "Dec", "2021");
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("2");//swagata
			//   newOrderInstance.selectProductType("2",33, 1);
			//   Thread.sleep(3000);
			//   newOrderInstance.selectProduct("2",33, 2);
			//   Thread.sleep(3000);
			//newOrderInstance.selectAdType("2",10, 3);
			//    newOrderInstance.selectAdType("2",33, 3);//swagata
			//    Thread.sleep(2000);
			//newOrderInstance.selectSection("2",10, 4);

			//     newOrderInstance.selectSection("2",33, 4);//swagata
			//   Thread.sleep(4000);
			//    newOrderInstance.viewInsertionDetails("2");
			//     Thread.sleep(3000);
			//     newOrderInstance.addOrEditInsersionVerisonID("2", 1);
			Thread.sleep(4000);//swagata
			// newOrderInstance.selectMaterialSource("2","N/A");
			/* newOrderInstance.clickOnDistributions(2);
		       Thread.sleep(200000);
		       newOrderInstance.selectZonePreprintOrder("Full");
		       newOrderInstance.confirmZoneSelection();*///swagata

			//    newOrderInstance.checkUncheckBillQty(false);
			//     Thread.sleep(3000);	
			//     newOrderInstance.enterBilledQty(5);
			//     Thread.sleep(3000);

			Logger.info("SecondInsertion price "+newOrderInstance.getInsertionPrice("2", "total"));
			double secondInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("2", "total");
			Thread.sleep(2000);

			newOrderInstance.collapseInsertionDetails("2");//swagata
			Thread.sleep(4000);	
			double totalPrice = newOrderInstance.getTotalOrderPrice();
			newOrderInstance.selectDeSelectInsertion(1, true);
			newOrderInstance.selectDeSelectInsertion(2, true);
			newOrderInstance.clickOnBundleButton();
			newOrderInstance.clickOnCreateBundleButton();
			String bundleName = newOrderInstance.enterBundleName("unique");
			Logger.info("bundleName "+bundleName);
			Double bundleDiscount = newOrderInstance.enterBundleDiscountPercent(10);
			Logger.info("bundleDiscount "+bundleDiscount);
			boolean flag1 = newOrderInstance.validateBundleDiscountAmount();
			boolean flag2 = newOrderInstance.validateBundlePriceAfterDiscount(2);
			Assert.assertEquals(newOrderInstance.getTotalBundleBasePrice(), totalPrice, 0);
			Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(1), firstInsertionPricePartOfBundle, 0);
			Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(2), secondInsertionPricePartOfBundle, 0);
			Assert.assertEquals(flag1, true);
			Assert.assertEquals(flag2, true);
			Thread.sleep(1000);
			newOrderInstance.clickOnSaveBundle();
			Thread.sleep(2000);//mou
			newOrderInstance.saveOrder();
			Thread.sleep(2000);
			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
			Logger.info("Saved Order : "+orderNumber);
			//dashboardPageInstance.clickOnLogout();//mou
			dashboardPageInstance.clickondropdownforlogout();//joy
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/*@Test(groups = {"OrderBundle", "preprintOrderBundleClear","Grp4","RegressionLatest","Group2","TestPriority","RegFail2","Group2F","NewRegression","G2","RerunF2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderBundleClear(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectBU("1",10, 0);
		       newOrderInstance.enterPubDate("1","21", "Dec", "2021");
		       newOrderInstance.selectProductType("1",10, 1);
		       newOrderInstance.selectProduct("1",10, 2);
		       Thread.sleep(3000);
		       newOrderInstance.selectAdType("1",10, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("1",10, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       newOrderInstance.selectMaterialSource("1","N/A");
		       newOrderInstance.clickOnDistributions(1);
		       Thread.sleep(44000);
		       newOrderInstance.selectZonePreprintOrder("Full");
		       newOrderInstance.confirmZoneSelection();
		       Logger.info("distributionsCount "+newOrderInstance.getDistributionsAdded());
		       Logger.info("FirstInsertion price= "+newOrderInstance.getInsertionPrice("1","total"));
		       double firstInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("1", "total");
		       Thread.sleep(2000);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("2",33, 0);
		       newOrderInstance.enterPubDate("2","23", "Dec", "2021");
		       newOrderInstance.selectProductType("2",33, 1);
		       newOrderInstance.selectProduct("2",33, 2);
		       Thread.sleep(3000);
		       newOrderInstance.selectAdType("2",10, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("2",10, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("2");
		       newOrderInstance.addOrEditInsersionVerisonID("2", 1);
		       newOrderInstance.selectMaterialSource("2","N/A");
		       newOrderInstance.clickOnDistributions(2);
		       Thread.sleep(44000);
		       newOrderInstance.selectZonePreprintOrder("Full");
		       newOrderInstance.confirmZoneSelection();
		       Logger.info("SecondInsertion price "+newOrderInstance.getInsertionPrice("2", "total"));
		       double secondInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("2", "total");
		       Thread.sleep(2000);

		       double totalPrice = newOrderInstance.getTotalOrderPrice();

		       newOrderInstance.saveOrder();
		       Thread.sleep(2000);

		       newOrderInstance.viewInsertionDetails("1");       

		       newOrderInstance.selectDeSelectInsertion(1, true);
		       newOrderInstance.viewInsertionDetails("2");

		       newOrderInstance.selectDeSelectInsertion(2, true);
		       Thread.sleep(3000);
		       newOrderInstance.clickOnBundleButton();
		       newOrderInstance.clickOnCreateBundleButton();
		       String bundleName = newOrderInstance.enterBundleName("unique");
		       Logger.info("bundleName "+bundleName);
		       Double bundleDiscount = newOrderInstance.enterBundleDiscountPercent(10);
		       Logger.info("bundleDiscount "+bundleDiscount);
		       boolean flag1 = newOrderInstance.validateBundleDiscountAmount();
		       boolean flag2 = newOrderInstance.validateBundlePriceAfterDiscount(2);
		       Assert.assertEquals(newOrderInstance.getTotalBundleBasePrice(), totalPrice, 0);
		       Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(1), firstInsertionPricePartOfBundle, 0);
		       Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(2), secondInsertionPricePartOfBundle, 0);
		       Assert.assertEquals(flag1, true);
		       Assert.assertEquals(flag2, true);
		       Thread.sleep(1000);
		       newOrderInstance.clickOnSaveBundle();
		       Thread.sleep(2000);
		       Assert.assertEquals(newOrderInstance.getBundleNameOnInsertion(1), bundleName);
		       Assert.assertEquals(newOrderInstance.getBundleNameOnInsertion(2), bundleName);
		       Thread.sleep(1000);
		       newOrderInstance.saveOrder();
		       String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
		       Logger.info("Saved Order : "+orderNumber);
		       Thread.sleep(3000);
		       newOrderInstance.clickOnBundleButton();
		       newOrderInstance.clickOnClearBundleButton();
		       newOrderInstance.clickOnBundleClearOkButton();
		       Thread.sleep(1000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.viewInsertionDetails("2");
		       Assert.assertEquals(newOrderInstance.validateVisibilityOfBundleName(1), false);
		       Assert.assertEquals(newOrderInstance.validateVisibilityOfBundleName(2), false);
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	}*/
	@Test(groups = {"arkadeep","OrderBundle","ScriptResult","preprintOrderBundleClear","PrioritizedReg1","Grp4","RegressionLatest","Group2","TestPriority","RegFail2","Group2F","NewRegression1","NewRegression","G2","RerunF2", "bundleOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderBundleClear(Map<String, String> userData) throws Exception
	{
		try
		{
			/* WebDriver driver = WebDriverManager.getDriver();
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
			       newOrderInstance.selectBU("1",10, 0);
			       Thread.sleep(4000);//swagata
			       newOrderInstance.enterPubDate("1","21", "Dec", "2021");

			       newOrderInstance.selectProductType("1",10, 1);
			       /*newOrderInstance.selectProduct("1",10, 2);
			       Thread.sleep(3000);
			       newOrderInstance.selectAdType("1",10, 3);
			       Thread.sleep(4000);//swagata
			       newOrderInstance.selectSection("1",10, 4);
			       Thread.sleep(9000);///swagata
			      // newOrderInstance.viewInsertionDetails("1");//swagata
			       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			      // newOrderInstance.selectMaterialSource("1","N/A");
			      / newOrderInstance.clickOnDistributions(1);
			       Thread.sleep(44000);
			       newOrderInstance.selectZonePreprintOrder("Full");
			       newOrderInstance.confirmZoneSelection();///swagata
			       newOrderInstance.checkUncheckBillQty(false);
			       Thread.sleep(3000);	
			       newOrderInstance.enterBilledQty(5);
			       Thread.sleep(3000);	
			       Logger.info("distributionsCount "+newOrderInstance.getDistributionsAdded());
			       Logger.info("FirstInsertion price= "+newOrderInstance.getInsertionPrice("1","total"));
			       double firstInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("1", "total");
			       Thread.sleep(2000);
			       newOrderInstance.createNewInsertion();
			       newOrderInstance.selectBU("2",33, 0);
			       Thread.sleep(6000);	//swagata
			       newOrderInstance.enterPubDate("2","26", "Dec", "2021");
			       newOrderInstance.selectProductType("2",33, 1);
			       Thread.sleep(3000);	//swagata
			       /*newOrderInstance.selectProduct("2",33, 2);
			       Thread.sleep(3000);
			       //newOrderInstance.selectAdType("2",10, 3);
			       newOrderInstance.selectAdType("2",33, 3);//swagata
			       Thread.sleep(6000);//swagata
			       newOrderInstance.selectSection("2",33, 4);//swagata
			      // newOrderInstance.selectSection("2",10, 4);
			       Thread.sleep(4000);*///swagata

			// newOrderInstance.viewInsertionDetails("2");//swagata
			//newOrderInstance.addOrEditInsersionVerisonID("2", 1);
			/*newOrderInstance.selectMaterialSource("2","N/A");
			       newOrderInstance.clickOnDistributions(2);
			       Thread.sleep(44000);
			       newOrderInstance.selectZonePreprintOrder("Full");
			       newOrderInstance.confirmZoneSelection();///swagata
			       newOrderInstance.checkUncheckBillQty(false);
			       Thread.sleep(3000);	
			       newOrderInstance.enterBilledQty(5);
			       Thread.sleep(3000);	
			       Logger.info("SecondInsertion price "+newOrderInstance.getInsertionPrice("2", "total"));
			       double secondInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("2", "total");
			       Thread.sleep(2000);

			       double totalPrice = newOrderInstance.getTotalOrderPrice();

			       newOrderInstance.saveOrder();
			       Thread.sleep(2000);

			       //newOrderInstance.viewInsertionDetails("1"); //swagata      

			       newOrderInstance.selectDeSelectInsertion(1, true);
			      // newOrderInstance.viewInsertionDetails("2");//swagata

			       newOrderInstance.selectDeSelectInsertion(2, true);
			       Thread.sleep(3000);
			       newOrderInstance.clickOnBundleButton();
			       newOrderInstance.clickOnCreateBundleButton();
			       String bundleName = newOrderInstance.enterBundleName("unique");
			       Logger.info("bundleName "+bundleName);
			       Double bundleDiscount = newOrderInstance.enterBundleDiscountPercent(10);
			       Logger.info("bundleDiscount "+bundleDiscount);
			       boolean flag1 = newOrderInstance.validateBundleDiscountAmount();
			       boolean flag2 = newOrderInstance.validateBundlePriceAfterDiscount(2);
			       Assert.assertEquals(newOrderInstance.getTotalBundleBasePrice(), totalPrice, 0);
			       Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(1), firstInsertionPricePartOfBundle, 0);
			       Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(2), secondInsertionPricePartOfBundle, 0);
			       Assert.assertEquals(flag1, true);
			       Assert.assertEquals(flag2, true);
			       Thread.sleep(1000);
			       newOrderInstance.clickOnSaveBundle();
			       Thread.sleep(2000);
			       Assert.assertEquals(newOrderInstance.getBundleNameOnInsertion(1), bundleName);
			       Assert.assertEquals(newOrderInstance.getBundleNameOnInsertion(2), bundleName);
			       Thread.sleep(1000);
			       newOrderInstance.saveOrder();
			       String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
			       Logger.info("Saved Order : "+orderNumber)*/
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
			newOrderInstance.selectBU("1",33, 0);
			Thread.sleep(3000);
			newOrderInstance.enterPubDate("1","21", "Dec", "2021");
			Thread.sleep(3000);

			newOrderInstance.selectProductType("1",33, 1);
			Thread.sleep(3000);
			newOrderInstance.selectProduct("1",33, 2);		       
			Thread.sleep(3000);
			newOrderInstance.selectAdType("1",33, 3);
			Thread.sleep(2000);
			// newOrderInstance.selectSection("1",33, 4);//swagata
			// Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			Thread.sleep(4000);


			// newOrderInstance.addOrEditInsersionVerisonID("1", 1);//swagata
			// newOrderInstance.selectMaterialSource("1","N/A");

			/*newOrderInstance.clickOnDistributions(1);
			      Thread.sleep(200000);

			       //new WebDriverWait(driver, 300).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Distributions']/../div/span[@class='input-group-addon pointer']/i)[1]")));
			       newOrderInstance.selectZonePreprintOrder("Full");
			       newOrderInstance.confirmZoneSelection();*///swagata
			newOrderInstance.checkUncheckBillQty(false);
			Thread.sleep(3000);	
			newOrderInstance.enterBilledQty(1000);
			Thread.sleep(3000);	
			Logger.info("FirstInsertion price= "+newOrderInstance.getInsertionPrice("1","total"));
			double firstInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("1", "total");
			Thread.sleep(2000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			//  newOrderInstance.createNewInsertion();
			//   newOrderInstance.selectBU("2",33, 0);
			//  Thread.sleep(5000);
			newOrderInstance.enterPubDate("2","23", "Dec", "2021");
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("2");
			//   newOrderInstance.selectProductType("2",33, 1);
			//   Thread.sleep(3000);
			//   newOrderInstance.selectProduct("2",33, 2);
			//   Thread.sleep(3000);
			//newOrderInstance.selectAdType("2",10, 3);
			//    newOrderInstance.selectAdType("2",33, 3);//swagata
			//    Thread.sleep(2000);
			//newOrderInstance.selectSection("2",10, 4);

			//     newOrderInstance.selectSection("2",33, 4);//swagata
			//   Thread.sleep(4000);
			//    newOrderInstance.viewInsertionDetails("2");
			//     Thread.sleep(3000);
			//     newOrderInstance.addOrEditInsersionVerisonID("2", 1);
			// newOrderInstance.selectMaterialSource("2","N/A");
			/* newOrderInstance.clickOnDistributions(2);
			       Thread.sleep(200000);
			       newOrderInstance.selectZonePreprintOrder("Full");
			       newOrderInstance.confirmZoneSelection();*///swagata

			//    newOrderInstance.checkUncheckBillQty(false);
			//     Thread.sleep(3000);	
			//     newOrderInstance.enterBilledQty(5);
			//     Thread.sleep(3000);

			Logger.info("SecondInsertion price "+newOrderInstance.getInsertionPrice("2", "total"));
			double secondInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("2", "total");
			Thread.sleep(2000);

			newOrderInstance.collapseInsertionDetails("2");//swagata
			Thread.sleep(4000);	
			double totalPrice = newOrderInstance.getTotalOrderPrice();
			newOrderInstance.selectDeSelectInsertion(1, true);
			newOrderInstance.selectDeSelectInsertion(2, true);
			newOrderInstance.clickOnBundleButton();
			newOrderInstance.clickOnCreateBundleButton();
			String bundleName = newOrderInstance.enterBundleName("unique");
			Logger.info("bundleName "+bundleName);
			Double bundleDiscount = newOrderInstance.enterBundleDiscountPercent(10);
			Logger.info("bundleDiscount "+bundleDiscount);
			boolean flag1 = newOrderInstance.validateBundleDiscountAmount();
			boolean flag2 = newOrderInstance.validateBundlePriceAfterDiscount(2);
			Assert.assertEquals(newOrderInstance.getTotalBundleBasePrice(), totalPrice, 0);
			Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(1), firstInsertionPricePartOfBundle, 0);
			Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(2), secondInsertionPricePartOfBundle, 0);
			Assert.assertEquals(flag1, true);
			Assert.assertEquals(flag2, true);
			Thread.sleep(1000);
			newOrderInstance.clickOnSaveBundle();
			Thread.sleep(2000);
			newOrderInstance.saveOrder();
			Thread.sleep(2000);//swagata
			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
			Thread.sleep(2000);//swagata
			Logger.info("Saved Order : "+orderNumber);
			Thread.sleep(3000);
			newOrderInstance.clickOnBundleButton();
			newOrderInstance.clickOnClearBundleButton();
			newOrderInstance.clickOnBundleClearOkButton();
			Thread.sleep(1000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.viewInsertionDetails("2");
			Assert.assertEquals(newOrderInstance.validateVisibilityOfBundleName(1), false);
			Assert.assertEquals(newOrderInstance.validateVisibilityOfBundleName(2), false);
			dashboardPageInstance.clickondropdownforlogout(); //joy
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	@Test(groups = {"TestBundle"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewbundleOnExistingOrderwithBundle(Map<String, String> userData) throws Exception
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
			newOrderInstance.enterPubDate("1","21", "Dec", "2021");
			newOrderInstance.selectProductType("1",7, 1);
			newOrderInstance.selectProduct("1",7, 2);
			newOrderInstance.selectAdType("1",7, 3);
			newOrderInstance.selectSection("1",7, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");

			newOrderInstance.selectAdSize(1,TribuneUtils.getStringCellValues("Product", 7, 5));
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
			Logger.info("FirstInsertion price= "+newOrderInstance.getInsertionPrice("1","total"));
			double firstInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("1", "total");
			Thread.sleep(2000);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("2",5, 0);
			newOrderInstance.enterPubDate("2","23", "Dec", "2021");
			newOrderInstance.selectProductType("2",5, 1);
			newOrderInstance.selectProduct("2",5, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("2",5, 3);
			newOrderInstance.selectSection("2",5, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("2");
			newOrderInstance.selectAdSize(2,TribuneUtils.getStringCellValues("Product", 5, 5));
			newOrderInstance.clickOnInsertionSalesRepSection(2);
			newOrderInstance.addNewSalesRepOnInsertion(2, "SA00443");
			Logger.info("SecondInsertion price "+newOrderInstance.getInsertionPrice("2", "total"));
			double secondInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("2", "total");
			Thread.sleep(2000);
			double totalOrderPrice = newOrderInstance.getTotalOrderPrice();
			newOrderInstance.selectDeSelectInsertion(1, true);
			newOrderInstance.selectDeSelectInsertion(2, true);
			newOrderInstance.clickOnBundleButton();
			newOrderInstance.clickOnCreateBundleButton();
			String bundleName = newOrderInstance.enterBundleName("unique");
			Double bundleDiscount = newOrderInstance.enterBundleDiscountPercent(10);
			boolean flag1 = newOrderInstance.validateBundleDiscountAmount();
			boolean flag2 = newOrderInstance.validateBundlePriceAfterDiscount(2);
			Assert.assertEquals(newOrderInstance.getTotalBundleBasePrice(), newOrderInstance.getInsertionPrice("1", "total")+newOrderInstance.getInsertionPrice("2", "total"), 0);
			Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(1), newOrderInstance.getInsertionPrice("1", "total"), 0);
			Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(2), newOrderInstance.getInsertionPrice("2", "total"), 0);
			Assert.assertEquals(flag1, true);
			Assert.assertEquals(flag2, true);
			Thread.sleep(1000);
			newOrderInstance.clickOnSaveBundle();
			Thread.sleep(2000);
			Assert.assertEquals(newOrderInstance.getBundleNameOnInsertion(1), bundleName);
			Assert.assertEquals(newOrderInstance.getBundleNameOnInsertion(2), bundleName);
			newOrderInstance.submitOrder();
			Thread.sleep(2000);
			String orderID = orderEntryPageInstance.getOrderID();
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			Assert.assertEquals(newOrderInstance.checkVisibilityOfCreateBundleButton(), false);
			Assert.assertEquals(newOrderInstance.checkVisibilityOfClearBundleButton(), true);
			Thread.sleep(3000);
			dashboardPageInstance.clickOnLogout();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"TestBundle","clearBundleWithDispalyOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void clearBundleWithDispalyOrders(Map<String, String> userData) throws Exception
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
			Thread.sleep(4000);
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1",6, 0);
			newOrderInstance.enterPubDate("1","21", "Dec", "2021");
			newOrderInstance.selectProductType("1",7, 1);
			newOrderInstance.selectProduct("1",7, 2);
			newOrderInstance.selectAdType("1",7, 3);
			newOrderInstance.selectSection("1",7, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");

			newOrderInstance.selectAdSize(1,TribuneUtils.getStringCellValues("Product", 7, 5));
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
			Logger.info("FirstInsertion price= "+newOrderInstance.getInsertionPrice("1","total"));
			double firstInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("1", "total");
			Thread.sleep(2000);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("2",5, 0);
			newOrderInstance.enterPubDate("2","23", "Dec", "2021");
			newOrderInstance.selectProductType("2",5, 1);
			newOrderInstance.selectProduct("2",5, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("2",5, 3);
			newOrderInstance.selectSection("2",5, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("2");
			newOrderInstance.selectAdSize(2,TribuneUtils.getStringCellValues("Product", 5, 5));
			newOrderInstance.clickOnInsertionSalesRepSection(2);
			newOrderInstance.addNewSalesRepOnInsertion(2, "SA00443");
			Logger.info("SecondInsertion price "+newOrderInstance.getInsertionPrice("2", "total"));
			double secondInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("2", "total");
			Thread.sleep(2000);
			double totalOrderPrice = newOrderInstance.getTotalOrderPrice();
			newOrderInstance.selectDeSelectInsertion(1, true);
			newOrderInstance.selectDeSelectInsertion(2, true);
			newOrderInstance.clickOnBundleButton();
			newOrderInstance.clickOnCreateBundleButton();
			String bundleName = newOrderInstance.enterBundleName("unique");
			Double bundleDiscount = newOrderInstance.enterBundleDiscountPercent(10);
			boolean flag1 = newOrderInstance.validateBundleDiscountAmount();
			boolean flag2 = newOrderInstance.validateBundlePriceAfterDiscount(2);
			Assert.assertEquals(newOrderInstance.getTotalBundleBasePrice(), newOrderInstance.getInsertionPrice("1", "total")+newOrderInstance.getInsertionPrice("2", "total"), 0);
			Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(1), newOrderInstance.getInsertionPrice("1", "total"), 0);
			Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(2), newOrderInstance.getInsertionPrice("2", "total"), 0);
			Assert.assertEquals(flag1, true);
			Assert.assertEquals(flag2, true);
			Thread.sleep(1000);
			newOrderInstance.clickOnSaveBundle();
			Thread.sleep(2000);
			Assert.assertEquals(newOrderInstance.getBundleNameOnInsertion(1), bundleName);
			Assert.assertEquals(newOrderInstance.getBundleNameOnInsertion(2), bundleName);
			newOrderInstance.submitOrder();
			Thread.sleep(2000);
			String orderID = orderEntryPageInstance.getOrderID();
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(6000);
			newOrderInstance.clickOnBundleButton();
			Thread.sleep(3000);
			newOrderInstance.clickOnClearBundleButton();
			Thread.sleep(3000);
			newOrderInstance.clickOnBundleClearOkButton();
			Thread.sleep(3000);
			Assert.assertEquals(newOrderInstance.getInsertionPrice("1", "total"),firstInsertionPricePartOfBundle,  0);
			Assert.assertEquals(newOrderInstance.getInsertionPrice("2", "total"),secondInsertionPricePartOfBundle,  0);
			Assert.assertEquals(newOrderInstance.getTotalOrderPrice(), totalOrderPrice,  0);
			//Assert.assertEquals(newOrderInstance.validateVisibilityOfBundleName(1), false);
			// Assert.assertEquals(newOrderInstance.validateVisibilityOfBundleName(2), false);

			dashboardPageInstance.clickOnLogout();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"TestBundle"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void clearBundleWithPreprintOrders(Map<String, String> userData) throws Exception
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
			newOrderInstance.selectBU("1",10, 0);
			newOrderInstance.enterPubDate("1","22", "Jun", "2021");
			newOrderInstance.selectProductType("1",10, 1);
			newOrderInstance.selectProduct("1",10, 2);
			Thread.sleep(3000);
			newOrderInstance.selectAdType("1",10, 3);
			Thread.sleep(2000);
			newOrderInstance.selectSection("1",10, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(4000);
			newOrderInstance.clickOnSearchZoneLink();
			Thread.sleep(3000);
			newOrderInstance.selectZonePreprintOrder("90001SC");
			newOrderInstance.confirmZoneSelection();	
			Logger.info("distributionsCount "+newOrderInstance.getDistributionsAdded());
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
			Logger.info("FirstInsertion price= "+newOrderInstance.getInsertionPrice("1","total"));
			double firstInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("1", "total");
			Thread.sleep(2000);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1",10, 0);
			newOrderInstance.enterPubDate("1","30", "Jun", "2021");
			newOrderInstance.selectProductType("1",10, 1);
			newOrderInstance.selectProduct("1",10, 2);
			Thread.sleep(3000);
			newOrderInstance.selectAdType("1",10, 3);
			Thread.sleep(2000);
			newOrderInstance.selectSection("1",10, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(4000);
			newOrderInstance.clickOnSearchZoneLink();
			Thread.sleep(3000);
			newOrderInstance.selectZonePreprintOrder("90001SC");
			newOrderInstance.confirmZoneSelection();	
			Logger.info("distributionsCount "+newOrderInstance.getDistributionsAdded());
			newOrderInstance.clickOnInsertionSalesRepSection(2);
			newOrderInstance.addNewSalesRepOnInsertion(2, "SA00443");
			Logger.info("SecondInsertion price "+newOrderInstance.getInsertionPrice("2", "total"));
			double secondInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("2", "total");
			Thread.sleep(2000);
			double totalOrderPrice = newOrderInstance.getTotalOrderPrice();
			newOrderInstance.selectDeSelectInsertion(1, true);
			newOrderInstance.selectDeSelectInsertion(2, true);
			newOrderInstance.clickOnBundleButton();
			newOrderInstance.clickOnCreateBundleButton();
			String bundleName = newOrderInstance.enterBundleName("unique");
			Double bundleDiscount = newOrderInstance.enterBundleDiscountPercent(10);
			boolean flag1 = newOrderInstance.validateBundleDiscountAmount();
			boolean flag2 = newOrderInstance.validateBundlePriceAfterDiscount(2);
			Assert.assertEquals(newOrderInstance.getTotalBundleBasePrice(), newOrderInstance.getInsertionPrice("1", "total")+newOrderInstance.getInsertionPrice("2", "total"), 0);
			Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(1), newOrderInstance.getInsertionPrice("1", "total"), 0);
			Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(2), newOrderInstance.getInsertionPrice("2", "total"), 0);
			Assert.assertEquals(flag1, true);
			Assert.assertEquals(flag2, true);
			Thread.sleep(1000);
			newOrderInstance.clickOnSaveBundle();
			Thread.sleep(2000);
			Assert.assertEquals(newOrderInstance.getBundleNameOnInsertion(1), bundleName);
			Assert.assertEquals(newOrderInstance.getBundleNameOnInsertion(2), bundleName);
			newOrderInstance.submitOrder();
			Thread.sleep(2000);
			String orderID = orderEntryPageInstance.getOrderID();
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.clickOnBundleButton();
			newOrderInstance.clickOnClearBundleButton();
			Thread.sleep(2000);
			Assert.assertEquals(newOrderInstance.getInsertionPrice("1", "total"),firstInsertionPricePartOfBundle,  0);
			Assert.assertEquals(newOrderInstance.getInsertionPrice("2", "total"),secondInsertionPricePartOfBundle,  0);
			Assert.assertEquals(newOrderInstance.getTotalOrderPrice(), totalOrderPrice,  0);
			Assert.assertEquals(newOrderInstance.validateVisibilityOfBundleName(1), false);
			Assert.assertEquals(newOrderInstance.validateVisibilityOfBundleName(2), false);

			dashboardPageInstance.clickOnLogout();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//updated to duplicate by Sunny
	@Test(groups = {"OrderBundle","displayOrderBundleWithFourInsertions","PrioritizedReg1","RegressionLatest","Grp1","bundleReg","Group2","TestPriority","RegFail2","Group2F","NewRegression1","NewRegression","G2", "bundleOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderBundleWithFourInsertions(Map<String, String> userData) throws Exception
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
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1","21", "Dec", "2021");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1",7, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",7, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",7, 3);
			Thread.sleep(4000);
			//newOrderInstance.selectSection("1",7, 4);
			Thread.sleep(4000);
			//  newOrderInstance.viewInsertionDetails("1");

			//  newOrderInstance.selectAdSize(1,TribuneUtils.getStringCellValues("Product", 7, 5));

			Logger.info("FirstInsertion price= "+newOrderInstance.getInsertionPrice("1","total"));
			//double firstInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("1", "total");
			Thread.sleep(2000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);	
			//  newOrderInstance.createNewInsertion();
			//   newOrderInstance.selectBU("2",6, 0);
			//  Thread.sleep(4000);
			newOrderInstance.enterPubDate("2","20", "Dec", "2021");
			Thread.sleep(4000);
			//  newOrderInstance.selectProductType("2",7, 1);
			//  Thread.sleep(4000);
			//  newOrderInstance.selectProduct("2",7, 2);
			//  Thread.sleep(2000);
			//  newOrderInstance.selectAdType("2",7, 3);
			//  Thread.sleep(4000);
			//  newOrderInstance.selectSection("2",7, 4);
			// Thread.sleep(4000);
			//  newOrderInstance.viewInsertionDetails("2");
			//  newOrderInstance.selectAdSize(2,TribuneUtils.getStringCellValues("Product", 5, 5));

			Logger.info("SecondInsertion price "+newOrderInstance.getInsertionPrice("2", "total"));
			//double s,econdInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("2", "total");
			Thread.sleep(4000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);	
			// newOrderInstance.createNewInsertion();
			// newOrderInstance.selectBU("3",6, 0);
			//  Thread.sleep(4000);
			newOrderInstance.enterPubDate("3","19", "Dec", "2021");
			Thread.sleep(4000);
			//    newOrderInstance.selectProductType("3",7, 1);
			//   Thread.sleep(4000);
			//   newOrderInstance.selectProduct("3",7, 2);
			// Thread.sleep(3000);
			//newOrderInstance.selectAdType("3",7, 3);
			//Thread.sleep(4000);
			// newOrderInstance.selectSection("3",7, 4);
			//Thread.sleep(4000);
			// newOrderInstance.viewInsertionDetails("3");
			//    Thread.sleep(2000);
			//  newOrderInstance.selectAdSize(3,TribuneUtils.getStringCellValues("Product", 5, 5));

			Logger.info("Third Insertion price "+newOrderInstance.getInsertionPrice("3", "total"));
			// double insertionPriceNotPartOfBundle = newOrderInstance.getInsertionPrice("3", "total");
			Thread.sleep(5000);
			// double totalOrderPrice = newOrderInstance.getTotalOrderPrice();
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);	
			//   newOrderInstance.createNewInsertion();
			//     newOrderInstance.selectBU("4",6, 0);
			//    Thread.sleep(4000);
			newOrderInstance.enterPubDate("4","22", "Dec", "2021");
			Thread.sleep(4000);
			//    newOrderInstance.selectProductType("4",7, 1);
			//    Thread.sleep(4000);
			//    newOrderInstance.selectProduct("4",7, 2);
			//    Thread.sleep(3000);
			//    newOrderInstance.selectAdType("4",7, 3);
			//    Thread.sleep(4000);
			//     newOrderInstance.selectSection("4",7, 4);
			//     Thread.sleep(4000);
			//newOrderInstance.viewInsertionDetails("4");
			//     Thread.sleep(2000);
			// newOrderInstance.selectAdSize(3,TribuneUtils.getStringCellValues("Product", 5, 5));

			Logger.info("Fourth Insertion price "+newOrderInstance.getInsertionPrice("4", "total"));
			newOrderInstance.selectDeSelectInsertion(1, true);
			newOrderInstance.selectDeSelectInsertion(2, true);
			newOrderInstance.selectDeSelectInsertion(3, true);
			newOrderInstance.selectDeSelectInsertion(4, true);
			newOrderInstance.clickOnBundleButton();
			newOrderInstance.clickOnCreateBundleButton();
			String bundleName = newOrderInstance.enterBundleName("unique");

			Thread.sleep(1000);
			newOrderInstance.clickOnSaveBundle();
			Thread.sleep(2000);
			Assert.assertEquals(newOrderInstance.getBundleNameOnInsertion(1), bundleName);
			Thread.sleep(4000);
			newOrderInstance.saveOrder();
			
			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
			Logger.info("Saved Order : "+orderNumber);
			
			//dashboardPageInstance.clickOnLogout();
			dashboardPageInstance.clickondropdownforlogout();//joy
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/*@Test(groups = {"OrderBundle", "preprintOrderBundleDollarDiscount","RegressionLatest","Grp4","bundleReg","Group2","TestPriority","RegFail2","Group2F","NewRegression","G2","RerunF2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderBundleDollarDiscount(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectBU("1",10, 0);
		       newOrderInstance.enterPubDate("1","21", "Nov", "2021");
		       newOrderInstance.selectProductType("1",10, 1);
		       newOrderInstance.selectProduct("1",10, 2);
		       Thread.sleep(3000);
		       newOrderInstance.selectAdType("1",10, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("1",10, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       newOrderInstance.selectMaterialSource("1","N/A");
		       newOrderInstance.clickOnDistributions(1);
		       Thread.sleep(44000);
		       newOrderInstance.selectZonePreprintOrder("Full");
		       newOrderInstance.confirmZoneSelection();
		       Logger.info("FirstInsertion price= "+newOrderInstance.getInsertionPrice("1","total"));
		       double firstInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("1", "total");
		       Thread.sleep(2000);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("2",33, 0);
		       newOrderInstance.enterPubDate("2","23", "Nov", "2021");
		       newOrderInstance.selectProductType("2",33, 1);
		       newOrderInstance.selectProduct("2",33, 2);
		       Thread.sleep(3000);
		       newOrderInstance.selectAdType("2",10, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("2",10, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("2");
		       newOrderInstance.addOrEditInsersionVerisonID("2", 1);
		       newOrderInstance.selectMaterialSource("2","N/A");
		       newOrderInstance.clickOnDistributions(2);
		       Thread.sleep(44000);
		       newOrderInstance.selectZonePreprintOrder("Full");
		       newOrderInstance.confirmZoneSelection();
		       Logger.info("SecondInsertion price "+newOrderInstance.getInsertionPrice("2", "total"));
		       double secondInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("2", "total");
		       Thread.sleep(2000);
		       double totalPrice = newOrderInstance.getTotalOrderPrice();
		       newOrderInstance.saveOrder();
		       Thread.sleep(2000);

		       newOrderInstance.viewInsertionDetails("1");       

		       newOrderInstance.selectDeSelectInsertion(1, true);
		       newOrderInstance.viewInsertionDetails("2");
		       newOrderInstance.selectDeSelectInsertion(2, true);
		       newOrderInstance.clickOnBundleButton();
		       newOrderInstance.clickOnCreateBundleButton();
		       String bundleName = newOrderInstance.enterBundleName("unique");
		       Logger.info("bundleName "+bundleName);
		       Double bundleDiscount = newOrderInstance.enterBundleDiscountAmount(0.02);
		       Logger.info("bundleDiscount "+bundleDiscount);
		       boolean flag1 = newOrderInstance.validateBundleDiscountAmount();
		       boolean flag2 = newOrderInstance.validateBundlePriceAfterDiscount(2);
		       Assert.assertEquals(newOrderInstance.getTotalBundleBasePrice(), totalPrice, 0);
		       Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(1), firstInsertionPricePartOfBundle, 0);
		       Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(2), secondInsertionPricePartOfBundle, 0);
		       Assert.assertEquals(flag1, true);
		       Assert.assertEquals(flag2, true);
		       Thread.sleep(1000);
		       newOrderInstance.clickOnSaveBundle();
		       Thread.sleep(2000);

		       newOrderInstance.saveOrder();
		       String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
		       Logger.info("Saved Order : "+orderNumber);
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	}

}*/
	@Test(groups = {"NovMaintenance","arkadeep","OrderBundle","ScriptResult","preprintOrderBundleDollarDiscount","PrioritizedReg1","RegressionLatest","Grp4","bundleReg","Group2","TestPriority","RegFail2","Group2F","NewRegression1","NewRegression","G2","RerunF2", "bundleOrders", "bundleOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderBundleDollarDiscount(Map<String, String> userData) throws Exception
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
			newOrderInstance.selectBU("1",33, 0);
			Thread.sleep(3000);
			newOrderInstance.enterPubDate("1","21", "Dec", "2021");
			Thread.sleep(3000);

			newOrderInstance.selectProductType("1",33, 1);
			Thread.sleep(3000);
			newOrderInstance.selectProduct("1",33, 2);		       
			Thread.sleep(3000);
			newOrderInstance.selectAdType("1",33, 3);
			Thread.sleep(2000);
			// newOrderInstance.selectSection("1",33, 4);//swagata
			// Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			Thread.sleep(4000);//swagata


			// newOrderInstance.addOrEditInsersionVerisonID("1", 1);//swagata
			// newOrderInstance.selectMaterialSource("1","N/A");

			/*newOrderInstance.clickOnDistributions(1);
		      Thread.sleep(200000);

		       //new WebDriverWait(driver, 300).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Distributions']/../div/span[@class='input-group-addon pointer']/i)[1]")));
		       newOrderInstance.selectZonePreprintOrder("Full");
		       newOrderInstance.confirmZoneSelection();*///swagata
			newOrderInstance.checkUncheckBillQty(false);
			Thread.sleep(3000);	
			newOrderInstance.enterBilledQty(1000);
			Thread.sleep(3000);	
			Logger.info("FirstInsertion price= "+newOrderInstance.getInsertionPrice("1","total"));
			double firstInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("1", "total");
			Thread.sleep(2000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			//  newOrderInstance.createNewInsertion();
			//   newOrderInstance.selectBU("2",33, 0);
			//  Thread.sleep(5000);
			newOrderInstance.enterPubDate("2","23", "Dec", "2021");
			Thread.sleep(3000);
			//  newOrderInstance.createNewInsertion();
			//   newOrderInstance.selectBU("2",33, 0);
			//   Thread.sleep(6000);//swagata
			//   newOrderInstance.enterPubDate("2","23", "Nov", "2021");
			//   newOrderInstance.selectProductType("2",33, 1);
			//   Thread.sleep(6000);//swagata
			/*newOrderInstance.selectProduct("2",33, 2);
		       Thread.sleep(3000);
		       newOrderInstance.selectAdType("2",33, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("2",33, 4);
		       Thread.sleep(4000);*///swagata
			//newOrderInstance.viewInsertionDetails("2");//swagata
			//    newOrderInstance.addOrEditInsersionVerisonID("2", 1);
			//    Thread.sleep(4000);//swagata
			//newOrderInstance.viewInsertionDetails("2");
			/* newOrderInstance.selectMaterialSource("2","N/A");
		       newOrderInstance.clickOnDistributions(2);
		       Thread.sleep(44000);
		       newOrderInstance.selectZonePreprintOrder("Full");
		       newOrderInstance.confirmZoneSelection();*/
			//    newOrderInstance.checkUncheckBillQty(false);
			//     Thread.sleep(3000);	
			//     newOrderInstance.enterBilledQty(5);
			//    Thread.sleep(3000);
			Logger.info("SecondInsertion price "+newOrderInstance.getInsertionPrice("2", "total"));
			double secondInsertionPricePartOfBundle = newOrderInstance.getInsertionPrice("2", "total");
			Thread.sleep(2000);
			double totalPrice = newOrderInstance.getTotalOrderPrice();
			newOrderInstance.saveOrder();


			/* newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(8000);*///swagata

			newOrderInstance.selectDeSelectInsertion(1, true);
			Thread.sleep(8000);//swagata
			/*newOrderInstance.viewInsertionDetails("2");
		       Thread.sleep(8000);*///swagata
			newOrderInstance.selectDeSelectInsertion(2, true);
			Thread.sleep(8000);
			newOrderInstance.clickOnBundleButton();

			newOrderInstance.clickOnCreateBundleButton();
			String bundleName = newOrderInstance.enterBundleName("unique");
			Logger.info("bundleName "+bundleName);
			Double bundleDiscount = newOrderInstance.enterBundleDiscountAmount(10);
			Logger.info("bundleDiscount "+bundleDiscount);
			boolean flag1 = newOrderInstance.validateBundleDiscountAmount();
			boolean flag2 = newOrderInstance.validateBundlePriceAfterDiscount(2);
			Assert.assertEquals(newOrderInstance.getTotalBundleBasePrice(), totalPrice, 0);
			Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(1), firstInsertionPricePartOfBundle, 0);
			Assert.assertEquals(newOrderInstance.getBundleInsertionBasePrice(2), secondInsertionPricePartOfBundle, 0);
			Assert.assertEquals(flag1, true);
			Assert.assertEquals(flag2, true);
			Thread.sleep(1000);
			newOrderInstance.clickOnSaveBundle();
			Thread.sleep(2000);

			newOrderInstance.saveOrder();
			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
			Logger.info("Saved Order : "+orderNumber);
			Thread.sleep(2000);
			dashboardPageInstance.clickondropdownforlogout(); //joy
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/*
	 * Validate that legacy insertion is calculating based on bundle price for a bundled order
	 * 
	 *///swagata
	@Test(groups = {"OrderBundle","NewRegression1","bundleOrders","bundleOrderLegacyInsertion"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void bundleOrderLegacyInsertion(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.loginWithProperty("success");

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
			Thread.sleep(4000); 
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
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
			Thread.sleep(4000);
			double firstInsSalesPrice = newOrderInstance.getInsertionPrice("1", "sales"); 
			newOrderInstance.collapseInsertionDetails("1");  
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("2");
			Thread.sleep(4000);
			double secondInsSalesPrice = newOrderInstance.getInsertionPrice("2", "sales"); 
			newOrderInstance.collapseInsertionDetails("2"); 
			double totalOrderPriceBeforeBundle = newOrderInstance.getTotalOrderPrice();
            newOrderInstance.selectDeSelectInsertion(1, true);
			newOrderInstance.selectDeSelectInsertion(2, true);
			newOrderInstance.clickOnBundleButton();
			newOrderInstance.clickOnCreateBundleButton();
			String bundleName = newOrderInstance.enterBundleName("unique");
			double bundlePrice = newOrderInstance.enterBundlePrice(100);
			newOrderInstance.clickOnSaveBundle();
			Thread.sleep(2000);
			Assert.assertNotEquals(bundlePrice, secondInsSalesPrice+firstInsSalesPrice, 0);
			Assert.assertNotEquals(totalOrderPriceBeforeBundle, newOrderInstance.getTotalOrderPrice(), 0);
			double totalOrderPriceBeforeSubmit = newOrderInstance.getTotalOrderPrice();
			newOrderInstance.submitOrderWithoutSave();
			newOrderInstance.clickYesLegacyAutoInsertionCreation();
			Thread.sleep(3000);
			//newOrderInstance.clickOnContinuePastPubDate();//joy
			//Thread.sleep(2000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info("Order: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);

			orderEntryPageInstance.clickOnOrder(orderID);
			 Logger.info("Order No. is:"+orderID);
			 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)						
	        			.withTimeout(500, TimeUnit.SECONDS) 			
	        			.pollingEvery(2, TimeUnit.SECONDS) 			
	        			.ignoring(NoSuchElementException.class);	
	        	WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){
	        	
	        		public WebElement apply(WebDriver driver ) {
	        			return 	driver.findElement(By.xpath("//span[text()='Processed ']"));

	        		}
	        	});
				Thread.sleep(4000);
	        	String orderStatusProcessed = newOrderInstance.getOrdeStatusOrderViewPage();
				Logger.info("orderStatus "+orderStatusProcessed);
			double totalOrderPriceAfterSubmit = newOrderInstance.getTotalOrderPrice();
			Assert.assertEquals(totalOrderPriceAfterSubmit, totalOrderPriceBeforeSubmit, 0);

			
			dashboardPageInstance.clickondropdownforlogout();//joy

			//dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

}

