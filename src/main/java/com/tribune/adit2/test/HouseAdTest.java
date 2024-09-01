package com.tribune.adit2.test;

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


public class HouseAdTest 
{
	/**
	 * This test will create a new HFO order that's free
	 */
	@Test(groups = {"Order","houseAdMakeOrderFree"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void makeOrderFree(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00560930");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_HouseAd");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",23, 0);
		       newOrderInstance.enterPubDate("1","29", "Dec", "2017");
		       newOrderInstance.selectProductType("1",23, 1);
		       newOrderInstance.selectProduct("1",23, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",23, 3);
		       newOrderInstance.selectSection("1",23, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       Logger.info("Insertion Price = "+newOrderInstance.getInsertionPrice("1", "total"));
		       newOrderInstance.getTotalOrderPrice();
		       Assert.assertEquals(newOrderInstance.getInsertionPrice("1", "total"), TribuneUtils.getDoubleCellValues("Product", 23, 17), 0);
		       Assert.assertEquals(newOrderInstance.getTotalOrderPrice(), TribuneUtils.getDoubleCellValues("Product", 23, 17), 0);
		       newOrderInstance.addSalesPerson(TribuneUtils.getStringCellValues("Sales", 1, 2));
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, TribuneUtils.getStringCellValues("Sales", 1, 2));
		       Thread.sleep(2000);
		       newOrderInstance.submitOrder();
		       newOrderInstance.confirmToMakeOrderFree();
		       Assert.assertEquals(newOrderInstance.getTotalOrderPrice(), TribuneUtils.getDoubleCellValues("Product", 23, 22), 0);
		       Thread.sleep(1000);
		       String orderID = orderEntryPageInstance.getOrderID();
		       Logger.info("OrderID "+orderID);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(1000);
		       orderEntryPageInstance.clickOnOrder(orderID);
		       Assert.assertEquals(newOrderInstance.getTotalOrderPrice(), TribuneUtils.getDoubleCellValues("Product", 23, 22), 0);
		       Assert.assertEquals(newOrderInstance.getInsertionPrice("1", "total"), TribuneUtils.getDoubleCellValues("Product", 23, 22), 0);
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"Order","testADSS"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void testADSS(Map<String, String> userData) throws Exception
	{
		try
		   {
			   WebDriver driver = WebDriverManager.getDriver();
			   Logger.info("Webdriver is initiated");
			   
			   TribuneUtils utilities = new TribuneUtils();
		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
		       utilities.implementWait(driver);
		       
		       Thread.sleep(20000);
		       
		       WebElement signIn = driver.findElement(By.xpath("//*[@id='sslUser']/div/a[1]"));
		 	  try{
		 		  if(signIn.isDisplayed()){
		 			 signIn.click();
		 				  Logger.info("Sign In Clicked");
		 				 Thread.sleep(20000);
		 			  }

		 	  }
		 	  catch(Exception e)
		 	  {
		 		  Logger.info("Sign in not clicked");
		 	  }
		       
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
