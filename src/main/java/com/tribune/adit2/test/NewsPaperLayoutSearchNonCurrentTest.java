package com.tribune.adit2.test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class NewsPaperLayoutSearchNonCurrentTest 
{
	/**
	 * This test will perform a search operation for news paper layouts where 
	 * current template is not selected
	 */
	
	@Test(groups = {"NewsPaperLayouts","Regression","NewsPaperLayoutsReg","Grp3","RegressionLatest","Group2","Group2F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
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
		       Thread.sleep(2000);
		       layoutPage.checkOrUncheckCurrentTemplate(false);
		       layoutPage.clickOnSearch();
		       Thread.sleep(4000);
		       String count = layoutPage.countOfResultsFound.getText();
		       Logger.info("Count of the results found: " +count);
		       layoutPage.validateSearchAllTemplates("DailyPress_Section_Sports");
		       
		       dashboardPageInstance.clickOnLogout();
		    }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
}
