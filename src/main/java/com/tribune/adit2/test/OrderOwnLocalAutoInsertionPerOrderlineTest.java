package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
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

public class OrderOwnLocalAutoInsertionPerOrderlineTest {
	@Test(groups = { "Order", "NovMaintenance", "orderWithOwnLocalAutoInsertion", "SanityTestNew", "OwnLocal", "OLReg",
			"RegressionLatest", "ProductionSanityTest1", "orderWithOwnLocalAutoInsertionPerOrderline", "Group2", "Grp4",
			"ProductionTest", "orderWithOwnLocalAutoInsertionPerOrderline8182", "ProductionTest32", "PTest1", "Group2F",
			"ProductionTestCI", "NewRegression2", "NewRegression", "G2",
			"ownLocalOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void orderWithOwnLocalAutoInsertion(Map<String, String> userData) throws Exception {
		try {
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
			newOrderInstance.selectSoldToCustomerBU("bu_ALT");
			newOrderInstance.enterSoldToCustomer("CU00258088");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(false);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 27, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "20", "Dec", "2021");
			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor) driver;// arka
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");// arka
			Thread.sleep(3000);// arka
			newOrderInstance.selectProductType("1", 27, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 27, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 27, 3);
			Thread.sleep(9000);
			// newOrderInstance.selectSection("1",27, 4);
			// Thread.sleep(4000);
			newOrderInstance.enterClassCodeForAnInsertion(1, "90050");// arka

			// newOrderInstance.clickOnInsertionSalesRepSection(2);
			// newOrderInstance.addNewSalesRepOnInsertion(2, "SA00443");

			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.selectMaterialSource("1","NewBuild");
			newOrderInstance.checkUncheckPosTemplateChckbx(1, true);
			newOrderInstance.clickOnPositionSelector();
			Thread.sleep(40000);
			newOrderInstance.selectAdSizeForPosition();
			Thread.sleep(5000);
			newOrderInstance.clickOnSearchPositionInPSWindw();
			Thread.sleep(10000);
			// newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
			newOrderInstance.selectFirstPostionFrmPositionSlctr();
			newOrderInstance.savePositionSelection();
			Thread.sleep(15000);

			/*
			 * Assert.assertEquals(newOrderInstance.getBUOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 34, 0));
			 * Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2)
			 * , TribuneUtils.getStringCellValues("Product", 34, 1));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 34, 2));
			 * Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 34, 3));
			 * Assert.assertEquals(newOrderInstance.getSectionOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 34, 4));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * "01/29/2020");
			 * Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
			 * Assert.assertEquals(newOrderInstance.getMaterialID("2"), "1");
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 34, 17));
			 */
			int insertionCount = newOrderInstance.getInsertionsCount();
			Logger.info("Insrtn count: " + insertionCount);
			// Assert.assertEquals(insertionCount, 3);
			Logger.info("BU: " + newOrderInstance.getBUOnInsertion(2));
			// Assert.assertEquals(newOrderInstance.getBUOnInsertion(3),
			// TribuneUtils.getStringCellValues("Product", 28, 0));
			Logger.info("Pdt Type: " + newOrderInstance.getProductTypeOnInsertion(2));
			// Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(3),
			// TribuneUtils.getStringCellValues("Product", 28, 1));
			Logger.info("Pdt: " + newOrderInstance.getProductOnInsertion(2));
			// Assert.assertEquals(newOrderInstance.getProductOnInsertion(3),
			// TribuneUtils.getStringCellValues("Product", 28, 2));
			Logger.info("Ad Type: " + newOrderInstance.getAdTypeOnInsertion(2));
			// Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(3),
			// TribuneUtils.getStringCellValues("Product", 28, 3));
			Logger.info("Section: " + newOrderInstance.getSectionOnInsertion(2));
			// Assert.assertEquals(newOrderInstance.getSectionOnInsertion(3),
			// TribuneUtils.getStringCellValues("Product", 28, 4));
			Logger.info("Pub Date: " + newOrderInstance.getPubDateOnInsertion(2));
			// Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(3),
			// "01/29/2020");
			Logger.info("Insrtn No: " + newOrderInstance.getInsertionNumber(2));
			// Assert.assertEquals(newOrderInstance.getInsertionNumber(3), 2);
			Logger.info("Material ID: " + newOrderInstance.getMaterialID("2"));
			// Assert.assertEquals(newOrderInstance.getMaterialID("3"), "1");
			Logger.info("New Insertion Price: " + newOrderInstance.getInsertionPrice("2", "total"));
			Thread.sleep(5000);
			newOrderInstance.saveOrder();

			Thread.sleep(7000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : " + orderNumber);
			Thread.sleep(3000);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order","NovMaintenance", "ownLocalSameMaterialIDSamePubdateOrderline", "OwnLocalReg", "Grp4", "OLReg",
			"RegressionLatest", "orderWithOwnLocalAutoInsertionPerOrderline", "Group2", "NewRegression2",
			"NewRegression", "G2",
			"ownLocalOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ownLocalSameMaterialIDSamePubdate(Map<String, String> userData) throws Exception {
		try {
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
			newOrderInstance.checkUncheckOwnLocalOptOut(false);//arka
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 25, 0);
			Thread.sleep(5000);//arka
			JavascriptExecutor js = (JavascriptExecutor) driver;//arka
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");//arka
			Thread.sleep(3000);//arka
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			Thread.sleep(3000);
			newOrderInstance.selectProductType("1", 25, 1);
			Thread.sleep(2000);
			newOrderInstance.selectProduct("1", 25, 2);
			Thread.sleep(2000);
			/*
			 * Assert.assertEquals(newOrderInstance.getBUOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 0));
			 * Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2)
			 * , TribuneUtils.getStringCellValues("Product", 22, 1));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 2));
			 * Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 3));
			 * Assert.assertEquals(newOrderInstance.getSectionOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 4));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * "01/29/2020");
			 * Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
			 * Assert.assertEquals(newOrderInstance.getMaterialID("2"), "1");
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 22, 17));
			 */
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);

			int insertionCount = newOrderInstance.getInsertionsCount();
			Assert.assertEquals(insertionCount, 3);
			Assert.assertEquals(newOrderInstance.getProductOnInsertion(1), newOrderInstance.getProductOnInsertion(3));
			// Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			// TribuneUtils.getStringCellValues("Product", 22, 2));
			// Assert.assertEquals(newOrderInstance.getProductOnInsertion(3),
			// TribuneUtils.getStringCellValues("Product", 12, 2));
			// Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			// "total"), TribuneUtils.getDoubleCellValues("Product", 22, 17));

			Logger.info(
					"Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
			Logger.info("Same MaterilaID SamePub date - Validation success");
			Logger.info("Only one ownlocal auto insertion is created with price for only one insertion");
			Logger.info("Pub date and material ID are matching with the parent insertion");
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order",
			"OwnLocal" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ownLocalNewVersionExistingOrderLine(Map<String, String> userData) throws Exception {
		try {
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
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(2000);

			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 12, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "17", "Jul", "2021");// mou
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 12, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 12, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 12, 3);
			Thread.sleep(4000);
			newOrderInstance.selectSection("1", 12, 4);
			Thread.sleep(4000);
			/*
			 * Assert.assertEquals(newOrderInstance.getBUOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 0));
			 * Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2)
			 * , TribuneUtils.getStringCellValues("Product", 22, 1));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 2));
			 * Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 3));
			 * Assert.assertEquals(newOrderInstance.getSectionOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 4));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * "12/29/2020");
			 * Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
			 * Assert.assertEquals(newOrderInstance.getMaterialID("2"), "1");
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 22, 17));
			 */
			newOrderInstance.createNewInsertionVersion("1");
			Thread.sleep(4000);

			int insertionCount = newOrderInstance.getInsertionsCount();
			Assert.assertEquals(insertionCount, 3);

			Logger.info(
					"Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
			Logger.info("New version of existing pub date - Validation success");
			Logger.info("Only one ownlocal auto insertion is created with price for only one insertion");
			Logger.info("Pub date and material ID are matching with the parent insertion");
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "ownLocalSameMaterialIDDiffPubdate", "OwnLocalReg", "Grp4", "OLReg",
			"RegressionLatest", "orderWithOwnLocalAutoInsertionPerOrderline", "Group2", "RegFail2", "NANT",
			"NewRegression2", "NewRegression", "NovMaintenance",
			"ownLocalOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ownLocalSameMaterialIDDiffPubdate(Map<String, String> userData) throws Exception {
		try {
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
			newOrderInstance.checkUncheckOwnLocalOptOut(false);// arka
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 62, 0);// arka
			Thread.sleep(4000);// arka
			JavascriptExecutor js = (JavascriptExecutor) driver;// arka
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");// arka
			Thread.sleep(4000);// arka
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			Thread.sleep(4000);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");// arka
			Thread.sleep(4000);// arka
			newOrderInstance.selectProductType("1", 62, 1);// arka
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 62, 2);// arka
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 62, 3);// arka
			Thread.sleep(4000);
			newOrderInstance.selectSection("1", 62, 4);// arka
			Thread.sleep(4000);

			/*
			 * Assert.assertEquals(newOrderInstance.getBUOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 0));
			 * Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2)
			 * , TribuneUtils.getStringCellValues("Product", 22, 1));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 2));
			 * Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 3));
			 * Assert.assertEquals(newOrderInstance.getSectionOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 4));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * "12/29/2020");
			 * Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
			 * Assert.assertEquals(newOrderInstance.getMaterialID("2"), "1");
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 22, 17));
			 */
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("3", "21", "Dec", "2021");
			Thread.sleep(5000);

			int insertionCount = newOrderInstance.getInsertionsCount();
			Assert.assertEquals(insertionCount, 3);

			/*
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(1),
			 * newOrderInstance.getProductOnInsertion(3));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * newOrderInstance.getProductOnInsertion(4));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(3),
			 * TribuneUtils.getStringCellValues("Product", 62, 2));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(4),
			 * TribuneUtils.getStringCellValues("Product", 62, 2));
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 62, 17));
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("4",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 22, 17));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(3),
			 * "12/30/2020");
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(4),
			 * "12/30/2020");
			 * Assert.assertEquals(newOrderInstance.getMaterialID("3"), "1");
			 * Assert.assertEquals(newOrderInstance.getMaterialID("4"), "1");
			 */

			Logger.info(
					"Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
			Logger.info("Same MaterialID Different Pub date - Validation success");
			Logger.info("Two ownlocal auto insertions are created, one for each parent insertion");
			Logger.info("Pub date and material ID are matching with the respective parent insertions");
			Thread.sleep(4000);
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "NovMaintenance", "Order", "OwnLocal", "ownLocalDiffMaterialIDSamePubdateOrderline", "Grp4",
			"OLReg", "RegressionLatest", "orderWithOwnLocalAutoInsertionPerOrderline", "Group2", "RegFail2",
			"NewRegression2", "NewRegression", "G2",
			"ownLocalOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ownLocalDiffMaterialIDSamePubdate(Map<String, String> userData) throws Exception {
		try {
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
			newOrderInstance.checkUncheckOwnLocalOptOut(false);// arka
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 62, 0);// arka
			Thread.sleep(4000);// swagata
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor) driver;// arka
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");// arka
			Thread.sleep(4000);// arka
			newOrderInstance.selectProductType("1", 62, 1);// arka
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 62, 2);// arka
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 62, 3);// arka
			Thread.sleep(4000);

			newOrderInstance.selectSection("1", 62, 4);// arka
			Thread.sleep(4000);
			/*
			 * Assert.assertEquals(newOrderInstance.getBUOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 0));
			 * Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2)
			 * , TribuneUtils.getStringCellValues("Product", 22, 1));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 2));
			 * Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 3));
			 * Assert.assertEquals(newOrderInstance.getSectionOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 4));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * "12/29/2020");
			 * Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
			 * Assert.assertEquals(newOrderInstance.getMaterialID("2"), "1");
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 22, 17));
			 */
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(6000);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");// arka
			Thread.sleep(4000);// arka
			newOrderInstance.enterPubDate("3", "21", "Dec", "2021");// arka
			Thread.sleep(4000);
			newOrderInstance.selectProductType("3", 62, 1);// arka
			Thread.sleep(4000);
			newOrderInstance.selectProduct("3", 62, 2);// arka
			Thread.sleep(4000);
			newOrderInstance.selectAdType("3", 62, 3);// arka
			Thread.sleep(4000);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");// arka
			Thread.sleep(4000);
			newOrderInstance.assignMaterialForAnInsertionNoAutoInsertion(3);
			Thread.sleep(5000);

			int insertionCount = newOrderInstance.getInsertionsCount();
			// Assert.assertEquals(insertionCount, 3); //swagata
			Assert.assertEquals(insertionCount, 4); // arka
			/*
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(1),
			 * TribuneUtils.getStringCellValues("Product", 12, 2));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 2));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(3),
			 * TribuneUtils.getStringCellValues("Product", 12, 2));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(4),
			 * TribuneUtils.getStringCellValues("Product", 22, 2));
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 22, 17));
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("4",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 22, 17));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(3),
			 * "12/29/2020");
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(4),
			 * "12/29/2020");
			 * Assert.assertEquals(newOrderInstance.getMaterialID("3"), "2");
			 * Assert.assertEquals(newOrderInstance.getMaterialID("4"), "2");
			 */
			Logger.info(
					"Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
			Logger.info("Different MaterialID Same Pub date - Validation success");
			Logger.info("Two ownlocal auto insertions are created, one for each parent insertion");
			Logger.info("Pub date and material ID are matching with the respective parent insertions");
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "arkadeep", "NovMaintenance", "Order", "OwnLocal", "ownLocalDiffMaterialIDDiffPubdate",
			"Grp4", "OLReg", "RegressionLatest", "orderWithOwnLocalAutoInsertionPerOrderline", "Group2", "RegFail2",
			"Group2F", "NewRegression2", "NewRegression", "G2",
			"ownLocalOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ownLocalDiffMaterialIDDiffPubdate(Map<String, String> userData) throws Exception {
		try {
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
			newOrderInstance.checkUncheckOwnLocalOptOut(false);// arka
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 11, 0);
			Thread.sleep(4000);// swagata
			JavascriptExecutor js = (JavascriptExecutor) driver;// arka
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");// arka
			Thread.sleep(4000);
			//newOrderInstance.enterPubDate("1", "22", "Dec", "2021");//swagata
			newOrderInstance.enterPubDateFromExcel("1", 9, 27);//swagata
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 11, 1);// arka
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 11, 2);// arka
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 11, 3);// arka
			Thread.sleep(4000);
			// newOrderInstance.selectSection("1", 11, 4);
			// Thread.sleep(4000);
			/*
			 * Assert.assertEquals(newOrderInstance.getBUOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 0));
			 * Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2)
			 * , TribuneUtils.getStringCellValues("Product", 22, 1));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 2));
			 * Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 3));
			 * Assert.assertEquals(newOrderInstance.getSectionOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 4));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * "12/29/2020");
			 * Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
			 * Assert.assertEquals(newOrderInstance.getMaterialID("2"), "1");
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 22, 17));
			 */
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");// arka
			Thread.sleep(3000);// arka
			//newOrderInstance.enterPubDate("3", "24", "Dec", "2021");//swagaat
			newOrderInstance.enterPubDateFromExcel("3", 17, 27);//swagata
			Thread.sleep(2000);
			newOrderInstance.assignMaterialForAnInsertion(3);
			Thread.sleep(5000);

			int insertionCount = newOrderInstance.getInsertionsCount();
			Assert.assertEquals(insertionCount, 4);
			/*
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(1),
			 * TribuneUtils.getStringCellValues("Product", 12, 2));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 2));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(3),
			 * TribuneUtils.getStringCellValues("Product", 12, 2));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(4),
			 * TribuneUtils.getStringCellValues("Product", 22, 2));
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 22, 17));
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("4",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 22, 17));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(3),
			 * "12/31/2020");
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(4),
			 * "12/31/2020");
			 * Assert.assertEquals(newOrderInstance.getMaterialID("3"), "2");
			 * Assert.assertEquals(newOrderInstance.getMaterialID("4"), "2");
			 */
			Logger.info(
					"Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
			Logger.info("Different MaterialID Different Pub date - Validation success");
			Logger.info("Two ownlocal auto insertions are created, one for each parent insertion");
			Logger.info("Pub date and material ID are matching with the respective parent insertions");
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order",
			"ownLocalSameMaterialIDSamePubdatePricePerline" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ownLocalSameMaterialIDSamePubdatePricePerline(Map<String, String> userData) throws Exception {
		try {
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
			newOrderInstance.checkUncheckOwnLocalOptOut(false);//arka
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 23, 0);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 23, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 23, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 23, 3);
			Thread.sleep(4000);
			newOrderInstance.selectSection("1", 23, 4);
			Thread.sleep(4000);
			/*
			 * Assert.assertEquals(newOrderInstance.getBUOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 0));
			 * Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2)
			 * , TribuneUtils.getStringCellValues("Product", 22, 1));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 2));
			 * Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 3));
			 * Assert.assertEquals(newOrderInstance.getSectionOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 4));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * "01/29/2020");
			 * Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
			 * Assert.assertEquals(newOrderInstance.getMaterialID("2"), "1");
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 22, 17));
			 */
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);

			int insertionCount = newOrderInstance.getInsertionsCount();
			Logger.info("" + insertionCount);
			Assert.assertEquals(insertionCount, 3);
			/*
			 * Logger.info("" + newOrderInstance.getProductOnInsertion(1));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(1),
			 * TribuneUtils.getStringCellValues("Product", 23, 2));
			 * Logger.info("" + newOrderInstance.getProductOnInsertion(2));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 2));
			 * Logger.info("" + newOrderInstance.getProductOnInsertion(3));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(3),
			 * TribuneUtils.getStringCellValues("Product", 23, 2));
			 * Logger.info("" + newOrderInstance.getPubDateOnInsertion(2));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * "12/22/2020"); Logger.info("" +
			 * newOrderInstance.getInsertionPrice("2", "total")); //
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2", //
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 22, 22));
			 */
			Logger.info(
					"Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
			Logger.info("Validation success - Same MaterialID Same Pub date - PricePerLine");
			Logger.info("Only one ownlocal auto insertions for both the parent insertions together");
			Logger.info("Pub date and material ID is matching with the first insertion");
			Logger.info("Price of the ownlocal auto insertion is doubled");
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "OwnLocal", "orderWithOwnLocalAutoInsertionPerOrderline", "Grp4",
			"ownLocalKillOrderSingleOwnLocal" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ownLocalKillOrderSingleOwnLocal(Map<String, String> userData) throws Exception {
		try {
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
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 12, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 12, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 12, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 12, 3);
			Thread.sleep(4000);
			newOrderInstance.selectSection("1", 12, 4);
			Thread.sleep(4000);
			/*
			 * Assert.assertEquals(newOrderInstance.getBUOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 0));
			 * Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2)
			 * , TribuneUtils.getStringCellValues("Product", 22, 1));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 2));
			 * Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 3));
			 * Assert.assertEquals(newOrderInstance.getSectionOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 4));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * "12/29/2020");
			 * Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
			 * Assert.assertEquals(newOrderInstance.getMaterialID("2"), "1");
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 22, 17));
			 */
			Thread.sleep(2000);
			int insertionCount = newOrderInstance.getInsertionsCount();
			Assert.assertEquals(insertionCount, 2);

			Logger.info("" + newOrderInstance.getProductOnInsertion(2));
			/*
			 * //Assert.assertEquals(newOrderInstance.getProductOnInsertion(1),
			 * TribuneUtils.getStringCellValues("Product", 12, 2));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 2));
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 22, 17));
			 */
			Logger.info(
					"Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
			Logger.info("Same MaterilaID SamePub date - Validation success");
			Logger.info("Only one ownlocal auto insertion is created with price for only one insertion");
			Logger.info("Pub date and material ID are matching with the parent insertion");

			// newOrderInstance.clickOnInsertionSalesRepSection(2);
			// newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");
			Thread.sleep(2000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(2);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order: " + orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();

			Thread.sleep(3000);
			driver.navigate().refresh();
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			newOrderInstance.clickOnKill();
			newOrderInstance.clickOnKillOnConfirmation();
			Thread.sleep(12000);
			//// Assert.assertEquals(newOrderInstance.getInsertionStatus("1"),"Killed");
			// Assert.assertEquals(newOrderInstance.getInsertionStatus("2"),"Killed");

			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "ownLocalKillSingleOrderline", "Grp4",
			"orderWithOwnLocalAutoInsertionPerOrderline" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ownLocalKillSingleOrderline(Map<String, String> userData) throws Exception {
		try {
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
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 12, 0);
			newOrderInstance.enterPubDate("1", "21", "Dec", "2021");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 12, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 12, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 12, 3);
			Thread.sleep(4000);
			newOrderInstance.selectSection("1", 12, 4);
			Thread.sleep(4000);

			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("3", "22", "Dec", "2021");
			Thread.sleep(4000);
			newOrderInstance.assignMaterialForAnInsertion(3);
			Thread.sleep(5000);

			int insertionCount = newOrderInstance.getInsertionsCount();
			Assert.assertEquals(insertionCount, 4);
			Logger.info(
					"Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");

			// newOrderInstance.clickOnInsertionSalesRepSection(2);
			// newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");
			// Thread.sleep(2000);
			// newOrderInstance.clickOnInsertionSalesRepSection(4);
			// newOrderInstance.addNewSalesRepOnInsertion(4, "SA01380");
			Thread.sleep(4000);
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
			Thread.sleep(3000);
			String orderID = orderEntryPageInstance.getOrderID();
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Logger.info("OrderID " + orderID);
			Thread.sleep(3000);
			driver.navigate().refresh();
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(4000);
			newOrderInstance.killInsertion("1");

			Thread.sleep(6000);
			Assert.assertEquals(newOrderInstance.getInsertionStatus("1"), "Kill Pending");
			Assert.assertEquals(newOrderInstance.getInsertionStatus("2"), "Kill Pending");

			newOrderInstance.submitOrder();
			Thread.sleep(3000);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {
			"updateParentInsertionOfOwnLocal" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void updateParentInsertionOfOwnLocal(Map<String, String> userData) throws Exception {
		try {
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
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 12, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "17", "Dec", "2021");// mou
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 12, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 12, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 12, 3);
			Thread.sleep(4000);
			newOrderInstance.selectSection("1", 12, 4);
			Thread.sleep(4000);
			/*
			 * Assert.assertEquals(newOrderInstance.getBUOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 0));
			 * Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2)
			 * , TribuneUtils.getStringCellValues("Product", 22, 1));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 2));
			 * Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 3));
			 * Assert.assertEquals(newOrderInstance.getSectionOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 4));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * "12/29/2020");
			 * Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
			 * Assert.assertEquals(newOrderInstance.getMaterialID("2"), "1");
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 22, 17));
			 */

			// Thread.sleep(2000);//swagata
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");// mou
			Thread.sleep(4000);// mou
			newOrderInstance.clickOnInsertionSalesRepSection(1);// mou
			Thread.sleep(4000);// mou
			newOrderInstance.applytoAllSalesRepOnInsertion(2);// mou
			Thread.sleep(2000);// mou
			Thread.sleep(4000); // swagata
			newOrderInstance.submitOrder();
			Thread.sleep(5000);// mou
			newOrderInstance.clickNoLegacyAutoInsertionCreation();// mou
			Thread.sleep(2000);// mou

			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order: " + orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(4000);

			newOrderInstance.selectSection("1", 23, 4);
			Thread.sleep(4000);
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// Thread.sleep(4000);
			// newOrderInstance.applytoAllSalesRepOnInsertion(3);
			/*
			 * Thread.sleep(2000);//swagata Thread.sleep(4000);
			 */// swagata*/

			Thread.sleep(2000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(3, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(3);
			Thread.sleep(2000);
			Thread.sleep(4000);// payel

			/*
			 * Assert.assertEquals(newOrderInstance.getBUOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 0));
			 * Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2)
			 * , TribuneUtils.getStringCellValues("Product", 22, 1));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 2));
			 * Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 3));
			 * Assert.assertEquals(newOrderInstance.getSectionOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 22, 4));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * "12/29/2020");
			 * Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
			 * Assert.assertEquals(newOrderInstance.getMaterialID("2"), "1");
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 22, 17));
			 * Assert.assertEquals(newOrderInstance.getBUOnInsertion(3),
			 * TribuneUtils.getStringCellValues("Product", 22, 0));
			 * Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(3)
			 * , TribuneUtils.getStringCellValues("Product", 22, 1));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(3),
			 * TribuneUtils.getStringCellValues("Product", 22, 2));
			 * Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(3),
			 * TribuneUtils.getStringCellValues("Product", 22, 3));
			 * Assert.assertEquals(newOrderInstance.getSectionOnInsertion(3),
			 * TribuneUtils.getStringCellValues("Product", 22, 4));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(3),
			 * "12/29/2020");
			 * Assert.assertEquals(newOrderInstance.getInsertionNumber(3), 3);
			 * Assert.assertEquals(newOrderInstance.getMaterialID("3"), "1");
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("3",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 22, 17));
			 * Assert.assertEquals(newOrderInstance.getInsertionStatus("2"),
			 * "Kill Pending");
			 */// newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1,
				// "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
				// newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
