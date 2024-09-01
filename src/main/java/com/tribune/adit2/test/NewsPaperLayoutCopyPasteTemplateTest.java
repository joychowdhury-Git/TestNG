package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class NewsPaperLayoutCopyPasteTemplateTest 
{

	/**
	 * @author smukherjee - Sunny
	 * @param userData
	 * @throws Exception
	 * @description This test method creates a new newspaper template, adds first page to it,  
	 * 				copies the new template created, pastes the copied template to a new template.
	 * @notes Copy option will copy the whole page content and Paste option will paste the 
	 * 				whole page content into whichever template selected
	 */
	
	@Test(groups = {"NewsPaperLayouts","CopyPasteLayout1","NewsPaperLayoutsReg","Grp3","Group2F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void copypasteNewspaperTemplate(Map<String, String> userData) throws Exception
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
		       layoutPage.selectDayOfWeek("DayOfWeek_Mon");
		       layoutPage.selectProduct("DPRProduct_DailyPress");
		       layoutPage.selectSection(0);
		       layoutPage.checkOrUncheckCurrentTemplate(true);
		       
		       //create a new template
		       layoutPage.clickOnNewTemplateBtn();
		       Thread.sleep(1000);
		       layoutPage.enterDescription();
		       layoutPage.selectDatetype("EffectiveDate");
		       Thread.sleep(2000);
		       layoutPage.enterDate("16", "Dec", "2019");
		      // layoutPage.checkUncheckInheritFrom(true);
		       layoutPage.saveNewTemplate();
		       String templateid = layoutPage.getTemplateID();
		       Thread.sleep(2000);
		       
		       driver.navigate().refresh();
		       layoutPage.selectBU("BU_DPR");
		       layoutPage.selectDayOfWeek("DayOfWeek_Mon");
		       layoutPage.selectProduct("DPRProduct_DailyPress");
		       layoutPage.selectSection(0);
		       layoutPage.checkOrUncheckCurrentTemplate(true);
		       Thread.sleep(1000);
		       layoutPage.clickOnSearch();
		       Thread.sleep(4000);
		       layoutPage.clickOnTemplate(templateid);
		       		       
		       NewsPaperLayoutViewPage layoutViewPage = PageFactory.initElements(driver, NewsPaperLayoutViewPage.class);
		       Thread.sleep(3000);
		       
		       layoutViewPage.rightClickOnPageNumAndNameSection();		       
		       Thread.sleep(3000);
		       WebElement linkCopyElement = driver.findElement(By.xpath("html/body/div[2]/ul/li[7]/a"));
		       	       
		       linkCopyElement.click();
		       Thread.sleep(4000);
		       layoutViewPage.getPageNumber();
		       layoutViewPage.clickOnGoToNextPageButton();
		       layoutViewPage.getPageNumber();
		       Thread.sleep(4000);
		       
		       layoutViewPage.rightClickOnPageNumAndNameSection();		       
		       Thread.sleep(3000);
		       WebElement linkPasteElement = driver.findElement(By.xpath("html/body/div[2]/ul/li[8]/a"));
		       	       
		       linkPasteElement.click();
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
