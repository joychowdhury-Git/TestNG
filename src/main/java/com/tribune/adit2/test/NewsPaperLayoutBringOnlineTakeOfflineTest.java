

	package com.tribune.adit2.test;

	import java.util.Map;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.tribune.adit2.Home.DashboardPage;
	import com.tribune.adit2.Home.SignInPage;
	import com.tribune.adit2.NewsPaperLayout.NewsPaperLayoutViewPage;
	import com.tribune.adit2.NewsPaperLayout.NewsPaperLayoutsPage;
	import com.tribune.adit2.OrderEntry.NewOrderPage;
	import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
	import com.tribune.adit2.testng.Logger;
	import com.tribune.adit2.testng.WebDriverManager;
	import com.tribune.adit2.util.Configurator;
	import com.tribune.adit2.util.TribuneUtils;
	
	public class NewsPaperLayoutBringOnlineTakeOfflineTest 
	{
		/**
		 * @author smukherjee - Sunny
		 * @param userData
		 * @throws Exception
		 * @description This test method creates a new newspaper template and adds first page to it. 
		 * 				Then it checks when Take offline button is clicked, template gets locked 
		 * 				When Bring online button is clicked, template lock goes away
		 */
		
		@Test(groups = {"NewsPaperLayouts","OfflineOnline","NewsPaperLayoutsReg","Group2","Group2F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
		public void offlineOnline(Map<String, String> userData) throws Exception
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
			       Thread.sleep(3000);
			       layoutPage.selectBU("BU_DPR");
			       layoutPage.selectDayOfWeek("DayOfWeek_Wed");
			       layoutPage.selectProduct("DPRProduct_DailyPress");
			       layoutPage.selectSection(0);
			       layoutPage.checkOrUncheckCurrentTemplate(true);
			       
			       //create a new template
			       layoutPage.clickOnNewTemplateBtn();
			       Thread.sleep(1000);
			       layoutPage.enterDescription();
			       layoutPage.selectDatetype("EffectiveDate");
			       Thread.sleep(2000);
			       layoutPage.enterDate("25", "Jul", "2019");
			       layoutPage.checkUncheckInheritFrom(false);
			       layoutPage.saveNewTemplate();
			       String templateid = layoutPage.getTemplateID();
			       Thread.sleep(2000);
			       
			       driver.navigate().refresh();
			       layoutPage.selectBU("BU_DPR");
			       layoutPage.selectDayOfWeek("DayOfWeek_Wed");
			       layoutPage.selectProduct("DPRProduct_DailyPress");
			       layoutPage.selectSection(0);
			       layoutPage.checkOrUncheckCurrentTemplate(true);
			       Thread.sleep(1000);
			       layoutPage.clickOnSearch();
			       Thread.sleep(4000);
			       layoutPage.clickOnTemplate(templateid);
			       
			       NewsPaperLayoutViewPage layoutViewPage = PageFactory.initElements(driver, NewsPaperLayoutViewPage.class);
			       Thread.sleep(1000);
			       
			       //add first page for the new template created
			       layoutViewPage.clickOnAddFirstPage();
			       layoutViewPage.enterTemplateName();
			       layoutViewPage.enterTemplateDescription();
			       layoutViewPage.selectCommonPageCheckBox(true);
			       layoutViewPage.selectColorPageCheckBox(true);
			       layoutViewPage.selectTypeOfColor("Spot Color");
			       layoutViewPage.clickOnSaveNewPage();
			       Thread.sleep(4000);
			       layoutViewPage.clickOnBringOnlineButton();
			       layoutViewPage.clickOnTakeOfflineButton();
			       layoutViewPage.verifyTemplateLocked();
			    
			       }
			   
			   catch(Exception e)
			   {
				   Logger.error(e.getMessage());
					  throw e;
			   }
		} 
		
		@Test(groups = {"NewsPaperLayouts","takeOfflineCheckLock","NewsPaperLayoutsReg","Group2","Group2F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
		public void takeOfflineCheckLock(Map<String, String> userData) throws Exception
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
			       Thread.sleep(3000);
			       layoutPage.selectBU("BU_Sun");
			       layoutPage.selectDayOfWeek("DayOfWeek_Wed");
			       layoutPage.selectProduct("SSCProduct_SunSentinel");
			       layoutPage.selectSection(0);
			       layoutPage.checkOrUncheckCurrentTemplate(true);
			       
			       //create a new template
			       layoutPage.clickOnNewTemplateBtn();
			       Thread.sleep(1000);
			       layoutPage.enterDescription();
			       layoutPage.selectDatetype("EffectiveDate");
			       Thread.sleep(2000);
			       layoutPage.enterDate("24", "Jul", "2019");
			       layoutPage.checkUncheckInheritFrom(false);
			       layoutPage.saveNewTemplate();
			       String templateid = layoutPage.getTemplateID();
			      
			       
			       driver.navigate().refresh();
			       layoutPage.selectBU("BU_Sun");
			       layoutPage.selectDayOfWeek("DayOfWeek_Wed");
			       layoutPage.selectProduct("SSCProduct_SunSentinel");
			       layoutPage.selectSection(0);
			       layoutPage.checkOrUncheckCurrentTemplate(true);
			       Thread.sleep(1000);
			       layoutPage.clickOnSearch();
			       Thread.sleep(4000);
			       layoutPage.clickOnTemplate(templateid);
			       //get template ID for new template
			     //  int newLayoutID = layoutPage.getLatestNewsPaperLayoutID();
			     //  Logger.info("New layout ID is " +layoutPage.getLatestNewsPaperLayoutID());
			       
			     //  layoutPage.clickOnNewsPaperLayoutID(newLayoutID);
			       
			       NewsPaperLayoutViewPage layoutViewPage = PageFactory.initElements(driver, NewsPaperLayoutViewPage.class);
			       Thread.sleep(1000);
			       
			       //add first page for the new template created
			       layoutViewPage.clickOnAddFirstPage();
			       layoutViewPage.enterTemplateName();
			       layoutViewPage.enterTemplateDescription();
			       layoutViewPage.selectCommonPageCheckBox(true);
			       layoutViewPage.selectColorPageCheckBox(true);
			       layoutViewPage.selectTypeOfColor("Spot Color");
			       layoutViewPage.clickOnSaveNewPage();
			       Thread.sleep(4000);
			       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			       utilities.implementWait(driver);		    
			       
			       signinPageinstance.login2("success","rsahoo","Tribune8");
			       dashboardPageInstance.clickOnNewsPaperLayoutModule();
			       layoutPage.selectBU("BU_Sun");
			       layoutPage.selectDayOfWeek("DayOfWeek_Wed");
			       layoutPage.selectProduct("SSCProduct_SunSentinel");
			       layoutPage.selectSection(0);
			       layoutPage.checkOrUncheckCurrentTemplate(true);
			       Thread.sleep(1000);
			       layoutPage.clickOnSearch();
			       Thread.sleep(4000);
			       			      
			       layoutPage.clickOnTemplate(templateid);
			       Thread.sleep(4000);

			       layoutViewPage.verifyTemplateLocked();
			       Thread.sleep(4000);
			       }
			   
			   catch(Exception e)
			   {
				   Logger.error(e.getMessage());
					  throw e;
			   }
		} 
	}


