package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tribune.adit2.Customers.CustomerCreatePage;
import com.tribune.adit2.Customers.CustomerPage;
import com.tribune.adit2.Customers.CustomerProfilePage;
import com.tribune.adit2.Customers.EditCustomerPage;
import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

public class CustomerAlternativeNameValidationTest {

	/**
	 * Validate that Alternative name field is allowing max 30 characters for new customer
	 *///swagata

	@Test(groups = {"alternativeNameCustomer","NewRegression3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void alternativeNameCustomer(Map<String, String> userData) throws Exception
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
			dashboardPageInstance.clickOnCustomerModule();

			CustomerPage customerSearchPage = PageFactory.initElements(driver, CustomerPage.class);
			customerSearchPage.setCustomerName(2, 0);
			customerSearchPage.clickOnCustomersSearchBtn();

			WebElement customerNameResults = driver.findElement(By.partialLinkText("Auto"));
			WebDriverWait wait = new WebDriverWait(driver,120); 
			wait.until(ExpectedConditions.visibilityOf(customerNameResults));

			String numberOfResults = customerSearchPage.getCountOfCustomerSearchResults();
			Logger.info("count of the total results found : " +numberOfResults);
			String getCustomerName = customerNameResults.getText();
			Logger.info("searched customer name: " +getCustomerName+ " with length: "+getCustomerName.length());
			Assert.assertEquals(getCustomerName.length(), 20);
			WebElement customerName1 = driver.findElement(By.linkText(getCustomerName));
			customerName1.click();
			CustomerProfilePage profileCustomer = PageFactory.initElements(driver, CustomerProfilePage.class);
			String str=profileCustomer.getCustomerCUNumber();
			EditCustomerPage EditCustomerPage = PageFactory.initElements(driver, EditCustomerPage.class);
			EditCustomerPage.clickOnCustProfileEdit();
			CustomerCreatePage customerCreate = PageFactory.initElements(driver, CustomerCreatePage.class);
			TribuneUtils utils = new TribuneUtils();
			customerCreate.enteralternativeNameTextBox(utils.generateRandomString(31));
			String name= customerCreate.alternativeName.getAttribute("value");
			Logger.info(name);
			Assert.assertEquals(name.length(),30);
			EditCustomerPage.clickOnCustProfileSave();
			profileCustomer.getCustomerID();
			Thread.sleep(3000);
			Logger.info("Customer Created with name : " + profileCustomer.getCustomerName() + " and Customer ID : "
					+ profileCustomer.getCustomerCUNumber());

			//Assert.assertEquals(str, profileCustomer.getCustomerCUNumber());
			dashboardPageInstance.clickOnLogout();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

}
