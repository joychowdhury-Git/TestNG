
package com.tribune.adit2.test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

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
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

public class NewsPaperLayoutExportImportLibrary 
{
	/**
	 * @author smukherjee - Sunny
	 * @param userData
	 * @throws Exception
	 * @description This test method creates a new newspaper template and adds first page to it. 
	 * 				Then it checks when Take offline button is clicked, template gets locked 
	 * 				When Bring online button is clicked, template lock goes away
	 */
	String name;
	@Test(groups = {"NewsPaperLayouts","exportLayout","exportImportLayout","NewsPaperLayoutsReg","Grp3","RegressionLatest","Group2","Group2F","G2","RerunF2", "newspaperLayout"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void exportLayout(Map<String, String> userData) throws Exception
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
		       Thread.sleep(4000);
		      //layoutViewPage.clickOnBringOnlineButton();
		       layoutViewPage.clickOnTakeOfflineButton();//swagata new
		       layoutViewPage.verifyTemplateLocked();
		       Thread.sleep(4000);
		       layoutViewPage.rightClickOnPageNumAndNameSection();//swagata new		       
		       //Thread.sleep(1000);
		       Thread.sleep(8000);//swagata new 
		      // WebElement linkExportElement = driver.findElement(By.xpath("html/body/div[2]/ul/li[10]/a"));
		       WebElement linkExportElement = driver.findElement(By.xpath("//a[text()='Export To Library']"));//swagata new
       
		       linkExportElement.click();
		       Thread.sleep(4000);
		       layoutViewPage.clickOnExportNew();
		       name = layoutViewPage.enterExportName();//mou
		       Logger.info("Export Name:" +name);//mou
		       layoutViewPage.clickOnvisibilityMine();
		       layoutViewPage.clickOnExportButton();
		       Thread.sleep(4000);	
		       dashboardPageInstance.clickOnLogout();       
		      
		       }
		   
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	} 
	
	@Test(groups = {"NewsPaperLayouts","importLayout","exportImportLayout","NewsPaperLayoutsReg","Grp3","RegressionLatest","Group2","Group2F","G2","G2","RerunF2", "newspaperLayout"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void importLayout(Map<String, String> userData) throws Exception
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
		       //layoutPage.selectBU("BU_DPR");
		       layoutPage.selectBU("BU_CTC");  //joy
		       layoutPage.selectDayOfWeek("DayOfWeek_Wed");
		       layoutPage.selectProduct("CTCProduct_ChicagoTribune"); //Joy
		       layoutPage.selectSection(2);
		       layoutPage.checkOrUncheckCurrentTemplate(true);
		       layoutPage.clickOnSearch();
		       Thread.sleep(4000);
		       layoutPage.clickOnFirstNewsPaperLayoutID();
		       Thread.sleep(4000);
		       NewsPaperLayoutViewPage layoutViewPage = PageFactory.initElements(driver, NewsPaperLayoutViewPage.class);
		       //Thread.sleep(1000); joy
		       Thread.sleep(4000);
		      //layoutViewPage.clickOnBringOnlineButton();
		       layoutViewPage.clickOnTakeOfflineButton();//swagata new
		       layoutViewPage.verifyTemplateLocked();
		       Thread.sleep(4000);
		       layoutViewPage.rightClickOnPageNumAndNameSection();//swagata new		       
		       //Thread.sleep(1000);
		       Thread.sleep(8000);//swagata new 
			
      WebElement linkImportElement = driver.findElement(By.xpath("//a[text()='Import From Library']"));//mousumi
      	       
      linkImportElement.click();
      Thread.sleep(4000);
      layoutViewPage.clickOnLibraryMine();
      Thread.sleep(2000);
      layoutViewPage.selectLibraryName(name);
      Thread.sleep(2000);
      layoutViewPage.clickOnImportButton();
      Thread.sleep(4000);
      dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
}