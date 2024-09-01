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

/**
 * Page Class Modeling for Order Entry Home Page
 * @author Priyanka Goud CR 
 * @since January 2016
 */

public class OrderErrMandatoryPositionTempTest 
{
	/*This test tries to create a insertion order of display product type with a fixed inventory 
	 * */
	@Test(groups = {"ErrorValidations","Regression", "RegressionLatest","Grp1", "OrderErrMandatoryPositionTempTest","Group3","TestPriority"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
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
		       newOrderInstance.selectSoldToCustomerBU("bu_DPR");
		       newOrderInstance.enterSoldToCustomer("CU00013249");
		       newOrderInstance.selectBillToCustomerBU("bu_DPR");
		       newOrderInstance.enterBillToCustomer("CU00013249");
		       Thread.sleep(2000);
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       Thread.sleep(2000);
		      // newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(2000);
		       newOrderInstance.selectBU("1",1, 0);
		       Thread.sleep(2000);
		       newOrderInstance.enterPubDate("1","20", "Dec", "2019");
		       Thread.sleep(2000);
		       newOrderInstance.selectProductType("1",1, 1);
		       Thread.sleep(2000);
		       newOrderInstance.selectProduct("1",1, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",1, 3);
		       Thread.sleep(2000);
		    //   newOrderInstance.selectSection("1",1, 4);
		       Thread.sleep(2000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(2000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(7000);
		       newOrderInstance.displayErrorMessage();
		       String [] errorMsgs = {  userData.get("MandatoryPositionTemp")};
		       Assert.assertEquals(newOrderInstance.compareErrorMsgMultiErr(errorMsgs), true);
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
