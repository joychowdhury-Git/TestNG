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
 * @author Priyanka Goud CR 
 * @since January 2016
 */

public class OrderCreateNewCustomerTest 
{
	/**
	 * This test will create a new order for display product type with a new customer
	 */
	@Test(groups = {"Order", "ProductionTest1","createNewOrderWithNewCustomer1","RegressionLatest"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewOrderWithNewCustomer(Map<String, String> userData) throws Exception
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
		       newOrderInstance.clickOnNewCustomer(); 
		       TribuneUtils utils  = new TribuneUtils();
		       CustomerCreatePage customerCreate =  PageFactory.initElements(driver, CustomerCreatePage.class);
		       String str = utils.generateRandomString(15);
		       customerCreate.enterCustomerName(str+" Auto");
		       customerCreate.selectBillingType("ValuePrePaid");
		       customerCreate.selectBU("Orlando Sentinel");
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
		       customerCreate.entercontactName(str+" Auto");
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
		       customerCreate.selectCustomerGroup("Orlando Sentinel", "Default - Internet Sites");
		       Thread.sleep(2000);
		       customerCreate.clickOnCustomerSaveBtn();
		       Thread.sleep(3000);
		       customerCreate.clickOnNextBtn();
		       Thread.sleep(13000);
		       customerCreate.verifyDeclineReasonNoMatch();
		     //  customerCreate.selectCustomerDeails("SmokeTest Automation");
		       customerCreate.clickOnselectBtn();
		       Thread.sleep(70000);		       
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       Thread.sleep(3000);
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);
		       newOrderInstance.selectBU("1",25, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDateFromExcel("1",25,27);
		       Thread.sleep(5000);
		       newOrderInstance.selectProductType("1",25, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",25, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",25, 3);
		       Thread.sleep(5000);
		       newOrderInstance.selectSection("1",25, 4);
		       Thread.sleep(4000);
		       //newOrderInstance.viewInsertionDetails("1");
		       //newOrderInstance.selectMaterialSource("1","NewBuild");
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           //newOrderInstance.removeSalesRepOnInsertion(1);
			   Thread.sleep(4000);				      
	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA00494");
			   Thread.sleep(4000);
			  newOrderInstance.clickOnInsertionSalesRepSection(1);
			   Thread.sleep(4000);
			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
			   Thread.sleep(2000);
		       Thread.sleep(4000);
		       newOrderInstance.addServiceRep("019411");
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(1000);		       
		       Logger.info(orderEntryPageInstance.getOrderID());
		       String orderID = orderEntryPageInstance.getOrderID();
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);	       
		       
		       orderEntryPageInstance.clickOnOrder(orderID);
		       Thread.sleep(7000);
		       
		       newOrderInstance.verifyNewCustomerButtonDisabled();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
