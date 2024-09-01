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

public class OrderSearchByStatusTest 
{
	/**
	 * This test perform a search on orders for a particular order status
	 */
	@Test(groups = {"OrderSearch", "Regression","Group3","performOrderSearchByStatus"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	   public void performOrderSearchByStatus(Map<String, String> userData) throws Exception
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
		       dashboardPageInstance.clickOnOrderEntryModule();
		       
		       OrderEntryHomePage orderSearch = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       WebDriverWait wait = new WebDriverWait(driver,120);
		       List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
		       wait.until(ExpectedConditions.visibilityOfAllElements(list));
		       orderSearch.selectStatus("Processed");
		       orderSearch.clickOnOrderSearchBtn();
		       Thread.sleep(2000);
		       
		       //Verification of the results
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
