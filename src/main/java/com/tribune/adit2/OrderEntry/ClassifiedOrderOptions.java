package com.tribune.adit2.OrderEntry;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

public class ClassifiedOrderOptions {
	@FindBy(xpath = "//select[@id='adSizes.Id']")
	public WebElement Adsize;//swagata
	//@FindBy(xpath = "(//label[text()='Contact Email']//following::textarea[@type='email'])[1]")
	@FindBy(xpath = "(//div[@id='package-attributes']//label[text()='Contact Email']//following::div[@class='input'])[1]")
	public WebElement ContactEmail;//swagata
	@FindBy(xpath = "(//button[@type='button'][text()='Save'])[2]")
	public WebElement SaveAttributeBtn;//swagata
	@FindBy(xpath = "//div[@class='ngucarousel']/div[@class='ngucarousel-items']//ngu-tile//img")
	public List<WebElement> imgCarousal;//swagata
	@FindBy(xpath = "//button[text()='Close']")
	public WebElement CloseButton;
	@FindBy(xpath = "//input[@placeholder='First Name']")
	public WebElement FirstNameAdMaterial;//swagata
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	public WebElement LastNameAdMaterial;//swagata
	@FindBy(xpath = "(//label[text()='First Name']//following-sibling::div/input)[1]")
	public WebElement FirstNameAttribute;//swagata
	@FindBy(xpath = "(//label[text()='Last Name']//following-sibling::div/input)[1]")
	public WebElement LastNameAttribute;//swagata
	@FindBy (xpath = "//span[@class='input-group-addon pointer']/i")
	public WebElement addOnChargemagnifier;//partha
	@FindBy (xpath = "//button[contains(text(),'Cancel')]")
	public WebElement CancelButtonAddonCharge;//partha
	@FindBy (xpath = "//button[contains(text(),'Confirm')]")
	public WebElement ConfirmButtonAddonCharge;//partha
	@FindBy (xpath = "//label[text()='Lock Order Lines']")
	public WebElement LockOrderLines;//partha
	

	//@FindBy(xpath = "//textarea[@ng-reflect-name='ObitText']")
	@FindBy(xpath = "//textarea[contains(@placeholder,'Obit Text')or @placeholder='ObitText' or @placeholder='Obituary Text']")
	public WebElement ObitTextAdMaterial;//swagata
	
	@FindBy(xpath = "//span[text()='Save & Continue Booking']")
	public WebElement SaveAndContinue;//swagata
	@FindBy(xpath = "//div[@id='package-attributes']//label[text()='City']//following-sibling::div//input[@type='text']")
	public WebElement cityTextField;//swagata
	@FindBy(xpath = "//div[@id='package-attributes']//label[text()='State']//following-sibling::div//span[@title='Click to edit']")
	public WebElement StateDropdown;//swagata
	@FindBy(xpath = "//div[@id='package-attributes']//label[text()='Town 1']//following-sibling::div//span[@title='Click to edit']")
	public WebElement Town1Dropdown;//swagata
	@FindBy(xpath = "//div[@id='package-attributes']//label[text()='Contact Name']/following-sibling::div//input[@type='text']")
	public WebElement ContactName;//swagata
	
	@FindBy(xpath = "//div[@id='package-attributes']//label[text()='Town Name for Obit Index VMG']//following-sibling::div//span[@title='Click to edit']")
	public WebElement TownnameDropdown;//Partha

	@FindBy(xpath = "//div/p[text()='File is too large, maximum permitted file size is: 10MB.']")//payel
	public WebElement UploadAdErrMsg;//payel

	@FindBy(xpath = ".//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/a/span/span")//Payel
	public WebElement MakeAttribute;//Payel

	@FindBy(xpath = "//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/form/div/select")//Payel
	public WebElement makeDrpdwn;//Payel

	@FindBy(xpath =".//*[@id='package-attributes']/div/div[2]/dynamic-field/div/div/a/span/span")//payel
	public WebElement ModelAttribute;//Payel

	@FindBy(xpath =".//*[@id='package-attributes']/div/div[2]/dynamic-field/div/div/form/div/select")//payel
	public WebElement ModelDrpdown;//Payel

	@FindBy(xpath =".//*[@id='package-attributes']/div/div[3]/dynamic-field/div/div/form/div/select")//payel
	public WebElement YearDrpdown;//Payel

	@FindBy(xpath =".//*[@id='package-attributes']/div/div[3]/dynamic-field/div/div/a/span/span")//payel
	public WebElement YearAttribute;//Payel

	@FindBy(xpath = "//input[@title='Upload Image']")//Swagata
	public WebElement UploadAttribute1mg;

	@FindBy(xpath = "//span[text()='Duplicate']")
	public WebElement DuplicateOrderLink;

	@FindBy(xpath = ".//*[@id='lineErrorMessage']/ul/li")
	public WebElement UploadAdErrMsg1;

	@FindBy(xpath = "(//label[contains(text(),'Adsize')]/../div/a/span[@id='Span3']/span)")
	public WebElement EditAdLink;

	@FindBy(xpath = "//span[text()='Total Amount:']/following-sibling::span")
	public WebElement TotalPrice;

	@FindBy(xpath = ".//*[@id='insertionInfo']/form/div/table/tbody[1]/tr[2]/td/div[2]/div/div/div[1]/div/div/div[1]/div[3]/div/form/div/select")
	public WebElement AdsizeDrpDwn;

	@FindBy(xpath = "//span[text()='Tearsheets ']")// Ritoban
	public WebElement TearsheetTab;

	@FindBy(xpath = "//a[text()='New Tearsheet']")// Ritoban
	public WebElement NewTearsheetLnk;

	@FindBy(xpath = ".//*[@id='package-tearsheets']/div[1]/table/tbody/tr")// Ritoban
	public WebElement TearsheetEntry;	

	@FindBy(xpath = "//span[text()='Processed']")
	public WebElement OrderStatus;

	@FindBy(xpath = "(//span[@id='Span4']/span)[1]")
	public WebElement AgencyCommission;	

	@FindBy(xpath = ".//*[@id='order-detail-page']/div[2]/div[4]/div[2]/form/div/table/tbody[1]/tr[1]/td[2]/div/div[3]/a/i")
	public WebElement OrderMoreOptions;

	@FindBy(id = "BusinessUnitId")
	public WebElement businessUnitDrpDwn;

	@FindBy(xpath = ".//*[@id='bu.id']")
	public WebElement ClassifiedBUDrpDwn;

	@FindBy(xpath = ".//*[@id='sc.id']")
	public WebElement ClassifiedSubcategoryDrpDwn;

	@FindBy(xpath = "//*[@id='products.Id']")
	public WebElement ClassifiedProductDrpDwn;

	@FindBy(xpath = ".//*[@id='pckDtls.Id']")
	public WebElement ClassifiedPackageDrpDwn;

	@FindBy(xpath = ".//*[@id='clsCode.Id']")
	public WebElement ClassifiedClassCodeDrpDwn;

	//@FindBy(xpath = ".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/thead/tr[1]/th[3]")					 
	@FindBy(xpath = ".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/thead/tr[2]/th[3]")
	public WebElement NextMnth;

	//@FindBy(xpath = ".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/thead/tr[1]/th[1]")					 
	@FindBy(xpath = ".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/thead/tr[2]/th[1]")
	public WebElement PrevMnth;

	@FindBy(xpath = ".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr[2]/td[4]")
	public WebElement Date;

	@FindBy(xpath = "//*[@id='order-detail-page']/div[2]/div[4]/form/div[1]/div/button[1]")
	public WebElement ApplyBtn;

	@FindBy(xpath = "//*[@id='order-detail-page']/div[2]/div[4]/form/div[1]/div/div/button[1]")
	public WebElement EditAdBtn;

	//@FindBy(xpath = "//*[@id='designAd']/div[1]/div/a/span")
	//div[@class='col-md-12']/a
	@FindBy(xpath="//div[@class='col-md-12']/a") //Shalini and payel
	public WebElement UploadAdlink1;
	@FindBy(xpath="//*[text()='Design Your Material']") //Partha
	public WebElement DesignYourMaterial;

	//@FindBy(xpath = ".//*[@id='newCSRUploaderLinkButton']")
	//button[@auto-test='uploadImage']
	@FindBy(xpath="//input[@title='Upload Material']")//Shalini and payel
	public WebElement UploadAdBtn;	
	//shalini added
	@FindBy(xpath="//button[@auto-test='Crop']")
	public WebElement VerifyCropMaterial;

	@FindBy(xpath="(//*[text()='Toggle Dropdown'])[3]/..")
	public WebElement EditAdDropdown;	

	@FindBy(xpath="//a[text()='Upload Ad']")
	public WebElement EditAdDropdown_uploadAdBtn;


	//@FindBy(xpath = ".//*[@id='saveCropperImage']")
	//span[@class='cropper-line line-e']
	@FindBy(xpath = "//span[text()='accept & continue']")//shalini	
	public WebElement ADSSAcceptBtn;

	//@FindBy(xpath = ".//*[@id='acceptBtn']")
	//button[@auto-test='accept']/span
	@FindBy(xpath = "//span[text()='Save And Continue']")//Shalini
	public WebElement ADSSSaveBtn;	

	@FindBy(xpath = "//*[@id='packageInfo']/ul/li[2]/a/span")
	public WebElement AttributeTab;				

	@FindBy(xpath = "//button[contains(text(), 'OK')]")
	public WebElement ModifyOrderOKBtn;		

	@FindBy(xpath = "//*[@id='packageInfo']/div[2]/label/input")
	public WebElement LockOrderLinesChckBox;

	@FindBy(xpath = "(//span[text()='Processed ']/preceding-sibling::a)[1]")
	public WebElement OrderWithProcessedStatus;

	@FindBy(xpath = "//div[text()='01-00']/preceding-sibling::div/i")
	public WebElement FirstInsertionMoreOptions;

	@FindBy(xpath = "//button[text()='Continue']")
	public WebElement ContinueBtnForPastPubdateOrderAlert;

	@FindBy(xpath = "//*[@id='packageInfo']/ul/li[2]/a/span")
	public WebElement attributeTab;// arka

	@FindBy(xpath = "//*[@id='package-attributes']/div/div[18]/dynamic-field/div/div/input")
	public WebElement attributeTabZipCode;// arka

	@FindBy(xpath = "//*[@id='package-attributes']/div/div[19]/button")
	public WebElement attributeTabSaveButton;// arka

	private WebDriver driver;
	//WebDriverWait wait = new WebDriverWait(driver,200);

	Properties properties = TribuneUtils.readProperties();

	public ClassifiedOrderOptions(WebDriver driver)
	{
		this.driver = driver;
	}

	public void waitUntilElementVisible(WebElement webElement) {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(webElement));

	}

	//Code to select business Unit
	public void selectBU(String BU) throws Exception
	{
		try
		{
			if (businessUnitDrpDwn.isDisplayed())
			{
				businessUnitDrpDwn.click();
				Select valueFromBU = new Select(businessUnitDrpDwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
					Logger.info(properties.getProperty(BU)+ " business Unit is selected"); 
				}
				else
				{
					Logger.info("drop down is empty");
				}
			}
			else
			{
				Logger.info("Business Unit drop down is not displayed");
				throw new NoSuchElementException("Business Unit drop down is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void selectPackageBU(String insertionIndex,int row, int col) throws Exception
	{
		try
		{
			String value = TribuneUtils.getStringCellValues("ClassifiedOrder",row, col);
			//String value="DPR";
			Logger.info("BU="+value);
			switch(value)
			{
			case "LAT": 
				if (ClassifiedBUDrpDwn.isDisplayed())
				{						  
					ClassifiedBUDrpDwn.click();
					Thread.sleep(2000);
					Select valueFromBU = new Select(ClassifiedBUDrpDwn);
					List<WebElement> listOfValuesBU = valueFromBU.getOptions();
					if(listOfValuesBU.size() !=0)
					{
						Logger.info("size:"+listOfValuesBU.size());
						//valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						// valueFromBU.selectByValue(value);
						valueFromBU.selectByVisibleText(value);
						// valueFromBU.selectByIndex(0);
						Logger.info(value+ " business Unit is selected"); 
					}
					else
					{
						Logger.info("drop down is empty");
					}
				}
				else
				{
					Logger.info("Business Unit drop down is not displayed");
					throw new NoSuchElementException("Business Unit drop down is not displayed");
				}
				break;

			case "DPR": 
				if (ClassifiedBUDrpDwn.isDisplayed())
				{
					ClassifiedBUDrpDwn.click();
					Select valueFromBU = new Select(ClassifiedBUDrpDwn);
					List<WebElement> listOfValuesBU = valueFromBU.getOptions();
					if(listOfValuesBU.size() !=0)
					{
						//valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						//valueFromBU.selectByIndex(1);
						valueFromBU.selectByVisibleText(value);
						Logger.info(value+ " business Unit is selected"); 
					}
					else
					{
						Logger.info("drop down is empty");
					}
				}
				else
				{
					Logger.info(" Business Unit drop down is not displayed");
					throw new NoSuchElementException(" Business Unit drop down is not displayed");
				}
				break;

			case "TMN": 
				if (ClassifiedBUDrpDwn.isDisplayed())
				{
					ClassifiedBUDrpDwn.click();
					Select valueFromBU = new Select(ClassifiedBUDrpDwn);
					List<WebElement> listOfValuesBU = valueFromBU.getOptions();
					if(listOfValuesBU.size() !=0)
					{
						//valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						//valueFromBU.selectByIndex(2);
						valueFromBU.selectByVisibleText(value);
						Logger.info(value+ "Package business Unit is selected"); 
					}
					else
					{
						Logger.info("drop down is empty");
					}
				}
				else
				{
					Logger.info(" Business Unit drop down is not displayed");
					throw new NoSuchElementException(" Business Unit drop down is not displayed");
				}
				break;

			case "CTC": 
				if (ClassifiedBUDrpDwn.isDisplayed())
				{Logger.info("CTC"); 
				ClassifiedBUDrpDwn.click();
				Select valueFromBU = new Select(ClassifiedBUDrpDwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					//valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
					//valueFromBU.selectByIndex(3);
					valueFromBU.selectByVisibleText(value);
					Logger.info(value+ "Package business Unit is selected"); 
				}
				else
				{
					Logger.info("drop down is empty");
				}
				}
				else
				{
					Logger.info(" Business Unit drop down is not displayed");
					throw new NoSuchElementException(" Business Unit drop down is not displayed");
				}
				break;

			case "OSC": 
				if (ClassifiedBUDrpDwn.isDisplayed())
				{
					ClassifiedBUDrpDwn.click();
					Select valueFromBU = new Select(ClassifiedBUDrpDwn);
					List<WebElement> listOfValuesBU = valueFromBU.getOptions();
					if(listOfValuesBU.size() !=0)
					{
						//valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						//valueFromBU.selectByIndex(4);
						valueFromBU.selectByVisibleText(value);
						Logger.info(value+ "Package business Unit is selected"); 
					}
					else
					{
						Logger.info("drop down is empty");
					}
				}
				else
				{
					Logger.info(" Business Unit drop down is not displayed");
					throw new NoSuchElementException(" Business Unit drop down is not displayed");
				}
				break;

			case "SSC": 
				if (ClassifiedBUDrpDwn.isDisplayed())
				{
					ClassifiedBUDrpDwn.click();
					Select valueFromBU = new Select(ClassifiedBUDrpDwn);
					List<WebElement> listOfValuesBU = valueFromBU.getOptions();
					if(listOfValuesBU.size() !=0)
					{
						//valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						//valueFromBU.selectByIndex(5);
						valueFromBU.selectByVisibleText(value);
						Logger.info(value+ "Package business Unit is selected"); 
					}
					else
					{
						Logger.info("drop down is empty");
					}
				}
				else
				{
					Logger.info(" Business Unit drop down is not displayed");
					throw new NoSuchElementException(" Business Unit drop down is not displayed");
				}
				break;

			case "TBS": 
				if (ClassifiedBUDrpDwn.isDisplayed())
				{
					ClassifiedBUDrpDwn.click();
					Select valueFromBU = new Select(ClassifiedBUDrpDwn);
					List<WebElement> listOfValuesBU = valueFromBU.getOptions();
					if(listOfValuesBU.size() !=0)
					{
						//valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						//valueFromBU.selectByIndex(6);
						valueFromBU.selectByVisibleText(value);
						Logger.info(value+ "Package business Unit is selected"); 
					}
					else
					{
						Logger.info("drop down is empty");
					}
				}
				else
				{
					Logger.info(" Business Unit drop down is not displayed");
					throw new NoSuchElementException(" Business Unit drop down is not displayed");
				}
				break;

			case "ALT": 
				if (ClassifiedBUDrpDwn.isDisplayed())
				{
					ClassifiedBUDrpDwn.click();
					Select valueFromBU = new Select(ClassifiedBUDrpDwn);
					List<WebElement> listOfValuesBU = valueFromBU.getOptions();
					if(listOfValuesBU.size() !=0)
					{
						//valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						//valueFromBU.selectByIndex(7);
						valueFromBU.selectByVisibleText(value);
						Logger.info(value+ "Package business Unit is selected"); 
					}
					else
					{
						Logger.info("drop down is empty");
					}
				}
				else
				{
					Logger.info(" Business Unit drop down is not displayed");
					throw new NoSuchElementException(" Business Unit drop down is not displayed");
				}
				break;

			case "HTF": 
				if (ClassifiedBUDrpDwn.isDisplayed())
				{
					ClassifiedBUDrpDwn.click();
					Select valueFromBU = new Select(ClassifiedBUDrpDwn);
					List<WebElement> listOfValuesBU = valueFromBU.getOptions();
					if(listOfValuesBU.size() !=0)
					{
						//valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						//valueFromBU.selectByIndex(8);
						valueFromBU.selectByVisibleText(value);
						Logger.info(value+ "Package business Unit is selected"); 
					}
					else
					{
						Logger.info("drop down is empty");
					}
				}
				else
				{
					Logger.info(" Business Unit drop down is not displayed");
					throw new NoSuchElementException(" Business Unit drop down is not displayed");
				}
				break;

			case "SDT": 
				if (ClassifiedBUDrpDwn.isDisplayed())
				{
					ClassifiedBUDrpDwn.click();
					Select valueFromBU = new Select(ClassifiedBUDrpDwn);
					List<WebElement> listOfValuesBU = valueFromBU.getOptions();
					if(listOfValuesBU.size() !=0)
					{
						//valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						//valueFromBU.selectByIndex(9);
						valueFromBU.selectByVisibleText(value);
						Logger.info(value+ "Package business Unit is selected"); 
					}
					else
					{
						Logger.info("drop down is empty");
					}
				}
				else
				{
					Logger.info(" Business Unit drop down is not displayed");
					throw new NoSuchElementException(" Business Unit drop down is not displayed");
				}
				break;

			case "MOT": 
				if (ClassifiedBUDrpDwn.isDisplayed())
				{
					ClassifiedBUDrpDwn.click();
					Select valueFromBU = new Select(ClassifiedBUDrpDwn);
					List<WebElement> listOfValuesBU = valueFromBU.getOptions();
					if(listOfValuesBU.size() !=0)
					{
						//valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						//valueFromBU.selectByIndex(10);
						valueFromBU.selectByVisibleText(value);
						Logger.info(value+ "Package business Unit is selected"); 
					}
					else
					{
						Logger.info("drop down is empty");
					}
				}
				else
				{
					Logger.info(" Business Unit drop down is not displayed");
					throw new NoSuchElementException(" Business Unit drop down is not displayed");
				}
				break;

			case "TIC": 
				if (ClassifiedBUDrpDwn.isDisplayed())
				{
					ClassifiedBUDrpDwn.click();
					Select valueFromBU = new Select(ClassifiedBUDrpDwn);
					List<WebElement> listOfValuesBU = valueFromBU.getOptions();
					if(listOfValuesBU.size() !=0)
					{
						//valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						//valueFromBU.selectByIndex(11);
						valueFromBU.selectByVisibleText(value);
						Logger.info(value+ "Package business Unit is selected"); 
					}
					else
					{
						Logger.info("drop down is empty");
					}
				}
				else
				{
					Logger.info(" Business Unit drop down is not displayed");
					throw new NoSuchElementException(" Business Unit drop down is not displayed");
				}
				break;

			case "TRG": 
				if (ClassifiedBUDrpDwn.isDisplayed())
				{
					ClassifiedBUDrpDwn.click();
					Select valueFromBU = new Select(ClassifiedBUDrpDwn);
					List<WebElement> listOfValuesBU = valueFromBU.getOptions();
					if(listOfValuesBU.size() !=0)
					{
						//valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						//valueFromBU.selectByIndex(12);
						valueFromBU.selectByVisibleText(value);
						Logger.info(value+ "Package business Unit is selected"); 
					}
					else
					{
						Logger.info("drop down is empty");
					}
				}
				else
				{
					Logger.info(" Business Unit drop down is not displayed");
					throw new NoSuchElementException(" Business Unit drop down is not displayed");
				}
				break;
			case "NDN": 
				if (ClassifiedBUDrpDwn.isDisplayed())
				{Logger.info("NDN"); 
				ClassifiedBUDrpDwn.click();
				Select valueFromBU = new Select(ClassifiedBUDrpDwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					//valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
					//valueFromBU.selectByIndex(3);
					valueFromBU.selectByVisibleText(value);
					Logger.info(value+ "Package business Unit is selected"); 
				}
				else
				{
					Logger.info("drop down is empty");
				}
				}
				else
				{
					Logger.info(" Business Unit drop down is not displayed");
					throw new NoSuchElementException(" Business Unit drop down is not displayed");
				}
				break;//swagata

			default: 
				break;
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to select package Subcategory
	// Designed by rmukhopadhyay
	public void selectClassifiedSubcategoryDrpDwn(String insertionIndex,int row, int col) throws Exception
	{				
		try
		{
			String value = TribuneUtils.getStringCellValues("ClassifiedOrder",row, col);
			// String value="Automotive";
			// String value="Legal: Notices";
			//String value="Other Classified - Obituaries";
			if (ClassifiedSubcategoryDrpDwn.isDisplayed())
			{
				//  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ClassifiedSubcategoryDrpDwn);
				ClassifiedSubcategoryDrpDwn.click();
				Select valueFromBU = new Select(ClassifiedSubcategoryDrpDwn);
				Logger.info(" subcategory dropdown is expanded");
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();

				if(listOfValuesBU.size() !=0)
				{			
					//	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", listOfValuesBU);
					valueFromBU.selectByVisibleText(value);
					//valueFromBU.selectByIndex(1);
					Logger.info(value+ " subcategory is selected"); 
				}
				else
				{
					Logger.info("drop down is empty");
				}
			}
			else
			{
				Logger.info("Package subcategory drop down is not displayed");
				throw new NoSuchElementException("Package subcategory drop down is not displayed");
			}

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

			Thread.sleep(4000);

		}
		catch(Exception e)
		{
			Logger.info("Inside exception");
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectClassifiedSubcategoryDrpDwnByIndex(int index) throws Exception
	{				
		try
		{
			if (ClassifiedBUDrpDwn.isDisplayed())
			{
				ClassifiedBUDrpDwn.click();
				Select valueFromBU1 = new Select(ClassifiedBUDrpDwn);
				Logger.info(" bu dropdown is expanded");
				List<WebElement> listOfValuesBU1 = valueFromBU1.getOptions();

				if(listOfValuesBU1.size() !=0)
				{			

					//listOfValuesBU. valueFromBU.selectByVisibleText(value);
					//valueFromBU.selectByIndex(index);
					valueFromBU1.selectByVisibleText("HTF");//mou
					Logger.info(" bu is selected"); 
				}
				else
				{
					Logger.info("drop down is empty");
				}
			}
			else
			{
				Logger.info("Package bu drop down is not displayed");
				throw new NoSuchElementException("Package bu drop down is not displayed");
			}


			// String value="Automotive";
			// String value="Legal: Notices";
			//String value="Other Classified - Obituaries";
			if (ClassifiedSubcategoryDrpDwn.isDisplayed())
			{
				ClassifiedSubcategoryDrpDwn.click();
				Select valueFromBU = new Select(ClassifiedSubcategoryDrpDwn);
				Logger.info(" subcategory dropdown is expanded");
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();

				if(listOfValuesBU.size() !=0)
				{			

					//listOfValuesBU. valueFromBU.selectByVisibleText(value);

					//valueFromBU.selectByIndex(index); 
					//valueFromBU.selectByVisibleText("Legal: Notices");
					valueFromBU.selectByVisibleText("Merchandise");

					//valueFromBU.selectByIndex(index);
					valueFromBU.selectByVisibleText("Legal: Public Notices/Auctions");

					Logger.info(" subcategory is selected"); 
				}
				else
				{
					Logger.info("drop down is empty");
				}
			}
			else
			{
				Logger.info("Package subcategory drop down is not displayed");
				throw new NoSuchElementException("Package subcategory drop down is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.info("Inside exception");
			Logger.error(e.getMessage());
			throw e;
		} 
	}	
	//Code to select package Product
	// Designed by rmukhopadhyay
	public void selectClassifiedProductDrpDwn(String insertionIndex,int row, int col) throws Exception
	{
		try
		{
			Logger.info("Package product selection starts");
			String value = TribuneUtils.getStringCellValues("ClassifiedOrder",row, col);
			//String value="classified.chicagotribune.com [Online]";
			//String value="Chicago Tribune  [Classified Listings]";
			//String value="Daily Press [Classified Listings]";
			Logger.info(value+ "Package product is picked from excel");
			//	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ClassifiedProductDrpDwn);
			if (ClassifiedProductDrpDwn.isDisplayed())
			{
				//ClassifiedProductDrpDwn.click();
				Select valueFromBU = new Select(ClassifiedProductDrpDwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				
				for (WebElement webElement : listOfValuesBU) {
		            String name = webElement.getText();
		            Logger.info("option values:"+name); 
		            System.out.println(name);
		        }
				
				if(listOfValuesBU.size() !=0)
				{ //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", listOfValuesBU);
					//valueFromBU.selectByVisibleText(properties.getProperty(product).toString());
					valueFromBU.selectByVisibleText(value);
					//valueFromBU.selectByIndex(1);
					Logger.info(value+ "Package product is selected"); 
					JavascriptExecutor js = ((JavascriptExecutor) driver);
					js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

					Thread.sleep(4000);
					Logger.info("Package product selection ends");

				}
				else
				{
					Logger.info("drop down is empty");
				}
			}
			else
			{
				Logger.info("Package product drop down is not displayed");
				throw new NoSuchElementException("Package product drop down is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectClassifiedProductDrpDwnByIndex(int index) throws Exception
	{
		try
		{
			//String value = TribuneUtils.getStringCellValues("ClassifiedOrder",row, col);
			//String value="classified.chicagotribune.com [Online]";
			//String value="Chicago Tribune  [Classified Listings]";
			//String value="Daily Press [Classified Listings]";
			//Logger.info(value+ "Package product is selected");
			if (ClassifiedProductDrpDwn.isDisplayed())
			{
				ClassifiedProductDrpDwn.click();
				Select valueFromBU = new Select(ClassifiedProductDrpDwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					//valueFromBU.selectByVisibleText(properties.getProperty(product).toString());
					// valueFromBU.selectByVisibleText(value);
					valueFromBU.selectByIndex(index);
					Logger.info("Package product is selected"); 
				}
				else
				{
					Logger.info("drop down is empty");
				}
			}
			else
			{
				Logger.info("Package product drop down is not displayed");
				throw new NoSuchElementException("Package product drop down is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to select package Product
	// Designed by rmukhopadhyay
	public void selectClassifiedPackage(String insertionIndex,int row, int col) throws Exception
	{
		try
		{
			String value = TribuneUtils.getStringCellValues("ClassifiedOrder",row, col);
			//String value="Auto Other Pioneer Central";
			//String value="IL Govt Legal Notice CTC";
			//String value="DP Obituaries NEW";
			Logger.info(value+ "Package is selected");
			if (ClassifiedPackageDrpDwn.isDisplayed())
			{
				ClassifiedPackageDrpDwn.click();
				Select valueFromBU = new Select(ClassifiedPackageDrpDwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					//valueFromBU.selectByVisibleText(properties.getProperty(packg).toString());
					valueFromBU.selectByVisibleText(value); 
					//valueFromBU.selectByIndex(1);
					Logger.info(value+ "Package is selected"); 
				}
				else
				{
					Logger.info("drop down is empty");
				}
			}
			else
			{
				Logger.info("Package drop down is not displayed");
				throw new NoSuchElementException("Package drop down is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	public void selectClassifiedPackageByName(String pkg) throws Exception
	{
		try
		{

			if (ClassifiedPackageDrpDwn.isDisplayed())
			{
				ClassifiedPackageDrpDwn.click();
				Select valueFromBU = new Select(ClassifiedPackageDrpDwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					//valueFromBU.selectByVisibleText(properties.getProperty(packg).toString());
					valueFromBU.selectByVisibleText(pkg); 
					//valueFromBU.selectByIndex(1);
					Logger.info(pkg+ "Package is selected"); 
				}
				else
				{
					Logger.info("drop down is empty");
				}
			}
			else
			{
				Logger.info("Package drop down is not displayed");
				throw new NoSuchElementException("Package drop down is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	public void selectClassifiedPackageByIndex(int index) throws Exception
	{
		try
		{
			Thread.sleep(4000);
			Logger.info("Package selection starts"); 

			//String value = TribuneUtils.getStringCellValues("ClassifiedOrder",row, col);
			//String value="Auto Other Pioneer Central";
			//String value="IL Govt Legal Notice CTC";
			//String value="DP Obituaries NEW";

			if (ClassifiedPackageDrpDwn.isDisplayed())
			{
				ClassifiedPackageDrpDwn.click();
				Select valueFromBU = new Select(ClassifiedPackageDrpDwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					//valueFromBU.selectByVisibleText(properties.getProperty(packg).toString());
					// valueFromBU.selectByVisibleText(value); 
					valueFromBU.selectByIndex(1);
					Logger.info("Package is selected"); 
				}
				else
				{
					Logger.info("drop down is empty");
				}
			}
			else
			{
				Logger.info("Package drop down is not displayed");
				throw new NoSuchElementException("Package drop down is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	//Code to select package Product
	// Designed by rmukhopadhyay
	public void selectClassifiedClassCode(String insertionIndex,int row, int col) throws Exception
	{
		try
		{
			String value = TribuneUtils.getStringCellValues("ClassifiedOrder",row, col);
			//String value="76407 - Autos Wanted";
			//String value="11015 - Legal Notices - Government/Education";
			//String value="90100 - Paid Obituaries";
			if (ClassifiedClassCodeDrpDwn.isDisplayed())
			{
				ClassifiedClassCodeDrpDwn.click();
				Select valueFromBU = new Select(ClassifiedClassCodeDrpDwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", listOfValuesBU);
					//valueFromBU.selectByVisibleText(properties.getProperty(classcode).toString());
					valueFromBU.selectByVisibleText(value);
					//valueFromBU.selectByIndex(1);
					Logger.info(value+ "Classcode is selected"); 
				}
				else
				{
					Logger.info("drop down is empty");
				}
			}
			else
			{
				Logger.info("Classcode drop down is not displayed");
				throw new NoSuchElementException("classcode drop down is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectClassifiedClassCodeByIndex(int index) throws Exception
	{
		try
		{
			//String value = TribuneUtils.getStringCellValues("ClassifiedOrder",row, col);
			//String value="76407 - Autos Wanted";
			//String value="11015 - Legal Notices - Government/Education";
			//String value="90100 - Paid Obituaries";
			if (ClassifiedClassCodeDrpDwn.isDisplayed())
			{
				ClassifiedClassCodeDrpDwn.click();
				Select valueFromBU = new Select(ClassifiedClassCodeDrpDwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					//valueFromBU.selectByVisibleText(properties.getProperty(classcode).toString());
					//	  valueFromBU.selectByVisibleText(value);
					valueFromBU.selectByIndex(index);
					Logger.info("Classcode is selected"); 
				}
				else
				{
					Logger.info("drop down is empty");
				}
			}
			else
			{
				Logger.info("Classcode drop down is not displayed");
				throw new NoSuchElementException("classcode drop down is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectNewClassifiedClassCode(String classCode) throws Exception
	{
		try
		{
			//String value = TribuneUtils.getStringCellValues("ClassifiedOrder",row, col);
			//String value="76407 - Autos Wanted";
			//String value="11015 - Legal Notices - Government/Education";
			//String value="90100 - Paid Obituaries";
			if (ClassifiedClassCodeDrpDwn.isDisplayed())
			{
				ClassifiedClassCodeDrpDwn.click();
				Select valueFromBU = new Select(ClassifiedClassCodeDrpDwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					//valueFromBU.selectByVisibleText(properties.getProperty(classcode).toString());
					valueFromBU.selectByVisibleText(classCode);
					//valueFromBU.selectByIndex(1);
					Logger.info(classCode+ "Classcode is selected"); 
				}
				else
				{
					Logger.info("drop down is empty");
				}
			}
			else
			{
				Logger.info("Classcode drop down is not displayed");
				throw new NoSuchElementException("classcode drop down is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void verifyPackageDrpDwn() throws Exception
	{
		try
		{
			ClassifiedBUDrpDwn.click();
			Select valueFromBU = new Select(ClassifiedBUDrpDwn);
			List<WebElement> listOfValuesBU = valueFromBU.getOptions();
			Logger.info(Integer.toString(listOfValuesBU.size()));
			if(listOfValuesBU.size() !=0)
			{
				for(int i=0;i<listOfValuesBU.size();i++){
					Logger.info("i="+i);
					valueFromBU.selectByIndex(i);				    		  
					Logger.info("Business Unit "+i+" is selected"); 

					Thread.sleep(2000);

					ClassifiedSubcategoryDrpDwn.click();
					Select valueFromSubcategory = new Select(ClassifiedSubcategoryDrpDwn);								 
					List<WebElement> listOfValuesSC = valueFromSubcategory.getOptions();
					Logger.info(Integer.toString(listOfValuesSC.size()));
					if(listOfValuesSC.size() >1){
						for(int Subcategory=0;Subcategory<listOfValuesSC.size()-1;Subcategory++){
							Logger.info("Subcategory="+Subcategory);
							valueFromSubcategory.selectByIndex(Subcategory);
							Logger.info("Subcategory "+Subcategory+" is selected"); 
							Thread.sleep(2000);

							Select valueFromPackage = new Select(ClassifiedPackageDrpDwn);
							List<WebElement> listOfValuesPckg = valueFromPackage.getOptions();
							if(listOfValuesPckg.size() !=0){
								Logger.info("Package drop down is not empty");
								Assert.assertEquals("str", "str");
							}
							else{
								Logger.info("Package drop down is empty");
								Assert.assertEquals("str", "str1");
							}
						}//end of FOR							    	
					}//end of ClassifiedSubcategoryDrpDwn IF
					else
					{
						Logger.info("ClassifiedSubcategoryDrpDwn drop down is empty");
					}//end of ClassifiedSubcategoryDrpDwn ELSE							  
				} //END OF FIRST FOR
			}//end of FIRST IF
		}// End of TRY
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}		

	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void selectDate(String str) throws Exception
	{
		try
		{
			switch (str) {
			case "nextmonth":
				if (NextMnth.isDisplayed())
				{
					NextMnth.click();
					Thread.sleep(3000);
					//Date.click();
					int i=1;
					String flag="false";
					while(i>0)
					{
						//WebElement date1= driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr[2]/td["+i+"]"));//swagata
						WebElement date= driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr[4]/td["+i+"]"));//swagata
						String attribute= date.getAttribute("class");

						if(!(attribute.contains("disabled")))
						{
							//driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr[2]/td["+i+"]")).click();//swagata
							date.click();//swagata
							Logger.info("Date is selected");
							flag="true";
							break;
						}else if(i==7)
							break;
						//End of if
						i++;
					}//End of while

					if(flag=="false"){
						Logger.info("Enabled date is not available");}
					else{

					}

				}
				else
				{
					Logger.info("Next Month link is not displayed");
					throw new NoSuchElementException("Next Month link is not displayed");
				}
				break;

			case "nextday":
				DateFormat dateformat = new SimpleDateFormat("dd/MM/yy");
				Calendar calendarobj = Calendar.getInstance();
				calendarobj.add(calendarobj.DAY_OF_MONTH, 1);
				Logger.info(dateformat.format(calendarobj.getTime()));
				String[] string = dateformat.format(calendarobj.getTime()).split("/");
				List<WebElement> menuLI1 = driver.findElements(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr"));					       						
				Logger.info("presentdate,listsize:"+menuLI1.size());

				Logger.info("presentdate,listsize:"+menuLI1.size());
				for(int i=1; i<=menuLI1.size();i++){ Logger.info("i:"+i);
				int j=1;
				while(j<=7){
					String appdate = driver.findElement(By.xpath(
							".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr["+i+"]/td["+j+"]"))
							.getText();					    	   
					Logger.info("presentdate,appdate: "+appdate+" j="+j);
					if(appdate.equals(string[0]) || ("0"+appdate).equals(string[0])){
						Logger.info("inside IF");
						driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).click();
						i=1000; break; }
					j++;
				}// End of While
				}// End of FOR

				break;
			case "prevmonth": 
				if (PrevMnth.isDisplayed())
				{
					PrevMnth.click();
					Thread.sleep(3000);
					//Date.click();
					int i=1;
					String flag="false";
					while(i>0)
					{
						WebElement date1= driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr[2]/td["+i+"]"));
						String attribute= date1.getAttribute("class");

						if(!(attribute.contains("disabled")))
						{
							driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr[2]/td["+i+"]")).click();
							Logger.info("Date is selected");
							flag="true";
							break;
						}else if(i==7)
							break;
						//End of if
						i++;
					}//End of while

					if(flag=="false"){
						Logger.info("Enabled date is not available");}
					else{

					}

				}
				else
				{
					Logger.info("Prev Month link is not displayed");
					throw new NoSuchElementException("Prev Month link is not displayed");
				}
				break;

			case "presentdate":
				DateFormat df = new SimpleDateFormat("dd/MM/yy");		      
				Calendar calobj = Calendar.getInstance();
				Logger.info(df.format(calobj.getTime()));
				String[] a= df.format(calobj.getTime()).split("/");
				Logger.info("Date: "+a[0]);
				List<WebElement> menuLI = driver.findElements(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr"));					       						
				Logger.info("presentdate,listsize:"+menuLI.size());
				for(int i=1; i<=menuLI.size();i++){ Logger.info("i:"+i);
				int j=1;
				while(j<=7){
					String appdate = driver.findElement(By.xpath(
							".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr["+i+"]/td["+j+"]"))
							.getText();					    	   
					Logger.info("presentdate,appdate: "+appdate+" j="+j);
					if(appdate.equals(a[0]) || ("0"+appdate).equals(a[0])){
						Logger.info("inside IF");
						driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).click();
						i=1000; break; }
					j++;
				}// End of While
				}// End of FOR
				break;

			case "2weeks":
				if (NextMnth.isDisplayed())
				{
					NextMnth.click();
					Thread.sleep(3000);
					//Date.click();							 
					String flag="false";

					for(int j=2;j<=3;j++){Logger.info("j="+j);
					for(int i=1;i<=7;i++)
					{
						Logger.info("i="+i);
						WebElement date1= driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr["+j+"]/td["+i+"]"));
						String attribute= date1.getAttribute("class");

						if(!(attribute.contains("disabled")))
						{
							driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr["+j+"]/td["+i+"]")).click();
							Logger.info("Date is selected");
							flag="true";
						}//End of if								
					}//End of inner FOR(i)
					}//End of outer FOR(j)
					if(flag=="false"){
						Logger.info("Enabled date is not available");}
					else{

					}

				}
				else
				{
					Logger.info("Next Month link is not displayed");
					throw new NoSuchElementException("Next Month link is not displayed");
				}
				break;

			case "1month":
				if (NextMnth.isDisplayed())
				{
					NextMnth.click();
					Thread.sleep(3000);
					//Date.click();							 
					String flag="false";

					for(int j=2;j<=5;j++){Logger.info("j="+j);
					for(int i=1;i<=7;i++)
					{
						Logger.info("i="+i);
						WebElement date1= driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr["+j+"]/td["+i+"]"));
						String attribute= date1.getAttribute("class");

						if(!(attribute.contains("disabled")))
						{
							driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr["+j+"]/td["+i+"]")).click();
							Logger.info("Date is selected");
							flag="true";
						}//End of if								
					}//End of inner FOR(i)
					}//End of outer FOR(j)
					if(flag=="false"){
						Logger.info("Enabled date is not available");}
					else{

					}

				}
				else
				{
					Logger.info("Next Month link is not displayed");
					throw new NoSuchElementException("Next Month link is not displayed");
				}
				break;
			case "1week":
				if (NextMnth.isDisplayed())
				{
					NextMnth.click();
					Thread.sleep(3000);
					//Date.click();							 
					String flag="false";

					for(int j=2;j<=2;j++){Logger.info("j="+j);
					for(int i=1;i<=7;i++)
					{
						Logger.info("i="+i);
						WebElement date1= driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr["+j+"]/td["+i+"]"));
						String attribute= date1.getAttribute("class");

						if(!(attribute.contains("disabled")))
						{
							driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr["+j+"]/td["+i+"]")).click();
							Logger.info("Date is selected");
							flag="true";
						}//End of if								
					}//End of inner FOR(i)
					}//End of outer FOR(j)
					if(flag=="false"){
						Logger.info("Enabled date is not available");}
					else{

					}

				}
				else
				{
					Logger.info("Next Month link is not displayed");
					throw new NoSuchElementException("Next Month link is not displayed");
				}
				break;
			default:					        
				break;
			}


		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public String modifyPubDate() throws Exception
	{String changeddate=null, newdate=null;
	try
	{
		if (NextMnth.isDisplayed())
		{
			NextMnth.click();
			Thread.sleep(3000);
			//Date.click();
			int i=1;
			String flag="false";
			while(i>0)
			{
				WebElement date1= driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr[4]/td["+i+"]"));
				String attribute= date1.getAttribute("class");

				if(!(attribute.contains("disabled")))
				{
					driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr[4]/td["+i+"]")).click();
					Logger.info("Date is selected");
					flag="true";
					changeddate=driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[3]/div[1]/div/div[1]/table/tbody/tr[4]/td["+i+"]")).getText();
					break;
				}else if(i==7)
					break;
				//End of if
				i++;
			}//End of while

			if(flag=="false"){
				Logger.info("Enabled date is not available");}					  
			else{
				DateFormat df = new SimpleDateFormat("dd/MM/yy");		      
				Calendar calobj = Calendar.getInstance();
				Logger.info(df.format(calobj.getTime()));
				String[] a= df.format(calobj.getTime()).split("/");
				int month = Integer.parseInt(a[1]);
				month=month+2;
				String mm=Integer.toString(month);
				mm="0"+mm;
				Logger.info(a[0]+mm+a[2]);
				newdate=mm+"/"+changeddate+"/20"+a[2];
				Logger.info(newdate);
				return newdate;
			}

		}
		else
		{
			Logger.info("Next Month link is not displayed");
			throw new NoSuchElementException("Next Month link is not displayed");
		}				  
	}
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
	finally{
		return newdate;
	}
	}
	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void clickApplyBtn() throws Exception
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, 300);");

		Thread.sleep(4000);
		try
		{
			if (ApplyBtn.isDisplayed())
			{
				ApplyBtn.click();
				Logger.info("Apply Button is clicked");
			}
			else
			{
				Logger.info("Apply Button is not displayed");
				throw new NoSuchElementException("Apply Button is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void clickFirstInsertionMoreOptions() throws Exception
	{
		try
		{
			if (FirstInsertionMoreOptions.isDisplayed())
			{
				FirstInsertionMoreOptions.click();
				Logger.info("More Options of First Insertion is clicked");
			}
			else
			{
				Logger.info("More Options of First Insertion is not displayed");
				throw new NoSuchElementException("More Options of First Insertion is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	

	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void ModifyAdSize() throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,200);		       
			wait.until(ExpectedConditions.elementToBeClickable(EditAdLink));

			if (EditAdLink.isDisplayed())
			{
				EditAdLink.click();
				Logger.info("Edit Ad Link of first insertion is clicked");
			}
			else
			{
				Logger.info("Edit Ad Link of first insertion is not displayed");
				throw new NoSuchElementException("Edit Ad Link of first insertion is not displayed");
			}

			wait.until(ExpectedConditions.elementToBeClickable(AdsizeDrpDwn));

			Select valueFromAdsize = new Select(AdsizeDrpDwn);
			List<WebElement> listOfValuesAdsize = valueFromAdsize.getOptions();
			if(listOfValuesAdsize.size() > 1)
			{				    	 
				valueFromAdsize.selectByIndex(listOfValuesAdsize.size()-1);
				Logger.info("Adsize is modified"); 
			}
			else
			{
				Logger.info("Adsize drop down do not have more than one option");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void clickEditAdBtn() throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,200);		       
			//					  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='toast-container']/.../div")));
			wait.until(ExpectedConditions.elementToBeClickable(EditAdBtn));
			if (EditAdBtn.isDisplayed())
			{
				EditAdBtn.click();
				Logger.info("Edit Ad Button is clicked");

				//Thread.sleep(5000);
				// Thread.sleep(20000);//swagata
				Thread.sleep(7000);
				Logger.info(driver.getCurrentUrl());//swagata
			}
			else
			{
				Logger.info("Edit Ad Button is not displayed");
				throw new NoSuchElementException("Edit Ad Button is not displayed");
			}					  					  

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickEditAdDropdown_uploadAdBtn() throws InterruptedException{		

		Thread.sleep(10000);
		Actions action = new Actions(driver);
		action.moveToElement(EditAdDropdown).click().build().perform();
		//EditAdDropdown.click();
		Thread.sleep(5000);
		EditAdDropdown_uploadAdBtn.click();
		Thread.sleep(5000);
		Logger.info("File is uploaded successfully");

	}

	public void uploadAdOnly() throws InterruptedException{		

		driver.switchTo().frame(0);
		Thread.sleep(2000);
		UploadAdBtn.sendKeys(System.getProperty("user.dir") + "\\ClassfiedFile\\RoysRoofing.pdf");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Logger.info("File is uploaded successfully");

	}

	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void uploadAd(String insertionIndex,int row, int col) throws Exception
	{ 
		//Runtime.getRuntime().exec("D:\\Automation\\test.exe");

		//String pathForImage = System.getProperty("user.dir")+ "ClassfiedFile\\RoysRoofing.pdf";
		//Logger.info("pathForImage:"+pathForImage);
		List<WebElement> ele = driver.findElements(By.tagName("frame"));
		System.out.println("Number of frames in a page :" + ele.size());
		for(WebElement el : ele){
			//Returns the Id of a frame.
			Logger.info("Frame Id :" + el.getAttribute("id"));
			//Returns the Name of a frame.
			Logger.info("Frame name :" + el.getAttribute("name"));
		}

		String filename = TribuneUtils.getStringCellValues("ClassifiedOrder",row, col);
		Logger.info("File to be uploaded: "+filename);
		try
		{
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			WebDriverWait wait = new WebDriverWait(driver,200);		       

			// wait.until(ExpectedConditions.elementToBeClickable(UploadAdlink1));
			wait.until(ExpectedConditions.elementToBeClickable(UploadAdlink1));//swagata
			Thread.sleep(5000);//Shalini and payel
			if (UploadAdlink1.isEnabled())//Shalini and payel
			{
				Thread.sleep(3000);//Shalini and payel
				UploadAdlink1.click();
				//Thread.sleep(10000);//Shalini and payel
				Logger.info("Upload Ad link is clicked");//shalini
			}
			else
			{
				Logger.info("Upload Ad link is not displayed");
				throw new NoSuchElementException("Edit Ad Button is not displayed");
			}
			// wait.until(ExpectedConditions.elementToBeClickable(UploadAdBtn));
			Thread.sleep(7000);//Shalini and payel
			if (UploadAdBtn.isEnabled())
			{
				Thread.sleep(3000);
				//UploadAdBtn.click();//shalini and payel
				Logger.info("Upload ad bttn selected file need to be selectd");//Shalini and payel
				String filepath = System.getProperty("user.dir")+ "\\ClassfiedFile\\"+filename;//swagata
				Thread.sleep(3000);//Shalini and payel
				UploadAdBtn.sendKeys(filepath);//shalini

				Logger.info("File is selected successfully");//shalini
			}
			else
			{
				Logger.info("Upload Ad Button and file  is not displayed");
				throw new NoSuchElementException("Upload Ad Button is not displayed");
			}

			Thread.sleep(10000);

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ADSSAcceptBtn);


			// wait.until(ExpectedConditions.elementToBeClickable(ADSSAcceptBtn));//shalini
			//Thread.sleep(10000);	//shalini
			if (ADSSAcceptBtn.isEnabled())//shalini
			{	
				ADSSAcceptBtn.click();
				Thread.sleep(3000);					//shalini		  
				Logger.info("Accept Button is clicked");
			}
			else
			{
				Logger.info("Accept Button is not displayed");
				throw new NoSuchElementException("Accept Button is not displayed");
			}

			//wait = new WebDriverWait(driver,30);		       
			wait.until(ExpectedConditions.elementToBeClickable(ADSSSaveBtn));
			if (ADSSSaveBtn.isDisplayed())
			{
				ADSSSaveBtn.click();
				Thread.sleep(10000);							  
				Logger.info("ADSS SAVE Button is clicked");
			}
			else
			{
				Logger.info("ADSS SAVE Button is not displayed");
				throw new NoSuchElementException("ADSS SAVE Button is not displayed");
			}
			wait.until(ExpectedConditions.invisibilityOfElementLocated
					(By.xpath("//div[contains(text(),'Processing your material... Please wait.')]")));						  
			driver.switchTo().defaultContent();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	public void verifyEditAdWindowMaximize() throws Exception
	{ 
		//Runtime.getRuntime().exec("D:\\Automation\\test.exe");

		//String pathForImage = System.getProperty("user.dir")+ "ClassfiedFile\\RoysRoofing.pdf";
		//Logger.info("pathForImage:"+pathForImage);
		List<WebElement> ele = driver.findElements(By.tagName("frame"));
		System.out.println("Number of frames in a page :" + ele.size());
		for(WebElement el : ele){
			//Returns the Id of a frame.
			Logger.info("Frame Id :" + el.getAttribute("id"));
			//Returns the Name of a frame.
			Logger.info("Frame name :" + el.getAttribute("name"));
		}



		try
		{
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

			Thread.sleep(6000);
			//WebDriverWait wait = new WebDriverWait(driver,200);		       
			// wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath("//button[@class='close modal-resizer']/i")))));
			// html/body/div[1]/div/div/div/div[1]/button
			WebElement element = driver.findElement(By.tagName("iframe"));
			//  if (driver.findElement(By.xpath("//button[@class='close modal-resizer']/i")).isDisplayed())
			//  {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.height = '200px';", element);
			//	  Logger.info("Maximize button displayed");
			//	  driver.findElement(By.xpath("//button[@class='close modal-resizer'/i]")).click();
			//driver.manage().window().maximize();
			Logger.info("Edit Ad Window Maximized");
			//  }
			//  else
			//  {
			//	  Logger.info("Edit Ad Window did not open properly");
			//	  throw new NoSuchElementException("Edit Ad Window is not displayed");
			//  }

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void uploadAdLegal(String insertionIndex,int row, int col) throws Exception
	{ Logger.info("Upload Legal AD");
	String filename = TribuneUtils.getStringCellValues("ClassifiedOrder",row, col);
	Logger.info("filename:"+filename);
	String pathForImage = System.getProperty("user.dir")+ "ClassfiedFile\\"+filename;
	Logger.info("pathForImage:"+pathForImage);

	try
	{
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		WebDriverWait wait = new WebDriverWait(driver,200);		       
		wait.until(ExpectedConditions.elementToBeClickable(UploadAdlink1));
		if (UploadAdlink1.isDisplayed())
		{
			UploadAdlink1.click();
			Logger.info("Upload Ad Button is clicked");
		}
		else
		{
			Logger.info("Upload Ad Button is not displayed");
			throw new NoSuchElementException("Edit Ad Button is not displayed");
		}

		if (UploadAdBtn.isDisplayed())
		{
			UploadAdBtn.click();
			Thread.sleep(3000);
			//UploadAdBtn.sendKeys(pathForImage);
			Robot robot = new Robot();							 

			String text = System.getProperty("user.dir")+ "\\ClassfiedFile\\"+filename;
			Logger.info(text);
			StringSelection stringSelection = new StringSelection(text);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, stringSelection);

			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			// driver.findElement(By.id("newUploader")).sendKeys(pathForImage);
			//Thread.sleep(20000);
			wait.until(ExpectedConditions.elementToBeClickable(ADSSAcceptBtn));
			Logger.info("Upload Ad Button is clicked");
		}
		else
		{
			Logger.info("Upload Ad Button is not displayed");
			throw new NoSuchElementException("Upload Ad Button is not displayed");
		}

		if (ADSSAcceptBtn.isDisplayed())
		{
			ADSSAcceptBtn.click();
			//Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(ADSSSaveBtn));
			Logger.info("Accept Button is clicked");
		}
		else
		{
			Logger.info("Accept Button is not displayed");
			throw new NoSuchElementException("Accept Button is not displayed");
		}

		if (ADSSSaveBtn.isDisplayed())
		{
			ADSSSaveBtn.click();
			Thread.sleep(12000);							  
			Logger.info("ADSS SAVE Button is clicked");
		}
		else
		{
			Logger.info("ADSS SAVE Button is not displayed");
			throw new NoSuchElementException("ADSS SAVE Button is not displayed");
		}

		driver.switchTo().defaultContent();
	}
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
	}				


	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void uploadMultipleZoneAd() throws Exception
	{ 			  
		try
		{
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

			driver.findElement(By.xpath(".//*[@id='sliderContainer']/div[1]/div/div/div[1]/a/img")).click()	;
			Thread.sleep(4000);
			driver.findElement(By.xpath(".//*[@id='adTemplateForm']/div/div/div[4]/div/input")).click();
			Thread.sleep(12000);	
			driver.switchTo().defaultContent();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	//Code to select package business Unit
	// Designed by smukherjee 
	public void enterAttributeDetailsALTVolDisc() throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,200);
			wait.until(ExpectedConditions.elementToBeClickable(AttributeTab));
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				Thread.sleep(12000);
				//WebDriverWait wait = new WebDriverWait(driver,200);		       
				//wait.until(ExpectedConditions.presenceOfElementLocated
				//(By.xpath(".//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/input")));
				Logger.info("AttributeTab is clicked");
				/*	  
						  wait.until(ExpectedConditions.presenceOfElementLocated
					    		  (By.xpath("//*[@id='package-attributes']/div/div[2]/dynamic-field/div/div/a/span/span")));
						  driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[2]/dynamic-field/div/div/a/span/span")).click();	
						  wait.until(ExpectedConditions.presenceOfElementLocated
					    		  (By.xpath("//*[@id='package-attributes']/div/div[2]/dynamic-field/div/div/form/div/select")));
						  ClassifiedClassCodeDrpDwn = driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[2]/dynamic-field/div/div/form/div/select"));
						  Select valueFromBU = new Select(ClassifiedClassCodeDrpDwn);
					      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
					      if(listOfValuesBU.size() !=0)
						      {
						    	 //valueFromBU.selectByVisibleText(properties.getProperty(classcode).toString());
					    	  valueFromBU.selectByVisibleText("Commercial");
					    	  //valueFromBU.selectByIndex(1);

						      }
					      else
					      {
					    	  Logger.info("Property Type drop down is empty");
					      }
						  Logger.info("Property Type Selected");
						  Thread.sleep(4000);
				 */
				/*driver.findElement(By.xpath(".//*[@id='package-attributes')/div/div[2]/dynamic-field/div/div/input")).sendKeys("9999999999");						  						 
						  Logger.info("Phone Number Entered");
						  Thread.sleep(10000);*/
				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath(".//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/input")));
				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/input")).sendKeys("Chicago");						  						  
				Logger.info("City Entered");
				Thread.sleep(2000);

				//  wait.until(ExpectedConditions.presenceOfElementLocated
				//		  (By.xpath("//*[@id='package-attributes']/div/div[4]/dynamic-field/div/div/input")));
				//  driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[4]/dynamic-field/div/div/input")).sendKeys("Test Lane");						  						  
				//  Logger.info("Address Entered");
				//  /*driver.findElement(By.xpath(".//*[@id='package-attributes')/div/div[4]/dynamic-field/div/div/input")).sendKeys("Test-Emblem");						  						  

				//  Logger.info("Emblem Entered");
				//  Thread.sleep(10000);*/

				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath(".//*[@id='package-attributes']/div/div[6]/dynamic-field/div/div/input")));
				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[6]/dynamic-field/div/div/input")).sendKeys("60504");						  						  
				Logger.info("Zip Entered");
				/*	  
						  wait.until(ExpectedConditions.presenceOfElementLocated
					    		  (By.xpath("//*[@id='package-attributes']/div/div[7]/dynamic-field/div/div/input")));
						  driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[7]/dynamic-field/div/div/input")).sendKeys("7");						  						  
						  Logger.info("Price Entered");

						  wait.until(ExpectedConditions.presenceOfElementLocated
					    		  (By.xpath("//*[@id='package-attributes']/div/div[8]/dynamic-field/div/div/input")));
						  driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[8]/dynamic-field/div/div/input")).sendKeys("test@testmail.com");						  						  
						  Logger.info("Email Entered");
				 */
				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath(".//*[@id='package-attributes']/div/div[5]/dynamic-field/div/div/textarea")));
				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[5]/dynamic-field/div/div/textarea")).sendKeys("Test-Ad-Text");						  						  
				Logger.info("Ad Text Entered");
				//Thread.sleep(4000);

				/*
						  wait.until(ExpectedConditions.presenceOfElementLocated
					    		  (By.xpath("//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/input")));
						  driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/input")).sendKeys("3122225080");						  						  
						  Logger.info("Phone Number Entered");
						  Thread.sleep(4000);
						  wait.until(ExpectedConditions.presenceOfElementLocated
					    		  (By.xpath("//*[@id='package-attributes']/div/div[6]/dynamic-field/div/div/a/span/span")));
						  driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[6]/dynamic-field/div/div/a/span/span")).click();	
						  wait.until(ExpectedConditions.presenceOfElementLocated
					    		  (By.xpath("//*[@id='package-attributes']/div/div[6]/dynamic-field/div/div/form/div/select")));
						  ClassifiedClassCodeDrpDwn = driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[6]/dynamic-field/div/div/form/div/select"));
						  Select valueFromBU1 = new Select(ClassifiedClassCodeDrpDwn);
					      List<WebElement> listOfValuesBU1 = valueFromBU1.getOptions();
					      if(listOfValuesBU1.size() !=0)
						      {
						    	 //valueFromBU.selectByVisibleText(properties.getProperty(classcode).toString());
					    	  valueFromBU1.selectByVisibleText("AL");
					    	  //valueFromBU.selectByIndex(1);

						      }
					      else
					      {
					    	  Logger.info("State drop down is empty");
					      }
						  Logger.info("State Selected");
				 */ 
				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath("//*[@id='package-attributes']/div/div[12]/button")));
				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[12]/button")).click();
				Logger.info("SAVE button is clicked");
				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}



	public void enterAttributeDetails() throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,200);
			wait.until(ExpectedConditions.elementToBeClickable(AttributeTab));
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				Thread.sleep(12000);
				//WebDriverWait wait = new WebDriverWait(driver,200);		       
				//wait.until(ExpectedConditions.presenceOfElementLocated
				//(By.xpath(".//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/input")));
				Logger.info("AttributeTab is clicked");
				//Payel
				MakeAttribute.click();
				Actions action = new Actions(driver);
				action.moveToElement(makeDrpdwn).click().build().perform(); 
				Logger.info("Make drop down is clicked");  
				WebElement searchResult = makeDrpdwn;
				Thread.sleep(5000);
				//  Actions action1 = new Actions(driver);
				Select select = new Select(searchResult);
				select.selectByVisibleText("Acura");
				Logger.info("make attribute is selected"); 

				//Payel
				//	driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/input")).sendKeys("TEST");;						  						  
				//	Logger.info("Item Type Entered");
				//Thread.sleep(4000);

				/*driver.findElement(By.xpath(".//*[@id='package-attributes')/div/div[2]/dynamic-field/div/div/input")).sendKeys("9999999999");						  						 
						  Logger.info("Phone Number Entered");
						  Thread.sleep(10000);*/
				//				wait.until(ExpectedConditions.presenceOfElementLocated
				//						(By.xpath(".//*[@id='package-attributes']/div/div[3]/dynamic-field/div/div/input")));
				//				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[3]/dynamic-field/div/div/input")).sendKeys("60504");						  						  
				//				Logger.info("Zip Entered");
				//Thread.sleep(2000);

				/*driver.findElement(By.xpath(".//*[@id='package-attributes')/div/div[4]/dynamic-field/div/div/input")).sendKeys("Test-Emblem");						  						  
						  Logger.info("Emblem Entered");
						  Thread.sleep(10000);*/

				//Payel
				ModelAttribute.click();
				Actions action2 = new Actions(driver);
				action2.moveToElement(ModelDrpdown).click().build().perform(); 
				Logger.info("Model drop down is clicked");  
				WebElement searchResult1 = ModelDrpdown;
				Thread.sleep(5000);
				//Actions action3 = new Actions(driver);
				Select select1 = new Select(searchResult1);
				select1.selectByVisibleText("100");
				Logger.info("Model attribute is selected"); 

				//Payel
				//Payel
				YearAttribute.click();
				Actions action1 = new Actions(driver);
				action1.moveToElement(YearDrpdown).click().build().perform(); 
				Logger.info("Year drop down is clicked");  
				WebElement searchResult2 = YearDrpdown;
				Thread.sleep(5000);
				Select select2 = new Select(searchResult2);
				select2.selectByVisibleText("1899");
				Logger.info("Year attribute is selected"); 

				//Payel


				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath(".//*[@id='package-attributes']/div/div[8]/dynamic-field/div/div/textarea")));
				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[8]/dynamic-field/div/div/textarea")).sendKeys("Test-Ad-Text");						  						  
				Logger.info("Ad Text Entered");
				Thread.sleep(4000);

				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath("//*[@id='package-attributes']/div/div[10]/dynamic-field/div/div/input")));
				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[10]/dynamic-field/div/div/input")).sendKeys("100");						  						  
				Logger.info("Ad Text Entered");
				Thread.sleep(4000);

				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[17]/button")).click();
				Logger.info("SAVE button is clicked");
				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void enterAttributeDetailsDPR() throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,200);
			wait.until(ExpectedConditions.elementToBeClickable(AttributeTab));
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				Thread.sleep(12000);
				//WebDriverWait wait = new WebDriverWait(driver,200);		       
				//wait.until(ExpectedConditions.presenceOfElementLocated
				//(By.xpath(".//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/input")));
				Logger.info("AttributeTab is clicked");

				Thread.sleep(2000);
				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath("//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/input")));
				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/input")).sendKeys("Illinois");						  						  
				Logger.info("City Entered");

				Thread.sleep(2000);
				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath("//*[@id='package-attributes']/div/div[7]/dynamic-field/div/div/textarea")));
				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[7]/dynamic-field/div/div/textarea")).sendKeys("Test-Ad-Text");						  						  
				Logger.info("Ad Text Entered");
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[25]/button")).click();
				Logger.info("SAVE button is clicked");
				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void enterAttributeDetailsSSC() throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,200);
			wait.until(ExpectedConditions.elementToBeClickable(AttributeTab));
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				Thread.sleep(12000);
				//WebDriverWait wait = new WebDriverWait(driver,200);		       
				//wait.until(ExpectedConditions.presenceOfElementLocated
				//(By.xpath(".//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/input")));
				Logger.info("AttributeTab is clicked");


				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath("//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/a/span/span")));
				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/a/span/span")).click();
				WebElement makeDrpdwn = driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/form/div/select"));
				Select select = new Select (makeDrpdwn);
				select.selectByIndex(105);

				Logger.info("Make Selected");

				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath("//*[@id='package-attributes']/div/div[2]/dynamic-field/div/div/a/span/span")));
				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[2]/dynamic-field/div/div/a/span/span")).click();
				WebElement modelDrpdwn = driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[2]/dynamic-field/div/div/form/div/select"));
				Select select2 = new Select (modelDrpdwn);
				// select1.selectByIndex(250);
				// Create instance of Javascript executor
				JavascriptExecutor je1 = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element1 = driver.findElement(By.tagName("Camry"));
				// now execute query which actually will scroll until that element is not appeared on page.
				je1.executeScript("arguments[0].scrollIntoView(true);",element1);
				select2.selectByValue("string:Camry");
				Logger.info("Model Selected");

				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath(".//*[@id='package-attributes']/div/div[3]/dynamic-field/div/div/input")));
				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[3]/dynamic-field/div/div/input")).sendKeys("LE");						  						  
				Logger.info("Model Entered");
				//Thread.sleep(4000);


				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath(".//*[@id='package-attributes']/div/div[4]/dynamic-field/div/div/a/span/span")));
				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[4]/dynamic-field/div/div/a/span/span")).click();
				WebElement yearDrpdwn = driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[4]/dynamic-field/div/div/form/div/select"));
				Select select3 = new Select (yearDrpdwn);
				select3.selectByIndex(95);
				Logger.info("Year Selected");


				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath(".//*[@id='package-attributes']/div/div[5]/dynamic-field/div/div/input")));
				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[5]/dynamic-field/div/div/input")).sendKeys("Test Customer");						  						  
				Logger.info("Contact Name Entered");
				//Thread.sleep(4000);

				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath(".//*[@id='package-attributes']/div/div[12]/dynamic-field/div/div/input")));
				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[12]/dynamic-field/div/div/input")).sendKeys("1800");						  						  
				Logger.info("Price Entered");
				//Thread.sleep(4000);

				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath(".//*[@id='package-attributes']/div/div[6]/dynamic-field/div/div/input")));
				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[6]/dynamic-field/div/div/input")).sendKeys("954-573-7489");						  						  
				Logger.info("Phone Entered");
				//Thread.sleep(4000);

				/*	  wait.until(ExpectedConditions.presenceOfElementLocated
					    		  (By.xpath(".//*[@id='package-attributes']/div/div[14]/dynamic-field/div/div/input")));
						  driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[14]/dynamic-field/div/div/input")).sendKeys("Irving");						  						  
						  Logger.info("City Entered");
						  //Thread.sleep(4000);

						  wait.until(ExpectedConditions.presenceOfElementLocated
					    		  (By.xpath(".//*[@id='package-attributes']/div/div[9]/dynamic-field/div/div/input")));
						  driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[9]/dynamic-field/div/div/input")).sendKeys("954-573-7489");						  						  
						  Logger.info("Zip Code Entered");
						  //Thread.sleep(4000);
				 */

				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath("//*[@id='package-attributes']/div/div[11]/dynamic-field/div/div/textarea")));
				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[11]/dynamic-field/div/div/textarea")).sendKeys("Loaded with all the bells and whistles!  New brakes & tires. Asking $1800 OBO.");						  						  
				Logger.info("Ad Text Entered");
				//Thread.sleep(4000);

				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[14]/button")).click();
				Logger.info("SAVE button is clicked");
				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	public void verifyAttributeDetails() throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,200);
			wait.until(ExpectedConditions.elementToBeClickable(AttributeTab));
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				Thread.sleep(12000);
				//WebDriverWait wait = new WebDriverWait(driver,200);		       
				//wait.until(ExpectedConditions.presenceOfElementLocated
				//(By.xpath(".//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/input")));
				Logger.info("AttributeTab is clicked");

				String itemType = driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/input")).getAttribute("value");
				Logger.info("Item Type: "+itemType);
				Assert.assertEquals(itemType,"TEST");
				Logger.info("Item Type Match verified");
				//Thread.sleep(4000);

				/*driver.findElement(By.xpath(".//*[@id='package-attributes')/div/div[2]/dynamic-field/div/div/input")).sendKeys("9999999999");						  						 
						  Logger.info("Phone Number Entered");
						  Thread.sleep(10000);*/
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='package-attributes']/div/div[5]/dynamic-field/div/div/input")));
				String zip = driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[5]/dynamic-field/div/div/input")).getAttribute("value");						  						  
				Logger.info("zip: "+zip);
				Assert.assertEquals(zip,"60504");
				Logger.info("Zip Match verified");
				//Thread.sleep(2000);

				/*driver.findElement(By.xpath(".//*[@id='package-attributes')/div/div[4]/dynamic-field/div/div/input")).sendKeys("Test-Emblem");						  						  
						  Logger.info("Emblem Entered");
						  Thread.sleep(10000);*/

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='package-attributes']/div/div[3]/dynamic-field/div/div/textarea")));
				String adText = driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[3]/dynamic-field/div/div/textarea")).getAttribute("value");					  						  
				Logger.info("adText: "+adText);
				Assert.assertEquals(adText,"Test-Ad-Text");
				Logger.info("Ad Text Match verified");
				//Thread.sleep(4000);

				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void verifyVolumeDiscount() throws Exception
	{
		try
		{
			boolean flag = false;		  
			WebElement disc = driver.findElement(By.xpath("//*[@id='insertionInfo']/form/div/table/tbody[2]/tr[1]/td[12]/div/span/span"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", disc);
			if (disc.isDisplayed())
			{
				String discText = disc.getText();
				Logger.info("Volume Discount Applied: "+discText);
				flag = true;
			}
			else
			{
				Logger.info("Volume Discount not Applied");
				//Thread.sleep(4000);
			}
			Assert.assertEquals(flag, true);		  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void verifyUploadCopied() throws Exception
	{
		//Runtime.getRuntime().exec("D:\\Automation\\test.exe");

		//String pathForImage = System.getProperty("user.dir")+ "ClassfiedFile\\RoysRoofing.pdf";
		//Logger.info("pathForImage:"+pathForImage);
		List<WebElement> ele = driver.findElements(By.tagName("frame"));
		System.out.println("Number of frames in a page :" + ele.size());
		for(WebElement el : ele){
			//Returns the Id of a frame.
			Logger.info("Frame Id :" + el.getAttribute("id"));
			//Returns the Name of a frame.
			Logger.info("Frame name :" + el.getAttribute("name"));
		}


		try
		{
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			WebDriverWait wait = new WebDriverWait(driver,200);		       
			//wait.until(ExpectedConditions.elementToBeClickable(UploadAdlink1));
			Thread.sleep(7000);
			if (UploadAdlink1.isEnabled())
			{
				Thread.sleep(7000);
				UploadAdlink1.click();
				Logger.info("Upload Ad Button is clicked");
			}
			else
			{
				Logger.info("Upload Ad Button is not displayed");
				throw new NoSuchElementException("Edit Ad Button is not displayed");
			}
			Thread.sleep(25000);
			WebElement VerifyCrop = driver.findElement(By.xpath("//div[@class='text-left button-row']"));//Shalini
			//button[@auto-test='Preview']
			//button[@title='Crop Material']
			//VerifyCropMaterial.click();//Shalini
			Thread.sleep(25000);
			if (VerifyCrop.isDisplayed())//Shalini
			{
				//VerifyCrop.click();//Shalini
				System.out.println("Upload ad page opened");
				Thread.sleep(10000);
				Logger.info("Uploaded Ad copied");
			}
			else
			{
				Logger.info("Upload Ad not copied");
				throw new NoSuchElementException("Upload Ad not copied");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void enterSDTAttributeDetails6Img(int imgcount) throws Exception
	{
		try
		{
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				Thread.sleep(12000);
				Logger.info("AttributeTab is clicked");

				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[31]/dynamic-field/div/div/span")).click();					  
				Logger.info("Upload Image link clicked");
				Thread.sleep(4000);
				driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

				for(int i=1;i<=imgcount;i++){
					driver.findElement(By.xpath("(//a[text()='Select an Image'])["+i+"]")).click();
					Robot robot = new Robot();							 

					String text = System.getProperty("user.dir")+ "\\ClassfiedFile\\Image3.jpg";
					Logger.info(text);
					StringSelection stringSelection = new StringSelection(text);
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(stringSelection, stringSelection);

					Thread.sleep(3000);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);

					Thread.sleep(20000);
				}// End of FOR
				Logger.info("6 images uploaded successfully");
				driver.findElement(By.xpath(".//*[@id='updateImageListAttributeButton']")).click();
				Thread.sleep(10000);
				driver.switchTo().defaultContent();
				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to select package business Unit
	// Designed by rmukhopadhyay
	/*public void enterSDTAttributeDetails1Img(int imgcount) throws Exception
	{
		try
		{
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				Thread.sleep(12000);
				Logger.info("AttributeTab is clicked");

				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[30]/dynamic-field/div/div/span/i")).click();						  
				Logger.info("Upload Image link clicked");
				Thread.sleep(4000);
				driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

				for(int i=1;i<=imgcount;i++){
					driver.findElement(By.xpath("(//a[text()='Select an Image'])["+i+"]")).click();
					Robot robot = new Robot();							 

					String text = System.getProperty("user.dir")+ "\\ClassfiedFile\\Image3.jpg";
					Logger.info(text);
					StringSelection stringSelection = new StringSelection(text);
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(stringSelection, stringSelection);

					Thread.sleep(3000);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);

					Thread.sleep(20000);
				}// End of FOR

				driver.findElement(By.xpath(".//*[@id='updateImageListAttributeButton']")).click();
				Thread.sleep(10000);
				driver.switchTo().defaultContent();
				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}*/
	public void enterSDTAttributeDetails1Img(int imgcount) throws Exception
	{
		try
		{
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				Thread.sleep(10000);
				Logger.info("AttributeTab is clicked");
				WebDriverWait wait = new WebDriverWait(driver,200);		       
				// wait.until(ExpectedConditions.elementToBeClickable(UploadAttribute1mg));//swagata*/
				//Swagata updated
				if(UploadAttribute1mg.isEnabled()){
					Thread.sleep(5000);
					UploadAttribute1mg.click();
					//String AttributImage=driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[30]/dynamic-field/div/div/span")).click();//swagata
					// driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[30]/dynamic-field/div/div/span/i")).click();//swagata
					Thread.sleep(8000);//swagata 
					Logger.info("Upload attribute Image link clicked one or more ");
				}
				else
				{
					Logger.info("Upload attribute Image link is not clicked one or more");
				}
				//Thread.sleep(4000);//swagata
				Thread.sleep(20000);//swagata
				driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

				wait.until(ExpectedConditions.elementToBeClickable(UploadAttribute1mg));//swagata

				/* if (UploadAttributeImage.isEnabled())
							{
								Thread.sleep(3000);
								//UploadAdBtn.click();//shalini and payel
								Logger.info("Upload ad bttn for attribute image selected file need to be selectd");//Shalini and payel
								String filepath = System.getProperty("user.dir")+ "\\ClassfiedFile\\img lights.jpg";//shalini
								Thread.sleep(3000);//Shalini and payel
								//UploadAttributeImage.sendKeys(filepath);//shalini

								Logger.info(" attribut image File 1 is selected successfully");//shalini
							}
							else
							{
								Logger.info("Upload attribute button  and file  is not displayed");
								throw new NoSuchElementException("Upload attribute button  is not displayed");
							}

							Thread.sleep(10000);

							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ADSSAcceptBtn);


							// wait.until(ExpectedConditions.elementToBeClickable(ADSSAcceptBtn));//shalini

							//Pasted
						//  driver.switchTo().frame(driver.findElement(By.tagName("iframe")));//swagata
				 */


				for(int i=1;i<=imgcount;i++){
					driver.findElement(By.xpath("(//a[text()='Select an Image'])[i]")).click();
					// UploadAttributeImage.click();
					Robot robot = new Robot();							 

					String text = System.getProperty("user.dir")+ "\\ClassfiedFile\\Image3.jpg";
					Logger.info(text);
					StringSelection stringSelection = new StringSelection(text);
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(stringSelection, stringSelection);

					Thread.sleep(3000);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);

					Thread.sleep(20000);
				}// End of FOR

				driver.findElement(By.xpath(".//*[@id='updateImageListAttributeButton']")).click();
				Thread.sleep(10000);
				driver.switchTo().defaultContent();
				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}



	public void verifyLegalAttributeDetails() throws Exception
	{
		try
		{
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				Thread.sleep(12000);
				Logger.info("AttributeTab is clicked");

				String zip = driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[2]/dynamic-field/div/div/input")).getText();						  						  
				Assert.assertEquals(zip,"TEST");
				Logger.info("Zip Match verified");


				String adText = driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[4]/dynamic-field/div/div/textarea")).getText();						  						  
				Assert.assertEquals(adText,"TEST");
				Logger.info("Adtext Match verified");


			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void enterLegalAttributeDetails() throws Exception
	{
		try
		{
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				Thread.sleep(12000);
				Logger.info("AttributeTab is clicked");

				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[2]/dynamic-field/div/div/input")).sendKeys("TEST");;						  						  
				Logger.info("Zip Entered");

				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[4]/dynamic-field/div/div/textarea")).sendKeys("TEST");;						  						  
				Logger.info("Adtext Entered");

				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[7]/button")).click();
				Logger.info("SAVE button is clicked");
				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	//Partha
	public void enterRecruitmentAttributeDetails() throws Exception
	{
		try
		{
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				Thread.sleep(2000);
				Logger.info("AttributeTab is clicked");

				driver.findElement(By.xpath("//label[contains(text(),'Job Location City')]//following::input[1]")).sendKeys("TEST");;						  						  
				Logger.info("Job Location entered");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//label[contains(text(),'Job Title')]//following::input[1]")).sendKeys("TEST");;						  						  
				Logger.info("Job Title Entered");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//label[contains(text(),'Company Name')]//following::input[1]")).sendKeys("TEST");;						  						  
				Logger.info("Company name Entered");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//label[contains(text(),'Job Description')]//following::div[@class='input'])[1]")).click();
				Robot robot = new Robot();							 						  
				String text = "test";
				
				StringSelection stringSelection = new StringSelection(text);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, stringSelection);
				Logger.info("message copied");
				Thread.sleep(3000);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				
				Thread.sleep(1000);
				//driver.findElement(By.xpath("//i[@uib-tooltip='Job Description']//following::div[@class='input']")).sendKeys("TEST");;						  						  
				Logger.info("Job description Entered");
				Thread.sleep(3000);
				WebElement savebtn=driver.findElement(By.xpath("//*[@id='package-attributes']//button[contains(text(),'Save')]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", savebtn);
				Thread.sleep(2000);
				savebtn.click();
				Logger.info("SAVE button is clicked");
				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void enterDPROnineAttributeDetails() throws Exception
	{
		try
		{
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				Thread.sleep(12000);
				Logger.info("AttributeTab is clicked");

				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/input")).sendKeys("TEST");;						  						  
				Logger.info("First Name Entered");
				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[4]/dynamic-field/div/div/input")).sendKeys("TEST");;						  						  
				Logger.info("Last Name Entered");
				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[10]/dynamic-field/div/div/textarea")).sendKeys("TEST");;						  						  
				Logger.info("Obit Text Entered");
				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[15]/dynamic-field/div/div/textarea")).sendKeys("r@r.com");;						  						  
				Logger.info("Contact Email Entered");

				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[17]/button")).click();
				Logger.info("SAVE button is clicked");
				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void clickOKBtn() throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,200);		       
			wait.until(ExpectedConditions.elementToBeClickable(ModifyOrderOKBtn));
			if (ModifyOrderOKBtn.isDisplayed())
			{
				ModifyOrderOKBtn.click();
				Logger.info("OK Button is clicked");
			}
			else
			{
				Logger.info("OK Button is not displayed");
				throw new NoSuchElementException("OK Button is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void verifyPubDateChange(String addedDate) throws Exception
	{
		try
		{
			boolean flag=false;
			int i;
			List<WebElement> menuLI = driver.findElements(
					By.xpath(".//*[@id='order-detail-page']/div[2]/div[4]/div[2]/form/div/table/tbody"));

			for (i=1;i<=menuLI.size();i++){
				String pubdate=driver.findElement(By.xpath
						(".//*[@id='order-detail-page']/div[2]/div[4]/div[2]/form/div/table/tbody["+i+"]/tr[1]/td[5]/div/span")).getText();

				if(pubdate.equals(addedDate)){
					Logger.info("Pubdate modified successfully");
					flag=true;
					break;
				}//end of if				 
			}	// end of for
			if(i>menuLI.size() || flag==false)
				Logger.info("Pubdate not modified");

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void enterProofType() throws Exception
	{
		try
		{
			boolean flag=false;
			int i;
			List<WebElement> menuLI = driver.findElements(
					By.xpath(".//*[@id='order-detail-page']/div[2]/div[4]/div[2]/form/div/table/tbody"));

			for (i=1;i<=menuLI.size();i++){
				driver.findElement(By.xpath
						(".//*[@id='order-detail-page']/div[2]/div[4]/div[2]/form/div/table/tbody["+i+"]/tr[1]/td[14]/div/a/span/span"))
				.click();

				Select valueFromProofType = new Select(driver.findElement(
						By.xpath(".//*[@id='order-detail-page']/div[2]/div[4]/div[2]/form/div/table/tbody["+i+"]/tr[1]/td[14]/div/form/div/select")));			  
				valueFromProofType.selectByIndex(2);					  						 				 
			}	// end of for
			if(i>menuLI.size())
				Logger.info("All Proof Type  added");				
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickLockOrderLinesChckBox() throws Exception
	{
		try
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", LockOrderLinesChckBox);
			if (LockOrderLinesChckBox.isDisplayed())
			{
				LockOrderLinesChckBox.click();
				Logger.info("Lock OrderLinesChckBox is clicked");
			}
			else
			{
				Logger.info("Lock OrderLinesChckBox is not displayed");
				throw new NoSuchElementException("Lock OrderLinesChckBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}  
	}

	public void clickOrderMoreOptions() throws Exception
	{
		try
		{
			if (OrderMoreOptions.isDisplayed())
			{
				OrderMoreOptions.click();
				Logger.info("Order More Options is clicked");
			}
			else
			{
				Logger.info("Order More Options is not displayed");
				throw new NoSuchElementException("Order More Options is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}  
	}

	public int clickDuplicateOrderLink() throws Exception
	{
		try
		{
			List<WebElement> menuLI = driver.findElements(
					By.xpath(".//*[@id='order-detail-page']/div[2]/div[4]/div[2]/form/div/table/tbody"));			  				  

			WebDriverWait wait = new WebDriverWait(driver,300);		       
			wait.until(ExpectedConditions.elementToBeClickable(DuplicateOrderLink));
			if (DuplicateOrderLink.isDisplayed())
			{
				DuplicateOrderLink.click();
				Logger.info("Duplicate Order Link is clicked");
			}
			else
			{
				Logger.info("Duplicate Order Link is not displayed");
				throw new NoSuchElementException("Duplicate Order Link is not displayed");
			}
			return(menuLI.size());

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}  
	}

	public void verifyPrice() throws Exception
	{
		try
		{Logger.info("VerifyPrice");
		List<WebElement> menuLI = driver.findElements(
				By.xpath(".//*[@id='order-detail-page']/div[2]/div[4]/div[2]/form/div/table/tbody"));	

		double total_insertion_price=0;
		Logger.info("total_insertion_price:"+total_insertion_price);
		Logger.info("menuLI.size():"+menuLI.size());
		/*WebDriverWait wait = new WebDriverWait(driver,20);		       
		      wait.until(ExpectedConditions.elementToBeClickable(DuplicateOrderLink));*/

		for(int i=1;i<=menuLI.size(); i++){
			String insertion_price= driver.findElement(
					By.xpath(".//*[@id='order-detail-page']/div[2]/div[4]/div[2]/form/div/table/tbody["+i+"]/tr[1]/td[11]/span")).getText();
			Logger.info("insertion_price:"+insertion_price);

			if(insertion_price.contains(","))
			{
				insertion_price = insertion_price.replace(",", "");
			}
			double insertion_price_int=Double.parseDouble(insertion_price.substring(1));


			/*String[] a=insertion_price.split("\\$");
				Logger.info("a[0]:"+a[0]+"a[1]:"+a[1]);
				double insertion_price_int=Double.valueOf(a[1]);  //Integer.valueOf(a[1]);
				Logger.info("insertion_price_int:"+insertion_price_int);*/
			total_insertion_price=total_insertion_price+insertion_price_int;
			//Logger.info("total_insertion_price:"+total_insertion_price);
		}
		Logger.info("total_insertion_price:"+total_insertion_price);

		String sValue = (String) String.format("%.2f", total_insertion_price);
		Double newValue = Double.parseDouble(sValue);
		Logger.info("newValue:"+newValue);
		/*String total_price= TotalPrice.getText();  Logger.info("total_price:"+total_price);
			  String[] a1=total_price.split("\\$");Logger.info("a1[1]:"+a1[1]);
			  if(a1[1].contains(",")){ Logger.info("Replace");
				  a1[1].replace(",", "");}
			  double total_price_int=Double.valueOf(a1[1]);*/


		NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		Double total_price_int=newOrderInstance.getTotalOrderPrice();


		Logger.info("total_price_int:"+total_price_int);
		Logger.info("total_insertion_price:"+total_insertion_price);
		//if (total_price_int==total_insertion_price)
		if (Double.compare(total_price_int,newValue)==0)
		{				  
			Logger.info("Price matched");
			Assert.assertEquals("str", "str");
		}
		else
		{
			Logger.info("Price do not match");
			Assert.assertEquals("str", "str1");
		}
		}
		catch(Exception e)
		{Logger.info("Exception");
		Logger.error(e.getMessage());
		throw e;
		}  
	}

	/*public void verifyUploadAdErrorMsg(String insertionIndex,int row, int col, String errtype) throws Exception
	{
		try
		{			  
			String filename = TribuneUtils.getStringCellValues("ClassifiedOrder",row, col);
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

			if (UploadAdlink1.isDisplayed())
			{
				UploadAdlink1.click();
				Logger.info("Upload Ad Button is clicked");
			}
			else
			{
				Logger.info("Upload Ad Button is not displayed");
				throw new NoSuchElementException("Edit Ad Button is not displayed");
			}

			if (UploadAdBtn.isDisplayed())
			{
				String filepath = System.getProperty("user.dir")+ "\\ClassfiedFile\\"+filename;
				Logger.info(filepath);
				driver.findElement(By.id("newUploader")).sendKeys(filepath);
				//Thread.sleep(20000);							  
				Logger.info("Upload Ad Button is clicked");
			}
			else
			{
				Logger.info("Upload Ad Button is not displayed");
				throw new NoSuchElementException("Upload Ad Button is not displayed");
			}

			switch(errtype)
			{
			case "oversize":
				String errmsg= "File is too large, maximum permitted file size is: 10MB";
				if(UploadAdErrMsg.getText().equalsIgnoreCase(errmsg)){
					Logger.info("Actual Error Message : "+UploadAdErrMsg.getText());
					Logger.info("Correct error message is displayed");
					Assert.assertEquals("str1", "str1");
				}else{
					Logger.info("Correct error message is not displayed");
					Assert.assertEquals("str", "str1");
				}
				break;

			case "image":
				errmsg= "File has invalid extension, allowed extensions are- doc,docx,pdf";
				if(UploadAdErrMsg.getText().equalsIgnoreCase(errmsg)){

					Logger.info("Actual Error Message : "+UploadAdErrMsg.getText());
					Logger.info("Correct error message is displayed");
					Assert.assertEquals("str1", "str1");
				}else{
					Logger.info("Correct error message is not displayed");
					Assert.assertEquals("str", "str1");
				}
				break;

			default:
				break;

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}  
	}
	 */
	public void verifyUploadAdErrorMsg(String insertionIndex,int row, int col, String errtype) throws Exception
	{
		try
		{			  
			String filename = TribuneUtils.getStringCellValues("ClassifiedOrder",row, col);
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));


			/** Updated by Payel
			  if (UploadAdlink1.isDisplayed())
			  {
				  UploadAdlink1.click();
				  Logger.info("Upload Ad Button is clicked");
			  }
			  else
			  {
				  Logger.info("Upload Ad Button is not displayed");
				  throw new NoSuchElementException("Edit Ad Button is not displayed");
			  }

			  if (UploadAdBtn.isDisplayed())
			  {
				  UploadAdBtn.click();//test
				  String filepath = System.getProperty("user.dir")+ "\\ClassfiedFile\\"+filename;
				  Logger.info(filepath);
				  driver.findElement(By.id("newUploader")).sendKeys(filepath);
				  //Thread.sleep(20000);							  
				  Logger.info("Upload Ad Button is clicked");
			  }
			  else
			  {
				  Logger.info("Upload Ad Button is not displayed");
				  throw new NoSuchElementException("Upload Ad Button is not displayed");
			  }
			 **/

			//	driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			WebDriverWait wait = new WebDriverWait(driver,200);		       
			// wait.until(ExpectedConditions.elementToBeClickable(UploadAdlink1));
			Thread.sleep(20000);
			if (UploadAdlink1.isEnabled())//
			{
				Thread.sleep(3000);//
				UploadAdlink1.click();
				//Thread.sleep(10000);
				Logger.info("Upload Ad link is clicked");
			}
			else
			{
				Logger.info("Upload Ad link is not displayed");
				throw new NoSuchElementException("Edit Ad Button is not displayed");
			}
			// wait.until(ExpectedConditions.elementToBeClickable(UploadAdBtn));
			Thread.sleep(20000);
			if (UploadAdBtn.isEnabled())
			{
				Thread.sleep(3000);
				//UploadAdBtn.click();
				Logger.info("Upload ad bttn selected file need to be selectd");
				String filepath = System.getProperty("user.dir")+ "\\ClassfiedFile\\"+filename;
				Thread.sleep(3000);
				UploadAdBtn.sendKeys(filepath);
				Logger.info("File is selected successfully");
			}
			else
			{
				Logger.info("Upload Ad Button and file  is not displayed");
				throw new NoSuchElementException("Upload Ad Button is not displayed");
			}

			Thread.sleep(10000);
			//payel

			switch(errtype)
			{
			case "oversize":

				String errmsg= "File is too large, maximum permitted file size is: 10MB.";
				if(UploadAdErrMsg.getText().equalsIgnoreCase(errmsg)){
					Logger.info("Actual Error Message : "+UploadAdErrMsg.getText());
					Logger.info("Correct error message is displayed");
					Assert.assertEquals("str1", "str1");
				}else{
					Logger.info("Correct error message is not displayed");
					Assert.assertEquals("str", "str1");
				}
				break;

			case "image":
				errmsg= "File has invalid extension, allowed extensions are- doc,docx,pdf";
				if(UploadAdErrMsg.getText().equalsIgnoreCase(errmsg)){

					Logger.info("Actual Error Message : "+UploadAdErrMsg.getText());
					Logger.info("Correct error message is displayed");
					Assert.assertEquals("str1", "str1");
				}else{
					Logger.info("Correct error message is not displayed");
					Assert.assertEquals("str", "str1");
				}
				break;

			default:
				break;

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}  
	}
	public void verifyDiscountSectionAvailability() throws Exception
	{
		try
		{
			boolean flag=false;
			List<WebElement> menuLI = driver.findElements(
					By.xpath(".//*[@id='order-detail-page']/div[2]/div[4]/div[2]/form/div/table/tbody"));			  				  

			for(int i=1;i<=menuLI.size();i++){
				flag= driver.findElements(By.xpath
						(".//*[@id='order-detail-page']/div[2]/div[4]/div[2]/form/div/table/tbody["+i+"]/tr[1]/td[11]/div"))
						.size()>0;
			}// End of FOR

			if(flag==true){
				Logger.info("Discount Section is present");
				Assert.assertEquals("str1", "str1");
			}else{
				Logger.info("Discount Section is not present");
				Assert.assertEquals("str", "str1");
			}		
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}  
	}

	public void verifyInsertionPrice(String ordertype) throws Exception
	{
		switch(ordertype)
		{
		case "Legal":
			try
			{Logger.info("Inside verify decimal");
			int decimalpart, nondecimalpart;

			List<WebElement> menuLI = driver.findElements(
					By.xpath(".//*[@id='order-detail-page']/div[2]/div[4]/div[2]/form/div/table/tbody"));	

			boolean flag= false;
			Logger.info("menuLI.size():"+menuLI.size());
			for(int i=1; i<=menuLI.size(); i++){
				String price= driver.findElement(By.xpath(
						".//*[@id='order-detail-page']/div[2]/div[4]/div[2]/form/div/table/tbody["+i+"]/tr[1]/td[12]/span"))
						.getText();
				Logger.info("price:"+price);
				String[] price_arr= price.split("\\.");
				Logger.info(" price_arr[0]:"+price_arr[0]+" price_arr[1]:"+price_arr[1]);
				decimalpart = Integer.parseInt(price_arr[1]);

				String[] price_arr1= price_arr[0].split("\\$");
				nondecimalpart = Integer.parseInt(price_arr1[1]);
				Logger.info("decimalpart:"+decimalpart+" price_arr[0]:"+price_arr[0]+" price_arr[1]:"+price_arr[1]);

				if(nondecimalpart==0)
					continue;
				else if(decimalpart<0){
					Logger.info("Price rounding is applied for legal-Error");
					Assert.assertEquals("str1", "str");
					flag=true; break; }
			}// end of FOR

			if (flag==false)
			{
				Logger.info("Price rounding is not applied for legal-Expected result");
				Assert.assertEquals("str", "str");
			}
			else
			{
				Logger.info("Price rounding is applied for legal-Error");
				Assert.assertEquals("str1", "str");
			}
			}// End of TRY
			catch(Exception e)
			{Logger.info("Exception");
			Logger.error(e.getMessage());
			throw e;
			} 
			break;

		case "Non-Legal":
			try
			{Logger.info("Inside verify decimal");
			int decimalpart, nondecimalpart;

			List<WebElement> menuLI = driver.findElements(
					By.xpath(".//*[@id='order-detail-page']/div[2]/div[4]/div[2]/form/div/table/tbody"));	

			boolean flag= false;
			Logger.info("menuLI.size():"+menuLI.size());
			for(int i=1; i<=menuLI.size(); i++){
				String price= driver.findElement(By.xpath(
						".//*[@id='order-detail-page']/div[2]/div[4]/div[2]/form/div/table/tbody["+i+"]/tr[1]/td[12]/span"))
						.getText();
				Logger.info("price:"+price);
				String[] price_arr= price.split("\\.");
				Logger.info(" price_arr[0]:"+price_arr[0]+" price_arr[1]:"+price_arr[1]);
				decimalpart = Integer.parseInt(price_arr[1]);

				String[] price_arr1= price_arr[0].split("\\$");
				nondecimalpart = Integer.parseInt(price_arr1[1]);
				Logger.info("decimalpart:"+decimalpart+" price_arr[0]:"+price_arr[0]+" price_arr[1]:"+price_arr[1]);

				if(nondecimalpart==0)
					continue;
				else if(decimalpart>0){
					Logger.info("Price rounding is not applied for non-legal- Error");
					Assert.assertEquals("str1", "str");
					flag=true; break; }
			}// end of FOR

			if (flag==false)
			{
				Logger.info("Price rounding is applied for non-legal- Expected result");
				Assert.assertEquals("str", "str");
			}
			else
			{
				Logger.info("Price rounding is not applied for non-legal-Error");
				Assert.assertEquals("str1", "str");
			}
			}// End of TRY
			catch(Exception e)
			{Logger.info("Exception");
			Logger.error(e.getMessage());
			throw e;
			} 
			break;

		default:
			break;
		}// End of Switch	   
	}

	public void verifyDuplicateOrder(int previnsertioncount) throws Exception
	{
		try
		{
			int i;
			boolean flag=false;
			/*String existingpubdate=driver.findElement(By.xpath
						(".//*[@id='order-detail-page']/div[2]/div[4]/div[2]/form/div/table/tbody[3]/tr[1]/td[11]/span")).getText();
			  Logger.info("existingpubdate:"+existingpubdate);*/
			List<WebElement> menuLI = driver.findElements(
					By.xpath(".//*[@id='order-detail-page']/div[2]/div[4]/div[2]/form/div/table/tbody"));

			Logger.info("menuLI.size:"+menuLI.size()+"-previnsertioncount:"+previnsertioncount);

			if(menuLI.size()>previnsertioncount)
				Logger.info("Duplicate order inserted successfully");
			else
				Logger.info("Duplicate order is not inserted");

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 		   
	}

	public void enterTearSheetDetails() throws Exception
	{
		try
		{
			if (TearsheetTab.isDisplayed())
			{
				TearsheetTab.click();
				Logger.info("Tearsheet Tab is clicked");
			}
			else
			{
				Logger.info("Tearsheet Tab is not displayed");
				throw new NoSuchElementException("Tearsheet Tab is not displayed");
			}
			WebDriverWait wait = new WebDriverWait(driver,200);		       
			wait.until(ExpectedConditions.elementToBeClickable(NewTearsheetLnk));

			if (NewTearsheetLnk.isDisplayed())
			{
				NewTearsheetLnk.click(); 
				Logger.info("NewTearsheet Lnk is clicked");
			}
			else
			{
				Logger.info("NewTearsheet Lnk is not displayed");
				throw new NoSuchElementException("NewTearsheet Lnk is not displayed");
			}

			Thread.sleep(4000);

			driver.findElement(By.xpath("//label[text()='Quantity:']/following-sibling::input")).sendKeys("2");
			driver.findElement(By.xpath("//label[text()='Company:']/following-sibling::input")).sendKeys("TEST COMPANY");
			driver.findElement(By.xpath("//label[text()='City:']/following-sibling::input")).sendKeys("TEST CITY");
			driver.findElement(By.xpath("//label[text()='Zip:']/following-sibling::input")).sendKeys("TEST ZIP");
			driver.findElement(By.xpath("//label[text()='Contact:']/following-sibling::input")).sendKeys("9999999999");
			driver.findElement(By.xpath("//label[text()='Address:']/following-sibling::input")).sendKeys("TEST ADDRESS");
			driver.findElement(By.xpath("//label[text()='State:']/following-sibling::input")).sendKeys("TEST STATE");
			driver.findElement(By.xpath("//label[text()='Phone:']/following-sibling::input")).sendKeys("9999999999");

			driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[3]/button[1]")).click();
			Thread.sleep(4000);

			Logger.info("All tearsheet infos have been entered");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 

	}

	public void selectMultipleZone() throws Exception
	{
		try
		{
			int i;
			boolean flag=false;

			List<WebElement> menuLI = driver.findElements(
					By.xpath(".//*[@id='package-settings']/div/div[2]/div[@class='ng-scope']"));

			Logger.info("menuLI.size:"+menuLI.size());
			if(menuLI.size()>1)
				for(i=2; i<=menuLI.size(); i++){ Logger.info("i="+i);
				driver.findElement(
						By.xpath(".//*[@id='package-settings']/div/div[2]/div[@class='ng-scope']["+i+"]/label/i")).click();
				Logger.info("Zone "+i+" Selected");
				}// end of FOR
			else{
				Logger.info("Multiple Zone is not available");
				Assert.assertEquals("str", "str1");
			}		//end of else	
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectSingleZone() throws Exception
	{
		try
		{
			//  int i;
			//  boolean flag=false;
			WebElement fullruncheckbox =driver.findElement(
					By.xpath(".//*[@id='package-settings']/div/div[2]/div[4]/label/i"));
			Logger.info("Checkbox class :"+driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[2]/div[4]/label/input")).getAttribute("class"));
			if(driver.findElement(By.xpath(".//*[@id='package-settings']/div/div[2]/div[4]/label/input")).getAttribute("class").equalsIgnoreCase("ng-scope ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required")){				  				  
				Logger.info("Zone is already Selected");
			}// end of FOR
			else{
				fullruncheckbox.click();
				Logger.info("Zone is Selected");
			}		//end of else	
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void verifyClassifiedParametersDDStatus() throws Exception
	{
		try
		{
			Boolean flag= false;
			String BUDDStatus= ClassifiedBUDrpDwn.getAttribute("disabled");
			String SubcategoryDDStatus= ClassifiedSubcategoryDrpDwn.getAttribute("disabled");
			String ClassifiedProductDrpDwnStatus= ClassifiedProductDrpDwn.getAttribute("disabled");
			String ClassifiedPackageDrpDwnStatus= ClassifiedPackageDrpDwn.getAttribute("disabled");
			String ClassifiedClassCodeDrpDwnStatus= ClassifiedClassCodeDrpDwn.getAttribute("disabled");
			Logger.info("BUDDStatus:"+ BUDDStatus);
			Logger.info("SubcategoryDDStatus:"+ SubcategoryDDStatus);
			Logger.info("ClassifiedProductDrpDwnStatus:"+ ClassifiedProductDrpDwnStatus);
			Logger.info("ClassifiedPackageDrpDwnStatus:"+ ClassifiedPackageDrpDwnStatus);
			Logger.info("ClassifiedClassCodeDrpDwnStatus:"+ ClassifiedClassCodeDrpDwnStatus);

			if(BUDDStatus.equalsIgnoreCase("true"))
				if(SubcategoryDDStatus.equalsIgnoreCase("true"))
					if(ClassifiedProductDrpDwnStatus.equalsIgnoreCase("true"))
						if(ClassifiedPackageDrpDwnStatus.equalsIgnoreCase("true"))
							if(ClassifiedClassCodeDrpDwnStatus.equalsIgnoreCase("true")){
								Logger.info("All Dropdowns are in disabled mode");
								Assert.assertEquals("str", "str");
								flag=true;
							}
			if(flag==false){
				Logger.info("All Dropdowns are not in disabled mode");
				Assert.assertEquals("str1", "str");		    	  
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterLATAttributeDetails() throws Exception
	{
		try
		{
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				Thread.sleep(5000);
				Logger.info("AttributeTab is clicked");			

				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/input")).sendKeys("TEST TITLE");;						  						  
				Logger.info("Title Entered");
				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[2]/dynamic-field/div/div/textarea")).sendKeys("TEST AD");;						  						  
				Logger.info("AD Text Entered");

				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[9]/button")).click();
				Logger.info("SAVE button is clicked");
				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void uncheckLockOrderLinesChckBoxIfChecked() throws Exception {
		try {
			waitUntilElementVisible(LockOrderLinesChckBox);
			if(LockOrderLinesChckBox.isSelected()){
				clickLockOrderLinesChckBox();
			}
			Assert.assertFalse(LockOrderLinesChckBox.isSelected());
			Logger.info("Able to uncheck the Lock OrderLines checkbox if it is checked");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}



	public void verifyClassifiedFont(String text) throws Exception {
		/*WebElement webElement = driver.findElement(
				By.xpath("//b[contains(text(),'Allowed font(s):')]/.."));//mousumi
		String font = webElement.getText();
		Logger.info("Font equals to : " + font);
		Assert.assertEquals(text, font);
		Logger.info("Font is as expected");*/

		//List<WebElement> listOfValues = driver.findElements(By.xpath("//p[contains(@class,'text-muted')][./b[text()='Allowed font(s):']]"));
		List<WebElement> listOfValues = driver.findElements(By.xpath("(//p[contains(@class,'text-muted')])[4]"));
		//WebElement value = driver.findElement(By.xpath("//p[contains(@class,'text-muted')][./b[text()='Allowed font(s):']]"));
		String  lineUpdate= "";
		for(int i=0;i<listOfValues.size();i++){
			Logger.info("Values: "+listOfValues.get(i).getText());
			lineUpdate =lineUpdate+ listOfValues.get(i).getText();}
		//lineUpdate =value.getText();
		Logger.info("Line Update: "+lineUpdate);
		//Assert.assertEquals(text, lineUpdate);//swagata
	//	Logger.info("Line Update: "+lineUpdate);

	}// arka

	public void verifyclassifiedLegal(String text) throws Exception {
		WebElement webElement = driver.findElement(By.xpath("//span[@id='Span1']//span[contains(text(),'Legal')][1]"));//mou
		String typeLegal = webElement.getText();
		Logger.info("Price equals to : " + typeLegal);
		Assert.assertEquals(text, typeLegal);
		Logger.info("Legal status present");
	}// arka

	public boolean verifyCheckUncheckAffidavitRequired(boolean value) throws Exception {
		try {
			WebElement element = driver.findElement(By.xpath("//*[@id='order-info']/div/div[2]/dl/dd[4]/label/input"));
			JavascriptExecutor js = (JavascriptExecutor) driver;//mou
			js.executeScript("arguments[0].scrollIntoView();", element);//mou
			String checkCriteria = element.getAttribute("class");
			if (value) {
				if (checkCriteria.equalsIgnoreCase("ng-valid ng-dirty ng-valid-parse ng-touched ng-not-empty")) {
					Logger.info("Affidavit Required is not checked");
					return true;
				} else {

					Logger.info("Affidavit Required is  checked");
					return false;
				}
			}
			return true;

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}//arka

	public boolean verifyCheckUncheckTM1Zone(boolean value) throws Exception {
		try {
			WebElement element = driver.findElement(By.xpath("//*[@class='i-checks customer-label checkbox-option ng-binding']"));
			String checkCriteria = element.getAttribute("class");
			if (value) {
				if (checkCriteria.equalsIgnoreCase("i-checks customer-label checkbox-option ng-binding")) {
					Logger.info("Zone present");
					return true;
				} else {

					Logger.info("Zone not present");
					return false;
				}
			}
			return true;

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}//arka

	public void attributeDetailsTab() throws Exception {
		try {

			attributeTab.click();
			Logger.info("Attribute Tab Clicked");
			Thread.sleep(4000);
			attributeTabZipCode.click();
			Thread.sleep(4000);
			attributeTabZipCode.sendKeys("90001");
			Thread.sleep(4000);
			attributeTabSaveButton.click();
			Thread.sleep(4000);

		} catch (

				Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}// arka

	public void enterAttributeDetailsCTC() throws Exception
	{
		try
		{

			if (AttributeTab.isDisplayed())
			{

				WebDriverWait wait = new WebDriverWait(driver,200);		       
				wait.until(ExpectedConditions.elementToBeClickable(AttributeTab));
				AttributeTab.click();

				Logger.info("AttributeTab is clicked");
				wait.until(ExpectedConditions.elementToBeClickable(MakeAttribute));

				MakeAttribute.click();
				Actions action = new Actions(driver);
				action.moveToElement(makeDrpdwn).click().build().perform(); 
				Logger.info("Make drop down is clicked");  
				WebElement searchResult = makeDrpdwn;
				Thread.sleep(5000);
				Select select = new Select(searchResult);
				select.selectByVisibleText("Acura");
				Logger.info("make attribute is selected"); 


				ModelAttribute.click();
				Actions action2 = new Actions(driver);
				action2.moveToElement(ModelDrpdown).click().build().perform(); 
				Logger.info("Model drop down is clicked");  
				WebElement searchResult1 = ModelDrpdown;
				Thread.sleep(5000);
				Select select1 = new Select(searchResult1);
				select1.selectByVisibleText("100");
				Logger.info("Model attribute is selected"); 


				YearAttribute.click();
				Actions action1 = new Actions(driver);
				action1.moveToElement(YearDrpdown).click().build().perform(); 
				Logger.info("Year drop down is clicked");  
				WebElement searchResult2 = YearDrpdown;
				Thread.sleep(5000);
				Select select2 = new Select(searchResult2);
				select2.selectByVisibleText("1899");
				Logger.info("Year attribute is selected"); 
				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath("//*[@id='package-attributes']/div/div[5]/dynamic-field/div/div/textarea")));
				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[5]/dynamic-field/div/div/textarea")).sendKeys("Test-Ad-Text");						  						  
				Logger.info("Ad Text Entered");



				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath("//*[@id='package-attributes']/div/div[9]/dynamic-field/div/div/input")));
				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[9]/dynamic-field/div/div/input")).sendKeys("1800");						  						  
				Logger.info("Price Entered");
				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[14]/button")).click();
				Logger.info("SAVE button is clicked");
				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new 

	public void enterLegalAttributeTabDetails() throws Exception
	{
		try
		{
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				Thread.sleep(12000);
				Logger.info("AttributeTab is clicked");

				driver.findElement(By.xpath(".//*[@id='package-attributes']/div/div[6]/dynamic-field/div/div/input")).sendKeys("TEST");;						  						  
				Logger.info("Zip Entered");

				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[4]/dynamic-field/div/div/textarea")).sendKeys("TEST");;						  						  
				Logger.info("Adtext Entered");

				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@class='col-md-12 text-right']//button[text()='Save']")).click();
				Logger.info("SAVE button is clicked");
				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 

	}//mousumi
	public void enterAttributeDetailsRealEstate() throws Exception
	{
		try
		{

			if (AttributeTab.isDisplayed())
			{

				WebDriverWait wait = new WebDriverWait(driver,200);		       
				wait.until(ExpectedConditions.elementToBeClickable(AttributeTab));
				AttributeTab.click();

				Logger.info("AttributeTab is clicked");

				Thread.sleep(2000);
				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath("//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/input")));
				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[1]/dynamic-field/div/div/input")).sendKeys("Illinois");						  						  
				Logger.info("City Entered");
				Thread.sleep(2000);
				businessUnitDrpDwn.click();//update
				Select select = new Select(businessUnitDrpDwn);//update
				select.selectByVisibleText("Apartment");
				Logger.info("make attribute is selected"); 


				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath("//*[@id='package-attributes']/div/div[5]/dynamic-field/div/div/textarea")));
				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[5]/dynamic-field/div/div/textarea")).sendKeys("Test-Ad-Text");						  						  
				Logger.info("Ad Text Entered");
				attributeTabZipCode.click();
				Thread.sleep(4000);
				attributeTabZipCode.sendKeys("90001");
				Thread.sleep(4000);	   

				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[4]/dynamic-field/div/div/input")).sendKeys("Test Lane");						  						  
				Logger.info("Address Entered");
				wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath("//*[@id='package-attributes']/div/div[9]/dynamic-field/div/div/input")));
				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[9]/dynamic-field/div/div/input")).sendKeys("1800");						  						  
				Logger.info("Price Entered");
				driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[14]/button")).click();
				Logger.info("SAVE button is clicked");
				Thread.sleep(3000);

			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	public void enterAttributeDetailsObit() throws Exception
	{
		try
		{		

			if (AttributeTab.isDisplayed())
			{

				WebDriverWait wait = new WebDriverWait(driver,200);		       
				wait.until(ExpectedConditions.elementToBeClickable(AttributeTab));
				AttributeTab.click();

				Logger.info("AttributeTab is clicked");

				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOf(FirstNameAttribute));//swagata
				FirstNameAttribute.sendKeys("Auto");//swagata						  						  
				Logger.info("First Name Entered");

				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOf(LastNameAttribute));//swagata
				LastNameAttribute.sendKeys("Tester");	//swagata					  						  
				Logger.info("Last Name Entered");
				wait.until(ExpectedConditions.elementToBeClickable(ContactEmail));
				ContactEmail.sendKeys("r@r.com");						  						  
				Logger.info("Contact Email Entered");
				wait.until(ExpectedConditions.elementToBeClickable(cityTextField));
				cityTextField.sendKeys("Chicago");
				Logger.info("City name has Entered");

				wait.until(ExpectedConditions.elementToBeClickable(SaveAttributeBtn));
				//SaveAttributeBtn.click();
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", SaveAttributeBtn);
				Logger.info("SAVE button is clicked");
				Thread.sleep(3000);
				/*Thread.sleep(2000);

					Thread.sleep(4000);	   

					driver.findElement(By.xpath("//*[@id='package-attributes']/div/div[10]/button")).click();
					Logger.info("SAVE button is clicked");
					Thread.sleep(3000);*///swagata

			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new 
	public void enterDetailsInAdMaterialObit() throws Exception
	{
		List<WebElement> ele = driver.findElements(By.tagName("frame"));
		System.out.println("Number of frames in a page :" + ele.size());
		for(WebElement el : ele){

			Logger.info("Frame Id :" + el.getAttribute("id"));

			Logger.info("Frame name :" + el.getAttribute("name"));
		}

		try{
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			WebDriverWait wait = new WebDriverWait(driver,500);		       

			wait.until(ExpectedConditions.elementToBeClickable(FirstNameAdMaterial));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", FirstNameAdMaterial);
			//TribuneUtils utils = new TribuneUtils();
			//String FirstName =utils.generateRandomString(5);
			FirstNameAdMaterial.click();
			FirstNameAdMaterial.clear();
			FirstNameAdMaterial.sendKeys("Test");
			Logger.info("First name is given");
			LastNameAdMaterial.click();
			LastNameAdMaterial.clear();
			LastNameAdMaterial.sendKeys("Test");
			Logger.info("Last name is given");
			ObitTextAdMaterial.sendKeys("Test");
			Logger.info("Obit text is given");

			Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", SaveAndContinue);
			wait.until(ExpectedConditions.elementToBeClickable(SaveAndContinue));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", SaveAndContinue);
			//	SaveAndContinue.click();
			Thread.sleep(4000);
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.invisibilityOfElementLocated
					(By.xpath("//div[contains(text(),'Processing your material... Please wait.')]")));						  
			//driver.switchTo().defaultContent();

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new 
	public void enterAttributeDetailsObitTBS() throws Exception
	{
		try
		{
			/*WebDriverWait wait = new WebDriverWait(driver,200);
			wait.until(ExpectedConditions.elementToBeClickable(AttributeTab));
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				wait.until(ExpectedConditions.elementToBeClickable(ContactEmail));
				ContactEmail.sendKeys("r@r.com");						  						  
				Logger.info("Contact Email Entered");

				wait.until(ExpectedConditions.elementToBeClickable(SaveAttributeBtn));
				SaveAttributeBtn.click();
				Logger.info("SAVE button is clicked");
				Thread.sleep(3000);
			}*/
			//Partha
			AttributeTab.click();
			Thread.sleep(3000);
			//Partha
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ContactEmail);
			//ContactEmail.sendKeys("r@r.com");	
			//Partha
			ContactEmail.click();	
			
			Robot robot = new Robot();							 						  
			String text = "r@r.com";
			
			StringSelection stringSelection = new StringSelection(text);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, stringSelection);
			Logger.info("message copied");
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			Thread.sleep(2000);
			Logger.info("Contact Email Entered");
							  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new
	public void fillInTheMandatoryInputFldsInAdMaterialWindow(String... inputFldsInAdMaterialWindow) {
		try {
			String textToEnter = "test";
			WebElement inputFld;
			for(String inputFldInAdMaterialWindow: inputFldsInAdMaterialWindow){
				int counter = 0;
				boolean boolFound  =false;

				do{
					try{
						inputFld = driver.findElement(By.cssSelector("input[ng-reflect-placeholder='"+inputFldInAdMaterialWindow+"']"));
						boolFound = true;
					}
					catch(NoSuchElementException e){
						counter++;
					}
					if(boolFound == true){
						break;
					}
				}while(counter<60);
				counter = 0;
				inputFld = driver.findElement(By.cssSelector("input[ng-reflect-placeholder='"+inputFldInAdMaterialWindow+"']"));
				inputFld.click();
				inputFld.sendKeys(textToEnter);
				Assert.assertEquals(inputFld.getAttribute("value").trim(), textToEnter.trim());
			}
			Logger.info("Able to fill in all the mandatory input fields in the Ad Material window");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void fillInTheMandatoryTextAreaFldsInAdMaterialWindow(String... textAreaFldsInAdMaterialWindow) {
		try {
			String textToEnter = "test";
			WebElement inputFld;
			for(String textAreaFldInAdMaterialWindow: textAreaFldsInAdMaterialWindow){
				int counter = 0;
				boolean boolFound  =false;

				do{
					try{
						inputFld = driver.findElement(By.cssSelector("textarea[ng-reflect-placeholder='"+textAreaFldInAdMaterialWindow+"']"));
						boolFound = true;
					}
					catch(NoSuchElementException e){
						counter++;
					}
					if(boolFound == true){
						break;
					}
				}while(counter<60);
				counter = 0;
				inputFld = driver.findElement(By.cssSelector("textarea[ng-reflect-placeholder='"+textAreaFldInAdMaterialWindow+"']"));
				inputFld.click();
				inputFld.sendKeys(textToEnter);
				Assert.assertEquals(inputFld.getAttribute("value").trim(), textToEnter.trim());
				Logger.info("Able to fill in all the mandatory textarea fields in the Ad Material window");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnTheSaveAndContinueBtnInAdMaterialWindow() {
		try {
			//	WebElement saveAndContinueBtn = driver.findElement(By.xpath("//span[@class='mat-button-wrapper'][text()=\"Save & Continue Booking\"]"));//swagata

			WebDriverWait wait= new WebDriverWait(driver, 300);//swagata
			wait.until(ExpectedConditions.elementToBeClickable(SaveAttributeBtn));//swagata
			JavascriptExecutor executor = (JavascriptExecutor)driver;//swagata
			executor.executeScript("arguments[0].click();", SaveAttributeBtn);//swagata
			//saveAndContinueBtn.click();//swagata
			Logger.info("Able to click on the Save & Continue button in the Ad Material Window");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnTheAttributeTab() {
		try{
			AttributeTab.click();
			Logger.info("Able to click on the Attribute tab");
		}
		catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void enterMentionedTextInMentionedInputFld(String textToEnter, String inputFldInAttributeTab) {
		try {
			WebElement inputFldElementInAttributeTab = driver.findElement(By.xpath("//div[@id='packageInfo']//label[@class='name ng-binding'][text()=\""+inputFldInAttributeTab+"\"]/following-sibling::div[@class='input']/input"));
			WebDriverWait wait= new WebDriverWait(driver, 300);//swagata
			wait.until(ExpectedConditions.elementToBeClickable(inputFldElementInAttributeTab));//swagata
			inputFldElementInAttributeTab.click();
			inputFldElementInAttributeTab.sendKeys(textToEnter);
			Assert.assertEquals(inputFldElementInAttributeTab.getAttribute("value").trim(), textToEnter);
			Logger.info("Able to enter the mentioned text " + textToEnter + " in the mentioned input field " + inputFldInAttributeTab);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterMentionedTextInMentionedTextAreaFld(String textToEnter, String textAreaFldInAttributeTab) throws Exception {
		try {
			WebElement textAreaFldElementInAttributeTab = driver.findElement(By.xpath("//div[@id='packageInfo']//label[@class='name ng-binding'][text()=\""+textAreaFldInAttributeTab+"\"]/following-sibling::div[@class='input']/textarea"));
			try{
				textAreaFldElementInAttributeTab.click();
			}
			catch(StaleElementReferenceException e){
				Thread.sleep(5000);
				textAreaFldElementInAttributeTab.click();
			}
			textAreaFldElementInAttributeTab.sendKeys(textToEnter);
			Assert.assertEquals(textAreaFldElementInAttributeTab.getAttribute("value").trim(), textToEnter);
			Logger.info("Able to enter the mentioned text " + textToEnter + " in the mentioned input field " + textAreaFldInAttributeTab);
			// contact name
			driver.findElement(By.xpath("//div[@id='package-attributes']//label[text()='Contact Name']/following-sibling::div//input[@type='text']")).sendKeys("test");//swagata
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void enterAttributeDetailsObitDPR() throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,200);
			wait.until(ExpectedConditions.elementToBeClickable(AttributeTab));
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				Thread.sleep(3000);
				//Partha
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", cityTextField);
				//ContactEmail.sendKeys("r@r.com");	
				//Partha
				ContactEmail.click();	
				
				Robot robot = new Robot();							 						  
				String text = "r@r.com";
				
				StringSelection stringSelection = new StringSelection(text);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, stringSelection);
				Logger.info("message copied");
				Thread.sleep(3000);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				
				Thread.sleep(2000);
				Logger.info("Contact Email Entered");
				//wait.until(ExpectedConditions.elementToBeClickable(ContactEmail));
				//Thread.sleep(4000);
				
				wait.until(ExpectedConditions.elementToBeClickable(cityTextField));
				cityTextField.sendKeys("Chicago");
				Logger.info("City name has Entered");
				Actions action = new Actions(driver);
				action.moveToElement(StateDropdown).click().build().perform();
				WebElement element=driver.findElement(By.xpath("(//label[text()='State']//following-sibling::div//form//select)[1]"));
				Select valueFromdropdwn = new Select(element);
				valueFromdropdwn.selectByVisibleText("AK");
				Logger.info("State is selected");
				//Partha for town name dropdown only in QA
				/*action.moveToElement(TownnameDropdown).click().build().perform();
				Thread.sleep(2000);
				element=driver.findElement(By.xpath("(//label[text()='Town Name for Obit Index VMG']//following-sibling::div//form//select)[1]"));
				valueFromdropdwn = new Select(element);
				valueFromdropdwn.selectByVisibleText("Chesapeake");
				Logger.info("Town name is selected");*/
			
				/*List<WebElement> listOfValues = valueFromdropdwn.getOptions();
				if(listOfValues.size() !=0)
				{
					Logger.info("size:"+listOfValues.size());
					valueFromdropdwn.selectByVisibleText("AK");
					Logger.info("State is selected"); 
				}
				else{
					Logger.info("State dropdown is not displayed");
				}*/
				wait.until(ExpectedConditions.elementToBeClickable(SaveAttributeBtn));
				//SaveAttributeBtn.click();
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", SaveAttributeBtn);
				Logger.info("SAVE button is clicked");
				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new
	public void enterDetailsInAdMaterialObitHTF() throws Exception
	{
		List<WebElement> ele = driver.findElements(By.tagName("frame"));
		System.out.println("Number of frames in a page :" + ele.size());
		for(WebElement el : ele){

			Logger.info("Frame Id :" + el.getAttribute("id"));

			Logger.info("Frame name :" + el.getAttribute("name"));
		}

		try{
			WebDriverWait wait = new WebDriverWait(driver,500);		       

			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			Actions action = new Actions(driver);
			//WebElement element=driver.findElement(By.xpath("(//div[@class='ngucarousel']/div[@class='ngucarousel-items']//ngu-tile//img)[4]"));
			//List<WebElement> element = driver.findElements(imgCarousa);
			for(int i=0;i<imgCarousal.size();i++){
				action.moveToElement(imgCarousal.get(i)).build().perform();
				if(i==(imgCarousal.size()-3)){
					/*JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", element.get(i));*/
					action.moveToElement(imgCarousal.get(i)).click().build().perform();

					//element.get(i).click();
				}
			}


			wait.until(ExpectedConditions.elementToBeClickable(FirstNameAdMaterial));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", FirstNameAdMaterial);
			Thread.sleep(3000);
			//TribuneUtils utils = new TribuneUtils();
			//String FirstName =utils.generateRandomString(5);
			FirstNameAdMaterial.sendKeys("Test");
			Logger.info("First name is given");
			LastNameAdMaterial.sendKeys("Test");
			Logger.info("Last name is given");
			ObitTextAdMaterial.sendKeys("Test");
			Logger.info("Obit text is given");
			//Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", SaveAndContinue);
			wait.until(ExpectedConditions.elementToBeClickable(SaveAndContinue));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", SaveAndContinue);
			//	SaveAndContinue.click();
			Thread.sleep(4000);
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.invisibilityOfElementLocated
					(By.xpath("//div[contains(text(),'Processing your material... Please wait.')]")));						  
			//  use this order#6529881
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata 
	public void adsizeDropdown(String insertionIndex,int row, int col) throws Exception
	{
		try{
			String value = TribuneUtils.getStringCellValues("ClassifiedOrder",row, col);

			if (Adsize.isDisplayed())
			{	WebDriverWait wait = new WebDriverWait(driver,200);		       

			wait.until(ExpectedConditions.elementToBeClickable(Adsize));					  
			Adsize.click();
			Select valueFromBU = new Select(Adsize);
			List<WebElement> listOfValues = valueFromBU.getOptions();
			if(listOfValues.size() !=0)
			{
				Logger.info("size:"+listOfValues.size());

				valueFromBU.selectByVisibleText(value);
				Logger.info(value+ " Size is selected"); 
			}
			else
			{
				Logger.info("drop down is empty");
			}
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new	
	public void enterAttributeDetailsObitHTF() throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,200);
			wait.until(ExpectedConditions.elementToBeClickable(AttributeTab));
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				Actions action = new Actions(driver);
				wait.until(ExpectedConditions.elementToBeClickable(Town1Dropdown));
				action.moveToElement(Town1Dropdown).click().build().perform();
				WebElement element=driver.findElement(By.xpath("//div[@id='package-attributes']//label[text()='Town 1']//following-sibling::div//select"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
				Select valueFromdropdwn = new Select(element);
				List<WebElement> listOfValues = valueFromdropdwn.getOptions();
				if(listOfValues.size() !=0)
				{
					Logger.info("size:"+listOfValues.size());
					valueFromdropdwn.selectByVisibleText("ASHFORD");
					Logger.info("Town 1 is selected"); 
				}
				else{
					Logger.info("Town 1 dropdown is not displayed");
				}
				wait.until(ExpectedConditions.elementToBeClickable(SaveAttributeBtn));
				SaveAttributeBtn.click();
				/*JavascriptExecutor executor = (JavascriptExecutor)driver;
						executor.executeScript("arguments[0].click();", SaveAttributeBtn);*/
				Logger.info("SAVE button is clicked");
				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new
	public void enterAttributeDetailsObitCTC() throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,200);
			wait.until(ExpectedConditions.elementToBeClickable(AttributeTab));
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				/*wait.until(ExpectedConditions.elementToBeClickable(ContactEmail));
				ContactEmail.sendKeys("r@r.com");						  						  
				Logger.info("Contact Email Entered");*/
				Thread.sleep(3000);
				//Partha
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ContactEmail);
				//ContactEmail.sendKeys("r@r.com");	
				//Partha
				ContactEmail.click();	
				
				Robot robot = new Robot();							 						  
				String text = "r@r.com";
				
				StringSelection stringSelection = new StringSelection(text);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, stringSelection);
				Logger.info("message copied");
				Thread.sleep(3000);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				
				Thread.sleep(2000);
				Logger.info("Contact Email Entered");
				wait.until(ExpectedConditions.elementToBeClickable(cityTextField));
				cityTextField.sendKeys("Chicago");
				Logger.info("City name has Entered");

				wait.until(ExpectedConditions.elementToBeClickable(SaveAttributeBtn));
				//SaveAttributeBtn.click();
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", SaveAttributeBtn);
				Logger.info("SAVE button is clicked");
				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new
	public void enterAttributeDetailsObitSSC() throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,200);
			wait.until(ExpectedConditions.elementToBeClickable(AttributeTab));
			if (AttributeTab.isDisplayed())
			{
				AttributeTab.click();
				wait.until(ExpectedConditions.elementToBeClickable(ContactEmail));
				/*ContactEmail.sendKeys("r@r.com");						  						  
				Logger.info("Contact Email Entered");*/
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ContactEmail);
				//ContactEmail.sendKeys("r@r.com");	
				//Partha
				ContactEmail.click();	
				
				Robot robot = new Robot();							 						  
				String text = "r@r.com";
				
				StringSelection stringSelection = new StringSelection(text);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, stringSelection);
				Logger.info("message copied");
				Thread.sleep(3000);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				
				Thread.sleep(2000);
				Logger.info("Contact Email Entered");
				wait.until(ExpectedConditions.elementToBeClickable(ContactName));
				ContactName.sendKeys("test");
				Logger.info("Contact name has Entered");
				wait.until(ExpectedConditions.elementToBeClickable(SaveAttributeBtn));
				SaveAttributeBtn.click();
				/*JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", SaveAttributeBtn);*/
				Logger.info("SAVE button is clicked");
				Thread.sleep(3000);
			}
			else
			{
				Logger.info("AttributeTab is not displayed");
				throw new NoSuchElementException("AttributeTab is not displayed");
			}					  					  					
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new
	
	//Joy
	public void closebuttonAdWindow() throws Exception
	{
		//driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		WebElement CloseButton1 = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[3]/button"));
		Thread.sleep(4000);
		if (CloseButton1.isDisplayed())
		{
			CloseButton1.click();
			Logger.info("Close button is displayed");
		}
		else
		{
			Logger.info("CloseButton is not displayed");
		}
		
	}

	public void closeEditAdWindow() {
		
		
		try
		{
			List<WebElement> ele = driver.findElements(By.tagName("iframe"));
			System.out.println("Number of frames in a page :" + ele.size());
			for(WebElement el : ele){

				Logger.info("Frame Id :" + el.getAttribute("id"));

				Logger.info("Frame name :" + el.getAttribute("name"));		       

				driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
				WebDriverWait wait = new WebDriverWait(driver,200);
				wait.until(ExpectedConditions.elementToBeClickable(CloseButton));
				if (CloseButton.isDisplayed())
				{
					CloseButton.click();
					Logger.info("Close button is displayed");
				}
				else
				{
					Logger.info("CloseButton is not displayed");
				}					  					  					
			}
			}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata*/
	//Partha
public double getonlineInsertionPriceINRecruitmentOrder() {
		
		
		try
		{
			String insertionCheckboxXpath="//div[@class='insertionInfo table-responsive']/table[contains(@class,'table table-bordered')]/tbody[*]/tr[1]/td[1]/div[1]/label[1]/i[1]";
			List<WebElement> ele = driver.findElements(By.xpath(insertionCheckboxXpath));
			System.out.println("Number of frames in a page :" + ele.size());
			boolean online_found=false;
			String Online_price = null;
			for(int i=1;i<=ele.size();i++){
				
				String line_type_xpath="//div[@class='insertionInfo table-responsive']/table[contains(@class,'table table-bordered')]/tbody["+i+"]/tr[1]/td[6]/div[1]/span[1]";
				String line_type=driver.findElement(By.xpath(line_type_xpath)).getText();
				if (line_type.equalsIgnoreCase("online"))
				{
					String online_price_xpath="//div[@class='insertionInfo table-responsive']/table[contains(@class,'table table-bordered')]/tbody["+i+"]/tr[1]/td[12]/span[1]";
				
				Online_price=driver.findElement(By.xpath(online_price_xpath)).getText();
				Logger.info("onlie found in insertion no:"+i);
				Logger.info("oprice value is:"+Online_price);
				online_found=true;
				break;
				}				       				  					  					
			}
			if (online_found)
			{
				Online_price=Online_price.replace("$", "");
				double price=Double.parseDouble(Online_price);
				return price;
			}
			else
				return 0;
			}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
public double getonlineInsertionPriceINRecruitmentOrderAfterUnlockorderline() {
	
	
	try
	{
		String insertionCheckboxXpath="//table[contains(@class,'table table-bordered')]/tbody[*]/tr[1]/td[1]/div[1]/label[1]/i[1]";
		List<WebElement> ele = driver.findElements(By.xpath(insertionCheckboxXpath));
		System.out.println("Number of frames in a page :" + ele.size());
		boolean online_found=false;
		String Online_price = null;
		for(int i=1;i<=ele.size();i++){
			
			String line_type_xpath="//div[@class='insertionInfo table-responsive']/table[contains(@class,'table table-bordered')]/tbody["+i+"]/tr[1]/td[6]/div[1]/a[1]/span[1]/span[1]";
			String line_type=driver.findElement(By.xpath(line_type_xpath)).getText();
			if (line_type.equalsIgnoreCase("online"))
			{
				String online_price_xpath="//div[@class='insertionInfo table-responsive']/table[contains(@class,'table table-bordered')]/tbody["+i+"]/tr[1]/td[12]/span[1]";
			
			Online_price=driver.findElement(By.xpath(online_price_xpath)).getText();
			Logger.info("onlie found in insertion no:"+i);
			Logger.info("oprice value is:"+Online_price);
			online_found=true;
			break;
			}				       				  					  					
		}
		if (online_found)
		{
			Online_price=Online_price.replace("$", "");
			double price=Double.parseDouble(Online_price);
			return price;
		}
		else
			return 0;
		}
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
}
public int getonlineInsertionLineNoINRecruitmentOrder() {
	
	
	try
	{
		String insertionCheckboxXpath="//div[@class='insertionInfo table-responsive']/table[contains(@class,'table table-bordered')]/tbody[*]/tr[1]/td[1]/div[1]/label[1]/i[1]";
		List<WebElement> ele = driver.findElements(By.xpath(insertionCheckboxXpath));
		System.out.println("Number of frames in a page :" + ele.size());
		boolean online_found=false;
		int line_no = 0;
		
		for(int i=1;i<=ele.size();i++){
			
			String line_type_xpath="//div[@class='insertionInfo table-responsive']/table[contains(@class,'table table-bordered')]/tbody["+i+"]/tr[1]/td[6]/div[1]/span[1]";
			String line_type=driver.findElement(By.xpath(line_type_xpath)).getText();
			if (line_type.equalsIgnoreCase("online"))
			{
				String online_price_xpath="//div[@class='insertionInfo table-responsive']/table[contains(@class,'table table-bordered')]/tbody["+i+"]/tr[1]/td[12]/span[1]";
			
			
			online_found=true;
			line_no=i;
			Logger.info("online found in insertion no:"+line_no);
			break;
			}				       				  					  					
		}
		if (online_found)
		{
			
			return line_no;
		}
		else
			return 0;
		}
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
}
public void SelectAddonChargeAttrinute() throws Exception
{
	try
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AttributeTab);
		if (AttributeTab.isDisplayed())
		{
			AttributeTab.click();
			Thread.sleep(2000);
			Logger.info("AttributeTab is clicked");

			driver.findElement(By.xpath("//label[contains(text(),'Account Finance')]//following-sibling::i[1]")).click();						  						  
			Logger.info("Account Finance charge added");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//label[contains(text(),'Construction')]//following-sibling::i[1]")).click();						  						  
			Logger.info("JConstruction add on charge added");
			Thread.sleep(2000);
			
			WebElement savebtn=driver.findElement(By.xpath("//*[@id='package-attributes']//button[contains(text(),'Save')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", savebtn);
			Thread.sleep(2000);
			savebtn.click();
			Logger.info("SAVE button is clicked");
			Thread.sleep(3000);
		}
		else
		{
			Logger.info("AttributeTab is not displayed");
			throw new NoSuchElementException("AttributeTab is not displayed");
		}					  					  					
	}
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
}

public void ClickOnAddonchargesMagnifier(int insertionlineNoForOnline) throws Exception
{
	try
	{
		String magnifierxpathfortheInsertionLinexpath="//tbody["+insertionlineNoForOnline+"]//div[@class='pointer']/i//following::span[@class='input-group-addon pointer']/i";
		//Logger.info("magnifierxpathfortheInsertionLinexpath:"+magnifierxpathfortheInsertionLinexpath);
		WebElement magnifierxpathfortheInsertionLine=driver.findElement(By.xpath(magnifierxpathfortheInsertionLinexpath));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", magnifierxpathfortheInsertionLine);
			//js.executeScript("arguments[0].scrollIntoView();", magnifierxpathfortheInsertionLine);
			Thread.sleep(3000);
		
				Logger.info("Add On Magnifier Clicked");

			
		}

						  					  					
	
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
}

public void ClickCancelOnAddonChargeModifier() throws Exception
{
	try
	{
		if(CancelButtonAddonCharge.isDisplayed())
		{
			
			CancelButtonAddonCharge.click();
				Logger.info("cancel button Clicked");

			}else{
				Logger.info("cancel button is not displayed");

			}
		}

						  					  					
	
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
}
public void ClickConfirmOnAddonChargeModifier() throws Exception
{
	try
	{
		if(ConfirmButtonAddonCharge.isDisplayed())
		{
			
			ConfirmButtonAddonCharge.click();
				Logger.info("Confirm button Clicked");

			}else{
				Logger.info("Confirm button is not displayed");

			}
		}

						  					  					
	
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
}
public boolean VerifyRemoveButtonAdOnChargeAttributeSelectedinfees(String AddonChargetype) throws Exception
{
	try
	{
		String addOnChargetypeXpath="//html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[*]/td[1]/b[1]";
		List<WebElement> ele = driver.findElements(By.xpath(addOnChargetypeXpath));
		System.out.println("Number of add on fees in a page :" + ele.size());
		boolean addonChargeselected=false;
		int line_no = 0;
		String buttonValue = null;
		
		for(int i=1;i<=ele.size();i++){
			
			String Add_onChargeTypexpath="//html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[1]/b[1]";
			String add_onCharge=driver.findElement(By.xpath(Add_onChargeTypexpath)).getText();
			if (add_onCharge.equalsIgnoreCase(AddonChargetype))
			{
				String add_remove_button_valuexpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[5]/button[1]";
				buttonValue=driver.findElement(By.xpath(add_remove_button_valuexpath)).getText();
				break;
			}
			
					       				  					  					
		}
		if(buttonValue.contains("Remove")) {
			Logger.info("remove button is showing for add on charge type;"+AddonChargetype);
			return true;
		}		
		else
			return false;
		}
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
}
public void AddChargefromFeesInInsertionLine(String AddonChargetype) throws Exception
{
	try
	{
		String addOnChargetypeXpath="//html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[*]/td[1]/b[1]";
		List<WebElement> ele = driver.findElements(By.xpath(addOnChargetypeXpath));
		System.out.println("Number of add on fees in a page :" + ele.size());
		boolean addonChargeselected=false;
		int line_no = 0;
		String buttonValue = null;
		
		for(int i=1;i<=ele.size();i++){
			
			String Add_onChargeTypexpath="//html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[1]/b[1]";
			String add_onCharge=driver.findElement(By.xpath(Add_onChargeTypexpath)).getText();
			if (add_onCharge.equalsIgnoreCase(AddonChargetype))
			{
				String add_remove_button_valuexpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[5]/button[1]";
				driver.findElement(By.xpath(add_remove_button_valuexpath)).click();
				Thread.sleep(2000);
				addonChargeselected=true;
				break;
			}
			
					       				  					  					
		}
		if(addonChargeselected) {
			Logger.info("add button clicked for "+AddonChargetype);
			
		}		
		else {
			Logger.info("add button not clicked for "+AddonChargetype);
			
		}
			
		}
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
}
public double getAddONChargevalueFromFeesForparticularAddOntype(String AddonChargetype) throws Exception
{
	try
	{
		String addOnChargetypeXpath="//html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[*]/td[1]/b[1]";
		List<WebElement> ele = driver.findElements(By.xpath(addOnChargetypeXpath));
		System.out.println("Number of add on fees in a page :" + ele.size());
		boolean addonChargeselected=false;
		String charge = null;
		int line_no = 0;
		String buttonValue = null;
		
		for(int i=1;i<=ele.size();i++){
			
			String Add_onChargeTypexpath="//html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[1]/b[1]";
			String add_onCharge=driver.findElement(By.xpath(Add_onChargeTypexpath)).getText();
			if (add_onCharge.equalsIgnoreCase(AddonChargetype))
			{
				String AddOnChargeValue_xapth="//tbody[1]/tr["+i+"]/td[2]/a[1]/span[1]/span[1]";
				charge=driver.findElement(By.xpath(AddOnChargeValue_xapth)).getText();
				Thread.sleep(2000);
				addonChargeselected=true;
				break;
			}
			
					       				  					  					
		}
		if(addonChargeselected) {
			charge = charge.replace("$", "");
			Double price=Double.parseDouble(charge);
			Logger.info("charge for "+AddonChargetype+" is "+price);
			return price;
		}		
		else {
			Logger.info("charge not found for the provided add on type");
			return 0;
		}
			
		}
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
}
public void unlockOrderLines() throws Exception
{
	try
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", LockOrderLines);
		if(LockOrderLines.isDisplayed())
		{
			
			LockOrderLines.click();
			Thread.sleep(3000);
				Logger.info("Lock OrderLines checkbox unchecked");

			}else{
				Logger.info("Lock OrderLines checkbox is not displayed");

			}
		}

						  					  					
	
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
}

}
