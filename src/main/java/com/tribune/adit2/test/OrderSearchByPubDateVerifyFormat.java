package com.tribune.adit2.test;

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

import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.ClassifiedOrderOptions;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Order Entry Home Page
 * @author Priyanka Goud CR 
 * @since October 2015
 */

public class OrderSearchByPubDateVerifyFormat 
{
	/**
	 * This test perform a search on orders for a particular order status
	 */
	@Test(groups = {"OrderSearchByPubDateVerifyDateFormat","RegressionLatest","Grp1","Run1","Group3","NewRegression3","NewRegression","G1","searchOrders"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void OrderSearchByPubDateVerifyDateFormat(Map<String, String> userData) throws Exception
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
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       //orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       //**********************
		       //   driver.findElement(By.xpath(".//*[@id='app']/div[3]/div[2]/div[2]/div[1]/div/div[1]/div[1]/div/div/div/button")).click();
		       
		       driver.findElement(By.xpath("//*[@id='pubdateRange']")).click();
		       Thread.sleep(3000);
		      
		       String attribute =  driver.findElement(By.xpath("//*[@id='pubdateRange']")).getAttribute("format");
		       Logger.info("Pub Date Format: "+attribute);
		       Assert.assertEquals(attribute,"MM-DD-YYYY"); 
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
