package com.tribune.adit2.test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Order Entry Home Page
 * @author Priyanka Goud CR 
 * @since January 2016
 */

public class OrderPreprintOrderPandDSpecTest 
{
	/**
	 * This test will create a new insertion order for a preprint product type 
	 * with P and D specifications
	 */
	@Test(groups = {"Order"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintPandDSpec(Map<String, String> userData) throws Exception
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
		       
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryPageInstance.clickOnNewInsertionOrderBtn();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		      // newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",10, 0);
		       newOrderInstance.enterPubDate("1","28", "Dec", "2017");
		       newOrderInstance.selectProductType("1",10, 1);
		       newOrderInstance.selectProduct("1",10, 2);
		       newOrderInstance.selectAdType("1",10, 3);
		       newOrderInstance.selectSection("1",10, 4);
		       Thread.sleep(4000);
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.selectTypeInSettingsPreprintOrder("1", "Preprint_SettingsType_PDCombined");
		       newOrderInstance.selectMaterialSource("1","NewBuild");
		       newOrderInstance.checkUncheckBillQty(false);
		       newOrderInstance.enterBilledQty(3);
		       newOrderInstance.clickOnPAndDTab();
		       Thread.sleep(1000);
		       newOrderInstance.selectPandDPerforation("1", "PP_Perforation_Horizontal");
		       newOrderInstance.selectPandDFold("1", "PP_Fold_HalfFold");
		       newOrderInstance.selectPandDBindery("1", "PP_Bindery_ElasticBand");
		       newOrderInstance.selectPandDCreativeLoc("1", "PP_CreativeLoc_CentralStudio");
		       newOrderInstance.selectPandDPaperStock("1", "PP_PaperStock_60Coated");
		       newOrderInstance.selectPandDPaperColor("1", "PP_PaperColor_LightYellow");
		       newOrderInstance.selectPandDInkFront("1", "PP_InkFront_4C");
		       newOrderInstance.selectPandDInkBack("1", "PP_InkBck_SpotColor");
		       newOrderInstance.selectPandDBleed("1", "PP_Bleed_Yes");
		       newOrderInstance.selectPandDBagColor("1", "Bag_Color_White");
		       newOrderInstance.selectPandDPrinter("1", "PP_Printer_XGraphics");
		       newOrderInstance.enterPandDComments("1");
		       //newOrderInstance.addSalesPerson("SA00011");
		       newOrderInstance.submitOrder();
		       Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(3000);
		       List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));
		       WebDriverWait wait = new WebDriverWait(driver,20);
		       wait.until(ExpectedConditions.visibilityOfAllElements(list));
		       orderEntryPageInstance.getOrderNumber();
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
