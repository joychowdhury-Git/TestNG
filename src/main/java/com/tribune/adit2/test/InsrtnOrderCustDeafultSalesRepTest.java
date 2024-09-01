package com.tribune.adit2.test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

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
 * @since February 2016
 */

public class InsrtnOrderCustDeafultSalesRepTest 
{
	/**
	 * This test will click on the new insertion button and enters the sold to customer
	 * Validation is done on the default sales representative added for the order
	 */
	@Test(groups = {"InsertionOrder"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void custDefaultSalesRep(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewInsertionOrderBtn();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       Thread.sleep(2000);
		       List<WebElement> salesPerson = driver.findElements(By.xpath("//tr[@ng-repeat='salesperson in vm.order.SalesPersonList']"));
		       Thread.sleep(2000);
		       int countSPAfter = salesPerson.size();
		       Logger.info(countSPAfter+" sales persons are added");
		       boolean flag = false;
		       if(countSPAfter>0)
		       {
		    	   flag = true;
		       }
		       Assert.assertEquals(flag,true);
		       Assert.assertEquals(newOrderInstance.validateSaleRepAdded(1, 2, 3), true);
		       
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
