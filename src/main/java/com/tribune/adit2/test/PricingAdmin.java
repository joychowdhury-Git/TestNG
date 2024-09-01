package com.tribune.adit2.test;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
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
import com.tribune.adit2.OrderEntry.ClassifiedOrderOptions;
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

public class PricingAdmin {

	/**
	 * Create closed range ad modifiers
	 * Delete closed range modifier



	 *///swagata



	@Test(groups = {"CreateDeleteClosedRangeModifier","NovMaintenance","pricingAdmin","NewDev","PrioritizedReg3","NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void CreateDeleteClosedRangeModifier(Map<String, String> userData) throws Exception
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

			Thread.sleep(3000);
			PricingAdminPage PricingAdminPageInstance = PageFactory.initElements(driver, PricingAdminPage.class);

			PricingAdminPageInstance.clickOnTheMentionedBU("CTC-CTMG");

			PricingAdminPageInstance.clickOnTheMentionedProductType("Alternative");

			PricingAdminPageInstance.clickOnTheMentionedProduct("445 Windows");//swagata

			PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Baseline");//swagata
			Thread.sleep(2000);
			PricingAdminPageInstance.goToManageTab();

			PricingAdminPageInstance.clickTheRightArrowAndSelectDate();
			PricingAdminPageInstance.creatModifier("10","Target");//swagata
			Thread.sleep(3000);

			PricingAdminPageInstance.deleteFutureModifier();
			Thread.sleep(3000);

			PricingAdminPageInstance.clickOkInConfirmMessage();

			Thread.sleep(2000);
			dashboardPageInstance.clickOnLogout();//swagata

		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	} 

	/**
	 * The new charge is shown when adding charges to an order line 
	 * Also price is being calculated correctly 



	 *///swagata



	@Test(groups = {"SMaintenance","CreateChargesFeeDiscounts","NovMaintenance","PrioritizedReg3","NewDev","NewRegression3","NewRegression","pricingAdmin"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void CreateChargesFeeDiscounts(Map<String, String> userData) throws Exception
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

			PricingAdminPage PricingAdminPageInstance = PageFactory.initElements(driver, PricingAdminPage.class);

			PricingAdminPageInstance.clickOnTheMentionedBU("CTC-CTMG");

			PricingAdminPageInstance.clickOnTheMentionedProductType("Display");

			PricingAdminPageInstance.clickOnTheMentionedProduct("Chicago Tribune");

			PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Fees/Discounts");

			PricingAdminPageInstance.clickAddFeesDiscounts("2 Color");//swagata

			PricingAdminPageInstance.clickOnDefaultModifier("2");

			Thread.sleep(5000);


			PricingAdminPageInstance.refreshButton();

			Thread.sleep(8000);

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

			newOrderInstance.enterPubDate("1","25","Dec", "2021");

			Thread.sleep(5000);

			newOrderInstance.selectProductType("1","Display");

			Thread.sleep(3000);

			newOrderInstance.validateProduct("Chicago Tribune","1");

			newOrderInstance.viewInsertionDetails("1");

			newOrderInstance.clickOnAddOnMagnifier();

			Thread.sleep(3000);



			newOrderInstance.addFirstAddOn();

			//  String AddonPrice=newOrderInstance.getAddOnCharges();

			double AddonPrice=newOrderInstance.getInsertionPrice("1","addon charge");
			Logger.info("Addon "+AddonPrice);
			double salesPrice=newOrderInstance.getInsertionPrice("1","sales");
			Logger.info("salesPrice "+salesPrice);
			double netPrice=newOrderInstance.getInsertionPrice("1","net");
			Logger.info("netPrice "+netPrice);

			double sum=	AddonPrice+salesPrice;       
			Logger.info("Sum value is:"+sum);
			sum =Double.parseDouble(new DecimalFormat("##.##").format(sum));
			Logger.info("Sum value is:"+sum);
			//String sum=String.valueOf(Double.parseDouble(SalesPrice)+Double.parseDouble(AddonPrice));
			//Logger.info(sum);

			//   sum=String.format(sum, "%2f");
			

			Assert.assertEquals(netPrice, sum);
			//if(netPrice==sum)
			Logger.info("The new charge is shown when adding charges to an order line Also price is being calculated correctly");
			dashboardPageInstance.clickOnPricingModule();
			newOrderInstance.displayWarningMessageConfirm();
			

			Thread.sleep(3000);

			PricingAdminPageInstance.clickOnTheMentionedBU("CTC-CTMG");

			PricingAdminPageInstance.clickOnTheMentionedProductType("Display");

			PricingAdminPageInstance.clickOnTheMentionedProduct("Chicago Tribune");

			PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Fees/Discounts");

			PricingAdminPageInstance.clickOnAddedFeesDiscounts("2 Color");

			PricingAdminPageInstance.deleteFeesDiscounts();

			PricingAdminPageInstance.clickOkInConfirmMsg();
			PricingAdminPageInstance.refreshButton();//swagata
			Thread.sleep(2000);
			dashboardPageInstance.clickOnLogout();//swagata

	}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/**
	 * Create a Variable fee with Preprint product Customer Supplied /Other
	 *  Test with a Positive price modifier on Var fee


	 *///swagata



	@Test(groups = {"PositivePriceModifierOnVariableFee","NewDev","NewRegression3","NewRegression","pricingAdmin"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void PositivePriceModifierOnVariableFee(Map<String, String> userData) throws Exception
	{
		try
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

				Thread.sleep(3000);
				PricingAdminPage PricingAdminPageInstance = PageFactory.initElements(driver, PricingAdminPage.class);

				PricingAdminPageInstance.clickOnTheMentionedBU("CTC-CTMG");

				PricingAdminPageInstance.clickOnTheMentionedProductType("Preprint");

				Thread.sleep(2000);


				PricingAdminPageInstance.clickOnTheMentionedProduct("CT-Preprints");

				Thread.sleep(8000);
				/*String Adtype="Preprint";
				String Pagetype="Tab Cust Sup";
				String count="2";
				String preprintType="Customer Supplied / Other";
				String minValue="57000";*/
				TribuneUtils utils  = new TribuneUtils();//swagata
				int intValue = utils.randomInteger(5);//swagata
				String minValue= String.valueOf(intValue);//swagata
				PricingAdminPageInstance.clickOnVariableFees("AdType_PricingAdminPage_Preprint","PP_PaperType_TabCustSup","2","Preprint_SettingsType_CustSupplied",minValue);//swagata

				Thread.sleep(6000);

				PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Variable Fees");
				Thread.sleep(4000);


				PricingAdminPageInstance.goToNewCreatedVariableFees("AdType_PricingAdminPage_Preprint","PP_PaperType_TabCustSup","2","Preprint_SettingsType_CustSupplied",minValue);//swagata
				Thread.sleep(5000);

				double value= PricingAdminPageInstance.clickOnDefaultModifierInVarFees("2");
				Logger.info("Default Modifier value "+value);

				Thread.sleep(5000);


				PricingAdminPageInstance.refreshButton();

				Thread.sleep(8000);
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

				newOrderInstance.selectBUWithoutExcel("1","bu_CTC");

				Thread.sleep(2000);

				newOrderInstance.enterPubDate("1","13","Jan", "2021");

				Thread.sleep(5000);

				newOrderInstance.selectProductType("1","Preprint");

				Thread.sleep(3000);

				newOrderInstance.validateProduct("CT-Preprints","1");

				newOrderInstance.viewInsertionDetails("1");
				newOrderInstance.selectTypeInSettingsPreprintOrder("1","Preprint_SettingsType_CustSupplied");//swagata


				newOrderInstance.selectPageType("1", "PP_PaperType_TabCustSup");//swagata



				double salesRateBeforeBilledQtyIsChecked= newOrderInstance.getPreprintInsertionPrice("1","salesRate");

				Logger.info("Sales rate before billed Quantity is checked "+salesRateBeforeBilledQtyIsChecked);


				double sum=salesRateBeforeBilledQtyIsChecked+value;

				newOrderInstance.checkUncheckBillQty(false);
				Thread.sleep(3000);	
				newOrderInstance.enterBilledQty(Integer.parseInt(minValue));
				Thread.sleep(5000);
				double salesRate= newOrderInstance.getPreprintInsertionPrice("1","salesRate");
				Logger.info("Sales rate when billed Quantity is checked "+salesRate);


				Assert.assertEquals(salesRate, sum); 
				Logger.info("Test is verified with a Negaitive price modifier on Variable fee with Preprint product Customer Supplied /Other");
				//delete functionality is added @swagata
				dashboardPageInstance.clickOnPricingModule();
				Thread.sleep(2000);

				newOrderInstance.displayWarningMessageConfirm();


				Thread.sleep(3000);


					       PricingAdminPageInstance.clickOnTheMentionedBU("CTC-CTMG");

					       PricingAdminPageInstance.clickOnTheMentionedProductType("Preprint");

					       Thread.sleep(2000);


					       PricingAdminPageInstance.clickOnTheMentionedProduct("CT-Preprints");

					       PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Variable Fees");
					       Thread.sleep(2000);


							PricingAdminPageInstance.goToNewCreatedVariableFees("AdType_PricingAdminPage_Preprint","PP_PaperType_TabCustSup","2","Preprint_SettingsType_CustSupplied",minValue);//swagata

			            PricingAdminPageInstance.deleteVariableFees();

			            PricingAdminPageInstance.clickOkInConfirmMsg();
			            Thread.sleep(4000);
						PricingAdminPageInstance.refreshButton();

				 
				dashboardPageInstance.clickOnLogout();


			}

			catch(Exception e)
			{
				Logger.error(e.getMessage());
				throw e;
			}
		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/**
	 * Create a Variable fee with Preprint product Customer Supplied /Other
	 *  Test with a Negative price modifier on Var fee


	 *///swagata



	@Test(groups = {"NegativePriceModifierOnVariableFee","NewDev","NewRegression3","PrioritizedReg3","NewRegression","pricingAdmin"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void NegativePriceModifierOnVariableFee(Map<String, String> userData) throws Exception
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

			Thread.sleep(3000);
			PricingAdminPage PricingAdminPageInstance = PageFactory.initElements(driver, PricingAdminPage.class);

			PricingAdminPageInstance.clickOnTheMentionedBU("CTC-CTMG");

			PricingAdminPageInstance.clickOnTheMentionedProductType("Preprint");

			Thread.sleep(2000);


			PricingAdminPageInstance.clickOnTheMentionedProduct("CT-Preprints");

			Thread.sleep(8000);
			/*String Adtype="Preprint";
			String Pagetype="Tab Cust Sup";
			String count="2";
			String preprintType="Customer Supplied / Other";
			String minValue="57000";*/
			TribuneUtils utils  = new TribuneUtils();//swagata
			int intValue = utils.randomInteger(5);//swagata
			String minValue= String.valueOf(intValue);//swagata
			PricingAdminPageInstance.clickOnVariableFees("AdType_PricingAdminPage_Preprint","PP_PaperType_TabCustSup","2","Preprint_SettingsType_CustSupplied",minValue);//swagata

			Thread.sleep(6000);

			PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Variable Fees");
			Thread.sleep(4000);


			PricingAdminPageInstance.goToNewCreatedVariableFees("AdType_PricingAdminPage_Preprint","PP_PaperType_TabCustSup","2","Preprint_SettingsType_CustSupplied",minValue);//swagata
			Thread.sleep(5000);

			double value= PricingAdminPageInstance.clickOnDefaultModifierInVarFees("-2");
			Logger.info("Default Modifier value "+value);

			Thread.sleep(5000);


			PricingAdminPageInstance.refreshButton();

			Thread.sleep(8000);
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

			newOrderInstance.selectBUWithoutExcel("1","bu_CTC");

			Thread.sleep(2000);

			newOrderInstance.enterPubDate("1","13","Jan", "2021");

			Thread.sleep(5000);

			newOrderInstance.selectProductType("1","Preprint");

			Thread.sleep(3000);

			newOrderInstance.validateProduct("CT-Preprints","1");

			newOrderInstance.viewInsertionDetails("1");
			newOrderInstance.selectTypeInSettingsPreprintOrder("1","Preprint_SettingsType_CustSupplied");//swagata


			newOrderInstance.selectPageType("1", "PP_PaperType_TabCustSup");//swagata



			double salesRateBeforeBilledQtyIsChecked= newOrderInstance.getPreprintInsertionPrice("1","salesRate");

			Logger.info("Sales rate before billed Quantity is checked "+salesRateBeforeBilledQtyIsChecked);


			double sum=salesRateBeforeBilledQtyIsChecked+value;

			newOrderInstance.checkUncheckBillQty(false);
			Thread.sleep(3000);	
			newOrderInstance.enterBilledQty(Integer.parseInt(minValue));
			Thread.sleep(5000);
			double salesRate= newOrderInstance.getPreprintInsertionPrice("1","salesRate");
			Logger.info("Sales rate when billed Quantity is checked "+salesRate);


			Assert.assertEquals(salesRate, sum); 
			Logger.info("Test is verified with a Negaitive price modifier on Variable fee with Preprint product Customer Supplied /Other");
			//delete functionality is added @swagata
			dashboardPageInstance.clickOnPricingModule();
			Thread.sleep(2000);

			newOrderInstance.displayWarningMessageConfirm();


			Thread.sleep(3000);


				       PricingAdminPageInstance.clickOnTheMentionedBU("CTC-CTMG");

				       PricingAdminPageInstance.clickOnTheMentionedProductType("Preprint");

				       Thread.sleep(2000);


				       PricingAdminPageInstance.clickOnTheMentionedProduct("CT-Preprints");

				       PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Variable Fees");
				       Thread.sleep(2000);


						PricingAdminPageInstance.goToNewCreatedVariableFees("AdType_PricingAdminPage_Preprint","PP_PaperType_TabCustSup","2","Preprint_SettingsType_CustSupplied",minValue);//swagata

		            PricingAdminPageInstance.deleteVariableFees();

		            PricingAdminPageInstance.clickOkInConfirmMsg();
		            Thread.sleep(4000);
					PricingAdminPageInstance.refreshButton();

			 
			dashboardPageInstance.clickOnLogout();


		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * Creating Var fee for P&D Combined Rate 
	 *  Test with a Positive price modifier on Var fee


	 *///swagata



	@Test(groups = {"PositivePriceModifierOnVariableFeePAndD","NovMaintenance","NewDev","NewRegression3","PrioritizedReg3","NewRegression","pricingAdmin"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void PositivePriceModifierOnVariableFeePandD(Map<String, String> userData) throws Exception
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

			Thread.sleep(3000);
			PricingAdminPage PricingAdminPageInstance = PageFactory.initElements(driver, PricingAdminPage.class);

			PricingAdminPageInstance.clickOnTheMentionedBU("DPR-Daily Press");

			PricingAdminPageInstance.clickOnTheMentionedProductType("Preprint");

			Thread.sleep(2000);


			PricingAdminPageInstance.clickOnTheMentionedProduct("P&D Paid Distribu...");

			Thread.sleep(8000);
			/*String Adtype="Preprint";
			String Pagetype="8.5x11 Sgl Sheet";
			String count="2";
			String preprintType="P&D Combined Rate";
			String minValue="55000";*/
			TribuneUtils utils  = new TribuneUtils();//swagata
			int intValue = utils.randomInteger(5);//swagata
			String minValue= String.valueOf(intValue);//swagata
			PricingAdminPageInstance.clickOnVariableFees("ProductType_Preprint","PageType_PricingAdminPage_8.5x11SglSheet","2","Preprint_SettingsType_PDCombined",minValue);//swagata
			Thread.sleep(6000);

			PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Variable Fees");
			Thread.sleep(4000);


			  PricingAdminPageInstance.goToNewCreatedVariableFees("ProductType_Preprint","PageType_PricingAdminPage_8.5x11SglSheet","2","Preprint_SettingsType_PDCombined",minValue);//swagata
				Thread.sleep(5000);

			double value= PricingAdminPageInstance.clickOnDefaultModifierInVarFees("2");
			Logger.info("Default Modifier value "+value);

			Thread.sleep(5000);


			PricingAdminPageInstance.refreshButton();

			Thread.sleep(8000);
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

			newOrderInstance.selectBUWithoutExcel("1","bu_DPR");//swagata
			Thread.sleep(2000);

			newOrderInstance.enterPubDate("1","13","Jan", "2021");

			Thread.sleep(5000);

			newOrderInstance.selectProductType("1","Preprint");

			Thread.sleep(3000);

			newOrderInstance.validateProduct("P&D Paid Distribution","1");

			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);

			newOrderInstance.selectTypeInSettingsPreprintOrder("1","Preprint_SettingsType_PDCombined");//swagata

			newOrderInstance.selectPageType("1", "PageType_PricingAdminPage_8.5x11SglSheet");//swagata


			newOrderInstance.enterPageCount("2");
			Thread.sleep(2000);


			double baseRateBeforeBilledQtyIsChecked= newOrderInstance.getPreprintInsertionPrice("1","baseRate");//swagata

			Logger.info("Base rate before billed Quantity is checked "+baseRateBeforeBilledQtyIsChecked);//swagata


			double sum=baseRateBeforeBilledQtyIsChecked+value;//swagata

			newOrderInstance.checkUncheckBillQty(false);
			Thread.sleep(3000);	
			newOrderInstance.enterBilledQty(Integer.parseInt(minValue));
			Thread.sleep(5000);
			double baseRate= newOrderInstance.getPreprintInsertionPrice("1","baseRate");//swagata
			Logger.info("Base rate when billed Quantity is checked "+baseRate);//swagata


			Assert.assertEquals(baseRate, sum); //swagata
			Logger.info("Test is verified with a Positive price modifier on Variable fee with Preprint Combined Rate");
			//delete functionality is added @swagata

			dashboardPageInstance.clickOnPricingModule();
			Thread.sleep(2000);

			newOrderInstance.displayWarningMessageConfirm();


			Thread.sleep(3000);

				       PricingAdminPageInstance.clickOnTheMentionedBU("DPR-Daily Press");

				       PricingAdminPageInstance.clickOnTheMentionedProductType("Preprint");

				       Thread.sleep(2000);


				       PricingAdminPageInstance.clickOnTheMentionedProduct("P&D Paid Distribu...");

				       Thread.sleep(8000);

				       PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Variable Fees");
				       Thread.sleep(2000);


						  PricingAdminPageInstance.goToNewCreatedVariableFees("ProductType_Preprint","PageType_PricingAdminPage_8.5x11SglSheet","2","Preprint_SettingsType_PDCombined",minValue);//swagata
						Thread.sleep(6000);
		            PricingAdminPageInstance.deleteVariableFees();

					PricingAdminPageInstance.clickOkInConfirmMsg();
					Thread.sleep(2000);
					Logger.info("Successfully deleted Positive VariableFee For P&D Combined rate Product ");

					PricingAdminPageInstance.refreshButton();

					dashboardPageInstance.clickOnLogout();//swagata

		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * Creating Var fee for P&D Combined Rate 
	 *  Test with a Negative price modifier on Var fee


	 *///swagata



	@Test(groups = {"NegativePriceModifierOnVariableFeePAndD","NovMaintenance","pricingAdmin","NewDev","NewRegression3","NewRegression","pricingAdmin"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void NegativePriceModifierOnVariableFeePandD(Map<String, String> userData) throws Exception
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
			TribuneUtils utils  = new TribuneUtils();//swagata
			Thread.sleep(3000);
			PricingAdminPage PricingAdminPageInstance = PageFactory.initElements(driver, PricingAdminPage.class);

			PricingAdminPageInstance.clickOnTheMentionedBU("DPR-Daily Press");

			PricingAdminPageInstance.clickOnTheMentionedProductType("Preprint");

			Thread.sleep(2000);


			PricingAdminPageInstance.clickOnTheMentionedProduct("P&D Paid Distribu...");

			Thread.sleep(8000);
			/*String Adtype="Preprint";
			String Pagetype="8.5x11 Sgl Sheet";
			String count="2";
			String preprintType="P&D Combined Rate";
			String minValue="59000";*///swagata
			int intValue = utils.randomInteger(5);//swagata
			String minValue= String.valueOf(intValue);//swagata
			PricingAdminPageInstance.clickOnVariableFees("ProductType_Preprint","PageType_PricingAdminPage_8.5x11SglSheet","2","Preprint_SettingsType_PDCombined",minValue);//swagata
			Thread.sleep(6000);

			PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Variable Fees");
			Thread.sleep(4000);

			PricingAdminPageInstance.goToNewCreatedVariableFees("ProductType_Preprint","PageType_PricingAdminPage_8.5x11SglSheet","2","Preprint_SettingsType_PDCombined",minValue);//swagata
			Thread.sleep(5000);

			double value= PricingAdminPageInstance.clickOnDefaultModifierInVarFees("-2");
			Logger.info("Default Modifier value "+value);

			Thread.sleep(5000);


			PricingAdminPageInstance.refreshButton();

			Thread.sleep(8000);
			OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			basicOrderSearch.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			
			newOrderInstance.checkUncheckOwnLocalOptOut(true);//swagata

			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);

			newOrderInstance.selectBUWithoutExcel("1","bu_DPR");//swagata

			Thread.sleep(2000);

			newOrderInstance.enterPubDate("1","13","Jan", "2021");

			Thread.sleep(5000);

			newOrderInstance.selectProductType("1","Preprint");

			Thread.sleep(3000);

			newOrderInstance.validateProduct("P&D Paid Distribution","1");

			newOrderInstance.viewInsertionDetails("1");
			Thread.sleep(4000);

			newOrderInstance.selectTypeInSettingsPreprintOrder("1","Preprint_SettingsType_PDCombined");//swagata

			newOrderInstance.selectPageType("1", "PageType_PricingAdminPage_8.5x11SglSheet");//swagata

			newOrderInstance.enterPageCount("2");
			Thread.sleep(2000);


			double baseRateBeforeBilledQtyIsChecked= newOrderInstance.getPreprintInsertionPrice("1","baseRate");

			Logger.info("Base rate before billed Quantity is checked "+baseRateBeforeBilledQtyIsChecked);


			double sum=baseRateBeforeBilledQtyIsChecked+value;

			newOrderInstance.checkUncheckBillQty(false);
			Thread.sleep(3000);	
			newOrderInstance.enterBilledQty(Integer.parseInt(minValue));
			Thread.sleep(5000);
			double baseRate= newOrderInstance.getPreprintInsertionPrice("1","baseRate");
			Logger.info("Base rate when billed Quantity is checked "+baseRate);


			Assert.assertEquals(baseRate, sum); 
			Logger.info("Test is verified with a Negaitive price modifier on Variable fee with Preprint Combined Rate");
			//delete functionality is added @swagata

			dashboardPageInstance.clickOnPricingModule();
			Thread.sleep(2000);

			newOrderInstance.displayWarningMessageConfirm();


			Thread.sleep(3000);

				       PricingAdminPageInstance.clickOnTheMentionedBU("DPR-Daily Press");

				       PricingAdminPageInstance.clickOnTheMentionedProductType("Preprint");

				       Thread.sleep(2000);


				       PricingAdminPageInstance.clickOnTheMentionedProduct("P&D Paid Distribu...");

				       Thread.sleep(8000);

				       PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Variable Fees");
				       Thread.sleep(2000);


				       PricingAdminPageInstance.goToNewCreatedVariableFees("ProductType_Preprint","PageType_PricingAdminPage_8.5x11SglSheet","2","Preprint_SettingsType_PDCombined",minValue);//swagata
						Thread.sleep(5000);
		            PricingAdminPageInstance.deleteVariableFees();

					PricingAdminPageInstance.clickOkInConfirmMsg();
					Thread.sleep(2000);
					Logger.info("Successfully deleted Negative VariableFee For P&D Combined rate Product ");

					PricingAdminPageInstance.refreshButton();

					dashboardPageInstance.clickOnLogout();//swagata




		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/**
	 * Create % pricing for Classified SubCategory
	 *  Create a Classified Package Order and verify pricing



	 *///swagata



	@Test(groups = {"PercentagePricingForClassifiedSubCategories"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void PercentagePricingClassifiedSubCategories(Map<String, String> userData) throws Exception
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

			Thread.sleep(3000);
			PricingAdminPage PricingAdminPageInstance = PageFactory.initElements(driver, PricingAdminPage.class);

			PricingAdminPageInstance.clickOnTheMentionedBU("Sun Sentinel");

			PricingAdminPageInstance.clickOnTheMentionedProductType("Classified Listings");

			Thread.sleep(2000);


			PricingAdminPageInstance.clickOnSunSentinelProduct();
			//clickOnTheMentionedProduct("Sun Sentinel");



			PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Classified SubCategories");

			Thread.sleep(5000);

			PricingAdminPageInstance.goClassifiedSubCategories("Legal: Notices","1 Column","126.000000");


			double value= PricingAdminPageInstance.getValueOfDefaultModifier();
			Logger.info("Default Modifier value "+value);

			Thread.sleep(5000);


			PricingAdminPageInstance.refreshButton();

			Thread.sleep(8000);
			OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			basicOrderSearch.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
			Thread.sleep(3000);
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("1",13, 0);
			Thread.sleep(2000);

			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwnByIndex(2);
			classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(1);
			classifiedOrderInstance.selectClassifiedPackageByIndex(0);
			classifiedOrderInstance.selectClassifiedClassCodeByIndex(0);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();		       
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(52000);		       

			classifiedOrderInstance.clickEditAdBtn();

			Thread.sleep(15000);

			classifiedOrderInstance.uploadAd("1",13,6);

			Thread.sleep(52000);	

			newOrderInstance.saveOrder();

			Thread.sleep(6000);

			Double PriceDetails=newOrderInstance.getValueFromPriceDetails();
			Logger.info("Classified Subcategory Price value "+PriceDetails);

			Assert.assertEquals(value, PriceDetails);


			//div[text()='ClassifiedSubcategory']/../..//div[contains(text(),'38.5000 %')]


			Logger.info("Verified pricing for Classified Package Order ");





		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/**
	 * Create a Var Fee for Weight based product HTF ''Valumail PP' Page Type 'Broadsheet'
	 * Create an order and verify Var fee is being calculated correctly

	 *///swagata





	@Test(groups = {"SMaintenance","PositiveVariableFeeForWeightTypeProduct","NovMaintenance","pricingAdmin","NewDev","NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void PositiveVariableFeeForWeightTypeProduct(Map<String, String> userData) throws Exception
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
			TribuneUtils utils  = new TribuneUtils();//swagata


			Thread.sleep(6000);
			PricingAdminPage PricingAdminPageInstance = PageFactory.initElements(driver, PricingAdminPage.class);

			PricingAdminPageInstance.clickOnTheMentionedBU("HTF-CT1 Media");

			PricingAdminPageInstance.clickOnTheMentionedProductType("Preprint");

			Thread.sleep(2000);


			PricingAdminPageInstance.clickOnTheMentionedProduct("HC Extra Flavor");

			Thread.sleep(8000);
			/*String Adtype="Preprint";
			String Pagetype="Broadsheet";
			String count="2";
			String preprintType="Customer Supplied / Other";
			String minValue="55000";
			String Weight="0.25";*///swagata
			
			int intValue = utils.randomInteger(5);//swagata
			String minValue= String.valueOf(intValue);//swagata
			PricingAdminPageInstance.clickOnVariableFeesForWeightTypeProduct("Preprint","Broadsheet","2","Preprint_SettingsType_CustSupplied","0.25",minValue);//swagata
			Thread.sleep(8000);

			PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Variable Fees");

			PricingAdminPageInstance.goToNewCreatedVariableFeesForWeightTypeProduct("Preprint","Broadsheet","Preprint_SettingsType_CustSupplied","0.25",minValue);//swagata
			Thread.sleep(5000);

			double value= PricingAdminPageInstance.clickOnDefaultModifierInVarFees("2");
			Thread.sleep(5000);

			Logger.info("Default Modifier value "+value);



			PricingAdminPageInstance.refreshButton();

			Thread.sleep(8000);
			OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			basicOrderSearch.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);//swagata
			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);

			newOrderInstance.selectBUWithoutExcel("1","bu_HTF");//swagata

			Thread.sleep(2000);

			newOrderInstance.enterPubDate("1","16","Jan", "2021");

			Thread.sleep(5000);

			newOrderInstance.selectProductType("1","Preprint");

			Thread.sleep(3000);

			newOrderInstance.validateProduct("HC Extra Flavor","1");

			newOrderInstance.viewInsertionDetails("1");

			newOrderInstance.selectPageType("1", "PP_PaperType_Broadsheet");//swagata

			newOrderInstance.enterPageweight("0.25");
			Thread.sleep(5000);

			double baseRateBeforeBilledQtyIsChecked= newOrderInstance.getPreprintInsertionPrice("1","baseRate");//swagata

			Logger.info("Base rate before billed Quantity is checked "+baseRateBeforeBilledQtyIsChecked);//swagata


			double sum=baseRateBeforeBilledQtyIsChecked+value;//swagata

			newOrderInstance.checkUncheckBillQty(false);
			Thread.sleep(3000);	
			newOrderInstance.enterBilledQty(Integer.parseInt(minValue));
			Thread.sleep(5000);
			double baseRate= newOrderInstance.getPreprintInsertionPrice("1","baseRate");//swagata
			Logger.info("Base rate when billed Quantity is checked "+baseRate);//swagata



			Assert.assertEquals(baseRate, sum); //swagata
			Logger.info("Test is verified with a Positive price modifier on Variable fee with Weight Type Product");
			//delete functionality is added @swagata

			dashboardPageInstance.clickOnPricingModule();
			newOrderInstance.displayWarningMessageConfirm();


			Thread.sleep(3000);

			PricingAdminPageInstance.clickOnTheMentionedBU("HTF-CT1 Media");

			PricingAdminPageInstance.clickOnTheMentionedProductType("Preprint");

			Thread.sleep(2000);


			PricingAdminPageInstance.clickOnTheMentionedProduct("HC Extra Flavor");


			PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Variable Fees");

			PricingAdminPageInstance.goToNewCreatedVariableFeesForWeightTypeProduct("Preprint","Broadsheet","Preprint_SettingsType_CustSupplied","0.25",minValue);//swagata
			PricingAdminPageInstance.deleteVariableFees();

			PricingAdminPageInstance.clickOkInConfirmMsg();
			Thread.sleep(2000);
			Logger.info("Successfully deleted Positive VariableFee For WeightType Product ");

			PricingAdminPageInstance.refreshButton();

			dashboardPageInstance.clickOnLogout();//swagata



		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * Create a Var Fee for Weight based product HTF ''Valumail PP' Page Type 'Broadsheet'
	 * Create an order and verify Negaitive Var fee is being calculated correctly

	 *///swagata





	@Test(groups = {"SMaintenance1","NegaitiveVariableFeeForWeightTypeProduct","NovMaintenance","pricingAdmin","NewDev","NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void NegaitiveVariableFeeForWeightTypeProduct(Map<String, String> userData) throws Exception
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
			TribuneUtils utils  = new TribuneUtils();//swagata

			Thread.sleep(6000);
			PricingAdminPage PricingAdminPageInstance = PageFactory.initElements(driver, PricingAdminPage.class);

			PricingAdminPageInstance.clickOnTheMentionedBU("HTF-CT1 Media");

			PricingAdminPageInstance.clickOnTheMentionedProductType("Preprint");

			Thread.sleep(2000);


			//PricingAdminPageInstance.clickOnTheMentionedProduct("HC Inside Shopper");
			PricingAdminPageInstance.clickOnTheMentionedProduct("HC Extra Flavor");
			
			Thread.sleep(8000);
			/*String Adtype="Preprint";
			String Pagetype="Broadsheet";
			String count="2";
			String preprintType="Customer Supplied / Other";
			String minValue="56000";
			String Weight="0.25";*///swagata
			int intValue = utils.randomInteger(5);//swagata
			String minValue= String.valueOf(intValue);//swagata
			PricingAdminPageInstance.clickOnVariableFeesForWeightTypeProduct("Preprint","Broadsheet","2","Preprint_SettingsType_CustSupplied","0.25",minValue);//swagata
			Thread.sleep(8000);

			PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Variable Fees");

			PricingAdminPageInstance.goToNewCreatedVariableFeesForWeightTypeProduct("Preprint","Broadsheet","Preprint_SettingsType_CustSupplied","0.25",minValue);//swagata
			Thread.sleep(5000);

			double value= PricingAdminPageInstance.clickOnDefaultModifierInVarFees("-2");
			Thread.sleep(5000);

			Logger.info("Default Modifier value "+value);



			PricingAdminPageInstance.refreshButton();

			Thread.sleep(8000);
			OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			basicOrderSearch.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
			newOrderInstance.checkUncheckOwnLocalOptOut(true);//swagata

			newOrderInstance.createNewInsertion();
			Thread.sleep(4000);

			newOrderInstance.selectBUWithoutExcel("1","bu_HTF");//swagata

			Thread.sleep(2000);

			newOrderInstance.enterPubDate("1","16","Jan", "2021");

			Thread.sleep(5000);

			newOrderInstance.selectProductType("1","Preprint");

			Thread.sleep(5000);

			//newOrderInstance.validateProduct("HC Inside Shopper","1");
			newOrderInstance.validateProduct("HC Extra Flavor","1");

			newOrderInstance.viewInsertionDetails("1");

			newOrderInstance.selectPageType("1", "PP_PaperType_Broadsheet");//swagata

			newOrderInstance.enterPageweight("0.25");
			Thread.sleep(3000);

			double baseRateBeforeBilledQtyIsChecked= newOrderInstance.getPreprintInsertionPrice("1","baseRate");//swagata

			Logger.info("Sales rate before billed Quantity is checked "+baseRateBeforeBilledQtyIsChecked);


			double sum=baseRateBeforeBilledQtyIsChecked+value;

			newOrderInstance.checkUncheckBillQty(false);
			Thread.sleep(3000);	
			newOrderInstance.enterBilledQty(Integer.parseInt(minValue));
			Thread.sleep(5000);
			double baseRate= newOrderInstance.getPreprintInsertionPrice("1","baseRate");//swagata
			Logger.info("Base rate when billed Quantity is checked "+baseRate);//swagata



			Assert.assertEquals(baseRate, sum); 
			Logger.info("Test is verified with a Negaitive price modifier on Variable fee with Weight Type Product");
			//delete functionality is added @swagata

			dashboardPageInstance.clickOnPricingModule();
			newOrderInstance.displayWarningMessageConfirm();


			Thread.sleep(3000);

			PricingAdminPageInstance.clickOnTheMentionedBU("HTF-CT1 Media");

			PricingAdminPageInstance.clickOnTheMentionedProductType("Preprint");

			Thread.sleep(2000);


			PricingAdminPageInstance.clickOnTheMentionedProduct("HC Extra Flavor");


			PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Variable Fees");

			PricingAdminPageInstance.goToNewCreatedVariableFeesForWeightTypeProduct("Preprint","Broadsheet","Preprint_SettingsType_CustSupplied","0.25",minValue);//swagata
			PricingAdminPageInstance.deleteVariableFees();

			PricingAdminPageInstance.clickOkInConfirmMsg();
			Thread.sleep(3000);
			Logger.info("Successfully deleted Negaitive VariableFee For WeightType Product ");

			PricingAdminPageInstance.refreshButton();

			dashboardPageInstance.clickOnLogout();//swagata


		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/**
	 * Create Fixed pricing for Classified SubCategory
	 *  Create a Classified Package Order and verify pricing



	 *///swagata



	@Test(groups = {"FixedPricingForClassifiedSubCategories"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void FixedPricingClassifiedSubCategories(Map<String, String> userData) throws Exception
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

			Thread.sleep(3000);
			PricingAdminPage PricingAdminPageInstance = PageFactory.initElements(driver, PricingAdminPage.class);

			PricingAdminPageInstance.clickOnTheMentionedBU("DPR-Daily Press");

			PricingAdminPageInstance.clickOnTheMentionedProductType("Classified Listings");

			Thread.sleep(2000);


			PricingAdminPageInstance.clickOnTheMentionedProduct("Daily Press");




			PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Classified SubCategories");

			Thread.sleep(5000);

			PricingAdminPageInstance.goClassifiedSubCategories("Automotive","1 Column","1.037000");


			double value= PricingAdminPageInstance.getValueOfDefaultModifier();
			Logger.info("Default Modifier value "+value);

			Thread.sleep(5000);


			PricingAdminPageInstance.refreshButton();

			Thread.sleep(8000);
			OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			basicOrderSearch.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
			Thread.sleep(3000);
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("1",2, 0);
			Thread.sleep(2000);

			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwnByIndex(0);
			classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(1);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			classifiedOrderInstance.selectClassifiedClassCodeByIndex(0);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();		       
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(52000);		       

			classifiedOrderInstance.clickEditAdBtn();

			Thread.sleep(15000);

			classifiedOrderInstance.uploadAd("1",13,6);

			Thread.sleep(52000);	

			newOrderInstance.saveOrder();

			Thread.sleep(6000);

			Double PriceDetails=newOrderInstance.getValueFromPriceDetails();
			Logger.info("Classified Subcategory Price value "+PriceDetails);

			Assert.assertEquals(value, PriceDetails);


			//div[text()='ClassifiedSubcategory']/../..//div[contains(text(),'38.5000 %')]


			Logger.info("Verified pricing for Classified Package Order ");





		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/**
	 * Create Fixed pricing for Classified SubCategory
	 *  Create a Classified Package Order and verify pricing



	 *///swagata



	@Test(groups = {"CPIPricingForClassifiedSubCategories"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void CPIPricingClassifiedSubCategories(Map<String, String> userData) throws Exception
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

			Thread.sleep(3000);
			PricingAdminPage PricingAdminPageInstance = PageFactory.initElements(driver, PricingAdminPage.class);

			PricingAdminPageInstance.clickOnTheMentionedBU("DPR-Daily Press");

			PricingAdminPageInstance.clickOnTheMentionedProductType("Classified Listings");

			Thread.sleep(2000);


			PricingAdminPageInstance.clickOnTheMentionedProduct("Daily Press");




			PricingAdminPageInstance.clickOnTheMentionedOptionFromTheAttributeTable("Classified SubCategories");

			Thread.sleep(5000);

			PricingAdminPageInstance.goClassifiedSubCategories("Automotive","1 Column","0.578667");


			double value= PricingAdminPageInstance.getValueOfDefaultModifier();
			Logger.info("Default Modifier value "+value);

			Thread.sleep(5000);


			PricingAdminPageInstance.refreshButton();

			Thread.sleep(8000);
			OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			basicOrderSearch.clickOnNewGeneralOrder();

			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);

			ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
			Thread.sleep(3000);
			newOrderInstance.createNewClassifiedInsertion();
			Thread.sleep(4000);
			classifiedOrderInstance.selectPackageBU("1",2, 0);
			Thread.sleep(2000);

			classifiedOrderInstance.selectClassifiedSubcategoryDrpDwnByIndex(0);
			classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(1);
			classifiedOrderInstance.selectClassifiedPackageByIndex(2);
			classifiedOrderInstance.selectClassifiedClassCodeByIndex(0);
			classifiedOrderInstance.selectDate("nextmonth");
			classifiedOrderInstance.selectSingleZone();		       
			classifiedOrderInstance.clickApplyBtn();

			Thread.sleep(52000);		       

			classifiedOrderInstance.clickEditAdBtn();

			Thread.sleep(15000);

			classifiedOrderInstance.uploadAd("1",13,6);

			Thread.sleep(52000);	

			newOrderInstance.saveOrder();

			Thread.sleep(6000);

			Double PriceDetails=newOrderInstance.getValueFromPriceDetails();
			Logger.info("Classified Subcategory Price value "+PriceDetails);

			Assert.assertEquals(value, PriceDetails);


			//div[text()='ClassifiedSubcategory']/../..//div[contains(text(),'38.5000 %')]


			Logger.info("Verified pricing for Classified Package Order ");





		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

}



