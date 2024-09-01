package com.tribune.adit2.test;


import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.PricingAdmin.PricingAdminHome;
import com.tribune.adit2.SpecialPrograms.NewContractPage;
import com.tribune.adit2.SpecialPrograms.SpecialProgramLandingPage;

import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

import junit.framework.Assert;
import java.text.DecimalFormat;

public class SpecialProgramCreationValidation 
{

	public String contract = "";
	public String promotion = "";


	@Test(groups = {"createNewContractAllTypes"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewContractAllTypes(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnSpecialProgramsModule();

			SpecialProgramLandingPage contractCreation = PageFactory.initElements(driver, SpecialProgramLandingPage.class);
			TribuneUtils utils  = new TribuneUtils();
			contractCreation.clickOnNewContractButton();
			Thread.sleep(3000);
			NewContractPage contractCreate =  PageFactory.initElements(driver, NewContractPage.class);
			String str = utils.generateRandomString(15);
			contractCreate.enterContractName("Auto Test "+str);
			contractCreate.inputCustomer("CU00059747");
			contractCreate.enterComments("This is a test contract created through automation");

			contractCreate.enterContractEffectiveToDate(12,28,2019);
			contractCreate.enterComments.click();
			//   contractCreate.enterContractEffectiveFromDate(10,28,2019);
			contractCreate.clickOnSave();
			Thread.sleep(6000);
			contractCreate.clickOnProductsTab();
			Thread.sleep(6000);
			contractCreate.clickOnAddProductButton();
			Thread.sleep(3000);
			contractCreate.selectBU("CTC-CTMG");
			Thread.sleep(3000);
			contractCreate.selectProductType("Display");
			Thread.sleep(3000);
			contractCreate.clickaddProductsButton();
			Thread.sleep(3000);
			contractCreate.selectProduct("CTC - Chicago Tribune(Display)");
			contractCreate.clickOnAddPricingRuleButton();
			contractCreate.selectPricingType("Fixed Price");
			contractCreate.enterCommentsPricing("This is a test contract created through automation");
			contractCreate.enterAmountPricing("100");
			// contractCreate.enterHolidayAmountPricing("200");
			contractCreate.selectFilterType("Day Of Week");
			contractCreate.selectDayOfWeek("Wednesday");
			contractCreate.clickOnAddFilterButton();
			contractCreate.clickOnAddPricingRuleBtn();
			Thread.sleep(5000);		      
			contractCreate.clickOnAddPricingRuleButton();
			contractCreate.selectPricingType("CPI Price");
			contractCreate.enterCommentsPricing("This is a test contract created through automation");
			contractCreate.enterAmountPricing("200");
			// contractCreate.enterHolidayAmountPricing("200");
			contractCreate.selectFilterType("Day Of Week");
			contractCreate.selectDayOfWeek("Thursday");
			contractCreate.clickOnAddFilterButton();
			contractCreate.clickOnAddPricingRuleBtn();
			Thread.sleep(5000);
			contractCreate.clickOnAddPricingRuleButton();
			contractCreate.selectPricingType("Percent Off");
			contractCreate.enterCommentsPricing("This is a test contract created through automation");
			contractCreate.enterPercentOffPricing("10");
			// contractCreate.enterHolidayPercentOffPricing("20");
			contractCreate.selectFilterType("Day Of Week");
			contractCreate.selectDayOfWeek("Friday");
			contractCreate.clickOnAddFilterButton();
			contractCreate.clickOnAddPricingRuleBtn();
			Thread.sleep(5000);
			contractCreate.clickOnAddPricingRuleButton();
			contractCreate.selectPricingType("Dollar(s) off");
			contractCreate.enterCommentsPricing("This is a test contract created through automation");
			contractCreate.enterAmountPricing("300");
			// contractCreate.enterHolidayAmountPricing("200");
			contractCreate.selectFilterType("Day Of Week");
			contractCreate.selectDayOfWeek("Saturday");
			contractCreate.clickOnAddFilterButton();
			contractCreate.clickOnAddPricingRuleBtn();
			Thread.sleep(5000);
			contractCreate.clickOnAddProductButton();
			contractCreate.selectBU("CTC-CTMG");
			Thread.sleep(3000);
			contractCreate.selectProductType("Preprint");
			Thread.sleep(3000);
			contractCreate.clickaddProductsButton();
			Thread.sleep(3000);
			contractCreate.selectProduct("LAT - Daily Pilot(Preprint)");
			contractCreate.clickOnAddPricingRuleButton();
			contractCreate.selectPricingType("CPM Price");
			contractCreate.enterCommentsPricing("This is a test contract created through automation");
			contractCreate.enterAmountPricing("50");
			// contractCreate.enterHolidayAmountPricing("200");
			contractCreate.selectFilterType("Day Of Week");
			contractCreate.selectDayOfWeek("Tuesday");
			contractCreate.clickOnAddFilterButton();
			contractCreate.clickOnAddPricingRuleBtn();
			Thread.sleep(5000);		
			dashboardPageInstance.clickOnSpecialProgramsModule();
			Thread.sleep(5000);	
			contractCreation.enterName("Auto Test "+str);
			Thread.sleep(3000);
			contractCreation.clickOnSearch();
			Thread.sleep(5000);	
			contractCreation.clickOnContract("Auto Test "+str);
			Thread.sleep(5000);
			dashboardPageInstance.clickOnPricingModule();
			Thread.sleep(5000);
			PricingAdminHome pricing = PageFactory.initElements(driver, PricingAdminHome.class);
			pricing.clickRefreshButton();	
			Thread.sleep(5000);
			pricing.clickRefreshButton();	
			Thread.sleep(5000);
			dashboardPageInstance.clickOnOrderEntryModule();
			Thread.sleep(5000);
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			//  Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",8, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDate("1","19","Dec","2019");
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",8, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",8, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",8, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1",8, 4);		       
			Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			double fixedContractPrice = newOrderInstance.getInsertionPrice("1","contract");
			Thread.sleep(4000);
			Logger.info("Fixed COntract Price: "+fixedContractPrice);
			Assert.assertEquals(100.0, fixedContractPrice);
			double totalInsertionPrice = newOrderInstance.getInsertionPrice("1","total");
			Thread.sleep(4000);
			Logger.info("total fixed contract insertion price: "+totalInsertionPrice);
			Assert.assertEquals(100.0, totalInsertionPrice);
			Thread.sleep(4000);
			Logger.info("Fixed contract pricing is as expected");
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(7000);
			newOrderInstance.enterPubDate("1","21", "Dec", "2019");
			Thread.sleep(5000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			double percentOffContractPrice = newOrderInstance.getInsertionPrice("1","contract");
			Thread.sleep(4000);		       
			Logger.info("percentOffContractPrice: "+percentOffContractPrice);
			double basePrice = newOrderInstance.getInsertionPrice("1","base");
			Thread.sleep(4000);
			Logger.info("basePrice: "+basePrice);
			double priceDiscount = (basePrice - percentOffContractPrice) ;
			Thread.sleep(4000);
			Logger.info("priceDiscount: "+priceDiscount);
			double value = (0.1*basePrice);
			DecimalFormat df2 = new DecimalFormat(".##");
			Assert.assertEquals(df2.format(value), df2.format(priceDiscount));
			Thread.sleep(4000);
			double totalPrice2 = newOrderInstance.getInsertionPrice("1","total");
			Thread.sleep(4000);	
			Logger.info("total percentOffContract Insertion Price: "+totalPrice2);
			Assert.assertEquals(percentOffContractPrice, totalPrice2);		      
			Thread.sleep(4000);
			Logger.info("Percent Off contract pricing is as expected");
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(7000);
			newOrderInstance.enterPubDate("1","22", "Dec", "2019");
			Thread.sleep(5000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			double dollarOffContractPrice = newOrderInstance.getInsertionPrice("1","contract");
			Thread.sleep(4000);
			Logger.info("dollarOffContractPrice: "+dollarOffContractPrice);
			double basePrice1 = newOrderInstance.getInsertionPrice("1","base");
			Thread.sleep(4000);
			Logger.info("basePrice1: "+basePrice1);
			double priceDiscount1 = (basePrice - dollarOffContractPrice) ;
			Thread.sleep(4000);
			Logger.info("priceDiscount1: "+priceDiscount1);
			Assert.assertEquals(300.0, priceDiscount1);
			Thread.sleep(4000);
			double totalPrice1 = newOrderInstance.getInsertionPrice("1","total");
			Thread.sleep(4000);		
			Logger.info("total dollarOffContract Insertion Price: "+totalPrice1);	
			Assert.assertEquals(dollarOffContractPrice, totalPrice1, 0);		      
			Thread.sleep(4000);
			Logger.info("Dollar Off contract pricing is as expected");
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);		
			newOrderInstance.saveOrder();
			Thread.sleep(3000);
			newOrderInstance.createDuplicateInsertion("1");
			Thread.sleep(7000);
			newOrderInstance.enterPubDate("1","18", "Dec", "2019");
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",10, 1);
			Thread.sleep(4000);		
			newOrderInstance.selectProduct("1",8, 2);
			Thread.sleep(4000);       
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			Thread.sleep(4000);      		      
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckBillQty(false);
			Thread.sleep(4000);
			newOrderInstance.enterBilledQty(22);
			Thread.sleep(4000);
			double cpmContractPrice = newOrderInstance.getPreprintInsertionPrice("1","contract");
			Thread.sleep(4000);
			Logger.info("cpmContractPrice: "+cpmContractPrice);
			double value1 = 1.10 ;//((22*50)/1000)
			Logger.info("value1: "+value1);
			//  DecimalFormat df2 = new DecimalFormat(".##");
			Assert.assertEquals(df2.format(value1), df2.format(cpmContractPrice));
			double totalPrice = newOrderInstance.getPreprintInsertionPrice("1","total");
			Thread.sleep(4000);		   	
			Logger.info("total CPM Contract Insertion Price: "+totalPrice);	
			Assert.assertEquals(cpmContractPrice, totalPrice);		      
			Thread.sleep(4000);
			Logger.info("CPM contract pricing is as expected");
			Thread.sleep(4000);
			newOrderInstance.saveOrder();
			Thread.sleep(3000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : "+orderNumber);
			dashboardPageInstance.clickOnLogout();//swagata

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/*	@Test(groups = {"createNewContractFixedPrice","SpecialProgramReg","NewRegression","G4","RerunF2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void createNewContractFixedPrice(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnSpecialProgramsModule();

		       SpecialProgramLandingPage contractCreation = PageFactory.initElements(driver, SpecialProgramLandingPage.class);
		       TribuneUtils utils  = new TribuneUtils();
		       contractCreation.clickOnNewContractButton();
		       Thread.sleep(3000);
		       NewContractPage contractCreate =  PageFactory.initElements(driver, NewContractPage.class);
		       String str = utils.generateRandomString(15);
		       contractCreate.enterContractName("Auto Test Fixed Price "+str);
		     //contractCreate.inputCustomer("CU00059747");//Shalni
		       contractCreate.inputCustomer("CU80040767");//shalni
		       contractCreate.enterComments("This is a test contract created through automation");

		       contractCreate.enterContractEffectiveToDate(12,28,2019);
		       contractCreate.enterComments.click();
		    //   contractCreate.enterContractEffectiveFromDate(10,28,2019);
		       contractCreate.clickOnSave();
		       Thread.sleep(6000);
		       contractCreate.clickOnProductsTab();
		       Thread.sleep(6000);
		       contractCreate.clickOnAddProductButton();
		       Thread.sleep(3000);
		       contractCreate.selectBU("CTC-CTMG");
		       Thread.sleep(3000);
		       contractCreate.selectProductType("Display");
		       Thread.sleep(3000);
		       contractCreate.selectProduct("CTC - Chicago Tribune(Display)");//shalini
		       contractCreate.clickaddProductsButton();
		       Thread.sleep(3000);
		       contractCreate.selectProduct("CTC - Chicago Tribune(Display)");
		       contractCreate.clickOnAddPricingRuleButton();
		       Thread.sleep(3000);
		       contractCreate.selectPricingType("Fixed Price");
		       contractCreate.enterCommentsPricing("This is a test contract created through automation");
		       contractCreate.enterAmountPricing("100");
		      // contractCreate.enterHolidayAmountPricing("200");
		       contractCreate.selectFilterType("Day Of Week");
		       contractCreate.selectDayOfWeek("Wednesday");
		       contractCreate.clickOnAddFilterButton();
		       contractCreate.clickOnAddPricingRuleBtn();
		       Thread.sleep(5000);
		       dashboardPageInstance.clickOnSpecialProgramsModule();
		       Thread.sleep(5000);	
		       contractCreation.enterName("Auto Test Fixed Price "+str);
		       Thread.sleep(3000);
		       contractCreation.clickOnSearch();
		       Thread.sleep(5000);	
		       contractCreation.clickOnContract("Auto Test Fixed Price "+str);
		       Thread.sleep(5000);
		       dashboardPageInstance.clickOnPricingModule();
		       Thread.sleep(5000);
		       PricingAdminHome pricing = PageFactory.initElements(driver, PricingAdminHome.class);
		       pricing.clickRefreshButton();	
		       Thread.sleep(5000);
		       pricing.clickRefreshButton();	
		       Thread.sleep(5000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       Thread.sleep(5000);
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryPageInstance.clickOnNewGeneralOrder();

		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       Thread.sleep(4000);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);
		       newOrderInstance.selectBU("1",8, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","19","Dec","2019");
		       Thread.sleep(5000);
		       newOrderInstance.selectProductType("1",8, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",8, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",8, 3);
		       Thread.sleep(5000);
		       newOrderInstance.selectSection("1",8, 4);		       
		       Thread.sleep(6000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		       double fixedContractPrice = newOrderInstance.getInsertionPrice("1","contract");
		       Thread.sleep(4000);
		       Logger.info("Fixed COntract Price: "+fixedContractPrice);
		       Assert.assertEquals(100.0, fixedContractPrice);
		       double totalInsertionPrice = newOrderInstance.getInsertionPrice("1","total");
		       Thread.sleep(4000);
		       Logger.info("total fixed contract insertion price: "+totalInsertionPrice);
		       Assert.assertEquals(100.0, totalInsertionPrice);
		       Thread.sleep(4000);
		       Logger.info("Fixed contract pricing is as expected");
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		       Thread.sleep(4000);
		       newOrderInstance.saveOrder();
		       Thread.sleep(3000);

		       String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

		       Logger.info("Saved Order : "+orderNumber);
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
		   }

	@Test(groups = {"createNewContractPercentOff","SpecialProgramReg","NewRegression","G4","RerunF2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void createNewContractPercentOff(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnSpecialProgramsModule();

		       SpecialProgramLandingPage contractCreation = PageFactory.initElements(driver, SpecialProgramLandingPage.class);
		       TribuneUtils utils  = new TribuneUtils();
		       contractCreation.clickOnNewContractButton();
		       Thread.sleep(3000);
		       NewContractPage contractCreate =  PageFactory.initElements(driver, NewContractPage.class);
		       String str = utils.generateRandomString(15);
		       contractCreate.enterContractName("Auto Test Percent Off "+str);
		       contractCreate.inputCustomer("CU00059747");
		       contractCreate.enterComments("This is a test contract created through automation");

		       contractCreate.enterContractEffectiveToDate(12,28,2019);
		       contractCreate.enterComments.click();
		    //   contractCreate.enterContractEffectiveFromDate(10,28,2019);
		       contractCreate.clickOnSave();
		       Thread.sleep(6000);
		       contractCreate.clickOnProductsTab();
		       Thread.sleep(6000);
		       contractCreate.clickOnAddProductButton();
		       Thread.sleep(3000);
		       contractCreate.selectBU("CTC-CTMG");
		       Thread.sleep(3000);
		       contractCreate.selectProductType("Display");
		       Thread.sleep(3000);
		       contractCreate.clickaddProductsButton();
		       Thread.sleep(3000);
		       contractCreate.selectProduct("CTC - Chicago Tribune(Display)");
		       contractCreate.clickOnAddPricingRuleButton();
		       Thread.sleep(3000);
		       contractCreate.selectPricingType("Percent Off");
		       contractCreate.enterCommentsPricing("This is a test contract created through automation");
		       contractCreate.enterPercentOffPricing("10");
		      // contractCreate.enterHolidayPercentOffPricing("20");
		       contractCreate.selectFilterType("Day Of Week");
		       contractCreate.selectDayOfWeek("Friday");
		       contractCreate.clickOnAddFilterButton();
		       contractCreate.clickOnAddPricingRuleBtn();
		       Thread.sleep(5000);
		       dashboardPageInstance.clickOnSpecialProgramsModule();
		       Thread.sleep(5000);	
		       contractCreation.enterName("Auto Test Percent Off "+str);
		       Thread.sleep(3000);
		       contractCreation.clickOnSearch();
		       Thread.sleep(5000);	
		       contractCreation.clickOnContract("Auto Test Percent Off "+str);
		       Thread.sleep(5000);
		       dashboardPageInstance.clickOnPricingModule();
		       Thread.sleep(5000);
		       PricingAdminHome pricing = PageFactory.initElements(driver, PricingAdminHome.class);
		       pricing.clickRefreshButton();	
		       Thread.sleep(5000);
		       pricing.clickRefreshButton();	
		       Thread.sleep(5000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       Thread.sleep(5000);
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryPageInstance.clickOnNewGeneralOrder();

		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		      //  Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       Thread.sleep(4000);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);
		       newOrderInstance.selectBU("1",8, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","21", "Dec", "2019");
		       Thread.sleep(5000);
		       newOrderInstance.selectProductType("1",8, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",8, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",8, 3);
		       Thread.sleep(5000);
		       newOrderInstance.selectSection("1",8, 4);		       
		       Thread.sleep(6000); 		       
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		       double percentOffContractPrice = newOrderInstance.getInsertionPrice("1","contract");
		       Thread.sleep(4000);		       
		       Logger.info("percentOffContractPrice: "+percentOffContractPrice);
		       double basePrice = newOrderInstance.getInsertionPrice("1","base");
		       Thread.sleep(4000);
		       Logger.info("basePrice: "+basePrice);
		       double priceDiscount = (basePrice - percentOffContractPrice) ;
		       Thread.sleep(4000);
		       Logger.info("priceDiscount: "+priceDiscount);
		       double value = (0.1*basePrice);
		       DecimalFormat df2 = new DecimalFormat(".##");
		       Assert.assertEquals(df2.format(value), df2.format(priceDiscount));
		       Thread.sleep(4000);
		       double totalPrice2 = newOrderInstance.getInsertionPrice("1","total");
		       Thread.sleep(4000);	
		       Logger.info("total percentOffContract Insertion Price: "+totalPrice2);
		       Assert.assertEquals(percentOffContractPrice, totalPrice2);		      
		       Thread.sleep(4000);
		       Logger.info("Percent Off contract pricing is as expected");
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		       Thread.sleep(4000);
		       newOrderInstance.saveOrder();
		       Thread.sleep(3000);

		       String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

		       Logger.info("Saved Order : "+orderNumber);
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
		   }*/
	@Test(groups = {"SMaintenance","ShaliniContractfixed","specialProgram","NewRegression3","NovMaintenance","NewRegression","createNewContractFixedPrice","SpecialProgramReg","Group3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewContractFixedPrice(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnSpecialProgramsModule();

			SpecialProgramLandingPage contractCreation = PageFactory.initElements(driver, SpecialProgramLandingPage.class);
			TribuneUtils utils  = new TribuneUtils();
			contractCreation.clickOnNewContractButton();
			Thread.sleep(3000);
			NewContractPage contractCreate =  PageFactory.initElements(driver, NewContractPage.class);
			String str = utils.generateRandomString(15);
			contractCreate.enterContractName("Auto Test Fixed Price "+str);
			contractCreate.inputCustomer("CU00000010");//Shalni
			//contractCreate.inputCustomer("CU80040767");//swagata
			//contractCreate.inputCustomer("CU80018679");//swagata
			
			contractCreate.enterComments("This is a test contract created through automation");

			contractCreate.enterContractEffectiveToDateFromExcel(88, 27);//swagata
			contractCreate.enterComments.click();
			//   contractCreate.enterContractEffectiveFromDate(10,28,2019);
			contractCreate.clickOnSave();
			Thread.sleep(9000);
			contractCreate.clickOnProductsTab();
			Thread.sleep(6000);
			contractCreate.clickOnAddProductButton();
			Thread.sleep(3000);
			contractCreate.selectBU("CTC-CTMG");
			Thread.sleep(3000);
			contractCreate.selectProductType("Display");
		
			Thread.sleep(3000);
			contractCreate.selectProduct("Chicago Tribune");//swagata
			contractCreate.clickaddProductsButton();//swagata

			//contractCreate.selectProduct("CTC - Chicago Tribune(Display)");//swagata
			Thread.sleep(9000);
			// contractCreate.selectProduct("CTC - Chicago Tribune(Display)");//shalni
			contractCreate.clickOnAddPricingRuleButton();
			Thread.sleep(3000);
			contractCreate.selectPricingType("Fixed Price");
			contractCreate.enterCommentsPricing("This is a test contract created through automation");
			contractCreate.enterAmountPricing("100");
			// contractCreate.enterHolidayAmountPricing("200");
			contractCreate.selectFilterType("Day Of Week");
			contractCreate.selectDayOfWeek("Select all");
			Thread.sleep(4000);
			contractCreate.clickOnAddFilterButton();
			contractCreate.clickOnAddPricingRuleBtn();
			Thread.sleep(5000);
			dashboardPageInstance.clickOnSpecialProgramsModule();
			Thread.sleep(5000);	
			contractCreation.enterName("Auto Test Fixed Price "+str);
			Thread.sleep(3000);
			contractCreation.selectStatus("All"); //joy
			Thread.sleep(3000);
			contractCreation.clickOnSearch();
			Thread.sleep(5000);	
			contractCreation.clickOnContract("Auto Test Fixed Price "+str);
			Thread.sleep(5000);
			dashboardPageInstance.clickOnPricingModule();
			Thread.sleep(5000);
			PricingAdminHome pricing = PageFactory.initElements(driver, PricingAdminHome.class);
			pricing.clickRefreshButton();	
			Thread.sleep(5000);
			pricing.clickRefreshButton();	
			Thread.sleep(5000);
			dashboardPageInstance.clickOnOrderEntryModule();
			Thread.sleep(5000);
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			//newOrderInstance.selectSoldToCustomerBU("bu_OSC");//swagata
			//newOrderInstance.enterSoldToCustomer("CU80040767");//swagata
			newOrderInstance.selectSoldToCustomerBU("bu_DPR");//swagata
			newOrderInstance.enterSoldToCustomer("CU00000010");//swagata
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",8, 0);
			Thread.sleep(4000);
			//newOrderInstance.enterPubDate("1","16","Dec","2019");//swagata
			newOrderInstance.enterPubDateFromExcel("1", 88, 27);//swagata

			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",8, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",8, 2);
			Thread.sleep(4000);
			/*newOrderInstance.selectAdType("1",8, 3);
		       Thread.sleep(5000);
		       newOrderInstance.selectSection("1",8, 4);		       
		       Thread.sleep(6000);*/
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			double fixedContractPrice = newOrderInstance.getInsertionPrice("1","contract");
			Thread.sleep(4000);
			Logger.info("Fixed COntract Price: "+fixedContractPrice);
			Assert.assertEquals(100.0, fixedContractPrice);
			double totalInsertionPrice = newOrderInstance.getInsertionPrice("1","total");
			Thread.sleep(4000);
			Logger.info("total fixed contract insertion price: "+totalInsertionPrice);
			Assert.assertEquals(100.0, totalInsertionPrice);
			Thread.sleep(4000);
			Logger.info("Fixed contract pricing is as expected");
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.saveOrder();
			Thread.sleep(3000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : "+orderNumber);
			dashboardPageInstance.clickOnLogout();//swagata

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	@Test(groups = {"SMaintenance","createNewContractDollarOff","specialProgram","PrioritizedReg3","NovMaintenance","SpecialProgramReg","NewRegression3","NewRegression","G4","RerunF2","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewContractDollarOff(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnSpecialProgramsModule();

			SpecialProgramLandingPage contractCreation = PageFactory.initElements(driver, SpecialProgramLandingPage.class);
			TribuneUtils utils  = new TribuneUtils();
			contractCreation.clickOnNewContractButton();
			Thread.sleep(3000);
			NewContractPage contractCreate =  PageFactory.initElements(driver, NewContractPage.class);
			String str = utils.generateRandomString(15);
			contractCreate.enterContractName("Auto Test Dollar Off "+str);
			//contractCreate.inputCustomer("CU00059747");//swagata
			contractCreate.inputCustomer("CU00258088");//swagata
			contractCreate.enterContractEffectiveToDateFromExcel(17, 27);//swagata
			contractCreate.enterComments("This is a test contract created through automation");
			contractCreate.enterComments.click();
			//   contractCreate.enterContractEffectiveFromDate(10,28,2019);
			contractCreate.clickOnSave();
		    Thread.sleep(6000);
			contractCreate.clickOnProductsTab();
			Thread.sleep(6000);
			contractCreate.clickOnAddProductButton();
			Thread.sleep(5000);
			contractCreate.selectBU("CTC-CTMG");
			Thread.sleep(3000);
			contractCreate.selectProductType("Display");
			Thread.sleep(3000);
			contractCreate.selectProduct("Chicago Tribune");//swagata
            contractCreate.clickaddProductsButton();
			Thread.sleep(5000);//shalini
			//contractCreate.selectProduct("CTC - Chicago Tribune(Display)");//swagata
			contractCreate.clickOnAddPricingRuleButton();
			contractCreate.selectPricingType("Dollar(s) off");//swagata
			contractCreate.enterCommentsPricing("This is a test contract created through automation");
			contractCreate.enterAmountPricing("10");//swagata
			// contractCreate.enterHolidayAmountPricing("200");
			contractCreate.selectFilterType("Day Of Week");
			contractCreate.selectDayOfWeek("Sunday");
			contractCreate.clickOnAddFilterButton();
			contractCreate.clickOnAddPricingRuleBtn();
			Thread.sleep(5000);
			dashboardPageInstance.clickOnSpecialProgramsModule();
			Thread.sleep(5000);	
			contractCreation.enterName("Auto Test Dollar Off "+str);
			Thread.sleep(3000);
			contractCreation.selectStatus("All"); //joy
			Thread.sleep(3000);
			
			contractCreation.clickOnSearch();
			Thread.sleep(5000);	
			contractCreation.clickOnContract("Auto Test Dollar Off "+str);
			Thread.sleep(5000);
			dashboardPageInstance.clickOnPricingModule();
			Thread.sleep(5000);
			PricingAdminHome pricing = PageFactory.initElements(driver, PricingAdminHome.class);
			pricing.clickRefreshButton();	
			Thread.sleep(5000);
			pricing.clickRefreshButton();	
			Thread.sleep(5000);
			dashboardPageInstance.clickOnOrderEntryModule();
			Thread.sleep(5000);
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			//newOrderInstance.selectSoldToCustomerBU("bu_OSC");//swagata
			//newOrderInstance.enterSoldToCustomer("CU80040767");//swagata
			newOrderInstance.selectSoldToCustomerBU("bu_ALT");//swagata
			newOrderInstance.enterSoldToCustomer("CU00258088");//swagata
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			//  Thread.sleep(4000); 
			newOrderInstance.checkUncheckOwnLocalOptOut(true);//swagata
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",8, 0);
			Thread.sleep(4000);
			//newOrderInstance.enterPubDate("1","22", "Dec", "2019");
			newOrderInstance.enterPubDateFromExcel("1", 17, 27);//swagata
			Thread.sleep(7000);
			newOrderInstance.selectProductType("1",8, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",8, 2);
			Thread.sleep(4000);
			newOrderInstance.selectAdType("1",8, 3);
			Thread.sleep(5000);
			newOrderInstance.selectSection("1",8, 4);		       
			Thread.sleep(6000); 	
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			double dollarOffContractPrice = newOrderInstance.getInsertionPrice("1","contract");
			Thread.sleep(4000);
			Logger.info("dollarOffContractPrice: "+dollarOffContractPrice);
			double basePrice1 = newOrderInstance.getInsertionPrice("1","base");
			Thread.sleep(4000);
			Logger.info("basePrice1: "+basePrice1);
			double priceDiscount1 = (basePrice1 - dollarOffContractPrice) ;
			Thread.sleep(4000);
			Logger.info("priceDiscount1: "+priceDiscount1);
			Assert.assertEquals(10.0, priceDiscount1);//swagata
			Thread.sleep(4000);
			double totalPrice1 = newOrderInstance.getInsertionPrice("1","contract");
			Thread.sleep(4000);		
			Logger.info("total dollarOffContract Insertion Price: "+totalPrice1);	
			Assert.assertEquals(dollarOffContractPrice, totalPrice1, 0);		      
			Thread.sleep(4000);
			Logger.info("Dollar Off contract pricing is as expected");
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.saveOrder();
			Thread.sleep(3000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : "+orderNumber);
			dashboardPageInstance.clickOnLogout();//swagata

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	@Test(groups = {"SMaintenance","createNewContractCPM","specialProgram","SpecialProgramReg","NovMaintenance","NewRegression3","NewRegression","G4","RerunF2","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewContractCPM(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnSpecialProgramsModule();

			SpecialProgramLandingPage contractCreation = PageFactory.initElements(driver, SpecialProgramLandingPage.class);
			TribuneUtils utils  = new TribuneUtils();
			contractCreation.clickOnNewContractButton();
			Thread.sleep(3000);
			NewContractPage contractCreate =  PageFactory.initElements(driver, NewContractPage.class);
			String str = utils.generateRandomString(15);
			contractCreate.enterContractName("Auto Test CPM "+str);
			//contractCreate.inputCustomer("CU00059747");//swagata
			contractCreate.inputCustomer("CU80018679");//swagata
        	contractCreate.enterComments("This is a test contract created through automation");

			contractCreate.enterContractEffectiveToDateFromExcel(1, 27);//swagata
			contractCreate.enterComments.click();
			//   contractCreate.enterContractEffectiveFromDate(10,28,2019);
			contractCreate.clickOnSave();
			Thread.sleep(6000);
			contractCreate.clickOnProductsTab();
			Thread.sleep(6000);
			contractCreate.clickOnAddProductButton();
			Thread.sleep(5000);
			contractCreate.selectBU("CTC-CTMG");
			Thread.sleep(4000);
			contractCreate.selectProductType("Preprint");
			Thread.sleep(3000);
			contractCreate.selectProduct("CT-Preprints");//swagata

			contractCreate.clickaddProductsButton();
			Thread.sleep(5000);
			// contractCreate.selectProduct("LAT - Daily Pilot(Preprint)");//swagata
			contractCreate.clickOnAddPricingRuleButton();
			Thread.sleep(3000);
			contractCreate.selectPricingType("CPM Price");
			contractCreate.enterCommentsPricing("This is a test contract created through automation");
			contractCreate.enterAmountPricing("50");
			// contractCreate.enterHolidayAmountPricing("200");
			contractCreate.selectFilterType("Day Of Week");
			Thread.sleep(3000);
			contractCreate.selectDayOfWeek("Select all");
			Thread.sleep(3000);
			contractCreate.clickOnAddFilterButton();
			Thread.sleep(3000);
			contractCreate.clickOnAddPricingRuleBtn();
			Thread.sleep(5000);
			dashboardPageInstance.clickOnSpecialProgramsModule();
			Thread.sleep(5000);	
			contractCreation.enterName("Auto Test CPM "+str);
			Thread.sleep(3000);
			
			contractCreation.selectStatus("All"); //joy
			Thread.sleep(3000);
			contractCreation.clickOnSearch();
			Thread.sleep(5000);	
			contractCreation.clickOnContract("Auto Test CPM "+str);
			Thread.sleep(5000);
			dashboardPageInstance.clickOnPricingModule();
			Thread.sleep(5000);
			PricingAdminHome pricing = PageFactory.initElements(driver, PricingAdminHome.class);
			pricing.clickRefreshButton();	
			Thread.sleep(5000);
			pricing.clickRefreshButton();	
			Thread.sleep(5000);
			dashboardPageInstance.clickOnOrderEntryModule();
			Thread.sleep(5000);
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_DPR");//swagata
			newOrderInstance.enterSoldToCustomer("CU80018679");//swagata
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			//  Thread.sleep(4000);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",8, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",1,27);//swagata
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",10, 1);
			Thread.sleep(4000);	
			//newOrderInstance.selectProduct("1",8, 2);//swagata
			newOrderInstance.selectProduct("1", 10, 2);//swagata
			Thread.sleep(4000);       
			newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			Thread.sleep(4000);      		      
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.checkUncheckBillQty(false);
			Thread.sleep(4000);
			newOrderInstance.enterBilledQty(22);//swagata
			//newOrderInstance.enterBilledQty(1000);//swagata
			Thread.sleep(4000);
			double cpmContractPrice = newOrderInstance.getPreprintInsertionPrice("1","contract");
			Thread.sleep(7000);
			Logger.info("cpmContractPrice: "+cpmContractPrice);
			double value1 = 1.10 ;//((22*50)/1000)
			//double value1 = 50.00 ;//((50*1000)/1000)//swagata

			Logger.info("value1: "+value1);
			DecimalFormat df2 = new DecimalFormat(".##");
			Assert.assertEquals(df2.format(value1), df2.format(cpmContractPrice));
			double totalPrice = newOrderInstance.getPreprintInsertionPrice("1","total");
			Thread.sleep(4000);		   	
			Logger.info("total CPM Contract Insertion Price: "+totalPrice);	
			Assert.assertEquals(cpmContractPrice, totalPrice);		      
			Thread.sleep(4000);
			Logger.info("CPM contract pricing is as expected");
			Thread.sleep(4000);
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.saveOrder();
			Thread.sleep(5000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : "+orderNumber);
			dashboardPageInstance.clickOnLogout();//swagata

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	//arka
	/*@Test(groups = {"createNewContractCPI","SpecialProgramReg","NewRegression","G4","RerunF2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void createNewContractCPI(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnSpecialProgramsModule();

		       SpecialProgramLandingPage contractCreation = PageFactory.initElements(driver, SpecialProgramLandingPage.class);
		       TribuneUtils utils  = new TribuneUtils();
		       contractCreation.clickOnNewContractButton();
		       Thread.sleep(3000);
		       NewContractPage contractCreate =  PageFactory.initElements(driver, NewContractPage.class);
		       String str = utils.generateRandomString(15);
		       contractCreate.enterContractName("Auto Test CPI Price "+str);
		       contractCreate.inputCustomer("CU80018679");
		       contractCreate.enterComments("This is a test contract created through automation");

		       contractCreate.enterContractEffectiveToDate(12,28,2019);
		       contractCreate.enterComments.click();
		    //   contractCreate.enterContractEffectiveFromDate(10,28,2019);
		       contractCreate.clickOnSave();
		       Thread.sleep(6000);
		       contractCreate.clickOnProductsTab();
		       Thread.sleep(6000);
		       contractCreate.clickOnAddProductButton();
		       Thread.sleep(3000);
		       contractCreate.selectBU("CTC-CTMG");
		       Thread.sleep(3000);
		       contractCreate.selectProductType("Display");
		       Thread.sleep(3000);
		       contractCreate.clickaddProductsButton();
		       Thread.sleep(3000);
		       contractCreate.selectProduct("CTC - Chicago Tribune(Display)");
		       contractCreate.clickOnAddPricingRuleButton();
		       Thread.sleep(3000);
		       contractCreate.selectPricingType("CPI Price");
		       contractCreate.enterCommentsPricing("This is a test contract created through automation");
		       contractCreate.enterAmountPricing("20");
		      // contractCreate.enterHolidayAmountPricing("200");
		       contractCreate.selectFilterType("Day Of Week");
		       contractCreate.selectDayOfWeek("Friday"); 
		       //index for Friday is 5 , so it will select Wednesday for this product
		       contractCreate.clickOnAddFilterButton();		       
		       contractCreate.clickOnAddPricingRuleBtn();
		       Thread.sleep(5000);		       
		       dashboardPageInstance.clickOnSpecialProgramsModule();
		       Thread.sleep(5000);	
		       contractCreation.enterName("Auto Test CPI Price "+str);
		       Thread.sleep(3000);
		       contractCreation.clickOnSearch();
		       Thread.sleep(5000);	
		       contractCreation.clickOnContract("Auto Test CPI Price "+str);
		       Thread.sleep(5000);
		       dashboardPageInstance.clickOnPricingModule();
		       Thread.sleep(5000);
		       PricingAdminHome pricing = PageFactory.initElements(driver, PricingAdminHome.class);
		       pricing.clickRefreshButton();	
		       Thread.sleep(5000);
		       pricing.clickRefreshButton();	
		       Thread.sleep(5000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       Thread.sleep(5000);
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryPageInstance.clickOnNewGeneralOrder();

		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU80018679");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       Thread.sleep(4000);
		       newOrderInstance.createNewInsertion();
		       Thread.sleep(4000);
		       newOrderInstance.selectBU("1",12, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","19","Dec","2019");
		       Thread.sleep(5000);
		       newOrderInstance.selectProductType("1",12, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",12, 2);
		       Thread.sleep(4000);
		 //      newOrderInstance.selectAdType("1",12, 3);
		 //      Thread.sleep(5000);
		  //     newOrderInstance.selectSection("1",8, 4);		       
		  //     Thread.sleep(6000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		       double cpiContractPrice = newOrderInstance.getInsertionPrice("1","contract");
		       Thread.sleep(4000);
		       Logger.info("CPI COntract Price: "+cpiContractPrice);
		       Assert.assertEquals(270.00, cpiContractPrice);
		       double totalInsertionPrice = newOrderInstance.getInsertionPrice("1","total");
		       Thread.sleep(4000);
		       Logger.info("total fixed contract insertion price: "+totalInsertionPrice);
		       Assert.assertEquals(cpiContractPrice, totalInsertionPrice);
		       Thread.sleep(4000);
		       Logger.info("CPI contract pricing is as expected");
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		       Thread.sleep(4000);
		       newOrderInstance.saveOrder();
		       Thread.sleep(3000);

		       String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

		       Logger.info("Saved Order : "+orderNumber);
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				  throw e;
		   }
		   }

}*/
	@Test(groups = {"SMaintenance1","ShaliniContractCPI","specialProgram","createNewContractCPI","NovMaintenance","SpecialProgramReg","Group3","NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewContractCPI(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnSpecialProgramsModule();

			SpecialProgramLandingPage contractCreation = PageFactory.initElements(driver, SpecialProgramLandingPage.class);
			TribuneUtils utils  = new TribuneUtils();
			contractCreation.clickOnNewContractButton();
			Thread.sleep(3000);
			NewContractPage contractCreate =  PageFactory.initElements(driver, NewContractPage.class);
			String str = utils.generateRandomString(15);
			contract="Auto Test CPI Price "+str;
			contractCreate.enterContractName(contract);
			contractCreate.inputCustomer("CU80018679");
			contractCreate.enterComments("This is a test contract created through automation");

			//contractCreate.enterContractEffectiveToDate(12,28,2019);//swagata
			contractCreate.enterContractEffectiveToDateFromExcel(29, 27);//swagata
			contractCreate.enterComments.click();
			//   contractCreate.enterContractEffectiveFromDate(10,28,2019);
			contractCreate.clickOnSave();
			Thread.sleep(6000);
			contractCreate.clickOnProductsTab();
			Thread.sleep(6000);
			contractCreate.clickOnAddProductButton();
			Thread.sleep(5000);
			contractCreate.selectBU("CTC-CTMG");
			Thread.sleep(3000);
			contractCreate.selectProductType("Display");
			Thread.sleep(3000);
			contractCreate.selectProduct("Chicago Tribune");//swagata

			//contractCreate.selectProduct("CTC - Chicago Tribune(Display)");//swagata
			contractCreate.clickaddProductsButton();
			Thread.sleep(3000);
			//contractCreate.selectProduct("CTC - Chicago Tribune(Display)");
			contractCreate.clickOnAddPricingRuleButton();
			Thread.sleep(3000);
			contractCreate.selectPricingType("CPI Price");
			contractCreate.enterCommentsPricing("This is a test contract created through automation");
			contractCreate.enterAmountPricing("20");
			// contractCreate.enterHolidayAmountPricing("200");
			contractCreate.selectFilterType("Day Of Week");
			Thread.sleep(3000);
			contractCreate.selectDayOfWeek("Select all"); //index for Friday is 5 , so it will select Wednesday for this product
			contractCreate.clickOnAddFilterButton();		       
			contractCreate.clickOnAddPricingRuleBtn();
			Thread.sleep(5000);		       
			dashboardPageInstance.clickOnSpecialProgramsModule();
			Thread.sleep(5000);	
			contractCreation.enterName("Auto Test CPI Price "+str);
			Thread.sleep(3000);
			contractCreation.selectStatus("All"); //joy
			Thread.sleep(3000); //joy
			
			contractCreation.clickOnSearch();
			Thread.sleep(5000);	
			contractCreation.clickOnContract("Auto Test CPI Price "+str);
			Thread.sleep(5000);
			dashboardPageInstance.clickOnPricingModule();
			Thread.sleep(5000);
			PricingAdminHome pricing = PageFactory.initElements(driver, PricingAdminHome.class);
			pricing.clickRefreshButton();	
			Thread.sleep(5000);
			pricing.clickRefreshButton();	
			Thread.sleep(5000);
			dashboardPageInstance.clickOnOrderEntryModule();
			Thread.sleep(5000);
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();
			Thread.sleep(5000);
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.selectSoldToCustomerBU("bu_DPR");
			newOrderInstance.enterSoldToCustomer("CU80018679");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",12, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1",29,27);//swagata
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",12, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",12, 2);
			Thread.sleep(4000);
			//      newOrderInstance.selectAdType("1",12, 3);
			//      Thread.sleep(5000);
			//     newOrderInstance.selectSection("1",8, 4);		       
			//     Thread.sleep(6000);
			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.selectAdSize(1, "Full Page  (6 x 21)");//swagata
			Thread.sleep(4000);

			double cpiContractPrice = newOrderInstance.getInsertionPrice("1","contract");
			Thread.sleep(4000);
			Logger.info("CPI COntract Price: "+cpiContractPrice);
			//Assert.assertEquals(270.00, cpiContractPrice);//swagata
			Assert.assertEquals(2520.00, cpiContractPrice);//swagata

			double totalInsertionPrice = newOrderInstance.getInsertionPrice("1","total");
			Thread.sleep(4000);
			Logger.info("total fixed contract insertion price: "+totalInsertionPrice);
			Assert.assertEquals(cpiContractPrice, totalInsertionPrice);
			Thread.sleep(4000);
			Logger.info("CPI contract pricing is as expected");
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			Thread.sleep(4000);
			newOrderInstance.saveOrder();
			Thread.sleep(3000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : "+orderNumber);
			Thread.sleep(3000);

			dashboardPageInstance.clickOnLogout();//swagata

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"createNewExpiredContractFixedPrice","specialProgram","NovMaintenance","NewRegression3","PrioritizedReg3","NewRegression","SpecialProgramReg","Group3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewExpiredContractFixedPrice(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnSpecialProgramsModule();

			SpecialProgramLandingPage contractCreation = PageFactory.initElements(driver, SpecialProgramLandingPage.class);
			TribuneUtils utils  = new TribuneUtils();
			contractCreation.clickOnNewContractButton();
			Thread.sleep(3000);
			NewContractPage contractCreate =  PageFactory.initElements(driver, NewContractPage.class);
			String str = utils.generateRandomString(15);
			contractCreate.enterContractName("Auto Test Fixed Price "+str);
			//contractCreate.inputCustomer("CU00059747");
		//	contractCreate.inputCustomer("CU80040767");//swagata
			contractCreate.inputCustomer("CU80018679");//swagata

			contractCreate.enterComments("This is a test contract created through automation");

			contractCreate.enterContractEffectiveToDate(12,28,2018);
			contractCreate.enterComments.click();
			contractCreate.enterContractEffectiveFromDate(10,28,2018);
			contractCreate.clickOnSave();
			Thread.sleep(10000);
			WebElement status = driver.findElement(By.xpath("//strong[contains(text(),'Status')]/../span"));
			String contractStatus = status.getText();
			Logger.info("Contract Status : "+contractStatus);
			Assert.assertEquals("Expired",contractStatus);//swagaat
			dashboardPageInstance.clickOnLogout();//swagata

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"createNewDuplicateContract","specialProgram","PrioritizedReg3","NewRegression3","NewRegression","SpecialProgramReg","Group3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void createNewDuplicateContract(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnSpecialProgramsModule();

			SpecialProgramLandingPage contractCreation = PageFactory.initElements(driver, SpecialProgramLandingPage.class);
			TribuneUtils utils  = new TribuneUtils();

			NewContractPage contractCreate =  PageFactory.initElements(driver, NewContractPage.class);
			contractCreation.enterName(contract);
			Thread.sleep(3000);
			contractCreation.clickOnSearch();
			Thread.sleep(5000);	
			contractCreation.clickOnContract(contract);
			Thread.sleep(5000);
			contractCreate.clickOnDuplicate();
			Thread.sleep(5000);
			String str = utils.generateRandomString(15);
			contractCreate.enterContractName("AutoTest Duplicate "+str);
			contractCreate.clickOnSave();
			Thread.sleep(6000);
			dashboardPageInstance.clickOnLogout();//swagata

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"createNewContractClassCode","SpecialProgramReg","NovMaintenance","PrioritizedReg3","Group3","NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewContractClassCode(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnSpecialProgramsModule();

			SpecialProgramLandingPage contractCreation = PageFactory.initElements(driver, SpecialProgramLandingPage.class);
			TribuneUtils utils  = new TribuneUtils();
			contractCreation.clickOnNewContractButton();
			Thread.sleep(3000);
			NewContractPage contractCreate =  PageFactory.initElements(driver, NewContractPage.class);
			String str = utils.generateRandomString(15);
			contractCreate.enterContractName("Auto Test Fixed Price "+str);
			//   contractCreate.inputCustomer("CU00059747");
			contractCreate.inputCustomer("CU00250481");//swagata

			//contractCreate.inputCustomer("CU80040767");//shalni
			contractCreate.enterComments("This is a test contract created through automation");

			contractCreate.enterContractEffectiveToDateFromExcel(1, 27);//swagata
			contractCreate.enterComments.click();
			//   contractCreate.enterContractEffectiveFromDate(10,28,2019);
			contractCreate.clickOnSave();
			Thread.sleep(6000);
			contractCreate.clickOnProductsTab();
			Thread.sleep(6000);
			contractCreate.clickOnAddProductButton();
			Thread.sleep(3000);
			contractCreate.selectBU("CTC-CTMG");
			Thread.sleep(3000);
			contractCreate.selectProductType("Display");
			Thread.sleep(3000);
			contractCreate.selectProduct("Chicago Tribune");//swagata

			// contractCreate.selectProduct("CTC - Chicago Tribune(Display)");//shalini
			contractCreate.clickaddProductsButton();
			Thread.sleep(9000);
			// contractCreate.selectProduct("CTC - Chicago Tribune(Display)");//shalni
			contractCreate.clickOnAddPricingRuleButton();
			Thread.sleep(3000);
			contractCreate.selectPricingType("Fixed Price");
			contractCreate.enterCommentsPricing("This is a test contract created through automation");
			contractCreate.enterAmountPricing("100");
			// contractCreate.enterHolidayAmountPricing("200");
			contractCreate.selectFilterType("Class Code");
			String classCode = contractCreate.selectFirstClassCode();
			contractCreate.clickOnAddFilterButton();
			contractCreate.clickOnAddPricingRuleBtn();
			Thread.sleep(5000);
			contractCreate.clickOnAddPricingRuleButton();
			Thread.sleep(3000);
			contractCreate.selectPricingType("Fixed Price");
			contractCreate.enterCommentsPricing("This is a test contract created through automation");
			contractCreate.enterAmountPricing("1000");
			// contractCreate.enterHolidayAmountPricing("200");
			contractCreate.selectFilterType("Day Of Week");
			contractCreate.selectDayOfWeek("Select all");
			contractCreate.clickOnAddFilterButton();
			contractCreate.clickOnAddPricingRuleBtn();
			Thread.sleep(5000);
			dashboardPageInstance.clickOnSpecialProgramsModule();
			Thread.sleep(5000);	
			contractCreation.enterName("Auto Test Fixed Price "+str);
			Thread.sleep(3000);
			contractCreation.selectStatus("All"); //joy
			Thread.sleep(3000);
			contractCreation.clickOnSearch();
			Thread.sleep(5000);	
			contractCreation.clickOnContract("Auto Test Fixed Price "+str);
			Thread.sleep(5000);
			dashboardPageInstance.clickOnPricingModule();
			Thread.sleep(5000);
			PricingAdminHome pricing = PageFactory.initElements(driver, PricingAdminHome.class);
			pricing.clickRefreshButton();	
			Thread.sleep(5000);
			//pricing.clickRefreshButton();	//swagata
			//Thread.sleep(5000);//swagata
			dashboardPageInstance.clickOnOrderEntryModule();
			Thread.sleep(5000);
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			// newOrderInstance.selectSoldToCustomerBU("bu_OSC");//swagata
			//newOrderInstance.enterSoldToCustomer("CU80040767");//swagata

			newOrderInstance.selectSoldToCustomerBU("bu_HTF");//swagata
			newOrderInstance.enterSoldToCustomer("CU00250481");//swagata
			newOrderInstance.selectBilltoSameAsSoldTo();//swagata

			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); 
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",8, 0);
			Thread.sleep(4000);
			newOrderInstance.enterPubDateFromExcel("1", 1, 27);//swagata
			Thread.sleep(2000);
			//newOrderInstance.selectProductType("1",8, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",8, 2);
			Thread.sleep(4000);
			/*newOrderInstance.selectAdType("1",8, 3);
		       Thread.sleep(5000);
		       newOrderInstance.selectSection("1",8, 4);		       
		       Thread.sleep(6000);*/
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			
			double fixedContractPrice = newOrderInstance.getInsertionPrice("1","contract");
			Thread.sleep(4000);
			Logger.info("Fixed COntract Price: "+fixedContractPrice);
			Assert.assertEquals(1000.0, fixedContractPrice);//swagata

			double totalInsertionPrice = newOrderInstance.getInsertionPrice("1","total");
			Thread.sleep(4000);
			Logger.info("total fixed contract insertion price: "+totalInsertionPrice);
			Assert.assertEquals(1000.0, totalInsertionPrice);//swagata

			Thread.sleep(4000);
			Logger.info("Fixed contract pricing is as expected");
			
			newOrderInstance.enterClassCodeForAnInsertion(1, "10020");//swagata
			Thread.sleep(2000);//swagata
			double fixedContractPrice2 = newOrderInstance.getInsertionPrice("1","contract");//swagata
			Thread.sleep(1000);//swagata
			Logger.info("Fixed COntract Price: "+fixedContractPrice2);//swagata
			Assert.assertEquals(100.0, fixedContractPrice2);//swagata

			double totalInsertionPrice2 = newOrderInstance.getInsertionPrice("1","total");//swagata
			Logger.info("total fixed contract insertion price: "+totalInsertionPrice2);//swagata
			//Assert.assertEquals(100.0, totalInsertionPrice);//swagata
			Assert.assertEquals(100.0, totalInsertionPrice2);//swagata

			Logger.info("Fixed contract pricing is as expected");//swagata
			
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.saveOrder();
			Thread.sleep(3000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : "+orderNumber);
			dashboardPageInstance.clickOnLogout();//swagata

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"SMaintenance","createAPromotion","specialProgram","NovMaintenance","NewRegression3","NewRegression","PrioritizedReg3","SpecialProgramReg","Group3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createAPromotion(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnSpecialProgramsModule();

			SpecialProgramLandingPage contractCreation = PageFactory.initElements(driver, SpecialProgramLandingPage.class);
			TribuneUtils utils  = new TribuneUtils();
			contractCreation.clickOnNewPromotionBtn();
			Thread.sleep(3000);
			NewContractPage contractCreate =  PageFactory.initElements(driver, NewContractPage.class);
			String str = utils.generateRandomString(15);
			promotion = "Auto Test Promotion "+str;
			contractCreate.enterContractName(promotion);
			//contractCreate.inputCustomer("CU00059747");
			//  contractCreate.inputCustomer("CU80040767");
			contractCreate.enterComments("This is a test promotion created through automation");

		//	contractCreate.enterContractEffectiveToDate(12,28,2019);//swagata
			contractCreate.enterContractEffectiveToDate(12,25,2023);//swagata

			contractCreate.enterComments.click();
			///   contractCreate.enterContractEffectiveFromDate(10,28,2019);
			//   contractCreate.enterComments.click();
		//	contractCreate.enterbookingToDate(12,28,2019);//swagata
			contractCreate.enterbookingToDate(12,25,2023);//swagata

			contractCreate.enterComments.click();
			contractCreate.enterbookingFromDate(10,28,2019);
			//  contractCreate.enterComments.click();
			contractCreate.clickOnSavePromotion();
			Thread.sleep(6000);
			contractCreate.clickOnProductsTabPromotion();
			Thread.sleep(6000);
			contractCreate.clickOnAddProductButton();
			Thread.sleep(3000);
			contractCreate.selectBU("CTC-CTMG");
			Thread.sleep(3000);
			contractCreate.selectProductType("Display");
			Thread.sleep(3000);
			contractCreate.selectProduct("Chicago Tribune");//shalini
			contractCreate.clickaddProductsButton();
			Thread.sleep(5000);
			// contractCreate.selectProduct("CTC - Chicago Tribune(Display)");//shalni
			contractCreate.clickOnAddPricingRuleButton();
			Thread.sleep(3000);
			contractCreate.selectPricingType("Fixed Price");
			contractCreate.enterCommentsPricing("This is a test contract created through automation");
			contractCreate.enterAmountPricing("100");
			// contractCreate.enterHolidayAmountPricing("200");
			contractCreate.selectFilterType("Class Code");
			String classCode = contractCreate.selectFirstClassCode();
			contractCreate.clickOnAddFilterButton();
			contractCreate.clickOnAddPricingRuleBtn();
			Thread.sleep(5000);
			contractCreate.clickOnAddPricingRuleButton();
			Thread.sleep(3000);
			contractCreate.selectPricingType("Fixed Price");
			contractCreate.enterCommentsPricing("This is a test contract created through automation");
			contractCreate.enterAmountPricing("1000");
			// contractCreate.enterHolidayAmountPricing("200");
			contractCreate.selectFilterType("Day Of Week");
			contractCreate.selectDayOfWeek("Friday");
			contractCreate.clickOnAddFilterButton();
			contractCreate.clickOnAddPricingRuleBtn();
			Thread.sleep(5000);
			dashboardPageInstance.clickOnSpecialProgramsModule();
			Thread.sleep(5000);	
			contractCreation.selectType("Promotion");
			Thread.sleep(3000);
			
			contractCreation.selectStatus("All"); //joy
			Thread.sleep(3000);
			
			contractCreation.enterName("Auto Test Promotion "+str);
			Thread.sleep(3000);
			contractCreation.clickOnSearch();
			Thread.sleep(5000);	
			contractCreation.clickOnContract("Auto Test Promotion "+str);
			Thread.sleep(5000);
			dashboardPageInstance.clickOnPricingModule();
			Thread.sleep(5000);
			PricingAdminHome pricing = PageFactory.initElements(driver, PricingAdminHome.class);
			pricing.clickRefreshButton();	
			Thread.sleep(5000);
			pricing.clickRefreshButton();	
			Thread.sleep(5000);
			dashboardPageInstance.clickOnOrderEntryModule();
			Thread.sleep(5000);
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			// newOrderInstance.selectSoldToCustomerBU("bu_OSC");
			newOrderInstance.selectSoldToCustomerBU("bu_HTF");//swagata

			// newOrderInstance.enterSoldToCustomer("CU80040767");
			newOrderInstance.enterSoldToCustomer("CU00250481");//swagata

			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(4000); 
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
			Thread.sleep(4000);
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);
			newOrderInstance.selectBU("1",8, 0);
			Thread.sleep(4000);
			//newOrderInstance.enterPubDate("1","23","Dec","2020");//swagata
			Thread.sleep(5000);
			newOrderInstance.selectProductType("1",8, 1);
			Thread.sleep(4000);
			newOrderInstance.selectProduct("1",8, 2);
			Thread.sleep(4000);
			/*newOrderInstance.selectAdType("1",8, 3);
		       Thread.sleep(5000);
		       newOrderInstance.selectSection("1",8, 4);		       
		       Thread.sleep(6000);*/
			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);
			newOrderInstance.enterClassCodeForAnInsertion(1, "10020");
			Thread.sleep(4000);
			newOrderInstance.clickOnProgramPriceSelector();//swagata
			newOrderInstance.selectProgramPromotion(promotion);//swagata
			Thread.sleep(3000);//swagata
			//double fixedContractPrice = newOrderInstance.getInsertionPrice("1","contract");//swagata

			double fixedprogramPrice = newOrderInstance.getInsertionPrice("1","sales");//swagata
			Thread.sleep(4000);
			Logger.info("Fixed program Price: "+fixedprogramPrice);//swagata
			Assert.assertEquals(100.0, fixedprogramPrice);
			double totalInsertionPrice = newOrderInstance.getInsertionPrice("1","total");
			Thread.sleep(4000);
			Logger.info("total fixed program insertion price: "+totalInsertionPrice);//swagata
			Assert.assertEquals(100.0, totalInsertionPrice);
			Thread.sleep(8000);

			Logger.info("Fixed program pricing is as expected");//swagata
			//newOrderInstance.clearClassCodeForAnInsertion(classCode);//swagata
			//Thread.sleep(4000);
			//newOrderInstance.viewInsertionDetails("1");
			/*Thread.sleep(4000);
			// Thread.sleep(4000);//swagata
			newOrderInstance.selectBU("1",8, 0);//swagata
			Thread.sleep(2000);//swagata
			newOrderInstance.enterPubDate("1","25","Dec","2020");//swagata
			Thread.sleep(3000);//swagata
			newOrderInstance.selectProductType("1",8, 1);//swagata
			Thread.sleep(3000);//swagata
			newOrderInstance.selectProduct("1",8, 2);//swagata
			Thread.sleep(4000);//swagata
			newOrderInstance.viewInsertionDetails("1");//swagata
			Thread.sleep(4000);//swagata
			newOrderInstance.clickOnProgramPriceSelector();//swagata
			newOrderInstance.selectProgramPromotion(promotion);//swagata
			Thread.sleep(3000);//swagata

			double fixedprogramPrice2 = newOrderInstance.getInsertionPrice("1","sales");//swagata
			Thread.sleep(4000);
			Logger.info("Fixed program Price: "+fixedprogramPrice2);//swagata
			Assert.assertEquals(1000.0, fixedprogramPrice2);//swagata
			double totalInsertionPrice2 = newOrderInstance.getInsertionPrice("1","total");//swagata
			Thread.sleep(4000);
			Logger.info("total fixed program insertion price: "+totalInsertionPrice2);//swagata
			Assert.assertEquals(1000.0, totalInsertionPrice2);//swagata
			Thread.sleep(4000);//swagata
			Logger.info("Fixed program pricing is as expected");//swagata
			newOrderInstance.viewInsertionDetails("1");//swagata*/
			Thread.sleep(3000);
			newOrderInstance.ClickSubmitButton();
			Thread.sleep(3000);
			//String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			//Logger.info("Saved Order : "+orderNumber);
			//Thread.sleep(3000);
			//dashboardPageInstance.clickondropdownforlogout();//joy

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"createNewExpiredPromotion","specialProgram","NewRegression3","NewRegression","SpecialProgramReg","Group3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewExpiredPromotion(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnSpecialProgramsModule();

			SpecialProgramLandingPage contractCreation = PageFactory.initElements(driver, SpecialProgramLandingPage.class);
			TribuneUtils utils  = new TribuneUtils();
			contractCreation.clickOnNewPromotionBtn();
			Thread.sleep(3000);
			NewContractPage contractCreate =  PageFactory.initElements(driver, NewContractPage.class);
			String str = utils.generateRandomString(15);
			contractCreate.enterContractName("Auto Test Promotion "+str);
			contractCreate.enterComments("This is a test promotion created through automation");

			contractCreate.enterContractEffectiveToDate(12,28,2018);
			contractCreate.enterComments.click();
			Thread.sleep(3000);
			contractCreate.enterContractEffectiveFromDate(10,28,2018);
			contractCreate.enterComments.click();
			Thread.sleep(3000);
			contractCreate.enterbookingToDate(12,28,2018);
			contractCreate.enterComments.click();
			Thread.sleep(3000);
			contractCreate.enterbookingFromDate(10,28,2018);
			contractCreate.enterComments.click();
			Thread.sleep(3000);
			contractCreate.clickOnSavePromotion();
			Thread.sleep(6000);
			WebElement status = driver.findElement(By.xpath("//strong[contains(text(),'Status')]/../span"));
			String contractStatus = status.getText();
			Logger.info("Contract Status : "+contractStatus);
			Assert.assertEquals("Expired",contractStatus);//swagata
			dashboardPageInstance.clickOnLogout();//swagata

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"SMaintenance","createNewDuplicatePromotion","specialProgram","NewRegression3","NewRegression","SpecialProgramReg","Group3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewDuplicatePromotion(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnSpecialProgramsModule();

			SpecialProgramLandingPage contractCreation = PageFactory.initElements(driver, SpecialProgramLandingPage.class);
			TribuneUtils utils  = new TribuneUtils();

			NewContractPage contractCreate =  PageFactory.initElements(driver, NewContractPage.class);
			contractCreation.selectType("Promotion");
			Thread.sleep(3000);
			/*contractCreation.enterName(promotion);
			Thread.sleep(3000);*///swagata
			contractCreation.clickOnSearch();
			Thread.sleep(5000);	
			contractCreation.clickOnContract(promotion);
			Thread.sleep(5000);
			contractCreate.clickOnDuplicatePromotion();
			Thread.sleep(5000);
			String str = utils.generateRandomString(15);
			contractCreate.enterContractName("Duplicate "+str);//swagata
			Thread.sleep(5000);
			contractCreate.clickOnSavePromotion();
			Thread.sleep(6000);
			dashboardPageInstance.clickOnLogout();//swagata

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}



