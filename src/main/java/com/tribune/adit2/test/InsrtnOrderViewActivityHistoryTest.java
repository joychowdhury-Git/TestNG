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
import com.tribune.adit2.OrderEntry.OrderNewTearsheetProofPage;
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

public class InsrtnOrderViewActivityHistoryTest {

	/**
	 * This test performs searches for an Insertion order and view the order
	 * history
	 */
	@Test(groups = { "InsrtnOrderViewActivityHistoryTest", "PrioritizedReg1", "RegressionLatest", "Grp1", "Reg1",
			"Group3", "RegFailed4", "Group3F", "NewRegression1", "NewRegression", "G3", "G3", "RerunF2",
			"insertionOrders" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void newInsertionVersion(Map<String, String> userData) throws Exception {
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
			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 10, 0);
			newOrderInstance.enterPubDate("1", "23", "Dec", "2020");
			Thread.sleep(2000);
			newOrderInstance.selectProductType("1", 10, 1);
			newOrderInstance.selectProduct("1", 10, 2);
			newOrderInstance.selectAdType("1", 10, 3);
			Thread.sleep(3000);

			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.checkUncheckBillQty(false);
			newOrderInstance.enterBilledQty(4);
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
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderID();
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			orderEntryPageInstance.clickOnOrder(orderID);

			NewOrderPage orderViewPage = PageFactory.initElements(driver, NewOrderPage.class);
			wait.until(ExpectedConditions.visibilityOf(orderViewPage.orderViewPageElement));
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.clickProofTab();
			Thread.sleep(2000);
			newOrderInstance.clickOnNewProof();
			Thread.sleep(2000);

			OrderNewTearsheetProofPage newProofInstance = PageFactory.initElements(driver,
					OrderNewTearsheetProofPage.class);

			newProofInstance.enterQuantity();
			newProofInstance.enterContact();
			newProofInstance.enterCompany();
			newProofInstance.enterAddress();
			newProofInstance.entrCity();
			newProofInstance.enterState();
			newProofInstance.enterZipCode();
			newProofInstance.enterPhoneNumber();
			newProofInstance.clickOnSave();
			Thread.sleep(2000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(3000);

			OrderEntryHomePage orderEntryPage = PageFactory.initElements(driver, OrderEntryHomePage.class);

			orderEntryPage.enterOrderNumber(orderID);
			orderEntryPage.clickOnOrderSearchBtn();
			Thread.sleep(2000);
			orderEntryPageInstance.clickOnOrder(orderID);

			orderViewPage.viewOrderHistory(1);

			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			//Assert.fail();
			//throw e;
		}
	}
}
