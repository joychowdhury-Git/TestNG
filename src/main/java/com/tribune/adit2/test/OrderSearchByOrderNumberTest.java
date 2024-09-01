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
 * @since October 2015
 */

public class OrderSearchByOrderNumberTest 
{
	/**
	 * This test performs a search operation based on order number 
	 */
	@Test(groups = {"orderSearchByOrderNumber","Regression","ProductionTest","Group3","PTest1","ProductionTestCI"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void orderSearchByOrderNumber(Map<String, String> userData) throws Exception
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
		       
		       OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       basicOrderSearch.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_CTC");
		       newOrderInstance.enterSoldToCustomer("CU00037236");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",15, 0);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2019");
		       Thread.sleep(3000);
		       newOrderInstance.selectProductType("1",15, 1);
		       Thread.sleep(3000);
		       newOrderInstance.selectProduct("1",15, 2);
		       Thread.sleep(3000);
		       newOrderInstance.selectAdType("1",15, 3);
		       Thread.sleep(2000);
		      // newOrderInstance.selectSection("1",15, 4);
		       Thread.sleep(4000);
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       newOrderInstance.viewInsertionDetails("1");
		      // newOrderInstance.selectMaterialSource("1","N/A");
		       //newOrderInstance.selectPageType("1", "PP_PaperType_Broadsheet");
		       newOrderInstance.checkUncheckBillQty(false);
		       newOrderInstance.enterBilledQty(2);
		      /* newOrderInstance.clickOnDistributions();
		       Thread.sleep(4000);
		       newOrderInstance.clickOnSearchZoneLink();
		       Thread.sleep(3000);
		       newOrderInstance.selectZonePreprintOrder("90001SC");
		       newOrderInstance.getAssignedZonesCount();
		       newOrderInstance.confirmZoneSelection();	*/
		       Thread.sleep(2000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(1000);
		       String orderNum = basicOrderSearch.getOrderID();
		       basicOrderSearch.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
		       WebDriverWait wait = new WebDriverWait(driver,20);
		       wait.until(ExpectedConditions.visibilityOfAllElements(list));
		       basicOrderSearch.enterOrderNumber(orderNum);
		       basicOrderSearch.clickOnOrderSearchBtn();
		       Thread.sleep(4000);
		       
		       //Verify the results
		       WebElement orderNumberLink = driver.findElement(By.xpath("//a[text()='"+orderNum+"']"));
		       wait.until(ExpectedConditions.visibilityOf(orderNumberLink));
		       if(orderNumberLink.isDisplayed())
		       {
		    	   Assert.assertTrue(true);
		    	   Logger.info(orderNum+ " order search result validated successfully");
		       }
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
}
