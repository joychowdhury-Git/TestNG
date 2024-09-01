package com.tribune.adit2.SpecialPrograms;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Special Program Contract
 * @author Sunny Mukherjee
 * @since October 2018
 */

public class NewContractPage 
{

	@FindBy(id = "contract-name")
	public WebElement contractNameInput;

	@FindBy(id = "Text3")
	public WebElement inputCustomer;

	@FindBy(id = "from-date")
	public WebElement packageEffectiveFromDate;

	@FindBy(id = "to-date")
	public WebElement packageEffectiveToDate;

	@FindBy(id = "booking-from-date")
	public WebElement bookingFromDate;

	@FindBy(id = "booking-to-date")
	public WebElement bookingToDate;

	@FindBy(xpath = "//button[@ng-click='vm.saveContract()']")
	public WebElement saveButton;

	@FindBy(xpath = "//button[@ng-click='vm.savePromotion()']")
	public WebElement savePromotionButton;

	@FindBy(xpath = "//button[@ng-click='vm.duplicateContract()']")
	public WebElement duplicateButton;

	@FindBy(xpath = "//button[@ng-click='vm.duplicatePromotion()']")
	public WebElement duplicatePromotionBtn;

	@FindBy(id = "comments")
	public WebElement enterComments;

	@FindBy(xpath = "//*[@id='app']/div[3]/div[2]/div[2]/div/div/ul/li[4]/a")
	public WebElement productsTab;

	@FindBy(xpath = "//*[@id='app']/div[3]/div[2]/div[2]/div/div/ul/li[3]/a")
	public WebElement productsTabPromotion;

	@FindBy(xpath = "//button[@ng-click='addProduct()']")
	public WebElement addProduct;

	@FindBy(id = "btnSaveAddress")
	public WebElement addProductsButton;

	@FindBy(id = "Select2")
	public WebElement buDrpdwn;

	//@FindBy(xpath = "//*[@is-open='pricingRule.open']/div/div/div/div/div/div[2]/button")
	@FindBy(xpath = "//div[@class='row']/div/div/button[@type='button'][1]")//shalini
	public WebElement addPricingRuleButton;

	@FindBy(xpath = "//*[@is-open='chargeRule.open']/div/div/div/div/div/div[2]/button")
	public WebElement addChargeRuleButton;

	@FindBy(id = "pricingType")
	public WebElement pricingTypeDrpdwn;

	@FindBy(id = "comnt")
	public WebElement enterCommentsPricing;

	@FindBy(id = "doller")
	public WebElement enterAmountPricing;

	@FindBy(id = "percntageoff")
	public WebElement enterPercentOffPricing;

	@FindBy(id = "dollerHolday")
	public WebElement enterHolidayAmountPricing;

	@FindBy(id = "holidypercntgof")
	public WebElement enterHolidayPercentOffPricing;

	@FindBy(id = "filterType")
	public WebElement filterTypeDrpdwn;

	@FindBy(xpath = "//*[@id='filter']/../div[@class='btn-group']")
	public WebElement filterDropDown;

	@FindBy(xpath = "//button[text()='Add Filter']")
	public WebElement addFilterButton;

	private WebDriver driver;

	Properties properties = TribuneUtils.readProperties();

	public NewContractPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public void clickOnAddPricingRuleBtn() throws Exception
	{
		try
		{
			if (addProductsButton.isDisplayed())
			{
				addProductsButton.click();
				Logger.info("addPricingRuleBtnClicked");
			}
			else
			{
				Logger.info("addPricingRuleBtn is not displayed");
				throw new NoSuchElementException("addPricingRuleBtn is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickOnAddFilterButton() throws Exception
	{
		try
		{
			if (addFilterButton.isDisplayed())
			{
				addFilterButton.click();
				Logger.info("addFilterButton Clicked");
			}
			else
			{
				Logger.info("addFilterButton is not displayed");
				throw new NoSuchElementException("addFilterButton is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	//shalini 
	public void selectDayOfWeek(String filter) throws Exception
	{
		try
		{

			Actions action = new Actions(driver);
			action.moveToElement(filterDropDown).click().build().perform(); 

			//  if (statusDropDown.isDisplayed())
			//  {
			//	  statusDropDown.click();
			Logger.info("filterDropDown is clicked");
			String index = "";
			switch (filter)

			{
			case "Select all":  index = "multiselect-all";  
			break;
			case "Sunday":  index = "string:61-1";   
			break;
			case "Monday": index="string:61-2"; 
			break;
			case "Wednesday":  index = "string:61-4"; 
			break;
			case "Thursday":  index = "string:61-5";   
			break;
			case "Friday":  index = "string:61-6";  
			break;
			case "Saturday":  index = "string:61-7"; 
			break;
			default:
				break;
			} 

			//WebElement searchResult = driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[3]/div[2]/div/div[1]/div[2]/div/div/ul/li["+index+"]/a/label/input"));
			WebElement searchResult = driver.findElement(By.xpath("//li/a/label[@class='checkbox']/input[@value='"+index+"']"));//shalini
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
			Thread.sleep(5000);
			Actions action1 = new Actions(driver);
			action1.moveToElement(searchResult).click().build().perform();
			//searchResult.click();

			Logger.info("'"+ filter + "' filter is selected"); 



		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public String selectFirstClassCode() throws Exception
	{
		try
		{

			Actions action = new Actions(driver);
			action.moveToElement(filterDropDown).click().build().perform(); 				

			Logger.info("filterDropDown is clicked");			 		 


			WebElement searchResult = driver.findElement(By.xpath("//li/a/label[@class='checkbox']/input[@value='string:76-269']"));//shalini
			String classcodeValue = searchResult.getText();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
			Thread.sleep(5000);
			action.moveToElement(searchResult).click().build().perform();
			//searchResult.click();

			Logger.info(classcodeValue+" classcodeValue filter is selected"); 
			return classcodeValue;


		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectFilterType(String Filter) throws Exception
	{
		try
		{
			if (filterTypeDrpdwn.isDisplayed())
			{
				filterTypeDrpdwn.click();
				Select valueFromBU = new Select(filterTypeDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter)+ " filterType is selected"); 
				}
				else
				{
					Logger.info("drop down is empty");
				}
			}
			else
			{
				Logger.info("filterTypeDrpdwn is not displayed");
				throw new NoSuchElementException("filterTypeDrpdwn is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void enterHolidayAmountPricing(String amount) throws Exception
	{
		try{
			if (enterHolidayAmountPricing.isEnabled())
			{
				Logger.info("enterHolidayAmountPricing text box is visible");
				enterHolidayAmountPricing.click();
				enterHolidayAmountPricing.sendKeys(Keys.CONTROL,"a");
				enterHolidayAmountPricing.clear();
				enterHolidayAmountPricing.sendKeys(amount);
				enterHolidayAmountPricing.sendKeys(Keys.ENTER);
				Thread.sleep(6000);				
				Logger.info(amount+ " enterHolidayAmountPricing is entered");
			}
			else
			{
				Logger.info("enterHolidayAmountPricing text box is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterHolidayPercentOffPricing(String amount) throws Exception
	{
		try{
			if (enterHolidayPercentOffPricing.isEnabled())
			{
				Logger.info("enterHolidayPercentOffPricing text box is visible");
				enterHolidayPercentOffPricing.click();
				enterHolidayPercentOffPricing.sendKeys(Keys.CONTROL,"a");
				enterHolidayPercentOffPricing.clear();
				enterHolidayPercentOffPricing.sendKeys(amount);
				enterHolidayPercentOffPricing.sendKeys(Keys.ENTER);
				Thread.sleep(6000);				
				Logger.info(amount+ " enterHolidayAmountPricing is entered");
			}
			else
			{
				Logger.info("enterHolidayAmountPricing text box is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterAmountPricing(String amount) throws Exception
	{
		try{
			if (enterAmountPricing.isEnabled())
			{
				Logger.info("enterAmountPricing text box is visible");
				enterAmountPricing.click();
				enterAmountPricing.sendKeys(Keys.CONTROL,"a");
				enterAmountPricing.clear();
				enterAmountPricing.sendKeys(amount);
				enterAmountPricing.sendKeys(Keys.ENTER);
				Thread.sleep(6000);				
				Logger.info(amount+ " enterAmountPricing is entered");
			}
			else
			{
				Logger.info("enterAmountPricing text box is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	public void enterPercentOffPricing(String amount) throws Exception
	{
		try{
			if (enterPercentOffPricing.isEnabled())
			{
				Logger.info("enterPercentOffPricing text box is visible");
				enterPercentOffPricing.click();
				enterPercentOffPricing.sendKeys(Keys.CONTROL,"a");
				enterPercentOffPricing.clear();
				enterPercentOffPricing.sendKeys(amount);
				enterPercentOffPricing.sendKeys(Keys.ENTER);
				Thread.sleep(6000);				
				Logger.info(amount+ " enterPercentOffPricing is entered");
			}
			else
			{
				Logger.info("enterPercentOffPricing text box is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterCommentsPricing(String comments) throws Exception
	{
		try{
			if (enterCommentsPricing.isEnabled())
			{
				Logger.info("enterCommentsPricing text box is visible");
				enterCommentsPricing.click();
				enterCommentsPricing.sendKeys(Keys.CONTROL,"a");
				enterCommentsPricing.clear();
				enterCommentsPricing.sendKeys(comments);
				enterCommentsPricing.sendKeys(Keys.ENTER);
				Thread.sleep(6000);				
				Logger.info(comments+ " enterCommentsPricing is entered");
			}
			else
			{
				Logger.info("enterCommentsPricing text box is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectPricingType(String Pricing) throws Exception
	{
		try
		{ WebDriverWait wait=new WebDriverWait(driver, 20);//swagata
		wait.until(ExpectedConditions.elementToBeClickable(pricingTypeDrpdwn));//swagata
		if (pricingTypeDrpdwn.isDisplayed())
		{   

			pricingTypeDrpdwn.click();
			Select valueFromBU = new Select(pricingTypeDrpdwn);
			List<WebElement> listOfValuesBU = valueFromBU.getOptions();
			if(listOfValuesBU.size() !=0)
			{
				valueFromBU.selectByVisibleText((Pricing));
				Logger.info((Pricing)+ " pricingType is selected"); 
			}
			else
			{
				Logger.info("drop down is empty");
			}
		}
		else
		{
			Logger.info("pricingTypeDrpdwn is not displayed");
			throw new NoSuchElementException("pricingTypeDrpdwn is not displayed");
		}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	public void clickOnAddChargeRuleButton() throws Exception
	{
		try
		{
			if (addChargeRuleButton.isDisplayed())
			{
				addChargeRuleButton.click();
				Logger.info("addChargeRuleButton Clicked");
			}
			else
			{
				Logger.info("addChargeRuleButton is not displayed");
				throw new NoSuchElementException("addChargeRuleButton is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}



	public void clickOnAddPricingRuleButton() throws Exception
	{
		try
		{
			if (addPricingRuleButton.isDisplayed())
			{
				addPricingRuleButton.click();
				Logger.info("addPricingRuleButton Clicked");
			}
			else
			{
				Logger.info("addPricingRuleButton is not displayed");
				throw new NoSuchElementException("addPricingRuleButton is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	public void selectProduct(String Product) throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,200);
			//WebElement product = driver.findElement(By.xpath("//a[text()='"+Product+"']")); //shalni
			WebElement product = driver.findElement(By.xpath("(//span[contains(text(),'"+Product+"')])[1]/../span[2]/span/input"));//shalini
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", product);
			wait.until(ExpectedConditions.elementToBeClickable(product));
			if (product.isDisplayed())
			{
				product.click();
				Logger.info("productCheckbox Clicked");
			}
			else
			{
				Logger.info("productCheckbox is not displayed");
				throw new NoSuchElementException("productCheckbox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickaddProductsButton() throws Exception
	{
		try
		{
			if (addProductsButton.isDisplayed())
			{
				addProductsButton.click();
				Logger.info("addProductsButton Clicked");
			}
			else
			{
				Logger.info("addProductsButton is not displayed");
				throw new NoSuchElementException("addProductsButton is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	public void selectProductType(String Product) throws Exception
	{
		try
		{
			//WebElement productCheckbox = driver.findElement(By.xpath("//div[@title='"+Product+"']/span[2]/span/input"));//shalini
			WebElement productPlus = driver.findElement(By.xpath("//div[@title='"+Product+"']/span"));//shalini
			if (productPlus.isDisplayed())
			{
				productPlus.click();
				Logger.info("productPlus Clicked");
			}
			else
			{
				Logger.info("productPlus is not displayed");
				throw new NoSuchElementException("productPlus is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectBU(String BU) throws Exception
	{
		try
		{
			if (buDrpdwn.isDisplayed())
			{
				buDrpdwn.click();
				Select valueFromBU = new Select(buDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					valueFromBU.selectByVisibleText((BU));
					Logger.info((BU)+ " BU is selected"); 
				}
				else
				{
					Logger.info("drop down is empty");
				}
			}
			else
			{
				Logger.info("type drop down is not displayed");
				throw new NoSuchElementException("type drop down is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickOnAddProductButton() throws Exception
	{
		try
		{
			if (addProduct.isDisplayed())
			{
				addProduct.click();
				Logger.info("addProduct Clicked");
			}
			else
			{
				Logger.info("addProduct is not displayed");
				throw new NoSuchElementException("addProduct is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	public void clickOnProductsTab() throws Exception
	{
		try
		{
			if (productsTab.isDisplayed())
			{
				productsTab.click();
				Logger.info("productsTab Clicked");
			}
			else
			{
				Logger.info("productsTab is not displayed");
				throw new NoSuchElementException("productsTab is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickOnProductsTabPromotion() throws Exception
	{
		try
		{
			if (productsTabPromotion.isDisplayed())
			{
				productsTabPromotion.click();
				Logger.info("productsTabPromotion Clicked");
			}
			else
			{
				Logger.info("productsTabPromotion is not displayed");
				throw new NoSuchElementException("productsTabPromotion is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	public void clickOnSave() throws Exception
	{
		try
		{
			if (saveButton.isDisplayed())
			{
				saveButton.click();
				Logger.info("saveButton Clicked");
			}
			else
			{
				Logger.info("saveButton is not displayed");
				throw new NoSuchElementException("saveButton is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickOnSavePromotion() throws Exception
	{
		try
		{
			if (savePromotionButton.isDisplayed())
			{
				savePromotionButton.click();
				Logger.info("savePromotionButton Clicked");
			}
			else
			{
				Logger.info("savePromotionButton is not displayed");
				throw new NoSuchElementException("savePromotionButton is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	public void clickOnDuplicate() throws Exception
	{
		try
		{
			if (duplicateButton.isDisplayed())
			{
				duplicateButton.click();
				Logger.info("duplicateButton Clicked");
			}
			else
			{
				Logger.info("duplicateButton is not displayed");
				throw new NoSuchElementException("duplicateButton is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickOnDuplicatePromotion() throws Exception
	{
		try
		{
			if (duplicatePromotionBtn.isDisplayed())
			{
				duplicatePromotionBtn.click();
				Logger.info("duplicatePromotionBtn Clicked");
			}
			else
			{
				Logger.info("duplicatePromotionBtn is not displayed");
				throw new NoSuchElementException("duplicatePromotionBtn is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	public void enterContractEffectiveFromDate(int mm, int dd, int yyyy) throws Exception
	{
		try{
			packageEffectiveFromDate.click();
			packageEffectiveFromDate.sendKeys(mm+"/"+dd+"/"+yyyy);
			packageEffectiveFromDate.sendKeys(Keys.CONTROL, "a");
			packageEffectiveFromDate.sendKeys(Keys.CONTROL, "\b");
			Thread.sleep(2000);

			packageEffectiveFromDate.sendKeys(mm+"/"+dd+"/"+yyyy);
			Thread.sleep(2000);
			Logger.info("contract effective from date is entered");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void enterContractEffectiveToDate(int mm, int dd, int yyyy) throws Exception
	{
		try{
			packageEffectiveToDate.click();
			packageEffectiveToDate.sendKeys(mm+"/"+dd+"/"+yyyy);
			Thread.sleep(2000);
			packageEffectiveToDate.sendKeys(Keys.CONTROL, "a");
			packageEffectiveToDate.sendKeys(Keys.CONTROL, "\b");
			Thread.sleep(2000);
			packageEffectiveToDate.sendKeys(mm+"/"+dd+"/"+yyyy);
			Logger.info("contract effective to date is entered");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void enterbookingFromDate(int mm, int dd, int yyyy) throws Exception
	{
		try{
			bookingFromDate.click();
			bookingFromDate.sendKeys(mm+"/"+dd+"/"+yyyy);
			bookingFromDate.sendKeys(Keys.CONTROL, "a");
			bookingFromDate.sendKeys(Keys.CONTROL, "\b");
			Thread.sleep(2000);

			bookingFromDate.sendKeys(mm+"/"+dd+"/"+yyyy);
			Thread.sleep(2000);
			Logger.info("promotion booking from date is entered");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void enterbookingToDate(int mm, int dd, int yyyy) throws Exception
	{
		try{
			bookingToDate.click();
			bookingToDate.sendKeys(mm+"/"+dd+"/"+yyyy);
			Thread.sleep(2000);
			bookingToDate.sendKeys(Keys.CONTROL, "a");
			bookingToDate.sendKeys(Keys.CONTROL, "\b");
			Thread.sleep(2000);
			bookingToDate.sendKeys(mm+"/"+dd+"/"+yyyy);
			Logger.info("promotion booking to date is entered");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void enterComments(String comments) throws Exception
	{
		try{
			if (enterComments.isEnabled())
			{
				Logger.info("enterComments text box is visible");
				enterComments.click();
				enterComments.sendKeys(Keys.CONTROL,"a");
				enterComments.clear();
				enterComments.sendKeys(comments);
				enterComments.sendKeys(Keys.ENTER);
				Thread.sleep(6000);				
				Logger.info(comments+ " enterComments is entered");
			}
			else
			{
				Logger.info("enterComments text box is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterContractName(String contractName) throws Exception
	{
		try{
			if (contractNameInput.isEnabled())
			{
				Logger.info("contractNameInput text box is visible");
				contractNameInput.click();
				contractNameInput.sendKeys(Keys.CONTROL,"a");
				contractNameInput.sendKeys(Keys.CONTROL,"\b");//swagata
				contractNameInput.clear();
				Thread.sleep(4000);
				contractNameInput.sendKeys(contractName);
				contractNameInput.sendKeys(Keys.ENTER);
				Thread.sleep(6000);				
				Logger.info(contractName+ " contractNameInput is entered");
			}
			else
			{
				Logger.info("contractNameInput text box is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void inputCustomer(String customer) throws Exception
	{
		try{
			if (inputCustomer.isEnabled())
			{
				Logger.info("inputCustomer text box is visible");
				inputCustomer.click();
				inputCustomer.sendKeys(Keys.CONTROL,"a");
				inputCustomer.clear();
				inputCustomer.sendKeys(customer);
				inputCustomer.sendKeys(Keys.ENTER);
				Thread.sleep(60000);
				WebElement customerDetails = driver.findElement(By.xpath("//a[@class='customer-aclist-item ng-scope']/div/span[3]"));
				WebDriverWait wait = new WebDriverWait(driver, 120);
				wait.until(ExpectedConditions.visibilityOf(customerDetails));
				customerDetails.click();
				Thread.sleep(2000);
				Logger.info(customer+ " inputCustomer is entered");
			}
			else
			{
				Logger.info("inputCustomer text box is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	public void enterContractEffectiveToDateFromExcel(int row, int col) throws Exception
	{
		try{

			String value = TribuneUtils.getStringCellValues("Product",row, col);
			Logger.info("Date from excel "+value);

			String[] parts = value.split("/");
			String dateString = parts[1];
			int date = Integer.parseInt(dateString);
			Logger.info("Date :"+date);
			String month = parts[0];
			Logger.info("month :"+month);
			String yearString = parts[2];
			int year = Integer.parseInt(yearString);
			Logger.info("year :"+year);
			/*if (date.length() == 1)
			{
				switch (date)

				{
				case "1":  date = "01";       break;
				case "2":  date = "02";       break;
				case "3":  date = "03";       break;
				case "4":  date = "04";       break;
				case "5":  date = "05";       break;
				case "6":  date = "06";       break;
				case "7":  date = "07";       break;
				case "8":  date = "08";       break;
				case "9":  date = "09";       break;        

				} 
			}
			Logger.info("Date number is "+date);*/
			//String monthString = "";
			long mon = 0;
			switch (month)

			{
			case "Jan":  mon = 01;      break;
			case "Feb":  mon = 02;      break;
			case "Mar":  mon = 03;      break;
			case "Apr":  mon = 04;      break;
			case "May":  mon = 05;      break;
			case "Jun":  mon = 06;      break;
			case "Jul":  mon = 07;      break;
			case "Aug":  mon = 8;       break;
			case "Sep":  mon = 9;       break;
			case "Oct":  mon = 10;      break;
			case "Nov":  mon = 11;      break;
			case "Dec":  mon = 12;      break;

			}
			Logger.info("Month is "+mon);
			packageEffectiveToDate.click();
			packageEffectiveToDate.sendKeys(mon+"/"+date+"/"+year);
			Thread.sleep(2000);
			packageEffectiveToDate.sendKeys(Keys.CONTROL, "a");
			packageEffectiveToDate.sendKeys(Keys.CONTROL, "\b");
			Thread.sleep(2000);
			packageEffectiveToDate.sendKeys(mon+"/"+date+"/"+year);
			Logger.info("contract effective to date is entered");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata


}
