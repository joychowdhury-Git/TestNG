package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class NewsPaperLayoutInsertBeforeAfterDeletePage 
{
	/**
	 * @author cymkozalg6 - Priyanka
	 * @param userData
	 * @throws Exception
	 * @description This test method creates a new newspaper template, adds first page to it and then deletes 
	 * 				the page added. 
	 */
	
	@Test(groups = {"NewsPaperLayouts","insertAfterPage","NewsPaperLayoutsReg","Grp3","RegressionLatest","Group2","Group2F","G2","RerunF2", "newspaperLayout"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void insertAfterPage(Map<String, String> userData) throws Exception
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
		       layoutPage.enterDate("19", "Feb", "2020");//mousumi
		       layoutPage.checkUncheckInheritFrom(true);
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
		       Thread.sleep(2000);
		       
		       layoutViewPage.rightClickOnPageNumAndNameSection();
		       
		       WebElement linkInsertAfterElement = driver.findElement(By.xpath("html/body/div[2]/ul/li[5]/a"));
		      
		       linkInsertAfterElement.click();	
		       layoutViewPage.enterTemplateName();
		       layoutViewPage.enterTemplateDescription();
		       layoutViewPage.selectCommonPageCheckBox(true);
		       layoutViewPage.selectColorPageCheckBox(true);
		       layoutViewPage.selectTypeOfColor("Spot Color");
		       layoutViewPage.clickOnSaveNewPage();
		       Thread.sleep(2000);
		       Logger.info("New page inserted after first page");
		       layoutViewPage.clickOnGoToNextPageButton();
		       layoutViewPage.getPageNumber();		          
		    //   dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
	
	@Test(groups = {"insertBeforePage","insertBeforeAfterDeletePage","NewsPaperLayoutsReg","Grp2","RegressionLatest","Group2","Group2F","G2","RerunF2", "newspaperLayout"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void insertBeforePage(Map<String, String> userData) throws Exception
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
		       layoutPage.enterDate("13", "Nov", "2019");
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
		       Thread.sleep(2000);
		       
		       layoutViewPage.rightClickOnPageNumAndNameSection();
		       
		       
		       WebElement linkInsertBeforeElement = driver.findElement(By.xpath("//a[text()='Insert Page Before ']"));		       
		      
		       linkInsertBeforeElement.click();	
		       layoutViewPage.enterTemplateName();
		       layoutViewPage.enterTemplateDescription();
		       layoutViewPage.selectCommonPageCheckBox(true);
		       layoutViewPage.selectColorPageCheckBox(true);
		       layoutViewPage.selectTypeOfColor("Spot Color");
		       layoutViewPage.clickOnSaveNewPage();
		       Thread.sleep(2000);
		       Logger.info("New page inserted before first page");
		       
		       layoutViewPage.getPageNumber();
		          
		     //  dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
	@Test(groups = {"NewsPaperLayouts","insertBeforeAfterDeletePage","NewsPaperLayoutsReg","RegressionLatest","Grp3","deletePage","Group2","Group2F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void deletePage(Map<String, String> userData) throws Exception
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
		       layoutPage.enterDate("13", "Nov", "2019");
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
		       Thread.sleep(2000);
		       
		      layoutViewPage.rightClickOnPageNumAndNameSection();
		       
		       
		       WebElement linkDeleteElement = driver.findElement(By.xpath("html/body/div[2]/ul/li[2]/a"));
		       	       
		       linkDeleteElement.click();
		       layoutViewPage.clickOnDeletePageButton();
		       Logger.info("First Page deleted");
		       Thread.sleep(4000);
		/*      // Validate if the page is deleted and add first page button is displayed
		       boolean flag = false;
		       if(layoutViewPage.addFirstPageButton.isDisplayed())
		       {
		    	   flag = true;
		       }
		       Assert.assertEquals(flag, true);
		     */ 
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
	@Test(groups = {"NewsPaperLayouts","changePageTypeZonedtoCommon","NewsPaperLayoutsReg","Grp3","RegressionLatest","Group2","Group2F","G2","RerunF2", "newspaperLayout"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void changePageTypeZonedtoCommon(Map<String, String> userData) throws Exception
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
		       layoutPage.selectDayOfWeek("DayOfWeek_Thur");
		       layoutPage.selectProduct("DPRProduct_VPtheBeacon");
		       layoutPage.selectSection(0);
		       layoutPage.checkOrUncheckCurrentTemplate(true);
		       
		       //create a new template
		       layoutPage.clickOnNewTemplateBtn();
		       Thread.sleep(1000);
		       layoutPage.enterDescription();
		       layoutPage.selectDatetype("EffectiveDate");
		       Thread.sleep(2000);//mou
		       layoutPage.enterDate("24", "Dec", "2019");//mou
		       //WebDriverWait wait = new WebDriverWait(driver,200); 
		       layoutPage.checkUncheckInheritFrom(false);
		       layoutPage.saveNewTemplate();
		       String templateid = layoutPage.getTemplateID();
		       Thread.sleep(2000);
		       
		       driver.navigate().refresh();
		       layoutPage.selectBU("BU_DPR");
		       layoutPage.selectDayOfWeek("DayOfWeek_Thur");
		       layoutPage.selectProduct("DPRProduct_VPtheBeacon");
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
		       layoutViewPage.selectCommonPageCheckBox(false);
		       layoutViewPage.selectColorPageCheckBox(true);
		       layoutViewPage.selectTypeOfColor("Spot Color");
		       layoutViewPage.clickOnSaveNewPage();
		       Thread.sleep(2000);
		       
		       layoutViewPage.rightClickOnPageNumAndNameSection();
		       Thread.sleep(2000);
		       
		       WebElement linkInsertAfterElement = driver.findElement(By.xpath("html/body/div[2]/ul/li[5]/a"));
		      
		       linkInsertAfterElement.click();	
		       layoutViewPage.enterTemplateName();
		       layoutViewPage.enterTemplateDescription();
		       layoutViewPage.selectCommonPageCheckBox(false);
		       layoutViewPage.selectColorPageCheckBox(true);
		       layoutViewPage.selectTypeOfColor("Spot Color");
		       layoutViewPage.clickOnSaveNewPage();
		       Thread.sleep(2000);
		       Logger.info("New page inserted after first page");
		       layoutViewPage.clickOnGoToNextPageButton();
		       String pageno1 = layoutViewPage.returnPageNumber();			      
		    //   dashboardPageInstance.clickOnLogout();
		       layoutViewPage.rightClickOnPageNumAndNameSection();
		       Thread.sleep(2000);
		       WebElement editPage = driver.findElement(By.xpath("html/body/div[2]/ul/li[1]/a"));
		       editPage.click();
		       layoutViewPage.selectCommonPageCheckBox(true);
		       layoutViewPage.clickOnSaveNewPage();
		       Thread.sleep(2000);
		       layoutViewPage.clickOnGoToLastPageButton();
		       String pageno2 = layoutViewPage.returnPageNumber();
		       Assert.assertTrue(pageno1.contains("Page 2 of 2"));
		       Assert.assertTrue(pageno1.contains("Zoned"));
		       Assert.assertTrue(pageno2.contains("Page 2 of 2"));
		       Assert.assertTrue(pageno2.contains("Common"));
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
	
	@Test(groups = {"NewsPaperLayouts","PrioritizedReg2","changePageTypeCommontoZoned","NewsPaperLayoutsReg","Grp3","RegressionLatest","Group2","Group2F","G2","RerunF2", "newspaperLayout"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void changePageTypeCommontoZoned(Map<String, String> userData) throws Exception
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
		       layoutPage.selectBU("BU_CTC");
		       layoutPage.selectDayOfWeek("DayOfWeek_Wed");
		       layoutPage.selectProduct("CTCProduct_ChicagoTribune");
		       layoutPage.selectSection(6);
		       layoutPage.checkOrUncheckCurrentTemplate(true);
		       
		       //create a new template
		       layoutPage.clickOnNewTemplateBtn();
		       Thread.sleep(1000);
		       layoutPage.enterDescription();
		       layoutPage.selectDatetype("EffectiveDate");
		       layoutPage.enterDate("15", "Jan", "2020");//mou
		       layoutPage.checkUncheckInheritFrom(false);
		       layoutPage.saveNewTemplate();
		       String templateid = layoutPage.getTemplateID();
		       Thread.sleep(2000);
		       
		       driver.navigate().refresh();
		       layoutPage.selectBU("BU_CTC");
		       layoutPage.selectDayOfWeek("DayOfWeek_Wed");
		       layoutPage.selectProduct("CTCProduct_ChicagoTribune");
		       layoutPage.selectSection(6);
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
		       
		       layoutViewPage.rightClickOnPageNumAndNameSection();
		       Thread.sleep(2000);
		       
		       WebElement linkInsertAfterElement = driver.findElement(By.xpath("html/body/div[2]/ul/li[5]/a"));
		      
		       linkInsertAfterElement.click();	
		       layoutViewPage.enterTemplateName();
		       layoutViewPage.enterTemplateDescription();
		       layoutViewPage.selectCommonPageCheckBox(true);
		       layoutViewPage.selectColorPageCheckBox(true);
		       layoutViewPage.selectTypeOfColor("Spot Color");
		       layoutViewPage.clickOnSaveNewPage();
		       Thread.sleep(4000);
		       Logger.info("New page inserted after first page");
		       
		       layoutViewPage.clickOnGoToNextPageButton();
		       String pageno1 = layoutViewPage.returnPageNumber();
		       Thread.sleep(4000);
		       layoutViewPage.clickOnGoToLastPageButton();
		    //   dashboardPageInstance.clickOnLogout();
		       layoutViewPage.rightClickOnPageNumAndNameSection();
		       Thread.sleep(2000);
		       WebElement editPage = driver.findElement(By.xpath("html/body/div[2]/ul/li[1]/a"));
		       editPage.click();
		       layoutViewPage.selectCommonPageCheckBox(false);
		       layoutViewPage.clickOnSaveNewPage();
		       Thread.sleep(2000);
		       
		       String pageno2 = layoutViewPage.returnPageNumber();
		       Assert.assertTrue(pageno1.contains("Page 2 of 2"));
		       Assert.assertTrue(pageno1.contains("Zoned"));
		       Assert.assertTrue(pageno2.contains("Page 2 of 2"));
		       Assert.assertTrue(pageno2.contains("Common"));
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
}
