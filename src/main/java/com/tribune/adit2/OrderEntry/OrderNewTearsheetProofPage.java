package com.tribune.adit2.OrderEntry;

import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Customers Page
 * @author Priyanka Goud CR 
 * @since November 2015
 */

public class OrderNewTearsheetProofPage 
{

	@FindBy (xpath = "//label[text()='Quantity:']/../input")
	public WebElement quantityTextBox;
	
	@FindBy (xpath = "//label[text()='Contact:']/../input")
	public WebElement contactTextBox;
	
	@FindBy (xpath = "//label[text()='Company:']/../input")
	public WebElement companyTextBox;

	@FindBy (xpath = "//label[text()='Address:']/../input")
	public WebElement addressTextBox;
	
	@FindBy (xpath = "//label[text()='City:']/../input")
	public WebElement cityTextBox;
	
	@FindBy (xpath = "//label[text()='State:']/../input")
	public WebElement stateTextBox;
	
	@FindBy (xpath = "//label[text()='Zip:']/../input")
	public WebElement zipTextBox;
	
	@FindBy (xpath = "//label[text()='Phone:']/../input")
	public WebElement phoneTextBox;
	
	@FindBy (xpath = "//div[@class='modal-footer']/button[text()='Save']")
	public WebElement saveBtn;
	
	@FindBy (xpath = "//div[@class='modal-footer']/button[text()='Cancel']")
	public WebElement cancelBtn;
	
	private WebDriver driver;
	
	Properties properties = TribuneUtils.readProperties();
		
	public OrderNewTearsheetProofPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
//code to enter quantity
	public void  enterQuantity() throws Exception
	{
		try{
			if(quantityTextBox.isDisplayed()){
				quantityTextBox.click();
				quantityTextBox.clear();
				quantityTextBox.sendKeys(properties.getProperty("TearProof_Quantity"));
				Logger.info("Quantity " +properties.getProperty("TearProof_Quantity")+" is entered");
			}
			else
				Logger.info("quantity text box is not displayed");
		}
		catch(Exception e)
		 {
			 Logger.error(e.getMessage());
			  throw e;
		 }
	}

//code to enter contact
	public void enterContact() throws Exception
	{
		try{
			if(contactTextBox.isDisplayed()){
				contactTextBox.click();
				contactTextBox.clear();
				contactTextBox.sendKeys(properties.getProperty("TearProof_Contact"));
				Logger.info("Contact " +properties.getProperty("TearProof_Contact") +" is entered");
			}
			else
				Logger.info("Contact text box is not displayed");
		}
		catch(Exception e)
		 {
			 Logger.error(e.getMessage());
			  throw e;
		 }
	}
	
//Code to enter company name
	public void enterCompany() throws Exception
	{
		try{
			if(companyTextBox.isDisplayed()){
				companyTextBox.click();
				companyTextBox.clear();
				companyTextBox.sendKeys(properties.getProperty("TearProof_Company"));
				Logger.info("Company " +properties.getProperty("TearProof_Company")+" is entered");
			}
			else
				Logger.info("Company text box is not displayed");
		}
		catch(Exception e)
		 {
			 Logger.error(e.getMessage());
			  throw e;
		 }
	}
	
//Code to enter address
	public void enterAddress() throws Exception
	{
		try{
			if(addressTextBox.isDisplayed()){
				addressTextBox.click();
				addressTextBox.clear();
				addressTextBox.sendKeys(properties.getProperty("TearProof_Address"));
				Logger.info("Address " +properties.getProperty("TearProof_Address") +" is entered");
			}
			else
				Logger.info("Address text box is not displayed");
		}
		catch(Exception e)
		 {
			 Logger.error(e.getMessage());
			  throw e;
		 }
	}
	
//Code to enter city
	public void entrCity() throws Exception
	{
		try{
			if(cityTextBox.isDisplayed()){
				cityTextBox.click();
				cityTextBox.clear();
				cityTextBox.sendKeys(properties.getProperty("TearProof_City"));
				Logger.info("City " +properties.getProperty("TearProof_City")+" is entered");
			}
			else
				Logger.info("City text box is not displayed");
		}
		catch(Exception e)
		 {
			 Logger.error(e.getMessage());
			  throw e;
		 }	
	}
	
//Code to enter state
	public void enterState() throws Exception
	{
		try{
			if(stateTextBox.isDisplayed()){
				stateTextBox.click();
				stateTextBox.clear();
				stateTextBox.sendKeys(properties.getProperty("TearProof_State"));
				Logger.info("State " +properties.getProperty("TearProof_State")+" is entered");
			}
			else
				Logger.info("State text box is not displayed");
		}
		catch(Exception e)
		 {
			 Logger.error(e.getMessage());
			  throw e;
		 }	
	}
	
//Code to enter the ZIP code
	public void enterZipCode() throws Exception
	{
		try{
			if(zipTextBox.isDisplayed()){
				zipTextBox.click();
				zipTextBox.clear();
				zipTextBox.sendKeys(properties.getProperty("TearProof_Zip"));
				Logger.info("Zip Code " +properties.getProperty("TearProof_Zip") +" is entered");
			}
			else
				Logger.info("Zip text box is not displayed");
		}
		catch(Exception e)
		 {
			 Logger.error(e.getMessage());
			  throw e;
		 }	
	}
	
//Code to enter the phone number
	public void  enterPhoneNumber() throws Exception
	{
		try{
			if(phoneTextBox.isDisplayed()){
				phoneTextBox.click();
				phoneTextBox.clear();
				phoneTextBox.sendKeys(properties.getProperty("TearProof_Phone"));
				Logger.info("Phone Number " +properties.getProperty("TearProof_Phone")+" is entered");
			}
			else
				Logger.info("Phone text box is not displayed");
		}
		catch(Exception e)
		 {
			 Logger.error(e.getMessage());
			  throw e;
		 }
	}
	
//Code to click on save button to save the tearsheet
	public void clickOnSave() throws Exception
	{
		try{
			if(saveBtn.isDisplayed()){
				saveBtn.click();
				Logger.info("Save butoon is clicked");
			}
			else
				Logger.info("Save button is not displayed");
		}
		catch(Exception e)
		 {
			 Logger.error(e.getMessage());
			  throw e;
		 }
	}
	
//Code to click on cancel button
	public void clickOnCancel() throws Exception
	{
		try{
			if(cancelBtn.isDisplayed()){
				cancelBtn.click();
				Logger.info("Cancel butoon is clicked");
			}
			else
				Logger.info("Cancel button is not displayed");
		}
		catch(Exception e)
		 {
			 Logger.error(e.getMessage());
			  throw e;
		 }
	}
}
