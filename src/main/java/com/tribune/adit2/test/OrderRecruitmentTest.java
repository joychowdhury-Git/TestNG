package com.tribune.adit2.test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.ClassifiedOrderOptions;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;


public class OrderRecruitmentTest 
{
	@Test(groups = {"Order", "recruitmentOrderWithMMTag"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void recruitmentOrderWithMMTag(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(false);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",38, 0);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2017");
		       Thread.sleep(3000);
		       newOrderInstance.selectProductType("1",38, 1);
		       newOrderInstance.selectProduct("1",38, 2);
		       newOrderInstance.selectAdType("1",38, 3);
		       Thread.sleep(5000);
		      // newOrderInstance.selectSection("1",38, 4);
		      // Thread.sleep(6000);
		       newOrderInstance.selectMMTag("1", "One Day Sale");
		       Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		      newOrderInstance.submitOrder();
		       Thread.sleep(5000);		       
		       String orderID = orderEntryPageInstance.getOrderID();
		       Logger.info("Order ID: "+orderID);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
		       WebDriverWait wait = new WebDriverWait(driver,20);
		       wait.until(ExpectedConditions.visibilityOfAllElements(list));
		       orderEntryPageInstance.clickOnOrder(orderID);
		       
		       Thread.sleep(3000);
		        
		       dashboardPageInstance.clickOnLogout();
		   }
		   catch(Exception e)
		   {
			   Logger.error(e.getMessage());
				throw e;
		   }
	   }
	@Test(groups = {"RecruitmentOrderAddOncharges","Sprint56","Regression3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void RecruitmentOrderAddOncharges(Map<String, String> userData) throws Exception
	{
		try
		{
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");			   			   

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);
			Thread.sleep(30000);
			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");//swagata
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

			newOrderInstance.selectSoldToCustomerBU("bu_SDT");
			newOrderInstance.enterSoldToCustomer("CU00475251");
			newOrderInstance.selectBilltoSameAsSoldTo();

			newOrderInstance.createNewClassifiedInsertion();		       
			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("1",26, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("1",26, 1);
			Thread.sleep(2000);	      
			classifiedOrderInstance.selectClassifiedProductDrpDwn("1",26, 2);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackage("1",26, 3);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCode("1",26, 4);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();		       
			classifiedOrderInstance.clickApplyBtn();
			Thread.sleep(5000);
			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(7000);
			classifiedOrderInstance.uploadAd("1",1,6);
			//Thread.sleep(7000);	
			/* classifiedOrderInstance.enterAttributeDetailsALTVolDisc();	
		      Thread.sleep(15000);*/
			classifiedOrderInstance.enterRecruitmentAttributeDetails();	
			Thread.sleep(5000);
			newOrderInstance.saveOrder();
			Thread.sleep(6000);
			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
			Logger.info("Saved Order : "+orderNumber);
			Thread.sleep(3000);
			Double price_before_attributeAdded=classifiedOrderInstance.getonlineInsertionPriceINRecruitmentOrder();
			Logger.info("Price value before add on charge added is:"+price_before_attributeAdded);
			classifiedOrderInstance.SelectAddonChargeAttrinute();
			Thread.sleep(5000);
			int insertionlineNoForOnline=classifiedOrderInstance.getonlineInsertionLineNoINRecruitmentOrder();
			Double price_after_attributeAdded=classifiedOrderInstance.getonlineInsertionPriceINRecruitmentOrder();
			Logger.info("Price value after add on charge added is:"+price_after_attributeAdded);
			double expected_price_after_add_on_charges=price_before_attributeAdded+100.0;
			Assert.assertEquals(expected_price_after_add_on_charges, price_after_attributeAdded);
			Logger.info("add on charges added successfully in insertion line");	
			newOrderInstance.viewInsertionDetails(Integer.toString(insertionlineNoForOnline));
			Thread.sleep(2000);
			//Double AddonPrice=newOrderInstance.getInsertionPrice(Integer.toString(insertionlineNoForOnline),"addon charge");
			//Logger.info("Addon "+AddonPrice);
			//Assert.assertEquals(AddonPrice, 100.0);
			//Thread.sleep(2000);
			classifiedOrderInstance.ClickOnAddonchargesMagnifier(insertionlineNoForOnline);
			Assert.assertEquals(true, classifiedOrderInstance.VerifyRemoveButtonAdOnChargeAttributeSelectedinfees("Construction"));
			Thread.sleep(2000);
			Assert.assertEquals(true, classifiedOrderInstance.VerifyRemoveButtonAdOnChargeAttributeSelectedinfees("AccountFinance"));
			Thread.sleep(2000);
			classifiedOrderInstance.ClickCancelOnAddonChargeModifier();
			Thread.sleep(4000);			
			newOrderInstance.ScrollToInsertionLine(1);
			newOrderInstance.clickOnsalesrrepInInserionLine(2);
			//newOrderInstance.removeSalesRepOnInsertion(1)
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(2, "SA01634");
			Thread.sleep(4000);
			newOrderInstance.clickOnsalesrrepInInserionLine(2);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(2);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			//Thread.sleep(2000);
			String orderid = orderEntryPageInstance.getOrderID();
			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();

			dashboardPageInstance.clickOnLogout();//swagata
			//dashboardPageInstance.clickondropdownforlogout(); //joy
		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"RecruitmentOrderAddOnchargesaddedtoInsertionLine","Sprint56","Regression3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void RecruitmentOrderAddOnchargesaddedtoInsertionLine(Map<String, String> userData) throws Exception
	{
		try
		{
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");			   			   

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);
			Thread.sleep(30000);
			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");//swagata
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

			newOrderInstance.selectSoldToCustomerBU("bu_SDT");
			newOrderInstance.enterSoldToCustomer("CU00475251");
			newOrderInstance.selectBilltoSameAsSoldTo();

			newOrderInstance.createNewClassifiedInsertion();		       
			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("1",26, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("1",26, 1);
			Thread.sleep(2000);	      
			classifiedOrderInstance.selectClassifiedProductDrpDwn("1",26, 2);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackage("1",26, 3);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCode("1",26, 4);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();		       
			classifiedOrderInstance.clickApplyBtn();
			Thread.sleep(5000);
			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(7000);
			classifiedOrderInstance.uploadAd("1",1,6);
			//Thread.sleep(7000);	
			/* classifiedOrderInstance.enterAttributeDetailsALTVolDisc();	
		      Thread.sleep(15000);*/
			classifiedOrderInstance.enterRecruitmentAttributeDetails();	
			Thread.sleep(5000);
			newOrderInstance.saveOrder();
			Thread.sleep(6000);
			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
			Logger.info("Saved Order : "+orderNumber);
			Thread.sleep(5000);
			
			Double price_before_attributeAdded=classifiedOrderInstance.getonlineInsertionPriceINRecruitmentOrder();
			Logger.info("Price value before add on charge added is:"+price_before_attributeAdded);
			classifiedOrderInstance.SelectAddonChargeAttrinute();
			Thread.sleep(5000);
			int insertionlineNoForOnline=classifiedOrderInstance.getonlineInsertionLineNoINRecruitmentOrder();
			Double price_after_attributeAdded=classifiedOrderInstance.getonlineInsertionPriceINRecruitmentOrder();
			Logger.info("Price value after add on charge added is:"+price_after_attributeAdded);
			double expected_price_after_add_on_charges=price_before_attributeAdded+100.0;
			Assert.assertEquals(expected_price_after_add_on_charges, price_after_attributeAdded);
			Logger.info("add on charges added successfully in insertion line");	
			classifiedOrderInstance.unlockOrderLines();
			newOrderInstance.viewInsertionDetails(Integer.toString(insertionlineNoForOnline));
			Thread.sleep(2000);
			
			//Double AddonPrice=newOrderInstance.getInsertionPrice(Integer.toString(insertionlineNoForOnline),"addon charge");
			//Logger.info("Addon "+AddonPrice);
			//Assert.assertEquals(AddonPrice, 100.0);
			//Thread.sleep(2000);
			classifiedOrderInstance.ClickOnAddonchargesMagnifier(insertionlineNoForOnline);
			Assert.assertEquals(true, classifiedOrderInstance.VerifyRemoveButtonAdOnChargeAttributeSelectedinfees("Construction"));
			Thread.sleep(2000);
			Assert.assertEquals(true, classifiedOrderInstance.VerifyRemoveButtonAdOnChargeAttributeSelectedinfees("AccountFinance"));
			Thread.sleep(2000);
			classifiedOrderInstance.AddChargefromFeesInInsertionLine("FacebookPlatinum");
			Double newAddonchrage=classifiedOrderInstance.getAddONChargevalueFromFeesForparticularAddOntype("FacebookPlatinum");
			classifiedOrderInstance.ClickConfirmOnAddonChargeModifier();
			Thread.sleep(4000);	
			Double price_after_attributeAddedrominsertionline=classifiedOrderInstance.getonlineInsertionPriceINRecruitmentOrderAfterUnlockorderline();
			Logger.info("Price value after add on charge added is:"+price_after_attributeAddedrominsertionline);
			Assert.assertEquals(price_after_attributeAddedrominsertionline, price_after_attributeAdded+newAddonchrage);
			newOrderInstance.ScrollToInsertionLine(1);
			newOrderInstance.clickOnsalesrrepInInserionLine(2);
			//newOrderInstance.removeSalesRepOnInsertion(1)
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(2, "SA01634");
			Thread.sleep(4000);
			newOrderInstance.clickOnsalesrrepInInserionLine(2);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(2);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			//Thread.sleep(2000);
			String orderid = orderEntryPageInstance.getOrderID();
			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();

			dashboardPageInstance.clickOnLogout();//swagata
			//dashboardPageInstance.clickondropdownforlogout(); //joy
		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}