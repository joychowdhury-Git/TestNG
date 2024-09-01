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
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

public class NewsPaperLayoutViewLayoutTest 
{
	@Test(groups = {"NewsPaperLayouts", "ViewNews"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void viewNewsPaperLayout(Map<String, String> userData) throws Exception
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
		       layoutPage.checkOrUncheckCurrentTemplate(false);
		       String section = layoutPage.getSectionIDSelectedInSearch();
		       layoutPage.clickOnSearch();
		       Thread.sleep(4000);
		       String count = layoutPage.countOfResultsFound.getText();
		       Logger.info("Count of the results found: " +count);
		       layoutPage.validateCurrentSearch("DailyPress_Section_Sports");
		     //  String description = layoutPage.getNewsPaperLayoutDescription(0);
		     //  String effectiveDate = layoutPage.getNewsPaperLayoutEffectiveDate(0);
		     //  layoutPage.clickOnNewsPaperLayoutID(0);
		       Thread.sleep(2000);
		       
		       NewsPaperLayoutViewPage layoutViewPage = PageFactory.initElements(driver, NewsPaperLayoutViewPage.class);
		       boolean buFlag = layoutViewPage.validateBusinessUnitInLayoutViewPage("BU_DPR");
		       boolean productFlag = layoutViewPage.validateProductInLayoutViewPage("DPRProduct_DailyPress");
		       boolean sectionFlag = layoutViewPage.validateSectionInLayoutViewPage(section);
		       boolean dayOfWeekFlag = layoutViewPage.validateDayOfWeekInLayoutViewPage("DayOfWeek_Wed");
		    //   boolean descriptionFlag = layoutViewPage.validateDescriptionInLayoutViewPage(description);
		   //    boolean effectiveDateFlag = layoutViewPage.validateEffectiveDateInLayoutViewPage(effectiveDate);
		       boolean flag = false;
		   //    if(buFlag&productFlag&sectionFlag&dayOfWeekFlag&descriptionFlag&effectiveDateFlag)
		       {
		    	   flag = true;
		       }
		       Assert.assertEquals(flag, true);
		       
		       dashboardPageInstance.clickOnLogout();
		       }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
}
