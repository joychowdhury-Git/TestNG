package com.tribune.adit2.ProductAdmin;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

import junit.framework.Assert;

/**
 * Page Class Modeling for Product Admin Page
 * 
 * @author rrath
 * @since Jan 2018
 */

public class ProductAdminPage {
	@FindBy(id = "btnProductSaveDetails")
	private WebElement btnProductSave;

	@FindBy(xpath = "//a[contains(text(),'Save')]")
	private WebElement btnBuSave;

	@FindBy(xpath = "//*[@id='Select_ProducType']")
	private WebElement productTypeDropDown;

	@FindBy(xpath = "//*[@id='app']/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/ul/li[16]/a")
	private WebElement FinanceTab;

	@FindBy(xpath = "//*[@id='app']/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/ul/li[1]/a")
	private WebElement GeneralInfoTab;

	@FindBy(xpath = "//*[@id='A2']")
	private WebElement btnSectionSave;

	@FindBy(xpath = "//*[@id='btnSubsectionSaveDetails']")
	private WebElement btnSubSectionSave;

	@FindBy(xpath = "//button[text()='OK']/../../div[3]/button")
	private WebElement ClickOk;

	@FindBy(xpath = "//span[text()='CTC-CTMG']/../../../li[2]/a/button/span")
	private WebElement ProductCaret;

	@FindBy(xpath = "//*[@id='bu-42']/ul/li[1]")
	private WebElement AddProduct;

	@FindBy(xpath = "//*[@id='bu_Name']")
	private WebElement ProductNameTextBox;


	@FindBy(xpath ="//a[text()='Miscellaneous']")
	private WebElement MiscellaneousTab;


	@FindBy(xpath = "//*[@id='i-productAdmin-bu-42']")
	private WebElement ExpandBU;


	@FindBy(xpath ="//a[text()='Ad Size Assignment']")
	private WebElement AdSizeAssignmentTab;

	@FindBy(xpath = "//*[@id='i-productAdmin-producttype-7']")
	private WebElement ExpandProduct;


	@FindBy(xpath = "//select[@id='column_model']")
	private WebElement ColumnModelDropdown;

	@FindBy(xpath = "//*[@id='section_Name']")
	private WebElement SectionName;

	@FindBy(xpath = "//*[@id='subsection_Name']")
	private WebElement SubSectionName;
	@FindBy(xpath = "//a[text()='Active Days of Week']")
	private WebElement selectActiveDaysofWeekTab;

	@FindBy(xpath = "//a[text()='Recurrence']")
	private WebElement selectRecurrenceTab;

	@FindBy(xpath = "//a[text()='Position Management']")
	private WebElement SelectPositionManagementTab;

	@FindBy(xpath = "//a[text()='Ad Type Management']")
	private WebElement SelectAdTypeManagementTab;


	@FindBy(xpath = "//a[text()='Position Assignment']")
	private WebElement selectPositionAssignmentTab;

	@FindBy(xpath = "//*[@id='btn_Position_Management']")
	private WebElement AddPositionButton;

	@FindBy(xpath = "//*[@id='i-productAdmin-producttype-4']")
	private WebElement ExpandProductTypeClassifiedListing; // arka

	@FindBy(xpath = "//*[@id='i-productAdmin-product-204']")
	private WebElement ExpandProductChicagoTribune; // arka

	@FindBy(xpath = "//*[@id='section-2499']/span")
	private WebElement ExpandSectionDeathNotices;// arka

	@FindBy(xpath = "//*[@id='app']/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/ul/li[9]/a")
	private WebElement ExpandSectionClassifiedFont;// arka

	@FindBy(xpath = "//*[@id='A1']/i[@class='fa fa-plus']")
	private WebElement ExpandSectionClassifiedFontAddButton;// arka


	@FindBy(xpath = "//div[@class='ui-grid-header-cell-wrapper']//*[@ng-class='headerButtonClass()']")
	private WebElement adSizeManagementExp;

	@FindBy(xpath = "//div[@class='ui-grid-cell-contents']//*[@ng-class='headerButtonClass()']")
	private WebElement adSizeAssignmentExp;

	//@FindBy(xpath = "//*[@id='1561447990923-grid-container']/div[2]")
	//private WebElement ExpandSectionClassifiedNewFontSection;// arka

	@FindBy(xpath = "(//span[text()='Name'])[1]")
	private WebElement ExpandSectionClassifiedFontNameButton;// arka

	@FindBy(xpath = "//a[text()='Auto Insertion Management']")
	private WebElement AutoInsertionManagementTab;


	@FindBy(xpath = "//*[@id='Button3']")
	private WebElement Addbutton;

	@FindBy(xpath = "//*[text()='AbcdTest']")
	private WebElement ExpandSectionClassifiedAddFontName;// arka

	@FindBy(xpath = "//*[@id='Min_Sales_Price']")
	private WebElement MinSalesPrice;

	@FindBy(xpath = "//*[@id='btnOk']")
	private WebElement ExpandSectionClassifiedAddFontOKBtn;// arka

	@FindBy(xpath = "//*[@id='Text1']")
	private WebElement Percentage;

	@FindBy(xpath = "//*[@id='btnOkTemplate']")
	private WebElement okbutton;
	@FindBy(xpath = "//*[@id='btnCancel']")
	private WebElement cancelbutton;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id='Button4']")
	private WebElement editButton;

	@FindBy (xpath="//*[@id='Button5']")
	private WebElement removeButton;

	@FindBy (xpath="//input[@id='Digital_Services_Product']")
	private WebElement DigitalServicesProductCheckBox;

	@FindBy (xpath="//a[text()='Product Types']")
	private WebElement ProductTypesTab;


	@FindBy (xpath="//h4[@class='panel-title']//*[@ng-click='openGeneralAccordion(IsGeneralAccordionOpen)']/i")
	private WebElement GeneralInfo;

	@FindBy (xpath="//h4[@class='panel-title']//*[@ng-click='loadBUAdSizes(IsAdSizeAccordionOpen)']/i")
	private WebElement AdSizeManagement ;

	//@FindBy(xpath="(//*[contains(text(),'AD Space')]/../../../..//*[contains(text(),' ')])[2]")
	@FindBy(xpath="//*[text()='A D Type']/../../../../../../../../../../div[2]/div/div[2]/div/div[2]/div")
	private WebElement AdSizeManagementColName ;

	@FindBy(xpath = "//*[@id='Text2']")
	private WebElement BUNameTextBox ;


	@FindBy(xpath = "//*[@id='btnProductSaveDetails']")
	private WebElement ExpandSectionClassifiedAddFontSaveBtn;// arka

	@FindBy(xpath = "//*[@id='Text3']")
	private WebElement abbreviationTextBox ;

	@FindBy(xpath="//div[text()=\"Success!\"]")
	public WebElement successMsg;//swagata
	@FindBy(xpath="//div[contains(text(),'Validation failed: One or more order types must be specified')]")
	public WebElement alertMsg;//swagata
	//@FindBy(xpath= "(//select[@id='orderTypesId']//following::button)[1]" )
	@FindBy(xpath= "//label[contains(text(),'Matched Order Types:')]//following::button[1]" )
	public WebElement OrderTypeDropDown;//swagata
	@FindBy(xpath= "//input[@placeholder='Search']" )
	public WebElement OrderTypeSearchBox;//swagata



	public void waitUntilElementVisible(WebElement webElement) {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(webElement));

	}//swagata

	private WebDriver driver;

	Properties properties = TribuneUtils.readProperties();
	TribuneUtils utils = new TribuneUtils();

	public void clickExpandProductTypeClassifiedListing() throws Exception {
		try {

			Actions action = new Actions(driver);
			action.moveToElement(ExpandProductTypeClassifiedListing).click().build().perform();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// arka

	public void clickExpandProductChicagoTribune() throws Exception {
		try {

			Actions action = new Actions(driver);
			action.moveToElement(ExpandProductChicagoTribune).click().build().perform();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// arka

	public void clickExpandSectionDeathNotices() throws Exception {
		try {

			Actions action = new Actions(driver);
			action.moveToElement(ExpandSectionDeathNotices).click().build().perform();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// arka

	public void clickExpandSectionClassifiedFont() throws Exception {
		try {

			Actions action = new Actions(driver);
			action.moveToElement(ExpandSectionClassifiedFont).click().build().perform();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// arka
	public void clickExpandSectionClassifiedFontRemoveButton() throws Exception {
		try {
			driver.findElement(By.xpath("//div[text()='AbcdTest']")).click();
			driver.findElement(By.xpath("//*[text()=' Remove']")).click();
			Logger.info("Font is removed");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickExpandSectionClassifiedFontAddButton() throws Exception {
		try {

			Actions action = new Actions(driver);
			action.moveToElement(ExpandSectionClassifiedFontAddButton).click().build().perform();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// arka

	/*public void clickExpandSectionClassifiedNewFontSection() throws Exception {
		try {

			Actions action = new Actions(driver);
			action.moveToElement(ExpandSectionClassifiedNewFontSection).click().build().perform();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// arka*/

	public void clickExpandSectionClassifiedAddFontName() throws Exception {
		try {
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			// This will scroll the page till the element is found
			//js.executeScript("window.scrollTo(0, 400)");
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ExpandSectionClassifiedAddFontName);
			ExpandSectionClassifiedFontNameButton.click();
			ExpandSectionClassifiedAddFontName.click();

		} catch (

				Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// arka

	public void clickExpandSectionClassifiedAddFontOKBtn() throws Exception {
		try {

			Actions action = new Actions(driver);
			action.moveToElement(ExpandSectionClassifiedAddFontOKBtn).click().build().perform();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// arka

	public void clickExpandSectionClassifiedAddFontSaveBtn() throws Exception {
		try {

			Actions action = new Actions(driver);
			action.moveToElement(ExpandSectionClassifiedAddFontSaveBtn).click().build().perform();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// arka

	public ProductAdminPage(WebDriver driver) {
		this.driver = driver;
	}

	public void save() throws Exception {
		try {
			btnBuSave.click();//swagata

			//utils.clickWebElement(btnBuSave);
			Thread.sleep(15000);
			/* utils.implementWait(driver); */
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @description This method is used to click on BU caret arrow
	 * @author rrath
	 * @param BU
	 *            name
	 */
	public void clickBuExpand(String buName) throws Exception //swagata new
	{
		try {
			WebElement buCaret = driver
					.findElement(By.xpath("//li[@ng-repeat='bu in BUdata']/a/span[text()='" + buName + "']/../i"));
			utils.clickWebElement(buCaret);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @description This method is used to click on BU Link
	 * @author rrath
	 * @param BU
	 *            name
	 */
	public void clickBuLink(String buName) throws Exception {
		try {
			WebElement buLink = driver
					.findElement(By.xpath("//li[@ng-repeat='bu in BUdata']/a/span[text()='" + buName + "']"));
			utils.clickWebElement(buLink);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**.
	 * This method is used to click on the caret arrows to reach the required product


	/**
	 * . This method is used to click on the caret arrows to reach the required
	 * product
	 * 
	 * @param buName
	 * @param prodType
	 * @param prodLoc
	 * @param prodName
	 * @throws Exception
	 */
	public void clickSection(String buName, String prodType, String prodLoc, String prodName) throws Exception {
		try {
			String xPath = "//li[@ng-repeat='bu in BUdata']/a/span[text()='" + buName + "']/../i";
			WebElement buCaret = driver.findElement(By.xpath(xPath));

			utils.clickWebElement(buCaret); 

			xPath = xPath+"/../../ul/li//span[text()='"+prodType+"']/../i";

			utils.clickWebElement(buCaret);

			xPath = xPath + "/../../ul/li//span[text()='" + prodType + "']/../i";
			WebElement prodTypeCaret = driver.findElement(By.xpath(xPath));
			utils.clickWebElement(prodTypeCaret);

			xPath = xPath+"/../../ul/li//span[text()='"+prodLoc+"']/../i";


			xPath = xPath + "/../../ul/li//span[text()='" + prodLoc + "']/../i";
			WebElement prodLocCaret = driver.findElement(By.xpath(xPath));
			utils.clickWebElement(prodLocCaret);

			xPath = xPath+"/../../ul/li/a/span[text()='"+prodName+"']";


			xPath = xPath + "/../../ul/li/a/span[text()='" + prodName + "']";
			WebElement product = driver.findElement(By.xpath(xPath));
			utils.clickWebElement(product);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void addBusinessUnit(String buName) throws Exception {
		try {
			utils.clickWebElement(driver.findElement(By.xpath("//*[@id='A1']/button")));
			WebElement buAddLink = driver.findElement(By
					.xpath("//ul[@class='pull-right dropdown-menu padder']/li/i[contains(text(),'AddBusinessUnit')]"));
			utils.clickWebElement(buAddLink);
			utils.fillText(driver.findElement(By.id("Text2")), buName, true, "New BU Name");
			utils.fillText(driver.findElement(By.id("Text3")), buName, true, "New BU Abbreviation");
			save();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void removeBusinessUnit(String buName) throws Exception {
		try {
			utils.clickWebElement(driver.findElement(By.xpath("//span[text()='" + buName + "']/../button")));
			WebElement buRemoveLink = driver.findElement(By.xpath(
					"//ul[@class='pull-right dropdown-menu padder']/li/i[contains(text(),'Remove BusinessUnit')]"));
			utils.clickWebElement(buRemoveLink);
			WebElement deleteConfirm = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
			utils.clickWebElement(deleteConfirm);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void hideOffline() throws Exception {
		try {
			utils.clickWebElement(driver.findElement(By.xpath("//*[@id='A1']/button")));
			WebElement hideOfflineLink = driver.findElement(
					By.xpath("//ul[@class='pull-right dropdown-menu padder']/li/i[contains(text(),'Hide Offline')]"));
			utils.clickWebElement(hideOfflineLink);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void displayOffline() throws Exception {
		try {
			utils.clickWebElement(driver.findElement(By.xpath("//*[@id='A1']/button")));
			WebElement hideOfflineLink = driver.findElement(By
					.xpath("//ul[@class='pull-right dropdown-menu padder']/li/i[contains(text(),'Display Offline')]"));
			utils.clickWebElement(hideOfflineLink);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * . code to verify the business unit dropdown for a value
	 * 
	 * @param BUvalue
	 * @throws Exception
	 */
	public boolean verifyBU(String value) throws Exception {
		boolean flag = false;
		try {
			String buElementsPath = "//ul[@class='tree tree-sub']/li/a/span";
			List<WebElement> buElements = driver.findElements(By.xpath(buElementsPath));
			if (utils.searchListForText(buElements, value)) {
				flag = true;
				Logger.info(value + " text is available in the BU list.");
			} else
				Logger.info(value + " text is NOT available in the BU list.");
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		return flag;
	}


	public void selectProductType(String productType) throws Exception {
		try {
			if (productTypeDropDown.isDisplayed()) {
				productTypeDropDown.click();
				Logger.info("Product Type dropdown is clicked");
				Select valueFromProductType = new Select(productTypeDropDown);
				List<WebElement> listOfProductTypes = valueFromProductType.getOptions();
				if (listOfProductTypes.size() != 0) {
					Logger.info("List of Product types is not empty");

					valueFromProductType.selectByVisibleText(productType);

					Logger.info("'" + productType + "' product type is selected"); 
				}
			}
			else
			{
				Logger.info("Product Type drop down is not displayed");
				throw new NoSuchElementException("Product Type drop down is not displayed");
			}




		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new
	public void selectFinanceTab() throws Exception
	{
		try
		{
			if (FinanceTab.isDisplayed())
			{
				FinanceTab.click();
				Logger.info("Finance Tab is clicked");

				Select GLEntityCode = new Select(driver.findElement(By.xpath("//*[@id='Select1']")));
				GLEntityCode.selectByVisibleText("10000");
				Logger.info(" GL Entity Code is selected");
				//Thread.sleep(3000);

				Select GLSubEntityCode = new Select(driver.findElement(By.xpath("//*[@id='Select2']")));
				GLSubEntityCode.selectByVisibleText("10500");
				Logger.info(" GL Sub Entity Code is selected");
				//Thread.sleep(3000);

				Select GLDepartmentCode = new Select(driver.findElement(By.xpath("//*[@id='deptCodeid']")));
				GLDepartmentCode.selectByVisibleText("10000");
				Logger.info(" GL Department Code is selected");
				// Thread.sleep(3000);

				Select GLProductCode = new Select(driver.findElement(By.xpath("//*[@id='Select3']")));
				GLProductCode.selectByVisibleText("ACM000");
				Logger.info(" GL Product Code is selected");
				// Thread.sleep(3000);


			}

			else
			{
				Logger.info(" Finance Tab is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new







	/*public void BuProductCaret() throws Exception
	{
		try
		{
			if ( ProductCaret.isDisplayed())
			{
				ProductCaret.click();
				Logger.info("Product Caret Button is clicked");
			}

			else
			{
				Logger.info("Product Caret  Button is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new 	*/  

	public void AddProductButton(String BuName) throws Exception
	{
		try
		{

			WebElement AddProduct= driver.findElement(By.xpath("//span[text()='"+BuName+"']/..//li[@class='ng-scope']"));

			AddProduct.click();
			Logger.info(" Add Product  Button is clicked");




		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new 


	public void ExpandBU(String BU) throws Exception
	{
		try
		{      WebElement ExpandBU=driver.findElement(By.xpath("//span[text()='"+BU+"']/../i")); 

		ExpandBU.click();
		Logger.info(" Expand BU  Button is clicked");


		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new 

	public void ExpandProductType(String producttype) throws Exception
	{
		try
		{    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//mousumi    
		WebElement ExpandProduct= driver.findElement(By.xpath("//span[text()='"+producttype+"']/../i"));


		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ExpandProduct);
		Logger.info(" Expand Product Button is clicked");


		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new 

	public void DeleteProduct(String name) throws Exception
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver, 20);
			WebElement DeleteProduct = driver.findElement(By.xpath("(//span[text()='"+name+"']//preceding-sibling::i//following::ul/li/i)[2]"));//swagata
			wait.until(ExpectedConditions.elementToBeClickable(DeleteProduct));//swagata
			//WebElement DeleteProduct = driver.findElement(By.xpath("//span[text()='"+name+"']/following-sibling::button/span[@class='caret']"));//modification
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", DeleteProduct);

			DeleteProduct.click(); 
			Logger.info("Product is Deleteted");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new



	public void AddSection(String name) throws Exception
	{
		try{
			//WebDriverWait wait=new WebDriverWait(driver, 20);
			WebElement AddSection = driver.findElement(By.xpath("(//span[text()='"+name+"']//preceding-sibling::i//following::ul/li/i)[1]"));//swagata
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", AddSection);

			AddSection.click(); 
			Logger.info("Section is added");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new

	public String SectionName() throws Exception
	{
		try{
			SectionName.clear();
			String str = utils.generateRandomString(5);

			String Secname= "00"+str+" Test Section";
			SectionName.sendKeys(Secname);
			// SectionName.sendKeys("Test Section");
			Logger.info("Section name is given");
			Thread.sleep(2000);
			return Secname;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new

	public void ExpandCreatedProduct(String NewProductName) throws Exception
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver, 20);//mousumi
			
			//WebElement buCaret = driver.findElement(By.xpath("//span[text()='"+name+"']/following-sibling::button"));
			//WebElement CreatedProductdropdown = driver.findElement(By.xpath("(//span[text()='"+NewProductName+"']//parent::a//i)[1]"));//swagata
			WebElement CreatedProductdropdown = driver.findElement(By.xpath("//span[text()='"+NewProductName+"']/../i"));//joy
			
			
			wait.until(ExpectedConditions.elementToBeClickable(CreatedProductdropdown));//swagata
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", CreatedProductdropdown);
			Logger.info("New Product DropDown is Expanded");
			Thread.sleep(2000);
			CreatedProductdropdown.click();//swagata
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new

	public void NewSectionCaret(String NewSectionName) throws Exception
	{
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement SelectCreatedSection = driver.findElement(By.xpath("//span[text()='"+NewSectionName+"']/../../a/button/span"));

			SelectCreatedSection.click();
			Logger.info("Add Button is selected");//need to create button
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new

	public void DeleteSection(String name) throws Exception
	{
		try{
			WebElement DeleteSection = driver.findElement(By.xpath("(//span[text()='"+name+"']//preceding-sibling::i//following::ul/li/i)[1]"));//swagata
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", DeleteSection);
			WebDriverWait wait= new WebDriverWait(driver, 20);//swagata
			wait.until(ExpectedConditions.elementToBeClickable(DeleteSection));//swagata
			DeleteSection.click(); 
			Logger.info("Section is Deleteted");
			Thread.sleep(8000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new

	public void AddSubSection(String name) throws Exception
	{
		try{
			WebDriverWait wait= new WebDriverWait(driver, 20);//swagata
		WebElement AddSubSection = driver.findElement(By.xpath("(//span[text()='"+name+"']//preceding-sibling::i//following::ul/li/i)[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", AddSubSection);
		wait.until(ExpectedConditions.elementToBeClickable(AddSubSection));//swagata
		AddSubSection.click(); 
		Logger.info("SubSection is added");
		Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new 

	public String SubSectionName() throws Exception
	{
		try{
			SubSectionName.clear();
			String str = utils.generateRandomString(5);

			String SubSecname= "00"+str+" Test SubSection";
			SubSectionName.sendKeys(SubSecname);
			// SectionName.sendKeys("Test Section");
			Logger.info("SubSection name is given");

			driver.findElement(By.xpath("//*[text()='Dfp Name']/../../div/input")).sendKeys("test");
			Thread.sleep(2000);
			return SubSecname;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new  

	public void SubSectionButtonSave() throws Exception
	{
		try
		{
			if ( btnSubSectionSave.isDisplayed())
			{
				btnSubSectionSave.click();
				Logger.info("SubSection Save Button is clicked");
			}

			else
			{
				Logger.info("SubSection Save Button is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new 

	public void SelectDfp() throws Exception
	{
		try{
			WebElement SelectDfp = driver.findElement(By.xpath("//*[@id='section_IsDFPSection']"));
			SelectDfp.click();
			Logger.info("DFP section is selected");
			WebElement DfpName=driver.findElement(By.xpath("//*[@id='Text9']"));
			DfpName.click();
			DfpName.sendKeys("abc");
			Logger.info("DFP details is given");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new
	public void ClickOnProduct(String name) throws Exception
	{
		try{
			WebElement ClickOnProduct = driver.findElement(By.xpath("//span[text()="+name+"]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", ClickOnProduct);

			ClickOnProduct.click(); 
			Logger.info("Product is Clicked");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new 
	public void selectActiveDaysofWeekTab() throws Exception
	{
		try
		{
			if (selectActiveDaysofWeekTab.isDisplayed())
			{
				selectActiveDaysofWeekTab.click();
				Logger.info("Active Days of Week Tab is clicked");
			}

			else
			{
				Logger.info("Active Days of Week Tab is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new 








	public void ExpandCreatedSection(String SectionName) throws Exception
	{
		try{
			WebElement CreatedSectiondropdown = driver.findElement(By.xpath("(//span[text()='"+SectionName+"']//parent::a//i)[1]"));//swagata

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", CreatedSectiondropdown);
			WebDriverWait wait= new WebDriverWait(driver, 20);//swagata
			wait.until(ExpectedConditions.elementToBeClickable(CreatedSectiondropdown));//swagata
			CreatedSectiondropdown.click();
			Logger.info("New Section DropDown is Expanded");
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new

	public boolean isClickable()      
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,200);		       
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='app']/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div/div[4]/div/div[2]/div[2]/div[2]/div[2]/div/label[2]/input]"))));


			return true;
		}
		catch (Exception e)
		{
			return false;
		}

	}//swagata new

	public  String SelectPositionManagementTab() throws Exception
	{



		SelectPositionManagementTab.click();
		Logger.info(" Position Management Tab is clicked");

		AddPositionButton.click();
		Logger.info(" AddPosition button is clicked");

		Actions actions = new Actions(driver);
		WebElement AddPosition=driver.findElement(By.xpath("//div[contains(@class,'ui-grid-cell-contents')][normalize-space()='New Name']"));
		actions.doubleClick(AddPosition).perform();




		/*String str = utils.generateRandomString(5); */
		String str = utils.generateRandomString(5);
		String Positioname= "00"+str+" Position";
		Logger.info("Position name:"+Positioname);
		//				   JavascriptExecutor js = (JavascriptExecutor)driver;

		//				   js.executeScript("arguments[0].value='"+Positioname+"';", AddPosition);
		StringSelection stringSelection = new StringSelection(Positioname);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(200);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		Assert.assertEquals(Positioname, AddPosition.getText().trim());
		Logger.info("Position name is given");
		
		return Positioname;



	}//swagata new
	public void SelectAdTypeManagementTab() throws Exception
	{
		try
		{
			if (SelectAdTypeManagementTab.isDisplayed())
			{
				SelectAdTypeManagementTab.click();
				Logger.info(" AdType Management Tab is clicked");
			}

			else
			{
				Logger.info("AdType Management Tab is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new


	public void selectPositionAssignmentTab() throws Exception
	{



		try
		{
			if (selectPositionAssignmentTab.isDisplayed())
			{
				selectPositionAssignmentTab.click();
				Logger.info("Position Assignment Tab is clicked");

			}

			else
			{
				Logger.info("Position Assignment Tab is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new

	public String getPositionName(String Position) throws Exception
	{
		//String ProductId = "";
		WebElement element = driver.findElement(By.xpath("//div[text()='"+Position+"']"));

		Thread.sleep(3000);


		String PositionName = element.getText();
		Logger.info("Got the Position Name:"+PositionName);
		return PositionName;
	}//swagata new

	public void ClickOnBU(String BUName) throws Exception
	{



		try
		{   WebElement Name=driver.findElement(By.xpath("//span[text()='"+BUName+"']")) ; 
		Name.click();

		Logger.info(BUName+" BU is clicked");



		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new

	public void selectAutoInsertionManagementTab() throws Exception
	{
		try
		{
			if (AutoInsertionManagementTab.isDisplayed())
			{
				AutoInsertionManagementTab.click();
				Logger.info("AutoInsertion Management Tab is clicked");
			}

			else
			{
				Logger.info("AutoInsertion Management Tab is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new

	public void AddbuttonInAutoInsMangTab() throws Exception
	{
		try
		{
			if (Addbutton.isDisplayed())
			{
				Addbutton.click();
				Logger.info("Add button is clicked");
			}

			else
			{
				Logger.info("Add button is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new

	public void minSalesPrice(String Dollar) throws Exception
	{
		try
		{
			if (MinSalesPrice.isDisplayed())
			{

				MinSalesPrice.clear();

				MinSalesPrice.sendKeys(Dollar);

				Logger.info("Min Sales Price is given");
			}

			else
			{
				Logger.info("Min Sales Price box is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}  }//swagata new

	public void selectCreateProduct(String ProductName) throws Exception
	{
		try
		{
			driver.findElement(By.xpath("//*[@id='Product_Create']")).click();
			WebElement productDrpDwn = driver.findElement(By.xpath("//*[@id='Product_Create']"));
			Select selectProduct = new Select(productDrpDwn);



			selectProduct.selectByVisibleText(ProductName);
			Logger.info("Product is selected"); 


		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}



	}//swagata new
	//partha new
	public void selectMatchedOrderType(String OrderType) throws Exception
	{
		try
		{
			driver.findElement(By.xpath("//label[contains(text(),'Matched Order Types:')]//following::button[1]")).click();
			String ordertypeXpath="//label[@class='checkbox' and contains(text(),'"+OrderType+"')]";
			Thread.sleep(3000);
			driver.findElement(By.xpath(ordertypeXpath)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//label[contains(text(),'Matched Order Types:')]//following::button[1]")).click();
			Thread.sleep(3000);
			
			Logger.info("Order Type is selected"); 


		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}



	}

	public void createPercentage(String Percent) throws Exception
	{
		try
		{
			if (Percentage.isDisplayed())
			{

				Percentage.clear();

				Percentage.sendKeys(Percent);

				Logger.info("Percentage is given");
			}

			else
			{
				Logger.info("Percentage box is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}  }//swagata new


	public void okButton() throws Exception
	{
		try
		{
			if (okbutton.isDisplayed())
			{
				okbutton.click();

				Thread.sleep(5000);

				Logger.info("OK Button is clicked");
			}

			else
			{
				Logger.info("OK Button is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}  }//swagata new

	public void saveButton() throws Exception
	{
		try
		{
			if (saveButton.isDisplayed())
			{
				saveButton.click();

				Thread.sleep(20000);

				Logger.info("Save Button is clicked");
			}

			else
			{
				Logger.info("Save Button is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}  }//swagata new

	public String selectMatchedProduct(String ProductName,String ProdType) throws Exception
	{
		try
		{
			driver.findElement(By.xpath("//*[@id='MatchedProductName']")).click();
			WebElement productDrpDwn = driver.findElement(By.xpath("//*[@id='MatchedProductName']"));
			Select selectProduct = new Select(productDrpDwn);

			String MatchedProduct=ProductName+" "+"("+ProdType+")";

			selectProduct.selectByVisibleText(MatchedProduct);
			Logger.info("Product is selected"); 
			return MatchedProduct;	      

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}

	}//swagata new

	public void searchMatchedProduct(String productName) throws Exception
	{
		try
		{
		WebElement scrollMark = driver.findElement(By.xpath("(//*[@ui-grid='autoInsertionGrid']//div[contains(@ng-dblclick,'showAutoInsertionModal')])[last()]"));
		for(int i=0;i<50;i++){
			
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",scrollMark );
			Thread.sleep(500);

		}
			for(int i=0;i<50;i++){
				
				
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",scrollMark );
				Thread.sleep(500);
				if(driver.findElements(By.xpath("//div[text()='"+productName+"']")).size()>0)
				{
					Logger.info("matched product found");
					break;
					
				}
			}
			//driver.findElement(By.xpath("(//*[text()='CT Var Rate Special Sect. (Display)'])[1]")).click();
			WebElement Name=driver.findElement(By.xpath("//div[text()='"+productName+"']")) ;

			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();",Name );
			Thread.sleep(2000);
			Name.click();

			Logger.info("Matched Product is clicked");


		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new

	public void editButton() throws Exception
	{
		try
		{
			if (editButton.isDisplayed())
			{
				editButton.click();

				Thread.sleep(5000);

				Logger.info("Edit Button is clicked");
			}

			else
			{
				Logger.info("Edit Button is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}  }//swagata new


	public String getMinSalesPrice() throws Exception
	{

		//String ProductId = "";
		WebElement element = driver.findElement(By.xpath("//*[@id='Min_Sales_Price']"));
		Thread.sleep(3000);


		String Price = element.getAttribute("value").trim();
		Logger.info("Got the Min Sales Price:"+Price);
		return Price;


	}//swagata new 

	public void removeButton() throws Exception
	{
		try
		{
			if (removeButton.isDisplayed())
			{
				removeButton.click();

				Thread.sleep(5000);

				Logger.info("Remove Button is clicked");
			}

			else
			{
				Logger.info("Remove Button is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}  
		}//swagata new
	
	public void DeleteAll() throws Exception
	{
		WebElement deleteall = driver.findElement(By.xpath("//a[@id='A8']"));
		Thread.sleep(4000);
		try
		{
			if (deleteall.isDisplayed())
			{
				deleteall.click();

				Thread.sleep(5000);

				Logger.info("Remove Button is clicked");
			}

			else
			{
				Logger.info("Remove Button is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}  
		}//swagata new



	public void selectPricingModel(String Name) throws Exception
	{
		try
		{
			driver.findElement(By.xpath("//label[text()='Pricing Model']/../../div/select")).click();
			WebElement PricingModelDrpDwn = driver.findElement(By.xpath("//label[text()='Pricing Model']/../../div/select"));
			Select selectSizeOrWeight = new Select(PricingModelDrpDwn);
			selectSizeOrWeight.selectByVisibleText(Name);
			Logger.info(Name +"is selected"); 


		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}



	}//swagata new
	public void selectProductTypesTab() throws Exception
	{
		try
		{
			if (ProductTypesTab.isDisplayed())
			{
				ProductTypesTab.click();
				Logger.info("Product Types Tab is clicked");
			}

			else
			{
				Logger.info("Product Types Tab is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new

	public void roundToNearestCheckBox(boolean value) throws Exception
	{
		try{
			WebElement element = driver.findElement(By.xpath("//div[text()='Preprint']/../../../div/div[2]/div/input"));
			String checkCriteria = element.getAttribute("class");
			if(value){
				if(checkCriteria.equalsIgnoreCase("ng-valid ng-dirty ng-valid-parse ng-touched ng-not-empty")){

					Logger.info("Round To Nearest CheckBox is already checked");

				}
				else {
					element.click();
					Logger.info("Round To Nearest CheckBox is checked");
				}
			}
			else{
				if(checkCriteria.equalsIgnoreCase("ng-valid ng-dirty ng-valid-parse ng-touched ng-not-empty"))
				{
					element.click();
					Logger.info("Round To Nearest CheckBox is unchecked");
				}
				else{
					Logger.info("Round To Nearest CheckBox is already unchecked");
				}
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new

	public void selectGeneralInfo() throws Exception
	{
		try
		{
			if (GeneralInfo.isDisplayed())
			{
				GeneralInfo.click();

				Thread.sleep(5000);
				GeneralInfo.click();


				Logger.info("General Info expansion is clicked");
			}

			else
			{
				Logger.info("General Info expansion is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new

	public void selectAdSizeMng() throws Exception
	{
		try
		{
			if (AdSizeManagement.isDisplayed())
			{
				AdSizeManagement.click();

				Thread.sleep(5000);

				Logger.info("AdSize Management expansion is clicked");

			}

			else
			{
				Logger.info("AdSize Management expansion is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new

	public String getValueOfColumnModel()throws Exception
	{
		try
		{     

			String colModelName = AdSizeManagementColName.getAttribute("innerText");
			colModelName = colModelName.substring(0 , colModelName.lastIndexOf(" "));

			Logger.info("Got the Value Of ColumnModel");

			return colModelName;



		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new 

	public void ClickOnSection(String name) throws Exception
	{
		try{
			WebElement ClickOnSection = driver.findElement(By.xpath("//span[text()='"+name+"']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", ClickOnSection);

			ClickOnSection.click(); 
			Logger.info("Section is Clicked");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new

	public void selectMiscellaneousTab() throws Exception
	{
		try
		{
			if (MiscellaneousTab.isDisplayed())
			{
				MiscellaneousTab.click();
				Logger.info("MiscellaneousTab is clicked");
			}

			else
			{
				Logger.info("Miscellaneous Tab is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new

	public void selectColumnModel(String ColumnModel) throws Exception
	{
		try
		{
			if (ColumnModelDropdown.isDisplayed())
			{
				ColumnModelDropdown.click();
				Logger.info("Column Model drop down is clicked");
				Select valueFromColumnModel = new Select(ColumnModelDropdown);

				valueFromColumnModel.selectByVisibleText(ColumnModel);

				Logger.info("'" + ColumnModel + "' ColumnModel Name is selected"); 
			}

			else
			{
				Logger.info("ColumnModel drop down is not displayed");
			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new




	public void selectAdSizeAssignmentTab() throws Exception
	{
		try
		{
			if (AdSizeAssignmentTab.isDisplayed())
			{
				AdSizeAssignmentTab.click();
				Logger.info("Ad Size Assignment Tab is clicked");
			}

			else
			{
				Logger.info("Ad Size Assignment Tab is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new

	public void selectAdSizeManagementExp() throws Exception
	{
		try
		{
			if (adSizeManagementExp.isDisplayed())
			{
				adSizeManagementExp.click();
				Logger.info("AD Size Management expansion is clicked");
			}
			else
			{
				Logger.info("AD Size Management expansion is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new




	public void selectAdSizeAssignmentExp() throws Exception
	{
		try
		{
			if (adSizeAssignmentExp.isDisplayed())
			{
				adSizeAssignmentExp.click();
				Logger.info("Ad Size Assignment Expansion is clicked");
			}

			else
			{
				Logger.info("Ad Size Assignment Expansion is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new

	public String getBlockValue() throws Exception
	{
		WebElement Block= driver.findElement(By.xpath("//*[text()='A D Type']/../../../../../../../../../../div[2]/div/div[3]/div/div[3]/div"));
		String value=Block.getText();
		Logger.info("Got the BlockValue:"+value);
		return value;
	}//swagata new

	public String getBlockValueInSection() throws Exception
	{
		WebElement Block= driver.findElement(By.xpath("//*[text()='Ad Type']/../../../../../../../../../../div[2]/div/div[2]/div/div[2]/div"));
		String value=Block.getText();
		Logger.info("Got the BlockValue:"+value);
		return value;
	}//swagata new

	public void DigitalServicesProductCheckBox(boolean value) throws Exception
	{
		try{
			String checkCriteria = DigitalServicesProductCheckBox.getAttribute("class");
			if(value){
				if(checkCriteria.equalsIgnoreCase("ng-valid ng-touched ng-dirty ng-valid-parse ng-not-empty")){

					Logger.info("Digital Services Product CheckBox is  already checked");

				}
				else {
					DigitalServicesProductCheckBox.click();
					Logger.info("Digital Services Product CheckBox is clicked");
				}
			}
			else{
				if(checkCriteria.equalsIgnoreCase("ng-valid ng-touched ng-dirty ng-valid-parse ng-not-empty"))
				{
					DigitalServicesProductCheckBox.click();
					Logger.info("Digital Services Product CheckBox  is unchecked");
				}
				else{
					Logger.info("Digital Services Product CheckBox is already unchecked");
				}
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new

	public String BUName() throws Exception
	{
		try{
			BUNameTextBox.clear();
			//TribuneUtils utils  = new TribuneUtils();
			String str = utils.generateRandomString(5);
			String name= "00"+str+" Test BU";
			ProductNameTextBox.sendKeys(name);

			Logger.info(name+ "BU name is given");
			return name;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new

	public void abbreviation() throws Exception
	{
		try{
			abbreviationTextBox.clear();
			//TribuneUtils utils  = new TribuneUtils();
			String str = utils.generateRandomString(5);
			String name= "00"+str+" ";
			abbreviationTextBox.sendKeys(name);

			Logger.info(name+ "Abbreviation is given");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new

	public void clickBuCaret(String buName) throws Exception {
		try {			
			WebElement buCaret = driver.findElement(
					By.xpath("//span[text()='"+buName+"']/..//*[@class='caret']"));
			buCaret.click();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new



	public void selectGeneralInfoTab() throws Exception {
		try {
			if (GeneralInfoTab.isDisplayed()) {
				GeneralInfoTab.click();
				Logger.info("General Info Tab is clicked");
			}

			else {
				Logger.info("General Info Tab is not displayed");

			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void ProductButtonSave() throws Exception {
		try {
			if (btnProductSave.isDisplayed()) {
				btnProductSave.click();
				Logger.info(" Product Save Button is clicked");
				// driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;//swagata
			}

			else {
				Logger.info("Product Save Button is not displayed");

			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void checkIfSuccessMsgAppears() throws Exception {
		try {
			//waitUntilElementVisible(successMsg);
			//Logger.info("The Success Message appears");
			Thread.sleep(20000);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}//swagata

	public String getProductId() throws Exception {
		// String ProductId = "";
		WebElement element = driver.findElement(By.xpath("//input[@id='Product_Id']"));
		Thread.sleep(3000);

		String ProductId = element.getAttribute("value").trim();
		Logger.info("Got the Product ID:" + ProductId);
		return ProductId;
	}// swagata new

	public void SectionButtonSave() throws Exception {
		try {
			if (btnSectionSave.isDisplayed()) {
				btnSectionSave.click();
				Logger.info("Section Save Button is clicked");
			}

			else {
				Logger.info("Section Save Button is not displayed");

			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void clickOkInConfirmMessage() throws Exception {
		try { 
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(ClickOk));//swagata
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

	public String getSectionId() throws Exception {

		// String ProductId = "";
		WebElement element = driver.findElement(By.xpath("//*[@id='Text1']"));
		Thread.sleep(3000);

		String SectionId = element.getAttribute("value").trim();
		Logger.info("Got the Section ID:" + SectionId);
		return SectionId;

	}// swagata new

	public void NewProductCaret(String name) throws Exception {
		try {			
			WebElement buCaret = driver.findElement(By.xpath("//span[text()='"+name+"']/following-sibling::button"));
			//WebElement buCaret = driver.findElement(By.xpath("//span[text()='"+name+"']/following-sibling::button/span[@class='caret']"));
			buCaret.click();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void BuProductCaret() throws Exception {
		try {
			if (ProductCaret.isDisplayed()) {
				ProductCaret.click();
				Logger.info("Product Caret Button is clicked");
			}

			else {
				Logger.info("Product Caret  Button is not displayed");

			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void AddProduct() throws Exception {
		try {

			if (AddProduct.isDisplayed()) {
				AddProduct.click();
				Logger.info(" Add Product  Button is clicked");
			}

			else {
				Logger.info("Add Product Button is not displayed");

			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public String ProductName() throws Exception {
		try {
			ProductNameTextBox.clear();
			// TribuneUtils utils = new TribuneUtils();
			String str = utils.generateRandomString(5);
			String name = "00" + str + " Test Prod";
			ProductNameTextBox.sendKeys(name);

			// ProductName.sendKeys("Test Product");
			Logger.info("Product name is given");
			return name;
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void ExpandBU() throws Exception {
		try {
			if (ExpandBU.isDisplayed()) {
				ExpandBU.click();
				Logger.info(" Expand BU  Button is clicked");
			}

			else {
				Logger.info("Expand BU Button is not displayed");

			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void ExpandProduct() throws Exception {
		try {
			if (ExpandProduct.isDisplayed()) {
				ExpandProduct.click();
				Logger.info(" Expand Product Button is clicked");
			}

			else {
				Logger.info("Expand Product Button is not displayed");

			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new











	public void selectRecurrenceTab() throws Exception {
		try {
			if (selectRecurrenceTab.isDisplayed()) {
				selectRecurrenceTab.click();
				Logger.info(" Recurrence Tab Tab is clicked");
			}

			else {
				Logger.info("Recurrence Tab is not displayed");

			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public void NewSubSectionCaret(String name) throws Exception {
		try {
			WebElement SelectCreatedSubSection = driver
					.findElement(By.xpath("(//span[text()='" + name + "']//following::button/span)[1]"));//swagata
			WebDriverWait wait= new WebDriverWait(driver, 20);//swagata
			wait.until(ExpectedConditions.elementToBeClickable(SelectCreatedSubSection));//swagata
			SelectCreatedSubSection.click();
			Logger.info("Add Button is selected");
			Thread.sleep(2000);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new

	public String getSubSectionId() throws Exception {

		// String ProductId = "";
		WebElement element = driver.findElement(By.xpath("//*[@id='Text1']"));
		Thread.sleep(3000);

		String SubSectionId = element.getAttribute("value").trim();
		Logger.info("Got the Section ID:" + SubSectionId);
		return SubSectionId;

	}// swagata new

	public void DeleteSubSection(String name) throws Exception {
		try {
			WebElement DeleteSubSection = driver
					.findElement(By.xpath("(//span[text()='"+ name +"']//following::i)[1]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", DeleteSubSection);

			WebDriverWait wait= new WebDriverWait(driver, 20);//swagata
			wait.until(ExpectedConditions.elementToBeClickable(DeleteSubSection));//swagata
			DeleteSubSection.click();
			Logger.info("Section is added");
			Thread.sleep(5000);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// swagata new
	public void selectAutoinsertion(String AutoInsetion) throws Exception
	{
		try
		{
			WebDriverWait wait= new WebDriverWait(driver, 20);
			WebElement productDrpDwn = driver.findElement(By.xpath("//select[@id='Type_ID']"));
			wait.until(ExpectedConditions.elementToBeClickable(productDrpDwn));
			Select selectProduct = new Select(productDrpDwn);
			selectProduct.selectByVisibleText(AutoInsetion);
			Logger.info(AutoInsetion+ " is selected"); 

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}

	}//swagata 
	public void checkIfAlertMsgAppears() throws Exception {
		try {
			waitUntilElementVisible(alertMsg);
			Assert.assertEquals(true, alertMsg.isDisplayed());
			Logger.info("The alert Message appears");	

			//Thread.sleep(4000);
		}
		catch (AssertionError e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}//swagata

	public void selectOrderTypes() {
		WebElement orderTypeValidate = driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default btn-block']"));
		//if(driver.findElement(By.xpath("//div[@class='row row-spacing ng-hide'][.//label[contains(text(),'Matched Order Types')]]")).getAttribute("aria-hidden").equalsIgnoreCase("false"))
		//if(driver.findElement(By.xpath("//label[contains(text(),'Matched Order Types:')]")).getAttribute("aria-hidden").equalsIgnoreCase("false"))
		if(driver.findElement(By.xpath("//label[contains(text(),'Matched Order Types:')]")).isDisplayed())
		{
			if(OrderTypeDropDown.isDisplayed())
			{	
				Logger.info("Order Type is present for legacy");	
				OrderTypeDropDown.click();
				OrderTypeSearchBox.click();
				OrderTypeSearchBox.sendKeys("Pay Per Lead");
				driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
				Logger.info("Order Type is selected");	
			}
			else {
				Logger.info("Order Type is not present for legacy");
				Assert.fail("Validation failed");
			}
		}
		else {
			//Assert.assertEquals("true", orderTypeValidate.getAttribute("aria-hidden"));
			if(orderTypeValidate.isDisplayed())
			{	
			Logger.info("Order Type is  present for own local which is not expected");
			Assert.fail("Validation failed");
			}
			else{
				Logger.info("Order Type is not present for own local as expected");
			}

		}
	}//swagata

	public void cancelButton() throws Exception
	{
		try
		{
			if (cancelbutton.isDisplayed())
			{
				cancelbutton.click();

				Thread.sleep(5000);

				Logger.info("Cancel Button is clicked");
			}

			else
			{
				Logger.info("Cancel Button is not displayed");

			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}  }//swagata 


}
