/**package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.NewsPaperLayout.NewsPaperLayoutsPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;


 * @author Priyanka Goud CR 
 * @since April 2017
 * @description This test create a new news paper layout template and delete the template using 
 * 				the delete option on the search page
 

public class NewsPaperLayoutDeleteTest 
{
	@Test(groups = {"NewsPaperLayouts", "DeleteTemplate"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void deleteNewsPaperLayout(Map<String, String> userData) throws Exception
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
		       layoutPage.selectSection(2);
		       layoutPage.checkOrUncheckCurrentTemplate(true);
		       layoutPage.clickOnSearch();
		       Thread.sleep(4000);
		       
		       int idBeforeLayoutAddition = layoutPage.getLatestNewsPaperLayoutID();
		       
		       layoutPage.clickOnNewTemplateBtn();
		       Thread.sleep(1000);
		       layoutPage.enterDescription();
		       layoutPage.selectDatetype("EffectiveDate");
		       layoutPage.enterDate("26", "Jul", "2017");
		       layoutPage.saveNewTemplate();
		       Thread.sleep(2000);
		       
		       driver.navigate().refresh();
		       
		       layoutPage.selectBU("BU_DPR");
		       layoutPage.selectDayOfWeek("DayOfWeek_Wed");
		       layoutPage.selectProduct("DPRProduct_DailyPress");
		       layoutPage.selectSection(2);
		       layoutPage.checkOrUncheckCurrentTemplate(true);
		       Thread.sleep(1000);
		       layoutPage.clickOnSearch();
		       Thread.sleep(4000);
		       
		       int idAfterLayoutAddition = layoutPage.getLatestNewsPaperLayoutID();
		       boolean flag = false;
		       if(idAfterLayoutAddition>idBeforeLayoutAddition)
		       {
		    	   Logger.info("New Template ("+idAfterLayoutAddition+") added successfully");
		    	   flag = true;
		       }
		       Assert.assertEquals(flag, true);
		       
		       layoutPage.clickOnTakeOfflineButtonLatestNewsLayout();
		       layoutPage.clickOnDeleteButtonLatestNewsLayout();
		       Thread.sleep(1000);
		       
		       boolean deleteFlag = layoutPage.searchForSpecificNewsPaperLayout(idAfterLayoutAddition);
		       Assert.assertEquals(deleteFlag, false);
		       
		       dashboardPageInstance.clickOnLogout();
		       }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
	
	@Test(groups = {"NewsPaperLayouts", "DeleteTemplate1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void deleteNewsPaperLayoutFromMoreOptions(Map<String, String> userData) throws Exception
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
		       layoutPage.selectSection(2);
		       layoutPage.checkOrUncheckCurrentTemplate(false);
		       layoutPage.clickOnSearch();
		       Thread.sleep(4000);
		       
		       int idBeforeLayoutAddition = layoutPage.getLatestNewsPaperLayoutID();
		       
		       layoutPage.clickOnNewTemplateBtn();
		       Thread.sleep(1000);
		       layoutPage.enterDescription();
		       layoutPage.selectDatetype("EffectiveDate");
		       layoutPage.enterDate("26", "Jul", "2017");
		       layoutPage.saveNewTemplate();
		       Thread.sleep(2000);
		       
		       driver.navigate().refresh();
		       
		       layoutPage.selectBU("BU_DPR");
		       layoutPage.selectDayOfWeek("DayOfWeek_Wed");
		       layoutPage.selectProduct("DPRProduct_DailyPress");
		       layoutPage.selectSection(2);
		       layoutPage.checkOrUncheckCurrentTemplate(false);
		       Thread.sleep(1000);
		       layoutPage.clickOnSearch();
		       Thread.sleep(4000);
		       
		       int idAfterLayoutAddition = layoutPage.getLatestNewsPaperLayoutID();
		       boolean flag = false;
		       if(idAfterLayoutAddition>idBeforeLayoutAddition)
		       {
		    	   Logger.info("New Template ("+idAfterLayoutAddition+") added successfully");
		    	   flag = true;
		       }
		       Assert.assertEquals(flag, true);
		       
		       layoutPage.clickMoreButtonInLatestNewsLayout();
		       layoutPage.clickDeleteButtonInLatestNewsLayoutUnderMore();
		       Thread.sleep(1000);
		       
		       boolean deleteFlag = layoutPage.searchForSpecificNewsPaperLayout(idAfterLayoutAddition);
		       Assert.assertEquals(deleteFlag, false);
		       
		       dashboardPageInstance.clickOnLogout();
		       }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
}*/
