package com.tribune.adit2.test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tribune.adit2.GeneralSettings.Classified;
import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.ClassifiedOrderOptions;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

import junit.framework.Assert;

public class GeneralSettings {
	@Test(groups = { "TransferOrderValidation1","GeneralSettings","PrioritizedReg2", "NewRegression","NewRegression1", "generalSettings"
			}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void TransferOrderValidation(Map<String, String> userData) throws Exception {
		try {
			WebDriver driver = WebDriverManager.getDriver();
			Logger.info("Webdriver is initiated");

			TribuneUtils utilities = new TribuneUtils();
			utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
			utilities.implementWait(driver);

			SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
			signinPageinstance.login("success");

			DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
			NewOrderPage newOrderPageInstance = PageFactory.initElements(driver, NewOrderPage.class);
			OrderEntryHomePage orderEntryHomePageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
			Classified classifiedInstance = PageFactory.initElements(driver, Classified.class);
			ClassifiedOrderOptions classifiedOrderOptionsPageInstance = PageFactory.initElements(driver,
					ClassifiedOrderOptions.class);

			classifiedInstance.clickOnGeneralSettingsSection();
			Logger.info("General Settings selected");
			Thread.sleep(4000);

			classifiedInstance.clickOnClassifiedSection();
			Logger.info("Classified Section selected");
			Thread.sleep(4000);

			classifiedInstance.clickOnClassifiedPkgSection();
			Logger.info("Classified Section selected");
			Thread.sleep(4000);

			classifiedInstance.clickGeneralSettingsHTF_BU();
			Logger.info("HTF BU selected");
			Thread.sleep(4000);

			//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.carousel-modal")));
			//Logger.info("Window switched");
			
			String winHandleBefore = driver.getWindowHandle();

			// Perform the click operation that opens new window

			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Logger.info("Window switched");
			Thread.sleep(4000);

			//classifiedInstance.selectHTFZone("New Name");
			//Logger.info("HTF Zone selected");
			//Thread.sleep(4000);
			
			classifiedInstance.clickOnGeneralSettingsSection();
			Logger.info("General Settings selected");
			Thread.sleep(4000);
			
			orderEntryHomePageInstance.clickOnNewGeneralOrder();
			Logger.info("New Order clicked");
			Thread.sleep(4000);

			newOrderPageInstance.createNewClassifiedInsertion();
			Logger.info("New Classified Package created");
			Thread.sleep(4000);
			
			classifiedOrderOptionsPageInstance.selectPackageBU("1", 13, 0);
			Logger.info("HTF BU selected");
			Thread.sleep(4000);
			
			classifiedOrderOptionsPageInstance.selectClassifiedSubcategoryDrpDwnByIndex(4);
			Logger.info("Sub Category selected");
			Thread.sleep(4000);

			classifiedOrderOptionsPageInstance.selectClassifiedProductDrpDwnByIndex(2);
			Logger.info("Product selected");
			Thread.sleep(4000);

			classifiedOrderOptionsPageInstance.selectClassifiedPackageByIndex(2);
			Logger.info("Package selected");
			Thread.sleep(4000);

			classifiedOrderOptionsPageInstance.selectClassifiedClassCodeByIndex(1);
			Logger.info("Class code selected");
			Thread.sleep(4000);
			
			classifiedOrderOptionsPageInstance.verifyCheckUncheckTM1Zone(true);
			Thread.sleep(4000);
			
			
			
		}

		catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

}
