package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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

public class OrderErrProspectSoldToTest 
{
	/*This test tries to create a general order with a prospect Sold to customer and 
	* validates if the error message is displayed and it matches the expected message 
	* */
	@Test(groups = {"ErrorValidations", "RegressionLatest","Grp1", "OrderErrProspectSoldToTest","Group3","RegFailed4"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void OrderErrVldtnBillTo(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectSoldToCustomerBU("bu_All");
		       newOrderInstance.enterSoldToCustomer("Edward Blanks");
		       newOrderInstance.selectBillToCustomerBU("bu_LAT");
		       newOrderInstance.enterBillToCustomer("CU00059747");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		      // newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",2, 0);
		       newOrderInstance.enterPubDate("1","28", "Dec", "2019");
		       newOrderInstance.selectProductType("1",2, 1);
		       newOrderInstance.selectProduct("1",2, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",2, 3);
		       newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(2000);
		       newOrderInstance.viewInsertionDetails("1");
		    //   newOrderInstance.selectMaterialSource("1","NewBuild");
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
		       //newOrderInstance.addSalesPerson("SA00011");
		       Thread.sleep(2000);
		       Thread.sleep(4000);
		       newOrderInstance.addServiceRep("034107");
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(4000);
		       newOrderInstance.displayErrorMessage();
		       newOrderInstance.compareErrorMessageSingleErr(userData, "ProspectSoldToCustNewOrder");
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
