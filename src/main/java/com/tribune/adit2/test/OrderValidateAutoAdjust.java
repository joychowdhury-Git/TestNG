package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.WebDriver;
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

public class OrderValidateAutoAdjust 
{
	/**
	 * This test will create a new order of standard type
	 */
	@Test(groups = {"Order","editSalesValidateAutoAdjust"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void editSalesValidateAutoAdjust(Map<String, String> userData) throws Exception
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
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",2, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2017");
		       newOrderInstance.selectProductType("1",2, 1);
		       newOrderInstance.selectProduct("1",2, 2);
		       newOrderInstance.selectAdType("1",2, 3);
		       newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.selectMaterialSource("1","NewBuild");
		       newOrderInstance.checkUncheckSalesPrice(1,true);
		       String autoAdjustPriceBeforeEdit = newOrderInstance.getAutoAdjustPrice();
		       String autoAdjustPercentBeforeEdit = newOrderInstance.getAutoAdjustPercentage();
		       newOrderInstance.editSalesPrice("290.41",1);
		       String autoAdjustPriceAfterEdit = newOrderInstance.getAutoAdjustPrice();
		       Logger.info(autoAdjustPriceAfterEdit);
		       String autoAdjustPercentAfterEdit = newOrderInstance.getAutoAdjustPercentage();
		       Logger.info(autoAdjustPercentAfterEdit);
		       boolean priceFlag = false;
		       boolean percentFlag = false;
		       boolean salesPriceFlag = false;
		       boolean salesPriceAAPFlag = false;
		       if(!autoAdjustPriceBeforeEdit.contentEquals(autoAdjustPriceAfterEdit))
		       {
		    	   Logger.info("Validation Success - Auto adjust price is changed with Sales price");
		    	   priceFlag = true;
		       }
		       if(!autoAdjustPercentBeforeEdit.contentEquals(autoAdjustPercentAfterEdit))
		       {
		    	   Logger.info("Validation Success - Auto adjust percentage is changed with Sales price");
		    	   percentFlag = true;
		       }
		       double price = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("Total price of the order placed is "+price);
		       Assert.assertEquals(priceFlag, true);
		       Assert.assertEquals(percentFlag, true);
		       double salesPriceBeforeEdit = newOrderInstance.getInsertionPrice("1","sales");
		       newOrderInstance.editAutoAdjustPrice("1","1");
		       double salesPriceAfterEdit = newOrderInstance.getInsertionPrice("1","sales");
		       if(salesPriceBeforeEdit!=salesPriceAfterEdit)
		       {
		    	   Logger.info("Validation Success - sales price is updated along with auto adjust price");
		    	   salesPriceFlag =true;
		       }
		       Assert.assertEquals(salesPriceFlag, true);
		       newOrderInstance.editAutoAdjustPercent(1);
		       double salesPriceAfterAAPEdit = newOrderInstance.getInsertionPrice("1","sales");
		       if(salesPriceAfterEdit!=salesPriceAfterAAPEdit)
		       {
		    	   Logger.info("sales price is updated along with auto adjust percent");
		    	   salesPriceAAPFlag =true;
		       }
		       Assert.assertEquals(salesPriceAAPFlag, true);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       orderEntryPageInstance.getOrderID();
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
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
