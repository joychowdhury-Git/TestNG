package com.tribune.adit2.OrderEntry;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

import junit.framework.Assert;

/**
 * Page Class Modeling for Order Entry Home Page
 * @author Priyanka Goud CR 
 * @since October 2015
 */

public class OrderEntryHomePage
{
	@FindBy (xpath = "//a[@class='dropdown-toggle']/span[2]")
	public WebElement newDropDwn;
	@FindBy (xpath = "//p[contains(text(),'You have successfully submitted the order')]/a")
	//@FindBy (xpath = "//body/div[@id='app']/div[@id='toast-container']/div[1]/div[3]/div[1]/div[1]/p[1]")
	public WebElement OrderSubmitSuccessMsg;//swagata
	
	
	@FindBy (xpath = "//button[text()='Yes']")
	public WebElement WarngMsgYesOptn;
	
	@FindBy (xpath = "//button[text()='No']")
	public WebElement WarngMsgNoOptn;
	
	@FindBy (id = "new_general_order")
	public WebElement newGeneralOrder;
	
	@FindBy (id= "new_insertion_order")
	public WebElement newInsertionOrderBtn;
	
	@FindBy (id = "new_reservation")
	public WebElement newReservation;
	@FindBy (className ="ui-grid-icon-plus-squared")
	public WebElement ExpandOrderLink;
	
	@FindBy (xpath = "//*[@id='Button2']/span[1]")
	public WebElement ExportToExcelLink;
	
	@FindBy (id = "new_quote")
	public WebElement newQuote;
	
	//Partha
  //@FindBy(id = "businessUnitId")
  @FindBy(xpath = "//select[@id='businessUnitId']//following::button[1]")	
  public WebElement businessUnitDropDown;
  
  @FindBy(xpath = "//*[@id='orderStatusId']/../div[@class='btn-group']")
  public WebElement statusDropDown;
  @FindBy(id="HiveId")
  public WebElement HiveIdTextBox;
  @FindBy(xpath = "//select[@id='orderTypeId']/../div[@class='btn-group']")
  //@FindBy(id = "orderTypeId")
  public WebElement typeDropDown;
  
  @FindBy (xpath = "//input[@id = 'keyword']/../div/button")
  public WebElement keywordSerachBtn;
  
  @FindBy (id = "keyword")
  public WebElement keywordTextBox;
  
  @FindBy (id = "Text1")
  public WebElement orderNumberTextBox;
  
  @FindBy(id = "pubdateRange")
  public WebElement pubDate;
 
  @FindBy(id = "bookdateRange")
  public WebElement bookDate;
  
  @FindBy (xpath = "(//button[text()='Apply'])[8]")
  public WebElement applyBookDateSelectionBtn; 
  
  @FindBy (xpath = "(//button[text()='Cancel'])[8]")
  public WebElement cancelBookDateSelectionBtn; 
  
  //@FindBy(id = "productTypeId")
  @FindBy(xpath = "//select[@id='productTypeId']/../div[@class='btn-group']")
  public WebElement productTypeDropDown;
  
  @FindBy(id = "productId")
  public WebElement productDropDown;
  
  @FindBy(id = "sectionId")
  public WebElement sectionDropDown;
  
  @FindBy(id = "zoneId")
  public WebElement zoneDropDown;
  
  @FindBy(id = "OrderRoutingId")
  public WebElement orderRoutingDropDown;
  
  @FindBy(id = "subCategoryId")
  public WebElement subCagtegoryDropDown;
  
  @FindBy(id = "classCodeId")
  public WebElement classCodeDropDown;
  
  @FindBy(id = "mmTagId")
  public WebElement mmTagTextBox;
  
  @FindBy(xpath = "//button[contains(text(), 'Advanced')]")
  public WebElement advancedLink;
  
  @FindBy(id = "btnSearch")
  public WebElement orderSearchBtn;
  
  @FindBy(id = "Button2")
  public WebElement orderListExportToExcelBtn;
  
  //@FindBy (xpath = "//a[@class='h3 order-link ng-binding']")
  @FindBy (xpath = "//div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a")
  public WebElement orderLink;
  
  @FindBy (linkText = "Copy Whole Order")
  public WebElement orderEntryCopyOrderLink;
  
  @FindBy (linkText = "Last")
  public WebElement lastPageLink;
  
  @FindBy (xpath = "//*[@id='toast-container']/div/div[1]/button")
  public WebElement closeOrderSubmissionMessage;
  
  @FindBy (xpath = "//ul[@class='dropdown-menu pull-right']//a[contains(text(),'Kill')]")
  public WebElement killOrderFromOrderEntryPage;
  
  @FindBy (xpath = "//div[@class='modal-footer ng-scope']/button[text()='Kill']")
  public WebElement killOrderButtonOnConformation;
  
   @FindBy (xpath = "(//*[text()='Processed ']/../../../div[1]/div/span/a)[1]")
  public WebElement orderSearchResult;
   

   @FindBy (xpath = "(//*[text()='Invoiced ']/../../../div[1]/div/span/a)[1]")
  public WebElement orderSearchResult1;
  
  @FindBy (xpath = "//tbody[1]/tr[1]/td[15]/div/a/span/span")
  public WebElement ProofType;
  //Partha
  @FindBy(xpath = "//span[contains(text(),'Price')]//following::i[2]")
  public WebElement OrderSearchPriceingOrderDropdown;
  
  @FindBy (xpath = "//*[@id='insertionInfo']/form/div/table/tbody/tr[1]/td[15]/div/form/div/select")
  public WebElement ProofTypeDD; 

    @FindBy (xpath = "//button[@id='advancedSearchToggler']")//Joy
	public WebElement AdvOrdersearchLink;
	
	@FindBy (xpath = "//button[text()='Yes']")
	public WebElement discardYesBtn;//mou
	
	@FindBy(xpath = "//*[@id='transfer-order']")
	public WebElement InvoiceTransfer;// arka
  
	@FindBy(xpath = "//select[@id='businessUnitId']/following-sibling::div/button")
	public WebElement buDropdown;//swagata
  private WebDriver driver;
  
  Properties properties = TribuneUtils.readProperties();
  
  public OrderEntryHomePage(WebDriver driver)
  {
	  this.driver = driver;
  }
  
  
  // Code to select the value from the Business Unit drop Drown
  
  public void selectBussinessUnit(String bussinessUnit) throws Exception
  {
	  try
	  {
		  
		    Actions action = new Actions(driver);//swagata
			action.moveToElement(buDropdown).click().build().perform(); //swagata				
			Logger.info("BU DropDown is clicked");			 		 
			WebElement searchResult = driver.findElement(By.xpath("(//select[@id='businessUnitId']//following::label[contains(text(),'"+bussinessUnit+"')])[1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
			Thread.sleep(5000);
			action.moveToElement(searchResult).click().build().perform();
			Logger.info(bussinessUnit+" bussiness Unit from filter is selected"); 
			
	  }//swagata
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
	  
  }
    
//Code to select the value from Status drop down
  
 public void selectStatus(String status) throws Exception
 {
	 try
	  {	       WebDriverWait wait = new WebDriverWait(driver,150);//swagata
	  wait.until(ExpectedConditions.elementToBeClickable(statusDropDown));//swagata
		        
		       Actions action = new Actions(driver);
				action.moveToElement(statusDropDown).click().build().perform(); 
				
		//  if (statusDropDown.isDisplayed())
		//  {
		//	  statusDropDown.click();
			  Logger.info("Status drop down is clicked");
			/*  String index = "";
			  switch (status)
			  
			    {
			  case "Select all":  index = "2";       break;
			  case "Saved":  index = "3";       break;
			  case "Submitted":  index = "4";       break;
			  case "Killed":  index = "5";       break;
			  case "Changed":  index = "6";       break;
			  case "Kill Pending":  index = "7";       break;
			  case "Change Pending":  index = "8";       break;
			  case "Processed":  index = "9";       break;
			  case "Expired":  index = "10";       break;   
			  case "Error":  index = "11";       break;
			  case "Invoiced":  index = "12";       break; 
			  case "Transferring":  index = "13";       break;
			  case "Transferred":  index = "14";       break; 
			  case "Pending Payment":  index = "15";       break;
			  case "Pending Approval":  index = "16";       break; 
			  case "Rejected":  index = "17";       break;
			  case "Pending Invoicing":  index = "18";       break; 

			    } 
			  
			  WebElement searchResult = driver.findElement(By.xpath("//*[@id='fetchOrder']/div[1]/div[3]/div/div/ul/li["+index+"]/a/label/input"));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
			  Thread.sleep(5000);
			  Actions action1 = new Actions(driver);
				action1.moveToElement(searchResult).click().build().perform();
			  //searchResult.click();
		      
		          Logger.info("'"+ status + "' status is selected"); *///swagata		 		 
				WebElement searchResult = driver.findElement(By.xpath("//select[@id='orderStatusId']//following::label[contains(text(),'"+status+"')]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
				Thread.sleep(5000);
				action.moveToElement(searchResult).click().build().perform();
				Logger.info(status+" bussiness Unit from filter is selected"); 
		     //swagata
		
		
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
 }
  
 public void selectType(String type)
 {
	 try
	  {
		  if (typeDropDown.isDisplayed())
		  {
			  //swagata
			  Actions action = new Actions(driver);
				action.moveToElement(typeDropDown).click().build().perform(); 			
				 Logger.info("Type drop down is clicked");
				WebElement searchResult = driver.findElement(By.xpath("(//select[@id='orderTypeId']//following::label[contains(text(),'"+type+"')])[1]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
				Thread.sleep(5000);
				action.moveToElement(searchResult).click().build().perform();
				Logger.info(type+" bussiness Unit from filter is selected");
			  //swagata
			  
			  
			  
			/* typeDropDown.click();
			 Logger.info("Type drop down is clicked");
			 Select valueFromType = new Select(typeDropDown);
		     List<WebElement> listOfValuesType = valueFromType.getOptions();
		     if(listOfValuesType.size() !=0)
		     {
		    	 Logger.info("List of type drop down is not empty"); 
		    	 valueFromType.selectByVisibleText(properties.getProperty(type));
		         Logger.info("'" + type + "' type is selected"); 
		     }*///swagata
		  }
		  else
		  {
			  Logger.info("Type drop down is not displayed");
			  throw new NoSuchElementException("Type drop down is not displayed");
		  }
		
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
	  }
 }
  
 // Code to enter the Customer Name for search criteria
  
  public void enterCustomerName(String filterIndex, String customerName) throws Exception
  {
	  try
	  {
		  if(keywordSerachBtn.isDisplayed()){
			  keywordSerachBtn.click();
			  Logger.info("Keyword search filter button is clicked");
			  WebElement filter = driver.findElement(By.xpath("(//label[@class='i-checks customer-label checkbox-option ng-binding']/i)["+filterIndex+"]"));
			  if(filter.isDisplayed())
			  {
				  filter.click();
				  Logger.info("filter critera is selected");
				  if(keywordTextBox.isDisplayed()){
					  keywordTextBox.click();
					  keywordTextBox.clear();
					  keywordTextBox.sendKeys(customerName);
					  Logger.info("'" +customerName+ "' Customer Name is entered");
				  }else{
					  Logger.info("keyword text box is not displayed");
				  } 
			  }
		  }
		  else
		  {
			  Logger.info("keyword filter button is not displayed");
		  }
		
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }    
  }

//Code to get the customer name from data provider
  
	  public void getCustomerName(String filterIndex, Map<String,String> userData) throws Exception
		{
			try 
			{
				enterCustomerName(filterIndex, userData.get("CustomerName3").toString());	
			} 
			catch (Exception e) 
			{
				throw e;
			}
		}
  
  
// Code to select the pub date
  public void selectPubDate() throws Exception
  {
	  try
	  {
		  if (pubDate.isDisplayed())
		  {
			  Logger.info("Pub date is displayed");
			  pubDate.click();
			  Logger.info("Pub Date is clicked"); 
		
		  }
	  }
	  catch(Exception e)
	  {
		  
	  }
	  
  }
  
// Code to select a product type from the drop down list
  
  public void selectProductType(String productType) throws Exception
  {
	  try
	  {
		  if (productTypeDropDown.isDisplayed())
		  {
			 // productTypeDropDown.click();
			  Actions action = new Actions(driver);//swagata
				action.moveToElement(productTypeDropDown).click().build().perform(); //swagata
			  Logger.info("Product Type drop down is clicked");
		      /*Select valueFromProductType = new Select(productTypeDropDown);
		      List<WebElement> listOfProductTypes = valueFromProductType.getOptions();
		      if(listOfProductTypes.size() !=0)
			      {
			    	 Logger.info("List of Product types is not empty"); 
			    	//valueFromProductType.selectByVisibleText(properties.getProperty(productType));
			    	 valueFromProductType.selectByVisibleText(productType);//swagata new
			      }*///swagata
			  				
				WebElement searchResult = driver.findElement(By.xpath("(//select[@id='productTypeId']//following::label[contains(text(),'"+productType+"')])[1]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
				Thread.sleep(5000);
				action.moveToElement(searchResult).click().build().perform();
				Logger.info(productType+" business Unit from filter is selected"); 
		  }//swagata
		  else
		  {
			  Logger.info("Product Type drop down is not displayed");
			  throw new NoSuchElementException("Product Type drop down is not displayed");
		  }
		
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
  }

// Code to select product
 
  public void selectProduct(String product) throws Exception
  {
	  try
	  {
		  if (productDropDown.isDisplayed())
		  {
			  productDropDown.click();
			  Logger.info("Product drop down is clicked");
		      Select valueFromProduct = new Select(productDropDown);
		      List<WebElement> listOfProducts = valueFromProduct.getOptions();
		      if(listOfProducts.size() !=0)
			      {
			    	 Logger.info("List of Product types is not empty"); 
			    	 valueFromProduct.selectByVisibleText(properties.getProperty(product));
			         Logger.info("'" + product + "' product is selected"); 
			      }
		  }
		  else
		  {
			  Logger.info("Product drop down is not displayed");
			  throw new NoSuchElementException("Product drop down is not displayed");
		  }
		
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
  }
  
// Code to select Section
  public void selectSection(String section) throws Exception
  {
	  try
	  {
		  if (sectionDropDown.isDisplayed())
		  {
			  sectionDropDown.click();
			  Logger.info("Section drop down is clicked");
		      Select valueFromSection = new Select(sectionDropDown);
		      List<WebElement> listOfSections = valueFromSection.getOptions();
		      if(listOfSections.size() !=0)
			      {
			    	 Logger.info("List of Product types is not empty"); 
			    	 valueFromSection.selectByVisibleText(properties.getProperty(section));
			         Logger.info("'" + section + "' section is selected"); 
			      }
		  }
		  else
		  {
			  Logger.info("Section drop down is not displayed");
			  throw new NoSuchElementException("Section drop down is not displayed");
		  }
		
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }  
  }
  
// Code to select the Zone
  public void selectZone(String zone) throws Exception
  {
	  try
	  {
		  if (zoneDropDown.isDisplayed())
		  {
			  zoneDropDown.click();
			  Logger.info("Zone drop down is clicked");
		      Select valueFromZone = new Select(zoneDropDown);
		      List<WebElement> listOfZones = valueFromZone.getOptions();
		      if(listOfZones.size() !=0)
			      {
			    	 Logger.info("List of Zones is not empty"); 
			    	 valueFromZone.selectByVisibleText(properties.getProperty(zone));
			         Logger.info("'" + zone + "' Zone is selected"); 
			      }
		  }
		  else
		  {
			  Logger.info("Zone drop down is not displayed");
			  throw new NoSuchElementException("Zone drop down is not displayed");
		  }
		
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }  
  }
  
// Code to select the Order Routing
  public void selectOrderRouting(String orderRouting) throws Exception
  {
	  try
	  {
		  if (orderRoutingDropDown.isDisplayed())
		  {
			  orderRoutingDropDown.click();
			  Logger.info("Order Routing drop down is clicked");
		      Select valueFromOrderRouting = new Select(orderRoutingDropDown);
		      List<WebElement> listOfOrderRoutings = valueFromOrderRouting.getOptions();
		      if(listOfOrderRoutings.size() !=0)
			      {
			    	 Logger.info("List of order routings is not empty"); 
			    	 valueFromOrderRouting.selectByVisibleText(properties.getProperty(orderRouting));
			         Logger.info("'" + orderRouting + "' order routing is selected"); 
			      }
		  }
		  else
		  {
			  Logger.info("Order Routing drop down is not displayed");
			  throw new NoSuchElementException("Order Routing drop down is not displayed");
		  }
		
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
  }
  
// Code to select Sub Category
  public void selectSubCategory(String subCategory) throws Exception
  {
	  try
	  {
		  if (subCagtegoryDropDown.isDisplayed())
		  {
			  subCagtegoryDropDown.click();
			  Logger.info("SubCategory drop down is clicked");
		      Select valueFromSubCategory = new Select(subCagtegoryDropDown);
		      List<WebElement> listOfSubCategories = valueFromSubCategory.getOptions();
		      if(listOfSubCategories.size() !=0)
			      {
			    	 Logger.info("List of subCategories is not empty"); 
			    	 valueFromSubCategory.selectByVisibleText(properties.getProperty(subCategory));
			         Logger.info("'" + subCategory + "' SubCategory is selected"); 
			      }
		  }
		  else
		  {
			  Logger.info("SubCategory drop down is not displayed");
			  throw new NoSuchElementException("SubCategory drop down is not displayed");
		  }
		
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
  } 
 
  public void selectSubCategoryByIndex(int index) throws Exception
  {
	  try
	  {
		  if (subCagtegoryDropDown.isDisplayed())
		  {
			  subCagtegoryDropDown.click();
			  Logger.info("SubCategory drop down is clicked");
		      Select valueFromSubCategory = new Select(subCagtegoryDropDown);
		      List<WebElement> listOfSubCategories = valueFromSubCategory.getOptions();
		      if(listOfSubCategories.size() !=0)
			      {
			    	 Logger.info("List of subCategories is not empty"); 
			    	 valueFromSubCategory.selectByIndex(index);
			         Logger.info("SubCategory is selected"); 
			      }
		  }
		  else
		  {
			  Logger.info("SubCategory drop down is not displayed");
			  throw new NoSuchElementException("SubCategory drop down is not displayed");
		  }
		
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
  } 
  
// Code to select Class Code
  public void selectClassCode(String classCode) throws Exception
  {
	  try
	  {
		  if (classCodeDropDown.isDisplayed())
		  {
		  classCodeDropDown.click();
		  Logger.info("classCode drop down is clicked");
	      Select valueFromSubCategory = new Select(classCodeDropDown);
	      List<WebElement> listOfSubCategories = valueFromSubCategory.getOptions();
	      Logger.info("List of classCode count: "+listOfSubCategories.size()); 
	      if(listOfSubCategories.size() !=0)
		      {		    	 
		    	 valueFromSubCategory.selectByVisibleText(classCode);
		         Logger.info("'" + classCode + "' classCode is selected"); 
		      }
		  }
	  else
	  {
		  Logger.info("classCode drop down is not displayed");
		  throw new NoSuchElementException("classCode drop down is not displayed");
	  }
	
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }    
  }

// Code to get the class Code from data provider
 /* 
  public void getClassCode(Map<String,String> userData) throws Exception
	{
		try 
		{
			enterClassCode(userData.get("ClassCode").toString());	
		} 
		catch (Exception e) 
		{
			throw e;
		}
	}  
  */
// Code to enter MM Tag
  public void enterMMTag(String mMTag) throws Exception
  {
	  try
	  {
		  if (mmTagTextBox.isDisplayed())
		  {
			  Logger.info("MM Tag text box is visible");
			  mmTagTextBox.click();
			  mmTagTextBox.sendKeys(mMTag);
			  Logger.info("MM Tag Tag is entered");
		  }
		  else
		  {
			  Logger.info("MM Tag TextBox is not displayed");
			  throw new NoSuchElementException("MM Tag TextBox is not displayed");
		  }
		
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }    
  }

//Code to get the MMTag from data provider
  
  public void getMMTag(Map<String,String> userData) throws Exception
	{
		try 
		{
			enterMMTag(userData.get("MMTag").toString());	
		} 
		catch (Exception e) 
		{
			throw e;
		}
	}  
  
//Code to click on the Advanced link
  
 public void clickOnAdvancedLink() throws Exception
 {
	  try
	  {
		  if (advancedLink.isDisplayed())
		  {
			  advancedLink.click();
			  Logger.info("Advanced Link is clicked");
		  }
		  else
		  {
			  Logger.info("Advanced Link is not displayed");
			  throw new NoSuchElementException("Advanced Link is not displayed");
		  }
		
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
 }
  
  // Code to click on the Search button
  
  public void clickOnOrderSearchBtn() throws Exception
  {
	  try
	  {
		  if (orderSearchBtn.isDisplayed())
		  {
			  orderSearchBtn.click();
			  Logger.info("Search button is clicked");
		  }
		  else
		  {
			  Logger.info("Search button is not displayed");
			  throw new NoSuchElementException("Search button is not displayed");
		  }
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
  }
  //Partha
  public void ordersearchPriceDecending() throws Exception
  {
	  try
	  {
		  
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", OrderSearchPriceingOrderDropdown);
			Thread.sleep(2000);
			  OrderSearchPriceingOrderDropdown.click();
		  Thread.sleep(2000);
		String price_decending_xpath="//button[contains(text(),'Sort Descending')]";
		  if (driver.findElement(By.xpath(price_decending_xpath)).isDisplayed())
		  {
			  driver.findElement(By.xpath(price_decending_xpath)).click();
			  Logger.info("Price Decending is clicked");
		  }
		  else
		  {
			  Logger.info("Price decending is not clicked.");
			  
		  }
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
  }
  
//Code to click on new order button
  public void clickOnNewInsertionOrderBtn() throws Exception
  {
	  try
	  {
		  	Thread.sleep(2000);
		  if(newDropDwn.isDisplayed()){
			  Thread.sleep(2000);
			  newDropDwn.click();
			  newInsertionOrderBtn.click();
			  Logger.info("New Order button is clicked");
		  }
		  else
		  {
			  Logger.info("New Order is not displayed");
			  throw new NoSuchElementException("New Order is not displayed");
		  }
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
  }
  
//Code to click on new general order
  public void clickOnNewGeneralOrder() throws Exception
  {
	  try{
		  WebDriverWait wait = new WebDriverWait(driver,500);	//swagata	       
			wait.until(ExpectedConditions.elementToBeClickable(newDropDwn));//swagata
		  if(newDropDwn.isDisplayed()){
			  newDropDwn.click();
				wait.until(ExpectedConditions.elementToBeClickable(newGeneralOrder));//swagata
			  newGeneralOrder.click();
			  Logger.info("New general order button is clicked");
		  }
		  else
		  {
			  Logger.info("New Order drop down is not displayed");
		  }
		  
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
  }
  
//Code to click on new general order
  public void clickOnNewReservation() throws Exception
  {
	  try{
		  if(newDropDwn.isDisplayed()){
			  newDropDwn.click();
			  newReservation.click();
			  Logger.info("New Reservation button is clicked");
		  }
		  else
		  {
			  Logger.info("New Order drop down is not displayed");
		  }
		  
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
  }
  
//Code to click on new general order
  public void clickOnNewQuote() throws Exception
  {
	  try{
		  if(newDropDwn.isDisplayed()){
			  newDropDwn.click();
			  newQuote.click();
			  Logger.info("New quote button is clicked");
		  }
		  else
		  {
			  Logger.info("New Order drop down is not displayed");
		  }
		  
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
  }
// Code to enter order number
  public void enterOrderNumber(String orderNumber) throws Exception
  {
	  try
	  {
		  if(orderNumberTextBox.isDisplayed())
		  {
		  orderNumberTextBox.click();
		  orderNumberTextBox.sendKeys(orderNumber);
		  Logger.info(orderNumber+" Order Number is entered");
		  }
		  else{
			  Logger.info("order Number textbox is not displayed");
		  }
			  
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
  }
  
//Code to click on the order link in the order entry page
  public void clickOnOrder(String orderID) throws Exception
  {
	  try
	  {
		 /* driver.findElement(By.xpath("//*[@id='businessUnitId']")).click();
	       WebElement productDrpDwn = driver.findElement(By.xpath("//*[@id='businessUnitId']"));
			  Select selectProduct = new Select(productDrpDwn);
			  List<WebElement> listOfProducts = selectProduct.getOptions();
			  
			  Logger.info("listOfProducts.size()="+listOfProducts.size());
			  
			  
		      if(listOfProducts.size() !=0)
			      {
		    	  selectProduct.selectByVisibleText("All");
			         Logger.info("All BU is selected"); 
			      }
		      else
		      {
		    	  Logger.info("BU drop down is empty");
		      }*///swagata
	       Thread.sleep(2000);
	       WebElement order1 = driver.findElement(By.xpath("//*[@id='Text1']"));
	       order1.click();
	       order1.sendKeys(Keys.CONTROL,"a");
	       order1.clear();
	       order1.sendKeys(orderID);
	       order1.sendKeys(Keys.ENTER);
	       Thread.sleep(2000);
	       orderSearchBtn.click();
	       Thread.sleep(5000);
		  //WebElement order = driver.findElement(By.xpath("//a[text()='"+orderID+"']"));//swagata
		  WebElement order = driver.findElement(By.xpath("//a[contains(text(),'"+orderID+"')]"));//swagata
		//a[normalize-space(text())='6614134']
		  WebDriverWait wait = new WebDriverWait(driver,120);
		  wait.until(ExpectedConditions.visibilityOf(order));
		  if(order.isDisplayed())
		  {
			  order.click();
			  Logger.info("order is clicked in Order Entry page");
			  Thread.sleep(3000);
		  }
		  else{
			  Logger.info("order is not displayed");
		  }
			NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);//swagata
		wait.until(ExpectedConditions.visibilityOf(newOrderInstance.orderViewPageElement)); //swagata
		  Wait<WebDriver> Fwait = new FluentWait<WebDriver>(driver)						
      			.withTimeout(500, TimeUnit.SECONDS) 			
      			.pollingEvery(2, TimeUnit.SECONDS) 			
      			.ignoring(NoSuchElementException.class);//swagata	
      	WebElement clickseleniumlink = Fwait.until(new Function<WebDriver, WebElement>(){
      	
      		public WebElement apply(WebDriver driver ) {
      			return 	driver.findElement(By.xpath("//span[text()='Processed 'or 'Changed ' or 'Invoiced ' or 'Transferred ']"));

      		}
      	});//swagata
      	String orderStatusProcessed = newOrderInstance.getOrdeStatusOrderViewPage();//swagata
		Logger.info("orderStatus "+orderStatusProcessed);//swagata
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
  }
  
//Code to get the order Id that is created
  public String getOrderNumber() throws Exception
  {
	  WebDriverWait wait = new WebDriverWait(driver,300);//swagata 
      wait.until(ExpectedConditions.visibilityOf(OrderSubmitSuccessMsg));//swagata
		String	orderNumber = getOrderID();
			  
	  return orderNumber;
  }
  
//Code to get the order number from the success message
  public String getOrderID() throws Exception
  {
	  Logger.info("Order ID entered");
	  String orderID = "";
	// Thread.sleep(2000);
	  //WebElement element =driver.findElement(By.xpath("//a[contains(@class,'bold text')]"));//Shalini
	  Logger.info("before order ID success pop up");
	// Thread.sleep(5000);
   // WebElement element = driver.findElement(By.xpath("//*[@id='toast-container']/div/div[3]/div/div/p/a"));
	//  WebElement element =driver.findElement(By.xpath("//p[contains(text(),'You have successfully submitted the order ')]/a"));//swagata
	  WebDriverWait wait = new WebDriverWait(driver,300);//swagata 
      wait.until(ExpectedConditions.elementToBeClickable(OrderSubmitSuccessMsg));//swagata
	  //wait.until(ExpectedConditions.visibilityOf(OrderSubmitSuccessMsg));
	 // Thread.sleep(3000);
	  orderID = OrderSubmitSuccessMsg.getText().trim();//swagata 
	  Logger.info("Order ID to the end of the function");
	  return orderID;
	  
  }

  
  public String getConfirmationMsg() throws Exception
  {
	  String orderID = "";
	  WebElement element = driver.findElement(By.xpath("//*[@id='toast-container']/div/div[3]/div"));
	  WebDriverWait wait = new WebDriverWait(driver,200); 
 
      wait.until(ExpectedConditions.elementToBeClickable(element));
 
	  orderID = element.getText();
	  return orderID;
	  
  }
  
  public String getOrderIDNewPage() throws Exception
  {
	  String orderID1 = "";
	 // WebElement element = driver.findElement(By.xpath(".//*[@id='order-detail-page']/div[1]/div/div[1]/span"));
	  WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Order:')]"));//swagata
	  WebDriverWait wait = new WebDriverWait(driver,200); 
 
      wait.until(ExpectedConditions.elementToBeClickable(element));
 
      orderID1 = element.getText();
      String[] parts = orderID1.split(":");
	  String orderID2 = parts[1].trim(); 
	  String[] parts1 = orderID2.split(" ");
	  String orderID = parts1[0].trim();
	  Logger.info("Order: "+orderID);
	  return orderID;
	  
  }
  
/*//Code to get the order status of the specific order in the search results
  public String getOrderStatus(String orderID) throws Exception
  {
	  driver.findElement(By.xpath("//*[@id='businessUnitId']")).click();
      WebElement productDrpDwn = driver.findElement(By.xpath("//*[@id='businessUnitId']"));
		  Select selectProduct = new Select(productDrpDwn);
		  List<WebElement> listOfProducts = selectProduct.getOptions();
		  
		  Logger.info("listOfProducts.size()="+listOfProducts.size());
		  
		  
	      if(listOfProducts.size() !=0)
		      {
	    	  selectProduct.selectByVisibleText("All");
		         Logger.info("All BU is selected"); 
		      }
	      else
	      {
	    	  Logger.info("BU drop down is empty");
	      }
      Thread.sleep(2000);
      orderSearchBtn.click();
      Thread.sleep(5000);
	  String orderStatus = "";
	  String orderStatusPath = "//a[text()='"+orderID+"']/../../../../div[5]/div/span";
	  try
	  {
		  WebElement order = driver.findElement(By.xpath(orderStatusPath));
		  if(order.isDisplayed()){
			  orderStatus = order.getText();
			  Logger.info("created order status is " +orderStatus);
		  }
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
	  return orderStatus;
  }
  */
  
  
//Code to get the order status of the specific order in the search results
  public String getOrderStatus(String orderID) throws Exception
  {
	  driver.findElement(By.xpath("//*[@id='businessUnitId']")).click();
      WebElement productDrpDwn = driver.findElement(By.xpath("//*[@id='businessUnitId']"));
		  Select selectProduct = new Select(productDrpDwn);
		  List<WebElement> listOfProducts = selectProduct.getOptions();
		  
		  Logger.info("listOfProducts.size()="+listOfProducts.size());
		  
		  
	      if(listOfProducts.size() !=0)
		      {
	    	  selectProduct.selectByVisibleText("All");
		         Logger.info("All BU is selected"); 
		      }
	      else
	      {
	    	  Logger.info("BU drop down is empty");
	      }
      Thread.sleep(2000);
      orderSearchBtn.click();
      Thread.sleep(5000);
	  String orderStatus = "";
	  String orderStatusPath = "//a[text()='"+orderID+"']/../../../../../div/div[5]/div/span";
	 // String orderStatusPath ="//div[@role='gridcell'][5]/div/span";//Shalini
	  try
	  {
		  WebElement order = driver.findElement(By.xpath(orderStatusPath));
		  if(order.isEnabled()){
			  orderStatus = order.getText();
			  Logger.info("created order status is " +orderStatus);
		  }
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
	  return orderStatus;
  }
  
//Copy the order from order Entry page
  public void copyOrder() throws Exception
  {
	  try
	  {
		  WebElement moreOptionsBtn = driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div[2]/div[2]/div/button[text()='More']"));
		  moreOptionsBtn.click();
		  if(orderEntryCopyOrderLink.isDisplayed())
		  {
			  orderEntryCopyOrderLink.click();
			  Logger.info("Copy order link is clicked");
		  }
		  else{
			  Logger.info("Copy order link is not displayed");
		  }
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
  }
  
//code to get the type selected in the order Entry page
  public String getTypeSelected() throws Exception
  {
	  String type = "";
	  try{
		  if(typeDropDown.isDisplayed()){
			  Select select = new Select(typeDropDown);
			  WebElement element  = select.getFirstSelectedOption();
			  type = element.getText();
		  }
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
	  return type;
  }
  
  public String getBuSelected() throws Exception
  {
	  String type = "";
	  try{
		  if(businessUnitDropDown.isDisplayed()){
			  Select select = new Select(businessUnitDropDown);
			  WebElement element  = select.getFirstSelectedOption();
			  type = element.getText();
		  }
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
	  return type;
  }
  
//code to click on book date businessUnitDropDown
  public void clickOnBookDate() throws Exception
  {
	  try{
		  if(bookDate.isDisplayed()){
			  bookDate.click();
			  Logger.info("Book date is clicked");
		  }
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
  }
  
//Code to click on required criteria in the book date options
  public void clickOnSpecificBookDate(String typeOfBookDate)
  {
	try{
		WebElement element = driver.findElement(By.xpath("(//li[text()='"+typeOfBookDate+"'])[8]"));
		element.click();
		Logger.info(typeOfBookDate+" typeOfBookDate is clicked");
		applyBookDateSelectionBtn.click();
	}  
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
  }
  
//code to get the book date 
  public String getBookDate() throws Exception
  {
	  String date = "";
	  try{
		  if(bookDate.isDisplayed())
		  {
			  date = bookDate.getAttribute("value");
		  }
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
	  return date;
  }
  
//code to get the status selected in status drop down in order entry search page 
  public String cancelElement() throws Exception
  {
	  String status = "";
	  try{
		  if(statusDropDown.isDisplayed())
		  {
			  Select select = new Select(statusDropDown);
			  WebElement element  = select.getFirstSelectedOption();
			  status = element.getText();
		  }
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
	  return status;
  }
  
 //code to get the count of the order search results
  public int getOrders(){
	  try {
		  WebDriverWait wait = new WebDriverWait(driver,10);
	       List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
	       wait.until(ExpectedConditions.visibilityOfAllElements(list));
	       return list.size();
		  
	  } catch (Exception e){
		  return 0;
	  }
  }
  
  /**
   * @author cymkozalg6 - Priyanka
   * @return customer entered in the keyword text box of order search page
   * @description reads the customer entered in the keyword text box of order search page and returns the same
   */
  public String getCustomerEnteredInOrderSearch() throws Exception
  {
	  String customerEntered = "";
	  try
	  {
		  if(keywordTextBox.isDisplayed())
		  {
			  customerEntered = keywordTextBox.getAttribute("value"); 
			  return customerEntered;
		  }
		  else{
			  return customerEntered;
		  }
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
  }
  
  /**
   * @author cymkozalg6 - Priyanka
   * @description This method closes the order success message
   */
  public void closeOrderSuccessSubmissionMessage() throws Exception
  {
	// WebElement closeOrderSubmissionMessage = driver.findElement(By.xpath("//*[@id='toast-container']/div/div[1]/button"));
	// WebDriverWait wait = new WebDriverWait(driver,200);	
				 //wait.until(ExpectedConditions.elementToBeClickable(closeOrderSubmissionMessage));
	  try{
		  if(closeOrderSubmissionMessage.isDisplayed())
		  {
			  closeOrderSubmissionMessage.click();
			  Logger.info("order success message is closed");
			  Thread.sleep(1000);
		  }
		  else{
			  Logger.info("order success message is not displayed");
		  }
	  }
	  catch(Exception e)
	  {
		  Logger.info("order success message is closed");
		  //throw e;
	  }
  }
  
  /**
   * @description this method clicked on more button on an order in order entry page
   * @param orderID
   */
  public void clickOnMoreOptionsOEPage(String orderID) throws Exception
  {
	  WebElement moreButton = driver.findElement(By.xpath("//a[text()='"+orderID+"']/../../../..//button[text()='More']"));
	  if(moreButton.isDisplayed())
	  {
		  moreButton.click();
		  Logger.info("More button on "+orderID+" order is clicked");
	  }else{
		  Logger.info("More button is not displayed");
	  }
  }
  
  /**
   * @description This method clicks on the button present under more options of an order in order entry page
   */
  public void killOrderFromOrderEntryPage() throws Exception
  {
	  if(killOrderFromOrderEntryPage.isDisplayed())
	  {
		  killOrderFromOrderEntryPage.click();
		  Logger.info("Kill button in order entry page is clicked");
	  }
	  else{
		  Logger.info("kill button is not displayed");
	  }
  }
  
  /**
   * @description This method clicks on the button present under more options of an order in order entry page
   */
  public void enterProofType() throws Exception
  {
	  if(ProofType.isDisplayed())
	  {
		  ProofType.click();
		  Logger.info("Proof Type in order entry page is clicked");
	  }
	  else{
		  Logger.info("Proof Type is not displayed");
	  }
	  
	  if(ProofTypeDD.isDisplayed())
	  {
		  Select valueFromProofType = new Select(ProofTypeDD);			  
		  valueFromProofType.selectByIndex(2);
		  Logger.info("Proof Type value is entered");
	  }
	  else{
		  Logger.info("Proof Type is not displayed");
	  }
  }
  
  /**
   * @description This method returns the status of the order from Order entry page
   * @param orderID
   */
  public String getOrderStatusFromOEPage(String orderID) throws Exception
  {
	  WebElement order1 = driver.findElement(By.xpath("//*[@id='Text1']"));
      order1.click();
      order1.sendKeys(Keys.CONTROL,"a");
      order1.clear();
      order1.sendKeys(orderID);
      order1.sendKeys(Keys.ENTER);
      Thread.sleep(2000);
      orderSearchBtn.click();
      Thread.sleep(5000);
	  WebElement order = driver.findElement(By.xpath("//a[text()='"+orderID+"']"));

	  WebDriverWait wait = new WebDriverWait(driver,120);
	  wait.until(ExpectedConditions.visibilityOf(order));
	  String orderStatus = "";
	  if(order.isDisplayed())
	  {
	  WebElement order2 = driver.findElement(By.xpath("//a[text()='"+orderID+"']/../../../../div[5]//span"));
	  orderStatus = order2.getText();
	 
	  }
	  return orderStatus;
  }
  public void verifyOrderStatusSelectedText(String text) throws Exception
  {
	  WebElement order = driver.findElement(By.xpath("//*[@id='orderStatusId']/../div[@class='btn-group']/button/span"));
	  String orderStatus = order.getText();
	  Logger.info("Order Status text: "+orderStatus);
	  Assert.assertEquals(text, orderStatus);
  }
  
  /**
   * @description This method is used to click on the kill button displayed in the kill order confirmation window 
   */
  public void clickOnKillOnConfirmation() throws Exception
  {
 	 try{
 		 killOrderButtonOnConformation.click();
 			 Logger.info("Kill button is clicked on the kill confirmation window");
 	 }
 	 catch(Exception e)
 	  {
 		  Logger.error(e.getMessage());
 		  throw e;
 	  } 
  }
  
  /**
   * @description Used to click on the searched order in order entry console
   */
  public void clickOnSearchedOrderInvoiced() throws Exception
  {
 	 try{
 		orderSearchResult1.click();
 			 Logger.info("Searched order is clicked on the searched order in order entry console: "+orderSearchResult1.getText());
 	 }
 	 catch(Exception e)
 	  {
 		  Logger.error(e.getMessage());
 		  throw e;
 	  } 
  }
  public void clickOnSearchedOrder() throws Exception
  {
 	 try{
 		orderSearchResult.click();
 			 Logger.info("Searched order is clicked on the searched order in order entry console: "+orderSearchResult.getText());
 	 }
 	 catch(Exception e)
 	  {
 		  Logger.error(e.getMessage());
 		  throw e;
 	  } 
  }
  public void selectBUs(String BU) throws Exception//SanDiego,mains
  {
 	 try
 	  {
 		        
 		       Actions action = new Actions(driver);
 				action.moveToElement(businessUnitDropDown).click().build().perform(); 
 		
 		//  if (statusDropDown.isDisplayed())
 		//  {
 		//	  statusDropDown.click();
 			  Logger.info("BU drop down is clicked"); 
 			// WebElement searchResult = driver.findElement(By.xpath("//*[@id='businessUnitId']"));
 			  			  Thread.sleep(5000);
 			  //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
 			 // Thread.sleep(5000);
 			 // Actions action1 = new Actions(driver);
 			 // Select select = new Select(searchResult);
 			  //select.selectByVisibleText(BU);
// 			  action1.moveToElement(searchResult).click().build().perform();
 			  //searchResult.click();
 			  			//partha		
 			  			driver.findElement(By.xpath("(//label[contains(text(),'All')])[1]")).click();
 			  			Thread.sleep(2000);
 			  			driver.findElement(By.xpath("(//label[contains(text(),'All')])[1]")).click();
 			  			Thread.sleep(2000);
 			  			  String Bu_xpath="//label[contains(text(),'"+BU+"')]";
 			  			  
 			  			  driver.findElement(By.xpath(Bu_xpath)).click();
 			  			Thread.sleep(2000);
 		          Logger.info("'"+ BU + "' BU is selected"); 
 		     
 		
 		
 	  }
 	  catch(Exception e)
 	  {
 		  Logger.error(e.getMessage());
 		  throw e;
 	  }
  }
  
  public void selectProductType2(String ProductType) throws Exception//SanDiego,mains
  {
 	 try
 	  {
 		        
 		       Actions action = new Actions(driver);
 				action.moveToElement(productTypeDropDown).click().build().perform(); 
 		//Partha		
 		//  if (statusDropDown.isDisplayed())
 		//  {
 		//	  statusDropDown.click();
 			  Logger.info("ProductType drop down is clicked");  
 			  WebElement searchResult = productTypeDropDown;
 			  Thread.sleep(5000);
 			 driver.findElement(By.xpath("(//label[contains(text(),'Product Type')]//following::input[@placeholder='Search'])[1]")).sendKeys(ProductType);
 			 Thread.sleep(2000);
 			 String firstProduct_xpath="//label[contains(text(),'"+ProductType+"')]";
 			driver.findElement(By.xpath(firstProduct_xpath)).click();;
 			Thread.sleep(1000);
 			  //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
 			 // Thread.sleep(5000);
 			 // Actions action1 = new Actions(driver);
 			  //Select select = new Select(searchResult);
 			 // select.selectByVisibleText(ProductType);
// 			  action1.moveToElement(searchResult).click().build().perform();
 			  //searchResult.click();
 		      
 		          Logger.info("'"+ ProductType + "' BU is selected"); 
 		     
 		
 		
 	  }
 	  catch(Exception e)
 	  {
 		  Logger.error(e.getMessage());
 		  throw e;
 	  }
  }
  public void selectProduct2(String Product) throws Exception//SanDiego,mains
  {
 	 try
 	  {
 		        
 		       Actions action = new Actions(driver);
 				action.moveToElement(productDropDown).click().build().perform(); 
 				
 		//  if (statusDropDown.isDisplayed())
 		//  {
 		//	  statusDropDown.click();
 			  Logger.info("Product drop down is clicked");  
 			  WebElement searchResult = productDropDown;
 			  Thread.sleep(5000);
 			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
 			  Thread.sleep(5000);
 			  Actions action1 = new Actions(driver);
 			  Select select = new Select(searchResult);
 			  select.selectByVisibleText(Product);
// 			  action1.moveToElement(searchResult).click().build().perform();
 			  //searchResult.click();
 		      
 		          Logger.info("'"+ Product + "' BU is selected"); 
 		     
 		
 		
 	  }
 	  catch(Exception e)
 	  {
 		  Logger.error(e.getMessage());
 		  throw e;
 	  }
  }
  
  public void selectSection2(String Section) throws Exception//SanDiego,mains
  {
 	 try
 	  {
 		        
 		       Actions action = new Actions(driver);
 				action.moveToElement(sectionDropDown).click().build().perform(); 
 				
 		//  if (statusDropDown.isDisplayed())
 		//  {
 		//	  statusDropDown.click();
 			  Logger.info("Section drop down is clicked");  
 			  WebElement searchResult = sectionDropDown;
 			  Thread.sleep(5000);
 			  //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
 			 // Thread.sleep(5000);
 			  Actions action1 = new Actions(driver);
 			  Select select = new Select(searchResult);
 			  select.selectByVisibleText("Main News");
// 			  action1.moveToElement(searchResult).click().build().perform();
 			  //searchResult.click();
 		      
 		          Logger.info("'"+ Section + "' BU is selected"); 
 		     
 		
 		
 	  }
 	  catch(Exception e)
 	  {
 		  Logger.error(e.getMessage());
 		  throw e;
 	  }
  }
  public String getInvoiceId() throws Exception
  {
	  //String InvoiceId = "";
	 
	  WebElement element = driver.findElement(By.xpath("//div[contains(@class,'orderline ui-grid ng-isolate-scope grid')]//div[contains(@class,'ui-grid-viewport')]//div[@row-render-index='rowRenderIndex']/div[@role='gridcell'][count(//div[contains(@class,'orderline ui-grid ng-isolate-scope grid')]//div[contains(@ng-repeat,'col in colContainer')][.//span[contains(@class,'ui-grid-header-cell-label')][text()='Invoice I D']]/preceding-sibling::div)+1]/div[contains(@class,'ui-grid-cell-contents')]"));
	  Thread.sleep(3000);
	  /*WebDriverWait wait = new WebDriverWait(driver,30); 
 
      wait.until(ExpectedConditions.elementToBeClickable(element));*/
 
	  String InvoiceId = element.getText();
	   Logger.info("Got the invoice ID");
	  return InvoiceId;
  }//swagata new
  
  public String getFirstInvOrderIdSearchLines() throws Exception
  {
	  //String InvoiceId = "";
	 
	  WebElement element = driver.findElement(By.xpath("((//span[text()='Invoiced '])[1]/../../../div)[1]/div/span/a"));
	  Thread.sleep(3000);
	  /*WebDriverWait wait = new WebDriverWait(driver,30); 
 
      wait.until(ExpectedConditions.elementToBeClickable(element));*/
 
	  String OrderIdSearchLines = element.getText();
	   Logger.info("Got the order ID:" +OrderIdSearchLines);
	  return OrderIdSearchLines;
  }//swagata new
  
  public void ClickPendingAppOrder() throws Exception
  {
	  try
	  {
		 WebDriverWait wait = new WebDriverWait(driver,20);
	  
	  WebElement order = driver.findElement(By.xpath("((//span[text()='Pending Approval '])[1]/../../../div)[1]/div/span/a"));
  order.click();
	  wait.until(ExpectedConditions.visibilityOf(order));
	  if(order.isDisplayed())
	  {
		  order.click();
		  Logger.info("order is clicked in Order Entry page");
		  Thread.sleep(3000);
	  }
	  else{
		  Logger.info("order is not displayed");
	  }
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
  }//swagata new
  
  public void ClickProcessedOrder() throws Exception
  {
	  try
	  {
		 WebDriverWait wait = new WebDriverWait(driver,20);
	  
	  WebElement order = driver.findElement(By.xpath("((//span[text()='Processed '])[1]/../../../div)[1]/div/span/a"));
  order.click();
	  wait.until(ExpectedConditions.visibilityOf(order));
	  if(order.isDisplayed())
	  {
		  order.click();
		  Logger.info("order is clicked in Order Entry page");
		  Thread.sleep(3000);
	  }
	  else{
		  Logger.info("order is not displayed");
	  }
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
  }//swagata new 
  public void clickOnAdvSearch() throws Exception
 	{
 		try{
 			if(AdvOrdersearchLink.isDisplayed())
 			{
 				AdvOrdersearchLink.click();
 				Logger.info("Advanced search button is clicked");
 			}
 			else{
 				Logger.info("Advanced search button is not clicked");

 			}
 		}
 		catch(Exception e){
 			Logger.error("Advanced search button is not clicked "+e.getMessage());
 			  throw e;
 		}
 	}//swagata new
  public void ExpandInvoicedOrder() throws Exception
	{
		try{
			/*WebDriverWait wait = new WebDriverWait(driver,20);
	       wait.until(ExpectedConditions.elementToBeClickable(ExpandOrderLink));*/
			if(ExpandOrderLink.isDisplayed())
			{
				ExpandOrderLink.click();
				Logger.info("Expand Order Link button is clicked");
			}
			else{
				Logger.info("Expand Order Link button is not clicked");

			}
		}
		catch(Exception e){
			Logger.error("Expand Order Link button is not clicked "+e.getMessage());
			  throw e;
		}
	}//swagata new
  public void ExportToExcel() throws Exception
 	{
 		try{
 			if(ExportToExcelLink.isDisplayed())
 			{
 				ExportToExcelLink.click();
 				Logger.info("Export to Excel button is clicked");
 			}
 			else{
 				Logger.info("Export to Excel button is not clicked");

 			}
 		}
 		catch(Exception e){
 			Logger.error("Export to Excel button is not clicked "+e.getMessage());
 			  throw e;
 		}
 	}//swagata new
  
  public void clickOnDiscardYesBtn() throws Exception
	{
		try{
			if(discardYesBtn.isDisplayed())
			{
				discardYesBtn.click();
				Logger.info("Order  is discarded");
			}
			else{
				Logger.info("Order discard is not discarded");

			}
		}
		catch(Exception e){
			Logger.error("Order discarded button is not clicked "+e.getMessage());
			  throw e;
		}
	}//mou
  public void clickOnInvoiceTransfer() throws Exception {
		try {

			Actions action = new Actions(driver);
			action.moveToElement(InvoiceTransfer).click().build().perform();

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// arka
  public void enterHiveId(String ID) throws Exception
  {
 	 try
 	  {	       WebDriverWait wait = new WebDriverWait(driver,150);
 	  wait.until(ExpectedConditions.elementToBeClickable(HiveIdTextBox));
 	 HiveIdTextBox.click();
 	HiveIdTextBox.clear();
 	HiveIdTextBox.sendKeys(ID);
 		       Logger.info("Hive id is entered "+ID); 
 		     
 		
 		
 	  }
 	  catch(Exception e)
 	  {
 		  Logger.error(e.getMessage());
 		  throw e;
 	  }
  }//swagata


public void validateOrderNum(String orderid) {
	WebElement element = driver.findElement(By.xpath("//a[contains(@class,'order')]"));
	String orderId = element.getText();
	Assert.assertEquals(orderid, orderId);
     Logger.info("Both order number has matched"); 

}//swagata
}
