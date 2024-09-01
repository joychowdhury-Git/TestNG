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

public class OrderOwnLocalAutoInsertionPerCalendarWeekTest {
	@Test(groups = { "Order", "OwnLocal", "ownLocalAutoInsertionValidation", "Grp4", "OLReg", "RegressionLatest",
			"Group2",
			"OLReg" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ownLocalAutoInsertionValidation(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 25, 0);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			newOrderInstance.selectProductType("1", 25, 1);
			newOrderInstance.selectProduct("1", 25, 2);
			newOrderInstance.selectAdType("1", 25, 3);
			newOrderInstance.selectSection("1", 25, 4);
			Thread.sleep(7000);
			Logger.info("BU of Ownlocal AutoInsertion " + newOrderInstance.getBUOnInsertion(2));
			Assert.assertEquals(newOrderInstance.getBUOnInsertion(2),
					TribuneUtils.getStringCellValues("Product", 26, 0));
			Logger.info("Producttype of Ownlocal AutoInsertion " + newOrderInstance.getProductTypeOnInsertion(2));
			Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2),
					TribuneUtils.getStringCellValues("Product", 26, 1));
			Logger.info("Product of Ownlocal AutoInsertion " + newOrderInstance.getProductOnInsertion(2));
			Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
					TribuneUtils.getStringCellValues("Product", 26, 2));
			Logger.info("Adtype of Ownlocal AutoInsertion " + newOrderInstance.getAdTypeOnInsertion(2));
			Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2),
					TribuneUtils.getStringCellValues("Product", 26, 3));

			// Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			// "total"), TribuneUtils.getDoubleCellValues("Product", 26, 17));

			Logger.info(
					"Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
			Thread.sleep(3000);
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "OLReg", "OwnLocal", "SwagataMou", "Grp4", "OLReg", "RegressionLatest", "Group2",
			"RegFail2", "NewRegression2", "NewRegression", "ownLocalSameMaterialIDSamePubdate",
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
			newOrderInstance.selectSoldToCustomerBU("bu_HTF");
			newOrderInstance.enterSoldToCustomer("CU00001123");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			// newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 25, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "17", "Jul", "2021");// mou
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 25, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 25, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 25, 3);
			Thread.sleep(4000);
			newOrderInstance.selectSection("1", 25, 4);

			Thread.sleep(4000);
			/*
			 * Assert.assertEquals(newOrderInstance.getBUOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 26, 0));
			 * Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2)
			 * , TribuneUtils.getStringCellValues("Product", 26, 1));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 26, 2));
			 * Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 26, 3));
			 * Assert.assertEquals(newOrderInstance.getSectionOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 26, 4)); //
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * newOrderInstance.getPubDateOnInsertion(1));
			 * Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
			 * Assert.assertEquals(newOrderInstance.getMaterialID("2"),
			 * newOrderInstance.getMaterialID("1"));
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 26, 17));
			 */
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(7000);

			int insertionCount = newOrderInstance.getInsertionsCount();
			Assert.assertEquals(insertionCount, 3);
			/*
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(1),
			 * TribuneUtils.getStringCellValues("Product", 25, 2));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 26, 2));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(3),
			 * TribuneUtils.getStringCellValues("Product", 25, 2));
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 26, 17));
			 * Assert.assertEquals(newOrderInstance.getMaterialID("2"),
			 * newOrderInstance.getMaterialID("1"));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * newOrderInstance.getPubDateOnInsertion(1));
			 * Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
			 */
			Logger.info(
					"Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
			Logger.info("Same MaterilaID SamePub date - Validation success");
			Logger.info("Only one ownlocal auto insertion is created with price for only one insertion");
			Logger.info("Pub date and material ID are matching with the parent insertion");
			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {
			"ownLocalSameMaterialIDDiffPubdateSameWeek" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ownLocalSameMaterialIDDiffPubdateSameWeek(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_HTF");
			newOrderInstance.enterSoldToCustomer("CU00001123");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			// newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 25, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "17", "Jul", "2021");// mou
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 25, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 25, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 25, 3);
			Thread.sleep(4000);
			newOrderInstance.selectSection("1", 25, 4);
			Thread.sleep(7000);
			/*
			 * 
			 * Assert.assertEquals(newOrderInstance.getBUOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 26, 0));
			 * Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2)
			 * , TribuneUtils.getStringCellValues("Product", 26, 1));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 26, 2));
			 * Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 26, 3));
			 * Assert.assertEquals(newOrderInstance.getSectionOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 26, 4));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * newOrderInstance.getPubDateOnInsertion(1));
			 * Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
			 * Assert.assertEquals(newOrderInstance.getMaterialID("2"),
			 * newOrderInstance.getMaterialID("1"));
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 26, 17));
			 */
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("3", "18", "Jul", "2021");// mou
			Thread.sleep(5000);

			int insertionCount = newOrderInstance.getInsertionsCount();
			Assert.assertEquals(insertionCount, 3);// mou
			/*
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(1),
			 * TribuneUtils.getStringCellValues("Product", 25, 2));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 26, 2));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(3),
			 * TribuneUtils.getStringCellValues("Product", 25, 2));
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 26, 17));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * newOrderInstance.getPubDateOnInsertion(1));
			 * Assert.assertEquals(newOrderInstance.getMaterialID("2"),
			 * newOrderInstance.getMaterialID("1"));
			 * Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
			 */
			Logger.info(
					"Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
			Logger.info("Validation success - Same MaterialID Different Pub date within same week");
			Logger.info("One ownlocal auto insertions is created with price unchanged");
			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "OwnLocal",
			"ownLocalDiffMaterialIDSamePubdate" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
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
			newOrderInstance.selectSoldToCustomerBU("bu_HTF");
			Thread.sleep(2000);
			newOrderInstance.enterSoldToCustomer("CU00001123");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			// newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			Thread.sleep(2000);
			newOrderInstance.selectBU("1", 25, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "17", "Jul", "2021");// mou
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 25, 1);
			Thread.sleep(4000);// mou
			newOrderInstance.selectProduct("1", 25, 2);
			Thread.sleep(6000);// mou
			newOrderInstance.selectAdType("1", 25, 3);
			Thread.sleep(2000);
			newOrderInstance.selectSection("1", 25, 4);
			Thread.sleep(3000);
			Logger.info("bu: " + newOrderInstance.getBUOnInsertion(2));
			Logger.info("pdt type: " + newOrderInstance.getProductTypeOnInsertion(2));
			Logger.info("pdt: " + newOrderInstance.getProductOnInsertion(2));
			Logger.info("ad type: " + newOrderInstance.getAdTypeOnInsertion(2));
			Logger.info("section: " + newOrderInstance.getSectionOnInsertion(2));
			Logger.info("pun date: " + newOrderInstance.getPubDateOnInsertion(2));
			Logger.info("insrtn no: " + newOrderInstance.getInsertionNumber(2));
			Logger.info("Material ID2: " + newOrderInstance.getMaterialID("2"));
			Logger.info("Material ID1: " + newOrderInstance.getMaterialID("1"));
			Logger.info("Insertion Price: " + newOrderInstance.getInsertionPrice("2", "total"));
			/*
			 * Assert.assertEquals(newOrderInstance.getBUOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 26, 0));
			 * Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2)
			 * , TribuneUtils.getStringCellValues("Product", 26, 1));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 26, 2));
			 * Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 26, 3));
			 * Assert.assertEquals(newOrderInstance.getSectionOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 26, 4));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * newOrderInstance.getPubDateOnInsertion(1));
			 * Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
			 * Assert.assertEquals(newOrderInstance.getMaterialID("2"),
			 * newOrderInstance.getMaterialID("1"));
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 26, 17));
			 */
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(5000);
			Logger.info("" + newOrderInstance.getInsertionsCount());
			newOrderInstance.enterPubDate("3", "24", "Jul", "2021");// mou
			Thread.sleep(2000);// mou
			newOrderInstance.assignMaterialForAnInsertionNoAutoInsertion(3);
			Thread.sleep(5000);

			int insertionCount = newOrderInstance.getInsertionsCount();
			Assert.assertEquals(insertionCount, 4);
			Logger.info("insrtns: " + insertionCount);
			//Logger.info("pdt1: " + newOrderInstance.getProductOnInsertion(1));
			//Logger.info("pdt2: " + newOrderInstance.getProductOnInsertion(2));
			//Logger.info("pdt3: " + newOrderInstance.getProductOnInsertion(3));
			// Logger.info("pdt4: "+newOrderInstance.getProductOnInsertion(4));
			Logger.info("Insertion Price2: " + newOrderInstance.getInsertionPrice("2", "total"));
			// Logger.info("pub date3:
			// "+newOrderInstance.getPubDateOnInsertion(3));
			//Logger.info("pub date2: " + newOrderInstance.getPubDateOnInsertion(2));
			//Logger.info("pub date1: " + newOrderInstance.getPubDateOnInsertion(1));

			// Logger.info("Insertion Price4:
			// "+newOrderInstance.getInsertionPrice("4", "total"));
			Logger.info("insrtn no2: " + newOrderInstance.getInsertionNumber(2));
			// Logger.info("Material ID3:
			// "+newOrderInstance.getMaterialID("3"));
			Logger.info("Material ID2: " + newOrderInstance.getMaterialID("2"));
			Logger.info("Material ID1: " + newOrderInstance.getMaterialID("1"));

			/*
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(1),
			 * TribuneUtils.getStringCellValues("Product", 25, 2));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 26, 2));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(3),
			 * TribuneUtils.getStringCellValues("Product", 25, 2));
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 26, 17));
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * newOrderInstance.getPubDateOnInsertion(1));
			 * Assert.assertEquals(newOrderInstance.getMaterialID("2"),
			 * newOrderInstance.getMaterialID("1"));
			 */
			Logger.info(
					"Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
			Logger.info("Validation success - Different MaterialID Same Pub date");
			Logger.info("One ownlocal auto insertions is created, material matches with first parent insertion");

			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "SMaintenance","Order", "NovMaintenance", "OwnLocal3", "SwagataMou", "OwnLocalReg", "Grp4", "OLReg",
			"RegressionLatest", "Group2", "RegFail2", "NewRegression2", "NewRegression", "G2",
			"ownLocalDiffMaterialIDDiffPubdateSameWeek",
			"ownLocalOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ownLocalDiffMaterialIDDiffPubdateSameWeek(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_OSC");
			newOrderInstance.enterSoldToCustomer("CU00392709");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(false);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 25, 0);
			Thread.sleep(5000);// arka
			JavascriptExecutor js = (JavascriptExecutor) driver;// arka
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");// arka
			Thread.sleep(5000);
		//	newOrderInstance.enterPubDate("1", "22", "Dec", "2021");//swagata
			newOrderInstance.enterPubDateFromExcel("1", 9, 27);//swagata
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 25, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 25, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 25, 3);
			Thread.sleep(4000);
			// newOrderInstance.selectSection("1", 25, 4);//arka
			// Thread.sleep(7000);
			Logger.info("bu: " + newOrderInstance.getBUOnInsertion(2));
			Logger.info("pdt type: " + newOrderInstance.getProductTypeOnInsertion(2));
			Logger.info("pdt: " + newOrderInstance.getProductOnInsertion(2));
			Logger.info("ad type: " + newOrderInstance.getAdTypeOnInsertion(2));
			Logger.info("section: " + newOrderInstance.getSectionOnInsertion(2));
			Logger.info("pun date: " + newOrderInstance.getPubDateOnInsertion(2));
			Logger.info("insrtn no: " + newOrderInstance.getInsertionNumber(2));
			//Logger.info("Material ID2: " + newOrderInstance.getMaterialID("2"));
			//Logger.info("Material ID1: " + newOrderInstance.getMaterialID("1"));
			//Logger.info("Insertion Price: " + newOrderInstance.getInsertionPrice("2", "total"));

			
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			//newOrderInstance.enterPubDate("3", "24", "Dec", "2021");
			//newOrderInstance.enterPubDateFromExcel("3", 16, 27);//swagata
			newOrderInstance.enterPubDateFromExcel("1", 9, 27); //joy
			Thread.sleep(2000);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");// arka
			Thread.sleep(2000);
			//newOrderInstance.assignMaterialForAnInsertion(3);
			//Thread.sleep(5000);

			int insertionCount = newOrderInstance.getInsertionsCount();
			Logger.info("insrtns: " + insertionCount);
			Logger.info("pdt1: " + newOrderInstance.getProductOnInsertion(1));
			Logger.info("pdt2: " + newOrderInstance.getProductOnInsertion(3));
			Logger.info("pdt3: " + newOrderInstance.getProductOnInsertion(4));
			// Logger.info("pdt4: "+newOrderInstance.getProductOnInsertion(4));
			Logger.info("Insertion Price2: " + newOrderInstance.getInsertionPrice("2", "total"));
			Logger.info("pub date3: " + newOrderInstance.getPubDateOnInsertion(4));
			Logger.info("pub date2: " + newOrderInstance.getPubDateOnInsertion(3));
			Logger.info("pub date1: " + newOrderInstance.getPubDateOnInsertion(1));

			// Logger.info("Insertion Price4:
			// "+newOrderInstance.getInsertionPrice("4", "total"));
			Logger.info("insrtn no2: " + newOrderInstance.getInsertionNumber(3));
			//Logger.info("Material ID3: " + newOrderInstance.getMaterialID("3"));
			//Logger.info("Material ID2: " + newOrderInstance.getMaterialID("2"));
			//Logger.info("Material ID1: " + newOrderInstance.getMaterialID("1"));
			
			Logger.info(
					"Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
			Logger.info("Validation success - Different MaterialID Different Pub date within same week");
			Logger.info("One ownlocal auto insertions is created");
			Logger.info("Pub date and material ID are matching with the first parent insertions");
			dashboardPageInstance.clickOnLogout();
			//dashboardPageInstance.clickondropdownforlogout();//Joy
			//newOrderInstance.displayWarningMessageConfirm();//swagata

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "SMaintenance","Order", "NovMaintenance", "OwnLocal", "ownLocalSameMaterialIDDiffPubdateDiffWeek", "Grp4",
			"OLReg", "RegressionLatest", "Group2", "RegFail27", "NewRegression2", "NewRegression", "G2",
			"ownLocalOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ownLocalSameMaterialIDDiffPubdateDiffWeek(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_OSC");
			newOrderInstance.enterSoldToCustomer("CU00392709");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(false);// arka
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 25, 0);
			Thread.sleep(5000);// arka
			JavascriptExecutor js = (JavascriptExecutor) driver;// arka
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");// arka
			Thread.sleep(3000);// arka
			newOrderInstance.enterPubDate("1", "12", "Feb", "2021");//swagata
			//newOrderInstance.enterPubDateFromExcel("1", 9, 27);//swagata
			Thread.sleep(3000);
			newOrderInstance.selectProductType("1", 25, 1);
			Thread.sleep(2000);
			newOrderInstance.selectProduct("1", 25, 2);
			Thread.sleep(2000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");// arka
			Thread.sleep(4000);// arka
			//newOrderInstance.enterPubDateFromExcel("1", 9, 27);//Joy
			newOrderInstance.enterPubDate("3", "19", "Feb", "2021");//swagata
			Thread.sleep(5000);
			int insertionCount = newOrderInstance.getInsertionsCount();
			Assert.assertEquals(insertionCount, 4);//Joy
			
			Logger.info(
					"Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
			Logger.info("Validation success - Same MaterialID Different Pub date not within same week");
			Logger.info("Two ownlocal auto insertions are created, one for each parent insertion");
			dashboardPageInstance.clickOnLogout();//swagata
			
			//newOrderInstance.displayWarningMessageConfirm();//swagata

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "SMaintenance","Order", "OwnLocal", "NovMaintenance", "ownLocalDiffMaterialIDDiffPubdateDiffWeek", "OwnLocalReg",
			"Grp4", "OLReg", "RegressionLatest", "Group2", "TestPriority", "RegFail2", "NewRegression2",
			"NewRegression", "G2",
			"ownLocalOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ownLocalDiffMaterialIDDiffPubdateDiffWeek(Map<String, String> userData) throws Exception {
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
			// newOrderInstance.checkUncheckOwnLocalOptOut(true);//arka
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 25, 0);
			Thread.sleep(5000);// arka
			JavascriptExecutor js = (JavascriptExecutor) driver;// arka
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");// arka
			Thread.sleep(5000);
			//newOrderInstance.enterPubDate("1", "22", "Dec", "2021");//swagata
			newOrderInstance.enterPubDateFromExcel("1", 9, 27);//swagata
			Thread.sleep(3000);
			newOrderInstance.selectProductType("1", 25, 1);
			Thread.sleep(3000);
			newOrderInstance.selectProduct("1", 25, 2);
			// newOrderInstance.selectAdType("1",25, 3);
			// newOrderInstance.selectSection("1",25, 4);
			Thread.sleep(7000);
			Logger.info("bu: " + newOrderInstance.getBUOnInsertion(2));// arka
			Logger.info("pdt type: " + newOrderInstance.getProductTypeOnInsertion(2));// arka
			Logger.info("pdt: " + newOrderInstance.getProductOnInsertion(2));// arka
			Logger.info("ad type: " + newOrderInstance.getAdTypeOnInsertion(2));// arka
			Logger.info("section: " + newOrderInstance.getSectionOnInsertion(2));// arka
			Logger.info("pub date: " + newOrderInstance.getPubDateOnInsertion(2));// arka
			Logger.info("insrtn no: " + newOrderInstance.getInsertionNumber(2));// arka
			Logger.info("Material ID2: " + newOrderInstance.getMaterialID("2"));// arka
			Logger.info("Material ID1: " + newOrderInstance.getMaterialID("1"));// arka
			Logger.info("Insertion Price: " + newOrderInstance.getInsertionPrice("2", "total"));// arka
			
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			//newOrderInstance.enterPubDate("3", "26", "Dec", "2021");//swagata
			newOrderInstance.enterPubDateFromExcel("1", 17, 27);//swagata
			Thread.sleep(4000);
			//newOrderInstance.assignMaterialForAnInsertion(3);// arka
			//Thread.sleep(5000);

			int insertionCount = newOrderInstance.getInsertionsCount();
			Logger.info("insrtns: " + insertionCount);
			Logger.info("pdt1: " + newOrderInstance.getProductOnInsertion(1));
			//Logger.info("pdt2: " + newOrderInstance.getProductOnInsertion(2));
			//Logger.info("pdt3: " + newOrderInstance.getProductOnInsertion(3));
			//Logger.info("pdt4: " + newOrderInstance.getProductOnInsertion(4));//swagata
			//Logger.info("Insertion Price2: " + newOrderInstance.getInsertionPrice("2", "total"));
			//Logger.info("pub date2: " + newOrderInstance.getPubDateOnInsertion(2));
			//Logger.info("insrtn no2: " + newOrderInstance.getInsertionNumber(2));


			//Logger.info("Material ID2: " + newOrderInstance.getMaterialID("2"));
			//Logger.info("Material ID3: " + newOrderInstance.getMaterialID("3"));

			//Assert.assertEquals(3,insertionCount);//swagata
			
			Logger.info(
					"Validation success - Own Local AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");
			Logger.info("Validation success - Same MaterialID Different Pub date not within same week");
			Logger.info("Two ownlocal auto insertions are created, one for each paremeter insertion"); //joy
			dashboardPageInstance.clickOnLogout();//partha
			//dashboardPageInstance.clickondropdownforlogout(); //Joy
			
			//newOrderInstance.displayWarningMessageConfirm();//swagata
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
