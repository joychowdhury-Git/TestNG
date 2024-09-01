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
import java.util.concurrent.TimeUnit;

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


public class AddDeleteFunctionality {

	/**
	 * Validate-Adding Product is working

	 *///swagata

	//String ProductId;
	//String name;

	@Test(groups = {"AddDeleteProduct","NewDev","NovMaintenance","NewRegression","PrioritizedReg1","NewRegression1", "addDeleteFunc"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void AddDeleteProduct(Map<String, String> userData) throws Exception
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
			
			Logger.info("Passed");

			ProductAdminPageInstance.AddProductButton("CTC-CTMG");
			Thread.sleep(8000); 

			ProductAdminPageInstance.selectProductType("Alternative");

			String NewProductName=ProductAdminPageInstance.ProductName();
			Thread.sleep(2000);
             Logger.info("Product name is:"+NewProductName);//swagata

			ProductAdminPageInstance.selectFinanceTab();

			ProductAdminPageInstance.selectGeneralInfoTab();

			ProductAdminPageInstance.ProductButtonSave();

			/**
			 * DeleteProduct
			 */
			//String ProductId =ProductAdminPageInstance.getProductId();
			//Logger.info("Product Id is:"+ProductId);
			//Thread.sleep(8000);//mou

			ProductAdminPageInstance.ExpandBU("CTC-CTMG");
			Thread.sleep(5000);

			ProductAdminPageInstance.ExpandProductType("Alternative");
			Thread.sleep(5000);

			// Logger.info("Xpath is - //span[text()=+name+]/../../a/button/span");


			ProductAdminPageInstance.NewProductCaret(NewProductName);

			//  Logger.info("Xpath is - //*[@id='product-"+ProductId+"']/ul/li[2]");
			
			String ProductId =ProductAdminPageInstance.getProductId();
			Logger.info("Product Id is:"+ProductId);
			Thread.sleep(6000);
			
			/*ProductAdminPageInstance.ExpandProductType("Alternative");
			Thread.sleep(5000);
			ProductAdminPageInstance.ExpandCreatedProduct(NewProductName);
			ProductAdminPageInstance.NewProductCaret(NewProductName);*///swagata
			
			ProductAdminPageInstance.DeleteProduct(NewProductName);//swagata
			//Thread.sleep(5000);//swagata


			ProductAdminPageInstance.clickOkInConfirmMessage();
			//Thread.sleep(8000);//swagata
			//dashboardPageInstance.clickOnLogout();//swagata
			dashboardPageInstance.clickondropdownforlogout();//joy


		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * Validate Deleting Product is working

	 *///swagata

	/*@Test(groups = {"DeleteProduct"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
   public void DeleteProduct(Map<String, String> userData) throws Exception
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

	       //Delete
	       WebElement ProductDropDown = driver.findElement(By.xpath("//*[@id='i-productAdmin-bu-42']"));
	       ProductDropDown.click();
	       Logger.info("Product DropDown is selected");
	       Thread.sleep(5000);//need to create button


	       WebElement ProductTypeDropDown = driver.findElement(By.xpath("//*[@id='i-productAdmin-producttype-7']"));
	       ProductTypeDropDown.click();
	       Logger.info("Product Type DropDown is selected");//need to create button
	       Thread.sleep(5000);
	      // Logger.info("Xpath is - //span[text()=+name+]/../../a/button/span");


	       ProductAdminPageInstance.NewProduct(name);

	       Logger.info("Xpath is - //*[@id='product-"+ProductId+"']/ul/li[2]");
	       WebElement DeleteProduct = driver.findElement(By.xpath("//*[@id='product-"+ProductId+"']/ul/li[2]"));//modification
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("arguments[0].scrollIntoView(true);", DeleteProduct);

	       DeleteProduct.click(); 
	       Logger.info("Product is Deleteted");//need to create button
	       Thread.sleep(5000);


	       ProductAdminPageInstance.clickOkInConfirmMessage();
	       Thread.sleep(8000);

	   }

	   catch(Exception e)
	   {
		   Logger.error(e.getMessage());
			throw e;
	   }
}*/

	/**
	 * Validate-Adding and Deleting Section is working

	 *///swagata

	@Test(groups = {"AddDeleteSection","NovMaintenance","NewDev","NewRegression","NewRegression1", "addDeleteFunc"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void AddDeleteSection(Map<String, String> userData) throws Exception
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

			Logger.info("Name of created new product:"+NewProductName);//swagata
			ProductAdminPageInstance.selectFinanceTab();

			ProductAdminPageInstance.selectGeneralInfoTab();

			ProductAdminPageInstance.ProductButtonSave();

			
			ProductAdminPageInstance.ExpandBU("CTC-CTMG");
			Thread.sleep(5000);

			ProductAdminPageInstance.ExpandProductType("Alternative");
			Thread.sleep(5000);
			ProductAdminPageInstance.NewProductCaret(NewProductName);
			String ProductId =ProductAdminPageInstance.getProductId();
			Logger.info("Product Id is:"+ProductId);
			Thread.sleep(8000);

			ProductAdminPageInstance.AddSection(NewProductName);//swagata
			ProductAdminPageInstance.SectionName();

			String SectionName=ProductAdminPageInstance.SectionName();

			ProductAdminPageInstance.SectionButtonSave();
			Thread.sleep(8000);

			
			 /* Deleting Section 
			 


			String SectionId =ProductAdminPageInstance.getSectionId();
			Logger.info("Section Id is:"+SectionId);
			Thread.sleep(5000);

			ProductAdminPageInstance.ExpandCreatedProduct(NewProductName);//swagata
		
			ProductAdminPageInstance.NewSectionCaret(SectionName);

			ProductAdminPageInstance.DeleteSection(SectionName);//swagata

			ProductAdminPageInstance.clickOkInConfirmMessage();
            //dashboardPageInstance.clickOnLogout();//swagata*/
			dashboardPageInstance.clickondropdownforlogout();
		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}

	}

	@Test(groups = {"AddDeleteSubSection","NovMaintenance","NewDev","NewRegression","PrioritizedReg1","NewRegression1", "addDeleteFunc"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")

	public void AddDeleteSubSection(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.ProductAdminModule();//swagata
			Thread.sleep(8000); 
			ProductAdminPage ProductAdminPageInstance = PageFactory.initElements(driver, ProductAdminPage.class);

			ProductAdminPageInstance.clickBuCaret("CTC-CTMG");
			Thread.sleep(2000); 

			ProductAdminPageInstance.AddProductButton("CTC-CTMG");
			Thread.sleep(8000); 

			ProductAdminPageInstance.selectProductType("Online");

			String NewProductName=ProductAdminPageInstance.ProductName();
			Thread.sleep(2000);
			Logger.info("New Product name is:"+NewProductName);//swagata

			ProductAdminPageInstance.selectFinanceTab();

			ProductAdminPageInstance.selectGeneralInfoTab();

			ProductAdminPageInstance.ProductButtonSave();

			

			ProductAdminPageInstance.ExpandBU("CTC-CTMG");
			//Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			ProductAdminPageInstance.ExpandProductType("Online");


			//ProductAdminPageInstance.ExpandProduct();
			Thread.sleep(8000);



			ProductAdminPageInstance.NewProductCaret(NewProductName);
			String ProductId =ProductAdminPageInstance.getProductId();//mou
			Logger.info("Product Id is:"+ProductId);//mou
			Thread.sleep(5000);//mou


			ProductAdminPageInstance.AddSection(NewProductName);//swagata



		String SectionName=ProductAdminPageInstance.SectionName();
		Thread.sleep(5000);
Logger.info("New Section name is:"+SectionName);//swagata
		ProductAdminPageInstance.SelectDfp();

			ProductAdminPageInstance.SectionButtonSave();
			Thread.sleep(8000);


			

			ProductAdminPageInstance.ExpandCreatedProduct(NewProductName);
			Thread.sleep(2000);
			String SectionId =ProductAdminPageInstance.getSectionId();//mou
			Logger.info("Section Id is:"+SectionId);//mou

			ProductAdminPageInstance.NewSectionCaret(SectionName);//swagata
			

			//Thread.sleep(6000);//swagata

			ProductAdminPageInstance.AddSubSection(SectionName);//swagata

			String SubSectionName=ProductAdminPageInstance.SubSectionName();
			Logger.info("New SubSection name is:"+SubSectionName);//swagata


			ProductAdminPageInstance.SubSectionButtonSave();


			/**
			 * DeleteSubSection
			 */

			

			ProductAdminPageInstance.ExpandCreatedSection(SectionName);//swagata
			//Thread.sleep(2000);//swagata
			ProductAdminPageInstance.NewSubSectionCaret(SubSectionName);//swagata
			String SubSectionId =ProductAdminPageInstance.getSubSectionId();//mou
			Logger.info("SubSection Id is:"+SubSectionId);//mou

			//Thread.sleep(6000);//swagata

			ProductAdminPageInstance.DeleteSubSection(SubSectionName);//swagata
			Thread.sleep(6000);//mou

            ProductAdminPageInstance.clickOkInConfirmMessage();
//dashboardPageInstance.clickOnLogout();//swagata
			dashboardPageInstance.clickondropdownforlogout();//joy
		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}

	}
	/**
	 * Validate-Adding Business Unit is working

	 *///swagata



	@Test(groups = {"AddDeleteBU"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void AddDeleteBU(Map<String, String> userData) throws Exception
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
			Thread.sleep(3000); 
			ProductAdminPage ProductAdminPageInstance = PageFactory.initElements(driver, ProductAdminPage.class);
			ProductAdminPageInstance.addBusinessUnit("CTC-CTMG");

			String NewBUName=ProductAdminPageInstance.BUName();
			ProductAdminPageInstance.abbreviation();
			ProductAdminPageInstance.save();
			Thread.sleep(8000); 

			// Give rights to add bu

			ProductAdminPageInstance.removeBusinessUnit(NewBUName);




		}

		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}

	}

}

