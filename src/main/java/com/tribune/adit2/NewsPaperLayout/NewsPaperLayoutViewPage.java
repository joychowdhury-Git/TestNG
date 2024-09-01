package com.tribune.adit2.NewsPaperLayout;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for NewsPaper Layouts View Page
 * @author Priyanka Goud CR 
 * @since April 2016
 */

public class NewsPaperLayoutViewPage 
{
	@FindBy (xpath = "(//div[@id='customer-detail-page']/div[2]/div[1]/span)[1]")
	public WebElement businessUnitLayoutViewPage;
	
	@FindBy (xpath = "(//div[@id='customer-detail-page']/div[2]/div[1]/span)[2]")
	public WebElement productLayoutViewPage;
	
	@FindBy (xpath = "(//div[@id='customer-detail-page']/div[2]/div[1]/span)[3]")
	public WebElement sectionUnitLayoutViewPage;
	
	@FindBy (xpath = "(//div[@id='customer-detail-page']/div[2]/div[1]/span)[4]")
	public WebElement dayOfWeekLayoutViewPage;
	
	@FindBy (xpath = "//a[@id='edit-desc']/span[@id='Span12']/span")
	public WebElement layoutDescriptionInLayoutViewPage;
	
	@FindBy (xpath = "//a[@id='edit-desc']/span[@id='Span12']/span/../../../span")
	public WebElement layoutEffectiveDateInLayoutViewPage;
	
	@FindBy (xpath = "//button[contains(text(),'Add First Page')]")
	public WebElement addFirstPageButton;
	
	@FindBy (id = "page-name")
	public WebElement nameOfNewPageTextBox;
	
	@FindBy (xpath = "//text[@class='newspaper-pagename']")
	public WebElement pageNumbersLink;
	
	@FindBy (id = "zone")
	public WebElement zoneDropDownNewsPaperLayout;
	
	@FindBy (xpath = "//button[text()='GO']/../input")
	public WebElement pageNoTextBoxToGo;
	
	@FindBy (xpath = "//button[text()='GO']")
	public WebElement goToPageButton;
	
	@FindBy (xpath = "//button[@ng-click='vm.prevPage()']")
	public WebElement goToPreviousPageButton;
	
	@FindBy (xpath = "//button[@ng-click='vm.nextPage()']")
	public WebElement goToNextPageButton;
	
	@FindBy (xpath = "//button[@ng-click='vm.firstPage()']")
	public WebElement goToFirstPageButton;
	
	@FindBy (xpath = "//button[@ng-click='vm.lastPage()']")
	public WebElement goToLastPageButton;
	
	@FindBy (id = "page-desc")
	public WebElement descriptionOfNewPageTextBox;
	
	//@FindBy (xpath = "//input[@ng-model='vm.isCommonPage']/../i")
	//@FindBy (xpath = "(//input[@class='ng-pristine ng-untouched ng-valid ng-empty'])[1]")
	@FindBy (xpath = "(html/body/div[1]/div/div/div/div[2]/div/div[3]/div/label/i)")	
	public WebElement commonPageCheckBox;
	
	//@FindBy (xpath = "(//input[@class='ng-pristine ng-untouched ng-valid ng-empty'])[2]")
	@FindBy (xpath = "(html/body/div[1]/div/div/div/div[2]/div/div[4]/div/label/i)")
	public WebElement isColorPageCheckBox;
	
	@FindBy (id = "Select2")
	public WebElement colorSelectionDropDown;
	
	@FindBy (id = "btnSaveTemplate")
	public WebElement saveNewPageButton;
	
	@FindBy (id = "btnCancel")
	public WebElement cancelNewPageButton;
	
	@FindBy (xpath = "//div[contains(text(),'Are you sure you want to delete this page')]/../../div[3]/button[contains(text(),'Delete')]")
	public WebElement pageDeleteButton;
	
	@FindBy (xpath = "//button[@ng-click='vm.editPage(vm.currentPage)']")
	public WebElement pageEditButton;
		
	@FindBy (xpath = "//span[@title='copy']")
	public WebElement copyPageButton;
	
	@FindBy (xpath = "//span[@title='paste']")
	public WebElement pastePageButton;
	
	@FindBy (xpath = "//span[@title='Export to Lib']")
	public WebElement exportPageToLibButton;
	
	@FindBy (xpath = "//span[@title='Import to Lib']")
	public WebElement importPageToLibButton;
	
	@FindBy (id = "adType")
	public WebElement adTypeDropDownAdBlockSection;
	
	@FindBy (id = "adSize")
	public WebElement adSizeDropDownAdBlockSection;
	
	@FindBy (id = "ad-desc")
	public WebElement descriptionAdBlockSection;
	
	@FindBy (id = "ad-label")
	public WebElement adlabelDropDownAdBlockSection;
	
	@FindBy (xpath = "//a[contains(text(),'Editorial')]")
	public WebElement editorialButton;
	
	@FindBy (xpath = "//a[contains(text(),'Ad')]")
	public WebElement adsButton;
	
	@FindBy (xpath = "//a[contains(text(),'Edit')]")
	public WebElement editButton;
	
	@FindBy (xpath = "//button[contains(text(),'Delete')]")
	public WebElement deleteButton;
	
	@FindBy (xpath = "html/body/div[1]/div/div/div[3]/button[1]")
	public WebElement confirmDeleteButton;
	
	@FindBy (xpath = "//button[contains(text(),'Export')]")
	public WebElement exportOrderButton;
	
	//button[text()='Insert Ad']
	@FindBy (id = "btnSaveTemplate")
	public WebElement insertAdButtonAdBlockSection;
	
	//button[text()='Cancel']
	@FindBy (id = "btnCancel")
	public WebElement cancelAdButtonAdBlockSection;
	
	@FindBy (xpath = "//button[@title='Print']/i")
	public WebElement printButton;
	
	@FindBy (id = "ed-size")
	public WebElement editorialSizeDropDown;
	
	@FindBy (id = "ed-desc")
	public WebElement editorialDescriptionTextbox;
	
	@FindBy (xpath = "//button[text()='Insert Editorial']")
	public WebElement insertEditorialButton;
	
	@FindBy (xpath = "//button[text()='Insert Editorial']")
	public WebElement cancelEditorialButton;
	
	@FindBy (xpath = "//span[contains(text(),'Locked')]")
	public WebElement lockedLabel;	
	
	@FindBy (xpath = "//span[@ng-if='vm.pageVersion.LockedByUserID']")
	public WebElement lockedUser;
	
	@FindBy (xpath = "//span[text()='Bring Online']/..")
	public WebElement bringOnlineButton;
	
	//@FindBy (xpath = "//span[text()='Take offline']/..")
	@FindBy (xpath = "//span[text()='Take offline']")

	
	public WebElement takeOfflineButton;//swagata new
	
	//@FindBy (xpath = "//*[@id='pagelayout-normal-view']/*[name()='svg']/*[name()='g']//*[contains(text(),'Page') and contains(text(),'of') ]")
	@FindBy (xpath = "//*[@id='pagelayout-normal-view']/*[name()='svg']/*[name()='g']//*[local-name()='text'][contains(text(),'Page')][contains(@class,'newspaper')]")
	public WebElement templatePageNumber;//swagata new
	
	
	
	@FindBy (xpath = "//*[contains(text(),'Spot') and contains(text(),'Color') ]")
	public WebElement rectElement;
	
	@FindBy (id = "Text1")
	public WebElement exportName;
	
	@FindBy (xpath = "//label[text()='New']")
	public WebElement exportNew;
	
	@FindBy (xpath = "//label[text()='Exisiting']")
	public WebElement exportExisting;
	
	@FindBy (xpath = "//*[text()='Visibility']/../div/label[1]/i")
	public WebElement visibilityMine;
	
	@FindBy (xpath = "//*[text()='Visibility']/../div/label[1]/i")
	public WebElement visibilityBU;
	
	@FindBy (xpath = "//*[text()='Visibility']/../div/label[1]/i")
	public WebElement visibilityGlobal;
	
	@FindBy (xpath = "//button[text()='Export']")
	public WebElement btnExport;
	
	//@FindBy (xpath = "//*[text()='Library:']/../../../div[2]/div/label[1]/i")
	@FindBy (xpath = "//body/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/label[1]/i[1]") //Joy
	
	public WebElement libraryMine;
	
	@FindBy (xpath = "//*[text()='Library:']/../../../div[2]/div/label[2]/i")
	public WebElement libraryBU;
	
	@FindBy (xpath = "//*[text()='Library:']/../../../div[2]/div/label[3]/i")
	public WebElement libraryGlobal;
	
	@FindBy (id = "page-name")
	public WebElement nameDropDown;
	
	@FindBy (xpath = "//button[text()='Import']")
	public WebElement btnImport;
	
	@FindBy (xpath = "//*[text()='PositionX']/../input")
	public WebElement positionXTextBox;
	
	@FindBy (xpath = "//*[text()='PositionY']/../input")
	public WebElement positionYTextBox;
	
	@FindBy (xpath = "//*[@id='adType']")
	public WebElement adTypeDropdwn;
	
	@FindBy (xpath = "//*[@id='adSize']")
	public WebElement adSizeDropdwn;
	
	@FindBy (xpath = "//*[text()='Ad Label']/../../div[2]/select")
	public WebElement adLabelDropdwn;
	
	@FindBy (xpath = "//*[text()='Description']/../../div[2]/textarea")
	public WebElement adDescTextArea;
	
	@FindBy (xpath = "(html/body/div[1]/div/div/div/div[2]/div[2]/div[5]/div/div/label/i)")	
	public WebElement premiumPositionCheckBox;
	
	@FindBy (xpath = "//button[text()='Insert']")
	public WebElement btnInsert;
	
	@FindBy (xpath = "//button[text()='Update']")
	public WebElement btnUpdate;
	
	private WebDriver driver;
	
	Properties properties = TribuneUtils.readProperties();
	
	TribuneUtils utils  = new TribuneUtils();
	
	public NewsPaperLayoutViewPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * @author cymkozalg6 - Priyanka
	 * @param businessUnitSearched
	 * @return boolean
	 * @throws Exception
	 * @description This method compares the business unit given in the news paper layout search criteria
	 * 				to the business unit displayed in the layout view page
	 */
	public boolean validateBusinessUnitInLayoutViewPage(String businessUnitSearched) throws Exception
	{
		String busimessUnitDisplayed = businessUnitLayoutViewPage.getText();
		if(busimessUnitDisplayed.equalsIgnoreCase("Business Unit: "+properties.getProperty(businessUnitSearched).toString()))
		{
			Logger.info("Business unit matches both news paper layout search and view page");
			return true;
		}
		else{
			Logger.info("Business Unit is not the same in news paper layout search and view page");
			return false;
		}
	}

	/**
	 * @author cymkozalg6 - Priyanka
	 * @param productSearched
	 * @return boolean
	 * @throws Exception
	 * @description This method compares the product given in the news paper layout search criteria
	 * 				to the business unit displayed in the layout view page
	 */
	public boolean validateProductInLayoutViewPage(String productSearched) throws Exception
	{
		String productDisplayed = productLayoutViewPage.getText();
		if(productDisplayed.equalsIgnoreCase("Product: "+properties.getProperty(productSearched).toString()))
		{
			Logger.info("Product matches both news paper layout search and view page");
			return true;
		}
		else{
			Logger.info("Product is not the same in news paper layout search and view page");
			return false;
		}
	}

	/**
	 * @author cymkozalg6 - Priyanka
	 * @param sectionSearched
	 * @return boolean
	 * @throws Exception
	 * @description This method compares the section given in the news paper layout search criteria
	 * 				to the business unit displayed in the layout view page
	 */
	public boolean validateSectionInLayoutViewPage(String sectionSearched) throws Exception
	{
		String sectionDisplayed = sectionUnitLayoutViewPage.getText();
		if(sectionDisplayed.equalsIgnoreCase("Section: "+sectionSearched))
		{
			Logger.info("Section matches both news paper layout search and view page");
			return true;
		}
		else{
			Logger.info("Section is not the same in news paper layout search and view page");
			return false;
		}
	}

	/**
	 * @author cymkozalg6 - Priyanka
	 * @param dayOfWeekSearched
	 * @return boolean
	 * @throws Exception
	 * @description This method compares the dayOfWeekSearched given in the news paper layout search criteria
	 * 				to the business unit displayed in the layout view page
	 */
	public boolean validateDayOfWeekInLayoutViewPage(String dayOfWeekSearched) throws Exception
	{
		String dayOfWeekDisplayed = dayOfWeekLayoutViewPage.getText();
		if(dayOfWeekDisplayed.equalsIgnoreCase("Day of Week:"+properties.getProperty(dayOfWeekSearched).toString()))
		{
			Logger.info("DayOfWeek matches both news paper layout search and view page");
			return true;
		}
		else{
			Logger.info("DayOfWeek is not the same in news paper layout search and view page");
			return false;
		}
	}

	/**
	 * @author cymkozalg6 - Priyanka
	 * @param layoutDescriptionInSearchPage
	 * @return boolean
	 * @throws Exception
	 * @description This method compares the layoutDescriptionInSearchPage given in the news paper layout search criteria
	 * 				to the description displayed in the layout view page
	 */
	public boolean validateDescriptionInLayoutViewPage(String layoutDescriptionInSearchPage) throws Exception
	{
		String layoutDescriptionInViewLayoutPage = layoutDescriptionInLayoutViewPage.getText();
		if(layoutDescriptionInViewLayoutPage.equalsIgnoreCase(layoutDescriptionInSearchPage))
		{
			Logger.info("Description matches both news paper layout search and view page");
			return true;
		}
		else{
			Logger.info("Description is not the same in news paper layout search and view page");
			return false;
		}
	}

	/**
	 * @author cymkozalg6 - Priyanka
	 * @param layoutEffectiveDateInSearchPage
	 * @return boolean
	 * @throws Exception
	 * @description This method compares the layoutEffectiveDateInSearchPage given in the news paper layout search criteria
	 * 				to the Effective date displayed in the layout view page
	 */
	public boolean validateEffectiveDateInLayoutViewPage(String layoutEffectiveDateInSearchPage) throws Exception
	{
		String layoutEffectiveDateInViewLayoutPage = layoutEffectiveDateInLayoutViewPage.getText();
		if(layoutEffectiveDateInViewLayoutPage.substring(16).equalsIgnoreCase(layoutEffectiveDateInSearchPage))
		{
			Logger.info("Effective date matches both news paper layout search and view page");
			return true;
		}
		else{
			Logger.info("Effective date is not the same in news paper layout search and view page");
			return false;
		}
	}

/**
 * @author cymkozalg6 - Priyanka
 * @param zone
 * @throws Exception
 * @description This method selects the required zone from the drop down list in the layout view page
 */
public void selectZoneInViewLayoutPage(String zone) throws Exception
{
	try
	{
		if(zoneDropDownNewsPaperLayout.isEnabled())
		{
			Select select = new Select(zoneDropDownNewsPaperLayout);
			select.selectByVisibleText(zone);
			Logger.info(zone + "zone is selected");
		}
		else{
			Logger.info("Zone drop down is disabled");
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
 * @throws Exception
 * @description This method clicks on the Add first page button in layout view page
 */
public void clickOnAddFirstPage() throws Exception
{
	try
	{
		if(addFirstPageButton.isDisplayed())
		{
			addFirstPageButton.click();
			Logger.info("Add first page button is clicked");
		}
		else{
			Logger.info("Add first page button is not displayed");
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
 * @throws Exception
 * @description This method enters the template name using random string generation
 */
public void enterTemplateName() throws Exception
{
	Thread.sleep(3000);
	try
	{
		if(nameOfNewPageTextBox.isDisplayed())
		{
			nameOfNewPageTextBox.click();
			nameOfNewPageTextBox.sendKeys(utils.generateRandomString(4));
			Logger.info("Template name is entered");
		}
		else{
			Logger.info("template name text box is not displayed");
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
 * @throws Exception
 * @description This method enters the description for a new page being created
 */
public void enterTemplateDescription() throws Exception
{
	try{
		if(descriptionOfNewPageTextBox.isDisplayed())
		{
			descriptionOfNewPageTextBox.click();
			descriptionOfNewPageTextBox.sendKeys(utils.generateRandomString(10));
			Logger.info("Description is entered");
		}
		else{
			Logger.info("Description text box is not displayed");
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
 * @param value
 * @throws Exception
 * @description This method check or unchecks the common page check box 
 */
public void selectCommonPageCheckBox(boolean value) throws Exception
{
	try
	{
		Logger.info("Value="+value);
		if(value)
		{
			Logger.info("Into True");
			if(commonPageCheckBox.isSelected()) {
				Logger.info("common page is selected");
			}
			else{
				commonPageCheckBox.click();
				Logger.info("Common page is selected");
			}
		}
		else{
			Logger.info("Into False");
			if(commonPageCheckBox.isSelected()) {
				commonPageCheckBox.click();
				Logger.info("common page is deselected");
			}
			else{
				Logger.info("Common page is deselected");
			}
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
 * @param value
 * @throws Exception
 * @description This method check or unchecks the Color page check box 
 */
public void selectColorPageCheckBox(boolean value) throws Exception
{
	try
	{
		if(value)
		{
			if(isColorPageCheckBox.isSelected()) {
				Logger.info("Color page is selected");
			}
			else{
				isColorPageCheckBox.click();
				Logger.info("Color page is selected");
			}
		}
		else{
			if(isColorPageCheckBox.isSelected()) {
				isColorPageCheckBox.click();
				Logger.info("Color page is deselected");
			}
			else{
				Logger.info("Color page is deselected");
			}
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
 * @param colorType
 * @throws Exception
 * @description This method will select the required color type for a new page being created 
 */
public void selectTypeOfColor(String colorType) throws Exception
{
	try
	{
		if(colorSelectionDropDown.isDisplayed())
		{
			Select select = new Select(colorSelectionDropDown);
			select.selectByVisibleText(colorType);
			Logger.info(colorType + "Color type is selected");
		}
		else{
			Logger.info("Color selection drop down is not displayed");
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
 * @throws Exception
 * @description This method clicks on the save button for a new page
 */
public void clickOnSaveNewPage() throws Exception
{
	try
	{
		if(saveNewPageButton.isDisplayed())
		{
			saveNewPageButton.click();
			Logger.info("Save button for a new page is clicked");
		}
		else{
			Logger.info("SAve button is not displayed");
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
 * @throws Exception
 * @description This method clicks on the cancel button for a new page
 */
public void clickOnCancelNewPage() throws Exception
{
	try
	{
		if(cancelNewPageButton.isDisplayed())
		{
			cancelNewPageButton.click();
			Logger.info("Cancel button for a new page is clicked");
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
 * @throws Exception
 * @description This method clicks on edit page button
 */
public void  clickOnEditPageButton() throws Exception
{
	try
	{
			if(pageEditButton.isDisplayed())
			{
				pageEditButton.click();
				Logger.info("Page edit button is clicked");
			}
			else{
				Logger.info("page edit button is not displayed");
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
 * @throws Exception
 * @description This method clicks on delete page button
 */
public void  clickOnDeletePageButton() throws Exception
{
	try
	{
		if(pageDeleteButton.isDisplayed())
			{
				pageDeleteButton.click();
				Logger.info("Page delete button is clicked");
			}
			else{
				Logger.info("page delete button is not displayed");
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
 * @throws Exception
 * @description This method clicks on the page name
 */
public void clickOnPageNumAndNameSection() throws Exception
{
	try
	{		
		//WebElement element = driver.findElement(By.xpath("//*[@class='newspaper-pagename']"));
		if(templatePageNumber.isDisplayed())
		{
			templatePageNumber.click();
			Logger.info("page numbers link is clicked");
		}
		else{
			Logger.info("page numbers link is not displayed");
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
 * @throws Exception
 * @description This method clicks on a particular section inside a page
 */
public void clickOnASectionOfAPage() throws Exception
{
	try
	{		
		 WebElement element = driver.findElement(By.cssSelector("#section-to-print > div > div > div > svg > g > rect"));
		 /*Actions builder = new Actions(driver);*/

		 /*new Actions(driver).moveToElement(element).moveByOffset(100, 32).click().perform();
		 Logger.info("clicked on the required section of a page");*/
		 
		 Actions builder = new Actions(driver);   
		 builder.moveToElement(element, 100, 32).click().build().perform();
		 
		 /*builder.keyDown(Keys.CONTROL)
		    .click(element)
		    .moveByOffset( 33, 32 );
		    .click(someOtherElement)
		    .keyUp(Keys.CONTROL).build().perform();*/
		 
		 /*if(element.isDisplayed())
		{
			//element.click();
			Logger.info("clicked on the required section of a page");
		}
		else{
			Logger.info("required section of page is not identified");
		}*/
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}

/**
 * @author cymkozalg6 - Priyanka
 * @param pageNumber - Provide the page number on which the operation should be performed
 * @throws Exception
 * @description This method clicks on more options button
 */
public void  clickOnMoreOptionsOnPageButton(int pageNumber) throws Exception
{
	try
	{
		String elementID = "";
		if((pageNumber%2)==0) {
			elementID = "more-menu-left";
		}
		else {
			elementID = "more-menu-right";
		}
		Logger.info("elementID "+elementID);
		WebElement moreOptionsButton = driver.findElement(By.id(elementID));
		if(moreOptionsButton.isDisplayed())
		{
			moreOptionsButton.click();
			Logger.info("More Options button is clicked on page "+pageNumber);
		}
		else{
			Logger.info("More options button is not displayed for page " +pageNumber);
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
 * @param pageNumber - Provide the page number on which the operation should be performed
 * @throws Exception
 * @description This method clicks on insert page before button inside the more options for a page
 */
public void clickOnInsertPageBeforeButton(int pageNumber) throws Exception
{
	try
	{
		int instanceOfPage = 0;
		if((pageNumber%2)==0) {
			instanceOfPage = 0;
		}
		else {
			instanceOfPage = 1; 
		}
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementsByClassName('glyphicon glyphicon-circle-arrow-left')["+instanceOfPage+"].click();");
		Logger.info("Insert Page Before button is clicked on page "+pageNumber);
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}

/**
 * @author cymkozalg6 - Priyanka
 * @param pageNumber - Provide the page number on which the operation should be performed
 * @throws Exception
 * @description This method clicks on insert page after button inside the more options for a page
 */
public void clickOnInsertPageAfterButton(int pageNumber) throws Exception
{
	try
	{
		int instanceOfPage = 0;
		if((pageNumber%2)==0) {
			instanceOfPage = 0;
		}
		else {
			instanceOfPage = 1; 
		}
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementsByClassName('glyphicon glyphicon-circle-arrow-right')["+instanceOfPage+"].click();");
		Logger.info("Insert Page after button is clicked on "+pageNumber);
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
 * @description This method clicks on copy page button inside the more options for a page
 */
public void clickOnCopyPageButton() throws Exception
{
	try
	{
		if(copyPageButton.isDisplayed())
		{
			copyPageButton.click();
			Logger.info("Copy Page button is clicked");
		}
		else{
			Logger.info("Copy page button is not displayed");
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
 * @throws Exception
 * @description This method clicks on paste page button inside the more options for a page
 */
public void clickOnPastePageButton() throws Exception
{
	try
	{
		if(pastePageButton.isDisplayed())
		{
			pastePageButton.click();
			Logger.info("Paste Page button is clicked");
		}
		else{
			Logger.info("Paste page button is not displayed");
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
 * @throws Exception
 * @description This method clicks on export to library button inside the more options for a page
 */
public void clickOnExportToLibButton() throws Exception
{
	try
	{
		if(exportPageToLibButton.isDisplayed())
		{
			exportPageToLibButton.click();
			Logger.info("Export Page to Library button is clicked");
		}
		else{
			Logger.info("Export Page to Library button is not displayed");
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
 * @throws Exception
 * @description This method clicks on import to library button inside the more options for a page
 */
public void clickOnImportToLibButton() throws Exception
{
	try
	{
		if(importPageToLibButton.isDisplayed())
		{
			importPageToLibButton.click();
			Logger.info("Import Page to Library button is clicked");
		}
		else{
			Logger.info("Import Page to Library button is not displayed");
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
 * @param pageNum
 * @throws Exception
 * @description This method enters the required page number in the "Page #" text box and then clicks on GO
 */
public void goToRequiredPage(int pageNum) throws Exception
{
	try
	{
		if(pageNoTextBoxToGo.isDisplayed())
		{
			pageNoTextBoxToGo.click();
			pageNoTextBoxToGo.sendKeys(""+pageNum);
			Logger.info("Required page number is entered");
			if(goToPageButton.isDisplayed())
			{
				goToPageButton.click();
				Logger.info("Go button is clicked");
			}
			else{
				Logger.info("Go button is not displayed");
			}
		}
		else{
			Logger.info("page number textbox to enter the page number is not displayed");
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
 * @throws Exception
 * @description This method clicks on go to first page button
 */
public void clickOnGoToFirstPageButton() throws Exception
{
	try
	{
		if(goToFirstPageButton.isEnabled())
		{
			goToFirstPageButton.click();
			Logger.info("Go to first page button is clicked");
		}
		else{
			Logger.info("Go to first page button is not enabled");
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
 * @throws Exception
 * @description This method clicks on go to previous page button
 */
public void clickOnGoToPreviousPageButton() throws Exception
{
	try
	{
		if(goToPreviousPageButton.isEnabled())
		{
			goToPreviousPageButton.click();
			Logger.info("Go to previous page button is clicked");
		}
		else{
			Logger.info("Go to previous page button is not enabled");
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
 * @throws Exception
 * @description This method clicks on go to next page button
 */
public void clickOnGoToNextPageButton() throws Exception
{
	try
	{
		if(goToNextPageButton.isEnabled())
		{
			goToNextPageButton.click();
			Logger.info("Go to next page button is clicked");
		}
		else{
			Logger.info("Go to next page button is not enabled");
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
 * @throws Exception
 * @description This method clicks on go to last page button
 */
public void clickOnGoToLastPageButton() throws Exception
{
	try
	{
		if(goToLastPageButton.isEnabled())
		{
			goToLastPageButton.click();
			Logger.info("Go to last page button is clicked");
		}
		else{
			Logger.info("Go to last page button is not enabled");
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
 * @throws Exception
 * @description This method clicks on print button in layout view page
 */
public void clickOnPrint() throws Exception
{
	try
	{
		if(printButton.isDisplayed())
		{
			printButton.click();
			Logger.info("Print button is clicked");
		}
		else{
			Logger.info("Print button is not displayed");
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
 * @throws Exception
 * @description This method clicks on editorial button on a page for the position selected
 */
public void clickOnEditorialButton() throws Exception
{
	try
	{
		if(editorialButton.isDisplayed())
		{
			editorialButton.click();
			Logger.info("Editorial button is clicked");
		}
		else
		{
			Logger.info("Editorial button is not displayed");
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
 * @throws Exception
 * @description This method clicks on ad button on a page for the position selected
 */
public void clickOnAdsButton() throws Exception
{
	try
	{
		if(adsButton.isDisplayed())
		{
			adsButton.click();
			Logger.info("Ads button is clicked");
		}
		else
		{
			Logger.info("Ads button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

/**
 * @author smukherjee - Sunny
 * @throws Exception
 * @description This method clicks on Bring Online button on a layout view page
 */
public void clickOnBringOnlineButton() throws Exception
{
	try
	{
		if(bringOnlineButton.isDisplayed())
		{
			bringOnlineButton.click();
			Logger.info("Bring Online button is clicked");
		}
		else
		{
			Logger.info("Bring Online button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

/**
 * @author smukherjee - Sunny
 * @throws Exception
 * @description This method clicks on Take Offline button on a layout view page
 */
public void clickOnTakeOfflineButton() throws Exception
{
	try
	{
		if(takeOfflineButton.isDisplayed())
		{
			takeOfflineButton.click();
			Logger.info("Take Offline button is clicked");
		}
		else
		{
			Logger.info("Take Offline button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

/**
 * @author smukherjee - Sunny
 * @throws Exception
 * @description This method verifies if template is locked on a layout view page
 */
public void verifyTemplateLocked() throws Exception
{
	try
	{
		if(lockedLabel.isDisplayed())
		{
			
			Logger.info("template is locked : "+lockedUser.getText());
		}
		else
		{
			Logger.info("template is not locked");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}
/**
 * @author smukherjee - Sunny
 * @throws Exception
 * @description This method prints pafe number on a layout view page
 */
public void getPageNumber() throws Exception
{
	try
	{
		if(templatePageNumber.isDisplayed())
		{
			
			Logger.info("Page No. : "+templatePageNumber.getText());
		}
		else
		{
			Logger.info("template Page Number not found");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

public String returnPageNumber() throws Exception
{
	String page = null;
	try
	{
		
		if(templatePageNumber.isDisplayed())
		{
			page = templatePageNumber.getText();
			Logger.info("Page No. : "+templatePageNumber.getText());
			
		}
		else
		{
			Logger.info("template Page Number not found");
		}
		return page;
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}
/**
 * @author smukherjee - Sunny
 * @throws Exception
 * @description This method right clicks on page no. to display page operation options
 */
public void rightClickOnPageNumAndNameSection() throws Exception
{
	try
	{	
		 //Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//mou
		if(templatePageNumber.isDisplayed())
		{
			Actions action = new Actions(driver);
				action.moveToElement(templatePageNumber).doubleClick(templatePageNumber).build().perform();
				Thread.sleep(3000);
			action.contextClick(templatePageNumber).build().perform();
		//action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
			//templatePageNumber.click();
		Logger.info("Right clicked on Page Number ");
		Thread.sleep(3000);
		}
		else
		{
			Logger.info("template Page Number not found");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}

/**
 * @author smukherjee - Sunny
 * @throws Exception
 * @description This method verifies page operation options are present
 */
public void verifyPageOperationOptions() throws Exception
{
		
		//List<WebElement> liElements = driver.findElements(By.xpath("html/body/div[2]/ul/li"));
		//Logger.info("List of elements: "+liElements);
		ArrayList<String> mylist = new ArrayList<String>();
        for(int i=1; i <= 2; i++)
        {
        	WebElement linkElement = driver.findElement(By.xpath("html/body/div[2]/ul/li[" + i + "]/a"));
        	Logger.info("Option "+i+": "+linkElement.getText());              
            mylist.add(linkElement.getText());
        }
        for(int i=4; i <= 5; i++)
        {
        	WebElement linkElement = driver.findElement(By.xpath("html/body/div[2]/ul/li[" + i + "]/a"));
        	Logger.info("Option "+(i - 1)+": "+linkElement.getText());              
            mylist.add(linkElement.getText());
        }
        for(int i=7; i <= 8; i++)
        {
        	WebElement linkElement = driver.findElement(By.xpath("html/body/div[2]/ul/li[" + i + "]/a"));
        	Logger.info("Option "+(i - 2)+": "+linkElement.getText());              
            mylist.add(linkElement.getText());
        }
        for(int i=10; i <= 11; i++)
        {
        	WebElement linkElement = driver.findElement(By.xpath("html/body/div[2]/ul/li[" + i + "]/a"));
        	Logger.info("Option "+(i - 3)+": "+linkElement.getText());              
            mylist.add(linkElement.getText());
        }
        Logger.info("List array: "+mylist.toString());
        if(mylist.contains("Edit") && mylist.contains("Delete") && mylist.contains("Insert Page Before") && mylist.contains("Insert Page After") && mylist.contains("Copy Page Content") && mylist.contains("Paste Page Content") && mylist.contains("Export To Library") && mylist.contains("Import From Library"))
        {
        	 Logger.info("All Options are present as expected");
        }
        else
        {
        	Logger.info("All Options are not present");
        }
        
   
}

/**
 * @author cymkozalg6 - Priyanka
 * @return 
 * @throws Exception
 * @description This method enters the template name using random string generation
 */
public String enterExportName() throws Exception
{
	Thread.sleep(4000);//mou
	String name = utils.generateRandomString(4);
	try
	{
		if(exportName.isDisplayed())
		{
			exportName.click();
			
			exportName.sendKeys(name);
			Logger.info("Export name is entered");
			
		}
		else{
			Logger.info("Export name text box is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
	return name; 
}

public void clickOnExportNew() throws Exception
{
	try
	{
		if(exportNew.isDisplayed())
		{
			exportNew.click();
			Logger.info("New export button is clicked");
		}
		else{
			Logger.info("New export button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}


public void clickOnExportExisting() throws Exception
{
	try
	{
		if(exportExisting.isDisplayed())
		{
			exportExisting.click();
			Logger.info("Exisiting export button is clicked");
		}
		else{
			Logger.info("Existing export button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

public void clickOnvisibilityMine() throws Exception
{
	try
	{
		if(visibilityMine.isDisplayed())
		{
			visibilityMine.click();
			Logger.info("Visibility Mine radio button is clicked");
		}
		else{
			Logger.info("Visibility Mine radio button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

public void clickOnvisibilityBU() throws Exception
{
	try
	{
		if(visibilityBU.isDisplayed())
		{
			visibilityBU.click();
			Logger.info("Visibility BU radio button is clicked");
		}
		else{
			Logger.info("Visibility BU radio button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

public void clickOnvisibilityGlobal() throws Exception
{
	try
	{
		if(visibilityGlobal.isDisplayed())
		{
			visibilityGlobal.click();
			Logger.info("Visibility Global radio button is clicked");
		}
		else{
			Logger.info("Visibility Global radio button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

public void clickOnExportButton() throws Exception
{
	try
	{
		if(btnExport.isDisplayed())
		{
			btnExport.click();
			Logger.info("Export button is clicked");
		}
		else{
			Logger.info("Export button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

public void clickOnImportButton() throws Exception
{
	try
	{
		if(btnImport.isDisplayed())
		{
			btnImport.click();
			Logger.info("Import button is clicked");
		}
		else{
			Logger.info("Import button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}


public void clickOnLibraryMine() throws Exception
{
	try
	{
		if(libraryMine.isDisplayed())
		{
			libraryMine.click();
			Logger.info("Library Mine radio button is clicked");
		}
		else{
			Logger.info("Library Mine radio button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

public void clickOnLibraryBU() throws Exception
{
	try
	{
		if(libraryBU.isDisplayed())
		{
			libraryBU.click();
			Logger.info("Library BU radio button is clicked");
		}
		else{
			Logger.info("Library BU radio button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

public void clickOnLibraryGlobal() throws Exception
{
	try
	{
		if(libraryGlobal.isDisplayed())
		{
			libraryGlobal.click();
			Logger.info("Library Global radio button is clicked");
		}
		else{
			Logger.info("Library Global radio button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

public void selectLibraryName(String libname) throws Exception
{
	try
	{
		if(nameDropDown.isEnabled())
		{
			Select select = new Select(nameDropDown);
			select.selectByVisibleText(libname);
			Logger.info(libname + "Library is selected");
		}
		else{
			Logger.info("Library Name drop down is disabled");
		}
		
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}

/**
 * @author smukherjee - Sunny
 * @throws Exception
 * @description This method right clicks on layout
 */
public void rightClickOnlayoutPage() throws Exception
{
	try
	{	
		if(rectElement.isDisplayed())
		{
		Actions action = new Actions(driver).contextClick(rectElement);
		action.build().perform();
		Logger.info("Right clicked on layout ");
		Thread.sleep(3000);
		}
		else
		{
			Logger.info("Block already filled in the page");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}

public void selectAdType(String adType) throws Exception
{
	try
	{
		if(adTypeDropdwn.isEnabled())
		{
			Select select = new Select(adTypeDropdwn);
			select.selectByVisibleText(adType);
			Logger.info(adType + " Ad Type is selected");
		}
		else{
			Logger.info("Ad Type drop down is disabled");
		}
		
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}


public void selectAdSize(String adSize) throws Exception
{
	try
	{
		if(adSizeDropdwn.isEnabled())
		{
			Select select = new Select(adSizeDropdwn);
			select.selectByVisibleText(adSize);
			Logger.info(adSize + " Ad Size is selected");
		}
		else{
			Logger.info("Ad Size drop down is disabled");
		}
		
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}


public void selectAdLabel(String adLabel) throws Exception
{
	try
	{
		if(adLabelDropdwn.isEnabled())
		{
			Select select = new Select(adLabelDropdwn);
			select.selectByVisibleText(adLabel);
			Logger.info(adLabel + " Ad Label is selected");
		}
		else{
			Logger.info("Ad Label drop down is disabled");
		}
		
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}

public void enterAdTemplateDescription() throws Exception
{
	try{
		if(adDescTextArea.isDisplayed())
		{
			adDescTextArea.click();
			adDescTextArea.sendKeys("AutoTest_"+utils.generateRandomString(5));
			Logger.info("Ad Description is entered");
		}
		else{
			Logger.info("Ad Description text box is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}

public void enterPositionX(String posX) throws Exception
{
	Thread.sleep(3000);
	try
	{
		if(positionXTextBox.isDisplayed())
		{
			positionXTextBox.click();
			positionXTextBox.clear();
			positionXTextBox.sendKeys(posX);
			Logger.info("Position X is entered");
		}
		else{
			Logger.info("Position X text box is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}

public void enterPositionY(String posY) throws Exception
{
	Thread.sleep(3000);
	try
	{
		if(positionYTextBox.isDisplayed())
		{
			positionYTextBox.click();
			positionYTextBox.clear();
			positionYTextBox.sendKeys(posY);
			Logger.info("Position Y is entered");
		}
		else{
			Logger.info("Position Y text box is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}

public void selectPremiumPositionCheckBox(boolean value) throws Exception
{
	try
	{
		if(value)
		{
			if(premiumPositionCheckBox.isSelected()) {
				Logger.info("Premium Position is selected");
			}
			else{
				premiumPositionCheckBox.click();
				Logger.info("Premium Position is selected");
			}
		}
		else{
			if(premiumPositionCheckBox.isSelected()) {
				premiumPositionCheckBox.click();
				Logger.info("Premium Position is deselected");
			}
			else{
				Logger.info("Premium Position is deselected");
			}
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } 
}

public void clickOnInsertButton() throws Exception
{
	try
	{
		if(btnInsert.isDisplayed())
		{
			btnInsert.click();
			Logger.info("Insert button is clicked");
		}
		else{
			Logger.info("Insert button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

public void clickOnUpdateButton() throws Exception
{
	try
	{
		if(btnUpdate.isDisplayed())
		{
			btnUpdate.click();
			Logger.info("Update button is clicked");
		}
		else{
			Logger.info("Update button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

public void clickOnEditButton() throws Exception
{
	try
	{
		if(editButton.isDisplayed())
		{
			editButton.click();
			Logger.info("Edit button is clicked");
		}
		else
		{
			Logger.info("Edit button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

public void clickOnDeleteButton() throws Exception
{
	try
	{
		if(deleteButton.isDisplayed())
		{
			deleteButton.click();
			Logger.info("Delete button is clicked");
		}
		else
		{
			Logger.info("Delete button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

public void clickOnConfirmDeleteButton() throws Exception
{
	try
	{
		if(confirmDeleteButton.isDisplayed())
		{
			confirmDeleteButton.click();
			Logger.info("Delete Confirm button is clicked");
		}
		else
		{
			Logger.info("Delete Confirm button is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

public void clickOnExportOrderButton() throws Exception
{
	try
	{
		if(exportOrderButton.isDisplayed())
		{
			exportOrderButton.click();
			Logger.info("exportOrderButton is clicked");
		}
		else
		{
			Logger.info("exportOrderButton is not displayed");
		}
	}
	catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  }
}

public void saveExportOrderExcel() throws Exception
{
	Robot robot = new Robot();							 
	  
	  
	  Thread.sleep(3000);
	  robot.keyPress(KeyEvent.VK_DOWN);
	  robot.keyRelease(KeyEvent.VK_DOWN);
	  
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
}
}
