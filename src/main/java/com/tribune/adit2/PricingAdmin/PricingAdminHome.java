package com.tribune.adit2.PricingAdmin;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Pricing Admin Page
 * 
 * @author Sunny
 * @since Jan 2018
 */

public class PricingAdminHome {
	@FindBy(id = "btn-refresh")
	public WebElement btnRefresh;

	private WebDriver driver;

	Properties properties = TribuneUtils.readProperties();
	TribuneUtils utils = new TribuneUtils();

	public PricingAdminHome(WebDriver driver) {
		this.driver = driver;
	}

public void clickRefreshButton() throws Exception
{
	 try
	 {
		 
		 btnRefresh.click();
		 WebDriverWait wait = new WebDriverWait(driver,20);
	       
		 WebElement ele = driver.findElement(By.xpath("//*[@id='toast-container']/div/div[3]/div"));
		 wait.until(ExpectedConditions.visibilityOf(ele));
		 
		 Logger.info("Refreshed with message: "+ele.getText());
	 }
	 catch(Exception e)
	 {
		 Logger.error(e.getMessage());
		  throw e;
	 }
}

}
