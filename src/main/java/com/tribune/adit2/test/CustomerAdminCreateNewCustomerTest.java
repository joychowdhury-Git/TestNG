package com.tribune.adit2.test;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.tribune.adit2.Customers.CustomerCreatePage;
import com.tribune.adit2.Customers.CustomerPage;
import com.tribune.adit2.Customers.CustomerProfilePage;
import com.tribune.adit2.Customers.EditCustomerPage;
import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

import junit.framework.Assert;

public class CustomerAdminCreateNewCustomerTest {

	@Test(groups = { "createNewCustomer", "SanityTestNew", "PrdSanityNew",
			"CustRegression", "ProductionTest", "Reg1", "PriorityVulnerability", "ProductionTestPriority",
			"TestPriority", "ProductionTestCI", "ProdTestCI", "Patch14", "NANT",
			"ProductionTestLock" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData", invocationCount = 1)
	public void createNewCustomer(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);
			Thread.sleep(50000);
			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.loginWithProperty("success");
			Thread.sleep(3000);
			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
			TribuneUtils utils = new TribuneUtils();
			viewCustomer.clickOnNewCustomerBtn();
			Thread.sleep(3000);
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			String str = utils.generateRandomString(15);
			customerCreate.enterCustomerName(str + " Auto");
			customerCreate.selectBillingType("Value");
			//customerCreate.selectBU("CTC-CTMG");
			customerCreate.selectBU("NDN-New York Daily News");
			customerCreate.enteralternativeNameTextBox("sdtsmoketest");
			customerCreate.selectAccountType("Advertiser");
			customerCreate.selectCategory("Retail");
			customerCreate.selectSubCategory("Internet Sites ");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			customerCreate.enterTermsEmail("smoketest@tronc.com");
			Thread.sleep(3000);
			customerCreate.tearsheetCheckBoxPresenceValidation();
			customerCreate.taxExemptCheckBoxaPresencValidation();
			customerCreate.isOrderConfirmationRequiredCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxPresenceValidation();
			customerCreate.applySpoilageCheckBoxPresenceValidation();
			customerCreate.supplementalDataSectionPresenceValidation();
			customerCreate.companyRevenueTextBoxPresenceValidation();
			customerCreate.numOfEmployeeTextBox();
			customerCreate.numOflocationsTextBox();
			customerCreate.dunsNumTextBox();
			customerCreate.infoUsaNumTextBox();
			customerCreate.checkDefaultProofValue();
			customerCreate.isPORequiredCheckBoxPresenceValidation();
			customerCreate.IsSelfServiceLocAllowedCheckBoxPresenceValidation();
			customerCreate.notesTextBox();
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("tes123@tronc.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			Thread.sleep(5000);
			// customerCreate.clickOnbusinessUnitMappingSection();
			// Thread.sleep(5000);
			// customerCreate.selectCustomerGroup("Orlando Sentinel", "Default -
			// Internet Sites");
			// Thread.sleep(2000);
			// customerCreate.clickOnFinanceSection();
			// Thread.sleep(4000);
			// customerCreate.clickOnCreditSection();
			// Thread.sleep(4000);
			// customerCreate.selectRiskCode("ACCOM");
			// Thread.sleep(4000);
			// customerCreate.clickOnCreditStatusSaveBtn();
			// Thread.sleep(8000);
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(6000);
			/*
			 * customerCreate.verifyaddressContactNameTextBox(str+" Auto");
			 * customerCreate.verifyaddressline1TextBox("435 N Michigan Ave");
			 * customerCreate.verifyaddresscityTextBox("Chicago");
			 * customerCreate.verifyaddressemailTextBox("tes123@tronc.com");
			 * customerCreate.verifyaddressphone("3124444444");
			 */
			customerCreate.clickOnNextBtn();
			Thread.sleep(70000);
			// customerCreate.verifyDeclineReasonNoMatch();

			// customerCreate.selectCustomerDeails("SmokeTest Automation");
			customerCreate.clickOnselectBtn();
			Thread.sleep(50000);

			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);
			profileCustomer.getCustomerID();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber());

			Assert.assertEquals(str + " Auto", profileCustomer.getCustomerName());
			/*
			 * String mdmID = profileCustomer.getCustomerMDMNumber(); boolean
			 * flag = true; if(mdmID.equals(null) || mdmID.equals("")) {
			 * Logger.info("MDM ID not generated"); flag = false; }
			 * Assert.assertEquals(true, flag);
			 * 
			 * customerCreate.clickOnNewOrderBtn(); OrderEntryHomePage
			 * orderEntryPageInstance = PageFactory.initElements(driver,
			 * OrderEntryHomePage.class); NewOrderPage newOrderInstance =
			 * PageFactory.initElements(driver, NewOrderPage.class);
			 * newOrderInstance.selectBilltoSameAsSoldTo();
			 * newOrderInstance.selectOrderType("OrderType_Standard");
			 * newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill"
			 * ); Thread.sleep(4000);
			 * newOrderInstance.checkUncheckOwnLocalOptOut(true);
			 * Thread.sleep(4000); newOrderInstance.createNewInsertion();
			 * Thread.sleep(4000); newOrderInstance.selectBU("1",18, 0);
			 * Thread.sleep(4000);
			 * newOrderInstance.enterPubDateFromExcel("1",18,27);
			 * Thread.sleep(5000); newOrderInstance.selectProductType("1",18,
			 * 1); Thread.sleep(4000); newOrderInstance.selectProduct("1",18,
			 * 2); Thread.sleep(4000); newOrderInstance.selectAdType("1",18, 3);
			 * Thread.sleep(5000); newOrderInstance.selectSection("1",18, 4);
			 * Thread.sleep(6000); newOrderInstance.viewInsertionDetails("1");
			 * Thread.sleep(4000); // newOrderInstance.selectAdSize(1,
			 * "1/4V  (3 x 10.5)"); // Thread.sleep(4000);
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * //newOrderInstance.removeSalesRepOnInsertion(1);
			 * Thread.sleep(4000); newOrderInstance.addNewSalesRepOnInsertion(1,
			 * "SA00494"); Thread.sleep(4000);
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * Thread.sleep(4000);
			 * newOrderInstance.applytoAllSalesRepOnInsertion(1);
			 * Thread.sleep(2000); Thread.sleep(4000);
			 * newOrderInstance.addServiceRep("019167"); Thread.sleep(4000);
			 * newOrderInstance.submitOrder(); Thread.sleep(1000); String
			 * orderID = orderEntryPageInstance.getOrderNumber();
			 * Logger.info(orderEntryPageInstance.getOrderID());
			 * orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			 * Thread.sleep(1000);
			 */
			dashboardPageInstance.clickOnLogout();//swagata
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "createDuplicateCustomer", "CustRegression", "RegressionLatest", "Grp1", "Reg1", "Group3",
			"PriorityDFP", "RegFailed4",
			"Group3F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createDuplicateCustomer(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
			TribuneUtils utils = new TribuneUtils();
			viewCustomer.clickOnNewCustomerBtn();
			Thread.sleep(3000);
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			String str = utils.generateRandomString(15);
			customerCreate.enterCustomerName(str + " Auto");
			customerCreate.selectBillingType("Value");
			customerCreate.selectBU("CTC-CTMG");
			customerCreate.enteralternativeNameTextBox("altsmoketest");
			customerCreate.selectAccountType("Advertiser");
			customerCreate.selectCategory("Retail");
			customerCreate.selectSubCategory("Internet Sites ");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			customerCreate.enterTermsEmail("smoketest@tronc.com");
			Thread.sleep(3000);
			customerCreate.tearsheetCheckBoxPresenceValidation();
			customerCreate.taxExemptCheckBoxaPresencValidation();
			customerCreate.isOrderConfirmationRequiredCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxPresenceValidation();
			customerCreate.applySpoilageCheckBoxPresenceValidation();
			customerCreate.supplementalDataSectionPresenceValidation();
			customerCreate.companyRevenueTextBoxPresenceValidation();
			customerCreate.numOfEmployeeTextBox();
			customerCreate.numOflocationsTextBox();
			customerCreate.dunsNumTextBox();
			customerCreate.infoUsaNumTextBox();
			customerCreate.checkDefaultProofValue();
			customerCreate.isPORequiredCheckBoxPresenceValidation();
			customerCreate.IsSelfServiceLocAllowedCheckBoxPresenceValidation();
			customerCreate.notesTextBox();
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("smoke1@test.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			// Thread.sleep(3000);
			// customerCreate.clickOnbusinessUnitMappingSection();
			// customerCreate.selectCustomerGroup("Orlando Sentinel", "Default -
			// Internet Sites");
			Thread.sleep(2000);
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(8000);
			customerCreate.verifyaddressContactNameTextBox(str + " Auto");
			customerCreate.verifyaddressline1TextBox("435 N Michigan Ave");
			customerCreate.verifyaddresscityTextBox("Chicago");
			customerCreate.verifyaddressemailTextBox("smoke1@test.com");
			customerCreate.verifyaddressphone("3124444444");
			customerCreate.clickOnNextBtn();
			Thread.sleep(30000);
			customerCreate.verifyDeclineReasonNoMatch();
			// customerCreate.selectCustomerDeails("SmokeTest Automation");
			customerCreate.clickOnselectBtn();
			Thread.sleep(60000);

			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);
			String customer1 = profileCustomer.getCustomerCUNumber();
			String mdm1 = profileCustomer.getCustomerMDMNumber();
			profileCustomer.getCustomerID();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber() + " and MDM ID : "
					+ profileCustomer.getCustomerMDMNumber());
			dashboardPageInstance.clickOnCustomerModule();
			viewCustomer.clickOnNewCustomerBtn();
			customerCreate.enterCustomerName(str + " Auto");
			customerCreate.selectBillingType("Value");
			customerCreate.selectBU("Orlando Sentinel");
			customerCreate.enteralternativeNameTextBox("altsmoketest");
			customerCreate.selectAccountType("Advertiser");
			customerCreate.selectCategory("Retail");
			customerCreate.selectSubCategory("Internet Sites ");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			customerCreate.enterTermsEmail("smoketest@tronc.com");
			Thread.sleep(3000);
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("smoke1@test.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			Thread.sleep(3000);
			customerCreate.clickOnbusinessUnitMappingSection();
			Thread.sleep(3000);
			customerCreate.selectCustomerGroup("Orlando Sentinel", "Default - Internet Sites");
			Thread.sleep(2000);
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(3000);
			customerCreate.verifyaddressContactNameTextBox(str + " Auto");
			customerCreate.verifyaddressline1TextBox("435 N Michigan Ave");
			customerCreate.verifyaddresscityTextBox("Chicago");
			customerCreate.verifyaddressemailTextBox("smoke1@test.com");
			customerCreate.verifyaddressphone("3124444444");
			customerCreate.clickOnNextBtn();
			Thread.sleep(80000);
			customerCreate.verifyDeclineReasonNoMatch();
			customerCreate.clickOnselectBtn();
			// customerCreate.selectCustomerDeails(str+" Auto");
			// customerCreate.clickOnselectBtn();
			Thread.sleep(60000);
			String customer2 = profileCustomer.getCustomerCUNumber();
			String mdm2 = profileCustomer.getCustomerMDMNumber();
			// CustomerProfilePage profileCustomer =
			// PageFactory.initElements(driver, CustomerProfilePage.class);
			profileCustomer.getCustomerID();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber() + " and MDM ID : "
					+ profileCustomer.getCustomerMDMNumber());
			Assert.assertFalse(customer1.equalsIgnoreCase(customer2));
			Logger.info("Two customer ID created are different as expected");
			// Assert.assertEquals(mdm1, mdm2);
			// Logger.info("Two customer created with same MDM ID as expected");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "createNewProspectCustomerConvert", "CustRegression", "RegressionLatest", "Reg1", "Group3",
			"PriorityVulnerability",
			"NANT" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewProspectCustomerConvert(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
			TribuneUtils utils = new TribuneUtils();
			viewCustomer.clickOnNewCustomerBtn();
			Thread.sleep(3000);
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			String str = utils.generateRandomString(15);
			customerCreate.enterCustomerName(str + " Auto");
			customerCreate.selectBillingType("PrivateParty");
			customerCreate.selectBU("CTC-CTMG");
			customerCreate.enteralternativeNameTextBox("altsmoketest");
			customerCreate.selectAccountType("Prospect");
			// customerCreate.selectCategory("Retail");
			// customerCreate.selectSubCategory("Internet Sites ");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			customerCreate.enterTermsEmail1("smoketest@tronc.com");
			Thread.sleep(3000);
			customerCreate.tearsheetCheckBoxPresenceValidation();
			customerCreate.taxExemptCheckBoxaPresencValidation();
			customerCreate.isOrderConfirmationRequiredCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxPresenceValidation();
			customerCreate.applySpoilageCheckBoxPresenceValidation();
			customerCreate.supplementalDataSectionPresenceValidation();
			customerCreate.companyRevenueTextBoxPresenceValidation();
			customerCreate.numOfEmployeeTextBox();
			customerCreate.numOflocationsTextBox();
			customerCreate.dunsNumTextBox();
			customerCreate.infoUsaNumTextBox();
			customerCreate.checkDefaultProofValue();
			customerCreate.isPORequiredCheckBoxPresenceValidation();
			customerCreate.IsSelfServiceLocAllowedCheckBoxPresenceValidation();
			customerCreate.notesTextBox();
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("smoke1@test.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			// Thread.sleep(3000);
			//
			// customerCreate.clickOnbusinessUnitMappingSection();
			// customerCreate.selectCustomerGroup("Orlando Sentinel", "Default -
			// Non-Business/Individual");
			Thread.sleep(2000);
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(3000);
			Thread.sleep(60000);

			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);

			String custBillType = profileCustomer.getCustomerBillingType();

			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + "");

			Assert.assertEquals("PrivateParty", custBillType);
			Assert.assertEquals(str + " Auto", profileCustomer.getCustomerName());

			customerCreate.clickOnCustomerEditBtn();
			customerCreate.selectAccountType("Advertiser");

			Thread.sleep(2000);
			customerCreate.clickOnCustomerSaveBtn1();
			Thread.sleep(3000);
			customerCreate.verifyaddressContactNameTextBox(str + " Auto");
			customerCreate.verifyaddressline1TextBox("435 N Michigan Ave");
			customerCreate.verifyaddresscityTextBox("Chicago");
			customerCreate.verifyaddressemailTextBox("smoke1@test.com");
			customerCreate.verifyaddressphone("3124444444");
			customerCreate.clickOnNextBtn();
			Thread.sleep(13000);
			customerCreate.verifyDeclineReasonNoMatch();
			Thread.sleep(13000);
			// customerCreate.selectCustomerDeails("SmokeTest Automation");
			customerCreate.clickOnselectBtn();
			Thread.sleep(60000);

			profileCustomer.getCustomerID();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber() + " and MDM ID : "
					+ profileCustomer.getCustomerMDMNumber());

			Assert.assertEquals(str + " Auto", profileCustomer.getCustomerName());
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "createNewCustomerEmailValidation",
			"Reg1" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewCustomerEmailValidation(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
			TribuneUtils utils = new TribuneUtils();
			viewCustomer.clickOnNewCustomerBtn();
			Thread.sleep(3000);
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			String str = utils.generateRandomString(15);
			customerCreate.enterCustomerName(str + " Auto");
			customerCreate.selectBillingType("Value");
			customerCreate.selectBU("Orlando Sentinel");
			customerCreate.enteralternativeNameTextBox("altsmoketest");
			customerCreate.selectAccountType("Advertiser");
			customerCreate.selectCategory("Retail");
			customerCreate.selectSubCategory("Internet Sites ");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			customerCreate.enterTermsEmail("1autotest-customer.23_12@59gmail.co.in");
			Thread.sleep(3000);
			customerCreate.tearsheetCheckBoxPresenceValidation();
			customerCreate.taxExemptCheckBoxaPresencValidation();
			customerCreate.isOrderConfirmationRequiredCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxPresenceValidation();
			customerCreate.applySpoilageCheckBoxPresenceValidation();
			customerCreate.supplementalDataSectionPresenceValidation();
			customerCreate.companyRevenueTextBoxPresenceValidation();
			customerCreate.numOfEmployeeTextBox();
			customerCreate.numOflocationsTextBox();
			customerCreate.dunsNumTextBox();
			customerCreate.infoUsaNumTextBox();
			customerCreate.checkDefaultProofValue();
			customerCreate.isPORequiredCheckBoxPresenceValidation();
			customerCreate.IsSelfServiceLocAllowedCheckBoxPresenceValidation();
			customerCreate.notesTextBox();
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("123smoke@tronc.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			Thread.sleep(3000);
			customerCreate.clickOnbusinessUnitMappingSection();
			customerCreate.selectCustomerGroup("Orlando Sentinel", "Default - Internet Sites");
			Thread.sleep(2000);
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(3000);
			customerCreate.verifyaddressContactNameTextBox(str + " Auto");
			customerCreate.verifyaddressline1TextBox("435 N Michigan Ave");
			customerCreate.verifyaddresscityTextBox("Chicago");
			customerCreate.verifyaddressemailTextBox("123smoke@tronc.com");
			customerCreate.verifyaddressphone("3124444444");
			customerCreate.clickOnNextBtn();
			Thread.sleep(13000);
			customerCreate.verifyDeclineReasonNoMatch();
			Thread.sleep(13000);
			// customerCreate.selectCustomerDeails("SmokeTest Automation");
			customerCreate.clickOnselectBtn();
			Thread.sleep(60000);

			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);
			profileCustomer.getCustomerID();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber() + " and MDM ID : "
					+ profileCustomer.getCustomerMDMNumber());

			Assert.assertEquals(str + " Auto", profileCustomer.getCustomerName());

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Order",
			"testOrderPerf" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void testOrderPerf(Map<String, String> userData) throws Exception {
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
			Thread.sleep(4000);
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
			Thread.sleep(6000);
			newOrderInstance.saveOrder();
			Thread.sleep(3000);
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
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
			TribuneUtils utils = new TribuneUtils();

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);

			dashboardPageInstance.clickOnLogout();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "validateCustomerTermsEmailMandatory", "NewRegression1", "PrioritizedReg1", "CustRegression",
			"RegressionLatest", "Reg1", "Group3", "PriorityVulnerability", "NewRegression",
			"customerAdminCreation" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void validateCustomerTermsEmailMandatory(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
			TribuneUtils utils = new TribuneUtils();
			viewCustomer.clickOnNewCustomerBtn();
			Thread.sleep(3000);
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			String str = utils.generateRandomString(15);
			customerCreate.enterCustomerName(str + " Auto");
			customerCreate.selectBillingType("Value");
			customerCreate.selectBU("CTC-CTMG");
			customerCreate.enteralternativeNameTextBox("altsmoketest");
			customerCreate.selectAccountType("Advertiser");
			customerCreate.selectCategory("Retail");
			customerCreate.selectSubCategory("Internet Sites");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			customerCreate.enterTermsEmail("smoketest@tronc.com");
			Thread.sleep(3000);
			customerCreate.tearsheetCheckBoxPresenceValidation();
			customerCreate.taxExemptCheckBoxaPresencValidation();
			customerCreate.isOrderConfirmationRequiredCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxPresenceValidation();
			customerCreate.applySpoilageCheckBoxPresenceValidation();
			customerCreate.supplementalDataSectionPresenceValidation();
			customerCreate.companyRevenueTextBoxPresenceValidation();
			customerCreate.numOfEmployeeTextBox();
			customerCreate.numOflocationsTextBox();
			customerCreate.dunsNumTextBox();
			customerCreate.infoUsaNumTextBox();
			customerCreate.checkDefaultProofValue();
			customerCreate.isPORequiredCheckBoxPresenceValidation();
			customerCreate.IsSelfServiceLocAllowedCheckBoxPresenceValidation();
			customerCreate.notesTextBox();
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("tes123@tronc.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			// Thread.sleep(3000);
			// customerCreate.clickOnbusinessUnitMappingSection();
			// customerCreate.selectCustomerGroup("Orlando Sentinel", "Default -
			// Internet Sites");
			Thread.sleep(2000);
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(3000);
			customerCreate.verifyaddressContactNameTextBox(str + " Auto");
			customerCreate.verifyaddressline1TextBox("435 N Michigan Ave");
			customerCreate.verifyaddresscityTextBox("Chicago");
			customerCreate.verifyaddressemailTextBox("tes123@tronc.com");
			customerCreate.verifyaddressphone("3124444444");
			customerCreate.clickOnNextBtn();
			Thread.sleep(13000);
			customerCreate.verifyDeclineReasonNoMatch();
			Thread.sleep(13000);
			// customerCreate.selectCustomerDeails("SmokeTest Automation");
			customerCreate.clickOnselectBtn();
			Thread.sleep(60000);

			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);
			profileCustomer.getCustomerID();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber() + " and MDM ID : "
					+ profileCustomer.getCustomerMDMNumber());
			customerCreate.CustomerCreativeFeeOptout(profileCustomer.getCustomerCUNumber());
			Assert.assertEquals(str + " Auto", profileCustomer.getCustomerName());
			customerCreate.clickOnCustomerEditBtn();
			customerCreate.enterTermsEmail("");
			Thread.sleep(2000);
			customerCreate.clickOnCustomerSaveBtn1();
			Thread.sleep(4000);
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.verifyOopsrMessagePopUp("Please specify Terms Email");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "NovMaintenance", "createCustomerPlaceOrderStopUpdate", "CustRegression", "RegressionLatest",
			"Reg1", "Group3", "Group3F", "NewRegression", "NewRegression1", "RerunF2",
			"customerAdminCreation" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createCustomerPlaceOrderStopUpdate(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
			TribuneUtils utils = new TribuneUtils();
			viewCustomer.clickOnNewCustomerBtn();
			Thread.sleep(3000);
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			String str = utils.generateRandomString(15);
			customerCreate.enterCustomerName(str + " Auto");
			customerCreate.selectBillingType("Value");
			customerCreate.selectBU("CTC-CTMG");
			customerCreate.enteralternativeNameTextBox("altsmoketest");
			customerCreate.selectAccountType("Advertiser");
			customerCreate.selectCategory("Retail");
			customerCreate.selectSubCategory("Internet Sites");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			customerCreate.enterTermsEmail("smoketest@tronc.com");
			Thread.sleep(3000);
			customerCreate.tearsheetCheckBoxPresenceValidation();
			customerCreate.taxExemptCheckBoxaPresencValidation();
			customerCreate.isOrderConfirmationRequiredCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxPresenceValidation();
			customerCreate.applySpoilageCheckBoxPresenceValidation();
			customerCreate.supplementalDataSectionPresenceValidation();
			customerCreate.companyRevenueTextBoxPresenceValidation();
			customerCreate.numOfEmployeeTextBox();
			customerCreate.numOflocationsTextBox();
			customerCreate.dunsNumTextBox();
			customerCreate.infoUsaNumTextBox();
			customerCreate.checkDefaultProofValue();
			customerCreate.isPORequiredCheckBoxPresenceValidation();
			customerCreate.IsSelfServiceLocAllowedCheckBoxPresenceValidation();
			customerCreate.notesTextBox();
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("tes123@tronc.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			Thread.sleep(5000);
			// customerCreate.clickOnbusinessUnitMappingSection();
			// customerCreate.selectCustomerGroup("Orlando Sentinel", "Default -
			// Internet Sites");
			// Thread.sleep(2000);
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(6000);
			customerCreate.verifyaddressContactNameTextBox(str + " Auto");
			Thread.sleep(3000);
			customerCreate.verifyaddressline1TextBox("435 N Michigan Ave");
			customerCreate.verifyaddresscityTextBox("Chicago");
			customerCreate.verifyaddressemailTextBox("tes123@tronc.com");
			customerCreate.verifyaddressphone("3124444444");
			customerCreate.clickOnNextBtn();
			Thread.sleep(25000);
			customerCreate.verifyDeclineReasonNoMatch();
			Thread.sleep(13000);
			// customerCreate.selectCustomerDeails("SmokeTest Automation");
			customerCreate.clickOnselectBtn();
			Thread.sleep(60000);

			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);
			profileCustomer.getCustomerID();
			String customerCUNumber = profileCustomer.getCustomerCUNumber();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber() + " and MDM ID : "
					+ profileCustomer.getCustomerMDMNumber());

			Assert.assertEquals(str + " Auto", profileCustomer.getCustomerName());
			customerCreate.CustomerCreativeFeeOptout(profileCustomer.getCustomerCUNumber());
			
			
			customerCreate.clickOnNewOrderBtn();
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");// mousumi
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 8, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1", 8, 27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 8, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 8, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 8, 3);
			Thread.sleep(5000);
			// newOrderInstance.selectSection("1", 25, 4);
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
			//Thread.sleep(2000);
			Thread.sleep(6000);
			newOrderInstance.addServiceRep("019167");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(2000);
			newOrderInstance.clickOnContinuePastPubDate(); //Joy
			// newOrderInstance.clickNoLegacyAutoInsertionCreation();
			// Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(5000);
			dashboardPageInstance.clickOnCustomerModule();
			Thread.sleep(8000);
			CustomerPage customerSearchPage = PageFactory.initElements(driver, CustomerPage.class);
			customerSearchPage.searchCustomerByCUNumber(customerCUNumber);
			Thread.sleep(8000);
			customerCreate.clickOnFinanceSection();
			Thread.sleep(4000);
			customerCreate.clickOnCollectorSection();
			Thread.sleep(4000);
			customerCreate.selectCreditStatus("Stop");// mousumi
			Thread.sleep(4000);
			//customerCreate.clickOnCreditStatusSaveBtn();
			//Thread.sleep(8000);
			OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			dashboardPageInstance.clickOnOrderEntryModule();
			Thread.sleep(5000);
			basicOrderSearch.enterOrderNumber(orderID);
			Thread.sleep(2000);
			basicOrderSearch.clickOnOrderSearchBtn();
			Thread.sleep(4000);

			WebElement orderNumberLink = driver.findElement(By.xpath("//a[text()='" + orderID + "']"));
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOf(orderNumberLink));
			if (orderNumberLink.isDisplayed()) {
				orderNumberLink.click();
				Logger.info(orderID + " searched order is clicked");
			}
			Thread.sleep(15000);

			newOrderInstance.selectOrderType("OrderType_Legal");
			Thread.sleep(2000);
			newOrderInstance.submitOrder();
			
			Thread.sleep(2000);
			newOrderInstance.clickOnContinuePastPubDate(); //Joy
			
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "createStopCustomerPlaceOrder", "CustRegression", "RegressionLatest", "Reg1", "Group3",
			"PriorityVulnerability", "RegFailed4", "Group3F", "NewRegression1", "NewRegression", "RerunF2",
			"customerAdminCreation" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createStopCustomerPlaceOrder(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
			TribuneUtils utils = new TribuneUtils();
			viewCustomer.clickOnNewCustomerBtn();
			Thread.sleep(3000);
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			String str = utils.generateRandomString(15);
			customerCreate.enterCustomerName(str + " Auto");
			customerCreate.selectBillingType("Value");
			customerCreate.selectBU("CTC-CTMG");
			customerCreate.enteralternativeNameTextBox("altsmoketest");
			customerCreate.selectAccountType("Advertiser");
			customerCreate.selectCategory("Retail");
			customerCreate.selectSubCategory("Internet Sites");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			customerCreate.enterTermsEmail("smoketest@tronc.com");
			Thread.sleep(3000);
			customerCreate.tearsheetCheckBoxPresenceValidation();
			customerCreate.taxExemptCheckBoxaPresencValidation();
			customerCreate.isOrderConfirmationRequiredCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxPresenceValidation();
			customerCreate.applySpoilageCheckBoxPresenceValidation();
			customerCreate.supplementalDataSectionPresenceValidation();
			customerCreate.companyRevenueTextBoxPresenceValidation();
			customerCreate.numOfEmployeeTextBox();
			customerCreate.numOflocationsTextBox();
			customerCreate.dunsNumTextBox();
			customerCreate.infoUsaNumTextBox();
			customerCreate.checkDefaultProofValue();
			customerCreate.isPORequiredCheckBoxPresenceValidation();
			customerCreate.IsSelfServiceLocAllowedCheckBoxPresenceValidation();
			customerCreate.notesTextBox();
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("tes123@tronc.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			// Thread.sleep(3000);
			// customerCreate.clickOnbusinessUnitMappingSection();
			// Thread.sleep(2000);
			// customerCreate.selectCustomerGroup("Orlando Sentinel", "Default -
			// Internet Sites");
			Thread.sleep(2000);
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(3000);
			customerCreate.verifyaddressContactNameTextBox(str + " Auto");
			customerCreate.verifyaddressline1TextBox("435 N Michigan Ave");
			customerCreate.verifyaddresscityTextBox("Chicago");
			customerCreate.verifyaddressemailTextBox("tes123@tronc.com");
			customerCreate.verifyaddressphone("3124444444");
			customerCreate.clickOnNextBtn();
			Thread.sleep(13000);
			customerCreate.verifyDeclineReasonNoMatch();
			Thread.sleep(13000);
			// customerCreate.selectCustomerDeails("SmokeTest Automation");
			customerCreate.clickOnselectBtn();
			Thread.sleep(60000);

			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);
			profileCustomer.getCustomerID();
			String customerCUNumber = profileCustomer.getCustomerCUNumber();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber() + " and MDM ID : "
					+ profileCustomer.getCustomerMDMNumber());
			customerCreate.CustomerCreativeFeeOptout(profileCustomer.getCustomerCUNumber());
			Assert.assertEquals(str + " Auto", profileCustomer.getCustomerName());

			Thread.sleep(8000);
			customerCreate.clickOnFinanceSection();
			Thread.sleep(4000);
			customerCreate.clickOnCollectorSection();
			Thread.sleep(4000);
			customerCreate.selectCreditStatus("Stop");
			Thread.sleep(4000);
			customerCreate.clickOnCreditStatusSaveBtn();
			Thread.sleep(8000);
			customerCreate.clickOnNewOrderBtn();
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.selectPaymentType("Invoice");
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
			// newOrderInstance.selectSection("1", 25, 4);
			// Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			// newOrderInstance.selectAdSize(1, "1/4V (3 x 10.5)");
			// Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);// mousumi
			// newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA00494");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);// mousumi
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);// mousumi
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("019167");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			// Thread.sleep(1000);
			// newOrderInstance.clickNoLegacyAutoInsertionCreation();
			Thread.sleep(1000);
			newOrderInstance.displayErrorMessage();
			newOrderInstance.compareErrorMessage("Can't submit order due to Bill To customer credit status");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/*
	 * Verify Legacy Autoinsertion with agency commission allocating when bill to customer is Agency type
	 */

	@Test(groups = { "createNewCustomerAutoAgencyCommission", "S56M1", "RegressionLatest", "Reg1", "Group3",
			"PriorityVulnerability", "NewRegression1", "NewRegression",
			"customerAdminCreation" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewCustomerAutoAgencyCommission(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
			TribuneUtils utils = new TribuneUtils();
			viewCustomer.clickOnNewCustomerBtn();
			Thread.sleep(3000);
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			String str = utils.generateRandomString(15);
			customerCreate.enterCustomerName(str + " Auto");
			customerCreate.selectBillingType("Value");
			customerCreate.selectBU("DPR-Daily Press");
			customerCreate.enteralternativeNameTextBox("altsmoketest");
			customerCreate.selectAccountType("Advertiser");
			customerCreate.selectCategory("Retail");
			customerCreate.selectSubCategory("Internet Sites ");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			customerCreate.enterTermsEmail("smoketest@tronc.com");
			Thread.sleep(3000);
			customerCreate.tearsheetCheckBoxPresenceValidation();
			customerCreate.taxExemptCheckBoxaPresencValidation();
			customerCreate.isOrderConfirmationRequiredCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxSelect();
			customerCreate.applySpoilageCheckBoxPresenceValidation();
			customerCreate.supplementalDataSectionPresenceValidation();
			customerCreate.companyRevenueTextBoxPresenceValidation();
			customerCreate.numOfEmployeeTextBox();
			customerCreate.numOflocationsTextBox();
			customerCreate.dunsNumTextBox();
			customerCreate.infoUsaNumTextBox();
			customerCreate.checkDefaultProofValue();
			customerCreate.isPORequiredCheckBoxPresenceValidation();
			customerCreate.IsSelfServiceLocAllowedCheckBoxPresenceValidation();
			customerCreate.notesTextBox();
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("tes123@tronc.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			Thread.sleep(3000);
		/*	customerCreate.clickOnbusinessUnitMappingSection();
			customerCreate.selectCustomerGroup("DPR-Daily Press", "Internet Sites");
			Thread.sleep(2000);*///swagata
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(3000);
			customerCreate.verifyaddressContactNameTextBox(str + " Auto");
			customerCreate.verifyaddressline1TextBox("435 N Michigan Ave");
			customerCreate.verifyaddresscityTextBox("Chicago");
			customerCreate.verifyaddressemailTextBox("tes123@tronc.com");
			customerCreate.verifyaddressphone("3124444444");
			customerCreate.clickOnNextBtn();
			Thread.sleep(13000);
			customerCreate.verifyDeclineReasonNoMatch();
			Thread.sleep(13000);
			// customerCreate.selectCustomerDeails("SmokeTest Automation");
			customerCreate.clickOnselectBtn();
			Thread.sleep(60000);

			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);
			String custAdvertiser = profileCustomer.getCustomerCUNumber();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber() + " and MDM ID : "
					+ profileCustomer.getCustomerMDMNumber());

			/*utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			signinPageinstance.login("success");*///swagata

			dashboardPageInstance.clickOnCustomerModule();

			viewCustomer.clickOnNewCustomerBtn();

			Thread.sleep(3000);

			String str1 = utils.generateRandomString(15);
			customerCreate.enterCustomerName(str1 + " Auto");
			customerCreate.selectBillingType("Value");
			customerCreate.selectBU("DPR-Daily Press");
			customerCreate.enteralternativeNameTextBox("altsmoketest");
			customerCreate.selectAccountType("Agency");
			customerCreate.selectCategory("Retail");
			customerCreate.selectSubCategory("Internet Sites ");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			customerCreate.enterTermsEmail("smoketest@tronc.com");
			Thread.sleep(3000);
			customerCreate.tearsheetCheckBoxPresenceValidation();
			customerCreate.taxExemptCheckBoxaPresencValidation();
			customerCreate.isOrderConfirmationRequiredCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxPresenceValidation();

			customerCreate.applySpoilageCheckBoxPresenceValidation();
			customerCreate.supplementalDataSectionPresenceValidation();
			customerCreate.companyRevenueTextBoxPresenceValidation();
			customerCreate.numOfEmployeeTextBox();
			customerCreate.numOflocationsTextBox();
			customerCreate.dunsNumTextBox();
			customerCreate.infoUsaNumTextBox();
			customerCreate.checkDefaultProofValue();
			customerCreate.isPORequiredCheckBoxPresenceValidation();
			customerCreate.IsSelfServiceLocAllowedCheckBoxPresenceValidation();
			customerCreate.notesTextBox();
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str1 + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("tes123@tronc.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			Thread.sleep(3000);
			// customerCreate.clickOnbusinessUnitMappingSection();
			// customerCreate.selectCustomerGroup("DPR-Daily Press", "Internet
			// Sites");
			// Thread.sleep(2000);
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(3000);
			customerCreate.verifyaddressContactNameTextBox(str1 + " Auto");
			customerCreate.verifyaddressline1TextBox("435 N Michigan Ave");
			customerCreate.verifyaddresscityTextBox("Chicago");
			customerCreate.verifyaddressemailTextBox("tes123@tronc.com");
			customerCreate.verifyaddressphone("3124444444");
			customerCreate.clickOnNextBtn();
			Thread.sleep(13000);
			customerCreate.verifyDeclineReasonNoMatch();
			Thread.sleep(13000);
			// customerCreate.selectCustomerDeails("SmokeTest Automation");
			customerCreate.clickOnselectBtn();
			Thread.sleep(120000);

			String custAgency = profileCustomer.getCustomerCUNumber();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber() + " and MDM ID : "
					+ profileCustomer.getCustomerMDMNumber());

			/*utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			signinPageinstance.login("success");

			dashboardPageInstance.clickOnOrderEntryModule();*///swagata

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_DPR");
			newOrderInstance.enterSoldToCustomer(custAdvertiser);
			newOrderInstance.selectBillToCustomerBU("bu_DPR");
			newOrderInstance.enterBillToCustomer(custAgency);
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 29, 0);
			Thread.sleep(4000);
			 newOrderInstance.enterPubDateFromExcel("1",29,27);
			 Thread.sleep(5000);
			newOrderInstance.selectProductType("1", 29, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 29, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 29, 3);
			Thread.sleep(5000);
			//newOrderInstance.selectSection("1", 29, 4);
			//Thread.sleep(6000);
			newOrderInstance.enterClassCodeForAnInsertion(1, "50100");
			Thread.sleep(4000);  
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			double agencyCommPercentage = newOrderInstance.getInsertionPrice("1", "agencyComm Percentage");
			Logger.info("Agency commision  Percentage: " + agencyCommPercentage);
			boolean flag = false;
			if (agencyCommPercentage > 0.0) {
				flag = true;
			}
			Assert.assertEquals(true, flag);
			//added by swagata
			double NetPriceStndrdLine = newOrderInstance.getInsertionPrice("1","net");
			Logger.info("Net price of standard line before submit" + NetPriceStndrdLine);
            newOrderInstance.collapseInsertionDetails("1");	
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			newOrderInstance.submitOrderWithoutSave();
			Thread.sleep(4000);//joy
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info("Order: "+orderID);
			newOrderInstance.ClickSubmitButton();//joy
			Thread.sleep(3000);
			//newOrderInstance.clickNoLegacyAutoInsertionCreation(); //joy
			
			//Thread.sleep(3000);
			
			
		} catch (Exception e) {
			Logger.error(e.getMessage());
			//throw e;
		}
	}

	@Test(groups = { "NovMaintenance", "createNewCustomerCondnsdStatmnt", "CustRegression", "RegressionLatest",
			"Group3", "PriorityVulnerability", "RegFailed4", "NewRegression1", "NewRegression", "RerunF2",
			"customerAdminCreation" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewCustomerCondnsdStatmnt(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
			TribuneUtils utils = new TribuneUtils();
			viewCustomer.clickOnNewCustomerBtn();
			Thread.sleep(3000);
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			String str = utils.generateRandomString(15);
			customerCreate.enterCustomerName(str + " Auto");
			customerCreate.selectBillingType("Value");
			customerCreate.selectBU("Orlando Sentinel");// mousumi
			customerCreate.enteralternativeNameTextBox("altsmoketest");
			customerCreate.selectAccountType("Advertiser");
			customerCreate.selectCategory("Retail");
			customerCreate.selectSubCategory("Internet Sites");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			customerCreate.enterTermsEmail("smoketest@tronc.com");
			Thread.sleep(3000);
			customerCreate.tearsheetCheckBoxPresenceValidation();
			customerCreate.taxExemptCheckBoxaPresencValidation();
			customerCreate.isOrderConfirmationRequiredCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxPresenceValidation();
			customerCreate.applySpoilageCheckBoxPresenceValidation();
			customerCreate.condensedStmntCheckBoxSelect();// mousumi
			Thread.sleep(3000);
			customerCreate.supplementalDataSectionPresenceValidation();
			customerCreate.companyRevenueTextBoxPresenceValidation();

			customerCreate.numOflocationsTextBox();
			customerCreate.dunsNumTextBox();
			customerCreate.infoUsaNumTextBox();
			customerCreate.checkDefaultProofValue();
			customerCreate.isPORequiredCheckBoxPresenceValidation();
			customerCreate.IsSelfServiceLocAllowedCheckBoxPresenceValidation();

			customerCreate.numOfEmployeeTextBox();
			customerCreate.notesTextBox();
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("tes123@tronc.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			Thread.sleep(3000);
			customerCreate.clickOnbusinessUnitMappingSection();
			Thread.sleep(6000);
			customerCreate.selectCustomerGroup("Orlando Sentinel", "Default - Internet Sites");
			Thread.sleep(2000);
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(6000);
			customerCreate.verifyaddressContactNameTextBox(str + " Auto");
			customerCreate.verifyaddressline1TextBox("435 N Michigan Ave");
			customerCreate.verifyaddresscityTextBox("Chicago");
			customerCreate.verifyaddressemailTextBox("tes123@tronc.com");
			customerCreate.verifyaddressphone("3124444444");
			customerCreate.clickOnNextBtn();
			Thread.sleep(13000);
			customerCreate.verifyDeclineReasonNoMatch();
			Thread.sleep(13000);
			// customerCreate.selectCustomerDeails("SmokeTest Automation");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			customerCreate.clickOnselectBtn();
			// Thread.sleep(60000);

			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);
			String customerID = profileCustomer.getCustomerCUNumber();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber() + " and MDM ID : "
					+ profileCustomer.getCustomerMDMNumber());
			customerCreate.CustomerCreativeFeeOptout(profileCustomer.getCustomerCUNumber());
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			signinPageinstance.login("success");

			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_OSC");
			newOrderInstance.enterSoldToCustomer(customerID);
			// newOrderInstance.selectBillToCustomerBU("bu_OSC");
			// newOrderInstance.enterBillToCustomer("CU00392709");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			boolean flag1 = newOrderInstance.verifycheckUncheckCondensedStatement(true);
			Assert.assertEquals(flag1, true);
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
			newOrderInstance.addServiceRep("203486");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(3000);
			// newOrderInstance.clickNoLegacyAutoInsertionCreation();
			// Thread.sleep(1000);
			newOrderInstance.clickOnContinuePastPubDate();//joy
			Thread.sleep(4000);

			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(7000);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Logger.info("START OF COPY ORDER");

			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();
			Thread.sleep(8000);
			boolean flag = newOrderInstance.verifycheckUncheckCondensedStatement(true);
			Assert.assertEquals(flag, true);
			dashboardPageInstance.clickOnLogout();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "createNewProspectCustomerEditBillingPlaceOrder", "CustRegression", "RegressionLatest", "Reg1",
			"Group3", "PriorityVulnerability", "NewRegression1", "NewRegression", "RerunF2",
			"customerAdminCreation" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewProspectCustomerEditBillingPlaceOrder(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
			TribuneUtils utils = new TribuneUtils();
			viewCustomer.clickOnNewCustomerBtn();
			Thread.sleep(3000);
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			String str = utils.generateRandomString(15);
			customerCreate.enterCustomerName(str + " Auto");
			customerCreate.selectBillingType("PrivateParty");
			customerCreate.selectBU("DPR-Daily Press");
			customerCreate.enteralternativeNameTextBox("altsmoketest");
			customerCreate.selectAccountType("Prospect");
			// customerCreate.selectCategory("Retail");
			// customerCreate.selectSubCategory("Internet Sites ");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			customerCreate.enterTermsEmail1("smoketest@tronc.com");
			Thread.sleep(3000);
			customerCreate.tearsheetCheckBoxPresenceValidation();
			customerCreate.taxExemptCheckBoxaPresencValidation();
			customerCreate.isOrderConfirmationRequiredCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxPresenceValidation();
			customerCreate.applySpoilageCheckBoxPresenceValidation();
			customerCreate.supplementalDataSectionPresenceValidation();
			customerCreate.companyRevenueTextBoxPresenceValidation();
			customerCreate.numOfEmployeeTextBox();
			customerCreate.numOflocationsTextBox();
			customerCreate.dunsNumTextBox();
			customerCreate.infoUsaNumTextBox();
			customerCreate.checkDefaultProofValue();
			customerCreate.isPORequiredCheckBoxPresenceValidation();
			customerCreate.IsSelfServiceLocAllowedCheckBoxPresenceValidation();
			customerCreate.notesTextBox();
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("smoke1@test.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			Thread.sleep(3000);

			// customerCreate.clickOnbusinessUnitMappingSection();
			// customerCreate.selectCustomerGroup("DPR-Daily Press", "Default -
			// Non-Business/Individual");
			Thread.sleep(2000);
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(3000);
			Thread.sleep(60000);

			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);

			String custBillType = profileCustomer.getCustomerBillingType();

			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + "");

			Assert.assertEquals("PrivateParty", custBillType);
			Assert.assertEquals(str + " Auto", profileCustomer.getCustomerName());

			customerCreate.clickOnCustomerEditBtn();
			customerCreate.selectAccountType("Advertiser");

			Thread.sleep(2000);

			customerCreate.selectBillingType1("Value");
			Thread.sleep(2000);
			customerCreate.selectCategory("General");
			Thread.sleep(2000);
			customerCreate.selectSubCategory("Advertising Agencies");
			Thread.sleep(2000);
			customerCreate.clickOnCustomerSaveBtn1();
			Thread.sleep(3000);
			customerCreate.verifyaddressContactNameTextBox(str + " Auto");
			customerCreate.verifyaddressline1TextBox("435 N Michigan Ave");
			customerCreate.verifyaddresscityTextBox("Chicago");
			customerCreate.verifyaddressemailTextBox("smoke1@test.com");
			customerCreate.verifyaddressphone("3124444444");
			customerCreate.clickOnNextBtn();
			Thread.sleep(13000);
			customerCreate.verifyDeclineReasonNoMatch();// mousumi
			Thread.sleep(13000);
			// customerCreate.selectCustomerDeails("SmokeTest Automation");
			customerCreate.clickOnselectBtn();
			Thread.sleep(80000);

			profileCustomer.getCustomerID();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber() + " and MDM ID : "
					+ profileCustomer.getCustomerMDMNumber());
			customerCreate.CustomerCreativeFeeOptout(profileCustomer.getCustomerCUNumber());
			Assert.assertEquals(str + " Auto", profileCustomer.getCustomerName());

			CustomerProfilePage customerProfile = PageFactory.initElements(driver, CustomerProfilePage.class);
			customerProfile.getCustomerProfile();
			Thread.sleep(3000);
			customerProfile.clickOnNewOrder();
			Thread.sleep(3000);
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectBilltoSameAsSoldTo();
			Thread.sleep(3000);
			newOrderInstance.selectOrderType("OrderType_Standard");
			Thread.sleep(3000);
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1", 55, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1", 55, 27);
			Thread.sleep(5000);

			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.enterClassCodeForAnInsertion(1, "10060");
			Thread.sleep(4000);

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
			newOrderInstance.addServiceRep("034107");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(2000);
			// newOrderInstance.clickNoLegacyAutoInsertionCreation();
			// Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();

			orderEntryPageInstance.clickOnOrder(orderID);
			
			Thread.sleep(3000);

			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "createNewCustomerPOnotes", "PrioritizedReg1",
			"customerAdminCreation" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void createNewCustomerPOnotes(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
			TribuneUtils utils = new TribuneUtils();
			viewCustomer.clickOnNewCustomerBtn();
			Thread.sleep(3000);
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			String str = utils.generateRandomString(15);
			customerCreate.enterCustomerName(str + " Auto");
			customerCreate.selectBillingType("Value");
			customerCreate.selectBU("Orlando Sentinel");
			customerCreate.enteralternativeNameTextBox("altsmoketest");
			customerCreate.selectAccountType("Advertiser");
			//customerCreate.selectCategory("Retail");
			customerCreate.selectSubCategory("Internet Sites ");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			customerCreate.enterTermsEmail("smoketest@tronc.com");
			Thread.sleep(3000);
			customerCreate.tearsheetCheckBoxPresenceValidation();
			customerCreate.taxExemptCheckBoxaPresencValidation();
			customerCreate.isOrderConfirmationRequiredCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxPresenceValidation();
			customerCreate.applySpoilageCheckBoxPresenceValidation();
			customerCreate.supplementalDataSectionPresenceValidation();
			customerCreate.companyRevenueTextBoxPresenceValidation();
			customerCreate.numOfEmployeeTextBox();
			customerCreate.numOflocationsTextBox();
			customerCreate.dunsNumTextBox();
			customerCreate.infoUsaNumTextBox();
			customerCreate.checkDefaultProofValue();
			customerCreate.checkPORequiredCheckBox();
			customerCreate.IsSelfServiceLocAllowedCheckBoxPresenceValidation();
			customerCreate.enterNotesText();
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("tes123@tronc.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			Thread.sleep(3000);

			customerCreate.clickOnbusinessUnitMappingSection();
			Thread.sleep(3000);
			customerCreate.selectCustomerGroup("Orlando Sentinel", "Default - Internet Sites");
			Thread.sleep(2000);
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(3000);
			customerCreate.verifyaddressContactNameTextBox(str + " Auto");
			customerCreate.verifyaddressline1TextBox("435 N Michigan Ave");
			customerCreate.verifyaddresscityTextBox("Chicago");
			customerCreate.verifyaddressemailTextBox("tes123@tronc.com");
			customerCreate.verifyaddressphone("3124444444");
			customerCreate.clickOnNextBtn();
			Thread.sleep(13000);
			customerCreate.verifyDeclineReasonNoMatch();
			Thread.sleep(13000);
			// customerCreate.selectCustomerDeails("SmokeTest Automation");
			customerCreate.clickOnselectBtn();
			Thread.sleep(120000);

			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);
			profileCustomer.getCustomerID();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber() + " and MDM ID : "
					+ profileCustomer.getCustomerMDMNumber());

			Assert.assertEquals(str + " Auto", profileCustomer.getCustomerName());

			CustomerProfilePage customerProfile = PageFactory.initElements(driver, CustomerProfilePage.class);

			customerProfile.clickOnNewOrder();
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 6, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1", "29", "Dec", "2019");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1", 7, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1", 7, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1", 7, 3);
			Thread.sleep(4000);
			// newOrderInstance.selectSection("1",7, 4);
			/// Thread.sleep(4000);
			newOrderInstance.selectMMTag("1", "Festival of Books");
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
			newOrderInstance.addServiceRep("203486");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			newOrderInstance.displayErrorMessageMultiple(1);
			newOrderInstance.compareErrorMessageMultiple(
					"This Bill To customer requires a Purchase Order Number. please Enter a PO#(30 char max).", 1);
			Random rand = new Random(System.currentTimeMillis());
			int num = rand.nextInt(9999);
			newOrderInstance.enterPoNumber("" + num);
			Thread.sleep(2000);
			newOrderInstance.submitOrder();
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
	
	
	/*
	 * Validate  if Audit Log for a particular customer to be displayed in 
	 * the Customer History Pop Up when changes made in any Edit action
	 */
	//swagata
	@Test(groups = { "SMaintenance","CustRegression","customerHistoryPopUpChecking","NewRegression3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData", invocationCount = 1)
	public void customerHistoryPopUpChecking(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);
			Thread.sleep(50000);
			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");
			Thread.sleep(3000);
			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
			TribuneUtils utils = new TribuneUtils();
			viewCustomer.clickOnNewCustomerBtn();
			Thread.sleep(3000);
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			String str = utils.generateRandomString(15);
			customerCreate.enterCustomerName(str + " Auto");
			customerCreate.selectBillingType("Value");
			customerCreate.selectBU("NDN-New York Daily News");
			customerCreate.enteralternativeNameTextBox("sdtsmoketest");
			customerCreate.selectAccountType("Advertiser");
			customerCreate.selectCategory("Retail");
			customerCreate.selectSubCategory("Internet Sites");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			customerCreate.enterTermsEmail("smoketest@tronc.com");
			Thread.sleep(3000);
			customerCreate.tearsheetCheckBoxPresenceValidation();
			customerCreate.taxExemptCheckBoxaPresencValidation();
			customerCreate.isOrderConfirmationRequiredCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxPresenceValidation();
			customerCreate.applySpoilageCheckBoxPresenceValidation();
			customerCreate.supplementalDataSectionPresenceValidation();
			customerCreate.companyRevenueTextBoxPresenceValidation();
			customerCreate.numOfEmployeeTextBox();
			customerCreate.numOflocationsTextBox();
			customerCreate.dunsNumTextBox();
			customerCreate.infoUsaNumTextBox();
			customerCreate.checkDefaultProofValue();
			customerCreate.isPORequiredCheckBoxPresenceValidation();
			customerCreate.IsSelfServiceLocAllowedCheckBoxPresenceValidation();
			customerCreate.notesTextBox();
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("tes123@tronc.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			Thread.sleep(4000);
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(6000);
			customerCreate.clickOnNextBtn();
			customerCreate.clickOnselectBtn();
			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);
			profileCustomer.getCustomerID();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber());

			Assert.assertEquals(str + " Auto", profileCustomer.getCustomerName());
			customerCreate.clickOnFinanceSection();
			String status=  profileCustomer.activeInactiveCustomer();//need to check issue
			Logger.info("Active status:"+status);
			customerCreate.clickOnCreditStatusSaveBtn();
			profileCustomer.clickHistoryCustomerProfile();
			String changedStatus = null;
			switch (status)

			{
			case "yes":   changedStatus = "no";  
			profileCustomer.customerInactiveStatus();
			break; 

			case "no":    changedStatus = "yes";
			profileCustomer.customerInactiveStatus();
			break;


			} 
			//profileCustomer. verifyCustomerHistory(2,"Finance : isactive- "+changedStatus+" change to "+status);

			Thread.sleep(5000);
			dashboardPageInstance.clickondropdownforlogout();//joy
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/*
	 * Validate that this Textbox value would be mandatory if 
	 * Other has been selected as the Option by the User
	 */
	//swagata
	@Test(groups = {"CustRegression", "custAccountStndgOthrWithOutComnt","NewRegression3" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData", invocationCount = 1)
	public void customerAcountStandingOtherWithOutComment(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);
			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");
			Thread.sleep(3000);
			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
			TribuneUtils utils = new TribuneUtils();
			viewCustomer.clickOnNewCustomerBtn();
			Thread.sleep(3000);
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			String str = utils.generateRandomString(15);
			customerCreate.enterCustomerName(str + " Auto");
			customerCreate.selectBillingType("Value");
			customerCreate.selectBU("NDN-New York Daily News");
			customerCreate.enteralternativeNameTextBox("sdtsmoketest");
			customerCreate.selectAccountType("Advertiser");
			customerCreate.selectCategory("Retail");
			customerCreate.selectSubCategory("Internet Sites");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			customerCreate.enterTermsEmail("smoketest@tronc.com");
			Thread.sleep(3000);
			customerCreate.tearsheetCheckBoxPresenceValidation();
			customerCreate.taxExemptCheckBoxaPresencValidation();
			customerCreate.isOrderConfirmationRequiredCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxPresenceValidation();
			customerCreate.applySpoilageCheckBoxPresenceValidation();
			customerCreate.supplementalDataSectionPresenceValidation();
			customerCreate.companyRevenueTextBoxPresenceValidation();
			customerCreate.numOfEmployeeTextBox();
			customerCreate.numOflocationsTextBox();
			customerCreate.dunsNumTextBox();
			customerCreate.infoUsaNumTextBox();
			customerCreate.checkDefaultProofValue();
			customerCreate.isPORequiredCheckBoxPresenceValidation();
			customerCreate.IsSelfServiceLocAllowedCheckBoxPresenceValidation();
			customerCreate.notesTextBox();
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("tes123@tronc.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			Thread.sleep(4000);
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(6000);
			customerCreate.clickOnNextBtn();
			customerCreate.clickOnselectBtn();
			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);
			profileCustomer.getCustomerID();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber());

			Assert.assertEquals(str + " Auto", profileCustomer.getCustomerName());
			customerCreate.clickOnFinanceSection();
			customerCreate.selectAccountStanding("Other");

			customerCreate.clickOnCreditStatusSaveBtn();
			String errorMsgText = customerCreate.errorMsgChecking();
			Assert.assertEquals("Please Insert Account Standing Value", errorMsgText);
			Logger.info("Textbox value would be mandatory if Other has been selected as the Option by the User");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/*
	 * Validate that Once the user selects "Other", 
	 * a Blank Textbox is displayed where the Account Standing 
	 * Value can be entered by the user
	 */
	//swagata
	@Test(groups = {"CustRegression","customerAcountStandingOtherWithComment", "custAccountStndgOthrWithComnt","NewRegression3" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData", invocationCount = 1)
	public void customerAcountStandingOtherWithComment(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);
			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");
			Thread.sleep(3000);
			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
			TribuneUtils utils = new TribuneUtils();
			viewCustomer.clickOnNewCustomerBtn();
			Thread.sleep(3000);
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			String str = utils.generateRandomString(15);
			customerCreate.enterCustomerName(str + " Auto");
			customerCreate.selectBillingType("Value");
			customerCreate.selectBU("NDN-New York Daily News");
			customerCreate.enteralternativeNameTextBox("sdtsmoketest");
			customerCreate.selectAccountType("Advertiser");
			customerCreate.selectCategory("Retail");
			customerCreate.selectSubCategory("Internet Sites");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			customerCreate.enterTermsEmail("smoketest@tronc.com");
			Thread.sleep(3000);
			customerCreate.tearsheetCheckBoxPresenceValidation();
			customerCreate.taxExemptCheckBoxaPresencValidation();
			customerCreate.isOrderConfirmationRequiredCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxPresenceValidation();
			customerCreate.applySpoilageCheckBoxPresenceValidation();
			customerCreate.supplementalDataSectionPresenceValidation();
			customerCreate.companyRevenueTextBoxPresenceValidation();
			customerCreate.numOfEmployeeTextBox();
			customerCreate.numOflocationsTextBox();
			customerCreate.dunsNumTextBox();
			customerCreate.infoUsaNumTextBox();
			customerCreate.checkDefaultProofValue();
			customerCreate.isPORequiredCheckBoxPresenceValidation();
			customerCreate.IsSelfServiceLocAllowedCheckBoxPresenceValidation();
			customerCreate.notesTextBox();
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("tes123@tronc.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			Thread.sleep(4000);
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(6000);
			customerCreate.clickOnNextBtn();
			Thread.sleep(2000);
			customerCreate.clickOnselectBtn();
			Thread.sleep(2000);
			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);
			profileCustomer.getCustomerID();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber());

			Assert.assertEquals(str + " Auto", profileCustomer.getCustomerName());
			customerCreate.clickOnFinanceSection();
			Thread.sleep(2000);
			customerCreate.selectAccountStanding("Other");
			Thread.sleep(2000);
			customerCreate.enterCommentInOtherTextBox();
			Thread.sleep(2000);
			customerCreate.clickOnCreditStatusSaveBtn();
			Thread.sleep(2000);
			Logger.info(" Once the user selects 'Other' a Blank Textbox is displayed where the Account Standing Value can be entered by the user");


		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/*
	 * Validate that Once the customer is created
	 * There should be no option to  turn it into prospect customer
	 */
	//swagata
	@Test(groups = { "CustRegression","editCustChkNoProspectOption","NewRegression3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData", invocationCount = 1)
	public void editCustChkNoProspectOption(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);
			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			Thread.sleep(3000);
			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
			TribuneUtils utils = new TribuneUtils();
			viewCustomer.clickOnNewCustomerBtn();
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			String str = utils.generateRandomString(15);
			customerCreate.enterCustomerName(str + " Auto");
			customerCreate.selectBillingType("Value");
			customerCreate.selectBU("NDN-New York Daily News");
			customerCreate.enteralternativeNameTextBox("sdtsmoketest");
			customerCreate.selectAccountType("Advertiser");
			customerCreate.selectCategory("Retail");
			customerCreate.selectSubCategory("Internet Sites");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			customerCreate.enterTermsEmail("smoketest@tronc.com");
			Thread.sleep(3000);
			customerCreate.tearsheetCheckBoxPresenceValidation();
			customerCreate.taxExemptCheckBoxaPresencValidation();
			customerCreate.isOrderConfirmationRequiredCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxPresenceValidation();
			customerCreate.applySpoilageCheckBoxPresenceValidation();
			customerCreate.supplementalDataSectionPresenceValidation();
			customerCreate.companyRevenueTextBoxPresenceValidation();
			customerCreate.numOfEmployeeTextBox();
			customerCreate.numOflocationsTextBox();
			customerCreate.dunsNumTextBox();
			customerCreate.infoUsaNumTextBox();
			customerCreate.checkDefaultProofValue();
			customerCreate.isPORequiredCheckBoxPresenceValidation();
			customerCreate.IsSelfServiceLocAllowedCheckBoxPresenceValidation();
			customerCreate.notesTextBox();
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("tes123@tronc.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			Thread.sleep(4000);
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(6000);
			customerCreate.clickOnNextBtn();
			customerCreate.clickOnselectBtn();
			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);
			profileCustomer.getCustomerID();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber());

			Assert.assertEquals(str + " Auto", profileCustomer.getCustomerName());
			EditCustomerPage EditCustomerPage = PageFactory.initElements(driver, EditCustomerPage.class);
			EditCustomerPage.clickOnCustProfileEdit();
			EditCustomerPage.AccountTypeCheck("Prospect");
			Logger.info("There is no option to  turn it into prospect customer after a customer is created");
			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
