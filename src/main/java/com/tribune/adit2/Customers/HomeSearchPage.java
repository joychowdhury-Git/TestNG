package com.tribune.adit2.Customers;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

import junit.framework.Assert;

/**
 * Page Class Modeling for Customers Page
 * @author Priyanka Goud CR 
 * @since October 2015
 */

public class HomeSearchPage 
{

	@FindBy (id = "accountType_credit")
	public WebElement creditCardPaymentMethod;
	
	@FindBy (id = "creditCardNumber")
	public WebElement creditCardNumber;
	
	@FindBy (id = "securityCode")
	public WebElement securityCode;
	
	@FindBy(xpath = "//*[@ng-model='vm.card.ExpiringMonth']")
	public WebElement cardExpiringMonth;
	
	@FindBy(xpath = "//*[@ng-model='vm.card.ExpiringYear']")
	public WebElement cardExpiringYear;
	
	@FindBy (id = "firstName")
	public WebElement firstName;
	
	@FindBy (id = "lastName")
	public WebElement lastName;
	
	@FindBy (id = "street")
	public WebElement streetAddress;
	
	@FindBy (id = "city")
	public WebElement cityName;
	
	@FindBy (id = "state")
	public WebElement stateName;
	
	@FindBy (id = "zipCode")
	public WebElement zipCode;
	
	@FindBy (id = "country")
	public WebElement countryCode;
	
	@FindBy (id = "email")
	public WebElement emailAddress;
	
	@FindBy (id = "phone")
	public WebElement phoneNumber;
	
	@FindBy (id = "isPrimary")
	public WebElement primaryCardSelectionCheckBox;
	
	@FindBy (id = "btnSavePaymentAccount")
	public WebElement savePaymentButton;
	
	@FindBy (id = "btnCancel")
	public WebElement cancelPaymentButton;
	
	@FindBy (id = "accountType_echeck")
	public WebElement eCheckPaymentMethod;
	
	@FindBy (id = "achAccountNumber")
	public WebElement achAccountNumber;
	
	@FindBy (id = "confirmAccountNumber")
	public WebElement confirmAccountNumber;
	
	@FindBy (id = "Text1")
	public WebElement achRoutingNumber;
	
	@FindBy (id = "accountType")
	public WebElement achAccountType;
	
	@FindBy (xpath = "//td[text() = 'Credit Card']/../td[3]")
	public List<WebElement> creditCardNumbers;
	
	@FindBy (xpath = "//td[text() = 'ACH']/../td[3]")
	public List<WebElement> eCheckList;
	
	private WebDriver driver;
	
	Properties properties = TribuneUtils.readProperties();
	
	public HomeSearchPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
//Code to click on the credit card type of payment method
	public void clickOnCreditCard(boolean value) throws Exception
	{
		try
		{
			if(value){
				if(creditCardPaymentMethod.isSelected()){
					Logger.info("credit card payment method is selected");
				}
				else{
					creditCardPaymentMethod.click();
					Logger.info("credit card payment method is selected");
				}
			}
			else 
			{
				if(!creditCardPaymentMethod.isSelected()){
					creditCardPaymentMethod.click();
				}
				Logger.info("credit card payment method is not selected by default. Hence, explicitly Clicked on credit card payment");
			}
			
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}

//Code to enter Credit Card Number
	public void enterCreditCardNumber(String vendorName) throws Exception
	{
		try
		{
			if(creditCardNumber.isEnabled())
			{
				creditCardNumber.click();
				creditCardNumber.clear();
				String cardNumber = TribuneUtils.getCreditCardNumber(vendorName);
				creditCardNumber.sendKeys(cardNumber);
				Logger.info("Credit card number is entered");
			}
			else 
			{
				Logger.info("Credit card number textbox is not enabled");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}

//Code to enter the security Code
	public void enterSecurityCode(String vendorName) throws Exception
	{
		try
		{
			if(securityCode.isEnabled())
			{
				securityCode.click();
				securityCode.clear();
				String securityCodeValue = TribuneUtils.getCreditCardSecurityCode(vendorName);
				securityCode.sendKeys(securityCodeValue);
				Logger.info("Security Code is entered");
			}
			else 
			{
				Logger.info("Security Codetextbox is not enabled");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}

//Code to enter credit card expiring month
	public void enterCardExpiringMonth(String vendorName) throws Exception
	{
		 try{
			 if(cardExpiringMonth.isDisplayed())
			 {
				 Select selectBU = new Select(cardExpiringMonth);
				 String expMonth = TribuneUtils.getCreditCardExpMonth(vendorName);
				 selectBU.selectByVisibleText(expMonth);
				 Logger.info(expMonth+" credit card expiring month is selected");
			 }
			 else{
				 Logger.info("card expiring month is not displayed");
			 }
		 }
		 catch(Exception e)
		 {
			 Logger.error(e.getMessage());
			  throw e;
		 }
		/*try
		{
			if(cardExpiringMonth.isEnabled())
			{
				cardExpiringMonth.click();
				cardExpiringMonth.clear();
				String expMonth = TribuneUtils.getCreditCardExpMonth(vendorName);
				cardExpiringMonth.sendKeys(expMonth);
				Logger.info("credit card expiring month is entered");
			}
			else 
			{
				Logger.info("card expiring month textbox is not enabled");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}*/
	}
	
//Code to enter credit card expiring year
	public void enterCardExpiringYear(String vendorName) throws Exception
	{
		 try{
			 if(cardExpiringYear.isDisplayed())
			 {
				 Select selectBU = new Select(cardExpiringYear);
				 String expYear = TribuneUtils.getCreditCardExpYear(vendorName);
				 selectBU.selectByVisibleText(expYear);
				 Logger.info(expYear+" credit card expiring year is selected");
			 }
			 else{
				 Logger.info("card expiring year is not displayed");
			 }
		 }
		 catch(Exception e)
		 {
			 Logger.error(e.getMessage());
			  throw e;
		 }/*
		try
		{
			if(cardExpiringYear.isEnabled())
			{
				cardExpiringYear.click();
				cardExpiringYear.clear();
				String expYear = TribuneUtils.getCreditCardExpYear(vendorName);
				cardExpiringYear.sendKeys(expYear);
				Logger.info("credit card expiring year is entered");
			}
			else 
			{
				Logger.info("card expiring year textbox is not enabled");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}*/
	}

//Code to enter the card holder's first name
	public void enterFirstName(String frstName) throws Exception
	{
		try
		{
			if(firstName.isEnabled())
			{
				firstName.click();
				firstName.clear();
				firstName.sendKeys(frstName);
				Logger.info("first name is entered");
			}
			else 
			{
				Logger.info("first name textbox is not enabled");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to enter the card holder's last name
	public void enterLastName(String lstName) throws Exception
	{
		try
		{
			if(lastName.isEnabled())
			{
				lastName.click();
				lastName.clear();
				lastName.sendKeys(lstName);
				Logger.info("last name is entered");
			}
			else 
			{
				Logger.info("last name textbox is not enabled");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to enter the street address
	public void enterStreetAddress(String streetAddr) throws Exception
	{
		try
		{
			if(streetAddress.isEnabled())
			{
				streetAddress.click();
				streetAddress.clear();
				streetAddress.sendKeys(streetAddr);
				Logger.info("street address is entered");
			}
			else 
			{
				Logger.info("street address textbox is not enabled");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}

//Code to enter the city name
	public void enterCityName(String city) throws Exception
	{
		try
		{
			if(cityName.isEnabled())
			{
				cityName.click();
				cityName.clear();
				cityName.sendKeys(city);
				Logger.info("city name is entered");
			}
			else 
			{
				Logger.info("city textbox is not enabled");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}

//Code to enter the state name
	public void enterStateName(String state) throws Exception
	{
		try
		{
			if(stateName.isEnabled())
			{
				stateName.click();
				stateName.clear();
				stateName.sendKeys(state);
				Logger.info("state name is entered");
			}
			else 
			{
				Logger.info("state textbox is not enabled");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to enter ZIP code
	public void enterZipCode(String zip) throws Exception
	{
		try
		{
			if(zipCode.isEnabled())
			{
				zipCode.click();
				zipCode.clear();
				zipCode.sendKeys(zip);
				Logger.info("Zip Code is entered");
			}
			else 
			{
				Logger.info("zip textbox is not enabled");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to enter the country code
	public void enterCountryCode(String country) throws Exception
	{
		try
		{
			if(countryCode.isEnabled())
			{
				countryCode.click();
				countryCode.clear();
				countryCode.sendKeys(country);
				Logger.info("country code is entered");
			}
			else 
			{
				Logger.info("Country textbox is not enabled");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to enter the email address
	public void enterEmailAddress(String email) throws Exception
	{
		try
		{
			if(emailAddress.isEnabled())
			{
				emailAddress.click();
				emailAddress.clear();
				emailAddress.sendKeys(email);
				Logger.info("email address is entered");
			}
			else 
			{
				Logger.info("Email textbox is not enabled");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to enter phone number
	public void enterPhoneNumber(String phone) throws Exception
	{
		try
		{
			if(phoneNumber.isEnabled())
			{
				phoneNumber.click();
				phoneNumber.clear();
				phoneNumber.sendKeys(phone);
				Logger.info("phone number is entered");
			}
			else 
			{
				Logger.info("Phone textbox is not enabled");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to enter credit card information
	public void enterCardInfo(String vendorName) throws Exception
	{
		enterCreditCardNumber(vendorName);
		//enterSecurityCode(vendorName);
		enterCardExpiringMonth(vendorName);
	    enterCardExpiringYear(vendorName);
	}
	
//Code to enter all the details of card/Echeck holder
	public void enterCardECheckHoldersInfo() throws Exception
	{
		enterFirstName("Macy");
		enterLastName("Rose");
		enterStreetAddress("124 Main St");
		enterCityName("Niagara Falls");
		enterStateName("NY");
		enterZipCode("14305");
		enterCountryCode("US");
		enterEmailAddress("macy@xyz.com");
		enterPhoneNumber("1234567890");
	}
	
//Code to select the card as primary
	public void selectCreditCardAsPrimary() throws Exception
	{
		try
		{
			WebElement primaryCheckBox = driver.findElement(By.xpath("//input[@id='isPrimary']/../i"));
			if(primaryCardSelectionCheckBox.getAttribute("class").equalsIgnoreCase("ng-valid ng-dirty ng-valid-parse ng-touched ng-empty"))
				{
					primaryCheckBox.click();
					//primaryCardSelectionCheckBox.click();
					Logger.info("selected as a primary card");
				}
				else if(primaryCardSelectionCheckBox.getAttribute("class").equalsIgnoreCase("ng-valid ng-dirty ng-valid-parse ng-touched ng-not-empty"))
				{
					primaryCheckBox.click();
					//primaryCardSelectionCheckBox.click();
					Logger.info("primary checkbox is already selected");
				}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to save the credit card details entered
	public void savePaymentDetails() throws Exception
	{
		try
		{
			if(savePaymentButton.isDisplayed())
			{
				savePaymentButton.click();
				Logger.info("details entered are saved");
				Thread.sleep(5000);
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

// Code to cancel the details entered 
	public void cancelPaymentDetails() throws Exception
	{
		try
		{
			if(cancelPaymentButton.isDisplayed())
			{
				cancelPaymentButton.click();
				Logger.info("details entered are canceled");
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
	
//Code to click on E-Check button
	public void clickOnECheck() throws Exception
	{
		try
		{
			if(eCheckPaymentMethod.isSelected())
			{
				Logger.info("E-Check payment method is selected");
			}
			else 
			{
				eCheckPaymentMethod.click();
				Logger.info("E-Check button is selected explicitly");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to enter ACH Account number
	public void enterACHAccountNumber(String AccType) throws Exception
	{
		try
		{
			if(achAccountNumber.isEnabled())
			{
				achAccountNumber.click();
				achAccountNumber.clear();
				String accNumber = TribuneUtils.getACHAccNumber(AccType);
				achAccountNumber.sendKeys(accNumber);
				Logger.info("ACH Account number is entered");
			}
			else 
			{
				Logger.info("Account Number textbox is not enabled");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	public void enterConfirmACHAccountNumber(String AccType) throws Exception
	{
		try
		{
			if(confirmAccountNumber.isEnabled())
			{
				confirmAccountNumber.click();
				confirmAccountNumber.clear();
				String accNumber = TribuneUtils.getACHAccNumber(AccType);
				confirmAccountNumber.sendKeys(accNumber);
				Logger.info("ACH Account number confirm is entered");
			}
			else 
			{
				Logger.info("Account Number confirm textbox is not enabled");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
//Code to enter ACH routing number
	public void enterACHRoutingNumber(String achAccType) throws Exception
	{
		try
		{
			if(achRoutingNumber.isEnabled())
			{
				achRoutingNumber.click();
				achRoutingNumber.clear();
				String accRountingNumber = TribuneUtils.getACHAccRoutingNumber(achAccType);
				achRoutingNumber.sendKeys(accRountingNumber);
				Logger.info("ACH Routing number is entered");
			}
			else 
			{
				Logger.info("Routing Number textbox is not enabled");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}

//Code to select the account type
	public void selectAccountType(String accountType) throws Exception
	{
		try
		{
			if(achAccountType.isDisplayed())
			{
				achAccountType.click();
				Select valueFromType = new Select(achAccountType);
			    List<WebElement> listOfAccTypes = valueFromType.getOptions();
			    if(listOfAccTypes.size() !=0)
			      {
			    	valueFromType.selectByVisibleText(properties.getProperty(accountType));
			         Logger.info("AccountType is selected"); 
			      }
			      else
			      {
			    	  Logger.info("AccountType drop down is empty");
			      }
			}
			else
			{
				Logger.info("AccountType drop down is not displayed");
				throw new NoSuchElementException("AccountType drop down is not displayed");	
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//validate credit card addition
	public void validateCreditCardAddition(String cardVendor) throws Exception
	{
		boolean flag = false;
		if(!creditCardNumbers.isEmpty())
		{
			Iterator<WebElement> iterator = creditCardNumbers.iterator();
			  while(iterator.hasNext())
			  {
				  WebElement cardNumberElement = iterator.next();
				  String cardNumber = cardNumberElement.getText();
				  int cardNumberLength = cardNumber.length();
				  String cardLastFourDigitsActual = cardNumber.substring(cardNumberLength-4);
				  //String vendorName = properties.getProperty(cardVendor);
				  flag = false;
				  if(cardVendor.equalsIgnoreCase("Visa"))
				  {
					  String creditCardNumberAdded = TribuneUtils.getCreditCardNumber(cardVendor);
					  String cardLastFourDigitsExpected	=  creditCardNumberAdded.substring(creditCardNumberAdded.length()-4);
					  if(cardLastFourDigitsActual.equals(cardLastFourDigitsExpected))
					  {
						  flag = true;
						  Logger.info("validated visa card");
						  break;
						  
					  }
				  }
				  else if (cardVendor.equalsIgnoreCase("AmericanExpress"))
				  {
					  String creditCardNumberAdded = TribuneUtils.getCreditCardNumber(cardVendor);;
					  String cardLastFourDigitsExpected	=  creditCardNumberAdded.substring(creditCardNumberAdded.length()-4);
					  if(cardLastFourDigitsActual.equals(cardLastFourDigitsExpected))
					  {
						  flag = true;
						  Logger.info("validated american express card");
						  break;
					  }
				  }
				  else if (cardVendor.equalsIgnoreCase("Master"))
				  {
					  String creditCardNumberAdded = TribuneUtils.getCreditCardNumber(cardVendor);;
					  String cardLastFourDigitsExpected	=  creditCardNumberAdded.substring(creditCardNumberAdded.length()-4);
					  if(cardLastFourDigitsActual.equals(cardLastFourDigitsExpected))
					  {
						  flag = true;
						  Logger.info("validated master card");
						  break;
					  }
				  }
				  else if (cardVendor.equalsIgnoreCase("Discover"))
				  {
					  String creditCardNumberAdded = TribuneUtils.getCreditCardNumber(cardVendor);
					  String cardLastFourDigitsExpected	=  creditCardNumberAdded.substring(creditCardNumberAdded.length()-4);
					  if(cardLastFourDigitsActual.equals(cardLastFourDigitsExpected))
					  {
						  flag = true;
						  Logger.info("validated discover card");
						  break;
					  }
				  }
				  
			  }
			  Assert.assertEquals(true, flag);
			  Logger.info("Validated the credit card addition successfully");
		}
	}
	
//validate e-check addition
	public void validateECheckAddition(String cardType) throws Exception
	{
		boolean flag = false;
		if(!eCheckList.isEmpty())
		{
			Iterator<WebElement> iterator = eCheckList.iterator();
			Logger.info("iterator length = "+ eCheckList.size());
			  while(iterator.hasNext())
			  {
				  WebElement cardNumberElement = iterator.next();
				  String cardNumber = cardNumberElement.getText();
				  flag = false;
				  if(cardType.equalsIgnoreCase("Type1"))
				  {
					  String ECheckAdded = TribuneUtils.getACHAccNumber(cardType);
					 if(cardNumber.equals(ECheckAdded))
					  {
						  flag = true;
						  Logger.info("validated type1 ECheck");
						  break;
					  }
				  }
				  else if (cardType.equalsIgnoreCase("Type2"))
				  {
					  String ECheckAdded = TribuneUtils.getACHAccNumber(cardType);
					  if(cardNumber.equals(ECheckAdded))
					  {
						  flag = true;
						  Logger.info("validated type2 ECheck");
						  break;
					  }
				  }
				  else if (cardType.equalsIgnoreCase("Type3"))
				  {
					  String ECheckAdded = TribuneUtils.getACHAccNumber(cardType);
					  if(cardNumber.equals(ECheckAdded))
					  {
						  flag = true;
						  Logger.info("validated type3 ECheck");
						  break;
					  }
				  }
				  else if (cardType.equalsIgnoreCase("Type4"))
				  {
					  String ECheckAdded = TribuneUtils.getACHAccNumber(cardType);
					  if(cardNumber.equals(ECheckAdded))
					  {
						  flag = true;
						  Logger.info("validated type4 ECheck");
						  break;
					  }
				  }
			  }
			  Assert.assertEquals(true, flag);
			  Logger.info("Validated the ECheck addition successfully");
		}
	}
	
}
