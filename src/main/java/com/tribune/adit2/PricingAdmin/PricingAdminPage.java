package com.tribune.adit2.PricingAdmin;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import java.util.Properties;

import org.eclipse.jetty.util.log.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Pricing Admin Page
 * 
 * @author Swagata
 * @since Jul 2019
 */

public class PricingAdminPage {
	@FindBy(id = "btn-refresh")
	public WebElement btnRefresh;


	@FindBy(xpath = "//td[normalize-space()='Manage']")
	public WebElement manageTab;

	@FindBy(xpath = "//span[@class='fc-icon fc-icon-right-single-arrow']")
	public WebElement rightArrow;

	@FindBy(xpath = "//div[@class='fc-bg']/table/tbody/tr/td[4]")
	public WebElement selectAFutureDate;

	@FindBy(xpath = "//input[@id='baselineAdPrice']")
	public WebElement baseAdPriceInput;//swagata

	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement submitButtoninModifier;

	@FindBy(xpath = "//button[text()='OK']/../../div[3]/button")
	private WebElement ClickOk;

	@FindBy(xpath = "//span[@title='Add New Charge']/i")
	//@FindBy(xpath = "(//i[@class='fa fa-plus'])[1]")
	private WebElement ClickAdd;

	@FindBy(xpath = "//label[text()='Charge Type:']/../select")
	private WebElement chargeTypeDropDown;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement chargeTypeSaveButton;

	@FindBy(xpath = "//div[@class='fc-content']/span")
	private WebElement clickOnDefaultMod;

	@FindBy(xpath = "//input[@id='Text5']")
	private WebElement modifierValue;
	@FindBy(xpath = "//input[@id='Text7']")
	private WebElement modifierValueVarFees;

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement modifierValueSubmitButton;

	@FindBy(xpath = "//button[text()='Close']")
	private WebElement modifierValueCancelButton;



	@FindBy(xpath = "//span[@title='Add new Variable Fee']/i")
	private WebElement ClickAddVarFees;

	
	@FindBy(how=How.CSS, using = "a#btnProductSaveDetails")
	public WebElement saveBtnInProductPg;

	@FindBy(xpath="//div[text()=\"Success!\"]")
	public WebElement successMsg;

	@FindBy(how=How.CSS, using = "div.modal-content button.btn.btn-success")
	public WebElement okBtnInConfirmationMsgPopUpHighlightedInGreen;

	@FindBy(how=How.CSS, using = "div.modal-content button.btn.btn-primary.ng-binding.ng-scope")
	public WebElement okBtnInConfirmationMsgPopUp;

	@FindBy(css="div.ui-grid-pinned-container-left i[class]")
	public List<WebElement> adTypeBlockHeaderExpandOrCollapseBtn;

	@FindBy(how=How.CSS, using = "div.tab-pane.ng-scope.active button[ng-click^='add']>i.fa.fa-plus")
	public WebElement addBtnInProductTable;

	@FindBy(css="div.tab-pane.ng-scope.active button[ng-click^='add']>i.fa.fa-plus-square")
	public WebElement addCountBtnInProductTable;

	@FindBy(how=How.CSS, using = "input[ng-class*='colt']")
	public WebElement inputBelowPageCountHeadingInProductTable;

	@FindBy(css="span.ng-binding.carret-space")
	public WebElement sectionAvailableAfterExpandingProduct;

	@FindBy(how=How.CSS, using = "div.weekdays>label.i-checks>input[type='checkbox']")
	public List<WebElement> daysListInRecurrenceTab;

	@FindBy(xpath="//div[contains(@id,'accordiongroup')][.//i[contains(@class,'chevron-up')]]/following-sibling::div[contains(@id,'accordiongroup')]//table/tbody/tr/td")
	public List<WebElement> datasForSelectedOptionFromTheAttributeTable;

	@FindBy(how=How.CSS, using = "button#btnAdd>i.fa.fa-plus.fa-fw")
	public WebElement addBtnInClassifiedPkg;

	@FindBy(how=How.CSS, using = "button#Button1>i.fa.fa-plus.fa-fw")
	public WebElement addBtnInClassifiedPkgPopUp;

	@FindBy(xpath="//div[@class='ng-scope']//select")
	public WebElement dropdownOptionAfterDoubleClkInSpcfcHeadingInGeneralSettingsSubModulePgPopUp;

	@FindBy(how=How.CSS, using = "input.form-control.searchField[type='text']")
	public WebElement inputFieldUnderSearchFilterBtnToTypeData;

	@FindBy(css="span[dm-dropdown-static-include]")
	public List<WebElement> tableDatasBelowClassifiedPkgTbl;

	@FindBy(how=How.CSS, using = "button[title='Click to inactivate']")
	public List<WebElement> inactivateBtnInClassifiedPkgTbl;

	@FindBy(how=How.CSS, using = "button[title='Edit']")
	public List<WebElement> editBtnInGeneralSettingsSubModulePg;

	@FindBy(how=How.CSS, using = "ul[class='pull-right dropdown-menu']")
	public WebElement dropdownMenuAfterClickingOnABtnInInsertionTbl;

	@FindBy(css="span.fc-title")
	public WebElement displayedPercentageInPricingPg;

	@FindBy(how=How.CSS, using = "div.modal-content[uib-modal-transclude]")
	public WebElement popUpElement;

	@FindBy(css="span.input-group-addon")
	public WebElement percentageSignInModifierValInputField;

	@FindBy(how=How.CSS, using = "a#btn-refresh")
	public WebElement refreshBtnInPricingPg;

	@FindBy(css="div.ng-binding.ng-scope")
	public WebElement successMsgAfterClickingOnRefreshBtnInPricingPg;

	@FindBy(how=How.CSS, using = "button[type='button']>i.glyphicon.glyphicon-calendar")
	public WebElement calendarIconBelowPubDateHeadingInInsertionTbl;

	@FindBy(how=How.CSS, using = "div[ng-switch='datepickerMode']")
	public WebElement calendarBelowPubDateHeadingInInsertionTbl;

	@FindBy(css="select[single='single']")
	public WebElement dropdownInInsertionTbl;

	@FindBy(how=How.CSS, using = "div.ui-grid-cell-contents.ng-binding.ng-scope.ui-grid-cell-contents-hidden+div.ng-scope")
	public WebElement inputInProductTblAftrDoubleClk;

	@FindBy(xpath="//span[@title='Delete Charge']/i")
	public WebElement deleteFeesDiscountsbtn;

	@FindBy(xpath="//span[@title='Delete Variable Fee']/i")
	public WebElement deleteVarFeesbtn;

	@FindBy(xpath="//button[text()='Save']")
	public WebElement saveVarFeesbtn;//swagata
	
	@FindBy(xpath="//input[@id='name']")
	public WebElement FeenameTextBox;//swagata
	
	@FindBy(xpath="//select[@id='Ad_Type']")
	public WebElement AdTypeDropDown;//swagata
	
	@FindBy(xpath="//select[@id='Select1']")
	public WebElement PageTypeDropDown;//swagata
	
	@FindBy(xpath="//select[@id='Select2']")
	public WebElement countDropDown;//swagata
	
	@FindBy(xpath="//select[@id='Select3']")
	public WebElement preprintDropDown;//swagata
	
	@FindBy(xpath="//input[@id='Pricing_UseWeight']")
	public WebElement UseWeightCheckBox;//swagata
	
	@FindBy(xpath="//input[@placeholder='Enter Weight']")
	public WebElement EnterWeightTextBox;//swagata
	
	@FindBy(xpath="//input[@id='minQuantity']")
	public WebElement MinQuantityTextBox;//swagata

	public WebElement dayInReferenceCheckboxText(WebElement dayInRecurrenceTab) {
		return dayInRecurrenceTab.findElement(By.xpath("./parent::label"));
	}

	private WebDriver driver;

	Properties properties = TribuneUtils.readProperties();
	TribuneUtils utils = new TribuneUtils();

	public PricingAdminPage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitUntilElementVisible(WebElement webElement) {
		Wait<WebDriver> wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOf(webElement));

	}


	public void waitUntilElementInvisibleSmall(By webElement) {
		Wait<WebDriver> wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(webElement));
	}
	public void waitUntilElementInvisible(By webElement) {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(webElement));
	}//swagata

	public void waitUntilElementVisibleSmall(WebElement webElement) {
		Wait<WebDriver> wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(webElement));

	}

	public void javascriptClk(WebDriver driver, WebElement webElement){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", webElement);
	}

	public void scrollToElement(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public void setClipboardData(String str) {
		StringSelection stringSelection = new StringSelection(str);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public void gotoProduct(String BU,String ProductType,String Product) throws InterruptedException
	{
		try
		{

			Thread.sleep(2000);
			WebElement Prodlink=driver.findElement(By.xpath("((((//*[text()='"+BU+"'])/../following-sibling::ul)//*[contains(text(),'"+ProductType+"')]/preceding-sibling::*)/../following-sibling::ul)//*[contains(text(),'"+Product+"')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Prodlink);
			Prodlink.click();
			Logger.info("Prod Link clicked");


		}
		catch(Exception eCheck)
		{			
			//ArrayList<String> prodCombo = new ArrayList<String>();
			try{
				String xpath1="(//*[text()='"+BU+"']/preceding-sibling::*)";		
				//String xpath13="((((//*[text()='"+BU+"'])/../following-sibling::ul)//*[contains(text(),'"+ProductType+"')]/preceding-sibling::*)/../following-sibling::ul)//*[contains(text(),'"+Product+"')]/preceding-sibling::*";
				String xpath3="//*[text()='"+Product+"']";

				/*			Logger.info(xpath1);
			Logger.info(xpath3);
				 */


				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath1)));
				WebElement BUlink=driver.findElement(By.xpath(xpath1));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", BUlink);
				BUlink.click();
				//Logger.info("xpath1 clicked");
				Thread.sleep(5000);

				//Search Product Type and Click

				try
				{
					for(int i=1;i<20;i++)
					{
						String xpath="((//*[text()='"+BU+"'])/../following-sibling::ul//span)["+i+"]";
						//Logger.info(xpath);

						//Thread.sleep(2000);
						WebElement ProductTypeName=driver.findElement(By.xpath(xpath));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ProductTypeName);

						String text=ProductTypeName.getText();
						//Logger.info(text);
						if(text.replaceAll("\\s+", "").equals(ProductType.replaceAll("\\s+", "")))
						{
							String xpathNode="((//*[text()='"+BU+"'])/../following-sibling::ul)//*[contains(text(),'"+ProductType+"')]/preceding-sibling::*";
							//Logger.info(xpathNode);
							WebElement ProductTypeLink=driver.findElement(By.xpath(xpathNode));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ProductTypeLink);

							ProductTypeLink.click();
							Logger.info("xpath2 clicked");
							Thread.sleep(5000);

							WebElement ProductLink=driver.findElement(By.xpath(xpath3));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ProductLink);
							ProductLink.click();
							Logger.info("xpath3 clicked");
							/*Thread.sleep(5000);

						prodCombo.add(xpathNode);
						prodCombo.add(xpath1);*/

							//return prodCombo;
						}
					}
				}
				catch(Exception e)
				{
					Logger.info(e.getMessage());
				}
			}
			catch(Exception e)
			{
				Logger.info(e.getMessage());
			}
		}
		//return null;
	}

	public void resetProdCombo(ArrayList<String> prodCombo) throws Exception
	{
		try
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(prodCombo.get(0))));
			Logger.info(String.valueOf(prodCombo.get(0)));
			Thread.sleep(2000);
			driver.findElement(By.xpath(prodCombo.get(0))).click();
			Thread.sleep(2000);

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(prodCombo.get(1))));
			Logger.info(String.valueOf(prodCombo.get(1)));
			Thread.sleep(2000);
			driver.findElement(By.xpath(prodCombo.get(1))).click();
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Logger.info(e.getMessage());
		}
	}

	public void clickOnTheMentionedBU(String buName) throws Exception {

		try{

			WebElement buToClk = driver.findElement(By.xpath("//div[@class='mCSB_container']//ul[@class='tree tree-sub']/li[contains(@class,'ng-scope')]//span[@class='ng-binding'][text()=\""+buName+"\"]/preceding-sibling::i[not(contains(@id,'producttype'))]"));
			try{
				waitUntilElementVisible(buToClk);
				Thread.sleep(4000);
			}
			catch(StaleElementReferenceException e){
				buToClk = driver.findElement(By.xpath("//div[contains(@id,'container_wrapper')]//ul[@class='tree tree-sub']/li[contains(@class,'ng-scope')]//span[@class='ng-binding'][text()=\""+buName+"\"]/preceding-sibling::i[not(contains(@id,'producttype'))]"));
				waitUntilElementVisible(buToClk);
			}
			if(buToClk.getAttribute("class").contains("right")){
				Logger.info("It contains right");
				javascriptClk(driver, buToClk);
			}
			Thread.sleep(4000);
			Assert.assertTrue(buToClk.getAttribute("class").contains("down"));
			Logger.info("Able to click on the BU " + buName);
		}
		catch(Exception e){
			Logger.error(e.getMessage());
			throw e;
		}
		catch(AssertionError e){
			Logger.error(e.getMessage());
			throw e;
		}
	}


	public void clickOnTheMentionedProductType(String productTypeName) throws Exception {
		try {
			WebElement productTypeToClick = driver.findElement(By.xpath("//div[@class='mCSB_container']//ul[@class='tree tree-sub'][@ng-hide='active']/li[@class='ng-scope expanded']/ul[@class='tree tree-sub']/li/a[contains(@id,'producttype')]/span[@class='ng-binding'][text()=\""+productTypeName+"\"]/preceding-sibling::i[contains(@id,'producttype')]"));
			waitUntilElementVisible(productTypeToClick);
			if(productTypeToClick.getAttribute("class").contains("right")){
				productTypeToClick.click();
				Thread.sleep(2000);
			}
			try{
				Assert.assertTrue(productTypeToClick.getAttribute("class").contains("down"));
				
			}
			catch(AssertionError e){
				Thread.sleep(2500);
			}
			Assert.assertTrue(productTypeToClick.getAttribute("class").contains("down"));
			Logger.info("Able to click on the Product Type " + productTypeName);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnTheMentionedProductOfTheCorrespondingProductType(String productName, String productTypeName, String optionInAttributeTable) throws Exception {
		try {
			WebElement productToClick = driver.findElement(By.xpath("//div[@class='mCSB_container']//ul[@class='tree tree-sub'][@ng-hide='active']/li[@class='ng-scope expanded']/ul[@class='tree tree-sub']/li/a[contains(@id,'producttype')]/span[@class='ng-binding'][text()=\""+productTypeName+"\"]/preceding-sibling::i[contains(@id,'producttype')]/parent::a/following-sibling::ul[@class='tree tree-sub']/li[@class='ng-scope'][./a]//span[@popover-class='popover-for-tree'][text()=\""+productName+"\"]"));
			waitUntilElementVisible(productToClick);//swagata
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", productToClick);
			int i = 0;
			boolean boolFound = false;
			WebElement attributeTableOptionLink;
			try{
				attributeTableOptionLink = driver.findElement(By.xpath("//a[@class='accordion-toggle'][contains(normalize-space(),\""+optionInAttributeTable+"\")]"));
			}
			catch(NoSuchElementException ex){
				attributeTableOptionLink = driver.findElement(By.xpath("//a[contains(text(),\""+optionInAttributeTable+"\")]"));
			}
			do {
				try {
					waitUntilElementVisible(attributeTableOptionLink);
					boolFound = true;
				} catch (NoSuchElementException e) {
					i++;
				}
				if(boolFound==true){
					break;
				}
			} while (i<60);
			Assert.assertEquals(true, boolFound);
			Logger.info("Able to successfully click on the product " + productName + " of the corresponding Product Type " + productTypeName);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnTheMentionedOptionFromTheAttributeTable(String optionInAttributeTable) throws Exception {
		try {
			WebElement optionFromAttributeTable = driver.findElement(By.xpath("//div[contains(@class,'col-md-4 no-padding treeHeight ng-scope ng-isolate-scope mCustomScrollbar _mCS')]//div[@class='mCSB_container']//div[@class='accordion-panel ng-scope'][not(./preceding-sibling::uib-accordion-heading)]//div[contains(@class,'ng-scope')][normalize-space()=\""+optionInAttributeTable+"\"]/i"));
			//waitUntilElementVisibleSmall(optionFromAttributeTable);//swagata
			waitUntilElementVisible(optionFromAttributeTable);//swagata
			Thread.sleep(300);
			javascriptClk(driver, optionFromAttributeTable);
			Logger.info("Able to click on the option " + optionInAttributeTable + " from the attribute value");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public ArrayList<String> getListOfDatasForSelectedOptionFromTheAttributeTable() {
		try{
			ArrayList<String> listOfDatasForSelectedOptionFromTheAttributeTable = new ArrayList<>();
			Assert.assertTrue(datasForSelectedOptionFromTheAttributeTable.size()>0);
			for(WebElement dataForSelectedOptionFromTheAttributeTable : datasForSelectedOptionFromTheAttributeTable){
				listOfDatasForSelectedOptionFromTheAttributeTable.add(dataForSelectedOptionFromTheAttributeTable.getText().trim());
			}
			Assert.assertNotNull(listOfDatasForSelectedOptionFromTheAttributeTable);
			Assert.assertTrue(listOfDatasForSelectedOptionFromTheAttributeTable.size()>0);
			Logger.info("Able to get the lost of datas for selected option from the attribute table");
			return listOfDatasForSelectedOptionFromTheAttributeTable;
		}
		catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnTheMentionedTabInProduct(String tabName) {
		try {
			WebElement tabInProductPg = driver.findElement(By.xpath("//div[@active='ProductActiveTab']/ul[@class='nav nav-tabs']/li[@role='button'][not(contains(@class,'ng-hide'))]/a[text()=\""+tabName+"\"]"));
			waitUntilElementVisible(tabInProductPg);
			tabInProductPg.click();
			Logger.info("Able to click on the tab " + tabName + " in Product");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnTheMentionedTabInProductSection(String tabName) {
		try {
			WebElement tabInProductPg = driver.findElement(By.xpath("//div[@active='SectionActiveTab']/ul[@class='nav nav-tabs']/li[@role='button'][not(contains(@class,'ng-hide'))]/a[text()=\""+tabName+"\"]"));
			waitUntilElementVisible(tabInProductPg);
			tabInProductPg.click();
			Logger.info("Able to click on the tab " + tabName + " in Product Section");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public int getListOfCheckedInputsInProductTable() {
		try {
			List<WebElement> inputCheckboxesInProductTable = driver.findElements(By.xpath("//div[contains(@class,'ui-grid-render-container')]/div[contains(@class,'ui-grid-viewport')]//div[contains(@ng-style,'Viewport.rowStyle')]//div[@role='gridcell'][./div[contains(@class,'ng-binding ng-scope')]]/following-sibling::div//input[@type='checkbox']"));
			ArrayList<WebElement> arrayListForCheckedInputsInProductTab = new ArrayList<>();
			int counter = 0;
			boolean boolFound = false;
			do{
				if(inputCheckboxesInProductTable.size()>0){
					boolFound = true;
				}
				else {
					counter++;
				}
				if(boolFound==true){
					break;
				}
			} while(counter < 30);
			Assert.assertTrue(inputCheckboxesInProductTable.size()>0);
			for(int i=0; i< inputCheckboxesInProductTable.size(); i++){
				if(inputCheckboxesInProductTable.get(i).isSelected()){
					arrayListForCheckedInputsInProductTab.add(inputCheckboxesInProductTable.get(i));
				}
			}
			Assert.assertTrue(arrayListForCheckedInputsInProductTab.size()>0);
			int dataCountForCheckedInputsInProductTab = arrayListForCheckedInputsInProductTab.size();
			Logger.info("Able  to get the list of checked inputs in Product table");
			return dataCountForCheckedInputsInProductTab;
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void checkIfTheDatasSelectedInPricingOnlyAreShowingInProductCheckboxForDaysOfWeek(
			ArrayList<String> listOfDatasForSelectedOptionFromTheAttributeTableForPricing) {
		try {
			for(String dataForSelectedOptionFromTheAttributeTableForPricing : listOfDatasForSelectedOptionFromTheAttributeTableForPricing){

				WebElement dataElementForSelectedOptionFromTheAttributeTableForPricing = driver.findElement(By.xpath("//div[contains(@class,'ui-grid-render-container')]/div[contains(@class,'ui-grid-viewport')]//div[contains(@ng-style,'Viewport.rowStyle')]//div[@role='gridcell'][./div[contains(@class,'ng-binding ng-scope')][text()=\""+dataForSelectedOptionFromTheAttributeTableForPricing+"\"]]/following-sibling::div//input[@type='checkbox']"));
				waitUntilElementVisible(dataElementForSelectedOptionFromTheAttributeTableForPricing);
				Assert.assertTrue(dataElementForSelectedOptionFromTheAttributeTableForPricing.isSelected());
			}
			Logger.info("Only the datas selected in pricing are showing in the product checkbox for days of week option");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public int getListOfDatasUnderMentionedHeadingInZoneTable(String headingInZoneTable) {
		try {
			List<WebElement> dataListUnderMentionedHeadingInZoneTable = driver.findElements(By.xpath("//div[@id='adZone']//div[@class='ui-grid-viewport ng-isolate-scope']//div[contains(@class,'ui-grid-cell ng-scope')][count(//div[@id='adZone']//div[@class='ui-grid-header-cell-row']/div[contains(@class,'ui-grid-clearfix')][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\""+headingInZoneTable+"\"]]/preceding-sibling::div[contains(@class,'ui-grid-clearfix')])+1]"));
			Assert.assertTrue(dataListUnderMentionedHeadingInZoneTable.size()>0);
			ArrayList<String> textListUnderSpecificHeadingInZoneTable = new ArrayList<>();
			for(int i=0; i< dataListUnderMentionedHeadingInZoneTable.size(); i++){
				textListUnderSpecificHeadingInZoneTable.add(dataListUnderMentionedHeadingInZoneTable.get(i).getText().trim());
			}
			Assert.assertTrue(textListUnderSpecificHeadingInZoneTable.size()>0);
			Logger.info("Able to get the list if datas under heading " + headingInZoneTable + " in the Zone table");
			return (textListUnderSpecificHeadingInZoneTable.size());
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void checkIfTheDatasSelectedInPricingOnlyAreShowingInProductZoneManagementUnderTheMentionedHeading(
			String headingInZoneTable, ArrayList<String> listOfDatasForSelectedOptionFromTheAttributeTableForPricing) {
		try {
			for(String dataForSelectedOptionFromTheAttributeTableForPricing: listOfDatasForSelectedOptionFromTheAttributeTableForPricing){
				WebElement dataElementForSelectedOptionFromTheAttributeTableForPricing = driver.findElement(By.xpath("//div[@id='adZone']//div[@class='ui-grid-viewport ng-isolate-scope']//div[contains(@class,'ui-grid-cell ng-scope')][count(//div[@id='adZone']//div[@class='ui-grid-header-cell-row']/div[contains(@class,'ui-grid-clearfix')][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\""+dataForSelectedOptionFromTheAttributeTableForPricing+"\"]]/preceding-sibling::div[contains(@class,'ui-grid-clearfix')])+1]"));
				waitUntilElementVisible(dataElementForSelectedOptionFromTheAttributeTableForPricing);
			}
			Logger.info("The data selected in Pricing only are shoowing in Product Zone Management under the heading " + headingInZoneTable);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnTheMentionedProduct(String NewProductName) {
		try {
			WebElement productLink = driver.findElement(By.xpath("//span[text()='" + NewProductName + "']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", productLink);

			productLink.click();
			Logger.info("Able to click on Product  " + NewProductName);
			//Thread.sleep(20000);//swagata
		} catch (Exception e) {
			Logger.error(e.getMessage());

		}
	}// swagata new

	public String getOptionFromTheAttributeTable(String optionInAttributeTable) {
		try {

			// Logger.info("Xpath is - //div[@class='mCSB_container_wrapper
			// mCS_y_hidden mCS_no_scrollbar_y mCS_x_hidden
			// mCS_no_scrollbar_x']/div[@class='mCSB_container']//div[@class='accordion-panel
			// ng-scope'][not(./preceding-sibling::uib-accordion-heading)]//div[@class='ng-scope'][normalize-space()=\""+optionInAttributeTable+"\"]");
			WebElement optionFromAttributeTable = driver.findElement(By
					.xpath("//div[@class='mCSB_container_wrapper mCS_y_hidden mCS_no_scrollbar_y mCS_x_hidden mCS_no_scrollbar_x']/div[@class='mCSB_container']//div[@class='accordion-panel ng-scope'][not(./preceding-sibling::uib-accordion-heading)]//div[@class='ng-scope'][normalize-space()=\""
							+ optionInAttributeTable + "\"]"));
			String text = optionFromAttributeTable.getText().trim();
			Logger.info(optionInAttributeTable + "Option is Visible");
			// Logger.info(text);

			return text;

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}


	}// swagata new

	public void refreshButton() throws Exception {
		try {waitUntilElementVisible(btnRefresh);//swagata

			if (btnRefresh.isDisplayed()) {
				btnRefresh.click();
				Logger.info("Refresh button is clicked");
			}

			else {
				Logger.info("Refresh button is not displayed");

			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void goToManageTab() {
		try {
			WebDriverWait wait = new WebDriverWait(driver,200);		   
			wait.until(ExpectedConditions.elementToBeClickable(manageTab));

			manageTab.click();
			Logger.info("Manage tab is clicked");



		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void clickTheRightArrowAndSelectDate() {
		try {
			rightArrow.click();
			Logger.info("Right Arrow is clicked");

			selectAFutureDate.click();

			Logger.info("Future Date is selected");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void creatModifier(String value,String PricingType) {
		try {
			WebElement PricingTypeDropDown = driver.findElement(By.xpath("//select[@id='pricingTypeId']"));//swagata
			Select selectPricingType = new Select(PricingTypeDropDown);//swagata
			List<WebElement> listOfPricingType = selectPricingType.getOptions();//swagata

			Logger.info("list Of listOfPricingType.size()="+listOfPricingType.size());//swagata


			if(listOfPricingType.size() !=0)
			{
				selectPricingType.selectByVisibleText(PricingType);
				Logger.info(PricingType+" Pricing type is selected"); 
			}
			else
			{
				Logger.info("drop down is empty");
			}//swagata


			baseAdPriceInput.sendKeys(value);//swagata
			Logger.info(value + "Base Ad Price is given");

			WebElement StartDate = driver.findElement(By.xpath("//Label[text()='Start Date:']/../p/input"));

			String Date = StartDate.getAttribute("value").trim();
			Logger.info("Modifier is created on:"+Date);//swagata
			submitButtoninModifier.click();

			Logger.info("Modifier is submitted");

			

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void deleteModifier() {
		try {

			// WebElement deleteModifier
			// =driver.findElement(By.xpath("//a[@data_start='"+value+"']/../../span[@class='pull-right
			// ng-scope']"));

			WebElement deleteModifier = driver.findElement(By.xpath("//span[@class='pull-right ng-scope']"));

			deleteModifier.click();

			Logger.info("Modifier is deleted");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new
	public void deleteFutureModifier() {
		try {

			// WebElement deleteModifier
			// =driver.findElement(By.xpath("//a[@data_start='"+value+"']/../../span[@class='pull-right
			// ng-scope']"));

			WebElement deleteModifier = driver.findElement(By.xpath("(//span[@class='pull-right ng-scope'])[5]"));

			deleteModifier.click();

			Logger.info("Modifier is deleted");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}//Partha

	public void clickOkInConfirmMessage() throws Exception {
		try {
			if (ClickOk.isDisplayed()) {
				Logger.info("Confirmation window is displayed requesting the user to Click either OK or Cancel");
				ClickOk.click();
				Logger.info("'OK' is clicked in confirmation window");
			} else {
				Assert.fail("Confirmation window is not displayed");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void clickAddFeesDiscounts(String chargeType) throws Exception {
		try {
			Thread.sleep(3000);
			if (ClickAdd.isDisplayed()) {

				ClickAdd.click();
				Logger.info("'+' is clicked in Attribute Table");
				//waitUntilElementVisible(chargeTypeDropDown);//swagata
				Thread.sleep(6000);
				chargeTypeDropDown.click();
				Select valueFromChargeType = new Select(chargeTypeDropDown);
				List<WebElement> listChargeTypes = valueFromChargeType.getOptions();
				if (listChargeTypes.size() != 0) {
					Logger.info("List of Product types is not empty");

					valueFromChargeType.selectByVisibleText(chargeType);

					Logger.info("'" + chargeType + "' product type is selected");
					chargeTypeSaveButton.click();

					Logger.info("Fees/Discount is saved");

					WebElement ChargeType = driver.findElement(By.xpath("//span[text()='" + chargeType + " " + "']"));

					ChargeType.click();
					Logger.info("Click on added Fees/Discount");
					Thread.sleep(3000);

				}
			} else {
				Logger.info("'+' is not displayed");

			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void clickOnVariableFees(String Adtype, String Pagetype,String count,String preprintType,String minValue) throws Exception {
		try {
			if (ClickAddVarFees.isDisplayed()) {

				ClickAddVarFees.click();
				Logger.info("Clicked on add Variable Fees");

				Thread.sleep(3000);
				FeenameTextBox.clear();
				//TribuneUtils utils  = new TribuneUtils();
				String str = utils.generateRandomString(3);
				String name= "00"+str+"Fee";
				FeenameTextBox.sendKeys(name);

				AdTypeDropDown.click();
				Select valueFromAdTypeDropDown = new Select(AdTypeDropDown);
				valueFromAdTypeDropDown.selectByVisibleText(properties.getProperty(Adtype));//changed @swagata

				//valueFromAdTypeDropDown.selectByVisibleText(Adtype);

				Logger.info("'" + Adtype + "' Ad type is selected");

				PageTypeDropDown.click();
				Select valueFromPageTypeDropDown = new Select(PageTypeDropDown);
				valueFromPageTypeDropDown.selectByVisibleText(properties.getProperty(Pagetype));//changed @swagata

				//valueFromPageTypeDropDown.selectByVisibleText(Pagetype);

				Logger.info("'" + Pagetype + "' Page Type is selected");

				countDropDown.click();
				Select valueFromcountDropDown = new Select(countDropDown);

				valueFromcountDropDown.selectByVisibleText(count);

				Logger.info("'" + count + "' count is selected");

				preprintDropDown.click();
				Select valueFrompreprintDropDown = new Select(preprintDropDown);
				valueFrompreprintDropDown.selectByVisibleText(properties.getProperty(preprintType));//changed @swagata

				//valueFrompreprintDropDown.selectByVisibleText(preprintType);//swagata

				Logger.info("'" + preprintType + "' Preprint Type is selected");

				MinQuantityTextBox.clear();

				MinQuantityTextBox.sendKeys(minValue);

				saveVarFeesbtn.click();



				Logger.info(" Variable Fees is created");

			} else {
				Logger.info(" Variable Fees add button is not displayed");

			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new


	public double clickOnDefaultModifierInVarFees(String value) throws Exception {
		try {
			if (clickOnDefaultMod.isDisplayed()) {

				clickOnDefaultMod.click();
				Logger.info("Clicked on Default Modifier");

				Thread.sleep(6000);

				// modifierValue.click();
				modifierValueVarFees.clear();
				modifierValueVarFees.sendKeys(value);

				Logger.info(" Default Modifier value:" + value + " is given");

				modifierValueSubmitButton.click();
				Logger.info(" Default Modifier value is submitted");

			} else {
				Logger.info(" Default Modifier is not displayed");

			}
			return Double.parseDouble(value);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new
	public void clickOnDefaultModifier(String value) throws Exception {
		try {
			if (clickOnDefaultMod.isDisplayed()) {

				clickOnDefaultMod.click();
				Logger.info("Clicked on Default Modifier");

				Thread.sleep(6000);

				// modifierValue.click();
				modifierValue.clear();
				modifierValue.sendKeys(value);

				Logger.info(" Default Modifier value:" + value + " is given");

				modifierValueSubmitButton.click();
				Logger.info(" Default Modifier value is submitted");

			} else {
				Logger.info(" Default Modifier is not displayed");

			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new


	public void goToNewCreatedVariableFees(String Adtype, String Pagetype,String count,String preprintType,String minValue) throws Exception {
		try {



			WebElement AdTypeDropDown = driver.findElement(By.xpath("//div[normalize-space()='"+properties.getProperty(Adtype)+"']/i"));//swagata
			AdTypeDropDown.click();
			Thread.sleep(2000);



			Logger.info("'" + Adtype + "' Ad type is opened");

			WebElement PageTypeDropDown = driver.findElement(By.xpath("//div[normalize-space()='"+properties.getProperty(Pagetype)+"']/i"));//swagata
			PageTypeDropDown.click();
			Thread.sleep(2000);



			Logger.info("'" + Pagetype + "' Page Type is opened");

			WebElement countDropDown = driver.findElement(By.xpath("//div[normalize-space()='"+count+"']/i"));
			countDropDown.click();
			Thread.sleep(2000);


			Logger.info("'" + count + "' count is opened");

			WebElement preprintDropDown = driver.findElement(By.xpath("//div[normalize-space()='"+properties.getProperty(preprintType)+"']/i"));//swagata
			preprintDropDown.click();
			Thread.sleep(2000);



			Logger.info("'" + preprintType + "' Preprint Type is opened");

			WebElement value = driver.findElement(By.xpath("//td[normalize-space()='"+minValue+"']"));
			value.click();


			Logger.info("Default Modifier is opened");



		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void goClassifiedSubCategories(String subcategory, String AdSize,String AdDepth) throws Exception {
		try {



			WebElement SubcategoryDropDown = driver.findElement(By.xpath("//div[contains(@class,'mCSB_container_wrapper mCS_x_hidden mCS_no_scrollbar_x')]//div[@class='ng-isolate-scope panel panel-open panel-open-class']//div[@class='panel-collapse in collapse']/div[@class='panel-body']/div[@class='accordion-panel ng-scope']/uib-accordion/div[@role='tablist']/div[contains(@class,'panel-default ng-scope')]/div[@role='tab']//div[@class='ng-binding ng-scope'][@role='button'][normalize-space()='"+subcategory+"']/i"));
			SubcategoryDropDown.click();
			Thread.sleep(4000);



			Logger.info("'" + subcategory + "' Sub Category is opened");

			WebElement AdSizeDropDown = driver.findElement(By.xpath("//div[contains(@class,'mCSB_container_wrapper mCS_x_hidden mCS_no_scrollbar_x')]//div[@class='ng-isolate-scope panel panel-open panel-open-class']//div[@class='panel-collapse in collapse']/div[@class='panel-body']/div[@class='accordion-panel ng-scope']/uib-accordion/div[@role='tablist']/div[contains(@class,'panel-default ng-scope')]/div[@role='tab']//div[@class='ng-binding ng-scope'][@role='button'][normalize-space()='"+AdSize+"']/i"));
			/*(//div[normalize-space()='"+AdSize+"']/i)[1]
				WebElement AdSizeDropDown = driver.findElement(By.xpath(""));*/
			AdSizeDropDown.click();



			Logger.info("'" + AdSize + "' Ad Size is opened");
			Thread.sleep(4000);


			WebElement adDepth = driver.findElement(By.xpath("//div[contains(@id,'accordiongroup')][.//i[contains(@class,'chevron-up')]]/following-sibling::div[contains(@id,'accordiongroup')]//table/tbody/tr/td[normalize-space()='"+AdDepth+"']"));
			adDepth.click();
			Thread.sleep(4000);


			Logger.info("'" + AdDepth + "' Ad Depth is clicked");




			Logger.info("Default Modifier is opened");



		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public double getValueOfDefaultModifier() throws Exception {
		try {


			clickOnDefaultMod.click();
			Logger.info("Clicked on Default Modifier");

			Thread.sleep(6000);

			String price=modifierValueVarFees.getAttribute("value");


			Logger.info(" Default Modifier value:" + price + " is already given");

			modifierValueCancelButton.click();
			Logger.info(" Default Modifier value is cancelled");

			return Double.parseDouble(price);




		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}


	}

	public int noteTheFirstUncheckedCheckboxIndexAndCheckIt(String productUseCheckbox) {
		try {
			List<WebElement> checkBoxListInProductListHeading = driver.findElements(By.xpath("//div[@id='adTypeGrid']//div[@class='ui-grid-canvas']/div[@class='ui-grid-row ng-scope']//div[contains(@ng-class,'ui-grid-row-header-cell')][count(//div[@id='adTypeGrid']//div[@class='ui-grid-header-cell-wrapper']//div[@render-index='$index'][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\""+productUseCheckbox+"\"]]/preceding-sibling::div[@render-index='$index'])+1]//input[@type='checkbox']"));
			int counter = 0;
			boolean listFound = false;
			do {
				try {
					Assert.assertTrue(checkBoxListInProductListHeading.size()>0);
					listFound = true;
					break;
				} catch (AssertionError e) {
					counter++;
				}
				if(listFound==true){
					break;
				}
			} while (counter<30);
			Assert.assertTrue(checkBoxListInProductListHeading.size()>0);
			boolean boolFound = false;
			int firstUncheckedCheckeboxIdx = 0;
			for(int i=0; i< checkBoxListInProductListHeading.size(); i++){
				if(!(checkBoxListInProductListHeading.get(i).isSelected())){
					boolFound = true;
					firstUncheckedCheckeboxIdx = i;
					break;
				}
			}
			checkBoxListInProductListHeading.get(firstUncheckedCheckeboxIdx).click();
			Assert.assertEquals(true, checkBoxListInProductListHeading.get(firstUncheckedCheckeboxIdx).isSelected());
			Assert.assertEquals(true, boolFound);
			firstUncheckedCheckeboxIdx+=1;
			Logger.info("Able to note the first unchecked chekbox index and also able to check it");
			return firstUncheckedCheckeboxIdx;
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public String noteTheNameOfTheLatestCheckedCheckbox(int firstUncheckedCheckboxIdx) {
		try {
			WebElement recentCheckedCheckboxNameElement = driver.findElement(By.xpath("//div[@id='adTypeGrid']//div[@class='ui-grid-canvas']/div[contains(@class,'ui-grid-row ng-scope')]["+firstUncheckedCheckboxIdx+"]//div[contains(@ng-class,'ui-grid-row-header-cell')][count(//div[@id='adTypeGrid']//div[@class='ui-grid-header-cell-wrapper']//div[@render-index='$index'][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\"AdType\"]]/preceding-sibling::div[@render-index='$index'])+1]"));
			waitUntilElementVisible(recentCheckedCheckboxNameElement);
			String recentCheckedCheckboxName = recentCheckedCheckboxNameElement.getText().trim();
			Assert.assertNotNull(recentCheckedCheckboxName);
			Assert.assertFalse(recentCheckedCheckboxName.equals(""));
			Logger.info("Able to note the name of the latest checked checkbox and it is the " + recentCheckedCheckboxName + " checkbox");
			return recentCheckedCheckboxName;
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnSaveBtnInTheProductPg() throws Exception {
		try {
			//waitUntilElementVisible(saveBtnInProductPg);
			Thread.sleep(4000);
			saveBtnInProductPg.click();
			//waitUntilElementVisible(successMsg);
			Thread.sleep(30000);
			Logger.info("Able to click on the Save Button in the Produuct Page");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void checkIfTheSelectedOrTypedDataFromProductIsShowingInPricing(String data) {
		try {
			WebElement dataForSelectedOptionFromTheAttributeTable;
			try{
				dataForSelectedOptionFromTheAttributeTable = driver.findElement(By.xpath("//div[contains(@id,'accordiongroup')][.//i[contains(@class,'chevron-up')]]/following-sibling::div[contains(@id,'accordiongroup')][contains(@class,'in collapse')]/div[@class='panel-body']/table/tbody/tr/td[normalize-space()=\""+data+"\"]"));
			}
			catch(NoSuchElementException e){
				dataForSelectedOptionFromTheAttributeTable = driver.findElement(By.xpath("//div[contains(@id,'accordiongroup')][.//i[contains(@class,'chevron-up')]]/following-sibling::div[contains(@id,'accordiongroup')]//table/tbody/tr/td[normalize-space()=\""+data+"\"]"));
			}
			waitUntilElementVisible(dataForSelectedOptionFromTheAttributeTable);
			Logger.info("The selected or typed data: " + dataForSelectedOptionFromTheAttributeTable + " data from Product is showing in Pricing");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void checkIfTheSelectedDataFromProductIsNotShowingInPricing(String checkboxName) {
		try {
			boolean boolFound = true;
			WebElement dataForSelectedOptionFromTheAttributeTable;
			try{
				try{
					dataForSelectedOptionFromTheAttributeTable = driver.findElement(By.xpath("//div[contains(@id,'accordiongroup')][.//i[contains(@class,'chevron-up')]]/following-sibling::div[contains(@id,'accordiongroup')][contains(@class,'in collapse')]/div[@class='panel-body']/table/tbody/tr/td[normalize-space()=\""+checkboxName+"\"]"));
				}
				catch(NoSuchElementException e){
					dataForSelectedOptionFromTheAttributeTable = driver.findElement(By.xpath("//div[contains(@id,'accordiongroup')][.//i[contains(@class,'chevron-up')]]/following-sibling::div[contains(@id,'accordiongroup')]//table/tbody/tr/td[normalize-space()=\""+checkboxName+"\"]"));
				}
				waitUntilElementVisible(dataForSelectedOptionFromTheAttributeTable);
			}
			catch(NoSuchElementException ex){
				boolFound = false;
			}
			Assert.assertEquals(false, boolFound);
			Logger.info("The selected " + checkboxName + " data from Product is not showing in Pricing");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void uncheckTheLatestCheckedCheckboxInAdTYpeManagement(int firstUncheckedCheckboxIdx) throws Exception {
		try {
			WebElement recentCheckedCheckboxElement = driver.findElement(By.xpath("//div[@id='adTypeGrid']//div[@class='ui-grid-canvas']/div[contains(@class,'ui-grid-row ng-scope')]["+firstUncheckedCheckboxIdx+"]//div[contains(@ng-class,'ui-grid-row-header-cell')][count(//div[@id='adTypeGrid']//div[@class='ui-grid-header-cell-wrapper']//div[@render-index='$index'][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\"AdType\"]]/preceding-sibling::div[@render-index='$index'])+1]/following-sibling::div[contains(@ng-class,'ui-grid-row-header-cell')]//input[@type='checkbox']"));
			Assert.assertTrue(recentCheckedCheckboxElement.isSelected());
			recentCheckedCheckboxElement.click();
			waitUntilElementVisible(okBtnInConfirmationMsgPopUpHighlightedInGreen);
			okBtnInConfirmationMsgPopUpHighlightedInGreen.click();
			Thread.sleep(3000);
			Logger.info("Able to uncheck the latest checked checkbox in Ad Type Management");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void checkIfTheLastSelectedUncheckedCheckboxFromProductIsNotShowingInPricing(String checkboxName) {
		try {
			boolean boolFound = true;
			try {
				checkIfTheSelectedOrTypedDataFromProductIsShowingInPricing(checkboxName);
				boolFound = true;
			} catch (NoSuchElementException e) {
				boolFound = false;
			}
			Assert.assertEquals(false, boolFound);
			Logger.info("The last selected unchecked checkbox " + checkboxName +" from product is not showing in pricing");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void expandTheLatestProductTableBlockAddButtonIfPresentAndCollapsed() {
		try {
			try{
				Assert.assertTrue(adTypeBlockHeaderExpandOrCollapseBtn.size()>0);
				waitUntilElementVisible(adTypeBlockHeaderExpandOrCollapseBtn.get(adTypeBlockHeaderExpandOrCollapseBtn.size()-1));
				if(adTypeBlockHeaderExpandOrCollapseBtn.get(adTypeBlockHeaderExpandOrCollapseBtn.size()-1).getAttribute("class").contains("plus")){
					javascriptClk(driver, adTypeBlockHeaderExpandOrCollapseBtn.get(adTypeBlockHeaderExpandOrCollapseBtn.size()-1));
				
				}
				Assert.assertTrue(adTypeBlockHeaderExpandOrCollapseBtn.get(adTypeBlockHeaderExpandOrCollapseBtn.size()-1).getAttribute("class").contains("minus"));
			}
			catch (NoSuchElementException | TimeoutException e) {
				// do nothing
			}

			//WebElement element = driver.findElement(By.xpath("(//div[text()='3 X 3']/../../../../../../..//i[contains(@class,'clickable ng-scope ui-grid-icon-plus-squared')])[4]"));//swagata new
			//element.click();//swagata new 
			Logger.info("ad type expanded");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	//partha
	public void expandAdvertorialAdtype() {
		try {
			try{driver.findElement(By.xpath("(//i[@class='ui-grid-icon-plus-squared'])[1]")).click();
				
			Logger.info("Expanded AdvertorialAdtype");}
			catch (NoSuchElementException | TimeoutException e) {
				// do nothing
			}

			Logger.info("Able to expand the latest Product Table Block Add button if present and collapsed");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public int getNumberOfDatasForSelectedOptionFromTheAttributeTable() {
		try {
			List<WebElement> datasForSelectedOptionFromTheAttributeTable = driver.findElements(By.xpath("//div[contains(@id,'accordiongroup')][.//i[contains(@class,'chevron-up')]]/following-sibling::div[contains(@id,'accordiongroup')]//table/tbody/tr/td"));
			//List<WebElement> datasForSelectedOptionFromTheAttributeTable = driver.findElements(By.xpath("//div[contains(text(),'Advertorial')]//following::table[@class='table hoverTable table-bordered ng-scope'][1]//tr"));
			return (datasForSelectedOptionFromTheAttributeTable.size());
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	//partha
	public int getNumberOfDatasForSelectedAdtypeinPricingAdmin(String AdType) {
		try {
			String xpathForadType="//div[contains(text(),'"+AdType+"')]//following::table[@class='table hoverTable table-bordered ng-scope'][1]//tr";
			//List<WebElement> datasForSelectedOptionFromTheAttributeTable = driver.findElements(By.xpath("//div[contains(@id,'accordiongroup')][.//i[contains(@class,'chevron-up')]]/following-sibling::div[contains(@id,'accordiongroup')]//table/tbody/tr/td"));
			List<WebElement> datasForSelectedOptionFromTheAttributeTable = driver.findElements(By.xpath("//div[contains(text(),'Advertorial')]//following::table[@class='table hoverTable table-bordered ng-scope'][1]//tr"));
			return (datasForSelectedOptionFromTheAttributeTable.size());
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void checkIfTheNumberOfDatasPresentInAdTypeTableMatchesWithTheNotedNrOfDatasPresentInPricing(
			int nrOfDatasPresentInTheSelectedOptionFromTheAttributeTable) {
		try {
			//List<WebElement> nrOfDatasInAdTypeTable = driver.findElements(By.xpath("//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-canvas']/div[contains(@class,'ui-grid-row ng-scope')]//div[contains(@ng-class,'ui-grid-row-header-cell')][count(//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-header-cell-wrapper']//div[@render-index='$index'][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\"Ad Type\"]]/preceding-sibling::div[@render-index='$index'])+1][./div[not(contains(text(),\"Block (\"))]]"));
			//Partha
			List<WebElement> nrOfDatasInAdTypeTable = driver.findElements(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and contains(text(),'Advertorial')]"));
			Assert.assertEquals(nrOfDatasPresentInTheSelectedOptionFromTheAttributeTable, (nrOfDatasInAdTypeTable.size()));//swagata
            //Assert.assertEquals(nrOfDatasPresentInTheSelectedOptionFromTheAttributeTable, (nrOfDatasInAdTypeTable.size()-1));//swagata
			Logger.info("The number of datas present in Ad Type Table matches with the noted nr: " + nrOfDatasPresentInTheSelectedOptionFromTheAttributeTable + " datas present in Pricing");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnAddBtnInProductTable() {
		try {
			waitUntilElementVisible(addBtnInProductTable);
			addBtnInProductTable.click();
			Logger.info("Able to click on the Add button in Ad Type Table");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public int getNrOfDatasPresentInAdTypeTable() {
		try {
			//int nrOfDatasInAdTypeTable = driver.findElements(By.xpath("//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-canvas']/div[contains(@class,'ui-grid-row ng-scope')]//div[contains(@ng-class,'ui-grid-row-header-cell')][count(//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-header-cell-wrapper']//div[@render-index='$index'][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\"Ad Type\"]]/preceding-sibling::div[@render-index='$index'])+1][./div[not(contains(text(),\"Advertorial(\"))]]")).size();
			int nrOfDatasInAdTypeTable = driver.findElements(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and contains(text(),'Advertorial')]")).size();
			Logger.info("in product admin no of data"+(nrOfDatasInAdTypeTable-1));
			return nrOfDatasInAdTypeTable-1;//swagata
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void deleteTheLastlyAddedData(int nrOfDatasShowingInAddTypeTable) throws Exception {
		try {
			List<WebElement> listOfTrashIconsForAdTypes = driver.findElements(By.xpath("//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-canvas']/div[contains(@class,'ui-grid-row ng-scope')]//div[contains(@ng-class,'ui-grid-row-header-cell')][count(//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-header-cell-wrapper']//div[@render-index='$index'][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\"Action\"]]/preceding-sibling::div[@render-index='$index'])+1]//i[@class='fa fa-trash']"));
			Assert.assertTrue(listOfTrashIconsForAdTypes.size()>0);
			waitUntilElementVisible(listOfTrashIconsForAdTypes.get(nrOfDatasShowingInAddTypeTable-1));
			javascriptClk(driver, listOfTrashIconsForAdTypes.get(nrOfDatasShowingInAddTypeTable-1));
			waitUntilElementVisible(okBtnInConfirmationMsgPopUp);
			javascriptClk(driver, okBtnInConfirmationMsgPopUp);
			Thread.sleep(3000);
			Logger.info("Able to delete the last " + nrOfDatasShowingInAddTypeTable + "th added data");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}
	
	public void deleteTheLastlyAddedData() throws Exception {
		try {
			List<WebElement> listOfTrashIconsForAdTypes = driver.findElements(By.xpath("//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-canvas']/div[contains(@class,'ui-grid-row ng-scope')]//div[contains(@ng-class,'ui-grid-row-header-cell')][count(//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-header-cell-wrapper']//div[@render-index='$index'][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\"Action\"]]/preceding-sibling::div[@render-index='$index'])+1]//i[@class='fa fa-trash']"));
			Assert.assertTrue(listOfTrashIconsForAdTypes.size()>0);
			waitUntilElementVisible(listOfTrashIconsForAdTypes.get(listOfTrashIconsForAdTypes.size()-1));
			javascriptClk(driver, listOfTrashIconsForAdTypes.get(listOfTrashIconsForAdTypes.size()-1));
			waitUntilElementVisible(okBtnInConfirmationMsgPopUp);
			javascriptClk(driver, okBtnInConfirmationMsgPopUp);
			Thread.sleep(3000);
			Logger.info("Able to delete the lastly added data");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnTheMentionedSubOptionFromTheAttributeTable(String subOptionInAttributeTable) throws Exception {
		try {
			clickOnTheMentionedOptionFromTheAttributeTable(subOptionInAttributeTable);
			Logger.info("Able to click on the mentioned sub-option " + subOptionInAttributeTable + " from the attribute table");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void checkIfTheMentionedSubOptionIsNotPresentFromTheAttributeTable(String subOptionInAttributeTable){
		try {
			boolean boolFond = true;
			try{
				WebElement optionFromAttributeTable = driver.findElement(By.xpath("//div[@class='mCSB_container_wrapper mCS_y_hidden mCS_no_scrollbar_y mCS_x_hidden mCS_no_scrollbar_x']/div[@class='mCSB_container']//div[@class='accordion-panel ng-scope'][not(./preceding-sibling::uib-accordion-heading)]//div[contains(@class,'ng-scope')][normalize-space()=\""+subOptionInAttributeTable+"\"]/i"));
				waitUntilElementVisibleSmall(optionFromAttributeTable);
			}
			catch(NoSuchElementException e){
				boolFond = false;
			}
			Assert.assertEquals(false, boolFond);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void checkIfTheNumberOfDatasPresentInProductTableForMentionedHeadingMatchesWithTheNotedNrOfDatasPresentInPricing(
			String productTableHeading,
			int nrOfDatasPresentInTheSelectedOptionFromTheAttributeTableAfterAddingOrDeleting) {
		try {
			List<WebElement> nrOfDatasInAdTypeTable = driver.findElements(By.xpath("//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-canvas']/div[contains(@class,'ui-grid-row ng-scope')]//div[contains(@ng-class,'ui-grid-row-header-cell')][count(//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-header-cell-wrapper']//div[@render-index='$index'][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\""+productTableHeading+"\"]]/preceding-sibling::div[@render-index='$index'])+1]"));
			Assert.assertEquals(nrOfDatasPresentInTheSelectedOptionFromTheAttributeTableAfterAddingOrDeleting, (nrOfDatasInAdTypeTable.size()));
			Logger.info("The number of datas present in Ad Type Table matches with the noted nr: " + nrOfDatasPresentInTheSelectedOptionFromTheAttributeTableAfterAddingOrDeleting + " datas present in Pricing");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public int getNrOfDatasPresentInProductTable(String productTableHeading) {
		try {

			int nrOfDatasInAdTypeTable = driver.findElements(By.xpath("//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-canvas']/div[contains(@class,'ui-grid-row ng-scope')]//div[contains(@ng-class,'ui-grid-row-header-cell')][count(//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-header-cell-wrapper']//div[@render-index='$index'][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\""+productTableHeading+"\"]]/preceding-sibling::div[@render-index='$index'])+1]")).size();
			return nrOfDatasInAdTypeTable;
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void chooseTheMentionedOptionFromPageTypePopUp(String pageTypeOption) throws Exception {
		try {
			WebElement optionFromPageTypePopUp = driver.findElement(By.xpath("//div[@class='modal-content']//div[@class='ui-grid-canvas']/div[@class='ui-grid-row ng-scope']//div[contains(@class,'ui-grid-cell-contents')][text()=\""+pageTypeOption+"\"]"));
			waitUntilElementVisibleSmall(optionFromPageTypePopUp);
			
			optionFromPageTypePopUp.click();
			Thread.sleep(1500);
			waitUntilElementVisibleSmall(okBtnInConfirmationMsgPopUpHighlightedInGreen);
			okBtnInConfirmationMsgPopUpHighlightedInGreen.click();
			Thread.sleep(2000);
			Logger.info("Able to choose the option " + pageTypeOption + " from Page Type PopUp");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnAddCountBtnInProductTable() throws Exception {
		try {
			waitUntilElementVisible(addCountBtnInProductTable);
			Thread.sleep(3000);
			addCountBtnInProductTable.click();
			Logger.info("Able to click on the Add buton in Ad Type Table");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void doubleClickBelowTheMentionedSubHeadingInProductTable(String subHeadinngNameInProductTable) {
		try {
			WebElement elementToDoubleClickBelowCertainSubHeadingInProductTable = driver.findElement(By.xpath("//div[contains(@class,'ui-grid ng-isolate-scope grid')]//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-canvas']/div[contains(@class,'ui-grid-row ng-scope')]//div[contains(@ng-class,'ui-grid-row-header-cell')][count(//div[contains(@class,'ui-grid ng-isolate-scope grid')]//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-header-cell-wrapper']//div[@render-index='$index'][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\""+subHeadinngNameInProductTable+"\"]]/preceding-sibling::div[@render-index='$index'])+1]"));
			waitUntilElementVisible(elementToDoubleClickBelowCertainSubHeadingInProductTable);
			Actions actions = new Actions(driver);
			actions.moveToElement(elementToDoubleClickBelowCertainSubHeadingInProductTable).doubleClick().build().perform();
			Logger.error("Able to click on the subHeading " + subHeadinngNameInProductTable + " in the Product Table");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void enterTheCountBelowPageCountHeading(int pageCount) {
		try {
			waitUntilElementVisible(inputBelowPageCountHeadingInProductTable);
			inputBelowPageCountHeadingInProductTable.sendKeys(Integer.toString(pageCount));
			Assert.assertEquals(Integer.toString(pageCount).trim(), inputBelowPageCountHeadingInProductTable.getAttribute("value").trim());
			Logger.info("Able to enter count as " + pageCount + " below Page Count Heading");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void expandTheMentionedProductOfTheCorrespondingProductType(String productName, String productTypeName,
			String optionInAttributeTable) throws Exception {
		try {
			WebElement productToClick = driver.findElement(By.xpath("//div[@class='mCSB_container']//ul[@class='tree tree-sub'][@ng-hide='active']/li[@class='ng-scope expanded']/ul[@class='tree tree-sub']/li/a[contains(@id,'producttype')]/span[@class='ng-binding'][text()=\""+productTypeName+"\"]/preceding-sibling::i[contains(@id,'producttype')]/parent::a/following-sibling::ul[@class='tree tree-sub']/li[@class='ng-scope'][./a]//span[@popover-class='popover-for-tree'][text()=\""+productName+"\"]/preceding-sibling::i"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", productToClick);
			Thread.sleep(1500);
			Assert.assertTrue(productToClick.getAttribute("class").contains("caret-down"));
			Logger.info("Able to successfully click on the product " + productName + " of the corresponding Product Type " + productTypeName);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}// swagata new

	public void clickOnSunSentinelProduct() {
		try {
			WebElement productLink = driver.findElement(By.xpath("//i[@id='i-product-756']/../span"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", productLink);


			productLink.click();
			Logger.info("Able to click on the SunSentinel Product");
			Thread.sleep(20000);
		} catch (Exception e) {
			Logger.error(e.getMessage());

		}
	}// swagata new

	public void clickOnVariableFeesForWeightTypeProduct(String Adtype, String Pagetype,String count,String preprintType,String Weight,String minValue) throws Exception {
		try {
			if (ClickAddVarFees.isDisplayed()) {

				ClickAddVarFees.click();
				Logger.info("Clicked on add Variable Fees");

				Thread.sleep(3000);
				FeenameTextBox.clear();//swagata
				//TribuneUtils utils  = new TribuneUtils();
				String str = utils.generateRandomString(3);
				String name= "00"+str+"Fee";
				FeenameTextBox.sendKeys(name);//swagata

				AdTypeDropDown.click();
				Select valueFromAdTypeDropDown = new Select(AdTypeDropDown);
				//valueFromAdTypeDropDown.selectByVisibleText(properties.getProperty(Adtype));//changed @swagata

				valueFromAdTypeDropDown.selectByVisibleText(Adtype);//swagata

				Logger.info("'" + Adtype + "' Ad type is selected");

				PageTypeDropDown.click();
				Select valueFromPageTypeDropDown = new Select(PageTypeDropDown);
				//valueFromPageTypeDropDown.selectByVisibleText(properties.getProperty(Pagetype));//changed @swagata
				
				valueFromPageTypeDropDown.selectByVisibleText(Pagetype);//swagata

				Logger.info("'" + Pagetype + "' Page Type is selected");

				countDropDown.click();
				Select valueFromcountDropDown = new Select(countDropDown);

				valueFromcountDropDown.selectByVisibleText(count);

				Logger.info("'" + count + "' count is selected");

				preprintDropDown.click();
				Select valueFrompreprintDropDown = new Select(preprintDropDown);
				valueFrompreprintDropDown.selectByVisibleText(properties.getProperty(preprintType));//changed @swagata


				//valueFrompreprintDropDown.selectByVisibleText(preprintType);//swagata

				Logger.info("'" + preprintType + "' Preprint Type is selected");
				Thread.sleep(2000);
                
				UseWeightCheckBox.click();
				Thread.sleep(2000);

				EnterWeightTextBox.clear();//swagata

				EnterWeightTextBox.sendKeys(Weight);//swagata

				MinQuantityTextBox.clear();

				
				MinQuantityTextBox.sendKeys(minValue);

		       	saveVarFeesbtn.click();


				Logger.info(" Variable Fees is created");
				


			} else {
				Logger.info(" Variable Fees add button is not displayed");

			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new




	public void goToNewCreatedVariableFeesForWeightTypeProduct(String Adtype, String Pagetype,String preprintType,String Weight,String minValue) throws Exception {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 50);
          	WebElement AdTypeDropDown = driver.findElement(By.xpath("//div[normalize-space()='"+Adtype+"']/i"));//swagata
			wait.until(ExpectedConditions.elementToBeClickable(AdTypeDropDown));//swagata
			AdTypeDropDown.click();


			Logger.info("'" + Adtype + "' Ad type is opened");

			WebElement PageTypeDropDown = driver.findElement(By.xpath("//div[normalize-space()='"+Pagetype+"']/i"));//swagata
			wait.until(ExpectedConditions.elementToBeClickable(PageTypeDropDown));//swagata
			PageTypeDropDown.click();



			Logger.info("'" + Pagetype + "' Page Type is opened");

			WebElement WeightDropDown = driver.findElement(By.xpath("//div[normalize-space()='"+Weight+"']/i"));
			wait.until(ExpectedConditions.elementToBeClickable(WeightDropDown));//swagata
			WeightDropDown.click();


			Logger.info("'" + Weight + "' Weight is opened");

			WebElement preprintDropDown = driver.findElement(By.xpath("//div[normalize-space()='"+properties.getProperty(preprintType)+"']/i"));//swagata
			wait.until(ExpectedConditions.elementToBeClickable(preprintDropDown));//swagata
			preprintDropDown.click();



			Logger.info("'" + preprintType + "' Preprint Type is opened");

			WebElement value = driver.findElement(By.xpath("//td[normalize-space()='"+minValue+"']"));
			wait.until(ExpectedConditions.elementToBeClickable(value));//swagata
			value.click();


			Logger.info("Default Modifier is opened");



		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new




	public void clickOnTheSectionAvailableAfterExpandingTheProduct(String optionInAttributeTable) {
		try {
			waitUntilElementVisibleSmall(sectionAvailableAfterExpandingProduct);
			sectionAvailableAfterExpandingProduct.click();
			Logger.info("Able to clickOn The Section Available After Expanding The Product");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}


	public void clickOnTheMentionedOptionFromSectionInAttributeTableInPricing(String optionInAttributeTable) throws Exception {
		try {
			WebElement optionElementFromSectionInAttributeTableInPricing = driver.findElement(By.xpath("//div[@class='mCSB_container_wrapper mCS_y_hidden mCS_no_scrollbar_y mCS_x_hidden mCS_no_scrollbar_x']/div[@class='mCSB_container']//div[contains(@class,'ng-isolate-scope panel')]//div[@class='ng-scope'][normalize-space()=\""+optionInAttributeTable+"\"]/i"));
			waitUntilElementVisible(optionElementFromSectionInAttributeTableInPricing);
			javascriptClk(driver, optionElementFromSectionInAttributeTableInPricing);
			Thread.sleep(3000);
			Assert.assertTrue(optionElementFromSectionInAttributeTableInPricing.getAttribute("class").contains("chevron-up"));
			Logger.info("Able to click on the option " + optionElementFromSectionInAttributeTableInPricing + " from Section in Attribute Table in Pricing");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void checkIfTheNrOfDatasInExpandedOptionMatchesWithTheNrOfDatasNotedFromProductSection(
			List<String> checkedDaysNames) {
		try {
			Assert.assertTrue(datasForSelectedOptionFromTheAttributeTable.size()>0);
			Assert.assertEquals(checkedDaysNames.size(), datasForSelectedOptionFromTheAttributeTable.size());
			Logger.info("The number of datas in expanded option matches with the number of datas noted from the product section");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void checkIfDatasInExpandedOptionMatchesWithTheDatasNotedFromProductSection(List<String> checkedDaysNames) {
		try {
			for(String checkedDayName: checkedDaysNames){
				WebElement checkedDayElementInProductSection = driver.findElement(By.xpath("//div[contains(@id,'accordiongroup')][.//i[contains(@class,'chevron-up')]]/following-sibling::div[contains(@id,'accordiongroup')]//table/tbody/tr/td[normalize-space()=\""+checkedDayName+"\"]"));
				waitUntilElementVisible(checkedDayElementInProductSection);
			}
			Logger.info("The Datas In Expanded Option Matches with the Datas noted from the Product Section");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void checkIfAbleToExpandProductProperly(String linkAvailableAfterExpandingProduct) {
		try {
			int i = 0;
			boolean boolFound = false;
			WebElement attributeTableOptionLink = driver.findElement(By.xpath("//*[normalize-space()=\""+linkAvailableAfterExpandingProduct+"\"]"));
			do {
				try {
					waitUntilElementVisible(attributeTableOptionLink);
					boolFound = true;
				} catch (NoSuchElementException e) {
					i++;
				}
				if(boolFound==true){
					break;
				}
			} while (i<60);
			Assert.assertEquals(true, boolFound);
			Logger.info("Able to expand the Product properly");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public List<String> noteTheNamesOfTheCheckboxesWhichAreCheckedInTheRecurenceTab() {
		try {
			ArrayList<String> checkedDaysNames = new ArrayList<>();
			for(WebElement dayInRecurrenceTab : daysListInRecurrenceTab){
				if(dayInRecurrenceTab.isSelected()){
					waitUntilElementVisible(dayInReferenceCheckboxText(dayInRecurrenceTab));
					checkedDaysNames.add(dayInReferenceCheckboxText(dayInRecurrenceTab).getText().trim());
				}
			}
			Assert.assertTrue(checkedDaysNames.size()>0);
			Logger.info("Able to note the names of the checkboxes which are checked in the Recurrence tab");
			return checkedDaysNames;
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void checkIfOnlytheCheckedDaysInProductAreShowingInPricing(
			List<String> checkedCheckboxesNamesInRecurrenceTab) {
		try {
			for(String checkedDayName: checkedCheckboxesNamesInRecurrenceTab){
				WebElement checkedDayElementInProductSection = driver.findElement(By.xpath("//div[contains(@id,'accordiongroup')][.//i[contains(@class,'chevron-up')]]/following-sibling::div[contains(@id,'accordiongroup')]//table/tbody/tr/td[normalize-space()=\""+checkedDayName+"\"]"));
				waitUntilElementVisible(checkedDayElementInProductSection);
			}
			Logger.info("Only the  checked days in Product are showing in Pricing");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnTheMentionedOptionToExpandFromAdOrdersOptions(String optionTextToExpandFromAdOrdersOptions) {
		try {
			WebElement optionToExpandFromAdOrdersOptions = driver.findElement(By.xpath("//nav[@class='navi clearfix ng-scope']/ul[@class='nav ng-scope']/li[not(@class) or @class=''][.//span[text()=\""+optionTextToExpandFromAdOrdersOptions+"\"]]/a/span[contains(@class,'pull-right')]/i[contains(@class,'fa-angle-right text')]"));
			waitUntilElementVisible(optionToExpandFromAdOrdersOptions);
			javascriptClk(driver, optionToExpandFromAdOrdersOptions);
			Logger.info("Able to click on the option " + optionTextToExpandFromAdOrdersOptions + " from Ad Orders Options");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnTheMentionedSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions(
			String subOptionToClickAfterExpandingOptionFromAdOrdersOptions, String optionToExpandFromAdOrdersOptions) {
		try {
			WebElement subOptionTextElementAfterExpandingMentionedOptionFromAdOrdersOptions = driver.findElement(By.xpath("//nav[@class='navi clearfix ng-scope']/ul[@class='nav ng-scope']/li[@class='active'][.//span[text()=\""+optionToExpandFromAdOrdersOptions+"\"]]/ul[@class='nav nav-sub dk']/li[@ui-sref-active='active'][.//span[text()=\""+subOptionToClickAfterExpandingOptionFromAdOrdersOptions+"\"]]//i[contains(@class,'fa-angle-right')]"));
			waitUntilElementVisible(subOptionTextElementAfterExpandingMentionedOptionFromAdOrdersOptions);
			subOptionTextElementAfterExpandingMentionedOptionFromAdOrdersOptions.click();
			Logger.info("Able to click on the sub option " + subOptionToClickAfterExpandingOptionFromAdOrdersOptions + " after expanding the option " + optionToExpandFromAdOrdersOptions + " from Ad Orders options");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnAddBtnInGeneralSettingsSubModulePage() {
		try {
			waitUntilElementVisible(addBtnInClassifiedPkg);
			addBtnInClassifiedPkg.click();
			Logger.info("Able to click on the Add button in Classified Package Page");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void chooseTheMentionedOptionFromTheMentionedDropdownInGeneralSettingsSubModulePgPopUp(
			String dropdownOptionToChooseInGeneralSettingsSubModulePgPopUp, String dropdownInClassifiedPkgPopUp) {
		try {
			WebElement dropdownElementInGeneralSettingsSubModulePgPopUp = driver.findElement(By.xpath("//div[@class='form-group']/label[@for][normalize-space()=\""+dropdownInClassifiedPkgPopUp+"\"]/following-sibling::select[contains(@class,'form-control')]"));
			waitUntilElementVisible(dropdownElementInGeneralSettingsSubModulePgPopUp);
			Select select = new Select(dropdownElementInGeneralSettingsSubModulePgPopUp);
			select.selectByVisibleText(dropdownOptionToChooseInGeneralSettingsSubModulePgPopUp);
			String selectedDropdownOption = select.getFirstSelectedOption().getText().trim();
			Assert.assertEquals(dropdownOptionToChooseInGeneralSettingsSubModulePgPopUp, selectedDropdownOption);
			Logger.info("Able to choose the option " + dropdownOptionToChooseInGeneralSettingsSubModulePgPopUp + " from the dropdown " + dropdownInClassifiedPkgPopUp);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnTheMentionedLinkAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions(
			String linkToClkAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions,
			String optionToExpandFromAdOrdersOptions) {
		try {
			WebElement linkElementAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions = driver.findElement(By.xpath("//nav[@class='navi clearfix ng-scope']/ul[@class='nav ng-scope']/li[@class='active'][.//span[text()=\""+optionToExpandFromAdOrdersOptions+"\"]]/ul[@class='nav nav-sub dk']/li[@class='active']//ul[contains(@class,'nav dker ulNestedLevel')]/li[@ui-sref-active='active']//span[text()=\""+linkToClkAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions+"\"]"));
			waitUntilElementVisible(linkElementAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions);
			linkElementAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions.click();
			Logger.info("Able to click on the link " + linkToClkAfterClickingOnSubOptionAfterExpandingMentionedOptionFromAdOrdersOptions + " after clicking on sub-option after expanding option " + optionToExpandFromAdOrdersOptions + " from Ad Orders option");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void enterTheMentionedTextInTheMetionedInputFieldInGeneralSettingsSubModulePgPopUp(String textToEnter,
			String inputFieldGeneralSettingsSubModulePgPopUp) {
		try {
			WebElement inputFieldElementInGeneralSettingsSubModulePgPopUp = driver.findElement(By.xpath("//div[@class='form-group']/label[@for][normalize-space()=\""+inputFieldGeneralSettingsSubModulePgPopUp+"\"]/following-sibling::input[@type='text']"));
			waitUntilElementVisible(inputFieldElementInGeneralSettingsSubModulePgPopUp);
			inputFieldElementInGeneralSettingsSubModulePgPopUp.sendKeys(textToEnter);
			Assert.assertEquals(inputFieldElementInGeneralSettingsSubModulePgPopUp.getAttribute("value").trim(), textToEnter.trim());
			Logger.info("Able to enter text as " + textToEnter + " in the input field " + inputFieldGeneralSettingsSubModulePgPopUp + " in Classified Package PopUp");
		} catch (Exception e) {
			Logger.info(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnAddBtnInGeneralSettingsSubModulePgPopUp() {
		try {
			waitUntilElementVisible(addBtnInClassifiedPkgPopUp);
			addBtnInClassifiedPkgPopUp.click();
			Logger.info("Able to click on the Add button in Classified Package Page PopUp");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void doubleClickOnTheHeadingOptionInTableInGeneralSettingsSubModulePgPopUpAndChooseTheMentionedOption(
			String headingOptiontoDoubleClickInTableInGeneralSettingsSubModulePgPopUp,
			String dropdownOptionToChooseForSpecificHeadingInTableInGeneralSettingsSubModulePgPopUp) {
		try {
			WebElement headingOptionElementInTableInGeneralSettingsSubModulePgPopUp = driver.findElement(By.xpath("//div[contains(@class,'ui-grid-render-container-body')]/div[@class='ui-grid-viewport ng-isolate-scope']/div[@class='ui-grid-canvas']//div[@ng-style='rowStyle'][count(//div[contains(@class,'ui-grid-render-container-body')]/div[@class='ui-grid-header ng-scope']//div[contains(@class,'ui-grid-clearfix')][.//span[contains(@class,'ng-binding')][text()=\""+headingOptiontoDoubleClickInTableInGeneralSettingsSubModulePgPopUp+"\"]]/preceding-sibling::div[contains(@class,'ui-grid-clearfix')])+1]"));
			waitUntilElementVisible(headingOptionElementInTableInGeneralSettingsSubModulePgPopUp);
			Actions actions = new Actions(driver);
			actions.moveToElement(headingOptionElementInTableInGeneralSettingsSubModulePgPopUp).doubleClick().build().perform();
			waitUntilElementVisible(dropdownOptionAfterDoubleClkInSpcfcHeadingInGeneralSettingsSubModulePgPopUp);
			Select select = new Select(dropdownOptionAfterDoubleClkInSpcfcHeadingInGeneralSettingsSubModulePgPopUp);
			select.selectByVisibleText(dropdownOptionToChooseForSpecificHeadingInTableInGeneralSettingsSubModulePgPopUp);
			actions.sendKeys(Keys.ENTER).build().perform();
			Assert.assertEquals(dropdownOptionToChooseForSpecificHeadingInTableInGeneralSettingsSubModulePgPopUp.trim(), headingOptionElementInTableInGeneralSettingsSubModulePgPopUp.getText().trim());
			Logger.info("Able to double click on the heading option " + headingOptiontoDoubleClickInTableInGeneralSettingsSubModulePgPopUp + " in table in Classified Package Pop-Up and choose the option " + dropdownOptionToChooseForSpecificHeadingInTableInGeneralSettingsSubModulePgPopUp);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void checkTheMentionedCheckboxInTableInClassifiedPkgPopUp(
			String checkboxHeadingInTableInClassifiedPkgPopUp) {
		try {
			WebElement checkboxUnderSpecifiedHeadingElementInTableInClassifiedPkgPopUp = driver.findElement(By.xpath("//div[contains(@class,'ui-grid-render-container-body')]/div[@class='ui-grid-viewport ng-isolate-scope']/div[@class='ui-grid-canvas']//div[@ng-style='rowStyle'][count(//div[contains(@class,'ui-grid-render-container-body')]/div[@class='ui-grid-header ng-scope']//div[contains(@class,'ui-grid-clearfix')][.//span[contains(@class,'ng-binding')][text()=\""+checkboxHeadingInTableInClassifiedPkgPopUp+"\"]]/preceding-sibling::div[contains(@class,'ui-grid-clearfix')])+1]//input[@type='checkbox']"));
			waitUntilElementVisible(checkboxUnderSpecifiedHeadingElementInTableInClassifiedPkgPopUp);
			Assert.assertFalse(checkboxUnderSpecifiedHeadingElementInTableInClassifiedPkgPopUp.isSelected());
			checkboxUnderSpecifiedHeadingElementInTableInClassifiedPkgPopUp.click();
			Assert.assertTrue(checkboxUnderSpecifiedHeadingElementInTableInClassifiedPkgPopUp.isSelected());
			Logger.info("Able to check the checkbox under heading " + checkboxHeadingInTableInClassifiedPkgPopUp + " in Table in Classified Package Pop-Up");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnTheMentionedBtnInGeneralSettingsSubModulePgPopUp(String btnToClkInClassifiedPkgPopUp) {
		try {
			WebElement btnElementInClassifiedPkgPopUp = driver.findElement(By.xpath("//div[@class='modal-footer']/button[contains(@id,'btn')][text()=\""+btnToClkInClassifiedPkgPopUp+"\"]"));
			waitUntilElementVisible(btnElementInClassifiedPkgPopUp);
			javascriptClk(driver, btnElementInClassifiedPkgPopUp);
			Logger.info("Able to click on the " + btnToClkInClassifiedPkgPopUp + " button in General Settings Sub-Module Pop-Up");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void checkIfSuccessMsgAppears() {
		try {
			waitUntilElementVisible(successMsg);
			Logger.info("The Success Message appears");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void chooseTheMentionedDropdownOptionAsTheMentionedTextInGeneralSettingsSubModulePg(String dropdownInClassifiedPkg,
			String dropdownOptionInClassifiedPkgPgDropdown) {
		try {
			WebElement dropdownInClassifiedPkgPg = driver.findElement(By.xpath("//div[@class='panel-body']//label[@class='control-label'][text()=\""+dropdownInClassifiedPkg+"\"]/following-sibling::select[contains(@class,'form-control')]"));
			Select select = new Select(dropdownInClassifiedPkgPg);
			select.selectByVisibleText(dropdownOptionInClassifiedPkgPgDropdown);
			Assert.assertEquals(dropdownOptionInClassifiedPkgPgDropdown.trim(), select.getFirstSelectedOption().getText().trim());
			Logger.info("Able to choose the dropdown " + dropdownInClassifiedPkg + " option as " + dropdownOptionInClassifiedPkgPgDropdown + " in Classified Package Page");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void searchForTheSameTypedNameInClassifiedPkgTblUnderMentionedHeading(String inputFieldInClassifiedPkgPopUp,
			String textToEnter) {
		try {
			WebElement searchFilterBtnUnderSpecifiedHeadingInClassifiedPkgTbl = driver.findElement(By.xpath("//div[@role='columnheader']/div[@role='button'][contains(@class,'ui-grid-cell-contents')][./span[contains(@class,'ng-binding')][text()=\""+inputFieldInClassifiedPkgPopUp+"\"]]/following-sibling::div[@ui-grid-filter]//button[@type='button']"));
			waitUntilElementVisible(searchFilterBtnUnderSpecifiedHeadingInClassifiedPkgTbl);
			searchFilterBtnUnderSpecifiedHeadingInClassifiedPkgTbl.click();
			waitUntilElementVisible(inputFieldUnderSearchFilterBtnToTypeData);
			inputFieldUnderSearchFilterBtnToTypeData.sendKeys(textToEnter.trim());
			Assert.assertEquals(1, tableDatasBelowClassifiedPkgTbl.size());
			Assert.assertEquals(textToEnter.trim(), tableDatasBelowClassifiedPkgTbl.get(0).getText().trim());
			tableDatasBelowClassifiedPkgTbl.get(0).click();
			Logger.info("Able to search for the earlier same typed name in Classified Package Table under the Heading " + inputFieldInClassifiedPkgPopUp);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void inactivateTheSameSearchedDataInGeneralSettingsSubModuleTbl(String textEntered) {
		try {
			Assert.assertEquals(1, inactivateBtnInClassifiedPkgTbl.size());
			waitUntilElementVisible(inactivateBtnInClassifiedPkgTbl.get(0));
			inactivateBtnInClassifiedPkgTbl.get(0).click();
			waitUntilElementVisible(okBtnInConfirmationMsgPopUp);
			okBtnInConfirmationMsgPopUp.click();
			By searchedData = By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope'][text()=\""+textEntered+"\"]");
			waitUntilElementInvisible(searchedData);//swagata
			Logger.info("Able to inactivate the searched data " + textEntered + " in Classified Package table");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void checkTheCheckboxInGeneralSettingsSubModulePgPopUp(String checkboxInGeneralSettingsSubModulePgPopUp) {
		try {
			WebElement checkboxElementInGeneralSettingsSubModulePgPopUp = driver.findElement(By.xpath("//label[contains(@class,'checkbox-option')][normalize-space()=\""+checkboxInGeneralSettingsSubModulePgPopUp+"\"]/input[@type='checkbox']"));
			javascriptClk(driver, checkboxElementInGeneralSettingsSubModulePgPopUp);
			Assert.assertTrue(checkboxElementInGeneralSettingsSubModulePgPopUp.isSelected());
			Logger.info("Able to check The Checkbix " + checkboxInGeneralSettingsSubModulePgPopUp + " in General Settings Sub Module Page popup");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void uncheckTheEarlierCheckedCheckboxInInGeneralSettingsSubModulePgPopUpAndSaveAndClickOnOK(
			String checkboxInGeneralSettingsSubModulePgPopUp) {
		try {
			uncheckTheEarlierCheckedCheckboxInInGeneralSettingsSubModulePgPopUpAndSave(checkboxInGeneralSettingsSubModulePgPopUp);
			waitUntilElementVisible(okBtnInConfirmationMsgPopUp);
			okBtnInConfirmationMsgPopUp.click();
			Logger.info("Able to uncheck the earlier checked checkbox " + checkboxInGeneralSettingsSubModulePgPopUp + " in the General Settings  Sub-Module Page PopUp, Save and click on OK");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void uncheckTheEarlierCheckedCheckboxInInGeneralSettingsSubModulePgPopUpAndSave(
			String checkboxInGeneralSettingsSubModulePgPopUp) {
		try {
			Assert.assertEquals(1, editBtnInGeneralSettingsSubModulePg.size());
			waitUntilElementVisible(editBtnInGeneralSettingsSubModulePg.get(0));
			editBtnInGeneralSettingsSubModulePg.get(0).click();
			WebElement checkboxElementInGeneralSettingsSubModulePgPopUp = driver.findElement(By.xpath("//label[contains(@class,'checkbox-option')][normalize-space()=\""+checkboxInGeneralSettingsSubModulePgPopUp+"\"]/input[@type='checkbox']"));
			javascriptClk(driver, checkboxElementInGeneralSettingsSubModulePgPopUp);
			Assert.assertFalse(checkboxElementInGeneralSettingsSubModulePgPopUp.isSelected());
			clickOnTheMentionedBtnInGeneralSettingsSubModulePgPopUp("Save");
			Logger.info("Able to uncheck the earlier checked checkbox " + checkboxInGeneralSettingsSubModulePgPopUp + " in the General Settings  Sub-Module Page PopUp and Save");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnTheMentionedBtnInInsertionTbl(String btnNameToClkInInsertionTable) {
		try {
			WebElement btnElementInInSertionTbl = driver.findElement(By.xpath("//div[@class='actions-bar pull-right ng-scope']//button[contains(@class,'btn-default btn-sm')][normalize-space()=\""+btnNameToClkInInsertionTable+"\"]"));
			waitUntilElementVisible(btnElementInInSertionTbl);
			btnElementInInSertionTbl.click();
			waitUntilElementVisible(dropdownMenuAfterClickingOnABtnInInsertionTbl);
			Logger.info("Able to click on the button " + btnNameToClkInInsertionTable + " in the Insertion Table");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnTheMentionedSubOptionAfterClickingOnReqdBtnInInsertionTbl(
			String subOptionToClkFromBtnClickedInInsertionTable, String btnNameToClkInInsertionTable) {
		try {
			WebElement subOptionElementAfterClickingOnReqdBtnInInsertionTbl = driver.findElement(By.xpath("//div[@class='actions-bar pull-right ng-scope']//button[contains(@class,'btn-default btn-sm')][normalize-space()=\""+btnNameToClkInInsertionTable+"\"]/following-sibling::ul[@class='pull-right dropdown-menu']/li[@role='menuitem']/a[text()=\""+subOptionToClkFromBtnClickedInInsertionTable+"\"]"));
			waitUntilElementVisible(subOptionElementAfterClickingOnReqdBtnInInsertionTbl);
			subOptionElementAfterClickingOnReqdBtnInInsertionTbl.click();
			Logger.info("Able to click on the SubOption " + subOptionToClkFromBtnClickedInInsertionTable + " after clicking on the button " + btnNameToClkInInsertionTable + " in Insertion Table");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnTheMentionedPricingOptionInSectionLevel(String pricingOptionInSectionLevel) {
		try {
			WebElement pricigOptionElementInSectionLevel = driver.findElement(By.xpath("//div[contains(@id,'accordiongroup')][.//i[contains(@class,'chevron-up')]]/following-sibling::div[contains(@id,'accordiongroup')]//table/tbody/tr/td[normalize-space()=\""+pricingOptionInSectionLevel+"\"]"));
			waitUntilElementVisible(pricigOptionElementInSectionLevel);
			javascriptClk(driver, pricigOptionElementInSectionLevel);
			Logger.info("Able to click on the pricing option " + pricingOptionInSectionLevel + " in Section Level");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnTheDisplayedPercentageInPricingPg() throws Exception {
		try {
			int i = 0;
			boolean boolFound = false;
			do {
				try {
					waitUntilElementVisible(displayedPercentageInPricingPg);
					javascriptClk(driver, displayedPercentageInPricingPg);
					boolFound = true;
				} catch (StaleElementReferenceException ex) {
					boolFound = false;
					i++;
				}
				if(boolFound==true){
					break;
				}
			} while (i<30);
			Assert.assertEquals(true, boolFound);
			waitUntilElementVisibleSmall(popUpElement);
			Logger.info("Able to click on the Displayed Percentage in Pricing Page");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public String changeTheValueInTheMentionedInputFieldInModifierPopUp(String inputFieldInModifierPopUp) {
		try {
			WebElement inputFieldElementInModifierPopUp = driver.findElement(By.xpath("//div[@class='form-group']/label[@for][normalize-space()=\""+inputFieldInModifierPopUp+"\"]/following-sibling::div[@class='input-group']/input[@type='text']"));
			waitUntilElementVisible(inputFieldElementInModifierPopUp);
			String inputFieldStrInModifierPopUp;
			if(inputFieldElementInModifierPopUp.getAttribute("value").trim().contains("100.0")){
				inputFieldElementInModifierPopUp.clear();
				inputFieldElementInModifierPopUp.sendKeys("50");
				waitUntilElementVisible(percentageSignInModifierValInputField);
				percentageSignInModifierValInputField.click();
				Assert.assertEquals("50.0000", inputFieldElementInModifierPopUp.getAttribute("value").trim());
				inputFieldStrInModifierPopUp = (inputFieldElementInModifierPopUp.getAttribute("value").trim());
				Logger.info("Able to change the value in the Input Field " + inputFieldInModifierPopUp + " in Modifier PopUp");
				return inputFieldStrInModifierPopUp;
			}
			else {
				inputFieldElementInModifierPopUp.clear();
				inputFieldElementInModifierPopUp.sendKeys("80");
				waitUntilElementVisible(percentageSignInModifierValInputField);
				percentageSignInModifierValInputField.click();
				Assert.assertEquals("100.0000", inputFieldElementInModifierPopUp.getAttribute("value").trim());
				inputFieldStrInModifierPopUp = (inputFieldElementInModifierPopUp.getAttribute("value").trim());
				Logger.info("Able to change the value in the Input Field " + inputFieldInModifierPopUp + " in Modifier PopUp");
				return inputFieldStrInModifierPopUp;
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnOkBtnInConfirmationMsgPopUpHighlightedInGreen() {
		try {
			waitUntilElementVisible(okBtnInConfirmationMsgPopUpHighlightedInGreen);
			okBtnInConfirmationMsgPopUpHighlightedInGreen.click();
			Logger.info("Able to click on the Ok button in the ConfirmTION mESSAGE pOPuP highlighted in Green");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void checkIfTheDisplayedPercentageInPricingIsShowingTheChangedPercentage(
			String changedTextInInputFieldInModifierPopUp) throws Exception {
		try {
			Thread.sleep(2500);
			waitUntilElementVisible(displayedPercentageInPricingPg);
			String displayedChangedTextInInputFieldInModifierPopUp = displayedPercentageInPricingPg.getText().trim();
			displayedChangedTextInInputFieldInModifierPopUp = displayedChangedTextInInputFieldInModifierPopUp.substring(0, displayedChangedTextInInputFieldInModifierPopUp.indexOf("%"));
			Assert.assertEquals(displayedChangedTextInInputFieldInModifierPopUp, changedTextInInputFieldInModifierPopUp);
			Logger.info("The Displayed Percentage in Pricing is showing the Changed Percentage " + changedTextInInputFieldInModifierPopUp);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public String noteTheValueShownInTheMentionedInputFieldInModifierPopUp(String inputFieldInModifierPopUp) {
		try {
			WebElement inputFieldElementInModifierPopUp = driver.findElement(By.xpath("//div[@class='form-group']/label[@for][normalize-space()=\""+inputFieldInModifierPopUp+"\"]/following-sibling::div[@class='input-group']/input[@type='text']"));
			waitUntilElementVisible(inputFieldElementInModifierPopUp);
			Assert.assertNotNull(inputFieldElementInModifierPopUp.getAttribute("value").trim());
			Assert.assertNotSame("", inputFieldElementInModifierPopUp.getAttribute("value").trim());
			Logger.info("Able to note the value shown in the Input field " + inputFieldInModifierPopUp + " in Modifier PopUp");
			return (inputFieldElementInModifierPopUp.getAttribute("value").trim());
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnRefreshPgBtnInPriciingPg() {
		try {
			waitUntilElementVisible(refreshBtnInPricingPg);
			javascriptClk(driver, refreshBtnInPricingPg);
			waitUntilElementVisible(successMsgAfterClickingOnRefreshBtnInPricingPg);
			Logger.info("Able to click on the Refresh Page BUtton in Pricing Page");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnTheTableDataForMentionedHeadingInInsertionTable(
			String tableDataToClickForHeadingInInsertionTable) {
		try {
			WebElement tableDataElementForSpecificHeadingInInsertionTable = driver.findElement(By.xpath("//div[@class='insertionInfo table-responsive']/table[@class='table table-bordered ']/tbody[contains(@class,'order-lines')]/tr[@class='overview']/td[count(//div[@class='insertionInfo table-responsive']/table[@class='table table-bordered ']/thead[@class='fixThisHeader']/tr/th[text()=\""+tableDataToClickForHeadingInInsertionTable+"\"]/preceding-sibling::th)+1]//span[not(contains(@class,'input'))][not(@id)]"));
			tableDataElementForSpecificHeadingInInsertionTable.click();
			Logger.info("Able to click on the table data for heading : " + tableDataToClickForHeadingInInsertionTable + " in Insertion Table");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnTheCalendarIconBelowPubDateHeadingInInsertionTbl() {
		try {
			waitUntilElementVisible(calendarIconBelowPubDateHeadingInInsertionTbl);
			calendarIconBelowPubDateHeadingInInsertionTbl.click();
			waitUntilElementVisible(calendarBelowPubDateHeadingInInsertionTbl);
			Logger.info("Able to click on the Calendar Icon Below PubDate Heading in Insertion Table");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void selectTheMentionedIndexedDateForTheSpecifiedDateInCalendarFieldBelowPubDateHeadingInInsertionTbl(int index,
			String dayInCalendarField) {
		try {
			List<WebElement> dateListForTheSpecifiedDateInCalendarFieldBelowPubDateHeadingInInsertionTbl = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr[@class='uib-weeks ng-scope']/td[@class][count(//table[@role='grid']/thead/tr[2]/th[@class='text-center ng-scope'][normalize-space()=\""+dayInCalendarField+"\"]/preceding-sibling::th)+1][not(.//span[contains(@class,'text-muted')])]"));
			Assert.assertTrue(dateListForTheSpecifiedDateInCalendarFieldBelowPubDateHeadingInInsertionTbl.size()>0);
			waitUntilElementVisible(dateListForTheSpecifiedDateInCalendarFieldBelowPubDateHeadingInInsertionTbl.get(index));
			dateListForTheSpecifiedDateInCalendarFieldBelowPubDateHeadingInInsertionTbl.get(index).click();
			Logger.info("Able to select the " + index + " indexed date for the specific date " + dayInCalendarField + " in Calendar field below PubDate heading in Insertion Table");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void selectTheMentionedOptionFromInsertionTblDropdown(String dropdownOptionToChoose, String tableDataToClickForHeadingInInsertionTable) throws Exception {
		try {
			waitUntilElementVisible(dropdownInInsertionTbl);
			Select select = new Select(dropdownInInsertionTbl);
			select.selectByVisibleText(dropdownOptionToChoose);
			WebElement tableDataElementForSpecificHeadingInInsertionTable = driver.findElement(By.xpath("//div[@class='insertionInfo table-responsive']/table[@class='table table-bordered ']/tbody[contains(@class,'order-lines')]/tr[@class='overview']/td[count(//div[@class='insertionInfo table-responsive']/table[@class='table table-bordered ']/thead[@class='fixThisHeader']/tr/th[text()=\""+tableDataToClickForHeadingInInsertionTable+"\"]/preceding-sibling::th)+1]//span[not(contains(@class,'input'))][not(@id)]"));
			try{
				Assert.assertEquals(dropdownOptionToChoose, tableDataElementForSpecificHeadingInInsertionTable.getText().trim());
			}
			catch(NoSuchElementException | AssertionError e){
				driver.findElement(By.xpath("//div[@class='insertionInfo table-responsive']/table[@class='table table-bordered ']/thead[@class='fixThisHeader']/tr/th[text()=\""+tableDataToClickForHeadingInInsertionTable+"\"]")).click();
				Assert.assertEquals(dropdownOptionToChoose, tableDataElementForSpecificHeadingInInsertionTable.getText().trim());
			}
			Logger.info("Able to choose the option " + dropdownOptionToChoose + " from Insertion table dropdown");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void checkIfTheChangedPercentageIsReflectingInPriceDetailsInNewOrderPg(
			String changedTextInInputFieldInModifierPopUp) {
		try {
			String changedTextPercentageInPriceDetailsInNewOrderPg = changedTextInInputFieldInModifierPopUp + " %";
			WebElement changedTextPercentageElementInPriceDetailsInNewOrderPg = driver.findElement(By.xpath("//div[@class='modal-content']//div[@class='ui-grid-row ng-scope']//div[@role='gridcell'][normalize-space()=\"SectionZone\"]/following-sibling::div[@role='gridcell'][normalize-space()=\""+changedTextPercentageInPriceDetailsInNewOrderPg+"\"]"));
			waitUntilElementVisible(changedTextPercentageElementInPriceDetailsInNewOrderPg);
			Logger.info("The changed percentage is reflecting in Price Details in New Order Page");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void clickOnTheMentionedBtnInNewOrderPgPopUp(String btnInNewOrderPgPopUp) {
		try {
			WebElement btnElementInNewOrderPgPopUp = driver.findElement(By.xpath("//div[@class='modal-footer ng-scope']/button[contains(@class,'btn')][text()='"+btnInNewOrderPgPopUp+"']"));
			waitUntilElementVisible(btnElementInNewOrderPgPopUp);
			btnElementInNewOrderPgPopUp.click();
			Logger.info("Able to click on the " + btnInNewOrderPgPopUp + " button in New Order Page PopUp");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void changeTheValueInTheMentionedInputFieldInModifierPopUpToTheOldValue(
			String inputFieldInModifierPopUp, String valShownInInputFieldInModifierPopUp) {
		try {
			WebElement inputFieldElementInModifierPopUp = driver.findElement(By.xpath("//div[@class='form-group']/label[@for][normalize-space()=\""+inputFieldInModifierPopUp+"\"]/following-sibling::div[@class='input-group']/input[@type='text']"));
			waitUntilElementVisible(inputFieldElementInModifierPopUp);
			inputFieldElementInModifierPopUp.clear();
			inputFieldElementInModifierPopUp.sendKeys(valShownInInputFieldInModifierPopUp);
			waitUntilElementVisible(percentageSignInModifierValInputField);
			percentageSignInModifierValInputField.click();
			Assert.assertEquals(valShownInInputFieldInModifierPopUp, inputFieldElementInModifierPopUp.getAttribute("value").trim());
			Logger.info("Able to change the value in the Input Field " + inputFieldInModifierPopUp + " in Modifier PopUp");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void checkIfTheEarlierChangedPercentageIsNotReflectingInPriceDetailsInNewOrderPg(
			String changedTextInInputFieldInModifierPopUp) {
		try {
			String changedTextPercentageInPriceDetailsInNewOrderPg = changedTextInInputFieldInModifierPopUp + " %";
			boolean boolFound = true;
			try{
				WebElement changedTextPercentageElementInPriceDetailsInNewOrderPg = driver.findElement(By.xpath("//div[@class='modal-content']//div[@class='ui-grid-row ng-scope']//div[@role='gridcell'][normalize-space()=\"SectionZone\"]/following-sibling::div[@role='gridcell'][normalize-space()=\""+changedTextPercentageInPriceDetailsInNewOrderPg+"\"]"));
				waitUntilElementVisibleSmall(changedTextPercentageElementInPriceDetailsInNewOrderPg);
				boolFound = true;
			}
			catch (NoSuchElementException e) {
				boolFound = false;
			}
			Assert.assertEquals(false, boolFound);
			Logger.info("The earlier changed percentage " + changedTextInInputFieldInModifierPopUp + " is not reflecting in Price Details in New Order Page");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public void goToTheLastSectionIDUnderTheMentionedHeadingInProductTblAndEnterAValue(String headingInProductTbl) throws Exception {
		try {
			List<WebElement> listOfDatasUnderMentionedHeadingInProductTbl = driver.findElements(By.xpath("//div[@class='ui-grid-contents-wrapper']//div[@class='ui-grid-viewport ng-isolate-scope']//div[contains(@ng-repeat,'rowRenderIndex, row')]//div[contains(@class,'ui-grid-cell ng-scope')][count(//div[@class='ui-grid-contents-wrapper']//div[@class='ui-grid-header ng-scope']//div[contains(@class,'ui-grid-coluiGrid')][.//span[contains(@class,'ui-grid-header-cell-label')][text()=\""+headingInProductTbl+"\"]]/preceding-sibling::div[contains(@class,'ui-grid-coluiGrid')])+1]"));
			Assert.assertTrue(listOfDatasUnderMentionedHeadingInProductTbl.size()>0);
			int j;
			String id = "ID";
			List<WebElement> listOfDatasUnderIDHeadingInProductTbl = driver.findElements(By.xpath("//div[@class='ui-grid-contents-wrapper']//div[@class='ui-grid-viewport ng-isolate-scope']//div[contains(@ng-repeat,'rowRenderIndex, row')]//div[contains(@class,'ui-grid-cell ng-scope')][count(//div[@class='ui-grid-contents-wrapper']//div[@class='ui-grid-header ng-scope']//div[contains(@class,'ui-grid-coluiGrid')][.//span[contains(@class,'ui-grid-header-cell-label')][text()=\""+id+"\"]]/preceding-sibling::div[contains(@class,'ui-grid-coluiGrid')])+1]"));
			do {
				int i = listOfDatasUnderMentionedHeadingInProductTbl.size();
				waitUntilElementVisible(listOfDatasUnderMentionedHeadingInProductTbl.get(i-1));
				scrollToElement(driver, listOfDatasUnderMentionedHeadingInProductTbl.get(i-1));
				j = i-1;
			} while (!(listOfDatasUnderIDHeadingInProductTbl.get(j).getText().trim().equalsIgnoreCase("0")));
			Assert.assertTrue(listOfDatasUnderIDHeadingInProductTbl.get(j).getText().trim().equalsIgnoreCase("0"));
			String dataValForSecondLastMentionedHeadingDataInProductTbl = listOfDatasUnderMentionedHeadingInProductTbl.get(j-1).getText().trim();
			dataValForSecondLastMentionedHeadingDataInProductTbl = dataValForSecondLastMentionedHeadingDataInProductTbl + "1";
			Actions actions = new Actions(driver);
			actions.moveToElement(listOfDatasUnderMentionedHeadingInProductTbl.get(j)).doubleClick().build().perform();
			waitUntilElementVisible(inputInProductTblAftrDoubleClk);
			setClipboardData(dataValForSecondLastMentionedHeadingDataInProductTbl);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Assert.assertEquals(dataValForSecondLastMentionedHeadingDataInProductTbl, listOfDatasUnderMentionedHeadingInProductTbl.get(j).getText().trim());
			Logger.info("Able to go to the last section ID under the heading " + headingInProductTbl + " in product table and successfully able to enter a value");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}
	public void deleteFeesDiscounts() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions
					.elementToBeClickable(deleteFeesDiscountsbtn));

			if(deleteFeesDiscountsbtn.isDisplayed())
			{	
				deleteFeesDiscountsbtn.click();

				Logger.info("Fees/Discounts is deleted");

			}
		}
		catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new
	public void deleteVariableFees() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions
					.elementToBeClickable(deleteVarFeesbtn));

			if(deleteVarFeesbtn.isDisplayed())
			{	
				deleteVarFeesbtn.click();

				Logger.info("Variable Feess is deleted");

			}
		}
		catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void clickOkInConfirmMsg() {  
		try { 
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions
					.elementToBeClickable(okBtnInConfirmationMsgPopUp));
			if(okBtnInConfirmationMsgPopUp.isDisplayed())
			{
				okBtnInConfirmationMsgPopUp.click();

				Logger.info("Ok button is clicked in Confirm Window");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void clickOnAddedFeesDiscounts(String chargeType) throws Exception {
		try {


			WebElement ChargeType = driver.findElement(By.xpath("//span[text()='" + chargeType + " " + "']"));

			ChargeType.click();
			Logger.info("Click on added Fees/Discount");
			Thread.sleep(3000);



		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void scrollToBottomOftheTableUntilTheLastCreatedDataHavingIdAsZeroIsReached(String productTableHeading,
			int nrOfDatasPresentInTheSelectedOptionFromTheAttributeTable) {
		try {
		List<WebElement> nrOfDatasInAdTypeTable = driver.findElements(By.xpath("//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-canvas']/div[contains(@class,'ui-grid-row ng-scope')]//div[contains(@ng-class,'ui-grid-row-header-cell')][count(//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-header-cell-wrapper']//div[@render-index='$index'][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\""+productTableHeading+"\"]]/preceding-sibling::div[@render-index='$index'])+1]"));
		Assert.assertTrue(nrOfDatasInAdTypeTable.size()>0);
		do {
			scrollToElement(driver, nrOfDatasInAdTypeTable.get(nrOfDatasInAdTypeTable.size()-1));
			nrOfDatasInAdTypeTable = driver.findElements(By.xpath("//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-canvas']/div[contains(@class,'ui-grid-row ng-scope')]//div[contains(@ng-class,'ui-grid-row-header-cell')][count(//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-header-cell-wrapper']//div[@render-index='$index'][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\""+productTableHeading+"\"]]/preceding-sibling::div[@render-index='$index'])+1]"));
			Assert.assertTrue(nrOfDatasInAdTypeTable.size()>0);
		} while (!(nrOfDatasInAdTypeTable.get(nrOfDatasInAdTypeTable.size()-1).getText().trim().equalsIgnoreCase("0")));
		Assert.assertEquals("0", nrOfDatasInAdTypeTable.get(nrOfDatasInAdTypeTable.size()-1).getText().trim());
		Logger.info("Able to scroll to the bottom of the table until the last created data having Id as Zero is reached");
	} catch (Exception e) {
		Logger.error(e.getMessage());
		throw e;
	}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
}

	public String noteTheValueOfTheSecondLastDataInTheTable(String productTableHeading) throws Exception {
		try {
			List<WebElement> nrOfDatasInAdTypeTable = driver.findElements(By.xpath("//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-canvas']/div[contains(@class,'ui-grid-row ng-scope')]//div[contains(@ng-class,'ui-grid-row-header-cell')][count(//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-header-cell-wrapper']//div[@render-index='$index'][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\""+productTableHeading+"\"]]/preceding-sibling::div[@render-index='$index'])+1]"));
			/*scrollToElement(driver, nrOfDatasInAdTypeTable.get(nrOfDatasInAdTypeTable.size()-2));*/
			String dataToNote;
			try{
			dataToNote = nrOfDatasInAdTypeTable.get(nrOfDatasInAdTypeTable.size()-2).getText().trim();
			}
			catch (StaleElementReferenceException e) {
				Thread.sleep(5000);
				dataToNote = nrOfDatasInAdTypeTable.get(nrOfDatasInAdTypeTable.size()-2).getText().trim();
			}
			Assert.assertNotNull(dataToNote);
			Assert.assertFalse(dataToNote.trim().equalsIgnoreCase(""));
			Logger.info("Able to note the value if the Second last data in the table");
			return dataToNote;
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
		
	}

	public String checkIfTheNewIdIsGeneratedAndNoteTheId(String productTableHeading, String tblDataVal) {
		try {
			List<WebElement> nrOfDatasInAdTypeTable = driver.findElements(By.xpath("//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-canvas']/div[contains(@class,'ui-grid-row ng-scope')]//div[contains(@ng-class,'ui-grid-row-header-cell')][count(//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-header-cell-wrapper']//div[@render-index='$index'][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\""+productTableHeading+"\"]]/preceding-sibling::div[@render-index='$index'])+1]"));
			Assert.assertTrue(nrOfDatasInAdTypeTable.size()>0);
			do {
				scrollToElement(driver, nrOfDatasInAdTypeTable.get(nrOfDatasInAdTypeTable.size()-1));
				nrOfDatasInAdTypeTable = driver.findElements(By.xpath("//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-canvas']/div[contains(@class,'ui-grid-row ng-scope')]//div[contains(@ng-class,'ui-grid-row-header-cell')][count(//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-header-cell-wrapper']//div[@render-index='$index'][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\""+productTableHeading+"\"]]/preceding-sibling::div[@render-index='$index'])+1]"));
				Assert.assertTrue(nrOfDatasInAdTypeTable.size()>0);
			} while (!(nrOfDatasInAdTypeTable.get(nrOfDatasInAdTypeTable.size()-2).getText().trim().equalsIgnoreCase(tblDataVal)));
			Assert.assertEquals(tblDataVal, nrOfDatasInAdTypeTable.get(nrOfDatasInAdTypeTable.size()-2).getText().trim());
			String newTblData = nrOfDatasInAdTypeTable.get(nrOfDatasInAdTypeTable.size()-1).getText().trim();
			Logger.info("data is " + newTblData);
			Assert.assertNotNull(newTblData);
			Assert.assertFalse(newTblData.trim().equalsIgnoreCase(""));
			Logger.info("New data generated is " + newTblData);
			return newTblData;
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void scrollToBottomOftheTableUntilTheLatestCreatedIdIsReached(String productTableHeading,
			String newDataCreated) {
		try {
			List<WebElement> nrOfDatasInAdTypeTable = driver.findElements(By.xpath("//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-canvas']/div[contains(@class,'ui-grid-row ng-scope')]//div[contains(@ng-class,'ui-grid-row-header-cell')][count(//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-header-cell-wrapper']//div[@render-index='$index'][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\""+productTableHeading+"\"]]/preceding-sibling::div[@render-index='$index'])+1]"));
			Assert.assertTrue(nrOfDatasInAdTypeTable.size()>0);
			do {
				scrollToElement(driver, nrOfDatasInAdTypeTable.get(nrOfDatasInAdTypeTable.size()-1));
				nrOfDatasInAdTypeTable = driver.findElements(By.xpath("//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-canvas']/div[contains(@class,'ui-grid-row ng-scope')]//div[contains(@ng-class,'ui-grid-row-header-cell')][count(//div[contains(@class,'ui-grid-render-container-body')]//div[@class='ui-grid-header-cell-wrapper']//div[@render-index='$index'][.//span[@class='ui-grid-header-cell-label ng-binding'][text()=\""+productTableHeading+"\"]]/preceding-sibling::div[@render-index='$index'])+1]"));
				Assert.assertTrue(nrOfDatasInAdTypeTable.size()>0);
			} while (!(nrOfDatasInAdTypeTable.get(nrOfDatasInAdTypeTable.size()-1).getText().trim().equalsIgnoreCase(newDataCreated)));
			Assert.assertEquals(newDataCreated, nrOfDatasInAdTypeTable.get(nrOfDatasInAdTypeTable.size()-1).getText().trim());
			Logger.info("Able to scroll to the bottom of the table until the latest created Id is reached");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnNewlyAddedPageTypeCount(String pageTypeOption ) {
	
			try{
				 WebElement newLine = driver.findElement(By.xpath("//div[@class='ui-grid-viewport ng-isolate-scope'][@style='overflow: auto scroll;']//div[@role='row']//div[text()=\""+pageTypeOption+"\"]"));
			 /* List<WebElement> newLine = driver.findElements(By.xpath("//div[@class='ui-grid-viewport ng-isolate-scope'][@style='overflow: auto scroll;']//div[@class='ui-grid-canvas']"));

				 Logger.info("Size is:"+newLine.size());
           	  for(int i=0;i<newLine.size();i++){
           		 WebElement orderUpdate =newLine.get(i);
           		orderUpdate.click();
           		javascriptClk(driver, ele.get(ele.Size()-1));
           		
           		  }*/
				javascriptClk(driver,newLine );

  				
				
				Logger.info("Able to expand the latest Product Table Block Add button if present and collapsed");
	
			}

		 catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		
	}
	}//swagata

}
