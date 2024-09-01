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
import com.tribune.adit2.NewsPaperLayout.NewsPaperLayoutsPage;
import com.tribune.adit2.OrderEntry.ClassifiedOrderOptions;
import com.tribune.adit2.OrderEntry.DigitalOrderOptions;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

public class OrderInfoFunctionality {
	@Test(groups = {"verifyOrderEntryWarningMsgDiscardOrder","Grp2","PrioritizedReg2","OrderInfoReg","NewRegression2","NewRegression","G2","displayOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void verifyOrderEntryWarningMsgDiscardOrder(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectSoldToCustomerBU("bu_ALT");
		       newOrderInstance.enterSoldToCustomer("CU00258088");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(false);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       Thread.sleep(3000);
		       orderEntryPageInstance.WarngMsgYesOptn.click();
		       Thread.sleep(3000);
		       
		       if((orderEntryPageInstance.orderSearchBtn).isDisplayed()){
		    	   Logger.info("YES option of warning message is working correctly");
		    	   Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("YES option of warning message is not working correctly");
		    	   Assert.assertEquals("str1","str"); 
		       }
		    	   
		     //***********************
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnLogout();//swagata
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"verifySaveOrder","Grp2","OrderInfoReg","PriorityVulnerability","Group3F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifySaveOrder(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectSoldToCustomerBU("bu_ALT");
		       newOrderInstance.enterSoldToCustomer("CU00258088");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(false);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(15000);
		       newOrderInstance.saveOrder();
		       
		       Thread.sleep(3000);
		     //  WebDriverWait wait = new WebDriverWait(driver,120);
		       /*List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
		       wait.until(ExpectedConditions.visibilityOfAllElements(list));*/
		       String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
		       newOrderInstance.saveAndCloseOrder();
		       orderEntryPageInstance.clickOnOrder(orderNumber);
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"retainSearchParameters"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void retainSearchParameters(Map<String, String> userData) throws Exception
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
		       		       
		       basicOrderSearch.selectBussinessUnit("LAT-LATMG");
		       Thread.sleep(2000);
		       //basicOrderSearch.selectStatus("OrderStatus_Processed");
		       Thread.sleep(2000);
		       //basicOrderSearch.selectType("Type_Order");
		       basicOrderSearch.enterCustomerName("1", "Group 7 House Account");
		       basicOrderSearch.clickOnOrderSearchBtn(); 
		       Thread.sleep(10000);
		       
		       // Verifying if the correct customer related orders are searched
		       WebDriverWait wait = new WebDriverWait(driver,20);
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
		       
		       dashboardPageInstance.clickOnNewsPaperLayoutModule();
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       Thread.sleep(5000);
		       basicOrderSearch.clickOnOrderSearchBtn(); 
		       Thread.sleep(10000);
		       List<WebElement> customerNameResults1 = driver.findElements(By.xpath("//*[@id='app']/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[1]/div[2]/div[2]/a"));
		       wait.until(ExpectedConditions.visibilityOfAllElements(customerNameResults1));
		       int countOfSearchResults1 = customerNameResults1.size();
		       Logger.info("count of the results displayed: " + countOfSearchResults1);
		      
		       Assert.assertEquals(countOfSearchResults, countOfSearchResults1);
		       
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"orderSearchByClassCode","Grp2","RegressionLatest","OrderInfoReg","Group3","Group3F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void orderSearchByClassCode(Map<String, String> userData) throws Exception
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
		       		       
		       basicOrderSearch.selectBussinessUnit("DPR-Daily Press");
		       Thread.sleep(2000);
		       basicOrderSearch.clickOnAdvancedLink();
		       Thread.sleep(2000);
		       basicOrderSearch.selectClassCode("Public Notice");		      
		       basicOrderSearch.clickOnOrderSearchBtn(); 
		       Thread.sleep(10000);
		       
		       // Verifying if the correct customer related orders are searched
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
		       WebDriverWait wait = new WebDriverWait(driver,20);
		       wait.until(ExpectedConditions.visibilityOfAllElements(list));
		       orderEntryPageInstance.clickOnSearchedOrder();
		       
		       Thread.sleep(4000);
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		     //  newOrderInstance.lockOrderLine();
		       Thread.sleep(3000);
		       String classCodeAtInsertion = newOrderInstance.getClassCodeForAnInsertion(1);
		       Logger.info("classCodeAtInsertion: "+classCodeAtInsertion);
		       Assert.assertEquals(classCodeAtInsertion, "10330");
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"NewsPaperLayouts","Regression","ProductionSanityTest1", "ProductionTest","NewsPaperLayoutsReg","OrderInfoReg","Grp3","searchNewsPaperLayoutProduct"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void searchNewsPaperLayoutProduct(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnNewsPaperLayoutModule();
		       
		       NewsPaperLayoutsPage layoutPage = PageFactory.initElements(driver, NewsPaperLayoutsPage.class);
		       layoutPage.selectBU("BU_DPR");
		       Thread.sleep(4000);
		       layoutPage.selectDayOfWeek("DayOfWeek_Wed");
		       Thread.sleep(4000);
		       layoutPage.selectProduct("DPRProduct_DailyPress");
		       Thread.sleep(4000);
		       layoutPage.selectSection(2);
		       Thread.sleep(4000);
		       layoutPage.checkOrUncheckCurrentTemplate(true);
		       Thread.sleep(4000);
		       layoutPage.clickOnSearch();
		       Thread.sleep(4000);
		       String count = layoutPage.countOfResultsFound.getText();
		       Logger.info("Count of the results found: " +count);
		       layoutPage.validateCurrentSearch("DailyPress_Section_Sports");
		       Thread.sleep(4000);
		       dashboardPageInstance.clickOnLogout();
		       }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
}
