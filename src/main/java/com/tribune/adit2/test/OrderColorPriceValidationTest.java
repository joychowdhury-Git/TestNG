package com.tribune.adit2.test;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

public class OrderColorPriceValidationTest 
{
	/**
	 * This test will create a new order then change the color 
	 * of the layout and validate the pricing details
	 */
	@Test(groups = {"Order","orderColorValidation"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void orderColorValidation(Map<String, String> userData) throws Exception
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
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",4, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2017");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",4, 1);
		       newOrderInstance.selectProduct("1",4, 2);
		       newOrderInstance.selectAdType("1",4, 3);
		       newOrderInstance.selectSection("1",4, 4);
		       Thread.sleep(2000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.selectMaterialSource("1","NewBuild");
		       double priceBeforeEdit = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("Total price of the order placed is "+priceBeforeEdit);
		       double salesPriceBeforeEdit = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("Sales price before editing" +salesPriceBeforeEdit);
		       newOrderInstance.checkUncheckSalesPrice(1,true);
		       newOrderInstance.editColor("1","4C");
		       Thread.sleep(2000);
		       double priceAfterEdit = newOrderInstance.getInsertionPrice("1","total");
		       Logger.info("Total price of the order placed is "+priceAfterEdit);
		       boolean basePriceFlag = false;
		       boolean salesPriceFlag = false;
		       boolean netPriceFlag = false;
		       boolean totalPriceFlag = false;
		       boolean contractPriceFlag = false;
		       boolean overallPriceFlag = false;
		       double basePrice = newOrderInstance.getInsertionPrice("1", "base");
		       Logger.info("base price= "+basePrice+"Data ="+TribuneUtils.getDoubleCellValues("Product",4, 14));
		       //if(basePrice==TribuneUtils.getDoubleCellValues("Product",4, 14))
		       if(basePrice==8.56)
		       {
		    	   basePriceFlag = true;
		    	   Logger.info("base price "+basePrice+" is as per the pricing logics");
		       }
		       double salesPrice = newOrderInstance.getInsertionPrice("1", "sales");
		       Logger.info("salesPrice= "+salesPrice+"Data ="+TribuneUtils.getDoubleCellValues("Product",4, 16));
		       //if(salesPrice==TribuneUtils.getDoubleCellValues("Product",4, 16))
		       if(salesPrice==8.56)
		       {
		    	   salesPriceFlag = true;
		    	   Logger.info("sales price "+salesPrice+" is as per the pricing logics");
		       }
		       double netPrice = newOrderInstance.getInsertionPrice("1", "net");
		       Logger.info("netPrice= "+netPrice+"Data ="+TribuneUtils.getDoubleCellValues("Product",4, 15));
		       //if(netPrice==TribuneUtils.getDoubleCellValues("Product",4, 15))
		    	   if(netPrice==9.84)
		       {
		    	   netPriceFlag = true;
		    	   Logger.info("net price "+netPrice+" is as per the pricing logics");
		       }
		       double totalInsertionPrice = newOrderInstance.getInsertionPrice("1", "total");
		       Logger.info("totalInsertionPrice= "+totalInsertionPrice+"Data ="+TribuneUtils.getDoubleCellValues("Product",4, 17));
		       //if(totalInsertionPrice==TribuneUtils.getDoubleCellValues("Product",4, 17))
		       if(totalInsertionPrice==9.84)
		       {
		    	   totalPriceFlag = true;
		    	   Logger.info("total insertion price "+totalInsertionPrice+" is as per the pricing logics");
		       }
		       double contractPrice = newOrderInstance.getInsertionPrice("1", "contract");
		       Logger.info("contractPrice= "+contractPrice+"Data ="+TribuneUtils.getDoubleCellValues("Product",4, 18));
		       if(contractPrice==TribuneUtils.getDoubleCellValues("Product",4, 18))
		       {
		    	   contractPriceFlag = true;
		    	   Logger.info("contract price "+contractPrice+" is as per the pricing logics");
		       }
		       
		       if(basePriceFlag==true){
		    	   if(salesPriceFlag==true){
		    		   if(netPriceFlag==true){
		    			   if(contractPriceFlag==true){
		    				   if(totalPriceFlag==true){
		    					   overallPriceFlag = true;
		    				   }
		    			   }
		    		   }
		    	   }
		       }
		       Assert.assertEquals(overallPriceFlag, true);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA00443");
		       //newOrderInstance.submitOrder();
		       
		       
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
