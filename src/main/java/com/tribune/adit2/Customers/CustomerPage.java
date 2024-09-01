package com.tribune.adit2.Customers;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Customers Page
 * @author Priyanka Goud CR 
 * @since October 2015
 */

public class CustomerPage
{
	@FindBy(id = "businessUnitId")
	public WebElement businessUnitDropDown;
	
	@FindBy(id = "customerName")
	public WebElement customerNameTextBox;
	
	@FindBy(id = "billingTypeId")
	public WebElement billingTypeDropDown;
	
	@FindBy(id = "accountTypeId")
	public WebElement accountTypeDropDown;
	
	@FindBy(id = "customerCategoryId")
	public WebElement categoryDropDown;
	
	@FindBy(id = "customerSubCategoryId")
	public WebElement subCategoryDropDown;
	
	@FindBy(id = "creditStatus")
	public WebElement creditStatusTextBox;
	
	@FindBy(id = "riskCode")
	public WebElement riskCodeTextBox;
	
	@FindBy(id = "zipCode")
	public WebElement zipTextBox;
	
	@FindBy (xpath = "//span/b[@class='ng-binding']")
	public WebElement autoSuggestionCustID;
	
	@FindBy (xpath = "//span[@class='text-info ng-binding']")
	public List<WebElement> autoSuggestionCustName;
	
	@FindBy (id = "btnSearch")
	public WebElement customerSearchBtn;
	
	@FindBy (xpath = "//div[@class='input-group w-full autocomplete-field']/input")
	public WebElement customerSearchBox;
	
	@FindBy (id = "resultCustomerCount")
	public WebElement resultsFound;
	
	@FindBy (xpath = "//*[@id='customer-list-page']/div/div[3]/a")
	public WebElement newCustomerBtn;
	
	@FindBy (xpath = "//a[text()='Delete CCPA Info']")
	public WebElement deleteCCPAbutton;
	
	@FindBy (xpath = "//label[text()='Request ID']/following-sibling::input")
	public WebElement requestID;
	
	@FindBy (xpath = "//label[text()='Requester Name']/following-sibling::input")
	public WebElement requesterName;
	
	@FindBy (xpath = "//button[text()='Ok']")
	public WebElement okButton;
	
	@FindBy (xpath = "(//div[@class='panel-heading b-b b-light clearfix']//span)[2]")
	public WebElement customerStatus;
	
	@FindBy (xpath = "//div[@class='panel-heading b-b b-light clearfix']//b")
	public WebElement customerNameUpdated;
	
	@FindBy (xpath = "(//div[@class='panel-heading b-b b-light clearfix']//h4)[1]")
	public WebElement customerID;
	
	@FindBy (xpath = "//*[contains(text(),'Alternative Name')]/following-sibling::dd[1]")
	public WebElement altenativeName;
	
	@FindBy (xpath = "//*[contains(text(),'Terms Email')]/following-sibling::dd[1]")
	public WebElement termsEmail;
	
	@FindBy (xpath = "//div[@class='contact-name']/b")
	public WebElement addressContactName;
	
	@FindBy (xpath = "//div[@class='contact-name']/following-sibling::div")
	public WebElement addressFirst;
	
	@FindBy (xpath = "//div[@class='contact-name']/following-sibling::div/following-sibling::div")
	public WebElement addressSecond;
	
	@FindBy (xpath = "//div[@ng-if='address.Email']")
	public WebElement addressEmail;
	
	@FindBy (xpath = "//div[@ng-if='address.Email']/following-sibling::div")
	public WebElement addressPhone;
	
	@FindBy (xpath = "//div[@ng-if='address.Email']/following-sibling::div/following-sibling::div")
	public WebElement addressFax;
	
	@FindBy (xpath = "//*[@id='accountTypeId']")//mou
	public WebElement AccountTypeSelectDropDown;//mou
	
	private WebDriver driver;
	
	Properties properties = TribuneUtils.readProperties();
	
	public CustomerPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
// Code to select the value from the Business Unit drop Drown
	public void selectBU(String BU) throws Exception
	  {
		 
		  try
		  {
			  if (businessUnitDropDown.isDisplayed())
			  {
				  businessUnitDropDown.click();
				  Logger.info("Business Unit drop down is clicked");
			      Select valueFromBU = new Select(businessUnitDropDown);
			      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
			      if(listOfValuesBU.size() !=0)
				      {
				    	 valueFromBU.selectByVisibleText(BU);
				         Logger.info("business Unit is selected"); 
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
	
// Code to enter the Customer Name for search criteria
	  
	  public void enterCustomerName(String customerName) throws Exception
	  {
		  try
		  {
			  if (customerNameTextBox.isDisplayed())
			  {
				  Logger.info("Customer Name text box is visible");
				  customerNameTextBox.click();
				  customerNameTextBox.clear();
				  customerNameTextBox.sendKeys(customerName);
				  Logger.info(customerName+" customer Name is entered");
			  }
			  else
			  {
				  Logger.info("Customer Name TextBox is not displayed");
				  throw new NoSuchElementException("Customer Name TextBox is not displayed");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  }    
	  }

// Code to get the customer name from data provider
	  
	  public void getCustomerName(Map<String,String> userData) throws Exception
		{
			try 
			{
				enterCustomerName(userData.get("CustomerName").toString());	
			} 
			catch (Exception e) 
			{
				throw e;
			}
		}
	  public void  setCustomerName(int row, int col) throws Exception
		{
			
				String value = TribuneUtils.getStringCellValues("CustomerInfo",row, col);
				try 
				{
					enterCustomerName(value);	
				} 
				catch (Exception e) 
				{
					throw e;
				}
		}
	  public void inputCustomerName(String customer) throws Exception
			{
				try 
				{
					enterCustomerName(customer);	
				} 
				catch (Exception e) 
				{
					throw e;
				}
			}

// Code to select the billing type
	  public void selectBillingType(String billingType) throws Exception
	  {
		  try
		  {
			  if (billingTypeDropDown.isDisplayed())
			  {
				  billingTypeDropDown.click();
				  Logger.info("Billing Type drop down is clicked");
			      Select valueFromBillingType = new Select(billingTypeDropDown);
			      List<WebElement> listOfBillingTypeValues = valueFromBillingType.getOptions();
			      if(listOfBillingTypeValues.size() !=0)
				      {
				    	 Logger.info("List of Billing Type is not empty"); 
				         valueFromBillingType.selectByVisibleText(properties.getProperty(billingType));
				         Logger.info(billingType + " billing type is selected"); 
				      }
			  }
			  else
			  {
				  Logger.info("Billing Type drop down is not displayed");
				  throw new NoSuchElementException("Billing Type drop down is not displayed");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  } 

// Code to select Account Type
	  public void selectAccountType(String accountType) throws Exception
	  {
		  try
		  {
			  if (accountTypeDropDown.isDisplayed())
			  {
				  accountTypeDropDown.click();
				  Logger.info("Account Type drop down is clicked");
			      Select valueFromAccountType = new Select(accountTypeDropDown);
			      List<WebElement> listOfAccountTypeValues = valueFromAccountType.getOptions();
			      if(listOfAccountTypeValues.size() !=0)
				      {
				    	 Logger.info("List of account type is not empty"); 
				         valueFromAccountType.selectByVisibleText(properties.getProperty(accountType));
				         Logger.info(accountType + " account type is selected"); 
				      }
			  }
			  else
			  {
				  Logger.info("Account Type drop down is not displayed");
				  throw new NoSuchElementException("Account Type drop down is not displayed");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }  

// Code to select Category
		  public void selectCategory(String Category) throws Exception
		  {
			  try
			  {
				  if (categoryDropDown.isDisplayed())
				  {
					  categoryDropDown.click();
					  Logger.info("Category drop down is clicked in Order Entry Home Page");
				      Select valueFromCategory = new Select(categoryDropDown);
				      List<WebElement> listOfCategories = valueFromCategory.getOptions();
				      if(listOfCategories.size() !=0)
					      {
					    	 Logger.info("List of Category is not empty"); 
					         valueFromCategory.selectByVisibleText(properties.getProperty(Category));
					         Logger.info(Category + " Category is selected"); 
					      }
				  }
				  else
				  {
					  Logger.info("Category drop down is not displayed");
					  throw new NoSuchElementException("Category drop down is not displayed");
				  }
				
			  }
			  catch(Exception e)
			  {
				  
				  Logger.error(e.getMessage());
				  throw e;
			  } 
		  }  

// Code to select SubCategory
		  public void selectSubCategory(String subCategory) throws Exception
		  {
			  try
			  {
				  if (subCategoryDropDown.isDisplayed())
				  {
					  subCategoryDropDown.click();
					  Logger.info("Sub Category drop down is clicked in Order Entry Home Page");
				      Select valueFromSubCategory = new Select(subCategoryDropDown);
				      List<WebElement> listOfSubCategories = valueFromSubCategory.getOptions();
				      if(listOfSubCategories.size() !=0)
					      {
					    	 Logger.info("List of Sub Category is not empty"); 
					         valueFromSubCategory.selectByVisibleText(properties.getProperty(subCategory));
					         Logger.info(subCategory + " Category is selected"); 
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

// Code to enter Credit Status
		  public void enterCreditStatus(String creditStatus) throws Exception
		  {
			  try
			  {
				  if (creditStatusTextBox.isDisplayed())
				  {
					  Logger.info("Credit Status text box is visible");
					  creditStatusTextBox.click();
					  creditStatusTextBox.clear();
					  creditStatusTextBox.sendKeys(properties.getProperty(creditStatus));
					  Logger.info("Credit Status is entered");
				  }
				  else
				  {
					  Logger.info("Credit Status TextBox is not displayed");
					  throw new NoSuchElementException("Credit Status TextBox is not displayed");
				  }
				
			  }
			  catch(Exception e)
			  {
				  Logger.error(e.getMessage());
				  throw e;
			  }    
		  }	 


//Code to enter risk Code
		  public void enterRiskCode(String riskCode) throws Exception
		  {
			  try
			  {
				  if (riskCodeTextBox.isDisplayed())
				  {
					  Logger.info(" Risk Code text box is visible");
					  riskCodeTextBox.click();
					  riskCodeTextBox.clear();
					  riskCodeTextBox.sendKeys(properties.getProperty(riskCode));
					  Logger.info("Risk Code TextBox is entered");
				  }
				  else
				  {
					  Logger.info("Risk code TextBox is not displayed");
					  throw new NoSuchElementException("Risk Code TextBox is not displayed");
				  }
				
			  }
			  catch(Exception e)
			  {
				  Logger.error(e.getMessage());
				  throw e;
			  }    
		  }	  
		  
//Code to enter the ZIP
		  public void enterZip(String zip) throws Exception
		  {
			  try
			  {
				  if (zipTextBox.isDisplayed())
				  {
					  Logger.info(" Zip text box is visible");
					  zipTextBox.click();
					  zipTextBox.clear();
					  zipTextBox.sendKeys(zip);
					  Logger.info("Zip code is entered");
				  }
				  else
				  {
					  Logger.info("Zip TextBox is not displayed");
					  throw new NoSuchElementException("Zip TextBox is not displayed");
				  }
				
			  }
			  catch(Exception e)
			  {
				  Logger.error(e.getMessage());
				  throw e;
			  }    
		  }	  

// Code to get the customer name from data provider
		  
		  public void getZipCode(Map<String,String> userData) throws Exception
			{
				try 
				{
					enterZip(userData.get("zipCode").toString());	
				} 
				catch (Exception e) 
				{
					Logger.error(e.getMessage());
					  throw e;
				}
			}

//code to search customer through search box using the AX reference or CU number number
		  public void searchCustomerByCUNumber(String searchCriteria) throws Exception
		  {
			  try
			  {
				  if(customerSearchBox.isDisplayed())
				  {
					  customerSearchBox.click();
					  customerSearchBox.clear();
					  customerSearchBox.sendKeys(searchCriteria);
					  WebDriverWait wait = new WebDriverWait(driver, 120);
					  wait.until(ExpectedConditions.visibilityOf(autoSuggestionCustID));
					  autoSuggestionCustID.click();
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
		  
		  public void deleteCCPA() throws Exception
		  {
			  TribuneUtils utils = new TribuneUtils();
			  try
			  {
				  WebDriverWait wait = new WebDriverWait(driver,120); 
			      wait.until(ExpectedConditions.visibilityOf(deleteCCPAbutton));
				  if(deleteCCPAbutton.isDisplayed())
				  {
					  deleteCCPAbutton.click();
					  Logger.info("deleteCCPAbutton is clicked");					 
				      wait.until(ExpectedConditions.visibilityOf(requestID));
				      requestID.click();
				      requestID.clear();
				      requestID.sendKeys(utils.generateRandomNumString(4));
				      requesterName.click();
				      requesterName.clear();
				      requesterName.sendKeys(utils.generateRandomString(10));
				      okButton.click();
				  }
				  else{
					  Logger.info("deleteCCPAbutton is not avilable");
				  }
			  }
			  catch(Exception e)
			  {
				  Logger.error(e.getMessage());
				  throw e;
			  }
		  }
		  
		  public void verifyCustomerInactivated() throws Exception
		  {
			  try
			  {
				  WebDriverWait wait = new WebDriverWait(driver,120); 
			      wait.until(ExpectedConditions.visibilityOf(customerStatus));
				  if(customerStatus.isDisplayed())
				  {	
					  Assert.assertEquals(customerStatus.getText(), "Inactive");
					  Logger.info("customer status : "+customerStatus.getText());
					  Assert.assertEquals(customerNameUpdated.getText(), "Privacy Act");
					  Logger.info("customerNameUpdated : "+customerNameUpdated.getText());
					  Logger.info("customer Name with ID: "+customerID.getText());
					  Assert.assertEquals(altenativeName.getText(), "XXXX");
					  Logger.info("altenativeName: "+altenativeName.getText());
					  Assert.assertEquals(termsEmail.getText(), "XXXX@test.com");
					  Logger.info("termsEmail: "+termsEmail.getText());
					  Assert.assertEquals(addressContactName.getText(), "XXXX");
					  Logger.info("addressContactName: "+addressContactName.getText());
					  Assert.assertEquals(addressFirst.getText(), "XXXX XXXX");
					  Logger.info("addressFirst: "+addressFirst.getText());
					  Assert.assertEquals(addressSecond.getText(), "XXXX, None 00000 US");
					  Logger.info("addressSecond: "+addressSecond.getText());
					  Assert.assertEquals(addressEmail.getText(), "XXXX@test.com");
					  Logger.info("addressEmail: "+addressEmail.getText());
					  Assert.assertEquals(addressPhone.getText(), "(000) 000-0000");
					  Logger.info("addressPhone: "+addressPhone.getText());
					  Assert.assertEquals(addressFax.getText(), "XXXX");
					  Logger.info("addressFax: "+addressFax.getText());
				  }
				  else{
					  Logger.info("deleteCCPAbutton is not avilable");
				  }
			  }
			  catch(Exception e)
			  {
				  Logger.error(e.getMessage());
				  throw e;
			  }
		  }


		  
//code to click on the customer name after searching through the search box
		  public void clickOnCustomerLinkSearchBox(String customerCUNum) throws Exception
		  {
			  try
			  {
				  WebElement customerLink = driver.findElement(By.xpath("//span/b[text()='"+customerCUNum+"']"));
				  if(customerLink.isDisplayed())
				  {
					  customerLink.click();
					  Logger.info(customerCUNum+" customer is searched");
				  }
				  else{
					  Logger.info(customerCUNum+" customer is not avilable");
				  }
			  }
			  catch(Exception e)
			  {
				  Logger.error(e.getMessage());
				  throw e;
			  }
		  }
//code to search customer through search box using customer name
		  public void searchCustomerByNameSearchbox(String searchCriteria) throws Exception
		  {
			  try
			  {
				  if(customerSearchBox.isDisplayed())
				  {
					  customerSearchBox.click();
					  customerSearchBox.clear();
					  customerSearchBox.sendKeys(searchCriteria);
					  WebDriverWait wait = new WebDriverWait(driver,20);
					  wait.until(ExpectedConditions.visibilityOfAllElements(autoSuggestionCustName));
					  Iterator<WebElement> iterator = autoSuggestionCustName.iterator();
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
		  
//Code to click on the Search button
		  public void clickOnCustomersSearchBtn() throws Exception
		  {
			  try
			  {
				  if (customerSearchBtn.isDisplayed())
				  {
					  customerSearchBtn.click();
					  Logger.info("Search button is clicked in Customers page");
				  }
				  else
				  {
					  Logger.info("Search button is not displayed in customers page");
					  throw new NoSuchElementException("Search button is not displayed in customers page");
				  }
				
			  }
			  catch(Exception e)
			  {
				  Logger.error(e.getMessage());
				  throw e;
			  } 
		  }	

		//Code to click on the New Customer button
		  public void clickOnNewCustomerBtn() throws Exception
		  {
			  try
			  {
				  if (newCustomerBtn.isDisplayed())
				  {
					  newCustomerBtn.click();
					  Logger.info("New Customer button is clicked in Customers page");
				  }
				  else
				  {
					  Logger.info("New Customer button is not displayed in customers page");
					  throw new NoSuchElementException("New Customer button is not displayed in customers page");
				  }
				
			  }
			  catch(Exception e)
			  {
				  Logger.error(e.getMessage());
				  throw e;
			  } 
		  }	  
// Code to click on the customer name link
	public void clickOnCustomerLink(Map<String, String> userData, String customer) throws Exception
	{
		try
		  {
			
			  WebElement customerLink = driver.findElement(By.linkText(userData.get(""+customer).toString()));
			  WebDriverWait wait = new WebDriverWait(driver, 20);
			  wait.until(ExpectedConditions.visibilityOf(customerLink));
			  
			  if (customerLink.isDisplayed())
			  {
				  customerLink.click();
				  Logger.info("Customer link is clicked in Customers page");
			  }
			  else
			  {
				  Logger.info("Customer link is not displayed in customers page");
				  throw new NoSuchElementException("Customer link is not displayed in customers page");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}	  
	
	public void clickOnCustomerLink1(String customer) throws Exception
	{
		try
		  {
			
			  WebElement customerLink = driver.findElement(By.linkText((""+customer)));
			  WebDriverWait wait = new WebDriverWait(driver, 20);
			  wait.until(ExpectedConditions.visibilityOf(customerLink));
			  
			  if (customerLink.isDisplayed())
			  {
				  customerLink.click();
				  Logger.info("Customer link is clicked in Customers page");
			  }
			  else
			  {
				  Logger.info("Customer link is not displayed in customers page");
				  throw new NoSuchElementException("Customer link is not displayed in customers page");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}	  
	
//Code to get the count of the results found after search operation
	public String getCountOfCustomerSearchResults() throws Exception
	{
		String result;
		try
		  {
			  if (resultsFound.isDisplayed())
			  {
				result = resultsFound.getText();
			  }
			  else
			  {
				  Logger.info("count of the results is not displayed");
				  throw new NoSuchElementException("count of the results is not displayed");
			  }
		  }
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  }
		return result;
		
	}
	
	public void selectAccountTypeSearch(String accountType) throws Exception
	  {
		  try
		  {
			  if (AccountTypeSelectDropDown.isDisplayed())
			  {
				  AccountTypeSelectDropDown.click();
				  Logger.info("Account Type drop down is clicked");
			      Select valueFromAccountType = new Select(accountTypeDropDown);
			      List<WebElement> listOfAccountTypeValues = valueFromAccountType.getOptions();
			      if(listOfAccountTypeValues.size() !=0)
				      {
				    	 Logger.info("List of account type is not empty"); 
				         valueFromAccountType.selectByVisibleText(accountType);
				         Logger.info(accountType + " account type is selected"); 
				      }
			  }
			  else
			  {
				  Logger.info("Account Type drop down is not displayed");
				  throw new NoSuchElementException("Account Type drop down is not displayed");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }  //mou
	public void selectAgencyCustomer() throws Exception
	  {
		  try
		  {
			  
			      
			      List<WebElement> webElements = driver.findElements(By.xpath("//table[@class='table table-striped b-t b-light']/tbody/tr/td[count(//table[@class='table table-striped b-t b-light']/thead/tr/th[text()=\"Name\"]/preceding-sibling::th)+1]//a"));
					webElements.get(0).click();
					WebElement agencymap = driver.findElement(By.xpath("//a[text()='Agency Mapping']"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",  agencymap);
					//Thread.sleep(2000);
					if(agencymap.isDisplayed())
					{
						agencymap.click();
						Logger.info("Agency Mapping Tab is present");
					}
					else{
						Logger.info("Agency Mapping Tab is not present");
					}
				}
					

		  
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
}//mou
}
