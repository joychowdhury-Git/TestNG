package com.tribune.adit2.test;

import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tribune.adit2.Fullfillment.FullfillmentSystemsPage;
import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

public class FullfillmentSystemTest 
{
	/**
	 * @description This method searches for a fullfillment system
	 */
	@Test(groups = {"FullfillmentSystem"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void searchFullfillmentSystem(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnFullFillmentModuleLink();
		       dashboardPageInstance.clickOnFullfillmentSystemsLink();
		       
		       FullfillmentSystemsPage systemPageInstance = PageFactory.initElements(driver, FullfillmentSystemsPage.class);
		       systemPageInstance.searchForFullfillmentSystem("BillOrder");
		       boolean flag = systemPageInstance.validateFullfillmentSystemSearch("BillOrder");
		       Assert.assertEquals(flag, true);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 *  @description This method activates or deactivates given fullfillment system
	 */
	@Test(groups = {"FullfillmentSystem"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void activateDeactivateFullfillmentSystem(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnFullFillmentModuleLink();
		       dashboardPageInstance.clickOnFullfillmentSystemsLink();
		       
		       FullfillmentSystemsPage systemPageInstance = PageFactory.initElements(driver, FullfillmentSystemsPage.class);
		       systemPageInstance.searchForFullfillmentSystem("Rey Adit 2_0 QA test");
		       systemPageInstance.clickOnFullfillmentSystem("Rey Adit 2_0 QA test");
		       systemPageInstance.activateDeactivateFullfillmentSystem(true);
		       Properties properties = TribuneUtils.readProperties();
		       Assert.assertEquals(systemPageInstance.getFullfillmentStatusChangeMessage(), properties.getProperty("ActiveMessage"));
		       Thread.sleep(2000);
		       systemPageInstance.activateDeactivateFullfillmentSystem(false);
		       Assert.assertEquals(systemPageInstance.getFullfillmentStatusChangeMessage(), properties.getProperty("DeactiveMessage"));
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 *  @description This method creates new fullfillment system
	 */
	@Test(groups = {"FullfillmentSystem"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewFullfillmentSystem(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnFullFillmentModuleLink();
		       dashboardPageInstance.clickOnFullfillmentSystemsLink();
		       
		       FullfillmentSystemsPage systemPageInstance = PageFactory.initElements(driver, FullfillmentSystemsPage.class);
		       systemPageInstance.clickOnNewIntegrationSystemsBtn();
		       systemPageInstance.enterNameOfFullfillmentSystem();
		       systemPageInstance.enterDescriptionOfFullfillmentSystem();
		       systemPageInstance.enterSequenceOfFullfillmentSystem();
		       systemPageInstance.checkUncheckAbortOnExceptions(true);
		       
		       //**** The below lines of code will add a new fullfillment system to Adit 2.0. Use only when required ****//
		       
		       /*systemPageInstance.clickOnSaveFullfillmentSystem();
		       systemPageInstance.selectBusinessUnit("bu_DPR");
		       systemPageInstance.clickOnCreate();
		       systemPageInstance.checkUncheckUseFTP(true);
		       systemPageInstance.enterFTPServerOfFullfillmentSystem();
		       systemPageInstance.enterFTPPathOfFullfillmentSystem();
		       systemPageInstance.enterFTPUsernameOfFullfillmentSystem();
		       systemPageInstance.enterFTPPasswordOfFullfillmentSystem();
		       systemPageInstance.enterFilePathOfFullfillmentSystem();
		       systemPageInstance.enterDaysToKeepFilesForFullfillmentSystem(1);
		       systemPageInstance.checkUncheckUsePlugin(false);
		       systemPageInstance.selectModuleName("FSModuleName1");*/
		       
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
