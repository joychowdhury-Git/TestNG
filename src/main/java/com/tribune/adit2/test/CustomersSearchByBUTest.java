package com.tribune.adit2.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tribune.adit2.Customers.CustomerPage;
import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Order Entry Home Page
 * @author Priyanka Goud CR 
 * @since October 2015
 */

public class CustomersSearchByBUTest 
{

	/**
	 * This test perform a search customers for a particular business unit
	 */
	@Test(groups = {"CustomerSearch", "Regression"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void customerSearchByBU(Map<String, String> userData) throws Exception
	{
		try
		   {
			   WebDriver driver = WebDriverManager.getDriver();
			   Logger.info("Webdriver is initiated");
			   
			   TribuneUtils utilities = new TribuneUtils();
		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
		       utilities.implementWait(driver);
		       
		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
		       signinPageinstance.login("success");
		       
		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnCustomerModule();
		       
		       CustomerPage customerSearchPage = PageFactory.initElements(driver, CustomerPage.class);
		       customerSearchPage.selectBU("BU_T365");;
		       customerSearchPage.clickOnCustomersSearchBtn();
		      Thread.sleep(10000);
		       Logger.info("list of customer is displayed");
		       
		       // Verification if the customers for the specified BU are listed
		       WebElement table = driver.findElement(By.xpath("//div[@class='table-responsive']/table")); 
		       WebDriverWait wait = new WebDriverWait(driver, 120);
		       wait.until(ExpectedConditions.visibilityOf(table));

		       List<WebElement> column = table.findElements(By.xpath("//tbody/tr/td[3]"));
		       String expectedCellData = "TMN";
		       String numberOfResults = customerSearchPage.getCountOfCustomerSearchResults();
		       Logger.info("count of the total results found : " +numberOfResults);
		       
		       if(!column.isEmpty())
		       {
		    	   Logger.info("list is not empty");
		    	   WebDriverWait waitRows = new WebDriverWait(driver, 20);
		    	   waitRows.until(ExpectedConditions.visibilityOfAllElements(column));
		       
		    	   Iterator<WebElement> iterator= column.listIterator();
		    	   while(iterator.hasNext())
		    	   {
		    		   WebElement cell =  iterator.next() ;
		    		   String actualCellData = cell.getText();
		    		   Assert.assertEquals(actualCellData, expectedCellData);
		    	   }
		       
		       }
		       else
		       {
		    	   Logger.info("list is empty");
		       }

		       dashboardPageInstance.clickOnLogout();
		   }
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			Assert.fail();
			throw e;
		}
	}
	
}
