package com.tribune.adit2.test;

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
import com.tribune.adit2.Customers.CustomerProfilePage;
import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Order Entry Home Page
 * @author Priyanka Goud CR 
 * @since October 2015
 */

public class CustomerInactivate 
{

	/**
	 * This test perform a search operation on customers by customer name
	 */
	
	@Test(groups = {"customerInactivateDeleteCCPA","RegressionS49","NewRegression3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void customerInactivateDeleteCCPA(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnCustomerModule();
		       
		       CustomerPage customerSearchPage = PageFactory.initElements(driver, CustomerPage.class);
		       customerSearchPage.setCustomerName(2, 0);
		       customerSearchPage.clickOnCustomersSearchBtn();
		       
		    // Verifying if the correct customer results are searched
		      WebElement customerNameResults = driver.findElement(By.partialLinkText("Auto"));
		      WebDriverWait wait = new WebDriverWait(driver,120); 
		      wait.until(ExpectedConditions.visibilityOf(customerNameResults));
		      
		      String numberOfResults = customerSearchPage.getCountOfCustomerSearchResults();
		      Logger.info("count of the total results found : " +numberOfResults);
		      String getCustomerName = customerNameResults.getText();
		      Logger.info("searched customer name: " +getCustomerName+ " with length: "+getCustomerName.length());
		      Assert.assertEquals(getCustomerName.length(), 20);
		      WebElement customerName1 = driver.findElement(By.linkText(getCustomerName));
		      customerName1.click();
		      customerSearchPage.deleteCCPA();
		      customerSearchPage.verifyCustomerInactivated();
		    //  dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				Assert.fail();
				throw e;
		   }
	   }
	/*
	 * Activate/Deactivate a customer address
	 *///swagata
	@Test(groups = { "SMaintenance","CustRegression","customerActiveInactive","NewRegression3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData", invocationCount = 1)
	public void customerActiveInactive(Map<String, String> userData) throws Exception {
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
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("Invoice");
			customerCreate.enteraddressTextBox("1 North Trusel Street");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Orlando");
			customerCreate.selectState("Florida");
			customerCreate.enterzipCodeTextBox("32310");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3125544444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("tes123@tronc.com");
			customerCreate.enteradditionalEmailTextBox("test@test.com");
			customerCreate.clickOnSaveBtn();
			Thread.sleep(5000);
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(6000);
			customerCreate.clickOnNextBtn();
			//Thread.sleep(70000);
			customerCreate.clickOnselectBtn();
			//Thread.sleep(50000);

			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);
			profileCustomer.getCustomerID();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber());

			Assert.assertEquals(str + " Auto", profileCustomer.getCustomerName());
			//partha
			
			customerCreate.clickToDeactivateAddress();//getting null value issue
			customerCreate.clickToactivateAddress();


			dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
