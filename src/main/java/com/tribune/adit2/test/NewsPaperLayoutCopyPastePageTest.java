/**package com.tribune.adit2.test;

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

public class NewsPaperLayoutCopyPastePageTest 
{
	
	 * @author cymkozalg6 - Priyanka
	 * @param userData
	 * @throws Exception
	 * @description This test method create a new template, add first page to it and 
	 * 				then edits the page created followed by print page.
	
	
	@Test(groups = {"NewsPaperLayouts","EditPrintPage","testu"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void editAndPrintPage(Map<String, String> userData) throws Exception
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
		       layoutPage.enterDate("26", "Jul", "2017");
		       layoutPage.checkUncheckInheritFrom(false);
		       
		       layoutPage.saveNewTemplate();
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
		       
		       //get template ID for new template
		       int newLayoutID = layoutPage.getLatestNewsPaperLayoutID();
		       Logger.info("New layout ID is " +layoutPage.getLatestNewsPaperLayoutID());
		       
		       layoutPage.clickOnNewsPaperLayoutID(newLayoutID);
		       
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
		       
		       layoutViewPage.clickOnPageNumAndNameSection();
		       layoutViewPage.clickOnMoreOptionsOnPageButton(1);
		       layoutViewPage.clickOnInsertPageAfterButton(1);
		       
		      
		       layoutViewPage.enterTemplateName();
		       layoutViewPage.enterTemplateDescription();
		       layoutViewPage.selectCommonPageCheckBox(true);
		       layoutViewPage.selectColorPageCheckBox(true);
		       layoutViewPage.selectTypeOfColor("Spot Color");
		       layoutViewPage.clickOnSaveNewPage();
		       
		       layoutViewPage.clickOnMoreOptionsOnPageButton(1);
		       layoutViewPage.clickOnCopyPageButton();
		       
		       layoutViewPage.goToRequiredPage(2);
		       
		       layoutViewPage.clickOnMoreOptionsOnPageButton(2);
		       layoutViewPage.clickOnPastePageButton();
		       
		       
		       dashboardPageInstance.clickOnLogout();
		       }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
} */
