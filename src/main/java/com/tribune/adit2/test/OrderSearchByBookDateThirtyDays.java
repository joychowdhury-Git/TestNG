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

public class OrderSearchByBookDateThirtyDays 
{
	/**
	 * This test perform a search on orders for a particular order status
	 */
	@Test(groups = {"verifySearchByBookDateThirtyDays","searchOrders","SwagataMou","NewRegression","G1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifySearchByBookDateThirtyDays(Map<String, String> userData) throws Exception
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
		       driver.findElement(By.xpath("//label[text()='Keyword ']/../div/div/button")).click();			      
		       Thread.sleep(3000);
		     //  driver.findElement(By.xpath(".//*[@id='app']/div[3]/div[2]/div[2]/div[1]/div/div[1]/div[1]/div/div/div/ul/li[9]/label/i")).click();
		       driver.findElement(By.xpath("//label[text()='Keyword ']/../div/div/ul/li[11]/label/i")).click();
		       Thread.sleep(3000);
		       driver.findElement(By.xpath("//*[@id='keyword']")).click();
		       driver.findElement(By.xpath("//*[@id='keyword']")).sendKeys("Sunny Mukherjee");
		       Thread.sleep(2000);
		       driver.findElement(By.xpath("//*[@id='bookdateRange']")).click();
		       Thread.sleep(3000);
		       driver.findElement(By.xpath("html/body/div[3]/div[3]/ul/li[4]")).click();
		       Thread.sleep(3000);
		       orderEntryPageInstance.orderSearchBtn.click();
		       Thread.sleep(6000);
		    //   int searchcount_pre=driver.findElements(By.xpath("//div[@class='results-panel']/div")).size();
		       
		       dashboardPageInstance.clickOnNewsPaperLayoutModule();
		       Thread.sleep(4000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       Thread.sleep(4000);
		       orderEntryPageInstance.orderSearchBtn.click();
		       Thread.sleep(6000);
		       orderEntryPageInstance.orderListExportToExcelBtn.click();
		       Thread.sleep(2000);
		       String msg = orderEntryPageInstance.getConfirmationMsg();
		       Logger.info(msg);
		       boolean flag = false;
		       if(msg.contains("File exported successfully"))
		       {
		    	   flag =true;
		       }
		       
		       Assert.assertEquals(flag, true);
		       Logger.info("File Export msg validated");
		   //    int searchcount_post=driver.findElements(By.xpath("//div[@class='results-panel']/div")).size();
		     //**********************
		       
		       //orderEntryPageInstance.selectStatus("Processed");
		      /* orderEntryPageInstance.orderSearchBtn.click();
		       
		       
		       
		       String orderid=classifiedOrderInstance.OrderWithProcessedStatus.getText();
		       Logger.info("orderid="+orderid);
		       classifiedOrderInstance.OrderWithProcessedStatus.click();
		       Thread.sleep(4000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       orderEntryPageInstance.statusDropDown.click();
			  Logger.info("Status drop down is clicked");
			  Select valueFromStatus = new Select(orderEntryPageInstance.statusDropDown);
			  String status = valueFromStatus.getFirstSelectedOption().getText();
			  Logger.info(status);
			  if(searchcount_post==searchcount_pre){
				  Logger.info("Search criteria is verified");
				  Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Search criteria is not available");
		    	   Assert.assertEquals("str1","str"); 
		       }*/
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
