package com.tribune.adit2.test;

import java.util.Map;

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
 * @since January 2016
 */

public class OrderErrPreprintMandatoryPAndDTest 
{
	/* This test creates a new Insertion Order for a preprint product type
	 *  by selecting "P&D Combined Rate" type and also "P&D Split Rate" type in separate instances
	 */
	@Test(groups = {"ErrorValidations","Regression","orderPreprintMandPandD", "1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void orderPreprintMandPandD(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectBU("1",10, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2017");
		       newOrderInstance.selectProductType("1",10, 1);
		       newOrderInstance.selectProduct("1",10, 2);
		       newOrderInstance.selectAdType("1",10, 3);
		       newOrderInstance.selectSection("1",10, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
		       //newOrderInstance.enterBilledQty(2);
		       Thread.sleep(1000);
		       newOrderInstance.clickOnDistributions(1);
		       Thread.sleep(4000);
		       newOrderInstance.clickOnSearchZoneLink();
		       newOrderInstance.selectZonePreprintOrder("90001SC");
		       Logger.info("countOfZonesAssigned "+newOrderInstance.getAssignedZonesCount());
		       newOrderInstance.confirmZoneSelection();
		       
		       //newOrderInstance.addSalesPerson("SA00011");
		       newOrderInstance.submitOrder();
		       newOrderInstance.displayErrorMessage();
		       WebElement msgElement1 = newOrderInstance.errorMessage.get(0);
		       String insertionDetail1 = msgElement1.getText().substring(32, 37);
		       String actualErrMsg1 = msgElement1.getText().replaceFirst(insertionDetail1, "");
		       String expectedErrMsg1 = userData.get("ErrWithoutPandDSpec");
		       boolean flag1 = false;
		       if(actualErrMsg1.equalsIgnoreCase(expectedErrMsg1))
		       {
		    	   flag1 = true;
		    	   Logger.info("Validation success - correct error message is displayed");
		       }
		       Assert.assertEquals(flag1, true);
		       driver.navigate().refresh();
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		      // newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",10, 0);
		       newOrderInstance.enterPubDate("1","29", "Dec", "2017");
		       newOrderInstance.selectProductType("1",10, 1);
		       newOrderInstance.selectProduct("1",10, 2);
		       newOrderInstance.selectAdType("1",10, 3);
		       newOrderInstance.selectSection("1",10, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDSplit");
		       Thread.sleep(1000);
		       newOrderInstance.clickOnDistributions(1);
		       Thread.sleep(4000);
		       newOrderInstance.clickOnSearchZoneLink();
		       newOrderInstance.selectZonePreprintOrder("90001SC");
		       Logger.info("countOfZonesAssigned "+newOrderInstance.getAssignedZonesCount());
		       newOrderInstance.confirmZoneSelection();
		       //newOrderInstance.addSalesPerson("SA00011");
		       newOrderInstance.submitOrder();
		       newOrderInstance.displayErrorMessage();
		       WebElement msgElement2 = newOrderInstance.errorMessage.get(0);
		       String insertionDetail2 = msgElement2.getText().substring(32, 37);
		       String actualErrMsg2 = msgElement2.getText().replaceFirst(insertionDetail2, "");
		       String expectedErrMsg2 = userData.get("ErrWithoutPandDSpec");
		       boolean flag2 = false;
		       if(actualErrMsg2.equalsIgnoreCase(expectedErrMsg2))
		       {
		    	   flag2= true;
		    	   Logger.info("Validation success - correct error message is displayed");
		       }
		       Assert.assertEquals(flag2, true);
		       driver.navigate().refresh();
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
