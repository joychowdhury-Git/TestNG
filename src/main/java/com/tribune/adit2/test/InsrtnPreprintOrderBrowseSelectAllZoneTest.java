package com.tribune.adit2.test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class InsrtnPreprintOrderBrowseSelectAllZoneTest 
{
	/**
	 * This test will create a new insertion order for a preprint product type 
	 * with multiple distributions selected in the insertion
	 */
	@Test(groups = {"InsertionOrder","1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ioPreprintBrowseSelectAllZone(Map<String, String> userData) throws Exception
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
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",10, 0);
		       newOrderInstance.enterPubDate("1","26", "Dec", "2017");
		       Thread.sleep(2000);
		       newOrderInstance.selectProductType("1",10, 1);
		       newOrderInstance.selectProduct("1",10, 2);
		       Thread.sleep(1000);
		       newOrderInstance.selectAdType("1",10, 3);
		       newOrderInstance.selectSection("1",10, 4);
		       Thread.sleep(4000);
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.selectMaterialSource("1","N/A");
		       newOrderInstance.selectPageType("1", "PP_PaperType_Broadsheet");
		       newOrderInstance.clickOnDistributions(1);
		       Thread.sleep(3000);
		       newOrderInstance.clickOnSearchZoneLink();
		       newOrderInstance.selectZonePreprintOrder("90002D1");
		       Logger.info("countOfZonesAssigned "+newOrderInstance.getAssignedZonesCount());
		       newOrderInstance.cancelZoneSelection();
		       newOrderInstance.clickOnDistributions(1);
		       Thread.sleep(3000);
		       newOrderInstance.clickOnSearchZoneLink();
		       Thread.sleep(3000);
		       int totalDistributions = newOrderInstance.getTotalDistributionOnList();
		       Logger.info("totalDistributions "+totalDistributions);
		       newOrderInstance.selectAllZones();
		       int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
		       Logger.info("countOfZonesAssigned "+countOfZoneAssigned);
		       newOrderInstance.confirmZoneSelection();
		       newOrderInstance.checkUncheckBillQty(false);
		       newOrderInstance.enterBilledQty(3);
		       Thread.sleep(1000);
		       int distributionsCount = newOrderInstance.getDistributionsAdded();
		       Logger.info("distributionsCount "+distributionsCount);
		       Assert.assertEquals(distributionsCount, countOfZoneAssigned);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
		       //Assert.assertEquals(totalDistributions, countOfZoneAssigned);
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
