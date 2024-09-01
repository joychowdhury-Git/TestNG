/**package com.tribune.adit2.test;

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

public class NewsPaperLayoutNewTemplateMultiZonesTest 
{
	
	
	 * @author cymkozalg6 - Priyanka
	 * @param userData
	 * @throws Exception
	 * @description This test method creates a new newspaper template for a product with mutiple zones 
	
	
	@Test(groups = {"NewsPaperLayouts","MultiZones"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewsPaperLayoutWithMultiZones(Map<String, String> userData) throws Exception
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
		       layoutPage.selectBU("BU_LAT");
		       layoutPage.selectDayOfWeek("DayOfWeek_Sun");
		       layoutPage.selectProduct("LATProduct_LATimes");
		       layoutPage.selectSection(0);
		       layoutPage.checkOrUncheckCurrentTemplate(true);
		       layoutPage.clickOnSearch();
		       Thread.sleep(4000);
		       
		       int countBeforeAddition = Integer.parseInt(layoutPage.countOfResultsFound.getText());
		       Logger.info("Count of the results found: " +countBeforeAddition);
		       
		       layoutPage.clickOnNewTemplateBtn();
		       Thread.sleep(1000);
		       layoutPage.enterDescription();
		       layoutPage.selectDatetype("EffectiveDate");
		       layoutPage.enterDate("24", "Jul", "2019");
		       layoutPage.checkUncheckInheritFrom(false);
		       layoutPage.saveNewTemplate();
		       Thread.sleep(2000);
		       
		       driver.navigate().refresh();
		       layoutPage.selectBU("BU_LAT");
		       layoutPage.selectDayOfWeek("DayOfWeek_Sun");
		       layoutPage.selectProduct("LATProduct_LATimes");
		       layoutPage.selectSection(0);
		       layoutPage.checkOrUncheckCurrentTemplate(true);
		       Thread.sleep(1000);
		       layoutPage.clickOnSearch();
		       Thread.sleep(4000);
		       
		       Logger.info("New layout ID is " +layoutPage.getLatestNewsPaperLayoutID());
		       
		       layoutPage.clickOnLatestNewsPaperLayoutID();
		       
		       NewsPaperLayoutViewPage layoutViewPage = PageFactory.initElements(driver, NewsPaperLayoutViewPage.class);
		       Thread.sleep(1000);
		       layoutViewPage.selectZoneInViewLayoutPage("West");
		       
		       
		       dashboardPageInstance.clickOnLogout();
		       }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}

}
 */