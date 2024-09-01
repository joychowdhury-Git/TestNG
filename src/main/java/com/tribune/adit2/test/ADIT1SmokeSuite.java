//package com.tribune.adit2.test;
//
//import java.util.Map;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import com.tribune.adit2.Home.DashboardPage;
//import com.tribune.adit2.Home.SignInPage;
//import com.tribune.adit2.OrderEntry.ClassifiedOrderOptions;
//import com.tribune.adit2.OrderEntry.NewOrderPage;
//import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
//import com.tribune.adit2.testng.Logger;
//import com.tribune.adit2.testng.WebDriverManager;
//import com.tribune.adit2.util.Configurator;
//import com.tribune.adit2.util.TribuneUtils;
//
//
//public class ADIT1SmokeSuite 
//{
//	
//	@Test(groups = {"Order","ctcTC01","Grp4","Group1","ADIT1Smoke","ctc","TestProd1","Patch0222","SmokeSet1","SmokeFailed"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void ctcTC01(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_CTC");
//		       newOrderInstance.enterSoldToCustomer("CU00037236");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",17, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",17,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",17, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",17, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
////		       newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
////		       newOrderInstance.clickOnPositionSelector();
////		       Thread.sleep(12000);
////		      newOrderInstance.selectAdSizeForPosition();
////		      Thread.sleep(5000);
////		      
////		    //  newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
////		      newOrderInstance.selectFirstPostionFrmPositionSlctr();
////		       newOrderInstance.savePositionSelection();
////		       Thread.sleep(10000);	
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	        //   newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(3000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		      
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		       newOrderInstance.viewInsertionDetails("1");
//		  /*     newOrderInstance.createDuplicateInsertion("1");
//		       Thread.sleep(4000);	
//		       //newOrderInstance.viewInsertionDetails("2");
//		       newOrderInstance.selectMaterialSource2("Pickup w/Changes");
//		       Thread.sleep(4000);
//		       newOrderInstance.clickOnPickUpSearch();
//		       Thread.sleep(4000);
//		       newOrderInstance.enterAdMarcNo("7890");
//		       Thread.sleep(4000);
//		       newOrderInstance.assignMaterialForAnInsertion(2);
//		       Thread.sleep(4000);
//		       newOrderInstance.clickonApplyAllInsertions();
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(3000); */
//		        
//		       dashboardPageInstance.clickOnLogout();
//		       
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//
//	
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void  ctcTC02_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_CTC");
//		       newOrderInstance.enterSoldToCustomer("CU00037236");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",45, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",45,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",45, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",45, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",45, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",45, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.enterClassCodeForAnInsertion(1, "71005");
//		       Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//		       Thread.sleep(4000);
//		       		      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//
//	@Test(groups = {"Order","ctcTC03","Grp4","Group1","ADIT1Smoke","ctc","TestProd1","SmokeSet1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void ctcTC03(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_CTC");
//		       newOrderInstance.enterSoldToCustomer("CU00037236");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",80, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",80,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",80, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProductByIndex("1",5);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",80, 3);
//		       Thread.sleep(5000);
//		     //  newOrderInstance.selectSection("1",45, 4);		       
//		     //  Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdSize(1, "1/2H");
//		       Thread.sleep(4000);	
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order","ctcTC04","Grp4","Group1","ADIT1Smoke","ctc","SmokeSet1","SmokeFailed"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void ctcTC04(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_CTC");
//		       newOrderInstance.enterSoldToCustomer("CU00037236");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",43, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",43,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",43, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",43, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",43, 3);
//		       Thread.sleep(3000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");
//		   //    Thread.sleep(4000);
//		   //    newOrderInstance.selectMaterialSource("1","New Build");
//		 /*      newOrderInstance.checkUncheckBillQty(false);
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterBilledQty(5);*/
//		       Thread.sleep(3000);
//		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
//		       Thread.sleep(4000);
//		     // newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
//		      newOrderInstance.clickOnDistributions(1);
//		       Thread.sleep(95000);
//		     //  newOrderInstance.clickOnSearchZoneLink();
//		     //  Thread.sleep(10000);
//		       newOrderInstance.selectZonePreprintOrder("Full");
//		      // int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
//		       newOrderInstance.confirmZoneSelection();	
//		       Thread.sleep(5000);
//		       newOrderInstance.clickOnPAndDTab();
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_Tower"); 
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDPaperStock1("1", 1); 
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
//			   Thread.sleep(3000);
//			   newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		      
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		       /*
//		       newOrderInstance.viewInsertionDetails("1");
//		       newOrderInstance.createDuplicateInsertion("1");
//		       Thread.sleep(4000);			      
//		       newOrderInstance.enterPubDateFromExcel("1",46,27);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProductType("2",46, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProductByIndex("2",3);
//		       Thread.sleep(4000);
//		       newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
//		       newOrderInstance.clickOnPositionSelector();
//		       Thread.sleep(12000);
//		     // newOrderInstance.selectAdSizeForPosition();
//		     // Thread.sleep(5000);
//		      
//		    //  newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
//		      newOrderInstance.selectFirstPostionFrmPositionSlctr();
//		       newOrderInstance.savePositionSelection();
//		       Thread.sleep(10000);	
//		       newOrderInstance.clickonApplyAllInsertions();
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(2000);
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(3000);
//		        */
//		       dashboardPageInstance.clickOnLogout();
//		       
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order","latTC01","Grp4","Group1","ADIT1Smoke","lat","Test2","TestProd2","PatchProd"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void latTC01(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
//		       newOrderInstance.enterSoldToCustomer("CU00059747");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		      //  Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",18, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",18,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",18, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",18, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",18, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",18, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdSize(1, "1/4V  (3 x 10.5)");
//		       Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order","latTC02","Grp4","Group1","ADIT1Smoke","lat","Test2","TestProd2","TestPriority"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void latTC02(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
//		       newOrderInstance.enterSoldToCustomer("CU00059747");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		      //  Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",33, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",33,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",33, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",33, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",33, 3);
//		       Thread.sleep(3000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
//		     //  newOrderInstance.selectMaterialSource("1","N/A");
//		     //  newOrderInstance.checkUncheckBillQty(false);
//		      // Thread.sleep(3000);	
//		       /*newOrderInstance.enterBilledQty(5);
//		       Thread.sleep(3000);*/
//		       newOrderInstance.clickOnDistributions(1);
//		       Thread.sleep(75000);
//		     //  newOrderInstance.clickOnSearchZoneLink();
//		     //  Thread.sleep(10000);
//		       newOrderInstance.selectZonePreprintOrder("Full");
//		      // int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
//		       newOrderInstance.confirmZoneSelection();	
//		       Thread.sleep(5000);
//		       newOrderInstance.selectPageType("1", "PP_PaperType_Tab");
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterPageCount("8");
//		       Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order","latTC03","Grp4","Group1","ADIT1Smoke","lat","Test2","TestProd2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void latTC03(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
//		       newOrderInstance.enterSoldToCustomer("CU00059747");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		     //   Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",33, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",33,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",33, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",33, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",33, 3);
//		       Thread.sleep(3000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(3000);	
//		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);	
//		       Thread.sleep(3000);	
//		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
//		       Thread.sleep(3000);	
//		       newOrderInstance.selectPageType("1", "PP_PaperType_Oversized10x12.5");
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterPageCount("2");
//		       Thread.sleep(4000);
//		  /*     newOrderInstance.checkUncheckBillQty(false);
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterBilledQty(5);
//		       Thread.sleep(3000);	*/
//		       newOrderInstance.clickOnDistributions(1);
//	           Thread.sleep(60000);
//			   newOrderInstance.selectZonePreprintOrder("Full");
//			   Thread.sleep(4000);			       
//			   newOrderInstance.confirmZoneSelection();		
//			   Thread.sleep(4000);
//			   newOrderInstance.clickOnPAndDTab();
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_OcAdProd"); 
//			   Thread.sleep(3000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order","oscTC01","Grp4","Group1","ADIT1Smoke","osc","TestProd3","Patch0222","SmokeSet3","SmokeFailed"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void oscTC01(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       	
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_OSC");
//		       newOrderInstance.enterSoldToCustomer("CU00392709");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",85, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",85,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",85, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",85, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",85, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",85, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdSize(1, "1/16  (2 x 4)");
//		       Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void oscTC02_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_OSC");
//		       newOrderInstance.enterSoldToCustomer("CU00392709");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",47, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",47,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",47, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",47, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",47, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",47, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		     //  newOrderInstance.selectAdSize(1, "1/4V  (3 x 10.5)");
//		     //  Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void oscTC03_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_OSC");
//		       newOrderInstance.enterSoldToCustomer("CU00392709");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",48, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",48,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductTypeByIndex("1",8);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",48, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",48, 3);
//		    //   Thread.sleep(5000);
//		     //  newOrderInstance.selectSection("1",48, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		     //  newOrderInstance.selectAdSize(1, "1/4V  (3 x 10.5)");
//		     //  Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void oscTC04_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_OSC");
//		       newOrderInstance.enterSoldToCustomer("CU00392709");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",49, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",49,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",49, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProductByIndex("1", 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",49, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",49, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		     //  newOrderInstance.selectAdSize(1, "1/4V  (3 x 10.5)");
//		     //  Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void oscTC05_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_OSC");
//		       newOrderInstance.enterSoldToCustomer("CU00392709");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",50, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",50,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",50, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",50, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",50, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",50, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.enterClassCodeForAnInsertion(1, "30401");
//		       Thread.sleep(4000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		     //  newOrderInstance.selectAdSize(1, "1/4V  (3 x 10.5)");
//		     //  Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order","oscTC06","Grp4","Group1","ADIT1Smoke","osc","oscp","TestProd3","PatchProd","SmokeSet3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void oscTC06(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_OSC");
//		       newOrderInstance.enterSoldToCustomer("CU00392709");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",51, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",51,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",51, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",51, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",51, 3);
//		       Thread.sleep(3000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);		     
//		       /*      newOrderInstance.checkUncheckBillQty(false);
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterBilledQty(5);*/
//		       Thread.sleep(3000);
//		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_CustSupplied");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectPageType("1", "PP_PaperType_Broadsheet");
//		       Thread.sleep(3000);
//		     // newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
//		      newOrderInstance.clickOnDistributions(1);
//		       Thread.sleep(45000);
//		     //  newOrderInstance.clickOnSearchZoneLink();
//		     //  Thread.sleep(10000);
//		       newOrderInstance.selectZonePreprintOrder("Full");
//		      // int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
//		       newOrderInstance.confirmZoneSelection();	
//		       Thread.sleep(5000);
//		      // newOrderInstance.clickOnPAndDTab();
//			//  Thread.sleep(3000);
//			//   newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_CentralStudio"); 
//			   Thread.sleep(3000);
//			 //  newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
//			//   Thread.sleep(3000);
//			 //  newOrderInstance.selectPandDInk("1", "CMYK");
//			   Thread.sleep(3000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void oscTC07_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_OSC");
//		       newOrderInstance.enterSoldToCustomer("CU00392709");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",52, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",52,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",52, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",52, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",52, 3);
//		       Thread.sleep(3000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);		     
//		       /*      newOrderInstance.checkUncheckBillQty(false);
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterBilledQty(5);*/
//		       Thread.sleep(3000);
//		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_CustSupplied");
//		       Thread.sleep(4000);
//		     // newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
//		      newOrderInstance.clickOnDistributions(1);
//		       Thread.sleep(45000);
//		     //  newOrderInstance.clickOnSearchZoneLink();
//		     //  Thread.sleep(10000);
//		       newOrderInstance.selectZonePreprintOrder("Full");
//		      // int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
//		       newOrderInstance.confirmZoneSelection();	
//		       Thread.sleep(5000);
//		       newOrderInstance.clickOnPAndDTab();
//			   Thread.sleep(3000);
//			//   newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_CentralStudio"); 
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDInk("1", "CMYK");
//			   Thread.sleep(3000);	
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void oscTC08_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_OSC");
//		       newOrderInstance.enterSoldToCustomer("CU00392709");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",53, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",53,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",53, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",53, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",53, 3);
//		       Thread.sleep(3000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);		     
//		       /*      newOrderInstance.checkUncheckBillQty(false);
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterBilledQty(5);*/
//		       Thread.sleep(3000);
//		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_CustSupplied");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectZoneLevelPreprintOrder("1", "HD");
//		       Thread.sleep(4000);
//		     // newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
//		      newOrderInstance.clickOnDistributions(1);
//		       Thread.sleep(45000);
//		     //  newOrderInstance.clickOnSearchZoneLink();
//		     //  Thread.sleep(10000);
//		       newOrderInstance.selectZonePreprintOrder("Full");
//		      // int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
//		       newOrderInstance.confirmZoneSelection();	
//		       Thread.sleep(5000);
//		    //   newOrderInstance.clickOnPAndDTab();
//			//   Thread.sleep(3000);
//			//   newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_CentralStudio"); 
//			   Thread.sleep(3000);
//			 //  newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
//			//   Thread.sleep(3000);
//			//   newOrderInstance.selectPandDInk("1", "CMYK");
//			//   Thread.sleep(3000);	
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void oscTC09_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_OSC");
//		       newOrderInstance.enterSoldToCustomer("CU00392709");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",54, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",54,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",54, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",54, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",54, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",54, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.enterClassCodeForAnInsertion(1, "71854");
//		       Thread.sleep(4000);		       
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		     //  newOrderInstance.selectAdSize(1, "1/4V  (3 x 10.5)");
//		     //  Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void dprTC01_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_DPR");
//		       newOrderInstance.enterSoldToCustomer("CU00013249");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",55, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",55,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductTypeByValue("1","Alternative Print");
//		       Thread.sleep(4000);
//		      // newOrderInstance.selectProduct("1",55, 2);
//		      // Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",55, 3);
//		       Thread.sleep(5000);
//		     //  newOrderInstance.selectSection("1",55, 4);		       
//		    //   Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdSize(1, "Celeb (4 x 8)");
//		       Thread.sleep(4000);
//		       newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
//		       newOrderInstance.clickOnPositionSelector();
//		       Thread.sleep(12000);
//		     // newOrderInstance.selectAdSizeForPosition();
//		     // Thread.sleep(5000);
//		      
//		    //  newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
//		      newOrderInstance.selectFirstPostionFrmPositionSlctr();
//		       newOrderInstance.savePositionSelection();
//		       Thread.sleep(10000);	
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//		       
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02514");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order","dprTC02","Grp4","Group1","ADIT1Smoke","dpr","Test2","TestProd3","Patch0222","SmokeSet1","SmokeFailed"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void dprTC02(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_DPR");
//		       newOrderInstance.enterSoldToCustomer("CU00013249");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",29, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",29,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",29, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",29, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",29, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",29, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       
//		       newOrderInstance.selectAdSize(1, "1/4V  (3 x 10.5)");
//		       Thread.sleep(4000);
//		       newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
//		       newOrderInstance.clickOnPositionSelector();
//		       Thread.sleep(45000);
//		  
//		    //  newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
//		      newOrderInstance.selectFirstPostionFrmPositionSlctr();
//		      Thread.sleep(4000);
//		       newOrderInstance.savePositionSelection();
//		       Thread.sleep(10000);	 
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("2",56, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("2",56,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("2",56, 1);
//		       Thread.sleep(4000);
//		    /*   newOrderInstance.selectProduct("2",56, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("2",56, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("2",56, 4);		       
//		       Thread.sleep(6000);*/
//		       newOrderInstance.viewInsertionDetails("2");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdSizeByIndexOnline(1, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterItemDescription("CUBE",1);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterItemQuantity("100000",1);
//		       Thread.sleep(4000);
//		       newOrderInstance.viewInsertionDetails("2");
//		       Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(2, "SA02514");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(2);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void dprTC03_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_DPR");
//		       newOrderInstance.enterSoldToCustomer("CU00013249");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",57, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",57,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",57, 1);
//		       Thread.sleep(4000);
//		     /*  newOrderInstance.selectProduct("1",57, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",57, 3);
//		       Thread.sleep(3000); */
//		       newOrderInstance.viewInsertionDetails("1");
//		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
//		     //  newOrderInstance.selectMaterialSource("1","N/A");
//		     /*  newOrderInstance.checkUncheckBillQty(false);
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterBilledQty(5);
//		       Thread.sleep(3000);*/
//		       newOrderInstance.clickOnDistributions(1);
//		       Thread.sleep(45000);
//		     //  newOrderInstance.clickOnSearchZoneLink();
//		     //  Thread.sleep(10000);
//		       newOrderInstance.selectZonePreprintOrder("SubZip");
//		       Thread.sleep(5000);
//		      // int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
//		       newOrderInstance.confirmZoneSelection();	
//		       Thread.sleep(8000);
//		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_CustSupplied");
//		       Thread.sleep(3000);	
//		       newOrderInstance.selectPageType("1", "PP_PaperType_Tabloid");
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterPageCount("2");
//		       Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02514");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void dprTC04_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_DPR");
//		       newOrderInstance.enterSoldToCustomer("CU00013249");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",58, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",58,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",58, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",58, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",58, 3);
//		       Thread.sleep(3000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
//		     //  newOrderInstance.selectMaterialSource("1","N/A");
//		     /*  newOrderInstance.checkUncheckBillQty(false);
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterBilledQty(5);
//		       Thread.sleep(3000);	*/
//		       newOrderInstance.clickOnDistributions(1);
//		       Thread.sleep(45000);
//		     //  newOrderInstance.clickOnSearchZoneLink();
//		     //  Thread.sleep(10000);
//		       newOrderInstance.selectZonePreprintOrder("SubZip");
//		      // int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
//		       newOrderInstance.confirmZoneSelection();	
//		       Thread.sleep(5000);
//		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
//		       Thread.sleep(3000);	
//		       newOrderInstance.selectPageType("1", "PP_PaperType_EZNote");
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterPageCount("1");
//		     /*  Thread.sleep(4000);
//		       newOrderInstance.clickOnProgramPriceSelector();
//		       Thread.sleep(3000);	
//		       newOrderInstance.selectFirstSpecialProgramPromotion();
//		       Thread.sleep(3000);	*/
//		       newOrderInstance.clickOnPAndDTab();
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_CentralStudio"); 
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yes"); 
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDInk("1", "4C");
//			   Thread.sleep(3000);	
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02514");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(10000);
//		   //    newOrderInstance.clickOnContinuePastDeadlineDate();
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void dprTC05_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");			   			   
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       
//		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
//		       Thread.sleep(3000);
//		       
//		       newOrderInstance.selectSoldToCustomerBU("bu_DPR");
//		       newOrderInstance.enterSoldToCustomer("CU00013249");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       newOrderInstance.createNewClassifiedInsertion();
//		       Thread.sleep(4000);		      
//		       
//		       Thread.sleep(4000);
//		       classifiedOrderInstance.selectPackageBU("5",10, 0);
//		       Thread.sleep(2000);
//		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwnByIndex(10);
//		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
//		       Thread.sleep(2000);
//		       //driver.quit();
//		       classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(1);
//		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
//		       Thread.sleep(2000);
//		       classifiedOrderInstance.selectClassifiedPackageByIndex(1);
//		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
//		       Thread.sleep(2000);
//		       classifiedOrderInstance.selectClassifiedClassCodeByIndex(6);
//		       Thread.sleep(2000);
//		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
//		       classifiedOrderInstance.selectDate("nextmonth");
//		       classifiedOrderInstance.selectSingleZone();		       
//		       classifiedOrderInstance.clickApplyBtn();
//
//		       Thread.sleep(25000);		       
//		       //***********************
//		       classifiedOrderInstance.clickEditAdBtn();
//
//		       //Thread.sleep(15000);
//		       //classifiedOrderInstance.uploadAd();
//
//		       Thread.sleep(10000);
//		       classifiedOrderInstance.uploadAd("5",1,6);
//		       Thread.sleep(10000);
//		       Thread.sleep(3000);
//		       classifiedOrderInstance.verifyVolumeDiscount();
//		       Thread.sleep(5000);
//		    //   classifiedOrderInstance.verifyInsertionPrice("Non-Legal");
//		       classifiedOrderInstance.enterAttributeDetailsDPR();	
//		       Thread.sleep(4000);
//		       newOrderInstance.saveOrder();
//		       
//		       Thread.sleep(6000);
//		      
//		       String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
//		      
//		       Logger.info("Saved Order : "+orderNumber);
//		       Thread.sleep(3000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(11, "SA02514");
//			   Thread.sleep(4000);
//			   newOrderInstance.saveOrder();
//		       
//		       Thread.sleep(6000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(11);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       //Thread.sleep(2000);
//		       //newOrderInstance.confirmToMakeOrderFree();
//		       Thread.sleep(3000);
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(2000);
//		       ////dashboardPageInstance.clickOnLogout();
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void dprTC06_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			 WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");			   			   
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       
//		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
//		       Thread.sleep(3000);
//		       
//		       newOrderInstance.selectSoldToCustomerBU("bu_DPR");
//		       newOrderInstance.enterSoldToCustomer("CU00013249");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       newOrderInstance.createNewClassifiedInsertion();
//		       Thread.sleep(4000);		      
//		       
//		       Thread.sleep(4000);
//		       classifiedOrderInstance.selectPackageBU("5",10, 0);
//		       Thread.sleep(2000);
//		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwnByIndex(10);
//		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
//		       Thread.sleep(2000);
//		       //driver.quit();
//		       classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(1);
//		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
//		       Thread.sleep(2000);
//		       classifiedOrderInstance.selectClassifiedPackageByIndex(1);
//		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
//		       Thread.sleep(2000);
//		       classifiedOrderInstance.selectClassifiedClassCodeByIndex(6);
//		       Thread.sleep(2000);
//		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
//		       classifiedOrderInstance.selectDate("nextmonth");
//		       classifiedOrderInstance.selectSingleZone();		       
//		       classifiedOrderInstance.clickApplyBtn();
//
//		       Thread.sleep(25000);		       
//		       //***********************
//		       classifiedOrderInstance.clickEditAdBtn();
//
//		       //Thread.sleep(15000);
//		       //classifiedOrderInstance.uploadAd();
//
//		       Thread.sleep(10000);
//		       classifiedOrderInstance.uploadAd("5",1,6);
//		       Thread.sleep(10000);
//		       Thread.sleep(3000);
//		       classifiedOrderInstance.verifyVolumeDiscount();
//		       Thread.sleep(5000);
//		    //   classifiedOrderInstance.verifyInsertionPrice("Non-Legal");
//		       classifiedOrderInstance.enterAttributeDetailsDPR();	
//		       Thread.sleep(4000);
//		       newOrderInstance.saveOrder();
//		       
//		       Thread.sleep(6000);
//		      
//		       String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
//		      
//		       Logger.info("Saved Order : "+orderNumber);
//		       Thread.sleep(3000);
//		       newOrderInstance.viewInsertionDetails("1");		      
//			     //  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			     //  newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			       Thread.sleep(2000);
//			     //  newOrderInstance.selectProgramPriceForAnInsertion(1,"CHIDMA_Main $11740.2");
//			       newOrderInstance.clickOnProgramPriceSelectorPreprint();
//			       Thread.sleep(4000);
//			       newOrderInstance.selectProgramPromotion("DPMG Employee Discounts - Non-Commercial Ads");
//			       Thread.sleep(4000);
//			       newOrderInstance.saveOrder();
//			       
//			       Thread.sleep(6000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(11, "SA02514");
//			   Thread.sleep(4000);
//			   newOrderInstance.saveOrder();
//		       
//		       Thread.sleep(6000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(11);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       //Thread.sleep(2000);
//		       //newOrderInstance.confirmToMakeOrderFree();
//		       Thread.sleep(3000);
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(2000);
//		       ////dashboardPageInstance.clickOnLogout();
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order","sdtTC01","Grp4","Group1","ADIT1Smoke","sdt","TestProd1","TestPriority"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void sdtTC01(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_SDT");
//		       newOrderInstance.enterSoldToCustomer("CU00475251");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",59, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",59,27);
//		       
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",59, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",59, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",59, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",59, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(7000);
//		       newOrderInstance.selectAdSize(1, "6 x 10.75");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectColourForAnInsertion(1,"B/W");
//		       Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA03612");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       newOrderInstance.clickNoLegacyAutoInsertionCreation();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order","sdtTC02","Grp4","Group1","ADIT1Smoke","sdt","TestProd1","PatchProd"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void sdtTC02(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_SDT");
//		       newOrderInstance.enterSoldToCustomer("CU00475251");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",60, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",60,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",60, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",60, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",60, 3);
//		       Thread.sleep(3000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);		     
//		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
//		       newOrderInstance.selectPageType("1", "PP_PaperType_SingleSheet10x11");
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterPageCount("2");
//		       Thread.sleep(4000);
//		     /*  newOrderInstance.checkUncheckBillQty(false);
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterBilledQty(5);
//		       Thread.sleep(3000);	*/
//		       newOrderInstance.clickOnDistributions(1);
//		       Thread.sleep(45000);
//		     //  newOrderInstance.clickOnSearchZoneLink();
//		     //  Thread.sleep(10000);
//		       newOrderInstance.selectZonePreprintOrder("Full");
//		      // int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
//		       newOrderInstance.confirmZoneSelection();	
//		       Thread.sleep(5000);
//			   newOrderInstance.clickOnPAndDTab();
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_OcAdProd"); 
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDPrinter("1", "PP_Printer_Other");
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA03612");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void htfTC01_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_HTF");
//		       newOrderInstance.enterSoldToCustomer("CU00250481");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",61, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",61,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",61, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",61, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",61, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",61, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectPositionNonTemp("1", "Casinos");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdSize(1, "1/9  (2 x 3.5)");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectColourForAnInsertion(1, "4C");
//		       Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02433");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//
//	@Test(groups = {"Order","htfTC02","Grp4","Group1","ADIT1Smoke","htf","TestProd2","SmokeSet1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void htfTC02(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_HTF");
//		       newOrderInstance.enterSoldToCustomer("CU00250481");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",62, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",62,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",62, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",62, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",62, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",62, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdSize(1, "Front Page Strip 1/14 (6 x 1.5)");
//		       Thread.sleep(4000);
//		       newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
//		       newOrderInstance.clickOnPositionSelector();
//		       Thread.sleep(42000);		    
//		       newOrderInstance.selectFirstPostionFrmPositionSlctr();
//		       newOrderInstance.savePositionSelection();
//		       Thread.sleep(10000);
//		       newOrderInstance.selectColourForAnInsertion(1, "4C");
//		       Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02433");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	@Test(groups = {"Order","htfTC03","Grp4","Group1","ADIT1Smoke","htf","TestProd2","Patch0222","SmokeSet1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void htfTC03(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_HTF");
//		       newOrderInstance.enterSoldToCustomer("CU00250481");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",63, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",63,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",63, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",63, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",63, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",63, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdSize(1, "1/2V  (3 x 10.5)");
//		       Thread.sleep(4000);
//		       newOrderInstance.enterClassCodeForAnInsertion(1, "51048");
//		       Thread.sleep(4000);  
//		       newOrderInstance.selectColourForAnInsertion(1, "4C");
//		       Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02433");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void htfTC04_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_HTF");
//		       newOrderInstance.enterSoldToCustomer("CU00250481");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",64, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",64,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",64, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",64, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",64, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",64, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdSize(1, "1/4V  (3 x 10.5)");
//		       Thread.sleep(4000);
//		       newOrderInstance.enterClassCodeForAnInsertionByText(1, "ROP", "RE tab, Front of book");
//		       Thread.sleep(8000);  
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02433");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//
//	//@Test(groups = {"Order","htfTC05","Grp4","Group1","ADIT1Smoke","htf","TestProd2","SmokeSet1","SmokeFailed"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//
//	public void htfTC05_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_HTF");
//		       newOrderInstance.enterSoldToCustomer("CU00250481");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",65, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",65,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",65, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",65, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",65, 3);
//		       Thread.sleep(3000);
//		       newOrderInstance.selectSection("1",65, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_Wrap");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectZoneLevelPreprintOrder("1", "Wrap");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectPositionPreprintOrder("1", "Front Cover");
//		       Thread.sleep(4000);
//		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);		
//		       Thread.sleep(4000); 		       
//		       newOrderInstance.selectPageType("1", "PP_PaperType_FrontCover9.75x10.2");
//		       Thread.sleep(4000);
//		     /*  newOrderInstance.checkUncheckBillQty(false);
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterBilledQuantity(1202452);
//		       Thread.sleep(3000);*/
//		       newOrderInstance.clickOnDistributions(1);
//		       Thread.sleep(45000);
//		     //  newOrderInstance.clickOnSearchZoneLink();
//		     //  Thread.sleep(10000);
//		       newOrderInstance.selectZonePreprintOrder("Full");
//		      // int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
//		       newOrderInstance.confirmZoneSelection();	
//		       Thread.sleep(5000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02433");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		      // newOrderInstance.clickOnContinuePastPubDate();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order","htfTC06","Grp4","Group1","ADIT1Smoke","htf","TestProd2","SmokeSet1","SmokeFailed"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void htfTC06(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_HTF");
//		       newOrderInstance.enterSoldToCustomer("CU00250481");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",66, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",66,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",66, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",66, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",66, 3);
//		       Thread.sleep(3000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);		     
//		  /*     newOrderInstance.checkUncheckBillQty(false);
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterBilledQuantity(59423);
//		       Thread.sleep(3000);*/
//		      /* newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
//		       newOrderInstance.clickOnPositionSelector();
//		       Thread.sleep(32000);
//		     
//		      newOrderInstance.selectFirstPostionFrmPositionSlctr();
//		      Thread.sleep(4000);
//		       newOrderInstance.savePositionSelection();
//		       Thread.sleep(10000);	 */ 
//		       newOrderInstance.clickOnDistributions(1);
//		       Thread.sleep(45000);
//		     //  newOrderInstance.clickOnSearchZoneLink();
//		     //  Thread.sleep(10000);
//		       newOrderInstance.selectZonePreprintOrder("Full");
//		      // int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
//		       newOrderInstance.confirmZoneSelection();	
//		       Thread.sleep(5000);
//		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
//		       newOrderInstance.selectPageType("1", "PP_PaperType_8.5x11BusinessBuilder");
//		       Thread.sleep(3000);	
//		       newOrderInstance.clickOnPAndDTab();
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDPaperStock("1", "PP_PaperStock_Coated"); 
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDFold("1", "PP_Fold_HalfFold");
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDPerforation("1", "PP_Perforation_Yes");
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDPrinter("1", "PP_Printer_Express");
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDInk("1", "CMYK");
//			   Thread.sleep(3000);
//			  // newOrderInstance.selectPandDCreativeLoc("1", "");
//			 //  Thread.sleep(3000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02433");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//
//	@Test(groups = {"Order","altTC01","Grp4","Group1","ADIT1Smoke","alt","Test2","TestProd3","PatchProd","SmokeSet2","SmokeNew"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void altTC01(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_ALT");
//		       newOrderInstance.enterSoldToCustomer("CU00258088");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		        newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");		       
//		       Thread.sleep(4000);
//		       
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",27, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",27,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",27, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",27, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",27, 3);
//		       Thread.sleep(5000);
//		      // newOrderInstance.selectSection("1",27, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdSize(1, "1/3V (2 x 18)");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectMaterialSource("1","New Build");	
//		       Thread.sleep(4000);	
//		     //  newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
//		    //   newOrderInstance.clickOnPositionSelector();
//		    //   Thread.sleep(32000);
//		     
//		    //  newOrderInstance.selectFirstPostionFrmPositionSlctr();
//		    //  Thread.sleep(4000);
//		    //   newOrderInstance.savePositionSelection();
//		   //    Thread.sleep(10000);	  
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       newOrderInstance.clickNoLegacyAutoInsertionCreation();
//		     //  newOrderInstance.clickNoLegacyAutoInsertionCreation();
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order","altTC03","Grp4","Group1","ADIT1Smoke","alt","Test2","TestProd3","TestPriority","SmokeSet2","altf","SmokeFailed"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void altTC03_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_ALT");
//		       newOrderInstance.enterSoldToCustomer("CU00258088");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",67, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",67,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",67, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",67, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",67, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSectionByIndex("1",5);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(6000);
//		       newOrderInstance.selectAdSize(1, "1/108 Block (1 x 1)");
//		       Thread.sleep(4000);
//		       newOrderInstance.enterClassCodeForAnInsertion(1, "40010");
//		       Thread.sleep(4000); 	  
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	         //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		  //   newOrderInstance.clickNoLegacyAutoInsertionCreation();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void altTC02(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_ALT");
//		       newOrderInstance.enterSoldToCustomer("CU00258088");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",68, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",68,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",68, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",68, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",68, 3);
//		       Thread.sleep(3000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(3000);
//		       newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");		     
//		  /*     newOrderInstance.checkUncheckBillQty(false);
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterBilledQuantity(12024);
//		       Thread.sleep(3000);*/
//		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
//		       Thread.sleep(4000);
//		       newOrderInstance.clickOnDistributions(1);
//		       Thread.sleep(45000);
//		     //  newOrderInstance.clickOnSearchZoneLink();
//		     //  Thread.sleep(10000);
//		       newOrderInstance.selectZonePreprintOrder("SubZip");
//		      // int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
//		       newOrderInstance.confirmZoneSelection();	
//		       Thread.sleep(5000);
//		       newOrderInstance.selectPageType("1", "PP_PaperType_StandardFullRun");
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterPageCount("2");
//		       Thread.sleep(4000);	  
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order","tbsTC01","Grp4","Group1","ADIT1Smoke","Test2","TestProd2","Patch0222","SmokeSet3","tbs"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void tbsTC01(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_TBS");
//		       newOrderInstance.enterSoldToCustomer("CU00169935");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		      //  Thread.sleep(4000); 
//		      //  Thread.sleep(6000);
//		      // newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",69, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",69,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",69, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",69, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",69, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",69, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdSizeByValue(1, "number:2695");
//		       Thread.sleep(4000);
////		       newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
////		       newOrderInstance.clickOnPositionSelector();
////		       Thread.sleep(12000);
////		   //   newOrderInstance.selectAdSizeForPosition();
////		      Thread.sleep(5000);
////		      newOrderInstance.clickOnSearchPositionInPSWindw();
////		      Thread.sleep(42000);
////		    //  newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
////		      newOrderInstance.selectFirstPostionFrmPositionSlctr();
////		       newOrderInstance.savePositionSelection();
////		       Thread.sleep(10000);	
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA03390");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void tbsTC02_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_TBS");
//		       newOrderInstance.enterSoldToCustomer("CU00169935");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		     //   Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",70, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",70,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",70, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",70, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",70, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",70, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdSizeByValue(1, "number:2768");
//		       Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA03390");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void tbsTC03_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_TBS");
//		       newOrderInstance.enterSoldToCustomer("CU00169935");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		     //   Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",71, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",71,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",71, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",71, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",71, 3);
//		       Thread.sleep(3000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);		     
//		  /*     newOrderInstance.checkUncheckBillQty(false);
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterBilledQuantity(12024);
//		       Thread.sleep(3000);*/
//		       newOrderInstance.clickOnDistributions(1);
//		       Thread.sleep(45000);
//		     //  newOrderInstance.clickOnSearchZoneLink();
//		     //  Thread.sleep(10000);
//		       newOrderInstance.selectZonePreprintOrder("SubZip");
//		      // int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
//		       newOrderInstance.confirmZoneSelection();	
//		       Thread.sleep(5000);
//		       newOrderInstance.selectPageType("1", "PP_PaperType_Tab");
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterPageCount("8");
//		       Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA03390");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order","tbsTC04","Grp4","Group1","ADIT1Smoke","tbs","Test2","TestProd2","TestPriority","SmokeSet3","SmokeFailed"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void tbsTC04(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_TBS");
//		       newOrderInstance.enterSoldToCustomer("CU00169935");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		      //  Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",72, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",72,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",72, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",72, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",72, 3);
//		       Thread.sleep(3000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);     
//		       Thread.sleep(3000);
//		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
//		       Thread.sleep(4000);
//		     // newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
//		      newOrderInstance.clickOnDistributions(1);
//		       Thread.sleep(45000);
//		     //  newOrderInstance.clickOnSearchZoneLink();
//		     //  Thread.sleep(10000);
//		       newOrderInstance.selectZonePreprintOrder("Full");
//		      // int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
//		       newOrderInstance.confirmZoneSelection();	
//		       Thread.sleep(5000);
//		       newOrderInstance.clickOnPAndDTab();
//			   Thread.sleep(3000);
////			   newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_Tower"); 
////			   Thread.sleep(3000);
////			   newOrderInstance.selectPandDPaperStock1("1", 1); 
////			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
//			   Thread.sleep(3000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA03390");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(3000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order","sscTC01","Grp4","Group1","ADIT1Smoke","ssc","TestProd1","TestPriority","Patch0222","SmokeSet2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void sscTC01(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_SSC");
//		       newOrderInstance.enterSoldToCustomer("CU00117844");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",73, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",73,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",73, 1);
//		       Thread.sleep(4000);
//		     //  newOrderInstance.selectProduct("1",73, 2);
//		     //  Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",73, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",73, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdSize(1, "Full Page (6 x 10.5)");
//		       Thread.sleep(4000);
//			   newOrderInstance.selectMaterialSource("1","New Build");	
//		       Thread.sleep(4000);	
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01774");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(3000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void sscTC02_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_SSC");
//		       newOrderInstance.enterSoldToCustomer("CU00117844");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",74, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",74,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",74, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProductByIndex("1",15);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",74, 3);
//		       Thread.sleep(5000);
//		     //  newOrderInstance.selectSection("1",74, 4);		       
//		     //  Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdSize(1, "Full Page (6 x 10.5)");
//		       Thread.sleep(4000);	        
//		       newOrderInstance.selectColourForAnInsertion(1, "4C");
//		       Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01774");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//
//	@Test(groups = {"Order","sscTC03","Grp4","Group1","ADIT1Smoke","ssc","TestProd1","SmokeSet2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void sscTC03(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_SSC");
//		       newOrderInstance.enterSoldToCustomer("CU00117844");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",75, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",75,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",75, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",75, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",75, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",75, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);		     
//		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
//		       newOrderInstance.selectPageType("1", "PP_PaperType_5.5x8.5SglSheet");
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterPageCount("2");
//		       Thread.sleep(4000);
//		    /*   newOrderInstance.checkUncheckBillQty(false);
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterBilledQty(5);
//		       Thread.sleep(3000);*/
//		       newOrderInstance.selectMaterialSource("1", "New Build");
//		       Thread.sleep(3000);
//		       newOrderInstance.clickOnDistributions(1);
//	           Thread.sleep(40000);
//			   newOrderInstance.selectAllZonePreprintOrder();
//			   Thread.sleep(4000);			       
//			   newOrderInstance.confirmZoneSelection();		
//			   Thread.sleep(4000);
//			   newOrderInstance.clickOnPAndDTab();
//			   Thread.sleep(3000);
//			//   newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_Adwatch"); 
//			//   Thread.sleep(3000);
//			//   newOrderInstance.selectPandDPaperStock("1", "PP_PaperStock_60Coated"); 
//			//   Thread.sleep(3000);
//			   newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
//			   Thread.sleep(3000);
//			//   newOrderInstance.selectPandDFold("1", "PP_Fold_HalfFoldd");
//			//   Thread.sleep(3000);
//			//   newOrderInstance.selectPandDPerforation("1", "PP_Perforation_Yes");
//			//   Thread.sleep(3000);
//			   newOrderInstance.selectPandDPrinter("1", "PP_Printer_NPC");
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDInk("1", "4 Color Process");
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDOrientation("1", "Horizontal");	
//			   Thread.sleep(3000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01774");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void sscTC04_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_SSC");
//		       newOrderInstance.enterSoldToCustomer("CU00117844");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",76, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",76,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",76, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",76, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",76, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",76, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);	
//		       newOrderInstance.selectPageType("1", "PP_PaperType_Tab");
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterPageCount("12");
//		       Thread.sleep(4000);
//		       //insert code to match zip
//		       newOrderInstance.clickOnDistributions(1);
//	           Thread.sleep(40000);
//	           newOrderInstance.clickOnMatchZip();
//	           Thread.sleep(5000);
//	           newOrderInstance.enterAndIncludeZip("33317");
//	           Thread.sleep(5000);
//	           newOrderInstance.enterAndIncludeZip("33328");
//	           Thread.sleep(5000);
//	           newOrderInstance.enterAndIncludeZip("33067");
//	           Thread.sleep(5000);
//	           newOrderInstance.enterAndIncludeZip("33024");
//	           Thread.sleep(5000);
//	           newOrderInstance.confirmZoneSelection();		
//			   Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01774");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void sscTC05_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_SSC");
//		       newOrderInstance.enterSoldToCustomer("CU00117844");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",77, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",77,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",77, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",77, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",77, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",77, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);	
//		       newOrderInstance.selectPageType("1", "PP_PaperType_Singlesheet");
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterPageCount("2");
//		       Thread.sleep(4000);
//		       newOrderInstance.clickOnDistributions(1);
//	           Thread.sleep(40000);
//			   newOrderInstance.selectAllZonePreprintOrder();
//			   Thread.sleep(4000);			       
//			   newOrderInstance.confirmZoneSelection();		
//			   Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01774");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void sscTC06_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_SSC");
//		       newOrderInstance.enterSoldToCustomer("CU00117844");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",78, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",78,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductTypeByValue("1","Alternative Print");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",78, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",78, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",78, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdSize(1, "Full Page (6 x 10.5)");
//		       Thread.sleep(4000);	
//		       newOrderInstance.selectPositionNonTemp("1", "Page 2");
//		       Thread.sleep(3000);
//		       newOrderInstance.selectMaterialSource("1", "New Build");
//		       Thread.sleep(3000);
//		       newOrderInstance.selectColourForAnInsertion(1,"4C");
//		       Thread.sleep(4000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01774");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void sscTC07_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_SSC");
//		       newOrderInstance.enterSoldToCustomer("CU00117844");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		       Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
//		       Thread.sleep(3000);
//		       newOrderInstance.createNewClassifiedInsertion();
//		       Thread.sleep(4000);		      
//		       
//		       Thread.sleep(4000);
//		       classifiedOrderInstance.selectPackageBU("5",11, 0);
//		       Thread.sleep(2000);
//		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwnByIndex(1);
//		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
//		       Thread.sleep(2000);
//		       //driver.quit();
//		       classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(1);
//		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
//		       Thread.sleep(2000);
//		       classifiedOrderInstance.selectClassifiedPackageByIndex(1);
//		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
//		       Thread.sleep(2000);
//		       classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
//		       Thread.sleep(2000);
//		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
//		       classifiedOrderInstance.selectDate("nextmonth");
//		       classifiedOrderInstance.selectSingleZone();		       
//		       classifiedOrderInstance.clickApplyBtn();
//
//		       Thread.sleep(25000);		       
//		       //***********************
//		       classifiedOrderInstance.clickEditAdBtn();
//
//		       //Thread.sleep(15000);
//		       //classifiedOrderInstance.uploadAd();
//
//		       Thread.sleep(10000);
//		       classifiedOrderInstance.uploadAd("5",1,6);
//		       Thread.sleep(10000);
//		       Thread.sleep(3000);
//		    //   classifiedOrderInstance.verifyInsertionPrice("Non-Legal");
//		       classifiedOrderInstance.enterAttributeDetailsSSC();	
//		       Thread.sleep(4000);
//		       newOrderInstance.saveOrder();
//		       
//		       Thread.sleep(6000);
//		      
//		       String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
//		      
//		       Logger.info("Saved Order : "+orderNumber);
//		       Thread.sleep(3000);
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(6, "SA01774");
//			   Thread.sleep(4000);
//			   newOrderInstance.saveOrder();
//		       
//		       Thread.sleep(6000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(6);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void sscTC08_NA(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_SSC");
//		       newOrderInstance.enterSoldToCustomer("CU00117844");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		       Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",79, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",79,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",79, 1);
//		       Thread.sleep(4000);
//		     //  newOrderInstance.selectProduct("1",79, 2);
//		     //  Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",79, 3);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectSection("1",79, 4);		       
//		       Thread.sleep(6000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdSize(1, "Strip Ad 1/7 (6 x 3)");
//		       Thread.sleep(4000);	  
//		       newOrderInstance.selectMaterialSource("1", "New Build");
//		       Thread.sleep(3000);
//		       newOrderInstance.selectColourForAnInsertion(1,"4C");
//		       Thread.sleep(4000);	
//
//		       newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
//		       newOrderInstance.clickOnPositionSelector();
//		       Thread.sleep(22000);
//		      newOrderInstance.selectFirstPostionFrmPositionSlctr();
//		       newOrderInstance.savePositionSelection();
//		       Thread.sleep(10000);	
//		       newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01774");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       newOrderInstance.clickNoLegacyAutoInsertionCreation();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		       
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		        
//		       dashboardPageInstance.clickOnLogout();
//		      
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//
//
//	@Test(groups = {"Order","ctcTC05","Grp4","Group1","ADIT1Smoke","ctc","SmokeSet1","SmokeFailed","SmokeNew"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
//	public void ctcTC05(Map<String, String> userData) throws Exception
//	{
//		try
//		   {
//			   WebDriver driver = WebDriverManager.getDriver();
//			   Logger.info("Webdriver is initiated");
//			   
//			   TribuneUtils utilities = new TribuneUtils();
//		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
//		       utilities.implementWait(driver);
//		       
//		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
//		       signinPageinstance.login("success");
//		       
//		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
//		       dashboardPageInstance.clickOnOrderEntryModule();
//		       
//		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
//		       orderEntryPageInstance.clickOnNewGeneralOrder();
//		       
//		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
//		       newOrderInstance.selectSoldToCustomerBU("bu_CTC");
//		       newOrderInstance.enterSoldToCustomer("CU00037236");
//		       newOrderInstance.selectBilltoSameAsSoldTo();
//		       newOrderInstance.selectOrderType("OrderType_Standard");
//		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
//		        Thread.sleep(4000); newOrderInstance.checkUncheckOwnLocalOptOut(true);
//		       Thread.sleep(4000);
//		       newOrderInstance.createNewInsertion();
//		       Thread.sleep(4000);
//		       newOrderInstance.selectBU("1",86, 0);
//		       Thread.sleep(4000);
//		       newOrderInstance.enterPubDateFromExcel("1",86,27);
//		       Thread.sleep(5000);
//		       newOrderInstance.selectProductType("1",86, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProduct("1",86, 2);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectAdType("1",86, 3);
//		       Thread.sleep(3000);
//		       newOrderInstance.viewInsertionDetails("1");
//		       Thread.sleep(4000);
//		       newOrderInstance.addOrEditInserstionVerisonIDString("1", "test");
//		   //    Thread.sleep(4000);
//		   //    newOrderInstance.selectMaterialSource("1","New Build");
//		 /*      newOrderInstance.checkUncheckBillQty(false);
//		       Thread.sleep(3000);	
//		       newOrderInstance.enterBilledQty(5);*/
//		       Thread.sleep(3000);
//		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
//		       Thread.sleep(4000);
//		     // newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
//		      newOrderInstance.clickOnDistributions(1);
//		       Thread.sleep(95000);
//		     //  newOrderInstance.clickOnSearchZoneLink();
//		     //  Thread.sleep(10000);
//		       newOrderInstance.selectZonePreprintOrder("Full");
//		      // int countOfZoneAssigned = newOrderInstance.getAssignedZonesCount();
//		       newOrderInstance.confirmZoneSelection();	
//		       Thread.sleep(5000);
//		       newOrderInstance.clickOnPAndDTab();
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_Tower"); 
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDPaperStock1("1", 1); 
//			   Thread.sleep(3000);
//			   newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yess"); 
//			   Thread.sleep(3000);
//			   newOrderInstance.clickOnInsertionSalesRepSection(1);
//	           //newOrderInstance.removeSalesRepOnInsertion(1);
//			   Thread.sleep(4000);				      
//	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
//			   Thread.sleep(4000);
//			  newOrderInstance.clickOnInsertionSalesRepSection(1);
//			   Thread.sleep(4000);
//			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
//			   Thread.sleep(2000);
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(1000);
//		       String orderID = orderEntryPageInstance.getOrderNumber();
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(1000);
//		      
//		       orderEntryPageInstance.clickOnOrder(orderID);
//		       Thread.sleep(3000);
//		       /*
//		       newOrderInstance.viewInsertionDetails("1");
//		       newOrderInstance.createDuplicateInsertion("1");
//		       Thread.sleep(4000);			      
//		       newOrderInstance.enterPubDateFromExcel("1",46,27);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProductType("2",46, 1);
//		       Thread.sleep(4000);
//		       newOrderInstance.selectProductByIndex("2",3);
//		       Thread.sleep(4000);
//		       newOrderInstance.checkUncheckPosTemplateChckbx(1,true);
//		       newOrderInstance.clickOnPositionSelector();
//		       Thread.sleep(12000);
//		     // newOrderInstance.selectAdSizeForPosition();
//		     // Thread.sleep(5000);
//		      
//		    //  newOrderInstance.selectPostionFrmPositionSlctr("25", "3, 12.15");
//		      newOrderInstance.selectFirstPostionFrmPositionSlctr();
//		       newOrderInstance.savePositionSelection();
//		       Thread.sleep(10000);	
//		       newOrderInstance.clickonApplyAllInsertions();
//		       Thread.sleep(4000);
//		       newOrderInstance.submitOrder();
//		       Thread.sleep(2000);
//		       Logger.info(orderEntryPageInstance.getOrderID());
//		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
//		       Thread.sleep(3000);
//		        */
//		       dashboardPageInstance.clickOnLogout();
//		       
//		   }
//		catch (Exception e)
//		{
//			Logger.error(e.getMessage());
//			throw e;
//		}
//	}
//	
//	
//}
