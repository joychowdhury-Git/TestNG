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

public class NewsPaperLayoutAddFirstPageTest 
{
	/**
	 * @author cymkozalg6 - Priyanka
	 * @param userData
	 * @throws Exception
	 * @description This test method creates a new newspaper template and adds first page to it. 
	 * 				In the order entry page selects the product for which new template was created
	 * 				and verifies the position template for the pages created 
	 */
	
	@Test(groups = {"NewsPaperLayouts","AddFirstPage","NewsPaperLayoutsReg","Group2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void addFirstPage(Map<String, String> userData) throws Exception
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
		       layoutPage.enterDate("17", "Jul", "2019");
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
		       
		       
		    /*   //DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryPageInstance.clickOnNewInsertionOrderBtn();
		       
		       //place an order for the same product on which new template is created
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_TBS");
		       newOrderInstance.enterSoldToCustomer("CU00380012");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		     //  newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",11, 0);
		       newOrderInstance.enterPubDate("1","26", "Jul", "2017");
		       newOrderInstance.selectProductType("1",11, 1);
		       newOrderInstance.selectProduct("1",11, 2);
		       newOrderInstance.selectAdType("1",11, 3);
		       newOrderInstance.selectSection("1",11, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       
		       //select position template checkbox
		       newOrderInstance.checkUncheckPosTemplateChckbx(1, true);
		       newOrderInstance.clickOnPositionSelector();
		       Thread.sleep(4000);
		       newOrderInstance.selectAdSizeForPosition(0);
		       Thread.sleep(1000);
		       newOrderInstance.clickOnSearchPositionInPSWindw();
		      
		       //validate if the page is present for selection
		       boolean pageExistenceFalg = false;
		       if(newOrderInstance.pageNumbersLink.isDisplayed())
		       {
		    	   pageExistenceFalg = true;
		       }
		       Assert.assertEquals(pageExistenceFalg, true);
		      
		       dashboardPageInstance.clickOnLogout();
		        */
		       }
		   
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	} 
}
