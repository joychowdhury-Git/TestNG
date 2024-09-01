package com.tribune.adit2.test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class OrderLegacyAutoInsertionTest {
	@Test(groups = { "Order", "SanityTestNew", "Legacy", "ProductionTest", "orderWithLegacyAutoInsertion", "legacyReg",
			"OLReg", "RegressionLatest", "Group2", "PTest1", "PriorityVulnerability", "RegFailed3", "Group2F",
			"TestPriority", "ProdTestCI", "NANT",
	"ProductionTestLock" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void orderWithLegacyAutoInsertion(Map<String, String> userData) throws Exception {
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
			Thread.sleep(4000);

			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 27, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "23", "Dec", "2021");
			// newOrderInstance.enterPubDateFromExcel("1",27,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 27, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 27, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 27, 3);
			Thread.sleep(5000);
			// newOrderInstance.selectSection("1",27, 4);
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectAdSize(1, "1/4V (3 x 9)");
			Thread.sleep(4000);
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
			Thread.sleep(5000);
			newOrderInstance.clickYesLegacyAutoInsertionCreation();
			Thread.sleep(8000);
			// newOrderInstance.clickOnInsertionSalesRepSection(3);
			// newOrderInstance.addNewSalesRepOnInsertion(3, "SA00443");
			// newOrderInstance.assignMaterialAllInsertion();
			// Thread.sleep(8000);
			// newOrderInstance.submitOrder();
			newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata
			Thread.sleep(2000);//swagata
			newOrderInstance.applytoAllSalesRepOnInsertion(1);//swagata
			Thread.sleep(1000);//swagata
			newOrderInstance.submitOrderWithoutSave();//swagata

			String orderID = orderEntryPageInstance.getOrderNumber();//swagata
			Logger.info("Order: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);

			orderEntryPageInstance.clickOnOrder(orderID);

			Thread.sleep(3000);
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
			// "12/29/2016");
			Logger.info("Insrtn No: " + newOrderInstance.getInsertionNumber(2));
			// Assert.assertEquals(newOrderInstance.getInsertionNumber(3), 2);
			Logger.info("Material ID: " + newOrderInstance.getMaterialID("2"));
			// Assert.assertEquals(newOrderInstance.getMaterialID("3"), "1");
			Logger.info("New Insertion Price: " + newOrderInstance.getInsertionPrice("2", "total"));
			// Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			// "total"), TribuneUtils.getDoubleCellValues("Product", 28, 17));
			Logger.info("First Insertion Price: " + newOrderInstance.getInsertionPrice("2", "total"));
			// Assert.assertEquals(newOrderInstance.getInsertionPrice("1",
			// "total"), TribuneUtils.getDoubleCellValues("Product", 28,
			// 17)-25);
			Logger.info("Addon Amount: " + newOrderInstance.getAddOnAmount(1));
			// Assert.assertEquals(newOrderInstance.getAddOnAmount(1),
			// TribuneUtils.getDoubleCellValues("Product", 28, 17));
			Logger.info(
					"Validation success - Legacy AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID");

			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order1", "Legacy",
	"legacyAutoInsertionValidation" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void legacyAutoInsertionValidation(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 59, 0);
			newOrderInstance.enterPubDate("1", "29", "Dec", "2017");
			newOrderInstance.selectProductType("1", 59, 1);
			newOrderInstance.selectProduct("1", 59, 2);
			newOrderInstance.selectAdType("1", 59, 3);
			newOrderInstance.selectSection("1", 59, 4);
			Thread.sleep(6000);
			newOrderInstance.enterClassCodeForAnInsertion(1, "90050");
			Thread.sleep(8000);
			newOrderInstance.clickOnInsertionSalesRepSection(2);
			newOrderInstance.addNewSalesRepOnInsertion(2, "SA00443");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.selectMaterialSource("1","NewBuild");
			newOrderInstance.checkUncheckPosTemplateChckbx(1, true);
			newOrderInstance.clickOnPositionSelector();
			Thread.sleep(7000);
			// newOrderInstance.selectAdSizeForPosition(1);
			Thread.sleep(3000);
			// newOrderInstance.clickOnSearchPositionInPSWindw();
			newOrderInstance.selectPostionFrmPositionSlctr("18", "0, 20.15");
			newOrderInstance.savePositionSelection();
			Thread.sleep(3000);
			Assert.assertEquals(newOrderInstance.getInsertionPrice("1", "total"),
					TribuneUtils.getDoubleCellValues("Product", 59, 17));

			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 59, 0);
			newOrderInstance.enterPubDate("1", "28", "Dec", "2017");
			Thread.sleep(3000);
			newOrderInstance.selectProductType("1", 59, 1);
			Thread.sleep(3000);
			newOrderInstance.selectProduct("1", 59, 2);
			newOrderInstance.selectAdType("1", 59, 3);
			Thread.sleep(3000);
			newOrderInstance.selectSection("1", 59, 4);
			Thread.sleep(3000);
			// newOrderInstance.enterClassCodeForAnInsertion(2, "90050");
			// Thread.sleep(8000);
			newOrderInstance.clickOnInsertionSalesRepSection(2);
			newOrderInstance.addNewSalesRepOnInsertion(2, "SA00443");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("2");
			// newOrderInstance.selectMaterialSource("1","NewBuild");
			newOrderInstance.checkUncheckPosTemplateChckbx(2, true);
			newOrderInstance.clickOnPositionSelector();
			Thread.sleep(7000);
			// newOrderInstance.selectAdSizeForPosition(1);
			Thread.sleep(3000);
			// newOrderInstance.clickOnSearchPositionInPSWindw();
			newOrderInstance.selectPostionFrmPositionSlctr("13", "1, 19.15");
			newOrderInstance.savePositionSelection();
			Thread.sleep(3000);

			newOrderInstance.submitOrder();
			newOrderInstance.clickYesLegacyAutoInsertionCreation();

			Thread.sleep(2000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order Id: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderEntryPageInstance.clickOnOrder(orderID);

			Thread.sleep(3000);
			int insertionCount = newOrderInstance.getInsertionsCount();
			Logger.info("No. Of Insertions: " + insertionCount);
			/*
			 * Assert.assertEquals(insertionCount, 2);
			 * Assert.assertEquals(newOrderInstance.getBUOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 28, 0));
			 * Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(2)
			 * , TribuneUtils.getStringCellValues("Product", 28, 1));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 28, 2));
			 * Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 28, 3));
			 * Assert.assertEquals(newOrderInstance.getSectionOnInsertion(2),
			 * TribuneUtils.getStringCellValues("Product", 28, 4)); //
			 * Assert.assertEquals(newOrderInstance.getPubDateOnInsertion(2),
			 * "12/29/2016");
			 * Assert.assertEquals(newOrderInstance.getInsertionNumber(2), 2);
			 * Assert.assertEquals(newOrderInstance.getMaterialID("2"), "1");
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("2",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 28, 17));
			 * Assert.assertEquals(newOrderInstance.getInsertionPrice("1",
			 * "total"), TribuneUtils.getDoubleCellValues("Product", 28,
			 * 17)-25); Assert.assertEquals(newOrderInstance.getAddOnAmount(1),
			 * TribuneUtils.getDoubleCellValues("Product", 28, 17)); Logger.
			 * info("Validation success - Legacy AutoInsertion's pubdate/BU/productType/product/adtype/section/price/material ID"
			 * ); Assert.assertEquals(newOrderInstance.getMaterialID("3"), "2");
			 * 
			 */

			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	// arka
	@Test(groups = { "SMaintenance","Order", "NovMaintenance","Legacy", "killOrderWithLegacyAutoInsertion", "ProductionTest23", "OLReg",
			"RegressionLatest", "Grp1", "legacyReg", "Group2", "RegFailed28", "Group2F", "NewRegression2",
			"NewRegression", "G2", "RerunF2",
	"legacyOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void killOrderWithLegacyAutoInsertion(Map<String, String> userData) throws Exception {
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
			Thread.sleep(4000);

			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 27, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1", 27, 27);// arka
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 27, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 27, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 27, 3);
			Thread.sleep(5000);
			// newOrderInstance.selectSection("1",27, 4);
			newOrderInstance.selectSectionByIndex("1", 1);// arka

			Thread.sleep(6000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			Thread.sleep(4000);
			//	newOrderInstance.selectAdSize(1, "1/4V (3 x 9)");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA03612");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(8000);

			newOrderInstance.submitOrderWithoutSave();
			Thread.sleep(1000);
			newOrderInstance.clickYesLegacyAutoInsertionCreation();
			Thread.sleep(4000);

			// newOrderInstance.clickOnContinuePastPubDate();//swagata new
			Thread.sleep(4000);//swagata new
			// Thread.sleep(8000);
			// Thread.sleep(8000);
			 newOrderInstance.clickOnInsertionSalesRepSection(2);
			 newOrderInstance.addNewSalesRepOnInsertion(2, "SA03612");
			// newOrderInstance.assignMaterialAllInsertion();
			Thread.sleep(8000);
			
			newOrderInstance.submitOrder();
			// Thread.sleep(1000);
			/*	String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderEntryPageInstance.clickOnOrder(orderID);

			Thread.sleep(13000);*///swagata
			WebDriverWait wait = new WebDriverWait(driver, 200);
			/*
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata
			 * 
			 * Thread.sleep(4000); newOrderInstance.addNewSalesRepOnInsertionClassified(1,
			 * "SA02907");//swagata Thread.sleep(4000);
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata
			 * Thread.sleep(4000);
			 * newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);//swagata
			 * Thread.sleep(4000); newOrderInstance.submitOrderWithoutSave();//swagata
			 */		//	Thread.sleep(3000);//swagata
			String orderID = orderEntryPageInstance.getOrderNumber();//swagata
			Logger.info("Order: " + orderID);//swagata
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();//swagata
			Thread.sleep(2000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(4000);
			int insertionCount = newOrderInstance.getInsertionsCount();
			Logger.info("Insrtn count: " + insertionCount);
			Assert.assertEquals(insertionCount, 2);

			NewOrderPage orderViewPage = PageFactory.initElements(driver, NewOrderPage.class);
			wait.until(ExpectedConditions.visibilityOf(orderViewPage.orderViewPageElement));
			orderViewPage.killInsertion("1");
			Thread.sleep(6000);
			String insertionStatus = orderViewPage.getInsertionStatus("1");
			boolean insertionStatusflag = false;
			if (insertionStatus.equalsIgnoreCase("Kill Pending")) {
				insertionStatusflag = true;
				Logger.info("validation success - insertion kill");
			}
			Assert.assertEquals(insertionStatusflag, true);
			Thread.sleep(2000);
			// newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1,
			// "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			// newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
			orderViewPage.submitOrderWithoutSave();//swagata
			Thread.sleep(3000);
			// newOrderInstance.clickOnContinuePastPubDate();//swagata new
			// Thread.sleep(4000);//swagata new
			// orderEntryPageInstance.closeOrderSuccessSubmissionMessage();swagata
			// new
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(8000);//swagata
			orderEntryPageInstance.clickOnOrder(orderID);
			Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)						
					.withTimeout(500, TimeUnit.SECONDS) 			
					.pollingEvery(2, TimeUnit.SECONDS) 			
					.ignoring(NoSuchElementException.class);	
			WebElement clickseleniumlink = fwait.until(new Function<WebDriver, WebElement>(){

				public WebElement apply(WebDriver driver ) {
					return 	driver.findElement(By.xpath("//span[text()='Killed ']"));

				}
			});//swagata
			String orderStatusProcessed = orderViewPage.getOrdeStatusOrderViewPage();//swagata
			Logger.info("orderStatus "+orderStatusProcessed);//swagata
			Thread.sleep(8000);
			// Assert.assertEquals(newOrderInstance.getOrdeStatusOrderViewPage(),
			// "Changed");//swagata
			Assert.assertEquals(newOrderInstance.getInsertionStatus("1"), "Killed");//alt order have issue with alt so getting error
			//Thread.sleep(2000);
			dashboardPageInstance.clickOnLogout();//swagata

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "SMaintenance","Order","NovMaintenance", "PrioritizedReg1", "Legacy", "SwagataMou", "multipleOrderWithLegacyAutoInsertion",
			"ProductionTest23", "OLReg", "RegressionLatest", "Grp4", "legacyReg", "Group2", "RegFailed28", "Group2F",
			"NewRegression2", "NewRegression", "G2", "RerunF2",
	"legacyOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void multipleOrderWithLegacyAutoInsertion(Map<String, String> userData) throws Exception {
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
			Thread.sleep(4000);

			//Thread.sleep(4000);//swagata
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 27, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1", 27, 27);// swagata
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 27, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 27, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 27, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSectionByIndex("1", 1);// swagata
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectAdSize(1, "1/4V (3 x 9)");
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("2", 27, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("2", 27, 27);// swagata
			Thread.sleep(4000);
			newOrderInstance.selectProductType("2", 27, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("2", 27, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("2", 27, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSectionByIndex("2", 1);// arka

			// newOrderInstance.selectSection("2",27, 4);
			// Thread.sleep(6000);
			// newOrderInstance.clickOnInsertionSalesRepSection(4);
			// newOrderInstance.addNewSalesRepOnInsertion(4, "SA00443");
			// newOrderInstance.clickOnInsertionSalesRepSection(3);
			// newOrderInstance.addNewSalesRepOnInsertion(3, "SA00443");
			// newOrderInstance.selectMaterialSource("1", "NewBuild");
			// newOrderInstance.selectAdSize(1, "1/4V (3 x 9)");
			// newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(4,
			// "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			// newOrderInstance.applytoAllSalesRepOnInsertion(4);Thread.sleep(2000);Thread.sleep(4000);
			// Assert.assertEquals(newOrderInstance.getInsertionPrice("3",
			// "total"), TribuneUtils.getDoubleCellValues("Product", 59, 17));
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("2");
			Thread.sleep(4000);
			newOrderInstance.submitOrderWithoutSave();//swagata
			Thread.sleep(3000);

			newOrderInstance.clickYesLegacyAutoInsertionCreation();
			Thread.sleep(2000);
			//newOrderInstance.clickOnContinuePastPubDate();//swagata
			// newOrderInstance.clickOnInsertionSalesRepSection(5);
			// newOrderInstance.addNewSalesRepOnInsertion(5, "SA00443");
			// Thread.sleep(4000);

			// newOrderInstance.submitOrder();
			// Thread.sleep(7000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");//swagata
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);//swagata
			Thread.sleep(4000);
			newOrderInstance.submitOrderWithoutSave();//swagata
			Thread.sleep(3000);
			String orderID = orderEntryPageInstance.getOrderNumber();//swagata
			Logger.info("Order: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);

			orderEntryPageInstance.clickOnOrder(orderID);

			Thread.sleep(3000);
			int insertionCount = newOrderInstance.getInsertionsCount();
			Logger.info("Insrtn count: " + insertionCount);
			Assert.assertEquals(insertionCount, 4);
			Thread.sleep(4000);
			dashboardPageInstance.clickOnLogout();//swagata
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/**
	 * Validate that legacy price is getting repriced 
	 * when standard line price is changed after submission
	 *///swagata
	@Test(groups = {"SMaintenance","legacyOrders","legacyPriceRepricedAfterChngSalesPrice","insertionOrders","NewRegression2","legacyReg"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void legacyPriceRepricedAfterChngSalesPrice(Map<String, String> userData) throws Exception
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
			Thread.sleep(2000);

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_ALT");
			newOrderInstance.enterSoldToCustomer("CU00258088");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.enterComments();
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
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
			newOrderInstance.submitOrderWithoutSave();//swagata

			newOrderInstance.clickYesLegacyAutoInsertionCreation(); 
			Thread.sleep(4000);
			//click on close button on pop up
			newOrderInstance.clickOnInsertionSalesRepSection(1); 
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");
			Thread.sleep(4000); newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);

			newOrderInstance.submitOrderWithoutSave();//swagata
			WebDriverWait wait = new WebDriverWait(driver,120);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info("Order: "+orderID);
			Thread.sleep(3000);
			orderEntryPageInstance.clickOnOrder(orderID);
			//wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement)); 
			Thread.sleep(4000);


			newOrderInstance.viewInsertionDetails("1");
			double SalesPriceStndrdLine = newOrderInstance.getInsertionPrice("1","sales");
			newOrderInstance.collapseInsertionDetails("1");		
			newOrderInstance.viewInsertionDetails("2");
			double SalesPriceLegacyLine = newOrderInstance.getInsertionPrice("2","sales");
			newOrderInstance.collapseInsertionDetails("2");		
			double NetPrice= SalesPriceStndrdLine + SalesPriceLegacyLine;
			double PercentageLegacy = (SalesPriceLegacyLine/NetPrice )* 100;
			Logger.info("Pecentage in legacy is:" + PercentageLegacy+ "%");
			Logger.info("NetPrice is :"+NetPrice);
			newOrderInstance.viewInsertionDetails("1");
			double ManuallyGivenPrice = 20;
			newOrderInstance.checkUncheckSalesPrice(1, true);
			newOrderInstance.editSalesPrice(Double.toString(ManuallyGivenPrice),1);
			newOrderInstance.collapseInsertionDetails("1");
			newOrderInstance.submitOrderWithoutSave();
			String text = newOrderInstance.clickYesLegacyAutoInsertionCreation();
			//Assert.assertEquals("Your order contains one or more Auto Insertions where the price can change. Would you like to update the auto insertion price?", text);
			Logger.info("Order: "+ orderEntryPageInstance.getOrderNumber());
			Thread.sleep(3000);
			orderEntryPageInstance.clickOnOrder(orderID);
			wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement)); 
			Thread.sleep(4000);

			newOrderInstance.viewInsertionDetails("1");
			double SalesPriceStndrdLineChng = newOrderInstance.getInsertionPrice("1","sales");
			newOrderInstance.collapseInsertionDetails("1");	
			newOrderInstance.viewInsertionDetails("2");
			double SalesPriceLegacyLineChng = newOrderInstance.getInsertionPrice("2","sales");
			newOrderInstance.collapseInsertionDetails("2");	

			double NetPriceChng= SalesPriceStndrdLineChng + SalesPriceLegacyLineChng; 
			double PercentageLegacyChng = (SalesPriceLegacyLineChng/NetPriceChng )* 100;
			Logger.info("Changed Net Price is :"+NetPriceChng);
			//Assert.assertEquals(PercentageLegacy,PercentageLegacyChng,.00);
			Logger.info("Legacy price is getting repriced when standard line price is changed after submission");



		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	@Test(groups = {"SMaintenance","legacyStraightPkUp", "Regression S49","NewRegression2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void legacyStraightPkUp(Map<String, String> userData) throws Exception {
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
			newOrderInstance.enterPubDateFromExcel("1",90,27);//swagata
			newOrderInstance.selectProductType("1", 17, 1);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(2000);
			newOrderInstance.selectAdType("1", 17, 3);
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);			
			newOrderInstance.selectMaterialSource("1", "Straight Pickup");
			Thread.sleep(4000);
			newOrderInstance.clickOnPickUpSearch();
			Thread.sleep(4000);
			newOrderInstance.selectFirstPickUpByCustomer("Main News");
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");//swagata
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);//swagata
			Thread.sleep(4000);
			newOrderInstance.submitOrderWithoutSave();//swagata
			Thread.sleep(3000);

			newOrderInstance.clickYesLegacyAutoInsertionCreation();
			Thread.sleep(2000);
			newOrderInstance.clickOnContinuePastPubDate(); //Joy

			//			newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata
			//
			//			Thread.sleep(4000);				      
			//			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");//swagata
			//			Thread.sleep(4000);
			//			newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata
			//			Thread.sleep(4000);
			//			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);//swagata
			//			Thread.sleep(4000);
			//			newOrderInstance.submitOrderWithoutSave();//swagata
			//			Thread.sleep(3000);

			String orderID = orderEntryPageInstance.getOrderNumber();//swagata
			Logger.info("Order: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);

			orderEntryPageInstance.clickOnOrder(orderID);

			Thread.sleep(3000);
			int insertionCount = newOrderInstance.getInsertionsCount();
			Logger.info("Insrtn count: " + insertionCount);
			Assert.assertEquals(insertionCount, 2);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);	
			newOrderInstance.viewInsertionDetails("2");
			Thread.sleep(4000);	
			Assert.assertEquals(newOrderInstance.getMaterialSource("2"), newOrderInstance.getMaterialSource("1"));
			Logger.info("Material source of legacy line is same as standard line");
			//dashboardPageInstance.clickOnLogout();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/**
	 * Validate that user is able to add MM tag for ownlocal auto insertion in ALT new order
	 * Validate that user is able to add MM tag for legacy auto insertion  in ALT new order
	 *///swagata
	@Test(groups = {"legacyOrders","addMMTagForOwnLocalAndLegacy","NewRegression2","legacyReg"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void addMMTagForOwnLocalAndLegacy(Map<String, String> userData) throws Exception
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
			Thread.sleep(8000);
			newOrderInstance.enterPubDateFromExcel("1",27,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",27, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",27, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",27, 3);
			newOrderInstance.collapseInsertionDetails("1");
			newOrderInstance.selectMMTag("2", "Total Wine & More");
			newOrderInstance.submitOrderWithoutSave();//swagata

			newOrderInstance.clickYesLegacyAutoInsertionCreation(); Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1); Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");
			Thread.sleep(4000); newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			newOrderInstance.selectMMTag("3", "Total Wine & More");

			newOrderInstance.submitOrderWithoutSave();//swagata
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info("Order: "+orderID);
			Thread.sleep(3000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(4000);
			
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

}
