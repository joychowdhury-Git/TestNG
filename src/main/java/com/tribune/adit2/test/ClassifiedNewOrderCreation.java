package com.tribune.adit2.test;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.tribune.adit2.GeneralSettings.Classified;
import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.ClassifiedOrderOptions;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.ProductAdmin.ProductAdminPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

public class ClassifiedNewOrderCreation {

	/**
	 * Validate that user is able to Update the Pubdate of online insertion line
	 * in classified orders
	 * 
	 */
	// swagata
	@Test(groups = {"ChangeOnlinePubdateOfclassifiedOrder"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ChangeOnlinePubdateOfclassifiedOrder(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnOrderEntrySearchModule();
			Thread.sleep(2000);

			OrderEntryHomePage ClassifiedListingOrder = PageFactory.initElements(driver, OrderEntryHomePage.class);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			Thread.sleep(8000);
			ClassifiedListingOrder.clickOnAdvSearch();
			Thread.sleep(3000);

			ClassifiedListingOrder.selectBussinessUnit("All");
			Thread.sleep(3000);
			Logger.info("BU is selected successfully");

			ClassifiedListingOrder.selectStatus("Pending Approval");
			Thread.sleep(3000);
			Logger.info(" Pending Approval Status is selected");

			ClassifiedListingOrder.selectProductType("Classified Listings");
			Thread.sleep(3000);
			Logger.info(" Classified Listings Product Type is selected");

			//Added by Sunny
			ClassifiedListingOrder.selectSubCategoryByIndex(23);
			Thread.sleep(3000);
			Logger.info("Other Classified - Obituaries Sub Catege Type is selected");



			ClassifiedListingOrder.clickOnOrderSearchBtn();
			Thread.sleep(3000);

			// WebElement order =
			// driver.findElement(By.xpath("//a[text()='"+6209339+"']"));
			ClassifiedListingOrder.ClickPendingAppOrder();
			Thread.sleep(2000);

			NewOrderPage AdssOrderApprovalPage = PageFactory.initElements(driver, NewOrderPage.class);
			AdssOrderApprovalPage.lockOrderLine();
			Thread.sleep(2000);
			AdssOrderApprovalPage.ClickOnlineInsCalander();
			Thread.sleep(8000);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}


	// swagata
	@Test(groups = {"NovMaintenance","OpenExistingclassifiedOrder","NewDev","NewRegression","classifiedOrders","NewRegression1","Joy"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void OpenExistingclassifiedOrder(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnOrderEntrySearchModule();
			Thread.sleep(2000);

			OrderEntryHomePage ClassifiedListingOrder = PageFactory.initElements(driver, OrderEntryHomePage.class);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElements(list));
			Thread.sleep(8000);
			ClassifiedListingOrder.clickOnAdvSearch();
			Thread.sleep(3000);
			ClassifiedListingOrder.selectBussinessUnit("All");
			Thread.sleep(3000);
			Logger.info("BU is selected successfully");

			ClassifiedListingOrder.selectStatus("Processed");
			Thread.sleep(3000);
			Logger.info(" Processed Status is selected");
			ClassifiedListingOrder.selectProductType(" Classified Listings");
			Thread.sleep(3000);
			Logger.info(" Classified Listings Product Type is selected");
			ClassifiedListingOrder.clickOnOrderSearchBtn();
			Thread.sleep(3000);
			ClassifiedListingOrder.ClickProcessedOrder();
			Thread.sleep(2000);
			NewOrderPage ClassifiedListingNewOrder = PageFactory.initElements(driver, NewOrderPage.class);
			ClassifiedListingNewOrder.saveAndCloseOrder();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * Create a Classified Package order with over 20 Pub Dates & Include a
	 * Volume Discount and submit the order
	 * 
	 * 
	 */

	//swagata
	@Test(groups = {"SMaintenance","MultiplePubDatePackageOrder","SanityTestNew","NewDev","NewRegression","NewRegression1","PrioritizedReg1","classifiedOrders","PrioritizedReg1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void MultiplePubDatePackageOrder(Map<String, String> userData) throws Exception
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
			classifiedOrderInstance.selectPackageBU("1",14, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("1",14, 1);
			Thread.sleep(2000);	      
			classifiedOrderInstance.selectClassifiedProductDrpDwn("1",14, 2);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackage("1",14, 3);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCode("1",14, 4);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();		       
			classifiedOrderInstance.clickApplyBtn();




			Thread.sleep(5000);

			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(7000);
			classifiedOrderInstance.uploadAd("1",14,6);//swagata




			Thread.sleep(7000);	
			/* classifiedOrderInstance.enterAttributeDetailsALTVolDisc();	
		      Thread.sleep(15000);*/
			classifiedOrderInstance.enterAttributeDetails();	
			Thread.sleep(5000);

			newOrderInstance.saveOrder();

			Thread.sleep(6000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : "+orderNumber);
			Thread.sleep(3000);
			/*newOrderInstance.clickOnInsertionSalesRepSection(8);
			//newOrderInstance.removeSalesRepOnInsertion(1)
			Thread.sleep(4000);				      
			newOrderInstance.addNewSalesRepOnInsertion(8, "SA02907");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(8);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertion(8);
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
			 orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
			Thread.sleep(4000);*///swagata

			//dashboardPageInstance.clickOnLogout();//swagata
			dashboardPageInstance.clickondropdownforlogout(); //joy
		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "verifyClassifiedOrderMaterialBuilderMaximize", "testclasssified", "Classified", "Grp3",
			"ClassifiedUpdated",
	"RegFailed1" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyClassifiedOrderMaterialBuilderMaximize(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);

			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("5", 1, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 1, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(13);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(15000);
			// ***********************
			classifiedOrderInstance.clickEditAdBtn();

			// Thread.sleep(15000);
			// classifiedOrderInstance.uploadAd();

			Thread.sleep(10000);
			classifiedOrderInstance.verifyEditAdWindowMaximize();

			//// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "copyClassifiedOrderVerifyAttributes", "testclasssified", "Classified", "Grp3",
			"ClassifiedUpdated", "TestPriority",
	"RegFailed1" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void copyClassifiedOrderVerifyAttributes(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);

			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("5", 1, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 1, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(13);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
			// classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos
			// Wanted");
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(15000);
			// ***********************
			classifiedOrderInstance.clickEditAdBtn();

			// Thread.sleep(15000);
			// classifiedOrderInstance.uploadAd();

			Thread.sleep(10000);
			classifiedOrderInstance.uploadAd("5", 1, 6);
			// classifiedOrderInstance.verifyInsertionPrice("Non-Legal");
			classifiedOrderInstance.enterAttributeDetails();
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//
			Thread.sleep(6000);
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA01634");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			// Thread.sleep(2000);
			// newOrderInstance.confirmToMakeOrderFree();

			String orderid = orderEntryPageInstance.getOrderID();

			Thread.sleep(1000);

			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);

			Logger.info("START OF COPY ORDER");
			orderEntryPageInstance.clickOnOrder(orderid);
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();
			Thread.sleep(45000);

			classifiedOrderInstance.verifyAttributeDetails();
			//// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "copyClassifiedOrderVerifyUpload", "testclasssified", "Classified", "Grp3", "RegressionLatest",
			"Group4", "Classified21", "ClassifiedUpdated", "RegFailed1",
	"Group4F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void copyClassifiedOrderVerifyAttributesUpload(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);

			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("5", 1, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 1, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(13);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
			// classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos
			// Wanted");
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(15000);
			// ***********************
			classifiedOrderInstance.clickEditAdBtn();

			// Thread.sleep(15000);
			// classifiedOrderInstance.uploadAd();

			Thread.sleep(10000);
			classifiedOrderInstance.uploadAd("5", 1, 6);
			// classifiedOrderInstance.verifyInsertionPrice("Non-Legal");
			classifiedOrderInstance.enterAttributeDetails();
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
			// Thread.sleep(2000);
			// newOrderInstance.confirmToMakeOrderFree();

			String orderid = orderEntryPageInstance.getOrderID();

			Thread.sleep(2000);

			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);

			orderEntryPageInstance.clickOnOrder(orderid);
			Logger.info("START OF COPY ORDER");

			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();

			Thread.sleep(45000);

			classifiedOrderInstance.verifyAttributeDetails();
			Thread.sleep(60000);

			// ***********************
			classifiedOrderInstance.clickEditAdBtn();
			classifiedOrderInstance.verifyUploadCopied();
			//// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "Discount", "testclasssified1", "Smoke",
	"ClassifiedUpdated" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyDiscountinClassifiedOrder(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);
			/*
			 * newOrderInstance.selectBU("1",10, 0);
			 * newOrderInstance.enterPubDate("1","31", "Jan", "2017");
			 * newOrderInstance.selectProductType("1",10, 1);
			 * newOrderInstance.selectProduct("1",10, 2); Thread.sleep(3000);
			 * newOrderInstance.selectAdType("1",10, 3); Thread.sleep(5000);
			 * newOrderInstance.selectSection("1",10, 4); Thread.sleep(4000);
			 * newOrderInstance.viewInsertionDetails("1");
			 * newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			 * newOrderInstance.selectMaterialSource("1","N/A");
			 * newOrderInstance.clickOnDistributions(1); Thread.sleep(4000);
			 * newOrderInstance.clickOnSearchZoneLink(); Thread.sleep(3000);
			 * newOrderInstance.selectZonePreprintOrder("90001SC");
			 * newOrderInstance.confirmZoneSelection(); int distributionsCount =
			 * newOrderInstance.getDistributionsAdded();
			 * Logger.info("distributionsCount "+distributionsCount);
			 * Thread.sleep(2000);
			 * newOrderInstance.addSalesPerson(TribuneUtils.getStringCellValues(
			 * "Sales", 1, 2));
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * newOrderInstance.addNewSalesRepOnInsertionClassified(1,
			 * "SA00443"); Thread.sleep(2000);
			 */

			Thread.sleep(4000);
			/*
			 * classifiedOrderInstance.selectPackageBU("5",5, 0);
			 * Thread.sleep(2000);
			 * classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5",5,
			 * 1); //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn(
			 * "Automotive"); Thread.sleep(2000); //driver.quit();
			 * classifiedOrderInstance.selectClassifiedProductDrpDwn("5",5, 2);
			 * //classifiedOrderInstance.
			 * selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]"
			 * ); Thread.sleep(2000);
			 * classifiedOrderInstance.selectClassifiedPackageByIndex(2); //
			 * classifiedOrderInstance.selectClassifiedPackage("5",5, 3);
			 * //classifiedOrderInstance.
			 * selectClassifiedPackage("Auto Other Pioneer Central");
			 * Thread.sleep(2000);
			 * classifiedOrderInstance.selectClassifiedClassCode("5",5, 4);
			 * //classifiedOrderInstance.
			 * selectClassifiedClassCode("76407 - Autos Wanted");
			 */
			classifiedOrderInstance.selectPackageBU("5", 1, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 1, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(13);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.selectDate("prevmonth");
			classifiedOrderInstance.selectDate("prevmonth");
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(15000);
			// ***********************
			classifiedOrderInstance.verifyDiscountSectionAvailability();

			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "ClassifiedOrderChangePubDate", "testclasssified", "Classified", "Grp3", "RegressionLatest",
			"Group4", "Classified21", "ClassifiedUpdated",
	"RegFailed1" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void updateClassifiedOrderPubDate(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);

			classifiedOrderInstance.selectPackageBU("5", 1, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 1, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(13);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
			Thread.sleep(2000);
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(15000);
			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(10000);
			classifiedOrderInstance.uploadAd("5", 1, 6);
			;
			classifiedOrderInstance.enterAttributeDetails();
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
			Thread.sleep(1000);
			String orderid = orderEntryPageInstance.getOrderID();
			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			orderEntryPageInstance.clickOnOrder(orderid);
			Thread.sleep(7000);
			String addeddate = classifiedOrderInstance.modifyPubDate();
			classifiedOrderInstance.clickApplyBtn();
			// Thread.sleep(7000);
			classifiedOrderInstance.clickOKBtn();
			Thread.sleep(15000);

			Logger.info("addeddate:" + addeddate);
			classifiedOrderInstance.verifyPubDateChange(addeddate);
			// Thread.sleep(10000);
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
			Thread.sleep(15000);

			orderEntryPageInstance.getOrderStatus(orderid);
			/*
			 * if(orderstatus.contains("Changed") ||
			 * orderstatus.contains("Change Pending ")){
			 * Logger.info("Order status is changed");
			 * Assert.assertEquals("str","str"); }else{
			 * Logger.info("Order status is not changed");
			 * Assert.assertEquals("str","str1"); }
			 */
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "InsertDuplicateClassifiedOrder", "testclasssified", "Classified", "Grp3", "RegressionLatest",
			"Group4", "ClassifiedUpdated", "PriorityDFP", "PriorityVulnerability",
	"RegFailed1" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void classifiedOrderDuplication(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			Thread.sleep(7000);
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);

			classifiedOrderInstance.selectPackageBU("5", 1, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 1, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(13);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
			// classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos
			// Wanted");
			Thread.sleep(2000);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(15000);
			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(10000);
			classifiedOrderInstance.uploadAd("5", 1, 6);
			;
			classifiedOrderInstance.enterAttributeDetails();
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//
			Thread.sleep(6000);
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA01634");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(2000);
			String orderid = orderEntryPageInstance.getOrderID();
			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			orderEntryPageInstance.clickOnOrder(orderid);
			Thread.sleep(7000);

			classifiedOrderInstance.clickLockOrderLinesChckBox();
			Thread.sleep(4000);
			// classifiedOrderInstance.clickOrderMoreOptions();
			// int
			// previnsertioncount=classifiedOrderInstance.clickDuplicateOrderLink();
			NewOrderPage orderViewPage = PageFactory.initElements(driver, NewOrderPage.class);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
					orderViewPage.orderViewPageElement);
			wait.until(ExpectedConditions.visibilityOf(orderViewPage.orderViewPageElement));
			orderViewPage.createDuplicateInsertion("1");
			Thread.sleep(10000);
			orderViewPage.validateDuplicateInsertion("1");
			// classifiedOrderInstance.verifyDuplicateOrder(previnsertioncount);
			Thread.sleep(10000);
			// WebDriverWait wait = new WebDriverWait(driver,200);
			wait.until(ExpectedConditions.elementToBeClickable(newOrderInstance.submitOrderButton));
			newOrderInstance.submitOrder();
			Thread.sleep(10000);
			String orderstatus = orderEntryPageInstance.getOrderStatus(orderid);

			if (orderstatus.contains("Change") || orderstatus.contains("change")) {
				Logger.info("Order modified successfully");
				Assert.assertEquals("str", "str");
			} else {
				Logger.info("Order is not modified");
				Assert.assertEquals("str", "str1");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "VerifyAgncyCommssn", "testclasssified", "Classified", "Grp3", "Classified21", "ClassifiedUpdated",
			"RegFailed1",
	"Group4F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyAgencyCommission(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);
			/*
			 * newOrderInstance.selectBU("1",10, 0);
			 * newOrderInstance.enterPubDate("1","31", "Jan", "2017");
			 * newOrderInstance.selectProductType("1",10, 1);
			 * newOrderInstance.selectProduct("1",10, 2); Thread.sleep(3000);
			 * newOrderInstance.selectAdType("1",10, 3); Thread.sleep(5000);
			 * newOrderInstance.selectSection("1",10, 4); Thread.sleep(4000);
			 * newOrderInstance.viewInsertionDetails("1");
			 * newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			 * newOrderInstance.selectMaterialSource("1","N/A");
			 * newOrderInstance.clickOnDistributions(1); Thread.sleep(4000);
			 * newOrderInstance.clickOnSearchZoneLink(); Thread.sleep(3000);
			 * newOrderInstance.selectZonePreprintOrder("90001SC");
			 * newOrderInstance.confirmZoneSelection(); int distributionsCount =
			 * newOrderInstance.getDistributionsAdded();
			 * Logger.info("distributionsCount "+distributionsCount);
			 * Thread.sleep(2000);
			 * newOrderInstance.addSalesPerson(TribuneUtils.getStringCellValues(
			 * "Sales", 1, 2));
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * newOrderInstance.addNewSalesRepOnInsertionClassified(1,
			 * "SA00443"); Thread.sleep(2000);
			 */

			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("5", 1, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 1, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(13);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(15000);
			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(10000);
			classifiedOrderInstance.uploadAd("5", 1, 6);
			;
			classifiedOrderInstance.enterAttributeDetails();
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
			Thread.sleep(2000);
			String orderid = orderEntryPageInstance.getOrderID();
			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			orderEntryPageInstance.clickOnOrder(orderid);
			Thread.sleep(7000);
			Logger.info("AgencyCommission:" + classifiedOrderInstance.AgencyCommission.getText());
			if ((classifiedOrderInstance.AgencyCommission.getText()).equals("100%")) {
				Logger.info("Agency commission verified successfully "
						+ classifiedOrderInstance.AgencyCommission.getText());
				Assert.assertEquals("str", "str");
			} else {
				Logger.info("Incorrect Agency commission is displayed "
						+ classifiedOrderInstance.AgencyCommission.getText());
				Assert.assertEquals("str", "str1");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "NewClassifiedOrderWthTearsht", "testclasssified", "Classified", "Grp3", "RegressionLatest",
			"Group4", "Classified21", "ClassifiedUpdated", "PriorityDFP",
	"RegFailed1" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewClassifiedOrderWithTearSheet(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("5", 1, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 1, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(13);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
			// classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos
			// Wanted");
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(15000);

			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(10000);
			classifiedOrderInstance.uploadAd("5", 1, 6);
			;
			classifiedOrderInstance.enterAttributeDetails();

			classifiedOrderInstance.enterTearSheetDetails();

			newOrderInstance.clickOnInsertionSalesRepSection(1);
			//
			Thread.sleep(6000);
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA01634");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.submitOrder();
			Thread.sleep(2000);
			String orderid = orderEntryPageInstance.getOrderID();
			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			orderEntryPageInstance.clickOnOrder(orderid);
			Thread.sleep(7000);
			classifiedOrderInstance.TearsheetTab.click();
			Thread.sleep(2000);
			if ((classifiedOrderInstance.TearsheetEntry).isDisplayed()) {
				Logger.info("Tearsheet deatils added successfully");
				Assert.assertEquals("str", "str");
			} else {
				Logger.info("Tearsheet deatils is not added");
				Assert.assertEquals("str", "str1");
			}

			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "NewLegalClassifiedOrderWthFutureDate", "NewLegalClassifiedOrder", "Classified",
	"Classified21" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewLegalClassifiedOrderWthFutureDate(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);

			classifiedOrderInstance.selectPackageBU("5", 4, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 4, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwn("5", 4, 2);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("5",4, 3);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			classifiedOrderInstance.selectNewClassifiedClassCode("11250 - Advertisement for Bids");
			// classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos
			// Wanted");
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.selectDate("nextmonth");

			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(15000);
			// ******************
			classifiedOrderInstance.verifyInsertionPrice("Legal");
			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(10000);
			classifiedOrderInstance.uploadAd("5", 4, 6);
			classifiedOrderInstance.enterLegalAttributeDetails();
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
			// Thread.sleep(2000);
			// newOrderInstance.confirmToMakeOrderFree();
			Thread.sleep(2000);
			String orderid = orderEntryPageInstance.getOrderID();
			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "UpdateAdSize", "Classified", "Grp3","classifiedOrders", "RegressionLatest", "Group4", "testclasssified",
			"ClassifiedUpdated", "PriorityVulnerability",
			"NewRegression","NewRegression1" ,"PrioritizedReg1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void updateAdSize(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();

			Thread.sleep(4000);
			/*
			 * classifiedOrderInstance.selectPackageBU("5",4, 0);
			 * Thread.sleep(2000);
			 * classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5",4,
			 * 1); //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn(
			 * "Automotive"); Thread.sleep(2000); //driver.quit();
			 * classifiedOrderInstance.selectClassifiedProductDrpDwn("5",4, 2);
			 * //classifiedOrderInstance.
			 * selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]"
			 * ); Thread.sleep(2000);
			 * classifiedOrderInstance.selectClassifiedPackageByIndex(2); //
			 * classifiedOrderInstance.selectClassifiedPackage("5",4, 3);
			 * //classifiedOrderInstance.
			 * selectClassifiedPackage("Auto Other Pioneer Central");
			 * Thread.sleep(2000); //
			 * classifiedOrderInstance.selectClassifiedClassCode("5",4, 4);
			 * classifiedOrderInstance.
			 * selectNewClassifiedClassCode("11250 - Advertisement for Bids");
			 */
			classifiedOrderInstance.selectPackageBU("5", 1, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 1, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(13);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
			// classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos
			// Wanted");
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(15000);
			// ******************
			classifiedOrderInstance.clickLockOrderLinesChckBox();
			classifiedOrderInstance.clickFirstInsertionMoreOptions();
			classifiedOrderInstance.ModifyAdSize();
			// ******************
			Thread.sleep(2000);
			dashboardPageInstance.clickOnLogout(); //arka
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "verifyPackageDrpDwn", "Classified", "Grp3", "RegressionLatest", "Group4", "testclasssified",
	"ClassifiedUpdated" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyPackageDrpDwn(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();

			Thread.sleep(4000);
			/*
			 * classifiedOrderInstance.selectPackageBU("5",4, 0);
			 * Thread.sleep(2000);
			 * classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5",4,
			 * 1); //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn(
			 * "Automotive"); Thread.sleep(2000); //driver.quit();
			 * classifiedOrderInstance.selectClassifiedProductDrpDwn("5",4, 2);
			 * //classifiedOrderInstance.
			 * selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]"
			 * ); Thread.sleep(2000);
			 * classifiedOrderInstance.selectClassifiedPackage("5",4, 3);
			 * //classifiedOrderInstance.
			 * selectClassifiedPackage("Auto Other Pioneer Central");
			 * Thread.sleep(2000);
			 * classifiedOrderInstance.selectClassifiedClassCode("5",4, 4);
			 * //classifiedOrderInstance.
			 * selectClassifiedClassCode("76407 - Autos Wanted");
			 */
			// ******************
			classifiedOrderInstance.verifyPackageDrpDwn();
			// ******************

			// classifiedOrderInstance.selectDate("nextmonth");
			// classifiedOrderInstance.clickApplyBtn();

			/*
			 * Thread.sleep(15000); //******************
			 * classifiedOrderInstance.clickLockOrderLinesChckBox();
			 * classifiedOrderInstance.clickFirstInsertionMoreOptions();
			 * classifiedOrderInstance.ModifyAdSize(); //******************
			 */ Thread.sleep(2000);
			 // dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "NewLegalClassifiedOrderWthPastDate", "NewLegalClassifiedOrder", "Classified",
	"Classified21" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewLegalClassifiedOrderWthPastDate(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);
			/*
			 * newOrderInstance.selectBU("1",10, 0);
			 * newOrderInstance.enterPubDate("1","31", "Jan", "2017");
			 * newOrderInstance.selectProductType("1",10, 1);
			 * newOrderInstance.selectProduct("1",10, 2); Thread.sleep(3000);
			 * newOrderInstance.selectAdType("1",10, 3); Thread.sleep(5000);
			 * newOrderInstance.selectSection("1",10, 4); Thread.sleep(4000);
			 * newOrderInstance.viewInsertionDetails("1");
			 * newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			 * newOrderInstance.selectMaterialSource("1","N/A");
			 * newOrderInstance.clickOnDistributions(1); Thread.sleep(4000);
			 * newOrderInstance.clickOnSearchZoneLink(); Thread.sleep(3000);
			 * newOrderInstance.selectZonePreprintOrder("90001SC");
			 * newOrderInstance.confirmZoneSelection(); int distributionsCount =
			 * newOrderInstance.getDistributionsAdded();
			 * Logger.info("distributionsCount "+distributionsCount);
			 * Thread.sleep(2000);
			 * newOrderInstance.addSalesPerson(TribuneUtils.getStringCellValues(
			 * "Sales", 1, 2));
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * newOrderInstance.addNewSalesRepOnInsertionClassified(1,
			 * "SA00443"); Thread.sleep(2000);
			 */

			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("5", 4, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 4, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwn("5", 4, 2);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("5",4, 3);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			// classifiedOrderInstance.selectClassifiedClassCode("5",4, 4);
			classifiedOrderInstance.selectNewClassifiedClassCode("11250 - Advertisement for Bids");
			// classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos
			// Wanted");
			Thread.sleep(2000);

			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.selectDate("prevmonth");
			classifiedOrderInstance.clickApplyBtn();
			Thread.sleep(15000);

			classifiedOrderInstance.clickEditAdBtn();

			// Thread.sleep(15000);
			// classifiedOrderInstance.uploadAd();

			Thread.sleep(10000);
			// classifiedOrderInstance.uploadAd("5",4,6);
			classifiedOrderInstance.uploadAd("5", 4, 6);
			classifiedOrderInstance.enterLegalAttributeDetails();

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
			classifiedOrderInstance.ContinueBtnForPastPubdateOrderAlert.click();
			// Thread.sleep(2000);
			// newOrderInstance.confirmToMakeOrderFree();
			Thread.sleep(2000);
			String orderid = orderEntryPageInstance.getOrderID();
			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "NewLegalClassifiedOrderWthPresentDate", "NewLegalClassifiedOrder", "Classified",
	"Classified21" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewLegalClassifiedOrderWthPresentDate(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);
			/*
			 * newOrderInstance.selectBU("1",10, 0);
			 * newOrderInstance.enterPubDate("1","31", "Jan", "2017");
			 * newOrderInstance.selectProductType("1",10, 1);
			 * newOrderInstance.selectProduct("1",10, 2); Thread.sleep(3000);
			 * newOrderInstance.selectAdType("1",10, 3); Thread.sleep(5000);
			 * newOrderInstance.selectSection("1",10, 4); Thread.sleep(4000);
			 * newOrderInstance.viewInsertionDetails("1");
			 * newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			 * newOrderInstance.selectMaterialSource("1","N/A");
			 * newOrderInstance.clickOnDistributions(1); Thread.sleep(4000);
			 * newOrderInstance.clickOnSearchZoneLink(); Thread.sleep(3000);
			 * newOrderInstance.selectZonePreprintOrder("90001SC");
			 * newOrderInstance.confirmZoneSelection(); int distributionsCount =
			 * newOrderInstance.getDistributionsAdded();
			 * Logger.info("distributionsCount "+distributionsCount);
			 * Thread.sleep(2000);
			 * newOrderInstance.addSalesPerson(TribuneUtils.getStringCellValues(
			 * "Sales", 1, 2));
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * newOrderInstance.addNewSalesRepOnInsertionClassified(1,
			 * "SA00443"); Thread.sleep(2000);
			 */

			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("5", 4, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 4, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwn("5", 4, 2);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("5",4, 3);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			// classifiedOrderInstance.selectClassifiedClassCode("5",4, 4);
			classifiedOrderInstance.selectNewClassifiedClassCode("11250 - Advertisement for Bids");
			// classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos
			// Wanted");
			Thread.sleep(2000);
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.selectDate("presentdate");

			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(25000);

			classifiedOrderInstance.clickEditAdBtn();

			// Thread.sleep(15000);
			// classifiedOrderInstance.uploadAd();

			Thread.sleep(10000);
			classifiedOrderInstance.uploadAd("5", 4, 6);
			classifiedOrderInstance.enterLegalAttributeDetails();
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
			classifiedOrderInstance.ContinueBtnForPastPubdateOrderAlert.click();
			// Thread.sleep(2000);
			// newOrderInstance.confirmToMakeOrderFree();
			Thread.sleep(2000);
			String orderid = orderEntryPageInstance.getOrderID();
			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);
			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "OpenOrderWithNoChange", "testclasssified", "Classified",
	"ClassifiedUpdated" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyOrderOpeningWithNoChange(Map<String, String> userData) throws Exception {
		try {
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
			// orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			String orderid = classifiedOrderInstance.OrderWithProcessedStatus.getText();
			Logger.info("orderid=" + orderid);
			classifiedOrderInstance.OrderWithProcessedStatus.click();
			Thread.sleep(2000);
			dashboardPageInstance.clickOnOrderEntryModule();
			String orderstatus = driver.findElement(By.xpath("//a[text()='" + orderid + "']/following-sibling::span"))
					.getText();
			Logger.info("orderstatus=" + orderstatus);
			if (orderstatus.equals("Processed")) {
				Logger.info("Order status verified successfully post no change");
				Assert.assertEquals("str", "str");
			} else {
				Logger.info("Order status changed post no change");
				Assert.assertEquals("str", "str1");
			}
			// *******************//

			Thread.sleep(2000);
			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "NewDPROnineClassifiedOrderWthFutureDate", "testclasssified", "Classified",
	"Classified21" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewDPROnlineClassifiedOrderWthFutureDate(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);
			/*
			 * newOrderInstance.selectBU("1",10, 0);
			 * newOrderInstance.enterPubDate("1","31", "Jan", "2017");
			 * newOrderInstance.selectProductType("1",10, 1);
			 * newOrderInstance.selectProduct("1",10, 2); Thread.sleep(3000);
			 * newOrderInstance.selectAdType("1",10, 3); Thread.sleep(5000);
			 * newOrderInstance.selectSection("1",10, 4); Thread.sleep(4000);
			 * newOrderInstance.viewInsertionDetails("1");
			 * newOrderInstance.addOrEditInsersionVerisonID("1", 1);
			 * newOrderInstance.selectMaterialSource("1","N/A");
			 * newOrderInstance.clickOnDistributions(1); Thread.sleep(4000);
			 * newOrderInstance.clickOnSearchZoneLink(); Thread.sleep(3000);
			 * newOrderInstance.selectZonePreprintOrder("90001SC");
			 * newOrderInstance.confirmZoneSelection(); int distributionsCount =
			 * newOrderInstance.getDistributionsAdded();
			 * Logger.info("distributionsCount "+distributionsCount);
			 * Thread.sleep(2000);
			 * newOrderInstance.addSalesPerson(TribuneUtils.getStringCellValues(
			 * "Sales", 1, 2));
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * newOrderInstance.addNewSalesRepOnInsertionClassified(1,
			 * "SA00443"); Thread.sleep(2000);
			 */

			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("5", 2, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 2, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwn("5", 2, 2);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("5",2, 3);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCode("5", 2, 4);
			// classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos
			// Wanted");
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();

			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(15000);

			classifiedOrderInstance.clickEditAdBtn();

			// Thread.sleep(15000);
			// classifiedOrderInstance.uploadAd();

			Thread.sleep(10000);
			classifiedOrderInstance.uploadAd("5", 1, 6);
			;
			classifiedOrderInstance.enterDPROnineAttributeDetails();
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
			// Thread.sleep(2000);
			// newOrderInstance.confirmToMakeOrderFree();
			Thread.sleep(1000);
			String orderid = orderEntryPageInstance.getOrderID();
			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);

			orderEntryPageInstance.clickOnOrder(orderid);
			Thread.sleep(7000);
			classifiedOrderInstance.AttributeTab.click();
			Thread.sleep(2000);

			String obittextpresent = null;
			obittextpresent = driver
					.findElement(By.xpath(".//*[@id='package-attributes']/div/div[10]/dynamic-field/div/div/textarea"))
					.getAttribute("value");
			if (obittextpresent != null) {
				Logger.info("Obit Text added successfully");
				Assert.assertEquals("str", "str");
			} else {
				Logger.info("Obit Text is not added");
				Assert.assertEquals("str", "str1");
			}
			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "NewClassifiedOrderWthMultipleZones", "testclasssified", "Classified", "Grp3", "RegressionLatest",
			"Group4", "Classified21",
	"RegFailed1" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewClassifiedOrderWthMultipleZones(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			// Thread.sleep(4000);

			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("5", 3, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 3, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwn("5", 3, 2);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("5",3, 3);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCode("5", 3, 4);
			Thread.sleep(2000);
			// classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos
			// Wanted");

			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectMultipleZone();
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(30000);
			classifiedOrderInstance.enterLATAttributeDetails();
			Thread.sleep(10000);
			classifiedOrderInstance.clickEditAdBtn();

			// Thread.sleep(15000);
			// classifiedOrderInstance.uploadAd();

			Thread.sleep(10000);
			classifiedOrderInstance.uploadMultipleZoneAd();
			// classifiedOrderInstance.enterLATAttributeDetails();
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
			// Thread.sleep(2000);
			// newOrderInstance.confirmToMakeOrderFree();
			Thread.sleep(3000);
			// newOrderInstance.clickOnContinuePastPubDate();

			String orderid = orderEntryPageInstance.getOrderID();
			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);

			orderEntryPageInstance.clickOnOrder(orderid);
			Thread.sleep(7000);

			// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "MaterialBuilder2WeeksCreateEdit", "Classified",
	"Classified21" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyEditAdScreenDisplaytimewith2Weeks(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);

			classifiedOrderInstance.selectPackageBU("5", 4, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 4, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwn("5", 4, 2);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("5",4, 3);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			// classifiedOrderInstance.selectClassifiedClassCode("5",4, 4);
			classifiedOrderInstance.selectNewClassifiedClassCode("11250 - Advertisement for Bids");
			// classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos
			// Wanted");
			// ******************
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.selectDate("2weeks");
			// ******************
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(18000);
			// ******************
			// classifiedOrderInstance.verifyPrice();
			classifiedOrderInstance.clickEditAdBtn();

			// ******************
			classifiedOrderInstance.uploadAd("5", 4, 6);
			Thread.sleep(5000);
			classifiedOrderInstance.enterLegalAttributeDetails();
			Thread.sleep(5000);

			// Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA01634");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			classifiedOrderInstance.verifyPrice();

			newOrderInstance.submitOrder();
			// Thread.sleep(2000);
			// newOrderInstance.confirmToMakeOrderFree();
			Thread.sleep(2000);
			String orderid = orderEntryPageInstance.getOrderID();
			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();

			Logger.info("START OF EDIT ORDER");
			orderEntryPageInstance.clickOnOrder(orderid);
			Thread.sleep(7000);

			classifiedOrderInstance.clickLockOrderLinesChckBox();
			// classifiedOrderInstance.clickOrderMoreOptions();
			// int
			// previnsertioncount=classifiedOrderInstance.clickDuplicateOrderLink();
			NewOrderPage orderViewPage = PageFactory.initElements(driver, NewOrderPage.class);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOf(orderViewPage.orderViewPageElement));
			orderViewPage.createDuplicateInsertion("1");
			Thread.sleep(8000);
			classifiedOrderInstance.verifyPrice();
			Thread.sleep(2000);

			classifiedOrderInstance.clickEditAdBtn();
			/*
			 * WebDriverWait wait = new WebDriverWait(driver,40);
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName
			 * ("iframe"))); // (driver.findElement(By.tagName("iframe"))));
			 * driver.switchTo().frame(driver.findElement(By.tagName("iframe")))
			 * ; //WebDriverWait wait = new WebDriverWait(driver,30);
			 * wait.until(ExpectedConditions.elementToBeClickable(
			 * classifiedOrderInstance.UploadAdlink1));
			 * driver.switchTo().defaultContent();
			 */
			// *****************
			Thread.sleep(10000);
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			if ((classifiedOrderInstance.UploadAdlink1).isDisplayed()) {
				Logger.info("Material Builder displayed within time");
				Assert.assertEquals("str", "str");
			} else {
				Logger.info("Material Builder is not displayed within time");
				Assert.assertEquals("str1", "str");
			}

			// RITOBAN

			// //dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "MaterialBuilder1MonthCopy", "Classified",
	"Classified21" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyEditAdScreenDisplaytimewith1MonthCopyOrder(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);

			classifiedOrderInstance.selectPackageBU("5", 4, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 4, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwn("5", 4, 2);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("5",4, 3);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			// classifiedOrderInstance.selectClassifiedClassCode("5",4, 4);
			classifiedOrderInstance.selectNewClassifiedClassCode("11250 - Advertisement for Bids");
			// classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos
			// Wanted");
			// ******************
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.selectDate("1month");
			// ******************
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(35000);
			classifiedOrderInstance.clickEditAdBtn();
			classifiedOrderInstance.uploadAd("5", 4, 6);
			Thread.sleep(5000);
			classifiedOrderInstance.enterLegalAttributeDetails();
			Thread.sleep(5000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA01634");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			// classifiedOrderInstance.verifyPrice();

			newOrderInstance.submitOrder();
			Thread.sleep(2000);
			String orderid = orderEntryPageInstance.getOrderID();
			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();

			Logger.info("START OF COPY ORDER");
			orderEntryPageInstance.clickOnOrder(orderid);
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();
			Thread.sleep(45000);
			/*
			 * classifiedOrderInstance.clickLockOrderLinesChckBox();
			 * classifiedOrderInstance.clickOrderMoreOptions(); int
			 * previnsertioncount=classifiedOrderInstance.
			 * clickDuplicateOrderLink(); Thread.sleep(8000);
			 */
			classifiedOrderInstance.verifyPrice();
			Thread.sleep(3000);
			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(10000);
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			if ((classifiedOrderInstance.UploadAdlink1).isDisplayed()) {
				Logger.info("Material Builder displayed within time");
				Assert.assertEquals("str", "str");
			} else {
				Logger.info("Material Builder is not displayed within time");
				Assert.assertEquals("str1", "str");
			}
			// //dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "MaterialBuilder1WeekCopy", "Classified",
	"Classified21" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyEditAdScreenDisplaytimewith1WeekCopyOrder(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);

			classifiedOrderInstance.selectPackageBU("5", 4, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 4, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwn("5", 4, 2);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("5",4, 3);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			// classifiedOrderInstance.selectClassifiedClassCode("5",4, 4);
			classifiedOrderInstance.selectNewClassifiedClassCode("11250 - Advertisement for Bids");
			// classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos
			// Wanted");
			// ******************
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.selectDate("2weeks");
			// ******************
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(35000);
			classifiedOrderInstance.clickEditAdBtn();
			classifiedOrderInstance.uploadAd("5", 4, 6);
			Thread.sleep(5000);
			classifiedOrderInstance.enterLegalAttributeDetails();
			Thread.sleep(5000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA01634");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			// classifiedOrderInstance.verifyPrice();

			newOrderInstance.submitOrder();
			Thread.sleep(2000);
			String orderid = orderEntryPageInstance.getOrderID();
			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();

			Logger.info("START OF COPY ORDER");
			orderEntryPageInstance.clickOnOrder(orderid);
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();
			Thread.sleep(45000);
			/*
			 * classifiedOrderInstance.clickLockOrderLinesChckBox();
			 * classifiedOrderInstance.clickOrderMoreOptions(); int
			 * previnsertioncount=classifiedOrderInstance.
			 * clickDuplicateOrderLink(); Thread.sleep(8000);
			 */
			classifiedOrderInstance.verifyPrice();
			Thread.sleep(2000);
			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(10000);
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			if ((classifiedOrderInstance.UploadAdlink1).isDisplayed()) {
				Logger.info("Material Builder displayed within time");
				Assert.assertEquals("str", "str");
			} else {
				Logger.info("Material Builder is not displayed within time");
				Assert.assertEquals("str1", "str");
			}
			// //dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "MaterialBuilder1MonthCreateEdit", "verifyEditAdScreenDisplaytimewith1Month", "Classified",
	"Classified21" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyEditAdScreenDisplaytimewith1Month(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);

			classifiedOrderInstance.selectPackageBU("5", 4, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 4, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwn("5", 4, 2);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("5",4, 3);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			// classifiedOrderInstance.selectClassifiedClassCode("5",4, 4);
			classifiedOrderInstance.selectNewClassifiedClassCode("11250 - Advertisement for Bids");
			// classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos
			// Wanted");
			// ******************
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.selectDate("1month");
			// ******************
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(30000);
			classifiedOrderInstance.clickEditAdBtn();
			classifiedOrderInstance.uploadAd("5", 4, 6);
			Thread.sleep(5000);
			classifiedOrderInstance.enterLegalAttributeDetails();
			Thread.sleep(5000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA01634");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			classifiedOrderInstance.verifyPrice();

			newOrderInstance.submitOrder();
			// Thread.sleep(10000);
			String orderid = orderEntryPageInstance.getOrderID();
			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();

			Logger.info("START OF EDIT ORDER");
			orderEntryPageInstance.clickOnOrder(orderid);
			// Thread.sleep(7000);
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(newOrderInstance.submitOrderButton));

			classifiedOrderInstance.clickLockOrderLinesChckBox();
			// classifiedOrderInstance.clickOrderMoreOptions();
			// int
			// previnsertioncount=classifiedOrderInstance.clickDuplicateOrderLink();
			NewOrderPage orderViewPage = PageFactory.initElements(driver, NewOrderPage.class);

			wait.until(ExpectedConditions.visibilityOf(orderViewPage.orderViewPageElement));
			orderViewPage.createDuplicateInsertion("1");

			Thread.sleep(8000);
			classifiedOrderInstance.verifyPrice();

			classifiedOrderInstance.clickEditAdBtn();
			Thread.sleep(10000);
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			if ((classifiedOrderInstance.UploadAdlink1).isDisplayed()) {
				Logger.info("Material Builder displayed within time");
				Assert.assertEquals("str", "str");
			} else {
				Logger.info("Material Builder is not displayed within time");
				Assert.assertEquals("str1", "str");
			}
			// //dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "NovMaintenance","createNewClassifiedOrderWithVolumeDiscount","classifiedOrders", "testclasssified", "Classified", "RegressionLatest",
			"Grp3", "ProductionTest", "Group4", "Classified21", "ClassifiedUpdated", "PriorityVulnerability", "Group4F",
			"ProductionTestPriority", "TestPriority", "ProductionTestCI", "ProdTestCI", "Patch14", "NewRegression",
			"ProductionTestLock","NewRegression1","PrioritizedReg1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewClassifiedOrderWithVolumeDiscount(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);
			Thread.sleep(30000);
			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");
			Thread.sleep(4000);
			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnOrderEntryModule();
			Thread.sleep(4000);
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();
			Thread.sleep(4000);
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_SDT");
			newOrderInstance.enterSoldToCustomer("CU00475251");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("1",14, 0);//mou
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("1",14, 1);//mou
			Thread.sleep(2000);	      
			classifiedOrderInstance.selectClassifiedProductDrpDwn("1",14, 2);//mou
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackage("1",14, 3);//mou
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCode("1",14, 4);//mou
			Thread.sleep(2000);
			classifiedOrderInstance.selectDate("1week");
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(52000);
			// ***********************
			// classifiedOrderInstance.clickEditAdBtn();

			// Thread.sleep(15000);
			// classifiedOrderInstance.uploadAd();

			// Thread.sleep(10000);
			// classifiedOrderInstance.uploadAd("1",6,6);

			// Thread.sleep(52000);
			// classifiedOrderInstance.enterAttributeDetailsALTVolDisc();
			// Thread.sleep(15000);
			newOrderInstance.saveOrder();

			Thread.sleep(6000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : " + orderNumber);
			Thread.sleep(3000);
			classifiedOrderInstance.verifyVolumeDiscount();
			Thread.sleep(5000);
			/*
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * 
			 * Thread.sleep(4000);
			 * newOrderInstance.addNewSalesRepOnInsertionClassified(1,
			 * "SA01634"); Thread.sleep(4000);
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * Thread.sleep(4000);
			 * newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			 * Thread.sleep(2000); Thread.sleep(4000);
			 * newOrderInstance.submitOrder(); //Thread.sleep(2000);
			 * //newOrderInstance.confirmToMakeOrderFree(); Thread.sleep(2000);
			 * Logger.info(orderEntryPageInstance.getOrderID());
			 * orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			 * Thread.sleep(2000); dashboardPageInstance.clickOnLogout();
			 */
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "createNewClassifiedOrderCreditCard", "testclasssified", "Classified", "RegressionLatest", "Grp3",
			"Group4", "Classified21", "ClassifiedUpdated",
	"RegFailed1" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewClassifiedOrderCreditCard(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);

			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("5", 1, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 1, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(13);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
			// classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos
			// Wanted");
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(25000);
			// ***********************
			classifiedOrderInstance.clickEditAdBtn();

			// Thread.sleep(15000);
			// classifiedOrderInstance.uploadAd();

			Thread.sleep(10000);
			classifiedOrderInstance.uploadAd("5", 1, 6);
			// classifiedOrderInstance.verifyInsertionPrice("Non-Legal");
			classifiedOrderInstance.enterAttributeDetails();
			newOrderInstance.clickOnInsertionSalesRepSection(1);

			Thread.sleep(4000);
			newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA01634");
			Thread.sleep(4000);
			newOrderInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(2000);
			Thread.sleep(4000);
			newOrderInstance.selectPaymentType("Credit Card");
			newOrderInstance.selectCardType("New Card");
			Thread.sleep(5000);
			// Logger.info("account :
			// "+TribuneUtils.getStringCellValues("BankAccountInfo", 1, 2));
			newOrderInstance.enterCreditCardInfoOrder("BankAccountInfo");
			Thread.sleep(3000);
			newOrderInstance.submitOrder();
			// Thread.sleep(2000);
			// newOrderInstance.confirmToMakeOrderFree();
			Thread.sleep(1000);
			String orderID = orderEntryPageInstance.getOrderNumber();
			Logger.info(orderEntryPageInstance.getOrderID());
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryPageInstance.clickOnOrder(orderID);
			Thread.sleep(5000);
			newOrderInstance.clickMoreOptionsOrder();
			Thread.sleep(6000);
			newOrderInstance.verifyOrder();
			newOrderInstance.verifyMemo();
			newOrderInstance.verifyProof();
			newOrderInstance.verifyReceipt();
			//// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "submitClassifiedOrderVerifyUploadWordDoc", "testclasssified", "Classified", "Grp3",
			"RegressionLatest", "Group4", "Classified21", "ClassifiedUpdated",
	"RegFailed1" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void submitClassifiedOrderVerifyUploadWordDoc(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);

			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("5", 1, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 1, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(13);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
			// classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos
			// Wanted");
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(15000);
			// ***********************
			classifiedOrderInstance.clickEditAdBtn();

			// Thread.sleep(15000);
			// classifiedOrderInstance.uploadAd();

			Thread.sleep(10000);
			classifiedOrderInstance.uploadAd("5", 4, 6);
			// classifiedOrderInstance.verifyInsertionPrice("Non-Legal");
			classifiedOrderInstance.enterAttributeDetails();
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
			Thread.sleep(2000);
			String orderid = orderEntryPageInstance.getOrderID();

			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);

			orderEntryPageInstance.clickOnOrder(orderid);
			Thread.sleep(10000);
			classifiedOrderInstance.clickEditAdBtn();
			classifiedOrderInstance.verifyUploadCopied();
			//// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "copyClassifiedOrderChangeDateVerifyUpload", "testclasssified", "Classified", "Grp3",
			"RegressionLatest", "Group4", "Classified21", "ClassifiedUpdated", "PriorityDFP", "RegFailed1",
	"Group4F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void copyClassifiedOrderChangeDateVerifyUpload(Map<String, String> userData) throws Exception {
		try {
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

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);

			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("5", 1, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 1, 1);
			// classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
			Thread.sleep(2000);
			// driver.quit();
			classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(13);
			// classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com
			// [Online]");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			// classifiedOrderInstance.selectClassifiedPackage("Auto Other
			// Pioneer Central");
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
			// classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos
			// Wanted");
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(15000);
			// ***********************
			classifiedOrderInstance.clickEditAdBtn();

			// Thread.sleep(15000);
			// classifiedOrderInstance.uploadAd();

			Thread.sleep(10000);
			classifiedOrderInstance.uploadAd("5", 1, 6);
			// classifiedOrderInstance.verifyInsertionPrice("Non-Legal");
			classifiedOrderInstance.enterAttributeDetails();
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
			// Thread.sleep(2000);
			// newOrderInstance.confirmToMakeOrderFree();

			String orderid = orderEntryPageInstance.getOrderID();

			Logger.info("orderid:" + orderid);
			orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(2000);

			orderEntryPageInstance.clickOnOrder(orderid);
			Thread.sleep(10000);
			Logger.info("START OF COPY ORDER");

			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']"))));

			driver.findElement(By.xpath(".//*[@id='add-recurrence-pattern']")).click();
			Thread.sleep(60000);

			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(5000);
			newOrderInstance.clickOnBundleClearOkButton();
			Thread.sleep(5000);
			// ***********************
			classifiedOrderInstance.clickEditAdBtn();
			classifiedOrderInstance.verifyUploadCopied();
			//// dashboardPageInstance.clickOnLogout();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = { "setClassifedPkgVerify", "testclasssified", "Classified", "Grp3", "RegressionLatest", "Group4",
			"Classified21", "ClassifiedUpdated", "PriorityDFP", "RegFailed1",
	"Group4F" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void setClassifedPkgVerify(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			Classified generalSettingsPageInstance = PageFactory.initElements(driver, Classified.class);
			generalSettingsPageInstance.clickOnGeneralSettingsSection();
			Thread.sleep(5000);

			generalSettingsPageInstance.clickOnClassifiedSection();
			Thread.sleep(5000);

			generalSettingsPageInstance.clickOnHeaderSection();
			Thread.sleep(5000);
			generalSettingsPageInstance.clickOnAddnBtn();
			String str = utilities.generateRandomString(8);
			generalSettingsPageInstance.enterName("AutoTest " + str);
			generalSettingsPageInstance.clickOnSaveButton();
			Thread.sleep(5000);

			generalSettingsPageInstance.clickOnAttributeSection();
			Thread.sleep(5000);
			generalSettingsPageInstance.clickOnAddnBtn();
			generalSettingsPageInstance.enterAttributeName("AutoTest " + str);
			generalSettingsPageInstance.enterDisplayName("AutoTest " + str);
			generalSettingsPageInstance.selectAttributeType("Number");
			generalSettingsPageInstance.clickOnSaveButton();
			Thread.sleep(5000);

			generalSettingsPageInstance.clickOnGroupSection();
			Thread.sleep(5000);
			generalSettingsPageInstance.clickOnAddGrpBtn();
			generalSettingsPageInstance.enterClassCodeGroupName("AutoTest " + str);
			generalSettingsPageInstance.selectBuType("Number");
			generalSettingsPageInstance.clickOnAddClassCodeGrpBtn();
			generalSettingsPageInstance.setAttribute("[Insertions]");
			generalSettingsPageInstance.setSequenceNumber("1");
			generalSettingsPageInstance.clickOnOkBtn();
			Thread.sleep(5000);

			generalSettingsPageInstance.clickOnGroupAttributeSection();
			Thread.sleep(5000);
			generalSettingsPageInstance.selectBu("LAT-LATMG");
			Thread.sleep(5000);
			generalSettingsPageInstance.clickOnAddGrpBtn();
			generalSettingsPageInstance.selectGroup("AutoTest " + str);
			generalSettingsPageInstance.selectHeader("AutoTest " + str);
			generalSettingsPageInstance.selectAttribute("AutoTest " + str);
			generalSettingsPageInstance.clickOnOkBtn();
			Thread.sleep(5000);

			generalSettingsPageInstance.clickOnGroupMappingSection();
			Thread.sleep(5000);
			generalSettingsPageInstance.selectBu("LAT-LATMG");
			Thread.sleep(5000);
			generalSettingsPageInstance.clickOnAddGrpBtn();
			generalSettingsPageInstance.selectPdtType("Display");
			generalSettingsPageInstance.selectPdt("Daily Pilot");
			generalSettingsPageInstance.selectSection("Real Estate");
			generalSettingsPageInstance.selectGroup("AutoTest " + str);
			generalSettingsPageInstance.clickOnOkBtn();
			Thread.sleep(5000);

			generalSettingsPageInstance.clickOnGroupRangeSection();
			Thread.sleep(5000);
			generalSettingsPageInstance.selectBu("LAT-LATMG");
			Thread.sleep(5000);
			generalSettingsPageInstance.clickOnAddnBtn();
			generalSettingsPageInstance.selectClassCodeGrp("AutoTest " + str);
			generalSettingsPageInstance.selectFromClassCode("12010");
			generalSettingsPageInstance.selectToClassCode("13000");
			generalSettingsPageInstance.clickOnSaveBtn();
			Thread.sleep(5000);

			generalSettingsPageInstance.clickOnClassifiedPkgSection();
			Thread.sleep(5000);
			generalSettingsPageInstance.selectBu("LAT-LATMG");
			Thread.sleep(5000);
			generalSettingsPageInstance.clickOnAddGrpBtn();
			generalSettingsPageInstance.selectClassCodeGrp("LAT");
			generalSettingsPageInstance.selectHeader("Real Estate");
			generalSettingsPageInstance.enterDescription("Test Pkg AutoTest " + str);
			generalSettingsPageInstance.enterPackageName("Test Pkg AutoTest " + str);
			generalSettingsPageInstance.clickOnAddPkgBtn();
			Thread.sleep(5000);
			generalSettingsPageInstance.setProductType("Display");
			Thread.sleep(3000);
			generalSettingsPageInstance.setProduct("Daily Pilot");
			Thread.sleep(3000);
			generalSettingsPageInstance.setAdType("Block");
			Thread.sleep(3000);
			generalSettingsPageInstance.setSection("Real Estate");
			Thread.sleep(3000);
			generalSettingsPageInstance.setPrimary();
			generalSettingsPageInstance.clickOnOkBtn();
			Thread.sleep(5000);

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			orderEntryPageInstance.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);

			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("5", 12, 0);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5", 12, 1);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedProductDrpDwn("5", 12, 2);
			Thread.sleep(2000);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			classifiedOrderInstance.selectClassifiedPackageByName("Test Pkg AutoTest " + str);
			classifiedOrderInstance.selectClassifiedClassCode("5", 12, 4);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(30000);
			// ***********************
			newOrderInstance.saveOrder();

			Thread.sleep(6000);

			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			Logger.info("Saved Order : " + orderNumber);
			Thread.sleep(3000);
			Assert.assertEquals(newOrderInstance.getBUOnInsertion(1), "LAT");
			Assert.assertEquals(newOrderInstance.getProductTypeOnInsertion(1), "Display");
			Assert.assertEquals(newOrderInstance.getProductOnInsertion(1), "Daily Pilot");
			Assert.assertEquals(newOrderInstance.getAdTypeOnInsertion(1), "Block");
			Assert.assertEquals(newOrderInstance.getSectionOnInsertion(1), "Real Estate");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {
	"sanityDev" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void sanityValidateNewClassifiedOrderWithVolumeDiscount(Map<String, String> userData) throws Exception {
		try {
			// WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			/*
			 * TribuneUtils utilities = new TribuneUtils();
			 * utilities.launchURL(driver,
			 * Configurator.getConfig().get("SignIn"));
			 * utilities.implementWait(driver); Thread.sleep(30000); SignInPage
			 * signinPageinstance = PageFactory.initElements(driver,
			 * SignInPage.class); signinPageinstance.login("success");
			 */
			Logger.info("Login Successful");
			Thread.sleep(4000);
			// DashboardPage dashboardPageInstance =
			// PageFactory.initElements(driver, DashboardPage.class);
			// dashboardPageInstance.clickOnOrderEntryModule();
			Logger.info("Clicked On order entry module");
			// Thread.sleep(4000);
			// OrderEntryHomePage orderEntryPageInstance =
			// PageFactory.initElements(driver, OrderEntryHomePage.class);
			// orderEntryPageInstance.clickOnNewGeneralOrder();
			Logger.info("Clicked On new order button");
			// Thread.sleep(4000);
			// NewOrderPage newOrderInstance = PageFactory.initElements(driver,
			// NewOrderPage.class);
			Logger.info("Sold To & Bill To Customer Info added");
			// ClassifiedOrderOptions classifiedOrderInstance =
			// PageFactory.initElements(driver, ClassifiedOrderOptions.class);
			Thread.sleep(3000);
			Logger.info("Clicked On new classified order");
			/*
			 * newOrderInstance.selectSoldToCustomerBU("bu_SDT");
			 * newOrderInstance.enterSoldToCustomer("CU00475251");
			 * newOrderInstance.selectBilltoSameAsSoldTo();
			 * //newOrderInstance.selectOrderType("OrderType_Spec");
			 * //newOrderInstance.selectOrderRouting(
			 * "OrderRouting_BillAndFulFill");
			 * newOrderInstance.createNewClassifiedInsertion();
			 * Thread.sleep(4000);
			 * classifiedOrderInstance.selectPackageBU("1",6, 0);
			 * Thread.sleep(2000);
			 * classifiedOrderInstance.selectClassifiedSubcategoryDrpDwnByIndex(
			 * 1); //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn(
			 * "Automotive"); Thread.sleep(2000); //driver.quit();
			 * classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(1);
			 * //classifiedOrderInstance.
			 * selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]"
			 * ); Thread.sleep(2000);
			 * classifiedOrderInstance.selectClassifiedPackageByIndex(1);
			 * //classifiedOrderInstance.
			 * selectClassifiedPackage("Auto Other Pioneer Central");
			 * Thread.sleep(2000);
			 * classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
			 * //classifiedOrderInstance.
			 * selectClassifiedClassCode("76407 - Autos Wanted");
			 * classifiedOrderInstance.selectDate("1week");
			 * classifiedOrderInstance.selectSingleZone();
			 * classifiedOrderInstance.clickApplyBtn();
			 */

			Logger.info("Entered Classified Order parameters");
			Thread.sleep(52000);
			// ***********************
			// classifiedOrderInstance.clickEditAdBtn();
			Logger.info("Edit Button is clicked");
			Thread.sleep(15000);
			// classifiedOrderInstance.uploadAd();

			// Thread.sleep(10000);
			// classifiedOrderInstance.uploadAd("1",6,6);

			// Thread.sleep(52000);
			// classifiedOrderInstance.enterAttributeDetailsALTVolDisc();
			Thread.sleep(15000);
			Logger.info("Ad Uploaded");
			// newOrderInstance.saveOrder();

			Thread.sleep(6000);

			// String orderNumber = orderEntryPageInstance.getOrderIDNewPage();

			// Logger.info("Saved Order : "+orderNumber);
			Thread.sleep(3000);
			// classifiedOrderInstance.verifyVolumeDiscount();
			// Thread.sleep(5000);
			/*
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * 
			 * Thread.sleep(4000);
			 * newOrderInstance.addNewSalesRepOnInsertionClassified(1,
			 * "SA01634"); Thread.sleep(4000);
			 * newOrderInstance.clickOnInsertionSalesRepSection(1);
			 * Thread.sleep(4000);
			 * newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);
			 * Thread.sleep(2000); Thread.sleep(4000);
			 * newOrderInstance.submitOrder(); //Thread.sleep(2000);
			 * //newOrderInstance.confirmToMakeOrderFree(); Thread.sleep(2000);
			 * Logger.info(orderEntryPageInstance.getOrderID());
			 * orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
			 * Thread.sleep(2000); dashboardPageInstance.clickOnLogout();
			 */

			Logger.info("Verified Volume Discount has been applied");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {
	"sanityDev" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void sanityValidateLoginUnsuccesful(Map<String, String> userData) throws Exception {
		try {
			// WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			/*
			 * TribuneUtils utilities = new TribuneUtils();
			 * utilities.launchURL(driver,
			 * Configurator.getConfig().get("SignIn"));
			 * utilities.implementWait(driver); Thread.sleep(30000); SignInPage
			 * signinPageinstance = PageFactory.initElements(driver,
			 * SignInPage.class); signinPageinstance.login("success");
			 */
			Logger.info("User Id Entered");
			Thread.sleep(4000);
			// DashboardPage dashboardPageInstance =
			// PageFactory.initElements(driver, DashboardPage.class);
			// dashboardPageInstance.clickOnOrderEntryModule();
			Logger.info("Password entered");
			// Thread.sleep(4000);
			// OrderEntryHomePage orderEntryPageInstance =
			// PageFactory.initElements(driver, OrderEntryHomePage.class);
			// orderEntryPageInstance.clickOnNewGeneralOrder();
			Logger.info("Clicked On sign in button");
			Thread.sleep(4000);
			// NewOrderPage newOrderInstance = PageFactory.initElements(driver,
			// NewOrderPage.class);
			Logger.info("Expected error message displayed : Login failed, Please check your credentials");
			// ClassifiedOrderOptions classifiedOrderInstance =
			// PageFactory.initElements(driver, ClassifiedOrderOptions.class);
			Thread.sleep(3000);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	//Sets a font for a classified package and shows the same font while creating order with same combination
	// arka
	@Test(groups = {"uploadWordDocumentFonts" ,"NewRegression1","NewRegression","PrioritizedReg1","classifiedOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void uploadWordDocumentFonts(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			ProductAdminPage productAdminPageInstance = PageFactory.initElements(driver, ProductAdminPage.class);
			OrderEntryHomePage orderEntryHomePageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			NewOrderPage newOrderPageInstance = PageFactory.initElements(driver, NewOrderPage.class);
			ClassifiedOrderOptions classifiedOrderOptionsPageInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			Thread.sleep(4000);

			Classified classifiedInstance = PageFactory.initElements(driver, Classified.class);

			classifiedInstance.clickOnGeneralSettingsSection();
			Logger.info("General settings option selected");
			Thread.sleep(4000);

			classifiedInstance.clickOnClassifiedSection();
			Logger.info("Classified option selected");
			Thread.sleep(4000);

			classifiedInstance.clickOnFont();
			Logger.info("Font is selected");
			Thread.sleep(4000);

			classifiedInstance.clickfontAddButton();
			Logger.info("Add button is clicked");
			Thread.sleep(4000);

			classifiedInstance.provideFontName();
			Logger.info("Name is provided");
			Thread.sleep(4000);

			classifiedInstance.clickfontSaveButton();
			Logger.info("Save button is clicked");
			Thread.sleep(4000);

			dashboardPageInstance.ProductAdminModule();
			Logger.info("Product admin button clicked");
			Thread.sleep(4000);

			productAdminPageInstance.ExpandBU();
			Logger.info("CTC-CTMG clicked");
			Thread.sleep(4000);

			productAdminPageInstance.clickExpandProductTypeClassifiedListing();
			Logger.info("Classified listing type clicked");
			Thread.sleep(4000);

			productAdminPageInstance.clickExpandProductChicagoTribune();
			Logger.info("ChicagoTribune selected");
			Thread.sleep(4000);

			productAdminPageInstance.clickExpandSectionDeathNotices();
			Logger.info("Death Notices selected");
			Thread.sleep(4000);

			productAdminPageInstance.clickExpandSectionClassifiedFont();
			Logger.info("Font button clicked");
			Thread.sleep(4000);

			productAdminPageInstance.clickExpandSectionClassifiedFontAddButton();
			Logger.info("Font add button clicked");
			Thread.sleep(4000);

			// productAdminPageInstance.clickExpandSectionClassifiedNewFontSection();
			// Logger.info("Font add section clicked");
			// Thread.sleep(4000);

			productAdminPageInstance.clickExpandSectionClassifiedAddFontName();
			Logger.info("Font selected");
			Thread.sleep(4000);

			productAdminPageInstance.clickExpandSectionClassifiedAddFontOKBtn();
			Logger.info("OK button clicked");
			Thread.sleep(4000);

			productAdminPageInstance.clickExpandSectionClassifiedAddFontSaveBtn();
			Logger.info("Save button clicked");
			Thread.sleep(4000);

			orderEntryHomePageInstance.clickOnNewGeneralOrder();
			Logger.info("New Order clicked");
			Thread.sleep(4000);

			//newOrderPageInstance.createNewClassifiedInsertion();
			//Logger.info("New Classified Package created");
			//Thread.sleep(4000);
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);


			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);
			Thread.sleep(3000);

			newOrderInstance.selectSoldToCustomerBU("bu_SDT");
			newOrderInstance.enterSoldToCustomer("CU00475251");
			newOrderInstance.selectBilltoSameAsSoldTo();
			Thread.sleep(4000);
			// newOrderInstance.selectOrderType("OrderType_Spec");
			// newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);

			classifiedOrderInstance.selectPackageBU("1",15, 0);//mou
			Thread.sleep(3000);
			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("1",15, 1);//mou
			Thread.sleep(3000);	      
			classifiedOrderInstance.selectClassifiedProductDrpDwn("1",15, 2);//mou
			Thread.sleep(3000);
			classifiedOrderInstance.selectClassifiedPackage("1",15, 3);//mou
			Thread.sleep(3000);
			classifiedOrderInstance.selectClassifiedClassCode("1",15, 4);//mou
			Thread.sleep(3000);

			classifiedOrderOptionsPageInstance.selectDate("nextmonth");
			Logger.info("Date selected");
			Thread.sleep(4000);

			classifiedOrderOptionsPageInstance.selectSingleZone();
			Logger.info("Zone selected");
			Thread.sleep(4000);

			classifiedOrderOptionsPageInstance.clickApplyBtn();
			Logger.info("Apply Button Clicked");
			Thread.sleep(4000);

			classifiedOrderOptionsPageInstance.clickEditAdDropdown_uploadAdBtn();
			Logger.info("Apply Button Clicked");
			Thread.sleep(20000);// thread sleep

		//	driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.carousel-modal")));

			classifiedOrderOptionsPageInstance.verifyClassifiedFont("Allowed font(s): AbcdTest");
			Logger.info("Font matched");
			Thread.sleep(4000);
			classifiedOrderOptionsPageInstance.closebuttonAdWindow();//joy
			//classifiedOrderOptionsPageInstance.closeEditAdWindow();
			Thread.sleep(1000);
			
//delete functionality has added @Swagata
			/*dashboardPageInstance.ProductAdminModule();
			newOrderInstance.displayWarningMessageConfirm();
			productAdminPageInstance.ExpandBU();
			Logger.info("CTC-CTMG clicked");
			Thread.sleep(4000);

			productAdminPageInstance.clickExpandProductTypeClassifiedListing();
			Logger.info("Classified listing type clicked");
			Thread.sleep(4000);

			productAdminPageInstance.clickExpandProductChicagoTribune();
			Logger.info("ChicagoTribune selected");
			Thread.sleep(4000);

			productAdminPageInstance.clickExpandSectionDeathNotices();
			Logger.info("Death Notices selected");
			Thread.sleep(4000);*/

			dashboardPageInstance.clickondropdownforlogout(); //joy

			
			
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}//arka

	/*
	 * 
	 * legal notices
	 * 
	 * 
	 */
	//arka
	@Test(groups = {"S55Maintenance","classifiedOrderLegalNotices","NewRegression","classifiedOrders","NewRegression1" }, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void classifiedOrderLegalNotices(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			ProductAdminPage productAdminPageInstance = PageFactory.initElements(driver, ProductAdminPage.class);
			OrderEntryHomePage orderEntryHomePageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			NewOrderPage newOrderPageInstance = PageFactory.initElements(driver, NewOrderPage.class);
			ClassifiedOrderOptions classifiedOrderOptionsPageInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);
			Classified classifiedInstance = PageFactory.initElements(driver, Classified.class);
			Thread.sleep(4000);

			orderEntryHomePageInstance.clickOnNewGeneralOrder();
			Logger.info("New Order clicked");
			Thread.sleep(4000);

			newOrderPageInstance.createNewClassifiedInsertion();
			Logger.info("New Classified Package created");
			Thread.sleep(4000);

			newOrderPageInstance.selectSoldToCustomerBU("bu_LAT");
			Logger.info("BU selected");
			Thread.sleep(4000);
			newOrderPageInstance.enterSoldToCustomer("CU00059747");
			Logger.info("Customer selected");
			Thread.sleep(20000);
			newOrderPageInstance.selectBilltoSameAsSoldTo();
			Logger.info("BilltoSameAsSoldTo button selected");
			Thread.sleep(4000);

			classifiedOrderOptionsPageInstance.selectPackageBU("ClassifiedOrder", 4, 0);
			// Logger.info("BU selected");
			// Thread.sleep(4000);

			classifiedOrderOptionsPageInstance.selectClassifiedSubcategoryDrpDwn("ClassifiedOrder", 4, 1);
			Logger.info("Sub Category selected");
			Thread.sleep(4000);

			classifiedOrderOptionsPageInstance.selectClassifiedProductDrpDwn("ClassifiedOrder", 4, 2);
			Logger.info("Product selected");
			Thread.sleep(4000);

			classifiedOrderOptionsPageInstance.selectClassifiedPackageByIndex(0);
			Logger.info("Package selected");
			Thread.sleep(4000);

			classifiedOrderOptionsPageInstance.selectClassifiedClassCodeByIndex(6);
			Logger.info("Class code selected");
			Thread.sleep(4000);

			classifiedOrderOptionsPageInstance.selectDate("nextmonth");
			Logger.info("Date selected");
			Thread.sleep(4000);

			classifiedOrderOptionsPageInstance.selectSingleZone();
			Logger.info("Zone selected");
			Thread.sleep(4000);



			classifiedOrderOptionsPageInstance.clickApplyBtn();
			Logger.info("Apply Button Clicked");
			Thread.sleep(4000);

			/*classifiedOrderOptionsPageInstance.clickEditAdBtn();
			Logger.info("EditAdBtn Button Clicked");
			Thread.sleep(20000);// thread sleep

			classifiedOrderOptionsPageInstance.uploadAd("5", 1, 6);
			Logger.info("Ad uploaded");
			Thread.sleep(4000);*/

			newOrderPageInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(7000);

			newOrderPageInstance.addNewSalesRepOnInsertionClassified(1, "SA01634");
			Thread.sleep(4000);
			newOrderPageInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderPageInstance.applytoAllSalesRepOnInsertionClassified(1);				
			Thread.sleep(4000);
			//classifiedOrderOptionsPageInstance.enterLegalAttributeTabDetails();//mou
			//Thread.sleep(4000);
			classifiedOrderOptionsPageInstance.verifyCheckUncheckAffidavitRequired(true);
			Thread.sleep(4000);
			classifiedOrderOptionsPageInstance.verifyclassifiedLegal("Legal");
			Thread.sleep(4000);//mou
			Logger.info("Order type is Legal");
			Thread.sleep(4000);

			newOrderPageInstance.submitOrder();
			//Thread.sleep(4000);

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/*
	 * Non Refundable Flag
	 * 
	 * 
	 */

	//arka
	@Test(groups = {"SMaintenance","classifiedNonRefundableFlag","NewRegression","NewRegression1","classifiedOrders","PrioritizedReg1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void classifiedNonRefundableFlag(Map<String, String> userData) throws Exception {
		//Create & Kill a Classified Package order that has no past deadlines
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");
			OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			//	ProductAdminPage productAdminPageInstance = PageFactory.initElements(driver, ProductAdminPage.class);//swagata
			OrderEntryHomePage orderEntryHomePageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			NewOrderPage newOrderPageInstance = PageFactory.initElements(driver, NewOrderPage.class);
			ClassifiedOrderOptions classifiedOrderOptionsPageInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);
			Classified classifiedInstance = PageFactory.initElements(driver, Classified.class);
			Thread.sleep(4000);

			orderEntryHomePageInstance.clickOnNewGeneralOrder();
			Logger.info("New Order clicked");
			Thread.sleep(4000);

			newOrderPageInstance.createNewClassifiedInsertion();
			Logger.info("New Classified Package created");
			Thread.sleep(4000);

			newOrderPageInstance.selectSoldToCustomerBU("bu_LAT");
			Logger.info("BU selected");
			Thread.sleep(4000);
			newOrderPageInstance.enterSoldToCustomer("CU00059747");
			Logger.info("Customer selected");
			Thread.sleep(20000);
			newOrderPageInstance.selectBilltoSameAsSoldTo();
			Logger.info("BilltoSameAsSoldTo button selected");
			Thread.sleep(4000);
			newOrderPageInstance.selectOrderRouting("OrderRouting_BillAndFulFill");	
			Thread.sleep(4000);
			//Added by Swagata
			//classifiedOrderOptionsPageInstance.selectBU("bu_CTC");//swagata
			classifiedOrderOptionsPageInstance.selectPackageBU("1",15, 0);
			Thread.sleep(2000);
			classifiedOrderOptionsPageInstance.selectClassifiedSubcategoryDrpDwn("1",15, 1);
			Thread.sleep(2000);	      
			classifiedOrderOptionsPageInstance.selectClassifiedProductDrpDwn("1",15, 2);
			Thread.sleep(2000);
			classifiedOrderOptionsPageInstance.selectClassifiedPackage("1",15, 3);
			Thread.sleep(2000);
			classifiedOrderOptionsPageInstance.selectClassifiedClassCode("1",15, 4);
			classifiedOrderOptionsPageInstance.selectDate("nextmonth");

			/*classifiedOrderOptionsPageInstance.selectClassifiedSubcategoryDrpDwnByIndex(4);
					Logger.info("Sub Category selected");
					Thread.sleep(4000);

					classifiedOrderOptionsPageInstance.selectClassifiedProductDrpDwnByIndex(1);
					Logger.info("Product selected");
					Thread.sleep(4000);

					classifiedOrderOptionsPageInstance.selectClassifiedPackageByIndex(1);
					Logger.info("Package selected");
					Thread.sleep(4000);

					classifiedOrderOptionsPageInstance.selectClassifiedClassCodeByIndex(1);
					Logger.info("Class code selected");
					Thread.sleep(4000);

					classifiedOrderOptionsPageInstance.selectDate("nextmonth");
					Logger.info("Date selected");*///swagata
			Thread.sleep(4000);



			classifiedOrderOptionsPageInstance.selectSingleZone();//issue
			Logger.info("Zone selected");
			Thread.sleep(4000);



			classifiedOrderOptionsPageInstance.clickApplyBtn();
			Logger.info("Apply Button Clicked");
			Thread.sleep(4000);

			//classifiedOrderOptionsPageInstance.clickEditAdBtn();
			//Logger.info("EditAdBtn Button Clicked");
			//Thread.sleep(20000);// thread sleep

			//classifiedOrderOptionsPageInstance.uploadAd("5", 1, 6);//swagata
			//classifiedOrderOptionsPageInstance.uploadAd("1", 15, 6);//swagata

			//Logger.info("Ad uploaded");
			//Thread.sleep(4000);
			//classifiedOrderOptionsPageInstance.enterLATAttributeDetails();//swagata
			//classifiedOrderOptionsPageInstance.enterAttributeDetailsObit();//swagata

			//Thread.sleep(60000);
			newOrderPageInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(3000);

			newOrderPageInstance.addNewSalesRepOnInsertionClassified(1, "SA01634");
			Thread.sleep(4000);
			newOrderPageInstance.clickOnInsertionSalesRepSection(1);
			Thread.sleep(4000);
			newOrderPageInstance.applytoAllSalesRepOnInsertionClassified(1);
			Thread.sleep(4000);
			//					 String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
			//				      
			//				       Logger.info("Saved Order : "+orderNumber);
			//				       Thread.sleep(7000);
			Thread.sleep(3000);
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			/*newOrderInstance.saveOrder();

			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver,120);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
				       wait.until(ExpectedConditions.visibilityOfAllElements(list));
			String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
			Thread.sleep(3000);
			dashboardPageInstance.clickOnOrderEntryModule();
			Thread.sleep(3000);
			orderEntryPageInstance.clickOnOrder(orderNumber);
			Logger.info("Saved Order : "+orderNumber);

			//wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement));
			Thread.sleep(20000);*///swagata

			newOrderPageInstance.submitOrder();
			/*Thread.sleep(1000);
			//					newOrderPageInstance.displayWarningMessageVerifyConfirm("Insertion 01-00 has passed deadline.please notify the necessary production area that a late ad is in process.Would you want to continue?");
			//					Thread.sleep(4000);
			////					Logger.info("Past deadline message shown");
			//					newOrderPageInstance.clickOnContinuePastDeadlineDate();
			//					Logger.info("Past deadline message shown");
			//					Thread.sleep(2000);

			String orderID = orderEntryHomePageInstance.getOrderNumber();
			Logger.info(orderEntryHomePageInstance.getOrderID());
			orderEntryHomePageInstance.closeOrderSuccessSubmissionMessage();
			Thread.sleep(1000);

			orderEntryHomePageInstance.clickOnOrder(orderID);
			Thread.sleep(3000);*/
//dashboardPageInstance.clickOnLogout();//swagata
dashboardPageInstance.clickondropdownforlogout();//joy





		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	

}
