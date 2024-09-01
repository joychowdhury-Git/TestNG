package com.tribune.adit2.test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.ClassifiedOrderOptions;
import com.tribune.adit2.OrderEntry.DigitalOrderOptions;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.Customers.CustomerPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

public class Sprint9to15 {
	@Test(groups = {"WarngMsgYesOptn","Grp2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyOrderEntryWarningMsgYes(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       
		     //***********************
		       dashboardPageInstance.clickOnOrderEntryModule();
		       Thread.sleep(3000);
		       orderEntryPageInstance.WarngMsgYesOptn.click();
		       Thread.sleep(3000);
		       
		       if((orderEntryPageInstance.orderSearchBtn).isDisplayed()){
		    	   Logger.info("YES option of warning message is working correctly");
		    	   Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("YES option of warning message is not working correctly");
		    	   Assert.assertEquals("str1","str"); 
		       }
		    	   
		     //***********************
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"WarngMsgNoOptn","Grp2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyOrderEntryWarningMsgNo(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       
		     //***********************
		       dashboardPageInstance.clickOnOrderEntryModule();
		       Thread.sleep(3000);
		       orderEntryPageInstance.WarngMsgNoOptn.click();
		       Thread.sleep(3000);
		       
		       if((newOrderInstance.NewOrderHeaderTxt).isDisplayed()){
		    	   Logger.info("NO option of warning message is working correctly");
		    	   Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("NO option of warning message is not working correctly");
		    	   Assert.assertEquals("str1","str"); 
		       }
		    	   
		     //***********************
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"ADSSURL","Grp2","Sprint9to15"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyADSSURL(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewClassifiedInsertion();
		       Thread.sleep(4000);		      
		       
		       Thread.sleep(4000);
		       classifiedOrderInstance.selectPackageBU("5",1, 0);
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwnByIndex(1);
		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
		       Thread.sleep(2000);
		       //driver.quit();
		       classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(1);
		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedPackageByIndex(1);
		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
		       classifiedOrderInstance.selectDate("nextmonth");
		       classifiedOrderInstance.clickApplyBtn();
		       Thread.sleep(15000);
		       
		       classifiedOrderInstance.clickEditAdBtn();
		       
		       String adssurl= driver.findElement(By.xpath("//div[@class='modal-body no-padder']/iframe"))
		    		   				.getAttribute("ng-src");
		       Logger.info("adssurl:"+adssurl);
		       if(adssurl.contains("adss")){
		    	   Logger.info("URL contains ADSS");
		    	   Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("URL doesnot contain ADSS");
		    	   Assert.assertEquals("str1","str"); 
		       }		    	   
		     //***********************		      
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"OrderStatusDrpDwn1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyOrderStatusDrpDwnValue1(Map<String, String> userData) throws Exception
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
		       
		       orderEntryPageInstance.selectStatus("Processed");
		       orderEntryPageInstance.orderSearchBtn.click();
		       
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
			  if(status.equalsIgnoreCase("Processed")){
				  Logger.info("Order status value is verified successfully");
				  Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Order status value is not displayed correctly");
		    	   Assert.assertEquals("str1","str"); 
		       }
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"SearchBySalesRep","RegressionLatest","Sprint9to15","Grp1","Run1","Group3","TestPriority"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifySearchBySalesRep(Map<String, String> userData) throws Exception
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
		       driver.findElement(By.xpath("//label[text()='Keyword ']/../div/div/ul/li[14]/label/i")).click();
		       Thread.sleep(3000);
		       driver.findElement(By.xpath(".//*[@id='keyword']")).click();
		       driver.findElement(By.xpath(".//*[@id='keyword']")).sendKeys("Hall,Brian");
		       orderEntryPageInstance.orderSearchBtn.click();
		       Thread.sleep(6000);
		       int searchcount_pre=driver.findElements(By.xpath("//div[@class='results-panel']/div")).size();
		       
		       orderEntryPageInstance.clickOnSearchedOrder();
		       Thread.sleep(7000);
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		      
		       Thread.sleep(3000);
	    	   
	    	   Thread.sleep(4000);
			      // newOrderInstance.selectSection("1",18, 4);
			     //  Thread.sleep(4000);
			       newOrderInstance.viewInsertionDetails("1");
			       Thread.sleep(4000);
			       String salesRepOnInsertion = newOrderInstance.getSalesRepOnInsertion(1);
			       Logger.info("salesRepOnInsertion " +salesRepOnInsertion);
			       Assert.assertEquals(salesRepOnInsertion, "Hall,Brian");
			       Thread.sleep(2000);
		       dashboardPageInstance.clickOnNewsPaperLayoutModule();
		      /* String orderid=classifiedOrderInstance.OrderWithProcessedStatus.getText();
		       Logger.info("orderid="+orderid);
		       classifiedOrderInstance.OrderWithProcessedStatus.click();*/
		       Thread.sleep(4000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       Thread.sleep(4000);
		       orderEntryPageInstance.orderSearchBtn.click();
		       Thread.sleep(6000);
		       int searchcount_post=driver.findElements(By.xpath("//div[@class='results-panel']/div")).size();
		      
			  if(searchcount_post==searchcount_pre){
				  Logger.info("Search criteria is verified");
				  Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Search criteria is not available");
		    	   Assert.assertEquals("str1","str");

		    	  
		       }
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"BUDDValueinOrderEntryPage","Grp2","Sprint9to15","Group4F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyBUDDValueinOrderEntryPage(Map<String, String> userData) throws Exception
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
		       
		       orderEntryPageInstance.selectBussinessUnit("DPR-Daily Press");
		       
		       orderEntryPageInstance.selectStatus("Processed");
		       
		       orderEntryPageInstance.orderSearchBtn.click();
		       Thread.sleep(4000);
		      
		       String orderid=classifiedOrderInstance.OrderWithProcessedStatus.getText();
		       Logger.info("orderid="+orderid);
		       orderEntryPageInstance.clickOnOrder(orderid);
		       Thread.sleep(4000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       orderEntryPageInstance.businessUnitDropDown.click();
			  Logger.info("BU drop down in Order Entry Page is clicked");
			  Select valueFromStatus = new Select(orderEntryPageInstance.businessUnitDropDown);
			  String status = valueFromStatus.getFirstSelectedOption().getText();
			  Logger.info(status);
			  if(status.equalsIgnoreCase("DPR-Daily Press")){
				  Logger.info("BU DropDown value is verified successfully");
				  Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("BU DropDown value is not displayed correctly");
		    	   Assert.assertEquals("str1","str"); 
		       }
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"OrderStatusDrpDwn","Grp2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyOrderStatusDrpDwnValue(Map<String, String> userData) throws Exception
	{
		try
		   {
			//**********************
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
		       
		       orderEntryPageInstance.selectStatus("Processed");
		       orderEntryPageInstance.orderSearchBtn.click();
		       
			driver.findElement(By.xpath("//label[text()='Keyword ']/following-sibling::div/div/button"))
					.click();
			
			List<WebElement> filterList= driver.findElements(By.xpath
					("//label[text()='Keyword ']/following-sibling::div/div/ul/li"));
			
			for(int i=1; i<=filterList.size(); i++){
			  String str= driver.findElement(By.xpath
						("//label[text()='Keyword ']/following-sibling::div/div/ul/li["+i+"]/label")).getText();	
				if(str.equals("Sales Person                     ")){
					driver.findElement(By.xpath
						("//label[text()='Keyword ']/following-sibling::div/div/ul/li["+i+"]/label/input")).click();
					break;
				}//end of IF
			}//end of FOR
			//**********************
			
			   
		       
		       /*String orderid=classifiedOrderInstance.OrderWithProcessedStatus.getText();
		       Logger.info("orderid="+orderid);
		       classifiedOrderInstance.OrderWithProcessedStatus.click();
		       Thread.sleep(4000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       
		       
		       
		       orderEntryPageInstance.statusDropDown.click();
			  Logger.info("Status drop down is clicked");
			  Select valueFromStatus = new Select(orderEntryPageInstance.statusDropDown);
			  String status = valueFromStatus.getFirstSelectedOption().getText();
			  Logger.info(status);
			  if(status.equalsIgnoreCase("Processed")){
				  Logger.info("Order status value is verified successfully");
				  Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Order status value is not displayed correctly");
		    	   Assert.assertEquals("str1","str"); 
		       }*/
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"NewClassifiedOrderProofType","Grp2","RegFailed1","testclasssified"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewClassifiedOrderwithProofType(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewClassifiedInsertion();
		       Thread.sleep(4000);		      
		       
		       Thread.sleep(4000);
		       classifiedOrderInstance.selectPackageBU("5",1, 0);
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5",1, 1);
		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
		       Thread.sleep(2000);
		       //driver.quit();
		       classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(13);
		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedPackageByIndex(2);
		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
		       classifiedOrderInstance.selectDate("nextmonth");
		       classifiedOrderInstance.selectSingleZone();		       
		       classifiedOrderInstance.clickApplyBtn();

		       Thread.sleep(25000);		       
		       //***********************
		       classifiedOrderInstance.verifyInsertionPrice("Non-Legal");

		       classifiedOrderInstance.clickEditAdBtn();

		       Thread.sleep(20000);
		       classifiedOrderInstance.uploadAd("5",1,6);
		       classifiedOrderInstance.enterAttributeDetails();		       
		       //*********
		       classifiedOrderInstance.clickLockOrderLinesChckBox();
		       
		       classifiedOrderInstance.enterProofType();
		      // *********
		       
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(2, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(2);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       //Thread.sleep(2000);
		       //newOrderInstance.confirmToMakeOrderFree();
		       Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"NewDigitalOrderOrderRouting","Grp2","RegressionLatest","Sprint9to15","Group4","TestPriority"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyOrderRoutingofDigitalOrder(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewDigitalOrder();
		       Thread.sleep(4000);

		       digitalOrderInstance.selectPackageBU("6",1, 0);
		       Thread.sleep(2000);
		       
		       digitalOrderInstance.selectDigitalProductDrpDwn("6",1, 1);
		       digitalOrderInstance.selectDigitalChargeDayDrpDwn(1);
		       
		       digitalOrderInstance.clickApplyBtn();
		       Thread.sleep(15000);
		       //WebDriverWait wait = new WebDriverWait(driver,200);		       
		       //wait.until(ExpectedConditions.elementToBeClickable(newOrderInstance.submitOrderButton));
		       //***********************
		       
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(3, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(3);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       //Thread.sleep(2000);
		       //newOrderInstance.confirmToMakeOrderFree();
		       Thread.sleep(2000);
		       String orderid= orderEntryPageInstance.getOrderID();
		       Logger.info("Order:"+orderid);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);		       
		       orderEntryPageInstance.clickOnOrder(orderid);
		       Thread.sleep(7000);
		       String orderrouting=newOrderInstance.orderRouting.getText();
		       Thread.sleep(2000);
		       
		       if(orderrouting.equalsIgnoreCase("Bill Only")){
		    	   Logger.info("Correct OrderRouting info is displayed");
		    	   Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("InCorrect OrderRouting info is displayed");	       
		    	   Assert.assertEquals("str","str1");
		       }
		       
		       dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"NewClassifiedOrderImgUploadinAd","Grp2","classifiedOrders","SwagataMou","RegressionLatest","Sprint9to15","Group4","RegFailed1","Group4F","testclasssified","G5","RerunF2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewClassifiedOrderwithImgUploadinAd(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewClassifiedInsertion();
		       Thread.sleep(4000);		      
		       
		       Thread.sleep(4000);
		       classifiedOrderInstance.selectPackageBU("5",1, 0);
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5",1, 1);
		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
		       Thread.sleep(2000);
		       //driver.quit();
		       classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(13);
		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedPackageByIndex(2);
		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
		       classifiedOrderInstance.selectDate("nextmonth");
		       classifiedOrderInstance.selectSingleZone();		       
		       classifiedOrderInstance.clickApplyBtn();

		       Thread.sleep(25000);		       
		       //***********************
		       classifiedOrderInstance.clickEditAdBtn();

		       Thread.sleep(10000);
		       //classifiedOrderInstance.uploadAd("5",6,6);
		       
		     //*********
		       classifiedOrderInstance.verifyUploadAdErrorMsg("5",6,6,"image");
		    // *********
		       /*classifiedOrderInstance.enterAttributeDetails();		       
		       
		       classifiedOrderInstance.clickLockOrderLinesChckBox();
		       
		       classifiedOrderInstance.enterProofType();
		      
		       
		       newOrderInstance.clickonApplyAllInsertions();
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       //Thread.sleep(2000);
		       //newOrderInstance.confirmToMakeOrderFree();
		       Thread.sleep(3000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       dashboardPageInstance.clickOnLogout();*/
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"arkadeep","classifiedOrders","ErrMsgOversizedDocUploadinAd","Grp2","RegressionLatest","Sprint9to15","Group4","RegFailed1","Group4F","NewRegression3","NewRegression","G5","RerunF2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyErrMsgOversizedDocUploadinAd(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewClassifiedInsertion();
		       Thread.sleep(4000);		      
		       
		       //Thread.sleep(4000);//swagata
		       classifiedOrderInstance.selectPackageBU("5",1, 0);
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5",1, 1);
		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
		       Thread.sleep(2000);
		       //driver.quit();
		       classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(13);
		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedPackageByIndex(2);
		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
		       classifiedOrderInstance.selectDate("nextmonth");
		       classifiedOrderInstance.selectSingleZone();		       
		       classifiedOrderInstance.clickApplyBtn();

		       Thread.sleep(25000);		       
		       //***********************
		       classifiedOrderInstance.clickEditAdBtn();

		       Thread.sleep(10000);
		       //classifiedOrderInstance.uploadAd("5",6,6);
		       
		     //*********
		       classifiedOrderInstance.verifyUploadAdErrorMsg("5",7,6,"oversize");
		    // *********		       
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	//arka
	/*
	@Test(groups = {"verifyClassifiedParametersDD","testclasssified","Classified1","Grp2","RegFailed1","NewRegression","G5","RerunF2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyClassifiedParametersDD(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewClassifiedInsertion();
		       Thread.sleep(4000);

		       classifiedOrderInstance.selectPackageBU("5",1, 0);
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5",1, 1);
		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
		       Thread.sleep(2000);
		       //driver.quit();
		       classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(13);
		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedPackageByIndex(2);
		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
		       classifiedOrderInstance.selectDate("nextmonth");
		       classifiedOrderInstance.selectSingleZone();		       
		       classifiedOrderInstance.clickApplyBtn();

		       Thread.sleep(25000);		       
		       //***********************
		       classifiedOrderInstance.clickEditAdBtn();

		       Thread.sleep(10000);
		       classifiedOrderInstance.uploadAd("5",1,6);;
		       classifiedOrderInstance.enterAttributeDetails();		       		       
		       newOrderInstance.clickonApplyAllInsertions();
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();		       
		       Thread.sleep(2000);
		       String orderid=orderEntryPageInstance.getOrderID();
		       Logger.info("orderid:"+orderid);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);		       
		       orderEntryPageInstance.clickOnOrder(orderid);
		       Thread.sleep(7000);

		       classifiedOrderInstance.verifyClassifiedParametersDDStatus();
		       /*classifiedOrderInstance.clickLockOrderLinesChckBox();
		       classifiedOrderInstance.clickOrderMoreOptions();
		       int previnsertioncount=classifiedOrderInstance.clickDuplicateOrderLink();
		       Thread.sleep(10000);
		       classifiedOrderInstance.verifyDuplicateOrder(previnsertioncount);
		       Thread.sleep(70000);
		       WebDriverWait wait = new WebDriverWait(driver,200);		       
		       wait.until(ExpectedConditions.elementToBeClickable(newOrderInstance.submitOrderButton));
		       newOrderInstance.submitOrder();
		       Thread.sleep(10000);
		       String orderstatus=orderEntryPageInstance.getOrderStatus(orderid);
		       
		       if(orderstatus.contains("Change") || orderstatus.contains("change")){
		         Logger.info("Order modified successfully");
		    	   Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Order is not modified");	       
		    	   Assert.assertEquals("str","str1");
		       }
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	*/
	@Test(groups = {"arkadeep","SwagataMou","classifiedOrders","verifyClassifiedParametersDD","ScriptResult","testclasssified","Classified1","Grp2","RegFailed1","G5","RerunF2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyClassifiedParametersDD(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       
		      // newOrderInstance.selectSoldToCustomerBU("bu_LAT");//change
		       newOrderInstance.selectSoldToCustomerBU("bu_CTC");//swagata 
		       newOrderInstance.enterSoldToCustomer("CU00037236");//swagata
		       
		      // newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewClassifiedInsertion();
		       Thread.sleep(4000);

		       classifiedOrderInstance.selectPackageBU("5",1, 0);
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5",1, 1);
		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
		       Thread.sleep(2000);
		       //driver.quit();
		       classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(13);
		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedPackageByIndex(2);
		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
		       Thread.sleep(2000);	//swagata
		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
		       classifiedOrderInstance.selectDate("nextmonth");
		       Thread.sleep(2000);	//swagata
		       classifiedOrderInstance.selectSingleZone();
		       Thread.sleep(2000);	//swagata
		       classifiedOrderInstance.clickApplyBtn();

		       Thread.sleep(25000);		       
		       //***********************
		       classifiedOrderInstance.clickEditAdBtn();

		       Thread.sleep(20000);
		       classifiedOrderInstance.uploadAd("5",1,6);
		       Thread.sleep(10000);
		      
		      

		     //classifiedOrderInstance.enterAttributeDetails();//swagata 
		     classifiedOrderInstance.enterAttributeDetailsCTC();//swagata 
		     newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);
		     

				newOrderInstance.addNewSalesRepOnInsertionClassified(1, "SA00856");//swagata 
				Thread.sleep(2000);//swagata 
				newOrderInstance.clickOnInsertionSalesRepSection(1);//swagata 
				Thread.sleep(2000);//swagata
				newOrderInstance.applytoAllSalesRepOnInsertionClassified(1);//swagata 
				
		     
		      // newOrderInstance.clickonApplyAllInsertions();//swagata new
		       Thread.sleep(4000);
		       newOrderInstance.submitOrder();		       
		       //Thread.sleep(8000);//swagata new 
		       /*String orderid=orderEntryPageInstance.getOrderID();
		       Logger.info("orderid:"+orderid);
		       Thread.sleep(8000);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);		       
		       orderEntryPageInstance.clickOnOrder(orderid);
		       Thread.sleep(7000);*///swagata new
				 String orderID = orderEntryPageInstance.getOrderID();//swagata 
			       Logger.info("Order: "+orderID);//swagata 
			       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();//swagata 
			       Thread.sleep(2000);
			       List<WebElement> list = driver.findElements(By.xpath("//div[@class='row ng-scope']"));//swagata
			       WebDriverWait wait = new WebDriverWait(driver,200);//swagata
			       wait.until(ExpectedConditions.visibilityOfAllElements(list));//swagata
			       orderEntryPageInstance.clickOnOrder(orderID);//swagata
			       
			       Thread.sleep(13000);
			     

		       classifiedOrderInstance.verifyClassifiedParametersDDStatus();
		       /*classifiedOrderInstance.clickLockOrderLinesChckBox();
		       classifiedOrderInstance.clickOrderMoreOptions();
		       int previnsertioncount=classifiedOrderInstance.clickDuplicateOrderLink();
		       Thread.sleep(10000);
		       classifiedOrderInstance.verifyDuplicateOrder(previnsertioncount);
		       Thread.sleep(70000);
		       WebDriverWait wait = new WebDriverWait(driver,200);		       
		       wait.until(ExpectedConditions.elementToBeClickable(newOrderInstance.submitOrderButton));
		       newOrderInstance.submitOrder();
		       Thread.sleep(10000);
		       String orderstatus=orderEntryPageInstance.getOrderStatus(orderid);
		       
		       if(orderstatus.contains("Change") || orderstatus.contains("change")){
		         Logger.info("Order modified successfully");
		    	   Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Order is not modified");	       
		    	   Assert.assertEquals("str","str1");
		       }*/
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"arkadeep","SDT1ImgKill","Grp2","RegressionLatest","Sprint9to15","Group4","RegFailed1","Group4F","G5"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyPriceChangefor1ImgandKill(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewClassifiedInsertion();
		       Thread.sleep(4000);		      
		       
		       Thread.sleep(4000);
		       classifiedOrderInstance.selectPackageBU("5",6, 0);
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5",6, 1);
		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
		       Thread.sleep(2000);
		       //driver.quit();
		       classifiedOrderInstance.selectClassifiedProductDrpDwn("5",6, 2);
		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedPackage("5",6, 3);
		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedClassCode("5",6, 4);
		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectMultipleZone();
		       classifiedOrderInstance.selectDate("nextmonth");
		       classifiedOrderInstance.clickApplyBtn();

		       Thread.sleep(40000);
		       //***********************
		       //classifiedOrderInstance.verifyInsertionPrice("Non-Legal");

		       classifiedOrderInstance.clickEditAdBtn();

		       Thread.sleep(15000);
		       classifiedOrderInstance.uploadAd("5",1,6);//swagata

		       Thread.sleep(10000);
		       //classifiedOrderInstance.uploadAd("5",1,6);
		       String prev_price=driver.findElement(By.xpath("//span[text()='Total Amount:']/following-sibling::span"))
		    		   .getText();
		       classifiedOrderInstance.enterSDTAttributeDetails1Img(1);
		       String new_price=driver.findElement(By.xpath("//span[text()='Total Amount:']/following-sibling::span"))
		    		   .getText();
		       prev_price= prev_price.substring(1);
		       new_price= new_price.substring(1);
		       
		       Float prev_price_f= Float.valueOf(prev_price);
		       Float new_price_f= Float.valueOf(new_price);
		       
		       Logger.info("prev_price:"+prev_price+" new_price:"+new_price);
		       Logger.info("prev_price_f:"+prev_price_f+" new_price_f:"+new_price_f);
		       Logger.info(String.valueOf(new_price_f-prev_price_f));
		       if((new_price_f-prev_price_f)==0.00){
		    	   Logger.info("Price has not increased by $10");
		    	   //Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Price has increased");
		    	   Assert.assertEquals("str1","str");
		       }newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();		       
		       Thread.sleep(3000);
		       String orderid=orderEntryPageInstance.getOrderID();
		       Logger.info("orderid:"+orderid);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);		       
		       orderEntryPageInstance.clickOnOrder(orderid);
		       Thread.sleep(7000);
		       newOrderInstance.clickOnKill();
		       newOrderInstance.clickOnKillOnConfirmation();
		       String postKill_price=driver.findElement(By.xpath("//span[text()='Total Amount:']/following-sibling::span"))
		    		   .getText();
		       Logger.info("postKill_price:"+ postKill_price);
		       if(postKill_price.equals("$0.00")){
		    	   Logger.info("Price has been set to $0 post order kill");
		    	   Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Price has not been set to $0 post order kill");
		    	   Assert.assertEquals("str1","str");
		       }
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"SDT6ImgKill","Grp2","RegressionLatest","Sprint9to15","Group4","RegFailed1","Group4F","G5"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyPriceChangefor6ImgandKill(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewClassifiedInsertion();
		       Thread.sleep(4000);		      
		       
		       Thread.sleep(4000);
		       classifiedOrderInstance.selectPackageBU("5",6, 0);
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5",6, 1);
		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
		       Thread.sleep(2000);
		       //driver.quit();
		       classifiedOrderInstance.selectClassifiedProductDrpDwn("5",6, 2);
		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedPackage("5",6, 3);
		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedClassCode("5",6, 4);
		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectMultipleZone();
		       classifiedOrderInstance.selectDate("nextmonth");
		       classifiedOrderInstance.clickApplyBtn();

		       Thread.sleep(30000);
		       //***********************
		       //classifiedOrderInstance.verifyInsertionPrice("Non-Legal");

		       classifiedOrderInstance.clickEditAdBtn();

		       Thread.sleep(15000);
		       classifiedOrderInstance.uploadAd("5",1,6);

		       Thread.sleep(10000);
		       //classifiedOrderInstance.uploadAd("5",1,6);
		       /*String prev_price=driver.findElement(By.xpath("//span[text()='Total Amount:']/following-sibling::span"))
		    		   .getText();*/
		       classifiedOrderInstance.enterSDTAttributeDetails6Img(6);
		       /*String new_price=driver.findElement(By.xpath("//span[text()='Total Amount:']/following-sibling::span"))
		    		   .getText();
		       prev_price= prev_price.substring(1);
		       new_price= new_price.substring(1);
		       
		       Float prev_price_f= Float.valueOf(prev_price);
		       Float new_price_f= Float.valueOf(new_price);
		       
		       Logger.info("prev_price:"+prev_price+" new_price:"+new_price);
		       Logger.info("prev_price_f:"+prev_price_f+" new_price_f:"+new_price_f);

		       if((new_price_f-prev_price_f)==10.00){
		    	   Logger.info("Price has increased by $10");
		    	   //Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Price has not increased by $10");
		    	   Assert.assertEquals("str1","str");
		       }*/
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();		       
		       Thread.sleep(2000);
		       String orderid=orderEntryPageInstance.getOrderID();
		       Logger.info("orderid:"+orderid);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);		       
		       orderEntryPageInstance.clickOnOrder(orderid);
		       Thread.sleep(7000);
		       newOrderInstance.clickOnKill();
		       newOrderInstance.clickOnKillOnConfirmation();
		       String postKill_price=driver.findElement(By.xpath("//span[text()='Total Amount:']/following-sibling::span"))
		    		   .getText();
		       Logger.info("postKill_price:"+ postKill_price);
		       if(postKill_price.equals("$0.00")){
		    	   Logger.info("Price has been set to $0 post order kill");
		    	   Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Price has not been set to $0 post order kill");
		    	   Assert.assertEquals("str1","str");
		       }
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"DisplayOrderDocUpload","Grp2","RegFailed1","Group4F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderDocUpload(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
		       Thread.sleep(3000);
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_CTC");
		       newOrderInstance.enterSoldToCustomer("CU00037236");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",17, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2019");
		       newOrderInstance.selectProductType("1",17, 1);
		       newOrderInstance.selectProduct("1",17, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",17, 3);
		       newOrderInstance.selectSection("1",17, 4);
		       Thread.sleep(4000);
		       
		       newOrderInstance.uploadDoc("6",1, 4);
		       Thread.sleep(3000);
		       newOrderInstance.verifyDocUpload();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"PreprintOrderDocUpload","Sprint9to15","Grp1","Pre1","RegFailed1","Group4F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderDocUpload(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",10, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2019");
		       newOrderInstance.selectProductType("1",10, 1);
		       newOrderInstance.selectProduct("1",10, 2);
		       Thread.sleep(3000);
		       newOrderInstance.selectAdType("1",10, 3);
		       Thread.sleep(10000);
		       newOrderInstance.selectSection("1",10, 4);
		       Thread.sleep(8000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       newOrderInstance.selectMaterialSource("1","N/A");
		       newOrderInstance.clickOnDistributions(1);
		       Thread.sleep(44000);
		       newOrderInstance.selectZonePreprintOrder("Full");
		       newOrderInstance.confirmZoneSelection();	
		       int distributionsCount = newOrderInstance.getDistributionsAdded();
		       Logger.info("distributionsCount "+distributionsCount);
		       //**********************************
		       newOrderInstance.uploadDoc("6",1, 4);
		       Thread.sleep(3000);
		       newOrderInstance.verifyDocUpload();
		       //************************************
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"onlineOrderUploadDoc","PriorityDFP"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void onlineOrderUploadDoc(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",9, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2019");
		       newOrderInstance.selectProductType("1",9, 1);
		       newOrderInstance.selectProduct("1",9, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",9, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("1",9, 4);
		       Thread.sleep(4000);
		       
		     //**********************************
		       newOrderInstance.uploadDoc("6",1, 4);
		       Thread.sleep(3000);
		       newOrderInstance.verifyDocUpload();
		       //************************************
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"OrderUploadDocErrMsg","Grp2","RegressionLatest","Sprint9to15","Group4","RegFailed1","Group4F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void OrderUploadDocErrMsg(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		     //**********************************
		       newOrderInstance.uploadDoc("6",1, 4);
		       Thread.sleep(3000);
		       newOrderInstance.verifyUploadDocErrMsg();
		       //************************************
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"OrderUploadPDFErrMsg","Grp2","RegressionLatest","Sprint9to15","Group4","RegFailed1","Group4F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void OrderUploadPDFErrMsg(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		     //**********************************
		       newOrderInstance.uploadDoc("6",1, 3);
		       Thread.sleep(3000);
		       newOrderInstance.verifyUploadDocErrMsg();
		       //************************************
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"AltDigitalOrderDocUpload","Grp2","RegressionLatest","Sprint9to15","Group4","RegFailed1","Group4F"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void AltDigitalOrderDocUpload(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
		       Thread.sleep(3000);
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_CTC");
		       newOrderInstance.enterSoldToCustomer("CU00037236");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",37, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2019");
		       newOrderInstance.selectProductType("1",37, 1);
		       //newOrderInstance.selectProduct("1",37, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",37, 3);
		       newOrderInstance.selectSection("1",37, 4);
		       Thread.sleep(4000);
		       
		       newOrderInstance.uploadDoc("6",1, 4);
		       Thread.sleep(3000);
		     //  newOrderInstance.verifyDocUpload();
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       //Thread.sleep(2000);
		       //newOrderInstance.confirmToMakeOrderFree();
		       Thread.sleep(2000);
		       Logger.info("Order:"+orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"DisplayOrderCopyAccntInfo","Grp2","RegFailed3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderCopyAccntInfo(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
		       Thread.sleep(3000);
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_CTC");
		       newOrderInstance.enterSoldToCustomer("CU00037236");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",17, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2019");
		       newOrderInstance.selectProductType("1",17, 1);
		       newOrderInstance.selectProduct("1",17, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",17, 3);
		       newOrderInstance.selectSection("1",17, 4);
		       Thread.sleep(4000);
		       
		       String billToName= driver.findElement(By.xpath
		    		   (".//*[@id='order-detail-page']/div[2]/div[1]/div[1]/div/div/div[2]/div/form/div[1]/div[2]/div[2]/div/p")).getText();
		       String soldToName= driver.findElement(By.xpath
		    		   (".//*[@id='order-detail-page']/div[2]/div[1]/div[1]/div/div/div[2]/div/form/div[2]/div[2]/div[2]/div/p")).getText();
		   
		       newOrderInstance.saveOrderBtn.click();
		       Thread.sleep(4000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       Thread.sleep(4000);
		       driver.findElement(By.xpath("(//button[text()='More'])[1]")).click();
		       Thread.sleep(2000);
		       driver.findElement(By.xpath("(//a[text()='Copy Account To Order'])[1]")).click();
		       Thread.sleep(5000);
		       String billToNamePostCopy= driver.findElement(By.xpath
		    		   (".//*[@id='order-detail-page']/div[2]/div[1]/div[1]/div/div/div[2]/div/form/div[1]/div[2]/div[2]/div/p")).getText();
		       String soldToNamePostCopy= driver.findElement(By.xpath
		    		   (".//*[@id='order-detail-page']/div[2]/div[1]/div[1]/div/div/div[2]/div/form/div[2]/div[2]/div[2]/div/p")).getText();
		   
		       if(billToName.equalsIgnoreCase(billToNamePostCopy))
		    	   if(soldToName.equalsIgnoreCase(soldToNamePostCopy)){
		    		   Logger.info("Account info is copied successfully");
		    		   Assert.assertEquals("str","str");
		    	   }else{
		    		   Logger.info("Account info is not copied successfully");
		    		   Assert.assertEquals("str1","str");
		    	   }
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"OnlineOrderCopyAccntInfo","Grp2","RegressionLatest","Sprint9to15","Group1","PriorityDFP","RegFailed3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void onlineOrderCopyAccntInfo(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",9, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2019");
		       newOrderInstance.selectProductType("1",9, 1);
		       newOrderInstance.selectProduct("1",9, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",9, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("1",9, 4);
		       Thread.sleep(4000);
		       
		     //**********************************
		       String billToName= driver.findElement(By.xpath
		    		   ("//*[@id='accountInfo']/div/form/div[2]/div[2]/div[2]/div/p")).getText();
		       String soldToName= driver.findElement(By.xpath
		    		   ("..//*[@id='accountInfo']/div/form/div[1]/div[2]/div[2]/div/p")).getText();
		   
		       newOrderInstance.saveOrderBtn.click();
		       Thread.sleep(4000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       Thread.sleep(4000);
		       driver.findElement(By.xpath("(//button[text()='More'])[1]")).click();
		       Thread.sleep(2000);
		       driver.findElement(By.xpath("(//a[text()='Copy Account To Order'])[1]")).click();
		       Thread.sleep(5000);
		       String billToNamePostCopy= driver.findElement(By.xpath
		    		   ("//*[@id='accountInfo']/div/form/div[2]/div[2]/div[2]/div/p")).getText();
		       String soldToNamePostCopy= driver.findElement(By.xpath
		    		   (".//*[@id='accountInfo']/div/form/div[1]/div[2]/div[2]/div/p")).getText();
		   
		       if(billToName.equalsIgnoreCase(billToNamePostCopy))
		    	   if(soldToName.equalsIgnoreCase(soldToNamePostCopy)){
		    		   Logger.info("Account info is copied successfully");
		    		   Assert.assertEquals("str","str");
		    	   }else{
		    		   Logger.info("Account info is not copied successfully");
		    		   Assert.assertEquals("str1","str");
		    	   }
		       //************************************
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"OnlineOrderCopyAccntInfoSubmit","Grp2","RegressionLatest","Sprint9to15","Group1","PriorityDFP","RegFailed3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void onlineOrderCopyAccntInfoPostSubmit(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",9, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2019");
		       newOrderInstance.selectProductType("1",9, 1);
		       newOrderInstance.selectProduct("1",9, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",9, 3);
		       Thread.sleep(2000);
		      // newOrderInstance.selectSection("1",9, 4);
		      // Thread.sleep(4000);
		       
		     //**********************************
		       String billToName= driver.findElement(By.xpath
		    		   (".//*[@id='accountInfo']/div/form/div[2]/div[2]/div[2]/div/p")).getText();
		       String soldToName= driver.findElement(By.xpath
		    		   (".//*[@id='accountInfo']/div/form/div[1]/div[2]/div[2]/div/p")).getText();
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		     
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       //Thread.sleep(2000);
		       Thread.sleep(4000);

		       //orderEntryPageInstance.clickOnOrder(orderID);
		       //dashboardPageInstance.clickOnOrderEntryModule();
		       //Thread.sleep(4000);
		       driver.findElement(By.xpath("(//button[text()='More'])[1]")).click();
		       Thread.sleep(2000);
		       driver.findElement(By.xpath("(//a[text()='Copy Account To Order'])[1]")).click();
		       Thread.sleep(5000);
		       String billToNamePostCopy= driver.findElement(By.xpath
		    		   (".//*[@id='accountInfo']/div/form/div[2]/div[2]/div[2]/div/p")).getText();
		       String soldToNamePostCopy= driver.findElement(By.xpath
		    		   (".//*[@id='accountInfo']/div/form/div[1]/div[2]/div[2]/div/p")).getText();
		   
		       if(billToName.equalsIgnoreCase(billToNamePostCopy))
		    	   if(soldToName.equalsIgnoreCase(soldToNamePostCopy)){
		    		   Logger.info("Account info is copied successfully");
		    		   Assert.assertEquals("str","str");
		    	   }else{
		    		   Logger.info("Account info is not copied successfully");
		    		   Assert.assertEquals("str1","str");
		    	   }
		       //************************************
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	@Test(groups = {"PreprintOrderCopyAccntInfo","RegressionLatest","Sprint9to15","Grp1","Pre1","Group1","RegFailed3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderCopyAccntInfo(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",10, 0);
		       newOrderInstance.enterPubDate("1","30", "Nov", "2019");
		       newOrderInstance.selectProductType("1",10, 1);
		       newOrderInstance.selectProduct("1",10, 2);
		       Thread.sleep(3000);
		       /*newOrderInstance.selectAdType("1",10, 3);
		       Thread.sleep(10000);
		       newOrderInstance.selectSection("1",10, 4);
		       Thread.sleep(8000);*/
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       newOrderInstance.selectMaterialSource("1","N/A");
		       newOrderInstance.clickOnDistributions(1);
		       Thread.sleep(44000);
		       newOrderInstance.selectZonePreprintOrder("Full");
		       newOrderInstance.confirmZoneSelection();	
		       int distributionsCount = newOrderInstance.getDistributionsAdded();
		       Logger.info("distributionsCount "+distributionsCount);
		       //**********************************
		       Thread.sleep(4000);
		       JavascriptExecutor js = ((JavascriptExecutor) driver);
				  js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
				  
				  Thread.sleep(4000); 
				  
		       String billToName= driver.findElement(By.xpath
		    		   ("//*[@id='accountInfo']/div/form/div[1]/div[2]/div[2]/div/p")).getText();
		       String soldToName= driver.findElement(By.xpath
		    		   ("//*[@id='accountInfo']/div/form/div[2]/div[2]/div[2]/div/p")).getText();
		   
		       newOrderInstance.saveOrderBtn.click();
		       Thread.sleep(4000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       Thread.sleep(4000);
		       driver.findElement(By.xpath("(//button[text()='More'])[1]")).click();
		       Thread.sleep(2000);
		       driver.findElement(By.xpath("(//a[text()='Copy Account To Order'])[1]")).click();
		       Thread.sleep(5000);
		       String billToNamePostCopy= driver.findElement(By.xpath
		    		   ("//*[@id='accountInfo']/div/form/div[1]/div[2]/div[2]/div/p")).getText();
		       String soldToNamePostCopy= driver.findElement(By.xpath
		    		   ("//*[@id='accountInfo']/div/form/div[2]/div[2]/div[2]/div/p")).getText();
		   
		       if(billToName.equalsIgnoreCase(billToNamePostCopy))
		    	   if(soldToName.equalsIgnoreCase(soldToNamePostCopy)){
		    		   Logger.info("Account info is copied successfully");
		    		   Assert.assertEquals("str","str");
		    	   }else{
		    		   Logger.info("Account info is not copied successfully");
		    		   Assert.assertEquals("str1","str");
		    	   }
		       //************************************
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"ClassifiedOrderCopyAccntInfo"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void classifiedOrderCopyAccntInfo(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewClassifiedInsertion();
		       Thread.sleep(4000);		      
		       
		       Thread.sleep(4000);
		       classifiedOrderInstance.selectPackageBU("5",1, 0);
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5",1, 1);
		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
		       Thread.sleep(2000);
		       //driver.quit();
		       classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(4);
		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
		       Thread.sleep(2000);
		        classifiedOrderInstance.selectClassifiedPackageByIndex(2);
		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedClassCode("5",1, 4);
		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
		       classifiedOrderInstance.selectDate("nextmonth");
		       classifiedOrderInstance.clickApplyBtn();

		       Thread.sleep(15000);		       		       		       
		       newOrderInstance.clickonApplyAllInsertions();
		       Thread.sleep(4000);
		       
		       String billToName= driver.findElement(By.xpath
		    		   (".//*[@id='order-detail-page']/div[2]/div[1]/div[1]/div/div/div[2]/div/form/div[1]/div[2]/div[2]/div/p")).getText();
		       String soldToName= driver.findElement(By.xpath
		    		   (".//*[@id='order-detail-page']/div[2]/div[1]/div[1]/div/div/div[2]/div/form/div[2]/div[2]/div[2]/div/p")).getText();
		   
		       newOrderInstance.saveOrderBtn.click();
		       Thread.sleep(4000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       Thread.sleep(4000);
		       driver.findElement(By.xpath("(//button[text()='More'])[1]")).click();
		       Thread.sleep(2000);
		       driver.findElement(By.xpath("(//a[text()='Copy Account To Order'])[1]")).click();
		       Thread.sleep(5000);
		       String billToNamePostCopy= driver.findElement(By.xpath
		    		   (".//*[@id='order-detail-page']/div[2]/div[1]/div[1]/div/div/div[2]/div/form/div[1]/div[2]/div[2]/div/p")).getText();
		       String soldToNamePostCopy= driver.findElement(By.xpath
		    		   (".//*[@id='order-detail-page']/div[2]/div[1]/div[1]/div/div/div[2]/div/form/div[2]/div[2]/div[2]/div/p")).getText();
		   
		       if(billToName.equalsIgnoreCase(billToNamePostCopy))
		    	   if(soldToName.equalsIgnoreCase(soldToNamePostCopy)){
		    		   Logger.info("Account info is copied successfully");
		    		   Assert.assertEquals("str","str");
		    	   }else{
		    		   Logger.info("Account info is not copied successfully");
		    		   Assert.assertEquals("str1","str");
		    	   }
		       //************************************
		       
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"NewDigitalOrderCopyAccntInfo"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void newDigitalOrderCopyAccntInfo(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewDigitalOrder();
		       Thread.sleep(4000);

		       digitalOrderInstance.selectPackageBU("6",1, 0);
		       Thread.sleep(2000);
		       
		       digitalOrderInstance.selectDigitalProductDrpDwn("6",1, 1);
		       digitalOrderInstance.selectDigitalChargeDayDrpDwn(1);
		       
		       digitalOrderInstance.clickApplyBtn();
		       Thread.sleep(10000);
		       String billToName= driver.findElement(By.xpath
		    		   ("//*[@id='accountInfo']/div/form/div[2]/div[2]/div[2]/div/p")).getText();
		       String soldToName= driver.findElement(By.xpath
		    		   ("//*[@id='accountInfo']/div/form/div[1]/div[2]/div[2]/div/p")).getText();
		   
		       newOrderInstance.saveOrderBtn.click();
		       Thread.sleep(4000);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       Thread.sleep(4000);
		       driver.findElement(By.xpath("(//button[text()='More'])[1]")).click();
		       Thread.sleep(2000);
		       driver.findElement(By.xpath("(//a[text()='Copy Account To Order'])[1]")).click();
		       Thread.sleep(5000);
		       String billToNamePostCopy= driver.findElement(By.xpath
		    		   ("//*[@id='accountInfo']/div/form/div[2]/div[2]/div[2]/div/p")).getText();
		       String soldToNamePostCopy= driver.findElement(By.xpath
		    		   ("//*[@id='accountInfo']/div/form/div[1]/div[2]/div[2]/div/p")).getText();
		   
		       if(billToName.equalsIgnoreCase(billToNamePostCopy))
		    	   if(soldToName.equalsIgnoreCase(soldToNamePostCopy)){
		    		   Logger.info("Account info is copied successfully");
		    		   Assert.assertEquals("str","str");
		    	   }else{
		    		   Logger.info("Account info is not copied successfully");
		    		   Assert.assertEquals("str1","str");
		    	   }
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"BUWiseCustomerDPR","displayOrders","verifyBUWiseCustomerDPR","Grp2","PrioritizedReg3","TestPriority","NewRegression3","NewRegression","G5","RerunF2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyBUWiseCustomerDPR(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       CustomerPage customerPageinstance = PageFactory.initElements(driver, CustomerPage.class);
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_DPR");
		       newOrderInstance.enterSoldToCustomer("CU00013249");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //**********************
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",17, 0);
		       //newOrderInstance.enterPubDate("1","20", "Dec", "2019");//swagata
				newOrderInstance.enterPubDateFromExcel("1",90,27);//swagata
		       newOrderInstance.selectProductType("1",17, 1);
		       newOrderInstance.selectProduct("1",17, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",17, 3);
		       newOrderInstance.selectSection("1",17, 4);
		       Thread.sleep(4000);
		       //****************************
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);
		       newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");
		       Thread.sleep(4000);
		       newOrderInstance.clickOnInsertionSalesRepSection(1);
		       Thread.sleep(4000);	   
		       newOrderInstance.applytoAllSalesRepOnInsertion(1);
		       Thread.sleep(2000);
		       //Thread.sleep(4000);//swagata
		       newOrderInstance.submitOrder();	
		       Thread.sleep(2000); 
		       newOrderInstance.clickOnContinuePastPubDate();
		       Thread.sleep(3000);
		       String orderid=orderEntryPageInstance.getOrderID();
		       Logger.info("orderid:"+orderid);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);		       
		       orderEntryPageInstance.clickOnOrder(orderid);
		       Thread.sleep(7000);
		       
		       Select soldToBU = new Select(newOrderInstance.soldToCustomerBU);
		       String soldToBUValue = soldToBU.getFirstSelectedOption().getText();
		       
		       Select billToBU = new Select(newOrderInstance.billToCustomerBU);
		       String billToBUValue = billToBU.getFirstSelectedOption().getText();
		       
		       if(soldToBUValue.equalsIgnoreCase("DPR"))
		    	   if(billToBUValue.equalsIgnoreCase("DPR")){
		    		   Logger.info("BU is displayed successfully");
		    		   Assert.assertEquals("str","str");
		    	   }else{
		    		   Logger.info("BU is not displayed successfully");
		    		   Assert.assertEquals("str1","str");
		    	   }
		       dashboardPageInstance.clickOnLogout();//swagata
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	@Test(groups = {"BUWiseCustomerCTC","Grp2","RegressionLatest","Sprint9to15","Group3"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyBUWiseCustomerCTC(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       CustomerPage customerPageinstance = PageFactory.initElements(driver, CustomerPage.class);
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_CTC");
		       newOrderInstance.enterSoldToCustomer("CU00037236");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //**********************
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",17, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2019");
		       newOrderInstance.selectProductType("1",17, 1);
		       newOrderInstance.selectProduct("1",17, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",17, 3);
		       newOrderInstance.selectSection("1",17, 4);
		       Thread.sleep(4000);
		       //****************************
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();		       
		       Thread.sleep(2000);
		       String orderid=orderEntryPageInstance.getOrderID();
		       Logger.info("orderid:"+orderid);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);		       
		       orderEntryPageInstance.clickOnOrder(orderid);
		       Thread.sleep(7000);
		       
		       Select soldToBU = new Select(newOrderInstance.soldToCustomerBU);
		       String soldToBUValue = soldToBU.getFirstSelectedOption().getText();
		       
		       Select billToBU = new Select(newOrderInstance.billToCustomerBU);
		       String billToBUValue = billToBU.getFirstSelectedOption().getText();
		       
		       if(soldToBUValue.equalsIgnoreCase("CTC"))
		    	   if(billToBUValue.equalsIgnoreCase("CTC")){
		    		   Logger.info("BU is displayed successfully");
		    		   Assert.assertEquals("str","str");
		    	   }else{
		    		   Logger.info("BU is not displayed successfully");
		    		   Assert.assertEquals("str1","str");
		    	   }
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"BUWiseCustomerSSC","Grp2"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void verifyBUWiseCustomerSSC(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       CustomerPage customerPageinstance = PageFactory.initElements(driver, CustomerPage.class);
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_SSC");
		       newOrderInstance.enterSoldToCustomer("CU00117844");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //**********************
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",17, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2019");
		       newOrderInstance.selectProductType("1",17, 1);
		       newOrderInstance.selectProduct("1",17, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",17, 3);
		       newOrderInstance.selectSection("1",17, 4);
		       Thread.sleep(4000);
		       //****************************
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();		       
		       Thread.sleep(3000);
		       String orderid=orderEntryPageInstance.getOrderID();
		       Logger.info("orderid:"+orderid);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);		       
		       orderEntryPageInstance.clickOnOrder(orderid);
		       Thread.sleep(7000);
		       
		       Select soldToBU = new Select(newOrderInstance.soldToCustomerBU);
		       String soldToBUValue = soldToBU.getFirstSelectedOption().getText();
		       
		       Select billToBU = new Select(newOrderInstance.billToCustomerBU);
		       String billToBUValue = billToBU.getFirstSelectedOption().getText();
		       
		       if(soldToBUValue.equalsIgnoreCase("SSC"))
		    	   if(billToBUValue.equalsIgnoreCase("SSC")){
		    		   Logger.info("BU is displayed successfully");
		    		   Assert.assertEquals("str","str");
		    	   }else{
		    		   Logger.info("BU is not displayed successfully");
		    		   Assert.assertEquals("str1","str");
		    	   }
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"OrdeDisplayProofType","Grp2","RegressionLatest","Sprint9to15","Group1"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderWithProofType(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       CustomerPage customerPageinstance = PageFactory.initElements(driver, CustomerPage.class);
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //**********************
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(false);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",17, 0);
		       newOrderInstance.enterPubDate("1","23", "Dec", "2019");
		       Thread.sleep(4000);
		       newOrderInstance.selectProductType("1",38, 1);
		       //newOrderInstance.selectProduct("1",17, 2);
		       //Thread.sleep(2000);
		       //newOrderInstance.selectAdType("1",17, 3);
		       //newOrderInstance.selectSection("1",17, 4);
		       Thread.sleep(6000);
		       //****************************
		       orderEntryPageInstance.enterProofType(); 
		       //****************************
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();		       
		       Thread.sleep(3000);
		       String orderid=orderEntryPageInstance.getOrderID();
		       Logger.info("orderid:"+orderid);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"OrdePreprintProofType"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderWithProofType(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",10, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2019");
		       newOrderInstance.selectProductType("1",10, 1);
		       newOrderInstance.selectProduct("1",10, 2);
		       Thread.sleep(3000);
		      // newOrderInstance.selectAdType("1",10, 3);
		      // Thread.sleep(10000);
		     //  newOrderInstance.selectSection("1",10, 4);
		     //  Thread.sleep(8000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       newOrderInstance.selectMaterialSource("1","N/A");
		       newOrderInstance.clickOnDistributions(1);
		       Thread.sleep(44000);
		       newOrderInstance.selectZonePreprintOrder("Full");
		       newOrderInstance.confirmZoneSelection();	
		       int distributionsCount = newOrderInstance.getDistributionsAdded();
		       Logger.info("distributionsCount "+distributionsCount);
		       //**********************************
		       orderEntryPageInstance.enterProofType();
		       //****************************
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();		       
		       Thread.sleep(3000);
		       String orderid=orderEntryPageInstance.getOrderID();
		       Logger.info("orderid:"+orderid);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);	
		       //************************************
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"OrdeOnlineProofType","Grp2","PriorityDFP"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void onlineOrderWithProofType(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",9, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2019");
		       newOrderInstance.selectProductType("1",9, 1);
		       newOrderInstance.selectProduct("1",9, 2);
		       Thread.sleep(2000);
		     //  newOrderInstance.selectAdType("1",9, 3);
		      // Thread.sleep(2000);
		      // newOrderInstance.selectSection("1",9, 4);
		      // Thread.sleep(4000);
		       
		     //**********************************
		       orderEntryPageInstance.enterProofType();
		       //****************************
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();		       
		       Thread.sleep(3000);
		       String orderid=orderEntryPageInstance.getOrderID();
		       Logger.info("orderid:"+orderid);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);	
		       //************************************
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"OrdeRecruitmentProofType"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void recruitmentOrderWithProofType(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       CustomerPage customerPageinstance = PageFactory.initElements(driver, CustomerPage.class);
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00042510");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //**********************
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",17, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2019");
		       newOrderInstance.selectProductType("1",38, 1);
		       //newOrderInstance.selectProduct("1",17, 2);
		       Thread.sleep(2000);
		       //newOrderInstance.selectAdType("1",17, 3);
		       //newOrderInstance.selectSection("1",17, 4);
		       //Thread.sleep(6000);
		       //****************************
		       orderEntryPageInstance.enterProofType(); 
		       //****************************
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();		       
		       Thread.sleep(3000);
		       String orderid=orderEntryPageInstance.getOrderID();
		       Logger.info("orderid:"+orderid);
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);	
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"ECheckClassifiedOrder"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void createNewClassifiedOrderwithECheck(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //newOrderInstance.selectOrderType("OrderType_Spec");
		       //newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewClassifiedInsertion();
		       Thread.sleep(4000);		      
		       
		       Thread.sleep(4000);
		       classifiedOrderInstance.selectPackageBU("5",1, 0);
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("5",1, 1);
		       //classifiedOrderInstance.selectClassifiedSubcategoryDrpDwn("Automotive");
		       Thread.sleep(2000);
		       //driver.quit();
		       classifiedOrderInstance.selectClassifiedProductDrpDwnByIndex(14);
		       //classifiedOrderInstance.selectClassifiedProductDrpDwn("classified.chicagotribune.com [Online]");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedPackageByIndex(2);
		       //classifiedOrderInstance.selectClassifiedPackage("Auto Other Pioneer Central");
		       Thread.sleep(2000);
		       classifiedOrderInstance.selectClassifiedClassCodeByIndex(1);
		       //classifiedOrderInstance.selectClassifiedClassCode("76407 - Autos Wanted");
		       classifiedOrderInstance.selectSingleZone();
		       classifiedOrderInstance.selectDate("nextmonth");
		       classifiedOrderInstance.clickApplyBtn();

		       Thread.sleep(15000);		       
		       //***********************
		       newOrderInstance.selectPaymentType("Check");
		       Thread.sleep(2000);
		       newOrderInstance.enterCheckDetails("New Card");
		       Thread.sleep(3000);
		       //***********************
		       classifiedOrderInstance.clickEditAdBtn();

		       //Thread.sleep(15000);
		       //classifiedOrderInstance.uploadAd();

		       Thread.sleep(10000);
		       classifiedOrderInstance.uploadAd("5",1,6);
		       //classifiedOrderInstance.verifyInsertionPrice("Non-Legal");
		       classifiedOrderInstance.enterAttributeDetails();		       		       		       
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       //Thread.sleep(2000);
		       //newOrderInstance.confirmToMakeOrderFree();
		       Thread.sleep(2000);
		       Logger.info(orderEntryPageInstance.getOrderID());
		       orderEntryPageInstance.closeOrderSuccessSubmissionMessage();
		       Thread.sleep(2000);
		       ////dashboardPageInstance.clickOnLogout();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"OrderDisplayWithoutProduct"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderWithoutProduct(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       CustomerPage customerPageinstance = PageFactory.initElements(driver, CustomerPage.class);
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       
		       ClassifiedOrderOptions classifiedOrderInstance = PageFactory.initElements(driver, ClassifiedOrderOptions.class);
		       Thread.sleep(3000);
		       
		       DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
		       Thread.sleep(3000);
		       
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00042510");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       //**********************
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       //newOrderInstance.selectBU("1",17, 0);
		       //newOrderInstance.enterPubDate("1","30", "Dec", "2019");
		       Thread.sleep(4000);
		       //newOrderInstance.selectProductType("1",38, 1);
		       //newOrderInstance.selectProduct("1",17, 2);
		       //Thread.sleep(2000);
		       //newOrderInstance.selectAdType("1",17, 3);
		       //newOrderInstance.selectSection("1",17, 4);
		       Thread.sleep(6000);
		       //****************************
		       //orderEntryPageInstance.enterProofType(); 
		       //**************************** 
		       newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);newOrderInstance.addNewSalesRepOnInsertion(1, "SA01380");Thread.sleep(4000);newOrderInstance.clickOnInsertionSalesRepSection(1);Thread.sleep(4000);	   newOrderInstance.applytoAllSalesRepOnInsertion(1);Thread.sleep(2000);Thread.sleep(4000);
		       newOrderInstance.submitOrder();
		       Thread.sleep(2000);
		       newOrderInstance.displayErrorMessage();
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"DisplayOrderMaterialId"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void displayOrderMaterialId(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       DigitalOrderOptions digitalOrderInstance = PageFactory.initElements(driver, DigitalOrderOptions.class);
		       Thread.sleep(3000);
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_CTC");
		       newOrderInstance.enterSoldToCustomer("CU00037236");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.checkUncheckOwnLocalOptOut(true);
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",17, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2019");
		       newOrderInstance.selectProductType("1",17, 1);
		       newOrderInstance.selectProduct("1",17, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",17, 3);
		       newOrderInstance.selectSection("1",17, 4);
		       Thread.sleep(4000);
		       driver.findElement(By.xpath(".//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/table/tbody/tr[1]/td[2]/div/div[1]/i")).click();
		       Thread.sleep(4000);
		       WebElement MaterialId= driver.findElement(By.xpath("//label[text()='Material Source']/../div"));
		      
		       if(MaterialId.isDisplayed()){
		    	   Logger.info("Material Id is displayed");
		    	   Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Material Id is not displayed");
		    	   Assert.assertEquals("str1","str");
		       } 
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"OrdePreprintMaterialId"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void preprintOrderMaterialId(Map<String, String> userData) throws Exception
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
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",10, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2019");
		       newOrderInstance.selectProductType("1",10, 1);
		       newOrderInstance.selectProduct("1",10, 2);
		       Thread.sleep(3000);
		       newOrderInstance.selectAdType("1",10, 3);
		       Thread.sleep(10000);
		       newOrderInstance.selectSection("1",10, 4);
		       Thread.sleep(8000);
		       newOrderInstance.viewInsertionDetails("1");
		       newOrderInstance.addOrEditInsersionVerisonID("1", 1);
		       newOrderInstance.selectMaterialSource("1","N/A");
		       newOrderInstance.clickOnDistributions(1);
		       Thread.sleep(44000);
		       newOrderInstance.selectZonePreprintOrder("Full");
		       newOrderInstance.confirmZoneSelection();	
		       int distributionsCount = newOrderInstance.getDistributionsAdded();
		       Logger.info("distributionsCount "+distributionsCount);
		       //**********************************
		       //orderEntryPageInstance.enterProofType();
		       //****************************
		       
		       WebElement MaterialId= driver.findElement(By.xpath("//label[text()='Material Source']/../div"));
		       
		       if(MaterialId.isDisplayed()){
		    	   Logger.info("Material Id is displayed");
		    	   Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Material Id is not displayed");
		    	   Assert.assertEquals("str1","str");
		       }
		       //************************************
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	@Test(groups = {"OrdeOnlineMaterialId","PriorityDFP"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	public void onlineOrderMaterialId(Map<String, String> userData) throws Exception
	{
		try
		   {
			   WebDriver driver = WebDriverManager.getDriver();
			   Logger.info("Webdriver is initiated");
			   
			   TribuneUtils utilities = new TribuneUtils();
		       utilities.launchURL(driver, Configurator.getConfig().get("SignIn"));
		       utilities.implementWait(driver);
		       
		       SignInPage signinPageinstance = PageFactory.initElements(driver, SignInPage.class);
		    //   signinPageinstance.login("success");
		       
		       DashboardPage dashboardPageInstance = PageFactory.initElements(driver, DashboardPage.class);
		       dashboardPageInstance.clickOnOrderEntryModule();
		       
		       OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
		       orderEntryPageInstance.clickOnNewGeneralOrder();
		       
		       NewOrderPage newOrderInstance = PageFactory.initElements(driver, NewOrderPage.class);
		       newOrderInstance.selectSoldToCustomerBU("bu_LAT");
		       newOrderInstance.enterSoldToCustomer("CU00059747");
		       newOrderInstance.selectBilltoSameAsSoldTo();
		       newOrderInstance.selectOrderType("OrderType_Standard");
		       newOrderInstance.selectOrderRouting("OrderRouting_BillAndFulFill");
		       newOrderInstance.createNewInsertion();
		       newOrderInstance.selectBU("1",9, 0);
		       newOrderInstance.enterPubDate("1","30", "Dec", "2019");
		       newOrderInstance.selectProductType("1",9, 1);
		       newOrderInstance.selectProduct("1",9, 2);
		       Thread.sleep(2000);
		       newOrderInstance.selectAdType("1",9, 3);
		       Thread.sleep(2000);
		       newOrderInstance.selectSection("1",9, 4);
		       Thread.sleep(4000);
		       
		     //**********************************
		       driver.findElement(By.xpath(".//*[@id='insertionInfo']/form/div/table/tbody/tr[1]/td[2]/div/div[1]/i")).click();
		       Thread.sleep(4000);
		       WebElement MaterialId= driver.findElement(By.xpath("//label[text()='Material Source']/../div"));
		       
		       if(MaterialId.isDisplayed()){
		    	   Logger.info("Material Id is displayed");
		    	   Assert.assertEquals("str","str");
		       }else{
		    	   Logger.info("Material Id is not displayed");
		    	   Assert.assertEquals("str1","str");
		       }
		       //************************************
		   }
		catch (Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
