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

public class OrderNewDisplayAdSizePriceTest 
{

	/**
	 * This test will create a new display order, edit the adsize and validate the price
	 */
	@Test(groups = {"Order","orderAdSizePrice"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void orderAdSizePrice(Map<String, String> userData) throws Exception
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
		       newOrderInstance.selectBU("1",6, 0);
		       Thread.sleep(4000);
		       newOrderInstance.enterPubDate("1","22", "Dec", "2019");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",6, 1);
		       Thread.sleep(4000);
		       newOrderInstance.selectProduct("1",6, 2);
		       Thread.sleep(4000);
		       newOrderInstance.selectAdType("1",6, 3);
		       Thread.sleep(4000);
		       newOrderInstance.selectSection("1",6, 4);
		       Thread.sleep(4000);
		       newOrderInstance.viewInsertionDetails("1");
		       Thread.sleep(4000);
		      newOrderInstance.selectMaterialSource("1","New Build");
		      Thread.sleep(4000);
		       double totalInsertionPriceBefore = newOrderInstance.getInsertionPrice("1", "total");
		       Logger.info("total insertion price "+totalInsertionPriceBefore);
		       if(totalInsertionPriceBefore==8.56)
		       {
		    	   Logger.info("total insertion price "+totalInsertionPriceBefore+" is as per the pricing logics");
		       }
		       newOrderInstance.selectAdSize(1, "1 x 2 Directory");
		       Thread.sleep(1000);
		       boolean basePriceFlag = false;
		       boolean salesPriceFlag = false;
		       boolean netPriceFlag = false;
		       boolean totalPriceFlag = false;
		       boolean contractPriceFlag = false;
		       boolean overallPriceFlag = false;
		       double basePrice = newOrderInstance.getInsertionPrice("1", "base");
		       Logger.info("base price "+basePrice);
		       if(basePrice==17.11)
		       {
		    	   basePriceFlag = true;
		    	   Logger.info("base price "+basePrice+" is as per the pricing logics");
		       }
		       double salesPrice = newOrderInstance.getInsertionPrice("1", "sales");
		       Logger.info("sales price "+salesPrice);
		       if(salesPrice==17.11)
		       {
		    	   salesPriceFlag = true;
		    	   Logger.info("sales price "+salesPrice+" is as per the pricing logics");
		       }
		       double netPrice = newOrderInstance.getInsertionPrice("1", "net");
		       Logger.info("net price "+netPrice);
		       if(netPrice==17.11)
		       {
		    	   netPriceFlag = true;
		    	   Logger.info("net price "+netPrice+" is as per the pricing logics");
		       }
		       double totalInsertionPriceAfter = newOrderInstance.getInsertionPrice("1", "total");
		       Logger.info("total insertion price "+totalInsertionPriceAfter);
		     
		       if(totalInsertionPriceAfter==17.11)
		       {
		    	   totalPriceFlag = true;
		    	   Logger.info("total insertion price "+totalInsertionPriceAfter+" is as per the pricing logics");
		       }
		       double contractPrice = newOrderInstance.getInsertionPrice("1", "contract");
		       Logger.info("contract Price "+contractPrice);
		       if(contractPrice==0.0)
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
		       Assert.assertEquals(overallPriceFlag, true);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(2000);
		       orderEntryPageInstance.getOrderID();
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
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
