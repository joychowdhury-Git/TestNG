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
 * @since January 2016
 */

public class InsrtnPreprintOrderRefreshDrawTest 
{
	/**
	 * This test will create a new insertion order for a preprint product type 
	 * with multiple distributions selected in the insertion
	 */
	@Test(groups = {"InsertionOrder" ,"ioPreprintBrowseSelectZone1", "ioPreprintRefreshDraw", "Reg1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ioPreprintRefreshDraw(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectBU("1",10, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2017");
		       newOrderInstance.selectProductType("1",10, 1);
		       newOrderInstance.selectProduct("1",10, 2);
		       Thread.sleep(3000);
		       newOrderInstance.selectAdType("1",10, 3);
		       Thread.sleep(10000);
		       newOrderInstance.selectSection("1",10, 4);
		       Thread.sleep(8000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		     //  newOrderInstance.selectMaterialSource("1","N/A");
		       newOrderInstance.clickOnDistributions(1);
		       Thread.sleep(4000);
		       newOrderInstance.clickOnSearchZoneLink();
		       Thread.sleep(3000);
		       newOrderInstance.selectZonePreprintOrder("90001SC");
		       int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
		       newOrderInstance.confirmZoneSelection();	
		       int distributionsCount = newOrderInstance.getDistributionsAdded();
		       Logger.info("distributionsCount "+distributionsCount);
		       Thread.sleep(2000);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("2",10, 0);
		       newOrderInstance.enterPubDate("2","29", "Dec", "2017");
		       newOrderInstance.selectProductType("2",10, 1);
		       newOrderInstance.selectProduct("2",10, 2);
		       Thread.sleep(3000);
		       newOrderInstance.selectAdType("2",10, 3);
		       Thread.sleep(10000);
		       newOrderInstance.selectSection("2",10, 4);
		       Thread.sleep(8000);
		       newOrderInstance.viewInsertionDetails("2");
		       newOrderInstance.addOrEditInsersionVerisonID("2", 2);
		       newOrderInstance.selectMaterialSource("2","N/A");
		       newOrderInstance.clickOnDistributions(2);
		       Thread.sleep(4000);
		       newOrderInstance.clickOnSearchZoneLink();
		       Thread.sleep(3000);
		       newOrderInstance.selectZonePreprintOrder("90002SC");
		       int countOfZoneAssigned1 = newOrderInstance.getAssignedZonesCount();
		       newOrderInstance.confirmZoneSelection();	
		       int distributionsCount1 = newOrderInstance.getDistributionsAdded();
		       Logger.info("distributionsCount "+distributionsCount1);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","30", "Nov", "2017");
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("2","29", "Nov", "2017");
		       Thread.sleep(8000);
		       newOrderInstance.clickRefreshDraw();
		       Thread.sleep(2000);
		       newOrderInstance.comparePartialMessage("Distribution Updated");
		       Thread.sleep(4000);
		       
		       newOrderInstance.submitOrder();
		       Thread.sleep(2000);
		       Logger.info(orderEntryPageInstance.getOrderID());
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
