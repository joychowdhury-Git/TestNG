package com.tribune.adit2.test;

import java.util.Iterator;
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

public class OrderSearchByCustomerNameTest 
{

	/**
	 * This test performs an search of the insertion orders placed by a customer
	 */
	
	@Test(groups = {"OrderSearch", "Regression","orderSearchByCustomerName"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void orderSearchByCustomerName(Map<String, String> userData) throws Exception
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
		       
		       OrderEntryHomePage orderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderSearch.clickOnNewGeneralOrder();
		       
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
		      // newOrderInstance.selectAdType("1",10, 3);
		     //  newOrderInstance.selectSection("1",10, 4);
		       Thread.sleep(4000);
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.selectMaterialSource("1","N/A");
		       newOrderInstance.selectPageType("1", "PP_PaperType_Broadsheet");
		       newOrderInstance.checkUncheckBillQty(false);
		       newOrderInstance.enterBilledQty(4);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       orderSearch.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
		       WebDriverWait wait = new WebDriverWait(driver,20);
		       wait.until(ExpectedConditions.visibilityOfAllElements(list));
		       String orderNum =  orderSearch.getOrderNumber();
		       orderSearch.enterCustomerName("1", userData.get("CustomerName4").toString());	
		       //orderSearch.getCustomerName("1",userData);
		       orderSearch.clickOnOrderSearchBtn(); 
		       Thread.sleep(10000);
		       
		       // Verifying if the correct customer results are searched
		       List<WebElement> customerResults = driver.findElements(By.xpath("//*[@id='app']/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[1]/div[2]/div[2]/a"));
		       WebDriverWait waitForSearchResults = new WebDriverWait(driver,60); 
		       waitForSearchResults.until(ExpectedConditions.visibilityOfAllElements(customerResults));
			   Iterator<WebElement> iterator = customerResults.iterator();
			   boolean flag = false;
		       while(iterator.hasNext())
		       {
		    	   WebElement custName =  iterator.next();
		    	   String getCustomerName = custName.getText();
		    	   if((getCustomerName.equalsIgnoreCase(userData.get("CustomerName4").toString()))){
		    		   flag = true;
		    	   }
		       }
		       Assert.assertEquals(flag, true);
		 	   dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				Assert.fail();
				throw e;  
		   }
	   }
}
