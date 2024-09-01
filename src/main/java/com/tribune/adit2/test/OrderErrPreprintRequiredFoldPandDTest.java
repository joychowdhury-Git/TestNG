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
 * @since February 2016
 */

public class OrderErrPreprintRequiredFoldPandDTest 
{
	/* This test creates a new Insertion Order for a preprint product type
	 *  by selecting "P&D Combined Rate" type and also "P&D Split Rate" type in separate instances
	 */
	@Test(groups = {"orderPreprintMandFold","ErrorValidations2", "Reg1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void orderPreprintMandFold(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectSoldToCustomerBU("bu_TBS");
		       newOrderInstance.enterSoldToCustomer("CU00380012");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",10, 0);
		       newOrderInstance.enterPubDate("1","29", "Dec", "2017");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",10, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",10, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",10, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",10, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.clickOnDistributions(1);
		       
		       Thread.sleep(14000);
		       newOrderInstance.selectZonePreprintOrder("Full");
		       newOrderInstance.confirmZoneSelection();
		      
		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
		       Thread.sleep(1000);
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       newOrderInstance.clickOnPAndDTab();
		       Thread.sleep(1000);
		       newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_CentralStudio");
		       Thread.sleep(4000);
		       newOrderInstance.clickonApplyAllInsertions();
		       Thread.sleep(4000);
		       //newOrderInstance.clickonApplyAllInsertions();
		       newOrderInstance.submitOrder();
		       newOrderInstance.displayErrorMessage();
		       WebElement msgElement1 = newOrderInstance.errorMessage.get(0);
		       int index = msgElement1.getText().indexOf("-");
		       Logger.info(""+index);
		       String insertionDetail1 = msgElement1.getText().substring(38, 43);
		       String actualErrMsg1 = msgElement1.getText().replaceFirst(insertionDetail1, "");
		       String expectedErrMsg1 = userData.get("ErrRequiredFold");
		       boolean flag1 = false;
		       Logger.info("actualErrMsg1:"+actualErrMsg1);
		       Logger.info("expectedErrMsg1"+expectedErrMsg1);
		       if(actualErrMsg1.equalsIgnoreCase(expectedErrMsg1))
		       {
		    	   flag1 = true;
		    	   Logger.info("Validation success - correct error message is displayed");
		       }
		       Assert.assertEquals(flag1, true);
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
