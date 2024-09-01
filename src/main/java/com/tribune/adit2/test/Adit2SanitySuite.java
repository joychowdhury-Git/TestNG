package com.tribune.adit2.test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.tribune.adit2.Customers.CustomerCreatePage;
import com.tribune.adit2.Customers.CustomerPage;
import com.tribune.adit2.Customers.CustomerProfilePage;
import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.ClassifiedOrderOptions;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

import junit.framework.Assert;

public class Adit2SanitySuite {
	
	/*
	 * Display order with cash customer
	 * Used in production display scenario
	 * 
	 *///swagata
	@Test(priority=2,groups = { "Order", "PrdSanityNew"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderSanity(Map<String, String> userData) throws Exception {
		try {
				WebDriver driver = WebDriverManager.getDriver();
				Logger.info("Webdriver is initiated");

				TribuneUtils utilities = new TribuneUtils();
				utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
				utilities.implementWait(driver);
				//Thread.sleep(50000);

				SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
				signinPageinstance.loginWithProperty("success");

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
				newOrderInstance.selectBU("1",17, 0);
				Thread.sleep(4000);
				newOrderInstance.enterPubDateFromExcel("1",17,27);
				Thread.sleep(5000);
				newOrderInstance.selectProductType("1",17, 1);
				Thread.sleep(4000);
				newOrderInstance.selectProduct("1",17, 2);
				Thread.sleep(4000);
				newOrderInstance.viewInsertionDetails("1");
				Thread.sleep(4000);
				newOrderInstance.clickOnInsertionSalesRepSection(1);
				Thread.sleep(4000);				      
				newOrderInstance.addNewSalesRepOnInsertion(1, "SA02907");
				Thread.sleep(4000);
				/*newOrderInstance.clickOnInsertionSalesRepSection(1);
				Thread.sleep(4000);
				newOrderInstance.applytoAllSalesRepOnInsertion(1);
				Thread.sleep(2000);
				Thread.sleep(4000);*/
				newOrderInstance.submitOrder();
				//newOrderInstance.clickOnwarningConfirmation();
                String orderID = orderEntryPageInstance.getOrderNumber();
				Logger.info(orderEntryPageInstance.getOrderID());
				orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
				Thread.sleep(1000);

				orderEntryPageInstance.clickOnOrder(orderID);
				 Logger.info("Order No. is:"+orderID);//swagata
			      /* orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			       Thread.sleep(2000);*/
				  /*WebDriverWait wait = new WebDriverWait(driver,120);
					WebElement orderNumberLink = driver.findElement(By.xpath("//span[text()='Order: '"+orderID+""+"']"));
					wait.until(ExpectedConditions.visibilityOf(orderNumberLink));
					if(orderNumberLink.isDisplayed())
					{
						Assert.assertTrue(true);
						Logger.info(orderID+ " order search result validated successfully");
						Thread.sleep(2000);
					}*/
		
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)						
        			.withTimeout(500, TimeUnit.SECONDS) 			
        			.pollingEvery(2, TimeUnit.SECONDS) 			
        			.ignoring(NoSuchElementException.class);	
        	WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){
        	
        		public WebElement apply(WebDriver driver ) {
        			return 	driver.findElement(By.xpath("//span[text()='Processed ']"));

        		}
        	});
			Thread.sleep(4000);
        	String orderStatusProcessed = newOrderInstance.getOrdeStatusOrderViewPage();
			Logger.info("orderStatus "+orderStatusProcessed);
			/*if(orderStatusProcessed=="Processed")
			{
			newOrderInstance.clickOnKill();
			Thread.sleep(8000);
			}*/
			newOrderInstance.clickOnKill();
			Thread.sleep(8000);
					newOrderInstance.clickOnKillOnConfirmation();
					Thread.sleep(8000);			
					String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
					Logger.info("orderStatus "+orderStatus);
					driver.navigate().refresh();
					Thread.sleep(4000);
			      

				dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/*
	 * Used in production Classified order scenario
	 *///swagata

	@Test(priority=3,groups = {"NewClassifiedOrderSanity","CICDStage","CICDQa","CICDProd","PrdSanityNew","Partha1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void NewClassifiedOrderSanity(Map<String, String> userData) throws Exception
	{
		try
		{
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");			   			   

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);
			//Thread.sleep(10000);
			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.loginWithProperty("success");
			Thread.sleep(4000);
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
			Thread.sleep(4000);
			classifiedOrderInstance.selectDate("nextmonth");
		
			classifiedOrderInstance.selectSingleZone();		       
			classifiedOrderInstance.clickApplyBtn();
			Thread.sleep(5000);

			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(7000);
			classifiedOrderInstance.enterDetailsInAdMaterialObit();


			Thread.sleep(7000);	

			classifiedOrderInstance.enterAttributeDetailsObitTBS();	
			Thread.sleep(3000);


			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : "+orderNumber);
			//  classifiedOrderInstance.uploadAd("1",14,6);

			Thread.sleep(3000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();

			Thread.sleep(1000);

			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info("Order No. is:"+orderID);//swagata
			//Logger.info(orderEntryPageInstance.getOrderID());//swagata
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);

			Logger.info("Order No. is:"+orderID);//swagata
			/* orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
				       Thread.sleep(2000);*/
			
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)						
             			.withTimeout(500, TimeUnit.SECONDS) 			
             			.pollingEvery(2, TimeUnit.SECONDS) 			
             			.ignoring(NoSuchElementException.class);	
             	WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){
             	
             		public WebElement apply(WebDriver driver ) {
             			return 	driver.findElement(By.xpath("//span[text()='Processed ']"));

             		}
             	});
    			Thread.sleep(4000);
             	String orderStatusProcessed = newOrderInstance.getOrdeStatusOrderViewPage();
    			Logger.info("orderStatus "+orderStatusProcessed);
    			/*if(orderStatusProcessed=="Processed")
    			{
    			newOrderInstance.clickOnKill();
    			Thread.sleep(8000);
    			}*///need to update
			/*WebDriverWait wait = new WebDriverWait(driver,120);
						WebElement orderNumberLink = driver.findElement(By.xpath("//span[text()='Order: '"+orderID+""+"']"));
						wait.until(ExpectedConditions.visibilityOf(orderNumberLink));
						if(orderNumberLink.isDisplayed())
						{
							Assert.assertTrue(true);
							Logger.info(orderID+ " order search result validated successfully");
							Thread.sleep(2000);
						}*/

    			newOrderInstance.clickOnKill();
    			Thread.sleep(8000);
			newOrderInstance.clickOnKillOnConfirmation();
			Thread.sleep(8000);			
			String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
			Logger.info("orderStatus "+orderStatus);
			driver.navigate().refresh();
			Thread.sleep(4000);

			dashboardPageInstance.clickOnLogout();
		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/*
	 * Create preprint order for sanity.
	 * preprintordersanity updated on 20th jan
	 */
	@Test(priority=1,groups = {"preprintOrderSanity","CICDStage","CICDQa","CICDProd","PrdSanityNew","Partha2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderSanity(Map<String, String> userData) throws Exception
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
			//newOrderInstance.clickOnContinuePastDeadlineDate();
			
			String orderID = orderEntryPageInstance.getOrderID();
			Logger.info("Order ID: " + orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			/*String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info("Order No. is:"+orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();*/
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);//swagata
			Thread.sleep(3000);
			newOrderInstance.killOrderNonProd();
			newOrderInstance.clickOnContinuePastDeadlineDate();
			Thread.sleep(3000);
			dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(priority=1,groups = {"preprintOrderSanity","CICDStage","PrdSanityNew"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderSanity2(Map<String, String> userData) throws Exception
	{
		try
		{
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.loginWithProperty("success");

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
			newOrderInstance.checkUncheckOwnLocalOptOut(true);
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
			   //newOrderInstance.clickOnContinuePastDeadlineDate();
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info("Order No. is:"+orderID);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);//swagata
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)						
         			.withTimeout(500, TimeUnit.SECONDS) 			
         			.pollingEvery(2, TimeUnit.SECONDS) 			
         			.ignoring(NoSuchElementException.class);	
         	WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){
         	
         		public WebElement apply(WebDriver driver ) {
         			return 	driver.findElement(By.xpath("//span[text()='Processed ']"));

         		}
         	});
			Thread.sleep(4000);
         	String orderStatusProcessed = newOrderInstance.getOrdeStatusOrderViewPage();
			Logger.info("orderStatus "+orderStatusProcessed);
			/*if(orderStatusProcessed=="Processed")
			{
			newOrderInstance.clickOnKill();
			Thread.sleep(8000);
			}*///need to update
		/*WebDriverWait wait = new WebDriverWait(driver,120);
					WebElement orderNumberLink = driver.findElement(By.xpath("//span[text()='Order: '"+orderID+""+"']"));
					wait.until(ExpectedConditions.visibilityOf(orderNumberLink));
					if(orderNumberLink.isDisplayed())
					{
						Assert.assertTrue(true);
						Logger.info(orderID+ " order search result validated successfully");
						Thread.sleep(2000);
					}*/

			newOrderInstance.clickOnKill();
			Thread.sleep(8000);
		newOrderInstance.clickOnKillOnConfirmation();
		Thread.sleep(8000);			
		String orderStatus = newOrderInstance.getOrdeStatusOrderViewPage();
		Logger.info("orderStatus "+orderStatus);
		driver.navigate().refresh();
		Thread.sleep(4000);

		dashboardPageInstance.clickOnLogout();

		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/*
	 * Used in production customer scenario
	 *///swagata
	@Test(priority=4,groups = { "createNewCustomer","CICDStage", "CICDQa", "CICDProd","Partha3" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData", invocationCount = 1)
	public void createNewCustomer(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);
			//Thread.sleep(50000);
			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.loginWithProperty("success");
			Thread.sleep(3000);
			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage viewCustomer = PageFactory.initElements(driver, CustomerPage.class);
			TribuneUtils utils = new TribuneUtils();
			viewCustomer.clickOnNewCustomerBtn();
			Thread.sleep(3000);
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			String str = utils.generateRandomString(15);
			customerCreate.enterCustomerName(str + " Auto");
			customerCreate.selectBillingType("Value");
			//customerCreate.selectBU("CTC-CTMG");
			//customerCreate.selectBU("New York Daily News");//joy
			customerCreate.selectBU("NDN-New York Daily News");
			customerCreate.enteralternativeNameTextBox("sdtsmoketest");
			customerCreate.selectAccountType("Advertiser");
			customerCreate.selectCategory("Retail");
			customerCreate.selectSubCategory("Internet Sites");
			customerCreate.enterwebsiteTextBox("smoketest.com");
			customerCreate.entercouponCodeTextBox("CPN100");
			//customerCreate.enterTermsEmail("smoketest@tronc.com");
			customerCreate.enterTermsEmail("jbiswas@tribpub.com");//swagata
			Thread.sleep(3000);
			customerCreate.tearsheetCheckBoxPresenceValidation();
			customerCreate.taxExemptCheckBoxaPresencValidation();
			customerCreate.isOrderConfirmationRequiredCheckBoxPresenceValidation();
			customerCreate.autoCommissionCheckBoxPresenceValidation();
			customerCreate.applySpoilageCheckBoxPresenceValidation();
			customerCreate.supplementalDataSectionPresenceValidation();
			customerCreate.companyRevenueTextBoxPresenceValidation();
			customerCreate.numOfEmployeeTextBox();
			customerCreate.numOflocationsTextBox();
			customerCreate.dunsNumTextBox();
			customerCreate.infoUsaNumTextBox();
			customerCreate.checkDefaultProofValue();
			customerCreate.isPORequiredCheckBoxPresenceValidation();
			customerCreate.IsSelfServiceLocAllowedCheckBoxPresenceValidation();
			customerCreate.notesTextBox();
			customerCreate.clickOnNewAddressBtnBtn();
			Thread.sleep(4000);
			customerCreate.entercontactName(str + " Auto");
			customerCreate.selectAddressType("RMS");
			customerCreate.enteraddressTextBox("435 N Michigan Ave");
			customerCreate.enteraddress2TextBox("Auto Test");
			customerCreate.entercityTextBox("Chicago");
			customerCreate.selectState("Illinois");
			customerCreate.enterzipCodeTextBox("60611");
			customerCreate.selectCountry("The United States of America");
			customerCreate.enterphoneNumberTextBox("3124444444");
			customerCreate.enterfaxNumberTextBox("3125555555");
			customerCreate.enteremailAddressTextBox("tes123@tronc.com");
			customerCreate.enteradditionalEmailTextBox("smoke2@test.com");
			customerCreate.isPrimaryCheckBoxPresenceValidation();
			customerCreate.clickOnSaveBtn();
			Thread.sleep(5000);
			
			customerCreate.clickOnCustomerSaveBtn();
			Thread.sleep(10000);
		
			customerCreate.clickOnNextBtn();
			//Thread.sleep(70000);
		
			customerCreate.clickOnselectBtn();
			//Thread.sleep(50000);

			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);
			profileCustomer.getCustomerID();
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber());

			Assert.assertEquals(str + " Auto", profileCustomer.getCustomerName());
			
			//dashboardPageInstance.clickOnLogout();//swagata
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"Order", "PrdSanityNew", "displayOrderSanity","CICDStage","CICDQa","CICDProd","Partha4"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderSanityDpr(Map<String, String> userData) throws Exception
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
	
	
}
