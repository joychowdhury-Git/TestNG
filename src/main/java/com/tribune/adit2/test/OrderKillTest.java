package com.tribune.adit2.test;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.tribune.adit2.OrderEntry.ClassifiedOrderOptions;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Order Entry Home Page
 * @author Priyanka Goud CR 
 * @since September 2016
 */

public class OrderKillTest 
{
	
	static int j=0;

	//This method kills an order form the order entry page
	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void killOrderFromOEPage(Map<String, String> userData) throws Exception
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
			Thread.sleep(2000);

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1",6, 0);
			newOrderInstance.enterPubDate("1","29", "Dec", "2017");
			newOrderInstance.selectProductType("1",7, 1);
			newOrderInstance.selectProduct("1",7, 2);
			newOrderInstance.selectAdType("1",7, 3);
			newOrderInstance.selectSection("1",7, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA01635");
			Thread.sleep(3000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order ID: "+orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(8000);
			driver.navigate().refresh();
			orderEntryPageInstance.clickOnMoreOptionsOEPage(orderID);
			orderEntryPageInstance.killOrderFromOrderEntryPage();
			orderEntryPageInstance.clickOnKillOnConfirmation();
			Thread.sleep(4000);
			driver.navigate().refresh();
			Thread.sleep(4000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(4000);
			String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
			Logger.info("orderStatus "+orderStatus);
			Assert.assertEquals(orderStatus, "Killed");
			Assert.assertEquals(newOrderInstance.getInsertionStatus("1"), "Killed");
			dashboardPageInstance.clickOnLogout();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//This method kills an order form the order view page
	@Test(groups = {"Order", "ProductionTest","killOrderFromOrderViewPage","Group1","PTest1","PriorityVulnerability","Group1F","NANT","NewRegression2","NewRegression","G1","RerunF2","displayOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void killOrderFromOrderViewPage(Map<String, String> userData) throws Exception
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
			Thread.sleep(2000);

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",6, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1","12", "Jan", "2021");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1",7, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",7, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",7, 3);
			Thread.sleep(4000);
			newOrderInstance.selectSection("1",7, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
			Thread.sleep(3000);
			newOrderInstance.submitOrder();
			Thread.sleep(3000);
			newOrderInstance.clickOnContinuePastPubDate();//joy
			Thread.sleep(3000);
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order ID: "+orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(3000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(8000);
			newOrderInstance.clickOnKill();
			Thread.sleep(8000);
			newOrderInstance.clickOnKillOnConfirmation();
			Thread.sleep(8000);
			newOrderInstance.clickOnContinuePastDeadlineDate();//joy
			//  WebDriverWait wait = new WebDriverWait(driver, 60);
			//   wait.until(ExpectedConditions.textToBePresentInElement(newOrderInstance.orderStatusOVPage, "Killed"));
			Thread.sleep(10000);
			String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
			Logger.info("orderStatus "+orderStatus);
			//   Assert.assertEquals(orderStatus, "Killed");
			//  Assert.assertEquals(newOrderInstance.getInsertionStatus("1"), "Killed");

			dashboardPageInstance.clickOnLogout();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * This test submits an order with multiple insertions and kills one insertion from the order
	 */
	@Test(groups = {"Order", "ProductionTest"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void killInsertion(Map<String, String> userData) throws Exception
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
			Thread.sleep(2000);

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",6, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1","29", "Dec", "2020");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("1",7, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",7, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",7, 3);
			Thread.sleep(4000);
			newOrderInstance.selectSection("1",7, 4);
			Thread.sleep(4000);
			newOrderInstance.selectMMTag("1","Festival of Books");//swagata new
			Thread.sleep(4000);

			newOrderInstance.viewInsertionDetails("1");
			double priceFirstInsertion = newOrderInstance.getInsertionPrice("1","total");
			Logger.info("FirstInsertion price= "+priceFirstInsertion);
			Thread.sleep(2000);
			newOrderInstance.viewInsertionDetails("1");//swagata new

			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("2",2, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("2","31", "Dec", "2020");
			Thread.sleep(4000);
			newOrderInstance.selectProductType("2",2, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("2",2, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("2",2, 3);
			Thread.sleep(4000);
			newOrderInstance.selectSection("2",2, 4);
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("2");
			//newOrderInstance.selectMaterialSource("2","NewBuild");
			double priceSecondInsertion = newOrderInstance.getInsertionPrice("2", "total");
			Logger.info("SecondInsertion price "+priceSecondInsertion);
			Thread.sleep(1000);		       
			boolean flag = false;
			if(newOrderInstance.getInsertionsCount()>1){
				flag = true;
			}
			Assert.assertEquals(flag, true);
			// newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.viewInsertionDetails("2");
			//  newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(2);Thread.sleep(2000);Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(3000);
			String orderID = orderEntryPageInstance.getOrderID();//swagata new
			Logger.info("Order ID: "+orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(3000);

			WebDriverWait wait = new WebDriverWait(driver,120);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(2000);
			NewOrderPage orderViewPage = PageFactory.initElements(driver, NewOrderPage.class);
			wait.until(ExpectedConditions.visibilityOf(orderViewPage.orderViewPageElement));
			orderViewPage.killInsertion("1");
			Thread.sleep(2000);
			String insertionStatus = orderViewPage.getInsertionStatus("1");
			boolean insertionStatusflag = false;
			if(insertionStatus.equalsIgnoreCase("Kill Pending"))
			{
				insertionStatusflag = true;
				Logger.info("validation success - insertion kill");
			}
			Assert.assertEquals(insertionStatusflag, true);
			Thread.sleep(2000);
			orderViewPage.submitOrder();

			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(5000);
			//  Assert.assertEquals(newOrderInstance.getOrdeStatusOrderViewPage(), "Changed");
			//  Assert.assertEquals(newOrderInstance.getInsertionStatus("1"), "Killed");
			dashboardPageInstance.clickOnLogout();
			//   

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void killBulkOrderFromOEPage(Map<String, String> userData) throws Exception
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
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			String orderID = newOrderInstance.getOrderFromExcel(1, 0);
			Logger.info("Order to Kill:"+orderID);
			orderEntryPageInstance.clickOnMoreOptionsOEPage(orderID);
			orderEntryPageInstance.killOrderFromOrderEntryPage();
			orderEntryPageInstance.clickOnKillOnConfirmation();
			Thread.sleep(4000);
			driver.navigate().refresh();
			Thread.sleep(4000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(4000);
			String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
			Logger.info("orderStatus "+orderStatus);
			Assert.assertEquals(orderStatus, "Killed");
			Assert.assertEquals(newOrderInstance.getInsertionStatus("1"), "Killed");
			dashboardPageInstance.clickOnLogout();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"Order", "killAllOrders1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void killAllOrders1(Map<String, String> userData) throws Exception
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


			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);

			String noOfOrdersToKIll = System.getProperty("noOfOrdersToKill");
			Integer result = Integer.valueOf(noOfOrdersToKIll);
			Logger.info("No. of orders to Kill: "+result);
//			String modifiedUser = System.getProperty("modifiedUser");
			//include script to verify who created order
			for(int i=1;i<=result;i++){
				
				
				dashboardPageInstance.clickOnOrderEntryModule();
				String orderNum = newOrderInstance.getOrderFromExcel(i, 0);
				Logger.info("Order to Kill:"+orderNum);
				OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
				Thread.sleep(1000);
//				driver.findElement(By.xpath("//label[text()='Keyword ']/../div/div/button")).click();			      
//				Thread.sleep(3000);
//				driver.findElement(By.xpath("//label[text()='Keyword ']/../div/div/ul/li[11]/label/i")).click();
//				Thread.sleep(3000);
//				driver.findElement(By.xpath(".//*[@id='keyword']")).click();
//				Thread.sleep(3000);
//
//				driver.findElement(By.xpath(".//*[@id='keyword']")).sendKeys(modifiedUser);
//				Thread.sleep(3000);
//				basicOrderSearch.selectBussinessUnit("All");
//				Thread.sleep(2000);
				basicOrderSearch.enterOrderNumber(orderNum);
				basicOrderSearch.clickOnOrderSearchBtn();
				Thread.sleep(2000);

				//Verify the results
				WebDriverWait wait = new WebDriverWait(driver,120);
				WebElement orderNumberLink = driver.findElement(By.xpath("//a[text()='"+orderNum+"']"));
				wait.until(ExpectedConditions.visibilityOf(orderNumberLink));
				if(orderNumberLink.isDisplayed())
				{
					Assert.assertTrue(true);
					Logger.info(orderNum+ " order search result validated successfully");
					orderNumberLink.click();
					Thread.sleep(2000);
				}
				newOrderInstance.clickOnKill();
				newOrderInstance.clickOnKillOnConfirmation();
				Thread.sleep(8000);				
				String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
				Logger.info("orderStatus "+orderStatus);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}	       


			dashboardPageInstance.clickOnLogout();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}


	}
	
	@Test(groups = {"Order", "killAllOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void killAllOrders(Map<String, String> userData) throws Exception
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


			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);

			String noOfOrdersToKIll = System.getProperty("noOfOrdersToKill");
			Integer result = Integer.valueOf(noOfOrdersToKIll);
			Logger.info("No. of orders to Kill: "+result);
			
//			String modifiedUser = System.getProperty("modifiedUser");
			//include script to verify who created order
			int r = (result/20);
			
			for(int i=0;i<r;i++){
				
				utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
				utilities.implementWait(driver);

				signinPageinstance.login("success");
				
				
				for(j=(i*20);j<=((i*20)+19);j++){
				

				dashboardPageInstance.clickOnOrderEntryModule();
				String orderNum = newOrderInstance.getOrderFromExcel((j+1), 0);
				Logger.info("Order to Kill:"+orderNum);
				OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
				Thread.sleep(1000);
//				driver.findElement(By.xpath("//label[text()='Keyword ']/../div/div/button")).click();			      
//				Thread.sleep(3000);
//				driver.findElement(By.xpath("//label[text()='Keyword ']/../div/div/ul/li[11]/label/i")).click();
//				Thread.sleep(3000);
//				driver.findElement(By.xpath(".//*[@id='keyword']")).click();
//				Thread.sleep(3000);
//
//				driver.findElement(By.xpath(".//*[@id='keyword']")).sendKeys(modifiedUser);
//				Thread.sleep(3000);
//				basicOrderSearch.selectBussinessUnit("All");
//				Thread.sleep(2000);
				basicOrderSearch.enterOrderNumber(orderNum);
				basicOrderSearch.clickOnOrderSearchBtn();
				Thread.sleep(2000);

				//Verify the results
				WebDriverWait wait = new WebDriverWait(driver,120);
				WebElement orderNumberLink = driver.findElement(By.xpath("//a[text()='"+orderNum+"']"));
				wait.until(ExpectedConditions.visibilityOf(orderNumberLink));
				if(orderNumberLink.isDisplayed())
				{
					Assert.assertTrue(true);
					Logger.info(orderNum+ " order search result validated successfully");
					orderNumberLink.click();
					Thread.sleep(2000);
				}
				newOrderInstance.clickOnKill();
				newOrderInstance.clickOnKillOnConfirmation();
				Thread.sleep(8000);				
				String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
				Logger.info("orderStatus "+orderStatus);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
				dashboardPageInstance.clickOnLogout();	
			}
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			signinPageinstance.login("success");
			int rem = (result%20);
			for(int i=j; i<=((j+rem)+1); i++){
				dashboardPageInstance.clickOnOrderEntryModule();
				String orderNum = newOrderInstance.getOrderFromExcel((i+1), 0);
				Logger.info("Order to Kill:"+orderNum);
				OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
				Thread.sleep(1000);
//				driver.findElement(By.xpath("//label[text()='Keyword ']/../div/div/button")).click();			      
//				Thread.sleep(3000);
//				driver.findElement(By.xpath("//label[text()='Keyword ']/../div/div/ul/li[11]/label/i")).click();
//				Thread.sleep(3000);
//				driver.findElement(By.xpath(".//*[@id='keyword']")).click();
//				Thread.sleep(3000);
//
//				driver.findElement(By.xpath(".//*[@id='keyword']")).sendKeys(modifiedUser);
//				Thread.sleep(3000);
//				basicOrderSearch.selectBussinessUnit("All");
//				Thread.sleep(2000);
				basicOrderSearch.enterOrderNumber(orderNum);
				basicOrderSearch.clickOnOrderSearchBtn();
				Thread.sleep(2000);

				//Verify the results
				WebDriverWait wait = new WebDriverWait(driver,120);
				WebElement orderNumberLink = driver.findElement(By.xpath("//a[text()='"+orderNum+"']"));
				wait.until(ExpectedConditions.visibilityOf(orderNumberLink));
				if(orderNumberLink.isDisplayed())
				{
					Assert.assertTrue(true);
					Logger.info(orderNum+ " order search result validated successfully");
					orderNumberLink.click();
					Thread.sleep(2000);
				}
				newOrderInstance.clickOnKill();
				newOrderInstance.clickOnKillOnConfirmation();
				Thread.sleep(8000);				
				String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
				Logger.info("orderStatus "+orderStatus);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}

			dashboardPageInstance.clickOnLogout();
			
			
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}


	}

	@Test(groups = {"Order", "reSubmitAllOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void reSubmitAllOrders(Map<String, String> userData) throws Exception
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


			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);

			String noOfOrdersToKIll = System.getProperty("noOfOrdersToKill");
			Integer result = Integer.valueOf(noOfOrdersToKIll);
			Logger.info("No. of orders to Kill: "+result);
			String modifiedUser = System.getProperty("modifiedUser");
			//include script to verify who created order
			for(int i=1;i<=result;i++){

				dashboardPageInstance.clickOnOrderEntryModule();
				String orderNum = newOrderInstance.getOrderFromExcel(i, 0);
				Logger.info("Order to ReSubmit:"+orderNum);
				OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
				Thread.sleep(4000);
				/*    driver.findElement(By.xpath("//label[text()='Keyword ']/../div/div/button")).click();			      
			       Thread.sleep(3000);
			       driver.findElement(By.xpath("//label[text()='Keyword ']/../div/div/ul/li[11]/label/i")).click();
			       Thread.sleep(3000);
			       driver.findElement(By.xpath(".//*[@id='keyword']")).click();
			       Thread.sleep(3000);

			       driver.findElement(By.xpath(".//*[@id='keyword']")).sendKeys(modifiedUser);
			       Thread.sleep(3000);
			       basicOrderSearch.selectBussinessUnit("All");
			       Thread.sleep(2000);*/
				basicOrderSearch.enterOrderNumber(orderNum);
				basicOrderSearch.clickOnOrderSearchBtn();
				Thread.sleep(4000);

				//Verify the results
				WebDriverWait wait = new WebDriverWait(driver,120);
				WebElement orderNumberLink = driver.findElement(By.xpath("//a[text()='"+orderNum+"']"));
				wait.until(ExpectedConditions.visibilityOf(orderNumberLink));
				if(orderNumberLink.isDisplayed())
				{
					Assert.assertTrue(true);
					Logger.info(orderNum+ " order search result validated successfully");
					orderNumberLink.click();
					Thread.sleep(3000);
				}
				newOrderInstance.submitOrder();
				Thread.sleep(5000);
				/*  OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			       String orderID = orderEntryPageInstance.getOrderID();
			       Logger.info(orderEntryPageInstance.getOrderID());
			       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			       Thread.sleep(1000);

			       orderEntryPageInstance.clickOnOrder(orderID);
			       Thread.sleep(5000);
			       String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
			       Logger.info("orderStatus "+orderStatus);
			       Assert.assertEquals(orderStatus, "Changed");*/
				driver.navigate().refresh();
				Thread.sleep(4000);
			}	       


			dashboardPageInstance.clickOnLogout();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}


	}

	@Test(groups = {"Order", "killSpecificInsertions1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void killSpecificInsertions1(Map<String, String> userData) throws Exception
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


			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			NewOrderPage orderViewPage = PageFactory.initElements(driver, NewOrderPage.class);
			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);

			String noOfOrdersToKIll = System.getProperty("noOfOrdersToKill");
			Integer result = Integer.valueOf(noOfOrdersToKIll);
			Logger.info("No. of orders to Kill: "+result);
			String modifiedUser = System.getProperty("modifiedUser");
			//include script to verify who created order
			for(int i=1;i<=result;i++){

				dashboardPageInstance.clickOnOrderEntryModule();
				String orderNum = newOrderInstance.getOrderFromExcel(i, 0);
				Logger.info("Order to Kill:"+orderNum);
				OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
				Thread.sleep(4000);
				driver.findElement(By.xpath("//label[text()='Keyword ']/../div/div/button")).click();

				Thread.sleep(3000);
				driver.findElement(By.xpath("//label[text()='Keyword ']/../div/div/ul/li[11]/label/i")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(".//*[@id='keyword']")).click();
				Thread.sleep(3000);

				driver.findElement(By.xpath(".//*[@id='keyword']")).sendKeys(modifiedUser);
				Thread.sleep(3000);

				basicOrderSearch.enterOrderNumber(orderNum);
				basicOrderSearch.clickOnOrderSearchBtn();
				Thread.sleep(4000);

				//Verify the results
				WebDriverWait wait = new WebDriverWait(driver,120);
				WebElement orderNumberLink = driver.findElement(By.xpath("//a[text()='"+orderNum+"']"));
				wait.until(ExpectedConditions.visibilityOf(orderNumberLink));
				if(orderNumberLink.isDisplayed())
				{
					Assert.assertTrue(true);
					Logger.info(orderNum+ " order search result validated successfully");
					orderNumberLink.click();
					Thread.sleep(3000);
				}
				classifiedOrderInstance.uncheckLockOrderLinesChckBoxIfChecked();
				List<WebElement> pubDatesList = driver.findElements(By.xpath("//div[@class='insertionInfo table-responsive']/table[@class='table table-bordered ']/tbody[contains(@class,'order-lines')]/tr[@class='overview']/td[count(//div[@class='insertionInfo table-responsive']/table[@class='table table-bordered ']/thead[@class='fixThisHeader']/tr/th[text()=\"PubDate\"]/preceding-sibling::th)+1]"));
				Assert.assertTrue(pubDatesList.size()>0);
				Logger.info("Total number of PubDates available are " + pubDatesList.size());
				boolean boolFound = false;
				for(int j=0; j< pubDatesList.size(); j++){
					orderViewPage.scrollToElement(driver, pubDatesList.get(i));
					String pubDateStr = pubDatesList.get(j).getText().trim();
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
					Date pubDateDt1 = sdf.parse(pubDateStr);
					String pubDateLmtStr = "07/01/2020";
					SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
					Date pubDateDt2 = sdf1.parse(pubDateLmtStr);
					if((pubDateDt1.after(pubDateDt2)) || (pubDateDt1.equals(pubDateDt2))){
						boolFound = true;
						String idxToKill = Integer.toString(j+1);
						orderViewPage.killInsertion(idxToKill);
					}
				}
				//Check lockOrderlines checkbox present, if yes uncheck it (classifiedOrderInstance.clickLockOrderLinesChckBox();)
				//GetNoOfInsertions
				//Check Pubdate is >= 07/01/2020, If yes Kill insertion (orderViewPage.killInsertion("1");)
				
				newOrderInstance.submitOrder();
				if(boolFound==true){
				newOrderInstance.clickOnContinuePastPubDate();
				}
				driver.navigate().refresh();
				Thread.sleep(4000);
			}         


			dashboardPageInstance.clickOnLogout();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}


	}


	@Test(groups = {"Order", "killSpecificInsertions"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void killSpecificInsertions(Map<String, String> userData) throws Exception
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


			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			NewOrderPage orderViewPage = PageFactory.initElements(driver, NewOrderPage.class);
			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);

			String noOfOrdersToKIll = System.getProperty("noOfOrdersToKill");
			Integer result = Integer.valueOf(noOfOrdersToKIll);
			Logger.info("No. of orders to Kill: "+result);
			String modifiedUser = System.getProperty("modifiedUser");
			//include script to verify who created order
			for(int i=1;i<=result;i++){

				dashboardPageInstance.clickOnOrderEntryModule();
				String orderNum = newOrderInstance.getOrderFromExcel(i, 0);
				Logger.info("Order to Kill:"+orderNum);
				OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
				Thread.sleep(4000);
				driver.findElement(By.xpath("//label[text()='Keyword ']/../div/div/button")).click();

				Thread.sleep(3000);
				driver.findElement(By.xpath("//label[text()='Keyword ']/../div/div/ul/li[11]/label/i")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(".//*[@id='keyword']")).click();
				Thread.sleep(3000);

				driver.findElement(By.xpath(".//*[@id='keyword']")).sendKeys(modifiedUser);
				Thread.sleep(3000);

				basicOrderSearch.enterOrderNumber(orderNum);
				basicOrderSearch.clickOnOrderSearchBtn();
				Thread.sleep(4000);

				//Verify the results
				WebDriverWait wait = new WebDriverWait(driver,120);
				WebElement orderNumberLink = driver.findElement(By.xpath("//a[text()='"+orderNum+"']"));
				wait.until(ExpectedConditions.visibilityOf(orderNumberLink));
				if(orderNumberLink.isDisplayed())
				{
					Assert.assertTrue(true);
					Logger.info(orderNum+ " order search result validated successfully");
					orderNumberLink.click();
					Thread.sleep(3000);
				}
				classifiedOrderInstance.uncheckLockOrderLinesChckBoxIfChecked();
				List<WebElement> pubDatesList = driver.findElements(By.xpath("//div[@class='insertionInfo table-responsive']/table[@class='table table-bordered ']/tbody[contains(@class,'order-lines')]/tr[@class='overview']/td[count(//div[@class='insertionInfo table-responsive']/table[@class='table table-bordered ']/thead[@class='fixThisHeader']/tr/th[text()=\"PubDate\"]/preceding-sibling::th)+1]"));
				Assert.assertTrue(pubDatesList.size()>0);
				boolean boolFound = false;
				for(int j=0; j< pubDatesList.size(); j++){
					orderViewPage.scrollToElement(driver, pubDatesList.get(i));
					String pubDateStr = pubDatesList.get(j).getText().trim();
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
					Date pubDateDt1 = sdf.parse(pubDateStr);
					String pubDateLmtStr = "07/01/2020";
					SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
					Date pubDateDt2 = sdf1.parse(pubDateLmtStr);
					if((pubDateDt1.after(pubDateDt2)) || (pubDateDt1.equals(pubDateDt2))){
						boolFound = true;
						String idxToKill = Integer.toString(j+1);
						orderViewPage.killInsertion(idxToKill);
					}
				}
				//Check lockOrderlines checkbox present, if yes uncheck it (classifiedOrderInstance.clickLockOrderLinesChckBox();)
				//GetNoOfInsertions
				//Check Pubdate is >= 07/01/2020, If yes Kill insertion (orderViewPage.killInsertion("1");)
				
				newOrderInstance.submitOrder();
				if(boolFound==true){
				newOrderInstance.clickOnContinuePastPubDate();
				}
				driver.navigate().refresh();
				Thread.sleep(4000);
			}         


			dashboardPageInstance.clickOnLogout();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		   
		   
	   }
	
}
