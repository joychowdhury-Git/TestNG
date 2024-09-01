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

public class ViewCustomerDetailsTest 
{

	/**
	 * This test will view the customer details by searching 
	 * the required customer in the customer's page
	 */
	
	@Test(groups = {"CustomerSearch","PrdSanityNew","SanityTestNew","ProductionTest","ProductionSanityTest1","Group3","viewCustomerDetails","TestPriority","ProductionTestCI"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void viewCustomerDetails(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnCustomerModule();;
		       
		       CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
		       viewCustomer.getCustomerName(userData);
//		       viewCustomer.selectBillingType("BillingType_ValuePrePaid");
		       viewCustomer.selectAccountType("AccType_Advertiser");
		       viewCustomer.selectCategory("Category_Retail");
		       viewCustomer.selectSubCategory("SubCat_Retail_Other");
		       viewCustomer.clickOnCustomersSearchBtn();
		       viewCustomer.clickOnCustomerLink(userData, "CustomerName");
		       
		       CustomerProfilePage customerProfile = PageFactory.initElements(driver, CustomerProfilePage.class);
		       customerProfile.getCustomerProfile();
		       String actualCustomerName= customerProfile.getCustomerName();
		       Assert.assertEquals(actualCustomerName, userData.get("CustomerName").toString());
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				Assert.fail();
				throw e;
		   }
	   }
}
