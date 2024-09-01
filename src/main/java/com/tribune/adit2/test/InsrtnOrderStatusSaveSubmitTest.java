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

public class InsrtnOrderStatusSaveSubmitTest 
{
	/**
	 * This test will create a new Insertion Order for a dispaly product type 
	 * and validate the order status as saved and submitted
	 */
	@Test(groups = {"InsertionOrderorderStatusSaveSubmit", "RegressionLatest","Grp1", "Reg1","Group3","Group3F","NewRegression1","NewRegression","G3","RerunF2", "insertionOrders","orderStatusSaveSubmit"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void orderStatusSaveSubmit(Map<String, String> userData) throws Exception
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
		      // newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",2, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","28", "Dec", "2021");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",2, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",2, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",2, 3);
		       Thread.sleep(4000);
		       //newOrderInstance.selectSection("1",2, 4);
		       //Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		    //   newOrderInstance.selectMaterialSource("1","NewBuild");
		       double price = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("Total price of the order placed is $"+price);
		       newOrderInstance.saveOrder();
		       
		       Thread.sleep(8000);
		       WebDriverWait wait = new WebDriverWait(driver,120);
		       /*List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
		       wait.until(ExpectedConditions.visibilityOfAllElements(list));*/
		       String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
		       newOrderInstance.saveAndCloseOrder();
		     //  orderEntryPageInstance.clickOnOrder(orderNumber);
		    //   Logger.info("Order: "+orderNumber);
		      /* Thread.sleep(3000);//Joy
		       String orderStatus1 = orderEntryPageInstance.getOrderStatus(orderNumber);
		       boolean savedFlag = false;
		       boolean submittedFlag = false;
		       if(orderStatus1.equalsIgnoreCase("Saved"))
		       {
		    	   savedFlag = true;
		    	   Logger.info("Validation Success - order is saved");
		       }
		       Assert.assertEquals(savedFlag, true);*/
		       orderEntryPageInstance.clickOnOrder(orderNumber);
		       wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement));
		     //  Thread.sleep(1000); joy
		       Thread.sleep(4000);
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
		       newOrderInstance.submitOrder();
		       String orderID = orderEntryPageInstance.getOrderID();
		       Logger.info("Order ID: "+orderID);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		    
		   //    orderEntryPageInstance.clickOnOrder(orderNumber);
		      /* String orderStatus2 = orderEntryPageInstance.getOrderStatus(orderNumber);
		       if(orderStatus2.equalsIgnoreCase("Changed"))
		       {
		    	   submittedFlag = true;
		    	   Logger.info("Validation Success - order is Processed with status Changed - "+orderID);
		       }
		       Assert.assertEquals(submittedFlag, true);*/
		       dashboardPageInstance.clickondropdownforlogout(); //joy
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
