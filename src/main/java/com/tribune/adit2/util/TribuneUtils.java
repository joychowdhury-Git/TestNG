package com.tribune.adit2.util;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.BreakIterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTML;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.tribune.adit2.Customers.HomeSearchPage;
import com.tribune.adit2.testng.Logger;

public class TribuneUtils 
{
	static final String baseString="ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz 1234567890";

	/* This method is used to read the properties file and extract the required property*/
	public static Properties readProperties()
	{
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\datafile.properties");
		FileInputStream fileInput = null;
		try
		{
			fileInput = new FileInputStream(file);	
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try 
		{
			prop.load(fileInput);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return prop;

	}

	/* This method is used to launch the URL */
	public final void launchURL(WebDriver driver,String url)
	{
		driver.get(url);
		driver.manage().deleteAllCookies();//swagata
		Logger.info("URL launched is:\t"+url);
		driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(800, 600));
		//HTML.sendKeys(Key.chord(Keys.CONTROL, Keys.SUBTRACT));
	}
	
	public final void launchURL1(WebDriver driver,String url)
	{
		driver.get(url);
		Logger.info("URL launched is:\t"+url);
		driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(800, 600));
		//HTML.sendKeys(Key.chord(Keys.CONTROL, Keys.SUBTRACT));
	}

	/* This method is used to implement implicitlyWait function*/
	public final void implementWait(WebDriver driver)
	{
		Properties properties = readProperties();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("waitTime")), TimeUnit.SECONDS);
		Logger.info("wait until the page is loaded");
	}

	public static String getUsername() throws Exception
	{
		String userName = "cymkozalg6";
		return userName;
	}

	public static String getPassword() throws Exception
	{
		String password = "Tribune@1";
		return password;
	}

	//code to get the string values from excel sheet
	public static String getStringCellValues(String sheetName,int rowNum, int columnNum) throws Exception
	{
		//FileInputStream filePath  = new FileInputStream("D:/Sunny_Do_Not_Delete/ADIT 2 Automation Project Latest 12222016/src/main/resources/Adit2.0_TestData.xlsx");
		FileInputStream filePath  = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Adit2.0_TestData.xlsx");
		Logger.info("Excel Path: "+System.getProperty("user.dir")+"\\src\\main\\resources\\Adit2.0_TestData.xlsx");
		Workbook workBookInstance = WorkbookFactory.create(filePath);
		Sheet sheet = workBookInstance.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(columnNum);
		String cellValue = "";
		cellValue = cell.getStringCellValue(); 
		return cellValue;
	}

	//code to get the string values from excel sheet
	public static Double getDoubleCellValues(String sheetName, int rowNum, int columnNum) throws Exception
	{
		FileInputStream filePath  = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Adit2.0_TestData.xlsx");
		Workbook workBookInstance = WorkbookFactory.create(filePath);
		Sheet sheet = workBookInstance.getSheet(sheetName);  	  
		Row row = sheet.getRow(rowNum);  	  
		Cell cell = row.getCell(columnNum);
		Double cellValue = 0.0;
		cellValue = cell.getNumericCellValue();
		return cellValue;
	}

	//code to get the string values from excel sheet
	public static Integer getIntCellValues(String sheetName,int rowNum, int columnNum) throws Exception
	{
		FileInputStream filePath  = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Adit2.0_TestData.xlsx");
		Workbook workBookInstance = WorkbookFactory.create(filePath);
		Sheet sheet = workBookInstance.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(columnNum);
		Double cellValue = 0.0;
		cellValue = cell.getNumericCellValue();
		return cellValue.intValue();
	}

	public static String getCreditCardNumber(String vendorName) throws Exception
	{
		String cardNumber = "";
		try
		{
			if(vendorName.equalsIgnoreCase("Visa")){
				cardNumber= "4111111111111111";	
			}
			else if(vendorName.equalsIgnoreCase("Master")){
				cardNumber= "5555555555554444";	
			}
			else if(vendorName.equalsIgnoreCase("Discover")){
				cardNumber= "6011111111111117";	
			}
			else if(vendorName.equalsIgnoreCase("AmericanExpress")){
				cardNumber= "378282246310005";	
			}
			else if(vendorName.equalsIgnoreCase("AmericanExpressCorporate")){
				cardNumber= "378734493671000";	
			}
			else if(vendorName.equalsIgnoreCase("Master2Sesies")){
				cardNumber= "2223000148400010";	
			}//swagata
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return cardNumber;
	}

	public static String getCreditCardSecurityCode(String vendorName) throws Exception
	{
		String securityCode = "";
		try
		{
			if(vendorName.equalsIgnoreCase("Visa")){
				securityCode= "123";	
			}
			else if(vendorName.equalsIgnoreCase("Master")){
				securityCode= "123";	
			}
			else if(vendorName.equalsIgnoreCase("Discover")){
				securityCode= "123";	
			}
			else if(vendorName.equalsIgnoreCase("AmericanExpress")){
				securityCode= "1234";	
			}
			else if(vendorName.equalsIgnoreCase("AmericanExpressCorporate")){
				securityCode= "123";	
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return securityCode;
	}

	public static String getCreditCardExpMonth(String vendorName) throws Exception
	{
		String expMonth = "";
		try
		{
			if(vendorName.equalsIgnoreCase("Visa")){
				expMonth= "5";	
			}
			else if(vendorName.equalsIgnoreCase("Master")){
				expMonth= "5";	
			}
			else if(vendorName.equalsIgnoreCase("Discover")){
				expMonth= "5";	
			}
			else if(vendorName.equalsIgnoreCase("AmericanExpress")){
				expMonth= "5";	
			}
			else if(vendorName.equalsIgnoreCase("AmericanExpressCorporate")){
				expMonth= "5";	
			}
			else if(vendorName.equalsIgnoreCase("Master2Sesies")){
				expMonth= "5";	
			}//swagata
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return expMonth;
	}

	public static String getCreditCardExpYear(String vendorName) throws Exception
	{
		String expYear = "";
		try
		{
			if(vendorName.equalsIgnoreCase("Visa")){
				expYear= "2023";	
			}
			else if(vendorName.equalsIgnoreCase("Master")){
				expYear= "2023";	
			}
			else if(vendorName.equalsIgnoreCase("Discover")){
				expYear= "2023";	
			}
			else if(vendorName.equalsIgnoreCase("AmericanExpress")){
				expYear= "2023";	
			}
			else if(vendorName.equalsIgnoreCase("AmericanExpressCorporate")){
				expYear= "2023";	
			}
			else if(vendorName.equalsIgnoreCase("Master2Sesies")){
				expYear= "2023";	
			}//swagata
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return expYear;
	}

	public static String getACHAccNumber(String achAccType) throws Exception
	{
		String accNumber = "";
		try
		{
			if(achAccType.equalsIgnoreCase("Type1")){
				accNumber= "4100";	
			}
			else if(achAccType.equalsIgnoreCase("Type2")){
				accNumber= "4101";	
			}
			else if(achAccType.equalsIgnoreCase("Type3")){
				accNumber= "4102";	
			}
			else if(achAccType.equalsIgnoreCase("Type4")){
				accNumber= "4103";	
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return accNumber;
	}

	public static String getACHAccRoutingNumber(String achAccType) throws Exception
	{
		String accRoutingNumber = "";
		try
		{
			if(achAccType.equalsIgnoreCase("Type1")){
				accRoutingNumber= "121042882";	
			}
			else if(achAccType.equalsIgnoreCase("Type2")){
				accRoutingNumber= "121107882";	
			}
			else if(achAccType.equalsIgnoreCase("Type3")){
				accRoutingNumber= "071923284";	
			}
			else if(achAccType.equalsIgnoreCase("Type4")){
				accRoutingNumber= "122101191";	
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return accRoutingNumber;
	}


	/**
	 * @description This method calculates and returns date in future(in mmm/dd/yyyy) depending on the requested number of days in future
	 */
	public static String getFutureDate(int date) throws Exception
	{
		DateFormat dateFormat = new SimpleDateFormat("MMM/dd/yyyy ");
		Calendar calendarInstance = Calendar.getInstance();
		calendarInstance.add(Calendar.DAY_OF_MONTH, date);
		Logger.info("A day in future is " +dateFormat.format(calendarInstance.getTime()));
		return dateFormat.format(calendarInstance.getTime());

	}

	/**
	 * @description This method returns current system's date
	 */
	public static String getCurrentSystemDate() throws Exception
	{
		DateFormat dateFormat = new SimpleDateFormat("MMM/dd/yyyy ");
		Calendar calendarInstance = Calendar.getInstance();
		Logger.info("Current System Date " +dateFormat.format(calendarInstance.getTime()));
		return dateFormat.format(calendarInstance.getTime());

	}

	public final String generateRandomString()
	{
		try
		{
			BreakIterator line = BreakIterator.getSentenceInstance();

			line.setText(baseString);

			int startL=line.first();
			int endL = line.next();
			String firstSentence = baseString.substring(startL,endL);
			return firstSentence;

		}
		catch(Exception e)
		{
			Logger.info(e.getMessage());
			throw e;
		}
	}
	/**.
	 * Generate  random integers in the range 0..n. 
	 * @param     numberOfDigits
	 * @return    integer - a random integer
	 * */
	public final int randomInteger(final int numberOfDigits) {
		Random randomGenerator = new Random();
		boolean flag= false;
		int randomInt;
		do {
			int ndigits = 1;
			for (int i = 1; i <= numberOfDigits ; i++)
				ndigits = 10 * ndigits;
			randomInt = randomGenerator.nextInt(ndigits);
			int power = (int) Math.pow(10, numberOfDigits-1);
			if(randomInt>=power)
				break;
		}while (flag);
		return randomInt;
	}

	/**.
	 * Generate  random String. 
	 * @param     length
	 * @return    String - a random string
	 * */
	static final String randomString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public final String generateRandomString(final int length) {
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) 
			sb.append(randomString.charAt(rnd.nextInt(randomString.length()) ) );
		return sb.toString();
	}

	/**.
	 * Generate  random AlphaNumeric String. 
	 * @param     length
	 * @return    AlphaNumeric String - a random AlphaNumeric String
	 * */
	static final String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public final String generateRandomAlphaNumString(final int length) {
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) 
			sb.append(alphaNumeric.charAt(rnd.nextInt(alphaNumeric.length())) );
		return sb.toString();
	}

	static final String Numeric = "0123456789";
	public final String generateRandomNumString(final int length) {
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) 
			sb.append(alphaNumeric.charAt(rnd.nextInt(alphaNumeric.length())) );
		return sb.toString();
	}

	public void scroll(WebDriver driver, WebElement ele) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);
		Thread.sleep(2000);
	}

	/**.
	 * A general method to click a web element
	 * @param ele
	 * @throws Exception
	 */
	public final void clickWebElement(WebElement ele) throws Exception {
		try{
			String eleName = ele.getAttribute("innerText").trim().toUpperCase();
			Thread.sleep(1000);
			if(eleName.isEmpty()) eleName = ele.toString();
			if(ele.isDisplayed()){				 
				ele.click();
				Thread.sleep(2000);
				Logger.info("Clicked on: "+ eleName);
			}
			else{
				Logger.info("'"+eleName+"'" + " : is not displayed.");
			}
		}
		catch(NoSuchElementException e){
			Logger.error("Element is not found. " + e.getMessage());
		}
		catch(ElementNotVisibleException e){
			Logger.error("Element is not visible. " + e.getMessage());
			throw e;
		}
	}
	

	/**.
	 * A general method to fill text in an input field without logging
	 * @param ele
	 * @param input
	 * @param logFlg
	 * @param labelName
	 */
	public void fillText(WebElement ele,String input, boolean logFlg, String labelName)	{
		try{
			if(ele.isDisplayed()){
				ele.click();
				ele.clear();
				ele.sendKeys(input);

				if(logFlg){
					Logger.info(labelName.toUpperCase()+" entered: "+input);
				}
				ele.sendKeys(Keys.TAB);
			}
			else{
				Logger.info(labelName.toUpperCase() + " text is not available.");
				throw new NoSuchElementException("The text is not available..");
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**.
	 * A general method to select particular value in a list of webelements
	 * @param eles of List<WebElement> type
	 * @param searchText
	 */
	public boolean searchListForText(List<WebElement> eles, String searchText){
		Boolean found = false;
		try{
			for(int i=0; i<eles.size(); i++) {
			    if(eles.get(i).getText().equals(searchText)) {
			        found=true;
			    }
			}
		}
		catch(Exception e){
			Logger.error(e.getMessage());
		}
		return found;
	}
}
