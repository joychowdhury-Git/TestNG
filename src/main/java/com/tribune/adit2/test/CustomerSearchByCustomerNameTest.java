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

public class CustomerSearchByCustomerNameTest 
{

	/**
	 * This test perform a search operation on customers by customer name
	 */
	
	@Test(groups = {"CustomerSearch1","Regression","ProductionTest","Group3","ProductionSanityTest1","ProductionTestCI","customerSearchByName22"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void customerSearchByName(Map<String, String> userData) throws Exception
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
		       customerSearchPage.getCustomerName(userData);
		       customerSearchPage.clickOnCustomersSearchBtn();
		       
		    // Verifying if the correct customer results are searched
		      WebElement customerNameResults = driver.findElement(By.linkText(userData.get("CustomerName").toString()));
		      WebDriverWait wait = new WebDriverWait(driver,120); 
		      wait.until(ExpectedConditions.visibilityOf(customerNameResults));
		      
		      String numberOfResults = customerSearchPage.getCountOfCustomerSearchResults();
		      Logger.info("count of the total results found : " +numberOfResults);
		      String getCustomerName = customerNameResults.getText();
		      Assert.assertEquals(getCustomerName, userData.get("CustomerName").toString());
		      
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
