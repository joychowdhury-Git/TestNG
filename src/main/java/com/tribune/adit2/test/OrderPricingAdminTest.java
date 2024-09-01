package com.tribune.adit2.test;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.ClassifiedOrderOptions;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.PricingAdmin.PricingAdminElementIdentifiers;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;


public class OrderPricingAdminTest 
{
	
	@Test(groups = {"validatePricingModifierChange"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void validatePricingModifierChange(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnPricingModule();
		       
		       PricingAdminElementIdentifiers pricingPageInstance = PageFactory.initElements(driver, PricingAdminElementIdentifiers.class);
		       
		       
		       pricingPageInstance.gotoProduct("CTC-CTMG","Display","Chicago Tribune","Main News");
		       Thread.sleep(4000);
		       pricingPageInstance.expandZoneOptions();
		       Thread.sleep(4000);
		       pricingPageInstance.selectZoneOption("Full Run");
		       Thread.sleep(4000);
		      String value =  pricingPageInstance.getModifierValue();
		      
		    //   DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_CTC");
		       newOrderInstance.enterSoldToCustomer("CU00037236");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		     //  newOrderInstance.enterPoNumber("1234");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",17, 0);
		       newOrderInstance.enterPubDate("1","17", "Dec", "2019");
		       newOrderInstance.selectProductType("1",17, 1);
		       newOrderInstance.selectProduct("1",17, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",17, 3);
		       newOrderInstance.selectSection("1",17, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");		      
		       Thread.sleep(4000);
		       double salesPrice = newOrderInstance.getInsertionPrice("1", "total");
  		       Logger.info("total price "+salesPrice);
  		       
  		       
  		     utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
		       utilities.implementWait(driver);
		       
		      // SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
		       signinPageinstance.login("success");
		       dashboardPageInstance.clickOnPricingModule();
		       Thread.sleep(4000);
  		       pricingPageInstance.gotoProduct("CTC-CTMG","Display","Chicago Tribune","Main News");
  		     Thread.sleep(4000);
		       pricingPageInstance.expandZoneOptions();
		       Thread.sleep(4000);
		       pricingPageInstance.selectZoneOption("Full Run");
		       Thread.sleep(4000);
		       pricingPageInstance.editSectionModifierValueSubmit("120");
		       
		       pricingPageInstance.clickRefresh();
		       
		       dashboardPageInstance.clickOnOrderEntryModule();
		       
		     //  OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		     //  NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_CTC");
		       newOrderInstance.enterSoldToCustomer("CU00037236");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		     //  newOrderInstance.enterPoNumber("1234");
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",17, 0);
		       newOrderInstance.enterPubDate("1","17", "Dec", "2019");
		       newOrderInstance.selectProductType("1",17, 1);
		       newOrderInstance.selectProduct("1",17, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",17, 3);
		       newOrderInstance.selectSection("1",17, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");		      
		       Thread.sleep(4000);
		       double salesPrice1 = newOrderInstance.getInsertionPrice("1", "total");
  		       Logger.info("total price after section modifier changed from pricing admin : "+salesPrice1);
  		       
  		       if (salesPrice!=salesPrice1)
  		    	   
  		       {
  		    	   Logger.info("Price changed successfully after modifier value changed");
  		       }
  		       
  		       else
  		       {
  		    	 Logger.info("Price did not change after modifier value changed");
  		       }
  		       
  		     utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
		       utilities.implementWait(driver);
		       
		      // SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
		       signinPageinstance.login("success");
		       dashboardPageInstance.clickOnPricingModule();
  		       
  		       pricingPageInstance.gotoProduct("CTC-CTMG","Display","Chicago Tribune","Main News");
		       
		       pricingPageInstance.expandZoneOptions();
		       
		       pricingPageInstance.selectZoneOption("Full Run");
		       
		       pricingPageInstance.editSectionModifierValueSubmit(value);
		       
		       pricingPageInstance.clickRefresh();
		       
		       Logger.info("Modifier value reverted");
		       
		       dashboardPageInstance.clickOnLogout();
		       
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

		
}
