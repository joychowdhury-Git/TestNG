package com.tribune.adit2.test;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.tribune.adit2.Fullfillment.FullfillmentRulesPage;
import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

public class FullfillmentRulesTest 
{
	/**
	 * @description This method searches for a fullfillment routing rule
	 */
	@Test(groups = {"FullfillmentRules"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void searchFullfillmentRoutingRule(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnFullfillmentRoutingRulesMenuLink();
		       
		       FullfillmentRulesPage rulesPageInstance = PageFactory.initElements(driver, FullfillmentRulesPage.class);
		       rulesPageInstance.clickOnRoutingRulesTab();
		       rulesPageInstance.searchForFullfillmentRoutingRules("RoutingRule1");
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * @description This method searches for a fullfillment global rule
	 */
	@Test(groups = {"FullfillmentRules1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void searchFullfillmentGlobalRule(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnFullfillmentRoutingRulesMenuLink();
		       
		       FullfillmentRulesPage rulesPageInstance = PageFactory.initElements(driver, FullfillmentRulesPage.class);
		       rulesPageInstance.clickOnGlobalRulesTab();
		       Thread.sleep(2000);		      
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
