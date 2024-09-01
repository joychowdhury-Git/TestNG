

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
	 * Page Operation options existence for Newspaper Layout view (Edit, Delete, Copy Page content, Paste page content, Insert page Before, insert page after, Export to Library and Import to Library options are visible)
	 * @author Sunny 
	 * @since January 2017
	 */



public class NewsPaperLayoutPageOperationOptions 
	{
		/**
		 * This test will perform a search operation for news paper layouts that are current
		 */
		
		@Test(groups = {"NewsPaperLayouts","Regression","NewsPaperLayoutsReg","Grp3","verifyPageOperationsNewsPaperLayout"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
		public void verifyPageOperationsNewsPaperLayout(Map<String, String> userData) throws Exception
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
			       layoutPage.selectSection(0);
			       layoutPage.checkOrUncheckCurrentTemplate(true);
			       layoutPage.clickOnNewTemplateBtn();
			       Thread.sleep(1000);
			       layoutPage.enterDescription();
			       layoutPage.selectDatetype("EffectiveDate");
			       Thread.sleep(2000);
			       layoutPage.enterDate("24", "Jul", "2019");
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
			     
			       Thread.sleep(4000);
			       NewsPaperLayoutViewPage layoutViewPage = PageFactory.initElements(driver, NewsPaperLayoutViewPage.class);
			       Thread.sleep(1000);
			       layoutViewPage.clickOnAddFirstPage();
			       layoutViewPage.enterTemplateName();
			       layoutViewPage.enterTemplateDescription();
			       layoutViewPage.selectCommonPageCheckBox(true);
			       layoutViewPage.selectColorPageCheckBox(true);
			       layoutViewPage.selectTypeOfColor("Spot Color");
			       layoutViewPage.clickOnSaveNewPage();
			       Thread.sleep(4000);
			       //layoutViewPage.clickOnTakeOfflineButton();
			       layoutViewPage.rightClickOnPageNumAndNameSection();
			       layoutViewPage.verifyPageOperationOptions();			       
			       //dashboardPageInstance.clickOnLogout();
			       }
			   catch(Exception e)
			   {
				   Logger.error(e.getMessage());
					  throw e;
			   }
		}
	}
