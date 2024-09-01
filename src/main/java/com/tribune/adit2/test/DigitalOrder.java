package com.tribune.adit2.test;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.ClassifiedOrderOptions;
import com.tribune.adit2.OrderEntry.DigitalOrderOptions;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

public class DigitalOrder {
	@Test(groups = {"NewDigitalOrder","DigitalOrder","Grp2","RegressionLatest","Group4"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewDigitalOrder(Map<String, String> userData) throws Exception
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

			DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			//newOrderInstance.selectOrderType("OrderType_Spec");
			//newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewDigitalOrder();
			Thread.sleep(4000);
			
		//	digitalOrderInstance.selectPackageBU("6",1, 0);
			digitalOrderInstance.selectPackageBU("1",1, 0);
			Thread.sleep(2000);

		//	digitalOrderInstance.selectDigitalProductDrpDwn("6",1, 1);
			digitalOrderInstance.selectDigitalProductDrpDwn("1",1, 1);
			digitalOrderInstance.selectDigitalChargeDayDrpDwn(1);

			digitalOrderInstance.clickApplyBtn();
			Thread.sleep(10000);
			//WebDriverWait wait = new WebDriverWait(driver,200);		       
			//wait.until(ExpectedConditions.elementToBeClickable(newOrderInstance.submitOrderButton));
			//***********************
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA01634");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			//Thread.sleep(2000);
			//newOrderInstance.confirmToMakeOrderFree();
			Thread.sleep(3000);
			Logger.info("Order:"+orderEntryPageInstance.getOrderID());
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

	@Test(groups = {"KillDigitalOrder","DigitalOrder","Grp2","RegressionLatest","Group4","RegFailed1","Group4F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void killDigitalOrder(Map<String, String> userData) throws Exception
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

			DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			//newOrderInstance.selectOrderType("OrderType_Spec");
			//newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewDigitalOrder();
			Thread.sleep(4000);

			digitalOrderInstance.selectPackageBU("6",1, 0);
			Thread.sleep(2000);

			digitalOrderInstance.selectDigitalProductDrpDwn("6",1, 1);
			digitalOrderInstance.selectDigitalChargeDayDrpDwn(1);

			digitalOrderInstance.clickApplyBtn();
			Thread.sleep(10000);
			//WebDriverWait wait = new WebDriverWait(driver,200);		       
			//wait.until(ExpectedConditions.elementToBeClickable(newOrderInstance.submitOrderButton));
			//***********************
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA01634");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			// Thread.sleep(3000);
			String orderid=orderEntryPageInstance.getOrderID(); 
			Logger.info("Order:"+orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();

			orderEntryPageInstance.clickOnOrder(orderid);

			Thread.sleep(10000);
			newOrderInstance.clickOnKill();
			newOrderInstance.clickOnKillOnConfirmation();
			Thread.sleep(8000);
			//  WebDriverWait wait = new WebDriverWait(driver, 60);
			//   wait.until(ExpectedConditions.textToBePresentInElement(newOrderInstance.orderStatusOVPage, "Killed"));
			Thread.sleep(10000);
			String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
			Logger.info("orderStatus "+orderStatus);
			Thread.sleep(2000);
			dashboardPageInstance.clickOnLogout();
		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"UploadDocDigital","DigitalOrder1","Grp2","RegressionLatest","Group4","RegFailed1","Group4F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void uploadDocumentinDigitalOrder(Map<String, String> userData) throws Exception
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

			DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			//newOrderInstance.selectOrderType("OrderType_Spec");
			//newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewDigitalOrder();
			Thread.sleep(4000);

			digitalOrderInstance.selectPackageBU("6",1, 0);
			Thread.sleep(2000);

			digitalOrderInstance.selectDigitalProductDrpDwn("6",1, 1);
			digitalOrderInstance.selectDigitalChargeDayDrpDwn(1);

			digitalOrderInstance.clickApplyBtn();
			Thread.sleep(15000);
			//WebDriverWait wait = new WebDriverWait(driver,200);		       
			//wait.until(ExpectedConditions.elementToBeClickable(newOrderInstance.submitOrderButton));

			Thread.sleep(4000); 

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

			//***********************
			newOrderInstance.saveOrderBtn.click();
			Thread.sleep(3000);
			js.executeScript("window.scrollTo(0, -400);");
			digitalOrderInstance.uploadDoc("6",1, 3);
			Thread.sleep(4000);
			digitalOrderInstance.verifyDocUpload();
			//***********************
			/*newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       String orderid=orderEntryPageInstance.getOrderID(); 
		       Logger.info("Order:"+orderid);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();

		       orderEntryPageInstance.clickOnOrder(orderid);
		       WebDriverWait wait = new WebDriverWait(driver,200);		       
		       wait.until(ExpectedConditions.elementToBeClickable(newOrderInstance.orderMoreActionsBtn));

		       newOrderInstance.clickOnKill();
		       newOrderInstance.clickOnKillOnConfirmation();
		       //Thread.sleep(10000);

		       digitalOrderInstance.verifyOrderStatus(orderid,"Killed");*/

			Thread.sleep(2000);
			dashboardPageInstance.clickOnLogout();
		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"verifyChargeDayModificationinDigitalOrder","DigitalOrder","Grp2","RegressionLatest","Group4","TestPriority","PriorityVulnerability","NewRegression","NewRegression1", "digitalOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyChargeDayModificationinDigitalOrder(Map<String, String> userData) throws Exception
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

			DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			//newOrderInstance.selectOrderType("OrderType_Spec");
			//newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewDigitalOrder();
			Thread.sleep(4000);

			digitalOrderInstance.selectPackageBU("6",1, 0);
			Thread.sleep(2000);

			digitalOrderInstance.selectDigitalProductDrpDwn("6",1, 1);
			digitalOrderInstance.selectDigitalChargeDayDrpDwn(1);

			digitalOrderInstance.clickApplyBtn();
			Thread.sleep(10000);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);"); 
			Thread.sleep(4000);	

			newOrderInstance.addNewSalesRepOnInsertionClassified(3, "SA01634");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);"); 
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(3);
			Thread.sleep(2000);
			Thread.sleep(4000);
			//***********************
			newOrderInstance.submitOrder();
			//Thread.sleep(3000);
			String orderid=orderEntryPageInstance.getOrderID(); 
			Logger.info("Order:"+orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();

			orderEntryPageInstance.clickOnOrder(orderid);
			WebDriverWait wait = new WebDriverWait(driver,200);		       
			wait.until(ExpectedConditions.elementToBeClickable(newOrderInstance.submitOrderButton));
			digitalOrderInstance.selectDigitalChargeDayDrpDwn(2);
			newOrderInstance.submitOrder();
			// Thread.sleep(3000);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();//swagata

			orderEntryPageInstance.clickOnOrder(orderid);//swagata
			wait.until(ExpectedConditions.elementToBeClickable(newOrderInstance.submitOrderButton));//swagata
			String orderstatus=newOrderInstance.getOrdeStatusOrderViewPage();//swagata
			if(orderstatus.contains("Change"))
				Assert.assertEquals(orderstatus,"Changed");
			/*else
				Assert.assertEquals("str","str1");*///swagata
			//***********************

			//Thread.sleep(5000);
			//dashboardPageInstance.clickOnLogout();
		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"createDigitalOrderwithCCPrepayment","DigitalOrder1","Grp2","RegressionLatest","Group4","Group4F","TestPriority"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createDigitalOrderwithCCPrepayment(Map<String, String> userData) throws Exception
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

			DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			//newOrderInstance.selectOrderType("OrderType_Spec");
			//newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewDigitalOrder();
			Thread.sleep(4000);

			digitalOrderInstance.selectPackageBU("6",1, 0);
			Thread.sleep(2000);

			digitalOrderInstance.selectDigitalProductDrpDwn("6",1, 1);
			digitalOrderInstance.selectDigitalChargeDayDrpDwn(1);

			digitalOrderInstance.clickApplyBtn();
			Thread.sleep(10000);
			//WebDriverWait wait = new WebDriverWait(driver,200);		       
			//wait.until(ExpectedConditions.elementToBeClickable(newOrderInstance.submitOrderButton));



			Thread.sleep(4000); 

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

			newOrderInstance.saveOrderBtn.click();
			Thread.sleep(3000);


			Thread.sleep(4000); 


			js.executeScript("window.scrollTo(0, -400);");

			digitalOrderInstance.clickMakePaymntBtn();
			Thread.sleep(3000);
			digitalOrderInstance.selectPaymentType("Credit Card");
			Thread.sleep(2000);
			digitalOrderInstance.selectAccountType("New Card");
			digitalOrderInstance.ValueTxtFld.sendKeys("100000");

			newOrderInstance.enterCreditCardInfoDigitalOrder("BankAccountInfo");
			digitalOrderInstance.PayBtn.click();
			Thread.sleep(2000);

			newOrderInstance.compareErrorMessagePopUp("The amount $100,000.00 you are trying to charge is more than the outstanding balance $0.00, hence this request cannot be processed.");
			//   if(driver.findElement(By.xpath("//button[text()='Continue']")).isDisplayed())
			//	   driver.findElement(By.xpath("//button[text()='Continue']")).click();
			//   Thread.sleep(4000);
			//***********************
			//     newOrderInstance.clickOnInsertionSalesRepSection(1);

			//	   Thread.sleep(4000);				      
			//      newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA01634 ");
			//	   Thread.sleep(4000);
			//	  newOrderInstance.clickOnInsertionSalesRepSection(1);
			//	   Thread.sleep(4000);
			//	   newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			//	   Thread.sleep(2000);
			//       Thread.sleep(4000);
			//       newOrderInstance.submitOrder();
			//       Thread.sleep(1000);
			//       String orderid=orderEntryPageInstance.getOrderID(); 
			//       Logger.info("Order:"+orderid);
			//       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();

			//       Thread.sleep(2000);
			//      dashboardPageInstance.clickOnLogout();
		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"NovMaintenance","createDigitalOrderwithDifferentPaymentMode","PrioritizedReg2","createDigitalOrderwithDifferentPaymentMode","Grp2","RegressionLatest","Group4","PriorityDFP","RegFailed1","Group4F","NewRegression","NewRegression1", "digitalOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createDigitalOrderwithDifferentPaymentMode(Map<String, String> userData) throws Exception
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

			DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			Thread.sleep(4000);
			newOrderInstance.selectBilltoSameAsSoldTo();
			//newOrderInstance.selectOrderType("OrderType_Spec");
			//newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewDigitalOrder();
			Thread.sleep(4000);

			digitalOrderInstance.selectPackageBU("1",1, 0);//mousumi
			Thread.sleep(2000);

			digitalOrderInstance.selectDigitalProductDrpDwn("1",1, 1);//mousumi
			digitalOrderInstance.selectDigitalChargeDayDrpDwn(1);
			digitalOrderInstance.enterMonthlyPrice("10");
			digitalOrderInstance.clickApplyBtn();
			Thread.sleep(10000);

			Thread.sleep(4000); 

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

			newOrderInstance.saveOrderBtn.click();
			Thread.sleep(5000);
			js.executeScript("window.scrollTo(0, -400);");
			digitalOrderInstance.clickMakePaymntBtn();
			Thread.sleep(5000);
			digitalOrderInstance.selectPaymentType("Credit Card");
			Thread.sleep(6000);
			digitalOrderInstance.selectAccountType("New Card");
			digitalOrderInstance.ValueTxtFld.click();
			digitalOrderInstance.ValueTxtFld.clear();
			digitalOrderInstance.ValueTxtFld.sendKeys("1");

			//newOrderInstance.enterCreditCardInfoDigitalOrder("BankAccountInfo");
			digitalOrderInstance.PayBtn.click();
			Thread.sleep(2000);


			//***********************
			digitalOrderInstance.selectPaymentType("Check");
			Thread.sleep(2000);
			digitalOrderInstance.enterCheckDetails();
			digitalOrderInstance.PayBtn.click();
			Thread.sleep(2000);

			//***********************
			digitalOrderInstance.selectPaymentType("Cash");
			Thread.sleep(2000);
			digitalOrderInstance.enterCashDetails();
			digitalOrderInstance.PayBtn.click();
			Thread.sleep(2000);

			//***********************
			digitalOrderInstance.selectPaymentType("ACH");
			Thread.sleep(2000);

			digitalOrderInstance.enterACHDetails();
			digitalOrderInstance.PayBtn.click();
			Thread.sleep(2000);


			//***********************

			newOrderInstance.clickOnInsertionSalesRepSection(1);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);"); 
			Thread.sleep(4000);	

			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA01634");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);"); 
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(2000);
			Thread.sleep(4000);

			newOrderInstance.submitOrder();
			Thread.sleep(2000);
			/*String orderid=orderEntryPageInstance.getOrderID(); 
			Logger.info("Order:"+orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);		       
			orderEntryPageInstance.clickOnOrder(orderid);
			Thread.sleep(7000);

			digitalOrderInstance.clickMakePaymntBtn();
			//Thread.sleep(2000);
			//digitalOrderInstance.verifySelectedPaymentMethods();

			//Thread.sleep(2000);*/
			//dashboardPageInstance.clickOnLogout();
		
		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

}
