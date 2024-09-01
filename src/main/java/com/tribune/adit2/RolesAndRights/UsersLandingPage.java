package com.tribune.adit2.RolesAndRights;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

public class UsersLandingPage {
	@FindBy(xpath = ("//*[@id='app']/div[3]/div[2]/div[2]/div/div[1]/div/div/input"))
	private WebElement UserNameSearch;

@FindBy(xpath = ("/html/body/div[1]/div/div/div/form/div[2]/div[2]/div/div[1]/div[1]/div/input"))
private WebElement EditRoleNameSearch;

@FindBy (xpath = "//*[@id='btnSaveTemplate']")
public WebElement SaveBtn;

@FindBy (xpath = "//li[@heading='Roles']")
public WebElement RolesTab;

@FindBy (xpath = "//input[@placeholder='Start typing a role...']")
public WebElement EditWindowRoleNameSearch;


private WebDriver driver;

Properties properties = TribuneUtils.readProperties();

TribuneUtils utils  = new TribuneUtils();

public UsersLandingPage(WebDriver driver)
{
this.driver = driver;
}

public void searchForUsers(String RoleName) throws Exception
{
try
{
	if(UserNameSearch.isDisplayed())
	{
		UserNameSearch.click();
		UserNameSearch.sendKeys(RoleName);
		Logger.info("User  name is entered in search box");
	}
	else{
		Logger.info("User Name tab is not displayed");
	}
}
catch(Exception e)
  {
	  Logger.error(e.getMessage());
	  throw e;
  } 
}
public void ClickOnEditUserButton() throws Exception {
	try
	{
		//WebElement RoleName1 = driver.findElement(By.xpath("//div[contains(@class,'ng-isolate-scope ui-grid-render-container-body')]//div[@class='ui-grid-row ng-scope']//div[not(contains(@class,'textCenter'))][contains(@class,'ui-grid-coluiGrid')][.//div[contains(@class,'ng-binding ng-scope')][text()='"+Name+"']]/following-sibling::div[contains(@class,'textCenter')]//button[contains(@class,'btn-default')]/i[@class='fa fa-pencil']"));
		//WebElement editBtn = driver.findElement(By.xpath("//button[@title='Edit']"));//swagata
		WebElement editBtn = driver.findElement(By.xpath("//button[@title='Edit']/i"));//swagata

		if(editBtn.isDisplayed())
		{
			editBtn.click();
			Logger.info("UserName Edit button is clicked");
		}
		else{
			Logger.info("UserName Edit button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}
public void ClickOnUserBUName(String Name) throws Exception {
	try
	{
		WebElement RoleName1 = driver.findElement(By.xpath("//div[@ui-grid='vm.gridOptionsBU']//div[contains(@class,'left ui-grid-render-container')]//div[@class='ui-grid-canvas']/div[contains(@ng-style,'rowRenderIndex')][count(//div[@ui-grid='vm.gridOptionsBU']//div[contains(@class,'ui-grid-render-container ng-isolate-scope')]//div[@class='ui-grid-canvas']/div[contains(@ng-style,'rowRenderIndex')][.//div[contains(@class,'ui-grid-cell-contents')][text()='"+Name+"']]/preceding-sibling::div[contains(@ng-style,'rowRenderIndex')])+1]//div[contains(@ng-click,'selectButtonClick')]"));
		if(RoleName1.isDisplayed())
		{
		
			RoleName1.click();
			Logger.info("BU button is clicked");
		}
		else{
			Logger.info("BU button is not displayed");
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
			  Logger.info("savetBtn is not displayed in customers page");
			  throw new NoSuchElementException("nextBtn is not displayed");
		  }
		
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}	

public void CheckUserRoleName(String Name) throws Exception {
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
			Logger.info("Role name  is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}
public void ClickOnRolesTab() throws Exception 

{
	  try
	  {
		  if (RolesTab.isDisplayed())
		  {
			  RolesTab.click();
			  Logger.info("Roles Tab is clicked");
		  }
		  else
		  {
			  Logger.info("Roles tab is not displayed");
			  throw new NoSuchElementException("rolesTab is not displayed");
		  }
		
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}	

public void EditWindowRoleNameSearch(String Name) throws Exception {
	try
	{
		if(EditWindowRoleNameSearch.isDisplayed())
		{
			EditWindowRoleNameSearch.click();
			EditWindowRoleNameSearch.sendKeys(Name);
			Logger.info("Roles name is entered in search box");
		}
		else{
			Logger.info("Roles Name tab is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 

	
}
public void CheckUserRoleName1(String Name) throws Exception {
	try
	{
		//Logger.info("1");
		WebElement RoleName1 = driver.findElement(By.xpath("//div[@class='tab-pane ng-scope active']//div[contains(@class,'ui-grid-selection-row-header-buttons ui-grid-icon-ok clickable ng-pristine') and @role='checkbox']"));
		
		//Logger.info("2");
		String isChecked = RoleName1.getAttribute("aria-checked");
		if(isChecked.contains("false"))
		{
			RoleName1.click();
			
			Logger.info("checked");
		}
		else{
			Logger.info("Role name   displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}
}