package com.tribune.adit2.test;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
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

public class OrderDisplayTest {
	/**
	 * This test will create a new order for a display product type
	 */
	@Test(groups = { "Order", "ProductionTest", "OrderDisplayTest", "ProductionTest3", "OrderDisplayOnlineTest",
			"displayOrder", "Grp4", "RegressionLatest", "Group1", "DsplyReg1",
			"ProductionTestCI" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrder(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");

			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			newOrderInstance.selectProductType("1", 17, 1);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 17, 3);
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			boolean basePriceFlag = false;
			boolean salesPriceFlag = false;
			boolean netPriceFlag = false;
			boolean totalPriceFlag = false;
			boolean contractPriceFlag = false;
			boolean overallPriceFlag = false;
			double basePrice = newOrderInstance.getInsertionPrice("1", "base");
			Logger.info("base price " + basePrice);
			if (basePrice == TribuneUtils.getDoubleCellValues("Product", 17, 14)) {
				basePriceFlag = true;
				Logger.info("base price " + basePrice + " is as per the pricing logics");
			}

			double salesPrice = newOrderInstance.getInsertionPrice("1", "sales");
			Logger.info("sales price " + salesPrice);
			if (salesPrice == TribuneUtils.getDoubleCellValues("Product", 17, 16)) {
				salesPriceFlag = true;
				Logger.info("sales price " + salesPrice + " is as per the pricing logics");
			}
			double netPrice = newOrderInstance.getInsertionPrice("1", "net");
			Logger.info("net price " + netPrice);
			if (netPrice == TribuneUtils.getDoubleCellValues("Product", 17, 15)) {
				netPriceFlag = true;
				Logger.info("net price " + netPrice + " is as per the pricing logics");
			}
			double totalInsertionPrice = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("total insertion price " + totalInsertionPrice);
			if (totalInsertionPrice == TribuneUtils.getDoubleCellValues("Product", 17, 17)) {
				totalPriceFlag = true;
				Logger.info("total insertion price " + totalInsertionPrice + " is as per the pricing logics");
			}
			Thread.sleep(4000);
			double contractPrice = newOrderInstance.getInsertionPrice("1", "contract");
			Logger.info("contract price " + contractPrice);
			if (contractPrice == TribuneUtils.getDoubleCellValues("Product", 17, 18)) {
				contractPriceFlag = true;
				Logger.info("contract price " + contractPrice + " is as per the pricing logics");
			}
			Thread.sleep(4000);
			if (basePriceFlag == true) {
				Logger.info("Base Price as expected");
				if (salesPriceFlag == true) {
					Logger.info("Sales Price as expected");
					if (netPriceFlag == true) {
						Logger.info("Net Price as expected");
						if (contractPriceFlag == true) {
							Logger.info("Contract Price as expected");
							if (totalPriceFlag == true) {
								Logger.info("Total Price as expected");
								overallPriceFlag = true;
							}
						}
					}
				}
			}
			Thread.sleep(4000);
			Logger.info("Overall price flag: " + overallPriceFlag);
			Assert.assertEquals(overallPriceFlag, true);
			Thread.sleep(4000);

			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "SMaintenance","Order", "NovMaintenance","orderWithClassCode", "PrioritizedReg1", "OrderDisplayOnlineTest", "Grp4",
			"RegressionLatest", "Group1", "DsplyReg1", "Group1F", "NewRegression1", "NewRegression", "G1", "RerunF2",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void orderWithClassCode(Map<String, String> userData) throws Exception {
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
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			Thread.sleep(3000);
			newOrderInstance.selectBU("1", 12, 0);
			Thread.sleep(3000);
			newOrderInstance.enterPubDate("1", "21", "Dec", "2021");
			Thread.sleep(3000);
			newOrderInstance.selectProductType("1", 12, 1);
			Thread.sleep(3000);
			newOrderInstance.selectProduct("1", 12, 2);
			Thread.sleep(3000);
			newOrderInstance.selectAdType("1", 12, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1", 12, 4);
			Thread.sleep(6000);
			Logger.info("Overall price before class code: " + newOrderInstance.getInsertionPrice("1", "total"));
			// String
			// priceBeforeClassCode=""+newOrderInstance.getInsertionPrice("1",
			// "total");
			Thread.sleep(6000);
			newOrderInstance.enterClassCodeForAnInsertion(1, "10010");//arka
			Thread.sleep(4000);
			// newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.selectMaterialSource("1","NewBuild");//arka
			// newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			// newOrderInstance.clickOnPositionSelector();
			// Thread.sleep(7000);
			// newOrderInstance.selectAdSizeForPosition(1);
			// Thread.sleep(3000);
			// newOrderInstance.clickOnSearchPositionInPSWindw();
			// newOrderInstance.selectPostionFrmPositionSlctr("15", "1, 20.15");
			// newOrderInstance.savePositionSelection();
			Thread.sleep(3000);
			String priceAfterClassCode = "" + newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("Overall price after class code: " + newOrderInstance.getInsertionPrice("1", "total"));
			// Assert.assertNotEquals(priceBeforeClassCode,
			// priceAfterClassCode);
			Thread.sleep(8000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(8000);
			newOrderInstance.submitOrder();
			Thread.sleep(2000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("orderID " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(3000);

			dashboardPageInstance.clickondropdownforlogout();// joy
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderCreditCard","PrioritizedReg1", "OrderDisplayOnlineTest",
			"DsplyReg12", "Group1", "RegFailed3", "RegressionLatest", "Group1", "NewRegression1", "NewRegression", "G1",
			"RerunF2",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderCreditCard(Map<String, String> userData) throws Exception {
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
			// Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 18, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1", 18, 27);//swagata
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 18, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 18, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 18, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1", 18, 4);
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectAdSize(1, "1/4V  (3 x 10.5)");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(3000);
			//newOrderInstance.clickOnContinuePastPubDate();//joy
			//Thread.sleep(3000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(3000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);

			newOrderInstance.selectPaymentType1("Credit Card");
			newOrderInstance.selectCardType1("New Card");
			Thread.sleep(5000);
			newOrderInstance.enterPaymentAmount("100000");
			// Logger.info("account :
			// "+TribuneUtils.getStringCellValues("BankAccountInfo", 1, 2));
			//newOrderInstance.enterCreditCardInfoOrder("BankAccountInfo");
			Thread.sleep(3000);
			newOrderInstance.clickPayButton();
			Thread.sleep(3000);
			newOrderInstance.compareErrorMessagePopUp(
					"The amount $100,000.00 you are trying to charge is more than the outstanding balance $0.00, hence this request cannot be processed.");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderBillToSoldToPhoneNumber", "OrderDisplayOnlineTest", "displayOrderCard",
			"Group1", "RerunD",
			"Group1F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderBillToSoldToPhoneNumber(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_SSC");
			newOrderInstance.enterSoldToCustomer("(305) 374-6664");
			newOrderInstance.selectBillToCustomerBU("bu_CTC");
			newOrderInstance.enterBillToCustomer("(630) 848-2010");
			// newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.selectPaymentType("Invoice");
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);
			newOrderInstance.enterPubDate("1", "23", "Dec", "2021");
			newOrderInstance.selectProductType("1", 17, 1);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 17, 3);
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(3000);
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			orderEntryPageInstance.clickOnOrder(orderID);

			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderACH", "OrderDisplayOnlineTest", "displayOrderCard", "Group1",
			"Group1F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderACH(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			Thread.sleep(2000);
			newOrderInstance.enterSoldToCustomer("CU00037236");
			Thread.sleep(2000);
			newOrderInstance.selectBilltoSameAsSoldTo();
			Thread.sleep(2000);
			// newOrderInstance.enterPoNumber("1234");
			newOrderInstance.selectOrderType("OrderType_Standard");
			Thread.sleep(2000);
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(2000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.selectPaymentType("Invoice");
			Thread.sleep(2000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(2000);
			newOrderInstance.selectBU("1", 17, 0);
			Thread.sleep(2000);
			newOrderInstance.enterPubDate("1", "21", "Dec", "2021");
			Thread.sleep(2000);
			newOrderInstance.selectProductType("1", 17, 1);
			Thread.sleep(2000);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 17, 3);
			Thread.sleep(2000);
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			Logger.info(orderEntryPageInstance.getOrderID());
			String orderID = orderEntryPageInstance.getOrderID();
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			newOrderInstance.selectPaymentType("ACH");
			Thread.sleep(2000);
			newOrderInstance.selectCardType("New Card");
			Thread.sleep(5000);
			// Logger.info("account :
			// "+TribuneUtils.getStringCellValues("BankAccountInfo", 1, 2));
			newOrderInstance.enterAchBankAccountInfoOrder("BankAccountInfo");
			Thread.sleep(3000);
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(3000);
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrder4Ccolour", "OrderDisplayOnlineTest", "Grp4", "RegressionLatest", "Group1",
			"DsplyReg1",
			"NANT" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrder4Ccolour(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.enterPoNumber("1234");
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);
			newOrderInstance.enterPubDate("1", "17", "Dec", "2021");
			newOrderInstance.selectProductType("1", 17, 1);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 17, 3);
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			/*
			 * newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			 * newOrderInstance.clickOnPositionSelector(); Thread.sleep(45000);
			 * 
			 * // newOrderInstance.selectPostionFrmPositionSlctr("25",
			 * "3, 12.15");
			 * newOrderInstance.selectFirstPostionFrmPositionSlctr();
			 * Thread.sleep(4000); newOrderInstance.savePositionSelection();
			 * Thread.sleep(10000);
			 * newOrderInstance.selectColourForAnInsertion(1,"4C");
			 */
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			Logger.info("Colour of insertion is :" + newOrderInstance.getValueofSelectedColourOption(1));
			// Assert.assertEquals(newOrderInstance.getValueofSelectedColourOption(1),
			// "4C");
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderProgramPrice", "OrderDisplayOnlineTest", "Grp4", "DsplyReg1",
			"RerunD" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderProgramPrice(Map<String, String> userData) throws Exception {
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
			newOrderInstance.checkUncheckOwnLocalOptOut(false);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);
			newOrderInstance.enterPubDate("1", "21", "Dec", "2021");
			Thread.sleep(2000);
			newOrderInstance.selectProductType("1", 17, 1);
			Thread.sleep(2000);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 17, 3);
			Thread.sleep(2000);
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(2000);
			// newOrderInstance.selectProgramPriceForAnInsertion(1,"CHIDMA_Main
			// $11740.2");
			newOrderInstance.clickOnProgramPriceSelectorDisplay();
			Thread.sleep(4000);
			newOrderInstance.verifyProgramPriceSorting();
			Thread.sleep(4000);
			newOrderInstance.selectFirstSpecialProgramPromotion();
			Thread.sleep(4000);
			boolean salesPriceFlag = false;
			double salesPrice = newOrderInstance.getInsertionPrice("1", "sales");
			Logger.info("sales price " + salesPrice);
			if (salesPrice == 11732.5) {
				salesPriceFlag = true;
				Logger.info("sales price " + salesPrice + " is as per the pricing logics");
			}
			Assert.assertEquals(salesPriceFlag, true);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(5000);
			// newOrderInstance.submitOrder();
			Thread.sleep(2000);
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			// Logger.info("Colour of insertion is
			// :"+newOrderInstance.getValueofSelectedColourOption(1));
			// Assert.assertEquals(newOrderInstance.getValueofSelectedColourOption(1),
			// "4C");
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "SMaintenance","Order", "SanityTestNew", "displayOrderUpdate", "ProductionTest", "Grp4", "RegressionLatest",
			"Group1", "DsplyReg1", "RerunD", "PriorityVulnerability", "TestPriority", "NewRegression1", "NewRegression",
			"G1", "RerunF2",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderUpdate(Map<String, String> userData) throws Exception {
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
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 2, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "23", "Dec", "2021");
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 2, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 2, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 2, 3);
			Thread.sleep(4000);
			//newOrderInstance.selectSection("1", 2, 4);
			//Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");

			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(2000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.selectOrderType("OrderType_Legal");
			Thread.sleep(3000);
			Thread.sleep(2000);
			newOrderInstance.submitOrder();
			Thread.sleep(2000);
			// Logger.info(orderEntryPageInstance.getOrderID());
			// orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			// Thread.sleep(1000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			WebElement orderStatus = driver
					.findElement(By.xpath("//*[@id='order-detail-page']/div[1]/div/div[1]/span/span"));
			String text = orderStatus.getText();
			Logger.info("Order Status is :" + text);
			String str = "";
			try {
				if (text.equalsIgnoreCase("Changed") || text.equalsIgnoreCase("Change Pending")) {

					Logger.info("Order Status is Changed as expected");
					str = "Changed";

				} else {
					Logger.info("Order Status is not Changed");

				}
			} catch (Exception e) {
				Logger.info("Order Status is not Changed");

			}
			Thread.sleep(8000);
			Assert.assertEquals(str, "Changed");
			dashboardPageInstance.clickondropdownforlogout();//joy
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "SanityTestNew", "displayOrderVerifyExternalRef", "ProductionTest", "Group1",
			"PriorityDFP", "TestPriority",
			"ProductionTestCI" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderVerifyExternalRef(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);
			newOrderInstance.enterPubDate("1", "26", "Dec", "2021");
			newOrderInstance.selectProductType("1", 17, 1);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 17, 3);
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			// Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(3000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			String externalReferenceVal = newOrderInstance.getExternalReferenceValue();
			Assert.assertEquals(externalReferenceVal.trim(), "Adit 2.0");
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "NovMaintenance","orderWithMMTag", "OrderDisplayOnlineTest", "Grp4",
			"DsplyReg1" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void orderWithMMTag(Map<String, String> userData) throws Exception {
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
			// newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 12, 0);
			newOrderInstance.enterPubDate("1", "21", "Dec", "2021");//arka
			Thread.sleep(3000);
			newOrderInstance.selectProductType("1", 12, 1);
			newOrderInstance.selectProduct("1", 12, 2);
			newOrderInstance.selectAdType("1", 12, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1", 12, 4);
			Thread.sleep(6000);
			newOrderInstance.selectMMTag("1", "TMG Buy");//arka
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(2000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order ID: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderEntryPageInstance.clickOnOrder(orderID);

			Thread.sleep(3000);

			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "SMaintenance","Order", "removeMMTag", "OrderDisplayOnlineTest", "PrioritizedReg1", "Grp4", "RegressionLatest",
			"Group1", "DsplyReg1", "TestPriority", "NewRegression1", "NewRegression", "G1", "RerunF2",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void removeMMTag(Map<String, String> userData) throws Exception {
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
			Thread.sleep(3000);
			newOrderInstance.selectProductType("1", 12, 1);
			newOrderInstance.selectProduct("1", 12, 2);
			newOrderInstance.selectAdType("1", 12, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1", 12, 4);
			Thread.sleep(6000);
			newOrderInstance.selectMMTag("1", "TMG Buy");
			Thread.sleep(4000);
			newOrderInstance.selectMMTag("1", "");
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order ID: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderEntryPageInstance.clickOnOrder(orderID);

			Thread.sleep(3000);

			dashboardPageInstance.clickondropdownforlogout(); //joy
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}


	@Test(groups = { "SMaintenance","Order", "NovMaintenance","displayOrderSameProductDifferentMaterialSourceSameMaterialID", "OrderDisplayOnlineTest",
	"NewRegression1","NewRegression", "G1", "RerunF2","displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderSameProductDifferentMaterialSourceSameMaterialID(Map<String, String> userData)
			throws Exception {
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
			newOrderInstance.selectBU("1", 17, 0);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			newOrderInstance.selectProductType("1", 17, 1);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 17, 3);
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(2000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
		    newOrderInstance.viewInsertionDetails("2");//swagata
		    Thread.sleep(4000);
			newOrderInstance.selectMaterialSource("2", "Electronic");//swagata
			newOrderInstance.collapseInsertionDetails("2");//swagata
			Thread.sleep(4000); // payel
			
			
			newOrderInstance.submitOrder(); //joy
			Thread.sleep(3000);
			newOrderInstance.clickOnContinuePastPubDate();
			Thread.sleep(2000);
			newOrderInstance.clickNoLegacyAutoInsertionCreation(); //joy
			
			

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "NovMaintenance","displayOrderSameProductSameColourSameMaterialID", "OrderDisplayOnlineTest", "Grp4",
			"RegressionLatest", "Group1", "DsplyReg1", "RerunD", "Group1F", "NewRegression", "NewRegression1", "G1",
			"RerunF2",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderSameProductSameColourSameMaterialID(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 17, 0);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			newOrderInstance.selectProductType("1", 17, 1);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 17, 3);
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			//newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(2000);
			newOrderInstance.selectColourForAnInsertion(1, "4C");
			Thread.sleep(4000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			newOrderInstance.saveOrder();
			Thread.sleep(3000);
			Logger.info("Saved Order# : " + newOrderInstance.getOrderNo());
			Thread.sleep(3000);
//			Thread.sleep(4000);
//			newOrderInstance.clickOnInsertionSalesRepSection(1);
//			Thread.sleep(4000);
//			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
//			Thread.sleep(4000);
//			newOrderInstance.clickOnInsertionSalesRepSection(1);
//			Thread.sleep(4000);
//			newOrderInstance.applytoAllSalesRepOnInsertion2(1);
//			Thread.sleep(2000);
//			Thread.sleep(4000);
//			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			// Logger.info("Colour of insertion is
			// :"+newOrderInstance.getValueofSelectedColourOption(1));
			// Assert.assertEquals(newOrderInstance.getValueofSelectedColourOption(1),
			// "4C");
//			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderSameProductDifferentColourSameMaterialID", "PrioritizedReg1",
			"OrderDisplayOnlineTest", "Grp4", "RegressionLatest", "Group1", "DsplyReg1", "RerunD", "Group1F",
			"NewRegression1", "NewRegression", "G1",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderSameProductDifferentColourSameMaterialID(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 17, 0);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			newOrderInstance.selectProductType("1", 17, 1);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 17, 3);
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(2000);
			newOrderInstance.selectColourForAnInsertion(1, "4C");
			Thread.sleep(4000);
			newOrderInstance.selectMaterialSource("1", "New Build");
			Thread.sleep(4000);

			newOrderInstance.createDuplicateInsertion("1");

			Thread.sleep(2000);
			newOrderInstance.selectColourForAnInsertion(1, "B/W");
			Thread.sleep(4000);
			newOrderInstance.saveOrder();
			Thread.sleep(3000);
			Logger.info("Saved Order# : " + newOrderInstance.getOrderNo());
			Thread.sleep(3000);
			/*newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");//swagata
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(4000);*/
			newOrderInstance.submitOrderWithoutSave();//swagata
			newOrderInstance.displayErrorMessage();
			newOrderInstance.compareErrorMessage(
					"Two or more insertion lines with the same Material ID have different Colors! These are lines 01-00 02-00");

			// Logger.info("Colour of insertion is
			// :"+newOrderInstance.getValueofSelectedColourOption(1));
			// Assert.assertEquals(newOrderInstance.getValueofSelectedColourOption(1),
			// "4C");
			//dashboardPageInstance.clickOnLogout();//swagata
			dashboardPageInstance.clickondropdownforlogout();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	// arka

	/*
	 * @Test(groups = {"OrderTest123",
	 * "alternativePrintOrderSameProductSameColourSameMaterialID",
	 * "OrderDisplayOnlineTest","Grp4","RegressionLatest","Group1","DsplyReg1",
	 * "RerunD","RegFailed3","Group1F","NewRegression","G1"}, dataProviderClass
	 * = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider =
	 * "userData") public void
	 * alternativePrintOrderSameProductSameColourSameMaterialID(Map<String,
	 * String> userData) throws Exception { try { WebDriver driver =
	 * WebDriverManager.getDriver(); Logger.info("Webdriver is initiated");
	 * 
	 * TribuneUtils utilities = new TribuneUtils(); utilities.launchURL(driver,
	 * Configurator.getConfig().get("SignIn")); utilities.implementWait(driver);
	 * 
	 * SignInPage signinPageinstance = PageFactory.initElements(driver,
	 * SignInPage.class); signinPageinstance.login("success");
	 * 
	 * DashboardPage dashboardPageInstance = PageFactory.initElements(driver,
	 * DashboardPage.class); dashboardPageInstance.clickOnOrderEntryModule();
	 * 
	 * OrderEntryHomePage orderEntryPageInstance =
	 * PageFactory.initElements(driver, OrderEntryHomePage.class);
	 * orderEntryPageInstance.clickOnNewGeneralOrder();
	 * 
	 * NewOrderPage newOrderInstance = PageFactory.initElements(driver,
	 * NewOrderPage.class); newOrderInstance.selectSoldToCustomerBU("bu_LAT");
	 * newOrderInstance.enterSoldToCustomer("CU00059747");
	 * newOrderInstance.selectBilltoSameAsSoldTo();
	 * newOrderInstance.selectOrderType("OrderType_Standard");
	 * newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
	 * newOrderInstance.checkUncheckOwnLocalOptOut(false);
	 * newOrderInstance.createNewInsertion(); newOrderInstance.selectBU("1",84,
	 * 0); newOrderInstance.enterPubDate("1","20", "Dec", "2021");
	 * newOrderInstance.selectProductTypeByIndex("1",8);
	 * newOrderInstance.selectProduct("1",84, 2); Thread.sleep(2000); //
	 * newOrderInstance.selectAdType("1",39, 3);
	 * newOrderInstance.selectSection("1",84, 4); Thread.sleep(4000);
	 * newOrderInstance.viewInsertionDetails("1"); //
	 * newOrderInstance.clickOnInsertionSalesRepSection(1); //
	 * newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
	 * Thread.sleep(2000); newOrderInstance.selectColourForAnInsertion(1,"4C");
	 * Thread.sleep(4000); Thread.sleep(4000);
	 * newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
	 * newOrderInstance.clickOnPositionSelector(); Thread.sleep(12000); //
	 * newOrderInstance.selectAdSizeForPosition(); // Thread.sleep(5000);
	 * 
	 * // newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
	 * newOrderInstance.selectFirstPostionFrmPositionSlctr();
	 * newOrderInstance.savePositionSelection(); Thread.sleep(10000);
	 * newOrderInstance.viewInsertionDetails("1");
	 * newOrderInstance.createDuplicateInsertion("1"); Thread.sleep(4000);
	 * newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.addNewSalesRepOnInsertion2(2,
	 * "SA01380");Thread.sleep(4000);newOrderInstance.
	 * clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.applytoAllSalesRepOnInsertion2(2);Thread.sleep(2000);
	 * Thread.sleep(4000); Thread.sleep(4000); newOrderInstance.submitOrder();
	 * newOrderInstance.displayErrorMessageMultiple(1); //
	 * newOrderInstance.displayErrorMessageMultiple(2); // newOrderInstance.
	 * compareErrorMessageMultiple("Two or more insertion lines with the same Material ID have different ADSizes! These are lines 01-00 02-00"
	 * ,1); // newOrderInstance.
	 * compareErrorMessageMultiple("Two or more insertion lines with the same Material ID have different Colors! These are lines 01-00 02-00"
	 * ,2);
	 * 
	 * } catch (Exception e) { Logger.error(e.getMessage()); throw e; } }
	 */
	@Test(groups = { "arkadeep", "OrderTest123", "alternativePrintOrderSameProductSameColourSameMaterialID",
			"OrderDisplayOnlineTest", "Grp4", "RegressionLatest", "Group1", "DsplyReg1", "RerunD", "RegFailed3",
			"Group1F", "NewRegression", "G1",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void alternativePrintOrderSameProductSameColourSameMaterialID(Map<String, String> userData)
			throws Exception {
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
			newOrderInstance.checkUncheckOwnLocalOptOut(false);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 84, 0);
			newOrderInstance.enterPubDate("1", "20", "Dec", "2021");
			// newOrderInstance.selectProductTypeByIndex("1",8);payel
			newOrderInstance.selectProductType("1", 84, 1);// payel
			newOrderInstance.selectProduct("1", 84, 2);
			Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",39, 3);
			newOrderInstance.selectSection("1", 84, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(2000);
			newOrderInstance.selectColourForAnInsertion(1, "4C");
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.checkUncheckPosTemplateChckbx(1, true);
			newOrderInstance.clickOnPositionSelector();
			Thread.sleep(18000);
			// newOrderInstance.selectAdSizeForPosition();
			// Thread.sleep(5000);

			// newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
			newOrderInstance.selectFirstPostionFrmPositionSlctr();
			newOrderInstance.savePositionSelection();
			Thread.sleep(10000);
			newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(2000);

			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			// payel
			newOrderInstance.viewInsertionDetails("2");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckPosTemplateChckbx(2, false);
			Thread.sleep(4000);
			newOrderInstance.checkUncheckPosTemplateChckbx(2, true);
			Thread.sleep(4000);
			newOrderInstance.clickOnPositionSelctr(2);
			Thread.sleep(18000);
			newOrderInstance.selectsecondPostionFrmPositionSlctr();
			newOrderInstance.savePositionSelection();
			Thread.sleep(10000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(2);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			// newOrderInstance.displayErrorMessageMultiple(1);
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);

			dashboardPageInstance.clickOnLogout();
			// newOrderInstance.displayErrorMessageMultiple(2);
			// newOrderInstance.compareErrorMessageMultiple("Two or more
			// insertion lines with the same Material ID have different ADSizes!
			// These are lines 01-00 02-00",1);
			// newOrderInstance.compareErrorMessageMultiple("Two or more
			// insertion lines with the same Material ID have different Colors!
			// These are lines 01-00 02-00",2);

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "OrderTest123", "alternativePrintOrderSameProductDifferentColourSameMaterialID",
			"OrderDisplayOnlineTest", "Grp4", "RegressionLatest", "Group1", "DsplyReg1", "TestPriority", "RerunD",
			"RegFailed3",
			"Group1F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void alternativePrintOrderSameProductDifferentColourSameMaterialID(Map<String, String> userData)
			throws Exception {
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
			newOrderInstance.checkUncheckOwnLocalOptOut(false);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 85, 0);
			newOrderInstance.enterPubDate("1", "20", "Dec", "2021");
			Thread.sleep(4000);
			newOrderInstance.selectProductTypeByIndex("1", 8);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 85, 2);
			Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",37, 3);
			newOrderInstance.selectSection("1", 85, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(2000);
			newOrderInstance.selectColourForAnInsertion(1, "4C");
			Thread.sleep(4000);
			newOrderInstance.selectMaterialSource("1", "New Build");
			Thread.sleep(4000);
			Thread.sleep(4000);
			// newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			// newOrderInstance.clickOnPositionSelector();
			// Thread.sleep(12000);
			// newOrderInstance.selectAdSizeForPosition();
			// Thread.sleep(5000);

			// newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
			// newOrderInstance.selectFirstPostionFrmPositionSlctr();
			// newOrderInstance.savePositionSelection();
			// Thread.sleep(10000);
			// newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(2000);
			newOrderInstance.viewInsertionDetails("2");
			newOrderInstance.selectColourForAnInsertion(2, "B/W");
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion2(2);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			newOrderInstance.displayErrorMessageMultiple(1);
			// newOrderInstance.displayErrorMessageMultiple(2);
			// newOrderInstance.compareErrorMessageMultiple("Two or more
			// insertion lines with the same Material ID have different ADSizes!
			// These are lines 01-00 02-00",1);
			newOrderInstance.compareErrorMessageMultiple(
					"Two or more insertion lines with the same Material ID have different Colors! These are lines 01-00 02-00",
					1);

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "OrderTest123", "NovMaintenance","alternativePrintOrderDifferentProductSameColourSameMaterialID",
			"OrderDisplayOnlineTest", "Grp4", "RegressionLatest", "Group1", "DsplyReg1", "RerunD", "RegFailed3",
			"Group1F", "NewRegression2", "NewRegression", "G1", "RerunF2",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void alternativePrintOrderDifferentProductSameColourSameMaterialID(Map<String, String> userData)
			throws Exception {
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
			newOrderInstance.checkUncheckOwnLocalOptOut(false);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 84, 0);
			newOrderInstance.enterPubDateFromExcel("1",17,27);//swagata
			Thread.sleep(4000);
			newOrderInstance.selectProductTypeByValue("1", "Alternative Print");
			newOrderInstance.selectProduct("1", 84, 2);
			Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",37, 3);
			newOrderInstance.selectSection("1", 84, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(2000);
			newOrderInstance.selectColourForAnInsertion(1, "B/W");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckPosTemplateChckbx(1, true);
			newOrderInstance.clickOnPositionSelector();
			Thread.sleep(12000);
			// newOrderInstance.selectAdSizeForPosition();
			// Thread.sleep(5000);
			// newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
			newOrderInstance.selectFirstPostionFrmPositionSlctr();
			newOrderInstance.savePositionSelection();
			Thread.sleep(10000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("2", 17, 1);//arka
			// newOrderInstance.selectProduct("1",17, 2);
			Thread.sleep(2000);
			newOrderInstance.collapseInsertionDetails("2");//swagata
			// newOrderInstance.selectAdType("1",17, 3);
			// newOrderInstance.selectSection("1",17, 4);
			// Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			// newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			/*
			 * Thread.sleep(2000); Thread.sleep(4000); Thread.sleep(4000);
			 *///swagata
			newOrderInstance.submitOrder();
		//	newOrderInstance.clickNoLegacyAutoInsertionCreation();//swagata
			// newOrderInstance.displayErrorMessageMultiple(1);
			// newOrderInstance.displayErrorMessageMultiple(2);
			// newOrderInstance.compareErrorMessageMultiple("Two or more
			// insertion lines with the same Material ID have different ADSizes!
			// These are lines 01-00 02-00",1);
			// newOrderInstance.compareErrorMessageMultiple("Two or more
			// insertion lines with the same Material ID have different Colors!
			// These are lines 01-00 02-00",2);
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);

			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "OrderTest123", "alternativePrintOrderDifferentProductDifferentColourSameMaterialID",
			"OrderDisplayOnlineTest", "Grp4", "RegressionLatest", "Group1", "DsplyReg1", "RerunD", "RegFailed3",
			"Group1F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void alternativePrintOrderDifferentProductDifferentColourSameMaterialID(Map<String, String> userData)
			throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_SSC");
			newOrderInstance.enterSoldToCustomer("CU00117844");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 39, 0);
			newOrderInstance.enterPubDate("1", "20", "Dec", "2021");
			Thread.sleep(4000);
			newOrderInstance.selectProductTypeByIndex("1", 8);
			newOrderInstance.selectProduct("1", 84, 2);
			Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",37, 3);
			newOrderInstance.selectSection("1", 84, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(2000);
			newOrderInstance.selectColourForAnInsertion(1, "B/W");
			Thread.sleep(4000);
			newOrderInstance.selectMaterialSource("1", "New Build");
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.checkUncheckPosTemplateChckbx(1, true);
			newOrderInstance.clickOnPositionSelector();
			Thread.sleep(12000);
			// newOrderInstance.selectAdSizeForPosition();
			// Thread.sleep(5000);

			// newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
			newOrderInstance.selectFirstPostionFrmPositionSlctr();
			newOrderInstance.savePositionSelection();
			Thread.sleep(10000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("2", 17, 1);
			// newOrderInstance.selectProduct("1",17, 2);
			Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",17, 3);
			// newOrderInstance.selectSection("1",17, 4);
			// Thread.sleep(2000);
			Thread.sleep(2000);
			newOrderInstance.selectColourForAnInsertion(2, "4C");
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("2");
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion2(2);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			newOrderInstance.displayErrorMessageMultiple(1);
			// newOrderInstance.displayErrorMessageMultiple(2);
			// newOrderInstance.compareErrorMessageMultiple("Two or more
			// insertion lines with the same Material ID have different ADSizes!
			// These are lines 01-00 02-00",1);
			newOrderInstance.compareErrorMessageMultiple(
					"Two or more insertion lines with the same Material ID have different Colors! These are lines 01-00 02-00",
					1);

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "SMaintenance","Order", "displayOrderUpdateSalesPrice", "Grp4", "RegressionLatest", "PrioritizedReg2", "Group1",
			"DsplyReg1", "TestPriority", "PriorityVulnerability", "NewRegression2", "NewRegression", "G1",
			"RerunF2" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderUpdateSalesPrice(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_SSC");
			newOrderInstance.enterSoldToCustomer("CU00117844");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 40, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 40, 1);
			// newOrderInstance.selectProduct("1",40, 2);
			// Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",40, 3);
			// newOrderInstance.selectSection("1",40, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.editSalesPrice("7",1);
			Thread.sleep(4000);
			newOrderInstance.checkUncheckSalesPrice(1, false);
			Thread.sleep(4000);
			double salesPrice = newOrderInstance.getInsertionPrice("1", "sales");
			Logger.info("Sales Price: " + salesPrice);
			double priceAfterEdit = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("Total Price: " + priceAfterEdit);
			Assert.assertEquals(salesPrice, priceAfterEdit);

			newOrderInstance.checkUncheckSalesPrice(1, true);
			Thread.sleep(4000);
			newOrderInstance.editSalesPrice("0",1);
			Thread.sleep(4000);
			newOrderInstance.checkUncheckSalesPrice(1, false);
			Thread.sleep(4000);
			double salesPrice1 = newOrderInstance.getInsertionPrice("1", "sales");
			Logger.info("Sales Price: " + salesPrice1);
			double priceAfterEdit1 = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("Total Price: " + priceAfterEdit1);
			Assert.assertEquals(salesPrice1, priceAfterEdit1);

			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			double priceAfterEdit2 = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("Total Price: " + priceAfterEdit2);

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order",
			"displayOrderVerifyPickUpWindow" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderVerifyPickUpWindow(Map<String, String> userData) throws Exception {
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
			newOrderInstance.enterSoldToCustomer("CU00141546");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 41, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 41, 1);
			// newOrderInstance.selectProduct("1",40, 2);
			// Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",40, 3);
			// newOrderInstance.selectSection("1",40, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectMaterialSource1("Pickup w/Changes");
			Thread.sleep(4000);
			newOrderInstance.clickOnPickUpSearch();
			Thread.sleep(4000);

			newOrderInstance.enterFromDatePickUpWndw("1", "Jan", "2021");
			Thread.sleep(4000);
			newOrderInstance.enterFromDatePickUpWndw("21", "Dec", "2021");
			Thread.sleep(4000);

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderVerifyColumnHeaders", "Grp4", "DsplyReg1", "RerunD",
			"Group1F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderVerifyColumnHeaders(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_SSC");
			newOrderInstance.enterSoldToCustomer("CU00117844");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 40, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 40, 1);
			// newOrderInstance.selectProduct("1",40, 2);
			// Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",40, 3);
			// newOrderInstance.selectSection("1",40, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.createDuplicateInsertion("1");

			// newOrderInstance.selectProduct("1",40, 2);
			// Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",40, 3);
			// newOrderInstance.selectSection("1",40, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("2");
			Thread.sleep(4000);
			newOrderInstance.createDuplicateInsertion("2");

			// newOrderInstance.selectProduct("1",40, 2);
			// Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",40, 3);
			// newOrderInstance.selectSection("1",40, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("3");
			Thread.sleep(4000);
			newOrderInstance.createDuplicateInsertion("3");

			// newOrderInstance.selectProduct("1",40, 2);
			// Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",40, 3);
			// newOrderInstance.selectSection("1",40, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("4");
			Thread.sleep(4000);
			WebElement insertion = driver.findElement(By
					.xpath("//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/div/div/table/thead/tr/th[2]"));
			Logger.info("" + insertion.getText());
			Assert.assertEquals(insertion.getText(), "Insertion");
			WebElement bu = driver.findElement(By
					.xpath("//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/div/div/table/thead/tr/th[4]"));
			Logger.info("" + bu.getText());
			Assert.assertEquals(bu.getText(), "BU");
			WebElement pubdate = driver.findElement(By
					.xpath("//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/div/div/table/thead/tr/th[5]"));
			Logger.info("" + pubdate.getText());
			Assert.assertEquals(pubdate.getText(), "PubDate");
			WebElement producttype = driver.findElement(By
					.xpath("//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/div/div/table/thead/tr/th[6]"));
			Logger.info("" + producttype.getText());
			Assert.assertEquals(producttype.getText(), "Product Type");
			WebElement product = driver.findElement(By
					.xpath("//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/div/div/table/thead/tr/th[7]"));
			Logger.info("" + product.getText());
			Assert.assertEquals(product.getText(), "Product");
			WebElement AdType = driver.findElement(By
					.xpath("//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/div/div/table/thead/tr/th[8]"));
			Logger.info("" + AdType.getText());
			Assert.assertEquals(AdType.getText(), "AdType");
			WebElement Salesrep = driver.findElement(By
					.xpath("//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/div/div/table/thead/tr/th[9]"));
			Logger.info("" + Salesrep.getText());
			Assert.assertEquals(Salesrep.getText(), "Section");
			WebElement Section = driver.findElement(By
					.xpath("//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/div/div/table/thead/tr/th[10]"));
			Logger.info("" + Section.getText());
			Assert.assertEquals(Section.getText(), "Subsection");
			WebElement Price = driver.findElement(By
					.xpath("//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/div/div/table/thead/tr/th[11]"));
			Logger.info("" + Price.getText());
			Assert.assertEquals(Price.getText(), "Salesrep");
			WebElement Version = driver.findElement(By
					.xpath("//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/div/div/table/thead/tr/th[12]"));
			Logger.info("" + Version.getText());
			Assert.assertEquals(Version.getText(), "Price");
			WebElement Material = driver.findElement(By
					.xpath("//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/div/div/table/thead/tr/th[13]"));
			Logger.info("" + Material.getText());
			Assert.assertEquals(Material.getText(), "Version");
			WebElement Proof = driver.findElement(By
					.xpath("//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/div/div/table/thead/tr/th[14]"));
			Logger.info("" + Proof.getText());
			Assert.assertEquals(Proof.getText(), "Material Id");
			WebElement Class = driver.findElement(By
					.xpath("//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/div/div/table/thead/tr/th[15]"));
			Logger.info("" + Class.getText());
			Assert.assertEquals(Class.getText(), "Proof Type");
			WebElement Status = driver.findElement(By
					.xpath("//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/div/div/table/thead/tr/th[16]"));
			Logger.info("" + Status.getText());
			Assert.assertEquals(Status.getText(), "Class Code");
			WebElement MM = driver.findElement(By
					.xpath("//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/div/div/table/thead/tr/th[17]"));
			Logger.info("" + MM.getText());
			Assert.assertEquals(MM.getText(), "Status");
			WebElement MM1 = driver.findElement(By
					.xpath("//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/div/div/table/thead/tr/th[18]"));
			Logger.info("" + MM1.getText());
			Assert.assertEquals(MM1.getText(), "MM Tag");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderReservation", "Grp4", "PrioritizedReg2", "RegressionLatest", "Group1",
			"DsplyReg1", "TestPriority", "PriorityDFP", "PriorityVulnerability", "NewRegression2", "NewRegression",
			"G1", "RerunF2",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void displayOrderReservation(Map<String, String> userData) throws Exception {
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
			orderEntryPageInstance.clickOnNewReservation();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);
			newOrderInstance.enterPubDateFromExcel("1",90,27);//swagata
			newOrderInstance.selectProductType("1", 17, 1);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 17, 3);
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
//			
			newOrderInstance.submitReservation();
			Thread.sleep(1000);
			newOrderInstance.clickOnContinuePastPubDate(); //joy
			Thread.sleep(3000);
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderQuote", "Grp4", "RegressionLatest", "Group1", "DsplyReg1", "DsplyReg1",
			"TestPriority", "PriorityDFP",
			"PriorityVulnerability" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderQuote(Map<String, String> userData) throws Exception {
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
			orderEntryPageInstance.clickOnNewQuote();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);
			newOrderInstance.enterPubDate("1", "27", "Dec", "2021");
			newOrderInstance.selectProductType("1", 17, 1);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 17, 3);
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(5000);
			newOrderInstance.saveOrder();
			Thread.sleep(3000);
			newOrderInstance.verifyConvertToReservationButtonDisplayed();
			newOrderInstance.verifyConvertToOrderButtonDisplayed();
			Logger.info("Saved Order# : " + newOrderInstance.getOrderNo());

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderMultipleInsertionKill",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderMultipleInsertionKill(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			newOrderInstance.selectProductType("1", 17, 1);
			// newOrderInstance.selectProduct("1",37, 2);
			Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",37, 3);
			// newOrderInstance.selectSection("1",37, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(2000);
			// newOrderInstance.selectColourForAnInsertion(1,"B/W");
			Thread.sleep(4000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 17, 1);
			newOrderInstance.enterPubDate("2", "21", "Dec", "2021");
			// newOrderInstance.selectProduct("1",17, 2);
			Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",17, 3);
			// newOrderInstance.selectSection("1",17, 4);
			// Thread.sleep(2000);

			// newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1,
			// "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			// newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
			// Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion2(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(2000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order ID: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(3000);

			WebDriverWait wait = new WebDriverWait(driver, 120);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(10000);
			newOrderInstance.selectAllInsertions();
			Thread.sleep(2000);
			newOrderInstance.killAllInsertion();
			// newOrderInstance.selectColourForAnInsertion(1,"4C");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			// Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1,
			// "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			// newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);Thread.sleep(4000);newOrderInstance.submitOrder();
			Thread.sleep(2000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(6000);
			Logger.info(newOrderInstance.getOrdeStatusOrderViewPage() + " is order status");
			Logger.info(newOrderInstance.getInsertionStatus("1") + " is insertion 1 status");
			Logger.info(newOrderInstance.getInsertionStatus("2") + " is insertion 2 status");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderMultipleInsertionAssignMaterial", "OrderDisplayOnlineTest", "Grp4",
			"RegressionLatest", "Group1",
			"RerunD" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderMultipleInsertionAssignMaterial(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			newOrderInstance.selectProductType("1", 17, 1);
			// newOrderInstance.selectProduct("1",37, 2);
			Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",37, 3);
			// newOrderInstance.selectSection("1",37, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(2000);
			// newOrderInstance.selectColourForAnInsertion(1,"B/W");
			Thread.sleep(4000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 17, 1);
			newOrderInstance.enterPubDate("2", "21", "Dec", "2021");
			// newOrderInstance.selectProduct("1",17, 2);
			Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",17, 3);
			// newOrderInstance.selectSection("1",17, 4);
			// Thread.sleep(2000);

			newOrderInstance.selectAllInsertions();
			Thread.sleep(2000);
			newOrderInstance.assignMaterialAllInsertion();
			Assert.assertEquals(newOrderInstance.getMaterialID("1"), "2");
			Assert.assertEquals(newOrderInstance.getMaterialID("2"), "2");
			// newOrderInstance.selectColourForAnInsertion(1,"4C");
			Thread.sleep(4000);
			// Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1,
			// "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			// newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);Thread.sleep(4000);
			// newOrderInstance.submitOrder();
			// Thread.sleep(1000);
			// String orderID = orderEntryPageInstance.getOrderID();
			// Logger.info("Order ID: "+orderID);
			// orderEntryPageInstance.clickOnOrder(orderID);
			// Thread.sleep(6000);
			// Logger.info(newOrderInstance.getOrdeStatusOrderViewPage()+" is
			// order status");
			// Logger.info(newOrderInstance.getInsertionStatus("1")+" is
			// insertion 1 material id");
			// Logger.info(newOrderInstance.getInsertionStatus("2")+" is
			// insertion 2 material id");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderMultipleInsertionDelete", "OrderDisplayOnlineTest", "Grp4",
			"RegressionLatest", "Group1",
			"RerunD" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderMultipleInsertionDelete(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			newOrderInstance.selectProductType("1", 17, 1);
			// newOrderInstance.selectProduct("1",37, 2);
			Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",37, 3);
			// newOrderInstance.selectSection("1",37, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(2000);
			// newOrderInstance.selectColourForAnInsertion(1,"B/W");
			Thread.sleep(4000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 17, 1);
			newOrderInstance.enterPubDate("2", "21", "Dec", "2021");
			// newOrderInstance.selectProduct("1",17, 2);
			Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",17, 3);
			// newOrderInstance.selectSection("1",17, 4);
			// Thread.sleep(2000);

			// newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1,
			// "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			// newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.selectAllInsertions();
			Thread.sleep(2000);
			newOrderInstance.deleteAllInsertion();
			Thread.sleep(2000);
			int insertionCount = newOrderInstance.getInsertionsCount();
			Logger.info("No. Of Insertions: " + insertionCount);
			Assert.assertEquals(insertionCount, 0);

			Logger.info("All insertions deleted");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderSameProductSameAdSizeVerify", "OrderDisplayOnlineTest", "Grp4",
			"RegressionLatest", "Group1", "DsplyReg12", "RerunD", "Group1F", "NewRegression2", "NewRegression", "G1",
			"RerunF2",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderSameProductSameAdSizeVerify(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(2000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 38, 0);
			Thread.sleep(3000);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			// newOrderInstance.selectProductType("1",41, 1);
			// newOrderInstance.selectProduct("1",41, 2);
			Thread.sleep(3000);
			// newOrderInstance.selectAdType("1",41, 3);
			// newOrderInstance.selectSection("1",41, 4);
			/// Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");

			Thread.sleep(2000);
			newOrderInstance.selectAdSize(1, "1/9  (2 x 7)");
			Thread.sleep(4000);
			String adSize1 = newOrderInstance.getAdSize(1);
			Thread.sleep(4000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("2", "21", "Dec", "2021");
			Thread.sleep(4000);
			String adSize = newOrderInstance.getAdSize(2);
			Thread.sleep(2000);
			Assert.assertEquals(adSize, adSize1);
			Thread.sleep(2000);
			newOrderInstance.saveOrder();
			Thread.sleep(3000);
			Logger.info("Saved Order# : " + newOrderInstance.getOrderNo());
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(2);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			// Logger.info("Colour of insertion is
			// :"+newOrderInstance.getValueofSelectedColourOption(1));
			// Assert.assertEquals(newOrderInstance.getValueofSelectedColourOption(1),
			// "4C");
			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	// arka
	/*
	 * @Test(groups =
	 * {"Order","displayOrderSameProductDifferentAdSizeSameMaterialID",
	 * "OrderDisplayOnlineTest","Grp4","DsplyReg1","RerunD","Group1F",
	 * "NewRegression","G1","RerunF2"}, dataProviderClass =
	 * com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider =
	 * "userData") public void
	 * displayOrderSameProductDifferentAdSizeSameMaterialID(Map<String, String>
	 * userData) throws Exception { try { WebDriver driver =
	 * WebDriverManager.getDriver(); Logger.info("Webdriver is initiated");
	 * 
	 * TribuneUtils utilities = new TribuneUtils(); utilities.launchURL(driver,
	 * Configurator.getConfig().get("SignIn")); utilities.implementWait(driver);
	 * 
	 * SignInPage signinPageinstance = PageFactory.initElements(driver,
	 * SignInPage.class); signinPageinstance.login("success");
	 * 
	 * DashboardPage dashboardPageInstance = PageFactory.initElements(driver,
	 * DashboardPage.class); dashboardPageInstance.clickOnOrderEntryModule();
	 * 
	 * OrderEntryHomePage orderEntryPageInstance =
	 * PageFactory.initElements(driver, OrderEntryHomePage.class);
	 * orderEntryPageInstance.clickOnNewGeneralOrder();
	 * 
	 * NewOrderPage newOrderInstance = PageFactory.initElements(driver,
	 * NewOrderPage.class); newOrderInstance.selectSoldToCustomerBU("bu_CTC");
	 * newOrderInstance.enterSoldToCustomer("CU00037236");
	 * newOrderInstance.selectBilltoSameAsSoldTo();
	 * newOrderInstance.selectOrderType("OrderType_Standard");
	 * newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
	 * Thread.sleep(2000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
	 * newOrderInstance.createNewInsertion(); newOrderInstance.selectBU("1",41,
	 * 0); newOrderInstance.enterPubDate("1","22", "Dec", "2021"); //
	 * newOrderInstance.selectProductType("1",41, 1); //
	 * newOrderInstance.selectProduct("1",41, 2); Thread.sleep(2000); //
	 * newOrderInstance.selectAdType("1",41, 3); //
	 * newOrderInstance.selectSection("1",41, 4); /// Thread.sleep(4000);
	 * newOrderInstance.viewInsertionDetails("1"); //
	 * newOrderInstance.clickOnInsertionSalesRepSection(1); //
	 * newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
	 * Thread.sleep(2000); newOrderInstance.selectAdSize(1,"1/63  (1 x 2)");
	 * Thread.sleep(4000); newOrderInstance.createDuplicateInsertion("1");
	 * Thread.sleep(4000); // newOrderInstance.enterPubDate("2","21", "Dec",
	 * "2021"); // Thread.sleep(4000);
	 * newOrderInstance.selectAdSize(1,"1/126  (1 x 1)");
	 * 
	 * Thread.sleep(6000); newOrderInstance.saveOrder(); Thread.sleep(3000);
	 * Logger.info("Saved Order# : "+newOrderInstance.getOrderNo() );
	 * Thread.sleep(3000);
	 * newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.addNewSalesRepOnInsertion(2,
	 * "SA01380");Thread.sleep(4000);newOrderInstance.
	 * clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.applytoAllSalesRepOnInsertion(2);Thread.sleep(2000);
	 * Thread.sleep(4000); Thread.sleep(4000); newOrderInstance.submitOrder();
	 * newOrderInstance.displayErrorMessage(); newOrderInstance.
	 * compareErrorMessage("Two or more insertion lines with the same Material ID have different ADSizes! These are lines 01-00 02-00"
	 * );
	 * 
	 * } catch (Exception e) { Logger.error(e.getMessage()); throw e; } }
	 */

	@Test(groups = { "arkadeep", "Order", "displayOrderSameProductDifferentAdSizeSameMaterialID", "PrioritizedReg2",
			"OrderDisplayOnlineTest", "Grp4", "DsplyReg1", "RerunD", "Group1F", "NewRegression2", "NewRegression", "G1",
			"RerunF2",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderSameProductDifferentAdSizeSameMaterialID(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(2000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 41, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1", 41, 27);//swagata
			Thread.sleep(4000);
			 newOrderInstance.selectProductType("1",41, 1);//swagata
				Thread.sleep(6000);
			// newOrderInstance.selectProduct("1",41, 2);
			Thread.sleep(4000);
			 newOrderInstance.selectAdType("1",41, 3);//swagata
				Thread.sleep(4000);
			 newOrderInstance.selectSection("1",41, 4);//swagata
			/// Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(2000);
			newOrderInstance.selectAdSize(1, "1/63  (1 x 2)");
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("2");//swagata
			// newOrderInstance.enterPubDate("2","21", "Dec", "2021");
			// Thread.sleep(4000);
			// newOrderInstance.selectAdSize(1,"1/126 (1 x 1)"); payel
			newOrderInstance.selectAdSize(2, "1/126  (1 x 1)"); // payel
			Thread.sleep(6000);
			/*newOrderInstance.saveOrder();
			Thread.sleep(3000);
			Logger.info("Saved Order# : " + newOrderInstance.getOrderNo());
			Thread.sleep(3000);*///swagata
			newOrderInstance.collapseInsertionDetails("2");//swagata
			Thread.sleep(6000);
			/*newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");//swagata
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);*/
		/*	Thread.sleep(4000);
			Thread.sleep(4000);*///swagata
			newOrderInstance.submitOrder();
			newOrderInstance.displayErrorMessage();
			newOrderInstance.compareErrorMessage(
					"Two or more insertion lines with the same Material ID have different ADSizes! These are lines 01-00 02-00");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	// arka
	/*
	 * @Test(groups =
	 * {"Order","displayOrderColourRevertNewInsertion","OrderDisplayOnlineTest",
	 * "Grp4","RegressionLatest","Group1","RerunD","RegFailed3","Group1F",
	 * "NewRegression","G1","RerunF2"}, dataProviderClass =
	 * com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider =
	 * "userData") public void displayOrderColourRevertNewInsertion(Map<String,
	 * String> userData) throws Exception { try { WebDriver driver =
	 * WebDriverManager.getDriver(); Logger.info("Webdriver is initiated");
	 * 
	 * TribuneUtils utilities = new TribuneUtils(); utilities.launchURL(driver,
	 * Configurator.getConfig().get("SignIn")); utilities.implementWait(driver);
	 * 
	 * SignInPage signinPageinstance = PageFactory.initElements(driver,
	 * SignInPage.class); signinPageinstance.login("success");
	 * 
	 * DashboardPage dashboardPageInstance = PageFactory.initElements(driver,
	 * DashboardPage.class); dashboardPageInstance.clickOnOrderEntryModule();
	 * 
	 * OrderEntryHomePage orderEntryPageInstance =
	 * PageFactory.initElements(driver, OrderEntryHomePage.class);
	 * orderEntryPageInstance.clickOnNewGeneralOrder();
	 * 
	 * NewOrderPage newOrderInstance = PageFactory.initElements(driver,
	 * NewOrderPage.class); newOrderInstance.selectSoldToCustomerBU("bu_LAT");
	 * newOrderInstance.enterSoldToCustomer("CU00059747"); //
	 * newOrderInstance.enterSoldToCustomer("CA11004600");
	 * newOrderInstance.selectBilltoSameAsSoldTo();
	 * newOrderInstance.selectOrderType("OrderType_Standard");
	 * newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
	 * newOrderInstance.checkUncheckOwnLocalOptOut(false);
	 * newOrderInstance.createNewInsertion(); newOrderInstance.selectBU("1",12,
	 * 0); newOrderInstance.enterPubDate("1","22", "Dec", "2021");
	 * newOrderInstance.selectProductType("1",12, 1);
	 * newOrderInstance.selectProduct("1",12, 2); Thread.sleep(2000);
	 * newOrderInstance.selectAdType("1",12, 3);
	 * newOrderInstance.selectSection("1",12, 4); Thread.sleep(4000);
	 * newOrderInstance.viewInsertionDetails("1"); //
	 * newOrderInstance.clickOnInsertionSalesRepSection(1); //
	 * newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856"); //
	 * Thread.sleep(2000); newOrderInstance.selectColourForAnInsertion(1,"4C");
	 * Thread.sleep(4000); double addOnCharge1 =
	 * newOrderInstance.getInsertionPrice("1", "addon charge");
	 * Logger.info("Add on Charge for 1st insertion with 4C colour: "
	 * +addOnCharge1); newOrderInstance.createDuplicateInsertion("1");
	 * Thread.sleep(4000); newOrderInstance.enterPubDate("2","21", "Dec",
	 * "2021"); Thread.sleep(4000); newOrderInstance.viewInsertionDetails("2");
	 * double addOnCharge2 = newOrderInstance.getInsertionPrice("2",
	 * "addon charge");
	 * Logger.info("Add on Charge for duplicate insertion with B/W colour: "
	 * +addOnCharge2); Assert.assertEquals(addOnCharge1, addOnCharge2);
	 * Thread.sleep(4000); newOrderInstance.createNewInsertion();
	 * newOrderInstance.selectBU("3",12, 0);
	 * newOrderInstance.enterPubDate("3","22", "Dec", "2021");
	 * Thread.sleep(4000); newOrderInstance.selectProductType("3",12, 1);
	 * newOrderInstance.selectProduct("3",12, 2);
	 * newOrderInstance.viewInsertionDetails("3"); Thread.sleep(14000); double
	 * addOnCharge3 = newOrderInstance.getInsertionPrice("3", "addon charge");
	 * Logger.info("Add on Charge for new 3rd insertion with default colour: "
	 * +addOnCharge3); Assert.assertNotEquals(addOnCharge3, addOnCharge1,
	 * "Not matching as expected"); Thread.sleep(4000);
	 * 
	 * } catch (Exception e) { Logger.error(e.getMessage()); throw e; } }
	 */
	@Test(groups = { "arkadeep", "Order", "displayOrderColourRevertNewInsertion", "PrioritizedReg2",
			"OrderDisplayOnlineTest", "Grp4", "RegressionLatest", "Group1", "RerunD", "RegFailed3", "Group1F",
			"NewRegression2", "NewRegression", "G1", "RerunF2",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void displayOrderColourRevertNewInsertion(Map<String, String> userData) throws Exception {
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
			Thread.sleep(2000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			newOrderInstance.selectProductType("1", 17, 1);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",12, 3);payel
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			// payel
			String colorvalue = newOrderInstance.getColourForAnInsertion(1);
			Thread.sleep(4000);
			Assert.assertEquals("B/W", colorvalue);
			Logger.info("Comparable pass");
			Thread.sleep(4000);
			// payel
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			// Thread.sleep(2000);

			newOrderInstance.selectNontemplatepositionForAnInsertion(1, "Obits");
			Thread.sleep(4000);
			String colorvalue1 = newOrderInstance.getColourForAnInsertion(1);
			Thread.sleep(4000);
			Assert.assertEquals("B/W", colorvalue1);
			Logger.info("Comparable pass");
			newOrderInstance.selectNontemplatepositionForAnInsertion(1, "Not-specified");
			Thread.sleep(9000);
			// payel
			newOrderInstance.selectColourForAnInsertion(1, "4C");
			Thread.sleep(4000);
newOrderInstance.collapseInsertionDetails("1");//swagata
			// double addOnCharge1 = newOrderInstance.getInsertionPrice("1",
			// "addon charge");
			// Logger.info("Add on Charge for 1st insertion with 4C colour:
			// "+addOnCharge1);
			// payel
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("2", "21", "Dec", "2021");
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("2");
			// payel
			String colorvalue2 = newOrderInstance.getColourForAnInsertion(2);
			Thread.sleep(4000);
			Assert.assertEquals("4C", colorvalue2);
			Logger.info("Comparable pass");
			newOrderInstance.collapseInsertionDetails("2");//swagata
			// double addOnCharge2 = newOrderInstance.getInsertionPrice("2",
			// "addon charge");
			// Logger.info("Add on Charge for duplicate insertion with B/W
			// colour: "+addOnCharge2);
			// Assert.assertEquals(addOnCharge1, addOnCharge2);
			// payel
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("3", 17, 0);
			newOrderInstance.enterPubDate("3", "22", "Dec", "2021");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("3", 17, 1);
			newOrderInstance.selectProduct("3", 17, 2);
			newOrderInstance.viewInsertionDetails("3");
			Thread.sleep(4000);
			// payel
			String colorvalue3 = newOrderInstance.getColourForAnInsertion(3);
			Thread.sleep(4000);
			Assert.assertEquals("B/W", colorvalue3);
			Logger.info("Comparable pass");
			newOrderInstance.collapseInsertionDetails("3");//swagata
			// double addOnCharge3 = newOrderInstance.getInsertionPrice("3",
			// "addon charge");
			// Logger.info("Add on Charge for new 3rd insertion with default
			// colour: "+addOnCharge3);
			// Assert.assertNotEquals(addOnCharge3, addOnCharge1, "Not matching
			// as expected");
			// payel
			Thread.sleep(4000);
			// payel
			newOrderInstance.createDuplicateInsertion("3");
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("4", "21", "Dec", "2021");
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("4");
			// --payel
			String colorvalue4 = newOrderInstance.getColourForAnInsertion(4);
			Thread.sleep(4000);
			Assert.assertEquals("B/W", colorvalue4);
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("4");//swagata
			Logger.info("Pass");
			// --payel

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderModifyAddOnPercentage", "OrderDisplayOnlineTest", "Grp4", "RegressionLatest",
			"Group1",
			"Group1F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderModifyAddOnPercentage(Map<String, String> userData) throws Exception {
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
			newOrderInstance.checkUncheckOwnLocalOptOut(false);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 12, 0);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			newOrderInstance.selectProductType("1", 12, 1);
			newOrderInstance.selectProduct("1", 12, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 12, 3);
			newOrderInstance.selectSection("1", 12, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");

			newOrderInstance.selectColourForAnInsertion(1, "4C");
			Thread.sleep(4000);
			double addOnCharge1 = newOrderInstance.getInsertionPrice("1", "addon charge");
			Logger.info("Add on Charge for 1st insertion with 4C colour: " + addOnCharge1);
			double salesPrice = newOrderInstance.getInsertionPrice("1", "sales");
			Logger.info("Sales Price: " + salesPrice);
			Thread.sleep(4000);
			newOrderInstance.checkUncheckSalesPrice(1, false);

			newOrderInstance.clickOnAddOnMagnifier();
			Thread.sleep(4000);
			newOrderInstance.verifyFeesRemoveButtonDisplayed();
			Thread.sleep(4000);
			newOrderInstance.editFeesPercentage("9");
			Thread.sleep(4000);
			String feesAmount = newOrderInstance.getFeesAmount();
			Assert.assertEquals(feesAmount, "$2,072.38");
			newOrderInstance.clickOnConfirmFeesButton();
			Thread.sleep(4000);
			double addOnCharge2 = newOrderInstance.getInsertionPrice("1", "addon charge");
			Logger.info(
					"Add on Charge for 1st insertion with 4C colour after updating fees percentage:" + addOnCharge2);
			Thread.sleep(4000);
			// Assert.assertEquals(addOnCharge2, "2590.48");
			Assert.assertNotEquals(addOnCharge1, addOnCharge2);
			/*
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(
			 * 4000);newOrderInstance.addNewSalesRepOnInsertion(1,
			 * "SA01380");Thread.sleep(4000);newOrderInstance.
			 * clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			 * newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(
			 * 2000);Thread.sleep(4000); // Thread.sleep(4000); //
			 * Thread.sleep(4000);newOrderInstance.
			 * clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			 * newOrderInstance.addNewSalesRepOnInsertion(1,
			 * "SA01380");Thread.sleep(4000);newOrderInstance.
			 * clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			 * newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(
			 * 2000);Thread.sleep(4000);Thread.sleep(4000);
			 * newOrderInstance.submitOrder();
			 * 
			 * Thread.sleep(1000);
			 * Logger.info(orderEntryPageInstance.getOrderID());
			 * orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			 * Thread.sleep(1000); String orderID =
			 * orderEntryPageInstance.getOrderNumber();
			 * orderEntryPageInstance.clickOnOrder(orderID); Thread.sleep(3000);
			 */
			// Logger.info("Colour of insertion is
			// :"+newOrderInstance.getValueofSelectedColourOption(1));
			// Assert.assertEquals(newOrderInstance.getValueofSelectedColourOption(1),
			// "4C");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "SMaintenance","Order", "displayOrderRemoveAddOnFees", "OrderDisplayOnlineTest", "PrioritizedReg2", "Grp4",
			"RegressionLatest", "Group1", "TestPriority", "PriorityDFP", "NewRegression2", "NewRegression", "G1",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void displayOrderRemoveAddOnFees(Map<String, String> userData) throws Exception {
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
			newOrderInstance.enterPubDateFromExcel("1", 17, 27);//swagata
//			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");//swagata
			newOrderInstance.selectProductType("1", 12, 1);
			newOrderInstance.selectProduct("1", 12, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 12, 3);
			newOrderInstance.selectSection("1", 12, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");

			Thread.sleep(2000);
//			newOrderInstance.selectColourForAnInsertion(1, "4C");
//			Thread.sleep(4000);
			newOrderInstance.clickOnAddOnMagnifier();
			Thread.sleep(4000);
			newOrderInstance.clickFirstFeesAddButton();
			Thread.sleep(4000);
			newOrderInstance.clickOnConfirmFeesButton();
			Thread.sleep(4000);
			//double addOnCharge1 = newOrderInstance.getInsertionPrice("1", "addon charge");
			//Logger.info("Add on Charge for 1st insertion with 4C colour: " + addOnCharge1);
			//double salesPrice = newOrderInstance.getInsertionPrice("1", "sales");
			//Logger.info("Sales Price: " + salesPrice);
			Thread.sleep(4000);
			newOrderInstance.checkUncheckSalesPrice(1, false);
			Thread.sleep(4000);
			newOrderInstance.clickOnAddOnMagnifier();
			Thread.sleep(4000);
			newOrderInstance.clickFeesRemoveButton();
			Thread.sleep(4000);
			newOrderInstance.clickOnConfirmFeesButton();
			Thread.sleep(1000);
			//double addOnCharge2 = newOrderInstance.getInsertionPrice("1", "addon charge");
			//Logger.info(
					//"Add on Charge for 1st insertion with 4C colour after updating fees percentage:" + addOnCharge2);
			//Thread.sleep(4000);
			//Assert.assertNotEquals(addOnCharge1, addOnCharge2);
			dashboardPageInstance.clickOnLogout();//swagata
			//newOrderInstance.displayWarningMessageConfirm();//swagata
			
			
			

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderSaveCopyHistory", "OrderDisplayOnlineTest", "Grp4", "RegressionLatest",
			"Group1", "DsplyReg12", "PriorityDFP", "PriorityVulnerability",
			"Group1F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderSaveCopyHistory(Map<String, String> userData) throws Exception {
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
			// newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 12, 0);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			newOrderInstance.selectProductType("1", 12, 1);
			newOrderInstance.selectProduct("1", 12, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 12, 3);
			newOrderInstance.selectSection("1", 12, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(3000);
			newOrderInstance.saveOrder();

			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			/*
			 * List<WebElement> list =
			 * driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			 * wait.until(ExpectedConditions.visibilityOfAllElements(list));
			 */
			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
			Thread.sleep(3000);
			dashboardPageInstance.clickOnOrderEntryModule();
			Thread.sleep(3000);
			orderEntryPageInstance.clickOnOrder(orderNumber);
			Logger.info("Saved Order : " + orderNumber);

			wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement));
			Thread.sleep(8000);
			Logger.info("START OF COPY ORDER");

			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();
			Thread.sleep(8000);
			newOrderInstance.saveOrder();

			Thread.sleep(3000);

			/*
			 * List<WebElement> list =
			 * driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			 * wait.until(ExpectedConditions.visibilityOfAllElements(list));
			 */
			String orderNumber1 = orderEntryPageInstance.getOrderIDNewPage();
			Thread.sleep(3000);
			dashboardPageInstance.clickOnOrderEntryModule();
			Thread.sleep(3000);
			orderEntryPageInstance.clickOnOrder(orderNumber1);

			Thread.sleep(3000);

			Logger.info("Saved Order : " + orderNumber1);
			wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement));
			Thread.sleep(8000);
			newOrderInstance.clickOnHistoryButton();
			Thread.sleep(3000);
			String orderStatus2 = newOrderInstance.getOrderHistoryStatus(1);
			String orderStatus3 = newOrderInstance.getOrderHistoryStatus(2);

			boolean statusflag2 = false;

			if (orderStatus2.trim().contains("SAVE")) {

				Logger.info("Logged activity for SAVE status: " + newOrderInstance.getOrderHistoryActivity(1));
			} else if (orderStatus3.trim().contains("SAVE")) {

				Logger.info("Logged activity for SAVE status: " + newOrderInstance.getOrderHistoryActivity(2));
			} else {
				statusflag2 = true;
				Logger.info("Status Save not found in history");
			}

			Assert.assertEquals(statusflag2, false);

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderProgramPriceChange", "OrderDisplayOnlineTest", "Grp4", "DsplyReg1",
			"RerunD" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderProgramPriceChange(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_DPR");
			newOrderInstance.enterSoldToCustomer("CU00013249");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 29, 0);
			Thread.sleep(2000);
			newOrderInstance.enterPubDate("1", "20", "Sep", "2021");
			Thread.sleep(2000);
			newOrderInstance.selectProductType("1", 29, 1);
			// newOrderInstance.selectProduct("1",56, 2);
			// Thread.sleep(2000);
			// newOrderInstance.selectAdType("1",56, 3);
			// Thread.sleep(2000);
			// newOrderInstance.selectSection("1",8, 4);
			Thread.sleep(4000);

			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectAdSize(1, "1/8  (3 x 5.25)");
			Thread.sleep(4000);

			newOrderInstance.checkUncheckPosTemplateChckbx(1, true);
			newOrderInstance.clickOnPositionSelector();
			Thread.sleep(32000);

			newOrderInstance.selectFirstPostionFrmPositionSlctr();
			Thread.sleep(4000);
			newOrderInstance.savePositionSelection();
			Thread.sleep(10000);
			double totalInsertionPrice = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("total insertion price " + totalInsertionPrice);
			Thread.sleep(2000);
			String programPrice = newOrderInstance.getProgramPriceForAnInsertionDisplay(1);
			Thread.sleep(2000);
			Assert.assertEquals(programPrice, "None");
			Thread.sleep(2000);
			newOrderInstance.clickOnProgramPriceSelectorDisplay();
			Thread.sleep(4000);
			newOrderInstance.selectProgramPromotion("DP 1/8 Pg Print/Online Combo 2016-2020");
			Thread.sleep(4000);
			double totalInsertionPrice1 = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("total insertion price after selecting program " + totalInsertionPrice1);
			String programPrice1 = newOrderInstance.getProgramPriceForAnInsertionDisplay(1);
			Thread.sleep(2000);
			boolean flag = false;
			if (programPrice1 != programPrice && totalInsertionPrice1 != totalInsertionPrice) {
				flag = true;
			}

			Assert.assertEquals(flag, true);
			newOrderInstance.clearProgramPromotionDisplay();
			Thread.sleep(5000);
			String programPrice2 = newOrderInstance.getProgramPriceForAnInsertionDisplay(1);
			Thread.sleep(2000);
			Assert.assertEquals(programPrice2, "None");
			Thread.sleep(2000);
			double totalInsertionPrice2 = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("total insertion price after de-selecting program " + totalInsertionPrice1);
			Thread.sleep(2000);
			Assert.assertEquals(totalInsertionPrice2, totalInsertionPrice);
			Thread.sleep(2000);
			newOrderInstance.clickOnProgramPriceSelectorDisplay();
			Thread.sleep(4000);
			newOrderInstance.selectProgramPromotion("DP 1/8 Pg Print/Online Combo 2016-2020");
			Thread.sleep(4000);
			String programPrice3 = newOrderInstance.getProgramPriceForAnInsertionDisplay(1);
			Thread.sleep(2000);
			boolean flag1 = false;
			if (programPrice3 != programPrice2) {
				flag1 = true;
			}

			Assert.assertEquals(flag1, true);

			// --------------------------------------------------------//
			/*
			 * newOrderInstance.selectProductByIndex("1", 3);
			 * Thread.sleep(2000);
			 * 
			 * String programPrice4=
			 * newOrderInstance.getProgramPriceForAnInsertion(1);
			 * Thread.sleep(2000); String programPriceRate4 =
			 * newOrderInstance.getProgramPriceRateForAnInsertion(1);
			 * Thread.sleep(2000); Assert.assertEquals(programPrice4, "None");
			 * Thread.sleep(2000); Assert.assertEquals(programPriceRate4, "0");
			 * Thread.sleep(2000); newOrderInstance.selectProductByIndex("1",
			 * 0); Thread.sleep(5000);
			 * newOrderInstance.clickOnProgramPriceSelector();
			 * Thread.sleep(4000); newOrderInstance.
			 * selectProgramPromotion("DP Print/Online-A1/Section Fronts 2016-2020"
			 * ); Thread.sleep(4000); String programPrice5=
			 * newOrderInstance.getProgramPriceForAnInsertion(1);
			 * Thread.sleep(2000); String programPriceRate5 =
			 * newOrderInstance.getProgramPriceRateForAnInsertion(1);
			 * Thread.sleep(2000); boolean flag2 = false; if
			 * (programPriceRate5!=programPriceRate4 &&
			 * programPrice5!=programPrice4) { flag2 = true; }
			 * Assert.assertEquals(flag2, true);
			 */
			// ----------------------------------------------------------//

			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.addNewSalesRepOnInsertion(1, "SA02514");
			// Thread.sleep(2000);
			// newOrderInstance.addServiceRep("027440");
			// Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);
			orderEntryPageInstance.getOrderNumber();
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"SMaintenance", "Order","NovMaintenance", "displayOrderBleed", "OrderDisplayOnlineTest", "PrioritizedReg2", "Grp4",
			"RegressionLatest", "Group1", "DsplyReg1", "RerunD", "NewRegression2", "NewRegression", "G1", "RerunF2",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void displayOrderBleed(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 18, 0);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			Thread.sleep(2000);
			newOrderInstance.selectProductType("1", 18, 1);
			Thread.sleep(2000);
			newOrderInstance.selectProduct("1", 18, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 18, 3);
			Thread.sleep(2000);
			newOrderInstance.selectSection("1", 18, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectBleed("Full Page");
			Thread.sleep(4000);
			//newOrderInstance.createDuplicateInsertion("1");
			//Thread.sleep(4000);

			//newOrderInstance.selectBleedInsertion(2, "Double Truck");
			//Thread.sleep(4000);
			//newOrderInstance.viewInsertionDetails("1");
			//newOrderInstance.viewInsertionDetails("2");
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			//Thread.sleep(2000);
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// Thread.sleep(4000);
			// nnewOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1,
			// "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			// newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
			// Thread.sleep(2000);
			// newOrderInstance.addServiceRep("101583");
			// Thread.sleep(4000);
			// Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(2,
			// "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			// newOrderInstance.applytoAllSalesRepOnInsertion2(2);Thread.sleep(2000);Thread.sleep(4000);Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(7000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("2");
			Thread.sleep(4000);
			newOrderInstance.clearBleedDisplay(2);
			Thread.sleep(2000);
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// Thread.sleep(4000);
			// newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(3,
			// "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			// newOrderInstance.applytoAllSalesRepOnInsertion(3);Thread.sleep(2000);Thread.sleep(4000);
			newOrderInstance.submitOrder();
			// Thread.sleep(4000);
			// Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1,
			// "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			// newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);Thread.sleep(4000);newOrderInstance.submitOrder();
			// Thread.sleep(1000);
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	// arka
	/*
	 * @Test(groups = {"Order",
	 * "displayOrderColorMaterialAdSizeWarning","OrderDisplayOnlineTest","Grp4",
	 * "RegressionLatest","Group1","DsplyReg12","RerunD","RegFailed3","Group1F",
	 * "NewRegression","G1","RerunF2"}, dataProviderClass =
	 * com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider =
	 * "userData") public void
	 * displayOrderColorMaterialAdSizeWarning(Map<String, String> userData)
	 * throws Exception { try { WebDriver driver = WebDriverManager.getDriver();
	 * Logger.info("Webdriver is initiated");
	 * 
	 * TribuneUtils utilities = new TribuneUtils(); utilities.launchURL(driver,
	 * Configurator.getConfig().get("SignIn")); utilities.implementWait(driver);
	 * 
	 * SignInPage signinPageinstance = PageFactory.initElements(driver,
	 * SignInPage.class); signinPageinstance.login("success");
	 * 
	 * DashboardPage dashboardPageInstance = PageFactory.initElements(driver,
	 * DashboardPage.class); dashboardPageInstance.clickOnOrderEntryModule();
	 * 
	 * OrderEntryHomePage orderEntryPageInstance =
	 * PageFactory.initElements(driver, OrderEntryHomePage.class);
	 * orderEntryPageInstance.clickOnNewGeneralOrder();
	 * 
	 * NewOrderPage newOrderInstance = PageFactory.initElements(driver,
	 * NewOrderPage.class); newOrderInstance.selectSoldToCustomerBU("bu_CTC");
	 * newOrderInstance.enterSoldToCustomer("CU00037236");
	 * newOrderInstance.selectBilltoSameAsSoldTo();
	 * newOrderInstance.selectOrderType("OrderType_Standard");
	 * newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
	 * newOrderInstance.checkUncheckOwnLocalOptOut(true);
	 * newOrderInstance.createNewInsertion(); newOrderInstance.selectBU("1",17,
	 * 0); Thread.sleep(4000); newOrderInstance.enterPubDate("1","23", "Dec",
	 * "2021"); Thread.sleep(4000); newOrderInstance.selectProductType("1",17,
	 * 1); Thread.sleep(4000); newOrderInstance.selectProduct("1",17, 2);
	 * Thread.sleep(4000); newOrderInstance.selectAdType("1",17, 3);
	 * Thread.sleep(4000); newOrderInstance.selectSection("1",17, 4);
	 * Thread.sleep(4000); newOrderInstance.viewInsertionDetails("1");
	 * Thread.sleep(4000); newOrderInstance.selectAdSize(1, "1/9  (2 x 7)");
	 * Thread.sleep(4000); Thread.sleep(4000);
	 * newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
	 * newOrderInstance.clickOnPositionSelector(); Thread.sleep(45000);
	 * 
	 * // newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
	 * newOrderInstance.selectFirstPostionFrmPositionSlctr();
	 * Thread.sleep(4000); newOrderInstance.savePositionSelection();
	 * Thread.sleep(10000); newOrderInstance.selectMaterialSource("1",
	 * "New Build"); Thread.sleep(3000);
	 * newOrderInstance.selectColourForAnInsertion(1,"B/W"); Thread.sleep(4000);
	 * newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.addNewSalesRepOnInsertion(1,
	 * "SA01380");Thread.sleep(4000);newOrderInstance.
	 * clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);
	 * Thread.sleep(4000); Thread.sleep(4000); newOrderInstance.submitOrder();
	 * Thread.sleep(2000); String orderID = orderEntryPageInstance.getOrderID();
	 * Logger.info("Order ID: "+orderID);
	 * orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
	 * Thread.sleep(2000); List<WebElement> list =
	 * driver.findElements(By.xpath("//div[@class='row ng-scope']"));
	 * WebDriverWait wait = new WebDriverWait(driver,20);
	 * wait.until(ExpectedConditions.visibilityOfAllElements(list));
	 * orderEntryPageInstance.clickOnOrder(orderID); Thread.sleep(5000);
	 * newOrderInstance.viewInsertionDetails("1"); Thread.sleep(4000);
	 * newOrderInstance.selectAdSize(1, "Full Page (6 x 21)");
	 * Thread.sleep(4000); Thread.sleep(4000);
	 * newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
	 * newOrderInstance.clickOnPositionSelector(); Thread.sleep(45000);
	 * 
	 * // newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
	 * newOrderInstance.selectFirstPostionFrmPositionSlctr();
	 * Thread.sleep(4000); newOrderInstance.savePositionSelection();
	 * Thread.sleep(10000); //
	 * newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.addNewSalesRepOnInsertion(1,
	 * "SA01380");Thread.sleep(4000);newOrderInstance.
	 * clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);
	 * Thread.sleep(4000); Thread.sleep(4000); Thread.sleep(4000);
	 * newOrderInstance.submitOrder();
	 * 
	 * newOrderInstance.displayWarningMsg(); Thread.sleep(2000);
	 * newOrderInstance.clickOnContinuePastPubDate(); Thread.sleep(3000);
	 * orderEntryPageInstance.clickOnOrder(orderID); Thread.sleep(15000);
	 * newOrderInstance.viewInsertionDetails("1"); Thread.sleep(4000);
	 * newOrderInstance.selectMaterialSource("1", "Self Service");
	 * Thread.sleep(4000); //
	 * newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.addNewSalesRepOnInsertion(1,
	 * "SA01380");Thread.sleep(4000);newOrderInstance.
	 * clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);
	 * Thread.sleep(4000); Thread.sleep(4000); Thread.sleep(4000);
	 * newOrderInstance.submitOrder(); newOrderInstance.displayWarningMsg();
	 * Thread.sleep(2000); newOrderInstance.clickOnContinuePastPubDate();
	 * Thread.sleep(3000); orderEntryPageInstance.clickOnOrder(orderID);
	 * Thread.sleep(15000); newOrderInstance.viewInsertionDetails("1");
	 * Thread.sleep(4000); newOrderInstance.selectColourForAnInsertion(1,"4C");
	 * Thread.sleep(4000); //
	 * newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.addNewSalesRepOnInsertion(1,
	 * "SA01380");Thread.sleep(4000);newOrderInstance.
	 * clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);
	 * Thread.sleep(4000); Thread.sleep(4000); Thread.sleep(4000);
	 * newOrderInstance.submitOrder(); newOrderInstance.displayWarningMsg();
	 * Thread.sleep(2000); newOrderInstance.clickOnContinuePastPubDate();
	 * Thread.sleep(3000); orderEntryPageInstance.clickOnOrder(orderID);
	 * Thread.sleep(5000); dashboardPageInstance.clickOnLogout(); }
	 * catch(Exception e) { Logger.error(e.getMessage()); throw e; } }
	 */

	@Test(groups = {"SMaintenance1", "arkadeep", "Order", "displayOrderColorMaterialAdSizeWarning", "PrioritizedReg2",
			"OrderDisplayOnlineTest", "Grp4", "RegressionLatest", "Group1", "DsplyReg12", "RerunD", "RegFailed3",
			"Group1F", "NewRegression2", "NewRegression", "G1", "RerunF2",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
public void displayOrderColorMaterialAdSizeWarning(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);
			Thread.sleep(4000);
			// newOrderInstance.enterPubDate("1","26", "Dec", "2021");
			newOrderInstance.enterPubDateFromExcel("1", 17, 27);// payel
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 17, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 17, 3);
			Thread.sleep(4000);
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			//newOrderInstance.selectAdSize(1, "1/9  (2 x 7)");
			//Thread.sleep(4000);
			
			newOrderInstance.selectMaterialSource("1", "New Build");
			Thread.sleep(3000);
			newOrderInstance.selectColourForAnInsertion(1, "B/W");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);

			newOrderInstance.submitOrder();
			//Thread.sleep(2000);
			//newOrderInstance.clickNoLegacyAutoInsertionCreation();//swagata
			//newOrderInstance.clickOnwarningConfirmation();//joy
			//Thread.sleep(2000); //joy
			String orderID = orderEntryPageInstance.getOrderNumber();//swagata
			Logger.info("Order ID: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(5000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			//newOrderInstance.selectAdSize(1, "Full Page (6 x 21)");
			//Thread.sleep(4000);
			
			newOrderInstance.submitOrder();

			orderEntryPageInstance.clickOnOrder(orderID);
		
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectMaterialSource("1", "Self Service");
			Thread.sleep(4000);
			
			newOrderInstance.submitOrderWithoutSave();//swagata
			newOrderInstance.displayWarningMsg();
			Thread.sleep(4000);
			newOrderInstance.clickOnContinuePastPubDate();
			Thread.sleep(2000);
			newOrderInstance.clickNoLegacyAutoInsertionCreation();
			Thread.sleep(3000);
			orderEntryPageInstance.clickOnOrder(orderID);
			//Thread.sleep(15000);//swagata
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectColourForAnInsertion(1, "4C");
			Thread.sleep(4000);
		
			newOrderInstance.submitOrderWithoutSave();//swagata
			newOrderInstance.displayWarningMsg();
			Thread.sleep(4000);
			newOrderInstance.clickOnContinuePastPubDate();
			Thread.sleep(2000);
			newOrderInstance.clickNoLegacyAutoInsertionCreation();
			Thread.sleep(3000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(5000);
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderPickUpChangeWarning", "OrderDisplayOnlineTest", "Grp4", "PrioritizedReg2",
			"RegressionLatest", "Group1", "DsplyReg12", "RerunD", "NewRegression2", "NewRegression", "G1", "RerunF2",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderPickUpChangeWarning(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);
			Thread.sleep(4000);
		//	newOrderInstance.enterPubDate("1", "23", "Dec", "2021");//swagata
			newOrderInstance.enterPubDateFromExcel("1", 17, 27);//swagata
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 17, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 17, 3);
			Thread.sleep(4000);
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			//newOrderInstance.selectAdSize(1, "1/9  (2 x 7)");
			//Thread.sleep(4000);
			newOrderInstance.selectMaterialSource("1", "Electronic");
			Thread.sleep(3000);
			newOrderInstance.selectColourForAnInsertion(1, "4C");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			/*
			 * Thread.sleep(2000); Thread.sleep(4000); Thread.sleep(4000);
			 *///swagata
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order ID: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(5000);
			dashboardPageInstance.clickOnOrderEntryModule();

			orderEntryPageInstance.clickOnNewGeneralOrder();

			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);
			Thread.sleep(4000);
//			newOrderInstance.enterPubDate("1", "23", "Dec", "2021");
			newOrderInstance.enterPubDateFromExcel("1", 17, 27);//swagata
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 17, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 17, 3);
			Thread.sleep(4000);
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			//newOrderInstance.selectAdSize(1, "1/9  (2 x 7)");
			//Thread.sleep(4000);
			newOrderInstance.selectMaterialSource("1", "Electronic");
			Thread.sleep(3000);
			newOrderInstance.selectColourForAnInsertion(1, "4C");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID1 = orderEntryPageInstance.getOrderID();
			Logger.info("Order ID: " + orderID1);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			WebDriverWait wait1 = new WebDriverWait(driver, 20);
			wait1.until(ExpectedConditions.visibilityOfAllElements(list1));
			orderEntryPageInstance.clickOnOrder(orderID1);
			Thread.sleep(5000);
			dashboardPageInstance.clickOnOrderEntryModule();

			orderEntryPageInstance.clickOnNewGeneralOrder();

			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);
			Thread.sleep(4000);
//			newOrderInstance.enterPubDate("1", "23", "Dec", "2021");
			newOrderInstance.enterPubDateFromExcel("1", 17, 27);//swagata
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 17, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 17, 3);
			Thread.sleep(4000);
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			//newOrderInstance.selectAdSize(1, "1/9  (2 x 7)");
			//Thread.sleep(4000);
			newOrderInstance.selectMaterialSource("1", "Straight Pickup");
			Thread.sleep(3000);
			newOrderInstance.clickOnPickUpSearch();
			Thread.sleep(4000);
			newOrderInstance.searchOrderNoPickUpWindow(orderID);//swagata
			newOrderInstance.selectPickUp(orderID);
			Thread.sleep(4000);
			newOrderInstance.selectColourForAnInsertion(1, "4C");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID2 = orderEntryPageInstance.getOrderID();
			Logger.info("Order ID: " + orderID2);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			WebDriverWait wait2 = new WebDriverWait(driver, 20);
			wait2.until(ExpectedConditions.visibilityOfAllElements(list2));
			orderEntryPageInstance.clickOnOrder(orderID2);
			Thread.sleep(5000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.clickOnPickUpSearch();
			Thread.sleep(4000);
			newOrderInstance.searchOrderNoPickUpWindow(orderID1);//swagata
			newOrderInstance.selectPickUp(orderID1);
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			newOrderInstance.displayWarningMessageConfirm();
			// newOrderInstance.compareErrorMessageMultiple("Ad Size, Material
			// Source, Color, Pickup#, Version, Preprint Type, Page Count, Page
			// Type or Ad Type has changed without reassigning Material Id for
			// 01-00",2);
			/*
			 * Thread.sleep(3000);
			 */			orderEntryPageInstance.clickOnOrder(orderID1);
			Thread.sleep(5000);
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "alternativePrintOrderColorMaterialAdSizeWarning", "OrderDisplayOnlineTest", "Grp4",
			"RegressionLatest", "Group1", "DsplyReg12", "RerunD", "RegFailed3",
			"Group1F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void alternativePrintOrderColorMaterialAdSizeWarning(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 55, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "19", "Dec", "2021");
			Thread.sleep(4000);
			newOrderInstance.selectProductTypeByIndex("1", 8);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			// newOrderInstance.selectAdSize(1, "Celeb (4 x 8)");
			// Thread.sleep(4000);

			newOrderInstance.checkUncheckPosTemplateChckbx(1, true);
			newOrderInstance.clickOnPositionSelector();
			Thread.sleep(12000);
			// newOrderInstance.selectAdSizeForPosition();
			// Thread.sleep(5000);

			// newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
			newOrderInstance.selectFirstPostionFrmPositionSlctr();
			newOrderInstance.savePositionSelection();
			Thread.sleep(10000);
			newOrderInstance.selectMaterialSource("1", "New Build");
			Thread.sleep(3000);
			newOrderInstance.selectColourForAnInsertion(1, "4C");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order ID: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(5000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectMaterialSource("1", "Self Service");
			Thread.sleep(4000);
			// newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1,
			// "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			// newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			// Thread.sleep(3000);
			newOrderInstance.displayWarningMessageConfirm();
			// newOrderInstance.compareErrorMessageMultiple("Ad Size, Material
			// Source, Color, Pickup#, Version, Preprint Type, Page Count, Page
			// Type or Ad Type has changed without reassigning Material Id for
			// 01-00",2);
			Thread.sleep(2000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(5000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectColourForAnInsertion(1, "B/W");
			Thread.sleep(4000);
			// newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1,
			// "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			// newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			// Thread.sleep(3000);
			newOrderInstance.displayWarningMessageConfirm();
			// newOrderInstance.compareErrorMessageMultiple("Ad Size, Material
			// Source, Color, Pickup#, Version, Preprint Type, Page Count, Page
			// Type or Ad Type has changed without reassigning Material Id for
			// 01-00",2);
			Thread.sleep(2000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(5000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectAdSize(1, "Full Page (6 x 10.5)");
			Thread.sleep(4000);

			newOrderInstance.checkUncheckPosTemplateChckbx(1, true);
			newOrderInstance.clickOnPositionSelector();
			Thread.sleep(12000);
			// newOrderInstance.selectAdSizeForPosition();
			// Thread.sleep(5000);

			// newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
			newOrderInstance.selectFirstPostionFrmPositionSlctr();
			newOrderInstance.savePositionSelection();
			Thread.sleep(10000);
			// newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1,
			// "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			// newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			// Thread.sleep(3000);
			newOrderInstance.displayWarningMessageConfirm();
			// newOrderInstance.compareErrorMessageMultiple("Ad Size, Material
			// Source, Color, Pickup#, Version, Preprint Type, Page Count, Page
			// Type or Ad Type has changed without reassigning Material Id for
			// 01-00",2);
			Thread.sleep(2000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(5000);
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderMakeGood", "Grp4", "RegressionLatest", "Group1",
			"TestPriority" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderMakeGood(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectOrderType("OrderType_MakeGood");
			Thread.sleep(4000);
			newOrderInstance.selectMakeGoodReason("Did not Appear");
			Thread.sleep(4000);
			newOrderInstance.selectMakeGoodAccountability("Finance-Accounts Receivable Finance");
			Thread.sleep(4000);
			newOrderInstance.selectFirstDisplayMakeGoodInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 25, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1", 25, 27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 25, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 25, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 25, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1", 25, 4);
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			// newOrderInstance.selectAdSize(1, "1/4V (3 x 10.5)");
			// Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA00494");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(4000);
			newOrderInstance.confirmToMakeOrderFree();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);

			dashboardPageInstance.clickOnLogout();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "arkadeep", "Order", "comparableAdSizeSameMaterialId", "Grp4", "RegressionLatest", "Group1",
			"DsplyReg12", "G1", "RerunF2",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void comparableAdSizeSameMaterialId(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 17, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1", 17, 27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 17, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectAdSize(1, "1/2H  (6 x 10.5)");
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			Thread.sleep(4000);
			// newOrderInstance.createNewInsertion();
			newOrderInstance.createDuplicateInsertion("1");// payel
			Thread.sleep(4000);
			newOrderInstance.selectBU("2", 81, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("2", 17, 27);//swagata
			Thread.sleep(9000);
			newOrderInstance.selectProductType("2", 81, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("2", 81, 2);
			Thread.sleep(4000);
			// newOrderInstance.selectSectionByIndex("2",5);//payel
			Thread.sleep(3000);// payel
			newOrderInstance.viewInsertionDetails("2");
			Thread.sleep(2000);
			//newOrderInstance.selectAdSize(2, "Full Page (4 x 10.5)");
			//Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("2");//swagata
			Thread.sleep(2000);

			// newOrderInstance.createNewInsertion();
			newOrderInstance.createDuplicateInsertion("2");// payel
			Thread.sleep(4000);
			newOrderInstance.selectBU("3", 82, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("3", 17, 27);//swagata
			Thread.sleep(9000);
			newOrderInstance.selectProductType("3", 82, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("3", 82, 2);
			Thread.sleep(2000);
			//newOrderInstance.selectSectionByIndex("3", 4);
			//newOrderInstance.selectSectionByIndex("3", 0);//swagata
			//Thread.sleep(2000);
			newOrderInstance.viewInsertionDetails("3");
			Thread.sleep(2000);
			//newOrderInstance.selectAdSize(3, "1/2H  (6 x 10.5)");//joy
			//newOrderInstance.selectAdSize(3, "1/2V (2 x 10.5)");//swagata
			//Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("2");//swagata
			Thread.sleep(4000);

			
			newOrderInstance.submitOrder();
			Thread.sleep(3000);
			/*newOrderInstance.clickOnKillOnConfirmation();
			Thread.sleep(3000);*///swagata
			newOrderInstance.displayErrorMessage();//swagata
			newOrderInstance.compareErrorMessage("Two or more insertion lines with the same Material ID have different ADSizes! These are lines 01-00 02-00");//swagata
			

			//dashboardPageInstance.clickOnLogout(); joy

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	// arka
	
	@Test(groups = { "arkadeep", "Order", "comparableAdSizeStraightPkUp", "PrioritizedReg2", "Grp4", "RegressionLatest",
			"Group1", "TestPriority", "RerunD", "G1", "RerunF2",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void comparableAdSizeStraightPkUp(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 17, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1", 17, 27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 17, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectAdSize(1, "1/2H  (6 x 10.5)");
			Thread.sleep(4000);
			newOrderInstance.selectMaterialSource("1", "New Build");
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			Thread.sleep(4000);
			// newOrderInstance.createNewInsertion();
			newOrderInstance.createDuplicateInsertion("1");// payel
			Thread.sleep(4000);
			newOrderInstance.selectBU("2", 81, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("2", 17, 27);//swagata
			Thread.sleep(5000);
			newOrderInstance.selectProductType("2", 81, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("2", 81, 2);
			Thread.sleep(4000);
			// newOrderInstance.selectSectionByIndex("2",5);//payel
			// Thread.sleep(6000);//payel
			newOrderInstance.viewInsertionDetails("2");
			Thread.sleep(4000);
			newOrderInstance.selectAdSize(2, "1/2H  (6 x 10.5)");//swagata
			Thread.sleep(4000);
			newOrderInstance.selectMaterialSource("2", "Pickup w/Changes");
			Thread.sleep(4000);
			newOrderInstance.clickOnPickUpSearch();
			Thread.sleep(4000);
			newOrderInstance.selectFirstPickUpByCustomer("Test Ad Do Not Run");
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("2");//swagata
			Thread.sleep(4000);

			// newOrderInstance.createNewInsertion();
			newOrderInstance.createDuplicateInsertion("2");// payel
			Thread.sleep(4000);
			newOrderInstance.selectBU("3", 82, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("3", 17, 27);//swagata
			Thread.sleep(5000);
			newOrderInstance.selectProductType("3", 82, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("3", 82, 2);
			Thread.sleep(4000);
		//	newOrderInstance.selectSectionByIndex("3", 0);//swagata
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("3");
			Thread.sleep(4000);
			newOrderInstance.selectAdSize(3, "1/2H  (6 x 10.5)");//swagata
			Thread.sleep(4000);
			newOrderInstance.selectMaterialSource("3", "Straight Pickup");
			Thread.sleep(4000);
			newOrderInstance.clickOnPickUpSearchIndex(2);
			Thread.sleep(4000);
			newOrderInstance.selectFirstPickUpByCustomer("Test Ad Do Not Run");
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("3");//swagata
			Thread.sleep(4000);

			// newOrderInstance.createNewInsertion();
			newOrderInstance.createDuplicateInsertion("3");// payel
			Thread.sleep(4000);
			newOrderInstance.selectBU("4", 83, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("4", 17, 27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("4", 83, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("4", 83, 2);
			Thread.sleep(4000);
//			newOrderInstance.selectSectionByIndex("4", 3);//swagata
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("4");
			Thread.sleep(4000);
			//newOrderInstance.selectAdSize(4, "Full Page (4 x 10.5)");//swagata
			Thread.sleep(4000);
			newOrderInstance.selectMaterialSource("4", "Electronic");
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("4");//swagata
			newOrderInstance.saveOrder();

			Thread.sleep(3000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
			Logger.info("Saved Order : " + orderNumber);

			Thread.sleep(3000);
			/*
			 * dashboardPageInstance.clickOnOrderEntryModule(); Thread.sleep(3000);
			 * orderEntryPageInstance.clickOnOrder(orderNumber);
			 * 
			 * 
			 * newOrderInstance.viewInsertionDetails("4"); Thread.sleep(4000);
			 *///swagata
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(4, "SA00856");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(4);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();//joy
		
			//newOrderInstance.displayErrorMessage();//swagata
			//newOrderInstance.compareErrorMessage("Two or more insertion lines with the same Material ID have different ADSizes! These are lines 01-00 02-00 03-00 04-00");//Joy
		

			dashboardPageInstance.clickondropdownforlogout();//joy

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/*
	 * @Test(groups =
	 * {"Order","OrderDisplayTest","displayOrderAdjustmentSetApprove",
	 * "OrderDisplayOnlineTest","displayOrder","Grp4","RegressionLatest",
	 * "Group1","DsplyReg12","RerunD","RegFailed3","Group1F","GroupAdjReg",
	 * "NewRegression","G1","RerunF2"}, dataProviderClass =
	 * com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider =
	 * "userData") public void displayOrderAdjustmentSetApprove(Map<String,
	 * String> userData) throws Exception { try { WebDriver driver =
	 * WebDriverManager.getDriver(); Logger.info("Webdriver is initiated");
	 * 
	 * TribuneUtils utilities = new TribuneUtils(); utilities.launchURL(driver,
	 * Configurator.getConfig().get("SignIn")); utilities.implementWait(driver);
	 * 
	 * SignInPage signinPageinstance = PageFactory.initElements(driver,
	 * SignInPage.class); signinPageinstance.login("success");
	 * 
	 * DashboardPage dashboardPageInstance = PageFactory.initElements(driver,
	 * DashboardPage.class); dashboardPageInstance.clickOnOrderEntryModule();
	 * 
	 * OrderEntryHomePage orderSearch = PageFactory.initElements(driver,
	 * OrderEntryHomePage.class); WebDriverWait wait = new
	 * WebDriverWait(driver,120); List<WebElement> list =
	 * driver.findElements(By.xpath("//div[@class='row ng-scope']"));
	 * wait.until(ExpectedConditions.visibilityOfAllElements(list));
	 * orderSearch.selectStatus("Invoiced");
	 * orderSearch.clickOnOrderSearchBtn(); Thread.sleep(2000);
	 * 
	 * Thread.sleep(3000); String order =
	 * orderSearch.orderSearchResult1.getText();
	 * orderSearch.clickOnSearchedOrderInvoiced(); Thread.sleep(7000);
	 * NewOrderPage newOrderInstance = PageFactory.initElements(driver,
	 * NewOrderPage.class); String businessUnit =
	 * newOrderInstance.getBUOnInsertion(1); Thread.sleep(3000); int
	 * insertionCountpre = newOrderInstance.getInsertionsCount();
	 * newOrderInstance.clickOnAdjustmentRequest(); Thread.sleep(4000);
	 * newOrderInstance.setAdjustmentRequest("2501"); Thread.sleep(90000);
	 * String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
	 * Logger.info("orderStatus "+orderStatus);
	 * 
	 * dashboardPageInstance.clickOnAdjustmentsModule(); WebElement buDropdown =
	 * driver.findElement(By.xpath("//*[@id='productTypes']")); if
	 * (buDropdown.isDisplayed()) { buDropdown.click();
	 * Logger.info("buDropdown is clicked"); Select valueFromStatus = new
	 * Select(buDropdown); List<WebElement> listOfValuesStatus =
	 * valueFromStatus.getOptions(); if(listOfValuesStatus.size() !=0) {
	 * Logger.info("List of bu is not empty");
	 * //valueFromStatus.selectByVisibleText(properties.getProperty(status));
	 * valueFromStatus.selectByVisibleText(businessUnit);
	 * Logger.info(businessUnit+" bu is selected"); } } else {
	 * Logger.info("buDropdown not displayed"); throw new
	 * NoSuchElementException("buDropdown is not displayed"); }
	 * Thread.sleep(30000);
	 * 
	 * WebElement selectPendingAllUsers =
	 * driver.findElement(By.xpath("//a[text()='Pending(All Users)']"));
	 * selectPendingAllUsers.click(); Thread.sleep(3000);
	 * 
	 * WebElement selectAdjustment =
	 * driver.findElement(By.xpath("(//div[text()='"+order+"'])[1]"));
	 * selectAdjustment.click(); Thread.sleep(3000);
	 * 
	 * WebElement approveAdjustment =
	 * driver.findElement(By.xpath("//button[@id='approve']"));
	 * approveAdjustment.click(); Thread.sleep(3000);
	 * Logger.info("Adjustment Approved");
	 * 
	 * WebElement confirmApproveAdjustment =
	 * driver.findElement(By.xpath("//button[text()='Ok']"));
	 * confirmApproveAdjustment.click();
	 * Logger.info("Adjustment Approve Confirmed"); Thread.sleep(7000);
	 * 
	 * dashboardPageInstance.clickOnOrderEntryModule(); Thread.sleep(3000);
	 * orderSearch.enterOrderNumber(order); orderSearch.clickOnOrderSearchBtn();
	 * /* Thread.sleep(2000);
	 * 
	 * Thread.sleep(3000); orderSearch.clickOnSearchedOrder();
	 * Thread.sleep(7000); int insertionCountpost =
	 * newOrderInstance.getInsertionsCount();
	 * Assert.assertEquals(insertionCountpost, (insertionCountpre+1));
	 * 
	 * } catch (Exception e) { Logger.error(e.getMessage()); throw e; } }
	 */
	@Test(groups = { "SMaintenance","ShaliniAdjustment", "Order", "OrderDisplayTest", "displayOrderAdjustmentSetApprove",
			"OrderDisplayOnlineTest", "displayOrder", "Grp4", "RegressionLatest", "Group1", "DsplyReg1", "RerunD",
			"RegFailed3", "Group1F","NewRegression3",
			"GroupAdjReg"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderAdjustmentSetApprove(Map<String, String> userData) throws Exception {
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

			OrderEntryHomePage orderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderSearch.selectBUs("DPR-Daily Press");
			orderSearch.selectStatus("Invoiced");
			orderSearch.advancedLink.click();// Added Shalini
			orderSearch.selectProductType2("Display");// Added Shalini
			orderSearch.selectProduct2("Virginian Pilot");// Added Shalini
			// orderSearch.selectSection2("Main News");
			orderSearch.clickOnOrderSearchBtn();
			Thread.sleep(3000);
			orderSearch.ordersearchPriceDecending();

			Thread.sleep(3000);
			String order = orderSearch.orderSearchResult1.getText();
			orderSearch.clickOnSearchedOrderInvoiced();
			Thread.sleep(7000);
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			String businessUnit = newOrderInstance.getBUOnInsertion(1);
			Logger.info("Business unit:"+businessUnit);
			Thread.sleep(3000);
			int insertionCountpre = newOrderInstance.getInsertionsCount();
			newOrderInstance.clickOnAdjustmentRequest();
			Thread.sleep(4000);
			newOrderInstance.setAdjustmentRequest("2501");
			Thread.sleep(90000);
			String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
			Logger.info("orderStatus " + orderStatus);
			//Partha
			Properties properties = TribuneUtils.readProperties();
			dashboardPageInstance.clickOnLogout();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);
			signinPageinstance.enterUserName(properties.getProperty("username"));
			signinPageinstance.enterPassword(properties.getProperty("password"));
			signinPageinstance.clickOnLogin();
			Thread.sleep(15000);//partha
			
			

			dashboardPageInstance.clickOnAdjustmentsModule();
			WebElement buDropdown = driver.findElement(By.xpath("//*[@id='productTypes']"));
			if (buDropdown.isDisplayed()) {
				//buDropdown.click();
				Thread.sleep(2000);
				Logger.info("buDropdown is clicked");
				Select valueFromStatus = new Select(buDropdown);
				List<WebElement> listOfValuesStatus = valueFromStatus.getOptions();
				if (listOfValuesStatus.size() != 0) {
					Logger.info("List of bu is not empty");
					// valueFromStatus.selectByVisibleText(properties.getProperty(status));
					valueFromStatus.selectByVisibleText(businessUnit);
					Logger.info(businessUnit + " bu is selected");
				}
			} else {
				Logger.info("buDropdown not displayed");
				throw new NoSuchElementException("buDropdown is not displayed");
			}
			Thread.sleep(30000);

			WebElement selectPendingAllUsers = driver.findElement(By.xpath("//a[text()='Pending(All Users)']"));
			selectPendingAllUsers.click();
			Thread.sleep(3000);

			WebElement selectAdjustment = driver.findElement(By.xpath("(//div[text()='" + order + "'])[1]"));
			selectAdjustment.click();
			Thread.sleep(3000);

			WebElement approveAdjustment = driver.findElement(By.xpath("//button[@id='approve']"));
			approveAdjustment.click();
			Thread.sleep(3000);
			Logger.info("Adjustment Approved");

			WebElement confirmApproveAdjustment = driver.findElement(By.xpath("//button[text()='Ok']"));
			confirmApproveAdjustment.click();
			Logger.info("Adjustment Approve Confirmed");
			Thread.sleep(7000);

			dashboardPageInstance.clickOnOrderEntryModule();
			Thread.sleep(3000);
			orderSearch.enterOrderNumber(order);
			orderSearch.clickOnOrderSearchBtn();
			/*
			 * Thread.sleep(2000);
			 * 
			 * Thread.sleep(3000); orderSearch.clickOnSearchedOrder();
			 * Thread.sleep(7000); int insertionCountpost =
			 * newOrderInstance.getInsertionsCount();
			 * Assert.assertEquals(insertionCountpost, (insertionCountpre+1));
			 */

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/*
	 * @Test(groups =
	 * {"Order","OrderDisplayTest","displayOrderAdjustmentSetReject",
	 * "OrderDisplayOnlineTest","displayOrder","Grp4","RegressionLatest",
	 * "Group1","DsplyReg12","RerunD","RegFailed3","Group1F","GroupAdjReg",
	 * "NewRegression","G1","RerunF2"}, dataProviderClass =
	 * com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider =
	 * "userData") public void displayOrderAdjustmentSetReject(Map<String,
	 * String> userData) throws Exception { try { WebDriver driver =
	 * WebDriverManager.getDriver(); Logger.info("Webdriver is initiated");
	 * 
	 * TribuneUtils utilities = new TribuneUtils(); utilities.launchURL(driver,
	 * Configurator.getConfig().get("SignIn")); utilities.implementWait(driver);
	 * 
	 * SignInPage signinPageinstance = PageFactory.initElements(driver,
	 * SignInPage.class); signinPageinstance.login("success");
	 * 
	 * DashboardPage dashboardPageInstance = PageFactory.initElements(driver,
	 * DashboardPage.class); dashboardPageInstance.clickOnOrderEntryModule();
	 * 
	 * OrderEntryHomePage orderSearch = PageFactory.initElements(driver,
	 * OrderEntryHomePage.class); WebDriverWait wait = new
	 * WebDriverWait(driver,120); List<WebElement> list =
	 * driver.findElements(By.xpath("//div[@class='row ng-scope']"));
	 * wait.until(ExpectedConditions.visibilityOfAllElements(list));
	 * orderSearch.selectStatus("Invoiced");
	 * orderSearch.clickOnOrderSearchBtn(); Thread.sleep(2000);
	 * 
	 * Thread.sleep(3000); String order =
	 * orderSearch.orderSearchResult1.getText();
	 * orderSearch.clickOnSearchedOrderInvoiced(); Thread.sleep(7000);
	 * NewOrderPage newOrderInstance = PageFactory.initElements(driver,
	 * NewOrderPage.class); String businessUnit =
	 * newOrderInstance.getBUOnInsertion(1); Thread.sleep(3000); int
	 * insertionCountpre = newOrderInstance.getInsertionsCount();
	 * newOrderInstance.clickOnAdjustmentRequest(); Thread.sleep(4000);
	 * newOrderInstance.setAdjustmentRequest("2501"); Thread.sleep(90000);
	 * String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
	 * Logger.info("orderStatus "+orderStatus);
	 * 
	 * dashboardPageInstance.clickOnAdjustmentsModule(); WebElement buDropdown =
	 * driver.findElement(By.xpath("//*[@id='productTypes']")); if
	 * (buDropdown.isDisplayed()) { buDropdown.click();
	 * Logger.info("buDropdown is clicked"); Select valueFromStatus = new
	 * Select(buDropdown); List<WebElement> listOfValuesStatus =
	 * valueFromStatus.getOptions(); if(listOfValuesStatus.size() !=0) {
	 * Logger.info("List of bu is not empty");
	 * //valueFromStatus.selectByVisibleText(properties.getProperty(status));
	 * valueFromStatus.selectByVisibleText(businessUnit);
	 * Logger.info(businessUnit+" bu is selected"); } } else {
	 * Logger.info("buDropdown not displayed"); throw new
	 * NoSuchElementException("buDropdown is not displayed"); }
	 * Thread.sleep(30000);
	 * 
	 * WebElement selectPendingAllUsers =
	 * driver.findElement(By.xpath("//a[text()='Pending(All Users)']"));
	 * selectPendingAllUsers.click(); Thread.sleep(3000);
	 * 
	 * WebElement selectAdjustment =
	 * driver.findElement(By.xpath("(//div[text()='"+order+"'])[1]"));
	 * selectAdjustment.click(); Thread.sleep(3000);
	 * 
	 * WebElement approveAdjustment =
	 * driver.findElement(By.xpath("//button[@id='reject']"));
	 * approveAdjustment.click(); Thread.sleep(3000);
	 * Logger.info("Adjustment Rejected");
	 * 
	 * WebElement confirmApproveAdjustment =
	 * driver.findElement(By.xpath("//button[text()='Ok']"));
	 * confirmApproveAdjustment.click();
	 * Logger.info("Adjustment Reject Confirmed"); Thread.sleep(7000);
	 * 
	 * dashboardPageInstance.clickOnOrderEntryModule(); Thread.sleep(3000);
	 * orderSearch.enterOrderNumber(order); orderSearch.clickOnOrderSearchBtn();
	 * Thread.sleep(2000);
	 * 
	 * Thread.sleep(3000); orderSearch.clickOnSearchedOrderInvoiced();
	 * Thread.sleep(7000); int insertionCountpost =
	 * newOrderInstance.getInsertionsCount();
	 * Assert.assertEquals(insertionCountpost, insertionCountpre);
	 * 
	 * } catch (Exception e) { Logger.error(e.getMessage()); throw e; } }
	 */

	@Test(groups = { "SMaintenance","ShaliniAdjustRequest", "Order", "OrderDisplayTest", "displayOrderAdjustmentSetReject",
			"OrderDisplayOnlineTest", "displayOrder", "Grp4", "RegressionLatest", "Group1", "DsplyReg1", "RerunD",
			"RegFailed3", "Group1F","NewRegression3",
			"GroupAdjReg"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderAdjustmentSetReject(Map<String, String> userData) throws Exception {
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

			OrderEntryHomePage orderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			// orderSearch.selectStatus("Invoiced");
			orderSearch.selectBUs("DPR-Daily Press");// Added Shalini
			orderSearch.selectStatus("Invoiced");// Added Shalini
			orderSearch.advancedLink.click();// Added Shalini
			orderSearch.selectProductType2("Display");// Added Shalini
			orderSearch.selectProduct2("Virginian Pilot");// Added Shalini
			orderSearch.clickOnOrderSearchBtn();
			Thread.sleep(2000);
			orderSearch.ordersearchPriceDecending();
			Thread.sleep(3000);
			String order = orderSearch.orderSearchResult1.getText();
			orderSearch.clickOnSearchedOrderInvoiced();
			Thread.sleep(7000);
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			String businessUnit = newOrderInstance.getBUOnInsertion(1);
			Logger.info("businessUnit:"+businessUnit);
			Thread.sleep(3000);
			int insertionCountpre = newOrderInstance.getInsertionsCount();
			newOrderInstance.clickOnAdjustmentRequest();
			Thread.sleep(4000);
			newOrderInstance.setAdjustmentRequest("2501");
			Thread.sleep(90000);
			String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
			Logger.info("orderStatus " + orderStatus);

			dashboardPageInstance.clickOnAdjustmentsModule();
			WebElement buDropdown = driver.findElement(By.xpath("//*[@id='productTypes']"));
			if (buDropdown.isDisplayed()) {
				//buDropdown.click();
				Logger.info("buDropdown is clicked");
				Thread.sleep(2000);
				Select valueFromStatus = new Select(buDropdown);
				List<WebElement> listOfValuesStatus = valueFromStatus.getOptions();
				if (listOfValuesStatus.size() != 0) {
					Logger.info("List of bu is not empty");
					// valueFromStatus.selectByVisibleText(properties.getProperty(status));
					valueFromStatus.selectByVisibleText(businessUnit);
					Logger.info(businessUnit + " bu is selected");
				}
			} else {
				Logger.info("buDropdown not displayed");
				throw new NoSuchElementException("buDropdown is not displayed");
			}
			Thread.sleep(30000);

			WebElement selectPendingAllUsers = driver.findElement(By.xpath("//a[text()='Pending(All Users)']"));
			selectPendingAllUsers.click();
			Thread.sleep(3000);

			WebElement selectAdjustment = driver.findElement(By.xpath("(//div[text()='" + order + "'])[1]"));
			selectAdjustment.click();
			Thread.sleep(3000);

			WebElement approveAdjustment = driver.findElement(By.xpath("//button[@id='reject']"));
			approveAdjustment.click();
			Thread.sleep(3000);
			Logger.info("Adjustment Rejected");

			WebElement confirmApproveAdjustment = driver.findElement(By.xpath("//button[text()='Ok']"));
			confirmApproveAdjustment.click();
			Logger.info("Adjustment Reject Confirmed");
			Thread.sleep(7000);

			dashboardPageInstance.clickOnOrderEntryModule();
			Thread.sleep(3000);
			orderSearch.enterOrderNumber(order);
			orderSearch.clickOnOrderSearchBtn();
			Thread.sleep(2000);

			Thread.sleep(3000);
			orderSearch.clickOnSearchedOrderInvoiced();
			Thread.sleep(7000);
			int insertionCountpost = newOrderInstance.getInsertionsCount();
			Assert.assertEquals(insertionCountpost, insertionCountpre);

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "OrderDisplayTest", "displayOrderAdjustmentSetAutoApprove", "PrioritizedReg2",
			"OrderDisplayOnlineTest", "displayOrder", "Grp4", "RegressionLatest", "Group1", "DsplyReg12",
			"TestPriority", "RerunD", "RegFailed3", "Group1F", "GroupAdjReg", "NewRegression2", "NewRegression", "G1",
			"RerunF2","NewRegression3",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void displayOrderAdjustmentSetAutoApprove(Map<String, String> userData) throws Exception {
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

			OrderEntryHomePage orderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			
			orderSearch.selectBUs("DPR-Daily Press");
			orderSearch.selectStatus("Invoiced");
			orderSearch.advancedLink.click();// Added Shalini
			orderSearch.selectProductType2("Display");// Added Shalini
			orderSearch.selectProduct2("Virginian Pilot");
			orderSearch.clickOnOrderSearchBtn();
			Thread.sleep(2000);

			Thread.sleep(3000);
			String order = orderSearch.orderSearchResult1.getText();
			orderSearch.clickOnSearchedOrderInvoiced();
			Thread.sleep(7000);
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);

			Thread.sleep(3000);
			int insertionCountpre = newOrderInstance.getInsertionsCount();
			newOrderInstance.clickOnAdjustmentRequest();
			Thread.sleep(4000);
			newOrderInstance.setAdjustmentRequest("5");
			Thread.sleep(90000);
			String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
			Logger.info("orderStatus " + orderStatus);

			Thread.sleep(7000);
			int insertionCountpost = newOrderInstance.getInsertionsCount();
			Assert.assertEquals(insertionCountpost, insertionCountpre + 1);
			dashboardPageInstance.clickOnLogout();//swagata

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order",
			"displayOrderPositionColorVerify" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderPositionColorVerify(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_DPR");
			newOrderInstance.enterSoldToCustomer("CU00013249");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 55, 0);
			Thread.sleep(4000);

			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectPositionNonTemp("1", "Coupon");
			Thread.sleep(7000);
			String color = newOrderInstance.getColourForAnInsertion(1);
			Assert.assertEquals(color, "4C");

			dashboardPageInstance.clickOnLogout();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "NovMaintenance","displayOrderCondensedStatement", "PrioritizedReg2", "Grp4", "RegressionLatest", "Group1",
			"TestPriority", "NewRegression2", "NewRegression", "G1", "RerunF2",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void displayOrderCondensedStatement(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.checkUncheckCondensedStatement(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 1, 0);//swagata
			Thread.sleep(4000);
//			newOrderInstance.enterPubDate("1", "21", "Dec", "2021");//swagata
			newOrderInstance.enterPubDateFromExcel("1", 1, 27);//swagata
		Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 1, 1);//swagata
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 1, 2);//swagata
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 2, 3);//swagata
			Thread.sleep(4000);
			newOrderInstance.enterClassCodeForAnInsertion(1, "10060");//partha
			Thread.sleep(4000);
			//Thread.sleep(5000);//joy
			//newOrderInstance.selectSection("1", 1, 4);//joy
			//Thread.sleep(6000); //joy
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			// newOrderInstance.selectAdSize(1, "1/4V (3 x 10.5)");
			// Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA00494");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(2000);
			// newOrderInstance.clickNoLegacyAutoInsertionCreation(); //arka
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
	    Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(7000);
			newOrderInstance.clickCopyOrder();//swagata
			/*WebDriverWait wait = new WebDriverWait(driver, 120);
			Logger.info("START OF COPY ORDER");

			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();
			Thread.sleep(8000);*///swagata
			boolean flag = newOrderInstance.verifycheckUncheckCondensedStatement(true);
			Assert.assertEquals(flag, true);
			dashboardPageInstance.clickOnLogout();
			//newOrderInstance.displayWarningMessageConfirm();//swagata
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderInvalidDateFormat", "Grp4", "PrioritizedReg2", "RegressionLatest", "Group1",
			"NewRegression2", "NewRegression", "G1",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void displayOrderInvalidDateFormat(Map<String, String> userData) throws Exception {
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
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.enterPubDateWithoutCalender("2020/31/12");
			Thread.sleep(5000);
			newOrderInstance.submitOrderWithoutSave();//swagata
			Thread.sleep(4000);
			newOrderInstance.displayCompareErrorMessagePopUp("Please enter a valid date");//swagata
			dashboardPageInstance.clickOnLogout();//swagata
			//newOrderInstance.displayWarningMessageConfirm();//swagata

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "displayOrderInvalidSoldToBillToCustomer", "Grp4", "RegressionLatest", "Group1",
			"NewRegression2", "NewRegression", "G1",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void displayOrderInvalidSoldToBillToCustomer(Map<String, String> userData) throws Exception {
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
			newOrderInstance.validateInvalidSoldToCustomer("CU11");
			newOrderInstance.selectBillToCustomerBU("bu_CTC");
			newOrderInstance.validateInvalidBillToCustomer("CU11111111");
			dashboardPageInstance.clickOnLogout();//swagata
			//newOrderInstance.displayWarningMessageConfirm();//swagata


		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	// arka
	/*
	 * @Test(groups =
	 * {"Order","sdtLegacyPriceDistribution","Grp4","RegressionLatest","Group1",
	 * "NewRegression","G1","RerunF2"}, dataProviderClass =
	 * com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider =
	 * "userData") public void sdtLegacyPriceDistribution(Map<String, String>
	 * userData) throws Exception { try { WebDriver driver =
	 * WebDriverManager.getDriver(); Logger.info("Webdriver is initiated");
	 * 
	 * TribuneUtils utilities = new TribuneUtils(); utilities.launchURL(driver,
	 * Configurator.getConfig().get("SignIn")); utilities.implementWait(driver);
	 * 
	 * SignInPage signinPageinstance = PageFactory.initElements(driver,
	 * SignInPage.class); signinPageinstance.login("success");
	 * 
	 * DashboardPage dashboardPageInstance = PageFactory.initElements(driver,
	 * DashboardPage.class); dashboardPageInstance.clickOnOrderEntryModule();
	 * 
	 * OrderEntryHomePage orderEntryPageInstance =
	 * PageFactory.initElements(driver, OrderEntryHomePage.class);
	 * orderEntryPageInstance.clickOnNewGeneralOrder();
	 * 
	 * NewOrderPage newOrderInstance = PageFactory.initElements(driver,
	 * NewOrderPage.class); newOrderInstance.selectSoldToCustomerBU("bu_SDT");
	 * newOrderInstance.enterSoldToCustomer("CU00475251");
	 * newOrderInstance.selectBilltoSameAsSoldTo();
	 * newOrderInstance.selectOrderType("OrderType_Standard");
	 * newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
	 * Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
	 * Thread.sleep(4000); newOrderInstance.createNewInsertion();
	 * Thread.sleep(4000); newOrderInstance.selectBU("1",59, 0);
	 * Thread.sleep(4000); newOrderInstance.enterPubDate("1","21", "Dec",
	 * "2021"); Thread.sleep(5000); newOrderInstance.selectProductType("1",59,
	 * 1); Thread.sleep(4000); newOrderInstance.selectProduct("1",59, 2);
	 * Thread.sleep(4000); newOrderInstance.selectAdType("1",59, 3);
	 * Thread.sleep(5000); newOrderInstance.selectSection("1",59, 4);
	 * Thread.sleep(6000); newOrderInstance.createDuplicateInsertion("1");
	 * Thread.sleep(7000); newOrderInstance.enterPubDate("1","20", "Dec",
	 * "2021"); Thread.sleep(5000);
	 * 
	 * double totalInsertionPrice =
	 * newOrderInstance.getOnlineInsertionPrice("1", "total");
	 * Logger.info("total insertion price "+totalInsertionPrice);
	 * 
	 * double totalInsertionPrice1 =
	 * newOrderInstance.getOnlineInsertionPrice("2", "total");
	 * Logger.info("total insertion price "+totalInsertionPrice1);
	 * 
	 * newOrderInstance.clickOnInsertionSalesRepSection(1);
	 * //newOrderInstance.removeSalesRepOnInsertion(1); Thread.sleep(4000);
	 * newOrderInstance.addNewSalesRepOnInsertion(2, "SA03612");
	 * Thread.sleep(4000); newOrderInstance.clickOnInsertionSalesRepSection(1);
	 * Thread.sleep(4000); newOrderInstance.applytoAllSalesRepOnInsertion(2);
	 * Thread.sleep(2000); Thread.sleep(4000); newOrderInstance.submitOrder();
	 * Thread.sleep(1000);
	 * newOrderInstance.clickYesLegacyAutoInsertionCreation();
	 * Thread.sleep(1000); String orderID =
	 * orderEntryPageInstance.getOrderNumber();
	 * Logger.info(orderEntryPageInstance.getOrderID());
	 * orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
	 * Thread.sleep(1000);
	 * 
	 * orderEntryPageInstance.clickOnOrder(orderID); Thread.sleep(3000); double
	 * totalInsertionPrice2 = newOrderInstance.getOnlineInsertionPrice("1",
	 * "total"); Logger.info("total insertion price "+totalInsertionPrice2);
	 * Thread.sleep(4000); double totalInsertionPrice3 =
	 * newOrderInstance.getOnlineInsertionPrice("2", "total");
	 * Logger.info("total insertion price "+totalInsertionPrice3);
	 * Thread.sleep(4000); double totalPriceofLegacyExpected =
	 * (totalInsertionPrice-totalInsertionPrice2)+ (totalInsertionPrice1 -
	 * totalInsertionPrice3);
	 * Logger.info("total price of Legacy insertion expected: "
	 * +totalPriceofLegacyExpected); Thread.sleep(4000); double
	 * totalPriceofLegacyActual = newOrderInstance.getOnlineInsertionPrice("3",
	 * "total"); Logger.info("total price of Legacy insertion actual: "
	 * +totalPriceofLegacyActual); Thread.sleep(4000); DecimalFormat value = new
	 * DecimalFormat("#.#"); String price =
	 * value.format(totalPriceofLegacyExpected); String price1 =
	 * value.format(totalPriceofLegacyActual); Assert.assertEquals(price,
	 * price1); Logger.info("Legacy insertion price is as expected "); double
	 * price2 = totalPriceofLegacyActual/2;
	 * 
	 * double price3 = (totalInsertionPrice-totalInsertionPrice2); String price4
	 * = value.format(price2); Logger.info("Half of Legacy Price: "+price4);
	 * String price5 = value.format(price3);
	 * Logger.info("Change of Price of 1st insertion after Legacy added: "
	 * +price4); Assert.assertEquals(price4, price5);
	 * Logger.info("Legacy price equally split as expected ");
	 * dashboardPageInstance.clickOnLogout();
	 * 
	 * } catch (Exception e) { Logger.error(e.getMessage()); throw e; } }
	 */
	@Test(groups = {
			"sdtLegacyPriceDistribution" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void sdtLegacyPriceDistribution(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_SDT");
			newOrderInstance.enterSoldToCustomer("CU00475251");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			int i = 1;
			newOrderInstance.selectBU("1", 59, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "21", "Dec", "2021");
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 59, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 59, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 59, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1", 59, 4);
			Thread.sleep(6000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(7000);
			// newOrderInstance.enterPubDate("1","20", "Dec", "2021");
			newOrderInstance.enterPubDate("2", "20", "Dec", "2021");// payel
			Thread.sleep(5000);

			double totalInsertionPrice = newOrderInstance.getOnlineInsertionPrice("1", "total");
			Logger.info("total insertion price " + totalInsertionPrice);

			double totalInsertionPrice1 = newOrderInstance.getOnlineInsertionPrice("2", "total");
			Logger.info("total insertion price " + totalInsertionPrice1);

			newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(2, "SA03612");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(2);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			newOrderInstance.clickYesLegacyAutoInsertionCreation();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			double totalInsertionPrice2 = newOrderInstance.getOnlineInsertionPrice("1", "total");
			Logger.info("total insertion price " + totalInsertionPrice2);
			Thread.sleep(4000);
			double totalInsertionPrice3 = newOrderInstance.getOnlineInsertionPrice("2", "total");
			Logger.info("total insertion price " + totalInsertionPrice3);
			Thread.sleep(4000);
			double totalPriceofLegacyExpected = (3 * (totalInsertionPrice2) / 100);// payel
			Logger.info("total price of Legacy insertion expected for insertion 1: " + totalPriceofLegacyExpected);// payel
			Thread.sleep(4000);
			double totalPriceofLegacyActual = newOrderInstance.getOnlineInsertionPrice("3", "total");
			Logger.info("total price of Legacy insertion actual for insertion 1: " + totalPriceofLegacyActual);
			Thread.sleep(4000);
			double totalPriceofLegacyExpected1 = (3 * (totalInsertionPrice2) / 100);// payel
			Logger.info("total price of Legacy insertion expected for insertion 2: " + totalPriceofLegacyExpected1);// payel
			Thread.sleep(4000);
			double totalPriceofLegacyActual1 = newOrderInstance.getOnlineInsertionPrice("4", "total");// payel
			Logger.info("total price of Legacy insertion actual for insertion 2: " + totalPriceofLegacyActual1);// payel
			Thread.sleep(4000);
			DecimalFormat value = new DecimalFormat("#.#");
			String price = value.format(totalPriceofLegacyExpected);// payel
			String price1 = value.format(totalPriceofLegacyActual);// payel
			String prices = value.format(totalPriceofLegacyExpected1);// payel
			String prices1 = value.format(totalPriceofLegacyActual1);// payel
			Assert.assertEquals(price, price1);
			Assert.assertEquals(prices, prices1); // payel
			Logger.info("Legacy insertion price is as expected ");
			/*
			 * double price2 = totalPriceofLegacyActual/2;
			 * 
			 * double price3 = (totalInsertionPrice-totalInsertionPrice2);
			 * String price4 = value.format(price2);
			 * Logger.info("Half of Legacy Price: "+price4); String price5 =
			 * value.format(price3); Logger.
			 * info("Change of Price of 1st insertion after Legacy added: "
			 * +price4); Assert.assertEquals(price4, price5);
			 * Logger.info("Legacy price equally split as expected ");
			 */
			dashboardPageInstance.clickOnLogout();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order",
			"sdtLegacySaveSubmit" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void sdtLegacySaveSubmit(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_SDT");
			newOrderInstance.enterSoldToCustomer("CU00475251");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 59, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "21", "Dec", "2021");
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 59, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 59, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 59, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1", 59, 4);
			Thread.sleep(6000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA03612");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.saveOrder();

			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			/*
			 * List<WebElement> list =
			 * driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			 * wait.until(ExpectedConditions.visibilityOfAllElements(list));
			 */
			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
			Thread.sleep(3000);
			dashboardPageInstance.clickOnOrderEntryModule();
			Thread.sleep(3000);
			orderEntryPageInstance.clickOnOrder(orderNumber);
			Logger.info("Saved Order : " + orderNumber);

			wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement));
			Thread.sleep(8000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			newOrderInstance.clickYesLegacyAutoInsertionCreation();
			Thread.sleep(1000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(2);
			Thread.sleep(2000);
			Thread.sleep(4000);

			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderNumber);
			Thread.sleep(3000);
			int insertionCount = newOrderInstance.getInsertionsCount();
			Logger.info("Insrtn count: " + insertionCount);
			Assert.assertEquals(insertionCount, 2);
			dashboardPageInstance.clickOnLogout();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	

	@Test(groups = {"SMaintenance","Order","NovMaintenance", "displayOrderCopyChangeAdSizeSave", "PrioritizedReg2",
			"OrderDisplayOnlineTest", "Grp4", "RegressionLatest", "Group1", "DsplyReg12", "RegFailed3", "Group1F",
			"NewRegression2", "NewRegression", "G1", "RerunF2",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void displayOrderCopyChangeAdSizeSave(Map<String, String> userData) throws Exception {
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
			Thread.sleep(2000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 12, 0);
//			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			newOrderInstance.enterPubDateFromExcel("1",17,27);
			newOrderInstance.selectProductType("1", 12, 1);
			newOrderInstance.selectProduct("1", 12, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 12, 3);
			newOrderInstance.selectSection("1", 12, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA03612");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			// String orderID = orderEntryPageInstance.getOrderNumber();payel
			// Logger.info(orderEntryPageInstance.getOrderID());payel
			String orderID = orderEntryPageInstance.getOrderNumber();//swagata
			Logger.info("Order ID: " + orderID);// payel
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement));
			newOrderInstance.clickCopyOrder();//swagata
			Thread.sleep(3000);
			/*Thread.sleep(8000);
			Logger.info("START OF COPY ORDER");

			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			// driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();//payel
			driver.findElement(By.xpath("//div/button[@id='add-recurrence-pattern']")).click();// payel
			// Thread.sleep(8000);*///swagata		
			newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.selectAdSizeByIndex(1, 5);payel
			newOrderInstance.selectAdSize(1, "Full Page  (6 x 21)");// arka
			Thread.sleep(3000);
			newOrderInstance.saveOrder();
			Thread.sleep(3000);

			String orderNumber1 = orderEntryPageInstance.getOrderIDNewPage();
			newOrderInstance.saveAndCloseOrder();
			// orderEntryPageInstance.clickOnOrder(orderNumber1);//payel

			Thread.sleep(3000);
			Logger.info("Saved Order : " + orderNumber1);
			dashboardPageInstance.clickOnLogout();//swagata

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order",
			"overrideSalesrateFixedRateContract" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void overrideSalesrateFixedRateContract(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00000016");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 17, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "24", "Dec", "2021");
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 17, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.enterClassCodeForAnInsertion(1, "10060");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);

			newOrderInstance.addServiceRep("019167");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(8000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(3000);
			double salesPrice2 = newOrderInstance.getInsertionPrice("1", "sales");
			Logger.info("Sales Price: " + salesPrice2);
			double priceAfterEdit2 = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("Total Price: " + priceAfterEdit2);
			Assert.assertEquals(salesPrice2, priceAfterEdit2);

			newOrderInstance.checkUncheckSalesPrice(1, true);
			Thread.sleep(4000);
			newOrderInstance.editSalesPrice("7",1);
			Thread.sleep(4000);
			newOrderInstance.checkUncheckSalesPrice(1, false);
			Thread.sleep(4000);
			double salesPrice1 = newOrderInstance.getInsertionPrice("1", "sales");
			Logger.info("Sales Price: " + salesPrice1);
			double priceAfterEdit1 = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("Total Price: " + priceAfterEdit1);
			Assert.assertEquals(salesPrice1, priceAfterEdit1);

			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);

			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			double priceAfterEdit3 = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("Total Price: " + priceAfterEdit3);
			boolean flag = false;
			if (priceAfterEdit3 != priceAfterEdit2) {
				flag = true;
			}
			Assert.assertEquals(flag, true);
			dashboardPageInstance.clickOnLogout();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "overrideSalesrateCPMContract",
			"PrioritizedReg2" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void overrideSalesrateCPMContract(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00000016");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 17, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "24", "Dec", "2021");
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 17, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.enterClassCodeForAnInsertion(1, "10020");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);

			newOrderInstance.addServiceRep("019167");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(8000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(3000);
			double salesPrice2 = newOrderInstance.getInsertionPrice("1", "sales");
			Logger.info("Sales Price: " + salesPrice2);
			double priceAfterEdit2 = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("Total Price: " + priceAfterEdit2);
			Assert.assertEquals(salesPrice2, priceAfterEdit2);

			newOrderInstance.checkUncheckSalesPrice(1, true);
			Thread.sleep(4000);
			newOrderInstance.editSalesPrice("7",1);
			Thread.sleep(4000);
			newOrderInstance.checkUncheckSalesPrice(1, false);
			Thread.sleep(4000);
			double salesPrice1 = newOrderInstance.getInsertionPrice("1", "sales");
			Logger.info("Sales Price: " + salesPrice1);
			double priceAfterEdit1 = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("Total Price: " + priceAfterEdit1);
			Assert.assertEquals(salesPrice1, priceAfterEdit1);

			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);

			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			double priceAfterEdit3 = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("Total Price: " + priceAfterEdit3);
			boolean flag = false;
			if (priceAfterEdit3 != priceAfterEdit2) {
				flag = true;
			}
			Assert.assertEquals(flag, true);
			dashboardPageInstance.clickOnLogout();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order",
			"overrideSalesrateFixedRatePromotion" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void overrideSalesrateFixedRatePromotion(Map<String, String> userData) throws Exception {
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
			// Thread.sleep(4000);
			// newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 18, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "24", "Dec", "2021");
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 18, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 18, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 18, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1", 18, 4);
			Thread.sleep(6000);

			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.enterClassCodeForAnInsertion(1, "10000");
			Thread.sleep(4000);
			newOrderInstance.clickOnProgramPriceSelectorDisplay();
			Thread.sleep(4000);
			newOrderInstance.verifyProgramPriceSorting();
			Thread.sleep(4000);
			newOrderInstance.selectFirstSpecialProgramPromotion();
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);

			newOrderInstance.addServiceRep("019167");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(8000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(3000);
			double salesPrice2 = newOrderInstance.getInsertionPrice("1", "sales");
			Logger.info("Sales Price: " + salesPrice2);
			double priceAfterEdit2 = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("Total Price: " + priceAfterEdit2);
			Assert.assertEquals(salesPrice2, priceAfterEdit2);

			newOrderInstance.checkUncheckSalesPrice(1, true);
			Thread.sleep(4000);
			newOrderInstance.editSalesPrice("7",1);
			Thread.sleep(4000);
			newOrderInstance.checkUncheckSalesPrice(1, false);
			Thread.sleep(4000);
			double salesPrice1 = newOrderInstance.getInsertionPrice("1", "sales");
			Logger.info("Sales Price: " + salesPrice1);
			double priceAfterEdit1 = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("Total Price: " + priceAfterEdit1);
			Assert.assertEquals(salesPrice1, priceAfterEdit1);

			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);

			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			double priceAfterEdit3 = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("Total Price: " + priceAfterEdit3);
			boolean flag = false;
			if (priceAfterEdit3 != priceAfterEdit2) {
				flag = true;
			}
			Assert.assertEquals(flag, true);
			dashboardPageInstance.clickOnLogout();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "OrderDisplayTest", "displayOrderTransferInvoicedWithChanges", "PrioritizedReg2",
			"OrderDisplayOnlineTest", "displayOrder", "Grp4", "RegressionLatest", "Group1", "DsplyReg1", "TestPriority",
			"RerunD", "NewRegression2", "NewRegression", "G1",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void displayOrderTransferInvoicedWithChanges(Map<String, String> userData) throws Exception {
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

			OrderEntryHomePage orderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderSearch.selectBussinessUnit("All");
			Thread.sleep(2000);
			orderSearch.selectStatus("Invoiced");
			orderSearch.clickOnOrderSearchBtn();
			Thread.sleep(2000);

			Thread.sleep(3000);
			String order = orderSearch.orderSearchResult1.getText();
			Logger.info("Searched order: " + order);
			orderSearch.clickOnSearchedOrderInvoiced();
			Thread.sleep(7000);
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);

			Thread.sleep(3000);
			newOrderInstance.transferOrder();
			Thread.sleep(1000);
			newOrderInstance.selectOrderType("OrderType_Legal");
			Thread.sleep(4000);
			dashboardPageInstance.clickOnLogout();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "OrderDisplayTest", "displayOrderSearchMultipleStatus", "OrderDisplayOnlineTest",
			"displayOrder", "Grp4", "RegressionLatest", "Group1", "DsplyReg1", "TestPriority", "RerunD",
			"NewRegression2", "NewRegression", "NewRegression", "G1",
			"displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void displayOrderSearchMultipleStatus(Map<String, String> userData) throws Exception {
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

			OrderEntryHomePage orderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderSearch.selectBussinessUnit("All");
			Thread.sleep(2000);
			orderSearch.selectStatus("Submitted");
			Thread.sleep(2000);
			orderSearch.clickOnOrderSearchBtn();
			Thread.sleep(2000);

			Thread.sleep(3000);
			orderSearch.selectStatus("Processed");
			Thread.sleep(2000);
			orderSearch.clickOnOrderSearchBtn();
			Thread.sleep(2000);

			Thread.sleep(3000);
			orderSearch.selectStatus("Changed");
			Thread.sleep(2000);

			orderSearch.clickOnOrderSearchBtn();
			Thread.sleep(2000);

			Thread.sleep(3000);
			orderSearch.verifyOrderStatusSelectedText("Changed, ... (Total: 3)");	//joy
			//orderSearch.verifyOrderStatusSelectedText("Submitted, ... (Total: 3)");
			String order = orderSearch.orderSearchResult.getText();
			Logger.info("Searched order: " + order);
			orderSearch.clickOnSearchedOrder();
			Thread.sleep(7000);

			dashboardPageInstance.clickOnLogout();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "OrderDisplayTest", "displayOrderSaveProcessedOrder", "OrderDisplayOnlineTest",
			"displayOrder", "Grp4", "DsplyReg1", "TestPriority", "RerunD", "RegFailed3",
			"Group1F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderSaveProcessedOrder(Map<String, String> userData) throws Exception {
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

			OrderEntryHomePage orderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderSearch.selectStatus("Processed");
			orderSearch.clickOnOrderSearchBtn();
			Thread.sleep(2000);

			Thread.sleep(3000);
			String order = orderSearch.orderSearchResult.getText();
			orderSearch.clickOnSearchedOrder();
			Thread.sleep(7000);
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);

			Thread.sleep(3000);

			newOrderInstance.selectOrderType("OrderType_Legal");
			Thread.sleep(3000);

			newOrderInstance.saveOrder();

			Thread.sleep(3000);
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
			newOrderInstance.displayErrorMessageMultiple(1);
			// newOrderInstance.displayErrorMessageMultiple(2);
			// newOrderInstance.compareErrorMessageMultiple("Two or more
			// insertion lines with the same Material ID have different ADSizes!
			// These are lines 01-00 02-00",1);
			newOrderInstance.compareErrorMessageMultiple(
					"You have pending SAVED changes that will NOT take effect unless you click on the SUBMIT button!",
					1);

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "displayOrderPriceDetailsVerify", "OrderDisplayOnlineTest", "Grp4", "RegressionLatest", "Group1",
			"DsplyReg1", "RerunD", "RegFailed3",
			"Group1F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderPriceDetailsVerify(Map<String, String> userData) throws Exception {
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
			newOrderInstance.checkUncheckOwnLocalOptOut(false);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 18, 0);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2021");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 18, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 18, 2);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Double totalInsertionPrice11 = newOrderInstance.getInsertionPrice("1", "total");
			String totalInsertionPrice1 = newOrderInstance.convertToPricePattern(totalInsertionPrice11);
			Logger.info("Insertion1 price: " + totalInsertionPrice1);
			Thread.sleep(4000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(2000);
			newOrderInstance.selectProduct("1", 8, 2);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Double totalInsertionPrice21 = newOrderInstance.getInsertionPrice("1", "total");
			String totalInsertionPrice2 = newOrderInstance.convertToPricePattern(totalInsertionPrice21);
			Logger.info("Insertion2 price: " + totalInsertionPrice2);
			Thread.sleep(4000);
			Double totalOrderPrice1 = newOrderInstance.getInsertionPrice("1", "overall");
			String totalOrderPrice = newOrderInstance.convertToPricePattern(totalOrderPrice1);
			Logger.info("Total Order price: " + totalOrderPrice);
			newOrderInstance.clickMoreOptionsOrder();
			Thread.sleep(6000);
			newOrderInstance.verifyPriceDetails(totalOrderPrice, totalOrderPrice, totalOrderPrice, "0.00$",
					totalInsertionPrice1, totalInsertionPrice2);

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/**
	 * Placing a display order with 2 series master card
	 * Check the card is accepted in cyber source or not
	 */
	//swagata
	@Test(groups = {"displayOrderCreditMasterCard","displayOrders","NewRegression3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderCreditMasterCard(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000);
			newOrderInstance.selectPaymentType("Credit Card");
			newOrderInstance.selectCardType("New Card");
			Thread.sleep(5000);
			newOrderInstance.enterCreditCardInfoOrderWithOutMVN("BankAccountInfo","Master2Sesies");
			Thread.sleep(3000);

			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 18, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1", 18, 27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 18, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 18, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 18, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1", 18, 4);
			Thread.sleep(4000);
			/*newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectAdSize(1, "1/4V  (3 x 10.5)");
			Thread.sleep(4000);*/
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			newOrderInstance.submitOrder();
			String orderID = orderEntryPageInstance.getOrderNumber();
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);		
			newOrderInstance.cyberSourceChecking();
			dashboardPageInstance.clickOnLogout();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/**
	 * Validate if order type freezes after invoicing an order
	 */
	//swagata

	@Test(groups = {"orderTypeFreezesInvOrdr","displayOrders","NewRegression3"})
	public void orderTypeFreezesInvOrdr() throws Exception
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

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			basicOrderSearch.selectBussinessUnit("All");
			Logger.info("BU is selected successfully");
			basicOrderSearch.selectStatus("Invoiced");
			Logger.info("Invoiced is selected");
			basicOrderSearch.clickOnOrderSearchBtn();

			String orderID = basicOrderSearch.getFirstInvOrderIdSearchLines();
			Logger.info("Order number is:" +orderID);

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnOrder(orderID);

			Assert.assertEquals(1, newOrderInstance.OrderTypeDisable());
			Logger.info("The order type freezes after invoicing an order");
			dashboardPageInstance.clickOnOrderEntryModule();

			String orderNum = newOrderInstance.getOrderFromTransferExcel(2, 1);
			Logger.info("Order number" + orderNum);
			orderEntryPageInstance.clickOnOrder(orderNum);
			Assert.assertEquals(1, newOrderInstance.OrderTypeDisable());
			Logger.info("The order type freezes when an insertion line is invoiced in an order or partial invoiced");

			dashboardPageInstance.clickOnLogout();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/**
	 * Validate that sales price is retained with the overwritten value 
	 * when IO is Converted to order.
	 *///swagata
	@Test(groups = {"salesPriceRetainedFrmIOtoOrder","insertionOrders","NewRegression3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void salesPriceRetainedFrmIOtoOrder(Map<String, String> userData) throws Exception
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
			newOrderInstance.selectSoldToCustomerBU("bu_ALT");
			newOrderInstance.enterSoldToCustomer("CU00258088");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.enterComments();
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",27, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",27,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",27, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",27, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",27, 3);
			newOrderInstance.collapseInsertionDetails("1");
			newOrderInstance.viewInsertionDetails("2");
			double givenPrice = 20;
			newOrderInstance.editSalesPrice(Double.toString(givenPrice),2);
			newOrderInstance.collapseInsertionDetails("2");
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			//newOrderInstance.clickNoLegacyAutoInsertionCreation();
			

			//String orderID = orderEntryPageInstance.getOrderNumber();
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order: "+orderID);
			WebDriverWait wait = new WebDriverWait(driver,120);
			Thread.sleep(3000);
			orderEntryPageInstance.clickOnOrder(orderID);
			wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement)); 
			newOrderInstance.convertInsertion();
			wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement)); 
			newOrderInstance.viewInsertionDetails("2");
			Assert.assertEquals(givenPrice,newOrderInstance.getInsertionPrice("2","sales"),.00);
			Logger.info(" The sales price is retained with the overwritten value when IO is Converted to order.");



		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/*
	 * Validate that add on charges is not removing when unlocking the sales price for the below types of Add on charges for display
	 *///swagata
	@Test(groups = {"SMaintenance","displayOrders","addOnFeesNotRemovingAftrUnckingSalesPrice","NewRegression3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void addOnFeesNotRemovingAftrUnckingSalesPrice(Map<String, String> userData) throws Exception {
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
			Thread.sleep(2000);
			newOrderInstance.enterPubDateFromExcel("1", 17, 27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 12, 1);
			Thread.sleep(2000);
			newOrderInstance.selectProduct("1", 12, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 12, 3);
			newOrderInstance.selectSection("1", 12, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.clickOnAddOnMagnifier();
			Thread.sleep(4000);
			newOrderInstance.clickFirstFeesAddButton();
			Thread.sleep(4000);
			newOrderInstance.clickOnConfirmFeesButton();
			Thread.sleep(4000);
			double addOnCharge = newOrderInstance.getInsertionPrice("1", "addon charge");
			Logger.info("Add on Charge for 1st insertion with 4C colour: " + addOnCharge);
			double salesPrice = newOrderInstance.getInsertionPrice("1", "sales");
			Logger.info("Sales Price: " + salesPrice);
			newOrderInstance.collapseInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			newOrderInstance.submitOrder();
			newOrderInstance.ClickContinueButton();
			Thread.sleep(2000);
			
			dashboardPageInstance.clickOnLogout();
			
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/*
	 * Validate that user with below roles is able to update accountability and reason for adjustment <2500 QA
	 *///swagata
	@Test(groups = { "Order", "OrderDisplayTest", "updateAdjustmentAccountabilityReason","NewRegression2","displayOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void updateAdjustmentAccountabilityReason(Map<String, String> userData) throws Exception {
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

			OrderEntryHomePage orderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderSearch.selectStatus("Invoiced");
			orderSearch.clickOnOrderSearchBtn();
			Thread.sleep(2000);

			Thread.sleep(3000);
			String order = orderSearch.orderSearchResult1.getText();
			orderSearch.clickOnSearchedOrderInvoiced();
			Thread.sleep(7000);
			final NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);

			Thread.sleep(3000);
			//int insertionCountpre = newOrderInstance.getInsertionsCount();
			newOrderInstance.clickOnAdjustmentRequest();
			Thread.sleep(4000);
			String[] values =newOrderInstance.setAdjustmentRequest("5");
			Wait<WebDriver> Fwait = new FluentWait<WebDriver>(driver)						
        			.withTimeout(500, TimeUnit.SECONDS) 			
        			.pollingEvery(2, TimeUnit.SECONDS) 			
        			.ignoring(NoSuchElementException.class);	
        	//WebElement clickseleniumlink = Fwait.until(new Function<WebDriver, WebElement>(){
        	
        		//public WebElement apply(WebDriver driver ) {
        			//return 	newOrderInstance.ownLocalOptOutCheckBox;

        		//}
        	//});			
        	String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
			Logger.info("orderStatus " + orderStatus);
			Thread.sleep(4000);

			//int insertionCountpost = newOrderInstance.getInsertionsCount();
			//Assert.assertEquals(insertionCountpost, insertionCountpre + 1);
			newOrderInstance.clickOnAdjustmentRequestHistory();
			//newOrderInstance.updateReasonAccountabilityAdjustment(values[0],values[1]);
			Thread.sleep(2000);
			dashboardPageInstance.clickOnLogout();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/*
	 * Validate that a new button 'Delete' is added in order details page for saved order
	 * Validate that Undo button is added in order details page for the deleted orders to revert the action
	 * 
	 *///swagata
	@Test(groups = { "Order","deleteUndoOrder","displayOrderSanity","NewRegression2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void deleteUndoOrders(Map<String, String> userData) throws Exception {
		try {
				WebDriver driver = WebDriverManager.getDriver();
				Logger.info("Webdriver is initiated");

				TribuneUtils utilities = new TribuneUtils();
				utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
				utilities.implementWait(driver);
				//Thread.sleep(50000);

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
				newOrderInstance.saveOrder();
				newOrderInstance.deleteOrder();
				newOrderInstance.undoDeleteOrder(); 
				dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
}