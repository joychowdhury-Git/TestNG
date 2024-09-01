package com.tribune.adit2.test;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.ClassifiedOrderOptions;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.OrderEntry.OrderNewTearsheetProofPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

public class OrderPreprintTest {
	/**
	 * This test will create a new order for a preprint product type
	 */
	@Test(groups = { "PrdSanityNew", "Order", "SanityTestNew", "ProductionTest", "preprintOrder12", "OrderPreprintTest",
			"reRunP", "ProductionTestPriority",
			"ProductionTestCI", "ProdTestCI", "Patch14",
			"ProductionTestLock" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrder(Map<String, String> userData) throws Exception {
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
			Thread.sleep(3000);
			newOrderInstance.selectBU("1", 43, 0);
			Thread.sleep(3000);
			newOrderInstance.enterPubDateFromExcel("1", 43, 27);
			Thread.sleep(3000);
			newOrderInstance.selectProductType("1", 43, 1);
			Thread.sleep(3000);
			newOrderInstance.selectProduct("1", 43, 2);
			Thread.sleep(3000);
			// newOrderInstance.selectAdType("1",35, 3);
			// Thread.sleep(10000);
			// newOrderInstance.selectSection("1",35, 4);
			// Thread.sleep(10000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(3000);
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(200000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			newOrderInstance.saveOrder();

			Thread.sleep(3000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : " + orderNumber);
			// newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1,
			// "SA01380");Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(3000);

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "multiInsertionPreprint", "OrderPreprintTest", "RegressionLatest", "reRunP",
			"PreprintReg", "Grp4", "Pre1", "Group5", "RegFailed3", "RegFailed3", "reRunP",
			"Group5F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void multiInsertionPreprint(Map<String, String> userData) throws Exception {
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
			WebDriverWait wait = new WebDriverWait(driver, 120);
			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 10, 0);
			Thread.sleep(3000);
			newOrderInstance.enterPubDate("1", "20", "Dec", "2019");
			Thread.sleep(3000);
			newOrderInstance.selectProductType("1", 10, 1);
			Thread.sleep(3000);
			newOrderInstance.selectProduct("1", 10, 2);
			Thread.sleep(3000);
			newOrderInstance.selectAdType("1", 10, 3);
			Thread.sleep(5000);
			// newOrderInstance.selectSection("1",10, 4);
			// Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(40000);
			// newOrderInstance.clickOnSearchZoneLink();
			Thread.sleep(3000);
			newOrderInstance.selectZonePreprintOrder("Full");
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(4000);
			// newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
			double priceFirstInsertion = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("FirstInsertion price= " + priceFirstInsertion);
			Thread.sleep(2000);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("2", 10, 0);
			Thread.sleep(3000);
			newOrderInstance.enterPubDate("2", "21", "Dec", "2019");
			Thread.sleep(3000);
			newOrderInstance.selectProductType("2", 10, 1);
			Thread.sleep(3000);
			newOrderInstance.selectProduct("2", 10, 2);
			Thread.sleep(3000);
			newOrderInstance.selectAdType("2", 10, 3);
			Thread.sleep(5000);
			// newOrderInstance.selectSection("2",10, 4);
			// Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("2");
			newOrderInstance.addOrEditInsersionVerisonID("2", 2);
			// newOrderInstance.selectMaterialSource("2","N/A");
			newOrderInstance.clickOnDistributions(2);
			Thread.sleep(40000);
			// newOrderInstance.clickOnSearchZoneLink();
			Thread.sleep(3000);
			newOrderInstance.selectZonePreprintOrder("Full");
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(4000);
			// newOrderInstance.clickOnInsertionSalesRepSection(2);
			// newOrderInstance.addNewSalesRepOnInsertion(2, "SA00443");
			double priceSecondInsertion = newOrderInstance.getInsertionPrice("2", "total");
			Logger.info("SecondInsertion price " + priceSecondInsertion);
			Thread.sleep(1000);
			boolean flag = false;
			Logger.info("count" + newOrderInstance.getInsertionsCount());
			if (newOrderInstance.getInsertionsCount() > 1) {
				flag = true;
			}
			Assert.assertEquals(flag, true);
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
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(3000);
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	// arka
	/*
	 * @Test(groups =
	 * {"Order","preprintOrderZoneGroupForce","OrderPreprintTest",
	 * "RegressionLatest","reRunP","PreprintReg","Grp4","Pre1","Group5",
	 * "RegFailed3","Group5F","NewRegression","G5","RerunF2"}, dataProviderClass
	 * = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider =
	 * "userData") public void preprintOrderZoneGroupForce(Map<String, String>
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
	 * NewOrderPage.class); newOrderInstance.selectSoldToCustomerBU("bu_LAT");
	 * newOrderInstance.enterSoldToCustomer("CU00059747");
	 * newOrderInstance.selectBilltoSameAsSoldTo();
	 * newOrderInstance.selectOrderType("OrderType_Standard");
	 * newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
	 * newOrderInstance.createNewInsertion(); newOrderInstance.selectBU("1",35,
	 * 0); newOrderInstance.enterPubDate("1","22", "Dec", "2019");
	 * newOrderInstance.selectProductType("1",35, 1);
	 * newOrderInstance.selectProduct("1",35, 2); Thread.sleep(3000);
	 * newOrderInstance.selectAdType("1",35, 3); Thread.sleep(5000); //
	 * newOrderInstance.selectSection("1",35, 4); // Thread.sleep(4000);
	 * newOrderInstance.viewInsertionDetails("1");
	 * newOrderInstance.addOrEditInsersionVerisonID("1", 1); //
	 * newOrderInstance.selectMaterialSource("1","N/A");
	 * newOrderInstance.clickOnDistributions(1); Thread.sleep(40000); ////
	 * newOrderInstance.clickOnSearchZoneLink(); Thread.sleep(3000);
	 * newOrderInstance.selectZonePreprintOrder("Full"); // int
	 * countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
	 * newOrderInstance.confirmZoneSelection(); int distributionsCount =
	 * newOrderInstance.getDistributionsAdded();
	 * Logger.info("distributionsCount "+distributionsCount); //
	 * Assert.assertEquals(countOfZoneAssigned,2); /*boolean totalPriceFlag =
	 * false; double totalInsertionPrice =
	 * newOrderInstance.getPreprintInsertionPrice("1", "total");
	 * Logger.info(""+newOrderInstance.getPreprintInsertionPrice("1", "total"));
	 * Logger.info(""+TribuneUtils.getDoubleCellValues("Product",10, 17));
	 * if(totalInsertionPrice==TribuneUtils.getDoubleCellValues("Product",10,
	 * 17)) { totalPriceFlag = true; Logger.info("total insertion price "
	 * +totalInsertionPrice+" is as per the pricing logics"); }
	 * 
	 * Assert.assertEquals(totalPriceFlag, true);
	 * 
	 * Thread.sleep(2000);newOrderInstance.clickOnInsertionSalesRepSection(1);
	 * Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1,
	 * "SA01380");Thread.sleep(4000);newOrderInstance.
	 * clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);
	 * Thread.sleep(4000); newOrderInstance.submitOrder(); Thread.sleep(1000);
	 * Logger.info(orderEntryPageInstance.getOrderID());
	 * orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
	 * Thread.sleep(2000); dashboardPageInstance.clickOnLogout(); } catch
	 * (Exception e) { Logger.error(e.getMessage()); throw e; } }
	 */

	@Test(groups = { "preprintOrderZoneGroupForce", "PrioritizedReg2",
			"preprintOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void preprintOrderZoneGroupForce(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 35, 0);
			newOrderInstance.enterPubDate("1", "31", "May", "2019");
			newOrderInstance.selectProductType("1", 35, 1);
			newOrderInstance.selectProduct("1", 35, 2);
			Thread.sleep(3000);
			newOrderInstance.selectAdType("1", 35, 3);
			Thread.sleep(5000);
			// newOrderInstance.selectSection("1",35, 4);
			// Thread.sleep(4000);
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);// mou
			newOrderInstance.viewInsertionDetails("1");

			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);// mou
			Thread.sleep(80000);// mou
			newOrderInstance.selectZonePreprintOrder("Full");// mou
			newOrderInstance.confirmZoneSelection(); // mou
			Thread.sleep(5000);// mou
			int distributionsCount = newOrderInstance.getDistributionsAdded();
			Logger.info("distributionsCount " + distributionsCount);
			// Assert.assertEquals(countOfZoneAssigned,2);
			/*
			 * boolean totalPriceFlag = false; double totalInsertionPrice =
			 * newOrderInstance.getPreprintInsertionPrice("1", "total");
			 * Logger.info(""+newOrderInstance.getPreprintInsertionPrice("1",
			 * "total"));
			 * Logger.info(""+TribuneUtils.getDoubleCellValues("Product",10,
			 * 17)); if(totalInsertionPrice==TribuneUtils.getDoubleCellValues(
			 * "Product",10, 17)) { totalPriceFlag = true;
			 * Logger.info("total insertion price "
			 * +totalInsertionPrice+" is as per the pricing logics"); }
			 * 
			 * Assert.assertEquals(totalPriceFlag, true);
			 */
			Thread.sleep(2000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(5000);
			newOrderInstance.clickOnContinuePastPubDate();
			Thread.sleep(2000);
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "NovMaintenance", "Order", "duplicatePreprintDistibuitionOutError", "OrderPreprintTest",
			"RegressionLatest", "PreprintReg", "Grp4", "Pre1", "Group5", "RegFailed3", "PriorityDFP", "RegFailed3",
			"reRunP", "Group5F", "NewRegression2", "NewRegression", "G5",
			"preprintOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void duplicatePreprintDistibuitionOutError(Map<String, String> userData) throws Exception {
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

			OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			basicOrderSearch.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 35, 0);
			Thread.sleep(3000);
			newOrderInstance.enterPubDate("1", "9", "Jan", "2021");
			Thread.sleep(3000);
			newOrderInstance.selectProductType("1", 35, 1);
			Thread.sleep(3000);

			// newOrderInstance.selectSection("1",35, 4);
			// Thread.sleep(10000);

			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(3000);
			newOrderInstance.enterPubDate("2", "10", "Jan", "2021");
			Thread.sleep(3000);
			newOrderInstance.addOrEditInsersionVerisonID("2", 1);
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;// arka
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");// arka
			Thread.sleep(5000);
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			Thread.sleep(5000);
			newOrderInstance.viewInsertionDetails("1");// arka
			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(8000);
			// Thread.sleep(180000); // mou
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			//newOrderInstance.submitOrder();//swagata
		newOrderInstance.submitOrderWithoutSave();//swagata
		newOrderInstance.displayErrorMessage();
			newOrderInstance.compareErrorMessage(
					"Distribution maybe out of date for insertion 02-00. Please open the distribution dialog to verify");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "duplicatePreprint", "OrderPreprintTest", "RegressionLatest", "reRunP", "PreprintReg",
			"Grp4", "Pre1", "Group5", "RegFailed3", "RegFailed3", "reRunP",
			"Group5F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void duplicatePreprintInsertion(Map<String, String> userData) throws Exception {
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

			OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			basicOrderSearch.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 35, 0);
			Thread.sleep(3000);
			newOrderInstance.enterPubDate("1", "21", "Nov", "2019");
			Thread.sleep(3000);
			newOrderInstance.selectProductType("1", 35, 1);
			Thread.sleep(3000);
			newOrderInstance.selectProduct("1", 35, 2);
			Thread.sleep(3000);
			newOrderInstance.selectAdType("1", 35, 3);
			Thread.sleep(10000);
			// newOrderInstance.selectSection("1",35, 4);
			// Thread.sleep(10000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(50000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
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

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order ID: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderEntryPageInstance.clickOnOrder(orderID);

			NewOrderPage orderViewPage = PageFactory.initElements(driver, NewOrderPage.class);
			wait.until(ExpectedConditions.visibilityOf(orderViewPage.orderViewPageElement));
			int totalInsertiosnBeforeAction = orderViewPage.getInsertionsCount();
			Logger.info("totalInsertiosnBeforeAction : " + totalInsertiosnBeforeAction);
			Thread.sleep(3000);
			orderViewPage.createDuplicateInsertion("1");
			Thread.sleep(3000);
			int totalInsertiosnAfterAction = orderViewPage.getInsertionsCount();
			Logger.info("totalInsertiosnAfterAction : " + totalInsertiosnAfterAction);
			if (totalInsertiosnAfterAction > totalInsertiosnBeforeAction) {
				Logger.info("An insertion is made");
			}

			// Thread.sleep(5000);
			/*
			 * orderViewPage.submitOrder(); Thread.sleep(4000);
			 */
			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "newVersionPreprint", "OrderPreprintTest", "reRunP", "PreprintReg", "Grp4", "Pre1",
			"RegFailed3", "PriorityDFP", "RegFailed3", "reRunP",
			"Group5F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void newInsertionVersionPreprintOrder(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 35, 0);
			Thread.sleep(3000);
			newOrderInstance.enterPubDate("1", "21", "Nov", "2019");
			Thread.sleep(3000);
			newOrderInstance.selectProductType("1", 35, 1);
			Thread.sleep(3000);
			newOrderInstance.selectProduct("1", 35, 2);
			Thread.sleep(3000);
			newOrderInstance.selectAdType("1", 35, 3);
			Thread.sleep(5000);
			// newOrderInstance.selectSection("1",35, 4);
			// Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(40000);
			// newOrderInstance.clickOnSearchZoneLink();
			Thread.sleep(3000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			String versionID = newOrderInstance.getInsersionVerisonID("1");//

			int insertionVersionBefore = newOrderInstance.getVersionsInInsertion("01");
			Thread.sleep(3000);
			newOrderInstance.createNewInsertionVersion("1");
			Thread.sleep(3000);
			newOrderInstance.addOrEditInsersionVerisonID("2", 2);
			int insertionVersionAfter = newOrderInstance.getVersionsInInsertion("01");
			boolean newVersionFlag = false;
			if (insertionVersionAfter > insertionVersionBefore) {
				newVersionFlag = true;
				Logger.info("new version is created");
			}

			boolean versionIDFlag = false;
			if (versionID.equalsIgnoreCase("1")) {
				versionIDFlag = true;
				Logger.info("versionID addition is validated");
			}
			Assert.assertEquals(newVersionFlag, true);
			Assert.assertEquals(versionIDFlag, true);
			// newOrderInstance.clickOnInsertionSalesRepSection(2);

			newOrderInstance.clickOnDistributions(2);
			Thread.sleep(40000);
			// newOrderInstance.clickOnSearchZoneLink();
			Thread.sleep(5000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
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
			// newOrderInstance.addNewSalesRepOnInsertion(2, "SA00443");
			// Thread.sleep(2000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info(orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			// Thread.sleep(3000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(5000);
			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "preprintOrderWithMMTag", "OrderDisplayOnlineTest",
			"Group5F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderWithMMTag(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 35, 0);
			newOrderInstance.enterPubDate("1", "26", "Dec", "2019");
			newOrderInstance.selectProductType("1", 35, 1);
			newOrderInstance.selectProduct("1", 35, 2);
			Thread.sleep(3000);
			newOrderInstance.selectAdType("1", 35, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1", 35, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(40000);
			// newOrderInstance.clickOnSearchZoneLink();
			Thread.sleep(3000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			int distributionsCount = newOrderInstance.getDistributionsAdded();
			Logger.info("distributionsCount " + distributionsCount);
			// Assert.assertEquals(distributionsCount, countOfZoneAssigned);
			/*
			 * boolean totalPriceFlag = false; double totalInsertionPrice =
			 * newOrderInstance.getPreprintInsertionPrice("1", "total");
			 * Logger.info(""+newOrderInstance.getPreprintInsertionPrice("1",
			 * "total"));
			 * Logger.info(""+TribuneUtils.getDoubleCellValues("Product",10,
			 * 17)); if(totalInsertionPrice==TribuneUtils.getDoubleCellValues(
			 * "Product",10, 17)) { totalPriceFlag = true;
			 * Logger.info("total insertion price "
			 * +totalInsertionPrice+" is as per the pricing logics"); }
			 * 
			 * Assert.assertEquals(totalPriceFlag, true);
			 */
			Thread.sleep(2000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.selectMMTag("1", "One Day Sale");
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

			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "SMaintenance","SwagataMou", "Order", "verifyPreprintOrderCopySalesPrice", "NovMaintenance", "PrioritizedReg2",
			"OrderPreprintTest", "RegressionLatest", "reRunP", "PreprintReg", "Grp4", "Pre1", "Group5", "RegFailed3",
			"PriorityVulnerability", "Group5F", "NewRegression2", "NewRegression", "G5", "RerunF2",
			"preprintOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void verifyPreprintOrderCopySalesPrice(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_All");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 10, 0);
			//newOrderInstance.enterPubDate("1", "13", "Jan", "2020");//swagata
			 newOrderInstance.enterPubDateFromExcel("1",9,27);//swagata
			newOrderInstance.selectProductType("1", 10, 1);
			newOrderInstance.selectProduct("1", 10, 2);
			Thread.sleep(3000);
			newOrderInstance.selectAdType("1", 10, 3);
			Thread.sleep(10000);
			
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			
			newOrderInstance.clickOnDistributions(1);// mou
			//Thread.sleep(18000);//swagata
			newOrderInstance.selectZonePreprintOrder("Full");// mou
			newOrderInstance.confirmZoneSelection(); // mou
			Thread.sleep(5000);// mou
			// newOrderInstance.clickOnSearchZoneLink();// swagata
			// Thread.sleep(3000);//swagata
			// newOrderInstance.viewInsertionDetails("1");//mou
			// Thread.sleep(3000);
			//newOrderInstance.checkUncheckSalesPricePreprint(1, true);joy
			newOrderInstance.editSalesPricePrePrint("7");
			Thread.sleep(4000);
			//newOrderInstance.checkUncheckSalesPricePreprint(1, false);
			//Thread.sleep(4000);
			double salesPrice = newOrderInstance.getInsertionPrice("1", "sales preprint");
			Logger.info("Sales Price: " + salesPrice);
			double priceAfterEdit = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("Total Price: " + priceAfterEdit);
			//Assert.assertEquals(salesPrice, priceAfterEdit);

			//newOrderInstance.checkUncheckSalesPricePreprint(1, true);
			Thread.sleep(4000);
			newOrderInstance.editSalesPricePrePrint("0");
			Thread.sleep(4000);
			//newOrderInstance.checkUncheckSalesPricePreprint(1, false);
			//Thread.sleep(4000);
			double salesPrice1 = newOrderInstance.getInsertionPrice("1", "sales preprint");
			Logger.info("Sales Price: " + salesPrice1);
			double priceAfterEdit1 = newOrderInstance.getInsertionPrice("1", "total");
			Logger.info("Total Price: " + priceAfterEdit1);
			//Assert.assertEquals(salesPrice1, priceAfterEdit1);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			//newOrderInstance.ClickContinueButton();//joy
			//Thread.sleep(5000); //swagata
			//newOrderInstance.clickOnContinuePastPubDate();//swagata
			//Thread.sleep(2000); // mou
			/*
			 * Logger.info(orderEntryPageInstance.getOrderID());
			 * orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			 * Thread.sleep(2000); String orderID =
			 * orderEntryPageInstance.getOrderNumber();
			 * orderEntryPageInstance.clickOnOrder(orderID);
			 * Thread.sleep(7000);comment out
			 */
			// ewOrderInstance.submitOrder();
			// Thread.sleep(5000);
			/* String orderID = orderEntryPageInstance.getOrderID();/*added */
			/*
			 * Logger.info("Order ID: "+orderID);
			 * orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			 * Thread.sleep(2000); List<WebElement> list =
			 * driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			 * WebDriverWait wait = new WebDriverWait(driver,20);
			 * wait.until(ExpectedConditions.visibilityOfAllElements(list));
			 * orderEntryPageInstance.clickOnOrder(orderID);
			 * 
			 * Thread.sleep(6000);
			 */
			// newOrderInstance.submitOrder();
			// Thread.sleep(1000);
			// WebDriverWait wait = new WebDriverWait(driver,120);

			String orderID = orderEntryPageInstance.getOrderID();// mou
			Logger.info("Order ID: " + orderID);// mou
			//orderEntryPageInstance.closeOrderSuccessSubmissionMessage();// mou
			Thread.sleep(2000);// mou
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));// mou
			WebDriverWait wait = new WebDriverWait(driver, 20);// mou
			wait.until(ExpectedConditions.visibilityOfAllElements(list));// mou
			orderEntryPageInstance.clickOnOrder(orderID);// mou

			Thread.sleep(6000);// mou

			newOrderInstance.viewInsertionDetails("1");
			double salesPrice3 = newOrderInstance.getInsertionPrice("1", "sales preprint");
			Logger.info("Sales Price After Submit: " + salesPrice3);
			Assert.assertEquals(salesPrice1, salesPrice3);
			Thread.sleep(2000);
			newOrderInstance.clickCopyOrder();
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			double salesPrice2 = newOrderInstance.getInsertionPrice("1", "sales preprint");
			Logger.info("Sales Price After Copy: " + salesPrice2);
			Assert.assertEquals(salesPrice1, salesPrice2);
			dashboardPageInstance.clickOnLogout();//swagata
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order",
			"preprintOrderZoneZipSelect" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderZoneZipSelect(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 35, 0);
			newOrderInstance.enterPubDate("1", "26", "Dec", "2019");
			newOrderInstance.selectProductType("1", 35, 1);
			newOrderInstance.selectProduct("1", 35, 2);
			Thread.sleep(3000);
			// newOrderInstance.selectAdType("1",35, 3);
			Thread.sleep(10000);
			// newOrderInstance.selectSection("1",35, 4);
			// Thread.sleep(10000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(45000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectTypeZipAndZonePreprintOrder("Full", "90001", "90001");
			Thread.sleep(3000);
			newOrderInstance.matchZipZoneAndSelectPreprintOrder("90005", "90004");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			int distributionsCount = newOrderInstance.getDistributionsAdded();
			Logger.info("distributionsCount " + distributionsCount);
			boolean flag = false;
			if (distributionsCount > 0) {
				flag = true;
			}
			Assert.assertEquals(flag, true);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "preprintOrderVerifySortDistributions", "OrderPreprintTest", "RegressionLatest", "reRunP",
			"PreprintReg", "Grp4", "Pre1", "Group5", "RegFailed3",
			"Group5F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderVerifySortDistributions(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 33, 0);
			newOrderInstance.enterPubDate("1", "26", "Dec", "2019");
			newOrderInstance.selectProductType("1", 33, 1);
			newOrderInstance.selectProduct("1", 33, 2);
			Thread.sleep(3000);
			// newOrderInstance.selectAdType("1",35, 3);
			Thread.sleep(10000);
			// newOrderInstance.selectSection("1",35, 4);
			// Thread.sleep(10000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(45000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.maximizeDistributionWindowPreprintOrder();
			Thread.sleep(3000);
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.verifyZoneSort();
			newOrderInstance.verifyTypeSort();
			newOrderInstance.verifyGroupSort();
			newOrderInstance.verifyQuantitySort();
			newOrderInstance.verifyCitySort();

			newOrderInstance.verifyZipSort();
			newOrderInstance.verifyRegionSort();
			// newOrderInstance.verifyCountySort();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "preprintOrderExportSelectedZones", "OrderPreprintTest", "RegressionLatest", "reRunP",
			"PreprintReg", "Grp4", "Pre1", "Group5", "RegFailed3",
			"Group5F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderExportSelectedZones(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 35, 0);
			newOrderInstance.enterPubDate("1", "26", "Dec", "2019");
			newOrderInstance.selectProductType("1", 35, 1);
			newOrderInstance.selectProduct("1", 35, 2);
			// Thread.sleep(3000);
			// newOrderInstance.selectAdType("1",35, 3);
			Thread.sleep(10000);
			// newOrderInstance.selectSection("1",35, 4);
			// Thread.sleep(10000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(45000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.exportSelectedZonesPreprintOrder();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "preprintOrderForceGroup", "OrderPreprintTest", "RegressionLatest", "reRunP",
			"PreprintReg", "Grp4", "Pre1", "Group5", "RegFailed3", "TestPriority",
			"Group5F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderForceGroup(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 35, 0);
			newOrderInstance.enterPubDate("1", "26", "Dec", "2019");
			newOrderInstance.selectProductType("1", 35, 1);
			newOrderInstance.selectProduct("1", 35, 2);
			Thread.sleep(3000);
			// newOrderInstance.selectAdType("1",35, 3);
			Thread.sleep(10000);
			// newOrderInstance.selectSection("1",35, 4);
			// Thread.sleep(10000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(45000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.checkUncheckForceGroupPreprintOrder();
			Thread.sleep(3000);
			newOrderInstance.selectTypeZipAndZonePreprintOrder("Full", "90001", "90001");
			Thread.sleep(3000);
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			int distributionsCount = newOrderInstance.getDistributionsAdded();
			Logger.info("distributionsCount " + distributionsCount);
			Thread.sleep(6000);
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(55000);
			newOrderInstance.removeAssignedZone("Full", "90001");
			Thread.sleep(3000);
			newOrderInstance.selectTypeZipAndZonePreprintOrder("Full", "90001", "90001");
			Thread.sleep(3000);
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			int distributionsCount1 = newOrderInstance.getDistributionsAdded();
			Logger.info("distributionsCount " + distributionsCount1);
			Thread.sleep(3000);
			boolean flag = false;
			if (distributionsCount != distributionsCount1) {
				flag = true;
			}
			Assert.assertEquals(flag, true);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "preprintOrderUnavailableZones", "OrderPreprintTest", "RegressionLatest", "reRunP",
			"PreprintReg", "Grp4", "Pre1", "Group5", "RegFailed3", "TestPriority",
			"Group5F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderUnavailableZones(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 42, 0);
			newOrderInstance.enterPubDate("1", "29", "Dec", "2019");
			newOrderInstance.selectProductType("1", 42, 1);
			newOrderInstance.selectProductByIndex("1", 5);
			// Thread.sleep(3000);
			// newOrderInstance.selectAdType("1",35, 3);
			Thread.sleep(10000);
			// newOrderInstance.selectSection("1",35, 4);
			// Thread.sleep(10000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(45000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.verifyUnavailableZonesSection();
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "veryPubDateChangeInVersionPreprintOrder", "OrderPreprintTest", "RegressionLatest",
			"reRunP", "PreprintReg", "Grp4", "Pre1", "Group5", "RegFailed3", "TestPriority",
			"Group5F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void veryPubDateChangeInVersionPreprintOrder(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 35, 0);
			newOrderInstance.enterPubDate("1", "26", "Dec", "2019");
			newOrderInstance.selectProductType("1", 35, 1);
			newOrderInstance.selectProduct("1", 35, 2);
			Thread.sleep(3000);
			// newOrderInstance.selectAdType("1",35, 3);
			// Thread.sleep(5000);
			// newOrderInstance.selectSection("1",35, 4);
			// Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");

			newOrderInstance.createNewInsertionVersion("1");
			Thread.sleep(6000);
			if (newOrderInstance.getPubDateOnInsertion(1) == newOrderInstance.getPubDateOnInsertionVersion(1)) {
				Logger.info("Pub Date of both versions are same");
			}
			newOrderInstance.enterPubDate("1", "28", "Dec", "2019");
			Thread.sleep(6000);
			if (newOrderInstance.getPubDateOnInsertion(1) == newOrderInstance.getPubDateOnInsertionVersion(1)) {
				Logger.info("Pub Date of both versions are same even after changing pub date");
			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	// arka

	/*
	 * @Test(groups = {"Order",
	 * "preprintOrderDifferentProductSamePageType","OrderPreprintTest",
	 * "RegressionLatest","reRunP","PreprintReg","Grp4","Pre1","Group5",
	 * "RegFailed3","Group5F","NewRegression","G5","RerunF2"}, dataProviderClass
	 * = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider =
	 * "userData") public void
	 * preprintOrderDifferentProductSamePageType(Map<String, String> userData)
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
	 * OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver,
	 * OrderEntryHomePage.class); basicOrderSearch.clickOnNewGeneralOrder();
	 * 
	 * NewOrderPage newOrderInstance = PageFactory.initElements(driver,
	 * NewOrderPage.class); newOrderInstance.selectSoldToCustomerBU("bu_CTC");
	 * newOrderInstance.enterSoldToCustomer("CU00037236");
	 * newOrderInstance.selectBilltoSameAsSoldTo();
	 * newOrderInstance.selectOrderType("OrderType_Standard");
	 * newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
	 * newOrderInstance.createNewInsertion(); newOrderInstance.selectBU("1",43,
	 * 0); newOrderInstance.enterPubDate("1","22", "Dec", "2019");
	 * newOrderInstance.selectProductType("1",43, 1);
	 * newOrderInstance.selectProduct("1",43, 2);
	 * 
	 * Thread.sleep(10000); newOrderInstance.viewInsertionDetails("1");
	 * newOrderInstance.addOrEditInsersionVerisonID("1", 1); //
	 * newOrderInstance.selectMaterialSource("1","N/A");
	 * newOrderInstance.clickOnDistributions(1); Thread.sleep(50000); //
	 * newOrderInstance.clickOnSearchZoneLink(); // Thread.sleep(10000);
	 * newOrderInstance.selectZonePreprintOrder("Full"); // int
	 * countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
	 * newOrderInstance.confirmZoneSelection(); Thread.sleep(5000);
	 * newOrderInstance.viewInsertionDetails("1");
	 * newOrderInstance.createDuplicateInsertion("1"); Thread.sleep(7000);
	 * newOrderInstance.viewInsertionDetails("2");
	 * newOrderInstance.selectProductByIndex("2", 1); //
	 * newOrderInstance.selectProduct("1",17, 2); Thread.sleep(10000);
	 * 
	 * newOrderInstance.addOrEditInsersionVerisonID("2", 2); //
	 * newOrderInstance.selectMaterialSource("1","N/A");
	 * newOrderInstance.clickOnDistributions(2); Thread.sleep(50000); //
	 * newOrderInstance.clickOnSearchZoneLink(); // Thread.sleep(10000);
	 * newOrderInstance.selectZonePreprintOrder("Full"); // int
	 * countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
	 * newOrderInstance.confirmZoneSelection(); Thread.sleep(5000);
	 * newOrderInstance.clickRefreshDraw(); Thread.sleep(5000);
	 * newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.addNewSalesRepOnInsertion(2,
	 * "SA01380");Thread.sleep(4000);newOrderInstance.
	 * clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.applytoAllSalesRepOnInsertion(2);Thread.sleep(2000);
	 * Thread.sleep(4000); newOrderInstance.submitOrder();
	 * ClassifiedOrderOptions classifiedOrderInstance =
	 * PageFactory.initElements(driver, ClassifiedOrderOptions.class); //
	 * classifiedOrderInstance.ContinueBtnForPastPubdateOrderAlert.click();
	 * //Thread.sleep(2000); //newOrderInstance.confirmToMakeOrderFree();
	 * Thread.sleep(2000); OrderEntryHomePage orderEntryPageInstance =
	 * PageFactory.initElements(driver, OrderEntryHomePage.class); String
	 * orderid=orderEntryPageInstance.getOrderID();
	 * Logger.info("orderid:"+orderid);
	 * 
	 * } catch(Exception e) { Logger.error(e.getMessage()); throw e; } }
	 */
	@Test(groups = { "SwagataMou", "Order", "preprintOrderDifferentProductSamePageType", "PrioritizedReg2",
			"OrderPreprintTest", "RegressionLatest", "reRunP", "PreprintReg", "Grp4", "Pre1", "Group5", "RegFailed3",
			"Group5F", "NewRegression2", "NewRegression", "G5", "RerunF2",
			"preprintOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void preprintOrderDifferentProductSamePageType(Map<String, String> userData) throws Exception {
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

			OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			basicOrderSearch.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 43, 0);
			//newOrderInstance.enterPubDate("1", "31", "May", "2019");//swagata
			newOrderInstance.enterPubDateFromExcel("1", 18, 27);//swagata
			newOrderInstance.selectProductType("1", 43, 1);
			newOrderInstance.selectProduct("1", 43, 2);

			Thread.sleep(10000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);
			//Thread.sleep(12000);//swagata
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(7000);
			newOrderInstance.viewInsertionDetails("2");
			// newOrderInstance.selectProductByIndex("2", 1); //payel
			newOrderInstance.selectProduct("2", 43, 2);// payel
			// newOrderInstance.selectProduct("1",17, 2);
			Thread.sleep(10000);

			newOrderInstance.addOrEditInsersionVerisonID("2", 2);
			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(2);
			Thread.sleep(50000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			newOrderInstance.clickRefreshDraw();
			Thread.sleep(5000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(2);
			Thread.sleep(2000);
			Thread.sleep(4000);
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			newOrderInstance.submitOrder();
			//Thread.sleep(5000);//swagata
			//newOrderInstance.clickOnContinuePastPubDate();//swagata
			//Thread.sleep(2000);
			//ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,ClassifiedOrderOptions.class);//swagata
			// classifiedOrderInstance.ContinueBtnForPastPubdateOrderAlert.click();
			// Thread.sleep(2000);
			// newOrderInstance.confirmToMakeOrderFree();
			//Thread.sleep(2000);
			
			String orderid = orderEntryPageInstance.getOrderNumber();//swagata
			Logger.info("orderid:" + orderid);

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "NovMaintenance", "Order", "preprintOrderSameProductDifferentMaterialSource", "OrderPreprintTest",
			"RegressionLatest", "reRunP", "PreprintReg", "Grp4", "Pre1", "Group5", "RegFailed3", "Group5F",
			"NewRegression2", "NewRegression", "G5", "RerunF2",
			"preprintOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderSameProductDifferentMaterialSource(Map<String, String> userData) throws Exception {
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

			OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			basicOrderSearch.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 43, 0);
			Thread.sleep(4000);
			 newOrderInstance.enterPubDateFromExcel("1",9,27);//swagata

//			newOrderInstance.enterPubDate("1", "21", "Dec", "2019");// arka
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 43, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 43, 2);
			Thread.sleep(5000);
			newOrderInstance.selectAdType("1", 43, 3);
			Thread.sleep(4000);

			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(12000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			// newOrderInstance.selectProductByIndex("1", 3);
			// newOrderInstance.selectProduct("1",17, 2);
			newOrderInstance.selectMaterialSource("1", "Perpetual");
			Thread.sleep(4000);
			newOrderInstance.clickOnPickUpSearch();
			Thread.sleep(7000);
			newOrderInstance.clickOnSpecificOrderInPickUpWindw("0");
			Thread.sleep(6000);
			newOrderInstance.clickOnSelectBtnPickUpWindw();
			Thread.sleep(7000);
			newOrderInstance.addOrEditInsersionVerisonID("2", 2);
			// newOrderInstance.selectMaterialSource("1","N/A");
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			
			/*newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);*/
			Thread.sleep(4000);

			newOrderInstance.clickRefreshDraw();
			Thread.sleep(6000);
			newOrderInstance.submitOrder();
			Thread.sleep(5000); 
			/*
			 * newOrderInstance.clickOnContinuePastPubDate();
			 * Thread.sleep(2000);
			 */

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			String orderid = orderEntryPageInstance.getOrderID(); /* added */
			Logger.info("Order ID: " + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderEntryPageInstance.clickOnOrder(orderid);

			Thread.sleep(3000);

			dashboardPageInstance.clickOnLogout();/* added this line */
			// ClassifiedOrderOptions classifiedOrderInstance =
			// PageFactory.initElements(driver, ClassifiedOrderOptions.class);
			// classifiedOrderInstance.ContinueBtnForPastPubdateOrderAlert.click();
			// Thread.sleep(2000);
			// newOrderInstance.confirmToMakeOrderFree();
			// Thread.sleep(2000);
			// OrderEntryHomePage orderEntryPageInstance =
			// PageFactory.initElements(driver, OrderEntryHomePage.class);
			// String orderid=orderEntryPageInstance.getOrderID();
			// Logger.info("orderid:"+orderid);

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "preprintOrderSameProductDifferentPandDcolor", "OrderPreprintTest", "RegressionLatest",
			"reRunP", "PreprintReg", "Grp4", "Pre1", "Group5", "RegFailed3",
			"Group5F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderSameProductDifferentPandDcolor(Map<String, String> userData) throws Exception {
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

			OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			basicOrderSearch.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 43, 0);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2019");
			newOrderInstance.selectProductType("1", 43, 1);
			newOrderInstance.selectProduct("1", 43, 2);

			Thread.sleep(10000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(50000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			Thread.sleep(4000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(4000);
			// newOrderInstance.selectProductByIndex("1", 3);
			// newOrderInstance.selectProduct("1",17, 2);
			newOrderInstance.selectMaterialSource("1", "Perpetual");
			Thread.sleep(4000);
			newOrderInstance.clickOnPickUpSearch();
			Thread.sleep(7000);
			newOrderInstance.clickOnSpecificOrderInPickUpWindw("0");
			Thread.sleep(6000);
			newOrderInstance.clickOnSelectBtnPickUpWindw();
			Thread.sleep(7000);
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(4000);
			newOrderInstance.enterPandDcolors("RBG");
			Thread.sleep(4000);
			newOrderInstance.addOrEditInsersionVerisonID("2", 2);
			// newOrderInstance.selectMaterialSource("1","N/A");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(2);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.clickRefreshDraw();
			Thread.sleep(5000);
			newOrderInstance.submitOrder();
			newOrderInstance.displayErrorMessage();
			newOrderInstance.compareErrorMessage(
					"Two or more insertion lines with the same Material ID have different Color1Front! These are lines 01-00 02-00");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "preprintMultiplePageCountPandD", "preprintOrders",
			"PrioritizedReg2" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void preprintMultiplePageCountPandD(Map<String, String> userData) throws Exception {
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
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 39, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "22", "Dec", "2019");
			Thread.sleep(4000);
			newOrderInstance.selectProductTypeByIndex("1", 1);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			Thread.sleep(3000);
			newOrderInstance.selectMaterialSource1("Electronic");
			Thread.sleep(3000);
			newOrderInstance.selectPageType("1", "PP_PaperType_Broadsheet");
			Thread.sleep(3000);
			newOrderInstance.enterPageCount("6");
			Thread.sleep(3000);
			newOrderInstance.checkUncheckBillQty(false);
			Thread.sleep(3000);
			newOrderInstance.enterBilledQty(5);
			Thread.sleep(3000);
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			Thread.sleep(3000);
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(4000);
			newOrderInstance.selectPandDOrientation("1", "Vertical");
			Thread.sleep(4000);
			newOrderInstance.selectPandDOrientationException("1", "Horizontal", "6");
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(4000);
			newOrderInstance.selectPandDInk("1", "4 Color Process");
			Thread.sleep(4000);
			// newOrderInstance.selectPandDInkException("1", "Spot Color", "5");
			// newOrderInstance.clickOnPAndDTab();
			// Thread.sleep(4000);
			newOrderInstance.enterPandDcolors("YL");
			newOrderInstance.enterPandDcolors1("GR");
			newOrderInstance.enterPandDcolors2("WH");
			Thread.sleep(4000);
			newOrderInstance.enterPandDColorException(1, "A1", "B2", "C3", "3");
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(4000);
			newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess");
			Thread.sleep(4000);
			// newOrderInstance.selectPandDCreativeLoc("1",
			// "PP_CreativeLoc_Adwatch");
			// Thread.sleep(4000);
			// newOrderInstance.selectPandDPerforation("1",
			// "PP_Perforation_Yes");
			// Thread.sleep(4000);
			// newOrderInstance.selectPandDFold("1", "PP_Fold_None");
			// Thread.sleep(4000);
			// newOrderInstance.selectPandDPaperStock("1",
			// "PP_PaperStock_60Coated");
			// Thread.sleep(4000);
			newOrderInstance.selectPandDPrinter("1", "PP_Printer_NPC");
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
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			Logger.info("Order: " + orderEntryPageInstance.getOrderID());

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "NovMaintenance", "Order", "PrioritizedReg2", "preprintOrderPerpetualReport", "RegressionLatest",
			"reRunP", "PreprintReg", "Grp4", "Pre1", "Group5", "RegFailed3", "TestPriority", "PriorityDFP", "Group5F",
			"NewRegression2", "NewRegression", "G5", "RerunF2",
			"preprintOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void preprintOrderPerpetualReport(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 43, 0);
			Thread.sleep(4000);
			 newOrderInstance.enterPubDateFromExcel("1",9,27);//swagata

			//newOrderInstance.enterPubDate("1", "21", "Dec", "2019");// arka
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 43, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 43, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 43, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			Thread.sleep(4000);
			newOrderInstance.enterPerpetualQuantity(100000);
			Thread.sleep(4000);
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(75000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(5000);
			newOrderInstance
					.viewInsertionDetails("2"); /* changed added this line */
			newOrderInstance.selectMaterialSource("2", "Perpetual");
			Thread.sleep(7000); /* sleep time increased */
			newOrderInstance.clearPerpetualQuantity();
			Thread.sleep(3000);
			newOrderInstance.clickOnPickUpSearch();
			Thread.sleep(7000);
			newOrderInstance.clickOnOrderInPickUpWindw();
			Thread.sleep(6000);
			newOrderInstance.clickOnSelectBtnPickUpWindw();
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("2");
			newOrderInstance.clickRefreshDraw();
			Thread.sleep(7000);
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
			Thread.sleep(5000);
			// newOrderInstance.clickOnContinuePastPubDate();// mou
			// Thread.sleep(2000); // mou
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

	@Test(groups = { "Order", "preprintOrderNewVersionDistribution", "reRunP", "PreprintReg", "Grp4", "Pre1",
			"RegFailed3", "NovMaintenance", "NewRegression2", "NewRegression", "G5",
			"preprintOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderNewVersionDistribution(Map<String, String> userData) throws Exception {
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
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 75, 0);
			Thread.sleep(4000);
			 newOrderInstance.enterPubDateFromExcel("1",9,27);//swagata
		//	newOrderInstance.enterPubDate("1", "29", "Dec", "2019");// arka
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 75, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 75, 2);
			Thread.sleep(4000);
		//	newOrderInstance.selectAdType("1", 75, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInserstionVerisonIDString("1", "v1");
			// newOrderInstance.selectMaterialSource("1","N/A");
			Thread.sleep(4000);
			newOrderInstance.createNewInsertionVersion("1");
			Thread.sleep(5000);
			newOrderInstance.addOrEditInserstionVerisonIDString("2", "v2");
			//Thread.sleep(6000);
			newOrderInstance.clickOnDistributions(2);//joy
			//newOrderInstance.selectVersionInDistribution("v1");
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			Thread.sleep(8000);//swagata
			newOrderInstance.confirmZoneSelection();
			//Thread.sleep(5000);
			//newOrderInstance.clickOnDistributions(2);
			//Thread.sleep(15000);//swagata
			
			//newOrderInstance.selectVersionInDistribution("v2");
			Thread.sleep(4000);
			//newOrderInstance.confirmZoneSelection();
			//Thread.sleep(5000);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "preprintOrderProgramPriceChange", "reRunP", "PreprintReg", "Grp4", "Pre1",
			"RegFailed3" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderProgramPriceChange(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 35, 0);
			newOrderInstance.enterPubDate("1", "26", "Dec", "2019");
			newOrderInstance.selectProductType("1", 33, 1);
			// newOrderInstance.selectProduct("1",35, 2);
			Thread.sleep(3000);
			newOrderInstance.selectAdType("1", 33, 3);
			// Thread.sleep(10000);
			// newOrderInstance.selectSection("1",35, 4);
			// Thread.sleep(10000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.checkUncheckBillQty(false);
			Thread.sleep(3000);
			newOrderInstance.enterBilledQuantity(10000);
			Thread.sleep(3000);
			double totalInsertionPrice = newOrderInstance.getPreprintInsertionPrice("1", "total");
			Logger.info("total insertion price " + totalInsertionPrice);
			Thread.sleep(2000);
			String programPrice = newOrderInstance.getProgramPriceForAnInsertionPreprint(1);
			Thread.sleep(2000);
			Assert.assertEquals(programPrice, "None");
			Thread.sleep(2000);
			newOrderInstance.clickOnProgramPriceSelectorPreprint();
			Thread.sleep(4000);
			newOrderInstance.selectProgramPromotion("LATMG 6-12x Frequency");
			Thread.sleep(4000);
			double totalInsertionPrice1 = newOrderInstance.getPreprintInsertionPrice("1", "total");
			Logger.info("total insertion price after selecting program " + totalInsertionPrice1);
			String programPrice1 = newOrderInstance.getProgramPriceForAnInsertionPreprint(1);
			Thread.sleep(2000);
			boolean flag = false;
			if (programPrice1 != programPrice && totalInsertionPrice1 != totalInsertionPrice) {
				flag = true;
			}

			Assert.assertEquals(flag, true);
			newOrderInstance.clearProgramPromotionDisplay();
			Thread.sleep(5000);
			String programPrice2 = newOrderInstance.getProgramPriceForAnInsertionPreprint(1);
			Thread.sleep(2000);
			Assert.assertEquals(programPrice2, "None");
			Thread.sleep(2000);
			double totalInsertionPrice2 = newOrderInstance.getPreprintInsertionPrice("1", "total");
			Logger.info("total insertion price after de-selecting program " + totalInsertionPrice1);
			Thread.sleep(2000);
			Assert.assertEquals(totalInsertionPrice2, totalInsertionPrice);
			Thread.sleep(2000);
			newOrderInstance.clickOnProgramPriceSelectorPreprint();
			Thread.sleep(4000);
			newOrderInstance.selectProgramPromotion("LATMG 6-12x Frequency");
			Thread.sleep(4000);
			String programPrice3 = newOrderInstance.getProgramPriceForAnInsertionPreprint(1);
			Thread.sleep(2000);
			boolean flag1 = false;
			if (programPrice3 != programPrice2) {
				flag1 = true;
			}

			Assert.assertEquals(flag1, true);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
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

	@Test(groups = { "NovMaintenance", "Order", "Grp4", "RegressionLatest", "reRunP", "PreprintReg", "Group5",
			"RegFailed3", "preprintMultiPagePandDpickUp", "Group5F", "NewRegression2", "NewRegression", "G5", "RerunF2",
			"preprintOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintMultiPagePandDpickUp(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 43, 0);
			Thread.sleep(4000);
			 newOrderInstance.enterPubDateFromExcel("1",9,27);//swagata
            // newOrderInstance.enterPubDate("1", "21", "Dec", "2019");// arka
			// newOrderInstance.enterPubDate("1", "31", "May", "2019");// mou
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 43, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 43, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 43, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			Thread.sleep(3000);

			/*
			 * newOrderInstance.checkUncheckBillQty(false); Thread.sleep(3000);
			 * newOrderInstance.enterBilledQty(5);
			 */
			Thread.sleep(3000);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			Thread.sleep(4000);

			newOrderInstance.selectMaterialSource("1", "Electronic");
			Thread.sleep(3000);
			//newOrderInstance.selectPageType("1", "EZ Target");
			
			//newOrderInstance.selectPageType("1", "PP_PaperType_BrdFC35Off");
			//Thread.sleep(3000);
			//newOrderInstance.enterPageCount("6");
			//Thread.sleep(4000);
			// newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(5000);// arka
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(3000);
			newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_AdProd");//joy
			Thread.sleep(3000);
			newOrderInstance.selectPandDPaperStock("1", "PP_PaperStock_100Gloss");//joy
			Thread.sleep(3000);
			newOrderInstance.selectPandDBleed("1", "PP_Bleed_No");//joy
			Thread.sleep(3000);
			// newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(2000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			//newOrderInstance.ClickContinueButton(); //joy
			//Thread.sleep(5000);//swagata
			// newOrderInstance.clickOnContinuePastPubDate();// mou
			 Thread.sleep(1000);
			String orderNo = orderEntryPageInstance.getOrderID();
			Logger.info("Order No. is:"+orderNo);//swagata
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderNo);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement));
			Thread.sleep(8000);
			Logger.info("START OF COPY ORDER");

			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();
			Thread.sleep(8000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(3000);
			newOrderInstance.selectMaterialSource("1", "Straight Pickup");
			Thread.sleep(3000);
			newOrderInstance.clickOnPickUpSearch();
			Thread.sleep(4000);
			newOrderInstance.searchOrderNoPickUpWindow(orderNo);//swagata
            newOrderInstance.selectPickUp(orderNo);
			Thread.sleep(4000);
			newOrderInstance.clickRefreshDraw();
			Thread.sleep(8000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			//newOrderInstance.ClickContinueButton(); //joy
			//newOrderInstance.contin
			//Thread.sleep(5000);//swagata
			// newOrderInstance.clickOnContinuePastPubDate();// mou
			 Thread.sleep(2000);
			String orderNo1 = orderEntryPageInstance.getOrderID();// mou
			Logger.info("Order No. is:"+orderNo1);//swagata
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);
			 //dashboardPageInstance.clickOnLogout();//swagata
			 
			 dashboardPageInstance.clickondropdownforlogout();//joy
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {
			"preprintMultiPagePandDpickUpPgCntChngError" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintMultiPagePandDpickUpPgCntChngError(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 43, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "31", "May", "2019");// mou
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 43, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 43, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 43, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			Thread.sleep(3000);

			/*
			 * newOrderInstance.checkUncheckBillQty(false); Thread.sleep(3000);
			 * newOrderInstance.enterBilledQty(5);
			 */
			Thread.sleep(3000);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			Thread.sleep(4000);

			newOrderInstance.selectMaterialSource("1", "Electronic");
			Thread.sleep(3000);
			newOrderInstance.selectPageType("1", "PP_PaperType_BrdFC35Off");
			Thread.sleep(3000);
			newOrderInstance.enterPageCount("6");
			Thread.sleep(4000);
			// newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(45000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(3000);
			newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_Tower");
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(5000);
			newOrderInstance.clickOnContinuePastPubDate();// mou
			Thread.sleep(2000);// mou
			String orderNo = orderEntryPageInstance.getOrderID();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderNo);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement));
			Thread.sleep(8000);
			Logger.info("START OF COPY ORDER");

			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();
			Thread.sleep(8000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(3000);
			newOrderInstance.enterPageCount("4");
			Thread.sleep(4000);
			newOrderInstance.selectMaterialSource("1", "Straight Pickup");
			Thread.sleep(3000);
			newOrderInstance.clickOnPickUpSearch();
			Thread.sleep(4000);
			newOrderInstance.selectPickUp(orderNo);
			Thread.sleep(4000);
			newOrderInstance.clickRefreshDraw();
			Thread.sleep(18000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(5000);// mou
			newOrderInstance.clickOnContinuePastPubDate();// mou
			Thread.sleep(2000);// mou
			String orderNumber1 = orderEntryPageInstance.getOrderID();
			Logger.info(orderEntryPageInstance.getOrderID());
			// String orderNumber1 = orderEntryPageInstance.getOrderID();
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			Logger.info("Saved Order : " + orderNumber1);
			orderEntryPageInstance.clickOnOrder(orderNumber1);
			wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement));
			Thread.sleep(8000);
			newOrderInstance.clickOnHistoryButton();
			Thread.sleep(3000);
			String orderStatus2 = newOrderInstance.getOrderHistoryActivity(3);// mou

			boolean statusflag2 = false;

			if (orderStatus2.trim().contains(
					"routedownstream::adwatch: problem creating pickup-number tag. check pickupordernumber and pickuporderlinenumber")) {

				Logger.info("Logged activity for error : " + newOrderInstance.getOrderHistoryActivity(1));
				statusflag2 = true;
			}
			Assert.assertEquals(statusflag2, true);

			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	// arka
	/*
	 * @Test(groups = {"Order",
	 * "preprintOrderColorMaterialAdSizeWarning","OrderDisplayOnlineTest","Grp4"
	 * ,"RegressionLatest","reRunP","PreprintReg","Group5","RegFailed3",
	 * "DsplyReg1","TestPriority","Group5F","NewRegression","G5","RerunF2"},
	 * dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class,
	 * dataProvider = "userData") public void
	 * preprintOrderColorMaterialAdSizeWarning(Map<String, String> userData)
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
	 * NewOrderPage.class); newOrderInstance.selectSoldToCustomerBU("bu_LAT");
	 * newOrderInstance.enterSoldToCustomer("CU00059747");
	 * newOrderInstance.selectBilltoSameAsSoldTo();
	 * newOrderInstance.selectOrderType("OrderType_Standard");
	 * newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
	 * newOrderInstance.createNewInsertion(); newOrderInstance.selectBU("1",10,
	 * 0); Thread.sleep(3000); newOrderInstance.enterPubDate("1","22", "Dec",
	 * "2019"); Thread.sleep(3000); newOrderInstance.selectProductType("1",10,
	 * 1); Thread.sleep(3000); newOrderInstance.selectProduct("1",10, 2);
	 * Thread.sleep(3000); newOrderInstance.selectAdType("1",10, 3);
	 * Thread.sleep(5000); // newOrderInstance.selectSection("1",35, 4); //
	 * Thread.sleep(4000); newOrderInstance.viewInsertionDetails("1");
	 * newOrderInstance.addOrEditInsersionVerisonID("1", 1); //
	 * newOrderInstance.selectMaterialSource("1","N/A");
	 * newOrderInstance.clickOnDistributions(1); Thread.sleep(40000); //
	 * newOrderInstance.clickOnSearchZoneLink(); Thread.sleep(3000);
	 * newOrderInstance.selectZonePreprintOrder("Full"); // int
	 * countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
	 * newOrderInstance.confirmZoneSelection(); Thread.sleep(5000);
	 * 
	 * newOrderInstance.selectPageType("1", "PP_PaperType_Singlesheet");
	 * Thread.sleep(3000); newOrderInstance.enterPageCount("2");
	 * Thread.sleep(3000); newOrderInstance.clickOnInsertionSalesRepSection(1);
	 * // newOrderInstance.removeSalesRepOnInsertion(1); Thread.sleep(4000);
	 * newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
	 * Thread.sleep(4000); newOrderInstance.clickOnInsertionSalesRepSection(1);
	 * Thread.sleep(4000); newOrderInstance.applytoAllSalesRepOnInsertion(1);
	 * Thread.sleep(2000); Thread.sleep(4000); newOrderInstance.submitOrder();
	 * Thread.sleep(1000); String orderID = orderEntryPageInstance.getOrderID();
	 * Logger.info("Order ID: "+orderID);
	 * orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
	 * Thread.sleep(2000); List<WebElement> list =
	 * driver.findElements(By.xpath("//div[@class='row ng-scope']"));
	 * WebDriverWait wait = new WebDriverWait(driver,20);
	 * wait.until(ExpectedConditions.visibilityOfAllElements(list));
	 * orderEntryPageInstance.clickOnOrder(orderID); Thread.sleep(5000);
	 * newOrderInstance.viewInsertionDetails("1"); Thread.sleep(4000);
	 * newOrderInstance.selectAdType("1",35, 3); Thread.sleep(5000);
	 * newOrderInstance.clickOnDistributions(1); Thread.sleep(40000); //
	 * newOrderInstance.clickOnSearchZoneLink(); Thread.sleep(3000);
	 * newOrderInstance.selectZonePreprintOrder("Full"); // int
	 * countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
	 * newOrderInstance.confirmZoneSelection(); Thread.sleep(5000); //
	 * newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.addNewSalesRepOnInsertion(1,
	 * "SA01380");Thread.sleep(4000);newOrderInstance.
	 * clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);
	 * Thread.sleep(4000); newOrderInstance.submitOrder();
	 * newOrderInstance.displayWarningMsg(); Thread.sleep(2000);
	 * newOrderInstance.clickOnContinuePastPubDate(); Thread.sleep(3000);
	 * newOrderInstance.viewInsertionDetails("1"); Thread.sleep(4000);
	 * orderEntryPageInstance.clickOnOrder(orderID); Thread.sleep(13000);
	 * newOrderInstance.selectAdType("1",10, 3); Thread.sleep(5000);
	 * newOrderInstance.selectMaterialSource("1","Perpetual");
	 * Thread.sleep(3000); newOrderInstance.clickOnPickUpSearch();
	 * Thread.sleep(7000); newOrderInstance.clickOnOrderInPickUpWindw();
	 * Thread.sleep(6000); newOrderInstance.clickOnSelectBtnPickUpWindw();
	 * Thread.sleep(3000);newOrderInstance.displayWarningMsg();
	 * Thread.sleep(2000); newOrderInstance.clickOnContinuePastPubDate();
	 * Thread.sleep(3000); orderEntryPageInstance.clickOnOrder(orderID);
	 * Thread.sleep(13000); newOrderInstance.viewInsertionDetails("1");
	 * Thread.sleep(4000); newOrderInstance.selectMaterialSource("1","N/A");
	 * Thread.sleep(3000); newOrderInstance.selectPageType("1",
	 * "PP_PaperType_Broadsheet"); Thread.sleep(3000);
	 * newOrderInstance.displayWarningMsg(); Thread.sleep(2000);
	 * newOrderInstance.clickOnContinuePastPubDate(); Thread.sleep(3000); //
	 * orderEntryPageInstance.clickOnOrder(orderID); // Thread.sleep(13000);
	 * newOrderInstance.viewInsertionDetails("1"); Thread.sleep(4000);
	 * newOrderInstance.selectPageType("1", "PP_PaperType_Tab");
	 * Thread.sleep(3000); newOrderInstance.enterPageCount("4");
	 * Thread.sleep(3000); //
	 * newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.addNewSalesRepOnInsertion(1,
	 * "SA01380");Thread.sleep(4000);newOrderInstance.
	 * clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);
	 * Thread.sleep(4000);
	 * newOrderInstance.submitOrder();newOrderInstance.displayWarningMsg();
	 * Thread.sleep(2000); newOrderInstance.clickOnContinuePastPubDate();
	 * //Thread.sleep(3000); // orderEntryPageInstance.clickOnOrder(orderID);
	 * 
	 * // dashboardPageInstance.clickOnLogout(); } catch(Exception e) {
	 * Logger.error(e.getMessage()); throw e; } }
	 */
	@Test(groups = { "NovMaintenance", "Order", "preprintOrderColorMaterialAdSizeWarning", "PrioritizedReg2",
			"OrderDisplayOnlineTest", "Grp4", "RegressionLatest", "reRunP", "PreprintReg", "Group5", "RegFailed3",
			"DsplyReg1", "TestPriority", "Group5F", "NewRegression2", "NewRegression", "G5", "RerunF2",
			"preprintOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void preprintOrderColorMaterialAdSizeWarning(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 10, 0);
			Thread.sleep(6000);
			 newOrderInstance.enterPubDateFromExcel("1",9,27);//swagata

			//newOrderInstance.enterPubDate("1", "21", "Dec", "2019");// arka
			Thread.sleep(6000);
			newOrderInstance.selectProductType("1", 10, 1);
			Thread.sleep(6000);
			newOrderInstance.selectProduct("1", 10, 2);
			Thread.sleep(60000);
			newOrderInstance.selectAdType("1", 10, 3);
			Thread.sleep(5000);
			// newOrderInstance.selectSection("1",35, 4);
			// Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			Thread.sleep(5000);

			newOrderInstance.selectMaterialSource("1", "Electronic");
			Thread.sleep(3000);
			
			newOrderInstance.clickOnDistributions(1);
			//Thread.sleep(180000);//swagata

			newOrderInstance.selectZonePreprintOrder("Full");

			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(3000);
			newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_AdProd");//joy
			Thread.sleep(3000);
			newOrderInstance.selectPandDPaperStock("1", "PP_PaperStock_100Gloss");//joy
			Thread.sleep(3000);
			newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess");//joy
			Thread.sleep(3000);
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			Thread.sleep(2000);

			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(2000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(2000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(2000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(1000);
			Thread.sleep(2000);
			newOrderInstance.submitOrder();
			Thread.sleep(2000);
			//newOrderInstance.ClickContinueButton(); 
			//Thread.sleep(5000);
			// newOrderInstance.clickOnContinuePastPubDate();
			Thread.sleep(2000);
			String orderNo = orderEntryPageInstance.getOrderID();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderNo);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement));
			Thread.sleep(8000);
			Logger.info("START OF COPY ORDER");

			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();
			Thread.sleep(8000);
			newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.selectAdType("1",10, 3);//mou
			// Thread.sleep(5000);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			Thread.sleep(5000);
			newOrderInstance.selectMaterialSource("1", "Electronic");// mou
			Thread.sleep(3000);
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(10000);// arka

			newOrderInstance.selectZonePreprintOrder("Full");

			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(3000);
			newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_AdProd");
			Thread.sleep(3000);
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			//newOrderInstance.ClickContinueButton(); //joy
			//Thread.sleep(3000);
			
			
			String orderNo1 = orderEntryPageInstance.getOrderID();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderNo1);
			WebDriverWait wait1 = new WebDriverWait(driver, 120);
			wait1.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement));
			Thread.sleep(8000);
			Logger.info("START OF COPY ORDER");

			wait1.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();
			Thread.sleep(8000);
			newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.selectAdType("1",10, 3);//mou
			// Thread.sleep(5000);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			Thread.sleep(5000);
			newOrderInstance.selectMaterialSource("1", "Straight Pickup");
			Thread.sleep(3000);
			//newOrderInstance.clickOnDistributions(1);
			//Thread.sleep(10000);// arka
			newOrderInstance.clickOnPickUpSearch();
			Thread.sleep(4000);
			newOrderInstance.searchOrderNoPickUpWindow(orderNo);//swagata
			Thread.sleep(2000);
			newOrderInstance.selectPickUp(orderNo);
			Thread.sleep(4000);
			newOrderInstance.clickRefreshDraw();
			//newOrderInstance.selectZonePreprintOrder("Full");

			//newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			
			
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			//newOrderInstance.ClickContinueButton(); //joy
			Thread.sleep(3000);
			// newOrderInstance.clickOnContinuePastPubDate();// mou
			//Thread.sleep(2000);// mou
			/*String orderNo1 = orderEntryPageInstance.getOrderID();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderNo1);
			WebDriverWait wait1 = new WebDriverWait(driver, 120);
			wait1.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement));
			Thread.sleep(8000);
			Logger.info("START OF COPY ORDER");

			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();
			Thread.sleep(8000);
			// newOrderInstance.viewInsertionDetails("1");
			// Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(2000);
			newOrderInstance.selectMaterialSource("1", "Straight Pickup");
			Thread.sleep(3000);
			newOrderInstance.enterPageCount("2");
			Thread.sleep(4000);
			newOrderInstance.clickOnPickUpSearch();
			Thread.sleep(4000);
			newOrderInstance.searchOrderNoPickUpWindow(orderNo);//swagata
			Thread.sleep(2000);
			newOrderInstance.selectPickUp(orderNo);
			Thread.sleep(4000);
			newOrderInstance.clickRefreshDraw();
			Thread.sleep(18000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			//Thread.sleep(2000);
			Thread.sleep(4000);
			
			newOrderInstance.submitOrder();
			
			Thread.sleep(2000);
			newOrderInstance.ClickContinueButton(); //joy
			/*String orderID2 = orderEntryPageInstance.getOrderID();
			Logger.info("Order ID: " + orderID2);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			WebDriverWait wait2 = new WebDriverWait(driver, 20);
			wait2.until(ExpectedConditions.visibilityOfAllElements(list2));
			orderEntryPageInstance.clickOnOrder(orderID2);*/

			Thread.sleep(2000);
			//dashboardPageInstance.clickondropdownforlogout();/joy

			 //dashboardPageInstance.clickOnLogout();//swagata
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "preprintOrderPickUpChangeBlocker", "PrioritizedReg2",
			"preprintOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void preprintOrderPickUpChangeBlocker(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 43, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "31", "May", "2019"); /* changed */
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 43, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 43, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 43, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			Thread.sleep(4000);
			newOrderInstance.enterPerpetualQuantity(100000);
			Thread.sleep(4000);
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(60000);// mou
			// newOrderInstance.clickOnSearchZoneLink();//
			// Thread.sleep(10000);//
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			newOrderInstance.enterPageCount("6");
			Thread.sleep(4000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(5000);
			newOrderInstance.selectMaterialSource("1", "Perpetual");
			Thread.sleep(3000);
			// newOrderInstance.clearPerpetualQuantity();//mou
			// Thread.sleep(3000);//mou
			newOrderInstance.clickOnPickUpSearch();
			Thread.sleep(7000);
			newOrderInstance.clickOnSpecificOrderInPickUpWindw("0");
			Thread.sleep(6000);
			newOrderInstance.clickOnSelectBtnPickUpWindw();
			Thread.sleep(7000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);// mou
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(2); // mou
			Thread.sleep(2000);
			Thread.sleep(4000);
			// newOrderInstance.viewInsertionDetails("1");//mou

			newOrderInstance.clickRefreshDraw();
			Thread.sleep(7000);

			newOrderInstance.submitOrder();
			Thread.sleep(5000);
			newOrderInstance.clickOnContinuePastPubDate();// mou
			Thread.sleep(2000);// mou

			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order ID: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			WebDriverWait wait = new WebDriverWait(driver, 20);

			orderEntryPageInstance.clickOnOrder(orderID);

			Thread.sleep(3000);
			// DashboardPage dashboardPageInstance =
			// PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnOrderEntryModule();

			// OrderEntryHomePage orderEntryPageInstance =
			// PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			// NewOrderPage newOrderInstance = PageFactory.initElements(driver,
			// NewOrderPage.class);
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
			newOrderInstance.selectBU("1", 43, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "31", "May", "2019"); /* changed */
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 43, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 43, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 43, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			Thread.sleep(4000);
			newOrderInstance.enterPerpetualQuantity(100000);
			Thread.sleep(4000);
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(120000);// mou
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			newOrderInstance.enterPageCount("6");
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
			newOrderInstance.submitOrder();
			Thread.sleep(5000);
			newOrderInstance.clickOnContinuePastPubDate();// mou
			Thread.sleep(2000); // mou

			String orderID1 = orderEntryPageInstance.getOrderID();
			Logger.info("Order ID: " + orderID1);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			// List<WebElement> list =
			// driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			// WebDriverWait wait = new WebDriverWait(driver,20);
			// wait.until(ExpectedConditions.visibilityOfAllElements(list));
			driver.findElement(By.xpath("//label[text()='Keyword ']/../div/div/button")).click();
			Thread.sleep(3000);
			// driver.findElement(By.xpath(".//*[@id='app']/div[3]/div[2]/div[2]/div[1]/div/div[1]/div[1]/div/div/div/ul/li[9]/label/i")).click();
			driver.findElement(By.xpath("//label[text()='Keyword ']/../div/div/ul/li[11]/label/i")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='keyword']")).click();
			driver.findElement(By.xpath(".//*[@id='keyword']")).sendKeys("Sunny Mukherjee");
			orderEntryPageInstance.orderSearchBtn.click();
			Thread.sleep(8000);

			orderEntryPageInstance.clickOnOrder(orderID);

			Thread.sleep(3000);

			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.clickOnPickUpSearch();
			Thread.sleep(8000); /* changed */
			newOrderInstance.clickOnSpecificOrderInPickUpWindw("1"); /* changed */
			Thread.sleep(6000);
			newOrderInstance.clickOnSelectBtnPickUpWindw();
			Thread.sleep(3000);
			// newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1,
			// "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			// newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(5000);
			newOrderInstance.clickOnContinuePastPubDate();// mou
			Thread.sleep(2000);// mou

			newOrderInstance.displayErrorMessageMultiple(1);
			newOrderInstance.compareErrorMessageMultiple(
					"Ad Size, Material Source, Color, Pickup#, Version, Preprint Type, Page Count, Page Type or Ad Type has changed without reassigning Material Id for 01-00Preprint OrderLine properties were modified which will impact the SAM downstream system. 01-00Would you want to continue?",
					1);
			Thread.sleep(2000);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "preprintOrderPreferredDistribution", "Grp4", "RegressionLatest", "reRunP", "PreprintReg",
			"Group5", "RegFailed3",
			"Group5F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderPreferredDistribution(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 43, 0);
			Thread.sleep(4000);
			// newOrderInstance.enterPubDateFromExcel("1",43,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 43, 1);
			Thread.sleep(4000);
			// newOrderInstance.selectProduct("1",43, 2);
			// Thread.sleep(4000);
			// newOrderInstance.selectAdType("1",43, 3);
			// Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			/*
			 * newOrderInstance.checkUncheckBillQty(false); Thread.sleep(3000);
			 * newOrderInstance.enterBilledQty(5);
			 */
			Thread.sleep(3000);
			// newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(45000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(7000);
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(45000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("SubZip");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(7000);
			newOrderInstance.selectBU("1", 65, 0);
			Thread.sleep(4000);
			// newOrderInstance.enterPubDateFromExcel("1",65,27);
			// Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 65, 1);
			Thread.sleep(4000);
			// newOrderInstance.selectProduct("1",65, 2);
			// Thread.sleep(4000);
			// newOrderInstance.selectAdType("1",65, 3);
			// Thread.sleep(3000);
			// newOrderInstance.selectSection("1",65, 4);
			// Thread.sleep(6000);
			// newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			/*
			 * newOrderInstance.checkUncheckBillQty(false); Thread.sleep(3000);
			 * newOrderInstance.enterBilledQty(5);
			 */
			Thread.sleep(3000);
			// newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(45000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(7000);
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(45000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("SubZip");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(7000);
			newOrderInstance.selectBU("1", 68, 0);
			Thread.sleep(4000);
			// newOrderInstance.enterPubDateFromExcel("1",68,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 68, 1);
			Thread.sleep(4000);
			// newOrderInstance.selectProduct("1",68, 2);
			// Thread.sleep(4000);
			// newOrderInstance.selectAdType("1",68, 3);
			// Thread.sleep(3000);
			// newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			/*
			 * newOrderInstance.checkUncheckBillQty(false); Thread.sleep(3000);
			 * newOrderInstance.enterBilledQuantity(12024); Thread.sleep(3000);
			 */
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(45000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("SubZip");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(7000);
			newOrderInstance.selectBU("1", 77, 0);
			Thread.sleep(4000);
			// newOrderInstance.enterPubDateFromExcel("1",77,27);
			// Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 77, 1);
			Thread.sleep(4000);
			// newOrderInstance.selectProduct("1",77, 2);
			// Thread.sleep(4000);
			// newOrderInstance.selectAdType("1",77, 3);
			// Thread.sleep(5000);
			// newOrderInstance.selectSection("1",77, 4);
			// Thread.sleep(6000);
			// newOrderInstance.viewInsertionDetails("1");
			// Thread.sleep(4000);
			// newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			Thread.sleep(4000);
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(45000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(7000);
			newOrderInstance.selectBU("1", 33, 0);
			Thread.sleep(4000);
			// newOrderInstance.enterPubDateFromExcel("1",33,27);
			// Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 33, 1);
			Thread.sleep(4000);
			// newOrderInstance.selectProduct("1",33, 2);
			// Thread.sleep(4000);
			// newOrderInstance.selectAdType("1",33, 3);
			// Thread.sleep(3000);
			// newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// Thread.sleep(3000);
			// newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(45000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(7000);
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(45000);
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("SubZip");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(7000);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "preprintOrderCopy", "reRunP", "PreprintReg", "Grp4", "Pre1", "RegFailed3", "Group5F",
			"NewRegression2", "NewRegression", "G5", "NovMaintenance",
			"preprintOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderCopy(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 43, 0);
			Thread.sleep(4000);
			 newOrderInstance.enterPubDateFromExcel("1",9,27);//swagata

			//newOrderInstance.enterPubDate("1", "21", "Dec", "2019"); // arka
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 43, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 43, 2);
			Thread.sleep(5000);
			newOrderInstance.selectAdType("1", 43, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			Thread.sleep(4000);
			newOrderInstance.enterPerpetualQuantity(10000);
			Thread.sleep(4000);
			newOrderInstance.clickOnDistributions(1);
			//Thread.sleep(10000);//swagata
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(7000); // mou
			newOrderInstance.viewInsertionDetails("2");
			newOrderInstance.clickRefreshDraw();
			Thread.sleep(10000);// mou
newOrderInstance.collapseInsertionDetails("2");//swagata
Thread.sleep(4000);
			
			/*
			 * newOrderInstance.clickOnInsertionSalesRepSection(1); //
			 * newOrderInstance.removeSalesRepOnInsertion(1); Thread.sleep(4000);
			 * newOrderInstance.addNewSalesRepOnInsertion(1, "SA01774");//swagata
			 * Thread.sleep(4000); newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * Thread.sleep(4000); newOrderInstance.applytoAllSalesRepOnInsertion(1);
			 * Thread.sleep(2000);
			 */
			newOrderInstance.submitOrder();

			//Thread.sleep(5000);//swagata
			// newOrderInstance.clickOnContinuePastPubDate();// mou
			// Thread.sleep(2000);// mou
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order ID: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderEntryPageInstance.clickOnOrder(orderID);

			Thread.sleep(6000);
			Logger.info("START OF COPY ORDER");

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			// js.executeScript("window.scrollTo(0,
			// -document.body.scrollHeight);");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")));
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();
			Thread.sleep(8000);
			// newOrderInstance.viewInsertionDetails("1");
			// Thread.sleep(3000);
			/*
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * Thread.sleep(4000); newOrderInstance.addNewSalesRepOnInsertion(1,
			 * "SA01380"); Thread.sleep(4000);
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * Thread.sleep(4000);
			 * newOrderInstance.applytoAllSalesRepOnInsertion(1);
			 * Thread.sleep(4000);
			 */
		//	newOrderInstance.submitOrder();//swagata
			newOrderInstance.saveOrder();//swagata

			Thread.sleep(1000);
			newOrderInstance.displayErrorMessageMultiple(1);
			newOrderInstance.compareErrorMessageMultiple(
					"Distribution maybe out of date for insertion 01-00. Please open the distribution dialog to verify",
					1);
			Thread.sleep(4000);
			newOrderInstance.clickRefreshDraw();
			Thread.sleep(18000); // mou
			newOrderInstance.submitOrder();
			//Thread.sleep(5000);//swagata
			// newOrderInstance.clickOnContinuePastPubDate();// mou
			// Thread.sleep(2000);// mou
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "SMaintenance","Order", "preprintOrderCopyPubDateChng","NovMaintenance", "RegressionLatest", "reRunP", "PreprintReg", "Grp4",
			"Pre1", "Group5", "RegFailed3", "Group5F", "NANT", "NewRegression2", "NewRegression", "G5", "RerunF2",
			"preprintOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderCopyPubDateChng(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 43, 0);
			Thread.sleep(4000);
			 newOrderInstance.enterPubDateFromExcel("1",9,27);//swagata
			// newOrderInstance.enterPubDate("1", "31", "May", "2019");//swagata
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 43, 1);
			Thread.sleep(4000);

			newOrderInstance.selectProduct("1", 43, 2);// arka
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 43, 3);// arka
			Thread.sleep(3000);

			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			Thread.sleep(2000);// swagata
			newOrderInstance.viewInsertionDetails("1");// mou
			Thread.sleep(6000);//mou
			// newOrderInstance.selectMaterialSource("1","N/A");
			// Thread.sleep(4000);
			//newOrderInstance.enterPerpetualQuantity(100000);//swagata
			//Thread.sleep(4000);//swagata
			newOrderInstance.clickOnDistributions(1);//swagata
			newOrderInstance.selectZonePreprintOrder("Full");//swagata
			newOrderInstance.confirmZoneSelection();//swagata

			/*
			 * newOrderInstance.clickOnDistributions(1);//swagata
			 /* driver.findElement(By.xpath(
			 * "(//*[@id='insertionInfo']/form/div/table/tbody/tr[2]/td/div/div/div/div[1]/div/div[2]/div[4]/div/span[2])"
			 * )).click();//swagata Thread.sleep(4000);//swagata
			 * Logger.info("distributions button is clicked");//swagata
			 * Thread.sleep(4000);
			 */
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			/*
			 * newOrderInstance.selectZonePreprintOrder("Full"); // int
			 * countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
			 * newOrderInstance.confirmZoneSelection(); Thread.sleep(5000);
			 
			Thread.sleep(3000);
			newOrderInstance.checkUncheckBillQty(false);
			Thread.sleep(3000);
			newOrderInstance.enterBilledQty(5);*/// swagata
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(7000);
			newOrderInstance.clickRefreshDraw();
			Thread.sleep(6000);

			/*
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(
			 * 4000);newOrderInstance.addNewSalesRepOnInsertion(2,
			 * "SA01380");Thread.sleep(4000);newOrderInstance.
			 * clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
			 * newOrderInstance.applytoAllSalesRepOnInsertion(2);Thread.sleep(
			 * 2000);Thread.sleep(4000); newOrderInstance.submitOrder();
			 * //Thread.sleep(5000); Thread.sleep(9000); String orderID =
			 * orderEntryPageInstance.getOrderID();
			 * Logger.info("Order ID: "+orderID);
			 * orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			 * Thread.sleep(2000); // List<WebElement> list =
			 * driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			 * WebDriverWait wait = new WebDriverWait(driver,20); //
			 * wait.until(ExpectedConditions.visibilityOfAllElements(list));
			 * orderEntryPageInstance.clickOnOrder(orderID);
			 * 
			 * Thread.sleep(6000);
			 */
			Logger.info("START OF COPY ORDER");

			/*
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * Thread.sleep(2000); newOrderInstance.addNewSalesRepOnInsertion(1,
			 * "SA01380"); Thread.sleep(4000);
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * Thread.sleep(4000);
			 * newOrderInstance.applytoAllSalesRepOnInsertion2(1);
			 * Thread.sleep(2000);
			 * 
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * Thread.sleep(4000);
			 * newOrderInstance.applytoAllSalesRepOnInsertion(1);
			 * Thread.sleep(2000); Thread.sleep(4000);
			 */
			newOrderInstance.submitOrder();
			//newOrderInstance.ClickContinueButton(); //joy
			//Thread.sleep(8000); //swagata
			// newOrderInstance.clickOnContinuePastPubDate();// swagata
			//Thread.sleep(2000);// swagata
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order ID: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderEntryPageInstance.clickOnOrder(orderID);

			Thread.sleep(6000);
			Logger.info("START OF COPY ORDER");
			Thread.sleep(6000);// swagata
			//JavascriptExecutor js = ((JavascriptExecutor) driver);//swagata
			// js.executeScript("window.scrollTo(0,
			// -document.body.scrollHeight);");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")));
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(3000);
			/*newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(6000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");// arka
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			// Thread.sleep(2000);//swagata
			Thread.sleep(6000);*///swagata
			//newOrderInstance.submitOrder();
			//Thread.sleep(3000);

			/*newOrderInstance.displayErrorMessageMultiple(1);
newOrderInstance.compareErrorMessageMultiple("Distribution maybe out of date for insertion 01-00. Please open the distribution dialog to verify",1); 
			  Thread.sleep(2000);
			  newOrderInstance.displayErrorMessageMultiple(2);
			  newOrderInstance.compareErrorMessageMultiple("Distribution maybe out of date for insertion 02-00. Please open the distribution dialog to verify",2); 
			  Thread.sleep(2000);
			 
			newOrderInstance.displayErrorMessageMultiple(1);// mou
			newOrderInstance.compareErrorMessageMultiple(
					"Insertion 01-00, distribution quantity has changed, please review.", 1);// mou
			Thread.sleep(2000);
			newOrderInstance.displayErrorMessageMultiple(2);
			newOrderInstance.compareErrorMessageMultiple(
					"Insertion 02-00, distribution quantity has changed, please review.", 2);// mou
			Thread.sleep(2000);// mou
			newOrderInstance.clickRefreshDraw();// mou
			Thread.sleep(60000);// mou
			// newOrderInstance.enterPubDate("1","28", "Nov", "2019");
			newOrderInstance.enterPubDate("1", "28", "Dec", "2019");// arka
			Thread.sleep(5000);
			newOrderInstance.submitOrder();
			Thread.sleep(5000);
			newOrderInstance.displayErrorMessageMultiple(1);// mou
			newOrderInstance.compareErrorMessageMultiple(
					"Insertion 01-00, distribution quantity has changed, please review.", 1);// mou
			Thread.sleep(2000);// mou
			newOrderInstance.displayErrorMessageMultiple(2);
			newOrderInstance.compareErrorMessageMultiple(
					"Insertion 02-00, distribution quantity has changed, please review.", 2);// mou
			Thread.sleep(2000);// mou
			// newOrderInstance.clickOnContinuePastPubDate();//swagata
			// Thread.sleep(3000);//swagata
			newOrderInstance.clickRefreshDraw();// mou
			Thread.sleep(5000);// mou
			newOrderInstance.submitOrder();// mou
			Thread.sleep(5000);// mou
			newOrderInstance.clickOnContinuePastPubDate();// mou
			Thread.sleep(2000);// mou
			String orderID1 = orderEntryPageInstance.getOrderID();// mou
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);*/
			dashboardPageInstance.clickOnLogout();// arka
			//dashboardPageInstance.clickondropdownforlogout();//joy
			
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "SwagataMou", "Order", "NovMaintenance", "preprintOrderVerifyHistoryPandD", "RegressionLatest",
			"reRunP", "PreprintReg", "Grp4", "Pre1", "Group5", "RegFailed3", "Group5F", "NANT", "NewRegression2",
			"NewRegression", "G5", "RerunF2",
			"preprintOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderVerifyHistoryPandD(Map<String, String> userData) throws Exception {
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
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 75, 0);
			Thread.sleep(4000);
			 newOrderInstance.enterPubDateFromExcel("1",9,27);//swagata
			// newOrderInstance.enterPubDateFromExcel("1",75,27);//payel
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 75, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 75, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 75, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1", 75, 4);
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			Thread.sleep(3000);
			newOrderInstance.selectPageType("1", "PP_PaperType_5.5x8.5SglSheet");// swagata
			Thread.sleep(3000);
			newOrderInstance.enterPageCount("2");
			Thread.sleep(4000);
			/*
			 * newOrderInstance.checkUncheckBillQty(false); Thread.sleep(3000);
			 * newOrderInstance.enterBilledQty(5); Thread.sleep(3000);
			 */
			newOrderInstance.selectMaterialSource("1", "New Build");
			Thread.sleep(3000);
			newOrderInstance.clickOnDistributions(1);
			//Thread.sleep(40000);
			newOrderInstance.selectAllZonePreprintOrder();
			Thread.sleep(4000);
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(4000);
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(3000);
			newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_AdProd");
			// Thread.sleep(3000);
			// newOrderInstance.selectPandDPaperStock("1",
			// "PP_PaperStock_60Coated");
			// Thread.sleep(3000);
			newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess");
			Thread.sleep(3000);
			// newOrderInstance.selectPandDFold("1", "PP_Fold_HalfFoldd");
			// Thread.sleep(3000);
			// newOrderInstance.selectPandDPerforation("1",
			// "PP_Perforation_Yes");
			// Thread.sleep(3000);
			newOrderInstance.selectPandDPrinter("1", "PP_Printer_NPC");
			Thread.sleep(3000);
			newOrderInstance.selectPandDInk("1", "4 Color Process");
			Thread.sleep(3000);
			// newOrderInstance.selectPandDOrientation("1", "Horizontal");
			// Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01774");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(4000);
			// Thread.sleep(5000);// swagata
			newOrderInstance.ClickContinueButton();//joy
			//newOrderInstance.clickOnContinuePastPubDate();// joy
			Thread.sleep(2000);// mou
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);

			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(3000);

			newOrderInstance.selectPandDInk("1", "Spot Color");
			Thread.sleep(3000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			// Thread.sleep(5000);//swagata
			// newOrderInstance.clickOnContinuePastPubDate();//swagata
			Thread.sleep(2000);// mou

			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);// mou

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);// mou

			newOrderInstance.clickOnHistoryButton();
			Thread.sleep(3000);
			newOrderInstance.getOrderHistoryUpdateDetails(2);//swagata
			String orderUpdate = newOrderInstance.panddColorChange();// swagata
			Assert.assertEquals("order insertion 1-0 - p&d print specs - inkfront- 4 color process change to spot color",orderUpdate);// swagata
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "preprintOrderDefaultVersionDistribution", "RegressionLatest", "reRunP", "PreprintReg",
			"Grp4", "Pre1", "Group5",
			"RegFailed3" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderDefaultVersionDistribution(Map<String, String> userData) throws Exception {
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
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 75, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "29", "Dec", "2019");
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 75, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 75, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 75, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			;
			// newOrderInstance.selectMaterialSource("1","N/A");
			Thread.sleep(4000);
			newOrderInstance.createNewInsertionVersion("1");
			Thread.sleep(5000);
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(15000);
			newOrderInstance.selectVersionInDistribution("01-00");
			Thread.sleep(4000);
			newOrderInstance.selectVersionInDistribution("01-01");
			Thread.sleep(4000);
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "SwagataMou", "Order", "preprintPgCntChngError","NovMaintenance", "PrioritizedReg2", "Grp4", "RegressionLatest",
			"reRunP", "PreprintReg", "Group5", "RegFailed3", "Group5F", "NewRegression2", "NewRegression", "G5",
			"RerunF2",
			"preprintOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void preprintPgCntChngError(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 43, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "07", "Jan", "2021");// swagata
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 43, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 43, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 43, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			Thread.sleep(3000);

			/*
			 * newOrderInstance.checkUncheckBillQty(false); Thread.sleep(3000);
			 * newOrderInstance.enterBilledQty(5);
			 */
			Thread.sleep(3000);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			Thread.sleep(4000);

			newOrderInstance.selectMaterialSource("1", "Electronic");
			Thread.sleep(5000);
			// newOrderInstance.selectPageType("1", "Brd FC 35# Off");// swagata
			// newOrderInstance.selectPageType("1", "PP_PaperType_EZTarget");//
			// swagata

			//Thread.sleep(3000);
			// newOrderInstance.enterPageCount("2");//swagata
			Thread.sleep(4000);
			// newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			newOrderInstance.clickOnDistributions(1);
			// Thread.sleep(18000);// swagata
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(3000);
			newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_AdProd");
			Thread.sleep(3000);
			newOrderInstance.selectPandDPaperStock("1", "PP_PaperStock_100Gloss");// swagata
			Thread.sleep(3000);
			newOrderInstance.collapseInsertionDetails("1");// swagata
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("2");// swagata
//monday
			newOrderInstance.selectPageType("2", "PP_PaperType_TabFC30News");// joy
	
			newOrderInstance.enterPageCount("4");// joy
			Thread.sleep(3000);

			newOrderInstance.selectMaterialSource("2", "New Build");// swagata
			newOrderInstance.collapseInsertionDetails("2");// swagata
			Thread.sleep(4000);
			newOrderInstance.clickRefreshDraw();
			Thread.sleep(18000);

			// newOrderInstance.viewInsertionDetails("2");//swagata
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(2);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(2);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(2);
			Thread.sleep(2000);
			//Thread.sleep(4000); //joy
			newOrderInstance.submitOrder();
			Thread.sleep(2000);// mou
			newOrderInstance.displayErrorMessage();
			newOrderInstance.compareErrorMessage(
					"Two or more insertion lines with the same Material ID have different PageCounts! These are lines 01-00 02-00");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	// arka
	/*
	 * @Test(groups =
	 * {"Order","preprintOverrun","Grp4","RegressionLatest","Group5",
	 * "RegFailed3","reRunP","Group5F","PreprintReg","NewRegression","G5",
	 * "RerunF2"}, dataProviderClass =
	 * com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider =
	 * "userData") public void preprintOverrun(Map<String, String> userData)
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
	 * NewOrderPage.class); newOrderInstance.selectSoldToCustomerBU("bu_DPR");
	 * newOrderInstance.enterSoldToCustomer("CU00013249");
	 * newOrderInstance.selectBilltoSameAsSoldTo();
	 * newOrderInstance.selectOrderType("OrderType_Standard");
	 * newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
	 * Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
	 * Thread.sleep(4000); newOrderInstance.createNewInsertion();
	 * Thread.sleep(4000); newOrderInstance.selectBU("1",57, 0);
	 * Thread.sleep(4000); newOrderInstance.enterPubDateFromExcel("1",57,27);
	 * Thread.sleep(5000); newOrderInstance.selectProductType("1",57, 1);
	 * Thread.sleep(4000); /* newOrderInstance.selectProduct("1",57, 2);
	 * Thread.sleep(4000); newOrderInstance.selectAdType("1",57, 3);
	 * Thread.sleep(3000);
	 */
	// newOrderInstance.viewInsertionDetails("1");
	// newOrderInstance.addOrEditInsersionVerisonID("1", 1);
	// newOrderInstance.selectMaterialSource("1","N/A");
	/*
	 * newOrderInstance.checkUncheckBillQty(false); Thread.sleep(3000);
	 * newOrderInstance.enterBilledQty(5); Thread.sleep(3000);
	 */
	// newOrderInstance.clickOnDistributions(1);
	// Thread.sleep(45000);
	// newOrderInstance.clickOnSearchZoneLink();
	// Thread.sleep(10000);
	// newOrderInstance.selectZonePreprintOrder("SubZip");
	// int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
	// newOrderInstance.confirmZoneSelection();
	// Thread.sleep(5000);
	/*
	 * newOrderInstance.selectTypeInSettingsPreprintOrder("1",
	 * "Preprint_SettingsType_CustSupplied"); Thread.sleep(3000);
	 * newOrderInstance.selectPageType("1", "PP_PaperType_Tabloid");
	 * Thread.sleep(3000); newOrderInstance.enterPageCount("2");
	 * Thread.sleep(4000);
	 */

	// newOrderInstance.clickOnInsertionSalesRepSection(1);
	// newOrderInstance.removeSalesRepOnInsertion(1);
	/*
	 * Thread.sleep(4000); newOrderInstance.addNewSalesRepOnInsertion(1,
	 * "SA02514"); Thread.sleep(4000);
	 * newOrderInstance.clickOnInsertionSalesRepSection(1); Thread.sleep(4000);
	 * newOrderInstance.applytoAllSalesRepOnInsertion(1); Thread.sleep(2000);
	 * Thread.sleep(4000); newOrderInstance.clickOverrunTab();
	 * Thread.sleep(3000); newOrderInstance.clickNewOverrun();
	 * Thread.sleep(2000); OrderNewTearsheetProofPage newTearSheetInstance =
	 * PageFactory.initElements(driver, OrderNewTearsheetProofPage.class);
	 * 
	 * newTearSheetInstance.enterQuantity();
	 * newTearSheetInstance.enterContact(); newTearSheetInstance.clickOnSave();
	 * Thread.sleep(2000); newOrderInstance.
	 * verifyOopsrMessagePopUp("Please enter Company, Address, City, State and Zip Code"
	 * ); Thread.sleep(5000); newTearSheetInstance.enterCompany();
	 * newTearSheetInstance.clickOnSave(); Thread.sleep(2000); newOrderInstance.
	 * verifyOopsrMessagePopUp("Please enter Company, Address, City, State and Zip Code"
	 * ); Thread.sleep(5000); newTearSheetInstance.enterAddress();
	 * newTearSheetInstance.clickOnSave(); Thread.sleep(2000); newOrderInstance.
	 * verifyOopsrMessagePopUp("Please enter Company, Address, City, State and Zip Code"
	 * ); Thread.sleep(5000); newTearSheetInstance.entrCity();
	 * newTearSheetInstance.clickOnSave(); Thread.sleep(2000); newOrderInstance.
	 * verifyOopsrMessagePopUp("Please enter Company, Address, City, State and Zip Code"
	 * ); Thread.sleep(5000); newTearSheetInstance.enterState();
	 * newTearSheetInstance.clickOnSave(); Thread.sleep(2000); newOrderInstance.
	 * verifyOopsrMessagePopUp("Please enter Company, Address, City, State and Zip Code"
	 * ); Thread.sleep(5000); newTearSheetInstance.enterZipCode();
	 * newTearSheetInstance.enterPhoneNumber();
	 * newTearSheetInstance.clickOnSave(); Thread.sleep(2000);
	 * newOrderInstance.submitOrder(); Thread.sleep(1000); String orderID =
	 * orderEntryPageInstance.getOrderNumber();
	 * Logger.info(orderEntryPageInstance.getOrderID());
	 * orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
	 * Thread.sleep(1000);
	 * 
	 * orderEntryPageInstance.clickOnOrder(orderID); Thread.sleep(3000);
	 * 
	 * dashboardPageInstance.clickOnLogout();
	 * 
	 * } catch (Exception e) { Logger.error(e.getMessage()); throw e; } }
	 */
	@Test(groups = { "SwagataMou", "Order", "PrioritizedReg2", "NovMaintenance", "preprintOverrun", "Grp4",
			"RegressionLatest", "Group5", "RegFailed3", "reRunP", "Group5F", "PreprintReg", "NewRegression2",
			"NewRegression", "G5", "RerunF2",
			"preprintOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOverrun(Map<String, String> userData) throws Exception {
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
		//	newOrderInstance.selectBU("1", 57, 0);//swagata
			newOrderInstance.selectBU("1", 10, 0);
			Thread.sleep(4000);
		//newOrderInstance.enterPubDate("1", "13", "Jan", "2020");//swagata
			 newOrderInstance.enterPubDateFromExcel("1",9,27);//swagata
			newOrderInstance.selectProductType("1", 10, 1);//swagata
			newOrderInstance.selectProduct("1", 10, 2);//swagata
			newOrderInstance.selectAdType("1", 10, 3);//swagata
				
			/*newOrderInstance.enterPubDateFromExcel("1", 57, 27);// mou
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 57, 1);
			Thread.sleep(4000);
			
			 * newOrderInstance.selectProduct("1",57, 2); Thread.sleep(4000);
			 * newOrderInstance.selectAdType("1",57, 3); Thread.sleep(3000);
			 */// swagata
			newOrderInstance.viewInsertionDetails("1");//swagata
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");
			/*
			 * newOrderInstance.checkUncheckBillQty(false); Thread.sleep(3000);
			 * newOrderInstance.enterBilledQty(5); Thread.sleep(3000);
			 */// swagata
			newOrderInstance.clickOnDistributions(1);
			//Thread.sleep(18000);//swagata
			 //newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			/*
			 * newOrderInstance.selectTypeInSettingsPreprintOrder("1",
			 * "Preprint_SettingsType_CustSupplied"); Thread.sleep(3000);
			 * newOrderInstance.selectPageType("1", "PP_PaperType_Tabloid");
			 * Thread.sleep(3000); newOrderInstance.enterPageCount("2");
			 * Thread.sleep(4000);
			 */

			newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02514");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.clickOverrunTab();
			Thread.sleep(3000);
			newOrderInstance.clickNewOverrun();
			Thread.sleep(2000);
			OrderNewTearsheetProofPage newTearSheetInstance = PageFactory.initElements(driver,
					OrderNewTearsheetProofPage.class);

			newTearSheetInstance.enterQuantity();
			newTearSheetInstance.enterContact();
			newTearSheetInstance.clickOnSave();
			Thread.sleep(2000);
			newOrderInstance.verifyOopsrMessagePopUp("Please enter Company, Address, City, State and Zip Code");
			Thread.sleep(5000);
			newTearSheetInstance.enterCompany();
			newTearSheetInstance.clickOnSave();
			Thread.sleep(2000);
			newOrderInstance.verifyOopsrMessagePopUp("Please enter Company, Address, City, State and Zip Code");
			Thread.sleep(5000);
			newTearSheetInstance.enterAddress();
			newTearSheetInstance.clickOnSave();
			Thread.sleep(2000);
			newOrderInstance.verifyOopsrMessagePopUp("Please enter Company, Address, City, State and Zip Code");
			Thread.sleep(5000);
			newTearSheetInstance.entrCity();
			newTearSheetInstance.clickOnSave();
			Thread.sleep(2000);
			newOrderInstance.verifyOopsrMessagePopUp("Please enter Company, Address, City, State and Zip Code");
			Thread.sleep(5000);
			newTearSheetInstance.enterState();
			newTearSheetInstance.clickOnSave();
			Thread.sleep(2000);
			newOrderInstance.verifyOopsrMessagePopUp("Please enter Company, Address, City, State and Zip Code");
			Thread.sleep(5000);
			newTearSheetInstance.enterZipCode();
			newTearSheetInstance.enterPhoneNumber();
			newTearSheetInstance.clickOnSave();
			Thread.sleep(2000);
			newOrderInstance.submitOrder();
			// Thread.sleep(6000);// swagata
			// newOrderInstance.clickOnContinuePastPubDate();// swagata
			Thread.sleep(2000);// mou
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);

			dashboardPageInstance.clickOnLogout();//swagata

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {
			"createHTFPreprintOrderNewInsertion" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createHTFPreprintOrderNewInsertion(Map<String, String> userData) throws Exception {
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
			newOrderInstance.enterSoldToCustomer("CU00250481");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 66, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1", 66, 27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 66, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 66, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 66, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(45000);
			newOrderInstance.selectZonePreprintOrder("Full");
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(3000);
			// newOrderInstance.viewInsertionDetails("2");//mou
			// Thread.sleep(3000);
			newOrderInstance.clickRefreshDraw();
			Thread.sleep(5000);
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
			Thread.sleep(5000);// mou
			newOrderInstance.clickOnContinuePastPubDate();// mou
			Thread.sleep(2000);// mou
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(3000);
			newOrderInstance.clickRefreshDraw();
			Thread.sleep(5000);
			newOrderInstance.submitOrder();
			Thread.sleep(5000);
			newOrderInstance.clickOnContinuePastPubDate();// mou
			Thread.sleep(2000);// mou
			String orderID1 = orderEntryPageInstance.getOrderNumber();// mou
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);
			orderEntryPageInstance.clickOnOrder(orderID1); // mou
			Thread.sleep(3000);

			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	// arka
	/*
	 * @Test(groups = {"Order",
	 * "preprintOrderCopySaveClose","RegressionLatest","reRunP","PreprintReg",
	 * "Grp4","Pre1","Group5","RegFailed3","Group5F","NewRegression","G5",
	 * "RerunF2"}, dataProviderClass =
	 * com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider =
	 * "userData") public void preprintOrderCopySaveClose(Map<String, String>
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
	 * Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
	 * Thread.sleep(4000); newOrderInstance.createNewInsertion();
	 * Thread.sleep(4000); newOrderInstance.selectBU("1",43, 0);
	 * Thread.sleep(4000); newOrderInstance.enterPubDateFromExcel("1",43,27);
	 * Thread.sleep(5000); newOrderInstance.selectProductType("1",43, 1);
	 * Thread.sleep(4000); newOrderInstance.selectProduct("1",43, 2);
	 * Thread.sleep(4000); newOrderInstance.selectAdType("1",43, 3);
	 * Thread.sleep(3000); newOrderInstance.viewInsertionDetails("1");
	 * newOrderInstance.addOrEditInsersionVerisonID("1", 1); //
	 * newOrderInstance.selectMaterialSource("1","N/A");
	 * 
	 * newOrderInstance.checkUncheckBillQty(false); Thread.sleep(3000);
	 * newOrderInstance.enterBilledQty(5); Thread.sleep(3000); /*
	 * Thread.sleep(4000); newOrderInstance.clickOnDistributions(1);
	 * Thread.sleep(45000); // newOrderInstance.clickOnSearchZoneLink(); //
	 * Thread.sleep(10000); newOrderInstance.selectZonePreprintOrder("Full"); //
	 * int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
	 * newOrderInstance.confirmZoneSelection(); Thread.sleep(5000);
	 * 
	 * newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.addNewSalesRepOnInsertion(1,
	 * "SA01380");Thread.sleep(4000);newOrderInstance.
	 * clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);
	 * Thread.sleep(4000); newOrderInstance.submitOrder(); Thread.sleep(1000);
	 * String orderID = orderEntryPageInstance.getOrderID();
	 * Logger.info("Order ID: "+orderID);
	 * orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
	 * Thread.sleep(2000); // List<WebElement> list =
	 * driver.findElements(By.xpath("//div[@class='row ng-scope']"));
	 * WebDriverWait wait = new WebDriverWait(driver,20); //
	 * wait.until(ExpectedConditions.visibilityOfAllElements(list));
	 * orderEntryPageInstance.clickOnOrder(orderID);
	 * 
	 * Thread.sleep(6000); Logger.info("START OF COPY ORDER");
	 * 
	 * JavascriptExecutor js = ((JavascriptExecutor) driver); //
	 * js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	 * ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].scrollIntoView();",
	 * driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")));
	 * wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.
	 * xpath(".//*[@id='add-recurrence-pattern']"))));
	 * 
	 * driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click(
	 * ); Thread.sleep(8000); newOrderInstance.viewInsertionDetails("1");
	 * Thread.sleep(3000); newOrderInstance.enterPubDate("1","28", "Nov",
	 * "2019"); Thread.sleep(5000); Thread.sleep(4000);
	 * newOrderInstance.viewInsertionDetails("1");
	 * newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.addNewSalesRepOnInsertion(1,
	 * "SA01380");Thread.sleep(4000);newOrderInstance.
	 * clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
	 * newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);
	 * Thread.sleep(4000); Thread.sleep(3000); newOrderInstance.saveOrder();
	 * 
	 * Thread.sleep(3000);
	 * 
	 * String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
	 * newOrderInstance.saveAndCloseOrder();
	 * orderEntryPageInstance.clickOnOrder(orderNumber);
	 * Logger.info("Saved Order : "+orderNumber); Thread.sleep(1000);
	 * dashboardPageInstance.clickOnLogout(); } catch(Exception e) {
	 * Logger.error(e.getMessage()); throw e; } }
	 */
	@Test(groups = {
			"preprintOrderCopySaveClose" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderCopySaveClose(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectBU("1", 43, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1", 43, 27);// excel sheet
																// change
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 43, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 43, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 43, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			// newOrderInstance.selectMaterialSource("1","N/A");

			newOrderInstance.checkUncheckBillQty(false);
			Thread.sleep(3000);
			newOrderInstance.enterBilledQty(5);
			Thread.sleep(3000);
			/*
			 * Thread.sleep(4000); newOrderInstance.clickOnDistributions(1);
			 * Thread.sleep(45000); // newOrderInstance.clickOnSearchZoneLink();
			 * // Thread.sleep(10000);
			 * newOrderInstance.selectZonePreprintOrder("Full"); // int
			 * countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
			 * newOrderInstance.confirmZoneSelection(); Thread.sleep(5000);
			 */

			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(5000);
			newOrderInstance.clickOnContinuePastPubDate();// mou
			Thread.sleep(2000);// mou
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order ID: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			// List<WebElement> list =
			// driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			// wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderEntryPageInstance.clickOnOrder(orderID);

			Thread.sleep(6000);
			Logger.info("START OF COPY ORDER");

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			// js.executeScript("window.scrollTo(0,
			// -document.body.scrollHeight);");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")));
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();
			Thread.sleep(8000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(3000);
			newOrderInstance.enterPubDate("1", "28", "Nov", "2019");
			Thread.sleep(5000); // Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.clickOnInsertionSalesRepSection(1);// Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1,
																// "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
																// newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
			Thread.sleep(3000);
			newOrderInstance.saveOrder();

			Thread.sleep(3000);

			// String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
			// newOrderInstance.saveAndCloseOrder();
			// orderEntryPageInstance.clickOnOrder(orderNumber);
			// Logger.info("Saved Order : "+orderNumber);
			// Thread.sleep(1000);
			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {
			"htfPreprintCopy" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void htfPreprintCopy(Map<String, String> userData) throws Exception {
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
			newOrderInstance.enterSoldToCustomer("CU00250481");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 66, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1", 66, 27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 66, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 66, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 66, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			/*
			 * newOrderInstance.checkUncheckBillQty(false); Thread.sleep(3000);
			 * newOrderInstance.enterBilledQuantity(59423); Thread.sleep(3000);
			 */
			/*
			 * newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			 * newOrderInstance.clickOnPositionSelector(); Thread.sleep(32000);
			 * 
			 * newOrderInstance.selectFirstPostionFrmPositionSlctr();
			 * Thread.sleep(4000); newOrderInstance.savePositionSelection();
			 * Thread.sleep(10000);
			 */
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(18000);// mou
			// newOrderInstance.clickOnSearchZoneLink();
			// Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			// newOrderInstance.selectPandDCreativeLoc("1", "");
			// Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02433");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(5000);// mou
			newOrderInstance.clickOnContinuePastPubDate();// mou
			Thread.sleep(2000);// mou

			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			Thread.sleep(6000);
			Logger.info("START OF COPY ORDER");

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			// js.executeScript("window.scrollTo(0,
			// -document.body.scrollHeight);");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")));
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();
			Thread.sleep(8000);

			newOrderInstance.clickRefreshDraw();
			Thread.sleep(5000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");// mou
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);// mou
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(5000);// mou
			newOrderInstance.clickOnContinuePastPubDate();// mou
			Thread.sleep(2000);// mou
			String orderid = orderEntryPageInstance.getOrderID();
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();// mou
			Thread.sleep(1000);// mou

			Logger.info("orderid:" + orderid);
			dashboardPageInstance.clickOnLogout();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "verifyChangeVersionKeyboardMode", "Grp4", "RegressionLatest", "Group5", "RegFailed3", "Group5F",
			"PreprintReg", "NewRegression3", "NewRegression", "G5",
			"preprintOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyChangeVersionKeyboardMode(Map<String, String> userData) throws Exception {
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
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 76, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1", 76, 27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 76, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 76, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 76, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1", 76, 4);
			Thread.sleep(6000);
			// newOrderInstance.viewInsertionDetails("1");
			// Thread.sleep(4000);
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			Thread.sleep(3000);
			newOrderInstance.createNewInsertionVersion("1");
			Thread.sleep(3000);
			newOrderInstance.addOrEditInsersionVerisonID("2", 2);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			// insert code to match zip
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(40000);
			newOrderInstance.clickOnMatchZip();
			Thread.sleep(5000);
			newOrderInstance.enterAndIncludeZip("33317");
			Thread.sleep(5000);
			newOrderInstance.verifyZipVersionSelected("33317", "1");
			Thread.sleep(3000);
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(40000);
			newOrderInstance.selectVersionDistribution("2");
			Thread.sleep(3000);
			newOrderInstance.clickOnMatchZip();
			Thread.sleep(5000);
			newOrderInstance.enterAndIncludeZip("33317");
			Thread.sleep(5000);
			newOrderInstance.verifyZipVersionSelected("33317", "2");
			Thread.sleep(3000);

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "SMain", "Order", "preprintOrders", "NovMaintenance", "newVersionProductRefreshPreprintOrder",
			"OrderPreprintTest", "RegressionLatest", "reRunP", "PreprintReg", "Grp4", "Pre1", "Group5", "RegFailed3",
			"PriorityDFP", "Group5F", "NewRegression3", "NewRegression", "G5",
			"RerunF2" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void newVersionProductRefreshPreprintOrder(Map<String, String> userData) throws Exception {
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
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 43, 0);
			Thread.sleep(3000);
			newOrderInstance.enterPubDate("1", "16", "Jan", "2021");
			Thread.sleep(3000);
			newOrderInstance.selectProductType("1", 43, 1);
			Thread.sleep(3000);
			newOrderInstance.selectProduct("1", 43, 2);
			Thread.sleep(3000);
			newOrderInstance.createNewInsertionVersion("1");
			Thread.sleep(3000);
			Logger.info("New Version Product: " + newOrderInstance.getProductOnInsertionNewVersion(1));
			Assert.assertEquals(newOrderInstance.getProductOnInsertion(1),
					newOrderInstance.getProductOnInsertionNewVersion(1));
			Thread.sleep(3000);
			/*
			 * newOrderInstance.enterPubDate("1", "23", "Dec", "2019");
			 * Thread.sleep(5000); Logger.info("New Version Product: " +
			 * newOrderInstance.getProductOnInsertionNewVersion(1));
			 * Assert.assertEquals(newOrderInstance.getProductOnInsertion(1),
			 * newOrderInstance.getProductOnInsertionNewVersion(1));
			 * Thread.sleep(3000);
			 */// swagata
			newOrderInstance.saveOrder();

			Thread.sleep(3000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
			Logger.info("Saved Order : " + orderNumber);// swagata

			/*
			 * newOrderInstance.saveAndCloseOrder();
			 * orderEntryPageInstance.clickOnOrder(orderNumber);
			 * Logger.info("Saved Order : "+orderNumber); Thread.sleep(1000);
			 * dashboardPageInstance.clickOnLogout();
			 */

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order", "verifyInsertionVersionChngPreprintOrder", "OrderPreprintTest", "RegressionLatest",
			"reRunP", "PreprintReg", "Grp4", "Pre1", "Group5", "RegFailed3", "PriorityDFP", "RegFailed3", "reRunP",
			"Group5F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyInsertionVersionChngPreprintOrder(Map<String, String> userData) throws Exception {
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
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 43, 0);
			Thread.sleep(3000);
			newOrderInstance.enterPubDate("1", "21", "Sep", "2019");
			Thread.sleep(3000);
			newOrderInstance.selectProductType("1", 43, 1);
			Thread.sleep(3000);
			newOrderInstance.selectProduct("1", 43, 2);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			// newOrderInstance.selectMaterialSource("1","N/A");
			newOrderInstance.clickOnDistributions(1);
			Thread.sleep(60000);
			// newOrderInstance.clickOnSearchZoneLink();
			Thread.sleep(3000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned =
			// newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();
			Thread.sleep(5000);
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(3000);
			// newOrderInstance.selectPandDCreativeLoc("1",
			// "PP_CreativeLoc_Adwatch");
			// Thread.sleep(3000);
			// newOrderInstance.selectPandDPaperStock("1",
			// "PP_PaperStock_60Coated");
			// Thread.sleep(3000);
			newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess");
			Thread.sleep(3000);
			newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_Tower");
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			// newOrderInstance.addNewSalesRepOnInsertion(2, "SA00443");
			// Thread.sleep(2000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info(orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			// Thread.sleep(3000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(23000);
			// dashboardPageInstance.clickOnLogout();
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.addOrEditInsersionVerisonID("1", 2);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			newOrderInstance.displayWarningMessageVerifyConfirm(
					"Version has changed without reassigning Material Id for 01-00Would you want to continue?");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {
			"createCommercialPrintOrderWithoutVersion" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createCommercialPrintOrderWithoutVersion(Map<String, String> userData) throws Exception {
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
			orderEntryPageInstance.clickOnNewInsertionOrderBtn();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_HTF");
			newOrderInstance.enterSoldToCustomer("CU00250481");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 61, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "21", "Dec", "2019");
			Thread.sleep(4000);
			newOrderInstance.selectProductTypeByIndex("1", 9);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_CommPrint");

			Thread.sleep(3000);
			newOrderInstance.checkUncheckBillQty(false);
			Thread.sleep(3000);
			newOrderInstance.enterBilledQty(5);
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02433");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			newOrderInstance.displayErrorMessage();
			newOrderInstance.compareErrorMessage("Version is required for insertion 01-00");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
