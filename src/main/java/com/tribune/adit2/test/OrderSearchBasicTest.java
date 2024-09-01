package com.tribune.adit2.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class OrderSearchBasicTest 
{

	/**
	 * This test performs a basic search of the orders by 
	 * providing values to all the fields in the order entry page
	 */
	
	@Test(groups = {"performBasicOrderSearch","ProductionTest43"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
   public void performBasicOrderSearch(Map<String, String> userData) throws Exception
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
	       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
	       newOrderInstance.enterSoldToCustomer("CU00059747");
	       newOrderInstance.selectBilltoSameAsSoldTo();
	       newOrderInstance.selectOrderType("OrderType_Standard");
	       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
	       newOrderInstance.createNewInsertion();
	       newOrderInstance.selectBU("1",10, 0);
	       Thread.sleep(4000);
	       newOrderInstance.enterPubDate("1","30", "Dec", "2017");
	       Thread.sleep(4000);
	       newOrderInstance.selectProductType("1",10, 1);
	       Thread.sleep(4000);
	       newOrderInstance.selectProduct("1",10, 2);
	       Thread.sleep(4000);
	       newOrderInstance.selectAdType("1",10, 3);
	       Thread.sleep(4000);
	     //  newOrderInstance.selectSection("1",10, 4);
	     //  Thread.sleep(4000);
	       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
	       Thread.sleep(4000);
	       newOrderInstance.viewInsertionDetails("1");
	      // newOrderInstance.selectMaterialSource("1","N/A");
	       newOrderInstance.selectPageType("1", "PP_PaperType_Broadsheet");
	       newOrderInstance.checkUncheckBillQty(false);
	       newOrderInstance.enterBilledQty(2);
	       Thread.sleep(2000);
	       newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
	       newOrderInstance.clickOnPositionSelector();
	       Thread.sleep(12000);
	      newOrderInstance.selectAdSizeForPosition();
	      Thread.sleep(5000);
	      newOrderInstance.clickOnSearchPositionInPSWindw();
	      Thread.sleep(42000);
	    //  newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
	      newOrderInstance.selectFirstPostionFrmPositionSlctr();
	       newOrderInstance.savePositionSelection();
	       Thread.sleep(10000);	   		
	       newOrderInstance.clickonApplyAllInsertions();
	       Thread.sleep(5000);
	       newOrderInstance.submitOrder();
	       Thread.sleep(1000);
	       basicOrderSearch.closeOrderSuccessSubmissionMessage();
	       Thread.sleep(3000);
	       
	       List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
	       WebDriverWait wait = new WebDriverWait(driver,20);
	       wait.until(ExpectedConditions.visibilityOfAllElements(list));
	       Thread.sleep(8000);
	    //   String orderNum =  basicOrderSearch.getOrderNumber();
	       basicOrderSearch.selectBussinessUnit("LAT-LATMG");
	       Thread.sleep(2000);
	       //basicOrderSearch.selectStatus("OrderStatus_Processed");
	       Thread.sleep(2000);
	       //basicOrderSearch.selectType("Type_Order");
	       basicOrderSearch.enterCustomerName("1", "Group 7 House Account");
	       basicOrderSearch.clickOnOrderSearchBtn(); 
	       Thread.sleep(10000);
	       
	       // Verifying if the correct customer related orders are searched
	       List<WebElement> customerNameResults = driver.findElements(By.xpath("//*[@id='app']/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[1]/div[2]/div[2]/a"));
	       wait.until(ExpectedConditions.visibilityOfAllElements(customerNameResults));
	       int countOfSearchResults = customerNameResults.size();
	       Logger.info("count of the results displayed: " + countOfSearchResults);
	       Iterator<WebElement> iterator = customerNameResults.iterator();
	       boolean flag = false;
	       while(iterator.hasNext())
	       {
	    	   WebElement custName =  iterator.next();
	    	   String getCustomerName = custName.getText();
	    	   if((getCustomerName.equalsIgnoreCase("Group 7 House Account"))){
	    		   flag = true;
	    		   Logger.info("Search results for correct customer are displayed");
	    	   }
	    	   
	       }
	       Assert.assertEquals(flag, true);
	 	   dashboardPageInstance.clickOnLogout();
	   }
	   catch(Exception e)
	   {
		   Logger.error(e.getMessage());
			throw e;
	   }
   }

/**
 * This test Validates the export to excel functionality is working when order is searched only by Invoice #

 */
//swagata
@Test(groups = {"ExportToExcelWithInvoiceId","NewDev","PrioritizedReg3","NewRegression3","NewRegression","searchOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

public void ExportToExcelWithInvoiceId(Map<String, String> userData) throws Exception
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
       dashboardPageInstance.clickOnOrderEntrySearchModule();
       Thread.sleep(2000);       

       
       OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
       List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
       WebDriverWait wait = new WebDriverWait(driver,20);
       wait.until(ExpectedConditions.visibilityOfAllElements(list));
       Thread.sleep(8000);
       basicOrderSearch.selectBussinessUnit("All");
       Thread.sleep(3000);
       Logger.info("BU is selected successfully");
       
       /*driver.findElement(By.xpath("//*[@id='fetchOrder']/div[1]/div[3]/div/div/button/b")).click();
       WebElement radioBtn = driver.findElement(By.xpath("//*[@id='fetchOrder']/div[1]/div[3]/div/div/ul/li[12]/a/label/input"));

       radioBtn.click();*/
       basicOrderSearch.selectStatus("Invoiced");
       Logger.info("Invoiced is selected");
       
       

       basicOrderSearch.clickOnOrderSearchBtn();
       Thread.sleep(3000);
       
       String OrderIdSearchLines = basicOrderSearch.getFirstInvOrderIdSearchLines();
       Logger.info("Order number is:" +OrderIdSearchLines);
       
       basicOrderSearch.ExpandInvoicedOrder();
       Thread.sleep(3000);       
   
       
       
       basicOrderSearch.clickOnAdvSearch();
       Thread.sleep(3000);
       
      String InvoiceId = basicOrderSearch.getInvoiceId();
      Logger.info("Invoice Id is:"+InvoiceId);
      
     
      
      
      WebElement InvoiceNumber = driver.findElement(By.xpath("//*[@id='Text2']"));
      InvoiceNumber.click();
      InvoiceNumber.sendKeys(InvoiceId);
      
      Logger.info("Invoiced ID is placed");
      
       
      
       basicOrderSearch.selectBussinessUnit("All");
       Thread.sleep(3000);
       Logger.info("BU is selected successfully");
       
       
       
       basicOrderSearch.clickOnOrderSearchBtn();
       Thread.sleep(8000);
       
       
       
       String OrderIdAfterSearch = basicOrderSearch.getFirstInvOrderIdSearchLines();
       Logger.info("Order number from the search result:" +OrderIdAfterSearch);

       Assert.assertEquals(OrderIdSearchLines,OrderIdAfterSearch);
       
      /*InvoiceNumber.sendKeys("CTC1518449");
      Thread.sleep(3000);
    
       
       WebElement element= driver.findElement(By.xpath("((//span[text()='Invoiced '])[1]/../../../div)[1]/div/span/a"));
       Thread.sleep(3000);

       String OId = element.getText();
       Logger.info(OId);*/

       
       basicOrderSearch.ExportToExcel();
       Thread.sleep(3000);
       
       /*String actualMsg =basicOrderSearch.FileDownloadedText();
       
       String expcMsg ="File Exported successfully";
	Assert.assertEquals(expcMsg,actualMsg);*/

       
       
     
       
   }
	catch (Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	}
}

/**
 * This test Validates the export to excel functionality is working when order is searched only by Invoice #

 */
//swagata
@Test(groups = {"memoBillCheck"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

public void memoBillCheck(Map<String, String> userData) throws Exception
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
       dashboardPageInstance.clickOnOrderEntrySearchModule();
       Thread.sleep(2000);       

       
       OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
       List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
       WebDriverWait wait = new WebDriverWait(driver,20);
       wait.until(ExpectedConditions.visibilityOfAllElements(list));
       Thread.sleep(8000);
       basicOrderSearch.selectStatus("Invoiced");
       Logger.info("Invoiced is selected");

       basicOrderSearch.clickOnOrderSearchBtn();
       Thread.sleep(3000);
       
       String OrderIdSearchLines = basicOrderSearch.getFirstInvOrderIdSearchLines();
       Logger.info("Order number is:" +OrderIdSearchLines);  
       basicOrderSearch.clickOnOrder(OrderIdSearchLines);
       Thread.sleep(8000);
   
	NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
	WebElement element = driver.findElement(By.xpath("//button[@title='More actions']"));
	Actions action = new Actions(driver);
	action.moveToElement(element).click().build().perform();
	Thread.sleep(6000);
	newOrderInstance.verifyMemo();
       
	WebElement memoPrint = driver.findElement(By.xpath("//a[text()='Memo']/../ul/li[1]/a"));
	action.moveToElement(memoPrint).click().build().perform();
	Set<String> handles = driver.getWindowHandles();
    String currentHandle = driver.getWindowHandle();
    for (String handle : handles) {

     if (!handle .equals(currentHandle))
     {
         driver.switchTo().window(handle);
     }
   }

    driver.switchTo().window(currentHandle);
 //   actions.doubleClick(elementLocator).perform();

   }
	catch (Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	}
}
}

