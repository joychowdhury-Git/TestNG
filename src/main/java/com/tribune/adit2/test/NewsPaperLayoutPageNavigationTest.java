
	package com.tribune.adit2.test;

	import java.util.Map;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.annotations.Test;

	import com.tribune.adit2.Home.DashboardPage;
	import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.NewsPaperLayout.NewsPaperLayoutViewPage;
import com.tribune.adit2.NewsPaperLayout.NewsPaperLayoutsPage;
	import com.tribune.adit2.testng.Logger;
	import com.tribune.adit2.testng.WebDriverManager;
	import com.tribune.adit2.util.Configurator;
	import com.tribune.adit2.util.TribuneUtils;

	/**
	 * Page Navigation for Newspaper Layout view 
	 * @author Sunny 
	 * @since January 2017
	 */


public class NewsPaperLayoutPageNavigationTest 
	{
		/**
		 * This test will perform a search operation for news paper layouts that are current
		 */
		
		@Test(groups = {"NewsPaperLayouts","Regression","NewsPaperLayoutsReg","RegressionLatest","Grp3","navigationNewsPaperLayout","Group2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
		public void navigationNewsPaperLayout(Map<String, String> userData) throws Exception
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
			       layoutPage.clickOnFirstNewsPaperLayoutID();
			       Thread.sleep(4000);
			       NewsPaperLayoutViewPage layoutViewPage = PageFactory.initElements(driver, NewsPaperLayoutViewPage.class);
			       Thread.sleep(1000);
			       layoutViewPage.clickOnGoToFirstPageButton();
			       layoutViewPage.getPageNumber();
			       layoutViewPage.clickOnGoToNextPageButton();
			       layoutViewPage.getPageNumber();
			       layoutViewPage.clickOnGoToLastPageButton();
			       layoutViewPage.getPageNumber();
			       layoutViewPage.clickOnGoToPreviousPageButton();
			       layoutViewPage.getPageNumber();
			       dashboardPageInstance.clickOnLogout();
			       }
			   catch(Exception e)
			   {
				   Logger.error(e.getMessage());
					  throw e;
			   }
		}
	}
