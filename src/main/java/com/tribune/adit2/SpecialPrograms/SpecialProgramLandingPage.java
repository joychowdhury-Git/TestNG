package com.tribune.adit2.SpecialPrograms;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Special Program
 * @author Sunny Mukherjee
 * @since October 2018
 */

public class SpecialProgramLandingPage 
{

	@FindBy(id = "Type")
	public WebElement typeDrpDwn;
	
	@FindBy(id = "Status")
	public WebElement statusDrpDwn;
	
	@FindBy(id = "name")
	public WebElement nameInput;

	@FindBy(id = "Text3")
	public WebElement customerInput;
	
	@FindBy(id = "Button1")
	public WebElement searchButton;
	
	@FindBy(id = "add-recurrence-pattern")
	public WebElement newContractButton;
	
	@FindBy(xpath = "//*[@id='app']/div[3]/div[2]/div[1]/div/div[2]/div/div/button")
	public WebElement newDropDwn;
	
	@FindBy(xpath = "//*[@id='app']/div[3]/div[2]/div[1]/div/div[2]/div/div/ul/li[1]/a")
	public WebElement newPromotionBtn;
	
	@FindBy(xpath = "//*[@id='app']/div[3]/div[2]/div[1]/div/div[2]/div/div/ul/li[2]/a")
	public WebElement newCouponBtn;
	
		
	private WebDriver driver;
	
	Properties properties = TribuneUtils.readProperties();
	
	public SpecialProgramLandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void enterName(String contractName) throws Exception
	  {
		try{
			 if (nameInput.isEnabled())
			 {
				 Logger.info("nameInput text box is visible");
				 nameInput.click();
				 nameInput.sendKeys(Keys.CONTROL,"a");
				 nameInput.clear();
				 nameInput.sendKeys(contractName);
				 nameInput.sendKeys(Keys.ENTER);
				 Thread.sleep(6000);				
				 Logger.info(contractName+ " nameInput is entered");
			 }
			 else
			 {
				 Logger.info("nameInput text box is not visible");
			 }
		 }
		 catch(Exception e)
		 {
			 Logger.error(e.getMessage());
			  throw e;
		 }
	  }
	
	 public void clickOnNewCouponBtn() throws Exception
	  {
		  try
		  {
			  if(newDropDwn.isDisplayed()){
				  newDropDwn.click();
				  newCouponBtn.click();
				  Logger.info("New Contract button is clicked");
			  }
			  else
			  {
				  Logger.info("New Contract is not displayed");
				  throw new NoSuchElementException("New Contract is not displayed");
			  }
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }
	
	 public void clickOnNewPromotionBtn() throws Exception
	  {
		  try
		  {
			  if(newDropDwn.isDisplayed()){
				  newDropDwn.click();
				  newPromotionBtn.click();
				  Logger.info("New Promotion button is clicked");
			  }
			  else
			  {
				  Logger.info("New Promotion is not displayed");
				  throw new NoSuchElementException("New Promotion is not displayed");
			  }
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }
	
	public void clickOnNewContractButton() throws Exception
	  {
		  try
		  {
			  if(newContractButton.isDisplayed()){				 
				  newContractButton.click();
				  Logger.info("newContractButton Clicked");
			  }
			  else
			  {
				  Logger.info("newOrderButton is not displayed");
				  throw new NoSuchElementException("newOrderButton is not displayed");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }
	
	
	
	public void selectFirstSearchResult(String BU) throws Exception
	  {
		  try
		  {
			  WebElement searchResult = driver.findElement(By.xpath("//div[text()='"+BU+"']"));
			  if (searchResult.isDisplayed())
			  {
				  searchResult.click();
				  
				  Logger.info("First Search Result is clicked");
			  }
			  else
			  {
				  Logger.info("First Search Result is not displayed");
				  throw new NoSuchElementException("First Search Result is not displayed");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }
	
	public void clickOnSearch() throws Exception
	  {
		  try
		  {
			  if (searchButton.isDisplayed())
			  {
				  searchButton.click();
				  Logger.info("Search Button Clicked");
			  }
			  else
			  {
				  Logger.info("searchButton is not displayed");
				  throw new NoSuchElementException("searchButton is not displayed");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }
	
	public void clickOnContract(String contractName) throws Exception
	  {
		WebElement contract = driver.findElement(By.xpath("//div[text()='"+contractName+"']/../../div/div/span/a"));
		  try
		  {
			  if (contract.isDisplayed())
			  {
				  contract.click();
				  Logger.info("contract id Clicked: "+contract.getText());
			  }
			  else
			  {
				  Logger.info("contract is not displayed");
				  throw new NoSuchElementException("contract is not displayed");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }
	
	
	public void selectType(String Type) throws Exception
	  {
		  try
		  {
			  if (typeDrpDwn.isDisplayed())
			  {
				  typeDrpDwn.click();
				  Select valueFromBU = new Select(typeDrpDwn);
			      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
			      if(listOfValuesBU.size() !=0)
				      {
				    	 valueFromBU.selectByVisibleText((Type));
				         Logger.info((Type)+ " type is selected"); 
				      }
			      else
			      {
			    	  Logger.info("drop down is empty");
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
	
	public void selectStatus(String status) throws Exception
	  {
		  try
		  {
			  if (statusDrpDwn.isDisplayed())
			  {
				  statusDrpDwn.click();
				  Select valueFromBU = new Select(statusDrpDwn);
			      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
			      if(listOfValuesBU.size() !=0)
				      {
				    	 valueFromBU.selectByVisibleText((status));
				         Logger.info(status+ " status is selected"); 
				      }
			      else
			      {
			    	  Logger.info("drop down is empty");
			      }
			  }
			  else
			  {
				  Logger.info("status drop down is not displayed");
				  throw new NoSuchElementException("status drop down is not displayed");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }
	
	
}
