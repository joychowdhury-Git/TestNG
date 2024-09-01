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

import com.tribune.adit2.Customers.CustomerPage;
import com.tribune.adit2.Customers.CustomerProfilePage;
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
 * @since June 2016
 */

public class CustProfileMoreRecentOrdersTest 
{

	/**
	 * @author cymkozalg6 - Priyanka
	 * @description This test method clicks on the more button inside a customer profile below the recent order
	 * 				placed by the customer. Validation is done on the results displayed.
	 */
	@Test(groups = {"CustomerProfile"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void moreRecentOrders(Map<String, String> userData) throws Exception
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
		       newOrderInstance.enterPubDate("1","31", "Dec", "2017");
		       newOrderInstance.selectProductType("1",2, 1);
		       newOrderInstance.selectProduct("1",2, 2);
		       newOrderInstance.selectAdType("1",2, 3);
		       newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(4000);
		       /*newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.selectMaterialSource("1","NewBuild");*/
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       //List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
		       WebDriverWait wait = new WebDriverWait(driver,20);
		       //wait.until(ExpectedConditions.visibilityOfAllElements(list));
		       orderEntryPageInstance.getOrderID();
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       
		       dashboardPageInstance.clickOnCustomerModule();
		       
		       CustomerPage customerSearchPage = PageFactory.initElements(driver, CustomerPage.class);
		       customerSearchPage.enterCustomerName("Group 7 House Account");
		       customerSearchPage.clickOnCustomersSearchBtn();
		       customerSearchPage.clickOnCustomerLink(userData, "CustomerName4");
		       
		       CustomerProfilePage customerProfile = PageFactory.initElements(driver, CustomerProfilePage.class);
		       customerProfile.getCustomerProfile();
		       String customerCUNumber = customerProfile.getCustomerCUNumber();
		       customerProfile.clickOnMoreRecentOrders();
		       
		       OrderEntryHomePage orderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       List<WebElement> ordersList = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
		       wait.until(ExpectedConditions.visibilityOfAllElements(ordersList));
		       List<WebElement> customerResults = driver.findElements(By.xpath("//div[2]/a[@class='ng-binding'][text()='"+userData.get("CustomerName4").toString()+"']"));
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
		       Assert.assertEquals(orderSearch.getCustomerEnteredInOrderSearch(), customerCUNumber);
		       
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
