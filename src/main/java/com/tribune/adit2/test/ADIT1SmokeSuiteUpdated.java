package com.tribune.adit2.test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.ClassifiedOrderOptions;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;


public class ADIT1SmokeSuiteUpdated 
{

	@Test(groups = {"Order","ctcTC01","Grp4","Group1","ADIT1Smoke","ctc","TestProd1","Patch0222","smokeSetS45","SmokeSet1","SmokeFailed"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ctcTC01(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",17, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",17,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",17, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",17, 2);
			Thread.sleep(4000);
			newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");//swagata

			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			//		       newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			//		       newOrderInstance.clickOnPositionSelector();
			//		       Thread.sleep(12000);
			//		      newOrderInstance.selectAdSizeForPosition();
			//		      Thread.sleep(5000);
			//		      
			//		    //  newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
			//		      newOrderInstance.selectFirstPostionFrmPositionSlctr();
			//		       newOrderInstance.savePositionSelection();
			//		       Thread.sleep(10000);	
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//   newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			//newOrderInstance.viewInsertionDetails("1");//swagata
			/*     newOrderInstance.createDuplicateInsertion("1");
		       Thread.sleep(4000);	
		       //newOrderInstance.viewInsertionDetails("2");
		       newOrderInstance.selectMaterialSource2("Pickup w/Changes");
		       Thread.sleep(4000);
		       newOrderInstance.clickOnPickUpSearch();
		       Thread.sleep(4000);
		       newOrderInstance.enterAdMarcNo("7890");
		       Thread.sleep(4000);
		       newOrderInstance.assignMaterialForAnInsertion(2);
		       Thread.sleep(4000);
		       newOrderInstance.clickonApplyAllInsertions();
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(1000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000); */
		

		newOrderInstance.killOrderNonProd();
		dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	@Test(groups = {"Order","ctcTC03","Grp4","Group1","ADIT1Smoke","ctc","TestProd1","smokeSetS45","SmokeSet1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ctcTC03(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); 
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",80, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",80,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",80, 1);
			Thread.sleep(3000);
			newOrderInstance.selectProduct("1", 80, 2);//swagata
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",80, 3);
			Thread.sleep(5000);
			newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");//swagata
			//  newOrderInstance.selectSection("1",45, 4);		       
			//  Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectColourForAnInsertion(1, "B/W");
			Thread.sleep(4000);
			newOrderInstance.selectAdSize(1, "1/2H");
			//Thread.sleep(4000);	
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();


			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"Order","ctcTC04","Grp4","Group1","ADIT1Smoke","ctc","SmokeSet2","preprintSanity","set2","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ctcTC04(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",43, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",43,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",43, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",43, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",43, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");
			//    Thread.sleep(4000);
			//    newOrderInstance.selectMaterialSource("1","New Build");
			/*      newOrderInstance.checkUncheckBillQty(false);
		       Thread.sleep(3000);	
		       newOrderInstance.enterBilledQty(5);*/
			Thread.sleep(3000);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			Thread.sleep(4000);
			// newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			newOrderInstance.clickOnDistributions(1);//swagata
			//Thread.sleep(95000);//swagata
			//  newOrderInstance.clickOnSearchZoneLink();
			//  Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();	
			Thread.sleep(5000);
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(3000);
			newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_AdProd"); 
			Thread.sleep(3000);
			newOrderInstance.selectPandDPaperStock1("1", 1); 
			Thread.sleep(3000);
			newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			/*
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.createDuplicateInsertion("1");
		       Thread.sleep(4000);			      
		       newOrderInstance.enterPubDateFromExcel("1",46,27);
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("2",46, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProductByIndex("2",3);
		       Thread.sleep(4000);
		       newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
		       newOrderInstance.clickOnPositionSelector();
		       Thread.sleep(12000);
		     // newOrderInstance.selectAdSizeForPosition();
		     // Thread.sleep(5000);

		    //  newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
		      newOrderInstance.selectFirstPostionFrmPositionSlctr();
		       newOrderInstance.savePositionSelection();
		       Thread.sleep(10000);	
		       newOrderInstance.clickonApplyAllInsertions();
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(2000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
			 */
			newOrderInstance.killOrderNonProd();

		
		
			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"Order","oscTC01","Grp4","Group1","ADIT1Smoke","osc","TestProd3","Patch0222","SmokeSet1","SmokeFailed","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void oscTC01(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_OSC");
			newOrderInstance.enterSoldToCustomer("CU00392709");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",85, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",85,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",85, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",85, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",85, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1",85, 4);		       
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectAdSize(1, "1/16  (2 x 4)");
			//Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
		//	newOrderInstance.clickNoLegacyAutoInsertionCreation();//swagata
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());

			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"Order","oscTC06","Grp4","Group1","ADIT1Smoke","osc","oscp","TestProd3","PatchProd","SmokeSet2","set3","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void oscTC06(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_OSC");
			newOrderInstance.enterSoldToCustomer("CU00392709");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",51, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",51,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",51, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",51, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",51, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			// newOrderInstance.addOrEditInsersionVerisonID("1", 1);		//swagata  
			newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");//swagata
			/*      newOrderInstance.checkUncheckBillQty(false);
		       Thread.sleep(3000);	
		       newOrderInstance.enterBilledQty(5);*/
			Thread.sleep(3000);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_CustSupplied");
			Thread.sleep(4000);
			newOrderInstance.selectPageType("1", "PP_PaperType_Broadsheet");
			Thread.sleep(3000);
			// newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			newOrderInstance.clickOnDistributions(1);
			//Thread.sleep(45000);//swagata
			//  newOrderInstance.clickOnSearchZoneLink();
			//  Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();	
			Thread.sleep(5000);
			// newOrderInstance.clickOnPAndDTab();
			//  Thread.sleep(3000);
			//   newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_CentralStudio"); 
			Thread.sleep(3000);
			//  newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
			//   Thread.sleep(3000);
			//  newOrderInstance.selectPandDInk("1", "CMYK");
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"Order","htfTC02","Grp4","Group1","ADIT1Smoke","htf","TestProd2","SmokeSet1","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void htfTC02(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_HTF");
			newOrderInstance.enterSoldToCustomer("CU00250481");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",62, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",62,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",62, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",62, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",62, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1",62, 4);		       
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectAdSize(1, "Front Page Strip 1/14 (6 x 1.5)");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			newOrderInstance.clickOnPositionSelector();
			Thread.sleep(42000);		    
			newOrderInstance.selectFirstPostionFrmPositionSlctr();
			newOrderInstance.savePositionSelection();
			Thread.sleep(10000);
			newOrderInstance.selectColourForAnInsertion(1, "4C");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();


			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"Order","htfTC03","Grp4","Group1","ADIT1Smoke","htf","TestProd2","Patch0222","SmokeSet1","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void htfTC03(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_HTF");
			newOrderInstance.enterSoldToCustomer("CU00250481");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",63, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",63,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",63, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",63, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",63, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1",63, 4);		       
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectAdSize(1, "1/2V  (3 x 10.5)");
			Thread.sleep(4000);
			newOrderInstance.enterClassCodeForAnInsertion(1, "51048");
			Thread.sleep(4000);  
			newOrderInstance.selectColourForAnInsertion(1, "4C");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);

			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"Order","htfTC06","Grp4","Group1","ADIT1Smoke","htf","TestProd2","SmokeSet2","SmokeFailed","set3","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void htfTC06(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_HTF");
			newOrderInstance.enterSoldToCustomer("CU00250481");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",66, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",66,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",66, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",66, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",66, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			//  newOrderInstance.addOrEditInsersionVerisonID("1", 1);	//swagata
			newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");//swagata
			/*     newOrderInstance.checkUncheckBillQty(false);
		       Thread.sleep(3000);	
		       newOrderInstance.enterBilledQuantity(59423);
		       Thread.sleep(3000);*/
			/* newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
		       newOrderInstance.clickOnPositionSelector();
		       Thread.sleep(32000);

		      newOrderInstance.selectFirstPostionFrmPositionSlctr();
		      Thread.sleep(4000);
		       newOrderInstance.savePositionSelection();
		       Thread.sleep(10000);	 */ 
			newOrderInstance.clickOnDistributions(1);
			//Thread.sleep(45000);//swagata
			//  newOrderInstance.clickOnSearchZoneLink();
			//  Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();	
			Thread.sleep(5000);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			newOrderInstance.selectPageType("1", "PP_PaperType_8.5x11BusinessBuilder");
			Thread.sleep(3000);	
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(3000);
			newOrderInstance.selectPandDPaperStock("1", "PP_PaperStock_Coated"); 
			Thread.sleep(3000);
			newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
			Thread.sleep(3000);
			newOrderInstance.selectPandDFold("1", "PP_Fold_HalfFold");
			Thread.sleep(3000);
			newOrderInstance.selectPandDPerforation("1", "PP_Perforation_Yes");
			Thread.sleep(3000);
			newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_AdProd");
			Thread.sleep(3000);
			newOrderInstance.selectPandDPrinter("1", "PP_Printer_Express");
			Thread.sleep(3000);
			newOrderInstance.selectPandDInk("1", "CMYK");
			Thread.sleep(3000);
			// newOrderInstance.selectPandDCreativeLoc("1", "");
			//  Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();


			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"Order","altTC01","Grp4","Group1","ADIT1Smoke","alt","Test2","TestProd3","PatchProd","SmokeNew","smokeSetS45","SmokeSet1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void altTC01(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder(); 

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_ALT");
			newOrderInstance.enterSoldToCustomer("CU00258088");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");		      
			Thread.sleep(4000);

			Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",27, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",27,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",27, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",27, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",27, 3);
			Thread.sleep(5000);
			// newOrderInstance.selectSection("1",27, 4);		       
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectAdSize(1, "1/3V (2 x 18)");
			Thread.sleep(4000);
			newOrderInstance.selectMaterialSource("1","New Build");	
			Thread.sleep(4000);	
			//  newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			//   newOrderInstance.clickOnPositionSelector();
			//   Thread.sleep(32000);

			//  newOrderInstance.selectFirstPostionFrmPositionSlctr();
			//  Thread.sleep(4000);
			//   newOrderInstance.savePositionSelection();
			//    Thread.sleep(10000);	  
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			//  newOrderInstance.clickNoLegacyAutoInsertionCreation();
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"Order","smokeSetS45","SmokeSet2","altTC02","set1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void altTC02(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_ALT");
			newOrderInstance.enterSoldToCustomer("CU00258088");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",68, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",68,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",68, 1);
			Thread.sleep(6000);
			newOrderInstance.selectProduct("1",68, 2);
			Thread.sleep(6000);
			newOrderInstance.selectAdType("1",68, 3);
			Thread.sleep(6000);
			newOrderInstance.selectSection("1",68, 4);//swagata
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(3000);
			newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");		     
			/*     newOrderInstance.checkUncheckBillQty(false);
		       Thread.sleep(3000);	
		       newOrderInstance.enterBilledQuantity(12024);
		       Thread.sleep(3000);*/
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			Thread.sleep(4000);
			newOrderInstance.clickOnDistributions(1);//swagata
			//Thread.sleep(45000);//swagata
			//  newOrderInstance.clickOnSearchZoneLink();
			//  Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("SubZip");
			// int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();	
			Thread.sleep(5000);
			newOrderInstance.selectPageType("1", "PP_PaperType_StandardFullRun");
			Thread.sleep(3000);	
			newOrderInstance.enterPageCount("2");
			Thread.sleep(4000);	  
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"Order","tbsTC01","Grp4","Group1","ADIT1Smoke","Test2","TestProd2","Patch0222","SmokeSet1","tbs","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void tbsTC01(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_TBS");
			newOrderInstance.enterSoldToCustomer("CU00169935");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			//  Thread.sleep(4000); 
			//  Thread.sleep(6000);
			// newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",69, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",69,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",69, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",69, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",69, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1",69, 4);		       
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");//swagata
			Thread.sleep(4000);
			newOrderInstance.selectAdSizeByValue(1, "number:2695");
			Thread.sleep(4000);
			//		       newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			//		       newOrderInstance.clickOnPositionSelector();
			//		       Thread.sleep(12000);
			//		   //   newOrderInstance.selectAdSizeForPosition();
			//		      Thread.sleep(5000);
			//		      newOrderInstance.clickOnSearchPositionInPSWindw();
			//		      Thread.sleep(42000);
			//		    //  newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
			//		      newOrderInstance.selectFirstPostionFrmPositionSlctr();
			//		       newOrderInstance.savePositionSelection();
			//		       Thread.sleep(10000);	
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);

			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	@Test(groups = {"Order","tbsTC04","Grp4","Group1","ADIT1Smoke","tbs","Test2","TestProd2","TestPriority","SmokeSet2","set1","SmokeFailed","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void tbsTC04(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_TBS");
			newOrderInstance.enterSoldToCustomer("CU00169935");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			//  Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);//swagata
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",72, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",72,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",72, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",72, 2);
			Thread.sleep(6000);
			newOrderInstance.selectAdType("1",72, 3);
			Thread.sleep(4000);
			newOrderInstance.selectSection("1",72, 4);//swagata

			newOrderInstance.viewInsertionDetails("1");
			//newOrderInstance.addOrEditInsersionVerisonID("1", 1);  //swagata
			newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");//swagata
			Thread.sleep(3000);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			Thread.sleep(4000);
			// newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			newOrderInstance.clickOnDistributions(1);
			//Thread.sleep(45000);//swagata
			//  newOrderInstance.clickOnSearchZoneLink();
			//  Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();	
			Thread.sleep(5000);
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(3000);
			newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_AdProd");
			Thread.sleep(3000);
				//			   newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_Tower"); 
			//			   Thread.sleep(3000);
			//			   newOrderInstance.selectPandDPaperStock1("1", 1); 
			//			   Thread.sleep(3000);
			newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"Order","sscTC01","Grp4","Group1","ADIT1Smoke","ssc","TestProd1","TestPriority","Patch0222","SmokeSet1","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void sscTC01(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_SSC");
			newOrderInstance.enterSoldToCustomer("CU00117844");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",73, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",73,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",73, 1);
			Thread.sleep(5000);
			newOrderInstance.selectProduct("1",73, 2);//swagata
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",73, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1",73, 4);		       
			Thread.sleep(6000);
			newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");//swagata
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectAdSize(1, "Full Page  (6 x 21)");//by default this value selected
			//Thread.sleep(4000);
			newOrderInstance.selectMaterialSource("1","New Build");	
			Thread.sleep(4000);	
			//newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			//Thread.sleep(4000);				      
			//newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			//Thread.sleep(4000);
			//newOrderInstance.clickOnInsertionSalesRepSection(1);
			//Thread.sleep(4000);
			//newOrderInstance.applytoAllSalesRepOnInsertion(1);
			//Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(3000);
			//newOrderInstance.clickNoLegacyAutoInsertionCreation();//swagata

			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	@Test(groups = {"Order","sscTC03","Grp4","Group1","ADIT1Smoke","ssc","TestProd1","SmokeSet2","set1","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void sscTC03(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_SSC");
			newOrderInstance.enterSoldToCustomer("CU00117844");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",75, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",75,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",75, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",75, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",75, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1",75, 4);		       
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");//swagata
			Thread.sleep(3000);
			//newOrderInstance.addOrEditInsersionVerisonID("1", 1);	//swagata	     
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			newOrderInstance.selectPageType("1", "PP_PaperType_5.5x8.5SglSheet");
			Thread.sleep(3000);	
			newOrderInstance.enterPageCount("2");
			Thread.sleep(4000);
			/*   newOrderInstance.checkUncheckBillQty(false);
		       Thread.sleep(3000);	
		       newOrderInstance.enterBilledQty(5);
		       Thread.sleep(3000);*/
			newOrderInstance.selectMaterialSource("1", "New Build");
			Thread.sleep(3000);
			newOrderInstance.clickOnDistributions(1);
		//	Thread.sleep(40000);//swagata
			newOrderInstance.selectAllZonePreprintOrder();
			Thread.sleep(4000);			       
			newOrderInstance.confirmZoneSelection();		
			Thread.sleep(4000);
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(3000);
			//   newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_Adwatch"); 
			//   Thread.sleep(3000);
			//   newOrderInstance.selectPandDPaperStock("1", "PP_PaperStock_60Coated"); 
			//   Thread.sleep(3000);
			newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
			Thread.sleep(3000);
			newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_AdProd");
			Thread.sleep(3000);
			//   newOrderInstance.selectPandDFold("1", "PP_Fold_HalfFoldd");
			//   Thread.sleep(3000);
			//   newOrderInstance.selectPandDPerforation("1", "PP_Perforation_Yes");
			//   Thread.sleep(3000);
			newOrderInstance.selectPandDPrinter("1", "PP_Printer_NPC");
			Thread.sleep(3000);
			newOrderInstance.selectPandDInk("1", "4 Color Process");
			Thread.sleep(3000);
			newOrderInstance.selectPandDOrientation("1", "Horizontal");	
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	@Test(groups = {"Order","ctcTC05","Grp4","Group1","ADIT1Smoke","ctc","SmokeSet2","SmokeFailed","SmokeNew","set2","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ctcTC05(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",86, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",86,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",86, 1);//swagata
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",86, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",86, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");
			//    Thread.sleep(4000);
			//    newOrderInstance.selectMaterialSource("1","New Build");
			/*      newOrderInstance.checkUncheckBillQty(false);
		       Thread.sleep(3000);	
		       newOrderInstance.enterBilledQty(5);*/
			Thread.sleep(3000);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			Thread.sleep(4000);
			// newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			newOrderInstance.clickOnDistributions(1);
			//Thread.sleep(95000);//swagata
			//  newOrderInstance.clickOnSearchZoneLink();
			//  Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();	
			Thread.sleep(5000);
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(3000);
			newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_AdProd"); 
			Thread.sleep(3000);
			newOrderInstance.selectPandDPaperStock1("1", 1); 
			Thread.sleep(3000);
			newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
		
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			/*
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.createDuplicateInsertion("1");
		       Thread.sleep(4000);			      
		       newOrderInstance.enterPubDateFromExcel("1",46,27);
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("2",46, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProductByIndex("2",3);
		       Thread.sleep(4000);
		       newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
		       newOrderInstance.clickOnPositionSelector();
		       Thread.sleep(12000);
		     // newOrderInstance.selectAdSizeForPosition();
		     // Thread.sleep(5000);

		    //  newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
		      newOrderInstance.selectFirstPostionFrmPositionSlctr();
		       newOrderInstance.savePositionSelection();
		       Thread.sleep(10000);	
		       newOrderInstance.clickonApplyAllInsertions();
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(2000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
			 */
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	/*@Test(groups = {"Order","dprTC02","Grp4","Group1","ADIT1Smoke","dpr","Test2","TestProd3","Patch0222","SmokeSet1","SmokeFailed","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void dprTC02(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_DPR");
			newOrderInstance.enterSoldToCustomer("CU00013249");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); 
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",29, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",29,27);//swagata
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",29, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",29, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",29, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1",29, 4);		       
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
            newOrderInstance.selectAdSize(1, "1/4V  (3 x 10.5)");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			newOrderInstance.clickOnPositionSelector();
			Thread.sleep(45000);

			//  newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
			newOrderInstance.selectFirstPostionFrmPositionSlctr();
			Thread.sleep(4000);
			newOrderInstance.savePositionSelection();
			Thread.sleep(10000);	
			newOrderInstance.collapseInsertionDetails("1");//swagata
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("2",56, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("2",56,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("2",56, 1);
			Thread.sleep(4000);
			   newOrderInstance.selectProduct("2",56, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("2",56, 3);
		       Thread.sleep(5000);
		       newOrderInstance.selectSection("2",56, 4);		       
		       Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("2");
			Thread.sleep(4000);
			//  newOrderInstance.selectAdSizeByIndexOnline(1, 0);
			//  Thread.sleep(4000);
			newOrderInstance.enterItemDescription("CUBE",1);
			Thread.sleep(4000);
			newOrderInstance.enterItemQuantity("100000",1);
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("2");//swagata
			Thread.sleep(4000);
			
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * //newOrderInstance.removeSalesRepOnInsertion(1); Thread.sleep(4000);
			 * newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907"); Thread.sleep(4000);
			 * newOrderInstance.clickOnInsertionSalesRepSection(1); Thread.sleep(4000);
			 * newOrderInstance.applytoAllSalesRepOnInsertion(1);
			 //swagata
			newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");//swagata
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);//swagata
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}*/
	/*@Test(groups = {"Order","dprTC07","Grp4","Group1","ADIT1Smoke","osc","TestProd3","Patch0222","SmokeSet1","SmokeFailed","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void dprTC07(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_DPR");
			newOrderInstance.enterSoldToCustomer("CU00013249");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",87, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",87,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",87, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",87, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",87, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1",87, 4);		       
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectAdSize(1, "1/32 V (1 Col x 4)");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}*/

	@Test(groups = {"Order","dprTC08","Grp4","Group1","ADIT1Smoke","osc","TestProd3","Patch0222","SmokeSet2","set2","SmokeFailed","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void dprTC08(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_DPR");
			newOrderInstance.enterSoldToCustomer("CU00013249");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",57, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",57,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",57, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",57, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",57, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(3000);
			newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");
			Thread.sleep(3000);
			//  newOrderInstance.selectMaterialSource("1","N/A");
			/*  newOrderInstance.checkUncheckBillQty(false);
		       Thread.sleep(3000);	
		       newOrderInstance.enterBilledQty(5);
		       Thread.sleep(3000);	*/
			newOrderInstance.clickOnDistributions(1);
			//Thread.sleep(45000);//swagata
			//  newOrderInstance.clickOnSearchZoneLink();
			//  Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("SubZip");
			// int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();	
			Thread.sleep(5000);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			Thread.sleep(3000);	
			newOrderInstance.selectPageType("1", "PP_PaperType_EZ4");
			Thread.sleep(3000);	
			newOrderInstance.enterPageCount("2");
			/*  Thread.sleep(4000);
		       newOrderInstance.clickOnProgramPriceSelector();
		       Thread.sleep(3000);	
		       newOrderInstance.selectFirstSpecialProgramPromotion();
		       Thread.sleep(3000);	*/
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(3000);
			//newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_CentralStudio"); 
			newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_AdProd");
			
			Thread.sleep(3000);
			newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
			Thread.sleep(3000);			  
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			//Thread.sleep(10000);//swagata
			//    newOrderInstance.clickOnContinuePastDeadlineDate();
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	@Test(groups = {"Order","dprTC09","Grp4","Group1","ADIT1Smoke","osc","TestProd3","Patch0222","SmokeSet2","set3","SmokeFailed","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void dprTC09(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_DPR");
			newOrderInstance.enterSoldToCustomer("CU00013249");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",88, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",88,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",88, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",88, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",88, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(3000);
			newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");
			Thread.sleep(3000);
			//  newOrderInstance.selectMaterialSource("1","N/A");
			/*  newOrderInstance.checkUncheckBillQty(false);
	       Thread.sleep(3000);	
	       newOrderInstance.enterBilledQty(5);
	       Thread.sleep(3000);	*/
			newOrderInstance.clickOnDistributions(1);
			//Thread.sleep(45000);//swagata
			//  newOrderInstance.clickOnSearchZoneLink();
			//  Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();	
			Thread.sleep(5000);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			Thread.sleep(3000);	
			newOrderInstance.selectPageType("1", "PP_PaperType_EZ4");
			Thread.sleep(3000);	
			newOrderInstance.enterPageCount("2");
			/*  Thread.sleep(4000);
	       newOrderInstance.clickOnProgramPriceSelector();
	       Thread.sleep(3000);	
	       newOrderInstance.selectFirstSpecialProgramPromotion();
	       Thread.sleep(3000);	*/
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(3000);
			newOrderInstance.selectPandDPaperStock("1","PP_PaperStock_70Gloss");
			//		   newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_CentralStudio"); 
			Thread.sleep(3000);
			newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_AdProd");
			Thread.sleep(3000);
			newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
			Thread.sleep(3000);			  
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			//  Thread.sleep(2000);//swagata
			//Thread.sleep(10000);//swagata
			//    newOrderInstance.clickOnContinuePastDeadlineDate();
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"Order","ndnTC01","Grp4","Group1","ADIT1Smoke","alt","Test2","TestProd3","PatchProd","SmokeSet1","SmokeNew","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ndnTC01(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_NDN");
			newOrderInstance.enterSoldToCustomer("CU00646890");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");		       
			Thread.sleep(4000);

			Thread.sleep(4000); 
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",89, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",89,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",89, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",89, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",89, 3);
			Thread.sleep(5000);
			// newOrderInstance.selectSection("1",89, 4);		       
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");
			Thread.sleep(4000);
			newOrderInstance.selectAdSizefromExcel(1,89,5);//swagata
			Thread.sleep(4000);
			newOrderInstance.selectMaterialSource("1","New Build");	
			Thread.sleep(4000);	
			//  newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
			//   newOrderInstance.clickOnPositionSelector();
			//   Thread.sleep(32000);

			//  newOrderInstance.selectFirstPostionFrmPositionSlctr();
			//  Thread.sleep(4000);
			//   newOrderInstance.savePositionSelection();
			//    Thread.sleep(10000);	  
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
		  //  newOrderInstance.clickNoLegacyAutoInsertionCreation();
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"Order","Grp4","Group1","osc","TestProd3","Patch0222","set3","SmokeFailed","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ndnTC02(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_NDN");
			newOrderInstance.enterSoldToCustomer("CU00646890");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",90, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",90,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",90, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",90, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",90, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(3000);
			newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");
			Thread.sleep(3000);
			//  newOrderInstance.selectMaterialSource("1","N/A");
			/*  newOrderInstance.checkUncheckBillQty(false);
	       Thread.sleep(3000);	
	       newOrderInstance.enterBilledQty(5);
	       Thread.sleep(3000);	*/
			newOrderInstance.clickOnDistributions(1);
			//Thread.sleep(45000);//swagata
			//  newOrderInstance.clickOnSearchZoneLink();
			//  Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();	
			Thread.sleep(5000);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			Thread.sleep(3000);	
			newOrderInstance.selectPageType("1", "PP_PaperType_Tab");
			Thread.sleep(3000);	
			newOrderInstance.enterPageCount("4");
			/*  Thread.sleep(4000);
	       newOrderInstance.clickOnProgramPriceSelector();
	       Thread.sleep(3000);	
	       newOrderInstance.selectFirstSpecialProgramPromotion();
	       Thread.sleep(3000);	*/
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(3000);
			newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_AdProd"); 
			Thread.sleep(3000);
			newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
			Thread.sleep(3000);		
			newOrderInstance.selectPandDInk("1", "4C");
			Thread.sleep(3000);
			//   newOrderInstance.selectPandDPrinter("1", "Doodad");//swagata
			newOrderInstance.selectPandDPrinter("1", "PP_Printer_Doodad");//swagata

			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			// Thread.sleep(10000);//swagata
			//    newOrderInstance.clickOnContinuePastDeadlineDate();
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info("Order No. is:"+orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);//swagata
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"Order","oscTC10","Grp4","Group1","ADIT1Smoke","osc","oscp","TestProd3","PatchProd","SmokeSet3","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void oscTC10(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();
			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_OSC");
			newOrderInstance.enterSoldToCustomer("CU00392709");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);

			newOrderInstance.createNewClassifiedInsertion();		       
			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("1",23, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("1",23, 1);
			Thread.sleep(2000);	      
			classifiedOrderInstance.selectClassifiedProductDrpDwn("1",23, 2);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackage("1",23, 3);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCode("1",23, 4);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();		       
			classifiedOrderInstance.clickApplyBtn();
			Thread.sleep(5000);

			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(7000);
			classifiedOrderInstance.enterDetailsInAdMaterialObit();


			Thread.sleep(7000);	

			// classifiedOrderInstance.enterAttributeDetailsObit();	



			newOrderInstance.saveOrder();

			Thread.sleep(6000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : "+orderNumber);
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();

			Thread.sleep(1000);

			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info("Order No. is:"+orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);

			Logger.info("Order No. is:"+orderID);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"Order","ndnTC03","Grp4","Group1","ADIT1Smoke","osc","oscp","TestProd3","PatchProd","SmokeSet3","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ndnTC03(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();
			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_NDN");
			newOrderInstance.enterSoldToCustomer("CU00646890");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);

			newOrderInstance.createNewClassifiedInsertion();		       
			Thread.sleep(1000);
			classifiedOrderInstance.selectPackageBU("1",24, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("1",24, 1);
			Thread.sleep(2000);	      
			classifiedOrderInstance.selectClassifiedProductDrpDwn("1",24, 2);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackage("1",24, 3);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCode("1",24, 4);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();		       
			classifiedOrderInstance.clickApplyBtn();
			Thread.sleep(5000);

			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(7000);
			classifiedOrderInstance.enterDetailsInAdMaterialObit();


			Thread.sleep(7000);	

			//  classifiedOrderInstance.enterAttributeDetailsObit();	


			newOrderInstance.saveOrder();

			Thread.sleep(6000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : "+orderNumber);
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();

			Thread.sleep(1000);

			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info("Order No. is:"+orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);

			Logger.info("Order No. is:"+orderID);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"Order","tbsTC05","Grp4","Group1","ADIT1Smoke","osc","oscp","TestProd3","PatchProd","SmokeSet3","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void tbsTC05(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();
			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_TBS");
			newOrderInstance.enterSoldToCustomer("CU00169935");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);

			newOrderInstance.createNewClassifiedInsertion();		       
			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("1",25, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("1",25, 1);
			Thread.sleep(2000);	      
			classifiedOrderInstance.selectClassifiedProductDrpDwn("1",25, 2);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackage("1",25, 3);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCode("1",25, 4);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();		       
			classifiedOrderInstance.clickApplyBtn();
			Thread.sleep(5000);

			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(7000);
			classifiedOrderInstance.enterDetailsInAdMaterialObit();


			Thread.sleep(7000);	

			classifiedOrderInstance.enterAttributeDetailsObitTBS();	//swagata
			Thread.sleep(3000);


			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : "+orderNumber);
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();

			Thread.sleep(6000);

			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info("Order No. is:"+orderID);
			//orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(4000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(4000);

			Logger.info("Order No. is:"+orderID);
			newOrderInstance.killOrderNonProd();
			Thread.sleep(3000);
			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	@Test(groups = {"NovMaintenance","r@r.com","ctcTC06","Grp4","Group1","ADIT1Smoke","ctc","TestProd1","Patch0222","smokeSetS45","SmokeSet3","SmokeFailed"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ctcTC06(Map<String, String> userData) throws Exception{
		try
		{
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");			   			   

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);
			Thread.sleep(30000);
			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");
			Thread.sleep(4000);
			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnOrderEntryModule();
			Thread.sleep(4000);
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();
			Thread.sleep(4000);
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_CTC");
			newOrderInstance.enterSoldToCustomer("CU00037236");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");//swagata
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");//swagata
			newOrderInstance.checkUncheckOwnLocalOptOut(true);//swagata
			
			newOrderInstance.createNewClassifiedInsertion();		       
			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("1",15, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("1",15, 1);
			Thread.sleep(2000);	      
			classifiedOrderInstance.selectClassifiedProductDrpDwn("1",15, 2);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackage("1",15, 3);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCode("1",15, 4);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();		       
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(5000);

			classifiedOrderInstance.clickEditAdBtn();
			classifiedOrderInstance.enterDetailsInAdMaterialObit();//swagata

			/* 	driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.carousel-modal")));

		   	classifiedOrderInstance.fillInTheMandatoryInputFldsInAdMaterialWindow("First Name", "Last Name");
		   	classifiedOrderInstance.fillInTheMandatoryTextAreaFldsInAdMaterialWindow("Obituary Text");
		   	classifiedOrderInstance.clickOnTheSaveAndContinueBtnInAdMaterialWindow();//swagata
		   //	driver.switchTo().defaultContent();*///swagata

			Thread.sleep(7000);
			classifiedOrderInstance.enterAttributeDetailsObitCTC();//swagata
			/*	classifiedOrderInstance.clickOnTheAttributeTab();
		   	classifiedOrderInstance.enterMentionedTextInMentionedInputFld("test", "City");//swagata
		   	classifiedOrderInstance.enterMentionedTextInMentionedTextAreaFld("aghosh@tribpub.com", "Contact Email");*/
			
			newOrderInstance.saveOrder();
			Thread.sleep(6000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : "+orderNumber);
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();

			Thread.sleep(1000);

			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();
			Thread.sleep(3000);
			dashboardPageInstance.clickOnLogout();//swagata

			/* Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);*/
		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"Order","sscTC04","Grp4","Group1","ADIT1Smoke","ssc","TestProd1","TestPriority","Patch0222","SmokeSet3","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void sscTC04(Map<String, String> userData) throws Exception{
		try
		{
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");			   			   

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);
			Thread.sleep(30000);
			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");
			Thread.sleep(4000);
			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnOrderEntryModule();
			Thread.sleep(4000);
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();
			Thread.sleep(4000);
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_SSC");
			newOrderInstance.enterSoldToCustomer("CU00117844");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");//swagata
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");//swagata
			newOrderInstance.checkUncheckOwnLocalOptOut(true);//swagata
			
			newOrderInstance.createNewClassifiedInsertion();		       
			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("1",16, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("1",16, 1);
			Thread.sleep(2000);	      
			classifiedOrderInstance.selectClassifiedProductDrpDwn("1",16, 2);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackage("1",16, 3);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCode("1",16, 4);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();		       
			classifiedOrderInstance.clickApplyBtn();




			Thread.sleep(5000);

			classifiedOrderInstance.clickEditAdBtn();


			classifiedOrderInstance.enterDetailsInAdMaterialObit();//swagata
			/*	driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.carousel-modal")));

		   	classifiedOrderInstance.fillInTheMandatoryInputFldsInAdMaterialWindow("First Name", "Last Name");
		   	classifiedOrderInstance.fillInTheMandatoryTextAreaFldsInAdMaterialWindow("ObitText");
		   	classifiedOrderInstance.clickOnTheSaveAndContinueBtnInAdMaterialWindow();
		   		   	classifiedOrderInstance.clickOnTheAttributeTab();
		   	/*classifiedOrderInstance.enterMentionedTextInMentionedInputFld("test", "City");
		   	classifiedOrderInstance.enterMentionedTextInMentionedTextAreaFld("aghosh@tribpub.com", "Contact Email");*///swagata
			Thread.sleep(3000);

			classifiedOrderInstance.enterAttributeDetailsObitSSC();//swagata

			//  newOrderInstance.saveOrder();

			Thread.sleep(6000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : "+orderNumber);
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();

			Thread.sleep(1000);

			String orderID = orderEntryPageInstance.getOrderNumber();
			//Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Logger.info("Order no. is:"+orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();//swagata
			/* Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);*/
		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	} 

	@Test(groups = {"Order","dprTC10","Grp4","Group1","ADIT1Smoke","osc","oscp","TestProd3","PatchProd","SmokeSet3","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void dprTC10(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();
			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_DPR");
			newOrderInstance.enterSoldToCustomer("CU00013249");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);

			newOrderInstance.createNewClassifiedInsertion();		       
			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("1",22, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("1",22, 1);
			Thread.sleep(2000);	      
			classifiedOrderInstance.selectClassifiedProductDrpDwn("1",22, 2);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackage("1",22, 3);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCode("1",22, 4);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();		       
			classifiedOrderInstance.clickApplyBtn();
			Thread.sleep(5000);

			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(7000);
			classifiedOrderInstance.enterDetailsInAdMaterialObit();


			Thread.sleep(7000);	

			classifiedOrderInstance.enterAttributeDetailsObitTBS();	



			newOrderInstance.saveOrder();

			Thread.sleep(6000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : "+orderNumber);
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();

			Thread.sleep(1000);

			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info("Order No. is:"+orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);

			Logger.info("Order No. is:"+orderID);

			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	@Test(groups = {"Order","dprTC11","Grp4","Group1","ADIT1Smoke","osc","oscp","TestProd3","PatchProd","SmokeSet3","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void dprTC11(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();
			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_DPR");
			newOrderInstance.enterSoldToCustomer("CU00013249");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);

			newOrderInstance.createNewClassifiedInsertion();		       
			Thread.sleep(6000);
			classifiedOrderInstance.selectPackageBU("1",21, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("1",21, 1);
			Thread.sleep(2000);	      
			classifiedOrderInstance.selectClassifiedProductDrpDwn("1",21, 2);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackage("1",21, 3);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCode("1",21, 4);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();		       
			classifiedOrderInstance.clickApplyBtn();
			Thread.sleep(5000);

			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(7000);
			classifiedOrderInstance.enterDetailsInAdMaterialObit();
			Thread.sleep(7000);	
			classifiedOrderInstance.enterAttributeDetailsObitDPR();	
			// newOrderInstance.saveOrder();

			Thread.sleep(6000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : "+orderNumber);
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();

			Thread.sleep(1000);

			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info("Order No. is:"+orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);

			Logger.info("Order No. is:"+orderID);
			newOrderInstance.killOrderNonProd();

			Thread.sleep(3000);
			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"Order","htfTC08","Grp4","Group1","ADIT1Smoke","osc","oscp","TestProd3","PatchProd","SmokeSet3","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void htfTC08(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();
			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_HTF");
			newOrderInstance.enterSoldToCustomer("CU00250481");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);

			newOrderInstance.createNewClassifiedInsertion();		       
			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("1",19, 0);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("1",19, 1);
			classifiedOrderInstance.selectClassifiedProductDrpDwn("1",19, 2);
			classifiedOrderInstance.selectClassifiedPackage("1",19, 3);
			classifiedOrderInstance.selectClassifiedClassCode("1",19, 4);
			classifiedOrderInstance.adsizeDropdown("1",19, 7);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();		       
			classifiedOrderInstance.clickApplyBtn();
			Thread.sleep(5000);

			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(7000);
			classifiedOrderInstance.enterDetailsInAdMaterialObitHTF();


			Thread.sleep(7000);	

			classifiedOrderInstance.enterAttributeDetailsObitHTF();



			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : "+orderNumber);
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();

			Thread.sleep(1000);

			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info("Order No. is:"+orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);

			Logger.info("Order No. is:"+orderID);
			newOrderInstance.killOrderNonProd();
			

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"Order","altTC04","Grp4","Group1","ADIT1Smoke","osc","oscp","TestProd3","PatchProd","SmokeSet3","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void altTC04(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();
			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_ALT");
			newOrderInstance.enterSoldToCustomer("CU00258088");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);

			newOrderInstance.createNewClassifiedInsertion();		       
			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("1",20, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("1",20, 1);
			Thread.sleep(2000);	      
			classifiedOrderInstance.selectClassifiedProductDrpDwn("1",20, 2);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackage("1",20, 3);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCode("1",20, 4);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();		       
			classifiedOrderInstance.clickApplyBtn();
			Thread.sleep(5000);

			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(7000);
			classifiedOrderInstance.enterDetailsInAdMaterialObit();


			Thread.sleep(7000);	

			//  classifiedOrderInstance.enterAttributeDetailsObit();	


			//newOrderInstance.saveOrder();


			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : "+orderNumber);
			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();

			Thread.sleep(1000);

			String orderID = orderEntryPageInstance.getOrderNumber();//issue
			Logger.info("Order No. is:"+orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);

			Logger.info("Order No. is:"+orderID);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			
			throw e;
		}
	}

	@Test(groups = {"Order","dprTC12","Grp4","Group1","ADIT1Smoke","dpr","Test2","TestProd3","Patch0222","SmokeSet1","SmokeFailed","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void dprTC12(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_DPR");
			newOrderInstance.enterSoldToCustomer("CU00013249");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); 
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",91, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",91,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",91, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",91, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",91, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1",91, 4);		       
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectColourForAnInsertion(1, "4C");
			Thread.sleep(4000);
			newOrderInstance.selectZone("1", "Daily Press");
			Thread.sleep(4000);
            newOrderInstance.selectAdSize(1, "1/4 V (3 Col x 10.5)");
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("2",56, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("2",56,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("2",56, 1);
			Thread.sleep(4000);
			   newOrderInstance.selectProduct("2",56, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("2",56, 3);
		       Thread.sleep(5000);
		       newOrderInstance.selectSection("2",56, 4);		       
		       Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("2");
			Thread.sleep(4000);
			//  newOrderInstance.selectAdSizeByIndexOnline(1, 0);
			//  Thread.sleep(4000);
			newOrderInstance.enterItemDescription("CUBE",1);
			Thread.sleep(4000);
			newOrderInstance.enterItemQuantity("100000",1);
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("2");//swagata
			Thread.sleep(4000);
			
		
			newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");//swagata
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);//swagata
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			//newOrderInstance.clickNoLegacyAutoInsertionCreation();//partha
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	//Jayanta
	@Test(groups = {"Order","dprTC13","Grp4","Group1","ADIT1Smoke","dpr","Test2","TestProd3","Patch0222","SmokeSet1","SmokeFailed","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void dprTC13(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_DPR");
			newOrderInstance.enterSoldToCustomer("CU00013249");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); 
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",91, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",91,27);//swagata
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",91, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",91, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",91, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1",91, 4);		       
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectColourForAnInsertion(1, "B/W");
			Thread.sleep(4000);
			newOrderInstance.selectZone("1", "Virginian Pilot");
			Thread.sleep(4000);
            newOrderInstance.selectAdSize(1, "1/2 H (6 Col x 10.5)");
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			Thread.sleep(4000);
			
			
			newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");//swagata
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);//swagata
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	//Jayanta
	@Test(groups = {"Order","dprTC14","Grp4","Group1","ADIT1Smoke","dpr","Test2","TestProd3","Patch0222","SmokeSet1","SmokeFailed","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void dprTC14(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_DPR");
			newOrderInstance.enterSoldToCustomer("CU00013249");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); 
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",91, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",91,27);//swagata
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",91, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",91, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",91, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1",91, 4);		       
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.selectColourForAnInsertion(1, "B/W");
			Thread.sleep(4000);
            newOrderInstance.selectAdSize(1, "1/2 V (3 Col x 21)");
			newOrderInstance.selectZone("1", "Full Run");
			Thread.sleep(4000);
			newOrderInstance.collapseInsertionDetails("1");//swagata
			Thread.sleep(4000);
			
			
			newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");//swagata
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);//swagata
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();

			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"Order","NdnTC04","Grp4","Group1","osc","TestProd3","Patch0222","set3","SmokeSet2","smokeSetS45"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ndnTC04(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_NDN");
			newOrderInstance.enterSoldToCustomer("CU00646890");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",92, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",92,27);
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",92, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",92, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",92, 3);
			Thread.sleep(3000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(3000);
			newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");
			Thread.sleep(3000);
			//  newOrderInstance.selectMaterialSource("1","N/A");
			/*  newOrderInstance.checkUncheckBillQty(false);
	       Thread.sleep(3000);	
	       newOrderInstance.enterBilledQty(5);
	       Thread.sleep(3000);	*/
			newOrderInstance.clickOnDistributions(1);
			//Thread.sleep(45000);//swagata
			//  newOrderInstance.clickOnSearchZoneLink();
			//  Thread.sleep(10000);
			newOrderInstance.selectZonePreprintOrder("Full");
			// int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
			newOrderInstance.confirmZoneSelection();	
			Thread.sleep(5000);
			newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
			Thread.sleep(3000);	
			newOrderInstance.selectPageType("1", "PP_PaperType_Singlesheet");
			Thread.sleep(3000);	
			newOrderInstance.enterPageCount("2");
			/*  Thread.sleep(4000);
	       newOrderInstance.clickOnProgramPriceSelector();
	       Thread.sleep(3000);	
	       newOrderInstance.selectFirstSpecialProgramPromotion();
	       Thread.sleep(3000);	*/
			newOrderInstance.clickOnPAndDTab();
			Thread.sleep(3000);
			newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_AdProd"); 
			Thread.sleep(3000);
			newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
			Thread.sleep(3000);		
			newOrderInstance.selectPandDInk("1", "4C");
			Thread.sleep(3000);
			//   newOrderInstance.selectPandDPrinter("1", "Doodad");//swagata
			newOrderInstance.selectPandDPrinter("1", "PP_Printer_Doodad");//swagata

			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//newOrderInstance.removeSalesRepOnInsertion(1);
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(1);
			Thread.sleep(4000);
			newOrderInstance.addServiceRep("031200");
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			// Thread.sleep(10000);//swagata
			//    newOrderInstance.clickOnContinuePastDeadlineDate();
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info("Order No. is:"+orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);//swagata
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();
			Thread.sleep(3000);
			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
