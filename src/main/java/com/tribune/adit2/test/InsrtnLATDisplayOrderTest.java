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

/**
 * Page Class Modeling for Order Entry Home Page
 * @author Priyanka Goud CR 
 * @since December 2015
 */

public class InsrtnLATDisplayOrderTest 
{
	/**
	 * This test will create a new insertion order for a display product type
	 */
	@Test(groups = {"InsertionOrder","SanityTestNew","ProductionTest", "CheckIO","PrdSanityNew","ProductionSanityTest1","insertionDisplayOrder","Group3","TestPriority","Group3F","ProductionTestCI"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void insertionDisplayOrder(Map<String, String> userData) throws Exception
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
		       newOrderInstance.enterComments();
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",2, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDateFromExcel("1",85,27);
		       //newOrderInstance.validateListOfProductTypes("1");
		       Thread.sleep(2000);
		       newOrderInstance.selectProductType("1",2, 1);
		       Thread.sleep(2000);
		       newOrderInstance.selectProduct("1",2, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",2, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           //newOrderInstance.removeSalesRepOnInsertion(1);
			   Thread.sleep(4000);				      
	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			   Thread.sleep(4000);
			  newOrderInstance.clickOnInsertionSalesRepSection(1);
			 //  Thread.sleep(4000);
			  // newOrderInstance.applytoAllSalesRepOnInsertion(1);
			   //Thread.sleep(2000);//swagata
		       //Thread.sleep(4000);//swagata
		      // newOrderInstance.viewInsertionDetails("1");//swagata
		      // newOrderInstance.selectMaterialSource("1","NewBuild");
		       newOrderInstance.submitOrder();//swagata
		       Thread.sleep(3000);
		      Logger.info("Submitted IO no. is:"+orderEntryPageInstance.getOrderID());//swagata
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
