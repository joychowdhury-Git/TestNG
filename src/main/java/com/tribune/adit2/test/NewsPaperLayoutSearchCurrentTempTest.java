package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.NewsPaperLayout.NewsPaperLayoutsPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Order Entry Home Page
 * @author Priyanka Goud CR 
 * @since November 2015
 */

public class NewsPaperLayoutSearchCurrentTempTest 
{
	/**
	 * This test will perform a search operation for news paper layouts that are current
	 */
	
	@Test(groups = {"NewsPaperLayouts","SanityTestNew","Regression","ProductionSanityTest1", "ProductionTest","NewsPaperLayoutsReg","RegressionLatest","Grp3","searchNewsPaperLayout","Group2","TestPriority","ProductionTestCI"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void searchNewsPaperLayout(Map<String, String> userData) throws Exception
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
		       layoutPage.selectDayOfWeek("DayOfWeek_Wed");
		       layoutPage.selectProduct("DPRProduct_DailyPress");
		       layoutPage.selectSection(2);
		       layoutPage.checkOrUncheckCurrentTemplate(true);
		       layoutPage.clickOnSearch();
		       Thread.sleep(4000);
		       String count = layoutPage.countOfResultsFound.getText();
		       Logger.info("Count of the results found: " +count);
		       layoutPage.validateCurrentSearch("DailyPress_Section_Sports");
		       
		       dashboardPageInstance.clickOnLogout();
		       }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
	@Test(groups = {"NewsPaperLayoutsReg1","Regression","ProductionSanityTest1", "searchNewsPaperLayoutForCTShopsHereTMCjacket","NewsPaperLayoutsReg","RegressionLatest","Grp1","searchNewsPaperLayout","Group2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void searchNewsPaperLayoutForCTShopsHereTMCjacket(Map<String, String> userData) throws Exception
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
		       layoutPage.selectBU("BU_HTF");
		       layoutPage.selectDayOfWeek("DayOfWeek_Sat");
		       layoutPage.selectProduct1("CTShopsHere TMC Jacket");
		       //layoutPage.selectSection(2);
		       layoutPage.checkOrUncheckCurrentTemplate(true);
		       layoutPage.clickOnSearch();
		       
		       }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
	
	@Test(groups = {"NewsPaperLayoutsReg1","Regression","ProductionSanityTest1", "ProductionTest","NewsPaperLayoutsReg","RegressionLatest","Grp1","searchNewsPaperLayout","Group2","TestPriority"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void searchNewsPaperLayoutForHC(Map<String, String> userData) throws Exception
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
		       layoutPage.selectBU("BU_HTF");
		       layoutPage.selectDayOfWeek("DayOfWeek_Thur");
		       layoutPage.selectProduct1("HC Select");
		      // layoutPage.selectSection(2);
		       layoutPage.checkOrUncheckCurrentTemplate(true);
		       layoutPage.clickOnSearch();
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnLogout();
		       		      
		       }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
	@Test(groups = {"NewsPaperLayoutsReg1","Regression","ProductionSanityTest1", "ProductionTest","NewsPaperLayoutsReg","RegressionLatest","Grp1","searchNewsPaperLayout","Group2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void searchNewsPaperLayoutForHCSelect(Map<String, String> userData) throws Exception
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
		       layoutPage.selectBU("BU_HTF");
		       layoutPage.selectDayOfWeek("DayOfWeek_Fri");
		       layoutPage.selectProduct1("HC Select");
		     //  layoutPage.selectSection(2);
		       layoutPage.checkOrUncheckCurrentTemplate(true);
		       layoutPage.clickOnSearch();
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnLogout();
		       
		       }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
	
	@Test(groups = {"NewsPaperLayoutsReg1","Regression","ProductionSanityTest1", "ProductionTest","NewsPaperLayoutsReg","RegressionLatest","Grp1","searchNewsPaperLayout","Group2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void searchNewsPaperLayoutForHCSpecial(Map<String, String> userData) throws Exception
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
		       layoutPage.selectBU("BU_HTF");
		       layoutPage.selectDayOfWeek("DayOfWeek_Sat");
		       layoutPage.selectProduct1("HC Special Sections");
		      // layoutPage.selectSection(2);
		       layoutPage.checkOrUncheckCurrentTemplate(true);
		       layoutPage.clickOnSearch();
		       Thread.sleep(3000);
		       dashboardPageInstance.clickOnLogout();
		       
		       }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
}
