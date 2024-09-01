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

public class OrderErrPreprintRequiredCreativeLocPandDTest 
{
	/* This test creates a new Insertion Order for a preprint product type
	 *  by selecting "P&D Combined Rate" type and also "P&D Split Rate" type in separate instances
	 */
	@Test(groups = {"ErrorValidations2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void orderPreprintMandCreativeLoc(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",10, 0);
		       newOrderInstance.enterPubDate("1","20", "Apr", "2016");
		       newOrderInstance.selectProductType("1",10, 1);
		       newOrderInstance.selectProduct("1",10, 2);
		       newOrderInstance.selectAdType("1",10, 3);
		       newOrderInstance.selectSection("1",10, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.clickOnDistributions(1);
		       newOrderInstance.clickOnSearchZoneLink();
		       newOrderInstance.selectZonePreprintOrder("90002");
		       Logger.info("countOfZonesAssigned "+newOrderInstance.getAssignedZonesCount());
		       int countOfZoneAssigned1 = newOrderInstance.getAssignedZonesCount();
		       Logger.info("countOfZonesAssigned "+countOfZoneAssigned1);
		       newOrderInstance.confirmZoneSelection();
		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
		       Thread.sleep(1000);
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       newOrderInstance.clickOnPAndDTab();
		       Thread.sleep(1000);
		       newOrderInstance.selectPandDFold("1", "PP_Fold_HalfFold");
		       newOrderInstance.submitOrder();
		       newOrderInstance.displayErrorMessage();
		       WebElement msgElement1 = newOrderInstance.errorMessage.get(0);
		       int index = msgElement1.getText().indexOf("-");
		       Logger.info(""+index);
		       String insertionDetail1 = msgElement1.getText().substring(50, 55);
		       String actualErrMsg1 = msgElement1.getText().replaceFirst(insertionDetail1, "");
		       String expectedErrMsg1 = userData.get("ErrRequiredCreativeLoc");
		       boolean flag1 = false;
		       if(actualErrMsg1.equalsIgnoreCase(expectedErrMsg1))
		       {
		    	   flag1 = true;
		    	   Logger.info("Validation success - correct error message is displayed");
		       }
		       Assert.assertEquals(flag1, true);
		       driver.navigate().refresh();
		       newOrderInstance.selectSoldToCustomerBU("bu_TBS");
		       newOrderInstance.enterSoldToCustomer("CU00380012");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",10, 0);
		       newOrderInstance.enterPubDate("1","20", "Apr", "2016");
		       newOrderInstance.selectProductType("1",10, 1);
		       newOrderInstance.selectProduct("1",10, 2);
		       newOrderInstance.selectAdType("1",10, 3);
		       newOrderInstance.selectSection("1",10, 4);
		       Thread.sleep(4000);
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.clickOnDistributions(1);
		       newOrderInstance.clickOnSearchZoneLink();
		       newOrderInstance.selectZonePreprintOrder("90002");
		       Logger.info("countOfZonesAssigned "+newOrderInstance.getAssignedZonesCount());
		       int countOfZoneAssigned2 = newOrderInstance.getAssignedZonesCount();
		       Logger.info("countOfZonesAssigned "+countOfZoneAssigned2);
		       newOrderInstance.confirmZoneSelection();
		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDSplit");
		       Thread.sleep(1000);
		       newOrderInstance.clickOnPAndDTab();
		       Thread.sleep(1000);
		       newOrderInstance.submitOrder();
		       newOrderInstance.displayErrorMessage();
		       WebElement msgElement2 = newOrderInstance.errorMessage.get(0);
		       String insertionDetail2 = msgElement2.getText().substring(32, 37);
		       String actualErrMsg2 = msgElement2.getText().replaceFirst(insertionDetail2, "");
		       Logger.info(actualErrMsg2);
		       String expectedErrMsg2 = userData.get("ErrRequiredCreativeLoc");
		       Logger.info(expectedErrMsg2);
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
