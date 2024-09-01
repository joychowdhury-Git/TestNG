package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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

public class SDT {
	@Test(groups = {"SDT6Img","SDT","Grp2","RegFailed1","Group4F","TestPriority"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyPriceChangefor6Img(Map<String, String> userData) throws Exception
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
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewClassifiedInsertion();
		       Thread.sleep(4000);		      
		       
		       Thread.sleep(4000);
		       classifiedOrderInstance.selectPackageBU("5",6, 0);
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5",6, 1);
		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
		       Thread.sleep(2000);
		       //driver.quit();
		       classifiedOrderInstance.selectClassifiedProductDrpDwn("5",6, 2);
		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedPackage("5",6, 3);
		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedClassCode("5",6, 4);
		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectMultipleZone();
		       classifiedOrderInstance.selectDate("nextmonth");
		       classifiedOrderInstance.clickApplyBtn();

		       Thread.sleep(30000);
		       //***********************
		       //classifiedOrderInstance.verifyInsertionPrice("Non-Legal");

		       classifiedOrderInstance.clickEditAdBtn();

		       Thread.sleep(15000);
		       classifiedOrderInstance.uploadAd("5",1,6);

		       Thread.sleep(10000);
		       //classifiedOrderInstance.uploadAd("5",1,6);
		       String prev_price=driver.findElement(By.xpath("//span[text()='Total Amount:']/following-sibling::span"))
		    		   .getText();
		       classifiedOrderInstance.enterSDTAttributeDetails6Img(6);
		       Thread.sleep(10000);
		       String new_price=driver.findElement(By.xpath("//span[text()='Total Amount:']/following-sibling::span"))
		    		   .getText();
		       prev_price= prev_price.substring(1);
		       new_price= new_price.substring(1);
		       
		       Float prev_price_f= Float.valueOf(prev_price);
		       Float new_price_f= Float.valueOf(new_price);
		       
		       Logger.info("prev_price:"+prev_price+" new_price:"+new_price);
		       Logger.info("prev_price_f:"+prev_price_f+" new_price_f:"+new_price_f);

		       if((new_price_f-prev_price_f)==10.00){
		    	   Logger.info("Price has increased by $10");
		    	   Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Price has not increased by $10");
		    	   Assert.assertEquals("str1","str");
		       }
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"SDT1Img","SDT","Grp2","RegFailed1","TestPriority"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyPriceChangefor1Img(Map<String, String> userData) throws Exception
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
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewClassifiedInsertion();
		       Thread.sleep(4000);		      
		       
		       Thread.sleep(4000);
		       classifiedOrderInstance.selectPackageBU("5",6, 0);
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5",6, 1);
		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
		       Thread.sleep(2000);
		       //driver.quit();
		       classifiedOrderInstance.selectClassifiedProductDrpDwn("5",6, 2);
		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedPackage("5",6, 3);
		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedClassCode("5",6, 4);
		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectMultipleZone();
		       classifiedOrderInstance.selectDate("nextmonth");
		       classifiedOrderInstance.clickApplyBtn();

		       Thread.sleep(30000);
		       //***********************
		       //classifiedOrderInstance.verifyInsertionPrice("Non-Legal");

		       classifiedOrderInstance.clickEditAdBtn();

		       Thread.sleep(15000);
		       classifiedOrderInstance.uploadAd("5",1,6);

		       Thread.sleep(10000);
		       //classifiedOrderInstance.uploadAd("5",1,6);
		       String prev_price=driver.findElement(By.xpath("//span[text()='Total Amount:']/following-sibling::span"))
		    		   .getText();
		       classifiedOrderInstance.enterSDTAttributeDetails1Img(1);
		       String new_price=driver.findElement(By.xpath("//span[text()='Total Amount:']/following-sibling::span"))
		    		   .getText();
		       prev_price= prev_price.substring(1);
		       new_price= new_price.substring(1);
		       
		       Float prev_price_f= Float.valueOf(prev_price);
		       Float new_price_f= Float.valueOf(new_price);
		       
		       Logger.info("prev_price:"+prev_price+" new_price:"+new_price);
		       Logger.info("prev_price_f:"+prev_price_f+" new_price_f:"+new_price_f);
		       Logger.info(String.valueOf(new_price_f-prev_price_f));
		       if((new_price_f-prev_price_f)==0.00){
		    	   Logger.info("Price has not increased by $10");
		    	   Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Price has increased");
		    	   Assert.assertEquals("str1","str");
		       }		       
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"SDT1ImgCC","SDT","Grp2","RegressionLatest","Group4","PriorityVulnerability","RegFailed1","Group4F","G4"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyPriceChangefor1ImgforCreditCard(Map<String, String> userData) throws Exception
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
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewClassifiedInsertion();
		       Thread.sleep(4000);		      
		       
		       Thread.sleep(4000);
		       classifiedOrderInstance.selectPackageBU("5",6, 0);
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5",6, 1);
		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
		       Thread.sleep(2000);
		       //driver.quit();
		       classifiedOrderInstance.selectClassifiedProductDrpDwn("5",6, 2);
		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedPackage("5",6, 3);
		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedClassCode("5",6, 4);
		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectMultipleZone();
		       classifiedOrderInstance.selectDate("nextmonth");
		       classifiedOrderInstance.clickApplyBtn();

		       Thread.sleep(30000);
		       //***********************
		       //classifiedOrderInstance.verifyInsertionPrice("Non-Legal");

		       classifiedOrderInstance.clickEditAdBtn();

		       Thread.sleep(15000);
		       classifiedOrderInstance.uploadAd("5",1,6);

		       Thread.sleep(10000);
		       //***********
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		        //   newOrderInstance.removeSalesRepOnInsertion(1);
				   Thread.sleep(4000);				      
		           newOrderInstance.addNewSalesRepOnInsertion(1, "SA00856");
				   Thread.sleep(4000);
				  newOrderInstance.clickOnInsertionSalesRepSection(1);
				   Thread.sleep(4000);
				   newOrderInstance.applytoAllSalesRepOnInsertion(1);
				   Thread.sleep(2000);
			       Thread.sleep(4000);
		       newOrderInstance.submitOrder();		       
		       Thread.sleep(1000);
		       String orderid=orderEntryPageInstance.getOrderID();
		       Logger.info("orderid:"+orderid);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);		       
		       orderEntryPageInstance.clickOnOrder(orderid);
		       Thread.sleep(7000);
		       
		       newOrderInstance.selectPaymentType("Credit Card");
		       newOrderInstance.selectCardType("New Card");
		       Thread.sleep(5000);
		      // Logger.info("account : "+TribuneUtils.getStringCellValues("BankAccountInfo", 1, 2));
		       newOrderInstance.enterCreditCardInfoOrder("BankAccountInfo");
		       Thread.sleep(3000);
		       //**************
		       
		       //classifiedOrderInstance.uploadAd("5",1,6);
		       String prev_price=driver.findElement(By.xpath("//span[text()='Total Amount:']/following-sibling::span"))
		    		   .getText();
		       classifiedOrderInstance.enterSDTAttributeDetails1Img(1);
		       String new_price=driver.findElement(By.xpath("//span[text()='Total Amount:']/following-sibling::span"))
		    		   .getText();
		       prev_price= prev_price.substring(1);
		       new_price= new_price.substring(1);
		       
		       Float prev_price_f= Float.valueOf(prev_price);
		       Float new_price_f= Float.valueOf(new_price);
		       
		       Logger.info("prev_price:"+prev_price+" new_price:"+new_price);
		       Logger.info("prev_price_f:"+prev_price_f+" new_price_f:"+new_price_f);
		       Logger.info(String.valueOf(new_price_f-prev_price_f));
		       if((new_price_f-prev_price_f)==0.00){
		    	   Logger.info("Price has not increased by $10");
		    	   Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Price has increased");
		    	   Assert.assertEquals("str1","str");
		       }		      
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"SDT6ImgACH","SDT","Grp2","RegressionLatest","Group4","PriorityVulnerability","RegFailed1","Group4F","G4"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyPriceChangefor6ImgandACHPostOrderSubmit(Map<String, String> userData) throws Exception
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
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewClassifiedInsertion();
		       Thread.sleep(4000);		      
		       
		       Thread.sleep(4000);
		       classifiedOrderInstance.selectPackageBU("5",6, 0);
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5",6, 1);
		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
		       Thread.sleep(2000);
		       //driver.quit();
		       classifiedOrderInstance.selectClassifiedProductDrpDwn("5",6, 2);
		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedPackage("5",6, 3);
		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedClassCode("5",6, 4);
		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectMultipleZone();
		       classifiedOrderInstance.selectDate("nextmonth");
		       classifiedOrderInstance.clickApplyBtn();

		       Thread.sleep(30000);
		       //***********************
		       //classifiedOrderInstance.verifyInsertionPrice("Non-Legal");

		       classifiedOrderInstance.clickEditAdBtn();

		       Thread.sleep(15000);
		       classifiedOrderInstance.uploadAd("5",1,6);

		       Thread.sleep(10000);

		       //*****************
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           newOrderInstance.removeSalesRepOnInsertion(1);
			   Thread.sleep(4000);				      
	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			   Thread.sleep(4000);
			  newOrderInstance.clickOnInsertionSalesRepSection(1);
			   Thread.sleep(4000);
			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
			   Thread.sleep(2000);
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();		       
		       Thread.sleep(2000);
		       String orderid=orderEntryPageInstance.getOrderID();
		       Logger.info("orderid:"+orderid);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);		       
		       orderEntryPageInstance.clickOnOrder(orderid);
		       Thread.sleep(7000);
		       
		       newOrderInstance.selectPaymentType("ACH");
		       Thread.sleep(2000);
		       newOrderInstance.selectCardType("New Card");
		       Thread.sleep(5000);
		      // Logger.info("account : "+TribuneUtils.getStringCellValues("BankAccountInfo", 1, 2));
		       newOrderInstance.enterAchBankAccountInfoOrder("BankAccountInfo");
		       Thread.sleep(3000);
		     //*****************
		       String prev_price=driver.findElement(By.xpath("//span[text()='Total Amount:']/following-sibling::span"))
		    		   .getText();
		       classifiedOrderInstance.enterSDTAttributeDetails6Img(6);
		       Thread.sleep(2000);
		       String new_price=driver.findElement(By.xpath("//span[text()='Total Amount:']/following-sibling::span"))
		    		   .getText();
		       prev_price= prev_price.substring(1);
		       new_price= new_price.substring(1);
		       
		       Float prev_price_f= Float.valueOf(prev_price);
		       Float new_price_f= Float.valueOf(new_price);
		       
		       Logger.info("prev_price:"+prev_price+" new_price:"+new_price);
		       Logger.info("prev_price_f:"+prev_price_f+" new_price_f:"+new_price_f);
		       Logger.info(String.valueOf(new_price_f-prev_price_f));
		       if((new_price_f-prev_price_f)==10.00){
		    	   Logger.info("Price has increased by $10");
		    	   Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Price has not increased by $10");
		    	   Assert.assertEquals("str1","str");
		       }
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"SDT6ImgOrderSubmit","SDT","Grp2","RegressionLatest","Group4","RegFailed1","Group4F","NANT","G4","RerunF2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyPriceChangefor6ImgPostOrderSubmit(Map<String, String> userData) throws Exception
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
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewClassifiedInsertion();
		       Thread.sleep(4000);		      
		       
		       Thread.sleep(4000);
		       classifiedOrderInstance.selectPackageBU("5",6, 0);
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5",6, 1);
		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
		       Thread.sleep(2000);
		       //driver.quit();
		       classifiedOrderInstance.selectClassifiedProductDrpDwn("5",6, 2);
		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedPackage("5",6, 3);
		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedClassCode("5",6, 4);
		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectMultipleZone();
		       classifiedOrderInstance.selectDate("nextmonth");
		       classifiedOrderInstance.clickApplyBtn();

		       Thread.sleep(30000);
		       //***********************
		       //classifiedOrderInstance.verifyInsertionPrice("Non-Legal");

		       classifiedOrderInstance.clickEditAdBtn();

		       Thread.sleep(15000);
		       classifiedOrderInstance.uploadAd("5",1,6);

		       Thread.sleep(10000);

		       //*****************

		       newOrderInstance.clickOnInsertionSalesRepSection(1);
	           newOrderInstance.removeSalesRepOnInsertion(1);
			   Thread.sleep(4000);				      
	           newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
			   Thread.sleep(4000);
			  newOrderInstance.clickOnInsertionSalesRepSection(1);
			   Thread.sleep(4000);
			   newOrderInstance.applytoAllSalesRepOnInsertion(1);
			   Thread.sleep(2000);
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();		       
		       Thread.sleep(1000);
		       String orderid=orderEntryPageInstance.getOrderID();
		       Logger.info("orderid:"+orderid);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);		       
		       orderEntryPageInstance.clickOnOrder(orderid);
		       Thread.sleep(15000);		       		       
		     //*****************
		       String prev_price=driver.findElement(By.xpath("//span[text()='Total Amount:']/following-sibling::span"))
		    		   .getText();
		      
		       classifiedOrderInstance.enterSDTAttributeDetails6Img(6);
		       Thread.sleep(10000);
		       String new_price=driver.findElement(By.xpath("//span[text()='Total Amount:']/following-sibling::span"))
		    		   .getText();
		       Logger.info("prev_price:"+prev_price+" new_price:"+new_price);
		       
		       prev_price= prev_price.substring(1);
		       new_price= new_price.substring(1);
		       
		       Float prev_price_f= Float.valueOf(prev_price);
		       Float new_price_f= Float.valueOf(new_price);
		       
		       Logger.info("prev_price:"+prev_price+" new_price:"+new_price);
		       Logger.info("prev_price_f:"+prev_price_f+" new_price_f:"+new_price_f);
		       Logger.info(String.valueOf(new_price_f-prev_price_f));
		       if((new_price_f-prev_price_f)==10.00){
		    	   Logger.info("Price has increased by $10");
		    	   Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Price has not increased by $10");
		    	   Assert.assertEquals("str1","str");
		       }
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
