package com.tribune.adit2.Home;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

import junit.framework.Assert;

/**
 * Page Class Modeling for Customers Page
 * @author Priyanka Goud CR 
 * @since November 2015
 */

public class DashboardPage 
{
	@FindBy (xpath = "//span[text()='Dashboard']")
	public WebElement dashboardModuleLink;
	
	@FindBy (xpath = ".//*[@id='app']/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[1]/div[1]/div[2]/a")
	public WebElement firstOrderLink;	
	
	@FindBy (xpath = "//*[@id='app']/div[2]/div/div/nav/ul/li[3]/a/span")
	public WebElement OrdersearchLink;
	
	@FindBy (xpath = "//span[text()='Order Entry']")
	public WebElement orderEntryModuleLink;
	
	@FindBy (xpath = "//span[text()='Customers']")
	public WebElement customersModuleLink;
	
	@FindBy (xpath = "//span[text()='Special Programs']")
	public WebElement specialProgramModuleLink;
	
	@FindBy (xpath = "//span[text()='Newspaper Layout']")
	public WebElement newsPaperLayoutModuleLink; 
	
	@FindBy (xpath = "//span[text()='Adjustments']")
	public WebElement adjustmentsModuleLink; 
	
	@FindBy (xpath = "//span[text()='Pricing']")
	public WebElement pricingModuleLink; 
	
	@FindBy (xpath = "//span[text()='Fullfillment']")
	public WebElement fullfillmentModuleLink;
	
	@FindBy (xpath = "//span[text()='Systems']")
	public WebElement fullfillmentSystemsMenuLink;
	
	@FindBy (xpath = "//span[text()='Routing Rules']")
	public WebElement fullfillmentRoutingRulesMenuLink;
	
	@FindBy(id = "user_info_dropdown")
	public WebElement userSessionDropDown;
	
	@FindBy (xpath = "//a/span[text()='New Orders']")
	public WebElement totalNewOrdersLink;
	
	@FindBy (xpath = "//a/span[text()='New Orders']/../span[@class='text-white font-thin h1 block ng-binding']")
	public WebElement countofNewOrdersElement;
	
	@FindBy (xpath = "//a/span[text()='Reservations']")
	public WebElement totalReservationsLink;
	
	@FindBy (xpath = "//a/span[text()='Reservations']/../span[@class='text-white font-thin h1 block ng-binding']")
	public WebElement countofReservationsElement;
	
	@FindBy (xpath = "//a/span[text()='Quotes']")
	public WebElement totalQuotesLink;
	
	@FindBy (xpath = "//a/span[text()='Quotes']/../span[@class='text-white font-thin h1 block ng-binding']")
	public WebElement countofQuotesElement;
	
	@FindBy (xpath = "//a/span[text()='Insertion Orders']")
	public WebElement totalInsertionOrdersLink;
	
	@FindBy (xpath = "//a/span[text()='Insertion Orders']/../span[@class='text-white font-thin h1 block ng-binding']")
	public WebElement countofInsertionOrdersElement;
	
	@FindBy (xpath = "//a/span[text()='Insertion Orders Error Out']")
	public WebElement totalOrdersErrorOutLink;
	
	@FindBy (xpath = "//a/span[text()='Insertion Orders Error Out']/../span[@class='text-white font-thin h1 block ng-binding']")
	public WebElement countofOrdersErrOutElement;
	
	@FindBy (linkText = "More Customers")
	public WebElement moreCustomersLink;
	
	@FindBy (id = "logout")
	public WebElement logoutLink;
	
	@FindBy(xpath = "//span[text()='Pricing']")
	public WebElement priceAdminLink;
	
	@FindBy(xpath = "//span[text()='Product']")
	public WebElement prodAdminLink;
	
	//@FindBy (xpath = "//*[@id='app']/div[2]/div/div/nav/ul/li[17]/a")
     //public WebElement UserAdminLink;
	
	@FindBy (xpath = "//a[@class='auto']//../span[text()='User Admin']")
    public WebElement UserAdminLink;
	
	@FindBy (xpath = "//span[text()='Users']")
    public WebElement UsersLink;
	
	@FindBy (xpath = "//span[text()='Teams']")
    public WebElement TeamsLink;
	
	@FindBy (xpath = "//span[text()='Roles']")
    public WebElement RolesLink;
	
	
	@FindBy (xpath = "//a[@id='user_info_dropdown']/b")
	public WebElement dropdownlink;
	
	
	private WebDriver driver;
	
	Properties properties = TribuneUtils.readProperties();
	
	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Code to click on the dropdown link for Logout  //joy
	public void clickondropdownforlogout() throws Exception
	{
		try
		{
			
			Thread.sleep(4000); 
			  JavascriptExecutor js = ((JavascriptExecutor) driver);
			  js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");		
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.until(ExpectedConditions.visibilityOf(dropdownlink));
			wait.until(ExpectedConditions.elementToBeClickable(dropdownlink));
			
			if(dropdownlink.isDisplayed()){
				dropdownlink.click();
				Logger.info("dropdown link is clicked");
				logoutLink.click();
				Logger.info("Logout is not successfully");
			}
			else{
				Logger.info("logout is successfully");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
	
//Code to click on the dashboard link 
	public void clickOnDashboardModule() throws Exception
	{
		try
		{
			if(dashboardModuleLink.isDisplayed()){
				dashboardModuleLink.click();
				Logger.info("Dashboard page is loaded");
			}
			else{
				Logger.info("Dashboard link is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to click on order entry module link	
	public void clickOnOrderEntryModule() throws Exception
	{
		try
		{
			 WebDriverWait wait = new WebDriverWait(driver,500);	//swagata	       
				wait.until(ExpectedConditions.elementToBeClickable(orderEntryModuleLink));//swagata
				 
			Thread.sleep(4000);
			if(orderEntryModuleLink.isDisplayed())
			{
				orderEntryModuleLink.click();
				Logger.info("Order Entry page is loaded");
			}
			else{
				Logger.info("Order Entry link is not dispalyed");
			}
		}
		catch(Exception e){
			//Logger.info("Order Entry link is not dispalyed");
			Logger.error("Order Entry link is not dispalyed "+e.getMessage());
			  throw e;
		}
	}
	
	public void clickOnAvailabilityModule() throws Exception
	{
		try
		{
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath("//span[text()='Availability']"));
		     
		       if(element.isDisplayed())
		       {
		    	   element.click();
		    	   Thread.sleep(3000);		    	   
		    	   Logger.info("Module Availability is clicked");
		       }
			else{
				Logger.info("Availability link is not dispalyed");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//Code to click on customers module link
	public void clickOnCustomerModule() throws Exception
	{
		try
		{ 
			WebDriverWait wait = new WebDriverWait(driver,500);	//swagata	       
		wait.until(ExpectedConditions.elementToBeClickable(customersModuleLink));//swagata
			Thread.sleep(2000);
			if(customersModuleLink.isDisplayed())
			{
				customersModuleLink.click();
				Logger.info("Customers page is loaded");
				Thread.sleep(2000);
			}
			else{
				Logger.info("Customers page is loaded");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
	//Code to click on special Programs module link
		public void clickOnSpecialProgramsModule() throws Exception
		{
			try
			{
				Thread.sleep(2000);
				if(specialProgramModuleLink.isDisplayed())
				{
					specialProgramModuleLink.click();
					Logger.info("Special Programs page is loaded");
					Thread.sleep(4000);
				}
				else{
					Logger.info("Special Programs page is loaded");
				}
			}
			catch(Exception e){
				Logger.error(e.getMessage());
				  throw e;
			}
		}
	
//Code to click on newspaper layout module link
	public void clickOnNewsPaperLayoutModule() throws Exception
	{
		try
		{
			if(newsPaperLayoutModuleLink.isDisplayed())
			{
				newsPaperLayoutModuleLink.click();
				Logger.info("News Paper Layout page is loaded");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
	public void clickOnAdjustmentsModule() throws Exception
	{
		try
		{
			if(adjustmentsModuleLink.isDisplayed())
			{
				adjustmentsModuleLink.click();
				Logger.info("adjustmentsModuleLink page is loaded");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
	public void clickOnPricingModule() throws Exception
	{
		try
		{
			if(pricingModuleLink.isDisplayed())
			{ WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions
					.elementToBeClickable(pricingModuleLink));

				pricingModuleLink.click();
				Logger.info("pricingModuleLink page is loaded");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
	/**
	 * @author cymkozalg6 - Priyanka
	 * @description This method clicks on fullfillment menu
	 */
	public void clickOnFullFillmentModuleLink() throws Exception
	{
		try
		{
			if(fullfillmentModuleLink.isDisplayed())
			{
				fullfillmentModuleLink.click();
				Logger.info("FullFillment Module is clicked");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
	/**
	 * @author cymkozalg6 - Priyanka
	 * @description This method clicks on fullfillment systems menu
	 */
	public void clickOnFullfillmentSystemsLink() throws Exception
	{
		try
		{
			if(fullfillmentSystemsMenuLink.isDisplayed())
			{
				fullfillmentSystemsMenuLink.click();
				Logger.info("fullfillment Systems Menu Link is clicked");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
	/**
	 * @author cymkozalg6 - Priyanka
	 * @description This method clicks on fullfillment routing rules menu
	 */
	public void clickOnFullfillmentRoutingRulesMenuLink() throws Exception
	{
		try
		{
			if(fullfillmentRoutingRulesMenuLink.isDisplayed())
			{
				fullfillmentRoutingRulesMenuLink.click();
				Logger.info("Fullfillment Routing Rules Menu Link is clicked");
			}
			else{
				Logger.info("Fullfillment Routing Rules Menu is not displayed");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//code to click on the user specific details
	public void clickOnUserSessionDropDown() throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(userSessionDropDown));
			if(userSessionDropDown.isDisplayed())
			{
				userSessionDropDown.click();
				Logger.info("clicked on the user specific drop down");
			}
			else{
				Logger.info("user specific drop down is not visible");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//code to logout 
	public void clickOnLogout() throws Exception
	{
		try
		{
			Thread.sleep(4000); 
			  JavascriptExecutor js = ((JavascriptExecutor) driver);
			  js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
			  
			clickOnUserSessionDropDown();
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.until(ExpectedConditions.visibilityOf(logoutLink));
			wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
			if(logoutLink.isDisplayed())
			{
				logoutLink.click();
				Logger.info("logged out successfully");
			}
			else{
				Logger.info("logout link is not displayed");
			}
			Thread.sleep(2000);
			if(driver.findElements(By.xpath("//div[@class='modal-footer ng-scope']//button[contains(text(),'Yes')]")).size()>0)
			{
		 driver.findElement(By.xpath("//div[@class='modal-footer ng-scope']//button[contains(text(),'Yes')]")).click(); //Joy
		 Thread.sleep(2000);
		 Logger.info("Yes button is clicked");
		}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//code to click on new orders link 
	public void clickOnNewOrdersLink() throws Exception
	{
		try{
			if(totalNewOrdersLink.isDisplayed()){
				totalNewOrdersLink.click();
				Logger.info("new orders link in the dashboard page is clicked");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//code to click on reservations link
	public void clickOnReservationsLink() throws Exception
	{
		try{
			if(totalReservationsLink.isDisplayed()){
				totalReservationsLink.click();
				Logger.info("Reservations link in the dashboard page is clicked");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//code to click on quotes link
	public void clickOnQuotesLink() throws Exception
	{
		try{
			if(totalQuotesLink.isDisplayed()){
				totalQuotesLink.click();
				Logger.info(" Quotes Link in the dashboard page is clicked");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//code to click on insertion orders link
	public void clickOnInsertionOrdersLink() throws Exception
	{
		try{
			if(totalInsertionOrdersLink.isDisplayed()){
				totalInsertionOrdersLink.click();
				Logger.info("InsertionOrders link in the dashboard page is clicked");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//code to click on orders error out link
	public void clickOnOrdersErrorOutLink() throws Exception
	{
		try{
			if(totalOrdersErrorOutLink.isDisplayed()){
				totalOrdersErrorOutLink.click();
				Logger.info(" OrdersErrorOut Link in the dashboard page is clicked");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
//code to click on more customers button
	public void clickOnMoreCustomersBtn() throws Exception
	{
		try{
			if(moreCustomersLink.isDisplayed()){
				moreCustomersLink.click();
				Logger.info("MoreCustomers Link in the dashboard page is clicked");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}
	
	
//code to get the count of total new orders displayed on the dashboard page
	public int getCountOfNewOrders() throws Exception
	{
		String count = "";
		try{
			if(countofNewOrdersElement.isDisplayed()){
				count = countofNewOrdersElement.getText();
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
		return Integer.parseInt(count);
	}
	
//code to get the count of total reservations displayed on the dashboard page
	public int getCountOfReservations() throws Exception
	{
		String count = "";
		try{
			if(countofReservationsElement.isDisplayed()){
				count = countofReservationsElement.getText();
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
		return Integer.parseInt(count);
	}
	
//code to get the count of total quotes displayed on the dashboard page
	public int getCountOfQuotes() throws Exception
	{
		String count = "";
		try{
			if(countofQuotesElement.isDisplayed()){
				count = countofQuotesElement.getText();
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
		return Integer.parseInt(count);
	}
	
//code to get the count of total insertion orders displayed on the dashboard page
	public int getCountOfInsertionOrders() throws Exception
	{
		String count = "";
		try{
			if(countofInsertionOrdersElement.isDisplayed()){
				count = countofInsertionOrdersElement.getText();
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
		return Integer.parseInt(count);
	}
	
//code to get the count of total orders error out displayed on the dashboard page
	public int getCountOfOrdersErrOut() throws Exception
	{
		String count = "";
		try{
			if(countofOrdersErrOutElement.isDisplayed()){
				count = countofOrdersErrOutElement.getText();
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
		return Integer.parseInt(count);
	}
	
//click on a specific customer link on the dashboard page
	public void clickOnCustomerLink(String customerName) throws Exception
	{
		try{
			WebElement customerLink = driver.findElement(By.xpath("//a[contains(text(),'"+customerName+"')]"));
			customerLink.click();
			Logger.info("customer link is clicked");
					
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}

	public void clickOnTheRequiredModule(String moduleName) {
		try {
			WebDriverWait wait= new WebDriverWait(driver, 10);//swagata
			WebElement moduleLink;
			try{
			moduleLink = driver.findElement(By.xpath("//nav[@class='navi clearfix ng-scope']/ul[@class='nav ng-scope']/li[not(@class)]/a/span[@translate][text()=\""+moduleName+"\"]"));
			wait.until(ExpectedConditions.elementToBeClickable(moduleLink));//swagata

			}
			catch(NoSuchElementException ex){
				moduleLink = driver.findElement(By.xpath("//nav[@class='navi clearfix ng-scope']/ul[@class='nav ng-scope']/li[@class='']/a/span[@translate][text()=\""+moduleName+"\"]"));
			}
			moduleLink.click();
			Logger.info("Able to click on the module " + moduleName);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		
	}
	public void clickOnOrderEntrySearchModule() throws Exception
	{
		try
		{
			Thread.sleep(4000);
			if(OrdersearchLink.isDisplayed())
			{
				OrdersearchLink.click();
				Logger.info("Order Entry search page is loaded");
			}
			else{
				Logger.info("Order Entry search link is not dispalyed");
			}
		}
		catch(Exception e){
			Logger.error("Order Entry search link is not dispalyed "+e.getMessage());
			  throw e;
		}
	}//swagata new
	public void ProductAdminModule() throws Exception {
		try
		{
              WebDriverWait wait=new WebDriverWait(driver, 200);
            wait.until(ExpectedConditions.elementToBeClickable(priceAdminLink));//swagata
			if(prodAdminLink.isDisplayed())
			{
				prodAdminLink.click();
				Logger.info("prodAdminLink page is loaded");
			}
			else{
				Logger.info("Product Admin link is not dispalyed");
			}
		}
		catch(Exception e){
			Logger.error("Product Admin link is not dispalyed "+e.getMessage());
			  throw e;
		}
	}//swagata new 
	
	public void ClickOnUserAdminModule() throws Exception {
		try
		{
			Thread.sleep(4000);
			if(UserAdminLink.isDisplayed())
			{
				JavascriptExecutor executor = (JavascriptExecutor)driver;//swagata
				//action.moveToElement(UserAdminLink).build().perform();//swagata
				executor.executeScript("arguments[0].scrollIntoView(true);", UserAdminLink);
				Thread.sleep(2000);
				UserAdminLink.click();
				Logger.info("UserAdminLink page is loaded");
			}
			else{
				Logger.info("User Admin link is not dispalyed");
			}
		}
		catch(Exception e){
			Logger.error("User Admin link is not dispalyed "+e.getMessage());
			  throw e;
		}
	}//mousumi 
	
	public void clickOnUserAdminUsersLink() throws Exception
	{
		try
		{	Thread.sleep(4000);
			if(UsersLink.isDisplayed())
			{	Actions action = new Actions(driver);
				WebDriverWait wait = new WebDriverWait(driver, 150);//swagata
				JavascriptExecutor executor = (JavascriptExecutor)driver;//swagata
				action.moveToElement(UsersLink).build().perform();//swagata
				executor.executeScript("arguments[0].scrollIntoView(true);", UsersLink);//swagata
				wait.until(ExpectedConditions.elementToBeClickable(UsersLink));//swagata
				action.moveToElement(UsersLink).click().build().perform();//swagata
				//UsersLink.click();//swagata
				Logger.info("User Admin Users Link is clicked");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}//mousumi
	public void clickOnUserAdminTeamsLink() throws Exception
	{
		try
		{WebDriverWait wait3=new WebDriverWait(driver, 30);
			if(TeamsLink.isDisplayed())
			{
				TeamsLink.click();
				Logger.info("User Admin Teams Link is clicked");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}//mousumi
	public void clickOnUserAdminRolesLink() throws Exception
	{
		try
		{   Thread.sleep(4000);
			if(RolesLink.isDisplayed())
			{Actions action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, 150);//swagata
			JavascriptExecutor executor = (JavascriptExecutor)driver;//swagata
			action.moveToElement(RolesLink).build().perform();//swagata
			executor.executeScript("arguments[0].scrollIntoView(true);", RolesLink);//swagata
			wait.until(ExpectedConditions.elementToBeClickable(RolesLink));//swagata
			action.moveToElement(RolesLink).click().build().perform();//swagata
			
				//RolesLink.click();//swagata
				Logger.info("User Admin Roles Link is clicked");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			  throw e;
		}
	}//mousumi
	
	
}
