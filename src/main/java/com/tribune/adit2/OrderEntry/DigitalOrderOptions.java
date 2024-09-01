package com.tribune.adit2.OrderEntry;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;
import com.tribune.adit2.OrderEntry.NewOrderPage;

public class DigitalOrderOptions {

	@FindBy(xpath = ".//*[@id='digital.bu.id']")
	public WebElement DigitalBUDrpDwn;
	
	@FindBy(xpath = ".//*[@id='selectcard']")
	public WebElement PaymentTypeDrpDwn;
	
	@FindBy(xpath = ".//*[@id='accounts']")
	public WebElement AccountTypeDrpDwn;	
	
	@FindBy(xpath = ".//*[@id='amount']")
	public WebElement ValueTxtFld;
	
	@FindBy(xpath = "//button[text()='Pay']")
	public WebElement PayBtn;
	
	@FindBy(xpath = ".//*[@id='checknumber']")
	public WebElement CheckNoField;
	
	@FindBy(xpath = ".//*[@id='Text1']")
	public WebElement CashReceiptNoField;
	
	@FindBy(xpath = ".//button[text()='Make a Payment']")
	public WebElement MakePaymntBtn;
	
	@FindBy(xpath = ".//*[@id='digital.product.id']")
	public WebElement DigitalProductDrpDwn;
	
	@FindBy(xpath = ".//*[@id='digital.charge.day']")
	public WebElement ChargeDayDrpDwn;
	
	@FindBy(xpath = ".//button[text()='Apply']")
	public WebElement ApplyBtn;

	@FindBy(xpath = "//button[text()='Upload Document']")
	public WebElement UploadDocBtn;
	
	@FindBy(xpath = "//span[text()='Documents']")
	public WebElement DocumentsTab;
	
	@FindBy (id = "Text4")	
	 public WebElement monthlyPrice;
	
	@FindBy (id = "achAccountNumber")	
	 public WebElement accountACH;
	
	@FindBy (id = "achRoutingNumber")
	 public WebElement routingACH;
	 
	 @FindBy (id = "achAccountType")
	 public WebElement accountTypeACH;
	 
	 @FindBy (id = "firstName")
	 public WebElement firstNameACH;
	 
	 @FindBy (id = "lastName")
	 public WebElement lastNameACH;
	 
	 @FindBy (id = "street")
	 public WebElement addressACH;
	 
	 @FindBy (id = "city")
	 public WebElement cityACH;
	 
	 @FindBy (id = "state")
	 public WebElement stateACH;
	 
	 @FindBy (id = "zipCode")
	 public WebElement zipACH;
	 
	 @FindBy (id = "country")
	 public WebElement countryACH;
	 
	 @FindBy (id = "email")
	 public WebElement emailACH;
	 
	 @FindBy (id = "phone")
	 public WebElement phoneACH;
	
private WebDriver driver;
	
	Properties properties = TribuneUtils.readProperties();
	NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
	
	public DigitalOrderOptions(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Code to select package business Unit
		// Designed by rmukhopadhyay
			public void selectPackageBU(String insertionIndex,int row, int col) throws Exception
			  {
				  try
				  {
					  String value = TribuneUtils.getStringCellValues("DigitalOrder",row, col);
					  //String value="DPR";
					  Logger.info("BU="+value);
					  switch(value)
					  {
					  case "LAT": 
						  if (DigitalBUDrpDwn.isDisplayed())
						  {
							  Thread.sleep(2000);
							  DigitalBUDrpDwn.click();
							  Select valueFromBU = new Select(DigitalBUDrpDwn);
						      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
						      if(listOfValuesBU.size() !=0)
							      {
							    	 //valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						    	  valueFromBU.selectByIndex(0);
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
						  if (DigitalBUDrpDwn.isDisplayed())
						  {	Thread.sleep(2000);
							  DigitalBUDrpDwn.click();
							  Select valueFromBU = new Select(DigitalBUDrpDwn);
						      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
						      if(listOfValuesBU.size() !=0)
							      {
							    	 //valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						    	  valueFromBU.selectByIndex(1);
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
						  if (DigitalBUDrpDwn.isDisplayed())
						  {
							  DigitalBUDrpDwn.click();
							  Select valueFromBU = new Select(DigitalBUDrpDwn);
						      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
						      if(listOfValuesBU.size() !=0)
							      {
							    	 //valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						    	  valueFromBU.selectByIndex(2);
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
						  if (DigitalBUDrpDwn.isDisplayed())
						  {Logger.info("CTC"); 
							  DigitalBUDrpDwn.click();
							  Select valueFromBU = new Select(DigitalBUDrpDwn);
						      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
						      if(listOfValuesBU.size() !=0)
							      {
							    	 //valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						    	  valueFromBU.selectByIndex(3);
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
						  if (DigitalBUDrpDwn.isDisplayed())
						  {
							  DigitalBUDrpDwn.click();
							  Select valueFromBU = new Select(DigitalBUDrpDwn);
						      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
						      if(listOfValuesBU.size() !=0)
							      {
							    	 //valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						    	  valueFromBU.selectByIndex(4);
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
						  if (DigitalBUDrpDwn.isDisplayed())
						  {
							  DigitalBUDrpDwn.click();
							  Select valueFromBU = new Select(DigitalBUDrpDwn);
						      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
						      if(listOfValuesBU.size() !=0)
							      {
							    	 //valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						    	  valueFromBU.selectByIndex(5);
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
						  if (DigitalBUDrpDwn.isDisplayed())
						  {
							  DigitalBUDrpDwn.click();
							  Select valueFromBU = new Select(DigitalBUDrpDwn);
						      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
						      if(listOfValuesBU.size() !=0)
							      {
							    	 //valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						    	  valueFromBU.selectByIndex(6);
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
						  if (DigitalBUDrpDwn.isDisplayed())
						  {
							  DigitalBUDrpDwn.click();
							  Select valueFromBU = new Select(DigitalBUDrpDwn);
						      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
						      if(listOfValuesBU.size() !=0)
							      {
							    	 //valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						    	  valueFromBU.selectByIndex(7);
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
						  if (DigitalBUDrpDwn.isDisplayed())
						  {
							  DigitalBUDrpDwn.click();
							  Select valueFromBU = new Select(DigitalBUDrpDwn);
						      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
						      if(listOfValuesBU.size() !=0)
							      {
							    	 //valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						    	  valueFromBU.selectByIndex(8);
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
						  if (DigitalBUDrpDwn.isDisplayed())
						  {
							  DigitalBUDrpDwn.click();
							  Select valueFromBU = new Select(DigitalBUDrpDwn);
						      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
						      if(listOfValuesBU.size() !=0)
							      {
							    	 //valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						    	  valueFromBU.selectByIndex(9);
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
						  if (DigitalBUDrpDwn.isDisplayed())
						  {
							  DigitalBUDrpDwn.click();
							  Select valueFromBU = new Select(DigitalBUDrpDwn);
						      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
						      if(listOfValuesBU.size() !=0)
							      {
							    	 //valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						    	  valueFromBU.selectByIndex(10);
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
						  if (DigitalBUDrpDwn.isDisplayed())
						  {
							  DigitalBUDrpDwn.click();
							  Select valueFromBU = new Select(DigitalBUDrpDwn);
						      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
						      if(listOfValuesBU.size() !=0)
							      {
							    	 //valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						    	  valueFromBU.selectByIndex(11);
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
						  if (DigitalBUDrpDwn.isDisplayed())
						  {
							  DigitalBUDrpDwn.click();
							  Select valueFromBU = new Select(DigitalBUDrpDwn);
						      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
						      if(listOfValuesBU.size() !=0)
							      {
							    	 //valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
						    	  valueFromBU.selectByIndex(12);
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
			
	//Code to select package Product
	// Designed by rmukhopadhyay
		public void selectDigitalProductDrpDwn(String insertionIndex,int row, int col) throws Exception
		  {
			  try
			  {
				String value = TribuneUtils.getStringCellValues("DigitalOrder",row, col);
				  //String value="classified.chicagotribune.com [Online]";
				  //String value="Chicago Tribune  [Classified Listings]";
				  //String value="Daily Press [Classified Listings]";
				Logger.info(value+ "Product product is selected");
				  if (DigitalProductDrpDwn.isDisplayed())
				  {
					  DigitalProductDrpDwn.click();
					  Select valueFromBU = new Select(DigitalProductDrpDwn);
				      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				      if(listOfValuesBU.size() !=0)
					      {
					    	 //valueFromBU.selectByVisibleText(properties.getProperty(product).toString());
				    	  valueFromBU.selectByVisibleText(value);
				    	  //valueFromBU.selectByIndex(1);
					         Logger.info(value+ "Digital product is selected"); 
					      }
				      else
				      {
				    	  Logger.info("drop down is empty");
				      }
				  }
				  else
				  {
					  Logger.info("Digital product drop down is not displayed");
					  throw new NoSuchElementException("Digital product drop down is not displayed");
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
			public void selectDigitalChargeDayDrpDwn(int index) throws Exception
			  {
				  try
				  {
					//String value = TribuneUtils.getStringCellValues("DigitalOrder",row, col);
					//Logger.info(value+ "ChargeDay is selected");
					  if (ChargeDayDrpDwn.isDisplayed())
					  {
						  ChargeDayDrpDwn.click();
						  Select valueFromBU = new Select(ChargeDayDrpDwn);
					      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
					      if(listOfValuesBU.size() !=0)
						      {
						    	 //valueFromBU.selectByVisibleText(properties.getProperty(product).toString());
					    	  //valueFromBU.selectByVisibleText(value);
					    	  valueFromBU.selectByIndex(index);
						         //Logger.info(value+ "Digital charge day is selected"); 
					    	  Logger.info("Digital charge day is selected");
						      }
					      else
					      {
					    	  Logger.info("drop down is empty");
					      }
					  }
					  else
					  {
						  Logger.info("Digital charge day drop down is not displayed");
						  throw new NoSuchElementException("Digital charge day drop down is not displayed");
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
		public void clickApplyBtn() throws Exception
		  {
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
			public void clickMakePaymntBtn() throws Exception
			  {
				  try
				  {
					  if (MakePaymntBtn.isDisplayed())
					  {
						  MakePaymntBtn.click();
						  Logger.info("Make payment Button is clicked");
					  }
					  else
					  {
						  Logger.info("Make payment Button is not displayed");
						  throw new NoSuchElementException("Make payment Button is not displayed");
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
			public void verifyDocUpload() throws Exception
			  {
				  try
				  {
					  if (DocumentsTab.isDisplayed())
					  {
						  DocumentsTab.click();
						  Logger.info("Documents Tab is clicked");
						  int count=(driver.findElements(By.xpath(".//*[@id='order-documents']/div[2]/table/tbody/tr"))).size();
						  
						  if(count==2){
							  Logger.info("Document is uploaded");
							  Assert.assertEquals("str", "str");
						  }else{
							  Logger.info("Document is not uploaded");
							  Assert.assertEquals("str", "str1");
						  }							
					  }
					  else
					  {
						  Logger.info("Documents Tab is not displayed");
						  throw new NoSuchElementException("Documents Tab is not displayed");
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
		public void verifyOrderStatus(String orderid, String orderstatus) throws Exception
		  {
			  try
			  {
			       WebDriverWait wait = new WebDriverWait(driver,200);		       
			       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+orderstatus+" ']")));
				  String currentorderstatus=driver.findElement(By.xpath("//span[text()='Order: "+orderid+" ']/span")).getText();
				  if (currentorderstatus.equals(orderstatus))
				  {
					  Logger.info("Order status has matched");
				  }
				  else
				  {
					  Logger.info("Order status doesnot match");
					  throw new NoSuchElementException("Order status doesnot match");
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
			public void uploadDoc(String insertionIndex,int row, int col) throws Exception
			  {
				  try
				  {
					  String filename = TribuneUtils.getStringCellValues("DigitalOrder",row, col);
					  Logger.info("filename:"+filename);
					  String pathForImage = System.getProperty("user.dir")+ "\\ClassfiedFile\\"+filename;
					  
					  if (DocumentsTab.isDisplayed())
					  {
						  DocumentsTab.click();
						  Logger.info("Documents Tab is clicked");
					  }else{
						  Logger.info("Document tab is not available");
						  throw new NoSuchElementException("Document is not uploaded");
					  }
					  if (UploadDocBtn.isDisplayed())
					  {
						  UploadDocBtn.click();
						  Robot robot = new Robot();							 						  
						  //String text = System.getProperty("user.dir")+ "\\ClassfiedFile\\"+filename;
						  Logger.info(pathForImage);
						  StringSelection stringSelection = new StringSelection(pathForImage);
						  Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
						  clipboard.setContents(stringSelection, stringSelection);
						  
						  Thread.sleep(3000);
						  robot.keyPress(KeyEvent.VK_CONTROL);
						  robot.keyPress(KeyEvent.VK_V);
						  robot.keyRelease(KeyEvent.VK_V);
						  robot.keyRelease(KeyEvent.VK_CONTROL);
						  robot.keyPress(KeyEvent.VK_ENTER);
						  robot.keyRelease(KeyEvent.VK_ENTER);
						  Thread.sleep(3000);
						  Logger.info("Document is uploaded");
					  }
					  else
					  {
						  Logger.info("Document is not uploaded");
						  throw new NoSuchElementException("Document is not uploaded");
					  }
					
				  }
				  catch(Exception e)
				  {
					  Logger.error(e.getMessage());
					  throw e;
				  } 
			  }
			
	//Code to select the payment credit card type
	public void selectPaymentType(String cardTypeValue) throws Exception
	{
		 try
		 {
			 PaymentTypeDrpDwn.click();
			 Logger.info("Payment type dropdown is clicked");
			 Thread.sleep(3000);
			 //WebElement cardDrpDwn = driver.findElement(By.xpath("//dt[contains(text(),'Payment Type')]/../dd[6]/form/div/select"));
			 Select selectPaymentType = new Select(PaymentTypeDrpDwn);
			 List<WebElement> listOfValuesPymnt = selectPaymentType.getOptions();
			 Logger.info("Size :" +listOfValuesPymnt.size() );		
			 selectPaymentType.selectByVisibleText(cardTypeValue);
			 Logger.info(selectPaymentType+ " payment type is selected");
		 }
		 catch(Exception e)
		 {
			 Logger.error(e.getMessage());
			  throw e;
		 }
	}
	
	//Code to select the payment credit card type
		public void selectAccountType(String accountTypeValue) throws Exception
		{
			 try
			 {
				 AccountTypeDrpDwn.click();
				 Logger.info("Account type dropdown is clicked");
				 Thread.sleep(3000);
				 //WebElement cardDrpDwn = driver.findElement(By.xpath("//dt[contains(text(),'Payment Type')]/../dd[6]/form/div/select"));
				 Select selectPaymentType = new Select(AccountTypeDrpDwn);
				 List<WebElement> listOfValuesPymnt = selectPaymentType.getOptions();
				 Logger.info("Size :" +listOfValuesPymnt.size() );		
				 selectPaymentType.selectByVisibleText(accountTypeValue);
				 Logger.info(selectPaymentType+ " account type is selected");
			 }
			 catch(Exception e)
			 {
				 Logger.error(e.getMessage());
				  throw e;
			 }
		}
		
	//Code to select the payment credit card type
		public void enterCheckDetails() throws Exception
		{
			 try
			 {
				 selectPaymentType("Check");
				 CheckNoField.click();
				 CheckNoField.clear();
				 CheckNoField.sendKeys("12345");
				 ValueTxtFld.sendKeys("1");
				 //***********************				 
				 Logger.info("Check details entered successfully");
			 }
			 catch(Exception e)
			 {
				 Logger.error(e.getMessage());
				  throw e;
			 }
		}
		
	//Code to select the payment credit card type
		public void enterCashDetails() throws Exception
		{
			 try
			 {
				 selectPaymentType("Cash");
				 CashReceiptNoField.click();
				 CashReceiptNoField.clear();
				 CashReceiptNoField.sendKeys("12345");
				 ValueTxtFld.sendKeys("1");
				 //***********************				 
				 Logger.info("cash details entered successfully");
			 }
			 catch(Exception e)
			 {
				 Logger.error(e.getMessage());
				  throw e;
			 }
		}
		
	//Code to select the payment credit card type
	public void enterACHDetails() throws Exception
	{
		 try
		 {
			 selectPaymentType("ACH");
			 Thread.sleep(2000);
			 selectAccountType("New Card");	
			 Thread.sleep(7000);
			 enterAchBankAccountInfoOrder("BankAccountInfo");
			 ValueTxtFld.sendKeys("1");
			 //***********************				 
			 Logger.info("ACH details entered successfully");
		 }
		 catch(Exception e)
		 {Logger.info("Exception:"+e.toString());
			 Logger.error(e.getMessage());
			  throw e;
		 }
	}
	
	public void enterAchBankAccountInfoOrder(String sheetName) throws Exception
	  {
		  
		  try{
			  	  
			  if (accountACH.isDisplayed())
			  {
				  accountACH.click();
				  accountACH.clear();
				  accountACH.sendKeys(System.getProperty("ACHaccount"));
				  Logger.info("account is entered");
			  }
			  
			  if (routingACH.isDisplayed())
			  {Logger.info("INSIDE accountACH2");
				  routingACH.click();
				  routingACH.clear();
				  routingACH.sendKeys(System.getProperty("ACHrouting"));
				  Logger.info("routing is entered");
			  }
			  
			 if (accountTypeACH.isDisplayed())
			  {Logger.info("INSIDE accountACH3");
				 accountTypeACH.click();
				  Select valueFromBU = new Select(accountTypeACH);
			      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
			      if(listOfValuesBU.size() !=0)
				      {
				    	 valueFromBU.selectByVisibleText((TribuneUtils.getStringCellValues(sheetName, 1, 4)));
				         Logger.info("account type is selected"); 
				      }
			  }
						 
			  if (firstNameACH.isDisplayed())
			  {Logger.info("INSIDE accountACH4");
				  firstNameACH.click();
				  firstNameACH.clear();
				  firstNameACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 0));
				  Logger.info("first name is entered");
			  }
			  if (lastNameACH.isDisplayed())
			  {Logger.info("INSIDE accountACH5");
				  lastNameACH.click();
				  lastNameACH.clear();
				  lastNameACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 1));
				  Logger.info("last name is entered");
			  }
			  if (addressACH.isDisplayed())
			  {Logger.info("INSIDE accountACH6");
				  addressACH.click();
				  addressACH.clear();
				  addressACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 5));
				  Logger.info("address is entered");
			  }
			  if (cityACH.isDisplayed())
			  {Logger.info("INSIDE accountACH7");
				  cityACH.click();
				  cityACH.clear();
				  cityACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 6));
				  Logger.info("city is entered");
			  }
		     if (stateACH.isDisplayed())
			  {Logger.info("INSIDE accountACH8");
		    	 stateACH.click();
		    	 stateACH.clear();
		    	 stateACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 7));
				  Logger.info("state is entered");
			  } 
			  if (zipACH.isDisplayed())
			  {Logger.info("INSIDE accountACH9");
				  zipACH.click();
				  zipACH.clear();
				  zipACH.sendKeys(""+TribuneUtils.getIntCellValues(sheetName, 1, 8));
				  Logger.info("zip is entered");
			  }
			  if (countryACH.isDisplayed())
			  {Logger.info("INSIDE accountACH10");
				  countryACH.click();
				  countryACH.clear();
				  countryACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 9));
				  Logger.info("country is entered");
			  }
		     if (emailACH.isDisplayed())
			  {Logger.info("INSIDE accountACH11");
		    	 emailACH.click();
		    	 emailACH.clear();
		    	 emailACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 10));
				  Logger.info("email is entered");
			  } 
			  if (phoneACH.isDisplayed())
			  {Logger.info("INSIDE accountACH12");
				  phoneACH.click();
				  phoneACH.clear();
				  phoneACH.sendKeys(""+TribuneUtils.getIntCellValues(sheetName, 1, 11));
				  Logger.info("phone is entered");
			  }	  
		  }
		  catch(Exception e)
		  {Logger.info("Exception:"+e.toString());
			  Logger.error(e.getMessage());
			  throw e;
		  }
	  }
	
	//Code to select the payment credit card type
		public void verifySelectedPaymentMethods() throws Exception
		{
			 try
			 {
				 List<WebElement> menuLI = driver.findElements(
						  By.xpath(".//*[@id='payments']/div/div/div[2]/div[1]/ul/li"));
				 
				 if(menuLI.size()==4){
					 Assert.assertEquals("str", "str");
					 Logger.info("All payment types selected successfully");}
				 else{
					 Assert.assertEquals("str", "str1");
					 Logger.info("All payment types are not selected successfully");}								 
			 }
			 catch(Exception e)
			 {
				 Logger.error(e.getMessage());
				  throw e;
			 }
		}
		
		public void enterMonthlyPrice(String price) throws Exception
		  {
			  
			  try{			  	  
				 
				  monthlyPrice.click();
				  monthlyPrice.clear();
				  monthlyPrice.sendKeys(price);
				  Logger.info("monthlyPrice is entered");			  
				  
				
			  }
			  catch(Exception e)
			  {Logger.info("Exception:"+e.toString());
				  Logger.error(e.getMessage());
				  throw e;
			  }
		  }
}
