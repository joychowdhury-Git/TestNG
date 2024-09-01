package com.tribune.adit2.test;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.PricingAdmin.PricingAdminPage;
import com.tribune.adit2.ProductAdmin.GeneralInfo;
import com.tribune.adit2.ProductAdmin.ProductAdminPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

import junit.framework.Assert;


public class ProductAdmin {
	/**
	 * Validate-Product Implentation Activation Days of Week and Section Level-Recurrence

	 *///swagata



	@Test(groups = {"DaysOfWeekSectionLevel","NovMaintenance","productAdmin","PrioritizedReg3","NewDev","NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void DaysOfWeekSectionLevel(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.ProductAdminModule();
			Thread.sleep(8000); 
			ProductAdminPage ProductAdminPageInstance = PageFactory.initElements(driver, ProductAdminPage.class);

			ProductAdminPageInstance.clickBuCaret("CTC-CTMG");
			Thread.sleep(2000); 

			ProductAdminPageInstance.AddProductButton("CTC-CTMG");
			Thread.sleep(8000); 

			ProductAdminPageInstance.selectProductType("Alternative");

			String NewProductName=ProductAdminPageInstance.ProductName();
			Thread.sleep(2000);
			Logger.info("Product name is:"+NewProductName);

			ProductAdminPageInstance.selectFinanceTab();

			ProductAdminPageInstance.selectGeneralInfoTab();



			ProductAdminPageInstance.selectActiveDaysofWeekTab();

			WebElement InactiveCheckBox=driver.findElement(By.xpath("//div[text()='Monday']/../../../div/div[2]/div/input"));
			InactiveCheckBox.click();

			ProductAdminPageInstance.selectGeneralInfoTab();


			ProductAdminPageInstance.ProductButtonSave();
			ProductAdminPageInstance.checkIfSuccessMsgAppears();//swagata

			/*String ProductId =ProductAdminPageInstance.getProductId();
		       Logger.info("Product Id is:"+ProductId);
		       Thread.sleep(2000);*///swagata

			ProductAdminPageInstance.ExpandBU("CTC-CTMG");
			Thread.sleep(2000);
			ProductAdminPageInstance.ExpandProductType("Alternative");
			Thread.sleep(4000);


			ProductAdminPageInstance.NewProductCaret(NewProductName);

			ProductAdminPageInstance.AddSection(NewProductName);//swagata

			String SectionName=ProductAdminPageInstance.SectionName();
			Logger.info("Section name is:"+SectionName);

			ProductAdminPageInstance.selectRecurrenceTab();

			Assert.assertEquals(false, ProductAdminPageInstance.isClickable());

			Logger.info("This day is inactive");
			Thread.sleep(5000);

			/**
			 * Validate-Product Implementation Activation Days of Week in Order Entry Level 

			 */

			dashboardPageInstance.clickOnOrderEntryModule();

			OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			basicOrderSearch.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class); 
			//Partha for new creative fee opt out
			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);//
			newOrderInstance.createNewInsertion();
			newOrderInstance.selectBU("1", 17, 0);

			newOrderInstance.enterPubDate("1","13","Jan", "2021");

			Thread.sleep(5000);

			newOrderInstance.selectProductType("1","Alternative");

			Thread.sleep(3000);


			Assert.assertEquals(true, newOrderInstance.validateProduct(NewProductName,"1"));

			newOrderInstance.enterPubDate("1","18","Jan", "2021");
			Thread.sleep(5000);

			Assert.assertEquals(false, newOrderInstance.validateProduct(NewProductName,"1"));
			Thread.sleep(2000);

			Logger.info("Product Combination is avilable only for the selected days ");

            dashboardPageInstance.clickOnLogout();
			//newOrderInstance.displayWarningMessageConfirm();//swagata
		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * Validate-Product Implentation Activation Days of Week in Order Entry Level 

	 *///swagata

	/*	@Test(groups = {"DaysOfWeekOrderEntryLevel"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void DaysOfWeekOrderEntryLevel(Map<String, String> userData) throws Exception
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

		       OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       basicOrderSearch.clickOnNewGeneralOrder();

		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class); 

		       newOrderInstance.createNewInsertion();


		       newOrderInstance.enterPubDate("1","25","Dec", "2019");

		       Thread.sleep(5000);

		       newOrderInstance.selectProductTypeByIndex("1",5);

		       Thread.sleep(3000);


		       Assert.assertEquals(true, newOrderInstance.validateProduct(NewProductName,"1"));

              newOrderInstance.enterPubDate("1","23","Dec", "2019");
              Thread.sleep(5000);

		       Assert.assertEquals(false, newOrderInstance.validateProduct(NewProductName,"1"));
	              Thread.sleep(2000);

           Logger.info("Product Combination is avilable only for the selected days ");
			   }

			   catch(Exception e)
			   {
				   Logger.error(e.getMessage());
					throw e;
			   }
		}*/
	/**
	 * Validate Position Management
     *///swagata

	@Test(groups = {"SMaintenance","ValidatePositionManagement","NovMaintenance","PrioritizedReg3","productAdmin","NewDev","NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void ValidatePositionManagement(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.ProductAdminModule();
			Thread.sleep(8000); 
			ProductAdminPage ProductAdminPageInstance = PageFactory.initElements(driver, ProductAdminPage.class);



			ProductAdminPageInstance.clickBuCaret("CTC-CTMG");
			Thread.sleep(2000); 

			ProductAdminPageInstance.AddProductButton("CTC-CTMG");
			Thread.sleep(8000); 

			ProductAdminPageInstance.selectProductType("Display");

			String NewProductName=ProductAdminPageInstance.ProductName();
			Logger.info("Product name is:"+NewProductName);
			Thread.sleep(2000);

			ProductAdminPageInstance.SelectAdTypeManagementTab();

			WebElement AdTypeCheckBox=driver.findElement(By.xpath("//*[text()='Use for this Product']/../../../../../../../../../../div[2]/div/div/div/div[3]/div/input"));
			AdTypeCheckBox.click();

			String Position=ProductAdminPageInstance.SelectPositionManagementTab();

			ProductAdminPageInstance.selectFinanceTab();

			ProductAdminPageInstance.selectGeneralInfoTab();

			ProductAdminPageInstance.ProductButtonSave();
			ProductAdminPageInstance.checkIfSuccessMsgAppears();//swagata


			/*String ProductId =ProductAdminPageInstance.getProductId();
			Logger.info("Product Id is:"+ProductId);
			Thread.sleep(2000);*///swagata

			ProductAdminPageInstance.ExpandBU("CTC-CTMG");
			Thread.sleep(5000);

			ProductAdminPageInstance.ExpandProductType("Display");



			Thread.sleep(5000);


			ProductAdminPageInstance.NewProductCaret(NewProductName);


			ProductAdminPageInstance.AddSection(NewProductName);//swagata

			ProductAdminPageInstance.selectPositionAssignmentTab();

			Assert.assertEquals(Position, ProductAdminPageInstance.getPositionName(Position));

			Logger.info("Position is Validated");

			dashboardPageInstance.clickOnLogout();//swagata

		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * Validate that only Alternative Digital products 
	 * that have "Digital Services Product" checked in Product
	 *  Admin should appear in this section by BU


	 *///swagata

	@Test(groups = {"ValidateAlternativeDigitalProducts","productAdmin","NewDev","NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ValidateAlternativeDigitalProducts(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.ProductAdminModule();
			Thread.sleep(8000); 
			ProductAdminPage ProductAdminPageInstance = PageFactory.initElements(driver, ProductAdminPage.class);

			ProductAdminPageInstance.clickBuCaret("CTC-CTMG");
			Thread.sleep(2000); 

			ProductAdminPageInstance.AddProductButton("CTC-CTMG");
			Thread.sleep(3000); 

			ProductAdminPageInstance.selectProductType("Alternative Digital");

			String NewProductName=ProductAdminPageInstance.ProductName();
			Thread.sleep(8000);

			ProductAdminPageInstance.DigitalServicesProductCheckBox(true);


			ProductAdminPageInstance.selectFinanceTab();

			ProductAdminPageInstance.selectGeneralInfoTab();

			ProductAdminPageInstance.ProductButtonSave();
			Thread.sleep(20000);

			OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			basicOrderSearch.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);

			newOrderInstance.createNewDigitalOrder();

			newOrderInstance.selectBuInDigitalService("CTC");


			Assert.assertEquals(true, newOrderInstance.selectProductInDigitalService(NewProductName));

			Logger.info("Digital Services Product checked Alternative Digital products is  Validated");


		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/**
	 * Validate Auto insertion

	 *///swagata


	@Test(groups = {"SMaintenance1","ValidateAutoInsertion","NovMaintenance","NewDev","productAdmin","PrioritizedReg3","NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void ValidateAutoInsertion(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.ProductAdminModule();
			Thread.sleep(8000); 
			ProductAdminPage ProductAdminPageInstance = PageFactory.initElements(driver, ProductAdminPage.class);

			ProductAdminPageInstance.clickBuCaret("CTC-CTMG");
			Thread.sleep(2000); 

			ProductAdminPageInstance.AddProductButton("CTC-CTMG");
			Thread.sleep(4000); 

			String ProdType="Display";

			ProductAdminPageInstance.selectProductType(ProdType);

			String NewProductName=ProductAdminPageInstance.ProductName();
			Thread.sleep(2000);

			Logger.info("Product name is :"+NewProductName);
			ProductAdminPageInstance.selectFinanceTab();

			ProductAdminPageInstance.SelectAdTypeManagementTab();

			WebElement AdTypeCheckBox=driver.findElement(By.xpath("//*[text()='Use for this Product']/../../../../../../../../../../div[2]/div/div/div/div[3]/div/input"));
			AdTypeCheckBox.click();

			String Position=ProductAdminPageInstance.SelectPositionManagementTab();


			ProductAdminPageInstance.selectGeneralInfoTab();

			ProductAdminPageInstance.ProductButtonSave();
			ProductAdminPageInstance.checkIfSuccessMsgAppears();//swagata

			/* String ProductId =ProductAdminPageInstance.getProductId();
				       Logger.info("Product Id is:"+ProductId);
				       Thread.sleep(5000);*///swagata

			ProductAdminPageInstance.ExpandBU("CTC-CTMG");
			Thread.sleep(5000);

			ProductAdminPageInstance.ExpandProductType("Display");
			Thread.sleep(5000);



			ProductAdminPageInstance.NewProductCaret(NewProductName);


			ProductAdminPageInstance.AddSection(NewProductName);//swagata


			ProductAdminPageInstance.SectionName();

			String SectionName=ProductAdminPageInstance.SectionName();
			Logger.info("Product name is :"+SectionName);

			ProductAdminPageInstance.SectionButtonSave();

			ProductAdminPageInstance.checkIfSuccessMsgAppears();//swagata

			Thread.sleep(2000);


			ProductAdminPageInstance.ClickOnBU("CTC-CTMG");

			Thread.sleep(5000);

			ProductAdminPageInstance.selectAutoInsertionManagementTab();

			ProductAdminPageInstance.AddbuttonInAutoInsMangTab();

			//   String productName=ProductAdminPageInstance.selectMatchedProduct("CareerBuilder.com (Online)");

			String productName=ProductAdminPageInstance.selectMatchedProduct(NewProductName,ProdType);
			//partha
			ProductAdminPageInstance.selectMatchedOrderType("Standard");
			ProductAdminPageInstance.minSalesPrice("10");

			//ProductAdminPageInstance.selectCreateProduct("Ad Lights Billboard (Events/Sponsorships");

			ProductAdminPageInstance.selectCreateProduct(productName);

			ProductAdminPageInstance.createPercentage("5");

			ProductAdminPageInstance.okButton();

			ProductAdminPageInstance.saveButton();

			Thread.sleep(2000);

			ProductAdminPageInstance.searchMatchedProduct(productName);

			ProductAdminPageInstance.editButton();

			ProductAdminPageInstance.minSalesPrice("12");

			String  MinSalesPrice= ProductAdminPageInstance.getMinSalesPrice();

			ProductAdminPageInstance.okButton();

			ProductAdminPageInstance.saveButton();
			Thread.sleep(3000);

			//ProductAdminPageInstance.checkIfSuccessMsgAppears();//swagata
			Thread.sleep(3000);
			ProductAdminPageInstance.searchMatchedProduct(productName);

			ProductAdminPageInstance.editButton();

			String MinSalesPriceAfterEdit =ProductAdminPageInstance.getMinSalesPrice();

			Assert.assertEquals(MinSalesPrice, MinSalesPriceAfterEdit);

			Logger.info("Auto insertion is updated:Validated");
			ProductAdminPageInstance.okButton();//swagata

			Thread.sleep(4000); 
			dashboardPageInstance.clickOnLogout();//swagata





		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	} 

	/**
	 * Validate that Page Type and Page Count modifiers are present in the pricing modifier.

	 *///swagata


	@Test(groups = {"PageTypeCountModifier","productAdmin","PrioritizedReg3","NewDev","NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public  void PageTypeCountModifier(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.ProductAdminModule();
			Thread.sleep(8000); 
			ProductAdminPage ProductAdminPageInstance = PageFactory.initElements(driver, ProductAdminPage.class);

			ProductAdminPageInstance.clickBuCaret("CTC-CTMG");
			Thread.sleep(2000); 

			ProductAdminPageInstance.AddProductButton("CTC-CTMG");
			Thread.sleep(3000); 
			String ProdType="Preprint";

			ProductAdminPageInstance.selectProductType(ProdType);

			String NewProductName=ProductAdminPageInstance.ProductName();

			ProductAdminPageInstance.selectPricingModel("Size");


			ProductAdminPageInstance.selectFinanceTab();

			ProductAdminPageInstance.selectGeneralInfoTab();

			ProductAdminPageInstance.ProductButtonSave();
			Thread.sleep(20000);

			dashboardPageInstance.clickOnPricingModule();

			Thread.sleep(3000);
			PricingAdminPage PricingAdminPageInstance = PageFactory.initElements(driver, PricingAdminPage.class);

			PricingAdminPageInstance.clickOnTheMentionedBU("CTC-CTMG");
			Thread.sleep(2000);


			PricingAdminPageInstance.clickOnTheMentionedProductType(ProdType);
			Thread.sleep(2000);


			PricingAdminPageInstance.clickOnTheMentionedProduct(NewProductName);




			String PageTypes= PricingAdminPageInstance.getOptionFromTheAttributeTable("Page Types");

			Assert.assertEquals("Page Types" , PageTypes);
			// Logger.info("got page types");

			String PageCounts= PricingAdminPageInstance.getOptionFromTheAttributeTable("Page Counts");
			Assert.assertEquals("Page Counts" , PageCounts);




			Logger.info("Page Type and Page Count modifiers are present in the pricing modifier");


		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	} 

	/**
	 * Validate that Weight modifier is coming instead of Page Type and Page Count modifiers in the pricing modifier.

	 */

	@Test(groups = {"WeightModifier","productAdmin","NewDev","PrioritizedReg3","NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void WeightModifier(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.ProductAdminModule();
			Thread.sleep(8000); 
			ProductAdminPage ProductAdminPageInstance = PageFactory.initElements(driver, ProductAdminPage.class);

			ProductAdminPageInstance.clickBuCaret("CTC-CTMG");
			Thread.sleep(2000); 

			ProductAdminPageInstance.AddProductButton("CTC-CTMG");
			Thread.sleep(3000); 
			String ProdType="Preprint";

			ProductAdminPageInstance.selectProductType(ProdType);

			String NewProductName=ProductAdminPageInstance.ProductName(); 

			ProductAdminPageInstance.selectPricingModel("Weight");

			ProductAdminPageInstance.selectFinanceTab();

			ProductAdminPageInstance.selectGeneralInfoTab();


			ProductAdminPageInstance.ProductButtonSave();
			Thread.sleep(20000);

			dashboardPageInstance.clickOnPricingModule();

			Thread.sleep(8000);

			PricingAdminPage PricingAdminPageInstance = PageFactory.initElements(driver, PricingAdminPage.class);


			PricingAdminPageInstance.clickOnTheMentionedBU("CTC-CTMG");
			Thread.sleep(2000);
			PricingAdminPageInstance.clickOnTheMentionedProductType(ProdType);
			Thread.sleep(2000);



			PricingAdminPageInstance.clickOnTheMentionedProduct(NewProductName);

			String Weights= PricingAdminPageInstance.getOptionFromTheAttributeTable("Weights");
			// Logger.info(Weights);
			Assert.assertEquals("Weights" , Weights);

			Logger.info("Weight modifier is coming instead of Page Type and Page Count modifiers in the pricing modifier.");
			dashboardPageInstance.clickOnLogout();

		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	} 



	/**
	 * Validate price is showing properly ,it should /should not round off the price

	 *///swagata

	@Test(groups = {"SMaintenance","ValidateProductType","productAdmin","NewDev","NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void ValidateProductType(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.ProductAdminModule();
			Thread.sleep(8000); 
			ProductAdminPage ProductAdminPageInstance = PageFactory.initElements(driver, ProductAdminPage.class);

			ProductAdminPageInstance.ClickOnBU("CTC-CTMG");

			ProductAdminPageInstance.selectProductTypesTab();

			ProductAdminPageInstance.roundToNearestCheckBox(true);
			ProductAdminPageInstance.save();

			Thread.sleep(20000);

			dashboardPageInstance.clickOnPricingModule();

			Thread.sleep(3000);
			PricingAdminPage PricingAdminPageInstance = PageFactory.initElements(driver, PricingAdminPage.class);

			PricingAdminPageInstance.refreshButton();
			Thread.sleep(20000);

			OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			basicOrderSearch.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			//Partha for new creative fee opt out
			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);//
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);

			newOrderInstance.selectBUWithoutExcel("1","bu_CTC");//swagata

			Thread.sleep(2000);

			newOrderInstance.enterPubDate("1","13","Jan", "2021");

			Thread.sleep(5000);

			newOrderInstance.selectProductType("1","Preprint");

			Thread.sleep(3000);

			newOrderInstance.validateProduct("CT-Ad Note","1");

			newOrderInstance.viewInsertionDetails("1");

			newOrderInstance.checkUncheckBillQty(false);
			Thread.sleep(3000);	
			newOrderInstance.enterBilledQty(5);
			Thread.sleep(3000);

			String price=newOrderInstance.getBasePrice("base");

			Logger.info(price);

			Assert.assertEquals("$0.00", newOrderInstance.getBasePrice("base"));



			dashboardPageInstance.ProductAdminModule();

			newOrderInstance.clickOnConfirmationMsg("Yes");
			Thread.sleep(8000); 


			ProductAdminPageInstance.ClickOnBU("CTC-CTMG");

			ProductAdminPageInstance.selectProductTypesTab();

			ProductAdminPageInstance.roundToNearestCheckBox(true);
			ProductAdminPageInstance.save();

			Thread.sleep(20000);

			dashboardPageInstance.clickOnPricingModule();

			Thread.sleep(3000);

			PricingAdminPageInstance.refreshButton();
			Thread.sleep(20000);

			basicOrderSearch.clickOnNewGeneralOrder();
			//Partha for new creative fee opt out
			newOrderInstance.selectSoldToCustomerBU("bu_LAT");
			newOrderInstance.enterSoldToCustomer("CU00059747");
			newOrderInstance.selectBilltoSameAsSoldTo();
			newOrderInstance.selectOrderType("OrderType_Standard");
			newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
			newOrderInstance.checkUncheckOwnLocalOptOut(true);//

			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);

			newOrderInstance.selectBUWithoutExcel("1","bu_CTC");//swagata

			Thread.sleep(2000);

			newOrderInstance.enterPubDate("1","13","Jan", "2021");

			Thread.sleep(5000);

			newOrderInstance.selectProductType("1","Preprint");

			Thread.sleep(3000);

			newOrderInstance.validateProduct("CT-Ad Note","1");

			newOrderInstance.viewInsertionDetails("1");

			newOrderInstance.checkUncheckBillQty(false);
			Thread.sleep(3000);	
			newOrderInstance.enterBilledQty(5);
			Thread.sleep(3000);

			String price1=newOrderInstance.getBasePrice("base");

			Logger.info(price1);

			// Assert.assertEquals("$##.##", newOrderInstance.getBasePrice("base"));




			Thread.sleep(8000);





		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * Validate Ad Size management and assignment

	 *///swagata

	@Test(groups = {"AdSizeManagement","productAdmin","PrioritizedReg3","NewDev","NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void AdSizeManagement(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.ProductAdminModule();
			Thread.sleep(8000); 
			ProductAdminPage ProductAdminPageInstance = PageFactory.initElements(driver, ProductAdminPage.class);

			ProductAdminPageInstance.ClickOnBU("CTC-CTMG");

			ProductAdminPageInstance.selectGeneralInfo();

			Thread.sleep(3000);


			ProductAdminPageInstance.selectAdSizeMng();

			ProductAdminPageInstance.selectAdSizeManagementExp();

			String value=ProductAdminPageInstance.getBlockValue();


			String ColumnModelValue=ProductAdminPageInstance.getValueOfColumnModel();


			ProductAdminPageInstance.ExpandBU("CTC-CTMG");
			Thread.sleep(2000);

			ProductAdminPageInstance.ExpandProductType("Display");
			Thread.sleep(2000);

			ProductAdminPageInstance.ExpandCreatedProduct("Chicago Tribune");
			Thread.sleep(2000);

			ProductAdminPageInstance.ClickOnSection("Arts");

			Thread.sleep(4000);

			ProductAdminPageInstance.selectMiscellaneousTab();

			ProductAdminPageInstance.selectColumnModel(ColumnModelValue);

			ProductAdminPageInstance.selectAdSizeAssignmentTab();

			ProductAdminPageInstance.selectAdSizeAssignmentExp();

			String valueSame=ProductAdminPageInstance.getBlockValueInSection();


			Assert.assertEquals(value, valueSame);
			Logger.info(" Ad Size management and assignment is Validated");






		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}   
	/**
	 * Validate that a new field order type is added in Auto Insertion Management module at rule level when rule type is legacy

	 *///swagata


	@Test(groups = {"NewRegression3","ValidateAutoInsertionOrderTypeField"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void ValidateAutoInsertionOrderTypeField(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.ProductAdminModule();
			Thread.sleep(8000); 
			ProductAdminPage ProductAdminPageInstance = PageFactory.initElements(driver, ProductAdminPage.class);


			ProductAdminPageInstance.ClickOnBU("CTC-CTMG");

			Thread.sleep(5000);

			ProductAdminPageInstance.selectAutoInsertionManagementTab();

			ProductAdminPageInstance.AddbuttonInAutoInsMangTab();
			ProductAdminPageInstance.selectAutoinsertion("Legacy");

			//String productName=ProductAdminPageInstance.selectMatchedProduct("Display","Display");

			ProductAdminPageInstance.minSalesPrice("10");

			//ProductAdminPageInstance.selectCreateProduct(productName);
			ProductAdminPageInstance.okButton();
			ProductAdminPageInstance.checkIfAlertMsgAppears();
			
			ProductAdminPageInstance.selectOrderTypes();
			
			ProductAdminPageInstance.selectAutoinsertion("OwnLocal");
			ProductAdminPageInstance.selectOrderTypes();
			
			Thread.sleep(2000);

			Logger.info("Auto insertion is updated:Validated");
			ProductAdminPageInstance.cancelButton();

			Thread.sleep(4000); 
			dashboardPageInstance.clickOnLogout();





		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	} 

}   




