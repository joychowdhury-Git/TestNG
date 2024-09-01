package com.tribune.adit2.test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

/**
 * Page Class Modeling for Order Entry Home Page
 * @author Priyanka Goud CR 
 * @since January 2016
 */

public class InsrtnOrderMultiSalesRepCommissionTest 
{
	/**
	 * This test will create a new Insertion order with multiple sales person and
	 * validates the commission
	 */
	@Test(groups = {"addMultiSalesPersonIO","Grp1", "Reg1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void addMultiSalesPerson(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		      // newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",2, 0);
		       newOrderInstance.enterPubDate("1","29", "Dec", "2017");
		       newOrderInstance.selectProductType("1",2, 1);
		       newOrderInstance.selectProduct("1",2, 2);
		       newOrderInstance.selectAdType("1",2, 3);
		       newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		     //  newOrderInstance.selectMaterialSource("1","NewBuild");
		       boolean salesRepAdditionflag = false;
		       boolean salesCommFlag = false;
		       newOrderInstance.addSalesPerson("SA00012");
		       newOrderInstance.selectPrimarySalesPerson("SA00012");
		       newOrderInstance.addSalesPerson("SA00011");
		       
		       //Validate if the sales persons are added
		       List<WebElement> salesPerson = driver.findElements(By.xpath("//tr[@ng-repeat='salesperson in vm.order.SalesPersonList']"));
		       Thread.sleep(2000);
		       int countSPAfter = salesPerson.size();
		       Logger.info(countSPAfter+" sales persons are added");
		       if(countSPAfter>1)
		       {
		    	   salesRepAdditionflag = true;
		       }
		       //validate the commission for the sales persons added
		       newOrderInstance.getSalesPersonComm("SA00011");
		       newOrderInstance.getSalesPersonComm("SA00012");
		       salesCommFlag = newOrderInstance.validateSalesPersonComm();
		       Assert.assertEquals(true, salesRepAdditionflag);
		       Assert.assertEquals(true, salesCommFlag);
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
