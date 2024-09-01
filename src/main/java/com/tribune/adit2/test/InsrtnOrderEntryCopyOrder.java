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
 * @since November 2015
 */

public class InsrtnOrderEntryCopyOrder 
{
	/**
	 * This test performs a search operation based on order number 
	 */
	@Test(groups = {"orderSearchCopyOrder","Grp1", "Reg1", "RegressionLatest1","RegFailed4"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void orderSearchCopyOrder(Map<String, String> userData) throws Exception
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
		       newOrderInstance.enterPubDate("1","29", "Dec", "2019");
		       newOrderInstance.selectProductType("1",2, 1);
		       newOrderInstance.selectProduct("1",2, 2);
		       newOrderInstance.selectAdType("1",2, 3);
		       Thread.sleep(1000);
		       newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		      /* newOrderInstance.selectMaterialSource("1","NewBuild");
		       newOrderInstance.addSalesPerson("SA00011");*/
		       double price = newOrderInstance.getInsertionPrice("1", "total");
		       Logger.info("Total price of the order placed is $"+price);
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
		       Thread.sleep(2000);
		       String orderID = orderEntryPageInstance.getOrderID();
		       Logger.info("Order: "+orderID);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       WebDriverWait wait = new WebDriverWait(driver,120);
		       
		       orderEntryPageInstance.clickOnOrder(orderID);
		       
		       NewOrderPage orderViewPage = PageFactory.initElements(driver, NewOrderPage.class);
		       wait.until(ExpectedConditions.visibilityOf(orderViewPage.orderViewPageElement));
		       Logger.info("START OF COPY ORDER");
		      		       
		       wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));
		       
		       driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();
		       Thread.sleep(45000);
		       
		       wait.until(ExpectedConditions.urlContains("/orders/new"));
		       newOrderInstance.viewInsertionDetails("1");
		       WebElement buInsertionElement = driver.findElement(By.xpath("//tr/td/div/a/span[@id='Span4']/span"));
		       WebElement pubDate = driver.findElement(By.xpath("//*[@id='Span11']/span"));
		       WebElement productType = driver.findElement(By.xpath("//tr/td/div/a/span[@id='Span2']/span"));
		       WebElement product = driver.findElement(By.xpath("//tr/td/div/a/span[@id='Span5']/span"));
		       WebElement adType = driver.findElement(By.xpath("//tr/td/div/a/span[@id='Span7']/span"));
		       //WebElement section = driver.findElement(By.xpath("//tr/td/div/a/span[@id='Span6']/span"));
		       double copyOrderPrice = newOrderInstance.getInsertionPrice("1", "total");
		       Logger.info("new order price " +copyOrderPrice);
		       boolean buFlag = false;
		       boolean pubDateFlag = false;
		       boolean prodTypeFlag = false;
		       boolean prodFlag = false;
		       boolean adTypeFlag = false;
		       //boolean SectionFlag = false;
		       boolean priceFlag = false;
		       if(buInsertionElement.getText().equalsIgnoreCase("LAT")){
		    	   Logger.info("BU is validated");
		    	   buFlag= true;
		       }
		      
		       if(productType.getText().equalsIgnoreCase("Display")){
		    	   Logger.info("productType is validated");
		    	   prodTypeFlag = true;
		       }
		      
		       if(adType.getText().equalsIgnoreCase("Block")){
		    	   Logger.info("adType is validated");
		    	   adTypeFlag= true;
		       }
		      
		       if(price==copyOrderPrice)   {
		    	   Logger.info("total price is validated"); 
		    	   priceFlag= true;
		       }
		   	   Assert.assertEquals(buFlag, true);
			 
		 	   Assert.assertEquals(prodTypeFlag, true);
	    	 
	    	   Assert.assertEquals(adTypeFlag, true);
	    	 
	       	   Assert.assertEquals(priceFlag, true);
	       	   
	       	   Thread.sleep(2000);
	       	   dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
			   throw e;
		   }
	   }
}
