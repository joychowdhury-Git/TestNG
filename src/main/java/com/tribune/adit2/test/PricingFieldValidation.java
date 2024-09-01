package com.tribune.adit2.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.PricingAdmin.PricingAdminPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

import junit.framework.Assert;

public class PricingFieldValidation 
{


	@Test(groups = {"SMaintenance","CustomerSearch","SwagataMou", "NovMaintenance","Regression","PrioritizedReg3", "StgRegression", "DaysOfWeekModifiers", "NewRegression3","NewRegression","pricingAdmin"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void daysOfWeekModifiersValidate(Map<String, String> userData) throws Exception
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
			String pricingTab = "Pricing";
			String productTab = "Product";

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);

			PricingAdminPage pricingAdminPage = PageFactory.initElements(driver, PricingAdminPage.class);
			String buName = TribuneUtils.getStringCellValues(pricingTab,1, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			String productTypeName = TribuneUtils.getStringCellValues(pricingTab,1, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			String productName = TribuneUtils.getStringCellValues(pricingTab,1, 2);
			String optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,1, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);//swagata
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTable);
			ArrayList<String> listOfDatasForSelectedOptionFromTheAttributeTableForPricing = pricingAdminPage.getListOfDatasForSelectedOptionFromTheAttributeTable();

			dashboardPageInstance.clickOnTheRequiredModule(productTab);

			buName = TribuneUtils.getStringCellValues(pricingTab,1, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			productTypeName = TribuneUtils.getStringCellValues(pricingTab,1, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			productName = TribuneUtils.getStringCellValues(pricingTab,1, 2);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,1, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			String tabName = TribuneUtils.getStringCellValues(pricingTab,1, 4);
			pricingAdminPage.clickOnTheMentionedTabInProduct(tabName);

			int checkedInputsSizeInProductTable = pricingAdminPage.getListOfCheckedInputsInProductTable();
			Assert.assertEquals(listOfDatasForSelectedOptionFromTheAttributeTableForPricing.size(), checkedInputsSizeInProductTable);

			pricingAdminPage.checkIfTheDatasSelectedInPricingOnlyAreShowingInProductCheckboxForDaysOfWeek(listOfDatasForSelectedOptionFromTheAttributeTableForPricing);


			dashboardPageInstance.clickOnLogout();//swagata






		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		catch(AssertionError e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}	


	@Test(groups = {"CustomerSearch", "pricingAdmin","Regression","PrioritizedReg3", "StgRegression", "zoneModifiersValidate","NewRegression3", "NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void zoneModifiersValidate(Map<String, String> userData) throws Exception
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
			String pricingTab = "Pricing";
			String productTab = "Product";

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);

			PricingAdminPage pricingAdminPage = PageFactory.initElements(driver, PricingAdminPage.class);
			String buName = TribuneUtils.getStringCellValues(pricingTab,1, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			String productTypeName = TribuneUtils.getStringCellValues(pricingTab,1, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			String productName = TribuneUtils.getStringCellValues(pricingTab,1, 2);
			String optionInAttributeTableForPricing = TribuneUtils.getStringCellValues(pricingTab,2, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTableForPricing);
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTableForPricing);
			ArrayList<String> listOfDatasForSelectedOptionFromTheAttributeTableForPricing = pricingAdminPage.getListOfDatasForSelectedOptionFromTheAttributeTable();

			dashboardPageInstance.clickOnTheRequiredModule(productTab);

			buName = TribuneUtils.getStringCellValues(pricingTab,1, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			productTypeName = TribuneUtils.getStringCellValues(pricingTab,1, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			productName = TribuneUtils.getStringCellValues(pricingTab,1, 2);
			optionInAttributeTableForPricing = TribuneUtils.getStringCellValues(pricingTab,2, 4);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTableForPricing);
			String tabName = TribuneUtils.getStringCellValues(pricingTab,2, 4);
			pricingAdminPage.clickOnTheMentionedTabInProduct(tabName);

			String headingInZoneTable = TribuneUtils.getStringCellValues(pricingTab,2, 5);

			int totalDatasUnderMentionedHeadingInZoneTable = pricingAdminPage.getListOfDatasUnderMentionedHeadingInZoneTable(headingInZoneTable);
			Assert.assertEquals(listOfDatasForSelectedOptionFromTheAttributeTableForPricing.size(), totalDatasUnderMentionedHeadingInZoneTable);

			pricingAdminPage.checkIfTheDatasSelectedInPricingOnlyAreShowingInProductZoneManagementUnderTheMentionedHeading(headingInZoneTable, listOfDatasForSelectedOptionFromTheAttributeTableForPricing);

			dashboardPageInstance.clickOnLogout();//swagata




		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		catch(AssertionError e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}	



	@Test(groups = {"CustomerSearch", "Regression","pricingAdmin","PrioritizedReg3", "StgRegression", "AdTypeModifiers", "NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void  adTypeModifiersValidate(Map<String, String> userData) throws Exception
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
			String pricingTab = "Pricing";
			String productTab = "Product";

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPageInstance.clickOnTheRequiredModule(productTab);

			PricingAdminPage pricingAdminPage = PageFactory.initElements(driver, PricingAdminPage.class);
			String buName = TribuneUtils.getStringCellValues(pricingTab,1, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			String productTypeName = TribuneUtils.getStringCellValues(pricingTab,1, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			String productName = TribuneUtils.getStringCellValues(pricingTab,1, 2);
			String optionInAttributeTableForPricing = TribuneUtils.getStringCellValues(pricingTab,3, 4);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTableForPricing);
			String tabName = TribuneUtils.getStringCellValues(pricingTab,3, 4);
			pricingAdminPage.clickOnTheMentionedTabInProduct(tabName);


			String productUseCheckbox = "Use for this Product";

			int firstUncheckedCheckboxIdx;

			firstUncheckedCheckboxIdx = pricingAdminPage.noteTheFirstUncheckedCheckboxIndexAndCheckIt(productUseCheckbox);

			String checkboxName = pricingAdminPage.noteTheNameOfTheLatestCheckedCheckbox(firstUncheckedCheckboxIdx);

			pricingAdminPage.clickOnSaveBtnInTheProductPg();

			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);

			buName = TribuneUtils.getStringCellValues(pricingTab,1, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			productTypeName = TribuneUtils.getStringCellValues(pricingTab,1, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			productName = TribuneUtils.getStringCellValues(pricingTab,1, 2);
			String optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,3, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTable);
			pricingAdminPage.checkIfTheSelectedOrTypedDataFromProductIsShowingInPricing(checkboxName);

			dashboardPageInstance.clickOnTheRequiredModule(productTab);

			/*buName = TribuneUtils.getStringCellValues(pricingTab,1, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			productTypeName = TribuneUtils.getStringCellValues(pricingTab,1, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			productName = TribuneUtils.getStringCellValues(pricingTab,1, 2);*///swagata
			optionInAttributeTableForPricing = TribuneUtils.getStringCellValues(pricingTab,3, 4);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTableForPricing);//swagata
			tabName = TribuneUtils.getStringCellValues(pricingTab,3, 4);
			pricingAdminPage.clickOnTheMentionedTabInProduct(tabName);

			pricingAdminPage.uncheckTheLatestCheckedCheckboxInAdTYpeManagement(firstUncheckedCheckboxIdx);

			pricingAdminPage.clickOnSaveBtnInTheProductPg();

			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);
            Thread.sleep(3000);
			buName = TribuneUtils.getStringCellValues(pricingTab,1, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			productTypeName = TribuneUtils.getStringCellValues(pricingTab,1, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			productName = TribuneUtils.getStringCellValues(pricingTab,1, 2);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,3, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTable);
			pricingAdminPage.checkIfTheLastSelectedUncheckedCheckboxFromProductIsNotShowingInPricing(checkboxName);

			dashboardPageInstance.clickOnLogout();//swagata


		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		catch(AssertionError e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"SMaintenance","CustomerSearch","SwagataMou","positionModifiersModifiersValidate" ,"pricingAdmin","NovMaintenance","Regression", "StgRegression", "PositionModifiers","NewRegression3", "NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void  positionModifiersModifiersValidate(Map<String, String> userData) throws Exception
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
			String pricingTab = "Pricing";
			String productTab = "Product";



			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);

			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);
//partha for BSC display selected product position field is empty, so trying for dpr
			PricingAdminPage pricingAdminPage = PageFactory.initElements(driver, PricingAdminPage.class);
			String buName = TribuneUtils.getStringCellValues(pricingTab,9, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			String productTypeName = TribuneUtils.getStringCellValues(pricingTab,9, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			String productName = TribuneUtils.getStringCellValues(pricingTab,9, 2);
			String optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,4, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTable);
			String subOptionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,10, 6);//swagata
			pricingAdminPage.clickOnTheMentionedSubOptionFromTheAttributeTable(subOptionInAttributeTable);//swagata
			int nrOfDatasPresentInTheSelectedOptionFromTheAttributeTable = pricingAdminPage.getNumberOfDatasForSelectedAdtypeinPricingAdmin(subOptionInAttributeTable);
			Logger.info("No of data in pricing admin"+ nrOfDatasPresentInTheSelectedOptionFromTheAttributeTable);
			dashboardPageInstance.clickOnTheRequiredModule(productTab);

			buName = TribuneUtils.getStringCellValues(pricingTab,9, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			productTypeName = TribuneUtils.getStringCellValues(pricingTab,9, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			productName = TribuneUtils.getStringCellValues(pricingTab,9, 2);
			String optionInAttributeTableForPricing = TribuneUtils.getStringCellValues(pricingTab,4, 4);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTableForPricing);
			String tabName = TribuneUtils.getStringCellValues(pricingTab,4, 4);
			pricingAdminPage.clickOnTheMentionedTabInProduct(tabName);
		//	pricingAdminPage.expandTheLatestProductTableBlockAddButtonIfPresentAndCollapsed();//issue//swagata
			//pricingAdminPage.checkIfTheNumberOfDatasPresentInAdTypeTableMatchesWithTheNotedNrOfDatasPresentInPricing(nrOfDatasPresentInTheSelectedOptionFromTheAttributeTable);//swagata
			pricingAdminPage.clickOnAddBtnInProductTable();
			Thread.sleep(3000);
			pricingAdminPage.clickOnSaveBtnInTheProductPg();
			//partha
			driver.findElement(By.xpath("//a[contains(text(),'Zone Management')]")).click();;
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[contains(text(),'Position Management')]")).click();;
			Thread.sleep(5000);
			pricingAdminPage.expandAdvertorialAdtype();
			int nrOfDatasShowingInAddTypeTable = pricingAdminPage.getNrOfDatasPresentInAdTypeTable();//swagata

			Assert.assertEquals(1, (nrOfDatasShowingInAddTypeTable-nrOfDatasPresentInTheSelectedOptionFromTheAttributeTable));//swagata

			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);
			pricingAdminPage.clickOnRefreshPgBtnInPriciingPg();
			Thread.sleep(5000);
			productTypeName = TribuneUtils.getStringCellValues(pricingTab,9, 1);
			productName = TribuneUtils.getStringCellValues(pricingTab,9, 2);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,4, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedSubOptionFromTheAttributeTable(subOptionInAttributeTable);
			int nrOfDatasPresentInTheSelectedOptionFromTheAttributeTableAfterAddingOrDeleting = pricingAdminPage.getNumberOfDatasForSelectedAdtypeinPricingAdmin(subOptionInAttributeTable);//partha
			Logger.info("No of data in pricing admin"+ nrOfDatasPresentInTheSelectedOptionFromTheAttributeTable);
			Assert.assertEquals(1, (nrOfDatasPresentInTheSelectedOptionFromTheAttributeTableAfterAddingOrDeleting-nrOfDatasPresentInTheSelectedOptionFromTheAttributeTable));

			dashboardPageInstance.clickOnTheRequiredModule(productTab);

			productTypeName = TribuneUtils.getStringCellValues(pricingTab,9, 1);
			productName = TribuneUtils.getStringCellValues(pricingTab,9, 2);
			optionInAttributeTableForPricing = TribuneUtils.getStringCellValues(pricingTab,4, 4);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTableForPricing);
			tabName = TribuneUtils.getStringCellValues(pricingTab,4, 4);
			pricingAdminPage.clickOnTheMentionedTabInProduct(tabName);
			Thread.sleep(5000);
			//Partha
			//pricingAdminPage.expandTheLatestProductTableBlockAddButtonIfPresentAndCollapsed();
			pricingAdminPage.expandAdvertorialAdtype();
			//pricingAdminPage.checkIfTheNumberOfDatasPresentInAdTypeTableMatchesWithTheNotedNrOfDatasPresentInPricing(nrOfDatasPresentInTheSelectedOptionFromTheAttributeTableAfterAddingOrDeleting);//swagata
			pricingAdminPage.deleteTheLastlyAddedData(nrOfDatasShowingInAddTypeTable);
			pricingAdminPage.clickOnSaveBtnInTheProductPg();
			//Partha
			driver.findElement(By.xpath("//a[contains(text(),'Zone Management')]")).click();;
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[contains(text(),'Position Management')]")).click();;
			Thread.sleep(5000);
			pricingAdminPage.expandAdvertorialAdtype();
			nrOfDatasShowingInAddTypeTable = pricingAdminPage.getNrOfDatasPresentInAdTypeTable();

			//Assert.assertEquals(1, (nrOfDatasPresentInTheSelectedOptionFromTheAttributeTableAfterAddingOrDeleting-nrOfDatasShowingInAddTypeTable));//swagata
			Assert.assertEquals(1, (nrOfDatasPresentInTheSelectedOptionFromTheAttributeTableAfterAddingOrDeleting-nrOfDatasShowingInAddTypeTable));//swagata

			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);

			productTypeName = TribuneUtils.getStringCellValues(pricingTab,9, 1);
			productName = TribuneUtils.getStringCellValues(pricingTab,9, 2);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,4, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTable);
			//pricingAdminPage.clickOnTheMentionedSubOptionFromTheAttributeTable(subOptionInAttributeTable);//swagata
			nrOfDatasPresentInTheSelectedOptionFromTheAttributeTableAfterAddingOrDeleting = pricingAdminPage.getNumberOfDatasForSelectedAdtypeinPricingAdmin(subOptionInAttributeTable);//partha

			Assert.assertEquals(0, (nrOfDatasPresentInTheSelectedOptionFromTheAttributeTableAfterAddingOrDeleting-nrOfDatasPresentInTheSelectedOptionFromTheAttributeTable));
			dashboardPageInstance.clickOnLogout();//swagata

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		catch(AssertionError e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"SMaintenance","CustomerSearch", "Regression", "NovMaintenance","pricingAdmin","StgRegression", "classifiedSubCategoriesModifiersValidate","NewRegression3", "NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void  classifiedSubCategoriesModifiersValidate(Map<String, String> userData) throws Exception
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
			String pricingTab = "Pricing";
			String productTab = "Product";



			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);

			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);

			PricingAdminPage pricingAdminPage = PageFactory.initElements(driver, PricingAdminPage.class);
			String buName = TribuneUtils.getStringCellValues(pricingTab,5, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			String productTypeName = TribuneUtils.getStringCellValues(pricingTab,5, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			String productName = TribuneUtils.getStringCellValues(pricingTab,5, 2);
			String optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,5, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTable);
			String subOptionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,5, 6);
			pricingAdminPage.clickOnTheMentionedSubOptionFromTheAttributeTable(subOptionInAttributeTable);
			subOptionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,6, 6);
			pricingAdminPage.clickOnTheMentionedSubOptionFromTheAttributeTable(subOptionInAttributeTable);
			int nrOfDatasPresentInTheSelectedOptionFromTheAttributeTable = pricingAdminPage.getNumberOfDatasForSelectedOptionFromTheAttributeTable();

			dashboardPageInstance.clickOnTheRequiredModule(productTab);

			buName = TribuneUtils.getStringCellValues(pricingTab,5, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			productTypeName = TribuneUtils.getStringCellValues(pricingTab,5, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			productName = TribuneUtils.getStringCellValues(pricingTab,5, 2);
			String optionInAttributeTableForPricing = TribuneUtils.getStringCellValues(pricingTab,5, 4);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTableForPricing);
			String tabName = TribuneUtils.getStringCellValues(pricingTab,5, 4);
			pricingAdminPage.clickOnTheMentionedTabInProduct(tabName);
			String productTableHeading = TribuneUtils.getStringCellValues(pricingTab,5, 7);
			pricingAdminPage.clickOnAddBtnInProductTable();
			pricingAdminPage.scrollToBottomOftheTableUntilTheLastCreatedDataHavingIdAsZeroIsReached(productTableHeading, nrOfDatasPresentInTheSelectedOptionFromTheAttributeTable);
			String tblDataVal = pricingAdminPage.noteTheValueOfTheSecondLastDataInTheTable(productTableHeading);
			pricingAdminPage.clickOnSaveBtnInTheProductPg();
			Thread.sleep(10000);
			//partha
			 driver.findElement(By.xpath("//a[contains(text(),'Zone Management')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[contains(text(),'Classified Subcategories')]")).click();
				Thread.sleep(3000);
			String newDataCreated = pricingAdminPage.checkIfTheNewIdIsGeneratedAndNoteTheId(productTableHeading, tblDataVal);
			/*int nrOfDatasShowingInAddTypeTable = pricingAdminPage.getNrOfDatasPresentInProductTable(productTableHeading);

			
			Assert.assertEquals(1, (nrOfDatasShowingInAddTypeTable-nrOfDatasPresentInTheSelectedOptionFromTheAttributeTable));*/
			
			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);

			buName = TribuneUtils.getStringCellValues(pricingTab,5, 0);
			Thread.sleep(8000);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			productTypeName = TribuneUtils.getStringCellValues(pricingTab,5, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			productName = TribuneUtils.getStringCellValues(pricingTab,5, 2);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,5, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTable);
			subOptionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,5, 6);
			pricingAdminPage.clickOnTheMentionedSubOptionFromTheAttributeTable(subOptionInAttributeTable);
			subOptionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,6, 6);
			pricingAdminPage.clickOnTheMentionedSubOptionFromTheAttributeTable(subOptionInAttributeTable);
			int nrOfDatasPresentInTheSelectedOptionFromTheAttributeTableAfterAddingOrDeleting = pricingAdminPage.getNumberOfDatasForSelectedOptionFromTheAttributeTable();

			Assert.assertEquals(1, (nrOfDatasPresentInTheSelectedOptionFromTheAttributeTableAfterAddingOrDeleting-nrOfDatasPresentInTheSelectedOptionFromTheAttributeTable));

			dashboardPageInstance.clickOnTheRequiredModule(productTab);
			Thread.sleep(4000);
			buName = TribuneUtils.getStringCellValues(pricingTab,5, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			productTypeName = TribuneUtils.getStringCellValues(pricingTab,5, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			productName = TribuneUtils.getStringCellValues(pricingTab,5, 2);
			optionInAttributeTableForPricing = TribuneUtils.getStringCellValues(pricingTab,5, 4);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTableForPricing);
			tabName = TribuneUtils.getStringCellValues(pricingTab,5, 4);
			pricingAdminPage.clickOnTheMentionedTabInProduct(tabName);
			pricingAdminPage.scrollToBottomOftheTableUntilTheLatestCreatedIdIsReached(productTableHeading, newDataCreated);
			 pricingAdminPage.deleteTheLastlyAddedData();
			 pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			 Thread.sleep(3000);
			 pricingAdminPage.clickOnSaveBtnInTheProductPg();
			//nrOfDatasShowingInAddTypeTable = pricingAdminPage.getNrOfDatasPresentInProductTable(productTableHeading);

			//Assert.assertEquals(1, (nrOfDatasPresentInTheSelectedOptionFromTheAttributeTableAfterAddingOrDeleting-nrOfDatasShowingInAddTypeTable));

			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);

			buName = TribuneUtils.getStringCellValues(pricingTab,5, 0);
			Thread.sleep(4000);
            pricingAdminPage.clickOnTheMentionedBU(buName);
			Thread.sleep(4000);
			productTypeName = TribuneUtils.getStringCellValues(pricingTab,5, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			productName = TribuneUtils.getStringCellValues(pricingTab,5, 2);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,5, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTable);
			subOptionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,5, 6);
			pricingAdminPage.clickOnTheMentionedSubOptionFromTheAttributeTable(subOptionInAttributeTable);
			subOptionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,6, 6);
			pricingAdminPage.clickOnTheMentionedSubOptionFromTheAttributeTable(subOptionInAttributeTable);
			nrOfDatasPresentInTheSelectedOptionFromTheAttributeTableAfterAddingOrDeleting = pricingAdminPage.getNumberOfDatasForSelectedOptionFromTheAttributeTable();

			Assert.assertEquals(0, (nrOfDatasPresentInTheSelectedOptionFromTheAttributeTableAfterAddingOrDeleting-nrOfDatasPresentInTheSelectedOptionFromTheAttributeTable));
			dashboardPageInstance.clickOnLogout();//swagata

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		catch(AssertionError e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"SMaintenance","CustomerSearch", "SwagataMou","Regression","NovMaintenance","pricingAdmin", "StgRegression", "pageTypeModifiersAndPageCountModifiersValidate","NewRegression3", "NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void  pageTypeModifiersAndPageCountModifiersValidate(Map<String, String> userData) throws Exception
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
			String pricingTab = "Pricing";
			String productTab = "Product";




			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);

			dashboardPageInstance.clickOnTheRequiredModule(productTab);

			PricingAdminPage pricingAdminPage = PageFactory.initElements(driver, PricingAdminPage.class);
			String buName = TribuneUtils.getStringCellValues(pricingTab,6, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			String productTypeName = TribuneUtils.getStringCellValues(pricingTab,6, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			String productName = TribuneUtils.getStringCellValues(pricingTab,6, 2);
			String optionInAttributeTableForPricing = TribuneUtils.getStringCellValues(pricingTab,6, 4);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTableForPricing);
			String tabName = TribuneUtils.getStringCellValues(pricingTab,6, 4);
			pricingAdminPage.clickOnTheMentionedTabInProduct(tabName);
			pricingAdminPage.clickOnAddBtnInProductTable();
			Thread.sleep(1500);
			//String pageTypeOption = TribuneUtils.getStringCellValues(pricingTab, 6, 7);
			String pageTypeOption = TribuneUtils.getStringCellValues(pricingTab, 7, 7);
			pricingAdminPage.chooseTheMentionedOptionFromPageTypePopUp(pageTypeOption);
			Thread.sleep(2000);
			pricingAdminPage.clickOnNewlyAddedPageTypeCount(pageTypeOption);//swagata
			
			Thread.sleep(2000);
			//pricingAdminPage.expandTheLatestProductTableBlockAddButtonIfPresentAndCollapsed();//swagata  
			pricingAdminPage.clickOnAddCountBtnInProductTable();
			String subHeadinngNameInProductTable = TribuneUtils.getStringCellValues(pricingTab, 6, 9);
			pricingAdminPage.doubleClickBelowTheMentionedSubHeadingInProductTable(subHeadinngNameInProductTable);
			int pageCount = TribuneUtils.getIntCellValues(pricingTab, 6, 10);
			String pageTypeToAdd = TribuneUtils.getStringCellValues(pricingTab, 6, 8);
			pricingAdminPage.enterTheCountBelowPageCountHeading(pageCount);
			pricingAdminPage.clickOnSaveBtnInTheProductPg();
			Thread.sleep(2000);
			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);//swagata

			buName = TribuneUtils.getStringCellValues(pricingTab,6, 0);
			Thread.sleep(5000);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			productTypeName = TribuneUtils.getStringCellValues(pricingTab,6, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			productName = TribuneUtils.getStringCellValues(pricingTab,6, 2);
			String optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,6, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTable);
			pricingAdminPage.checkIfTheSelectedOrTypedDataFromProductIsShowingInPricing(pageTypeToAdd);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,7, 3);
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTable);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,6, 8);
			pricingAdminPage.clickOnTheMentionedSubOptionFromTheAttributeTable(optionInAttributeTable);
			pricingAdminPage.checkIfTheSelectedOrTypedDataFromProductIsShowingInPricing(Integer.toString(pageCount));

			dashboardPageInstance.clickOnTheRequiredModule(productTab);


			buName = TribuneUtils.getStringCellValues(pricingTab,6, 0);
			Thread.sleep(3000);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			productTypeName = TribuneUtils.getStringCellValues(pricingTab,6, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			productName = TribuneUtils.getStringCellValues(pricingTab,6, 2);
			optionInAttributeTableForPricing = TribuneUtils.getStringCellValues(pricingTab,6, 4);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTableForPricing);
			tabName = TribuneUtils.getStringCellValues(pricingTab,6, 4);
			pricingAdminPage.clickOnTheMentionedTabInProduct(tabName);
			String productTableHeading = TribuneUtils.getStringCellValues(pricingTab,5, 7);
			int nrOfDatasShowingInAddTypeTable = pricingAdminPage.getNrOfDatasPresentInProductTable(productTableHeading);
			pricingAdminPage.deleteTheLastlyAddedData(nrOfDatasShowingInAddTypeTable);
			pricingAdminPage.clickOnSaveBtnInTheProductPg();

			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);
            Thread.sleep(3000);
			buName = TribuneUtils.getStringCellValues(pricingTab,6, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			productTypeName = TribuneUtils.getStringCellValues(pricingTab,6, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			productName = TribuneUtils.getStringCellValues(pricingTab,6, 2);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,6, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTable);
			pricingAdminPage.checkIfTheSelectedDataFromProductIsNotShowingInPricing(pageTypeToAdd);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,7, 3);
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTable);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,6, 8);
			pricingAdminPage.checkIfTheMentionedSubOptionIsNotPresentFromTheAttributeTable(optionInAttributeTable);
			dashboardPageInstance.clickOnLogout();//swagata

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		catch(AssertionError e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"CustomerSearch","pricingAdmin", "Regression", "StgRegression", "DaysOfWeekModifiers", "NewRegression3","NewRegression","daysOfWeekModifiersValidate2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void  daysOfWeekModifiersValidate2(Map<String, String> userData) throws Exception
	{
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");
			String pricingTab = "Pricing";
			String productTab = "Product";




			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);

			dashboardPageInstance.clickOnTheRequiredModule(productTab);

			PricingAdminPage pricingAdminPage = PageFactory.initElements(driver, PricingAdminPage.class);


			String buName = TribuneUtils.getStringCellValues(pricingTab,1, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			String productTypeName = TribuneUtils.getStringCellValues(pricingTab,1, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			String productName = TribuneUtils.getStringCellValues(pricingTab,1, 2);
			String optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,8, 4);
			pricingAdminPage.expandTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			pricingAdminPage.clickOnTheSectionAvailableAfterExpandingTheProduct(optionInAttributeTable);
			String tabName = TribuneUtils.getStringCellValues(pricingTab,8, 4);
			pricingAdminPage.checkIfAbleToExpandProductProperly(tabName);
			pricingAdminPage.clickOnTheMentionedTabInProductSection(tabName);
			Assert.assertTrue(pricingAdminPage.daysListInRecurrenceTab.size()>0);

			List<String> checkedCheckboxesNamesInRecurrenceTab = pricingAdminPage.noteTheNamesOfTheCheckboxesWhichAreCheckedInTheRecurenceTab();

			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);

			buName = TribuneUtils.getStringCellValues(pricingTab,1, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			productTypeName = TribuneUtils.getStringCellValues(pricingTab,1, 1);
			Thread.sleep(3000);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			productName = TribuneUtils.getStringCellValues(pricingTab,1, 2);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,8, 4);
			pricingAdminPage.expandTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			pricingAdminPage.clickOnTheSectionAvailableAfterExpandingTheProduct(optionInAttributeTable);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab, 8, 3);
			pricingAdminPage.checkIfAbleToExpandProductProperly(optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedOptionFromSectionInAttributeTableInPricing(optionInAttributeTable);
			pricingAdminPage.checkIfTheNrOfDatasInExpandedOptionMatchesWithTheNrOfDatasNotedFromProductSection(checkedCheckboxesNamesInRecurrenceTab);
			pricingAdminPage.checkIfOnlytheCheckedDaysInProductAreShowingInPricing(checkedCheckboxesNamesInRecurrenceTab);
			dashboardPageInstance.clickOnLogout();//swagata



		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}	
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	@Test(groups = {"CustomerSearch", "SwagataMou","Regression","PrioritizedReg3","NovMaintenance", "pricingAdmin","classifiedPackageModifiersValidate", "NewRegression3","NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void  classifiedPackageModifiersValidate(Map<String, String> userData) throws Exception{
		try {

			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");
			String pricingTab = "Pricing";

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);

			PricingAdminPage pricingAdminPage = PageFactory.initElements(driver, PricingAdminPage.class);

			String optionToExpandFromAdOrdersOptions = TribuneUtils.getStringCellValues(pricingTab, 9, 11);
			pricingAdminPage.clickOnTheMentionedOptionToExpandFromAdOrdersOptions(optionToExpandFromAdOrdersOptions);
			String subOptionToClickAfterExpandingOptionFromAdOrdersOptions = TribuneUtils.getStringCellValues(pricingTab, 9, 12);
			pricingAdminPage.clickOnTheMentionedSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions(subOptionToClickAfterExpandingOptionFromAdOrdersOptions, optionToExpandFromAdOrdersOptions);
			String linkToClkAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions = TribuneUtils.getStringCellValues(pricingTab, 9, 13);
			pricingAdminPage.clickOnTheMentionedLinkAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions(linkToClkAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions, optionToExpandFromAdOrdersOptions);
			pricingAdminPage.clickOnAddBtnInGeneralSettingsSubModulePage();
			String dropdownInGeneralSettingsSubModulePopUp = TribuneUtils.getStringCellValues(pricingTab, 9, 14);
			String dropdownOptionToChooseInGeneralSettingsSubModulePopUp = TribuneUtils.getStringCellValues(pricingTab, 9, 15);
			pricingAdminPage.chooseTheMentionedOptionFromTheMentionedDropdownInGeneralSettingsSubModulePgPopUp(dropdownOptionToChooseInGeneralSettingsSubModulePopUp, dropdownInGeneralSettingsSubModulePopUp);
			dropdownInGeneralSettingsSubModulePopUp = TribuneUtils.getStringCellValues(pricingTab, 10, 14);
			dropdownOptionToChooseInGeneralSettingsSubModulePopUp = TribuneUtils.getStringCellValues(pricingTab, 10, 15);
			pricingAdminPage.chooseTheMentionedOptionFromTheMentionedDropdownInGeneralSettingsSubModulePgPopUp(dropdownOptionToChooseInGeneralSettingsSubModulePopUp, dropdownInGeneralSettingsSubModulePopUp);
			String inputFieldInClassifiedPkgPopUp = TribuneUtils.getStringCellValues(pricingTab, 9, 16);
			String textToEnter = "test" + System.currentTimeMillis();
			pricingAdminPage.enterTheMentionedTextInTheMetionedInputFieldInGeneralSettingsSubModulePgPopUp(textToEnter, inputFieldInClassifiedPkgPopUp);
			inputFieldInClassifiedPkgPopUp = TribuneUtils.getStringCellValues(pricingTab, 10, 16);
			int numberToEnter = TribuneUtils.getIntCellValues(pricingTab, 10, 17);
			pricingAdminPage.enterTheMentionedTextInTheMetionedInputFieldInGeneralSettingsSubModulePgPopUp(Integer.toString(numberToEnter), inputFieldInClassifiedPkgPopUp);
			pricingAdminPage.clickOnAddBtnInGeneralSettingsSubModulePgPopUp();
			String headingOptiontoDoubleClickInTableInClassifiedPkgPopUp = TribuneUtils.getStringCellValues(pricingTab, 9, 18);
			String dropdownOptionToChooseForSpecificHeadingInTableInClassifiedPkgPopUp = TribuneUtils.getStringCellValues(pricingTab, 9, 19);
			pricingAdminPage.doubleClickOnTheHeadingOptionInTableInGeneralSettingsSubModulePgPopUpAndChooseTheMentionedOption(headingOptiontoDoubleClickInTableInClassifiedPkgPopUp, dropdownOptionToChooseForSpecificHeadingInTableInClassifiedPkgPopUp);
			headingOptiontoDoubleClickInTableInClassifiedPkgPopUp = TribuneUtils.getStringCellValues(pricingTab, 10, 18);
			dropdownOptionToChooseForSpecificHeadingInTableInClassifiedPkgPopUp = TribuneUtils.getStringCellValues(pricingTab, 10, 19);
			pricingAdminPage.doubleClickOnTheHeadingOptionInTableInGeneralSettingsSubModulePgPopUpAndChooseTheMentionedOption(headingOptiontoDoubleClickInTableInClassifiedPkgPopUp, dropdownOptionToChooseForSpecificHeadingInTableInClassifiedPkgPopUp);
			headingOptiontoDoubleClickInTableInClassifiedPkgPopUp = TribuneUtils.getStringCellValues(pricingTab, 11, 18);
			dropdownOptionToChooseForSpecificHeadingInTableInClassifiedPkgPopUp = TribuneUtils.getStringCellValues(pricingTab, 11, 19);
			pricingAdminPage.doubleClickOnTheHeadingOptionInTableInGeneralSettingsSubModulePgPopUpAndChooseTheMentionedOption(headingOptiontoDoubleClickInTableInClassifiedPkgPopUp, dropdownOptionToChooseForSpecificHeadingInTableInClassifiedPkgPopUp);
			headingOptiontoDoubleClickInTableInClassifiedPkgPopUp = TribuneUtils.getStringCellValues(pricingTab, 12, 18);
			dropdownOptionToChooseForSpecificHeadingInTableInClassifiedPkgPopUp = TribuneUtils.getStringCellValues(pricingTab, 12, 19);
			pricingAdminPage.doubleClickOnTheHeadingOptionInTableInGeneralSettingsSubModulePgPopUpAndChooseTheMentionedOption(headingOptiontoDoubleClickInTableInClassifiedPkgPopUp, dropdownOptionToChooseForSpecificHeadingInTableInClassifiedPkgPopUp);
			headingOptiontoDoubleClickInTableInClassifiedPkgPopUp = TribuneUtils.getStringCellValues(pricingTab, 13, 18);
			dropdownOptionToChooseForSpecificHeadingInTableInClassifiedPkgPopUp = TribuneUtils.getStringCellValues(pricingTab, 13, 19);
			pricingAdminPage.doubleClickOnTheHeadingOptionInTableInGeneralSettingsSubModulePgPopUpAndChooseTheMentionedOption(headingOptiontoDoubleClickInTableInClassifiedPkgPopUp, dropdownOptionToChooseForSpecificHeadingInTableInClassifiedPkgPopUp);
			headingOptiontoDoubleClickInTableInClassifiedPkgPopUp = TribuneUtils.getStringCellValues(pricingTab, 14, 18);
			dropdownOptionToChooseForSpecificHeadingInTableInClassifiedPkgPopUp = TribuneUtils.getStringCellValues(pricingTab, 14, 19);
			Thread.sleep(1000);
			pricingAdminPage.doubleClickOnTheHeadingOptionInTableInGeneralSettingsSubModulePgPopUpAndChooseTheMentionedOption(headingOptiontoDoubleClickInTableInClassifiedPkgPopUp, dropdownOptionToChooseForSpecificHeadingInTableInClassifiedPkgPopUp);
			String checkboxHeadingInTableInClassifiedPkgPopUp = TribuneUtils.getStringCellValues(pricingTab, 15, 18);
			pricingAdminPage.checkTheMentionedCheckboxInTableInClassifiedPkgPopUp(checkboxHeadingInTableInClassifiedPkgPopUp);
			String btnToClkInClassifiedPkgPopUp = "Ok";
			pricingAdminPage.clickOnTheMentionedBtnInGeneralSettingsSubModulePgPopUp(btnToClkInClassifiedPkgPopUp);
			pricingAdminPage.checkIfSuccessMsgAppears();
			Thread.sleep(3000);
			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);
			String buName = TribuneUtils.getStringCellValues(pricingTab,9, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			String productTypeName = TribuneUtils.getStringCellValues(pricingTab,9, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			String productName = TribuneUtils.getStringCellValues(pricingTab,9, 2);
			String optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,9, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTable);
			pricingAdminPage.checkIfTheSelectedOrTypedDataFromProductIsShowingInPricing(textToEnter);

			optionToExpandFromAdOrdersOptions = TribuneUtils.getStringCellValues(pricingTab, 9, 11);
			pricingAdminPage.clickOnTheMentionedOptionToExpandFromAdOrdersOptions(optionToExpandFromAdOrdersOptions);
			linkToClkAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions = TribuneUtils.getStringCellValues(pricingTab, 9, 13);
			pricingAdminPage.clickOnTheMentionedLinkAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions(linkToClkAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions, optionToExpandFromAdOrdersOptions);
			String dropdownInClassifiedPkg = TribuneUtils.getStringCellValues(pricingTab, 15, 20);
			String dropdownOptionInClassifiedPkgPgDropdown = TribuneUtils.getStringCellValues(pricingTab, 15, 21);
			pricingAdminPage.chooseTheMentionedDropdownOptionAsTheMentionedTextInGeneralSettingsSubModulePg(dropdownInClassifiedPkg, dropdownOptionInClassifiedPkgPgDropdown);
			dropdownInClassifiedPkg = TribuneUtils.getStringCellValues(pricingTab, 16, 20);
			dropdownOptionInClassifiedPkgPgDropdown = TribuneUtils.getStringCellValues(pricingTab, 16, 21);
			pricingAdminPage.chooseTheMentionedDropdownOptionAsTheMentionedTextInGeneralSettingsSubModulePg(dropdownInClassifiedPkg, dropdownOptionInClassifiedPkgPgDropdown);
			inputFieldInClassifiedPkgPopUp = TribuneUtils.getStringCellValues(pricingTab, 17, 22);
			pricingAdminPage.searchForTheSameTypedNameInClassifiedPkgTblUnderMentionedHeading(inputFieldInClassifiedPkgPopUp, textToEnter);
			pricingAdminPage.inactivateTheSameSearchedDataInGeneralSettingsSubModuleTbl(textToEnter);//swagata

			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);
			productName = TribuneUtils.getStringCellValues(pricingTab,9, 2);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,9, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTable);
			pricingAdminPage.checkIfTheSelectedDataFromProductIsNotShowingInPricing(textToEnter);
			dashboardPageInstance.clickOnLogout();//swagata


		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}	
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}


	}


	@Test(groups = {"CustomerSearch","SwagataMou", "pricingAdmin","PrioritizedReg3","Regression","NovMaintenance", "classCodeModifiersValidate","NewRegression3", "NewRegression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void  classCodeModifiersValidate(Map<String, String> userData) throws Exception{
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");
			String pricingTab = "Pricing";

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);

			PricingAdminPage pricingAdminPage = PageFactory.initElements(driver, PricingAdminPage.class);

			String optionToExpandFromAdOrdersOptions = TribuneUtils.getStringCellValues(pricingTab, 9, 11);
			pricingAdminPage.clickOnTheMentionedOptionToExpandFromAdOrdersOptions(optionToExpandFromAdOrdersOptions);
			String subOptionToClickAfterExpandingOptionFromAdOrdersOptions = TribuneUtils.getStringCellValues(pricingTab, 10, 12);
			pricingAdminPage.clickOnTheMentionedSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions(subOptionToClickAfterExpandingOptionFromAdOrdersOptions, optionToExpandFromAdOrdersOptions);
			String linkToClkAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions = TribuneUtils.getStringCellValues(pricingTab, 10, 13);
			pricingAdminPage.clickOnTheMentionedLinkAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions(linkToClkAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions, optionToExpandFromAdOrdersOptions);
			String dropdownInClassifiedPkg = TribuneUtils.getStringCellValues(pricingTab, 15, 20);
			String dropdownOptionInClassifiedPkgPgDropdown = TribuneUtils.getStringCellValues(pricingTab, 15, 21);
		Thread.sleep(2000);
			pricingAdminPage.chooseTheMentionedDropdownOptionAsTheMentionedTextInGeneralSettingsSubModulePg(dropdownInClassifiedPkg, dropdownOptionInClassifiedPkgPgDropdown);
			dropdownInClassifiedPkg = TribuneUtils.getStringCellValues(pricingTab, 17, 20);
			dropdownOptionInClassifiedPkgPgDropdown = TribuneUtils.getStringCellValues(pricingTab, 17, 21);
			pricingAdminPage.chooseTheMentionedDropdownOptionAsTheMentionedTextInGeneralSettingsSubModulePg(dropdownInClassifiedPkg, dropdownOptionInClassifiedPkgPgDropdown);
			dropdownInClassifiedPkg = TribuneUtils.getStringCellValues(pricingTab, 18, 20);//swagata,test data change
			dropdownOptionInClassifiedPkgPgDropdown = TribuneUtils.getStringCellValues(pricingTab, 18, 21);//swagata,test data change
			pricingAdminPage.chooseTheMentionedDropdownOptionAsTheMentionedTextInGeneralSettingsSubModulePg(dropdownInClassifiedPkg, dropdownOptionInClassifiedPkgPgDropdown);
			pricingAdminPage.clickOnAddBtnInGeneralSettingsSubModulePage();
			String inputFieldInGeneralsettingsSubModulePgPopUp = TribuneUtils.getStringCellValues(pricingTab, 11, 16);
			String numberToEnter = Long.toString(System.currentTimeMillis());
			String numberToEnterSplittedPart = numberToEnter.substring(numberToEnter.length()-5);
			pricingAdminPage.enterTheMentionedTextInTheMetionedInputFieldInGeneralSettingsSubModulePgPopUp(numberToEnterSplittedPart, inputFieldInGeneralsettingsSubModulePgPopUp);
			String textToEnter = "test" + System.currentTimeMillis();
			inputFieldInGeneralsettingsSubModulePgPopUp = TribuneUtils.getStringCellValues(pricingTab, 12, 16);
			pricingAdminPage.enterTheMentionedTextInTheMetionedInputFieldInGeneralSettingsSubModulePgPopUp(textToEnter, inputFieldInGeneralsettingsSubModulePgPopUp);
			String dropdownInGeneralSettingsSubModulePopUp = TribuneUtils.getStringCellValues(pricingTab, 11, 14);
			String dropdownOptionToChooseInGeneralSettingsSubModulePopUp = TribuneUtils.getStringCellValues(pricingTab, 11, 15);
			pricingAdminPage.chooseTheMentionedOptionFromTheMentionedDropdownInGeneralSettingsSubModulePgPopUp(dropdownOptionToChooseInGeneralSettingsSubModulePopUp, dropdownInGeneralSettingsSubModulePopUp);
			String checkboxInGeneralSettingsSubModulePgPopUp = TribuneUtils.getStringCellValues(pricingTab, 19, 23);
			pricingAdminPage.checkTheCheckboxInGeneralSettingsSubModulePgPopUp(checkboxInGeneralSettingsSubModulePgPopUp);
			String btnToClkInClassifiedPkgPopUp = "Save";
			pricingAdminPage.clickOnTheMentionedBtnInGeneralSettingsSubModulePgPopUp(btnToClkInClassifiedPkgPopUp);
			pricingAdminPage.checkIfSuccessMsgAppears();

			Thread.sleep(3000);

			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);
			String buName = TribuneUtils.getStringCellValues(pricingTab,9, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			String productTypeName = TribuneUtils.getStringCellValues(pricingTab,9, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			String productName = TribuneUtils.getStringCellValues(pricingTab,9, 2);
			String optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,10, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTable);
			String subOptionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,17, 21);
			pricingAdminPage.clickOnTheMentionedSubOptionFromTheAttributeTable(subOptionInAttributeTable);
			subOptionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,18, 21);
			pricingAdminPage.clickOnTheMentionedSubOptionFromTheAttributeTable(subOptionInAttributeTable);
			pricingAdminPage.checkIfTheSelectedOrTypedDataFromProductIsShowingInPricing(textToEnter);
			pricingAdminPage.checkIfTheSelectedOrTypedDataFromProductIsShowingInPricing(numberToEnterSplittedPart);

			optionToExpandFromAdOrdersOptions = TribuneUtils.getStringCellValues(pricingTab, 9, 11);
			pricingAdminPage.clickOnTheMentionedOptionToExpandFromAdOrdersOptions(optionToExpandFromAdOrdersOptions);
			linkToClkAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions = TribuneUtils.getStringCellValues(pricingTab, 10, 13);
			pricingAdminPage.clickOnTheMentionedLinkAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions(linkToClkAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions, optionToExpandFromAdOrdersOptions);
			dropdownInClassifiedPkg = TribuneUtils.getStringCellValues(pricingTab, 15, 20);
			dropdownOptionInClassifiedPkgPgDropdown = TribuneUtils.getStringCellValues(pricingTab, 15, 21);
			pricingAdminPage.chooseTheMentionedDropdownOptionAsTheMentionedTextInGeneralSettingsSubModulePg(dropdownInClassifiedPkg, dropdownOptionInClassifiedPkgPgDropdown);
			dropdownInClassifiedPkg = TribuneUtils.getStringCellValues(pricingTab, 17, 20);
			dropdownOptionInClassifiedPkgPgDropdown = TribuneUtils.getStringCellValues(pricingTab, 17, 21);
			pricingAdminPage.chooseTheMentionedDropdownOptionAsTheMentionedTextInGeneralSettingsSubModulePg(dropdownInClassifiedPkg, dropdownOptionInClassifiedPkgPgDropdown);
			dropdownInClassifiedPkg = TribuneUtils.getStringCellValues(pricingTab, 18, 20);
			dropdownOptionInClassifiedPkgPgDropdown = TribuneUtils.getStringCellValues(pricingTab, 18, 21);
			pricingAdminPage.chooseTheMentionedDropdownOptionAsTheMentionedTextInGeneralSettingsSubModulePg(dropdownInClassifiedPkg, dropdownOptionInClassifiedPkgPgDropdown);
			String inputFieldInGeneralSettingsSubModulePgPopUp = TribuneUtils.getStringCellValues(pricingTab, 11, 16);
			pricingAdminPage.searchForTheSameTypedNameInClassifiedPkgTblUnderMentionedHeading(inputFieldInGeneralSettingsSubModulePgPopUp, numberToEnterSplittedPart);
			pricingAdminPage.uncheckTheEarlierCheckedCheckboxInInGeneralSettingsSubModulePgPopUpAndSave(checkboxInGeneralSettingsSubModulePgPopUp);
			pricingAdminPage.checkIfSuccessMsgAppears();

			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);
			productName = TribuneUtils.getStringCellValues(pricingTab,9, 2);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,10, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);//swagata
			pricingAdminPage.clickOnTheMentionedOptionFromTheAttributeTable(optionInAttributeTable);
			subOptionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,17, 21);
			pricingAdminPage.clickOnTheMentionedSubOptionFromTheAttributeTable(subOptionInAttributeTable);
			subOptionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,18, 21);
			pricingAdminPage.clickOnTheMentionedSubOptionFromTheAttributeTable(subOptionInAttributeTable);
			pricingAdminPage.checkIfTheSelectedDataFromProductIsNotShowingInPricing(numberToEnterSplittedPart);
			pricingAdminPage.checkIfTheSelectedDataFromProductIsNotShowingInPricing(textToEnter);
			dashboardPageInstance.clickOnLogout();//swagata

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"CustomerSearch", "Regression", "StgRegression", "Tc16"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void  validateThatThePriceIsCalculatedProperlyUsingZoneModifierOfBothProductAndSectionLevelForNYDNDisplay(Map<String, String> userData) throws Exception{
		try {

			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");
			String pricingTab = "Pricing";

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);

			OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			NewOrderPage newOrderPage = PageFactory.initElements(driver, NewOrderPage.class);
			PricingAdminPage pricingAdminPage = PageFactory.initElements(driver, PricingAdminPage.class);

			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);

			String buName = TribuneUtils.getStringCellValues(pricingTab,1, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			String productTypeName = TribuneUtils.getStringCellValues(pricingTab,1, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			String productName = TribuneUtils.getStringCellValues(pricingTab,1, 2);
			String optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,8, 4);
			pricingAdminPage.expandTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			pricingAdminPage.clickOnTheSectionAvailableAfterExpandingTheProduct(optionInAttributeTable);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab, 11, 3);
			pricingAdminPage.checkIfAbleToExpandProductProperly(optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedOptionFromSectionInAttributeTableInPricing(optionInAttributeTable);
			String pricingOptionInSectionLevel = TribuneUtils.getStringCellValues(pricingTab, 1, 26);
			pricingAdminPage.clickOnTheMentionedPricingOptionInSectionLevel(pricingOptionInSectionLevel);
			pricingAdminPage.clickOnTheDisplayedPercentageInPricingPg();
			String inputFieldInModifierPopUp = "Modifier Value";
			String valShownInInputFieldInModifierPopUp = pricingAdminPage.noteTheValueShownInTheMentionedInputFieldInModifierPopUp(inputFieldInModifierPopUp);
			String changedTextInInputFieldInModifierPopUp = pricingAdminPage.changeTheValueInTheMentionedInputFieldInModifierPopUp(inputFieldInModifierPopUp);
			pricingAdminPage.clickOnOkBtnInConfirmationMsgPopUpHighlightedInGreen();
			pricingAdminPage.clickOnRefreshPgBtnInPriciingPg();
			pricingAdminPage.checkIfTheDisplayedPercentageInPricingIsShowingTheChangedPercentage(changedTextInInputFieldInModifierPopUp);

			dashboardPageInstance.clickOnOrderEntryModule(); 
			basicOrderSearch.clickOnNewGeneralOrder();
			String btnNameToClkInInsertionTable = TribuneUtils.getStringCellValues(pricingTab, 1, 24);
			String subOptionToClkFromBtnClickedInInsertionTable = TribuneUtils.getStringCellValues(pricingTab, 1, 25);
			pricingAdminPage.clickOnTheMentionedBtnInInsertionTbl(btnNameToClkInInsertionTable);
			pricingAdminPage.clickOnTheMentionedSubOptionAfterClickingOnReqdBtnInInsertionTbl(subOptionToClkFromBtnClickedInInsertionTable, btnNameToClkInInsertionTable);
			String tableDataToClickForHeadingInInsertionTable = TribuneUtils.getStringCellValues(pricingTab, 1, 27);
			pricingAdminPage.clickOnTheTableDataForMentionedHeadingInInsertionTable(tableDataToClickForHeadingInInsertionTable);
			pricingAdminPage.clickOnTheCalendarIconBelowPubDateHeadingInInsertionTbl();
			String dayInCalendarField = TribuneUtils.getStringCellValues(pricingTab, 1, 29);
			pricingAdminPage.selectTheMentionedIndexedDateForTheSpecifiedDateInCalendarFieldBelowPubDateHeadingInInsertionTbl(1, dayInCalendarField);
			tableDataToClickForHeadingInInsertionTable = TribuneUtils.getStringCellValues(pricingTab, 4, 27);
			pricingAdminPage.clickOnTheTableDataForMentionedHeadingInInsertionTable(tableDataToClickForHeadingInInsertionTable);
			String dropdownOptionToChoose = TribuneUtils.getStringCellValues(pricingTab, 4, 28);
			pricingAdminPage.selectTheMentionedOptionFromInsertionTblDropdown(dropdownOptionToChoose, tableDataToClickForHeadingInInsertionTable);
			tableDataToClickForHeadingInInsertionTable = TribuneUtils.getStringCellValues(pricingTab, 2, 27);
			pricingAdminPage.clickOnTheTableDataForMentionedHeadingInInsertionTable(tableDataToClickForHeadingInInsertionTable);
			dropdownOptionToChoose = TribuneUtils.getStringCellValues(pricingTab, 2, 28);
			pricingAdminPage.selectTheMentionedOptionFromInsertionTblDropdown(dropdownOptionToChoose, tableDataToClickForHeadingInInsertionTable);
			tableDataToClickForHeadingInInsertionTable = TribuneUtils.getStringCellValues(pricingTab, 3, 27);
			pricingAdminPage.clickOnTheTableDataForMentionedHeadingInInsertionTable(tableDataToClickForHeadingInInsertionTable);
			dropdownOptionToChoose = TribuneUtils.getStringCellValues(pricingTab, 3, 28);
			pricingAdminPage.selectTheMentionedOptionFromInsertionTblDropdown(dropdownOptionToChoose, tableDataToClickForHeadingInInsertionTable);
			newOrderPage.getValueFromPriceDetailsInNewOrderPg();
			pricingAdminPage.checkIfTheChangedPercentageIsReflectingInPriceDetailsInNewOrderPg(changedTextInInputFieldInModifierPopUp);
			String btnInNewOrderPgPopUp = "Cancel";
			pricingAdminPage.clickOnTheMentionedBtnInNewOrderPgPopUp(btnInNewOrderPgPopUp);


			dashboardPageInstance.clickOnTheRequiredModule(pricingTab);
			btnInNewOrderPgPopUp = "Yes";
			pricingAdminPage.clickOnTheMentionedBtnInNewOrderPgPopUp(btnInNewOrderPgPopUp);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,8, 4);
			pricingAdminPage.clickOnTheSectionAvailableAfterExpandingTheProduct(optionInAttributeTable);
			optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab, 11, 3);
			pricingAdminPage.checkIfAbleToExpandProductProperly(optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedOptionFromSectionInAttributeTableInPricing(optionInAttributeTable);
			pricingOptionInSectionLevel = TribuneUtils.getStringCellValues(pricingTab, 1, 26);
			pricingAdminPage.clickOnTheMentionedPricingOptionInSectionLevel(pricingOptionInSectionLevel);
			pricingAdminPage.clickOnTheDisplayedPercentageInPricingPg();
			inputFieldInModifierPopUp = "Modifier Value";
			pricingAdminPage.changeTheValueInTheMentionedInputFieldInModifierPopUpToTheOldValue(inputFieldInModifierPopUp, valShownInInputFieldInModifierPopUp);
			pricingAdminPage.clickOnOkBtnInConfirmationMsgPopUpHighlightedInGreen();
			pricingAdminPage.clickOnRefreshPgBtnInPriciingPg();
			pricingAdminPage.checkIfTheDisplayedPercentageInPricingIsShowingTheChangedPercentage(valShownInInputFieldInModifierPopUp);

			dashboardPageInstance.clickOnOrderEntryModule(); 
			basicOrderSearch.clickOnNewGeneralOrder();
			btnNameToClkInInsertionTable = TribuneUtils.getStringCellValues(pricingTab, 1, 24);
			subOptionToClkFromBtnClickedInInsertionTable = TribuneUtils.getStringCellValues(pricingTab, 1, 25);
			pricingAdminPage.clickOnTheMentionedBtnInInsertionTbl(btnNameToClkInInsertionTable);
			pricingAdminPage.clickOnTheMentionedSubOptionAfterClickingOnReqdBtnInInsertionTbl(subOptionToClkFromBtnClickedInInsertionTable, btnNameToClkInInsertionTable);
			tableDataToClickForHeadingInInsertionTable = TribuneUtils.getStringCellValues(pricingTab, 1, 27);
			pricingAdminPage.clickOnTheTableDataForMentionedHeadingInInsertionTable(tableDataToClickForHeadingInInsertionTable);
			pricingAdminPage.clickOnTheCalendarIconBelowPubDateHeadingInInsertionTbl();
			dayInCalendarField = TribuneUtils.getStringCellValues(pricingTab, 1, 29);
			pricingAdminPage.selectTheMentionedIndexedDateForTheSpecifiedDateInCalendarFieldBelowPubDateHeadingInInsertionTbl(1, dayInCalendarField);
			tableDataToClickForHeadingInInsertionTable = TribuneUtils.getStringCellValues(pricingTab, 4, 27);
			pricingAdminPage.clickOnTheTableDataForMentionedHeadingInInsertionTable(tableDataToClickForHeadingInInsertionTable);
			dropdownOptionToChoose = TribuneUtils.getStringCellValues(pricingTab, 4, 28);
			pricingAdminPage.selectTheMentionedOptionFromInsertionTblDropdown(dropdownOptionToChoose, tableDataToClickForHeadingInInsertionTable);
			tableDataToClickForHeadingInInsertionTable = TribuneUtils.getStringCellValues(pricingTab, 2, 27);
			pricingAdminPage.clickOnTheTableDataForMentionedHeadingInInsertionTable(tableDataToClickForHeadingInInsertionTable);
			dropdownOptionToChoose = TribuneUtils.getStringCellValues(pricingTab, 2, 28);
			pricingAdminPage.selectTheMentionedOptionFromInsertionTblDropdown(dropdownOptionToChoose, tableDataToClickForHeadingInInsertionTable);
			tableDataToClickForHeadingInInsertionTable = TribuneUtils.getStringCellValues(pricingTab, 3, 27);
			pricingAdminPage.clickOnTheTableDataForMentionedHeadingInInsertionTable(tableDataToClickForHeadingInInsertionTable);
			dropdownOptionToChoose = TribuneUtils.getStringCellValues(pricingTab, 3, 28);
			pricingAdminPage.selectTheMentionedOptionFromInsertionTblDropdown(dropdownOptionToChoose, tableDataToClickForHeadingInInsertionTable);
			newOrderPage.getValueFromPriceDetailsInNewOrderPg();
			pricingAdminPage.checkIfTheEarlierChangedPercentageIsNotReflectingInPriceDetailsInNewOrderPg(changedTextInInputFieldInModifierPopUp);
			dashboardPageInstance.clickOnLogout();//swagata



		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"CustomerSearch", "Regression", "StgRegression", "WeightModifiers"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void  weightModifiersValidate(Map<String, String> userData) throws Exception{
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");
			String pricingTab = "Pricing";
			String productTab = "Product";

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);

			OrderEntryHomePage basicOrderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
			NewOrderPage newOrderPage = PageFactory.initElements(driver, NewOrderPage.class);
			PricingAdminPage pricingAdminPage = PageFactory.initElements(driver, PricingAdminPage.class);

			dashboardPageInstance.clickOnTheRequiredModule(productTab);

			String buName = TribuneUtils.getStringCellValues(pricingTab,12, 0);
			pricingAdminPage.clickOnTheMentionedBU(buName);
			String productTypeName = TribuneUtils.getStringCellValues(pricingTab,6, 1);
			pricingAdminPage.clickOnTheMentionedProductType(productTypeName);
			String productName = TribuneUtils.getStringCellValues(pricingTab,12, 2);
			String optionInAttributeTable = TribuneUtils.getStringCellValues(pricingTab,12, 3);
			String tabName = TribuneUtils.getStringCellValues(pricingTab,12, 3);
			pricingAdminPage.clickOnTheMentionedProductOfTheCorrespondingProductType(productName, productTypeName, optionInAttributeTable);
			pricingAdminPage.clickOnTheMentionedTabInProduct(tabName);
			pricingAdminPage.clickOnAddBtnInProductTable();
			String headingInProductTbl = TribuneUtils.getStringCellValues(pricingTab, 12, 7);
			pricingAdminPage.goToTheLastSectionIDUnderTheMentionedHeadingInProductTblAndEnterAValue(headingInProductTbl);
			
			
			dashboardPageInstance.clickOnLogout();//swagata

			
			
			
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}
}