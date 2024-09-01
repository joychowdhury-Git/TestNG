package com.tribune.adit2.Home;

import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.By;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Customers Page
 * @author Priyanka Goud CR 
 * @since November 2015
 */

public class SignInPage 
{
 @FindBy (id = "userName")
 public WebElement userNameTextBox;
 
 @FindBy (id = "password")
 public WebElement passwordTextBox;
 
 @FindBy (xpath = "//span[text()='Log in']/..")
 public WebElement loginInButton;
	private WebDriver driver;//swagata

//Code to enter user name
 public void enterUserName(String userName) throws Exception
 {
	 try{
		// WebDriverWait wait = new WebDriverWait(driver,500);	//swagata	       
		 if(userNameTextBox.isDisplayed())
		 {
			//	wait.until(ExpectedConditions.elementToBeClickable(userNameTextBox));//swagata

		// WebDriver driver = WebDriverManager.getDriver();
		//	 JavascriptExecutor je = (JavascriptExecutor) driver;       
	      //      je.executeScript("arguments[0].click();", driver.findElement(By.id("userName")));
	      //      Thread.sleep(5000);
				
			 userNameTextBox.click();
			 userNameTextBox.sendKeys(userName);
		   //  Logger.info(userName+ " username is entered");
		 }
		 else{
			 Logger.info("user name textbox is not displayed");
		 }
	 }
	 catch (Exception e)
	 {
		 Logger.error(e.getMessage());
		  throw e;
	 }
 }
 
//Code to enter password
 public void enterPassword(String password) throws Exception
 {
	// WebDriverWait wait = new WebDriverWait(driver,500);	//swagata	
	// wait.until(ExpectedConditions.elementToBeClickable(passwordTextBox));//swagata

	 try{
		 if(passwordTextBox.isDisplayed())
		 {	
              passwordTextBox.click();
			 passwordTextBox.sendKeys(password);
			 Thread.sleep(2000);
			Logger.info("Password is entered");
		 }
		 else{
			 Logger.info("password textbox is not displayed");
		 }
	 }
	 catch (Exception e)
	 {
		 Logger.error(e.getMessage());
		  throw e;
	 }
 }
 
//Code to click on login button
 public void clickOnLogin() throws Exception
 {
	 try{
		 if(loginInButton.isEnabled())
		 {
			 loginInButton.click();
			 Logger.info("Clicked on Login button");
		 }
		 else{
			 Logger.info("login button is not enabled");
		 }
	 }
	 catch (Exception e)
	 {
		 Logger.error(e.getMessage());
		  throw e;
	 }
 }
 
 // code to login
 public void login(String passResult) throws Exception
 {
	 if(passResult.equalsIgnoreCase("success"))
	 {
		 Properties properties = TribuneUtils.readProperties();
		// enterUserName(properties.getProperty("username"));
		// enterPassword(properties.getProperty("password"));
		 enterUserName(System.getProperty("userName"));
		 enterPassword(System.getProperty("passWord"));
		 clickOnLogin();
		 Thread.sleep(15000);
	 }
	 else
	 { 
		 TribuneUtils utils = new TribuneUtils();
		 enterUserName(utils.generateRandomAlphaNumString(10));
		 enterPassword(utils.generateRandomAlphaNumString(12));
		 clickOnLogin();
		 Thread.sleep(15000);
	 }
 }



public void login2(String passResult, String userName, String passWord) throws Exception
{
	 if(passResult.equalsIgnoreCase("success"))
	 {
		 
		 enterUserName((userName));
		 enterPassword((passWord));
		 clickOnLogin();
	 }
	 else
	 {  
		 TribuneUtils utils = new TribuneUtils();
		 enterUserName(utils.generateRandomAlphaNumString(10));
		 enterPassword(utils.generateRandomAlphaNumString(12));
		 clickOnLogin();
	 }
}
public void login1(String passResult) throws Exception
{
	 if(passResult.equalsIgnoreCase("success"))
	 {
		 Properties properties = TribuneUtils.readProperties();
		// enterUserName(properties.getProperty("username"));
		// enterPassword(properties.getProperty("password"));
		 enterUserName(System.getProperty("userName1"));
		 enterPassword(System.getProperty("passWord1"));
		 clickOnLogin();
		 Thread.sleep(5000);
	 }
	 else
	 { 
		 TribuneUtils utils = new TribuneUtils();
		 enterUserName(utils.generateRandomAlphaNumString(10));
		 enterPassword(utils.generateRandomAlphaNumString(12));
		 clickOnLogin();
	 }
}//mou


// code to login
public void loginWithProperty(String passResult) throws Exception
{
	 if(passResult.equalsIgnoreCase("success"))
	 {
		 Properties properties = TribuneUtils.readProperties();
		 enterUserName(properties.getProperty("username"));
		 enterPassword(properties.getProperty("password"));
		 clickOnLogin();
		 Thread.sleep(15000);
	 }
	 else {
	 TribuneUtils utils = new TribuneUtils();
	 enterUserName(utils.generateRandomString(5));
	 enterPassword(utils.generateRandomAlphaNumString(12));
	 clickOnLogin();
}
}
//swagata
}
