package com.tribune.adit2.Customers;

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

import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Customers Page
 * @author Priyanka Goud CR 
 * @since October 2015
 */

public class EditCustomerPage 
{
  @FindBy (xpath = "/h1[text()='Edit Customer']")
  public WebElement pageHeading;
  
  @FindBy (id = "companyName")
  public WebElement name;
  
  @FindBy (id = "billingType")
  public WebElement billingType;
  
  @FindBy (xpath = "//label[text()='Business Unit']/../div/button")
  public WebElement bussinesUnit;
  
  @FindBy (id = "alternativeName")
  public WebElement alternativeName;
  
  @FindBy (id = "accountTypeId")
  public WebElement accountType;
  
  @FindBy (id = "categoryId")
  public WebElement category;
  
  @FindBy (id = "website")
  public WebElement website;
  
  @FindBy (id = "couponCode")
  public WebElement couponCode;
  
  @FindBy (id = "subCategoryId")
  public WebElement subCategory;
  
  @FindBy (id = "tags")
  public WebElement tags;
  
  @FindBy (id = "tearsheetRequested")
  public WebElement tearsheetCheckbox;
  
  @FindBy (id = "taxExempt")
  public WebElement taxExemptCheckbox;     
  
  @FindBy (id = "applySpoilage")
  public WebElement applySpoilageCheckbox;
  
  @FindBy (id = "isOrderConfirmationRequired")
  public WebElement orderConfirmationCheckbox; 
  
  @FindBy (id = "autoCommission")
  public WebElement autoCommissionCheckbox;
  
  @FindBy (linkText = "Supplemental Data")
  public WebElement supplementalDataTab;
  
  @FindBy (linkText = "Customer Groups")
  public WebElement customerGroupsTab;
  
  @FindBy (linkText = "Pricing Groups")
  public WebElement pricingGroupsTab;
  
  @FindBy (linkText = "Legacy System Data")
  public WebElement legacySystemDataTab;
  
  @FindBy (xpath = "//button[text()='Save']")
  public WebElement saveButton;
  
  @FindBy(xpath = "//a[@ng-click='saveGeneralInfo()']")
  public WebElement saveGeneralInfo;//swagata
  @FindBy (xpath = "//button[text()='Cancel']")
  public WebElement cancelButton;
  
  @FindBy (id = "companyRevalue")
  public WebElement revenueTextbox;
  
  @FindBy (id = "proof")
  public WebElement proofTextBox;
  
  @FindBy (id = "numOfEmployee")
  public WebElement numOfEmployeeTextbox;
  
  @FindBy (id = "numOflocations")
  public WebElement numOfLocationsTextbox;
  
  @FindBy (id = "infoUsaNum")
  public WebElement infoUSANumTextbox;
  
  @FindBy (id = "isPIRequired")
  public WebElement poRequiredTextbox;
  
  @FindBy (id = "IsSelfServiceLocAllowed")
  public WebElement selfServiceLOCAllowedTextbox;
  
  @FindBy (id = "notes")
  public WebElement noteTextArea;
  
  @FindBy (xpath = "//a[contains(text(),'Edit')]/i[@class='glyphicon glyphicon-pencil']")
 public WebElement editCustomerDetailsLink;//swagata
  @FindBy(xpath ="//select[@ng-model='customerEdit.AccountTypeID']")
	public WebElement accountTypeDropDown;//swagata
  @FindBy (xpath = "//a[text()='Delete CCPA Info']")
	public WebElement deleteCCPAbutton;
  @FindBy (xpath = "//*[@id='toast-container']/div/div[1]/button")
  public WebElement closeOrderSubmissionMessage;
  
	private WebDriver driver;


	Properties properties = TribuneUtils.readProperties();


	public EditCustomerPage(WebDriver driver)
	{
		this.driver = driver;
	}
//Code to check Account Type
	public void AccountTypeCheck(String accountType) throws Exception
	{					
		int flag=0;
		
		try
		{
			if (accountTypeDropDown.isDisplayed())
			{
				accountTypeDropDown.click();
				Logger.info("Account Type drop down is clicked");
				Select valueFromAccountType = new Select(accountTypeDropDown);
				List<WebElement> listOfAccountTypeValues = valueFromAccountType.getOptions();
				for(WebElement ele :listOfAccountTypeValues){
				      if (ele.getText().contains(accountType)){
				         flag=1;
				         break;
				         }
						Logger.info(accountType + " account type is not there"); 
						}
			}
			else
			{
				Logger.info("Account Type drop down is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	} //swagata
	// Code to click on the customer edit link
		public void clickOnCustProfileEdit() throws Exception
		{
			try
			  {
				WebDriverWait wait = new WebDriverWait(driver, 60);

				 
				  wait.until(ExpectedConditions.visibilityOf(editCustomerDetailsLink));
				  
				  if (editCustomerDetailsLink.isDisplayed())
				  {
					  editCustomerDetailsLink.click();
					  Logger.info("Customer Profile edit link is clicked in Customers page");
				  }
				  else
				  {
					  Logger.info("Customer Profile edit link is not displayed in customers page");
					  throw new NoSuchElementException(" Customer Profile edit link is not displayed in customers page");
				  }
				
			  }
			  catch(Exception e)
			  {
				  Logger.error(e.getMessage());
				  throw e;
			  } 
		}//swagata	
		// Code to click on the customer save link
				public void clickOnCustProfileSave() throws Exception
				{
					try
					  {
						WebDriverWait wait = new WebDriverWait(driver, 60);

						 
						  wait.until(ExpectedConditions.visibilityOf(saveGeneralInfo));
						  
						  if (saveGeneralInfo.isDisplayed())
						  {
							  JavascriptExecutor executor = (JavascriptExecutor)driver;
						  executor.executeScript("arguments[0].click();", saveGeneralInfo);
							 wait.until(ExpectedConditions.elementToBeClickable(closeOrderSubmissionMessage));
				 
					 
						  closeOrderSubmissionMessage.click();
						  Thread.sleep(1000);
					 
							  saveGeneralInfo.click();
							  Logger.info("Customer Profile save link is clicked in Customers page");
							  wait.until(ExpectedConditions.elementToBeClickable(deleteCCPAbutton));
							  
						  }
						  else
						  {
							  Logger.info("Customer Profile save link is not displayed in customers page");
							  throw new NoSuchElementException(" Customer Profile save link is not displayed in customers page");
						  }
						
					  }
					  catch(Exception e)
					  {
						  Logger.error(e.getMessage());
						  throw e;
					  } 
				}//swagata	
}
