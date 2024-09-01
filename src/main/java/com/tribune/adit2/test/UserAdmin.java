package com.tribune.adit2.test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.tribune.adit2.Customers.CustomerPage;
import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.RolesAndRights.RolesLandingPage;
import com.tribune.adit2.RolesAndRights.UsersLandingPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

public class UserAdmin {
	
	@Test(groups = {"SMaintenance","NovMaintenance","AdjustmentWithFsc1RoleTest","NewRegression","NewRegression1", "Check","createNewOnlineOrder","PrioritizedReg1", "rolesRights" ,"Group3","TestPriority"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void AdjustmentWithFsc1RoleTest (Map<String, String> userData) throws Exception
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
		      // dashboardPageInstance.clickOnOrderEntryModule();
		       
		       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;//swagata
		       dashboardPageInstance.ClickOnUserAdminModule();
		       dashboardPageInstance.clickOnUserAdminUsersLink();
			       		       
		       RolesLandingPage RolesLandingPageInstance = PageFactory.initElements(driver, RolesLandingPage.class);
		       UsersLandingPage UsersLandingPageInstance = PageFactory.initElements(driver, UsersLandingPage.class);
		       //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;//mousumi
		       UsersLandingPageInstance.searchForUsers("AutomationTest");//swagata
		       
		       Thread.sleep(3000);
		       
		       UsersLandingPageInstance.ClickOnEditUserButton();
		       
		      Thread.sleep(2000);
		       UsersLandingPageInstance.ClickOnRolesTab();
		       WebDriverWait wait2=new WebDriverWait(driver, 20);
		       UsersLandingPageInstance.EditWindowRoleNameSearch("FSC 1");
		       Thread.sleep(2000);
		       UsersLandingPageInstance.CheckUserRoleName("FSC 1");
		       Thread.sleep(2000);
		       //WebDriverWait wait5=new WebDriverWait(driver, 30);
		       UsersLandingPageInstance.ClickOnSaveButton();
		       Thread.sleep(2000);
		       //WebDriverWait wait3=new WebDriverWait(driver, 30);
		       dashboardPageInstance.clickOnUserAdminRolesLink();
		       Thread.sleep(2000);
		       RolesLandingPageInstance.searchForRoles("FSC 1");
		      Thread.sleep(2000);
		       //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		      RolesLandingPageInstance.ClickOnEditRoleButton("FSC 1");
		      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		      RolesLandingPageInstance.EditRoleWindowNameSearch("AutomationTest");//swagata
		      //Thread.sleep(2000);
		     // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		      RolesLandingPageInstance.ClickOnUserRoleName("AutomationTest");//swagata
		     Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnSaveButton ();
		      Thread.sleep(2000);
		   	       
		      dashboardPageInstance.clickOnOrderEntryModule();
		       
		      OrderEntryHomePage orderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       WebDriverWait wait = new WebDriverWait(driver,120);
		       List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
		       wait.until(ExpectedConditions.visibilityOfAllElements(list));
		       orderSearch.selectStatus("Invoiced");
		       orderSearch.clickOnOrderSearchBtn();
		       Thread.sleep(2000);
		       
		       Thread.sleep(3000);
		       String order = orderSearch.orderSearchResult1.getText();
		       orderSearch.clickOnSearchedOrderInvoiced();
		       Thread.sleep(7000);
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		      
		       Thread.sleep(3000);
		       int insertionCountpre = newOrderInstance.getInsertionsCount();
		       newOrderInstance.clickOnAdjustmentRequest();
		       Thread.sleep(4000);
		       WebDriverWait wait4=new WebDriverWait(driver, 140);//mousumi
		       newOrderInstance.setAdjustmentRequest("5");
		      Thread.sleep(120000);
		       //driver.close();
		      String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
		       Logger.info("orderStatus "+orderStatus);
		       
		     
			      // Thread.sleep(7000);
			       //int insertionCountpost = newOrderInstance.getInsertionsCount();
			      // Assert.assertEquals(insertionCountpost, insertionCountpre+1);
			       
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"SMaintenance","AssignBUAdminTest","NewRegression","NewRegression1", "Check","PrioritizedReg1","createNewOnlineOrder","Group3","TestPriority", "rolesRights"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void AssignBUAdminTest (Map<String, String> userData) throws Exception
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
		      // dashboardPageInstance.clickOnOrderEntryModule();
		       
		       
		       dashboardPageInstance.ClickOnUserAdminModule();
		       dashboardPageInstance.clickOnUserAdminUsersLink();
		       RolesLandingPage RolesLandingPageInstance = PageFactory.initElements(driver, RolesLandingPage.class);
		       UsersLandingPage UsersLandingPageInstance = PageFactory.initElements(driver, UsersLandingPage.class);
		       UsersLandingPageInstance.searchForUsers("AutomationTest");//swagata
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnEditUserButton();
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnRolesTab();
		       UsersLandingPageInstance.EditWindowRoleNameSearch("BU ADMIN");
		       UsersLandingPageInstance.CheckUserRoleName("BU ADMIN");
		       UsersLandingPageInstance.ClickOnSaveButton();
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnUserAdminRolesLink();
		       Thread.sleep(2000);
		       RolesLandingPageInstance.searchForRoles("BU ADMIN");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnEditRoleButton("BU ADMIN");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.EditRoleWindowNameSearch("AutomationTest");//swagata
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnUserRoleName("AutomationTest");//swagata
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnSaveButton();
		      Thread.sleep(2000);
		   }
		catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
}
	@Test(groups = {"SMaintenance","NewRegression","NewRegression1","Check","createNewOnlineOrder","PrioritizedReg1","Group3","TestPriority", "AssignClassified1RoleTest", "rolesRights"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void AssignClassified1RoleTest (Map<String, String> userData) throws Exception
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
		      // dashboardPageInstance.clickOnOrderEntryModule();
		       
		       
		       dashboardPageInstance.ClickOnUserAdminModule();
		       dashboardPageInstance.clickOnUserAdminUsersLink();
		       RolesLandingPage RolesLandingPageInstance = PageFactory.initElements(driver, RolesLandingPage.class);
		       UsersLandingPage UsersLandingPageInstance = PageFactory.initElements(driver, UsersLandingPage.class);
		       UsersLandingPageInstance.searchForUsers("AutomationTest");//swagata
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnEditUserButton();
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnRolesTab();
		       UsersLandingPageInstance.EditWindowRoleNameSearch("classified");
		       UsersLandingPageInstance.CheckUserRoleName("CLASSIFIED1");
		       UsersLandingPageInstance.ClickOnSaveButton();
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnUserAdminRolesLink();
		       Thread.sleep(2000);
		       RolesLandingPageInstance.searchForRoles("classified");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnEditRoleButton("CLASSIFIED1");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.EditRoleWindowNameSearch("AutomationTest");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnUserRoleName("AutomationTest");//swagata
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnSaveButton();
		      Thread.sleep(2000);
		   }
		catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
}
	@Test(groups = {"SMaintenance","AssignCustomerMappingViewUpdateRightTest","NewRegression","PrioritizedReg1","NewRegression1", "Check","createNewOnlineOrder","Group3","TestPriority", "rolesRights"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void AssignCustomerMappingViewUpdateRightTest (Map<String, String> userData) throws Exception
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
		      // dashboardPageInstance.clickOnOrderEntryModule();
		       dashboardPageInstance.ClickOnUserAdminModule();
		       dashboardPageInstance.clickOnUserAdminRolesLink();
		       
		      RolesLandingPage RolesLandingPageInstance = PageFactory.initElements(driver, RolesLandingPage.class);
		      //RolesLandingPageInstance.CheckUserRightsName("QA");
		      RolesLandingPageInstance.searchForRoles("QA");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnEditRoleButton("QA");
		   Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnRightTab();
		      Thread.sleep(2000);
		      //RolesLandingPageInstance.EditRoleWindowRightsNameSearch("Customer");
		      RolesLandingPageInstance.CheckUserRightsName("CustomerMappingViewUpdate");
		      Thread.sleep(3000);
		      RolesLandingPageInstance.ClickOnRightsNameSearch("CustomerMappingViewUpdate");
		      //Thread.sleep(3000);
		      RolesLandingPageInstance.ClickOnSaveButton ();
		      Thread.sleep(2000);
		      dashboardPageInstance.clickOnCustomerModule();
		      CustomerPage CustomerPageInstance = PageFactory.initElements(driver, CustomerPage.class);
		      CustomerPageInstance.selectAccountTypeSearch("Agency");
		      CustomerPageInstance.clickOnCustomersSearchBtn();
		      Thread.sleep(2000);
		      CustomerPageInstance.selectAgencyCustomer();
		      Thread.sleep(3000);
		      
		   }
		catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
}
	@Test(groups = {"SMaintenance","AssignFinance1RoleTest","NewRegression","NewRegression1","NovMaintenance","Check","createNewOnlineOrder","PrioritizedReg1","Group3","TestPriority", "rolesRights"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void AssignFinance1RoleTest (Map<String, String> userData) throws Exception
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
		      // dashboardPageInstance.clickOnOrderEntryModule();
		       
		       
		       dashboardPageInstance.ClickOnUserAdminModule();
		       dashboardPageInstance.clickOnUserAdminUsersLink();
		       RolesLandingPage RolesLandingPageInstance = PageFactory.initElements(driver, RolesLandingPage.class);
		       UsersLandingPage UsersLandingPageInstance = PageFactory.initElements(driver, UsersLandingPage.class);
		       UsersLandingPageInstance.searchForUsers("AutomationTest");//swagata
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnEditUserButton();
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnRolesTab();
		       Thread.sleep(2000);
		       UsersLandingPageInstance.EditWindowRoleNameSearch("Finance1");
		       Thread.sleep(2000);
		       UsersLandingPageInstance.CheckUserRoleName("FINANCE1");
		       Thread.sleep(2000);
		       UsersLandingPageInstance.ClickOnSaveButton();
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnUserAdminRolesLink();
		       Thread.sleep(2000);
		       RolesLandingPageInstance.searchForRoles("Finance1");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnEditRoleButton("FINANCE1");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.EditRoleWindowNameSearch("AutomationTest");//swagata
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnUserRoleName("AutomationTest");//swagata
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnSaveButton ();
		      Thread.sleep(2000);
		   }
		catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
}
	@Test(groups = {"SMaintenance","AssignFSC1RoleTest","NewRegression","NewRegression1", "Check","createNewOnlineOrder","Group3","TestPriority", "AssignFSC1RoleTest", "rolesRights"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void AssignFSC1RoleTest (Map<String, String> userData) throws Exception
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
		      // dashboardPageInstance.clickOnOrderEntryModule();
		       
		       
		       dashboardPageInstance.ClickOnUserAdminModule();
		       dashboardPageInstance.clickOnUserAdminUsersLink();
		       RolesLandingPage RolesLandingPageInstance = PageFactory.initElements(driver, RolesLandingPage.class);
		       UsersLandingPage UsersLandingPageInstance = PageFactory.initElements(driver, UsersLandingPage.class);
		       UsersLandingPageInstance.searchForUsers("AutomationTest");//swagata
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnEditUserButton();
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnRolesTab();
		       UsersLandingPageInstance.EditWindowRoleNameSearch("FSC");
		       UsersLandingPageInstance.CheckUserRoleName("FSC 1");
		       Thread.sleep(2000);
		       UsersLandingPageInstance.ClickOnSaveButton();
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnUserAdminRolesLink();
		       Thread.sleep(2000);
		       RolesLandingPageInstance.searchForRoles("FSC");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnEditRoleButton("FSC 1");
		      RolesLandingPageInstance.EditRoleWindowNameSearch("AutomationTest");//swagata
		      RolesLandingPageInstance.ClickOnUserRoleName("AutomationTest");//swagata
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnSaveButton ();
		      Thread.sleep(2000);
		   }
		catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
}
	@Test(groups = {"SMaintenance","NewRegression","NewRegression1", "Check","createNewOnlineOrder","Group3","TestPriority", "AssignQARoleTest", "rolesRights"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void AssignQARoleTest (Map<String, String> userData) throws Exception
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
		      // dashboardPageInstance.clickOnOrderEntryModule();
		       
		       
		       dashboardPageInstance.ClickOnUserAdminModule();
		       dashboardPageInstance.clickOnUserAdminUsersLink();
		       RolesLandingPage RolesLandingPageInstance = PageFactory.initElements(driver, RolesLandingPage.class);
		       UsersLandingPage UsersLandingPageInstance = PageFactory.initElements(driver, UsersLandingPage.class);
		       UsersLandingPageInstance.searchForUsers("AutomationTest");//swagata
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnEditUserButton();
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnRolesTab();
		       UsersLandingPageInstance.EditWindowRoleNameSearch("QA");
		       UsersLandingPageInstance.CheckUserRoleName("QA");
		       UsersLandingPageInstance.ClickOnSaveButton();
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnUserAdminRolesLink();
		       Thread.sleep(2000);
		       RolesLandingPageInstance.searchForRoles("QA");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnEditRoleButton("QA");
		      RolesLandingPageInstance.EditRoleWindowNameSearch("AutomationTest");//swagata
		      RolesLandingPageInstance.ClickOnUserRoleName("AutomationTest");//swagata
		      RolesLandingPageInstance.ClickOnSaveButton ();
		      Thread.sleep(2000);
		   }
		catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
}
	@Test(groups = {"SMaintenance","NewRegression","AssignTechnologyRoleTest","NewRegression1", "Check","createNewOnlineOrder","Group3","TestPriority", "AssignTechnologyRoleTest", "rolesRights"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void AssignTechnologyRoleTest (Map<String, String> userData) throws Exception
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
		      // dashboardPageInstance.clickOnOrderEntryModule();
		       
		       
		       dashboardPageInstance.ClickOnUserAdminModule();
		       dashboardPageInstance.clickOnUserAdminUsersLink();
		       RolesLandingPage RolesLandingPageInstance = PageFactory.initElements(driver, RolesLandingPage.class);
		       UsersLandingPage UsersLandingPageInstance = PageFactory.initElements(driver, UsersLandingPage.class);
		       UsersLandingPageInstance.searchForUsers("AutomationTest");//swagata
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnEditUserButton();
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnRolesTab();
		       UsersLandingPageInstance.EditWindowRoleNameSearch("Techno");
		       UsersLandingPageInstance.CheckUserRoleName("TECHNOLOGY");
		       UsersLandingPageInstance.ClickOnSaveButton();
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnUserAdminRolesLink();
		       Thread.sleep(2000);
		       RolesLandingPageInstance.searchForRoles("Techno");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnEditRoleButton("TECHNOLOGY");
		      RolesLandingPageInstance.EditRoleWindowNameSearch("AutomationTest");//swagata
		      RolesLandingPageInstance.ClickOnUserRoleName("AutomationTest");//swagata
		      Thread.sleep(4000);
		      RolesLandingPageInstance.ClickOnSaveButton ();
		      Thread.sleep(2000);
		   }
		catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
}
	@Test(groups = {"SMaintenance","NovMaintenance","AssignUserAdminRoleTest","NewRegression","NewRegression1", "Check","createNewOnlineOrder","Group3","TestPriority", "rolesRights"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void AssignUserAdminRoleTest (Map<String, String> userData) throws Exception
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
		      // dashboardPageInstance.clickOnOrderEntryModule();
		       
		       
		       dashboardPageInstance.ClickOnUserAdminModule();
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnUserAdminUsersLink();
		       RolesLandingPage RolesLandingPageInstance = PageFactory.initElements(driver, RolesLandingPage.class);
		       UsersLandingPage UsersLandingPageInstance = PageFactory.initElements(driver, UsersLandingPage.class);
		      // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;//mou
		       UsersLandingPageInstance.searchForUsers("AutomationTest");//swagata
		       Thread.sleep(2000);
		      // driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);//mou
		       UsersLandingPageInstance.ClickOnEditUserButton();
		     Thread.sleep(2000);
		      UsersLandingPageInstance.ClickOnRolesTab();
		      Thread.sleep(2000);
		       UsersLandingPageInstance.EditWindowRoleNameSearch("user");
		       UsersLandingPageInstance.CheckUserRoleName("USER ADMIN");
		       UsersLandingPageInstance.ClickOnSaveButton();
		      Thread.sleep(2000);
		       dashboardPageInstance.clickOnDashboardModule();
		       Thread.sleep(2000);
		       dashboardPageInstance.ClickOnUserAdminModule();
		       dashboardPageInstance.clickOnUserAdminUsersLink();
		       UsersLandingPageInstance.searchForUsers("jayanta");//joy
		       Thread.sleep(2000);//mou
		       UsersLandingPageInstance.ClickOnEditUserButton();
		       Thread.sleep(2000);//mou
		       UsersLandingPageInstance.ClickOnRolesTab();
		       UsersLandingPageInstance.EditWindowRoleNameSearch("user");
		       UsersLandingPageInstance.CheckUserRoleName1("USER ADMIN");
		       UsersLandingPageInstance.ClickOnSaveButton();
		       Thread.sleep(2000);
		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
		       utilities.implementWait(driver);
		       
		       signinPageinstance.login("success");//swagata
		       
		       dashboardPageInstance.ClickOnUserAdminModule();
		       dashboardPageInstance.clickOnUserAdminRolesLink();
		       Thread.sleep(2000);
		       RolesLandingPageInstance.searchForRoles("user admin");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnEditRoleButton("USER ADMIN");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.EditRoleWindowNameSearch("AutomationTest");//swagata
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnUserRoleName("AutomationTest");//swagata
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnSaveButton ();
		      Thread.sleep(2000);
		   }
		catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
}
	@Test(groups = {"SMaintenance","AssignViewOnlyRoleTest","NewRegression","NewRegression1","PrioritizedReg1","Check","createNewOnlineOrder","Group3","TestPriority", "rolesRights"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void AssignViewOnlyRoleTest (Map<String, String> userData) throws Exception
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
		      // dashboardPageInstance.clickOnOrderEntryModule();
		       
		       
		       dashboardPageInstance.ClickOnUserAdminModule();
		       dashboardPageInstance.clickOnUserAdminUsersLink();
		       RolesLandingPage RolesLandingPageInstance = PageFactory.initElements(driver, RolesLandingPage.class);
		       UsersLandingPage UsersLandingPageInstance = PageFactory.initElements(driver, UsersLandingPage.class);
		       UsersLandingPageInstance.searchForUsers("AutomationTest");//swagata
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnEditUserButton();
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnRolesTab();
		       UsersLandingPageInstance.EditWindowRoleNameSearch("View Only");
		       UsersLandingPageInstance.CheckUserRoleName("VIEW ONLY");
		       UsersLandingPageInstance.ClickOnSaveButton();
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnUserAdminRolesLink();
		       Thread.sleep(2000);
		       RolesLandingPageInstance.searchForRoles("View Only");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnEditRoleButton("VIEW ONLY");
		      Thread.sleep(3000);
		      RolesLandingPageInstance.EditRoleWindowNameSearch("AutomationTest");//swagata
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnUserRoleName("AutomationTest");//swagata
		      Thread.sleep(3000);
		      RolesLandingPageInstance.ClickOnSaveButton ();
		      Thread.sleep(2000);
		   }
		catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
}
	@Test(groups = {"SMaintenance","NewRegression","ConvertIOToOrderUsingCustservice1Role","NewRegression1", "rolesRights", "Check","createNewOnlineOrder","Group3","TestPriority"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ConvertIOToOrderUsingCustservice1Role (Map<String, String> userData) throws Exception
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
		      // dashboardPageInstance.clickOnOrderEntryModule();
		       dashboardPageInstance.ClickOnUserAdminModule();
		       dashboardPageInstance.clickOnUserAdminUsersLink();
		       UsersLandingPage UsersLandingPageInstance = PageFactory.initElements(driver, UsersLandingPage.class);
		       Thread.sleep(2000);
		       UsersLandingPageInstance.searchForUsers("jayanta");//swagata
		       Thread.sleep(2000);
		       UsersLandingPageInstance.ClickOnEditUserButton();
		       Thread.sleep(2000);
		       UsersLandingPageInstance.ClickOnRolesTab();
		       UsersLandingPageInstance.EditWindowRoleNameSearch("Custservice1");
		       UsersLandingPageInstance.CheckUserRoleName("CUSTSERVICE1");
		       UsersLandingPageInstance.ClickOnSaveButton();
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnUserAdminRolesLink();
		       
		      RolesLandingPage RolesLandingPageInstance = PageFactory.initElements(driver, RolesLandingPage.class);
		      Thread.sleep(2000);
		      RolesLandingPageInstance.searchForRoles("custservice1");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnEditRoleButton("CUSTSERVICE1");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.EditRoleWindowNameSearch("jayanta");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnUserRoleName("Jayanta");
		      Thread.sleep(3000);
		      RolesLandingPageInstance.ClickOnSaveButton();
		      Thread.sleep(4000);
		      
		      ///RolesLandingPageInstance.EditRoleWindowNameSearch(Name);
		    
		       
		       
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryPageInstance.clickOnNewInsertionOrderBtn();
		   
		       Thread.sleep(4000);
		       //RolesLandingPage RolesLandingPageInstance = PageFactory.initElements(driver, RolesLandingPage.class);
		       //RolesLandingPageInstance.searchForRoles("Custservice 1");
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		      
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.enterComments();
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",2, 0);
		       Thread.sleep(4000);
		      // newOrderInstance.enterPubDateFromExcel("1",60,27);
		       newOrderInstance.enterPubDateFromExcel("1", 29, 27);
		       //newOrderInstance.validateListOfProductTypes("1");
		       Thread.sleep(2000);
		       newOrderInstance.selectProductType("1",2, 1);
		       Thread.sleep(2000);
		       newOrderInstance.selectProduct("1",2, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",2, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           //newOrderInstance.removeSalesRepOnInsertion(1);
			  // Thread.sleep(4000);				      
	           //newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			   //Thread.sleep(4000);
			   ///newOrderInstance.clickOnInsertionSalesRepSection(1);
			  //Thread.sleep(4000);
			   //newOrderInstance.applytoAllSalesRepOnInsertion(1);
			   //Thread.sleep(2000);
		       Thread.sleep(4000);
		       newOrderInstance.addServiceRep("203486");
			   Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(1000);
		       //newOrderInstance.clickOnContinuePastPubDate();//joy
		       Thread.sleep(2000);
		       WebDriverWait wait = new WebDriverWait(driver,120);
		       
		       String orderID = orderEntryPageInstance.getOrderID();
		       Logger.info("Order: "+orderID);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(8000);
		       
		       
		       orderEntryPageInstance.clickOnOrder(orderID);
		       
		       NewOrderPage orderViewPage = PageFactory.initElements(driver, NewOrderPage.class);
		       wait.until(ExpectedConditions.visibilityOf(orderViewPage.orderViewPageElement));
		       orderViewPage.convertInsertion();
		       Thread.sleep(5000);
		       newOrderInstance.submitOrder();
		       
		      
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	@Test(groups = {"SMaintenance","ConvertIOToOrderUsingCustservice2Role","NewRegression","NewRegression1","rolesRights","PrioritizedReg1", "Check","createNewOnlineOrder","Group3","TestPriority"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void ConvertIOToOrderUsingCustservice2Role (Map<String, String> userData) throws Exception
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
		      // dashboardPageInstance.clickOnOrderEntryModule();
		       dashboardPageInstance.ClickOnUserAdminModule();
		       dashboardPageInstance.clickOnUserAdminUsersLink();
		       UsersLandingPage UsersLandingPageInstance = PageFactory.initElements(driver, UsersLandingPage.class);
		       UsersLandingPageInstance.searchForUsers("Jayanta");//swagata
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnEditUserButton();
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnRolesTab();
		       UsersLandingPageInstance.EditWindowRoleNameSearch("Custservice2");
		       UsersLandingPageInstance.CheckUserRoleName("CUSTSERVICE2");
		       UsersLandingPageInstance.ClickOnSaveButton();
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnUserAdminRolesLink();
		       Thread.sleep(2000);
		      RolesLandingPage RolesLandingPageInstance = PageFactory.initElements(driver, RolesLandingPage.class);
		      Thread.sleep(2000);
		      RolesLandingPageInstance.searchForRoles("custservice2");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnEditRoleButton("CUSTSERVICE2");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.EditRoleWindowNameSearch("Jayanta");//swagata
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnUserRoleName("Jayanta");//swagata
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnSaveButton ();
		      Thread.sleep(4000);
		      
		      //RolesLandingPageInstance.EditRoleWindowNameSearch(Name);
		    
		       
		       
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryPageInstance.clickOnNewInsertionOrderBtn();
		   
		       
		       //RolesLandingPage RolesLandingPageInstance = PageFactory.initElements(driver, RolesLandingPage.class);
		       //RolesLandingPageInstance.searchForRoles("Custservice 1");
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       Thread.sleep(4000);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.enterComments();
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",2, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDateFromExcel("1",29,27);//swagata
		      // newOrderInstance.enterPubDate("1","23", "Dec", "2019");
		       //newOrderInstance.validateListOfProductTypes("1");
		       Thread.sleep(2000);
		       newOrderInstance.selectProductType("1",2, 1);
		       Thread.sleep(2000);
		       newOrderInstance.selectProduct("1",2, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",2, 3);
		       Thread.sleep(2000);
		       //newOrderInstance.selectSection("1",2, 4);
		       //Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           //newOrderInstance.removeSalesRepOnInsertion(1);
			   Thread.sleep(4000);				      
	           //newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			   //Thread.sleep(4000);
			 // newOrderInstance.clickOnInsertionSalesRepSection(1);
			 //  Thread.sleep(4000);
			 //  newOrderInstance.applytoAllSalesRepOnInsertion(1);
			   //Thread.sleep(2000);
		      // Thread.sleep(4000);
		      // newOrderInstance.addServiceRep("203486");
			//   Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(4000);
			
			  //newOrderInstance.clickOnContinuePastPubDate(); //joy
			 //Thread.sleep(2000);//joy
			
		       WebDriverWait wait = new WebDriverWait(driver,120);
		       
		       String orderID = orderEntryPageInstance.getOrderID();
		       Logger.info("Order: "+orderID);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(8000);
		 
		       orderEntryPageInstance.clickOnOrder(orderID);
		       
		       NewOrderPage orderViewPage = PageFactory.initElements(driver, NewOrderPage.class);
		       wait.until(ExpectedConditions.visibilityOf(orderViewPage.orderViewPageElement));
		       orderViewPage.convertInsertion();
		       Thread.sleep(5000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(1000);
			
		      
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	@Test(groups = {"SMaintenance","rolesRights", "ConvertIOToOrderUsingCustservice3Role" ,"NewRegression","NewRegression1", "Check","createNewOnlineOrder","Group3","TestPriority"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ConvertIOToOrderUsingCustservice3Role (Map<String, String> userData) throws Exception
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
		      // dashboardPageInstance.clickOnOrderEntryModule();
		       dashboardPageInstance.ClickOnUserAdminModule();
		       dashboardPageInstance.clickOnUserAdminUsersLink();
		       UsersLandingPage UsersLandingPageInstance = PageFactory.initElements(driver, UsersLandingPage.class);
		       UsersLandingPageInstance.searchForUsers("Jayanta");//swagata
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnEditUserButton();
		       Thread.sleep(1000);
		       UsersLandingPageInstance.ClickOnRolesTab();
		       UsersLandingPageInstance.EditWindowRoleNameSearch("Custservice3");
		       Thread.sleep(2000);
		       UsersLandingPageInstance.CheckUserRoleName("CUSTSERVICE3");
		       Thread.sleep(2000);
		       UsersLandingPageInstance.ClickOnSaveButton();
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnUserAdminRolesLink();
		       Thread.sleep(2000);
		       
		      RolesLandingPage RolesLandingPageInstance = PageFactory.initElements(driver, RolesLandingPage.class);
		      RolesLandingPageInstance.searchForRoles("custservice3");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnEditRoleButton("CUSTSERVICE3");
		      Thread.sleep(2000);
		      RolesLandingPageInstance.EditRoleWindowNameSearch("Jayanta");//swagata
		      Thread.sleep(2000);
		      RolesLandingPageInstance.ClickOnUserRoleName("Jayanta");//swagata
		      Thread.sleep(3000);
		      RolesLandingPageInstance.ClickOnSaveButton ();
		      Thread.sleep(2000);
		      
		      //RolesLandingPageInstance.EditRoleWindowNameSearch(Name);
		    
		       
		       
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryPageInstance.clickOnNewInsertionOrderBtn();
		   
		       
		       //RolesLandingPage RolesLandingPageInstance = PageFactory.initElements(driver, RolesLandingPage.class);
		       //RolesLandingPageInstance.searchForRoles("Custservice 1");
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		      
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       Thread.sleep(2000);
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       Thread.sleep(2000);
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.enterComments();
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",2, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDateFromExcel("1",29,27);//swagata
		       //newOrderInstance.enterPubDate("1","23", "Dec", "2019");
		       //newOrderInstance.validateListOfProductTypes("1");
		       Thread.sleep(2000);
		       newOrderInstance.selectProductType("1",2, 1);
		       Thread.sleep(2000);
		       newOrderInstance.selectProduct("1",2, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",2, 3);
		       Thread.sleep(2000);
		       //newOrderInstance.selectSection("1",2, 4);
		       //Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           //newOrderInstance.removeSalesRepOnInsertion(1);
			   Thread.sleep(4000);				      
	          // newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			 //  Thread.sleep(4000);
			 // newOrderInstance.clickOnInsertionSalesRepSection(1);
			 //  Thread.sleep(4000);
			 //  newOrderInstance.applytoAllSalesRepOnInsertion(1);
			  // Thread.sleep(2000);
		      // Thread.sleep(4000);
		      // newOrderInstance.addServiceRep("203486");
			//   Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(4000);
			
			 //newOrderInstance.clickOnContinuePastPubDate(); //joy
			 //Thread.sleep(2000);
			
		       WebDriverWait wait = new WebDriverWait(driver,120);
		       
		       String orderID = orderEntryPageInstance.getOrderID();
		       Logger.info("Order: "+orderID);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(8000);
		       
		       
		       orderEntryPageInstance.clickOnOrder(orderID);
		       
		       NewOrderPage orderViewPage = PageFactory.initElements(driver, NewOrderPage.class);
		       wait.until(ExpectedConditions.visibilityOf(orderViewPage.orderViewPageElement));
		       orderViewPage.convertInsertion();
		       Thread.sleep(5000);
		       newOrderInstance.submitOrder();
		     
			
		      
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	
	@Test(groups = {"SMaintenance","NewRegression3","SwagataMou","NewRegression","UnassignBUFromUserTest","ProductionTest", "Check","ProductionTest4","createNewOnlineOrder","Group3","TestPriority","ProductionTestPriority","ProductionTestCI"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void UnassignBUFromUserTest (Map<String, String> userData) throws Exception
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
		      // dashboardPageInstance.clickOnOrderEntryModule();
		       dashboardPageInstance.ClickOnUserAdminModule();
		       dashboardPageInstance.clickOnUserAdminUsersLink();
		       Thread.sleep(5000);
		       driver.navigate().refresh();
		       Thread.sleep(3000);
		      UsersLandingPage UsersLandingPageInstance = PageFactory.initElements(driver, UsersLandingPage.class);
		      UsersLandingPageInstance.searchForUsers("Jayanta");//swagata
		      Thread.sleep(2000);
		      UsersLandingPageInstance.ClickOnEditUserButton();
		      Thread.sleep(2000);
		     UsersLandingPageInstance.ClickOnUserBUName("DPR-Daily Press");
		     UsersLandingPageInstance.ClickOnSaveButton();
		      
		      dashboardPageInstance.clickOnOrderEntryModule();
		      OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       //orderEntryPageInstance.clickOnNewGeneralOrder();
		       orderEntryPageInstance.clickOnNewInsertionOrderBtn();
		      NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		      newOrderInstance.createNewInsertion();
		      Thread.sleep(1000);
		       newOrderInstance.selectNewInsertionBUCheck("DPR");
		       Thread.sleep(2000);
		       
		       dashboardPageInstance.ClickOnUserAdminModule();
		       dashboardPageInstance.clickOnUserAdminUsersLink();
		       Thread.sleep(4000);
		       //orderEntryPageInstance.clickOnDiscardYesBtn();
				newOrderInstance.displayWarningMessageConfirm();//swagata
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnUserAdminUsersLink();
		       
		      //UsersLandingPage UsersLandingPageInstance = PageFactory.initElements(driver, UsersLandingPage.class);
		      UsersLandingPageInstance.searchForUsers("Jayanta");//swagata
		      Thread.sleep(2000);
		      UsersLandingPageInstance.ClickOnEditUserButton();
		      Thread.sleep(2000);
		     UsersLandingPageInstance.ClickOnUserBUName("DPR-Daily Press");
		     UsersLandingPageInstance.ClickOnSaveButton();
		       
		       
		      
		      

}
		
		catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	}

	
}


		    

		    





































	



