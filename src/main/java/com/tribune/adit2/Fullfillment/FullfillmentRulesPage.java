package com.tribune.adit2.Fullfillment;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

public class FullfillmentRulesPage 
{

	@FindBy (xpath = "//li[@uib-tooltip='Routing Rules']/a/i")
	public WebElement routingRulesTab;
	
	@FindBy (xpath = "//li[@uib-tooltip='Global Rules']/a/i")
	public WebElement globalRulesTab;
	
	@FindBy (xpath = "//*[@id='routing-rules-menu']/div[1]/div/input")
	public WebElement searchFullfillmentRules;
	
	private WebDriver driver;
	
	Properties properties = TribuneUtils.readProperties();
	
	TribuneUtils utils  = new TribuneUtils();
	
	public FullfillmentRulesPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * @description This method clicks on routing rules tab
	 */
	public void clickOnRoutingRulesTab() throws Exception
	{
		try{
			if(routingRulesTab.isDisplayed()){
				routingRulesTab.click();
				Logger.info("Routing rules tab is selected");
			}else{
				Logger.info("routing rules tab is not displayed");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}
	
	/**
	 * @description This method clicks on global rules tab
	 */
	public void clickOnGlobalRulesTab() throws Exception
	{
		try{
			if(globalRulesTab.isDisplayed()){
				globalRulesTab.click();
				Logger.info("Global rules tab is selected");
			}else{
				Logger.info("Global rules tab is not displayed");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}
	
	/**
	 * @description This method is used to search for fullfillment rules (either routing rule or global rule)
	 * @param fullfillmentRuleName
	 */
	public void searchForFullfillmentRoutingRules(String fullfillmentRuleName) throws Exception
	{
		try
		{
			if(searchFullfillmentRules.isDisplayed())
			{
				searchFullfillmentRules.click();
				searchFullfillmentRules.sendKeys(properties.getProperty(fullfillmentRuleName));
				Logger.info("fullfilment routing rule name is entered in search box");
			}
			else{
				Logger.info("Fullfillemt routing rule tab is not displayed");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}
}
