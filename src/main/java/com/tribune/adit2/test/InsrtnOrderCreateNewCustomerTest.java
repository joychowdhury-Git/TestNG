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

import com.tribune.adit2.Customers.CustomerCreatePage;
import com.tribune.adit2.Customers.CustomerPage;
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
 * 
 * @author Priyanka Goud CR
 * @since January 2016
 */

public class InsrtnOrderCreateNewCustomerTest {
	/**
	 * This test will create a new Insertion order for display product type with
	 * a new customer
	 */
	@Test(groups = { "SMaintenance", "InsertionOrder2", "createNewOrderWithNewCustomer", "PrioritizedReg1",
			"RegressionLatest", "Grp1", "Reg1", "Group3", "RegressionLatest1", "Group3F", "TestPriority", "NANT",
			"NewRegression1", "G3", "RerunF2",
			"insertionOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void createNewOrderWithNewCustomer(Map<String, String> userData) throws Exception {
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
			newOrderInstance.clickOnNewCustomerInsertion();
			String customerName = newOrderInstance.enterCustomerInfo("CustomerInfo");
			newOrderInstance.selectOrderType("OrderType_Standard");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "23", "Dec", "2021");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 17, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 17, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 17, 3);
			Thread.sleep(4000);
			newOrderInstance.selectSection("1", 17, 4);
			Thread.sleep(4000);
			//newOrderInstance.viewInsertionDetails("1");
			//Thread.sleep(4000);
			//newOrderInstance.selectAdSize(1, "1/9  (2 x 7)");
			//Thread.sleep(4000);
			// newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			// newOrderInstance.clickOnPositionSelector();
			// Thread.sleep(32000);

			// newOrderInstance.selectFirstPostionFrmPositionSlctr();
			// Thread.sleep(4000);
			// newOrderInstance.savePositionSelection();
			// Thread.sleep(10000);
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);// mousumi
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA00494");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);// mousumi
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);// mousumi
			//Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitReservation();
			Thread.sleep(4000);
			if (newOrderInstance.confirmButton.isDisplayed()) { //joy
				newOrderInstance.confirmButton.click(); //joy
			} //joy
			Thread.sleep(4000);
			
			newOrderInstance.clickNoLegacyAutoInsertionCreation(); //joy
			Thread.sleep(2000);
			String orderID = orderEntryPageInstance.getOrderID();

			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(3000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(5000);
			NewOrderPage orderViewPage = PageFactory.initElements(driver, NewOrderPage.class);
			// wait.until(ExpectedConditions.visibilityOf(orderViewPage.orderViewPageElement));
			orderViewPage.convertInsertion();
			Thread.sleep(2000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);

			newOrderInstance.displayErrorMessageMultiple(1);
			newOrderInstance.displayErrorMessageMultiple(2);
			newOrderInstance.displayErrorMessageMultiple(3);
			newOrderInstance.compareErrorMessageMultiple(
					"Can't submit order with a prospect customer. Replace Sold To Customer with an actual customer", 1);
			newOrderInstance.compareErrorMessageMultiple(
					"Can't submit order with a prospect customer. Please convert Prospect Customer to Advertiser from Customer Admin",
					2);
			newOrderInstance.compareErrorMessageMultiple(
					"Can't submit order with a prospect customer. Replace Billed To Customer with an actual customer",
					3);
			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "SMaintenance", "InsertionOrder2", "searchEditNewCustomerNewIO", "PrioritizedReg1",
			"RegressionLatest", "Grp1", "Reg1", "Group3", "RegressionLatest1", "Group3F", "TestPriority",
			"NewRegression1", "NewRegression", "G3",
			"insertionOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void searchEditNewCustomerNewIO(Map<String, String> userData) throws Exception {
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
			newOrderInstance.clickOnNewCustomerInsertion();
			String customerName = newOrderInstance.enterCustomerInfo("CustomerInfo");
			newOrderInstance.selectOrderType("OrderType_Standard");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "25", "Dec", "2021");
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
			newOrderInstance.selectAdSize(1, "1/9  (2 x 7)");
			Thread.sleep(4000);
			// newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			// newOrderInstance.clickOnPositionSelector();
			// Thread.sleep(32000);

			// newOrderInstance.selectFirstPostionFrmPositionSlctr();
			// Thread.sleep(4000);
			// newOrderInstance.savePositionSelection();
			// Thread.sleep(10000);
			//newOrderInstance.clickOnInsertionSalesRepSection(1);
			
			newOrderInstance.clickOnsalesrrepInInserionLine(1);
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("034107");
			Thread.sleep(4000);
			newOrderInstance.submitReservation();
			Thread.sleep(7000);
		//	if (newOrderInstance.confirmButton.isDisplayed()) {
				newOrderInstance.confirmButton.click();
		//	}
			Thread.sleep(2000);
			
			newOrderInstance.clickNoLegacyAutoInsertionCreation();
			Thread.sleep(3000);
			String orderID = orderEntryPageInstance.getOrderID();

			Logger.info("Order ID: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(3000);
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage customerSearchPage = PageFactory.initElements(driver, CustomerPage.class);
			customerSearchPage.inputCustomerName(customerName);
			customerSearchPage.clickOnCustomersSearchBtn();
			Thread.sleep(5000);
			// Verifying if the correct customer results are searched
			WebElement customerNameResults = driver.findElement(By.linkText(customerName));
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOf(customerNameResults));

			String numberOfResults = customerSearchPage.getCountOfCustomerSearchResults();
			Logger.info("count of the total results found : " + numberOfResults);
			customerNameResults.click();
			Thread.sleep(7000);
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			customerCreate.clickOnCustomerEditBtn();
			Thread.sleep(3000);
			String customerName1 = customerCreate.getCustomerName();
			Logger.info("Customer Name in Order: " + customerName);
			Logger.info("Customer Name in CustomerSearch: " + customerName1);
			Assert.assertEquals(customerName1, customerName);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
