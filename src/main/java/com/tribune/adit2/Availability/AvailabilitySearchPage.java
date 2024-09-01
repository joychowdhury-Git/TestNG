package com.tribune.adit2.Availability;

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
 * Page Class Modeling for News Paper Layout Page
 * @author Priyanka Goud CR 
 * @since October 2015
 */

public class AvailabilitySearchPage 
{

	@FindBy(id = "businessUnitId")
	public WebElement businessUnitDrpDwn;
	
	@FindBy(id = "productTypes")
	public WebElement productType;
	
	@FindBy(id = "product")
	public WebElement productDrpDwn;

	@FindBy(id = "adtypes")
	public WebElement adType;
	
	@FindBy(id = "sections")
	public WebElement sectionDrpdwn;
	
	@FindBy(id = "fromdate")
	public WebElement fromDateInput;
	
	@FindBy(id = "todate")
	public WebElement thruDateInput;
	
	@FindBy(id = "btnSearch")
	public WebElement searchButton;
	
	@FindBy(id = "newOrder")
	public WebElement newOrderButton;
	
		
	private WebDriver driver;
	
	Properties properties = TribuneUtils.readProperties();
	
	public AvailabilitySearchPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickOnNewOrderButton() throws Exception
	  {
		  try
		  {
			  if (newOrderButton.isDisplayed())
			  {
				  newOrderButton.click();
				  Logger.info("newOrderButton Clicked");
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
	
	public void enterThruDate(String BU) throws Exception
	  {
		  try
		  {
			  if (thruDateInput.isDisplayed())
			  {
				  thruDateInput.click();
				  Thread.sleep(2000);
				  thruDateInput.sendKeys(""+BU);
				  thruDateInput.sendKeys(Keys.CONTROL, "a");
				  thruDateInput.sendKeys(Keys.CONTROL, "\b");
				  Thread.sleep(2000);
				  thruDateInput.sendKeys(""+BU);
				  Thread.sleep(2000);
				  Logger.info("To Date entered :"+BU);
			  }
			  else
			  {
				  Logger.info("To Date textbox is not displayed");
				  throw new NoSuchElementException("To Date textbox  is not displayed");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }
	
	public void enterFromDate(String BU) throws Exception
	  {
		  try
		  {
			  if (fromDateInput.isDisplayed())
			  {
				  fromDateInput.click();
				  Thread.sleep(2000);
				  fromDateInput.sendKeys(""+BU);
				  fromDateInput.sendKeys(Keys.CONTROL, "a");
				  fromDateInput.sendKeys(Keys.CONTROL, "\b");
				  Thread.sleep(2000);
				  fromDateInput.sendKeys(""+BU);
				  Thread.sleep(2000);
				  Logger.info("To Date entered :"+BU);
			  }
			  else
			  {
				  Logger.info("From Date textbox is not displayed");
				  throw new NoSuchElementException("From Date textbox  is not displayed");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }
	
//Code to select business Unit
	public void selectBU(String BU) throws Exception
	  {
		  try
		  {
			  if (businessUnitDrpDwn.isDisplayed())
			  {
				  businessUnitDrpDwn.click();
				  Select valueFromBU = new Select(businessUnitDrpDwn);
			      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
			      if(listOfValuesBU.size() !=0)
				      {
				    	 valueFromBU.selectByVisibleText((BU));
				         Logger.info((BU)+ " business Unit is selected"); 
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
	
	public void selectProductType(String BU) throws Exception
	  {
		  try
		  {
			  if (productType.isDisplayed())
			  {
				  productType.click();
				  Select valueFromBU = new Select(productType);
			      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
			      if(listOfValuesBU.size() !=0)
				      {
				    	 valueFromBU.selectByVisibleText((BU));
				         Logger.info(BU+ " productType is selected"); 
				      }
			      else
			      {
			    	  Logger.info("drop down is empty");
			      }
			  }
			  else
			  {
				  Logger.info("productType drop down is not displayed");
				  throw new NoSuchElementException("productType drop down is not displayed");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }
	
	public void selectProduct(String BU) throws Exception
	  {
		  try
		  {
			  if (productDrpDwn.isDisplayed())
			  {
				  productDrpDwn.click();
				  Select valueFromBU = new Select(productDrpDwn);
			      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
			      if(listOfValuesBU.size() !=0)
				      {
				    	 valueFromBU.selectByVisibleText((BU));
				         Logger.info(BU+ " product is selected"); 
				      }
			      else
			      {
			    	  Logger.info("drop down is empty");
			      }
			  }
			  else
			  {
				  Logger.info("product drop down is not displayed");
				  throw new NoSuchElementException("product drop down is not displayed");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }
	
	public void selectadType(String BU) throws Exception
	  {
		  try
		  {
			  if (adType.isDisplayed())
			  {
				  adType.click();
				  Select valueFromBU = new Select(adType);
			      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
			      if(listOfValuesBU.size() !=0)
				      {
				    	 valueFromBU.selectByVisibleText((BU));
				         Logger.info(BU+ " adType is selected"); 
				      }
			      else
			      {
			    	  Logger.info("drop down is empty");
			      }
			  }
			  else
			  {
				  Logger.info("adType drop down is not displayed");
				  throw new NoSuchElementException("adType drop down is not displayed");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }
	
	public void selectSectionDrpdwn(String BU) throws Exception
	  {
		  try
		  {
			  if (sectionDrpdwn.isDisplayed())
			  {
				  sectionDrpdwn.click();
				  Select valueFromBU = new Select(sectionDrpdwn);
			      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
			      if(listOfValuesBU.size() !=0)
				      {
				    	 valueFromBU.selectByVisibleText((BU));
				         Logger.info(BU+ " section is selected"); 
				      }
			      else
			      {
			    	  Logger.info("drop down is empty");
			      }
			  }
			  else
			  {
				  Logger.info("section drop down is not displayed");
				  throw new NoSuchElementException("sectionDrpdwn is not displayed");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }
}
