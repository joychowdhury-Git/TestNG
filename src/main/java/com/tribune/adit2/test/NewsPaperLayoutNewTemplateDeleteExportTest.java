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

	public class NewsPaperLayoutNewTemplateDeleteExportTest 
	{
		/**
		 * @author smukherjee - Sunny
		 * @param userData
		 * @throws Exception
		 * @description This test method creates a new newspaper template and adds first page to it. 
		 * 				In the order entry page selects the product for which new template was created
		 * 				and verifies the position template for the pages created 
		 */
		
		@Test(groups = {"NewsPaperLayouts","NewsPaperLayoutNewTemplateDeleteExportTst","NewsPaperLayoutsReg","Grp3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
		public void NewsPaperLayoutNewTemplateDeleteExportTst(Map<String, String> userData) throws Exception
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
			       layoutPage.selectBU("BU_TMC");
			       layoutPage.selectDayOfWeek("DayOfWeek_Wed");
			       layoutPage.selectProduct("TMCProduct_TheMorningCall");
			       layoutPage.selectSection(0);
			       layoutPage.checkOrUncheckCurrentTemplate(true);
			       layoutPage.clickOnSearch();
			       Thread.sleep(4000);
			       //create a new template
			       layoutPage.clickOnNewTemplateBtn();
			       Thread.sleep(1000);
			       layoutPage.enterDescription();
			       layoutPage.selectDatetype("EffectiveDate");
			       Thread.sleep(2000);
			       layoutPage.enterDate("24", "Jul", "2019");
			     //  layoutPage.checkUncheckInheritFrom(true);
			       layoutPage.saveNewTemplate();
			       Thread.sleep(4000);
			       String templateid = layoutPage.getTemplateID();
			       Thread.sleep(2000);
			       
			       driver.navigate().refresh();
			       layoutPage.selectBU("BU_TMC");
			       layoutPage.selectDayOfWeek("DayOfWeek_Wed");
			       layoutPage.selectProduct("TMCProduct_TheMorningCall");
			       layoutPage.selectSection(0);
			       layoutPage.checkOrUncheckCurrentTemplate(true);
			       Thread.sleep(1000);
			       layoutPage.clickOnSearch();
			       Thread.sleep(4000);
			       layoutPage.clickOnTemplate(templateid);
			       //get template ID for new template
			       
			       
			       NewsPaperLayoutViewPage layoutViewPage = PageFactory.initElements(driver, NewsPaperLayoutViewPage.class);
			       Thread.sleep(1000);
			       
			       //add first page for the new template created
			       layoutViewPage.clickOnDeleteButton();
			       Thread.sleep(2000);
			       layoutViewPage.clickOnConfirmDeleteButton();			       
			       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			       newOrderInstance.getOopsMessagePopUpError();
			       Thread.sleep(2000);
			       layoutViewPage.clickOnExportOrderButton();
			       Thread.sleep(2000);
			       layoutViewPage.saveExportOrderExcel();
			       }
			   
			   catch(Exception e)
			   {
				   Logger.error(e.getMessage());
					  throw e;
			   }
		} 
	}


