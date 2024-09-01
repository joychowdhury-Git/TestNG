package com.tribune.adit2.PricingAdmin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Pricing Admin Page
 * 
 * @author Sunny
 * @since Jan 2018
 */

public class PricingAdminElementIdentifiers {
	
	@FindBy (xpath = "//*[@id='insertionInfo']/form/div/table/tbody/tr[1]/td[15]/div/form/div/select")
	  public WebElement ProofTypeDD; 
	  
	  private WebDriver driver;
	  
	  Properties properties = TribuneUtils.readProperties();
	  
	  public PricingAdminElementIdentifiers(WebDriver driver)
	  {
		  this.driver = driver;
	  }
	 
	  
	 
	  public void expandZoneOptions() throws Exception
	  {
		  try
		  {
			  driver.findElement(By.xpath("(//div[starts-with(@id,'accordiongroup')]/h4/a/span/div/i)[3]")).click();
		       
				         Logger.info("Zone is expanded"); 				      
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  }
		  
	  }
	  
	  public void selectZoneOption(String Zone) throws Exception
	  {
		  try
		  {
			  driver.findElement(By.xpath("//*[contains(text(),'"+Zone+"')]")).click();
		       
				         Logger.info("Zone is selected"); 				      
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  }
		  
	  }
	  
	  public String getModifierValue() throws Exception
	  {
		  try
		  {
			  String modifierValue = driver.findElement(By.xpath("//span[@class='fc-title']")).getText();
		       
				         Logger.info("Modifier Value : "+modifierValue); 				      
			return modifierValue;
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  }
		  
	  }
	  
	  public void editSectionModifierValueSubmit(String value) throws Exception
	  {
		  try
		  {
			  driver.findElement(By.xpath("//span[@class='fc-title']")).click();
		       String modifierFieldInputXpath = ".//*[@id='sectionBaselineEdit']";
		       WebElement sectionModifier=driver.findElement(By.xpath(modifierFieldInputXpath));        			      
		       sectionModifier.click();
		       sectionModifier.clear();
		       sectionModifier.sendKeys(value);
		       driver.findElement(By.xpath("//button[text()='Submit']")).click();
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  }
		  
	  }
	  
	  public void clickRefresh() throws Exception
	  {
		  try
		  {
			  driver.findElement(By.xpath("//*[@id='btn-refresh']")).click();
		      Thread.sleep(20000);
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  }
		  
	  }
	  public void gotoProduct(String BU,String ProductType,String Product, String Section) throws InterruptedException
		{
			/*try
			{
				
				Thread.sleep(2000);
				WebElement Prodlink=driver.findElement(By.xpath("((((//*[text()='"+BU+"'])/../following-sibling::ul)//*[contains(text(),'"+ProductType+"')]/preceding-sibling::*)/../following-sibling::ul)//*[contains(text(),'"+Product+"')]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Prodlink);
				Prodlink.click();
				Logger.info("Prod Link clicked");
				
				 Thread.sleep(4000);
			}
			catch(Exception eCheck)
			{			
			*/
			try{
				String xpath1="(//*[text()='"+BU+"']/preceding-sibling::*)";		
				String xpath3="//*[text()='"+Product+"']/../i";
				String xpath4="//*[text()='"+Section+"']";
				WebElement BUlink=driver.findElement(By.xpath(xpath1));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", BUlink);
				BUlink.click();
				Logger.info("BUlink clicked");
				Thread.sleep(5000);

				//Search Product Type and Click

				try
				{
				
						String xpath="((//*[text()='"+BU+"'])/../following-sibling::ul)//*[contains(text(),'"+ProductType+"')]";
						Logger.info(xpath);
						
						WebElement ProductTypeName=driver.findElement(By.xpath(xpath));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ProductTypeName);

						String text=ProductTypeName.getText();
						Logger.info(text);
						if(text.replaceAll("\\s+", "").equals(ProductType.replaceAll("\\s+", "")))
						{
							String xpathNode="((//*[text()='"+BU+"'])/../following-sibling::ul)//*[contains(text(),'"+ProductType+"')]/preceding-sibling::*";
							
							WebElement ProductTypeLink=driver.findElement(By.xpath(xpathNode));
							
							ProductTypeLink.click();
							Logger.info("ProductTypeLink clicked");
							Thread.sleep(5000);
						}
				
							WebElement ProductLink=driver.findElement(By.xpath(xpath3));
							ProductLink.click();
							Logger.info("ProductLink clicked");
							
							WebElement SectionLink=driver.findElement(By.xpath(xpath4));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", SectionLink);
							SectionLink.click();
							Logger.info("SectionLink clicked");
							 Thread.sleep(4000);
				}
				catch(Exception e)
				{
					Logger.info(e.getMessage());
				}
			}
			catch(Exception e)
			{
				Logger.info(e.getMessage());
			}
		}
			//return null;
		//}	  
	  
}
