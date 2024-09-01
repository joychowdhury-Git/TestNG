package com.tribune.adit2.Customers;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Customers Page
 * @author Priyanka Goud CR 
 * @since October 2015
 */

public class CustomerAddressPage 
{
	@FindBy (id="contactName")
	public WebElement contactNameTextBox;
	
	@FindBy (id = "addressTypeId")
	public WebElement editAddressTypeDropDown;
	
	@FindBy (id = "streetLine")
	public WebElement streetAddress;
	
	@FindBy (id = "streetLine2")
	public WebElement street2Address;
	
	@FindBy (id = "city")
	public WebElement city;
	
	@FindBy (id = "state")
	public WebElement state;
	
	@FindBy (id = "zipCode")
	public WebElement zip;
	
	@FindBy (id = "phoneNumber")
	public WebElement phoneNumber; 
	
	@FindBy (id = "faxNumber")
	public WebElement fax;
	
	@FindBy (id = "emailAddress")
	public WebElement email;
	
	@FindBy (id = "additionalEmail")
	public WebElement additionalEmail;
	
	@FindBy (id = "isPrimary")
	public WebElement primaryAddressCheckBox;
	
	@FindBy(id = "btnSaveAddress")
	public WebElement saveButton;
	
	@FindBy(id = "btnCancel")
	public WebElement cancelButton;
	
	private WebDriver driver;
	
	Properties properties = TribuneUtils.readProperties();
	
	public CustomerAddressPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Code to enter the contact name in the edit address page
		public void enterContactName(Map<String, String> userData) throws Exception
		{
			try
			{
				if (contactNameTextBox.isDisplayed())
				  {
					contactNameTextBox.click();
					contactNameTextBox.clear();
					contactNameTextBox.sendKeys(userData.get("ContactName1").toString());
					Logger.info(userData.get("ContactName1").toString()+ "contact name is entered");
				  }
				else
				{
					 Logger.info("contact name text box is not displayed");
					  throw new NoSuchElementException("contact name text box is not displayed");	
				}
			}
			catch(Exception e)
			{
				Logger.error(e.getMessage());
				  throw e;
			}
		}

	//Code to select the type of the address in edit address page	
		public void selectAddressType(String type) throws Exception
		{
			try
			{
				if(editAddressTypeDropDown.isDisplayed())
				{
					editAddressTypeDropDown.click();
					Select valueFromType = new Select(editAddressTypeDropDown);
				    List<WebElement> listOfValuesBU = valueFromType.getOptions();
				    if(listOfValuesBU.size() !=0)
				      {
				    	valueFromType.selectByVisibleText(properties.getProperty(type));
				         Logger.info("type is selected"); 
				      }
				      else
				      {
				    	  Logger.info("type drop down is empty");
				      }
				}
				else
				{
					Logger.info("type drop down is not displayed");
					throw new NoSuchElementException("type drop down is not displayed");	
				}
			}
			catch(Exception e)
			{
				Logger.error(e.getMessage());
				  throw e;
			}
		}

	//Code to enter values in the address line
		public void enterAddress(Map<String, String> userData) throws Exception
		{
			try
			{
				if(streetAddress.isDisplayed())
				{
					streetAddress.click();
					streetAddress.clear();
					streetAddress.sendKeys(userData.get("StreetAddress").toString());
					Logger.info("street address is entered");
				}
				else
				{
					Logger.info("Street address textbox is not displayed");
				}
			}
			catch(Exception e)
			{
				Logger.error(e.getMessage());
				  throw e;
			}
		}

	// Code to enter street2 details in the address section
		public void enterStreet2Address(Map<String, String> userData) throws Exception
		{
			try
			{
				if(street2Address.isDisplayed())
				{
					street2Address.click();
					street2Address.clear();
					street2Address.sendKeys(userData.get("Street2Address").toString());
					Logger.info("Optional Street address is entered");
					
				}
				else
				{
					Logger.info("Optional Street address textbox is not displayed");
				}
			}
			catch(Exception e)
			{
				Logger.error(e.getMessage());
				  throw e;
			}
		}

	//Code to enter City
		public void enterCity(Map<String, String> userData) throws Exception
		{
			try
			{
				if(city.isDisplayed())
				{
					city.click();
					city.clear();
					city.sendKeys(userData.get("City").toString());
					Logger.info("City is entered");
					
				}
				else
				{
					Logger.info("City textbox is not displayed");
				}
			}
			catch(Exception e)
			{
				Logger.error(e.getMessage());
				  throw e;
			}
		}
		
	//Code to enter State
		public void enterState(Map<String, String> userData) throws Exception
		{
			try
			{
				if(state.isDisplayed())
				{
					state.click();
					state.clear();
					state.sendKeys(userData.get("State").toString());
					Logger.info("State is entered");
					
				}
				else
				{
					Logger.info("State text box is not displayed");
				}
			}
			catch(Exception e)
			{
				Logger.error(e.getMessage());
				  throw e;
			}
		}
		
	//Code to enter Zip code
		public void enterZip(Map<String, String> userData) throws Exception
		{
			try
			{
				if(zip.isDisplayed())
				{
					zip.click();
					zip.clear();
					zip.sendKeys(userData.get("Zip").toString());
					Logger.info("State is entered");
					
				}
				else
				{
					Logger.info("Zip text box is not displayed");
				}
			}
			catch(Exception e)
			{
				Logger.error(e.getMessage());
				  throw e;
			}
		}
		
	//Code to enter phone number
		public void enterPhoneNumber(Map<String, String> userData) throws Exception
		{
			try
			{
				if(phoneNumber.isDisplayed())
				{
					phoneNumber.click();
					phoneNumber.clear();
					
					phoneNumber.sendKeys(userData.get("PhoneNumber").toString());
					Logger.info("Phone Number is entered");
					
				}
				else
				{
					Logger.info("Phone text box is not displayed");
				}
			}
			catch(Exception e)
			{
				Logger.error(e.getMessage());
				  throw e;
			}
		}
		
	//Code to enter Fax
		public void enterFax(Map<String, String> userData) throws Exception
		{
			try
			{
				if(fax.isDisplayed())
				{
					fax.click();
					fax.clear();
					
					fax.sendKeys(userData.get("Fax").toString());
					Logger.info("Fax is entered");
					
				}
				else
				{
					Logger.info("Fax text box is not displayed");
				}
			}
			catch(Exception e)
			{
				Logger.error(e.getMessage());
				  throw e;
			}
		}

	//Code to enter email address
		public void enterEmailAdress(Map<String, String> userData) throws Exception
		{
			try
			{
				if(email.isDisplayed())
				{
					email.click();
					email.clear();
					
					email.sendKeys(userData.get("Email").toString());
					Logger.info("Email Address is entered");
					
				}
				else
				{
					Logger.info("Email text box is not displayed");
				}
			}
			catch(Exception e)
			{
				Logger.error(e.getMessage());
				  throw e;
			}
		}
		
	//Code to enter additional email address
		public void enterAdditionalEmailAddress(Map<String, String> userData) throws Exception
		{
			try
			{
				if(additionalEmail.isDisplayed())
				{
					additionalEmail.click();
					additionalEmail.clear();
					additionalEmail.sendKeys(userData.get("Additional Email").toString());
					Logger.info("Additional Email Address is entered");
					
				}
				else
				{
					Logger.info("Additional Email text box is not displayed");
				}
			}
			catch(Exception e)
			{
				Logger.error(e.getMessage());
				  throw e;
			}
		}
		
	// Code to click on primary address check box
		public void selectAddressAsPrimary() throws Exception
		{
			try
			{
				if(primaryAddressCheckBox.isDisplayed())
				{
					primaryAddressCheckBox.click();
					Logger.info("Address provided is selected as a primary address");
					
				}
				else
				{
					Logger.info("Primary adress section checkbox is not displayed");
				}
			}
			catch(Exception e)
			{
				Logger.error(e.getMessage());
				  throw e;
			}
		}
		
	//Code to click on Save button
		public void clickOnSaveButton() throws Exception
		{
			try
			{
				if(saveButton.isDisplayed())
				{
					saveButton.click();
					Thread.sleep(10000);
					Logger.info("Save button is clicked and the address details are saved");
				}
				else
				{
					Logger.info("Save button is not displayed");
				}
			}
			catch(Exception e)
			{
				Logger.error(e.getMessage());
				  throw e;
			}
		}
		
	//Code to click on cancel button
		public void clickOnCancelButton() throws Exception
		{
			try
			{
				if(cancelButton.isDisplayed())
				{
					cancelButton.click();
					Logger.info("Cancel button is clicked");
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
}
