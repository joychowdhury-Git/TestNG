package com.tribune.adit2.Customers;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
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
 * Page Class Modeling for Customers Page
 * @author Priyanka Goud CR 
 * @since October 2015
 */

public class CustomerProfilePage 
{

	@FindBy (xpath = "//h1[contains(text(),'Customer Profile')]")
	public WebElement customerProfileText;
	
	@FindBy (xpath = "//div[@class='input-group w-full autocomplete-field']/input")
	public WebElement custProfileSearchBox;
	
	@FindBy (xpath = "//span[@class='text-info ng-binding']")
	public List<WebElement> autoSuggestCustName;
	
	@FindBy (xpath = "//span/b[@class='ng-binding']")
	public WebElement autoSuggestCUNum;
	
	@FindBy (xpath = "//h4[@class='pull-left ng-binding']/b")
	public WebElement customerName;
	
	@FindBy (xpath = "//dt[text()='Account Type:']/../dd[9]")
	public WebElement customerAccType;
	
	@FindBy (xpath = "//dt[text()='Account Type:']/../dd[8]")
	public WebElement customerBillType;
	
	@FindBy (xpath = "//h4[@class='pull-left ng-binding']")
	public WebElement customerID;
	
	@FindBy (xpath = "//button[@class='btn btn-default btn-sm']/i[@class='glyphicon glyphicon-pencil']")
	public WebElement editAddressLink;
	
	@FindBy (xpath = "//button[@class='btn btn-default btn-sm']/i[@class='glyphicon glyphicon-trash']")
	public WebElement deleteAddressLink;
	
	@FindBy (xpath = "//button[contains(text(), 'New Address')]/i[@class='glyphicon glyphicon-plus']")
	public WebElement createNewAddressLink;
	
	@FindBy (linkText = "Supplemental Data")
	public WebElement supplementalDataTab;
	
	@FindBy (linkText = "Business Unit Mappings")
	public WebElement businessUnitMappingsTab;
	
	@FindBy (linkText = "Pricing Groups")
	public WebElement pricingGroupsTab;
	
	@FindBy (linkText = "Credit Cards")
	public WebElement creditCardsTab;
	
	@FindBy (linkText = "Legacy System Data")
	public WebElement legacySystemDataTab;
	
	@FindBy (id = "new_order")
	public WebElement customerNewOrderLink;
	
	@FindBy (xpath = "//input[@class='form-control  ng-pristine ng-valid ng-touched']")
	public WebElement customerSearchCustomerProfileLink;
	
	@FindBy (xpath = "//a[contains(text(),'Edit')]/i[@class='glyphicon glyphicon-pencil']")
	public WebElement editCustomerDetailsLink;
	
	@FindBy (xpath = "//button[text()='Syc with AX']")
	public WebElement synWithAXLink;

	@FindBy (xpath = "//tr[@class='address-line ng-scope']/td[1]/div[1]/b")
	public WebElement custProfileContactName;
	
	@FindBy (xpath = "//div/span[text()='Primary']")
	public WebElement primaryAdrress;
	
	@FindBy (xpath = "//tr[@class='address-line ng-scope']/td[1]/div[2]")
	public WebElement custProfileStreetAddress;
	
	@FindBy (xpath = "//tr[@class='address-line ng-scope']/td[1]/div[3]")
	public WebElement custProfileCityStateZipAddres;
	
	@FindBy (xpath = "//tr[@class='address-line ng-scope']/td[2]")
	public WebElement custProfileAddressType;
	
	@FindBy (xpath = "//tr[@class='address-line ng-scope']/td[3]/div[2]")
	public WebElement custProfilePhoneNumber;
	
	@FindBy (xpath = "//tr[@class='address-line ng-scope']/td[3]/div[3]")
	public WebElement custProfileFax;
	
	@FindBy (xpath = "//tr[@class='address-line ng-scope']/td[3]/div[1]")
	public WebElement custProfileEmail;
	
	@FindBy (xpath = "//button[text()='New Payment Method']")
	public WebElement newPaymentMethod;
	
	//@FindBy (id = "inlineSubmit")
	@FindBy (xpath = "//span[@class='editable-buttons']/button/span[@class='glyphicon glyphicon-ok']")
	public WebElement saveDefaultPricingGroup;
	
	@FindBy (id = "inlineCancel")
	public WebElement cancelDefaultPricingGroup;
	
	@FindBy (xpath = ".//*[@id='pricingGroups']/div/div[1]/a")
	public List<WebElement> listOfBusinessUnits;

	@FindBy (linkText = "New product pricing tier")
	public WebElement newProductTier;

	@FindBy (xpath = "//select[@ng-model='newProductPricingGroup.productTypeId']")
	public WebElement productTypeDropDown;
	
	@FindBy (xpath = "//select[@ng-model='newProductPricingGroup.productId']")
	public WebElement productDropDown;
	
	@FindBy (xpath = "//select[@ng-model='newProductPricingGroup.advertiserTierId']")
	public WebElement pricingGroupDropDown;
	
	@FindBy (xpath = "//button[text()='Save']")
	public WebElement saveNewProductCustProfile;
	
	@FindBy (xpath = "//button[text()='Cancel']")
	public WebElement cancelNewProductCustProfile;
	
	@FindBy (xpath = "//th[contains(text(),'Product')]/input")
	public WebElement productSearch;
	
	@FindBy (xpath = ".//*[@id='pricingGroups']/div/div[2]/div[2]/table/tbody/tr[1]/td[2]")
	public WebElement pricingGroupTabProduct;
	
	@FindBy (xpath ="//span[@id='Span2']/span")
	public WebElement pricingGroupTabPricing;
	
	@FindBy (xpath = "//div[@class='editable-controls form-group']/select" )
	public WebElement pricingGroupPricingDrpDwn;
	
	@FindBy (xpath = "//a[text()='Kill']")
	public WebElement killRecentOrderBtn;
	
	@FindBy (xpath = "//a/span[text()='Copy']")
	public WebElement copyRecentOrderBtn;
	
	@FindBy (xpath = "//a[contains(text(),'More')]/i")
	public WebElement moreRecentOrdersButton; 
	
	@FindBy (xpath = "//dt[text()='AX Reference #:']/../dd[4]")
	public WebElement customerCUNumber;
	
	@FindBy (xpath = "//dt[text()='MDM ID:']/../dd[7]")
	public WebElement customerMDMNumber;

    //@FindBy(xpath ="//input[contains(@ng-change,'customerInactive()')]/..")
	@FindBy(xpath ="//dl[@class='customer-dl dl-horizontal']//dd[1]//label[1]//input")
    public WebElement activeInactiveCheckBox;//Partha
  
    @FindBy (xpath = "//input[contains(@ng-change,'customerInactive()')]/..//ancestor::label")
    public WebElement activeInactiveCheckBoxClick;//partha
	@FindBy (xpath = "//button[@id='history']")
    public WebElement historyButton;//swagata
	@FindBy(xpath = "//span[text()='Inactive']")
	public WebElement inactiveStatus;

	private WebDriver driver;
	
	Properties properties = TribuneUtils.readProperties();
	
	public CustomerProfilePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
// Code to get the customer profile text
	public void getCustomerProfile() throws Exception
	  {
		  try
		  {
			  if (customerProfileText.isDisplayed())
			  {
				  Logger.info("customer profile page is loaded");
			  }
			  else
			  {
				  Logger.info("customer profile page is not loaded");
				  throw new NoSuchElementException("customer profile page is not loaded");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  }
	  }
//Code to get the customer name from customer profile
	public String getCustomerBillingType() throws Exception
	{
		String custAcc = "";
		try
		{
			if (customerBillType.isDisplayed())
			  {
				custAcc = customerBillType.getText();
				Logger.info("customer billing type is : " +custAcc);
			  }
			  else
			  {
				  Logger.info("customer billing type is not displayed");
				  throw new NoSuchElementException("customer billing type is not dispalyed");
			  }
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
		return custAcc;
	}
	public String getCustomerName() throws Exception
	{
		String custName = "";
		try
		{
			if (customerName.isDisplayed())
			  {
				custName = customerName.getText();
				Logger.info("customer name is : " +custName);
			  }
			  else
			  {
				  Logger.info("customer name is not displayed");
				  throw new NoSuchElementException("customer name is not dispalyed");
			  }
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
		return custName;
	}
//Code to get the customer id from customer profile
	public String getCustomerID() throws Exception
	{
		String custID = "";
		try
		{   Wait<WebDriver> Fwait = new FluentWait<WebDriver>(driver)						
		.withTimeout(200, TimeUnit.SECONDS) 			
		.pollingEvery(2, TimeUnit.SECONDS) 			
		.ignoring(NoSuchElementException.class);//swagata	
WebElement clickseleniumlink = Fwait.until(new Function<WebDriver, WebElement>(){

	public WebElement apply(WebDriver driver ) {
		return 	customerID;//swagata

	}
});//swagata
			WebDriverWait wait =new WebDriverWait(driver, 300);//swagata
			if (customerID.isDisplayed())
			  {
				custID = customerID.getText();
				Logger.info("Customer ID is : "+custID);
			  }
			  else
			  {
				  Logger.info("customer ID is not displayed");
				  throw new NoSuchElementException("customer ID is not displayed");
			  }
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
		return custID;
	}

	//code to search customer through search box using the AX reference or CU number number
	  public void searchCustomerProfileByCUNumber(String cuNum) throws Exception
	  {
		  try
		  {
			  if(custProfileSearchBox.isDisplayed())
			  {
				  custProfileSearchBox.click();
				  custProfileSearchBox.clear();
				  custProfileSearchBox.sendKeys(cuNum);
				  WebDriverWait wait = new WebDriverWait(driver, 120);
				  wait.until(ExpectedConditions.visibilityOf(autoSuggestCUNum));
				  autoSuggestCUNum.click();
				  Logger.info("auto suggestion results are displayed and the required value is clicked");
			  }
			  else
			  {
				  Logger.info("Customer seach box is not displayed");
			  }
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  }
	  }

//code to search customer through search box using customer name
	  public void searchCustomerProfileByNameSearchbox(String searchCriteria) throws Exception
	  {
		  try
		  {
			  if(custProfileSearchBox.isDisplayed())
			  {
				  custProfileSearchBox.click();
				  custProfileSearchBox.clear();
				  custProfileSearchBox.sendKeys(searchCriteria);
				  WebDriverWait wait = new WebDriverWait(driver,20);
				  wait.until(ExpectedConditions.visibilityOfAllElements(autoSuggestCustName));
				  Iterator<WebElement> iterator = autoSuggestCustName.iterator();
				  while(iterator.hasNext())
				  {
					  WebElement autoSuggestions = iterator.next();
					  String search = autoSuggestions.getText();
					  if(search.equalsIgnoreCase(searchCriteria))
						  autoSuggestions.click();
				  }
				  Logger.info("auto suggestion results are displayed and the required value is clicked");
			  }
			  else
			  {
				  Logger.info("Customer seach box is not displayed");
			  }
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  }
	  }
	  
	
//Code to edit the customer address details
	public void clickEditAddressLink() throws Exception
	{
		try
		{
			if (editAddressLink.isDisplayed())
			  {
				editAddressLink.click();
				Logger.info("Edit Address link is clicked");
				Thread.sleep(10000);
			  }
			else
			{
				 Logger.info("Edit Address link is not displayed");
				  throw new NoSuchElementException("Edit Address link is not displayed");	
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}


	
//Code to delete the address
	public void clickOnDeleteAddress() throws Exception
	{
		try
		{
			if(deleteAddressLink.isDisplayed())
			{
				deleteAddressLink.click();
				Logger.info("Address is deleted");
			}
			else
			{
				Logger.info("address link is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to click on New Address
	public void clickOnNewAddress() throws Exception
	{
		try
		{
			if(createNewAddressLink.isDisplayed())
			{
				createNewAddressLink.click();
				Thread.sleep(10000);
				Logger.info("New address link is clicked");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}

//Code to click on Supplemental data tab
	public void clickOnSupplimentalDataTab() throws Exception
	{
		try
		{
			if(supplementalDataTab.isDisplayed())
			{
				supplementalDataTab.click();
				Logger.info("Supplemental Data tab is clicked");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}

//Code to click on Business Unit Mapping tab
	public void clickOnBusinessUnitMappingTab() throws Exception
	{
		try
		{
			if(businessUnitMappingsTab.isDisplayed())
			{
				businessUnitMappingsTab.click();
				Logger.info("Business Unit Mapping tab is clicked");
				
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}

//Code to click on Pricing Groups tab
	public void clickOnPricingGroupsTab() throws Exception
	{

Thread.sleep(4000); 
		  
		  JavascriptExecutor js = ((JavascriptExecutor) driver);
		  js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		  
		try
		{
			if(pricingGroupsTab.isDisplayed())
			{
				pricingGroupsTab.click();
				Logger.info("Pricing Groups tab is clicked");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to click on Credit Cards tab
	public void clickOnCreditCardsTab() throws Exception
	{

Thread.sleep(4000); 
		  
		  JavascriptExecutor js = ((JavascriptExecutor) driver);
		  js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		  
		try
		{
			if(creditCardsTab.isDisplayed())
			{
				creditCardsTab.click();
				Logger.info("Credit Cards tab is clicked");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to click on Legacy System Data tab
	public void clickOnLegacySystemDataTab() throws Exception
	{
		try
		{
			if(legacySystemDataTab.isDisplayed())
			{
				legacySystemDataTab.click();
				Logger.info("Legacy System Data tab is clicked");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to add a new payment method to a particular customer
	public void clickOnNewPaymentMethod() throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(newPaymentMethod));
			if (newPaymentMethod.isDisplayed())
			{
				newPaymentMethod.click();
				Logger.info("New payment method is clicked");
				Thread.sleep(2000);
			}
		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to edit the default pricing group for the respective business unit
	public void editPricingGroup(String businessUnit, String pricingGroup) throws Exception
	{
		String buMappingsAllRows = ".//*[@id='buMappings']/div/table/tbody/tr";
		String pricingGrpDrpDown = "//div[@class='editable-controls form-group']/select";
		try
		{
		List<WebElement> buColumn = driver.findElements(By.xpath(buMappingsAllRows+"/td[1]"));
		int rowSize = buColumn.size();
		for (int rowIndex=0;rowIndex<rowSize;rowIndex++) 
		{
			if (buColumn.get(rowIndex).getText().equals(properties.getProperty(businessUnit)))
			{
				String pricingGroupColumnValue = buMappingsAllRows+"["+ (rowIndex+1) +"]/td[2]";
				driver.findElement(By.xpath(pricingGroupColumnValue)).click();
				Logger.info("pricing group against '"+properties.getProperty(businessUnit)+ "' BU is clicked");
				WebElement pricingGroupElement = driver.findElement(By.xpath(pricingGrpDrpDown));
				Select selectPricingGroups = new Select(pricingGroupElement);
			    selectPricingGroups.selectByVisibleText(properties.getProperty(pricingGroup));
			    Logger.info("Pricing group '" +properties.getProperty(pricingGroup) +"' is selected from the drop down");
			    //driver.findElement(By.xpath("//button[@type='submit']/span[@class='glyphicon glyphicon-ok']")).click();
			    saveDefaultPricingGroup.click();
			    Logger.info("pricing group is changed"); 
				rowIndex++;
			}
		}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;	
		}
	}
	
//Code to validate the pricing group update for specific business group
	public void validatePricingGroupUpdate(String businessUnit, String pricingGroup) throws Exception
	{
		String buMappingsAllRows = ".//*[@id='buMappings']/div/table/tbody/tr";
		try
		{
		List<WebElement> buColumn = driver.findElements(By.xpath(buMappingsAllRows+"/td[1]"));
		int rowSize = buColumn.size();
		for (int rowIndex=0;rowIndex<rowSize;rowIndex++) 
		{
			if (buColumn.get(rowIndex).getText().equals(properties.getProperty(businessUnit)))
			{
				String pricingGroupColumnValue = buMappingsAllRows+"["+ (rowIndex+1) +"]/td[2]";
				String updatedPricingGroup = driver.findElement(By.xpath(pricingGroupColumnValue)).getText();
				Assert.assertEquals(properties.getProperty(pricingGroup), updatedPricingGroup);
				Logger.info("Validation success. Pricing group is updated to "+ updatedPricingGroup + 
						     " for " +properties.getProperty(businessUnit)+ " business unit.");
				rowIndex++;
			}
		}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;	
		}
	}
// Code to click on the corresponding business unit under pricing groups tab
	public void selectBusinessUnit(String businessUnit) throws Exception
	{
		try
		{
			if(!listOfBusinessUnits.isEmpty())
			{
				int rowSize = listOfBusinessUnits.size();
				for (int rowIndex=0;rowIndex<rowSize;rowIndex++) 
				{
					if (listOfBusinessUnits.get(rowIndex).getText().equalsIgnoreCase(properties.getProperty(businessUnit)))
					{
						WebElement buElement  = listOfBusinessUnits.get(rowIndex);
						buElement.click();
						Logger.info("Business Unit selected "+buElement.getText());
						rowIndex++;
					}
				}
			}
			else 
			{
				Logger.info("list of business unit is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to enter the details of the new product to be added
	public void enterNewProductDetails(String productType, String Product, String pricingGroup) throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOf(newProductTier));
			
			if(newProductTier.isDisplayed())
			{
				newProductTier.click();
				Logger.info("new product tier link is clicked");
				if(productTypeDropDown.isDisplayed())
				{
					Select selectProductType = new Select(productTypeDropDown);
					selectProductType.selectByVisibleText(properties.getProperty(productType));
					Logger.info("Product Type " +properties.getProperty(productType)+ " is selected");
				}
				if(productDropDown.isDisplayed())
				{
					Select selectProduct = new Select(productDropDown);
					selectProduct.selectByVisibleText(Product);
					Logger.info("Product " +Product+ " is selected");
				}
				if(pricingGroupDropDown.isDisplayed())
				{
					Select selectPricingGroup = new Select(pricingGroupDropDown);
					selectPricingGroup.selectByVisibleText(properties.getProperty(pricingGroup));
					Logger.info("Pricing group " +(properties.getProperty(pricingGroup)+ " is selected"));
				}
			}
			else
			{
				Logger.info("New Product tier link is not displayed");
			}
		}
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
// Code to click on the save button after entering the details for a new product
	public void saveNewProduct() throws Exception
	{
		try
		{
			if(saveNewProductCustProfile.isDisplayed())
			{
				saveNewProductCustProfile.click();
				Logger.info("New product is saved under Pricing groups tab");
				WebDriverWait wait = new WebDriverWait(driver, 120);
				wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(saveNewProductCustProfile)));
			}
			else
			{
				Logger.info("save button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to click on the cancel button to cancel the changes made to add a new product
	public void cancelAdditionOfNewProduct() throws Exception
	{
		try
		{
			if(cancelNewProductCustProfile.isDisplayed())
			{
				cancelNewProductCustProfile.click();
				Logger.info("Cancel button is clicked to cancel the changes made to add a new product");
			}
			else
			{
				Logger.info("Cancel button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}

//Code to search a product in the product pricing group
	public void searchAndEditProductPricing(String productName, String pricingGroup) throws Exception
	{
		try
		{
			if(productSearch.isDisplayed())
				{
					productSearch.click();
					productSearch.clear();
					productSearch.sendKeys(productName);
					if(pricingGroupTabProduct.getText().equalsIgnoreCase(productName))
					{
						pricingGroupTabPricing.click();
						Select selectPricingGroup = new Select(pricingGroupPricingDrpDwn);
						selectPricingGroup.selectByVisibleText(properties.getProperty(pricingGroup));
						saveDefaultPricingGroup.click();
						Logger.info("pricing group for the respective product is changed");
					}
				}
			else
			{
				Logger.info("Product search box is not displayed");
			}
		}
		catch(Exception e)
		{
			 Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to delete a product in the pricing groups tab
	public void deleteProduct(String productType, String Product) throws Exception
	{
		String rowsPath = "//div[2]/table/tbody/tr[@class='ng-scope']"; 
		List<WebElement> allRows = driver.findElements(By.xpath(rowsPath));
		try
		{
		for (int rowIndex=0; rowIndex<allRows.size(); rowIndex++)
	       {
	    	  WebElement productElement = driver.findElement(By.xpath(rowsPath + "/td[text()='" + properties.getProperty(productType).toString() + "']/../td[2]")) ;
		    	if(productElement.isDisplayed()){   
		    	  if(productElement.getText().equalsIgnoreCase(Product))
			    	   {
			    		   Logger.info("Product is present in the pricing groups tab");
			    		   WebElement deleteProductElement = driver.findElement(By.xpath(rowsPath + "/td[contains(text(),'" + properties.getProperty(productType).toString() + "')]/../td[contains(text(),'" +Product+ "')]/../td[4]/button"));
			    		   if(deleteProductElement.isDisplayed())
			    		   {
			    			   Logger.info("Delete button  is displayed against the product specified");
			    			   deleteProductElement.click();
			    			   //Thread.sleep(2000);
			    			   WebElement deleteConfirm = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
			    			   deleteConfirm.click();
			    			   Logger.info("product is deleted");
			    			   break;
			    		   }
			    		   else
				    	   {
				    		   Logger.info("Product is not present");
				    	   }
			    	   }
		    	}else
		    	   {
		    		   Logger.info("Product is not present");
		    	   }  
	       }
		}
		catch(Exception e)
		{
			 Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//code to the edit recent orders
	  public void clickOnEditRecentOrder(int index) throws Exception
	  {
		  String path = "//div[@class='btn-group pull-right dropdown']/a[@class='btn btn-default btn-sm']/i";
		  try{
			  List<WebElement> list = driver.findElements(By.xpath("//div[@class='btn-group pull-right dropdown']/a[@class='btn btn-default btn-sm']/i"));
			  ListIterator<WebElement> iterator = list.listIterator();
			  Logger.info("list size"+list.size());
			  if(list.size()>0)
			  {
				 WebElement element = driver.findElement(By.xpath("("+path+")["+index+"]"));
				 element.click();
				 Logger.info("recent order edit button is clicked");
			  }
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }
	  
//code to click on the more options button on the recently placed order
	  public void clickOnMoreOptionRecentOrder(int index) throws Exception
	  {
		  String path = "//div[@class='btn-group pull-right dropdown']/a[@class='btn btn-default btn-sm dropdown-toggle']/i";
		  try{
			  List<WebElement> list = driver.findElements(By.xpath(path));
			  ListIterator<WebElement> iterator = list.listIterator();
			  Logger.info("list size"+list.size());
			  if(list.size()>0)
			  {
				 WebElement element = driver.findElement(By.xpath("("+path+")["+index+"]"));
				 element.click();
				 Logger.info("recent order more options button is clicked");
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
	   * @throws Exception
	   * @description - This method clicks on the more button below recent orders list
	   */
	  public void clickOnMoreRecentOrders() throws Exception
	  {
		  try{
			  if(moreRecentOrdersButton.isDisplayed())
			  {
				  moreRecentOrdersButton.click();
				  Logger.info("More button for the recent orders is clicked");
			  }
			  else{
				  Logger.info("More button is not displayed for recent orders");
			  }
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }
	  
	  
//code to click on kill recent order option
	  public void killRecentOrder() throws Exception
	  {
		  try{
			  if(killRecentOrderBtn.isDisplayed()){
				  killRecentOrderBtn.click();
				  Logger.info("recent order kill button ic clicked");
			  }
			  else{
				  Logger.info("kill recent order button is not visible");
			  }
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }
	  
//code to click on copy recent order button 
	  public void copyRecentOrder() throws Exception
	  {
		  try{
			  if(copyRecentOrderBtn.isDisplayed()){
				  copyRecentOrderBtn.click();
				  Logger.info("recent order copy button ic clicked");
			  }
			  else{
				  Logger.info("copy recent order button is not visible");
			  }
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  } 
	  
//code to click on new order button
	  public void clickOnNewOrder() throws Exception
	  {
		  try{
			  if(customerNewOrderLink.isDisplayed())
			  {
				  customerNewOrderLink.click();
				  Logger.info("New order button is clicked");
			  }
			  else{
				  Logger.info("new order button is not visible");
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
	   * @return Customer's CUNumber
	   * @description This method reads the customers CU number in customer Profile page and return the value
	   */
	  public String getCustomerCUNumber() throws Exception
	  {
		  try
		  {
			  String cUNumber = "";
			  if(customerCUNumber.isDisplayed())
			  {
			   cUNumber = customerCUNumber.getText();
		       return cUNumber;
			  }
			  else{
				  return cUNumber;
			  }
		  }
			  catch(Exception e)
			  {
				  Logger.error(e.getMessage());
				  throw e;
			  } 
	  }
	  
	  public String getCustomerMDMNumber() throws Exception
	  {
		  try
		  {
			  String cUNumber = "";
			  if(customerMDMNumber.isDisplayed())
			  {
			   cUNumber = customerMDMNumber.getText();
		       return cUNumber;
			  }
			  else{
				  return cUNumber;
			  }
		  }
			  catch(Exception e)
			  {
				  Logger.error(e.getMessage());
				  throw e;
			  } 
	  }
	
//code to validate if new product is added to the pricing groups tab
	public void validateNewProductAddition(String productType, String Product, String pricingGroup) throws Exception
	{
		String rowsPath = "//div[2]/table/tbody/tr[@class='ng-scope']"; 
		List<WebElement> allRows = driver.findElements(By.xpath(rowsPath));
		for (int rowIndex=0; rowIndex<allRows.size(); rowIndex++)
	       {
	    	  WebElement productElement = driver.findElement(By.xpath(rowsPath + "/td[text()='" + properties.getProperty(productType).toString() + "']/../td[2]")) ;
		    	   if(productElement.getText().equalsIgnoreCase(Product))
		    	   {
	    			   Assert.assertEquals(Product, productElement.getText());
		    	   }
			    	WebElement productPricingGroup = driver.findElement(By.xpath(rowsPath + "/td[contains(text(),'" + properties.getProperty(productType).toString() + "')]/../td[contains(text(),'" +Product+ "')]/../td[3]"));
			    	if(productPricingGroup.getText().equalsIgnoreCase(properties.getProperty(pricingGroup).toString()))
			    	{
			    		Assert.assertEquals(properties.getProperty(pricingGroup).toString(), productPricingGroup.getText());
			    	}
	       }
		Logger.info("Product addition is validated successfully");
	}
	
//code to validate the address
	public void validateAddress(Map<String, String> userData) throws Exception
		{
		 //verification of street address
			
	       if(custProfileStreetAddress.isDisplayed())
	       {
	    	   Assert.assertEquals(userData.get("StreetAddress").toString()+ " " +userData.get("Street2Address").toString()
	    			   				, custProfileStreetAddress.getText());
	    	   Logger.error("street adrress is validated");
	       }
	       else
	       {
	    	   Logger.error("street adrress is not displayed");
	       }
	       
	       //verification if the address is made primary
	       if(primaryAdrress.isDisplayed())
			{
				Logger.info("Address is made primary");
			}
			else
			{
				Logger.info("Primary button was not selected hence the address is not primary");
			}
	       
	       //Verification of optional street address , city, state and ZIP code 
	       String expectedStreetAddress = userData.get("City").toString() + ", " +
	    		   						  userData.get("State").toString() + " " +
	    		   						  userData.get("Zip").toString() + 
	    		   						  " US";
	       if(custProfileCityStateZipAddres.isDisplayed())
	       {
	    	   Assert.assertEquals(expectedStreetAddress, custProfileCityStateZipAddres.getText());
	    	   Logger.error("optional adrress is validated");
	       }
	       else
	       {
	    	   Logger.info("Optional address is not displayed");
	       }
	      
	       //Verification of the address type
	       if(custProfileAddressType.isDisplayed())
	       {
	    	   Assert.assertEquals(userData.get("AddressType"), custProfileAddressType.getText());
	    	   Logger.error("address type is validated");
	       }
	       else
	       {
	    	   Logger.info("Address type is not displayed");
	       }
	       
	       //Verification of the phone number
	       if(custProfilePhoneNumber.isDisplayed())
	       {
	    	   Assert.assertEquals(userData.get("PhoneNumber"), custProfilePhoneNumber.getText());
	    	   Logger.error("phone number is validated");
	       }
	       else
	       {
	    	   Logger.info("phone number is not dispalyed");
	       }
	       
	       //Code to validate fax custProfileFax
	       if(custProfileFax.isDisplayed())
	       {
	    	   Assert.assertEquals(userData.get("Fax"), custProfileFax.getText());
	    	   Logger.error("fax is validated");
	       }
	       else
	       {
	    	   Logger.info("fax is not dispalyed");
	       }
	       
	       //Code to validate email address
	       if(custProfileEmail.isDisplayed())
	       {
	    	   Assert.assertEquals(userData.get("Email"), custProfileEmail.getText());
	    	   Logger.error("Email is validated");
	       }
	       else
	       {
	    	   Logger.info("Email is not dispalyed");
	       }
	    }

	public String activeInactiveCustomer() {
		String Active = "";
		try {
		//partha	
			if(activeInactiveCheckBox.getAttribute("class").contains("ng-not-empty")) {
				//Actions ele = new Actions(driver);
				//ele.moveToElement(activeInactiveCheckBox).click().build().perform();
				//activeInactiveCheckBox.click();
				activeInactiveCheckBoxClick.click();
				Logger.info("InActive button was checked,Activated the cutomer");
				 Active="yes";	
			}
			else if(activeInactiveCheckBox.getAttribute("class").contains("ng-empty")){
				activeInactiveCheckBoxClick.click();
				Logger.info("InActive button was not checked, Inactivated the customer");
				 Active="no";
			}
		} catch (Exception e) {
			Logger.info(e.getMessage());
		}
		return Active;
	}//swagata

	public void clickHistoryCustomerProfile() {
		try {
			driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.elementToBeClickable(historyButton));
		historyButton.click();
		Logger.info("History button is clicked");

			
		} catch (Exception e) {
			Logger.info(e.getMessage());
		}
		
	} //swagata
	public void verifyCustomerHistory(int index , String status) throws Exception
	{
		try{
			
			WebElement activityInfo = driver.findElement(By.xpath("//ol[@class='historydetails list-group']/li["+index+"]//span[@class='caret']"));
			activityInfo.click();
		
				//List<WebElement> statusInfo = driver.findElements(By.xpath("(//div//span[text()='INFO']//following::div)["+index+"]//ol"));
				//partha
			List<WebElement> statusInfo = driver.findElements(By.xpath("//li[contains(text(),'Active')]"));
				String  loggedStatus= "";
				Logger.info("Size is:"+statusInfo.size());
				for(int i=0;i<statusInfo.size();i++){
					loggedStatus =loggedStatus+ statusInfo.get(i).getText();
				
					}
				//Partha
				Logger.info("Logged status: "+loggedStatus);
				if(status.equalsIgnoreCase(loggedStatus.trim()))
				{
				Logger.info("Logged status is as expected");
				}
				//Assert.assertEquals(status,loggedStatus.trim());
								
				
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata

	public void customerInactiveStatus() {
		if (inactiveStatus.isDisplayed()) {
			Logger.info("Customer is inactivated");
			
		}
		else
		Logger.info("Customer is activated");	
	}//swagata
}
