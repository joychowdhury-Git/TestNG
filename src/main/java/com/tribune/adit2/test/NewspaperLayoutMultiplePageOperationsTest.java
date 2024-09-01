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

public class NewspaperLayoutMultiplePageOperationsTest 
{
	/**
	 * @author cymkozalg6 - Priyanka
	 * @param userData
	 * @throws Exception
	 * @description Perform below page operations
						- Add first page
						- insert page before
						- insert page after
						- navigate pages using the arrows keys
						- search the page using the search box 
	 */
	
	@Test(groups = {"NewsPaperLayouts","MultiPageOperations"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void multiplePageOperations(Map<String, String> userData) throws Exception
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
		       Thread.sleep(2000);
		       
		       layoutPage.clickOnTemplate(templateid);
		       
		       NewsPaperLayoutViewPage layoutViewPage = PageFactory.initElements(driver, NewsPaperLayoutViewPage.class);
		       Thread.sleep(1000);
		       
		       //add first page for the new template created
		       layoutViewPage.clickOnAddFirstPage();
		       Thread.sleep(2000);
		       layoutViewPage.enterTemplateName();
		       layoutViewPage.enterTemplateDescription();
		       layoutViewPage.selectCommonPageCheckBox(true);
		       layoutViewPage.selectColorPageCheckBox(true);
		       layoutViewPage.selectTypeOfColor("Spot Color");
		       layoutViewPage.clickOnSaveNewPage();
		       Thread.sleep(4000);
		       
		       layoutViewPage.clickOnASectionOfAPage();
		       
		       Thread.sleep(6000);
		       
		      /* layoutViewPage.clickOnPageNumAndNameSection();
		       layoutViewPage.clickOnMoreOptionsOnPageButton(1);
		       layoutViewPage.clickOnInsertPageAfterButton(1);
		       
		       
		       layoutViewPage.enterTemplateName();
		       layoutViewPage.enterTemplateDescription();
		       layoutViewPage.selectCommonPageCheckBox(true);
		       layoutViewPage.selectColorPageCheckBox(true);
		       layoutViewPage.selectTypeOfColor("Spot Color");
		       layoutViewPage.clickOnSaveNewPage();
		       Thread.sleep(4000);
		       
		       layoutViewPage.goToRequiredPage(2);
		       Thread.sleep(4000);
		       
		       layoutViewPage.clickOnPageNumAndNameSection();
		       layoutViewPage.clickOnMoreOptionsOnPageButton(2);
		       layoutViewPage.clickOnInsertPageBeforeButton(2);
		       
		       layoutViewPage.enterTemplateName();
		       layoutViewPage.enterTemplateDescription();
		       layoutViewPage.selectCommonPageCheckBox(false);
		       layoutViewPage.selectColorPageCheckBox(true);
		       layoutViewPage.selectTypeOfColor("Full Color");
		       layoutViewPage.clickOnSaveNewPage();
		       Thread.sleep(4000);
		       
		       layoutViewPage.goToRequiredPage(1);
		       Thread.sleep(4000);
		       
		       layoutViewPage.clickOnGoToNextPageButton();
		       layoutViewPage.clickOnGoToPreviousPageButton();
		       layoutViewPage.clickOnGoToLastPageButton();
		       layoutViewPage.clickOnGoToFirstPageButton();*/
		       
		       //dashboardPageInstance.clickOnLogout();
		       }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
}
