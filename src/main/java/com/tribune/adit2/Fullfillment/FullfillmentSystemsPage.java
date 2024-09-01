package com.tribune.adit2.Fullfillment;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Fullfillment Systems Page
 * @author Priyanka Goud CR 
 * @since June 2016
 */

public class FullfillmentSystemsPage 
{

	@FindBy(xpath = "//a[text()='New']")
	public WebElement newIntegrationSystemsBtn;
	
	@FindBy (id = "name")
	public WebElement nameOfFullfillmentSystem;
	
	@FindBy (id = "description")
	public WebElement descriptionOfFullfillmentSystem;
	
	@FindBy (id = "sequence")
	public WebElement sequenceOfFullfillmentSystem;
	
	@FindBy (xpath = "//input[@ng-model='vm.system.AbortOnExceptions']/../i")
	public WebElement abortOnExceptionsCheckBox;
	
	@FindBy (xpath = "//button[contains(text(),'Save')]/i")
	public WebElement saveFullfillmentSystem;
	
	@FindBy (id = "bu")
	public WebElement selectBusinessUnit;
	
	@FindBy (xpath = "//button[@ng-click = 'vm.toggleSystemStatus()']")
	public WebElement FullfillmentSystemStatus;
	
	@FindBy(xpath = "//div[@id='fullfillment-systems-menu']//input")
	public WebElement searchBoxFullfillmentSystem;
	
	@FindBy (xpath = "//div[@class='toast-message']/div")
	public WebElement fullfillmentSystemStatusChangeMessage;
	
	@FindBy (xpath = "//button[@class='toast-close-button']")
	public WebElement fullfillmentSystemStatusChangeMessageClose;
	
	@FindBy (xpath = "//i[text()='Create']")
	public WebElement createButton;
	
	@FindBy (xpath = "//input[@ng-model='vm.transformer.IsFtp']/../i")
	public WebElement useFTPCheckbox;
	
	@FindBy (id = "ftp-server")
	public WebElement ftpServerTextBox; 
	
	@FindBy (id = "ftp-path")
	public WebElement ftpPathTextBox; 
	
	@FindBy (id = "ftp-username")
	public WebElement ftpUsernameTextBox;
	
	@FindBy (id = "ftp-password")
	public WebElement ftpPasswordTextBox;
	
	@FindBy (id = "file-path")
	public WebElement filePathTextBox;
	
	@FindBy (id = "ftp-dtkf")
	public WebElement daysToKeepFilesTextBox;
	
	@FindBy (xpath = "//input[@ng-model='vm.transformer.IsDLLPlugin']/../i")
	public WebElement usePluginCheckbox;
	
	@FindBy (id = "Select1")
	public WebElement moduleNameDropDownList;
	
	@FindBy (xpath = "//div[@class='form-group row']//i[contains(text(),'Save')]")
	public WebElement saveServerDetailsButton;
	
	private WebDriver driver;
	
	Properties properties = TribuneUtils.readProperties();
	
	TribuneUtils utils  = new TribuneUtils();
	
	public FullfillmentSystemsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * @author cymkozalg6 - Priyanka
	 * @description This method clicks on New button to create a new integration system
	 */
	public void clickOnNewIntegrationSystemsBtn() throws Exception
	{
		try
		{
			if(newIntegrationSystemsBtn.isDisplayed())
			{
				newIntegrationSystemsBtn.click();
				Logger.info("Button to create a new integration system is clicked ");
			}
			else{
				Logger.info("Button to create a new integration system is not displayed");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}
	
	/**
	 * @description This method is used to enter the name of the fullfillment system
	 */
	public void enterNameOfFullfillmentSystem() throws Exception
	{
		try{
			if(nameOfFullfillmentSystem.isDisplayed())
			{
				nameOfFullfillmentSystem.click();
				String systemName = "Test_"+utils.generateRandomAlphaNumString(8);
				nameOfFullfillmentSystem.sendKeys(systemName);
				Logger.info(systemName +" is the name of the fullfillment system entered");
			}
			else{
				Logger.info("name of the fullfillment system is not displayed");
				}
			}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
			
		}
	
	/**
	 * @description This method is used to enter the description of the fullfillment system
	 */
	public void enterDescriptionOfFullfillmentSystem() throws Exception
	{
		try{
			if(descriptionOfFullfillmentSystem.isDisplayed())
			{
				descriptionOfFullfillmentSystem.click();
				descriptionOfFullfillmentSystem.sendKeys("Test_"+utils.generateRandomAlphaNumString(10));
				Logger.info("description of the fullfillment system is entered");
			}
			else{
				Logger.info("description of the fullfillment system is not displayed");
				}
			}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
			
		}
	
	/**
	 * @description This method is used to enter the sequence of the fullfillment system
	 */
	public void enterSequenceOfFullfillmentSystem() throws Exception
	{
		try{
			if(sequenceOfFullfillmentSystem.isDisplayed())
			{
				sequenceOfFullfillmentSystem.click();
				sequenceOfFullfillmentSystem.sendKeys("Test_"+utils.generateRandomAlphaNumString(1));
				Logger.info("sequence of the fullfillment system is entered");
			}
			else{
				Logger.info("sequence of the fullfillment system is not displayed");
				}
			}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
		}
	
	/**
	 * @description This method is used to check or uncheck the abort on exception check box
	 */
	public void checkUncheckAbortOnExceptions(boolean value) throws Exception
	{
		try{
			if(value)
			{
				if(abortOnExceptionsCheckBox.isSelected())	{
					Logger.info("abort on exceptions check box is already selected");
				}	
				else{
					abortOnExceptionsCheckBox.click();
					Logger.info("aboirt on exception text box is selected");
					}
				}
			else{
				if(abortOnExceptionsCheckBox.isSelected())	{
					abortOnExceptionsCheckBox.click();
					Logger.info("abort on exceptions check box is not selected");
				}	
				else{
					Logger.info("aboirt on exception text box is not selected");
					}
				}
			}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
		}
	/**
	 * @description This method is used to click on save button for saving fullfillment system
	 */
	public void clickOnSaveFullfillmentSystem() throws Exception
	{
		try{
			if(saveFullfillmentSystem.isDisplayed())
			{
				saveFullfillmentSystem.click();
				Logger.info("Fullfillment system is saved");
			}
			else
			{
				Logger.info("Fullfillment save button is not dispalyed");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}
	
	/**
	 * @description This method is used to select the business unit 
	 * @param business unit
	 */
	public void selectBusinessUnit(String bu) throws Exception
	{
		try
		{
			if(selectBusinessUnit.isDisplayed())
			{
				Select selectBU = new Select(selectBusinessUnit);
				selectBU.selectByVisibleText(properties.getProperty(bu));
				Logger.info("Business unit is selected from the drop down");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}
	
	/**
	 * @description This method is used to activate or deactivate a fullfillment system
	 * @param value (enter True/False to activate/deactivate the system)
	 */
	public void activateDeactivateFullfillmentSystem(boolean value) throws Exception
	{
		String statusMessage = "";
		if(FullfillmentSystemStatus.isDisplayed())
		{
			statusMessage = FullfillmentSystemStatus.getAttribute("uib-tooltip");
			if(value){
				if(statusMessage.contains("Click to activate"))
				{
					FullfillmentSystemStatus.click();
					Logger.info("Fullfillment system is activated");
				}
				else{
					Logger.info("Fullfillment system is already active");
				}
			}
			else{
				if(statusMessage.contains("Click to activate"))
				{
					Logger.info("Fullfillment system is already deactive");
				}
				else{
					FullfillmentSystemStatus.click();
					Logger.info("Fullfillment system is deactivated");
				}
			}
		}
	}
	
	/**
	 * @description This method is used to enter the fullfillment system name in search box
	 * @param systemName
	 */
	public void searchForFullfillmentSystem(String systemName) throws Exception
	{
		try
		{
			if(searchBoxFullfillmentSystem.isDisplayed())
			{
				searchBoxFullfillmentSystem.click();
				searchBoxFullfillmentSystem.sendKeys(systemName);
				Logger.info("fullfilment system name is entered in search box");
			}
			else{
				Logger.info("Fullfillemt system search box is not displayed");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}
	
	/**
	 * @description this method is used to validate the search results for fullfillment system
	 * @param system
	 * @return Returns true or false whether search is success or failure
	 * @throws Exception
	 */
	public boolean validateFullfillmentSystemSearch(String system) throws Exception
	{
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+system+"')]"));
		if(element.isDisplayed())
	       return true;
		else
			return false;
	}
	
	/**
	 * @description This method clicks on the required fullfillment system
	 * @param system
	 */
	public void clickOnFullfillmentSystem(String system) throws Exception
	{
		try
		{
			WebElement fullfillmentSystem = driver.findElement(By.xpath("//span[contains(text(),'"+system+"')]"));
			if(fullfillmentSystem.isDisplayed())
			{
				fullfillmentSystem.click();
				Logger.info("Fullfillemnt system is clicked");
			}
			else{
				Logger.info("fullfillemnt system is not displayed");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}
	
	/**
	 * @description This method returns the success message displayed when the status of the fullfillment system is changed
	 * and closes the message 
	 */
	public String getFullfillmentStatusChangeMessage() throws Exception
	{
		String message = "";
		try
		{
			message = fullfillmentSystemStatusChangeMessage.getText();
			Logger.info("status change message is retrieved");
			fullfillmentSystemStatusChangeMessageClose.click();
			Logger.info("status change message is retrieved closed");
			return message;
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}
	
	/**
	 * @description This method clicks on create button to add ftp information for a fullfillment system
	 */
	public void clickOnCreate() throws Exception
	{
		try{
			if(createButton.isDisplayed())
			{
				createButton.click();
				Logger.info("create button is clicked");
			}else{
				Logger.info("create button is is not displayed");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  }
	}
	
	/**
	 * @description This method is used to check or uncheck the use ftp check box
	 */
	public void checkUncheckUseFTP(boolean value) throws Exception
	{
		try{
			if(value)
			{
				if(useFTPCheckbox.isSelected())	{
					Logger.info("use FTP check box is already selected");
				}	
				else{
					useFTPCheckbox.click();
					Logger.info("use FTP is selected");
					}
				}
			else{
				if(useFTPCheckbox.isSelected())	{
					useFTPCheckbox.click();
					Logger.info("use FTP check box is not selected");
				}	
				else{
					Logger.info("use FTP is not selected");
					}
				}
			}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
		}
	
	/**
	 * @description This method is used to enter the ftp server information for the fullfillment system
	 */
	public void enterFTPServerOfFullfillmentSystem() throws Exception
	{
		try{
			if(ftpServerTextBox.isDisplayed())
			{
				ftpServerTextBox.click();
				ftpServerTextBox.sendKeys("Test_"+utils.generateRandomAlphaNumString(10));
				Logger.info("ftp server information for the fullfillment system is entered");
			}
			else{
				Logger.info("ftp server text box is not displayed");
				}
			}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
		}
	
	/**
	 * @description This method is used to enter the ftp path information for the fullfillment system
	 */
	public void enterFTPPathOfFullfillmentSystem() throws Exception
	{
		try{
			if(ftpPathTextBox.isDisplayed())
			{
				ftpPathTextBox.click();
				ftpPathTextBox.sendKeys("Test_"+utils.generateRandomAlphaNumString(10));
				Logger.info("ftp path information for the fullfillment system is entered");
			}
			else{
				Logger.info("ftp path text box is not displayed");
				}
			}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
		}
	
	/**
	 * @description This method is used to enter the ftp username information for the fullfillment system
	 */
	public void enterFTPUsernameOfFullfillmentSystem() throws Exception
	{
		try{
			if(ftpUsernameTextBox.isDisplayed())
			{
				ftpUsernameTextBox.click();
				ftpUsernameTextBox.sendKeys("Test_"+utils.generateRandomAlphaNumString(10));
				Logger.info("ftp username information for the fullfillment system is entered");
			}
			else{
				Logger.info("ftp username text box is not displayed");
				}
			}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
		}
	
	/**
	 * @description This method is used to enter the ftp password information for the fullfillment system
	 */
	public void enterFTPPasswordOfFullfillmentSystem() throws Exception
	{
		try{
			if(ftpPasswordTextBox.isDisplayed())
			{
				ftpPasswordTextBox.click();
				ftpPasswordTextBox.sendKeys("Test_"+utils.generateRandomAlphaNumString(10));
				Logger.info("ftp password information for the fullfillment system is entered");
			}
			else{
				Logger.info("ftp password text box is not displayed");
				}
			}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
		}
	
	/**
	 * @description This method is used to enter the file path information for the fullfillment system
	 */
	public void enterFilePathOfFullfillmentSystem() throws Exception
	{
		try{
			if(filePathTextBox.isDisplayed())
			{
				filePathTextBox.click();
				filePathTextBox.sendKeys("Test_"+utils.generateRandomAlphaNumString(10));
				Logger.info("file path information for the fullfillment system is entered");
			}
			else{
				Logger.info("file path text box is not displayed");
				}
			}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
		}
	
	/**
	 * @description This method is used to enter days to keep files for the fullfillment system
	 */
	public void enterDaysToKeepFilesForFullfillmentSystem(int noOfDays) throws Exception
	{
		try{
			if(daysToKeepFilesTextBox.isDisplayed())
			{
				daysToKeepFilesTextBox.click();
				daysToKeepFilesTextBox.sendKeys(""+noOfDays);
				Logger.info("days to keep files for the fullfillment system is entered");
			}
			else{
				Logger.info("days to keep files text box is not displayed");
				}
			}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
		}
	
	/**
	 * @description This method is used to check or uncheck the use plugin check box
	 */
	public void checkUncheckUsePlugin(boolean value) throws Exception
	{
		try{
			if(value)
			{
				if(usePluginCheckbox.isSelected())	{
					Logger.info("use plugin check box is already selected");
				}	
				else{
					usePluginCheckbox.click();
					Logger.info("use plugin is selected");
					}
				}
			else{
				if(usePluginCheckbox.isSelected())	{
					usePluginCheckbox.click();
					Logger.info("use plugin check box is not selected");
				}	
				else{
					Logger.info("use plugin is not selected");
					}
				}
			}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
		}
	
	/**
	 * @description This method selects the module name required to assign as part of server details 
	 * in a fullfillment system
	 */
	public void selectModuleName(String moduleName) throws Exception
	{
		try
		{
			if(moduleNameDropDownList.isDisplayed())
			{
				Select selectModuleName = new Select(moduleNameDropDownList);
				selectModuleName.selectByVisibleText(properties.getProperty(moduleName));
				Logger.info("module name is selected");
			}
			else{
				Logger.info("module name is not displayed");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}
	
}


