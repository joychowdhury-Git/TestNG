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
 * @since December 2015
 */

public class OrderErrMandatorySoldToTest 
{
	/*This test tries to create a general order without sold to customer and 
	* validates if the error message is displayed and it matches the expected message 
	* */
	@Test(groups = {"ErrorValidations", "Regression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void OrderErrVldtnSoldTo(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectBillToCustomerBU("bu_LAT");
		       newOrderInstance.enterBillToCustomer("CU00059747");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		      // newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.addSalesPerson("SA00011");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",2, 0);
		       newOrderInstance.enterPubDate("1","31", "Dec", "2017");
		       newOrderInstance.selectProductType("1",2, 1);
		       newOrderInstance.selectProduct("1",2, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",2, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.selectMaterialSource("1","NewBuild");
		       Thread.sleep(3000);
		       newOrderInstance.submitOrder();
		       newOrderInstance.displayErrorMessage();
		       newOrderInstance.compareErrorMessageSingleErr(userData, "MandatorySoldTo");
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
