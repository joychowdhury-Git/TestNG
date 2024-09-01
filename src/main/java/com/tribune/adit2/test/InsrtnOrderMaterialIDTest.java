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

/**
 * Page Class Modeling for Order Entry Home Page
 * @author Priyanka Goud CR 
 * @since January 2016
 */

public class InsrtnOrderMaterialIDTest 
{
	/**
	 * This test will create a new Insertion order and validate material 
	 * for a new insertion, duplicate insertion, new version of an insertion
	 */
	@Test(groups = {"insertionOrderMaterialID", "RegressionLatest","Grp1","PrioritizedReg1", "Reg1","Group3","NewRegression1","NewRegression","RerunF2", "insertionOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void insertionOrderMaterialID(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewInsertionOrderBtn();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		      // newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",2, 0);
		       newOrderInstance.enterPubDate("1","28", "Dec", "2021");
		       newOrderInstance.selectProductType("1",2, 1);
		       newOrderInstance.selectProduct("1",2, 2);
		       newOrderInstance.selectAdType("1",2, 3);
		      // newOrderInstance.selectSection("1",2, 4);
		       Thread.sleep(4000);
		       String materialIdInsertion1 = newOrderInstance.getMaterialID("1");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("2",2, 0);
		       newOrderInstance.enterPubDate("2","30", "Dec", "2021");
		       newOrderInstance.selectProductType("2",2, 1);
		       newOrderInstance.selectProduct("2",2, 2);
		       newOrderInstance.selectAdType("2",2, 3);
		       //newOrderInstance.selectSection("2",2, 4);
		       Thread.sleep(4000);
		       String materialIdInsertion2 = newOrderInstance.getMaterialID("2");
		       newOrderInstance.createDuplicateInsertion("1");
		       String materialIdInsertion3 = newOrderInstance.getMaterialID("3");
		       newOrderInstance.createNewInsertionVersion("1");
		       String materialIdInsertion4 = newOrderInstance.getMaterialID("4");
		       boolean flag1 = false;
		       boolean flag2 = false;
		       if(materialIdInsertion1.contentEquals("1")){
		    	   flag1 = true;
		    	   Logger.info("Validation Success - initial insertion");
		       }
		       if(materialIdInsertion2.contentEquals("2")){
		    	   Logger.info("Validation Success - new insertion");
		    	   if(materialIdInsertion3.contentEquals("1")){
		    		   Logger.info("Validation Success - duplicate insertion-1");
		    		   if(materialIdInsertion4.contentEquals("1")){
				    	   flag2 = true;
				    	   Logger.info("Validation Success - new version of an insertion-1");
				       }
			       }
		       }
		      Assert.assertEquals(flag1, true);
		      Assert.assertEquals(flag2, true);
		      //newOrderInstance.addSalesPerson("SA00011");
		     // Thread.sleep(2000);
		       //dashboardPageInstance.clickondropdownforlogout(); //joy
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
