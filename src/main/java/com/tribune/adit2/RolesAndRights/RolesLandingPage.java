package com.tribune.adit2.RolesAndRights;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

public class RolesLandingPage {
	
	@FindBy(xpath = ("//*[@id='app']/div[3]/div[2]/div[2]/div/div[1]/div/div/input"))
			private WebElement RoleNameSearch;
	
	@FindBy(xpath = ("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/div[1]/div[1]/div/input"))
	private WebElement EditRoleNameSearch;
	
	@FindBy (xpath = "//button[@id='btnSaveTemplate']")
	public WebElement SaveBtn;
	
	@FindBy (xpath = "/html/body/div[1]/div/div/div/form/div[2]/div[2]/ul/li[2]")
	public WebElement RightsBtn;
	
	//@FindBy (xpath = "//a[text()='Rights']/../../../..//input[@class='form-control input-sm  ng-pristine ng-valid ng-empty ng-touched']")
	//public WebElement EditRoleRightsSearch;
	
	//@FindBy (xpath = "//div[@class='tab-pane ng-scope active']//*[@class='form-control input-sm  ng-pristine ng-valid ng-empty ng-touched']]")
	//public WebElement EditRoleRightsSearch;
	
	@FindBy (xpath = "//input[@placeholder='Start typing a right...']")
	public WebElement EditRoleRightsSearch;
private WebDriver driver;
	
	Properties properties = TribuneUtils.readProperties();
	
	TribuneUtils utils  = new TribuneUtils();
	
	public RolesLandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void searchForRoles(String RoleName) throws Exception
	{
		try
		{
			if(RoleNameSearch.isDisplayed())
			{
				RoleNameSearch.click();
				RoleNameSearch.sendKeys(RoleName);
				Logger.info("Role  name is entered in search box");
			}
			else{
				Logger.info("Role Name tab is not displayed");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}
	
	
	public void ClickOnEditRoleButton(String Name) throws Exception {
		try
		{
			WebElement RoleName1 = driver.findElement(By.xpath("//div[contains(@class,'ng-isolate-scope ui-grid-render-container-body')]//div[@class='ui-grid-row ng-scope']//div[not(contains(@class,'textCenter'))][contains(@class,'ui-grid-coluiGrid')][.//div[contains(@class,'ng-binding ng-scope')][text()='"+Name+"']]/following-sibling::div[contains(@class,'textCenter')]//button[contains(@class,'btn-default')]/i[@class='fa fa-pencil']"));
			if(RoleName1.isDisplayed())
			{
				RoleName1.click();
				Logger.info("RoleName Edit button is clicked");
			}
			else{
				Logger.info("RoleName Edit button not displayed");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}
	public void EditRoleWindowNameSearch(String Name) throws Exception {
		try
		{
			if(EditRoleNameSearch.isDisplayed())
			{
				EditRoleNameSearch.click();
				EditRoleNameSearch.sendKeys(Name);
				Logger.info("Role  name is entered in search box");
			}
			else{
				Logger.info("Role Name tab is not displayed");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	
		
	}
	public void ClickOnUserRoleName(String Name) throws Exception {
		try
		{Thread.sleep(4000);
			//WebElement RoleName1 = driver.findElement(By.xpath("//div[@class='tab-pane ng-scope active']//div[contains(@class,'ui-grid-render-container-left')]//div[@class='ui-grid-canvas']/div[@class='ui-grid-row ng-scope'][count(//div[@class='tab-pane ng-scope active']//div[@class='ui-grid-viewport ng-isolate-scope'][@style='overflow: hidden scroll;']/div[@class='ui-grid-canvas']/div[@class='ui-grid-row ng-scope'][.//div[contains(@class,'ui-grid-cell-contents')][text()='"+Name+"']]/preceding-sibling::div[@class='ui-grid-row ng-scope'])+1]//div[contains(@ng-click,'selectButtonClick')]"));
			WebElement RoleName = driver.findElement(By.xpath("//div[contains(text(),'"+Name+"')]"));//swagata
			if(RoleName.isDisplayed())
			{
				RoleName.click();
				Logger.info("RoleName Edit button is clicked");
			}
			else{
				Logger.info("RoleName Edit button is not displayed");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}
	
	public void ClickOnSaveButton () throws Exception 
		
			  {
				  try
				  {
					  if (SaveBtn.isDisplayed())
					  {
						  SaveBtn.click();
						  Logger.info("saveBtn is clicked");
					  }
					  else
					  {
						  Logger.info("saveBtn is not displayed");
						  throw new NoSuchElementException("saveBtn is not displayed");
					  }
					
				  }
				  catch(Exception e)
				  {
					  Logger.error(e.getMessage());
					  throw e;
				  } 
			  }	
	
	public void ClickOnRightTab() throws Exception 
	
	  {
		  try
		  {
			  if (RightsBtn.isDisplayed())
			  {
				  RightsBtn.click();
				  Logger.info("Rights Tab is clicked");
			  }
			  else
			  {
				  Logger.info("RightTab is not displayed");
				  throw new NoSuchElementException("rightTab is not displayed");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }	

public void EditRoleWindowRightsNameSearch(String Name) throws Exception {
	try
	{
		if(EditRoleRightsSearch.isDisplayed())
		{
			EditRoleRightsSearch.click();
			EditRoleRightsSearch.sendKeys(Name);
			Logger.info("Rights name is entered in search box");
		}
		else{
			Logger.info("Rights Name tab is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 

	
}
public void ClickOnRightsNameSearch(String Name) throws Exception {
	try
	{
		WebElement RightsName = driver.findElement(By.xpath("//div[@class='tab-pane ng-scope active']//div[contains(@class,'ui-grid-render-container-left')]//div[@class='ui-grid-canvas']/div[@class='ui-grid-row ng-scope'][count(//div[@class='tab-pane ng-scope active']//div[@class='ui-grid-viewport ng-isolate-scope'][@style='overflow: hidden scroll;']/div[@class='ui-grid-canvas']/div[@class='ui-grid-row ng-scope'][.//div[contains(@class,'ui-grid-cell-contents')][text()='"+Name+"']]/preceding-sibling::div[@class='ui-grid-row ng-scope'])+1]//div[contains(@ng-click,'selectButtonClick')]"));
		if(RightsName.isDisplayed())
		{
			RightsName.click();
			Logger.info("RightsName is clicked");
		}
		else{
			Logger.info("RightsName  is not clicked");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}
public void CheckUserRightsName(String Name) throws Exception {
	try
	{
		//Logger.info("1");
		WebElement RoleName1 = driver.findElement(By.xpath("//div[@class='tab-pane ng-scope active']//div[contains(@class,'ui-grid-selection-row-header-buttons ui-grid-icon-ok clickable ng-pristine') and @role='checkbox']"));
		
		//Logger.info("2");
		String isChecked = RoleName1.getAttribute("aria-checked");
		if(isChecked.contains("true"))
		{
			RoleName1.click();
			
			Logger.info("unchecked");
		}
		else{
			Logger.info("Right name  is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}
}
	
	


