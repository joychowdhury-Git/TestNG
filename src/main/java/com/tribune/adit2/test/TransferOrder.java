package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

import junit.framework.Assert;

public class TransferOrder {
	@Test(groups = {
			"TransferOrderValidation" ,"transferOrder","Transfer","Transfer_TC01","NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void TransferOrderValidation(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			NewOrderPage newOrderPageInstance = PageFactory.initElements(driver, NewOrderPage.class);

			dashboardPageInstance.clickOnOrderEntrySearchModule();
			Logger.info("Order entry tab clicked");
			Thread.sleep(4000);

			OrderEntryHomePage orderEntryHomePageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			String orderNum = newOrderPageInstance.getOrderFromTransferExcel(1, 1);//swagata
			Logger.info("Order number" + orderNum);
			String businessUnit = newOrderPageInstance.getOrderFromTransferExcel(1, 2);
			Logger.info("BU number" + businessUnit);
			String customer = newOrderPageInstance.getOrderFromTransferExcel(1, 3);
			Logger.info("CU number" + customer);

			/*
			 * orderEntryHomePageInstance.enterOrderNumber(orderNum);
			 * 
			 * orderEntryHomePageInstance.clickOnOrderSearchBtn();
			 * Logger.info("Search button clicked"); Thread.sleep(4000);
			 */

			orderEntryHomePageInstance.clickOnOrder(orderNum);
			Logger.info("Order id clicked");
			Thread.sleep(4000);

			orderEntryHomePageInstance.clickOnInvoiceTransfer();
			Logger.info("Transfer button clicked");
			Thread.sleep(4000);

			newOrderPageInstance.selectSoldToCustomerBU(businessUnit);
			newOrderPageInstance.enterSoldToCustomer(customer);
			Logger.info("Sold to customer clicked");
			Thread.sleep(4000);

			newOrderPageInstance.selectBilltoSameAsSoldTo();//swagata
			Thread.sleep(6000);

			/*newOrderPageInstance.selectBillToCustomerBU(businessUnit);
			newOrderPageInstance.enterBillToCustomer(customer);
			Logger.info("Bill to customer clicked");
			Thread.sleep(4000);*///swagata

			//newOrderPageInstance.submitOrderWithoutSave();//swagata
			newOrderPageInstance.ClickSubmitButton();//joy
			Thread.sleep(4000);

			//newOrderPageInstance.clickOnContinuePastPubDate();
			//Logger.info("ContinuePastPubDate button clicked clicked");
			//Thread.sleep(4000);

			dashboardPageInstance.clickOnOrderEntrySearchModule();
			Logger.info("Order entry tab clicked");

			orderEntryHomePageInstance.enterOrderNumber(orderNum);

			orderEntryHomePageInstance.clickOnOrderSearchBtn();
			Logger.info("Search button clicked");
			Thread.sleep(4000);

			orderEntryHomePageInstance.clickOnOrder(orderNum);
			Logger.info("Order id clicked");
			Thread.sleep(4000);

			newOrderPageInstance.verifyTransferredOrderPrice("$0.00");
			Logger.info("Transfer successful");
			//dashboardPageInstance.clickOnLogout();//swagata


		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	

	@Test(groups = {
			"PreprintTransferOrderValidation","transferOrder","Transfer","Transfer_TC02" ,"NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void PreprintTransferOrderValidation(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			NewOrderPage newOrderPageInstance = PageFactory.initElements(driver, NewOrderPage.class);

			dashboardPageInstance.clickOnOrderEntrySearchModule();
			Logger.info("Order entry tab clicked");
			Thread.sleep(4000);

			OrderEntryHomePage orderEntryHomePageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			String orderNum = newOrderPageInstance.getOrderFromTransferExcel(2, 1);//swagata
			Logger.info("Order number" + orderNum);
			String businessUnit = newOrderPageInstance.getOrderFromTransferExcel(2, 2);
			Logger.info("BU number" + businessUnit);
			String customer = newOrderPageInstance.getOrderFromTransferExcel(2, 3);
			Logger.info("CU number" + customer);

			/*
			 * orderEntryHomePageInstance.enterOrderNumber(orderNum);
			 * 
			 * orderEntryHomePageInstance.clickOnOrderSearchBtn();
			 * Logger.info("Search button clicked"); Thread.sleep(4000);
			 */

			orderEntryHomePageInstance.clickOnOrder(orderNum);
			Logger.info("Order id clicked");
			Thread.sleep(4000);

			orderEntryHomePageInstance.clickOnInvoiceTransfer();
			Logger.info("Transfer button clicked");
			Thread.sleep(4000);

			newOrderPageInstance.selectSoldToCustomerBU(businessUnit);
			newOrderPageInstance.enterSoldToCustomer(customer);
			Logger.info("Sold to customer clicked");
			Thread.sleep(4000);
			newOrderPageInstance.selectBilltoSameAsSoldTo();//swagata
			Thread.sleep(8000);
			/*newOrderPageInstance.selectBillToCustomerBU(businessUnit);
			newOrderPageInstance.enterBillToCustomer(customer);
			Logger.info("Bill to customer clicked");
			Thread.sleep(4000);*///swagata

			newOrderPageInstance.submitOrderWithoutSave();//swagata
			Logger.info("Submit button clicked");
			Thread.sleep(4000);

			newOrderPageInstance.clickOnContinuePastPubDate();
			Logger.info("ContinuePastPubDate button clicked clicked");
			Thread.sleep(4000);

			dashboardPageInstance.clickOnOrderEntrySearchModule();
			Logger.info("Order entry tab clicked");

			orderEntryHomePageInstance.enterOrderNumber(orderNum);

			orderEntryHomePageInstance.clickOnOrderSearchBtn();
			Logger.info("Search button clicked");
			Thread.sleep(4000);

			orderEntryHomePageInstance.clickOnOrder(orderNum);
			Logger.info("Order id clicked");
			Thread.sleep(4000);

			newOrderPageInstance.verifyTransferredOrderPrice("$0.00");
			Logger.info("Transfer successful");
			dashboardPageInstance.clickOnLogout();//swagata


		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {
			"ClassifiedTransferOrderValidation","transferOrder","Transfer_TC03","PrioritizedReg3" ,"NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ClassifiedTransferOrderValidation(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			NewOrderPage newOrderPageInstance = PageFactory.initElements(driver, NewOrderPage.class);

			dashboardPageInstance.clickOnOrderEntrySearchModule();
			Logger.info("Order entry tab clicked");
			Thread.sleep(8000);

			OrderEntryHomePage orderEntryHomePageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			String orderNum = newOrderPageInstance.getOrderFromTransferExcel(3, 1);//swagata
			Logger.info("Order number" + orderNum);
			String businessUnit = newOrderPageInstance.getOrderFromTransferExcel(3, 2);
			Logger.info("BU number" + businessUnit);
			String customer = newOrderPageInstance.getOrderFromTransferExcel(3, 3);
			Logger.info("CU number" + customer);

			/*
			 * orderEntryHomePageInstance.enterOrderNumber(orderNum);
			 * 
			 * orderEntryHomePageInstance.clickOnOrderSearchBtn();
			 * Logger.info("Search button clicked"); Thread.sleep(4000);
			 */

			orderEntryHomePageInstance.clickOnOrder(orderNum);
			Logger.info("Order id clicked");
			Thread.sleep(4000);

			orderEntryHomePageInstance.clickOnInvoiceTransfer();
			Logger.info("Transfer button clicked");
			Thread.sleep(4000);

			newOrderPageInstance.selectSoldToCustomerBU(businessUnit);
			newOrderPageInstance.enterSoldToCustomer(customer);
			Logger.info("Sold to customer clicked");
			Thread.sleep(4000);
			newOrderPageInstance.selectBilltoSameAsSoldTo();//swagata

			/*newOrderPageInstance.selectBillToCustomerBU(businessUnit);
			newOrderPageInstance.enterBillToCustomer(customer);
			Logger.info("Bill to customer clicked");
			Thread.sleep(4000);*///swagata

			newOrderPageInstance.submitOrderWithoutSave();//swagata
			Logger.info("Submit button clicked clicked");
			Thread.sleep(4000);

			newOrderPageInstance.clickOnContinuePastPubDate();
			Logger.info("ContinuePastPubDate button clicked clicked");
			Thread.sleep(4000);

			dashboardPageInstance.clickOnOrderEntrySearchModule();
			Logger.info("Order entry tab clicked");

			orderEntryHomePageInstance.enterOrderNumber(orderNum);

			orderEntryHomePageInstance.clickOnOrderSearchBtn();
			Logger.info("Search button clicked");
			Thread.sleep(4000);

			orderEntryHomePageInstance.clickOnOrder(orderNum);
			Logger.info("Order id clicked");
			Thread.sleep(4000);

			newOrderPageInstance.verifyTransferredOrderPrice("$0.00");
			Logger.info("Transfer successful");
			dashboardPageInstance.clickOnLogout();//swagata


		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {
			"DPRDisplayTransferOrderValidation","transferOrder","Transfer","Transfer_TC04","NewRegression3","NewRegression" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void DPRDisplayTransferOrderValidation(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			NewOrderPage newOrderPageInstance = PageFactory.initElements(driver, NewOrderPage.class);

			dashboardPageInstance.clickOnOrderEntrySearchModule();
			Logger.info("Order entry tab clicked");
			Thread.sleep(4000);

			OrderEntryHomePage orderEntryHomePageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			String orderNum = newOrderPageInstance.getOrderFromTransferExcel(4, 1);//swagata
			Logger.info("Order number" + orderNum);
			String businessUnit = newOrderPageInstance.getOrderFromTransferExcel(4, 2);
			Logger.info("BU number" + businessUnit);
			String customer = newOrderPageInstance.getOrderFromTransferExcel(4, 3);
			Logger.info("CU number" + customer);

			/*
			 * orderEntryHomePageInstance.enterOrderNumber(orderNum);
			 * 
			 * orderEntryHomePageInstance.clickOnOrderSearchBtn();
			 * Logger.info("Search button clicked"); Thread.sleep(4000);
			 */

			orderEntryHomePageInstance.clickOnOrder(orderNum);
			Logger.info("Order id clicked");
			Thread.sleep(4000);

			orderEntryHomePageInstance.clickOnInvoiceTransfer();
			Logger.info("Transfer button clicked");
			Thread.sleep(4000);

			newOrderPageInstance.selectSoldToCustomerBU(businessUnit);
			newOrderPageInstance.enterSoldToCustomer(customer);
			Logger.info("Sold to customer clicked");
			Thread.sleep(4000);

			newOrderPageInstance.selectBilltoSameAsSoldTo();//swagata

			/*newOrderPageInstance.selectBillToCustomerBU(businessUnit);
			newOrderPageInstance.enterBillToCustomer(customer);
			Logger.info("Bill to customer clicked");
			Thread.sleep(4000);*///swagata
			Thread.sleep(6000);
			newOrderPageInstance.submitOrderWithoutSave();//swagata
			Logger.info("Submit button clicked clicked");
			Thread.sleep(4000);

			newOrderPageInstance.clickOnContinuePastPubDate();
			Logger.info("ContinuePastPubDate button clicked clicked");
			Thread.sleep(4000);

			dashboardPageInstance.clickOnOrderEntrySearchModule();
			Logger.info("Order entry tab clicked");

			orderEntryHomePageInstance.enterOrderNumber(orderNum);

			orderEntryHomePageInstance.clickOnOrderSearchBtn();
			Logger.info("Search button clicked");
			Thread.sleep(4000);

			orderEntryHomePageInstance.clickOnOrder(orderNum);
			Logger.info("Order id clicked");
			Thread.sleep(4000);

			newOrderPageInstance.verifyTransferredOrderPrice("$0.00");
			Logger.info("Transfer successful");
			dashboardPageInstance.clickOnLogout();//swagata

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	

	@Test(groups = {
			"TBSDisplayTransferOrderValidation","transferOrder","Transfer","Transfer_TC05","NewRegression3","NewRegression" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void TBSDisplayTransferOrderValidation(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			NewOrderPage newOrderPageInstance = PageFactory.initElements(driver, NewOrderPage.class);

			dashboardPageInstance.clickOnOrderEntrySearchModule();
			Logger.info("Order entry tab clicked");
			Thread.sleep(4000);

			OrderEntryHomePage orderEntryHomePageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			String orderNum = newOrderPageInstance.getOrderFromTransferExcel(5, 1);//swagata
			Logger.info("Order number" + orderNum);
			String businessUnit = newOrderPageInstance.getOrderFromTransferExcel(5, 2);
			Logger.info("BU number" + businessUnit);
			String customer = newOrderPageInstance.getOrderFromTransferExcel(5, 3);
			Logger.info("CU number" + customer);

			/*
			 * orderEntryHomePageInstance.enterOrderNumber(orderNum);
			 * 
			 * orderEntryHomePageInstance.clickOnOrderSearchBtn();
			 * Logger.info("Search button clicked"); Thread.sleep(4000);
			 */

			orderEntryHomePageInstance.clickOnOrder(orderNum);
			Logger.info("Order id clicked");
			Thread.sleep(4000);

			orderEntryHomePageInstance.clickOnInvoiceTransfer();
			Logger.info("Transfer button clicked");
			Thread.sleep(4000);

			newOrderPageInstance.selectSoldToCustomerBU(businessUnit);
			newOrderPageInstance.enterSoldToCustomer(customer);
			Logger.info("Sold to customer clicked");
			Thread.sleep(4000);
			newOrderPageInstance.selectBilltoSameAsSoldTo();//swagata

			/*newOrderPageInstance.selectBillToCustomerBU(businessUnit);
			newOrderPageInstance.enterBillToCustomer(customer);
			Logger.info("Bill to customer clicked");
			Thread.sleep(4000);*///swagata
			Thread.sleep(6000);
			newOrderPageInstance.submitOrderWithoutSave();//swagata
			Logger.info("Submit button clicked clicked");
			Thread.sleep(4000);

			newOrderPageInstance.clickOnContinuePastPubDate();
			Logger.info("ContinuePastPubDate button clicked clicked");
			Thread.sleep(4000);

			dashboardPageInstance.clickOnOrderEntrySearchModule();
			Logger.info("Order entry tab clicked");

			orderEntryHomePageInstance.enterOrderNumber(orderNum);

			orderEntryHomePageInstance.clickOnOrderSearchBtn();
			Logger.info("Search button clicked");
			Thread.sleep(4000);

			orderEntryHomePageInstance.clickOnOrder(orderNum);
			Logger.info("Order id clicked");
			Thread.sleep(4000);

			newOrderPageInstance.verifyTransferredOrderPrice("$0.00");
			Logger.info("Transfer successful");
			dashboardPageInstance.clickOnLogout();//swagata

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

}
