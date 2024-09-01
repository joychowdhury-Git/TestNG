package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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
 * @since November 2015
 */

public class CustProfileSearchEditProductPricingTest 
{
	/**
	 * This test is used to edit the default pricing group for a specific product
	 * in pricing groups tab of Customer profile 
	 */
	@Test(groups = {"CustomerProfile", "Regression", "RegressionLatest","Grp1", "productPricingGroup","Group3","NewRegression","NewRegression1", "customerAdminCreation"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void productPricingGroup(Map<String, String> userData) throws Exception
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
		       
		       CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
		       viewCustomer.getCustomerName(userData);
		       viewCustomer.clickOnCustomersSearchBtn();
		       Thread.sleep(3000);
		       viewCustomer.clickOnCustomerLink(userData, "CustomerName");
		       //Thread.sleep(10000);
		       
		       CustomerProfilePage customerProfile =  PageFactory.initElements(driver, CustomerProfilePage.class);
		       customerProfile.getCustomerProfile();
		       customerProfile.clickOnPricingGroupsTab();
		       //Thread.sleep(2000);
		       customerProfile.selectBusinessUnit("BU_CTC");
		       customerProfile.searchAndEditProductPricing("Fin De Semana ", "National Platinum");
		       
		       //Validate if the correct product is searched and edited
		       
		       dashboardPageInstance.clickondropdownforlogout(); //joy
		   }
		catch(Exception e)
		{
			 Logger.error(e.getMessage());
			  throw e;
		}
	}
}
