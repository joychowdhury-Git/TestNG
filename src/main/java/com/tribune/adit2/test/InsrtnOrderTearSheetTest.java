package com.tribune.adit2.test;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.tribune.adit2.OrderEntry.OrderNewTearsheetProofPage;
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

public class InsrtnOrderTearSheetTest 
{
	/**
	 * This test create a new tearsheet for an order, 
	 * edit it and delete the tearsheet
	 */
	@Test(groups = {"NovMaintenance","orderTearSheet","InsertionOrderTearSheet", "RegressionLatest","Grp1", "Reg1","Group3","TestPriority","Group3F","NewRegression","NewRegression1","G3","RerunF2", "insertionOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void orderTearSheet(Map<String, String> userData) throws Exception
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
		       WebDriverWait wait = new WebDriverWait(driver,120);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",2, 0);
		       newOrderInstance.enterPubDate("1","23", "Dec", "2021");
		       newOrderInstance.selectProductType("1",2, 1);
		       newOrderInstance.selectProduct("1",2, 2);
		       newOrderInstance.selectAdType("1",2, 3);
		       //newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		    //   newOrderInstance.selectMaterialSource("1","NewBuild");
		       double price = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("Total price of the order placed is $"+price);
		       newOrderInstance.clickTearsheetTab();
		       newOrderInstance.clickNewTearsheet();
		       Thread.sleep(2000);
		       
		       OrderNewTearsheetProofPage newTearSheetInstance = PageFactory.initElements(driver, OrderNewTearsheetProofPage.class);
		       List<WebElement> newTearSheetelements = driver.findElements(By.xpath("//div[@class='form-group']/input"));
		       wait.until(ExpectedConditions.visibilityOfAllElements(newTearSheetelements));
		       newTearSheetInstance.enterQuantity();
		       newTearSheetInstance.enterContact();
		       newTearSheetInstance.enterCompany();
		       newTearSheetInstance.enterAddress();
		       newTearSheetInstance.entrCity();
		       newTearSheetInstance.enterState();
		       newTearSheetInstance.enterZipCode();
		       newTearSheetInstance.enterPhoneNumber();
		       newTearSheetInstance.clickOnSave();
		       Thread.sleep(2000);

Thread.sleep(4000); 
		  
		  JavascriptExecutor js = ((JavascriptExecutor) driver);
		 
		  js.executeScript("window.scrollTo(0, -(document.body.scrollHeight));");
		  
		  js.executeScript("scroll(0,400)");
		  
		       //Validate if the tearsheet is saved
		       WebElement tearsheetList = driver.findElement(By.xpath("//*[@id='insertionInfo']/form/div/table/tbody/tr[2]/td/div/div/div/div[2]/div[1]/table/tbody/tr/td[2]"));
		     //  wait.until(ExpectedConditions.visibilityOfAllElements(tearsheetList));
		       boolean flag = false;
		       if(tearsheetList.isDisplayed())
		       {
		    	   Logger.info("Tearsheet is added");
		    	   flag = true;
		       }
		       Assert.assertEquals(flag, true);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           //newOrderInstance.removeSalesRepOnInsertion(1);
			   Thread.sleep(4000);				      
	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			   Thread.sleep(4000);
			  newOrderInstance.clickOnInsertionSalesRepSection(1);
			   Thread.sleep(4000);
			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
			   Thread.sleep(2000);
		       Thread.sleep(4000);	
		       //newOrderInstance.addSalesPerson("SA00011");
		      newOrderInstance.submitOrder();
		      Thread.sleep(3000);
		      String orderID = orderEntryPageInstance.getOrderID();
		      Logger.info("Order ID: "+orderID);
		      orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       orderEntryPageInstance.clickOnOrder(orderID);
		       wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement));
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.clickTearsheetTab();
		       newOrderInstance.clickOnEditTearsheet();
		       Thread.sleep(2000);
		       newTearSheetInstance.enterQuantity();
		       newTearSheetInstance.clickOnSave();
		       Logger.info("Tearsheet is edited");
		       Thread.sleep(2000);
		       newOrderInstance.clickOnDeleteTearsheet();
		       Logger.info("TearSheet is deleted");
		       Thread.sleep(5000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(1000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       //orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		      // Thread.sleep(6000);
//		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	
	@Test(groups = {"orderValidateTearSheet", "RegressionLatest","Grp1", "Reg1","Group3","NewRegression1","NewRegression","G3", "insertionOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void orderValidateTearSheet(Map<String, String> userData) throws Exception
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
		       WebDriverWait wait = new WebDriverWait(driver,120);
		       newOrderInstance.selectSoldToCustomerBU("bu_DPR");
		       newOrderInstance.enterSoldToCustomer("CU00008397");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		     //  Thread.sleep(4000);
		      // newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(false);
		       Thread.sleep(4000);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);
		       newOrderInstance.selectBU("1",29, 0);
		       Thread.sleep(4000);
		      // newOrderInstance.enterPubDateFromExcel("1",29,27);
		       Thread.sleep(5000);
		       newOrderInstance.selectProductType("1",29, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",29, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",29, 3);
		       Thread.sleep(5000);
		       newOrderInstance.selectSection("1",29, 4);		       
		       Thread.sleep(6000);

		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		       newOrderInstance.clickTearsheetTab();
Thread.sleep(4000); 
		  
		  JavascriptExecutor js = ((JavascriptExecutor) driver);
		 
		  js.executeScript("window.scrollTo(0, -(document.body.scrollHeight));");
		  
		  js.executeScript("scroll(0,400)");
		  
		       //Validate if the tearsheet is saved
		       WebElement tearsheetList = driver.findElement(By.xpath("//*[@id='insertionInfo']/form/div/table/tbody/tr[2]/td/div/div/div/div[2]/div[1]/table/tbody/tr/td[2]"));
		     //  wait.until(ExpectedConditions.visibilityOfAllElements(tearsheetList));
		       boolean flag = false;
		       if(tearsheetList.isDisplayed())
		       {
		    	   Logger.info("Tearsheet is added");
		    	   flag = true;
		       }
		       Assert.assertEquals(flag, true);
		       newOrderInstance.clickOnEditTearsheet();
		       Thread.sleep(2000);
		       
		       //Write code to validate tear sheet values
		     //  newOrderInstance.validateTearsheetValues("10", "Chris VanDyck", "", "1600 Cantrell Rd", "Little Rock", "AR", "72201", "7273416103");
		       
		       Logger.info("Tearsheet is validated");
		       Thread.sleep(2000);
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
}
