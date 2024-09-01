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
import com.tribune.adit2.OrderEntry.OrderNewTearsheetProofPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Order Entry Home Page
 * @author Priyanka Goud CR 
 * @since December 2015
 */

public class InsrtnOrderProofTest 
{
	/**
	 * This test create a new proof for an order, 
	 * edit it and delete the proof
	 */
	@Test(groups = {"InsertionOrderorderProof", "RegressionLatest","Grp1", "Reg1","Group3","TestPriority","Group3F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void orderProof(Map<String, String> userData) throws Exception
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
		      // newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",10, 0);
		       newOrderInstance.enterPubDate("1","25", "Dec", "2019");
		       newOrderInstance.selectProductType("1",10, 1);
		       newOrderInstance.selectProduct("1",10, 2);
		       newOrderInstance.selectAdType("1",10, 3);  
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("1",10, 4);
		       Thread.sleep(4000);
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.checkUncheckBillQty(false);
		       newOrderInstance.enterBilledQty(4);
		       newOrderInstance.clickProofTab();
		       Thread.sleep(2000);
		       newOrderInstance.clickOnNewProof();
		       Thread.sleep(2000);
		       
		       OrderNewTearsheetProofPage newProofInstance = PageFactory.initElements(driver, OrderNewTearsheetProofPage.class);
		       List<WebElement> newProofelements = driver.findElements(By.xpath("//div[@class='form-group']/input"));
		       wait.until(ExpectedConditions.visibilityOfAllElements(newProofelements));
		       newProofInstance.enterQuantity();
		       newProofInstance.enterContact();
		       newProofInstance.enterCompany();
		       newProofInstance.enterAddress();
		       newProofInstance.entrCity();
		       newProofInstance.enterState();
		       newProofInstance.enterZipCode();
		       newProofInstance.enterPhoneNumber();
		       newProofInstance.clickOnSave();
		       
		       //Validate if the proof is saved
		       WebElement proofList = driver.findElement(By.xpath(".//*[@id='insertionInfo']/form/div/table/tbody/tr[2]/td/div/div/div/div[3]/div[1]/table/tbody/tr/td[1]"));
		      
		       boolean flag = false;
		       if(proofList.isDisplayed())
		       {
		    	   Logger.info("Proof is added");
		    	   flag = true;
		       }
		       Assert.assertEquals(flag, true);
		       Thread.sleep(1000);
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
		       Thread.sleep(1000);
		       String orderID = orderEntryPageInstance.getOrderID();
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       orderEntryPageInstance.clickOnOrder(orderID);
		       wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement));
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.clickProofTab();
		       newOrderInstance.clickOnEditProof();
		       Thread.sleep(2000);
		       newProofInstance.enterQuantity();
		       newProofInstance.clickOnSave();
		       Logger.info("Proof is edited");
		       Thread.sleep(2000);
		       newOrderInstance.clickOnDeleteProof();
		       Logger.info("Proof is deleted");
		       newOrderInstance.submitOrder();
		       Thread.sleep(2000);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
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
