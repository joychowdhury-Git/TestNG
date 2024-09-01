package com.tribune.adit2.NewsPaperLayout;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for News Paper Layout Page
 * @author Priyanka Goud CR 
 * @since October 2015
 */

public class NewsPaperLayoutsPage 
{

	@FindBy(id = "BusinessUnitId")
	public WebElement businessUnitDrpDwn;
	
	@FindBy(id = "DayOfWeek")
	public WebElement dayOfWeek;
	
	@FindBy(id = "ProductId")
	public WebElement productId;

	@FindBy(id = "SectionId")
	public WebElement sectionId;
	
	//@FindBy(xpath = "//input[@id='ShowCurrentVersionsOnly']/../i")
	//@FindBy (id = "ShowCurrentVersionsOnly")
	@FindBy(xpath = "//*[@id='app']/div[3]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/label/i")
	public WebElement currentTemplateCheckBox;
	
	@FindBy(id = "btnSearch")
	public WebElement newsPaperLayoutSearchBtn;
	
	@FindBy(id = "resultTemplateCount")
	public WebElement countOfResultsFound;
	
	@FindBy(xpath = "//tr[@class='section-version-item ng-scope']/td[2]")
	public List<WebElement> resultsSectionColumn;
	
	@FindBy (xpath = "//button[contains(text(),'Template')]")
	public WebElement addNewTemplateBtn;
	
	@FindBy (id = "section-description")
	public WebElement newTemplateDescription;
	
	@FindBy (id = "dateType")
	public WebElement dateTypeDrpDown;
	
	@FindBy (id = "EffectiveDate")
	public WebElement dateSelectionTxtBx;
	
	//@FindBy (xpath = "//input[@id='isInherit']/../i")
	//@FindBy (id = "isInherit")
	@FindBy (xpath = "html/body/div[1]/div/div/div/div[2]/div[4]/div/div/label/i")	
	public WebElement inheritFromCheckBox;
	
	@FindBy (id = "btnSaveTemplate")
	public WebElement saveTemplateBtn;
	
	@FindBy (id = "btnCancel")
	public WebElement cancelTemplateCreationBtn;
	
	@FindBy (xpath = "//span[@id='resultTemplateCount']")
	public WebElement newsPaperLayoutIDList;
	
	/*@FindBy (id = "btnCopy")
	public WebElement copyButtonNewsPaperLayoutSearchPage;
	
	@FindBy (id = "btnPaste")
	public WebElement pasteButtonNewsPaperLayoutSearchPage;*/
	
	
	private WebDriver driver;
	
	Properties properties = TribuneUtils.readProperties();
	
	public NewsPaperLayoutsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
//Code to select business Unit
	public void selectBU(String BU) throws Exception
	  {
		  try
		  {
			  if (businessUnitDrpDwn.isDisplayed())
			  {
				  businessUnitDrpDwn.click();
				  Select valueFromBU = new Select(businessUnitDrpDwn);
			      List<WebElement> listOfValuesBU = valueFromBU.getOptions();
			      if(listOfValuesBU.size() !=0)
				      {
				    	 valueFromBU.selectByVisibleText(properties.getProperty(BU).toString());
				         Logger.info(properties.getProperty(BU)+ " business Unit is selected"); 
				      }
			      else
			      {
			    	  Logger.info("drop down is empty");
			      }
			  }
			  else
			  {
				  Logger.info("Business Unit drop down is not displayed");
				  throw new NoSuchElementException("Business Unit drop down is not displayed");
			  }
			
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }
	
//Code to select the day of the week
	public void selectDayOfWeek(String day) throws Exception
	{
		try
		  {
			  if (dayOfWeek.isDisplayed())
			  {
				  dayOfWeek.click();
				  Select selectDay = new Select(dayOfWeek);
			      List<WebElement> listOfDays = selectDay.getOptions();
			      if(listOfDays.size() !=0)
				  {
			    	selectDay.selectByVisibleText(properties.getProperty(day).toString());
				    Logger.info(properties.getProperty(day)+" day of the week is selected"); 
				  }
			      else
			      {
			    	  Logger.info("drop down is empty");
			      }
			  }
			  else
			  {
				  Logger.info("DayOfWeek drop down is not displayed");
				  throw new NoSuchElementException("DayOfWeek drop down is not displayed");
			  }
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	  }

//code to select the product
	public void selectProduct(String product) throws Exception
	{
		try
		  {
			  if (productId.isDisplayed())
			  {
				  productId.click();
				  Select selectProduct = new Select(productId);
			      List<WebElement> listOfProducts = selectProduct.getOptions();
			      if(listOfProducts.size() !=0)
				  {
			    	  selectProduct.selectByVisibleText(properties.getProperty(product).toString());
				      Logger.info(properties.getProperty(product)+" product is selected"); 
				  }
				  else
				  {
					  Logger.info("drop down is empty");
				  }
			  }
			  else
			  {
				  Logger.info("product drop down is not displayed");
				  throw new NoSuchElementException("product drop down is not displayed");
			  }
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}
	
	public void selectProduct1(String product1) throws Exception
	{
		try
		  {
			  if (productId.isDisplayed())
			  {
				  productId.click();
				  Select selectProduct = new Select(productId);
			      List<WebElement> listOfProducts = selectProduct.getOptions();
			      if(listOfProducts.size() !=0)
				  {
			    	  selectProduct.selectByVisibleText(product1);
				      Logger.info(product1+" product is selected"); 
				  }
				  else
				  {
					  Logger.info("drop down is empty");
				  }
			  }
			  else
			  {
				  Logger.info("product drop down is not displayed");
				  throw new NoSuchElementException("product drop down is not displayed");
			  }
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}
	
//Code to select the section 
	public void selectSection(int sectionIndex) throws Exception
	{
		try
		  {
			  if (sectionId.isDisplayed())
			  {
				  Select selectSection = new Select(sectionId);
			      List<WebElement> listOfSections = selectSection.getOptions();
			      if(listOfSections.size() !=0)
				  {
			    	  selectSection.selectByIndex(sectionIndex);
			    	  Logger.info( " section is selected"); 
				  }
				  else
				  {
					  Logger.info("drop down is empty");
				  }
			  }
			  else
			  {
				  Logger.info("section drop down is not displayed");
			}
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}
	
public String getSectionIDSelectedInSearch() throws Exception
{
	try{
		Select select = new Select(sectionId); 
		  WebElement element = select.getFirstSelectedOption();
		  return element.getText();
	}
	catch(Exception e)
	{
		  Logger.error(e.getMessage());
		  throw e;
	} 
}
	
//code to select or deselect the current template option
	public void checkOrUncheckCurrentTemplate(boolean value) throws Exception
	{
		Logger.info(""+value);
	  if(value)
	  {
		  
	  	if((currentTemplateCheckBox.isSelected())){
	  		Logger.info("Inside If");
	  		Logger.info("current template is selected");
	  	}
	  /*	else{
	  		Logger.info("else loop");
	  		currentTemplateCheckBox.click();
	  		Logger.info("current template is selected");
	  	} */
	  }
	  else
	  {	
	  			if(!(currentTemplateCheckBox.isSelected())){
				Logger.info("Insde Selected");
				Thread.sleep(1000);
				currentTemplateCheckBox.click();
				Thread.sleep(4000);
				Logger.info("current template is deselected");
	  	}
	  	else{
	  		Logger.info("current template is not selected");
	  	} 
	  }
	}

//Code to click on the search button
	public void clickOnSearch() throws Exception
	{
		try
		  {
			  if (newsPaperLayoutSearchBtn.isDisplayed())
			  {
				  newsPaperLayoutSearchBtn.click();
				 Logger.info("search button is clicked");
			  }
			  else
			  {
				  Logger.info("search button is not displayed");
				  throw new NoSuchElementException("search button  is not displayed");
			  }
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  } 
	}
	
//code to click on new template button
	public void clickOnNewTemplateBtn() throws Exception
	{
		try{
			if(addNewTemplateBtn.isDisplayed()){
				addNewTemplateBtn.click();
				Logger.info("New templae button is clicked");
			}
			else{
				Logger.info("new template button is not displayed");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  }
	}
	
//code to enter description for a new template
	public void enterDescription() throws Exception
	{
		try{
			if(newTemplateDescription.isDisplayed()){
				newTemplateDescription.click();
				newTemplateDescription.clear();
				TribuneUtils utils = new TribuneUtils();
				newTemplateDescription.sendKeys("AutoTest"+utils.generateRandomAlphaNumString(22));
				Logger.info("Description is entered");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  }
	}

//code to select the type of the date
	public void selectDatetype(String dateType) throws Exception{
		try{
			if(dateTypeDrpDown.isDisplayed()){
				Select select = new Select(dateTypeDrpDown);
				select.selectByVisibleText(properties.getProperty(dateType));
				Logger.info(dateType +" Date type is selected");
			}else{
				Logger.info("date type drop down is not displayed");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  }
	}
	
//code to select the date 
	public void enterDate(String dd, String mmm, String yy) throws Exception
	{
		dateSelectionTxtBx.click();
		  WebElement curentMonthElement = driver.findElement(By.xpath("//th[@class='datepicker-switch']"));
		  String currentMonthYear = curentMonthElement.getText();
		  Logger.info("current month year from calendar "+currentMonthYear);
		  String expectedDate = properties.get(mmm).toString() + " " + yy;
		  Logger.info("expected month year from user " +expectedDate);
		  if(currentMonthYear.equalsIgnoreCase(expectedDate))
		  {
			  WebElement dateElement = driver.findElement(By.xpath("//td[@class='day'][text()='"+dd+"']"));
			  dateElement.click();
			  Logger.info(dd+"/"+mmm+"/"+yy +" is entered");
		  }
		  else
		  {
			  int length = currentMonthYear.length();
			  String currentyear = currentMonthYear.substring(length-4, length);
			  if(currentyear.equalsIgnoreCase(yy))
			  {
			  curentMonthElement.click();
			  WebElement expectedMonthElement = driver.findElement(By.xpath("//td/span[text()='"+mmm+"']"));
			  expectedMonthElement.click();
			  WebElement dateElement = driver.findElement(By.xpath("//td[@class='day'][text()='"+dd+"']"));
			  dateElement.click();
			  Logger.info(dd+"/"+mmm+"/"+yy +" is entered");
			  }
			  else
			  {
				  curentMonthElement.click();
				  WebElement yearElement = driver.findElement(By.xpath("//div[@class='datepicker-months']/table/thead/tr/th[@class='datepicker-switch']"));
				  yearElement.click();
				  WebElement expectedYearElement = driver.findElement(By.xpath("//td/span[contains(@class,'year')][text()='"+yy+"']"));//mou
				  if(expectedYearElement.isDisplayed())
				  {
					  expectedYearElement.click();
					  WebElement expectedMonthElement = driver.findElement(By.xpath("//td/span[text()='"+mmm+"']"));
					  expectedMonthElement.click();
					  WebElement dateElement = driver.findElement(By.xpath("//td[@class='day'][text()='"+dd+"']"));
					  dateElement.click();
					  Logger.info(dd+"/"+mmm+"/"+yy +" is entered");
				  }
				  else
				  {
					  WebElement next = driver.findElement(By.xpath("//th[@class='next']"));
					  next.click();
					  driver.findElement(By.xpath("//td/span[text()='"+yy+"']")).click();
					  driver.findElement(By.xpath("//td/span[text()='"+mmm+"']")).click();
					  driver.findElement(By.xpath("//td[@class='day'][text()='"+dd+"']")).click();
					  Logger.info(dd+"/"+mmm+"/"+yy +" is entered");
				  }
			  }
		  }
	}
	
//Code to check or uncheck inherit from current template check box
	public void checkUncheckInheritFrom(boolean value) throws Exception
	{
		Logger.info("Value="+value);
		if(value){
			Logger.info("Inside true section");
			if(inheritFromCheckBox.isSelected()){
				Logger.info("inherit from check box is selected");
			}else {
				Thread.sleep(1000);
				inheritFromCheckBox.click();
				Thread.sleep(4000);
				Logger.info("inherit from check box is selected");
			}
		}
		else{
			Logger.info("Inside false section");
			if(!(inheritFromCheckBox.isSelected())){
				Logger.info("Insde Selected");
				Thread.sleep(1000);
				inheritFromCheckBox.click();
				Thread.sleep(4000);
				Logger.info("inherit from check box is unselected");
			}else {
				Logger.info("inherit from check box is unselected");
			}
		}
	}
	
//code to save the template
	public void saveNewTemplate() throws Exception
	{
		try{
			if(saveTemplateBtn.isDisplayed()){
				saveTemplateBtn.click();
				Thread.sleep(2000);
				Logger.info("New template is created");
			}
			else{
				Logger.info("Save button is not displayed");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  }
	}
	
//code to cancel the new template creation
	public void cancelNewTemplate() throws Exception
	{
		try{
			if(cancelTemplateCreationBtn.isDisplayed()){
				cancelTemplateCreationBtn.click();
				Thread.sleep(2000);
				Logger.info("New template creation is canceled");
			}
			else{
				Logger.info("Cancel button is not displayed");
			}
		}
		catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  }
	}
	
/**
 * @author cymkozalg6 - Priyanka
 * @param newsPaperLayoutIDInstance
 * @throws Exception
 * @description This method performs a click on the required news paper layout ID 
 */

/*public void clickOnNewsPaperLayoutID(int newsPaperLayoutIDInstance) throws Exception
{
	try
	{
		if(newsPaperLayoutIDList.size()>0)
		{
			Iterator<WebElement> iterator = newsPaperLayoutIDList.iterator();
			while(iterator.hasNext())
			{
				WebElement newsPaperLayoutID = newsPaperLayoutIDList.get(newsPaperLayoutIDInstance);
				String newsPaperLayoutIDValue = newsPaperLayoutID.getText();
				newsPaperLayoutID.click();
				Logger.info("NewPaper Layout ID clicked is '"+newsPaperLayoutIDValue+"'");
				break;
			}			
		}
		else {
			Logger.info("There are no news paper layouts for the selected combination of search criteria");
		}
		
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}*/

/**
 * @author cymkozalg6 - Priyanka
 * @param newsPaperLayoutIDInstance
 * @throws Exception
 * @description This method performs a click on the required news paper layout ID  
 * 				based on the news paper layout ID
 */
/*public void clickOnNewsPaperLayoutID(int newsPaperLayoutID) throws Exception
{
	try
	{
		 
		  JavascriptExecutor js = ((JavascriptExecutor) driver);
		  js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		  
		  Thread.sleep(4000);
		  
		if(newsPaperLayoutIDList.size()>0)
		{
			Iterator<WebElement> iterator = newsPaperLayoutIDList.iterator();
			while(iterator.hasNext())
			{
				WebElement newsPaperLayoutIDElement = driver.findElement(By.xpath("//tr[@class='section-version-item ng-scope']/td/h4/a[text()='"+newsPaperLayoutID+"']"));
				newsPaperLayoutIDElement.click();
				Logger.info("NewPaper Layout ID clicked is '"+newsPaperLayoutID+"'");
				break;
			}			
		}
		else {
			Logger.info("There are no news paper layouts for the selected combination of search criteria");
		}
		
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}
*/
/**
 * @author cymkozalg6 - Priyanka
 * @throws Exception
 * @description This method performs a click on latest news paper layout ID 
 */
/*
public void clickOnLatestNewsPaperLayoutID() throws Exception
{
	try
	{
		if(newsPaperLayoutIDList.getText()!= "0")
		{
			Iterator<WebElement> iterator = newsPaperLayoutIDList.iterator();
			while(iterator.hasNext())
			{
				WebElement newsPaperLayoutID = newsPaperLayoutIDList.get(newsPaperLayoutIDList.size()-1);
				String newsPaperLayoutIDValue = newsPaperLayoutID.getText();
				newsPaperLayoutID.click();
				Logger.info("Latest NewPaper Layout ID clicked is '"+newsPaperLayoutIDValue+"'");
				break;
			}			
		}
		else {
			Logger.info("There are no news paper layouts for the selected combination of search criteria");
		}
		
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}*/
/**
 * @author smukherjee - Sunny
 * @throws Exception
 * @description This method performs a click on first news paper layout ID 
 */

public void clickOnFirstNewsPaperLayoutID() throws Exception
{
	try
	{
		if(newsPaperLayoutIDList.getText()!= "0" )
		{
			
				WebElement newsPaperLayoutID = driver.findElement(By.xpath("(//a[@class='order-link ng-binding'])[1]"));
				String newsPaperLayoutIDValue = newsPaperLayoutID.getText();
				newsPaperLayoutID.click();
				Logger.info("Latest NewPaper Layout ID clicked is '"+newsPaperLayoutIDValue+"'");
				
						
		}
		else {
			Logger.info("There are no news paper layouts for the selected combination of search criteria");
		}
		
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

public void clickOnSecondNewsPaperLayoutID() throws Exception
{
	try
	{
		if(newsPaperLayoutIDList.getText()!= "1")
		{
			
				WebElement newsPaperLayoutID = driver.findElement(By.xpath("(//a[@class='order-link ng-binding'])[2]"));
				String newsPaperLayoutIDValue = newsPaperLayoutID.getText();
				newsPaperLayoutID.click();
				Logger.info("Latest NewPaper Layout ID clicked is '"+newsPaperLayoutIDValue+"'");
						
		}
		else {
			Logger.info("There are no more than one news paper layouts for the selected combination of search criteria");
		}
		
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}
/**
 * @author cymkozalg6 - Priyanka
 * @param newsPaperLayoutIDInstance
 * @throws Exception
 * @return news paper layout ID for any required instance
 * @description This method gets the required news paper layout ID 
 */
/*
public int getNewsPaperLayoutID(int newsPaperLayoutIDInstance) throws Exception
{
	try
	{
		int newsPaperLayoutIDValue = 0;
		if(newsPaperLayoutIDList.size()>0)
		{
			Iterator<WebElement> iterator = newsPaperLayoutIDList.iterator();
			while(iterator.hasNext())
			{
				WebElement newsPaperLayoutID = newsPaperLayoutIDList.get(newsPaperLayoutIDInstance);
				newsPaperLayoutIDValue = Integer.parseInt(newsPaperLayoutID.getText());
				break;
			}
			return newsPaperLayoutIDValue;
		}
		else
		{
			Logger.info("There are no news paper layouts for the selected combination of search criteria");
			return newsPaperLayoutIDValue;
		}
		
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}
*/
/**
 * @author cymkozalg6 - Priyanka
 * @throws Exception
 * @description This method gets the ID of the latest news paper layout from the search results
 */
/*
public int getLatestNewsPaperLayoutID() throws Exception
{
	try
	{
		int newsPaperLayoutIDValue = 0;
		if(newsPaperLayoutIDList.size()>0)
		{
			Iterator<WebElement> iterator = newsPaperLayoutIDList.iterator();
			while(iterator.hasNext())
			{
				WebElement newsPaperLayoutID = newsPaperLayoutIDList.get(newsPaperLayoutIDList.size()-1);
				newsPaperLayoutIDValue = Integer.parseInt(newsPaperLayoutID.getText());
				break;
			}
			return newsPaperLayoutIDValue;
		}
		else
		{
			Logger.info("There are no news paper layouts for the selected combination of search criteria");
			return newsPaperLayoutIDValue;
		}
		
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}
*/
/**
 * @author cymkozalg6 - Priyanka
 * @param newsPaperLayoutIDInstance
 * @return News Paper Layout description
 * @throws Exception
 * @description This method retrieves description of the required new paper layout template
 
public String getNewsPaperLayoutDescription(int newsPaperLayoutIDInstance) throws Exception
{
	try
	{
		int newsPaperLayoutID  = getNewsPaperLayoutID(newsPaperLayoutIDInstance);
		WebElement layoutDescription = driver.findElement(By.xpath("//h4/a[text()='"+newsPaperLayoutID+"']/../../..//a[@class='ng-scope editable editable-click']/span/span"));
		return layoutDescription.getText();
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}*/

/**
 * @author cymkozalg6 - Priyanka
 * @param newsPaperLayoutIDInstance
 * @return selected news paper layouts effective date
 * @throws Exception
 * @description This method returns effective date of the news paper layout selected 
 
public String getNewsPaperLayoutEffectiveDate(int newsPaperLayoutIDInstance) throws Exception
{
	try
	{
		int newsPaperLayoutID  = getNewsPaperLayoutID(newsPaperLayoutIDInstance);
		WebElement layoutEffectiveDate = driver.findElement(By.xpath("//h4/a[text()='"+newsPaperLayoutID+"']/../../../td[5]/span"));
		return layoutEffectiveDate.getText();
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}
*/
/**
 * @author cymkozalg6 - Priyanka
 * @throws Exception
 * @description This method clicks on the take offline button for the latest new paper layout in the search results
 
public void clickOnTakeOfflineButtonLatestNewsLayout() throws Exception
{
	try
	{
		int newsPaperLayoutID  = getLatestNewsPaperLayoutID();
		WebElement takeOffilenButton = driver.findElement(By.xpath("//h4/a[text()='"+newsPaperLayoutID+"']/../../..//button[text()='Take Offline']"));
		takeOffilenButton.click();
		Logger.info("Take Offline button for the latest news paper layout("+newsPaperLayoutID+") is clicked");
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

/**
 * @author cymkozalg6 - Priyanka
 * @throws Exception
 * @description This method clicks on delete button for the latest new paper layout in the search results
 *//*
public void clickOnDeleteButtonLatestNewsLayout() throws Exception
{
	try
	{
		int newsPaperLayoutID  = getLatestNewsPaperLayoutID();
		WebElement takeOffilenButton = driver.findElement(By.xpath("//h4/a[text()='"+newsPaperLayoutID+"']/../../..//button[text()='Delete']"));
		takeOffilenButton.click();
		Logger.info("Delete button for the latest news paper layout("+newsPaperLayoutID+") is clicked");
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}
*/
/**
 * @author cymkozalg6 - Priyanka
 * @throws Exception
 * @description This method clicks on More button for the latest news paper layout in the search results
 
public void clickMoreButtonInLatestNewsLayout() throws Exception
{
	try
	{
		int newsPaperLayoutID  = getLatestNewsPaperLayoutID();
		WebElement moreButton = driver.findElement(By.xpath("//h4/a[text()='"+newsPaperLayoutID+"']/../../..//a[text()='More']"));
		moreButton.click();
		Logger.info("More button for the latest news paper layout("+newsPaperLayoutID+") is clicked");
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}
*/
/**
 * @author cymkozalg6 - Priyanka
 * @throws Exception
 * @description This method clicks on delete option present under more options of the latest
 * 				 news paper layout in the search results

public void clickDeleteButtonInLatestNewsLayoutUnderMore() throws Exception
{
	try
	{
		int newsPaperLayoutID  = getLatestNewsPaperLayoutID();
		WebElement deleteOption = driver.findElement(By.xpath("//h4/a[text()='"+newsPaperLayoutID+"']/../../..//ul[@class='dropdown-menu']//span[text()='Delete']"));
		deleteOption.click();
		Logger.info("Delete under more options for the latest news paper layout("+newsPaperLayoutID+") is clicked");
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}
 */
/**
 * @author cymkozalg6 - Priyanka
 * @param newspaper layout ID
 * @throws Exception
 * @description This method clicks on edit option present under more options of the latest
 * 				 news paper layout in the search results
 */
public void clickEditButtonInNewsLayoutUnderMore(int newsPaperLayoutID) throws Exception
{
	try
	{
		WebElement editOption = driver.findElement(By.xpath("//h4/a[text()='"+newsPaperLayoutID+"']/../../..//ul[@class='dropdown-menu']//a[text()='Edit']"));
		editOption.click();
		Logger.info("Edit under more options for the latest news paper layout("+newsPaperLayoutID+") is clicked");
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

/**
 * @author cymkozalg6 - Priyanka
 * @param newspaer layout ID
 * @throws Exception
 * @description This method clicks on copy option present under more options of the latest
 * 				 news paper layout in the search results
 */
public void clickCopyButtonInNewsLayoutUnderMore(int newsPaperLayoutID) throws Exception
{
	try
	{
		WebElement copyOption = driver.findElement(By.xpath("//h4/a[text()='"+newsPaperLayoutID+"']/../../..//ul[@class='dropdown-menu']//span[text()='Copy']"));
		copyOption.click();
		Logger.info("Copy under more options for the latest news paper layout("+newsPaperLayoutID+") is clicked");
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

/**
 * @author cymkozalg6 - Priyanka
 * @param newspaper layout ID
 * @throws Exception
 * @description This method clicks on paste option present under more options of the latest
 * 				 news paper layout in the search results
 */
public void clickPasteButtonInNewsLayoutUnderMore(int newsPaperLayoutID) throws Exception
{
	try
	{
		WebElement pasteOption = driver.findElement(By.xpath("//h4/a[text()='"+newsPaperLayoutID+"']/../../..//ul[@class='dropdown-menu']//a[text()='Paste']"));
		pasteOption.click();
		Logger.info("Paste under more options for the latest news paper layout("+newsPaperLayoutID+") is clicked");
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

/**
 * @author cymkozalg6 - Priyanka
 * @throws Exception
 * @description This method clicks on the copy button that is visible on news paper layout search panel
 */
/*public void clickOnCopyNewsPaperLayoutSearch() throws Exception
{
	try
	{
		if (copyButtonNewsPaperLayoutSearchPage.isDisplayed())
		{
			copyButtonNewsPaperLayoutSearchPage.click();
			Logger.info("Copy button in news paper layout search page is clicked");
		}
		else
		{
			Logger.info("Copy button in news paper layout search page is not displayed");
			throw new NoSuchElementException("Copy button in news paper layout search page is not displayed");
		}
	}
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
}*/

/**
 * @author cymkozalg6 - Priyanka
 * @throws Exception
 * @description This method clicks on the paste button that is visible on news paper layout search panel
 */
/*public void clickOnPasteNewsPaperLayoutSearch() throws Exception
{
	try
	{
		if (pasteButtonNewsPaperLayoutSearchPage.isDisplayed())
		{
			pasteButtonNewsPaperLayoutSearchPage.click();
			Logger.info("Paste button in news paper layout search page is clicked");
		}
		else
		{
			Logger.info("Paste button in news paper layout search page is not displayed");
			throw new NoSuchElementException("Paste button in news paper layout search page is not displayed");
		}
	}
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
}*/

/**
 * @author cymkozalg6 - Priyanka
 * @param newsPaperLayoutID
 * @throws Exception
 * @description This method searches for a specific news paper layout ID

public boolean searchForSpecificNewsPaperLayout(int newsPaperLayoutID) throws Exception
{
	boolean flag = false;
	try
	{
		if(newsPaperLayoutIDList.size()>0)
		{
			Iterator<WebElement> iterator = newsPaperLayoutIDList.iterator();
			while(iterator.hasNext())
			{
				WebElement newsPaperLayoutElement = driver.findElement(By.xpath("//h4/a[text()='"+newsPaperLayoutID+"']"));
				if(newsPaperLayoutElement.isDisplayed())
				{
					flag = true;
				}
				break;
			}			
		}
		else {
			Logger.info("There are no news paper layouts for the selected combination of search criteria");
		}
		return flag;
	}
	catch(Exception e)
	  {
		  Logger.info("NewPaper Layout ("+newsPaperLayoutID+") is not available");
		  return flag;
	  }
}
 */


/**
 * @author cymkozalg6 - Priyanka
 * @param sectionName
 * @throws Exception
 * @description code to validate the news paper layout search result when only 
 * 				current templates are searched
 */

	public void validateCurrentSearch(String sectionName) throws Exception
	{
		 List<WebElement> listSection = driver.findElements(By.xpath("//tr[@class='section-version-item ng-scope']/td[2]"));
	     Iterator<WebElement> iteratorSection = listSection.listIterator();
	  	   while(iteratorSection.hasNext())
	  	   {
	  		   WebElement section =  iteratorSection.next() ;
	  		   String actualCellData = section.getText();
	  		   Assert.assertEquals(actualCellData,properties.getProperty(sectionName).toString());
	  		   Logger.info("search result is validated");
	  	   }
	  	 List<WebElement> listStatus = driver.findElements(By.xpath("//th[text()='Status']/../../../tbody/tr/td[6]/span"));
	  	 Iterator<WebElement> iteratorStatus = listStatus.listIterator();  
	  	 while(iteratorStatus.hasNext())
	  	   {
	  		   WebElement status =  iteratorStatus.next() ;
	  		   String actualCellData = status.getText();
	  		   Assert.assertEquals(actualCellData,"current");
	  		   Logger.info("current templates are displayed");
	  	   }
	}

/**
 * @author cymkozalg6 - Priyanka
 * @param sectionName
 * @throws Exception
 * @description code to validate news paper layout search results when all the templates
 * 				 are searched including current and inactive
 */

	public void validateSearchAllTemplates(String sectionName) throws Exception
	{
		 List<WebElement> listSection = driver.findElements(By.xpath("//tr[@class='section-version-item ng-scope']/td[2]"));
	     Iterator<WebElement> iteratorSection = listSection.listIterator();
	  	   while(iteratorSection.hasNext())
	  	   {
	  		   WebElement section =  iteratorSection.next() ;
	  		   String actualCellData = section.getText();
	  		   Assert.assertEquals(actualCellData,properties.getProperty(sectionName).toString());
	  		   Logger.info("search result for the specified section is displayed");
	  	   }
	  	 List<WebElement> listStatus = driver.findElements(By.xpath("//th[text()='Status']/../../../tbody/tr/td[6]/span"));
	  	 Iterator<WebElement> iteratorStatus = listStatus.listIterator();  
	  	 boolean currentflag = false;
		 boolean inactiveFlag = false;
	  	 while(iteratorStatus.hasNext())
	  	   {
	  		   WebElement currentStatus =  iteratorStatus.next() ;
	  		   String actualCellData = currentStatus.getText();
	  		   
	  		   if(actualCellData.equalsIgnoreCase("Current"))
	  		   {
	  			 currentflag = true;
	  			 break;
	  		   }
	  	   }
	  		 while(iteratorStatus.hasNext())
		  	   {
		  		   WebElement inactiveStatus =  iteratorStatus.next() ;
		  		   String actualCellData1 = inactiveStatus.getText();
		  		   
		  		   if(actualCellData1.equalsIgnoreCase("Inactive"))
		  		   {
	  			  inactiveFlag = true;
	  			  break;
		  		   }
	  		 }
		   Assert.assertEquals(currentflag, true);
		   Assert.assertEquals(inactiveFlag, true);
	}
	
	public String getTemplateID() throws Exception
	  {
		  String orderID = "";
		  WebElement element = driver.findElement(By.xpath("//*[@id='tmplt_id']"));
		  WebDriverWait wait = new WebDriverWait(driver,200); 
	 
	      wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[@id='tmplt_id']"))));
	 
		  orderID = element.getText();
		  Logger.info("template id: "+orderID);
		  return orderID;
		  
	  }
	
	 public void clickOnTemplate(String orderID) throws Exception
	  {
		  try
		  {
			  WebElement zoneSorterDesc = driver.findElement(By.xpath("//*[text()='ID']/../..//*[@class='ui-grid-icon-angle-down']"));
	   		  zoneSorterDesc.click();
	   		
	   		  WebElement verifyDescZoneSortIcon = driver.findElement(By.xpath("(//*[@id='menuitem-1']/button)[1]"));
	   		  if (verifyDescZoneSortIcon.isDisplayed())
	   		  {
	   			   verifyDescZoneSortIcon.click();
	   		         Logger.info(" ID sorted in descending order "); 
	   		  }
	   		  else
	   		  {
	   			  Logger.info(" ID not sorted in descending order ");
	   		  }
	   		Thread.sleep(3000);
			  WebElement order = driver.findElement(By.xpath("//a[text()='"+orderID+"']"));

			  WebDriverWait wait = new WebDriverWait(driver,120);
			  wait.until(ExpectedConditions.visibilityOf(order));
			  if(order.isDisplayed())
			  {
				  order.click();
				  Logger.info("template is clicked in Newspaper Layout page");
				  Thread.sleep(3000);
			  }
			  else{
				  Logger.info("template is not displayed");
			  }
		  }
		  catch(Exception e)
		  {
			  Logger.error(e.getMessage());
			  throw e;
		  }
	  }
	  
}
