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
 * @since February 2016
 */

public class InsrtnHTFPreprintOrderTest 
{
	/**
	 * This test will create a new insertion order for a preprint product type 
	 * with multiple distributions selected in the insertion under HTF business unit
	 * 
	 */
	@Test(groups = {"SMaintenance","createHTFPreprintOrder", "RegressionLatest","Grp1", "Reg1","Group3","TestPriority","Group3F","NewRegression1","NewRegression","G3","RerunF2", "insertionOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createHTFPreprintOrder(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectSoldToCustomerBU("bu_HTF");
		       newOrderInstance.enterSoldToCustomer("CU00250481");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",14, 0);
		       Thread.sleep(4000);
		       //newOrderInstance.enterPubDate("1","23", "Dec", "2020");//Joy
		       //Thread.sleep(3000);
		       newOrderInstance.selectProductType("1",14, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",14, 2);
		       Thread.sleep(5000);//mou
		       newOrderInstance.selectAdType("1",14, 3);
		       Thread.sleep(4000);
		       //newOrderInstance.selectSection("1",14, 4);//Joy
		       //Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		     //  newOrderInstance.selectMaterialSource("1","N/A");
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       Thread.sleep(2000);
		       newOrderInstance.selectPageType("1", "PP_PaperType_Broadsheet");
		       Thread.sleep(2000);
		       newOrderInstance.checkUncheckBillQty(false);
		       Thread.sleep(2000);
		       newOrderInstance.enterBilledQty(3);
		       Thread.sleep(2000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           //newOrderInstance.removeSalesRepOnInsertion(1);
			   Thread.sleep(4000);				      
	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			   Thread.sleep(4000);
			  newOrderInstance.clickOnInsertionSalesRepSection(1);
			   Thread.sleep(4000);
			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
			   Thread.sleep(2000);
		       
		      // newOrderInstance.submitOrder();
			   newOrderInstance.ClickSubmitButton();//Joy
		      /* Thread.sleep(4000);
		       String orderID = orderEntryPageInstance.getOrderNumber();
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(1000);
		       orderEntryPageInstance.clickOnOrder(orderID);		     
		       //Thread.sleep(3000);
		       //dashboardPageInstance.clickOnLogout();*/
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
