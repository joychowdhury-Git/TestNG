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

public class NewsPaperLayoutPageEditPrintTest 
{
	/**
	 * @author cymkozalg6 - Priyanka
	 * @param userData
	 * @throws Exception
	 * @description Edit the page content for the new template created and verifies against
	 * 				 news paper layout displayed when position template is selected while 
	 * 				 placing an order
	 */
	
	@Test(groups = {"NewsPaperLayouts","EditPrintPage"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
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
		       
		       dashboardPageInstance.clickOnOrderEntryModule();
	
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryPageInstance.clickOnNewInsertionOrderBtn();
		       
		       //place an order for the same product on which new template is created
		       NewOrderPage newOrderInstance1 = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance1.selectSoldToCustomerBU("bu_TBS");
		       newOrderInstance1.enterSoldToCustomer("CU00380012");
		       newOrderInstance1.selectBilltoSameAsSoldTo();
		       newOrderInstance1.selectOrderType("OrderType_Standard");
		       newOrderInstance1.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance1.createNewInsertion();
		       newOrderInstance1.selectBU("1",11, 0);
		       newOrderInstance1.enterPubDate("1","26", "Jul", "2017");
		       newOrderInstance1.selectProductType("1",11, 1);
		       newOrderInstance1.selectProduct("1",11, 2);
		       newOrderInstance1.selectAdType("1",11, 3);
		       newOrderInstance1.selectSection("1",11, 4);
		       Thread.sleep(4000);
		       newOrderInstance1.viewInsertionDetails("1");
		       
		       //select position template checkbox
		       newOrderInstance1.checkUncheckPosTemplateChckbx(1,true);
		       newOrderInstance1.clickOnPositionSelector();
		       Thread.sleep(4000);
		       newOrderInstance1.selectAdSizeForPosition();
		       Thread.sleep(1000);
		       newOrderInstance1.clickOnSearchPositionInPSWindw();
		       Thread.sleep(4000);
		       
		       //validate if the page content is as per the edited data
		       
		       
		       
		       //go to newspaper layout module
		       dashboardPageInstance.clickOnNewsPaperLayoutModule();
		       
		       Thread.sleep(3000);
		       layoutPage.selectBU("BU_DPR");
		       layoutPage.selectDayOfWeek("DayOfWeek_Wed");
		       layoutPage.selectProduct("DPRProduct_DailyPress");
		       layoutPage.selectSection(0);
		       layoutPage.checkOrUncheckCurrentTemplate(true);
		       
		       //click on the same template created in the above steps
		     
		       //edit the page
		       layoutViewPage.clickOnPageNumAndNameSection();
		       layoutViewPage.clickOnMoreOptionsOnPageButton(1);
		       layoutViewPage.clickOnEditPageButton();
		       layoutViewPage.enterTemplateName();
		       layoutViewPage.enterTemplateDescription();
		       layoutViewPage.selectCommonPageCheckBox(true);
		       layoutViewPage.selectColorPageCheckBox(true);
		       layoutViewPage.selectTypeOfColor("Full Color");
		       layoutViewPage.clickOnSaveNewPage();
		       
		       //clicks on print button
		       //layoutViewPage.clickOnPrint();
		       
		       
		       //place an order for the same product on which new template is created
		       NewOrderPage newOrderInstance2 = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance2.selectSoldToCustomerBU("bu_TBS");
		       newOrderInstance2.enterSoldToCustomer("CU00380012");
		       newOrderInstance2.selectBilltoSameAsSoldTo();
		       newOrderInstance2.selectOrderType("OrderType_Standard");
		       newOrderInstance2.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance2.createNewInsertion();
		       newOrderInstance2.selectBU("1",11, 0);
		       newOrderInstance2.enterPubDate("1","26", "Jul", "2017");
		       newOrderInstance2.selectProductType("1",11, 1);
		       newOrderInstance2.selectProduct("1",11, 2);
		       newOrderInstance2.selectAdType("1",11, 3);
		       newOrderInstance2.selectSection("1",11, 4);
		       Thread.sleep(4000);
		       newOrderInstance2.viewInsertionDetails("1");
		       
		       //select position template checkbox
		       newOrderInstance2.checkUncheckPosTemplateChckbx(1,true);
		       newOrderInstance2.clickOnPositionSelector();
		       Thread.sleep(4000);
		       newOrderInstance2.selectAdSizeForPosition();
		       Thread.sleep(1000);
		       newOrderInstance2.clickOnSearchPositionInPSWindw();
		       
		       //validate if the page content is as per the edited data
		       
		       
		       dashboardPageInstance.clickOnLogout();
		       }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
	}
}
