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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Customers Page
 * @author Sunny Mukherjee
 * @since May 2017
 */

public class CustomerCreatePage
{
	@FindBy(id = "businessUnitId")
	public WebElement businessUnitDropDown;

	@FindBy(id = "companyName")
	public WebElement customerNameTextBox;

	@FindBy(id = "Select1")
	public WebElement billingTypeDropDown;

	@FindBy(id = "customerType")
	public WebElement billingTypeDropDown1;

	@FindBy(id = "accountTypeId")
	public WebElement accountTypeDropDown;

	@FindBy(id = "categoryId")
	public WebElement categoryDropDown;

	@FindBy(id = "subCategoryId")
	public WebElement subCategoryDropDown;

	@FindBy(id = "termsEmail")
	public WebElement termsEmailTextBox;

	@FindBy(id = "Text8")
	public WebElement termsEmailTextBox1;

	@FindBy(xpath = "//label[text()='Tearsheet Requested']/i")
	public WebElement tearsheetCheckBox;

	@FindBy(xpath = "//*[@id='taxExempt']/../i")
	public WebElement taxExemptCheckBox;

	@FindBy(xpath = "//input[@id='isOrderConfirmationRequired']/../i")
	public WebElement isOrderConfirmationRequiredCheckBox;

	@FindBy(xpath = "//input[@id='autoCommission']/../i")
	public WebElement autoCommissionCheckBox;

	@FindBy(xpath = "//label[text()='Auto Agency Commission']/i")
	public WebElement autoCommissionCheckBox1;

	@FindBy(xpath = "//label[@title='CondensedStatement']/i")
	public WebElement cndnsdStmntCheckBox;

	@FindBy(xpath = "//input[@id='applySpoilage']/../i")
	public WebElement applySpoilageCheckBox;

	@FindBy (xpath = "//*[@id='app']/div[3]/div[2]/div[2]/div[2]/div/div/ul/li[1]/a")
	public WebElement supplementalDataSection;

	@FindBy (xpath = "//*[@id='app']/div[3]/div[2]/div[2]/div[2]/div/div/ul/li[2]/a")
	public WebElement businessUnitMappingSection;

	@FindBy (xpath = "//*[@id='app']/div[3]/div[2]/div[2]/div[2]/div/div/ul/li[7]/a")
	public WebElement financeSection;

	@FindBy (xpath = "//*[@id='financialData']/div/div[1]/a[3]")
	public WebElement collectorSection;

	@FindBy (xpath = "//*[@id='financialData']/div/div[1]/a[2]")
	public WebElement creditSection;

	@FindBy(id = "companyRevalue")
	public WebElement companyRevenueTextBox;

	@FindBy(id = "numOfEmployee")
	public WebElement numOfEmployeeTextBox;

	@FindBy(id = "numOflocations")
	public WebElement numOflocationsTextBox;

	@FindBy(id = "Text6")
	public WebElement dunsNumTextBox;

	@FindBy(id = "infoUsaNum")
	public WebElement infoUsaNumTextBox;

	@FindBy(id = "proof")
	public WebElement proofDropDown;

	@FindBy(xpath = "//input[@id='isPIRequired']/../i")
	//@FindBy(id = "isPIRequired")
	public WebElement isPORequiredCheckBox;


	@FindBy(id = "isPIRequired")
	public WebElement isPORequiredCheckBox1;

	@FindBy(xpath = "//input[@id='IsSelfServiceLocAllowed']/../i")
	//@FindBy(id = "IsSelfServiceLocAllowed")
	public WebElement IsSelfServiceLocAllowedCheckBox;

	@FindBy(id = "notes")
	public WebElement notesTextBox;

	//	@FindBy (xpath = "//*[@id='app']/div[3]/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/button")
	@FindBy (xpath = "//button[text()='New Address']")//swagata
	public WebElement newAddressBtn;

	@FindBy (xpath = "//*[@id='new_order']")
	public WebElement newOrderBtn;

	@FindBy(id = "contactName")
	public WebElement contactNameTextBox;

	@FindBy(id = "streetLine")
	public WebElement addressTextBox;

	@FindBy(id = "addressTypeId")
	public WebElement addressTypeIdDropDown;

	@FindBy(id = "state")
	public WebElement stateDropDown;

	@FindBy(id = "Select1")
	public WebElement countryDropDown;

	@FindBy(id = "city")
	public WebElement cityTextBox;

	@FindBy(id = "zipCode")
	public WebElement zipCodeTextBox;

	@FindBy(id = "phoneNumber")
	public WebElement phoneNumberTextBox;

	@FindBy(id = "faxNumber")
	public WebElement faxNumberTextBox;

	@FindBy(id = "emailAddress")
	public WebElement emailAddressTextBox;

	@FindBy(id = "additionalEmail")
	public WebElement additionalEmailTextBox;

	@FindBy(id = "streetLine2")
	public WebElement address2TextBox;

	@FindBy(xpath = "//input[@id='isPrimary']/../i")
	//@FindBy(id = "isPrimary")
	public WebElement isPrimaryCheckBox;

	@FindBy (id = "btnSaveAddress")
	public WebElement saveBtn;

	@FindBy(xpath ="//input[@id = 'alternativeName']")
	public WebElement alternativeName;

	@FindBy(id = "website")
	public WebElement websiteTextBox;

	@FindBy(id = "couponCode")
	public WebElement couponCodeTextBox;

	@FindBy (xpath = "//*[@id='financialData']/div/div[5]/a")
	public WebElement saveCreditStatusBtn;

	@FindBy (xpath = "//*[@id='app']/div[3]/div[2]/div[1]/div/div[2]/button")
	public WebElement saveNewCustomerBtn;
	
	
	@FindBy (xpath = "//a[contains(text(),'Edit')]/i")
	public WebElement EditCustomerBtn;
	
	
	@FindBy (xpath = "//label[@title='CreativeFee-OptOut']")
	public WebElement CreativeFeeOptOutCust;

	@FindBy (xpath = "//a[text()='Save']")
	public WebElement saveNewCustomerBtn1;

	@FindBy (xpath = "//a[text()='Edit']")
	public WebElement editCustomerBtn;	

	@FindBy(id = "address-contactname")
	public WebElement addressContactNameTextBox;

	@FindBy(id = "address-line1")
	public WebElement addressline1TextBox;

	@FindBy(id = "address-email")
	public WebElement addressemailTextBox;

	@FindBy(id = "address-city")
	public WebElement addresscityTextBox;

	@FindBy(id = "address-state")
	public WebElement addressstate;

	@FindBy(id = "address-phone")
	public WebElement addressphone;

	@FindBy (xpath = "html/body/div[1]/div/div/div/div[3]/button[1]")
	public WebElement nextBtn;	

	@FindBy (xpath = "//input[@ng-model='vm.declineSelected']")
	public WebElement declineMatchCheckBox;

	@FindBy (xpath = "//select[@ng-model='vm.reason']/option[@selected='selected']")
	public WebElement declineReasonDropdownSelectedOption;

	@FindBy (xpath = "//select[@ng-model='vm.reason']")//mousumi
	public WebElement declineReasonDropdown;

	@FindBy (xpath = "//button[@ng-click='vm.decline()']") 
	public WebElement selectBtn;

	@FindBy (xpath = "//select[@ng-disabled='!updateCreditStatus']") 
	public WebElement statusList;//mousumi

	@FindBy (xpath = "//*[@id='Span21']") 
	public WebElement statusElement;//mousumi

	//@FindBy(xpath= "//button[@title='Click to De-Activate']")
	//partha
	@FindBy(xpath ="//i[@class='glyphicon glyphicon-thumbs-down']")
	public WebElement deActivateAddressButton;//swagata
	//@FindBy(xpath ="//button[@title='Click to Activate']")
	//Partha
	@FindBy(xpath= "//i[@class='glyphicon glyphicon-thumbs-up']")
	public WebElement activateAddressButton;//swagata

	@FindBy(xpath = "//div[@id='toast-container']/div[contains(text(),'success')]")
	public WebElement activeDeactivateSuccessMsg;//swagata

	@FindBy(xpath = "//div[contains(@class,'title')]")
	public WebElement saveSuccessfulMsg;//swagata
	@FindBy (xpath = "//dt[text()='Account Standing:']//following-sibling::dd//a[contains(@editable-select,'CustAccountStanding')]//span[contains(@class,'shorten ng-binding')]")
	public WebElement accountStandingDropDown;//swagata

	@FindBy (xpath = "//select[@ng-disabled='isFinancialData']")
	public WebElement accountStandingDropDownElement;//swagata
	@FindBy (xpath = "//div[@class='toast-message']/div")
	public WebElement errorMsg;//swagata
	@FindBy (xpath = "//textarea[@placeholder='Account Standing Value']")
	public WebElement enterCommentOtherTextBox;

	private WebDriver driver;


	Properties properties = TribuneUtils.readProperties();


	public CustomerCreatePage(WebDriver driver)
	{
		this.driver = driver;
	}

	public void selectCustomerGroup(String BU, String CustomerGroup) throws Exception
	{

		try
		{
			WebElement custgroup = driver.findElement(By.xpath("//td[text()='"+BU+"']/../td[3]/a/span"));
			if (custgroup.isDisplayed())
			{
				custgroup.click();
				Thread.sleep(2000);
				WebElement custgroupDropdown = driver.findElement(By.xpath("//td[text()='"+BU+"']/../td[3]/form/div/select"));
				custgroupDropdown.click();
				Logger.info("custgroupDropdown is clicked");
				Select valueFromBU = new Select(custgroupDropdown);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					valueFromBU.selectByVisibleText(CustomerGroup);
					Logger.info("CustomerGroup is selected"); 
				}
				else
				{
					Logger.info("CustomerGroup is empty");
				}
			}
			else
			{
				Logger.info("custgroupDropdown is not displayed");
				throw new NoSuchElementException("custgroupDropdown is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectBusinessUnitMapping(String bu) throws Exception
	{
		try
		{
			WebElement cust = driver.findElement(By.xpath("//td[text()='"+bu+"']"));
			if (cust.isDisplayed())
			{
				cust.click();
				Logger.info("Business Unit Mapped in Customers page");
			}
			else
			{
				Logger.info("Business Unit Mapped is not displayed in customers page");
				throw new NoSuchElementException("Business Unit Mapped is not displayed in customers page");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	


	public void clickOnbusinessUnitMappingSection() throws Exception
	{

		Thread.sleep(4000); 

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		try
		{
			if (businessUnitMappingSection.isDisplayed())
			{
				businessUnitMappingSection.click();
				Logger.info("businessUnitMappingSection is clicked in Customers page");
			}
			else
			{
				Logger.info("businessUnitMappingSection is not displayed in customers page");
				throw new NoSuchElementException("businessUnitMappingSection is not displayed in customers page");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	

	public void clickOnFinanceSection() throws Exception
	{

		Thread.sleep(4000); 

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		try
		{
			if (financeSection.isDisplayed())
			{
				financeSection.click();
				Logger.info("financeSection is clicked in Customers page");
			}
			else
			{
				Logger.info("financeSection is not displayed in customers page");
				throw new NoSuchElementException("financeSection is not displayed in customers page");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	

	public void clickOnCreditSection() throws Exception
	{

		Thread.sleep(4000); 

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		try
		{
			if (creditSection.isDisplayed())
			{
				creditSection.click();
				Logger.info("creditSection is clicked in Customers page");
			}
			else
			{
				Logger.info("creditSection is not displayed in customers page");
				throw new NoSuchElementException("creditSection is not displayed in customers page");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	

	public void clickOnCollectorSection() throws Exception
	{

		Thread.sleep(4000); 

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		try
		{
			if (collectorSection.isDisplayed())
			{
				collectorSection.click();
				Logger.info("collectorSection is clicked in Customers page");
			}
			else
			{
				Logger.info("collectorSection is not displayed in customers page");
				throw new NoSuchElementException("collectorSection is not displayed in customers page");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	

	public void  selectRiskCode(String code) throws Exception
	{
		try
		{
			WebElement statusElement = driver.findElement(By.xpath("(//*[@id='Select10'])[4]"));
			statusElement.click();
			WebElement statusList = driver.findElement(By.xpath("(//*[@id='Select10'])[4]"));
			Select selectstatus= new Select(statusList);
			List<WebElement> listOfValuesstatus = selectstatus.getOptions();
			if(listOfValuesstatus.size() !=0)
			{
				selectstatus.selectByVisibleText(code);
				Logger.info(code+" risk code is selected"); 
			}
			else
			{
				Logger.info("drop down is empty");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void  selectCreditStatus(String status) throws Exception
	{
		try
		{
			//WebElement statusElement = driver.findElement(By.xpath("//*[@id='Span21']"));//mousumi
			statusElement.click();
			WebDriverWait wait=new WebDriverWait(driver, 20);
			//WebElement statusList = driver.findElement(By.xpath("//select[@ng-disabled='!updateCreditStatus']"));//mousumi
			Select selectstatus= new Select(statusList);
			List<WebElement> listOfValuesstatus = selectstatus.getOptions();
			if(listOfValuesstatus.size() !=0)
			{
				selectstatus.selectByVisibleText(status);
				Logger.info(status+" credit status is selected"); 
			}
			else
			{
				Logger.info("drop down is empty");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickOnselectBtn() throws Exception
	{
		try
		{
			if (selectBtn.isDisplayed())
			{
				selectBtn.click();
				Logger.info("selectBtn is clicked in Customers page");
			}
			else
			{
				Logger.info("selectBtn is not displayed in customers page");
				throw new NoSuchElementException("selectBtn is not displayed in customers page");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	


	public void selectDeclineReason(String BU) throws Exception
	{

		try
		{
			if (declineReasonDropdown.isDisplayed())
			{
				declineReasonDropdown.click();
				Logger.info("declineReasonDropdown is clicked");
				Select valueFromBU = new Select(declineReasonDropdown);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					valueFromBU.selectByVisibleText(BU);
					Logger.info("Decline Reason is selected"); 
				}
				else
				{
					Logger.info("Decline Reason is empty");
				}
			}
			else
			{
				Logger.info("declineReasonDropdown is not displayed");
				throw new NoSuchElementException("declineReasonDropdown is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void verifyDeclineReasonNoMatch() throws Exception
	{
		try
		{
			if (declineReasonDropdown.isDisplayed())
			{
				Logger.info("declineReasonDropdown is visible");
				//				  String name = declineReasonDropdownSelectedOption.getAttribute("value");				  
				//				  Logger.info(name+" : decline reason found in declineReasonDropdown");
				//				  Assert.assertEquals(name, "string:No Match Found");
			}
			else
			{
				Logger.info("declineReasonDropdown is not displayed");
				throw new NoSuchElementException("declineReasonDropdown is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}


	public void clickOndeclineMatchCheckBox() throws Exception
	{
		try
		{
			if (declineMatchCheckBox.isDisplayed())
			{
				declineMatchCheckBox.click();
				Logger.info("declineMatchCheckBox is clicked in Customers page");
			}
			else
			{
				Logger.info("declineMatchCheckBox is not displayed in customers page");
				throw new NoSuchElementException("declineMatchCheckBox is not displayed in customers page");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	

	public void selectCustomerDeails(String customerName) throws Exception
	{
		try
		{
			WebElement cust = driver.findElement(By.xpath("//div[text()='"+customerName+"']"));
			if (cust.isDisplayed())
			{
				cust.click();
				Logger.info("customer address is clicked in Customers page");
			}
			else
			{
				Logger.info("customer address is not displayed in customers page");
				throw new NoSuchElementException("customer address is not displayed in customers page");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	

	public void clickOnNextBtn() throws Exception
	{
		try
		{
			if (nextBtn.isDisplayed())
			{
				nextBtn.click();
				Logger.info("nextBtn is clicked in Customers page");
			}
			else
			{
				Logger.info("nextBtn is not displayed in customers page");
				throw new NoSuchElementException("nextBtn is not displayed in customers page");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	

	public void verifyaddressphone(String address) throws Exception
	{
		try
		{
			if (addressphone.isDisplayed())
			{
				Logger.info("addressphone is visible");
				String name = addressphone.getAttribute("value");				  
				Logger.info(name+" : address phone found in addressphoneTextBox");
				Assert.assertEquals(name, address);
			}
			else
			{
				Logger.info("addressphone is not displayed");
				throw new NoSuchElementException("addressphone	 is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}


	public void verifyaddressstate(String address) throws Exception
	{
		try
		{
			if (addressstate.isDisplayed())
			{
				Logger.info("addressstate is visible");
				String name = addressstate.getAttribute("value");				  
				Logger.info(name+" : address state found in addressstateTextBox");
				Assert.assertEquals(name, address);
			}
			else
			{
				Logger.info("addressstate is not displayed");
				throw new NoSuchElementException("addressstate is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}

	public void verifyaddresscityTextBox(String address) throws Exception
	{
		try
		{
			if (addresscityTextBox.isDisplayed())
			{
				Logger.info("addresscityTextBox is visible");
				String name = addresscityTextBox.getAttribute("value");				  
				Logger.info(name+" : address city found in addresscityTextBox");
				Assert.assertEquals(name, address);
			}
			else
			{
				Logger.info("addresscityTextBox is not displayed");
				throw new NoSuchElementException("addresscityTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}



	public void verifyaddressemailTextBox(String address) throws Exception
	{
		try
		{
			if (addressemailTextBox.isDisplayed())
			{
				Logger.info("addressemailTextBox is visible");
				String name = addressemailTextBox.getAttribute("value");				  
				Logger.info(name+" : address email found in addressemailTextBox");
				Assert.assertEquals(name, address);
			}
			else
			{
				Logger.info("addressemailTextBox is not displayed");
				throw new NoSuchElementException("addressemailTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}

	public void verifyaddressline1TextBox(String address) throws Exception
	{
		try
		{
			if (addressline1TextBox.isDisplayed())
			{
				Logger.info("addressline1TextBox is visible");
				String name = addressline1TextBox.getAttribute("value");				  
				Logger.info(name+" : address line1 found in addressline1TextBox");
				Assert.assertEquals(name, address);
			}
			else
			{
				Logger.info("addressline1TextBox is not displayed");
				throw new NoSuchElementException("addressline1TextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}

	public void verifyaddressContactNameTextBox(String address) throws Exception
	{
		try
		{
			if (addressContactNameTextBox.isDisplayed())
			{
				Logger.info("addressContactNameTextBox is visible");
				String name = addressContactNameTextBox.getAttribute("value");				  
				Logger.info(name+" : name found in addressContactNameTextBox");
				Assert.assertEquals(name, address);
			}
			else
			{
				Logger.info("addressContactNameTextBox is not displayed");
				throw new NoSuchElementException("addressContactNameTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}

	public void clickOnCustomerSaveBtn() throws Exception
	{

		Thread.sleep(4000); 

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

		try
		{
			if (saveNewCustomerBtn.isDisplayed())
			{
				saveNewCustomerBtn.click();
				Logger.info("saveNewCustomerBtn is clicked in Customers page");
			}
			else
			{
				Logger.info("saveNewCustomerBtn is not displayed in customers page");
				throw new NoSuchElementException("saveNewCustomerBtn is not displayed in customers page");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	
	
	public void CustomerCreativeFeeOptout(String CustId) throws Exception
	{
		
		Thread.sleep(4000); 
		EditCustomerBtn.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", CreativeFeeOptOutCust);

		try
		{
			if (CreativeFeeOptOutCust.isDisplayed())
			{
				CreativeFeeOptOutCust.click();
				Logger.info("CreativeFeeOptOutCust is clicked in Customers page");
			}
			else
			{
				Logger.info("CreativeFeeOptOutCust is not displayed in customers page");
				throw new NoSuchElementException("CreativeFeeOptOutCust is not displayed in customers page");
			}
			Thread.sleep(2000);
			clickOnCustomerSaveBtn1();
			Thread.sleep(10000);

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	

	public void clickOnCustomerSaveBtn1() throws Exception
	{

		Thread.sleep(4000); 

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

		try
		{
			if (saveNewCustomerBtn1.isDisplayed())
			{
				saveNewCustomerBtn1.click();
				Logger.info("saveNewCustomerBtn is clicked in Customers page");
			}
			else
			{
				Logger.info("saveNewCustomerBtn is not displayed in customers page");
				throw new NoSuchElementException("saveNewCustomerBtn is not displayed in customers page");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	
	public void clickOnCreditStatusSaveBtn() throws Exception
	{

		Thread.sleep(4000); 

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

		try
		{
			if (saveCreditStatusBtn.isDisplayed())
			{
				saveCreditStatusBtn.click();
				Logger.info("saveCreditStatusBtn is clicked in Customers page");
				WebDriverWait wait = new WebDriverWait(driver, 300);//swagata
				wait.until(ExpectedConditions.visibilityOf(saveSuccessfulMsg));//swagata
				Logger.info("Changes are saved successfully");//swagata

			}
			else
			{
				Logger.info("saveCreditStatusBtn is not displayed in customers page");
				throw new NoSuchElementException("saveCreditStatusBtn is not displayed in customers page");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	
	public void clickOnCustomerEditBtn() throws Exception
	{

		Thread.sleep(4000); 

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

		try
		{
			if (editCustomerBtn.isDisplayed())
			{
				editCustomerBtn.click();
				Logger.info("editCustomerBtn is clicked in Customers page");
			}
			else
			{
				Logger.info("editCustomerBtn is not displayed in customers page");
				throw new NoSuchElementException("editCustomerBtn is not displayed in customers page");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	

	public void entercouponCodeTextBox(String address) throws Exception
	{
		try
		{
			if (couponCodeTextBox.isDisplayed())
			{
				Logger.info("couponCodeTextBox is visible");
				couponCodeTextBox.click();
				couponCodeTextBox.clear();
				couponCodeTextBox.sendKeys(address);
				Logger.info(address+" couponCode is entered");
			}
			else
			{
				Logger.info("couponCodeTextBox is not displayed");
				throw new NoSuchElementException("couponCodeTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}


	public void enterwebsiteTextBox(String address) throws Exception
	{
		try
		{
			if (websiteTextBox.isDisplayed())
			{
				Logger.info("websiteTextBox is visible");
				websiteTextBox.click();
				websiteTextBox.clear();
				websiteTextBox.sendKeys(address);
				Logger.info(address+" website is entered");
			}
			else
			{
				Logger.info("websiteTextBox is not displayed");
				throw new NoSuchElementException("websiteTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}


	public void enteralternativeNameTextBox(String address) throws Exception
	{
		try
		{
			if (alternativeName.isDisplayed())
			{
				Logger.info("alternativeName is visible");
				alternativeName.click();
				alternativeName.clear();
				alternativeName.sendKeys(address);
				Logger.info(address+" alternativeName is entered");
			}
			else
			{
				Logger.info("alternativeName is not displayed");
				throw new NoSuchElementException("alternativeName is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}

	public void clickOnSaveBtn() throws Exception
	{
		try
		{
			if (saveBtn.isDisplayed())
			{
				saveBtn.click();
				Logger.info("saveBtn is clicked in Customers page");
			}
			else
			{
				Logger.info("saveBtn is not displayed in customers page");
				throw new NoSuchElementException("saveBtn is not displayed in customers page");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	

	public void enteraddress2TextBox(String address) throws Exception
	{
		try
		{
			if (address2TextBox.isDisplayed())
			{
				Logger.info("address2TextBox is visible");
				address2TextBox.click();
				address2TextBox.clear();
				address2TextBox.sendKeys(address);
				Logger.info(address+" address2 is entered");
			}
			else
			{
				Logger.info("additionalEmailTextBox is not displayed");
				throw new NoSuchElementException("additionalEmailTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}

	public void isPrimaryCheckBoxPresenceValidation() throws Exception
	{

		try
		{
			if (isPrimaryCheckBox.isDisplayed())
			{

				Logger.info("isPrimaryCheckBox present");
				WebElement isCheckboxDiabled= driver.findElement(By.xpath("//input[@id='isPrimary']"));
				String type = isCheckboxDiabled.getAttribute("disabled");
				Logger.info(type);
				Assert.assertEquals(type, "true");
				Logger.info("isPrimaryCheckBox disabled");

			}
			else
			{
				Logger.info("isPrimaryCheckBox is not displayed");
				throw new NoSuchElementException("isPrimaryCheckBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void enteradditionalEmailTextBox(String address) throws Exception
	{
		try
		{
			if (additionalEmailTextBox.isDisplayed())
			{
				Logger.info("additionalEmailTextBox is visible");
				additionalEmailTextBox.click();
				additionalEmailTextBox.clear();
				additionalEmailTextBox.sendKeys(address);
				Logger.info(address+" additional email num is entered");
			}
			else
			{
				Logger.info("additionalEmailTextBox is not displayed");
				throw new NoSuchElementException("additionalEmailTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}

	public void enteremailAddressTextBox(String address) throws Exception
	{
		try
		{
			if (emailAddressTextBox.isDisplayed())
			{
				Logger.info("emailAddressTextBox is visible");
				emailAddressTextBox.click();
				emailAddressTextBox.clear();
				emailAddressTextBox.sendKeys(address);
				Logger.info(address+" email num is entered");
			}
			else
			{
				Logger.info("emailAddressTextBox is not displayed");
				throw new NoSuchElementException("emailAddressTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}

	public void enterfaxNumberTextBox(String address) throws Exception
	{
		try
		{
			if (faxNumberTextBox.isDisplayed())
			{
				Logger.info("faxNumberTextBox is visible");
				faxNumberTextBox.click();
				faxNumberTextBox.clear();
				faxNumberTextBox.sendKeys(address);
				Logger.info(address+" fax num is entered");
			}
			else
			{
				Logger.info("faxNumberTextBox is not displayed");
				throw new NoSuchElementException("faxNumberTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}

	public void enterphoneNumberTextBox(String address) throws Exception
	{
		try
		{
			if (phoneNumberTextBox.isDisplayed())
			{
				Logger.info("phoneNumberTextBox is visible");
				phoneNumberTextBox.click();
				phoneNumberTextBox.clear();
				phoneNumberTextBox.sendKeys(address);
				Logger.info(address+" phone num is entered");
			}
			else
			{
				Logger.info("phoneNumberTextBox is not displayed");
				throw new NoSuchElementException("phoneNumberTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}


	public void enterzipCodeTextBox(String address) throws Exception
	{
		try
		{
			if (zipCodeTextBox.isDisplayed())
			{
				Logger.info("zipCodeTextBox is visible");
				zipCodeTextBox.click();
				zipCodeTextBox.clear();
				zipCodeTextBox.sendKeys(address);
				Logger.info(address+" zip is entered");
			}
			else
			{
				Logger.info("zipCodeTextBox is not displayed");
				throw new NoSuchElementException("zipCodeTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}


	public void entercityTextBox(String address) throws Exception
	{
		try
		{
			if (cityTextBox.isDisplayed())
			{
				Logger.info("cityTextBox is visible");
				cityTextBox.click();
				cityTextBox.clear();
				cityTextBox.sendKeys(address);
				Logger.info(address+" city is entered");
			}
			else
			{
				Logger.info("cityTextBox is not displayed");
				throw new NoSuchElementException("cityTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}

	public void selectCountry(String BU) throws Exception
	{

		try
		{
			if (countryDropDown.isDisplayed())
			{
				countryDropDown.click();
				Logger.info("countryDropDown is clicked");
				Select valueFromBU = new Select(countryDropDown);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					valueFromBU.selectByVisibleText(BU);
					Logger.info("Country is selected"); 
				}
				else
				{
					Logger.info("countryDropDown is empty");
				}
			}
			else
			{
				Logger.info("countryDropDown is not displayed");
				throw new NoSuchElementException("countryDropDown is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectState(String BU) throws Exception
	{

		try
		{
			if (stateDropDown.isDisplayed())
			{
				stateDropDown.click();
				Logger.info("stateDropDown is clicked");
				Select valueFromBU = new Select(stateDropDown);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					valueFromBU.selectByVisibleText(BU);
					Logger.info("State is selected"); 
				}
				else
				{
					Logger.info("stateDropDown is empty");
				}
			}
			else
			{
				Logger.info("stateDropDown is not displayed");
				throw new NoSuchElementException("stateDropDown is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void enteraddressTextBox(String address) throws Exception
	{
		try
		{
			if (addressTextBox.isDisplayed())
			{
				Logger.info("addressTextBox is visible");
				addressTextBox.click();
				addressTextBox.clear();
				addressTextBox.sendKeys(address);
				Logger.info(address+" address is entered");
			}
			else
			{
				Logger.info("addressTextBox is not displayed");
				throw new NoSuchElementException("addressTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}

	public void selectAddressType(String BU) throws Exception
	{

		try
		{
			if (addressTypeIdDropDown.isDisplayed())
			{
				addressTypeIdDropDown.click();
				Logger.info("addressTypeIdDropDown is clicked");
				Select valueFromBU = new Select(addressTypeIdDropDown);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					valueFromBU.selectByVisibleText(BU);
					Logger.info("Address Type is selected"); 
				}
				else
				{
					Logger.info("drop down is empty");
				}
			}
			else
			{
				Logger.info("addressTypeIdDropDown is not displayed");
				throw new NoSuchElementException("addressTypeIdDropDown is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void entercontactName(String customerName) throws Exception
	{
		try
		{
			if (contactNameTextBox.isDisplayed())
			{
				Logger.info("contactNameTextBox is visible");
				contactNameTextBox.click();
				contactNameTextBox.clear();
				contactNameTextBox.sendKeys(customerName);
				Logger.info(customerName+" contactName is entered");
			}
			else
			{
				Logger.info("contactNameTextBox is not displayed");
				throw new NoSuchElementException("contactNameTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}

	public void clickOnNewAddressBtnBtn() throws Exception
	{
		try
		{
			WebDriverWait wait =new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(newAddressBtn));
			if (newAddressBtn.isDisplayed())
			{
				newAddressBtn.click();
				Logger.info("newAddressBtn is clicked in Customers page");
			}
			else
			{
				Logger.info("newAddressBtn is not displayed in customers page");
				throw new NoSuchElementException("newAddressBtn is not displayed in customers page");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	

	public void clickOnNewOrderBtn() throws Exception
	{
		try
		{
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
			if (newOrderBtn.isDisplayed())
			{
				newOrderBtn.click();
				Logger.info("newOrderBtn is clicked in Customers page");
			}
			else
			{
				Logger.info("newOrderBtn is not displayed in customers page");
				throw new NoSuchElementException("newOrderBtn is not displayed in customers page");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}	

	public void notesTextBox() throws Exception
	{

		try
		{
			if (notesTextBox.isDisplayed())
			{

				Logger.info("notesTextBox present");

			}
			else
			{
				Logger.info("notesTextBox is not displayed");
				throw new NoSuchElementException("notesTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void enterNotesText() throws Exception
	{

		try
		{
			if (notesTextBox.isDisplayed())
			{

				Logger.info("notesTextBox present");
				notesTextBox.sendKeys("AutoTest Order");
				Logger.info("notes entered");
			}
			else
			{
				Logger.info("notesTextBox is not displayed");
				throw new NoSuchElementException("notesTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void IsSelfServiceLocAllowedCheckBoxPresenceValidation() throws Exception
	{

		try
		{
			if (IsSelfServiceLocAllowedCheckBox.isDisplayed())
			{

				Logger.info("IsSelfServiceLocAllowedCheckBox present");

			}
			else
			{
				Logger.info("IsSelfServiceLocAllowedCheckBox is not displayed");
				throw new NoSuchElementException("IsSelfServiceLocAllowedCheckBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void isPORequiredCheckBoxPresenceValidation() throws Exception
	{

		try
		{
			if (isPORequiredCheckBox.isDisplayed())
			{

				Logger.info("isPORequiredCheckBox present");

			}
			else
			{
				Logger.info("isPORequiredCheckBox is not displayed");
				throw new NoSuchElementException("isPORequiredCheckBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void checkPORequiredCheckBox() throws Exception
	{

		try
		{
			if (isPORequiredCheckBox.isDisplayed())
			{

				Logger.info("isPORequiredCheckBox present");
				isPORequiredCheckBox1.click();

				Logger.info("isPORequiredCheckBox clicked");

			}
			else
			{
				Logger.info("isPORequiredCheckBox is not displayed");
				throw new NoSuchElementException("isPORequiredCheckBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void checkDefaultProofValue() throws Exception
	{

		Thread.sleep(4000); 

		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("window.scrollTo(0, -(document.body.scrollHeight));");

		js.executeScript("scroll(0,400)");
		try
		{
			if (proofDropDown.isDisplayed())
			{
				proofDropDown.click();
				Logger.info("proofDropDown is clicked");
				Select dropdown = new Select(proofDropDown);
				WebElement option = dropdown.getFirstSelectedOption();
				String text = option.getText();
				Logger.info("proofDropDown default value: "+text);
				Assert.assertEquals(text, "None");

			}
			else
			{
				Logger.info("proofDropDown is not displayed");
				throw new NoSuchElementException("proofDropDown is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void infoUsaNumTextBox() throws Exception
	{

		try
		{
			if (infoUsaNumTextBox.isDisplayed())
			{

				Logger.info("infoUsaNumTextBox present");

			}
			else
			{
				Logger.info("infoUsaNumTextBox is not displayed");
				throw new NoSuchElementException("infoUsaNumTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void dunsNumTextBox() throws Exception
	{

		try
		{
			if (dunsNumTextBox.isDisplayed())
			{

				Logger.info("dunsNumTextBox present");

			}
			else
			{
				Logger.info("dunsNumTextBox is not displayed");
				throw new NoSuchElementException("dunsNumTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void numOflocationsTextBox() throws Exception
	{

		try
		{
			if (numOflocationsTextBox.isDisplayed())
			{

				Logger.info("numOflocationsTextBox present");

			}
			else
			{
				Logger.info("numOflocationsTextBox is not displayed");
				throw new NoSuchElementException("numOflocationsTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void numOfEmployeeTextBox() throws Exception
	{

		try
		{
			if (numOfEmployeeTextBox.isDisplayed())
			{

				Logger.info("numOfEmployeeTextBox present");

			}
			else
			{
				Logger.info("numOfEmployeeTextBox is not displayed");
				throw new NoSuchElementException("numOfEmployeeTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void companyRevenueTextBoxPresenceValidation() throws Exception
	{

		try
		{
			if (companyRevenueTextBox.isDisplayed())
			{

				Logger.info("companyRevenueTextBox present");

			}
			else
			{
				Logger.info("companyRevenueTextBox is not displayed");
				throw new NoSuchElementException("companyRevenueTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	public void supplementalDataSectionPresenceValidation() throws Exception
	{

		try
		{
			if (supplementalDataSection.isDisplayed())
			{

				Logger.info("supplementalDataSection present");

			}
			else
			{
				Logger.info("supplementalDataSection is not displayed");
				throw new NoSuchElementException("supplementalDataSection is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	public void applySpoilageCheckBoxPresenceValidation() throws Exception
	{

		try
		{
			if (applySpoilageCheckBox.isDisplayed())
			{

				Logger.info("applySpoilageCheckBox present");

			}
			else
			{
				Logger.info("applySpoilageCheckBox is not displayed");
				throw new NoSuchElementException("applySpoilageCheckBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	public void autoCommissionCheckBoxPresenceValidation() throws Exception
	{

		try
		{
			if (autoCommissionCheckBox.isDisplayed())
			{

				Logger.info("autoCommissionCheckBox present");

			}
			else
			{
				Logger.info("autoCommissionCheckBox is not displayed");
				throw new NoSuchElementException("autoCommissionCheckBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void autoCommissionCheckBoxSelect() throws Exception
	{

		try
		{
			if (autoCommissionCheckBox1.isDisplayed())
			{

				try {

					Actions action = new Actions(driver);
					action.moveToElement(autoCommissionCheckBox1).click().build().perform();

					//autoCommissionCheckBox1.click();
					Logger.info("autoCommissionCheckBox1 selected");
				} catch (Exception e) {
					Logger.info("Try Waiting");		
					Thread.sleep(3000);
					autoCommissionCheckBox1.click();
					Logger.info("autoCommissionCheckBox1 selected");
				}


			}
			else
			{
				Logger.info("autoCommissionCheckBox1 is not displayed");
				throw new NoSuchElementException("autoCommissionCheckBox1 is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void condensedStmntCheckBoxSelect() throws Exception
	{

		try
		{
			if (cndnsdStmntCheckBox.isDisplayed())
			{

				try {

					Actions action = new Actions(driver);
					action.moveToElement(cndnsdStmntCheckBox).click().build().perform();

					//autoCommissionCheckBox1.click();
					Logger.info("cndnsdStmntCheckBox selected");
				} catch (Exception e) {
					Logger.info("Try Waiting");		
					Thread.sleep(3000);
					Actions action = new Actions(driver);
					action.moveToElement(cndnsdStmntCheckBox).click().build().perform();
					Logger.info("cndnsdStmntCheckBox selected");
				}


			}
			else
			{
				Logger.info("cndnsdStmntCheckBox is not displayed");
				throw new NoSuchElementException("cndnsdStmntCheckBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void isOrderConfirmationRequiredCheckBoxPresenceValidation() throws Exception
	{

		try
		{
			if (isOrderConfirmationRequiredCheckBox.isDisplayed())
			{

				Logger.info("isOrderConfirmationRequiredCheckBox present");

			}
			else
			{
				Logger.info("isOrderConfirmationRequiredCheckBox is not displayed");
				throw new NoSuchElementException("isOrderConfirmationRequiredCheckBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void taxExemptCheckBoxaPresencValidation() throws Exception
	{

		try
		{
			if (taxExemptCheckBox.isDisplayed())
			{

				Logger.info("taxExemptCheckBox present");

			}
			else
			{
				Logger.info("taxExemptCheckBox is not displayed");
				throw new NoSuchElementException("taxExemptCheckBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void tearsheetCheckBoxPresenceValidation() throws Exception
	{

		try
		{
			if (tearsheetCheckBox.isDisplayed())
			{

				Logger.info("tearsheetCheckBox present");

			}
			else
			{
				Logger.info("tearsheetCheckBox is not displayed");
				throw new NoSuchElementException("tearsheetCheckBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
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

	// Code to enter the Customer Name 

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

	public String getCustomerName() throws Exception
	{
		try
		{
			if (customerNameTextBox.isDisplayed())
			{
				Logger.info("Customer Name text box is visible");
				String customerName = customerNameTextBox.getAttribute("value");				 
				Logger.info(customerName+" customer Name has been found");
				return customerName;

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
	// Code to enter the Customer Name 

	public void enterTermsEmail(String email) throws Exception
	{
		try
		{
			if (termsEmailTextBox.isDisplayed())
			{
				Logger.info("Term's Email text box is visible");
				termsEmailTextBox.click();
				termsEmailTextBox.clear();
				termsEmailTextBox.sendKeys(email);
				Logger.info(email+" : Term's Email is entered");
			}
			else
			{
				Logger.info("Term's Email TextBox is not displayed");
				throw new NoSuchElementException("Term's EmailTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}    
	}

	public void enterTermsEmail1(String email) throws Exception
	{
		try
		{
			if (termsEmailTextBox1.isDisplayed())
			{
				Logger.info("Term's Email text box is visible");
				termsEmailTextBox1.click();
				termsEmailTextBox1.clear();
				termsEmailTextBox1.sendKeys(email);
				Logger.info(email+" : Term's Email is entered");
			}
			else
			{
				Logger.info("Term's Email TextBox is not displayed");
				throw new NoSuchElementException("Term's EmailTextBox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
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
					valueFromBillingType.selectByVisibleText((billingType));
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

	public void selectBillingType1(String billingType) throws Exception
	{
		try
		{
			if (billingTypeDropDown1.isDisplayed())
			{
				billingTypeDropDown1.click();
				Logger.info("Billing Type drop down is clicked");
				Select valueFromBillingType = new Select(billingTypeDropDown1);
				List<WebElement> listOfBillingTypeValues = valueFromBillingType.getOptions();
				if(listOfBillingTypeValues.size() !=0)
				{
					Logger.info("List of Billing Type is not empty"); 
					valueFromBillingType.selectByVisibleText((billingType));
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
					valueFromAccountType.selectByVisibleText((accountType));
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
		Thread.sleep(3000);
		try
		{
			if (categoryDropDown.isDisplayed())
			{
				Logger.info("Category drop down is displayed");
				//categoryDropDown.click();
				Logger.info("Category drop down is clicked in Order Entry Home Page");
				Select valueFromCategory = new Select(categoryDropDown);
				List<WebElement> listOfCategories = valueFromCategory.getOptions();
				if(listOfCategories.size() !=0)
				{
					Logger.info("List of Category is not empty"); 
					valueFromCategory.selectByVisibleText((Category));
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
				//subCategoryDropDown.click();
				Logger.info("Sub Category drop down is clicked in Order Entry Home Page");
				Select valueFromSubCategory = new Select(subCategoryDropDown);
				List<WebElement> listOfSubCategories = valueFromSubCategory.getOptions();
				if(listOfSubCategories.size() !=0)
				{
					Logger.info("List of Sub Category is not empty"); 
					valueFromSubCategory.selectByVisibleText((subCategory));
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

	public void clickToDeactivateAddress() throws Exception {
		WebDriverWait wait=new WebDriverWait(driver, 100);

		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(deActivateAddressButton));
			JavascriptExecutor js = (JavascriptExecutor) driver ;
			js.executeScript("arguments[0].scrollIntoView(true);", deActivateAddressButton);
			js.executeScript("arguments[0].click();", deActivateAddressButton);
			//deActivateAddressButton.click();
			//wait.until(ExpectedConditions.visibilityOf(activeDeactivateSuccessMsg));
			Thread.sleep(3000);
			if(activateAddressButton.isDisplayed()){
			Logger.info("Address is deactivated:" );
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}	

	}//swagata
	public void clickToactivateAddress() throws Exception {
		WebDriverWait wait=new WebDriverWait(driver, 100);

		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(activateAddressButton));
			JavascriptExecutor js = (JavascriptExecutor) driver ;
			js.executeScript("arguments[0].click();", activateAddressButton);
			Thread.sleep(3000);
			//activateAddressButton.click();
			//wait.until(ExpectedConditions.visibilityOf(activeDeactivateSuccessMsg));
			if(deActivateAddressButton.isDisplayed()){
			Logger.info("Address is activated:" );
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}	

	}//swagata

	// Code to select Account Standing
	public void selectAccountStanding(String accountType) throws Exception
	{
		try
		{
			if (accountStandingDropDown.isDisplayed())
			{
				accountStandingDropDown.click();
				Logger.info("Account standing drop down is clicked");
				accountStandingDropDownElement.click();
				Select valueFromAccountType = new Select(accountStandingDropDownElement);
				List<WebElement> listOfAccountTypeValues = valueFromAccountType.getOptions();
				if(listOfAccountTypeValues.size() !=0)
				{
					Logger.info("List of account standing is not empty"); 
					valueFromAccountType.selectByVisibleText(accountType);
					Logger.info(accountType + " account type is selected"); 
				}
			}
			else
			{
				Logger.info("Account standing drop down is not displayed");
				throw new NoSuchElementException("Account standing drop down is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata

	public String errorMsgChecking() {
		String errorMsgText="";
		if(errorMsg.isDisplayed()) {

			 errorMsgText =errorMsg.getText();
			Logger.info(errorMsgText);
		}
		return errorMsgText;			
	}//swagata

	public void enterCommentInOtherTextBox() {
	try {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(enterCommentOtherTextBox));
		enterCommentOtherTextBox.sendKeys("test");
		Logger.info("Comment is entered in the other text box");
	} catch (Exception e) {
		Logger.error(e.getMessage());
		throw e;
	}
		
	}  //swagata

	


}
