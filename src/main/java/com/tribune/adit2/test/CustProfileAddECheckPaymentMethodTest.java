package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tribune.adit2.Customers.HomeSearchPage;
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
* @since November 2015
*/

public class CustProfileAddECheckPaymentMethodTest 
{
	/*
	 * This test is used to add a new Echeck payment method for a customer 
	 */
	
	@Test(groups = {"CustomerProfile","Regression","Group3","addECheckPaymentMethod","TestPriority","Group3F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void addECheckPaymentMethod(Map<String, String> userData) throws Exception
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
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnCustomerModule();
		       
		       CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
		       viewCustomer.getCustomerName(userData);
		       viewCustomer.clickOnCustomersSearchBtn();
		       Thread.sleep(2000);
		       viewCustomer.clickOnCustomerLink(userData, "CustomerName");
		       
		       CustomerProfilePage customerProfile =  PageFactory.initElements(driver, CustomerProfilePage.class);
		       customerProfile.getCustomerProfile();
		       customerProfile.clickOnCreditCardsTab();
		       customerProfile.clickOnNewPaymentMethod();
		       
		       HomeSearchPage paymentMethodPage =  PageFactory.initElements(driver, HomeSearchPage.class);
		       paymentMethodPage.clickOnECheck();
		       paymentMethodPage.enterACHAccountNumber("Type2");
		       paymentMethodPage.enterConfirmACHAccountNumber("Type2");
		       paymentMethodPage.enterACHRoutingNumber("Type2");
		       paymentMethodPage.selectAccountType("ECheckAccType_Checking");
		       paymentMethodPage.enterCardECheckHoldersInfo();
		       paymentMethodPage.savePaymentDetails();
		       Thread.sleep(2000);
		       paymentMethodPage.validateECheckAddition("Type2");
		       dashboardPageInstance.clickOnLogout();
		   }
		catch(Exception e)
		{
			 Logger.error(e.getMessage());
			  throw e;
		}
	} 
}
