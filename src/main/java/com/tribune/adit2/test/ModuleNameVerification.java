package com.tribune.adit2.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tribune.adit2.Availability.AvailabilitySearchPage;
import com.tribune.adit2.Home.DashboardPage;
//import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

import junit.framework.Assert;

public class ModuleNameVerification {
	@Test(groups = {"moduleNameDashboard","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameDashboard(Map<String, String> userData) throws Exception
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
		       
		       //DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("//span[text()='Dashboard']"));
		       boolean flag = false;
		       
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Dashboard"));
		    	   flag = true;
		    	   Logger.info("Module Dashboard is present");
		       }
		       Assert.assertEquals(true, flag);
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"moduleNameOrderEntry","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameOrderEntry(Map<String, String> userData) throws Exception
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
		       
		      // DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("//span[text()='Order Entry']"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Order Entry"));
		    	   flag = true;
		    	   Logger.info("Module Order Entry is present");
		       }
		       Assert.assertEquals(true, flag);
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"moduleNameAvailability","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameAvailability(Map<String, String> userData) throws Exception
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
		       
		      // DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("//span[text()='Availability']"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Availability"));
		    	   flag = true;
		    	   Logger.info("Module Availability is present");
		       }
		       Assert.assertEquals(true, flag);
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"moduleAvailabilitySearchPlaceOrder","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleAvailabilitySearchPlaceOrder(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnAvailabilityModule();
		       Thread.sleep(3000);
		       
		       AvailabilitySearchPage availabilitySearch = PageFactory.initElements(driver, AvailabilitySearchPage.class);
		       availabilitySearch.selectBU("LAT");
		       availabilitySearch.selectProductType("Display");
		       availabilitySearch.selectProduct("Los Angeles Times");
		       availabilitySearch.selectadType("Block");
		       availabilitySearch.selectSectionDrpdwn("Sports");
		       availabilitySearch.enterFromDate("12/17/2019");
		       availabilitySearch.enterThruDate("12/21/2019");
		       availabilitySearch.clickOnSearch();
		       Thread.sleep(5000);
		       availabilitySearch.selectFirstSearchResult("LAT");
		       availabilitySearch.clickOnNewOrderButton();
		       Thread.sleep(5000);
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(false);
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   
		       newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       Thread.sleep(4000);newOrderInstance.submitOrder();
		       Thread.sleep(2000);
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(1000);
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"moduleNameSpecialPrograms","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameSpecialPrograms(Map<String, String> userData) throws Exception
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
		       
		      // DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("//span[text()='Special Programs']"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Special Programs"));
		    	   flag = true;
		    	   Logger.info("Module Special Programs is present");
		       }
		       Assert.assertEquals(true, flag);
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"moduleNameCustomers","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameCustomers(Map<String, String> userData) throws Exception
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
		       
		      // DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("//span[text()='Customers']"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Customers"));
		    	   flag = true;
		    	   Logger.info("Module Customers is present");
		       }
		       Assert.assertEquals(true, flag);
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"moduleNameNewspaperLayout","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameNewspaperLayout(Map<String, String> userData) throws Exception
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
		       
		      // DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("//span[text()='Newspaper Layout']"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Newspaper Layout"));
		    	   flag = true;
		    	   Logger.info("Module Newspaper Layouts is present");
		       }
		       Assert.assertEquals(true, flag);
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"moduleNameAccountUserTeamRoleRight","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameAccountUserTeamRoleRight(Map<String, String> userData) throws Exception
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
		       
		     //  DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("(//span[text()='User Admin'])[1]"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Thread.sleep(3000);
		    	  // Assert.assertTrue(driver.getTitle().contains("Newspaper Layout"));
		    	   flag = true;
		    	   Logger.info("Module Account is present");
		       }
		       Assert.assertEquals(true, flag);
		       
		       WebElement element1 = driver.findElement(By.xpath("//span[text()='Users']"));
		       boolean flag1 = false;
		       if(element1.isDisplayed())
		       {
		    	   element1.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Users"));		    	   
		    	   flag1 = true;
		    	   Logger.info("Module Users is present");
		       }
		       Assert.assertEquals(true, flag1);
		       
		       WebElement element2 = driver.findElement(By.xpath("//span[text()='Teams']"));
		       boolean flag2 = false;
		       if(element2.isDisplayed())
		       {
		    	   element2.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Teams"));	
		    	   flag2 = true;
		    	   Logger.info("Module Teams is present");
		       }
		       Assert.assertEquals(true, flag2);
		       
		       WebElement element3 = driver.findElement(By.xpath("//span[text()='Roles']"));
		       boolean flag3 = false;
		       if(element3.isDisplayed())
		       {
		    	   element3.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Roles"));	
		    	   flag3 = true;
		    	   Logger.info("Module Roles is present");
		       }
		       Assert.assertEquals(true, flag3);
		       
		       WebElement element4 = driver.findElement(By.xpath("//span[text()='Rights']"));
		       boolean flag4 = false;
		       if(element4.isDisplayed())
		       {
		    	   element4.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Rights"));
		    	   flag4 = true;
		    	   Logger.info("Module Rights is present");
		       }
		       Assert.assertEquals(true, flag4);
		       
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"moduleNameProductAdmin","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameProductAdmin(Map<String, String> userData) throws Exception
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
		       
		    //   DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("//span[text()='Product']"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Product Admin"));
		    	   flag = true;
		    	   Logger.info("Module Product Admin is present");
		       }
		       Assert.assertEquals(true, flag);
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"moduleNameProductAdminBU","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameProductAdminBU(Map<String, String> userData) throws Exception
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
		       
		    //   DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("//span[text()='Product']"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Product Admin"));
		    	   
		    	   Logger.info("Module Product Admin is present");
		    	   WebElement element1 = driver.findElement(By.xpath("//*[@id='bu-48']/span"));
		    	   Thread.sleep(3000);
		    	   element1.click();
		    	   Thread.sleep(5000);
		    	   Assert.assertTrue(driver.getTitle().contains("Business Unit - LAT"));
		    	   Logger.info("Title Business Unit - LAT is displayed");
		    	   flag = true;
		       }
		       Assert.assertEquals(true, flag);
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"moduleNameProductAdminProductName","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameProductAdminProductName(Map<String, String> userData) throws Exception
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
		       
		    //   DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("//span[text()='Product']"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Product Admin"));
		    	   
		    	   Logger.info("Module Product Admin is present");
		    	   WebElement element1 = driver.findElement(By.xpath("//*[@id='bu-48']/i"));
		    	   Thread.sleep(3000);
		    	   element1.click();
		    	   Thread.sleep(3000);
		    	   driver.findElement(By.xpath("//*[@id='producttype-1']/i")).click();
		    	   Thread.sleep(3000);
		    	   driver.findElement(By.xpath("//*[@id='product-360']/span")).click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Product - Daily Pilot"));
		    	   Logger.info("Title Product - Daily Pilot is displayed");
		    	   flag = true;
		       }
		       Assert.assertEquals(true, flag);
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"moduleNamePricingAdmin","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNamePricingAdmin(Map<String, String> userData) throws Exception
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
		       
		  //     DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("//span[text()='Pricing']"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Pricing Admin"));
		    	   flag = true;
		    	   Logger.info("Module Pricing Admin is present");
		       }
		       Assert.assertEquals(true, flag);
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"moduleNameFulfillmentSystemRoutingRuleFilter","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameFulfillmentSystemRoutingRuleFilter(Map<String, String> userData) throws Exception
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
		       
		     //  DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("(//span[text()='Fullfillment'])[1]"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Thread.sleep(3000);
		    	   flag = true;
		    	   Logger.info("Module Fulfillment is present");
		       }
		       Assert.assertEquals(true, flag);
		       
		       WebElement element1 = driver.findElement(By.xpath("//span[text()='Systems']"));
		       boolean flag1 = false;
		       if(element1.isDisplayed())
		       {
		    	   element1.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Fullfillment Systems"));
		    	   flag1 = true;
		    	   Logger.info("Module Systems is present");
		       }
		       Assert.assertEquals(true, flag1);
		       
		     
		       
		       WebElement element3 = driver.findElement(By.xpath("//span[text()='Filters']"));
		       boolean flag3 = false;
		       if(element3.isDisplayed())
		       {
		    	   element3.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Filters"));
		    	   flag3 = true;
		    	   Logger.info("Module Filter is present");
		       }
		       Assert.assertEquals(true, flag3);
		       
		       WebElement element2 = driver.findElement(By.xpath("//span[text()='Routing Rules']"));
		       boolean flag2 = false;
		       if(element2.isDisplayed())
		       {
		    	   element2.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Routing Rules"));
		    	   flag2 = true;
		    	   Logger.info("Module Routing Rules is present");
		       }
		       Assert.assertEquals(true, flag2);
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"moduleNameFulfillmentFilterName","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameFulfillmentFilterName(Map<String, String> userData) throws Exception
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
		       
		     //  DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("(//span[text()='Fullfillment'])[1]"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Thread.sleep(3000);
		    	   flag = true;
		    	   Logger.info("Module Fullfillment is present");
		       }
		       Assert.assertEquals(true, flag);
		       
		      		       
		       WebElement element3 = driver.findElement(By.xpath("//span[text()='Filters']"));
		       boolean flag3 = false;
		       if(element3.isDisplayed())
		       {
		    	   element3.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Filters"));		    	   
		    	   Logger.info("Module Filter is present");
		    	   driver.findElement(By.xpath("//a[text()='zzIsObitClassCode']")).click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Filter - zzIsObitClassCode"));		    	   
		    	   Logger.info("Title Filter - zzIsObitClassCode is displayed");
		    	   flag3 = true;
		       }
		       Assert.assertEquals(true, flag3);
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"moduleNameFulfillmentRoutingName","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameFulfillmentRoutingName(Map<String, String> userData) throws Exception
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
		       
		     //  DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("(//span[text()='Fullfillment'])[1]"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Thread.sleep(3000);
		    	   flag = true;
		    	   Logger.info("Module Fulfillment is present");
		       }
		       Assert.assertEquals(true, flag);
		       
		       WebElement element2 = driver.findElement(By.xpath("//span[text()='Routing Rules']"));
		       boolean flag2 = false;
		       if(element2.isDisplayed())
		       {
		    	   element2.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Routing Rules"));
		    	   Logger.info("Module Routing Rules is present");
		    	   Thread.sleep(3000);
		    	   driver.findElement(By.xpath("//a[text()='DPR SAM']")).click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Routing Rule - DPR SAM"));
		    	   Logger.info("Title Routing Rule - DPR SAM is displayed");
		    	   flag2 = true;
		    	   
		       }
		       Assert.assertEquals(true, flag2);
		       
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"moduleNameFulfillmentRoutingGlobalRule","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameFulfillmentRoutingGlobalRule(Map<String, String> userData) throws Exception
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
		       
		     //  DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("(//span[text()='Fullfillment'])[1]"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Thread.sleep(3000);
		    	   flag = true;
		    	   Logger.info("Module Fulfillment is present");
		       }
		       Assert.assertEquals(true, flag);
		       
		       WebElement element2 = driver.findElement(By.xpath("//span[text()='Routing Rules']"));
		       boolean flag2 = false;
		       if(element2.isDisplayed())
		       {
		    	   element2.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Routing Rules"));
		    	   Logger.info("Module Routing Rules is present");
		    	   Thread.sleep(3000);
		    	   driver.findElement(By.xpath("//*[@id='routing-rules-menu']/div[2]/ul/li[2]/a/i")).click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Global Rules"));
		    	   Logger.info("Title Global Rules is displayed");
		    	   flag2 = true;
		    	   
		       }
		       Assert.assertEquals(true, flag2);
		       
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"moduleNameFulfillmentRoutingGlobalRuleName","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameFulfillmentRoutingGlobalRuleName(Map<String, String> userData) throws Exception
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
		       
		     //  DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("(//span[text()='Fullfillment'])[1]"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Thread.sleep(3000);
		    	   flag = true;
		    	   Logger.info("Module Fulfillment is present");
		       }
		       Assert.assertEquals(true, flag);
		       
		       WebElement element2 = driver.findElement(By.xpath("//span[text()='Routing Rules']"));
		       boolean flag2 = false;
		       if(element2.isDisplayed())
		       {
		    	   element2.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Routing Rules"));
		    	   Logger.info("Module Routing Rules is present");
		    	   Thread.sleep(3000);
		    	   driver.findElement(By.xpath("//*[@id='routing-rules-menu']/div[2]/ul/li[2]/a/i")).click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Global Rules"));
		    	   Logger.info("Title Global Rules is displayed");
		    	   driver.findElement(By.xpath("//a[text()='IsForPublication']")).click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Global Rule - IsForPublication"));
		    	   Logger.info("Title Global Rule - IsForPublication is displayed");
		    	   flag2 = true;
		    	   
		       }
		       Assert.assertEquals(true, flag2);
		       
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"moduleNameFulfillmentSystemName","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameFulfillmentSystemName(Map<String, String> userData) throws Exception
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
		       
		     //  DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("(//span[text()='Fullfillment'])[1]"));
		       
		    	   element.click();
		    	   Thread.sleep(3000);		    	   
		       
		       WebElement element1 = driver.findElement(By.xpath("//span[text()='Systems']"));
		       boolean flag1 = false;
		       if(element1.isDisplayed())
		       {
		    	   element1.click();
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Fullfillment Systems"));
		    	   Logger.info("Module Systems is present");
		    	   driver.findElement(By.xpath("//*[@id='fullfillment-systems-menu']/div[2]/div/div/div/div/a[1]/span")).click();
		    	   Thread.sleep(4000);
		    	   Assert.assertTrue(driver.getTitle().contains("Fullfillment System - BillOrder"));
		    	   Logger.info("Tile Fulfillment System - BillOrder is present");
		    	   flag1 = true;
		       }
		       Assert.assertEquals(true, flag1);
		       
		       
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"moduleNameNewOrder","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameNewOrder(Map<String, String> userData) throws Exception
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
		       Thread.sleep(4000);
		    	   Assert.assertTrue(driver.getTitle().contains("New Order"));
		    	  
		    	   Logger.info("Module New Order is present");
		       
		      
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"moduleNameNewInsertionOrder","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameNewInsertionOrder(Map<String, String> userData) throws Exception
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
		       Thread.sleep(4000);
		    	   Assert.assertTrue(driver.getTitle().contains("New Insertion Order"));
		    	  
		    	   Logger.info("Module New Insertion Order is present");
		       
		      
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"moduleNameCustomerSearch","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameCustomerSearch(Map<String, String> userData) throws Exception
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
		       
		      // DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("//span[text()='Customers']"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Logger.info("Clicked on Customers from the menu");
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Customers"));		    	
		    	   WebElement custID = driver.findElement(By.xpath("//*[@id='app']/div[3]/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[1]/h4/a"));
		    	   custID.click();
		    	    Thread.sleep(4000);
		    	    Assert.assertTrue(driver.getTitle().contains("Customer - "));
		    	    flag = true;
		    	   Logger.info("Customer Searched Title is displayed");
		       }
		       Assert.assertEquals(true, flag);
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"moduleNameNewspaperLayoutSearch","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameNewspaperLayoutSearch(Map<String, String> userData) throws Exception
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
		       
		      // DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("//span[text()='Newspaper Layout']"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Logger.info("Clicked on Newspaper Layout from the menu");
		    	   Thread.sleep(3000);
		    	   Assert.assertTrue(driver.getTitle().contains("Newspaper Layout"));		    	
		    	   WebElement custID = driver.findElement(By.xpath("//*[@id='app']/div[3]/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr/td[1]/h4/a"));
		    	   custID.click();
		    	    Thread.sleep(4000);
		    	    Assert.assertTrue(driver.getTitle().contains("Newspaper Layout - "));
		    	    flag = true;
		    	   Logger.info("Newspaper Layout Searched Title is displayed");
		       }
		       Assert.assertEquals(true, flag);
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"moduleNameAccountUserSearch","Grp1","moduleNameVerify"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void moduleNameAccountUserSearch(Map<String, String> userData) throws Exception
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
		       
		     //  DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       WebElement element = driver.findElement(By.xpath("(//span[text()='User Admin'])[1]"));
		       boolean flag = false;
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Logger.info("Clicked on Accounts from the menu");
		    	   Thread.sleep(3000);
		    	   WebElement element1 = driver.findElement(By.xpath("//span[text()='Users']"));
			       
			       if(element1.isDisplayed())
			       {
			    	   element1.click();
			    	   Thread.sleep(3000);
			    	   Assert.assertTrue(driver.getTitle().contains("Users"));	 	   
			    	   Logger.info("Module Users is clicked");
			       }
		    	   	    	
		    	   WebElement custID = driver.findElement(By.xpath("//*[@id='app']/div[3]/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[1]/a"));
		    	 
		    	   custID.click();
		    	    Thread.sleep(4000);
		    	    Assert.assertTrue(driver.getTitle().contains("User - "));
		    	    flag = true;
		    	   Logger.info("User Searched Title is displayed");
		       }
		       Assert.assertEquals(true, flag);
		       //dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
