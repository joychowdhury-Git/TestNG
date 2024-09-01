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

public class OrderStatusSaveSubmitTest 
{
	/**
	 * This test will create a new Order for a display product type 
	 * and validate the order status as saved and submitted
	 */
	@Test(groups = {"Order","orderStatusSaveSubmit1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",2, 0);
		       newOrderInstance.enterPubDate("1","23", "Dec", "2019");
		       newOrderInstance.selectProductType("1",2, 1);
		       newOrderInstance.selectProduct("1",2, 2);
		       newOrderInstance.selectAdType("1",2, 3);
		       newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		       newOrderInstance.selectMaterialSource("1","New Build");
		       Thread.sleep(4000);
		       double price = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("Total price of the order placed is $"+price);
		       Thread.sleep(3000);
		       newOrderInstance.saveOrder();
		       Thread.sleep(3000);
		       Logger.info("Saved Order# : "+newOrderInstance.getOrderNo() );
		       String orderNumber = newOrderInstance.getOrderNo();
		       Thread.sleep(3000);
		       newOrderInstance.saveAndCloseOrder();
		       
		       Thread.sleep(3000);
		       WebDriverWait wait = new WebDriverWait(driver,120);
		       /*List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
		       wait.until(ExpectedConditions.visibilityOfAllElements(list));
		       //a[@class='order-link ng-binding']
		       */
		      
		       String orderStatus1 = orderEntryPageInstance.getOrderStatusFromOEPage(orderNumber);
		       boolean savedFlag = false;
		       boolean submittedFlag = false;
		       if(orderStatus1.equalsIgnoreCase("Saved"))
		       {
		    	   savedFlag = true;
		    	   Logger.info("Validation Success - order is saved");
		       }
		       Assert.assertEquals(savedFlag, true);
		       orderEntryPageInstance.clickOnOrder(orderNumber);
		       wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement));
		       Thread.sleep(1000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
		       Thread.sleep(3000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(1000);
		       //String orderID = orderEntryPageInstance.getOrderID();
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       String orderStatus2 = orderEntryPageInstance.getOrderStatusFromOEPage(orderNumber);
		       
		       Logger.info("Order is Submitted. Status is : "+orderStatus2);
		    /*   if(orderStatus2.equalsIgnoreCase("Submitted"))
		       {
		    	   submittedFlag = true;
		    	   Logger.info("Validation Success - order is Submitted");
		       }
		       Assert.assertEquals(submittedFlag, true);
		       Thread.sleep(3000);
		       driver.navigate().refresh();
		       Thread.sleep(4000);*/
		       Assert.assertEquals(orderEntryPageInstance.getOrderStatusFromOEPage(orderNumber), "Processed");
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
