package com.tribune.adit2.OrderEntry;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.google.common.base.Function;
import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

import junit.framework.Assert;

/**
 * Page Class Modeling for Customers Page
 * @author Priyanka Goud CR 
 * @since November 2015
 */

public class NewOrderPage 
{
	@FindBy (xpath = "//input[@id='order_id']")
	public WebElement orderNoTextBoxPickUp;//swagata

	@FindBy (xpath = "//button[@id='btnSearch']")
	public WebElement orderSearchBtn;//swagata
	@FindBy (xpath = "//label[text()='Page Count / Weight']/../div/div/div[2]/input")
	public WebElement pageWeightTextBox;

	@FindBy (xpath = "//label[text()='BU/Product']/../div/span/select")
	public WebElement BuInDigitalServiceDropDown;
	@FindBy (xpath = "//label[text()='BU/Product']/../div/select")
	public WebElement ProductInDigitalServiceDropDown;

	@FindBy(xpath = "//button[contains(.,'Upload')]")
	public WebElement UploadDocBtn;

	@FindBy(xpath = "//*[@id='add-recurrence-pattern']")
	public WebElement copyOrder;

	@FindBy(xpath = "//span[text()='Documents']")
	public WebElement DocumentsTab;	

	@FindBy (xpath ="//a[text()='Save And Close']") //mou
	public WebElement saveOrderAndExitBtn;

	@FindBy (xpath = "(//select[@ng-model='$parent.primaryBusinessUnit'])[1]")
	public WebElement soldToCustomerBU;

	@FindBy (xpath = "(//select[@ng-model='$parent.primaryBusinessUnit'])[2]")
	public WebElement billToCustomerBU;

	@FindBy(xpath = "//*[@id='accountInfo']/div/form/div[1]/div[2]/div[1]/div/customer-finder-order/div/input")
	//*[@id='accountInfo']/div/form/div[1]/div[2]/div[1]/div/customer-finder-order/div/input")
	//customer-finder[@ng-model='vm.order.SoldToCustomer.CustomerNumber']/div/input
	public WebElement soldToCustomer;

	@FindBy(xpath = "//*[@id='accountInfo']/div/form/div[2]/div[2]/div[1]/div/customer-finder-order/div/input")
	//customer-finder[@ng-model='vm.order.BillToCustomer.CustomerNumber']/div/input
	public WebElement billToCustomer;

	@FindBy (xpath = "//*[@id='newCustomer']")
	public WebElement newCustomerCheckBox;

	@FindBy (xpath = "//input[@ng-model='vm.order.isNewCustomer']/../i")
	public WebElement newCustomerCheckBoxInsertion;

	@FindBy (xpath = "//dt[text()='Order Type:']")
	public WebElement orderInfoElement;

	@FindBy (xpath = "//span[@id='Span1']/span")
	public WebElement orderType;

	@FindBy (xpath = "//span[@id='Span3']/span")
	public WebElement orderRouting;

	@FindBy (xpath = "//*[@id='order-detail-page']/div[2]/div[3]/div[1]/ul/li[2]/a/span")
	public WebElement paymentTab;//swagata

	@FindBy (xpath = "//span[@id='Span2']/span")
	public WebElement paymentRouting;

	//@FindBy (xpath = "//*[@id='accounts']")//swagata
	@FindBy (xpath = "//a[contains(@editable-select,'CreditCardInfo')]")//swagata
	public WebElement cardType;

	@FindBy (xpath = "//span[@id = 'Span12']")
	public WebElement tagTextBox;

	@FindBy (xpath = "(//span[@id = 'Span13'])[1]")
	public WebElement ponumberTextBox;

	@FindBy (xpath = "(//span[@id = 'Span6'])[1]")
	public WebElement cashReceiptTextBox;

	@FindBy (xpath = "//span[@id = 'Span9']")
	public WebElement descriptionTextBox;


	@FindBy (xpath = "//span[@id = 'Span20']")
	public WebElement campaignTextBox;

	@FindBy (xpath = "//*[@id='order-detail-page']/div[1]/div/div[1]/span")
	public WebElement orderNo;

	@FindBy (xpath = "//span[@id = 'Span10']")
	public WebElement commentsTextBox;
	@FindBy (xpath = "//dt[text()='Plus_Hive ID']//following::dd//a[contains(@editable-text,'HiveId')]")
	public WebElement hiveIdTextBox;
	@FindBy (xpath = "//a[contains(@editable-text,'HiveId')]/following::form//input[@type='text']")
	public WebElement hiveIdElement;
	@FindBy (xpath = "//div[./label[text()='Plus_Hive Line ID']]//input")
	public WebElement hiveLineIdTextBox;
	@FindBy (xpath = "//span[@id = 'Span11']")
	public WebElement invoiceNoteTextBox;

	@FindBy (xpath = "//span[@id = 'Span14']")
	public WebElement couponTextBox;

	@FindBy (xpath = "//span[@id = 'Span15']")
	public WebElement legacyOrderTextBox;

	@FindBy (xpath = "//dt[contains(text(),'External Reference')]/../dd[@class='ng-binding']")
	public WebElement externalReferenceNoElement;

	@FindBy (xpath = "//dt[contains(text(),'OwnLocal')]")
	public WebElement ownLocalOptOutLabel;

	@FindBy (xpath = "//input[@ng-model='vm.order.DisableAutoInsertion']/..")
	public WebElement ownLocalOptOutCheckBox; 

	@FindBy (xpath = "//input[@ng-model='vm.order.IsCondensedStatement']/..")
	public WebElement condensedStatementCheckBox; 

	@FindBy (xpath = "//button[text()='New']")
	public WebElement newInsertionButton;

	@FindBy (xpath = "//button[text()='Package']/../../button[1]/span[1]")
	public WebElement refreshDrawButton;

	@FindBy (linkText = "New Insertion")
	public WebElement newInsertionElement;

	@FindBy (linkText = "Classified Package")
	public WebElement newClassifiedInsertionElement;

	@FindBy (linkText = "Digital Services Order")
	public WebElement newDigitalOrderElement;

	@FindBy (linkText = "Multi-Insertions /w Zones")
	public WebElement multiInsertionWZonesElement;

	@FindBy (xpath = "//input[@ng-model='vm.orderLine.SalePriceLocked']/..")
	public WebElement salesPriceToolTipElement;

	@FindBy (xpath = "//label[text()='Sales Price']/../div/input")
	public List<WebElement> salesPriceTextBox;//swagata

	@FindBy (xpath = "//label[text()='Sales Price / Rate']/../div/input[1]")
	public WebElement salesPriceText;

	@FindBy (xpath = "//label[text()='Add-on / Charges']/../div/input")
	public WebElement addOnChargeTextBox;

	@FindBy (xpath = "//span[@class='input-group-addon pointer']/i")
	public WebElement addOnChargeToolTipElement;

	@FindBy (xpath = "//button[text()='Remove']")
	public WebElement feesRemoveButton;

	@FindBy (xpath = "(//button[text()='Add'])[3]")
	public WebElement feesFirstAddButton;

	@FindBy (xpath = "//*[contains(text(),'External Reference')]/following-sibling::dd[1]")
	public WebElement externalReferenceValue;

	@FindBy (xpath = "//span[@class='input-group-addon']/input[@ng-model='vm.orderLine.IsBilledQty']")
	public WebElement billedQtyCheckBox;

	@FindBy (xpath = "//label[text()='Billed Qty']/../div/input")
	public WebElement billedQtyTextBox;

	@FindBy (xpath = "//label[text()='Perpetual']/../div/input")
	public WebElement perpetualQtyTextBox;

	@FindBy (xpath = "//label[text()='Page Count / Weight']/../div/div/div[1]/a/span/span")
	public WebElement pageCountTextBox;

	@FindBy (xpath = "//label[text()='Zones']/../div/a/span/span")
	public WebElement zoneInsideInsertion;

	@FindBy (xpath = "//label[text()='Zones']/../div/form/div/select")
	public WebElement zoneDrpDwn;

	@FindBy (xpath = "//label[text()='Bleed']/../div/a/span/span")
	public WebElement bleedTextBox;

	@FindBy(xpath = "//label[text()='Bleed']/../div/form/div/select")
	public WebElement bleedDrpDwn;

	@FindBy(xpath = "//label[text()='Color & Spot #']/../div/div/div[1]/form/div/select")
	public WebElement colorDrpDwn;

	@FindBy (xpath = "//label[text()='Type']/../div/form/div/select")
	public WebElement typeSettingsPreprintDrpDwn;


	@FindBy (xpath = "//label[contains(text(),'Ad Size')]/../div/form/div/select")
	public WebElement adSizeDrpDwn;

	@FindBy (xpath = "//label[contains(text(),'Position')]/label/input")
	public WebElement positionTemplatedChckBx;

	@FindBy (xpath = "//label[contains(text(),'Position')]/../div/span/i")
	public WebElement positionSelector;

	@FindBy (xpath = "//label[contains(text(),'Program Price')]/../div/a/span/span[2]/i")
	public WebElement programPriceSelector;


	@FindBy (id = "nl_adSizeId")
	public WebElement positionAdSize;

	@FindBy (id = "Text8")
	public WebElement state1;

	@FindBy (xpath = "//label[contains(text(),'Position')]/label/input")//payel
	public WebElement nontemplate;//payel

	//@FindBy (xpath = "//div/ul/li/a[@id='A4']")//payel
	// public WebElement saveOrderAndExitBtn;///payel

	@FindBy (xpath = "//button[@id='btnSearch']/i")
	public WebElement searchPositionInPositionSelector;

	@FindBy (xpath = "//button[text()='Select']")
	public WebElement savepositionSelection;

	@FindBy (xpath = "//label[contains(text(),'Position')]/../div/a/span[@id='Span5']")
	public WebElement postionTemplatedTxtBx;

	@FindBy (xpath = "//label[contains(text(),'Position')]/../div/form/div/select")
	public WebElement positionTemplatedDrpDwn;

	@FindBy (xpath = "//label[contains(text(),'Position Header')]/../div/a/span[@id='Span7']")
	public WebElement positionHeaderTxtBx;

	@FindBy (xpath = "//label[contains(text(),'Position Header')]/../div/form/div/select")
	public WebElement positionHeaderDrpDwn;

	@FindBy (xpath = "//label[text()='Material Source']/..//select")
	public WebElement pickUpMaterialSourceDrpDwn;

	@FindBy (xpath = "//label[text()='Pickup #']/../div/span/i")
	public WebElement pickUpNumSearchBtn;

	@FindBy (xpath = "//input[@ng-model='vm.orderLine.PickupNumberDisplayText']")
	public WebElement pickUpNumValue;

	@FindBy (xpath = "//label[contains(text(),'Add-on')]/../div/span/i")
	public WebElement addOnSearchBtn;

	@FindBy (xpath = "//button[contains(text(),'Confirm')]")
	public WebElement confirmAddOnBtn;

	@FindBy (xpath = "//label[text()='Sales Tax']/../div/input")
	public WebElement salesTaxElement;

	@FindBy (xpath = "//*[@id='order-detail-page']/div[1]/div/div[2]/div[2]/button[2]")
	public WebElement saveOrderDrpDwn;

	@FindBy (xpath = ".//*[@id='save-order']")
	public WebElement saveOrderBtn1;

	//@FindBy (xpath = ".//*[@id='Button2']")//swagata
	@FindBy (xpath = "//div[contains(@class,'dropdown')]/button[text()='Save']")//swagata
	public WebElement saveOrderBtn;

	@FindBy (xpath = ".//*[@id='convert-io-to-reservation']")
	public WebElement convertToReservationBtn;

	@FindBy (xpath = ".//*[@id='convert-io-to-order']")
	public WebElement covertToOrderBtn;

	//@FindBy (id = "save-order-and-exit") payel
	//public WebElement saveOrderAndExitBtn; payel


	@FindBy (xpath ="//div[@class='editable-controls form-group']/select")
	public WebElement orderTypeDrpDwn ;//swagata


	@FindBy(id = "submit-order")
	public WebElement submitOrderButton;

	@FindBy(id = "transfer-order")
	public WebElement transferOrderButton;

	@FindBy (xpath = "//input[@ng-model='vm.order.BillToSameAsSoldTo']/../i")
	public WebElement billToSameasSoldToCheckbox; 

	@FindBy(xpath = "//span[@class='m-n font-thin h3 ng-binding ng-scope']")
	public WebElement orderViewPageElement;

	@FindBy (id = "Select6")
	public WebElement billingType;

	@FindBy(xpath = "html/body/ul/li[4]/a/span")
	public WebElement duplicateInsertionLink;

	@FindBy(xpath = "html/body/ul/li[1]/a/span")
	public WebElement newInsertionVersionLink;

	//@FindBy (xpath = "//input[@ng-model='vm.salesPersonNumber']")
	@FindBy(id = "salesperson-search-field")
	public WebElement searchSalesPersonTextbox;

	@FindBy(id = "servicerepNumber")
	public WebElement searchServiceRepTextbox;

	@FindBy (xpath = "//label[text()='Auto / User Adjust']/../div/input[2]")
	public WebElement autoAdjustPriceEdit;

	@FindBy (xpath = "//label[text()='Auto / User Adjust']/../div/input[3]")
	public WebElement autoAdjustPercentTextBox;

	@FindBy (xpath = "//a[text()='Settings']")
	public WebElement settingsTab;

	@FindBy(xpath = "//a/uib-tab-heading[contains(text(),'Tearsheet')]")
	public WebElement tearsheetTab;

	@FindBy(xpath = "//a/uib-tab-heading[contains(text(),'Overrun')]")
	public WebElement overrunTab;

	@FindBy(xpath = "//a/uib-tab-heading[contains(text(),'Proof')]")
	public WebElement proofTab;

	@FindBy (xpath = "//a[contains(text(),'P & D')]")
	public WebElement pAndDTab;

	@FindBy (xpath = "//a[@ng-click='vm.newTearsheet()']")
	public WebElement newTearsheetLink; 

	@FindBy (xpath = "//a[@ng-click='vm.newOverrun()']")
	public WebElement newOverrunLink; 

	@FindBy(xpath = "//a[@ng-click='vm.editTearsheet(tearsheet)'][contains(text(),'Edit')]")
	public WebElement editTearsheetLink;

	@FindBy(xpath = "//a[@ng-click='vm.deleteTearsheet(tearsheet)'][contains(text(),'Delete')]")
	public WebElement deleteTearsheetLink;

	@FindBy(xpath = "//a[contains(text(),'New Proof')]")
	public WebElement newProofLink;

	@FindBy(xpath = "//a[@ng-click='vm.editProof(proof)'][contains(text(),'Edit')]")
	public WebElement editProofLink;

	@FindBy(xpath = "//a[@ng-click='vm.deleteProof(proof)'][contains(text(),'Delete')]")
	public WebElement deleteProofLink;

	@FindBy (xpath = ".//*[@id='order-detail-page']/div[1]/div/div[2]/div[5]/button")
	public WebElement orderMoreActionsBtn;

	//@FindBy(xpath = "//ul[@class='dropdown-menu pull-right']//a[contains(text(),'Kill')]")
	//*[@id='order-detail-page']/div[1]/div/div[2]/div[5]/ul/li[2]/a
	//@FindBy(xpath = "//*[@id='order-detail-page']/div[1]/div/div[2]/div[5]/ul/li[1]/a") payel
	@FindBy(xpath = "//li[@role='menuitem']/a[contains(text(),'Kill')]")//payel
	public WebElement orderKillBtnOrderViewPage;

	@FindBy (xpath ="//div/div[3]/button[contains(text(), 'Continue')]")//payel
	public WebElement warningmessage;//payel
	
	@FindBy(xpath = "//a[contains(text(),'Recurrence')]")
	public WebElement orderRecurrenceBtn;

	@FindBy (xpath = "//label[text()='Repeats:']/../div/select")
	public WebElement orderRepeatDrpDwn;

	@FindBy (xpath="//label[contains(text(),'Every:')]/../div/input[@ng-model='vm.pattern.DailyPatternInstance.EveryDays']")
	public WebElement repeatDays;

	@FindBy (name = "StartDate")
	public WebElement startDate;

	@FindBy (xpath = "//label[text()='Ends:']/../div/div/label[text()='Never']/input")
	public WebElement endsNeverRadioBtn;

	@FindBy (xpath = "//label[text()='Ends:']/../div[1]/div[2]/label/input")
	public WebElement endsAfterRadioBtn;

	@FindBy (xpath = "//label[text()='Ends:']/../div[1]/div[2]/input")
	public WebElement endsAfterOccurrenceTxtBx;

	@FindBy (xpath = "//button[text()='Continue with as Provided']")
	public WebElement continueButton;

	@FindBy (xpath = "//button[text()='Confirm']")
	public WebElement confirmButton;

	@FindBy (xpath = "//label[text()='Ends:']/../div[1]/div[3]/label/input")
	public WebElement endsOnRadioBtn;

	@FindBy (xpath = "//label[text()='Ends:']/../div[1]/div[3]/input")
	public WebElement endsOnOccurrenceTxtBx;

	@FindBy(xpath = "//div[@class='modal-footer']/button[contains(text(),'Save')]")
	public WebElement saveRecurrenceBtn;

	@FindBy(xpath = "//div[@class='modal-footer']/button[contains(text(),'Cancel')]")
	public WebElement cancelRecurrenceBtn;

	@FindBy (xpath = "//button[@title='More actions']/i")
	public WebElement moreActionsOnOrderBtn;

	@FindBy (id ="export-spreadsheet")
	public WebElement exportOrderBtn;

	@FindBy (id = "from_date")
	public WebElement fromDatePickUpWindow;

	@FindBy (id = "order_id")
	public WebElement orderIDInPickUpWindow;

	@FindBy (id= "btnSearch")
	public WebElement searchBtnInPickUpWindow;

	@FindBy (xpath = "//label[text()='Zip Codes']/../div/form/div/textarea")
	public WebElement zipCodeTextArea;
	@FindBy (xpath = "//span[text()='ACCEPT']")
	public WebElement acceptStatusCybersoure;


	/* @FindBy (xpath = "//label[text()='Distributions']/../div/span[@class='input-group-addon pointer']/i")
 public WebElement preprintDistributionSearchBtn;*/

	@FindBy (xpath = "//label[text()='Distributions']/../div/input")
	public WebElement preprintDistributionsTextBox;

	@FindBy (linkText = "Search/Browse")
	public WebElement distributionZoneSearchWindowLink;

	@FindBy (xpath = "//span[text()='Zone']/../../div[3]/div/div/input")
	public WebElement searchDrawPreprintDistributions;

	@FindBy (xpath = "//div[contains(text(),'total:')]")
	public WebElement totalDistributionsDisplayed;

	@FindBy (linkText = "Enter Text")
	public WebElement distributionZoneEnterTextLink;

	@FindBy (xpath = "//a[contains(text(),'Assigned')]")
	public WebElement assignedZonesLink;

	@FindBy (xpath = "//a[contains(text(),'Assigned')]/span")
	public WebElement countOfAssignedZones;

	@FindBy (xpath = "//label[contains(text(),'Full Run')]/input")
	public WebElement includeAllZonesChckBx;

	@FindBy (xpath = "//label[text()='Match Zone']")
	public WebElement enterTextMatchZoneBtn;

	@FindBy (xpath = "//label[text()='Match Zip']")
	public WebElement enterTextMatchZipBtn;

	@FindBy (xpath = "//textarea[@ng-model='vm.txtManualEntry']")
	public WebElement zoneZipEnterTextArea;

	@FindBy (id ="zoneGroup")
	public WebElement zoneGroupDrpDwn;

	@FindBy (id = "lineVersion")
	public WebElement lineVersionDrpDwn;

	@FindBy (xpath = "//button[text()='Include']")
	public WebElement clickOnIncludeZoneSelectedBtn;

	@FindBy (xpath = "//button[text()='Remove']")
	public WebElement clickOnRemoveZoneSelectedBtn;

	@FindBy (xpath = "//button[text()='Done']")
	public WebElement zoneSelectionConfirmBtn;

	@FindBy (xpath = "//button[text()='Done']/../button[text()='Cancel']")
	public WebElement zoneSelectionCancelBtn;


	//@FindBy (xpath = "//th[text()='Order ID']/../../../tbody/tr[1]/td[1]")
	@FindBy (xpath = "//div[@class='ui-grid-canvas']/div/div[@class='ng-isolate-scope']")
	public WebElement orderLinkInPickUpWindow;

	@FindBy (xpath = "//button[text()='Select']")
	public WebElement selectBtnInPickUpWindow;

	@FindBy (xpath = "//span[@ng-click='vm.openDistributionModal()']/i")
	public WebElement distributionSerchBtn;

	@FindBy (xpath = "//label[text()='Distributions']/../div/input")
	public WebElement distributionValue;

	@FindBy (xpath ="//button[contains(text(),'Assign')]")
	public WebElement assignDistributionBtn;

	@FindBy (xpath = "//button[contains(text(),'Assign')]/../button[text()='Cancel']")
	public WebElement cancelDistributionBtn; 

	@FindBy (id = "creditCardNumber")
	public WebElement creditCardNumber;

	@FindBy (id = "securityCode")
	public WebElement cVV;

	@FindBy (xpath = "//label[text()='Expiry Date*']/../div/div[1]/select")
	public WebElement expiryMonth;

	@FindBy (xpath = "//label[text()='Expiry Date*']/../div/div[2]/select")
	public WebElement expiryYear;

	@FindBy (id = "achAccountNumber")
	public WebElement accountACH;

	@FindBy (id = "achRoutingNumber")
	public WebElement routingACH;

	@FindBy (id = "achAccountType")
	public WebElement accountTypeACH;

	@FindBy (id = "firstName")
	public WebElement firstNameACH;

	@FindBy (id = "lastName")
	public WebElement lastNameACH;

	@FindBy (id = "street")
	public WebElement addressACH;

	@FindBy (id = "city")
	public WebElement cityACH;

	@FindBy (id = "state")
	public WebElement stateACH;

	@FindBy (id = "zipCode")
	public WebElement zipACH;

	@FindBy (id = "country")
	public WebElement countryACH;

	@FindBy (id = "email")
	public WebElement emailACH;

	@FindBy (id = "phone")
	public WebElement phoneACH;


	@FindBy (xpath ="//button[contains(text(),'Save')]")
	public WebElement saveBtnACH;

	@FindBy (id = "companyName")
	public WebElement name;

	@FindBy (id = "accountTypeId")
	public WebElement businessUnit;

	@FindBy (xpath = "//span[text()='New Order']")
	public WebElement NewOrderHeaderTxt;

	@FindBy (xpath = "//*[@id='app']/div[3]/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr/td[2]")
	public WebElement customerCUNumber;

	@FindBy (id = "Select1")
	public WebElement pricingGroup;

	@FindBy (id = "address1")
	public WebElement address;

	@FindBy (id = "Text2")
	public WebElement city;

	@FindBy (id = "Select5")
	public WebElement state;

	@FindBy (id = "Text4")
	public WebElement zip;

	@FindBy (id = "Text5")
	public WebElement email;

	@FindBy (id = "Text7")
	public WebElement termsemail;

	@FindBy (id = "Text6")
	public WebElement phone;

	@FindBy (id = "Select2")
	public WebElement category;

	@FindBy (id = "Select3")
	public WebElement subCategory;

	@FindBy (id = "history")
	public WebElement historyBtn; 

	@FindBy (id= "multiinit-bu")
	public WebElement multiInsertionBu;

	@FindBy (id = "multiinit-pubdate")
	public WebElement multiInsertionPubDate;

	@FindBy (id = "multiinit-producttype")
	public WebElement multiInsertionProductType;

	@FindBy (id = "multiinit-product")
	public WebElement multiInsertionProduct;

	@FindBy (id = "multiinit-section")
	public WebElement multiInsertionSection;

	@FindBy (id = "multiinit-adtype")
	public WebElement multiInsertionAdType;

	@FindBy (xpath = "//button[contains(text(),'Ok')]")
	public WebElement saveZoneSelectionBtn;

	//@FindBy (xpath = "//*[@id='order-detail-page']/div[2]/div[3]/form/div[2]/div[2]/label/input")
	@FindBy (xpath = "//*[@id='packageInfo']/div[2]/label/input")//swagata new

	public WebElement lockOrderLine;

	@FindBy (xpath = "//section[@class='panel-body accordion-body ng-scope']/p[1]/strong")
	public List<WebElement> errorMessage;

	@FindBy (xpath = "//span[@id='Span7']/../../form/div/select")
	public WebElement pandDPerforationDrpDwn;

	@FindBy (xpath = "//span[@id='Span8']/../../form/div/select")
	public WebElement pandDFoldDrpDwn;

	@FindBy (xpath = "//span[@id='Span9']/../../form/div/select")
	public WebElement pandDBinderyDrpDwn;

	@FindBy (xpath = "//span[@id='Span10']/../../form/div/select")
	public WebElement pandDCreativeLocDrpDwn;

	@FindBy (xpath = "//span[@id='Span11']/../../form/div/select")
	public WebElement pandDPaperStockDrpDwn;

	@FindBy (xpath = "//span[@id='Span12']/../../form/div/select")
	public WebElement pandDPaperColorDrpDwn;

	@FindBy (xpath = "//span[@id='Span13']/../../form/div/select")
	public WebElement pandDPaperWeightDrpDwn;

	@FindBy (xpath = "//span[@id='Span14']/../../form/div/select")
	public WebElement pandDOrientFrontDrpDwn;

	@FindBy (xpath = "//span[@id='Span15']/../../form/div/select")
	public WebElement pandDOrientBackDrpDwn;

	@FindBy (xpath = "//span[@id='Span16']/../../form/div/select")
	public WebElement pandDInkFrontDrpDwn;

	@FindBy (xpath = "//span[@id='Span17']/../../form/div/select")
	public WebElement pandDInkBackDrpDwn;

	@FindBy (xpath = "//span[@id='Span18']/../../form/div/select")
	public WebElement pandDBleedDrpDwn;

	@FindBy (xpath = "//span[@id='Span19']/../../form/div/select")
	public WebElement pandDBagColorDrpDwn;

	@FindBy (xpath = "//span[@id='Span20']/../../form/div/select")
	public WebElement pandDPrinterDrpDwn;

	@FindBy (xpath = "//*[@id='insertionInfo']/form/div/table/tbody/tr[2]/td/div/div/div/div[1]/div/div[1]/div[3]/div/form/div/select")
	public WebElement pageTypeDrpDwn;

	@FindBy (xpath = "//*[contains(text(), 'Page 1')]")
	public WebElement pageNumbersLink;

	@FindBy (xpath = "//input[@ng-model='displayChangeHistory']/../i")
	public WebElement checkToChangeHistoryCheckBox;

	@FindBy (xpath = "//div[@class='pull-left padder m-b-xs']/span/span")
	public WebElement orderStatusOVPage;
	@FindBy (css = "i.fa.fa-ellipsis-h")
	public WebElement threeDotIconInNewOrder;

	//@FindBy (xpath = "//div[@class='modal-footer ng-scope']/button[text()='Kill']")

	@FindBy (xpath = "html/body/div[1]/div/div/div[3]/button[1]")
	public WebElement killOrderButtonOnConformation;

	@FindBy (xpath = "//button[text()='Package']")
	public WebElement packageButton;

	@FindBy (xpath = "//a[text()='Save Package']")
	public WebElement savePackageButton;

	@FindBy (xpath = "//a[text()='Load Package']")
	public WebElement loadPackageButton;

	@FindBy (xpath = "//label/b[text()='Package Name']/../../input")
	public WebElement packageNameTextBox;

	@FindBy (xpath = "//label/b[text()='Package Description']/../../textarea")
	public WebElement packageDescription;

	@FindBy (xpath = "//label/b[text()='Effective From']/../../input")
	public WebElement packageEffectiveFromDate;

	@FindBy (xpath = "//label/b[text()='Effective To']/../../input")
	public WebElement packageEffectiveToDate;

	@FindBy (xpath = "//button[text()='Create']")
	public WebElement createPackageButton;


	@FindBy (xpath = "//a[text()='Update Package']")
	public WebElement updatePackageTab;

	@FindBy (xpath = "//button[text()='Update']")
	public WebElement updatePackageButton;

	@FindBy (xpath = "//button[text()='Load']")
	public WebElement loadPackageButtonLoadWindow;

	@FindBy (id = "btnCancel")
	public WebElement cancelLoadPackageButton;

	@FindBy (xpath = "//input[@ng-model='vm.replace']/../i")
	public WebElement replaceExistingInsertionsLoadPkg;

	@FindBy (xpath = "//button[text()='Replace']")
	public WebElement replacePackageButtonConfirmationWindow;

	@FindBy (xpath= "//button[text()='Yes']")
	public WebElement confirmLegacyAutoInsertion;
	@FindBy (xpath = "//div[contains(@class,'text-area-display')]")
	public WebElement displayMsg;//swagata

	@FindBy (xpath= "//button[text()='No']")
	public WebElement rejectLegacyAutoInsertion;

	@FindBy (xpath = "//button[text()='Continue']")
	public WebElement pastPubDateConfirmBtn; 

	@FindBy (xpath = "//button[text()='Continue']")
	public WebElement pastPubDeadlineConfirmBtn;

	@FindBy (xpath = "//span[contains(text(),'Total Amount:')]/../span[2]")
	public WebElement totalOrderPrice;

	@FindBy (xpath = "//button[text()='Make it free']")
	public WebElement confirmMakeOrderFreeBtn;

	@FindBy (xpath = "//button[text()='Keep as it is']")
	public WebElement rejectFreeOrderKeepAsItis;

	@FindBy (xpath = "//button[text()='Bundle']")
	public WebElement bundleButton;

	@FindBy (xpath = "//a[text()='Create Bundle']")
	public WebElement createBundleButton;

	@FindBy (xpath = "//label/b[text()='Bundle Name']/../../input")
	public WebElement bundleNameTextBox;


	@FindBy (xpath = "//input[@name='discountPct']")
	public WebElement bundleDiscountPercentTextBox;

	@FindBy (xpath = "//input[@name='discountAmt']")
	public WebElement bundleDiscountAmtTextBox;

	@FindBy (xpath = "//input[@name='bndlprice']")
	public WebElement bundlePriceAmtTextBox;//swagata
	@FindBy (xpath = "//button[@id='delete-order']")
	public WebElement deleteOrder;//swagata
	@FindBy(xpath = "//div[contains(text(),' Do you want to delete this order?')]//following::button[text()='Yes']")
	public WebElement YesButtonInDelete;//swagata
	@FindBy(xpath = "//span[contains(text(),'Deleted ')]")
	public WebElement deleteStatus;//swagata
	@FindBy(xpath = "//button[@id='undo-delete']")
	public WebElement undoButton;//swagata
	@FindBy(xpath = "//div[contains(text(),'Do you want to revert this order to Saved state?')]//following::button[text()='Yes']")
	public WebElement YesButtonInUndo;//swagata
	@FindBy(xpath = "//span[contains(text(),'Saved ')]")
	public WebElement savedStatus;//swagata 
	@FindBy (id = "bndlprice")
	public WebElement totalBundlePrice;

	@FindBy (id = "bsprice")
	public WebElement totalBundleBasePrice;

	@FindBy (xpath = "//a[text()='Clear Bundle']")
	public WebElement clearBundleButton; 

	@FindBy (xpath = "//button[text()='OK']")
	public WebElement okButton;

	@FindBy (id = "btnSaveTemplate")
	public WebElement saveBundleButton;

	@FindBy (id = "btnCancel")
	public WebElement cancelBundleButton;

	@FindBy (xpath = "//button[text()='OK']")
	public WebElement successOKLink;

	@FindBy (xpath = "//button[@title='More actions']")
	
	public WebElement moreActions;//swagata
	//@FindBy (xpath = "//a[text()='Request Adjustment History']")
	@FindBy (xpath = "//li[@tabindex='0']/a[text()='Request Adjustment History']")	//joy
	
	public WebElement requestAdjustmentHistoryButton;//swagata
	
	@FindBy (xpath = "//select[contains(@ng-model,'AccountabilityID')]")
	public WebElement adjustmentAccountability;//swagata

	private WebDriver driver;

	Properties properties = TribuneUtils.readProperties();
	TribuneUtils utils = new TribuneUtils();

	public NewOrderPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public void scrollToElement(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}


	/**
	 * @description This method return the status of the order from the order view page
	 */
	public String getOrdeStatusOrderViewPage() throws Exception
	{
		String orderStatus = "";
		if(orderStatusOVPage.isDisplayed())
		{
			orderStatus = orderStatusOVPage.getText().trim();//swagata
			Logger.info("order status is displayed");
		}
		else{
			Logger.info("order status is not displayed");
		}
		return orderStatus;
	}

	public String getCustomerCUNumber() throws Exception
	{
		String orderStatus = "";
		if(customerCUNumber.isDisplayed())
		{
			orderStatus = customerCUNumber.getText();
		}
		else{
			Logger.info("customerCUNumber is not displayed");
		}
		return orderStatus;
	}

	//code to select the business for searching a sold to customer
	public void selectSoldToCustomerBU(String businessUnit) throws Exception
	{
		switch (businessUnit)

		{
		case "bu_LAT":  businessUnit = "bu_CTC";       break;
		case "bu_SDT":  businessUnit = "bu_HTF";       break;


		} 
		WebDriverWait wait = new WebDriverWait(driver,120);//swagata
		wait.until(ExpectedConditions.visibilityOf(soldToCustomerBU));//swagata
		try{
			if(soldToCustomerBU.isDisplayed())
			{
				Select selectBU = new Select(soldToCustomerBU);
				selectBU.selectByVisibleText(properties.getProperty(businessUnit));
				Logger.info(businessUnit+" Busines Unit is selected for Sold to");
			}
			else{
				Logger.info("Sold to customer business unit drop down is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	public void selectNewInsertionBUCheck(String businessUnit) throws Exception
	{

		try{


			boolean flag = true;
			String buElementPath = "/tr[1]/td/div/a/span[@id='Span4']/span"; 
			WebElement buInsertionElement = driver.findElement(By.xpath("//tbody[1]"+buElementPath));
			buInsertionElement.click();
			//WebElement buList = driver.findElement(By.xpath("//div[@class='editable-controls form-group']/select"));
			WebElement buList = driver.findElement(By.xpath("//div[@class='editable-controls form-group']/select"));

			Select selectBU = new Select(buList);
			List<WebElement> listOfValuesBU = selectBU.getOptions();
			flag = listOfValuesBU.contains(businessUnit);

			//selectBU.selectByVisibleText(businessUnit);
			// Logger.info(businessUnit+" business Unit is selected"); 

			if(flag==true){
				Logger.info(businessUnit+" Busines Unit is selected for Sold to");
			}
			else{
				Logger.info("BU is not present test case is passed");
			}





		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}


	}//mou

	public String getOrderFromExcel(int row, int col) throws Exception
	{
		try{
			String order = TribuneUtils.getStringCellValues("KillOrders",row, col);
			return order;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	//code to enter the sold to customer details
	public void enterSoldToCustomer(String customer) throws Exception
	{

		switch (customer)

		{
		case "CU00059747":  customer = "CU00037236";       break; 

		case "CU00475251":  customer = "CU00250481";       break;


		} 

		try{
			if (soldToCustomer.isEnabled())
			{
				Logger.info("Sold To customer text box is visible");
				soldToCustomer.click();
				soldToCustomer.sendKeys(Keys.CONTROL,"a");
				soldToCustomer.clear();
				soldToCustomer.sendKeys(customer);
				soldToCustomer.sendKeys(Keys.ENTER);
				//Thread.sleep(15000);//swagata
				WebElement customerDetails = driver.findElement(By.xpath("//a[@class='customer-aclist-item ng-scope']/div/span[3]"));
				WebDriverWait wait = new WebDriverWait(driver, 200);//swagata
				wait.until(ExpectedConditions.visibilityOf(customerDetails));
				customerDetails.click();
				Thread.sleep(2000);
				Logger.info(customer+ " sold To customer is entered");
			}
			else
			{
				Logger.info("Sold To customer text box is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void validateInvalidSoldToCustomer(String customer) throws Exception
	{
		try{
			if (soldToCustomer.isEnabled())
			{
				Logger.info("Sold To customer text box is visible");
				soldToCustomer.click();
				soldToCustomer.sendKeys(Keys.CONTROL,"a");
				soldToCustomer.clear();
				soldToCustomer.sendKeys(customer);
				soldToCustomer.sendKeys(Keys.ENTER);
				Thread.sleep(4000);
				WebElement customerDetails = driver.findElement(By.xpath(".//*[@id='accountInfo']/div/form/div[1]/div[2]/div[1]/div/customer-finder-order/div/div/span"));
				WebDriverWait wait = new WebDriverWait(driver, 120);
				wait.until(ExpectedConditions.visibilityOf(customerDetails));
				String message = customerDetails.getText();
				Thread.sleep(2000);
				Logger.info(customer+ " sold To customer is entered and message displayed is : "+message);
			}
			else
			{
				Logger.info("Sold To customer text box is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select the business for searching a bill to customer
	public void selectBillToCustomerBU(String businessUnit) throws Exception
	{
		try{
			if(billToCustomerBU.isDisplayed())
			{
				Select selectBU = new Select(billToCustomerBU);
				selectBU.selectByVisibleText(properties.getProperty(businessUnit));
				Logger.info(businessUnit+" Busines Unit is selected for Bill to");
			}
			else{
				Logger.info("Bill to customer business unit drop down is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to enter bill to customer
	public void enterBillToCustomer(String customer) throws Exception
	{
		try{
			if (billToCustomer.isEnabled())
			{
				Logger.info("Bill To customer text box is visible");
				billToCustomer.click();
				billToCustomer.sendKeys(Keys.CONTROL,"a");
				billToCustomer.clear();
				billToCustomer.sendKeys(customer);
				billToCustomer.sendKeys(Keys.ENTER);
				//Thread.sleep(60000);//swagata
				WebElement customerDetails = driver.findElement(By.xpath("//a[@class='customer-aclist-item ng-scope']/div/span[3]"));
				WebDriverWait wait = new WebDriverWait(driver, 120);
				wait.until(ExpectedConditions.visibilityOf(customerDetails));
				customerDetails.click();
				Thread.sleep(2000);
				Logger.info(customer+" Bill To customer is entered");
			}
			else
			{
				Logger.info("Bill To customer text box is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void validateInvalidBillToCustomer(String customer) throws Exception
	{
		try{
			if (billToCustomer.isEnabled())
			{
				Logger.info("Bill To customer text box is visible");
				billToCustomer.click();
				billToCustomer.sendKeys(Keys.CONTROL,"a");
				billToCustomer.clear();
				billToCustomer.sendKeys(customer);
				billToCustomer.sendKeys(Keys.ENTER);
				WebElement customerDetails = driver.findElement(By.xpath(".//*[@id='accountInfo']/div/form/div[2]/div[2]/div[1]/div/customer-finder-order/div/div/span"));
				WebDriverWait wait = new WebDriverWait(driver, 120);
				wait.until(ExpectedConditions.visibilityOf(customerDetails));
				String message = customerDetails.getText();
				Thread.sleep(2000);
				Logger.info(customer+ " Bill To customer is entered and message displayed is : "+message);
			}
			else
			{
				Logger.info("Bill To customer text box is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to select the order type
	public void selectOrderType(String order) throws Exception
	{
		try
		{
			//String orderTypeVisible = orderType.getText(); 
			if(orderType.getText().equalsIgnoreCase(properties.getProperty(order).toString()))
			{
				Logger.info(properties.getProperty(order).toString() + " order type is already selected");
			}
			else
			{
				orderType.click();
				WebElement orderTypeDrpDwn = driver.findElement(By.xpath("//div[@class='editable-controls form-group']/select"));
				Select selectOrderType = new Select(orderTypeDrpDwn);
				selectOrderType.selectByVisibleText(properties.getProperty(order).toString());
				Logger.info(properties.getProperty(order).toString()+ " order type is selected");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to select the Make Good Reason
	public void selectMakeGoodReason(String order) throws Exception
	{
		try
		{ 

			driver.findElement(By.xpath("//*[@id='Span17']/span")).click();
			WebElement orderTypeDrpDwn = driver.findElement(By.xpath("//div[@class='editable-controls form-group']/select"));
			Select selectOrderType = new Select(orderTypeDrpDwn);
			selectOrderType.selectByVisibleText(order);
			Logger.info(order+ " make good reason is selected");

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to select the Make Good Accountability
	public void selectMakeGoodAccountability(String order) throws Exception
	{
		try
		{ 

			driver.findElement(By.xpath("//*[@id='Span18']/span")).click();
			WebElement orderTypeDrpDwn = driver.findElement(By.xpath("//div[@class='editable-controls form-group']/select"));
			Select selectOrderType = new Select(orderTypeDrpDwn);
			selectOrderType.selectByVisibleText(order);
			Logger.info(order+ " make good accountability is selected");

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to select the Make Good Accountability
	public void selectFirstDisplayMakeGoodInsertion() throws Exception
	{
		try
		{ 

			driver.findElement(By.xpath("//*[@id='order-info']/div/div[3]/dl/dd[3]/i")).click();

			Thread.sleep(5000);

			driver.findElement(By.xpath("((//div[text()='Display'])[1])")).click();

			driver.findElement(By.xpath("//button[text()='Select']")).click();

			Logger.info(" make good insertion is selected");

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to select the order routing
	public void selectOrderRouting(String orderRoutingValue) throws Exception
	{
		try
		{
			orderRouting.click();
			WebDriverWait wait=new WebDriverWait(driver, 20); //mousumi
			WebElement orderRoutingDrpDwn = driver.findElement(By.xpath("//div[@class='editable-controls form-group']/select"));
			Select selectOrderType = new Select(orderRoutingDrpDwn);
			selectOrderType.selectByVisibleText(properties.getProperty(orderRoutingValue).toString());
			Logger.info(properties.getProperty(orderRoutingValue).toString() + " order routing is selected");
			Thread.sleep(4000);
			enterComments();
			Thread.sleep(4000);
			selectPaymentType("Cash");
			Thread.sleep(4000);
			enterCashReceipt("Test123");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void checkUncheckCondensedStatement(boolean value) throws Exception
	{
		try{
			WebElement element = driver.findElement(By.xpath("//input[@ng-model='vm.order.IsCondensedStatement']"));
			String checkCriteria = element.getAttribute("class");
			if(value)
			{
				if(checkCriteria.equalsIgnoreCase("ng-pristine ng-untouched ng-valid ng-not-empty")){
					Logger.info("Condensed Statement is already checked");
				}
				else {
					condensedStatementCheckBox.click();
					Logger.info("Condensed Statement is checked");
				}
			}
			else{
				if(checkCriteria.equalsIgnoreCase("ng-pristine ng-untouched ng-valid ng-not-empty")){
					condensedStatementCheckBox.click();
					Logger.info("Condensed Statement is unchecked");
				}
				else {
					Logger.info("Condensed Statement is already unchecked");
				}
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public boolean verifycheckUncheckCondensedStatement(boolean value) throws Exception
	{
		try{
			WebElement element = driver.findElement(By.xpath("//input[@ng-model='vm.order.IsCondensedStatement']"));
			String checkCriteria = element.getAttribute("class");
			if(value)
			{
				if(checkCriteria.equalsIgnoreCase("ng-pristine ng-untouched ng-valid ng-not-empty")){
					Logger.info("Condensed Statement is already checked");
					return true;
				}
				else {

					Logger.info("Condensed Statement is not checked");
					return false;
				}
			}
			else{
				if(checkCriteria.equalsIgnoreCase("ng-pristine ng-untouched ng-valid ng-not-empty")){

					Logger.info("Condensed Statement is not unchecked");
					return false;
				}
				else {
					Logger.info("Condensed Statement is already unchecked");
					return true;
				}
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectPaymentType(String orderPaymentTypeValue) throws Exception
	{
		try
		{
			paymentRouting.click();
			Logger.info("payment Routing dropdown is clicked");
			Thread.sleep(3000);
			WebElement paymentDrpDwn = driver.findElement(By.xpath("//dt[contains(text(),'Payment Type')]/../dd[5]/form/div/select"));
			Select selectPaymentType = new Select(paymentDrpDwn);
			List<WebElement> listOfValuesPymnt = selectPaymentType.getOptions();
			Logger.info("Size :" +listOfValuesPymnt.size() );		
			selectPaymentType.selectByVisibleText(orderPaymentTypeValue);
			Logger.info(orderPaymentTypeValue+ " payment routing is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to select the payment routing
	public void selectPaymentType1(String orderPaymentTypeValue) throws Exception
	{
		try
		{
			paymentTab.click();//swagata
			Logger.info("payment Routing dropdown is clicked");
			Thread.sleep(3000);
			WebElement paymentButton = driver.findElement(By.xpath("//*[@id='payments']/div/div/div[1]/div/div[4]/button"));
			paymentButton.click();
			Thread.sleep(3000);
			WebElement paymentDrpDwn = driver.findElement(By.xpath("//*[@id='selectcard']"));
			Select selectPaymentType = new Select(paymentDrpDwn);
			List<WebElement> listOfValuesPymnt = selectPaymentType.getOptions();
			Logger.info("Size :" +listOfValuesPymnt.size() );		
			selectPaymentType.selectByVisibleText(orderPaymentTypeValue);
			Logger.info(orderPaymentTypeValue+ " payment routing is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterPaymentAmount(String amt) throws Exception
	{
		try
		{
			WebElement paymentButton = driver.findElement(By.xpath("//*[@id='amount']"));
			paymentButton.click();
			Thread.sleep(3000);
			paymentButton.sendKeys(amt);
			Logger.info(amt+ " amount entered");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickPayButton() throws Exception
	{
		try
		{
			WebElement paymentButton = driver.findElement(By.xpath("//*[@ng-click='vm.processPayment()']"));
			paymentButton.click();
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to select the payment credit card type
	public void selectCardType(String cardTypeValue) throws Exception
	{
		try
		{
			cardType.click();//swagata
			Logger.info("card type dropdown is clicked");
			Thread.sleep(3000);
			WebElement cardDrpDwn = driver.findElement(By.xpath("//dt[contains(text(),'Payment Type')]/../dd[6]/form/div/select"));
			Select selectCardType = new Select(cardDrpDwn);
			List<WebElement> listOfValuesPymnt = selectCardType.getOptions();
			Logger.info("Size :" +listOfValuesPymnt.size() );		
			selectCardType.selectByVisibleText(cardTypeValue);
			Logger.info(cardTypeValue+ " card type is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	//Code to select the payment credit card type
	public void selectCardType1(String cardTypeValue) throws Exception
	{
		try
		{
			WebElement cardDrpDwn = driver.findElement(By.xpath("//*[@id='accounts']"));
			Select selectCardType = new Select(cardDrpDwn);
			List<WebElement> listOfValuesPymnt = selectCardType.getOptions();
			Logger.info("Size :" +listOfValuesPymnt.size() );		
			selectCardType.selectByVisibleText(cardTypeValue);
			Logger.info(cardTypeValue+ " card type is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to select the payment credit card type
	public void enterCheckDetails(String cardTypeValue) throws Exception
	{
		try
		{
			driver.findElement(By.xpath(".//*[@id='Span7']/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='order-info']/div/div[1]/dl/dd[6]/form/div/input")).sendKeys("4100");
			Thread.sleep(2000);
			//***********
			Logger.info(cardTypeValue+ " card type is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	//Code to enter the tag for an order
	public void entertag() throws Exception
	{
		try
		{
			tagTextBox.click();
			WebElement tagElement = driver.findElement(By.xpath("//div[@class='editable-controls form-group']/input"));
			TribuneUtils utils = new TribuneUtils();
			String tag = utils.generateRandomAlphaNumString(4);
			tagElement.sendKeys(tag);
			Logger.info(tag +" tag is entered");
			orderInfoElement.click();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterCashReceipt(String receipt) throws Exception
	{
		try
		{
			cashReceiptTextBox.click();
			WebElement poNumElement = driver.findElement(By.xpath("//div[@class='editable-controls form-group']/input"));
			poNumElement.sendKeys(receipt);
			Logger.info(receipt +" receipt number is entered");
			orderInfoElement.click();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to enter the PO number for an order
	public void enterPoNumber(String ponum) throws Exception
	{
		try
		{
			ponumberTextBox.click();
			WebElement poNumElement = driver.findElement(By.xpath("//div[@class='editable-controls form-group']/input"));
			poNumElement.sendKeys(ponum);
			Logger.info(ponum +" PO number is entered");
			orderInfoElement.click();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void entercampaignName(String campaign) throws Exception
	{
		try
		{
			campaignTextBox.click();
			WebElement poNumElement = driver.findElement(By.xpath("//div[@class='editable-controls form-group']/input"));
			poNumElement.sendKeys(campaign);
			Logger.info(campaign +" campaign name is entered");
			orderInfoElement.click();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to enter the description for an order
	public void enterDescription() throws Exception
	{
		try
		{
			descriptionTextBox.click();
			WebElement descElement = driver.findElement(By.xpath("//dt[contains(text(),'Description')]/../dd[1]/div/form/div[@class='editable-controls form-group']/textarea"));
			TribuneUtils utils = new TribuneUtils();
			String description = utils.generateRandomAlphaNumString(21);
			descElement.sendKeys(description);
			Logger.info("Description entered is '"+description+"'");
			orderInfoElement.click();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to enter the description for an order
	public void enterItemDescription(String description,int insertion) throws Exception
	{
		try
		{

			WebElement descElement = driver.findElement(By.xpath("(//label[contains(text(),'End Date / Desc')]/..//input[2])["+insertion+"]"));

			descElement.click();
			descElement.clear();
			descElement.sendKeys(description);
			Logger.info("Description entered is '"+description+"'");

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to enter the description for an order
	public void enterItemQuantity(String quantity, int insertion) throws Exception
	{
		try
		{

			WebElement qtyElement = driver.findElement(By.xpath("(//label[contains(text(),'Quantity')]/..//input)["+insertion+"]"));

			qtyElement.click();
			qtyElement.clear();
			qtyElement.sendKeys(quantity);
			Logger.info("Description entered is '"+quantity+"'");

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to enter the comments for an order
	public void enterComments() throws Exception
	{
		try
		{
			commentsTextBox.click();
			WebElement commentsElement = driver.findElement(By.xpath("//dt[contains(text(),'Comments')]/../dd[2]/form/div[@class='editable-controls form-group']/textarea"));
			TribuneUtils utils = new TribuneUtils();
			// String comments = utils.generateRandomAlphaNumString(12);
			commentsElement.sendKeys("Test Ad Through Automation");
			Logger.info("Comments entered ");
			orderInfoElement.click();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to get the own local opt output element text
	public boolean getOwnLocalOptOut()throws Exception
	{
		try{
			if(ownLocalOptOutLabel.isDisplayed())
			{
				String text = ownLocalOptOutLabel.getText();
				if(text.equalsIgnoreCase("OwnLocal Opt Out"))
				{
					return true;
				}
				else{
					return false;
				}
			}
			else{
				Logger.info("own local opt out element is not displayed");
				return false;
			}
		}
		catch(Exception e)
		{
			return false;
		}
	}

	//Code to enter the InvoiceNote for an order
	public void enterInvoiceNote() throws Exception
	{
		try
		{
			invoiceNoteTextBox.click();
			WebElement invoiceNoteElement = driver.findElement(By.xpath("//div[@class='editable-controls form-group']/input"));
			TribuneUtils utils = new TribuneUtils();
			invoiceNoteElement.sendKeys(utils.generateRandomString());
			Logger.info(" InvoiceNote is entered");
			orderInfoElement.click();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to check the visibility of invoice note
	public boolean checkInvoiceNoteVisibility() throws Exception
	{
		try{
			if( invoiceNoteTextBox.isDisplayed())
			{
				Logger.info("Invoice Note is displayed");
				return true;
			}
			else{
				Logger.info("Invoice Note is not displayed");
				return false;
			}
		}
		catch(Exception e)
		{
			Logger.info("Invoice Note is not displayed");
			return false;
		}
	}

	//Code to enter the Coupon for an order
	public void enterCoupon() throws Exception
	{
		try
		{
			couponTextBox.click();
			WebElement couponElement = driver.findElement(By.xpath("//div[@class='editable-controls form-group']/input"));
			TribuneUtils utils = new TribuneUtils();
			couponElement.sendKeys(utils.generateRandomString());
			Logger.info(" Coupon is entered");
			orderInfoElement.click();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to check the visibility of coupon in order info section
	public boolean checkCouponVisibility() throws Exception
	{
		try{
			if(couponTextBox.isDisplayed()){
				Logger.info("Coupon is displayed");
				return true;
			}
			else{
				Logger.info("Coupon is not displayed");
				return false;
			}
		}
		catch(Exception e)
		{
			Logger.info("Coupon is not displayed");
			return false;
		}
	}

	//Code to enter the legacy order number for an order
	public void enterLegacyOrderNo(String legacyOrder) throws Exception
	{
		try
		{
			legacyOrderTextBox.click();
			WebElement legacyOrderNoElement = driver.findElement(By.xpath("//div[@class='editable-controls form-group']/input"));
			legacyOrderNoElement.sendKeys(legacyOrder);
			Logger.info(legacyOrder +" legacy Order number is entered");
			orderInfoElement.click();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to check the visibility of legacy order no in an insertion order
	public boolean checkLegacyOrdNoVisibility() throws Exception
	{
		try{
			if(legacyOrderTextBox.isDisplayed())
			{
				Logger.info("Legacy order number is displayed");
				return true;
			}
			else{
				Logger.info("Legacy order number is not displayed");
				return false;
			}
		}
		catch(Exception e)
		{
			Logger.info("Legacy order number is not displayed");
			return false;
		}
	}

	//Code to check if the plus ticket system number is displayed as ExternalReference number for an insertion order
	public boolean checkIOExternalReferenceNo() throws Exception
	{
		try
		{
			String exRefNum = externalReferenceNoElement.getText();
			if(exRefNum.substring(0, 5).equalsIgnoreCase("PLUS:"))
			{
				Logger.info("Plus ticket number is displayed as external reference number");
				return true;
			}
			else{
				Logger.info("Plus ticket number is not displayed as external reference number");
				return false;
			}

		}
		catch(Exception e)
		{
			Logger.info("Plus ticket number is not displayed as external reference number");
			return false;
		}
	}

	//Code to enter the ExternalReference number for an order
	public String getIOExternalReferenceNo() throws Exception
	{
		String exRefNum = "";
		try
		{
			exRefNum = externalReferenceNoElement.getText();
			return exRefNum.substring(5, exRefNum.length());
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to create a new insertion
	public void createNewInsertion() throws Exception
	{
		try
		{
			JavascriptExecutor js = ((JavascriptExecutor) driver);//swagata

			if(newInsertionButton.isDisplayed())
			{
				js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				js.executeScript("arguments[0].scrollIntoView(true);", newInsertionButton);//swagata
				newInsertionButton.click();
				Logger.info("new button is clicked");
				newInsertionElement.click();
				Logger.info("New insertion is clicked under new button");



			}
			else
			{
				Logger.info("new button is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	//refreshDrawButton
	public void clickRefreshDraw() throws Exception
	{
		Thread.sleep(4000); 

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		// js.executeScript("window.scrollTo(0, 400);");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", refreshDrawButton);
		Thread.sleep(4000); 
		try
		{
			if(refreshDrawButton.isDisplayed())
			{
				refreshDrawButton.click();
				Logger.info("refresh Draw Button is clicked");

			}
			else
			{
				Logger.info("refresh Draw button is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to create a new insertion
	public void createNewClassifiedInsertion() throws Exception
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		Thread.sleep(4000);
		try
		{
			if(newInsertionButton.isDisplayed())
			{
				newInsertionButton.click();
				Logger.info("new button is clicked");
				newClassifiedInsertionElement.click();
				Logger.info("New Classified insertion is clicked under new button");
			}
			else
			{
				Logger.info("new button is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void createNewDigitalOrder() throws Exception
	{
		try
		{
			if(newInsertionButton.isDisplayed())
			{
				newInsertionButton.click();
				Logger.info("new button is clicked");
				newDigitalOrderElement.click();
				Logger.info("New Digital Order is clicked under new button");
			}
			else
			{
				Logger.info("new button is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to create multi insertions with zones
	public void createMultiInsertionWZones() throws Exception
	{
		try
		{
			if(newInsertionButton.isDisplayed())
			{
				newInsertionButton.click();
				Logger.info("new button is clicked");
				multiInsertionWZonesElement.click();
				Thread.sleep(1000);
				Logger.info("New insertion is clicked under new button");
			}
			else
			{
				Logger.info("new button is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select the business unit
	public void  selectBU(String insertionIndex,int row, int col) throws Exception
	{
		try
		{
			String value = TribuneUtils.getStringCellValues("Product",row, col);
			String buElementPath = "/tr[1]/td/div/a/span[@id='Span4']/span"; 
			WebElement buInsertionElement = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+buElementPath));
			buInsertionElement.click();
			Thread.sleep(4000);
			WebElement buList = driver.findElement(By.xpath("//div[@class='editable-controls form-group']/select"));
			Select selectBU = new Select(buList);
			List<WebElement> listOfValuesBU = selectBU.getOptions();
			if(listOfValuesBU.size() !=0)
			{
				selectBU.selectByVisibleText(value);
				Logger.info(value+" business Unit is selected"); 
			}
			else
			{
				Logger.info("drop down is empty");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to enter the pub date
	public void enterPubDate(String insertionIndex,String date, String month, String year) throws Exception
	{
		// viewInsertionDetails(insertionIndex);//payel
		month = setMonthName(month);
		Logger.info("month name is "+month);
		if (date.length() == 1)
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

		Logger.info("Date number is "+date);
		String pubDatePath = "/tr[1]/td[5]/div/span[1]/span"; 
		WebElement pubDate = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+pubDatePath));
		pubDate.click();
		Thread.sleep(4000);
		String calenderPath = "/tr[1]/td[5]/div/span[2]/span/button"; 
		//String calenderPath = "/tr[1]/td[5]/div/span[2]/span/button/i"; 
		WebElement calendericon = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+calenderPath));
		calendericon.click();
		WebElement curentMonthElement = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm uib-title']/strong"));
		String currentMonthYear = curentMonthElement.getText();
		Logger.info("current month year from calendar "+currentMonthYear);
		String expectedDate = month + " " + year;
		Logger.info("expected month year from user " +expectedDate);
		if(currentMonthYear.equalsIgnoreCase(expectedDate))
		{
			WebElement dateElement = driver.findElement(By.xpath("//td[@class='uib-day text-center ng-scope']//*[text()='"+date+"']"));
			dateElement.click();
			Logger.info(date+"/"+month+"/"+year +" is entered");
		}
		else
		{
			int length = currentMonthYear.length();
			String currentyear = currentMonthYear.substring(length-4, length);
			Logger.info(currentyear+" is currentyear");
			if(currentyear.equalsIgnoreCase(year))
			{
				curentMonthElement.click();
				WebElement expectedMonthElement = driver.findElement(By.xpath("//button[@class='btn btn-default']/span[text()='"+month+"']"));
				expectedMonthElement.click();
				WebElement dateElement = driver.findElement(By.xpath("//td[@class='uib-day text-center ng-scope']//*[text()='"+date+"']"));
				dateElement.click();
				Logger.info(date+"/"+month+"/"+year +" is entered");
			}
			else
			{
				curentMonthElement.click();
				WebElement yearElement = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm uib-title']/strong"));
				yearElement.click();
				WebElement expectedYearElement = driver.findElement(By.xpath("//button[@class='btn btn-default']/span[text()='"+year+"']"));
				if(expectedYearElement.isDisplayed())
				{

					expectedYearElement.click();
					Logger.info("expectedYearElement is entered");//swagata
					Thread.sleep(4000);
					WebElement expectedMonthElement = driver.findElement(By.xpath("//button[@ng-click='select(dt.date)']/span[text()='"+month+"']"));//swagata
					expectedMonthElement.click();
					WebElement dateElement = driver.findElement(By.xpath("//td[@class='uib-day text-center ng-scope']//*[text()='"+date+"']"));
					dateElement.click();
					Logger.info(date+"/"+month+"/"+year +" is entered");
				}
				else
				{
					WebElement next = driver.findElement(By.xpath("//th/button[@class='btn btn-default btn-sm pull-right uib-right']/i"));
					next.click();
					driver.findElement(By.xpath("//button[@class='btn btn-default']/span[text()='"+year+"']")).click();
					driver.findElement(By.xpath("//button[@class='btn btn-default']/span[text()='"+month+"']")).click();
					driver.findElement(By.xpath("//td[@class='uib-day text-center ng-scope']//*[text()='"+date+"']")).click();
					Logger.info(date+"/"+month+"/"+year +" is entered");
				}
			}
		}
		//  viewInsertionDetails(insertionIndex);//payel
	}

	public void enterPubDateWithoutCalender(String BU) throws Exception
	{

		WebElement pubDate = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[5]/div/span[1]/span"));
		pubDate.click();
		Thread.sleep(4000);
		WebElement pubDateTextBox = driver.findElement(By.xpath("//*[@id='insertionInfo']/form/div/table/tbody/tr[1]/td[5]/div/span[2]/input"));

		try
		{
			if (pubDateTextBox.isDisplayed())
			{
				pubDateTextBox.click();
				Thread.sleep(2000);
				pubDateTextBox.sendKeys(""+BU);
				pubDateTextBox.sendKeys(Keys.CONTROL, "a");
				pubDateTextBox.sendKeys(Keys.CONTROL, "\b");
				Thread.sleep(2000);
				pubDateTextBox.sendKeys(""+BU);
				Thread.sleep(2000);
				Logger.info("Pub Date entered :"+BU);
			}
			else
			{
				Logger.info("Pub Date textbox is not displayed");
				throw new NoSuchElementException("Pub Date textbox  is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void enterPubDateFromExcel(String insertionIndex,int row, int col) throws Exception
	{
		
		//viewInsertionDetails("1");
		//viewInsertionDetails(insertionIndex);//swagata
		String value = TribuneUtils.getStringCellValues("Product",row, col);
		Logger.info("Date from excel "+value);

		//  String value = TribuneUtils.getStringCellValues("Product",row, col);
		String[] parts = value.split("/");
		String date = parts[1];
		Logger.info("Date "+date);
		String month = parts[0];
		Logger.info("month "+month);
		String year = parts[2];	  
		Logger.info("year "+year);
		month = setMonthName(month);
		Logger.info("month name is "+month);
		if (date.length() == 1)
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

		Logger.info("Date number is "+date);
		String pubDatePath = "/tr[1]/td[5]/div/span[1]/span"; 
		WebElement pubDate = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+pubDatePath));
		pubDate.click();
		Thread.sleep(4000);
		String calenderPath = "/tr[1]/td[5]/div/span[2]/span/button"; 
		WebElement calendericon = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+calenderPath));
		calendericon.click();
		WebElement curentMonthElement = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm uib-title']/strong"));
		String currentMonthYear = curentMonthElement.getText();
		//  String[] parts1 = currentMonthYear.split(" ");
		//  currentMonthYear = parts1[0];
		Logger.info("current month year from calendar "+currentMonthYear);
		String expectedDate = month + " " + year;
		Logger.info("expected month year from user " +expectedDate);
		try
		{
		if(currentMonthYear.equalsIgnoreCase(expectedDate))
		{
			WebElement dateElement = driver.findElement(By.xpath("//td[@class='uib-day text-center ng-scope']//*[text()='"+date+"']"));

			/*	  WebElement dateElement2 = driver.findElement(By.xpath("(//td[@class='uib-day text-center ng-scope']//*[text()='"+date+"'])[2]"));
		  if (driver.findElement(By.xpath("(//td[@class='uib-day text-center ng-scope']//*[text()='"+date+"'])[2]")).isDisplayed())
		  {
			  driver.findElement(By.xpath("(//td[@class='uib-day text-center ng-scope']//*[text()='"+date+"'])[2]")).click();
		  }
		  else
		  { 
			  dateElement.click();
		  }*/

			dateElement.click();
			Logger.info(date+"/"+month+"/"+year +" is entered");
		}
		else
		{
			int length = currentMonthYear.length();
			String currentyear = currentMonthYear.substring(length-4, length);
			Logger.info(currentyear+" is currentyear");
			if(currentyear.equalsIgnoreCase(year))
			{
				curentMonthElement.click();
				WebElement expectedMonthElement = driver.findElement(By.xpath("//button[@class='btn btn-default']/span[text()='"+month+"']"));
				expectedMonthElement.click();
				WebElement dateElement = driver.findElement(By.xpath("//td[@class='uib-day text-center ng-scope']//*[text()='"+date+"']"));
				/*  WebElement dateElement2 = driver.findElement(By.xpath("(//td[@class='uib-day text-center ng-scope']//*[text()='"+date+"'])[2]"));
		  if (dateElement2.isDisplayed())
		  {
			  dateElement2.click();
		  }
		  else
		  {
			  dateElement.click();
		  }*/
				dateElement.click();
				Logger.info(date+"/"+month+"/"+year +" is entered");
			}
			else
			{
				curentMonthElement.click();
				WebElement yearElement = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm uib-title']/strong"));
				yearElement.click();
				
				
				//if(expectedYearElement.isDisplayed())
				//Partha
				if(driver.findElements(By.xpath("//button[@class='btn btn-default']/span[text()='"+year+"']")).size()>0)
				{
					WebElement expectedYearElement = driver.findElement(By.xpath("//button[@class='btn btn-default']/span[text()='"+year+"']"));
					Logger.info("expectedYearElement is value greater than 0");
					expectedYearElement.click();
					Logger.info("expectedYearElement is entered");
					Thread.sleep(4000);
					WebElement expectedMonthElement = driver.findElement(By.xpath("//button[@ng-click='select(dt.date)']/span[text()='"+month+"']"));
					expectedMonthElement.click();
					WebElement dateElement = driver.findElement(By.xpath("//td[@class='uib-day text-center ng-scope']//*[text()='"+date+"']"));
					/*  WebElement dateElement2 = driver.findElement(By.xpath("(//td[@class='uib-day text-center ng-scope']//*[text()='"+date+"'])[2]"));
				  if (dateElement2.isDisplayed())
				  {
					  dateElement2.click();
				  }
				  else
				  {
					  dateElement.click();
				  }
					 */
					dateElement.click();
					Logger.info(date+"/"+month+"/"+year +" is entered");
				}
				else
				{
					Logger.info("expectedYearElement is value less than 0");
					WebElement next = driver.findElement(By.xpath("//th/button[@class='btn btn-default btn-sm pull-right uib-right']/i"));
					next.click();
					//Logger.info("next buttoni is clicked");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//button[@class='btn btn-default']/span[text()='"+year+"']")).click();
					driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]/span[text()='"+month+"']")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//td[@class='uib-day text-center ng-scope']//*[text()='"+date+"']")).click();
					Logger.info(date+"/"+month+"/"+year +" is entered");
				}
			}
		}
		}
		catch(Exception e){
			Logger.info("expectedYearElement is value less than 0");
			WebElement next = driver.findElement(By.xpath("//th/button[@class='btn btn-default btn-sm pull-right uib-right']/i"));
			next.click();
			//Logger.info("next buttoni is clicked");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='btn btn-default']/span[text()='"+year+"']")).click();
			driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]/span[text()='"+month+"']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[@class='uib-day text-center ng-scope']//*[text()='"+date+"']")).click();
			Logger.info(date+"/"+month+"/"+year +" is entered");
		}
		//viewInsertionDetails("1");
		//viewInsertionDetails(insertionIndex);//swagata
	}
	//code to select second position from the position selector written by payel
	public void selectsecondPostionFrmPositionSlctr() throws Exception
	{
		try{
			Thread.sleep(42000);
			List<WebElement> positionAvailabilityList1 = driver.findElements(By.xpath("//th[contains(text(),'Page')]/../../../tbody/tr[2]"));
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfAllElements(positionAvailabilityList1));
			WebElement positionElement1 = driver.findElement(By.xpath("//th[contains(text(),'Page')]/../../../tbody/tr[2]/td[1]"));
			positionElement1.click();
			Logger.info("second position is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	//payel
	public void savePositionSelectionreplica() throws Exception
	{
		try{
			Thread.sleep(7000);
			WebDriverWait wait = new WebDriverWait(driver,200);		   
			wait.until(ExpectedConditions.elementToBeClickable(savepositionSelection));

			if(savepositionSelection.isDisplayed())
			{
				Thread.sleep(1000);
				// savepositionSelection.click();
				Actions action=new Actions(driver);
				action.moveToElement(savepositionSelection).click().build().perform();
				Thread.sleep(7000);
				Logger.info("position is saved");

			}

			else
			{

				Logger.info("postion save button is not clicked");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());

		}
	}
	//payel

	//payel
	public void clickOnwarningConfirmation() throws Exception
	{
		try{
			//if(warningmessage.isDisplayed())
				if(driver.findElements(By.xpath("//div/div[3]/button[contains(text(), 'Continue')]")).size()>0)	
				
			{ warningmessage.click();
			Logger.info("warning button is clicked on the warning confirmation window");}
			else
			{
				Logger.info("waring button is clicked on the warning confirmation window");}
		}
		catch(Exception e)
		{

			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//payel

	public String setMonthName(String month) throws Exception
	{
		try
		{
			String monthString = "";
			switch (month)

			{
			case "Jan":  monthString = "January";       break;
			case "Feb":  monthString = "February";      break;
			case "Mar":  monthString = "March";         break;
			case "Apr":  monthString = "April";         break;
			case "May":  monthString = "May";           break;
			case "Jun":  monthString = "June";          break;
			case "Jul":  monthString = "July";          break;
			case "Aug":  monthString = "August";        break;
			case "Sep":  monthString = "September";     break;
			case "Oct":  monthString = "October";       break;
			case "Nov":  monthString = "November";      break;
			case "Dec":  monthString = "December";      break;
			default: monthString = "Invalid month";     break;

			}
			return monthString;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select the product type
	public void selectProductType(String insertionIndex,int row, int col) throws Exception
	{
		try
		{
			String value = TribuneUtils.getStringCellValues("Product",row, col);
			String producTypePath = "/tr[1]/td/div/a/span[@id='Span2']/span"; 
			//String producTypePath = "/tr[1]/td/div/a/span[@id='Span2']/span";
			WebElement productType = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+producTypePath));
			WebDriverWait wait= new WebDriverWait(driver, 200);//swagata
			wait.until(ExpectedConditions.elementToBeClickable(productType));//swagata
			productType.click();
			WebElement productTypeDrpDwn = driver.findElement(By.xpath("//span[@id='Span2']/../../form/div/select"));
			//WebElement productTypeDrpDwn = driver.findElement(By.xpath("//select[contains(@ng-options,'.products')]"));
			
			
			
			Select selectProductType = new Select(productTypeDrpDwn);
			selectProductType.selectByVisibleText(value);
			Logger.info(value +" product type is selected");
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select the product type
	public void selectProductTypeByValue(String insertionIndex,String value) throws Exception
	{
		try
		{

			String producTypePath = "/tr[1]/td/div/a/span[@id='Span2']/span"; 
			WebElement productType = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+producTypePath));
			productType.click();
			WebElement productTypeDrpDwn = driver.findElement(By.xpath("//span[@id='Span2']/../../form/div/select"));
			Select selectProductType = new Select(productTypeDrpDwn);
			selectProductType.selectByVisibleText(value);
			Logger.info(value +" product type is selected");
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectProductTypeByIndex(String insertionIndex,int index) throws Exception
	{
		try
		{
			// String value = TribuneUtils.getStringCellValues("Product",row, col);
			String producTypePath = "/tr[1]/td/div/a/span[@id='Span2']/span"; 
			WebElement productType = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+producTypePath));
			productType.click();
			WebElement productTypeDrpDwn = driver.findElement(By.xpath("//span[@id='Span2']/../../form/div/select"));
			Select selectProductType = new Select(productTypeDrpDwn);
			selectProductType.selectByIndex(index);
			Logger.info(" product type is selected");
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	//code to validate the product types displayed for an insertion order
	public void validateListOfProductTypes(String insertionIndex) throws Exception
	{
		try
		{
			String producTypePath = "/tr[1]/td/div/a/span[@id='Span2']/span"; 
			WebElement productType = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+producTypePath));
			productType.click();
			List<WebElement> productTypeDrpDwn = driver.findElements(By.xpath("//span[@id='Span2']/../../form/div/select/option"));
			int countOfProductTypes = productTypeDrpDwn.size();
			Logger.info("Count of Product types "+countOfProductTypes);
			if(countOfProductTypes==3)
			{
				WebElement productTypeName1 = driver.findElement(By.xpath("(//span[@id='Span2']/../../form/div/select/option)[1]"));
				Logger.info(productTypeName1.getText());
				Assert.assertEquals("Display", productTypeName1.getText());
				WebElement productTypeName2 = driver.findElement(By.xpath("(//span[@id='Span2']/../../form/div/select/option)[2]"));
				Logger.info(productTypeName2.getText());
				Assert.assertEquals("Preprint", productTypeName2.getText());
				WebElement productTypeName3 = driver.findElement(By.xpath("(//span[@id='Span2']/../../form/div/select/option)[3]"));
				Logger.info(productTypeName3.getText());
				Assert.assertEquals("Online", productTypeName3.getText());
				WebElement element = driver.findElement(By.xpath("//th[text()='Product Type']"));
				element.click();
				Thread.sleep(3000);
				Logger.info("Product type validation success");

			}
			else{
				Assert.fail("Product types are not as per the expectation");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//span[@id='Span2']/../../form/div/select/option

	//code to select the product
	public void selectProduct(String insertionIndex,int row, int col) throws Exception
	{
		Thread.sleep(2000);
		try
		{
			Logger.info("inside function");
			String value = TribuneUtils.getStringCellValues("Product",row, col);
			String productPath = "/tr[1]/td/div/a/span[@id='Span5']/span"; 
			WebElement product = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+productPath));
			product.click();
			WebElement productDrpDwn = driver.findElement(By.xpath("//span[@id='Span5']/../../form/div/select"));
			Select selectProduct = new Select(productDrpDwn);
			List<WebElement> listOfProducts = selectProduct.getOptions();

			Logger.info("value="+value);
			// value="Los Angeles Times";
			Logger.info("listOfProducts.size()="+listOfProducts.size());


			if(listOfProducts.size()>0)
			{
				selectProduct.selectByVisibleText(value);
				/*Actions selectItem = new Actions(driver);//swagata
			selectItem.moveToElement(productDrpDwn).click().perform();  //swagata
			selectItem.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();//swagata
			selectItem.sendKeys(Keys.ENTER).perform();//swagata
				 */		
				//	((JavascriptExecutor)driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", productDrpDwn, value);
				Logger.info(value+" product is selected"); 


			}
			else
			{
				Logger.info("drop down is empty");
			}
		}
		catch(Exception e)
		{
			Logger.info("inside exception");

			Logger.error(e.getMessage());
			throw e;
		}
	}
	public void selectProductByIndex(String insertionIndex,int index) throws Exception
	{
		try
		{
			// String value = TribuneUtils.getStringCellValues("Product",1);
			String productPath = "/tr[1]/td/div/a/span[@id='Span5']/span"; 
			WebElement product = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+productPath));
			product.click();
			WebElement productDrpDwn = driver.findElement(By.xpath("//span[@id='Span5']/../../form/div/select"));
			Select selectProduct = new Select(productDrpDwn);
			selectProduct.selectByIndex(index);
			Logger.info(" product is selected");
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void verifyFieldsUneditable() throws Exception
	{
		try
		{
			WebElement bu = driver.findElement(By.xpath("//*[@id='insertionInfo']/form/div/table/tbody[1]/tr[1]/td[4]/div/span"));
			String buAttribute = bu.getAttribute("ng-if");
			Logger.info("BU type state: "+buAttribute);
			if(buAttribute.contains("vm.isDisabled()"))
			{
				Logger.info("BU field is disabled");
			}

			WebElement pubdate = driver.findElement(By.xpath("//*[@id='insertionInfo']/form/div/table/tbody[1]/tr[1]/td[5]/div/span[2]"));
			String pubdateAttribute = pubdate.getAttribute("ng-if");
			Logger.info("Pub date state: "+pubdateAttribute);
			if(pubdateAttribute.contains("vm.isDisabled()"))
			{
				Logger.info("Pub date field is disabled");
			}

			WebElement prodType = driver.findElement(By.xpath("//*[@id='insertionInfo']/form/div/table/tbody[1]/tr[1]/td[6]/div/span"));
			String prodTypeAttribute = prodType.getAttribute("ng-if");
			Logger.info("Product type state: "+prodTypeAttribute);
			if(prodTypeAttribute.contains("vm.isDisabled()"))
			{
				Logger.info("Product type field is disabled");
			}

			WebElement prod = driver.findElement(By.xpath("//*[@id='insertionInfo']/form/div/table/tbody[1]/tr[1]/td[7]/div/span"));
			String prodAttribute = prod.getAttribute("ng-if");
			Logger.info("Product state: "+prodAttribute);
			if(prodAttribute.contains("vm.isDisabled()"))
			{
				Logger.info("Product field is disabled");
			}	  


		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select the AD type
	public void selectAdType(String insertionIndex,int row, int col) throws Exception
	{
		try
		{
			String value = TribuneUtils.getStringCellValues("Product",row, col);		  
			String adTypePath = "/tr[1]/td/div/a/span[@id='Span7']/span"; 
			WebElement adType = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+adTypePath));
			WebDriverWait wait = new WebDriverWait(driver,120);
			wait.until(ExpectedConditions.visibilityOf(adType));
			if(adType.isDisplayed())
			{
				adType.click();
				Thread.sleep(4000);
				WebElement adTypeDrpDwn = driver.findElement(By.xpath("//span[@id='Span7']/../../form/div/select"));
				Select selectAdType = new Select(adTypeDrpDwn);
				selectAdType.selectByVisibleText(value);		  
				Logger.info(value +" adtype is selected");
			}
			else{
				Logger.info("Adtype element is not visible");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select the section
	public void selectSection(String insertionIndex,int row, int col) throws Exception
	{
		try
		{
			String value = TribuneUtils.getStringCellValues("Product",row, col);
			//value="Sports";
			String sectionPath = "/tr[1]/td/div/a/span[@id='Span6']/span"; 
			WebElement section = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+sectionPath));
			WebDriverWait wait = new WebDriverWait(driver,120);
			wait.until(ExpectedConditions.visibilityOf(section));
			if(section.isDisplayed())
			{
				section.click();
				Thread.sleep(4000);
				WebElement sectionDrpDwn = driver.findElement(By.xpath("//span[@id='Span6']/../../form/div/select"));
				Select selectSection = new Select(sectionDrpDwn);
				Thread.sleep(2000);
				selectSection.selectByVisibleText(value);
				Logger.info(value +" section is selected");
			}
			else{
				Logger.info("Section element is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	public void selectSectionByIndex(String insertionIndex,int index) throws Exception
	{
		try
		{

			String sectionPath = "/tr[1]/td/div/a/span[@id='Span6']/span"; 
			WebElement section = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+sectionPath));
			WebDriverWait wait = new WebDriverWait(driver,120);
			wait.until(ExpectedConditions.visibilityOf(section));
			if(section.isDisplayed())
			{
				section.click();
				Thread.sleep(4000);
				WebElement sectionDrpDwn = driver.findElement(By.xpath("//span[@id='Span6']/../../form/div/select"));
				Select selectSection = new Select(sectionDrpDwn);
				Thread.sleep(2000);
				selectSection.selectByIndex(index);
				Logger.info(" section is selected");
			}
			else{
				Logger.info("Section element is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select MM Tag
	public void selectMMTag(String insertionIndex,String value) throws Exception
	{
		try
		{
			WebElement mmTagElement = driver.findElement(By.xpath("(//a[@editable-select ='vm.orderLine.MultimediaTagID']/span)["+insertionIndex+"]"));
			mmTagElement.click();	
			Logger.info(" MM Tag field is clicked to enable dropdown");
			Thread.sleep(4000);
			WebElement mmTagDrpDwn = driver.findElement(By.xpath("//a[@editable-select ='vm.orderLine.MultimediaTagID']/../form/div/select"));
			Logger.info(" MM Tag dropdown: "+mmTagDrpDwn.getText());
			Select selectMmTag = new Select(mmTagDrpDwn);
			selectMmTag.selectByVisibleText(value);
			Logger.info(value +" MM Tag is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectMMTagAlt(String insertionIndex,String value) throws Exception
	{
		try
		{
			WebElement mmTagElement = driver.findElement(By.xpath("//tbody["+insertionIndex+"]/tr/td[17]/div/a/span"));
			mmTagElement.click();	
			Logger.info(" MM Tag field is clicked to enable dropdown");
			Thread.sleep(4000);
			WebElement mmTagDrpDwn = driver.findElement(By.xpath("//tbody["+insertionIndex+"]/tr/td[17]/div/form/div/select"));
			Logger.info(" MM Tag dropdown: "+mmTagDrpDwn.getText());
			Select selectMmTag = new Select(mmTagDrpDwn);
			selectMmTag.selectByVisibleText(value);
			Logger.info(value +" MM Tag is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to add or edit the version id for a specific insertion
	public void addOrEditInsersionVerisonID(String insertionIndex,int versionID) throws Exception
	{
		try
		{
			String versionPath = "/tr[1]/td/a/span[@id='Span13']"; 
			WebElement versionElement = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+versionPath));
			versionElement.click();
			WebElement version = driver.findElement(By.xpath("//form/div[@class='editable-controls form-group']/input"));
			version.clear();
			version.sendKeys(""+versionID);
			Logger.info("versionID "+versionID +" is added/edited");
			Thread.sleep(4000);Thread.sleep(4000);
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void addOrEditInserstionVerisonIDString(String insertionIndex,String versionID) throws Exception
	{
		try
		{
			String versionPath = "/tr[1]/td/a/span[@id='Span13']"; 
			WebElement versionElement = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+versionPath));
			versionElement.click();
			WebElement version = driver.findElement(By.xpath("//form/div[@class='editable-controls form-group']/input"));
			version.clear();
			version.sendKeys(""+versionID);
			Logger.info("versionID "+versionID +" is added/edited");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void incrementInsersionMaterialID(String insertionIndex) throws Exception
	{
		try
		{
			String materialIncrementorPath = "//*[@id='Span1']/i"; 
			WebElement materialIncrementorElement = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+materialIncrementorPath));
			materialIncrementorElement.click();

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to get the version id for an insertion
	public String getInsersionVerisonID(String insertionIndex) throws Exception
	{
		String versionID = "";
		try
		{
			String versionPath = "/tr[1]/td/a/span[@id='Span13']/span"; 
			WebElement version = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+versionPath));
			if(version.isDisplayed()){
				versionID = version.getText();
			}
			else{
				Logger.info("not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return versionID;
	}

	//code to get the material ID for an insertion(order line) in an order
	public String getMaterialID(String insertionIndex) throws Exception
	{
		String materialID = "";
		try{
			WebElement materialIDElement = driver.findElement(By.xpath("//tbody["+insertionIndex+"]//span[@id='Span1']/span"));
			if(materialIDElement.isDisplayed()){
				materialID = materialIDElement.getText();
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return materialID;
	}

	/**
	 * @description This method returns the total order price for an order from order view Page
	 * @throws Exception
	 */
	public double getTotalOrderPrice() throws Exception
	{
		try{
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", totalOrderPrice);//swagata
			String totalAmount = totalOrderPrice.getText();
			Logger.info("Total order price = " +totalAmount);
			if(totalAmount.contains(","))
			{
				totalAmount = totalAmount.replace(",", "");
			}
			return Double.parseDouble(totalAmount.substring(1));
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to get the price values from a specified insertion
	public double getInsertionPrice(String insertionIndex, String priceType) throws Exception
	{
		String price = "";
		if(priceType.equalsIgnoreCase("base")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Base Price']/../div/input)["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}else if(priceType.equalsIgnoreCase("sales")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Sales Price']/../div/input)["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}else if (priceType.equalsIgnoreCase("net")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Net Price']/../div/input)["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}else if(priceType.equalsIgnoreCase("contract")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Contract Price']/../div/input[1])["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}else if(priceType.equalsIgnoreCase("total")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Total']/../div/input)["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}
		else if(priceType.equalsIgnoreCase("overall")){
			WebElement priceElement = driver.findElement(By.xpath("//span[contains(text(),'Total Amount')]/../span[2]"));
			price = priceElement.getText();
		}
		else if(priceType.equalsIgnoreCase("sales preprint")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Sales Price / Rate']/../div/input[1])["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}

		else if(priceType.equalsIgnoreCase("addon charge")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Add-on / Charges']/../div/input[1])["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}
		else if(priceType.equalsIgnoreCase("agencyComm Percentage")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Agency Comm']/../div/input[2])["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}
		if(price.contains(","))
		{
			price = price.replace(",", "");
		}
		//partha
		
			price = price.replace(")", "");
			price = price.replace("(", "");
		
		if(price.contains("$"))
		{
			price = price.replace("$", "");
		}
		//Logger.info("Price is:"+price.substring(1) );
		Logger.info("Price is:"+price);
		//partha
		return Double.parseDouble(price);
		

	}



	public String convertToPricePattern(Double price) throws Exception
	{
		String pattern = "###,###,###.00";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		//decimalFormat.setGroupingSize(3);

		String number = decimalFormat.format(price);
		System.out.println("$"+number);
		return ("$"+number);
	}
	//code to get the insertion price for an online order
	public double getOnlineInsertionPrice(String insertionIndex, String priceType) throws Exception
	{
		String price = "";
		if(priceType.equalsIgnoreCase("base")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Base Price / Rate']/../div/input[1])["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}else if(priceType.equalsIgnoreCase("sales")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Sales Price']/../div/input)["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}else if (priceType.equalsIgnoreCase("net")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Net Price']/../div/input)["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}else if(priceType.equalsIgnoreCase("contract")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Contract Price / Rate']/../div/input[1])["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}else if(priceType.equalsIgnoreCase("total")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Total']/../div/input)["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}else if(priceType.equalsIgnoreCase("salesRatePrice")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Sales Rate']/../div/input[1])["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");  

		}
		if(price.contains(","))
		{
			price = price.replace(",", "");
		}
		return Double.parseDouble(price.substring(1));
	}

	//code to get the insertion price for an online order
	public double getPreprintInsertionPrice(String insertionIndex, String priceType) throws Exception
	{
		String price = "";
		if(priceType.equalsIgnoreCase("base")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[contains(text(),'Base Price')]/../div/input[1])["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}else if (priceType.equalsIgnoreCase("net")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Net Price']/../div/input)["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}else if (priceType.equalsIgnoreCase("net")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Net Price']/../div/input)["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}else if(priceType.equalsIgnoreCase("contract")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Contract Price / Rate']/../div/input[1])["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}else if(priceType.equalsIgnoreCase("total")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Total']/../div/input)["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");
		}else if(priceType.equalsIgnoreCase("salesRate")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[contains(text(),'Sales Price')]/../div/input[2])["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");  
		}else if(priceType.equalsIgnoreCase("baseRate")){
			WebElement priceElement = driver.findElement(By.xpath("(//label[contains(text(),'Base Price / Rate')]/../div/input[2])["+insertionIndex+"]"));
			price = priceElement.getAttribute("value");  
		}//swagata
		if(price.contains(","))
		{
			price = price.replace(",", "");
		}
		return Double.parseDouble(price.substring(1));
	}



	//code to get the no of units calculated for sales price
	public int getSalesRateNoOfUnit(String insertionIndex) throws Exception
	{
		int noOfunits = 0;
		WebElement priceElement = driver.findElement(By.xpath("(//label[text()='Sales Rate']/../div/input[2])["+insertionIndex+"]"));
		noOfunits = Integer.parseInt(priceElement.getAttribute("value"));
		return noOfunits;
	}


	// code to click on the link to expand the insertion details
	public void viewInsertionDetails(String insertionIndex) throws Exception
	{
		try
		{	JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement insertionLink = driver.findElement(By.xpath("//tbody["+insertionIndex+"]//div[@class='pointer']/i")); 

		if(insertionLink.getAttribute("class").contains("right")){

			Logger.info("It contains right");
			js.executeScript("arguments[0].click();", insertionLink);

		}//swagata
		Thread.sleep(4000);
		//Assert.assertTrue(insertionLink.getAttribute("class").contains("down"));//swagata
		Logger.info("Expand insertion link is clicked");
		Thread.sleep(4000);		

		//insertionLink.click();//swagata


		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		Thread.sleep(4000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectAllInsertions() throws Exception
	{
		try
		{
			WebElement insertionLink = driver.findElement(By.xpath(".//*[@id='insertionInfo']/form/div/table/thead/tr/th[1]/div[1]/label/i")); 
			insertionLink.click();
			Logger.info("selectAllInsertions checkbox is clicked");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}



	//lockOrderLine
	public void lockOrderLine() throws Exception
	{
		try
		{
			if(lockOrderLine.isDisplayed())
			{
				lockOrderLine.click();

				Logger.info("Checkbox lockOrderLine clicked");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	//Code to edit sales price
	public void editSalesPrice(String price,int insertionNo) throws Exception
	{
		try
		{
			if(salesPriceTextBox.get((insertionNo)-1).isDisplayed())
			{
				salesPriceTextBox.get((insertionNo)-1).click();
				salesPriceTextBox.get((insertionNo)-1).clear();	
				salesPriceTextBox.get((insertionNo)-1).sendKeys(Keys.CONTROL,"a");
				salesPriceTextBox.get((insertionNo)-1).sendKeys(price);
				Logger.info("Updated the sales price");
			}//swagata
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void editSalesPricePrePrint(String price) throws Exception
	{
		try
		{
			if(salesPriceText.isDisplayed())
			{
				salesPriceText.click();
				salesPriceText.clear();
				salesPriceText.sendKeys(price);
				Logger.info("Updated the sales price");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	// code to get the tool tip of sales price checkbox
	public boolean getSalesPriceToolTip(int insertionNumber)throws Exception
	{
		boolean flag = false;
		try
		{
			WebElement salesPriceCheckBox = driver.findElement(By.xpath("(//span[@class='input-group-addon']/input[@ng-model='vm.orderLine.SalePriceLocked'])["+insertionNumber+"]"));
			String toolTip = "";
			if(salesPriceCheckBox.isSelected())
			{

				toolTip = salesPriceToolTipElement.getAttribute("uib-tooltip");
				Logger.info("Sales price check box is selected "+toolTip);
				if(toolTip.equalsIgnoreCase("unlock price"))
				{
					flag = true;
				}
				else{
					flag = false;
				}
				return flag;
			}
			else{
				toolTip = salesPriceToolTipElement.getAttribute("uib-tooltip");
				Logger.info("Sales price check box is not selected "+toolTip);
				if(toolTip.equalsIgnoreCase("lock price"))
				{
					flag = true;
				}
				else{
					flag = false;
				}
				return flag;
			}
		}
		catch(Exception e)
		{
			return flag;
		}
	}

	// code to check or uncheck the sales price
	public void checkUncheckSalesPrice(int insertionNumber, boolean value)throws Exception
	{
		try
		{
			WebElement salesPriceCheckBox = driver.findElement(By.xpath("(//span[@class='input-group-addon']/input[@ng-model='vm.orderLine.SalePriceLocked'])["+insertionNumber+"]"));
			salesPriceTextBox.get((insertionNumber)-1).click();
			if(value){
				if(salesPriceCheckBox.isSelected())
				{
					salesPriceCheckBox.click();
					Logger.info("Sales price is unlocked");
				}
				else{
					Logger.info("Sales price is unlocked");
				}
			}
			else{
				if(!salesPriceCheckBox.isSelected())
				{
					salesPriceCheckBox.click();
					Logger.info("Sales price is locked");
				}
				else{
					Logger.info("Sales price is locked");
				}
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void checkUncheckSalesPricePreprint(int insertionNumber, boolean value)throws Exception
	{
		try
		{
			WebElement salesPriceCheckBox = driver.findElement(By.xpath("(//span[@class='input-group-addon']/input[@ng-model='vm.orderLine.SalePriceLocked'])["+insertionNumber+"]"));
			salesPriceTextBox.get((insertionNumber)-1).click();
			if(value){
				if(salesPriceCheckBox.isSelected())
				{
					salesPriceCheckBox.click();
					Logger.info("Sales price is unlocked");
				}
				else{
					Logger.info("Sales price is unlocked");
				}
			}
			else{
				if(!salesPriceCheckBox.isSelected())
				{
					salesPriceCheckBox.click();
					Logger.info("Sales price is locked");
				}
				else{
					Logger.info("Sales price is locked");
				}
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	//code to check or uncheck the billing quantity
	public void checkUncheckBillQty(boolean value)throws Exception
	{
		try
		{
			if(value){
				if(billedQtyCheckBox.isSelected())
				{
					billedQtyCheckBox.click();
					Logger.info("Billed quantity is unlocked");
				}
				else{
					Logger.info("Billed quantity is unlocked");
				}
			}
			else{
				if(!billedQtyCheckBox.isSelected())
				{
					billedQtyCheckBox.click();
					Logger.info("Billed quantity is locked");
				}
				else{
					Logger.info("Billed quantity is locked");
				}
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to enter billed quantity
	public void enterBilledQty(int qtyLength) throws Exception
	{
		try
		{

			Logger.info("start entering billed quantity");

			if(billedQtyTextBox.isDisplayed())
			{
				billedQtyTextBox.click();
				billedQtyTextBox.clear();
				//  TribuneUtils utils = new TribuneUtils();
				
				billedQtyTextBox.sendKeys(""+(qtyLength));
				Logger.info("entered billed quantity");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterPerpetualQuantity(int qty) throws Exception
	{
		try
		{
			if(perpetualQtyTextBox.isDisplayed())
			{
				perpetualQtyTextBox.click();
				perpetualQtyTextBox.clear();

				perpetualQtyTextBox.sendKeys(""+(qty));
				Logger.info("entered perpetual quantity");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clearPerpetualQuantity() throws Exception
	{
		try
		{
			if(perpetualQtyTextBox.isDisplayed())
			{
				perpetualQtyTextBox.click();
				perpetualQtyTextBox.clear();

				Logger.info("cleared perpetual quantity");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterBilledQuantity(int qty) throws Exception
	{
		try
		{
			if(billedQtyTextBox.isDisplayed())
			{
				billedQtyTextBox.click();
				billedQtyTextBox.clear();

				billedQtyTextBox.sendKeys(""+(qty));
				Logger.info("entered billed quantity");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterPageCount(String pageCount) throws Exception
	{
		try
		{
			if(pageCountTextBox.isDisplayed())
			{
				pageCountTextBox.click();

				WebElement pageCountDropdown = driver.findElement(By.xpath("//label[text()='Page Count / Weight']/../div/div/div[1]//select"));
				pageCountDropdown.click(); //joy
				
				Select selectPageCount= new Select(pageCountDropdown);
				selectPageCount.selectByVisibleText(pageCount);

				Logger.info("entered page count");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select the zone
	public void selectZone(String insertionIndex, String zone) throws Exception
	{
		try
		{
			if(zoneInsideInsertion.isDisplayed())
			{
				WebElement zoneElement = driver.findElement(By.xpath("(//label[text()='Zones']/../div/a/span/span)["+insertionIndex+"]"));
				zoneElement.click();
				// zoneInsideInsertion.click();
				Select selectzone = new Select(zoneDrpDwn);
				selectzone.selectByVisibleText(zone);
				Logger.info("Zone is selected");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to get the zone for a specific insertion
	public String getZone(String insertionIndex) throws Exception
	{
		String zone = "";
		try
		{
			if(zoneInsideInsertion.isDisplayed())
			{
				WebElement zoneElement = driver.findElement(By.xpath("(//label[text()='Zone']/../div/a/span/span)["+insertionIndex+"]"));
				zone = zoneElement.getText();
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return zone;
	}

	//Code to select the bleed
	public void selectBleed(String bleed) throws Exception
	{
		try
		{
			if(bleedTextBox.isDisplayed())
			{
				bleedTextBox.click();
				Select selectzone = new Select(bleedDrpDwn);
				selectzone.selectByVisibleText(bleed);
				Logger.info("Bleed is selected");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectBleedInsertion(int insertionIndex,String bleed) throws Exception
	{
		try
		{
			WebElement bleedTextBox1 = driver.findElement(By.xpath("(//label[text()='Bleed']/../div/a/span/span)["+insertionIndex+"]"));

			if(bleedTextBox1.isDisplayed())
			{
				bleedTextBox1.click();
				Select selectzone = new Select(bleedDrpDwn);
				selectzone.selectByVisibleText(bleed);
				Logger.info("Bleed is selected");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to change the color
	public void editColor(String insertionIndex, String color) throws Exception
	{
		try
		{
			WebElement colorTextBox = driver.findElement(By.xpath("(//label[contains(text(),'Color & Spot #')]/..//span[@id='Span4']/span)["+insertionIndex+"]"));
			colorTextBox.click();
			Select selectzone = new Select(colorDrpDwn);
			selectzone.selectByVisibleText(color);
			Logger.info("Color is changed");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	//Code to check the visibility of spot number field
	public boolean checkSpotNumFieldVisibility(String insertionIndex) throws Exception
	{
		try
		{
			WebElement spotTextBox = driver.findElement(By.xpath("(//label[contains(text(),'Color & Spot #')]/..//input[@ng-model='vm.orderLine.SpotColorValue'])["+insertionIndex+"]"));
			if(spotTextBox.isDisplayed())
				return true;
			else
				return false;
		}
		catch(Exception e)
		{
			Logger.error("Spot# field is not displayed");
			return false;
		}
	}

	//code to enter spot under an insertion
	public boolean enterSpot(String insertionIndex, int numOfCharacters) throws Exception
	{
		try
		{
			WebElement spotTextBox = driver.findElement(By.xpath("(//label[contains(text(),'Color & Spot #')]/..//input[@ng-model='vm.orderLine.SpotColorValue'])["+insertionIndex+"]"));
			spotTextBox.click();
			spotTextBox.clear();
			TribuneUtils utils = new TribuneUtils();
			if(numOfCharacters<=4)
			{
				String spot = utils.generateRandomAlphaNumString(numOfCharacters);
				spotTextBox.sendKeys(spot);
				Logger.info(spot+" Spot is entered");
				return true;
			}
			else{
				Logger.info("Maximum length of characters for Spot is four. Value entered exceeded four.");
				return false;
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			return false;
		}
	}

	//code to click on the add on search button
	public void clickOnAddOnBtn() throws Exception
	{
		try{
			if(addOnSearchBtn.isDisplayed())
			{
				addOnSearchBtn.click();
				Thread.sleep(1000);
				Logger.info("Add on search button is clicked");
			}
			else{
				Logger.info("Add on search button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select an add on
	public void selectAddOn(String addOn) throws Exception
	{
		try{
			WebElement addBtn = driver.findElement(By.xpath("//b[contains(text(),'"+addOn+"')]/../../td/button[contains(text(),'Add')]"));
			addBtn.click();
			Logger.info("add on is selected");
			confirmAddOnBtn.click();
			Thread.sleep(3000);
			Logger.info(addOn+ " add On is confirmed");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to get the add on amount
	public Double getAddOnAmount(int insertionNumber) throws Exception
	{
		Double addOnPrice = 0.0;
		try{
			//WebElement addOnAmount = driver.findElement(By.xpath("(//label[contains(text(),'Add-on')]/../div/input[@ng-model='vm.orderLine.AddOnAmount'])["+insertionNumber+"]")); // Blocked by ritoban
			WebElement addOnAmount = driver.findElement(By.xpath("//*[@id='insertionInfo']/form/div/table/tbody/tr[2]/td/div/div/div/div[1]/div/div[4]/div[1]/div/span[2]"));	// added by ritoban	  
			//String addOnAmountValue = addOnAmount.getAttribute("value");		  
			String addOnAmountValue1 = addOnAmount.getAttribute("title");
			Logger.info("addOnAmountValue1="+addOnAmountValue1);
			String[] addOnAmountValue2 = addOnAmountValue1.split(Pattern.quote("$"));
			Logger.info("addOnAmountValue2="+addOnAmountValue2[0]);
			addOnPrice = Double.parseDouble(addOnAmountValue2[1]);
			//addOnPrice = Double.parseDouble(addOnAmountValue.substring(2,addOnAmountValue.length()-1));
			Logger.info("addOnPrice="+addOnPrice);
		}
		catch(Exception e)
		{
			Logger.error("Inside exception:"+e.getMessage());
			throw e;
		}
		return addOnPrice;
	}

	//code to get the charge amount 
	public Double getChargeAmount(int insertionNumber) throws Exception
	{
		Double chargePrice = 0.0;
		try{

			WebElement addOnAmount = driver.findElement(By.xpath("(//label[contains(text(),'Add-on')]/../div/input[@ng-model='vm.orderLine.ChargeAmount'])["+insertionNumber+"]"));
			String chargeAmountValue = addOnAmount.getAttribute("value");
			chargePrice = Double.parseDouble(chargeAmountValue.substring(1));
			Logger.info(""+chargePrice);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return chargePrice;
	}

	//code to save the order
	public void saveAndCloseOrder() throws Exception
	{
		try
		{
			Thread.sleep(4000); 

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", saveOrderDrpDwn);
			WebDriverWait wait = new WebDriverWait(driver,30);//mou
			wait.until(ExpectedConditions.visibilityOf(saveOrderDrpDwn));
			if(saveOrderDrpDwn.isDisplayed())
			{
				saveOrderDrpDwn.click();
				Logger.info("save drp down is clicked");
				if(saveOrderAndExitBtn.isDisplayed()){
					saveOrderAndExitBtn.click();
					Logger.info("save and close order btn is clicked");
				}
				else{
					Logger.info("Save and close btn is not displayed");
				}
			}
			else{
				Logger.info("save drp down btn is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to submit an order saveOrderBtn
	public void submitOrder() throws Exception
	{ 

	saveOrder();//swagata

	WebDriverWait wait = new WebDriverWait(driver,500);//swagata
	Thread.sleep(5000); 
	//wait.until(ExpectedConditions.elementToBeClickable(copyOrder));//swagata
	
	OrderEntryHomePage orderEntryPageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);
	String orderNumber = orderEntryPageInstance.getOrderIDNewPage();
	Logger.info("Saved Order : "+orderNumber);
	driver.navigate().refresh();//swagata
	//wait.until(ExpectedConditions.elementToBeClickable(copyOrder));//swagata
	Thread.sleep(3000);
	try
	{
		Thread.sleep(3000); 

		JavascriptExecutor js = ((JavascriptExecutor) driver);//swagata
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");//swagata
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", submitOrderButton);//swagata
		wait.until(ExpectedConditions.elementToBeClickable(submitOrderButton));//swagata
		if(submitOrderButton.isDisplayed()){
			//submitOrderButton.click();
			js.executeScript("arguments[0].click();", submitOrderButton);//swagata
			//Thread.sleep(2000);//swagata
			Logger.info("Order is submitted");
			Thread.sleep(1000);
			// WebElement closeOrderSubmissionMessage = driver.findElement(By.xpath("//*[@id='toast-container']/div/div[1]/button"));

			// wait.until(ExpectedConditions.elementToBeClickable(closeOrderSubmissionMessage));
		}
		else{
			Logger.info("submit order is not displayed");
		}


		if(driver.getPageSource().contains("Your order contains one or more insertions that match auto insertion rules."))
		//if(driver.findElements(By.xpath("//div[contains(text(),'Your order contains one or more insertions that match auto insertion rules.')]")).size()>0)	
		{

			Logger.info("Confirmation window is displayed requesting the user to either accept or reject the creation of legacy auto insertion");
			rejectLegacyAutoInsertion.click();
			String  text = displayMsg.getAttribute("value");
			Logger.info("Message is displayed in the pop up: " + text);
			Logger.info("'No' is clicked in confirmation window");
			//Logger.info("Order is submitted successfully");
			Thread.sleep(3000);
		}//swagata
		/*if(driver.findElements(By.xpath("//button[contains(text(),'Continue')]")).size()>0)	
			
		{ Logger.info("continue button click required");
			driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		Logger.info("warning button is clicked on the warning confirmation window");}*/
		
			Logger.info("Order is submitted successfully");
		//swagata

	}
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	}
	}
	
	//Joy
	public void ClickSubmitButton() throws Exception
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement submit= driver.findElement(By.xpath("//button[@id='submit-order']"));
		if(submit.isDisplayed()){
			//submitOrderButton.click();
			js.executeScript("arguments[0].click();", submit);
			
			Logger.info("Order is submitted");
			Thread.sleep(1000);
			
		}
		else{
			Logger.info("submit order is not displayed");
		}

	}
	
	
	public void submitReservation() throws Exception
	{

		try
		{
			Thread.sleep(3000); 

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", submitOrderButton);
			WebDriverWait wait = new WebDriverWait(driver,300);		       
			wait.until(ExpectedConditions.elementToBeClickable(submitOrderButton));//swagata
			if(submitOrderButton.isDisplayed()){
				submitOrderButton.click();
				//Thread.sleep(2000);//swagata
				Logger.info("Order is submitted");
				Thread.sleep(1000);
				// WebElement closeOrderSubmissionMessage = driver.findElement(By.xpath("//*[@id='toast-container']/div/div[1]/button"));

				// wait.until(ExpectedConditions.elementToBeClickable(closeOrderSubmissionMessage));
			}
			else{
				Logger.info("submit order is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	public void transferOrder() throws Exception
	{
		try
		{
			Thread.sleep(4000); 

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", transferOrderButton);
			WebDriverWait wait = new WebDriverWait(driver,200);		       
			wait.until(ExpectedConditions.elementToBeClickable(transferOrderButton));
			if(transferOrderButton.isDisplayed()){
				transferOrderButton.click();
				Thread.sleep(4000);
				Logger.info("Order is transferred");
			}
			else{
				Logger.info("Transfer order is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickMoreOptionsOrder() throws Exception
	{
		try
		{
			WebElement moreOptionsButton = driver.findElement(By.xpath("//*[@id='order-detail-page']/div[1]/div/div[2]/div[4]/button"));
			WebDriverWait wait = new WebDriverWait(driver,200);		       
			wait.until(ExpectedConditions.elementToBeClickable(moreOptionsButton));
			if(moreOptionsButton.isDisplayed()){
				moreOptionsButton.click();
				Thread.sleep(4000);
				Logger.info("More Options is clicked and expanded");
			}
			else{
				Logger.info("More Options is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void verifyPriceDetails(String netPrice, String grossPrice, String orderPrice, String commAmt, String insertion1Price, String insertion2Price) throws Exception
	{
		try
		{
			WebElement priceDetailsOption = driver.findElement(By.xpath("//a[text()='Price Details']"));
			if(priceDetailsOption.isDisplayed())
			{
				Logger.info("Found "+priceDetailsOption);
				//  Actions builder = new Actions(driver);
				//  builder.moveToElement(priceDetailsOption).perform();
				priceDetailsOption.click();
				Thread.sleep(4000);
			}
			WebElement netPriceElement = driver.findElement(By.xpath("//*[contains(text(),'Net Price')]/../dd[1]/span"));
			String netPriceAmt = netPriceElement.getText();
			// Assert.assertEquals(netPriceAmt, netPrice);
			Logger.info("netPrice is : "+netPriceAmt);
			WebElement grossPriceElement = driver.findElement(By.xpath("//*[contains(text(),'Net Price')]/../dd[2]/span"));
			String grossPriceAmt = grossPriceElement.getText();
			// Assert.assertEquals(grossPriceAmt, grossPrice);
			Logger.info("grossPrice is : "+grossPriceAmt);
			WebElement orderPriceElement = driver.findElement(By.xpath("//*[contains(text(),'Comm Amt')]/../dd[2]/span"));
			String orderPriceAmt = orderPriceElement.getText();
			// Assert.assertEquals(orderPriceAmt, orderPrice);
			Logger.info("orderPrice is : "+orderPriceAmt);
			WebElement commAmtElement = driver.findElement(By.xpath("//*[contains(text(),'Comm Amt')]/../dd[1]/span"));
			String commAmtPriceAmt = commAmtElement.getText();
			// Assert.assertEquals(commAmtPriceAmt, commAmt);		 
			Logger.info("commAmt is : "+commAmtPriceAmt);
			WebElement insertion1Element = driver.findElement(By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[7]"));
			String insertion1Price1 = insertion1Element.getText();
			// Assert.assertEquals(commAmtPriceAmt, commAmt);		 
			Logger.info("insertion1Price is : "+insertion1Price1);
			WebElement insertion2Element = driver.findElement(By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[16]"));
			String insertion2Price1 = insertion2Element.getText();
			// Assert.assertEquals(commAmtPriceAmt, commAmt);		 
			Logger.info("insertion2Price1 is : "+insertion2Price1);	 
			if (netPriceAmt==netPrice && grossPriceAmt==grossPrice && orderPriceAmt==orderPrice && commAmtPriceAmt==commAmt && insertion1Price1==insertion1Price && insertion2Price1==insertion2Price)
			{
				Logger.info("Validation of price is succesful");
			}


		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	public void verifyMemo() throws Exception
	{
		try
		{
			WebElement memoOption = driver.findElement(By.xpath("//a[text()='Memo']"));
			Actions builder = new Actions(driver);
			builder.moveToElement(memoOption).perform();
			if(memoOption.isDisplayed()){
				WebElement memoPrint = driver.findElement(By.xpath("//a[text()='Memo']/../ul/li[1]/a"));
				String memoPrintText = memoPrint.getText();
				Assert.assertEquals(memoPrintText, "Print");
				WebElement memoEmail = driver.findElement(By.xpath("//a[text()='Memo']/../ul/li[2]/a"));
				String memoEmailText = memoEmail.getText();
				Assert.assertEquals(memoEmailText, "Email");
				Logger.info("Memo Option is as expected");
			}
			else{
				Logger.info("Memo Option is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void verifyOrder() throws Exception
	{
		try
		{
			WebElement orderOption = driver.findElement(By.xpath("//a[text()='Order']"));
			Actions builder = new Actions(driver);
			builder.moveToElement(orderOption).perform();
			if(orderOption.isDisplayed()){
				WebElement orderPrint = driver.findElement(By.xpath("//a[text()='Order']/../ul/li[1]/a"));
				String orderPrintText = orderPrint.getText();
				Assert.assertEquals(orderPrintText, "Print");
				WebElement orderEmail = driver.findElement(By.xpath("//a[text()='Order']/../ul/li[2]/a"));
				String orderEmailText = orderEmail.getText();
				Assert.assertEquals(orderEmailText, "Email");
				Logger.info("Order Option is as expected");
			}
			else{
				Logger.info("Order Option is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	public void verifyReceipt() throws Exception
	{
		try
		{
			WebElement receiptOption = driver.findElement(By.xpath("//a[text()='Receipt']"));
			Actions builder = new Actions(driver);
			builder.moveToElement(receiptOption).perform();
			if(receiptOption.isDisplayed()){
				WebElement receiptPrint = driver.findElement(By.xpath("//a[text()='Receipt']/../ul/li[1]/a"));
				String receiptPrintText = receiptPrint.getText();
				Assert.assertEquals(receiptPrintText, "Print");
				WebElement receiptEmail = driver.findElement(By.xpath("//a[text()='Receipt']/../ul/li[2]/a"));
				String receiptEmailText = receiptEmail.getText();
				Assert.assertEquals(receiptEmailText, "Email");
				Logger.info("Receipt Option is as expected");
			}
			else{
				Logger.info("Receipt Option is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void verifyProof() throws Exception
	{
		try
		{
			WebElement proofOption = driver.findElement(By.xpath("//a[text()='Proof']"));
			Actions builder = new Actions(driver);
			builder.moveToElement(proofOption).perform(); 
			if(proofOption.isDisplayed()){
				WebElement proofPrint = driver.findElement(By.xpath("//a[text()='Proof']/../ul/li[1]/a"));
				String proofPrintText = proofPrint.getText();
				Assert.assertEquals(proofPrintText, "Print");
				WebElement proofEmail = driver.findElement(By.xpath("//a[text()='Proof']/../ul/li[2]/a"));
				String proofEmailText = proofEmail.getText();
				Assert.assertEquals(proofEmailText, "Email");
				Logger.info("Proof Option is as expected");
			}
			else{
				Logger.info("Proof Option is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void verifyConvertToReservationButtonDisplayed() throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,200);		       
			wait.until(ExpectedConditions.elementToBeClickable(convertToReservationBtn));
			if(convertToReservationBtn.isDisplayed()){
				// convertToReservationBtn.click();
				Thread.sleep(4000);
				Logger.info("convertToReservationBtn is displayed");
			}
			else{
				Logger.info("convertToReservationBtn is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void verifyConvertToOrderButtonDisplayed() throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,200);		       
			wait.until(ExpectedConditions.elementToBeClickable(covertToOrderBtn));
			if(covertToOrderBtn.isDisplayed()){
				// covertToOrderBtn.click();
				Thread.sleep(4000);
				Logger.info("covertToOrderBtn is displayed");
			}
			else{
				Logger.info("covertToOrderBtnis not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void saveOrder() throws Exception
	{
		try
		{
			 addServiceRep("031200");//swagata
			Thread.sleep(4000); 

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

			WebDriverWait wait = new WebDriverWait(driver,200);		       
			wait.until(ExpectedConditions.elementToBeClickable(saveOrderBtn));
			if(saveOrderBtn.isDisplayed()){
				saveOrderBtn.click();//swagata
				Thread.sleep(4000);
				Logger.info("Order is saved");
			}
			else{
				Logger.info("save order is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	//code to click on checkbox to select the bill to customer same as sold to
	public void selectBilltoSameAsSoldTo() throws Exception
	{
		Thread.sleep(4000);
		try
		{
			if(billToSameasSoldToCheckbox.isSelected())
			{
				Logger.info("bill to same as sold to check box is selected");
			}
			else
			{
				billToSameasSoldToCheckbox.click();
				Logger.info("bill to same as sold to check box is selected");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	// Code to Click on duplicate insertion link to create a duplicate insertion
	public void createDuplicateInsertion(String insertionIndex) throws Exception
	{
		try
		{
			try
			{
				String insertionOptions = "//tr[@class='overview']/td//div[@class='pointer']/../div[3]//i";
				WebElement moreOptionsOnInsertionButton = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+insertionOptions));
				// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", moreOptionsOnInsertionButton);
				if(moreOptionsOnInsertionButton.isDisplayed())
				{
					moreOptionsOnInsertionButton.click();
					Logger.info("Options button is clicked on specified insertion");
					Thread.sleep(4000);
					duplicateInsertionLink.click();
					Thread.sleep(20000);
					Logger.info("Duplicate for the existing insertion is created");

					/*  JavascriptExecutor js = ((JavascriptExecutor) driver);
				  js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

				  Thread.sleep(4000);*/
				}
				else{
					Logger.info("Options link for the specified insertion is not displayed");
				}

			}
			catch(Exception e)
			{
				Logger.error(e.getMessage());
				throw e;
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @description This method clicks on assign material button for an insertion
	 * @param insertionIndex
	 */
	public void assignMaterialForAnInsertion(int insertionIndex) throws Exception
	{
		try
		{
			String insertionOptions = "//tr[@class='overview']/td//div[@class='pointer']/../div[3]//i";
			WebElement moreOptionsOnInsertionButton = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+insertionOptions));
			if(moreOptionsOnInsertionButton.isDisplayed())
			{
				moreOptionsOnInsertionButton.click();
				Logger.info("Options button is clicked on specified insertion");
				Thread.sleep(5000);
				WebElement assignMaterialButton = driver.findElement(By.xpath("html/body/ul/li[2]/a"));
				assignMaterialButton.click();
				Thread.sleep(20000);
				Logger.info("Material id is incremented by one to the selected insertion");
			}
			else{
				Logger.info("Options link for the specified insertion is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void assignMaterialForAnInsertionNoAutoInsertion(int insertionIndex) throws Exception
	{
		try
		{

			String insertionOptions = "//tr[@class='overview']/td//div[@class='pointer']/../div[3]//i";
			WebElement moreOptionsOnInsertionButton = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+insertionOptions));

			Thread.sleep(4000);//swagata
			if(moreOptionsOnInsertionButton.isDisplayed())
			{
				moreOptionsOnInsertionButton.click();
				Logger.info("Options button is clicked on specified insertion");
				Thread.sleep(5000);//swagata




				//WebElement assignMaterialButton = driver.findElement(By.xpath("(//a[text()='Assign Material'])["+(insertionIndex+1)+"]"));
				driver.findElement(By.xpath("(//*[@id='insertionInfo']/form/div/table/thead/tr/th[1]/div[2]/a)")).click();//swagata

				Thread.sleep(20000);
				Logger.info("Material id is incremented by one to the selected insertion");
			}
			else{
				Logger.info("Options link for the specified insertion is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to get the count of insertions available on an order
	public int getInsertionsCount() throws Exception
	{
		int countOfInsertions = 0;
		try
		{
			List<WebElement> listOfInsertions = driver.findElements(By.xpath("//tbody[@lineitem='orderLine']"));
			countOfInsertions = listOfInsertions.size();
			Logger.info("No. of insertions = "+countOfInsertions);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return countOfInsertions;
	}


	public String getOrderNo() throws Exception
	{
		try
		{
			String orderID2 = "";
			if(orderNo.isDisplayed())
			{
				String orderNum = orderNo.getText();			
				String[] parts = orderNum.split(" ");
				orderID2 = parts[1].trim(); 
				return orderID2;
			}
			else{
				return orderID2;
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to create new version for an existing insertion in an order
	public void createNewInsertionVersion(String insertionIndex) throws Exception
	{
		try
		{
			String insertionOptions = "//tr[@class='overview']/td//div[@class='pointer']/../div[3]//i";
			//  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", insertionOptions);
			WebElement moreOptionsOnInsertionButton = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+insertionOptions));
			if(moreOptionsOnInsertionButton.isDisplayed())
			{
				moreOptionsOnInsertionButton.click();
				Logger.info("Options button is clicked on specified insertion");
				Thread.sleep(4000);
				newInsertionVersionLink.click();
				Thread.sleep(2000);
				Logger.info("New version for the existing insertion is created");
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

				Thread.sleep(4000);
			}
			else{
				Logger.info("Options link for the specified insertion is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to click on kill insertion link
	public void killInsertion(String insertionIndex) throws Exception
	{
		try
		{
			String insertionOptions = "//tr[@class='overview']/td//div[@class='pointer']/../div[3]//i";
			//  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", insertionOptions);
			WebElement moreOptionsOnInsertionButton = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+insertionOptions));
			if(moreOptionsOnInsertionButton.isDisplayed())
			{
				moreOptionsOnInsertionButton.click();
				Thread.sleep(3000);
				Logger.info("Options button is clicked on specified insertion");
				WebElement killInsertionLink = driver.findElement(By.xpath("html/body/ul/li[5]/a"));
				scrollToElement(driver, killInsertionLink);
				killInsertionLink.click();
				Thread.sleep(10000);

				String insertionStatus = getInsertionStatus(insertionIndex);
				boolean insertionStatusflag = false;
				if(insertionStatus.equalsIgnoreCase("Kill Pending"))
				{
					insertionStatusflag = true;
					Logger.info("validation success - insertion kill");
				}
				Assert.assertEquals(insertionStatusflag, true); 

				Logger.info("killed the insertion numbered: " + insertionIndex);
			}
			else{
				Logger.info("Options link for the specified insertion numbered " + insertionIndex + " is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void killAllInsertion() throws Exception
	{
		try
		{
			WebElement moreOptionsOnInsertionButton = driver.findElement(By.xpath(".//*[@id='insertionInfo']/form/div/table/thead/tr/th[1]/div[2]/a/i"));
			if(moreOptionsOnInsertionButton.isDisplayed())
			{
				moreOptionsOnInsertionButton.click();
				Thread.sleep(3000);
				Logger.info("Options button is clicked on specified insertion");
				WebElement killInsertionLink = driver.findElement(By.xpath("html/body/ul/li[3]/a"));
				killInsertionLink.click();
				Thread.sleep(20000);
				Logger.info("killed all insertion");
			}
			else{
				Logger.info("Options link is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void assignMaterialAllInsertion() throws Exception
	{
		try
		{
			WebElement moreOptionsOnInsertionButton = driver.findElement(By.xpath(".//*[@id='insertionInfo']/form/div/table/thead/tr/th[1]/div[2]/a/i"));
			if(moreOptionsOnInsertionButton.isDisplayed())
			{
				moreOptionsOnInsertionButton.click();
				Thread.sleep(3000);
				Logger.info("Options button is clicked on specified insertion");
				WebElement killInsertionLink = driver.findElement(By.xpath("html/body/ul/li[1]/a"));
				killInsertionLink.click();
				Thread.sleep(20000);
				Logger.info("assigned Material to all insertion");
			}
			else{
				Logger.info("Options link is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void deleteAllInsertion() throws Exception
	{
		try
		{
			WebElement moreOptionsOnInsertionButton = driver.findElement(By.xpath(".//*[@id='insertionInfo']/form/div/table/thead/tr/th[1]/div[2]/a/i"));
			if(moreOptionsOnInsertionButton.isDisplayed())
			{
				moreOptionsOnInsertionButton.click();
				Thread.sleep(3000);
				Logger.info("Options button is clicked on specified insertion");
				WebElement killInsertionLink = driver.findElement(By.xpath("html/body/ul/li[4]/a"));
				killInsertionLink.click();
				Thread.sleep(20000);
				Logger.info("deleted all insertion");
			}
			else{
				Logger.info("Options link is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to click on delete insertion link
	public void deleteInsertion(String insertionIndex) throws Exception
	{
		try
		{
			String insertionOptions = "//tr[@class='overview']/td//div[@class='pointer']/../div[3]//i";
			WebElement moreOptionsOnInsertionButton = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+insertionOptions));
			if(moreOptionsOnInsertionButton.isDisplayed())
			{
				moreOptionsOnInsertionButton.click();
				Thread.sleep(2000);
				Logger.info("Options button is clicked on specified insertion");
				WebElement killInsertionLink = driver.findElement(By.xpath("html/body/ul/li[6]/a"));
				killInsertionLink.click();
				Thread.sleep(20000);
				Logger.info("deleted the insertion");
			}
			else{
				Logger.info("Options link for the specified insertion is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to convert insertion into order
	public void convertInsertion() throws Exception
	{
		try
		{		 
			WebElement convertInsertionButton = driver.findElement(By.xpath("//*[@id='convert-io-to-order']"));
			if(convertInsertionButton.isDisplayed())
			{
				convertInsertionButton.click();
				Thread.sleep(2000);
				Logger.info("Convert to Order button is clicked");

			}
			else{
				Logger.info("Convert to Order button is not displayed");
			}
			if(driver.getPageSource().contains("Your order contains one or more insertions that match auto insertion rules."))
			{

				Logger.info("Confirmation window is displayed requesting the user to either accept or reject the creation of legacy auto insertion");
				rejectLegacyAutoInsertion.click();
				String  text = displayMsg.getAttribute("value");
				Logger.info("Message is displayed in the pop up: " + text);
				Logger.info("'No' is clicked in confirmation window");
				//Logger.info("Order is submitted successfully");
				Thread.sleep(3000);
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	//code to add a sales person in an order
	public void addSalesPerson(String searchValue) throws Exception
	{
		try
		{
			if(searchSalesPersonTextbox.isDisplayed())
			{
				searchSalesPersonTextbox.click();
				searchSalesPersonTextbox.sendKeys(searchValue);
				WebElement searchResult = driver.findElement(By.xpath("//a[@class='customer-aclist-item ng-scope']/div/span[1]"));
				if(searchResult.isDisplayed())
				{
					searchResult.click();
					Logger.info(searchValue+" Sales Person is added at the order level");  
				}
				else{
					Logger.info("Sales person is not displayed");
				}
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void addServiceRep(String searchValue) throws Exception
	{
		Thread.sleep(4000); 

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

		try
		{
			/* WebElement serviceRepremove = driver.findElement(By.xpath("//*[@id='serviceRepInfo']/div/table/tbody/tr/td[4]/button"));
		  if(serviceRepremove.isDisplayed())
		  {
			  serviceRepremove.click();
		  }*/
			if(searchServiceRepTextbox.isDisplayed())
			{
				searchServiceRepTextbox.click();
				searchServiceRepTextbox.sendKeys(searchValue);
				WebElement searchResult = driver.findElement(By.xpath("//a[@class='customer-aclist-item ng-scope']/div/span[1]"));
				if(searchResult.isDisplayed())
				{
					searchResult.click();
					Logger.info(searchValue+" Service Rep is added at the order level");  
				}
				else{
					Logger.info("Service Rep is not displayed");
				}
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void changeSalesPerson(String searchValue) throws Exception
	{
		try
		{
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

			WebElement removeSalesesRepButton = driver.findElement(By.xpath(".//*[@id='order-detail-page']/div[2]/div[1]/div[2]/div/form/div[2]/div[2]/table/tbody/tr/td[3]/button"));
			if(removeSalesesRepButton.isDisplayed())
			{
				removeSalesesRepButton.click();
				Logger.info("Existing Sales person is removed");
			}
			else{
				Logger.info("Sales person is not found to be removed");
			}
			if(searchSalesPersonTextbox.isDisplayed())
			{
				searchSalesPersonTextbox.click();
				searchSalesPersonTextbox.sendKeys(searchValue);
				WebElement searchResult = driver.findElement(By.xpath("//a[@class='customer-aclist-item ng-scope']/div/span[1]"));
				if(searchResult.isDisplayed())
				{
					searchResult.click();
					Logger.info(searchValue+" Sales Person is added at the order level");  
				}
				else{
					Logger.info("Sales person is not displayed");
				}
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}



	//code to enter sales representative name/number in the search box
	public void enterSalesRep(String searchValue) throws Exception
	{
		try
		{
			if(searchSalesPersonTextbox.isDisplayed())
			{
				searchSalesPersonTextbox.click();
				searchSalesPersonTextbox.sendKeys(searchValue);
				Logger.error(searchValue+" sales person is entered in the search box");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to validate if inactive sales representatives are displayed in the search results
	public boolean validateSalesRepVisibility() throws Exception
	{
		try
		{
			WebElement searchResult = driver.findElement(By.xpath("//a[@class='customer-aclist-item ng-scope']/div/span[1]"));
			if(searchResult.isDisplayed())
				return true;
			else
				return false;
		}	
		catch(Exception e)
		{
			Logger.error("Sales Person is not displayed");
			return false;
		}
	}

	//code to validate the sales representative added
	public boolean validateSaleRepAdded(int row, int salesIDCol, int salesNameCol) throws Exception
	{
		try{
			List<WebElement> salesPerson = driver.findElements(By.xpath("//tr[@ng-repeat='salesperson in vm.order.SalesPersonList']/td[1]"));
			Iterator<WebElement> iterator = salesPerson.iterator();
			boolean flag = false;
			while(iterator.hasNext())
			{
				WebElement salesPersonElement = iterator.next();
				String salesPersonName = salesPersonElement.getText();
				int index = salesPersonName.lastIndexOf("SA");
				String salesRepID = salesPersonName.substring(index,salesPersonName.length() );
				String salesRepName = salesPersonName.substring(0,index-1);

				Logger.info(salesRepName);
				String requiredSalesRepID = TribuneUtils.getStringCellValues("Sales",row, salesIDCol);
				String requiredSalesRepName = TribuneUtils.getStringCellValues("Sales",row, salesNameCol);
				Logger.info(requiredSalesRepName);
				if(salesRepID.equalsIgnoreCase(requiredSalesRepID))
				{
					Logger.error("Sales Rep ID Validation success");
					if(salesRepName.equalsIgnoreCase(requiredSalesRepName))
					{
						Logger.error("Sales Rep name validation success");
						flag = true;
					}
					else{
						Logger.error("Sales Rep name validation failure");
						flag = false;
					}
				}
				else{
					Logger.error("Sales Rep ID Validation failure");
					flag = false;
				}
			}
			return flag;
		}
		catch(Exception e)
		{
			Logger.error("Sales Person is not as expected");
			return false;
		}
	}

	//code to click on primary button against the required sales person
	public void selectPrimarySalesPerson(String salesPersonEmpNumber) throws Exception
	{
		try
		{
			List<WebElement> salesPerson = driver.findElements(By.xpath("//tr[@ng-repeat='salesperson in vm.order.SalesPersonList']/td[1]"));
			Iterator<WebElement> iterator = salesPerson.iterator();
			while(iterator.hasNext())
			{
				WebElement salesPersonElement = iterator.next();
				String salesPersonName = salesPersonElement.getText();
				int index = salesPersonName.lastIndexOf("SA");
				String actualSalesPerson = salesPersonName.substring(index,salesPersonName.length() );
				if(actualSalesPerson.equalsIgnoreCase(salesPersonEmpNumber))
				{
					WebElement primaryLink = driver.findElement(By.xpath("//div[contains(text(),'"+salesPersonEmpNumber+"')]/..//a/span/i"));
					primaryLink.click();
					Logger.info("Sales person with num "+salesPersonEmpNumber+" is primary");
					break;
				}
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	//Code to delete the required sales person
	public void deleteSalesPerson(String salesPersonEmpNumber) throws Exception
	{
		try
		{
			List<WebElement> salesPerson = driver.findElements(By.xpath("//tr[@ng-repeat='salesperson in vm.order.SalesPersonList']/td[1]"));
			Iterator<WebElement> iterator = salesPerson.iterator();
			while(iterator.hasNext())
			{
				WebElement salesPersonElement = iterator.next();
				String salesPersonName = salesPersonElement.getText();
				int index = salesPersonName.lastIndexOf("SA");
				String actualSalesPerson = salesPersonName.substring(index,salesPersonName.length() );
				if(actualSalesPerson.equalsIgnoreCase(salesPersonEmpNumber))
				{
					WebElement deleteLink = driver.findElement(By.xpath("//div[contains(text(),'"+salesPersonEmpNumber+"')]/../..//button[@title='delete']/i"));
					deleteLink.click();
					Logger.info("Sales person with num "+salesPersonEmpNumber+" is deleted");
					break;
				}
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}  
	}

	//code to get the commission value for the sales person
	public int getSalesPersonComm(String salesPersonEmpNumber) throws Exception
	{
		int commissionPercent = 0;
		try
		{
			List<WebElement> salesPerson = driver.findElements(By.xpath("//tr[@ng-repeat='salesperson in vm.order.SalesPersonList']/td[1]"));
			Iterator<WebElement> iterator = salesPerson.iterator();
			while(iterator.hasNext())
			{
				WebElement salesPersonElement = iterator.next();
				String salesPersonName = salesPersonElement.getText();
				int index = salesPersonName.lastIndexOf("SA");
				String actualSalesPerson = salesPersonName.substring(index,salesPersonName.length() );
				if(actualSalesPerson.equalsIgnoreCase(salesPersonEmpNumber))
				{
					WebElement salesComm = driver.findElement(By.xpath("//div[contains(text(),'"+salesPersonEmpNumber+"')]/../..//span[@id='Span4']/span"));
					String comm = salesComm.getText();
					commissionPercent = Integer.parseInt(comm.substring(0, comm.length()-1));
					Logger.info("Sales person with num "+salesPersonEmpNumber+" has "+comm+" commission");
					break;
				}
			}
			return commissionPercent;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to validate the sales person commission value
	public boolean validateSalesPersonComm() throws Exception
	{
		boolean flag = false;
		try
		{
			List<WebElement> salesPersonComm = driver.findElements(By.xpath("//tr[@ng-repeat='salesperson in vm.order.SalesPersonList']//span[@id='Span4']/span"));
			Iterator<WebElement> iterator = salesPersonComm.iterator();
			int indexOfSalesRep = 1;
			int totalCommission = 0;
			while(iterator.hasNext())
			{
				WebElement salesPersonElement = iterator.next();
				String comm = salesPersonElement.getText();
				int commissionPercent = Integer.parseInt(comm.substring(0, comm.length()-1));
				totalCommission = totalCommission + commissionPercent;
				indexOfSalesRep++;
			}
			if(totalCommission==100)
			{
				flag = true;
				Logger.info("Validation success. Total commission is equal to 100");
			}
			return flag;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to edit the value in the auto adjust price field
	public void editAutoAdjustPrice(String insertionIndex, String price) throws Exception
	{
		try
		{
			if(autoAdjustPriceEdit.isDisplayed())
			{
				WebElement element = driver.findElement(By.xpath("(//label[text()='Auto / User Adjust']/../div/input[2])["+insertionIndex+"]"));
				/*autoAdjustPriceEdit.click();
			  autoAdjustPriceEdit.clear();
			  autoAdjustPriceEdit.sendKeys(price);*/
				element.click();
				element.clear();
				element.sendKeys(price);
				Thread.sleep(1000);
				Logger.info(price+" is entered in auto adjust price");
			}
			else{
				Logger.info("auto adjust price field is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to edit auto adjust percentage
	public void editAutoAdjustPercent(int percent) throws Exception
	{
		try
		{
			if(autoAdjustPercentTextBox.isDisplayed()){
				autoAdjustPercentTextBox.click();
				autoAdjustPercentTextBox.clear();
				autoAdjustPercentTextBox.sendKeys(""+percent);
				Logger.info(percent+ "is entered in auto adjust percent");
			}
			else{
				Logger.info("auto adjust percent field is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to get the price that is displayed in auto adjust price textbox
	public String getAutoAdjustPrice() throws Exception
	{
		String price = "";
		try
		{
			if(autoAdjustPriceEdit.isDisplayed())
			{
				String autoAdjustPrice = autoAdjustPriceEdit.getAttribute("value");
				int length = autoAdjustPrice.length();
				price = autoAdjustPrice.substring(1, length-1);
			}  
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
		return price;
	}

	//code to get the auto adjust percentage textbox
	public String  getAutoAdjustPercentage() throws Exception
	{
		String autoAdjustPercent = "";
		try
		{
			if(autoAdjustPercentTextBox.isDisplayed())
			{
				autoAdjustPercent = autoAdjustPercentTextBox.getAttribute("value");
			}  
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
		return autoAdjustPercent;
	}

	//code to check/uncheck position templated checkbox
	public void checkUncheckPosTemplateChckbx(int insertionIndex, boolean value) throws Exception
	{
		try{
			WebElement positionTemplateCheckbox = driver.findElement(By.xpath("//tbody["+insertionIndex+"]//label[contains(text(),'Position')]/label/input"));
			if(value)
			{
				if(positionTemplateCheckbox.isSelected()){
					Logger.info("position templated check box is already selected");
				}
				else{
					positionTemplateCheckbox.click();
					Logger.info("position templated check box is selected");
				}
			}
			else{
				if(positionTemplateCheckbox.isSelected()){
					positionTemplateCheckbox.click();
					Logger.info("position templated check box is deselected");
				}
				else{
					Logger.info("position templated check box is not selected");
				}
			}
			/* String checkStatus = "";
		  checkStatus = positionTemplatedChckBx.getAttribute("aria-checked");
		  if(value)
		  {
			  if(checkStatus.equalsIgnoreCase("false")){
				  positionTemplatedChckBx.click();
				  Logger.info("position templated check box is selected");
			  }
			  else{
				  Logger.info("position templated check box is already selected");
			  }
		  }
		  else{
			  if(checkStatus.equalsIgnoreCase("false")){
				  Logger.info("position templated check box is deselected");
			  }
			  else{
				  positionTemplatedChckBx.click();
				  Logger.info("position templated check box is deselected");
			  }
		  }*/

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickOnProgramPriceSelector() throws Exception
	{

		try
		{

			// WebElement programSelect = driver.findElement(By.xpath(".//label[text()='Program Price / Rate']/../div/a/span/span[1]"));
			WebElement programSelect = driver.findElement(By.xpath("//label[text()='Program Price ']/../div/a/span/span[1]"));//swagata

			programSelect.click();
			WebElement programPriceSelector2 = driver.findElement(By.xpath("//*[@id='Span21']/span[2]/i"));
			if(programPriceSelector2.isDisplayed()){
				programPriceSelector2.click();
				Logger.info("programPriceSelector button is clicked");
			} 
			else{
				Logger.info("programPriceSelector is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickOnProgramPriceSelectorDisplay() throws Exception
	{

		try
		{

			WebElement programSelect = driver.findElement(By.xpath("//label[text()='Program Price ']/../div/a/span/span[1]"));
			programSelect.click();
			//  WebElement programSelect = driver.findElement(By.xpath("//*[@id='Span21']/span[2]/i"));
			if(programPriceSelector.isDisplayed()){
				programPriceSelector.click();
				Logger.info("programPriceSelector button is clicked");
			} 
			else{
				Logger.info("programPriceSelector is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	public void clickOnProgramPriceSelectorPreprint() throws Exception
	{

		try
		{

			WebElement programSelect = driver.findElement(By.xpath("//label[text()='Program Price / Rate ']/../div/a/span/span[1]"));
			programSelect.click();
			WebElement programPriceSelector1 = driver.findElement(By.xpath("//*[@id='Span21']/span[2]/i"));
			if(programPriceSelector1.isDisplayed()){
				programPriceSelector1.click();
				Logger.info("programPriceSelector button is clicked");
			} 
			else{
				Logger.info("programPriceSelector is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	public void selectFirstSpecialProgramPromotion() throws Exception
	{
		WebElement programSelect = driver.findElement(By.xpath("((//div[text()='Promotion'])[1])"));


		try
		{
			if(programSelect.isDisplayed()){
				programSelect.click();
				Logger.info("First promotion program is selected");
				Thread.sleep(4000);
				WebElement done = driver.findElement(By.xpath("//button[text()='OK']"));
				done.click();
			} 
			else{
				Logger.info("No promotion program found");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void verifyProgramPriceSorting() throws Exception
	{

		try
		{
			WebElement zoneSorter = driver.findElement(By.xpath("(//span[text()='Name']/../..//i[@class='ui-grid-icon-angle-down'])"));
			zoneSorter.click();
			WebElement zoneSorterAsc = driver.findElement(By.xpath("//*[@id='menuitem-0']/button"));
			zoneSorterAsc.click();
			WebElement verifyAscZoneSortIcon = driver.findElement(By.xpath("(//span[text()='Name']/../..//i[@class='ui-grid-icon-up-dir'])"));
			if (verifyAscZoneSortIcon.isDisplayed())
			{
				Logger.info(" Name sorted in ascending order "); 
			}
			else
			{
				Logger.info(" Name not sorted in ascending order ");
			}
			zoneSorter.click();
			WebElement zoneSorterDesc = driver.findElement(By.xpath("//*[@id='menuitem-1']/button"));
			zoneSorterDesc.click();
			WebElement verifyDescZoneSortIcon = driver.findElement(By.xpath("//span[text()='Name']/../..//i[@class='ui-grid-icon-down-dir']"));
			if (verifyDescZoneSortIcon.isDisplayed())
			{
				Logger.info(" Name sorted in descending order "); 
			}
			else
			{
				Logger.info(" Name not sorted in descending order ");
			}


			WebElement zoneSorter1 = driver.findElement(By.xpath("(//span[text()='Type']/../..//i[@class='ui-grid-icon-angle-down'])"));
			zoneSorter1.click();
			WebElement zoneSorterAsc1 = driver.findElement(By.xpath("//*[@id='menuitem-0']/button"));
			zoneSorterAsc1.click();
			WebElement verifyAscZoneSortIcon1 = driver.findElement(By.xpath("(//span[text()='Type']/../..//i[@class='ui-grid-icon-up-dir'])"));
			if (verifyAscZoneSortIcon1.isDisplayed())
			{
				Logger.info(" Type sorted in ascending order "); 
			}
			else
			{
				Logger.info(" Type not sorted in ascending order ");
			}
			zoneSorter1.click();
			WebElement zoneSorterDesc1 = driver.findElement(By.xpath("//*[@id='menuitem-1']/button"));
			zoneSorterDesc1.click();
			WebElement verifyDescZoneSortIcon1 = driver.findElement(By.xpath("//span[text()='Type']/../..//i[@class='ui-grid-icon-down-dir']"));
			if (verifyDescZoneSortIcon1.isDisplayed())
			{
				Logger.info(" Type sorted in descending order "); 
			}
			else
			{
				Logger.info(" Type not sorted in descending order ");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectProgramPromotion(String Promotion) throws Exception
	{
		WebElement programSelect = driver.findElement(By.xpath("//div[text()='"+Promotion+"']"));


		try
		{
			if(programSelect.isDisplayed()){
				//programSelect.click();//swagata
				Thread.sleep(4000);
				Actions action = new Actions(driver);//swagata
				action.moveToElement(programSelect).click().perform();//swagata
				
				Logger.info(" promotion program is selected");
				Thread.sleep(4000);
				WebElement done = driver.findElement(By.xpath("//button[text()='OK']"));
				done.click();
			} 
			else{
				Logger.info("No promotion program found");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clearProgramPromotion() throws Exception
	{
		WebElement programSelect = driver.findElement(By.xpath("//*[@id='insertionInfo']/form/div/table/tbody/tr[2]/td/div/fieldset/div/div/div[1]/div/div[3]/div[2]/label/span/i"));


		try
		{
			if(programSelect.isDisplayed()){
				programSelect.click();
				Logger.info(" promotion program is cleared");
				Thread.sleep(4000);
			} 
			else{
				Logger.info("No promotion program clear button found");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clearProgramPromotionDisplay() throws Exception
	{
		WebElement programSelect = driver.findElement(By.xpath("//span[text()='clear']/i"));


		try
		{
			if(programSelect.isDisplayed()){
				programSelect.click();
				Logger.info(" promotion program is cleared");
				Thread.sleep(4000);
			} 
			else{
				Logger.info("No promotion program clear button found");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clearBleedDisplay(int index) throws Exception
	{
		WebElement programSelect = driver.findElement(By.xpath("(//label[text()='Bleed']/span/i)["+index+"]"));


		try
		{
			if(programSelect.isDisplayed()){
				programSelect.click();
				Logger.info(" bleed is cleared");
				Thread.sleep(4000);
			} 
			else{
				Logger.info("No bleed clear button found");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to click on the position selector
	public void clickOnPositionSelector() throws Exception
	{
		//label[contains(text(),'Position')]/../div/span/i
		try
		{
			if(positionSelector.isDisplayed()){
				positionSelector.click();
				Logger.info("position selector button is clicked");
				Thread.sleep(32000);
			} 
			else{
				Logger.info("position selector is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickOnPositionSelctr(int insertionIndex) throws Exception
	{
		WebElement positionSelectr = driver.findElement(By.xpath("(//label[contains(text(),'Position')]/../div/span/i)["+insertionIndex+"]"));


		try
		{
			if(positionSelectr.isDisplayed()){
				positionSelectr.click();
				Logger.info("position selector button is clicked");
			} 
			else{
				Logger.info("position selector is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	//Code to select the ad size inside positon selector window
	public void selectAdSizeForPosition() throws Exception
	{

		try{
			if(positionAdSize.isDisplayed()){
				Select selectAdSize = new Select(positionAdSize);
				// positionAdSize.click();
				selectAdSize.selectByVisibleText("Any");

				clickOnSearchPositionInPSWindw();
				Logger.info("required Ad Size is selected for the position");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to click on serach button inside position selector window
	public void clickOnSearchPositionInPSWindw() throws Exception
	{
		try{
			if(searchPositionInPositionSelector.isDisplayed()){
				searchPositionInPositionSelector.click();
				Logger.info("search button is clicked");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select the position from the position selector
	public void selectPostionFrmPositionSlctr(String pageNum, String positionInPage) throws Exception
	{
		try{
			List<WebElement> positionAvailabilityList = driver.findElements(By.xpath("//th[contains(text(),'Page')]/../../../tbody/tr"));
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfAllElements(positionAvailabilityList));
			WebElement positionElement = driver.findElement(By.xpath("//td[text()='"+pageNum+"']/../td[contains(text(),'"+positionInPage+"')]"));
			positionElement.click();
			Logger.info("specified position is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select first position from the position selector
	public void selectFirstPostionFrmPositionSlctr() throws Exception
	{
		try{
			Thread.sleep(30000);
			List<WebElement> positionAvailabilityList = driver.findElements(By.xpath("//tr[@ng-repeat='adBlock in vm.newsLayoutData']"));
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfAllElements(positionAvailabilityList));
			WebElement positionElement = driver.findElement(By.xpath("(//tr[@ng-repeat='adBlock in vm.newsLayoutData']/td)[1]"));
			positionElement.click();
			Logger.info("first position is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectPostionFrmPositionSlctrByIndex(int index) throws Exception
	{
		try{
			List<WebElement> positionAvailabilityList = driver.findElements(By.xpath("//tr[@ng-repeat='adBlock in vm.newsLayoutData']"));
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfAllElements(positionAvailabilityList));
			WebElement positionElement = driver.findElement(By.xpath("//tr[@ng-repeat='adBlock in vm.newsLayoutData']["+index+"]/td[1]"));
			positionElement.click();
			Logger.info("position is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	//code to save the position selection from the position selector
	public void savePositionSelection() throws Exception
	{
		try{
			Thread.sleep(7000);
			WebDriverWait wait = new WebDriverWait(driver,200);		   
			wait.until(ExpectedConditions.elementToBeClickable(savepositionSelection));

			if(savepositionSelection.isDisplayed())
			{
				Thread.sleep(1000);
				// savepositionSelection.click();
				Actions action=new Actions(driver);
				action.moveToElement(savepositionSelection).click().build().perform();
				Thread.sleep(7000);
				try
				{
					if(submitOrderButton.isDisplayed())
					{
						wait.until(ExpectedConditions.elementToBeClickable(submitOrderButton));
						Logger.info("position is saved");
					}
					else
					{ 

						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", savepositionSelection);
					}
					Thread.sleep(7000);
				}
				catch(Exception e)
				{
					savepositionSelection.click();
					Logger.error(e.getMessage());
					throw e;
				} 
			}
			else{
				Logger.info("postion save button is not displayed");
			}
		}
		catch( Exception e ) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", savepositionSelection);
			Logger.error(e.getMessage());
			throw e;
		}
		finally {
			Logger.info("postion save button is not clicked");
		}
	}

	//code to click on tearsheet tab
	public void clickTearsheetTab() throws Exception
	{
		try
		{
			if(tearsheetTab.isDisplayed())
			{

				tearsheetTab.click();
				Logger.info("Tearsheet tab is clicked");
			}
			else{
				Logger.info("Tearsheet tab is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to click on overrun tab
	public void clickOverrunTab() throws Exception
	{
		try
		{
			if(overrunTab.isDisplayed())
			{

				overrunTab.click();
				Logger.info("overrunTab tab is clicked");
			}
			else{
				Logger.info("overrunTab tab is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to click on proof tab
	public void clickProofTab() throws Exception
	{
		try
		{
			if(proofTab.isDisplayed())
			{
				proofTab.click();
				Logger.info("Proof tab is clicked");
			}else{
				Logger.info("Proof tab is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to click on P&D tab
	public void clickOnPAndDTab() throws Exception
	{
		try
		{
			if(pAndDTab.isDisplayed())
			{
				pAndDTab.click();
				Logger.info("P&D tab is clicked");
			}else{
				Logger.info("P&D tab is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to click in new tearsheet link to create a new tearsheet
	public void clickNewTearsheet() throws Exception
	{
		try{
			if(newTearsheetLink.isDisplayed())
			{
				newTearsheetLink.click();
				Logger.info("new tearsheet link is clicked");
			}
			else{
				Logger.info("tearsheet link is not displayed"); 
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickNewOverrun() throws Exception
	{
		try{
			if(newOverrunLink.isDisplayed())
			{
				newOverrunLink.click();
				Logger.info("newOverrunLink is clicked");
			}
			else{
				Logger.info("newOverrunLink is not displayed"); 
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to click on edit tearsheet
	public void clickOnEditTearsheet() throws Exception
	{
		try
		{
			if(editTearsheetLink.isDisplayed())
			{
				editTearsheetLink.click();
				Logger.info("Edit Tearsheet link is clicked");
			}
			else{
				Logger.info("Edit link is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void validateTearsheetValues(String qty, String cntct, String cmpny, String addrs, String city, String state, String Zip, String phn) throws Exception
	{
		try
		{
			if(editTearsheetLink.isDisplayed())
			{
				editTearsheetLink.click();
				Logger.info("Edit Tearsheet link is clicked");
			}
			else{
				Logger.info("Edit link is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to delete the tearsheet
	public void clickOnDeleteTearsheet() throws Exception
	{
		try
		{
			if(deleteTearsheetLink.isDisplayed())
			{
				deleteTearsheetLink.click();
				Logger.info("delete tearsheet link is clicked");
			}
			else{
				Logger.info("delete tearsheet link is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to click in new Proof link to create a new Proof
	public void clickOnNewProof() throws Exception
	{
		try{
			if(newProofLink.isDisplayed())
			{
				newProofLink.click();
				Logger.info("new proof link is clicked");
			}
			else{
				Logger.info("proof link is not displayed"); 
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to click on edit proof
	public void clickOnEditProof() throws Exception
	{
		try
		{
			if(editProofLink.isDisplayed())
			{
				editProofLink.click();
				Logger.info("Edit proof link is clicked");
			}
			else{
				Logger.info("Edit proof link is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to delete the proof
	public void clickOnDeleteProof() throws Exception
	{
		try
		{
			if(deleteProofLink.isDisplayed())
			{
				deleteProofLink.click();
				Logger.info("delete proof link is clicked");
			}
			else{
				Logger.info("delete proof link is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to click in request adjustment button
	public void clickOnAdjustmentRequest() throws Exception
	{
		try{

			WebElement moreActions = driver.findElement(By.xpath("//button[@title='More actions']"));
			moreActions.click();
			Thread.sleep(2000);
			//WebElement requestAdjustmentButton = driver.findElement(By.xpath(".//*[@id='order-detail-page']/div[1]/div/div[2]/div[4]/ul/li[3]/a"));
			WebElement requestAdjustmentButton = driver.findElement(By.xpath("//li[@tabindex='0']/a[text()='Request Adjustment']"));//Shalini
			if(requestAdjustmentButton.isDisplayed())
			{
				requestAdjustmentButton.click();
				Logger.info("requestAdjustmentButton is clicked");
			}
			else{
				Logger.info("requestAdjustmentButton is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	public String[] setAdjustmentRequest(String amount) throws Exception
	{
		String value="";
		String valueAcc="";
		try{

			Thread.sleep(3000);
			WebElement reasonDropdown = driver.findElement(By.xpath("//*[@id='orderStatusId']"));
			if (reasonDropdown.isDisplayed())
			{
				reasonDropdown.click();
				Logger.info("reasonDropdown is clicked");
				Select valueFromStatus = new Select(reasonDropdown);
				List<WebElement> listOfValuesStatus = valueFromStatus.getOptions();
				if(listOfValuesStatus.size() !=0)
				{
					Logger.info("List of Reason is not empty"); 
					//valueFromStatus.selectByVisibleText(properties.getProperty(status));
					value = "Misquote";//swagata
					valueFromStatus.selectByVisibleText(value);//swagata
					Logger.info("reason is selected"); 
				}
			}
			else
			{
				Logger.info("reasonDropdown not displayed");
				throw new NoSuchElementException("reasonDropdown is not displayed");
			}
			if (adjustmentAccountability.isDisplayed())
			{
				adjustmentAccountability.click();
				Logger.info("Accountability dropdown is clicked");
				Select valueFromStatus = new Select(adjustmentAccountability);
				List<WebElement> listOfValuesStatus = valueFromStatus.getOptions();
				if(listOfValuesStatus.size() !=0)
				{
					Logger.info("List of Accountability is not empty"); 
					valueAcc = "SalesRep";
					valueFromStatus.selectByVisibleText(valueAcc);
					Logger.info("Accountability is selected"); 
				}
			}
			else
			{
				Logger.info("Accountability Dropdown not displayed");
				throw new NoSuchElementException("Accountability Dropdown is not displayed");
			}//swagata
			Thread.sleep(3000);
			WebElement descriptionTestBox = driver.findElement(By.xpath("//input[@ng-model='vm.adjustment.Description']"));
			if (descriptionTestBox.isDisplayed())
			{
				descriptionTestBox.click();
				descriptionTestBox.clear();
				descriptionTestBox.sendKeys("Adjustment Automation Test");
				Logger.info("description entered");
			}
			else
			{
				Logger.info("descriptionTestBox not displayed");
				throw new NoSuchElementException("descriptionTestBox is not displayed");
			}
			Thread.sleep(3000);
			WebElement clickAdjustmentAmount = driver.findElement(By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[11]"));
			Actions action = new Actions(driver);
			action.moveToElement(clickAdjustmentAmount).doubleClick().build().perform();
			Thread.sleep(3000);
			WebElement enterAdjustmentAmount = driver.findElement(By.xpath("//form[@class='ng-pristine ng-valid']/input"));
			enterAdjustmentAmount.click();
			enterAdjustmentAmount.clear();
			enterAdjustmentAmount.sendKeys(""+amount);
			Logger.info("AdjustmentAmount entered");
			Thread.sleep(3000);
			WebElement selectInsertion = driver.findElement(By.xpath("(//*[@role='checkbox'])[1]"));
			action.moveToElement(selectInsertion).doubleClick().build().perform();
			Logger.info("Row selected");
			Thread.sleep(3000);
			WebElement submitAdjustment = driver.findElement(By.xpath("//button[text()='Submit']"));
			submitAdjustment.click();	
			Logger.info("AdjustmentAmount submitted");
			Thread.sleep(3000);
			WebElement confirmAdjustment = driver.findElement(By.xpath("//button[text()='Yes']"));
			confirmAdjustment.click();	  
			Logger.info("AdjustmentAmount confirmed");
			Thread.sleep(3000);
			String[] ans = new String[2]; 
			ans[0] = value; 
			ans[1] = valueAcc;
			return ans;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to click in kill button
	public void clickOnKill() throws Exception
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 150);//swagata
			wait.until(ExpectedConditions.elementToBeClickable(orderMoreActionsBtn));//swagata
			orderMoreActionsBtn.click();
			Thread.sleep(3000);
			if(orderKillBtnOrderViewPage.isDisplayed())
			{
				orderKillBtnOrderViewPage.click();
				Logger.info("kill button is clicked");
			}
			else{
				Logger.info("kill button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method is used to click on the kill button displayed in the kill order confirmation window 
	 */
	public void clickOnKillOnConfirmation() throws Exception
	{
		try{
			if(killOrderButtonOnConformation.isDisplayed())
			{ killOrderButtonOnConformation.click();
			Logger.info("Kill button is clicked on the kill confirmation window");}
			else
			{
				Logger.info("Kill button is clicked on the kill confirmation window");}
		}
		catch(Exception e)
		{

			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to click in recurrence button
	public void clickOnRecurrence() throws Exception
	{
		try{
			orderMoreActionsBtn.click();
			if(orderRecurrenceBtn.isDisplayed())
			{
				orderRecurrenceBtn.click();
				Logger.info("recurrence button is clicked");
			}
			else{
				Logger.info("recurrence butoon is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to click order repeat drop down to select the range when the order should repeat itself
	public void selectOrderRepeatInterval(String interval) throws Exception
	{
		try{
			Select select = new Select(orderRepeatDrpDwn);
			select.selectByVisibleText(properties.getProperty(interval));
			Logger.info("order repeat duration is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	//code to enter the number of days the order should repeat
	public void enterRepeatDays(int days) throws Exception
	{
		try{
			if(repeatDays.isDisplayed())
			{
				repeatDays.click();
				repeatDays.clear();
				repeatDays.sendKeys(""+days);
				Logger.info("Repeat days is entered");
			}else{
				Logger.info("Repeat days text box is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	public void getValueFromPriceDetailsInNewOrderPg()throws Exception
	{
		try
		{     threeDotIconInNewOrder.click();

		WebElement priceDetailsOption=driver.findElement(By.xpath("//a[text()='Price Details']"));
		if(priceDetailsOption.isDisplayed())
		{
			Logger.info("Found "+priceDetailsOption);
			priceDetailsOption.click();
			Thread.sleep(4000);
		}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	public String getOrderFromTransferExcel(int row, int col) throws Exception
	{
		try
		{
			String value = TribuneUtils.getStringCellValues("TransferExcel",row, col);

			Logger.info(value +" excel data fetched");
			Thread.sleep(2000);
			return value;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	public void verifyTransferredOrderPrice(String text) throws Exception {
		WebElement webElement = driver.findElement(By.xpath("//*[@id='order-detail-page']/div[1]/div/div[1]/div/span[2]"));
		String transferredPrice = webElement.getText();
		Logger.info("Price equals to : " + transferredPrice);
		Assert.assertEquals(text, transferredPrice);
		Logger.info("Price is as expected");
	}//arka

	//Code to enter the start date
	public void enterStartDate(String dd, String mm, String yyyy) throws Exception
	{
		startDate.click();
		Logger.info("start date is clicked");
		startDate.sendKeys(Keys.CONTROL,"a");
		startDate.clear();
		startDate.sendKeys(mm+"/"+dd+"/"+yyyy);
		startDate.sendKeys(Keys.CONTROL,"a");
		startDate.clear();
		startDate.sendKeys(mm+"/"+dd+"/"+yyyy);
		Logger.info(dd+"/"+mm+"/"+yyyy +" is entered");
		/* List<WebElement> curentMonthElement = driver.findElements(By.xpath("(//div[@class='datepicker-days']/table/thead/tr[1]/th[2])[2]"));
	  String currentMonthYear = "";
	  //Logger.info("Size ==\t"+curentMonthElement.size());
	  for(int i=0;i<curentMonthElement.size();i++){
		   currentMonthYear = curentMonthElement.get(i).getText();
		   Logger.info("currentMonthYear =\t"+currentMonthYear);
  		}
	  currentMonthYear = curentMonthElement.get(0).getText();
	  Logger.info("current month year from calendar "+currentMonthYear);
	  String expectedDate = properties.get(month).toString() + " " + year;
	  Logger.info("expected month year from user " +expectedDate);
	  if(currentMonthYear.equalsIgnoreCase(expectedDate))
	  {
	  	  List<WebElement> dateElement = driver.findElements(By.xpath("//td[text()='"+date+"']"));
	  	 // Thread.sleep(5000);
	  	  int index = 0;
	  	  for(int i=0;i<dateElement.size();i++){
			   String expectedDate1 = dateElement.get(i).getText();
			   if(expectedDate1.contentEquals(date))
			   {
				   index = i;
			   }
			   Logger.info("expectedDate1 =\t"+expectedDate1);
	  		}
	  	  dateElement.get(index).click(); 
	  	  //Thread.sleep(2000);
	  	  Logger.info(date+"/"+month+"/"+year +" is entered");
	  }
	  else
	  {
	  	  int length = currentMonthYear.length();
	  	  String currentyear = currentMonthYear.substring(length-4, length);
	  	  if(currentyear.equalsIgnoreCase(year))
	  	  {
	  	  curentMonthElement.get(0).click();
	  	 // Thread.sleep(4000);
	  	  WebElement expectedMonthElement = driver.findElement(By.xpath("(//span[text()='"+month+"'])[2]"));
	  	  expectedMonthElement.click();
	  	  Logger.info("Month is selected");
	  	// Thread.sleep(5000);
	  	  List<WebElement> dateElement = driver.findElements(By.xpath("//td[text()='"+date+"']"));
	  	  //Logger.info("Size ==\t"+dateElement.size());
	  	int index = 0;
		  for(int i=0;i<dateElement.size();i++){
			   String dateValue = dateElement.get(i).getText();
			   if(dateValue.contentEquals(date)){
				   index = i;
			   }
			}
		  dateElement.get(index).click();
		 // Thread.sleep(4000);
		  //dateElement.get(5).click();
	  	  Logger.info(date+"/"+month+"/"+year +" is entered");
	  	  }
	  	  else
	  	  {
	  		  curentMonthElement.get(0).click();
	  		//  Thread.sleep(5000);
	  		  List<WebElement> yearElement = driver.findElements(By.xpath("//table/thead/tr[1]/th[2]"));
	  	//	Thread.sleep(5000);
	  		 // Logger.info("Size ==\t"+yearElement.size());
	  		String year1 = "";
			  for(int i=0;i<yearElement.size();i++){
				   year1 = yearElement.get(i).getText();
				   Logger.info("year =\t"+year1);
		  		}
			  yearElement.get(0).click();
			  Logger.info("clicked on current year");
			//  Thread.sleep(5000);
	  		  WebElement expectedYearElement = driver.findElement(By.xpath("(//span[text()='"+year+"'])[2]"));
	  		for(int i=0;i<expectedYearElement.size();i++){
				 String expectedyear1 = expectedYearElement.get(i).getText();
				   Logger.info("year =\t"+expectedyear1);
		  		}

	  		  if(expectedYearElement.isDisplayed())
	  		  {
	  			  expectedYearElement.click();
	  			Logger.info("clicked on expected year");
	  		//	Thread.sleep(5000);
	  			  List<WebElement> expectedMonthElement = driver.findElements(By.xpath("//span[text()='"+month+"']"));
	  		//	Thread.sleep(5000);
	  			  for(int i=0;i<expectedMonthElement.size();i++){
					 String expectedmonth = expectedMonthElement.get(i).getText();
					   Logger.info("month =\t"+expectedmonth);
			  		}
	  			  expectedMonthElement.get(0).click();
	  			Logger.info("Expected month is clicked");
	  		//	Thread.sleep(5000);
	  			  List<WebElement> dateElement = driver.findElements(By.xpath("//td[text()='"+date+"']"));
	  			int index = 0;
	  			  for(int i=0;i<dateElement.size();i++){
					 String expecteddate = dateElement.get(i).getText();
					 if(expecteddate.contentEquals(date)){
						 index = i;
					 }
					   //Logger.info("date =\t"+expecteddate);
			  		}
	  			dateElement.get(index).click();
	  			//dateElement.get(5).click();
	  			  Logger.info(date+"/"+month+"/"+year +" is entered");
	  		  }
	  		  else
	  		  {
	  			  List<WebElement> next = driver.findElements(By.xpath("//th[@class='next']"));
	  			  for(int i=0;i<next.size();i++){
					 String expectedyear = next.get(i).getText();
					   Logger.info("next year =\t"+expectedyear);
			  		}
	  			//  Thread.sleep(5000);
	  			  next.get(index).click();
	  			  driver.findElement(By.xpath("(//span[text()='"+year+"'])[12]")).click();
	  			  driver.findElement(By.xpath("(//span[text()='"+month+"'])[1]")).click();
	  			  driver.findElement(By.xpath("(//td[text()='"+date+"'])[5]")).click();
	  			  Logger.info(date+"/"+month+"/"+year +" is entered");
	  		  }
	  	  }
	  }*/
	}

	//code to select never ends radio button
	public void selectNeverEnds() throws Exception
	{
		try{
			if (endsNeverRadioBtn.isDisplayed())
			{
				if(endsNeverRadioBtn.isSelected())
				{
					Logger.info("Never ends radio button is selected");
				}
				else
				{
					endsNeverRadioBtn.click();
					Logger.info("Never ends radio button is selected");
				}
			}else{
				Logger.info("never ends radio button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select ends after radio button 
	public void selectEndAfter() throws Exception
	{
		try{
			if(endsAfterRadioBtn.isDisplayed())
			{
				if(endsAfterRadioBtn.isSelected())
				{
					Logger.info("Ends After is selected");
				}
				else{
					endsAfterRadioBtn.click();
					Logger.info("Ends After radio button is selected");
				}
			}
			else{
				Logger.info("ends after textbox is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Code to enter the number of occurrences for ends after
	public void enterEndsAfterOccurrences(int occurrences) throws Exception
	{
		try{
			if(endsAfterRadioBtn.isSelected()){
				if(endsAfterOccurrenceTxtBx.isEnabled())
				{
					endsAfterOccurrenceTxtBx.click();
					endsAfterOccurrenceTxtBx.clear();
					endsAfterOccurrenceTxtBx.sendKeys(""+occurrences);
					Logger.info("number of occurrences is entered");
				}
				else{
					Logger.info("ends after occurrences test box is not enabled");
				}
			}
			else{
				Logger.info("ends after radio button is not selected");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select ends on radio button
	public void  selectEndsOn() throws Exception
	{
		try{
			if(endsOnRadioBtn.isDisplayed())
			{
				if(endsOnRadioBtn.isSelected())
				{
					Logger.info("Ends on is selected");
				}
				else{
					endsOnRadioBtn.click();
					Logger.info("Ends On radio button is selected");
				}
			}
			else{
				Logger.info("ends on textbox is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to enter ends on occurrences
	public void enterEndsOn(int occurrences) throws Exception
	{
		try{
			if(endsOnRadioBtn.isSelected()){
				if(endsOnOccurrenceTxtBx.isEnabled())
				{
					endsOnOccurrenceTxtBx.click();
					endsOnOccurrenceTxtBx.clear();
					endsOnOccurrenceTxtBx.sendKeys(""+occurrences);
					Logger.info("number of occurrences is entered");
				}
				else{
					Logger.info("ends on occurrences test box is not enabled");
				}
			}
			else{
				Logger.info("ends on radio button is not selected");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to save the recurrence details
	public void saveRecurrenceInfo() throws Exception
	{
		try
		{
			if(saveRecurrenceBtn.isDisplayed())
			{
				saveRecurrenceBtn.click();
				Logger.info("Recurrence is saved");
			}
			else{
				Logger.info("save recurrence button is not displayed"); 
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to cancel the recurrence info
	public void cancelRecurrenceInfo() throws Exception
	{
		try
		{
			if(cancelRecurrenceBtn.isDisplayed())
			{
				cancelRecurrenceBtn.click();
				Logger.info("Recurrence details entered are canceled");
			}
			else{
				Logger.info("cancel recurrence button is not displayed"); 
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to click on more options button on an order
	public void clickMoreOptionsBtn() throws Exception
	{
		try{
			if(moreActionsOnOrderBtn.isDisplayed())
			{
				moreActionsOnOrderBtn.click();
				Logger.info("More options button is clicked");
			}
			else{
				Logger.info("More option button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	//Code to export the order as word or excel
	public void exportOrder() throws Exception
	{
		try{
			if(exportOrderBtn.isDisplayed())
			{
				exportOrderBtn.click();
				Logger.info("Export order button is clicked");

			}
			else{
				Logger.info("Export menu is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to get the pick up material source
	public String getMaterialSource(String insertionIndex) throws Exception
	{
		String materialSource = "";
		try
		{
			WebElement pickUpMaterialSource = driver.findElement(By.xpath("(//label[text()='Material Source']/../div/a/span[@id='Span6']/span)["+insertionIndex+"]"));
			if(pickUpMaterialSource.isDisplayed())
			{
				materialSource = pickUpMaterialSource.getText();
				Logger.info("material source " +materialSource);
			}
			else{
				Logger.info("material source is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
		return materialSource;
	}

	//code to select the material source
	public void selectMaterialSource(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement pickUpMaterialSource = driver.findElement(By.xpath("(//label[text()='Material Source']/../div/a/span[@id='Span6']/span)["+insertionIndex+"]"));
			pickUpMaterialSource.click();	
			Thread.sleep(3000);
			Select select = new Select (pickUpMaterialSourceDrpDwn);
			select.selectByVisibleText(value);
			Logger.info(value+ " pick up material source is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	public void selectPositionNonTemp(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement positionNonTemp = driver.findElement(By.xpath("((//label[contains(text(),'Position')])[1]/../div/a/span)["+insertionIndex+"]"));
			positionNonTemp.click();
			WebElement positionNonTempDrpdwn = driver.findElement(By.xpath("(//*[@id='insertionInfo']/form/div/table/tbody/tr[2]/td/div/div/div/div[1]/div/div[2]/div[1]/div/form/div/select)["+insertionIndex+"]"));
			Select select = new Select (positionNonTempDrpdwn);
			select.selectByVisibleText(value);
			Logger.info(value+ " position Non Temp is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectMaterialSource1(String value) throws Exception
	{
		try{
			WebElement pickUpMaterialSource = driver.findElement(By.xpath("(//*[@id='Span6']/span)[2]"));
			pickUpMaterialSource.click();			 
			Thread.sleep(3000);
			//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/table/tbody/tr[2]/td/div/div/div/div[1]/div/div[2]/div[3]/div/form/div/select
			Select select = new Select (pickUpMaterialSourceDrpDwn);
			select.selectByVisibleText((value));
			Logger.info((value)+ " pick up material source is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectMaterialSource2(String value) throws Exception
	{
		try{
			WebElement pickUpMaterialSource = driver.findElement(By.xpath("(//*[@id='Span6']/span)[4]"));
			pickUpMaterialSource.click();			 
			Thread.sleep(3000);
			//*[@id='order-detail-page']/div[2]/div[3]/div[2]/form/div/table/tbody/tr[2]/td/div/div/div/div[1]/div/div[2]/div[3]/div/form/div/select
			Select select = new Select (pickUpMaterialSourceDrpDwn);
			select.selectByVisibleText((value));
			Logger.info((value)+ " pick up material source is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	//code to click on the pick up search button
	public void clickOnPickUpSearch() throws Exception
	{
		try
		{
			if(pickUpNumSearchBtn.isDisplayed()){
				pickUpNumSearchBtn.click();
				Logger.info("pick up search button is clicked");
				WebDriverWait wait = new WebDriverWait(driver,120);
				WebElement pickUpWindowTitle = driver.findElement(By.xpath("//h3[contains(text(),'Pickup')]"));
				wait.until(ExpectedConditions.visibilityOf(pickUpWindowTitle));
			}
			else{
				Logger.info("pick up search button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickOnPickUpSearchIndex(int index) throws Exception
	{
		try
		{
			WebElement pickUpNumSearchBtn = driver.findElement(By.xpath("(//label[text()='Pickup #']/../div/span/i)["+index+"]"));

			if(pickUpNumSearchBtn.isDisplayed()){
				pickUpNumSearchBtn.click();
				Logger.info("pick up search button is clicked");
				WebDriverWait wait = new WebDriverWait(driver,120);
				WebElement pickUpWindowTitle = driver.findElement(By.xpath("//h3[contains(text(),'Pickup')]"));
				wait.until(ExpectedConditions.visibilityOf(pickUpWindowTitle));
			}
			else{
				Logger.info("pick up search button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}



	public void selectPickUp(String Order) throws Exception
	{
		try
		{     JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement typeFilterFull = driver.findElement(By.xpath("//div[text()='"+Order+"']"));
		js.executeScript("arguments[0].scrollIntoView();", typeFilterFull);
		typeFilterFull.click();		 
		Thread.sleep(6000);
		WebElement selectZone = driver.findElement(By.xpath("//button[text()='Select']"));
		selectZone.click();
		Logger.info("Order Pick Up "+Order+" is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectFirstPickUpByCustomer(String customer) throws Exception
	{
		try
		{
			WebElement typeFilterFull = driver.findElement(By.xpath("(//div[text()='"+customer+"'])[1]"));
			typeFilterFull.click();		 
			Thread.sleep(4000);
			WebElement selectZone = driver.findElement(By.xpath("//button[text()='Select']"));
			selectZone.click();
			Logger.info("First Order Pick Up for "+customer+" is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void enterAdMarcNo(String Order) throws Exception
	{
		try
		{
			WebElement adMarcTab = driver.findElement(By.xpath("//a[text()='Ad Marc']"));
			if(adMarcTab.isDisplayed()){
				adMarcTab.click();
				Logger.info("adMarcTab is clicked");
				WebDriverWait wait = new WebDriverWait(driver,120);
				WebElement orderTextBox = driver.findElement(By.xpath("//*[@id='adMarcOrderNumber']"));
				wait.until(ExpectedConditions.visibilityOf(orderTextBox));
				orderTextBox.sendKeys(Order);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[text()='Select']")).click();
			}
			else{
				Logger.info("pick up search button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void enterPandDcolors(String color) throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,120);
			WebElement colorTextBox1 = driver.findElement(By.xpath("//input[@ng-model='vm.orderLine.PDPrintSpec.Color1Front']"));
			wait.until(ExpectedConditions.visibilityOf(colorTextBox1));
			colorTextBox1.sendKeys(color);
			Thread.sleep(3000);

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	public void enterPandDcolors1(String color) throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,120);
			WebElement colorTextBox1 = driver.findElement(By.xpath("//input[@ng-model='vm.orderLine.PDPrintSpec.Color2Front']"));
			wait.until(ExpectedConditions.visibilityOf(colorTextBox1));
			colorTextBox1.sendKeys(color);
			Thread.sleep(3000);

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void enterPandDcolors2(String color) throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,120);
			WebElement colorTextBox1 = driver.findElement(By.xpath("//input[@ng-model='vm.orderLine.PDPrintSpec.Color3Front']"));
			wait.until(ExpectedConditions.visibilityOf(colorTextBox1));
			colorTextBox1.sendKeys(color);
			Thread.sleep(3000);

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to enter the from date in the pick up window 
	public void enterFromDatePickUpWndw(String date, String month, String year) throws Exception
	{
		/*String pubDatePath = "/tr[1]/td/div/a/span[@id='Span8']/span"; 
	  WebElement pubDate = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+pubDatePath));*/
		fromDatePickUpWindow.click();
		WebElement curentMonthElement = driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[1]"));
		String currentMonthYear = curentMonthElement.getText();
		Logger.info("current month year from calendar "+currentMonthYear);
		String expectedDate = properties.get(month).toString() + " " + year;
		Logger.info("expected month year from user " +expectedDate);
		if(currentMonthYear.equalsIgnoreCase(expectedDate))
		{
			WebElement dateElement = driver.findElement(By.xpath("//td[@class='day'][text()='"+date+"']"));
			dateElement.click();
			Logger.info(date+"/"+month+"/"+year +" is entered");
		}
		else
		{
			int length = currentMonthYear.length();
			String currentyear = currentMonthYear.substring(length-4, length);
			if(currentyear.equalsIgnoreCase(year))
			{
				curentMonthElement.click();
				WebElement expectedMonthElement = driver.findElement(By.xpath("//td/span[text()='"+month+"']"));
				expectedMonthElement.click();
				WebElement dateElement = driver.findElement(By.xpath("//td[@class='day'][text()='"+date+"']"));
				dateElement.click();
				Logger.info(date+"/"+month+"/"+year +" is entered");
			}
			else
			{
				curentMonthElement.click();
				WebElement yearElement = driver.findElement(By.xpath("//div[@class='datepicker-months']/table/thead/tr/th[@class='datepicker-switch']"));
				yearElement.click();
				WebElement expectedYearElement = driver.findElement(By.xpath("//td/span[@class='year'][text()='"+year+"']"));
				if(expectedYearElement.isDisplayed())
				{
					expectedYearElement.click();
					WebElement expectedMonthElement = driver.findElement(By.xpath("//td/span[text()='"+month+"']"));
					expectedMonthElement.click();
					WebElement dateElement = driver.findElement(By.xpath("//td[@class='day'][text()='"+date+"']"));
					dateElement.click();
					Logger.info(date+"/"+month+"/"+year +" is entered");
				}
				else
				{
					WebElement next = driver.findElement(By.xpath("//th[@class='next']"));
					next.click();
					driver.findElement(By.xpath("//td/span[text()='"+year+"']")).click();
					driver.findElement(By.xpath("//td/span[text()='"+month+"']")).click();
					driver.findElement(By.xpath("//td[@class='day'][text()='"+date+"']")).click();
					Logger.info(date+"/"+month+"/"+year +" is entered");
				}
			}
		}
	}

	//code to enter the order number in search pick up window
	public void enterOrderId(String orderId) throws Exception
	{
		try{
			if(orderIDInPickUpWindow.isDisplayed())
			{
				orderIDInPickUpWindow.click();
				orderIDInPickUpWindow.sendKeys(orderId);
				Logger.info(orderId+" order number is entered");
			}
			else{
				Logger.info("order Id text box is not visible");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to click on search button to search the order in pick up window
	public void clickOnSearchOrder() throws Exception
	{
		try{
			if(searchBtnInPickUpWindow.isDisplayed()){
				searchBtnInPickUpWindow.click();
				Logger.info("search button is clicked");
			}
			else{
				Logger.info("order search button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to click on order from the pick up window search results
	public void clickOnOrderInPickUpWindw() throws Exception
	{
		try
		{

			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(orderLinkInPickUpWindow));
			Thread.sleep(1000);
			if(orderLinkInPickUpWindow.isDisplayed()){
				orderLinkInPickUpWindow.click();
				Logger.info("order link is clicked");
			}
			else{
				Logger.info("order link is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickOnSpecificOrderInPickUpWindw(String order) throws Exception
	{
		try
		{
			WebElement orderLinkInPickUpWindow1 = driver.findElement(By.xpath("//div[@class='ui-grid-canvas']/div/div[@class='ng-isolate-scope']//*[text()='"+order+"']/.."));
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(orderLinkInPickUpWindow1));
			Thread.sleep(1000);
			if(orderLinkInPickUpWindow1.isDisplayed()){
				orderLinkInPickUpWindow1.click();
				Logger.info("order link is clicked");
			}
			else{
				Logger.info("order link is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to click in select button to select the required order in the pick up window
	public void clickOnSelectBtnPickUpWindw() throws Exception
	{
		try{
			if(selectBtnInPickUpWindow.isDisplayed())
			{
				selectBtnInPickUpWindow.click();
				Logger.info("order is selected in the pick up window");
			}
			else{
				Logger.info("select button is not displayed in the pick up window");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}



	//code to click on assign distribution button
	public void clickOnAssignDistributionBtn() throws Exception
	{
		try
		{
			if(assignDistributionBtn.isDisplayed())
			{
				assignDistributionBtn.click();
				Logger.info("assign ditribution is clicked");
			}
			else{
				Logger.info("assign distribution button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to get the distribution assigned
	public String getDistributions() throws Exception
	{
		String distributions = "";
		try
		{
			if(distributionValue.isDisplayed())
			{
				distributions = distributionValue.getAttribute("value");
				Logger.info("Distributions assigned "+distributions);
			}
			else{
				Logger.info("distribution is not displayed"); 
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
		return distributions;
	}

	// code to cancel the distribution selection
	public void clickOnCancelDistributionBtn() throws Exception
	{
		try
		{
			if(cancelDistributionBtn.isDisplayed())
			{
				cancelDistributionBtn.click();
				Logger.info("cancel ditribution is clicked");
			}
			else{
				Logger.info("cancel distribution button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to check the visibility of orderline description field
	public boolean checkDescOrderLineVisibility(String insertionIndex) throws Exception
	{
		try{
			WebElement descriptionOrderLine = driver.findElement(By.xpath("(//label[text()='Description']/../div/input)["+insertionIndex+"]"));
			if(descriptionOrderLine.isDisplayed())
			{
				Logger.info("description in the orderline is displayed");
				return true;
			}
			else{
				Logger.info("description in the orderline is displayed");
				return false;
			}
		}
		catch(Exception e)
		{
			Logger.info("description in the orderline is not displayed");
			return false;
		} 
	}

	//code to enter Online insertion order description
	public void enterOnlineIODescription(String insertionIndex) throws Exception
	{
		try{
			WebElement onlineDesc = driver.findElement(By.xpath("(//label[text()='End Date / Desc']/../div/input[2])["+insertionIndex+"]"));
			onlineDesc.click();
			TribuneUtils utils = new TribuneUtils(); 
			onlineDesc.sendKeys(utils.generateRandomString(8));
			Logger.info("description for the online insertion is entered");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select the type in the settings tab for a preprint order
	public void selectTypeInSettingsPreprintOrder(String insertionIndex, String value) throws Exception
	{
		try{			 
			WebElement type = driver.findElement(By.xpath("(//label[text()='Type']/../div/a/span[@id='Span5']/span)["+insertionIndex+"]"));
			WebDriverWait wait= new WebDriverWait(driver, 200);//swagata
			wait.until(ExpectedConditions.elementToBeClickable(type));//swagata
			type.click();
			Thread.sleep(2000);
			Select select = new Select (typeSettingsPreprintDrpDwn);
			select.selectByVisibleText(properties.getProperty(value));
			Logger.info(properties.getProperty(value)+ " type is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectPositionPreprintOrder(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement type = driver.findElement(By.xpath("(//label[text()='Position']/../div/a/span[@id='Span3']/span)["+insertionIndex+"]"));
			type.click();
			WebElement typeSettingsPreprintDrpDwn1 = driver.findElement(By.xpath("(//*[@id='insertionInfo']/form/div/table/tbody/tr[2]/td/div/div/div/div[1]/div/div[1]/div[2]/div/form/div/select)["+insertionIndex+"]"));
			Select select = new Select (typeSettingsPreprintDrpDwn1);
			select.selectByVisibleText((value));
			Logger.info((value)+ " position is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectZoneLevelPreprintOrder(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement type = driver.findElement(By.xpath("(//label[text()='Zone Level']/../div/a/span[@id='Span4']/span)["+insertionIndex+"]"));
			type.click();
			WebElement typeSettingsPreprintDrpDwn1 = driver.findElement(By.xpath("(//*[@id='insertionInfo']/form/div/table/tbody/tr[2]/td/div/div/div/div[1]/div/div[2]/div[3]/div/form/div/select)["+insertionIndex+"]"));
			Select select = new Select (typeSettingsPreprintDrpDwn1);
			select.selectByVisibleText((value));
			Logger.info((value)+ " Zone Level is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to click on new customer check box
	public void clickOnNewCustomer() throws Exception
	{
		try{
			if(newCustomerCheckBox.isDisplayed()){
				newCustomerCheckBox.click();
				Logger.info("new customer button is clicked");
			}
			else{
				Logger.info("new customer button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnNewCustomerInsertion() throws Exception
	{
		try{
			if(newCustomerCheckBoxInsertion.isDisplayed()){
				newCustomerCheckBoxInsertion.click();
				Logger.info("new customer checkbox is clicked");
			}
			else{
				Logger.info("new customer checkbox is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void verifyNewCustomerButtonDisabled() throws Exception
	{
		try{
			if(newCustomerCheckBox.isDisplayed()){
				String buttonStatus =  newCustomerCheckBox.getAttribute("disabled");
				Logger.info("new customer button is currently : "+buttonStatus);
				Assert.assertEquals("disabled", buttonStatus);
			}
			else{
				Logger.info("new customer button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to enter customer information for a new customer
	public String enterCustomerInfo(String sheetName) throws Exception
	{
		String customerName = "";
		try{
			if (businessUnit.isDisplayed())
			{
				businessUnit.click();
				Select valueFromBU = new Select(businessUnit);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					valueFromBU.selectByVisibleText((TribuneUtils.getStringCellValues(sheetName, 1, 1)));
					Logger.info("business Unit is selected"); 
				}
			}
			/* if (pricingGroup.isDisplayed())
		  {
			  pricingGroup.click();
			  Select valueFromPG = new Select(pricingGroup);
		      List<WebElement> listOfValuesPG = valueFromPG.getOptions();
		      if(listOfValuesPG.size() !=0)
			      {
			    	 valueFromPG.selectByVisibleText(properties.getProperty(TribuneUtils.getStringCellValues(sheetName, 1, 2)));
			         Logger.info("pricingGroup is selected"); 
			      }
		  }*/

			if (address.isDisplayed())
			{
				address.click();
				address.clear();
				address.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 3));
				Logger.info("address is entered");
			}
			if (city.isDisplayed())
			{
				city.click();
				city.clear();
				city.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 4));
				Logger.info("city is entered");
			}
			if (state.isDisplayed())
			{
				state.click();
				Logger.info("state is clicked"); 
				Select valueFromCategory = new Select(state);
				List<WebElement> listOfValuesCategory = valueFromCategory.getOptions();
				if(listOfValuesCategory.size() !=0)
				{
					valueFromCategory.selectByVisibleText("AE");
					Logger.info("state is selected"); 
				}
			}
			if (zip.isDisplayed())
			{
				zip.click();
				zip.clear();
				zip.sendKeys(""+TribuneUtils.getIntCellValues(sheetName, 1, 6));
				Logger.info("zip is entered");
			}
			if (termsemail.isDisplayed())
			{
				termsemail.click();
				termsemail.clear();
				termsemail.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 7));
				Logger.info("terms email is entered");
			} 
			if (phone.isDisplayed())
			{
				phone.click();
				phone.clear();
				phone.sendKeys(""+TribuneUtils.getIntCellValues(sheetName, 1, 8));
				Logger.info("phone is entered");
			}
			if (category.isDisplayed())
			{
				category.click();
				Select valueFromCategory = new Select(category);
				List<WebElement> listOfValuesCategory = valueFromCategory.getOptions();
				if(listOfValuesCategory.size() !=0)
				{
					valueFromCategory.selectByVisibleText(properties.getProperty(TribuneUtils.getStringCellValues(sheetName, 1, 9)));
					Logger.info("category is selected"); 
				}
			}
			if (subCategory.isDisplayed())
			{
				subCategory.click();
				Select valueFromSubCat = new Select(subCategory);
				List<WebElement> listOfValuesSubCat = valueFromSubCat.getOptions();
				if(listOfValuesSubCat.size() !=0)
				{
					valueFromSubCat.selectByVisibleText(properties.getProperty(TribuneUtils.getStringCellValues(sheetName, 1, 10)));
					Logger.info("subCategory is selected"); 
				}
			}
			if (billingType.isDisplayed())
			{
				billingType.click();
				Select valueFromCategory = new Select(billingType);
				List<WebElement> listOfValuesCategory = valueFromCategory.getOptions();
				Logger.info("No of elements: "+listOfValuesCategory.size()); 
				if(listOfValuesCategory.size() !=0)
				{
					//Logger.info("Billing Type :" +properties.getProperty(TribuneUtils.getStringCellValues(sheetName, 1, 11)));
					valueFromCategory.selectByVisibleText(properties.getProperty("BillingType_PrivateParty"));
					Logger.info("billing Type is selected"); 
				}
			}
			if (name.isDisplayed())
			{
				name.click();
				name.clear();
				TribuneUtils utils = new TribuneUtils();
				customerName = utils.generateRandomString(15)+" Auto";
				name.sendKeys(customerName);
				Logger.info(customerName+" customer name is entered");
				return customerName;
			}
			else{
				return customerName;
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	public String enterCustomerInfoOrder(String sheetName) throws Exception
	{
		String customerName = "";
		try{
			if (businessUnit.isDisplayed())
			{
				businessUnit.click();
				Select valueFromBU = new Select(businessUnit);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					valueFromBU.selectByVisibleText(properties.getProperty(TribuneUtils.getStringCellValues(sheetName, 1, 1)));
					Logger.info("business Unit is selected"); 
				}
			}
			/* if (pricingGroup.isDisplayed())
		  {
			  pricingGroup.click();
			  Select valueFromPG = new Select(pricingGroup);
		      List<WebElement> listOfValuesPG = valueFromPG.getOptions();
		      if(listOfValuesPG.size() !=0)
			      {
			    	 valueFromPG.selectByVisibleText(properties.getProperty(TribuneUtils.getStringCellValues(sheetName, 1, 2)));
			         Logger.info("pricingGroup is selected"); 
			      }
		  }*/

			if (address.isDisplayed())
			{
				address.click();
				address.clear();
				address.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 3));
				Logger.info("address is entered");
			}
			if (city.isDisplayed())
			{
				city.click();
				city.clear();
				city.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 4));
				Logger.info("city is entered");
			}
			if (state1.isDisplayed())
			{
				state1.click();
				state1.clear();
				state1.sendKeys(""+TribuneUtils.getStringCellValues(sheetName, 1, 5));
				Logger.info("zip is entered");
			}
			if (zip.isDisplayed())
			{
				zip.click();
				zip.clear();
				zip.sendKeys(""+TribuneUtils.getIntCellValues(sheetName, 1, 6));
				Logger.info("zip is entered");
			}
			/*if (email.isDisplayed())
		  {
			  email.click();
			  email.clear();
			  email.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 7));
			  Logger.info("email is entered");
		  } */
			if (phone.isDisplayed())
			{
				phone.click();
				phone.clear();
				phone.sendKeys(""+TribuneUtils.getIntCellValues(sheetName, 1, 8));
				Logger.info("phone is entered");
			}
			if (category.isDisplayed())
			{
				category.click();
				Select valueFromCategory = new Select(category);
				List<WebElement> listOfValuesCategory = valueFromCategory.getOptions();
				if(listOfValuesCategory.size() !=0)
				{
					valueFromCategory.selectByVisibleText(properties.getProperty(TribuneUtils.getStringCellValues(sheetName, 1, 9)));
					Logger.info("category is selected"); 
				}
			}
			if (subCategory.isDisplayed())
			{
				subCategory.click();
				Select valueFromSubCat = new Select(subCategory);
				List<WebElement> listOfValuesSubCat = valueFromSubCat.getOptions();
				if(listOfValuesSubCat.size() !=0)
				{
					valueFromSubCat.selectByVisibleText(properties.getProperty(TribuneUtils.getStringCellValues(sheetName, 1, 10)));
					Logger.info("subCategory is selected"); 
				}
			}
			/* if (billingType.isDisplayed())
		  {
			  billingType.click();
			  Select valueFromCategory = new Select(billingType);
		      List<WebElement> listOfValuesCategory = valueFromCategory.getOptions();
		      Logger.info("No of elements: "+listOfValuesCategory.size()); 
		      if(listOfValuesCategory.size() !=0)
			      {
		    	  //Logger.info("Billing Type :" +properties.getProperty(TribuneUtils.getStringCellValues(sheetName, 1, 11)));
		    	  valueFromCategory.selectByVisibleText(properties.getProperty("BillingType_Commercial"));
			         Logger.info("billing Type is selected"); 
			      }
		  }*/
			if (name.isDisplayed())
			{
				name.click();
				name.clear();
				TribuneUtils utils = new TribuneUtils();
				customerName = utils.generateRandomString(15)+" Auto";
				name.sendKeys(customerName);
				Logger.info(customerName+" customer name is entered");
				return customerName;
			}
			else{
				return customerName;
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select the position from the drop down without template option
	public void selectPosition(String position) throws Exception
	{
		try{
			if(postionTemplatedTxtBx.isDisplayed()){
				postionTemplatedTxtBx.click();
				if(positionTemplatedDrpDwn.isDisplayed()){
					Select select = new Select(positionTemplatedDrpDwn);
					select.selectByVisibleText(position);
					Logger.info("Position is selected");
				}
				else{
					Logger.info("position template drop down is not displayed");
				}
			}
			else{
				Logger.info("position template text box is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select the position header
	public void selectPositionHeader(String positionHeader) throws Exception
	{
		try{
			if(positionHeaderTxtBx.isDisplayed()){
				positionHeaderTxtBx.click();
				if(positionHeaderDrpDwn.isDisplayed()){
					Select select = new Select(positionHeaderDrpDwn);
					select.selectByVisibleText(positionHeader);
					Logger.info("positionHeader is selected");
				}
				else{
					Logger.info("positionHeader drop down is not displayed");
				}
			}
			else{
				Logger.info("positionHeader text box is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to view the history of an order
	public void viewOrderHistory(int index) throws Exception
	{
		try{
			if(historyBtn.isDisplayed()){
				historyBtn.click();
				Logger.info("History button is clicked");
				//checkUncheckChangeHistoryCheckBox(true);
				//WebElement activityInfo = driver.findElement(By.xpath("//a[@id='activityInfo"+index+"']"));
				WebElement activityInfo = driver.findElement(By.xpath("//ol[@class='historydetails list-group']/li["+index+"]//span[@class='caret']"));
				activityInfo.click();
				Thread.sleep(2000);
				List<WebElement> activitiesList = driver.findElements(By.xpath("//li[@ng-repeat='change in activity.updates']"));
				ListIterator<WebElement> iterator = activitiesList.listIterator();
				if(activitiesList.size()>0){
					Logger.info("No of activities ="+activitiesList.size());
					while(iterator.hasNext()){
						String activityDetails = iterator.next().getText();
						Logger.info(activityDetails);
					}
				}
				else{
					Logger.info("No new updates are made. Only basic operation is performed.");
				}
			}
			else{
				Logger.info("history button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void verifyOrderHistory(int index , String status, String  activity) throws Exception
	{
		try{
			if(historyBtn.isDisplayed()){
				historyBtn.click();
				Logger.info("History button is clicked");
				Thread.sleep(2000);
				//checkUncheckChangeHistoryCheckBox(true);
				//WebElement activityInfo = driver.findElement(By.xpath("//a[@id='activityInfo"+index+"']"));
				WebElement activityInfo = driver.findElement(By.xpath("//ol[@class='historydetails list-group']/li["+index+"]/div[1]/span[2]"));
				String loggedActivity = activityInfo.getText();
				Logger.info("Logged activity: "+loggedActivity);
				Thread.sleep(2000);
				WebElement statusInfo = driver.findElement(By.xpath("//ol[@class='historydetails list-group']/li["+index+"]/b"));
				String loggedStatus = statusInfo.getText();
				Logger.info("Logged status: "+loggedStatus);
				Assert.assertEquals(loggedStatus.trim(), status);
				Logger.info("Logged status is as expected");
				boolean flag = false;
				if(loggedActivity.trim().contains(activity.trim()))
				{
					flag = true;
					Logger.info("Logged activity is as expected");
				}
				else
				{
					Logger.info("Logged activity is not as expected");
					Logger.info("Actual activity:"+loggedActivity.trim());
					Logger.info("Expected activity:"+activity.trim());

				}
				Assert.assertEquals(true, flag);
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnHistoryButton() throws Exception
	{

		try{
			WebDriverWait wait = new WebDriverWait(driver,500);//swagata
			wait.until(ExpectedConditions.elementToBeClickable(historyBtn));//swagata
			if(historyBtn.isDisplayed()){
				
				historyBtn.click();
				Logger.info("History button is clicked");
				Thread.sleep(2000);
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}

	}

	public String getOrderHistoryActivity(int index) throws Exception
	{
		String loggedActivity = null;
		try{
			WebElement activityInfo = driver.findElement(By.xpath("//ol[@class='historydetails list-group']/li["+index+"]/div[1]/span[2]"));
			loggedActivity = activityInfo.getText();
			Logger.info("Logged activity "+index+": "+loggedActivity);
			Thread.sleep(2000);

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return loggedActivity;
	}

	public String getOrderHistoryStatus(int index) throws Exception
	{
		String loggedStatus = null;
		try{

			WebElement statusInfo = driver.findElement(By.xpath("//ol[@class='historydetails list-group']/li["+index+"]/b"));
			loggedStatus = statusInfo.getText();
			Logger.info("Logged status "+index+": "+loggedStatus);


		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return loggedStatus;
	}

	public String getOrderHistoryUpdateDetails(int index) throws Exception
	{
		driver.findElement(By.xpath("//label[text()='Updates']")).click();
		Thread.sleep(4000);
		String loggedStatus = null;
		try{

			WebElement statusInfo = driver.findElement(By.xpath("//ol[@class='historydetails list-group']/li["+index+"]/b"));
			String  loggedStatusHeader = statusInfo.getText();
			WebElement statusdetails = driver.findElement( By.xpath("(//b[text()='ORDER_UPDATE']//following::span[@role='button'])["+index+"]"));//swagata
			statusdetails.click();//swagata
			Logger.info("Logged status Header"+index+": "+loggedStatusHeader);
			/*   if (loggedStatusHeader == "ORDER_UPDATE")
			   {
				   driver.findElement(By.xpath(".//*[@id='order-detail-page']/div[1]/div/div[2]/div[4]/ul/order-history/div/div/ol/li[1]/span[2]")).click();
				   Thread.sleep(3000);
				   loggedStatus = driver.findElement(By.xpath("//li[@ng-repeat='change in activity.updates']/span[2]")).getText();
				   Logger.info("Logged status details "+index+": "+loggedStatus);
			   }
			 */

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return loggedStatus;
	}
	/**
	 * @description this test method selects the required ad size for a particular insertion
	 * @param adSize
	 */
	public void selectAdSize(int insertionNumber, String adSize) throws Exception
	{
		try{
			WebElement adSizeTxtBox = driver.findElement(By.xpath("(//label[contains(text(),'Ad Size')]/../div/a/span[@id='Span1']/span)["+insertionNumber+"]"));
			adSizeTxtBox.click();
			Thread.sleep(2000);
			//Select select = new Select(adSizeDrpDwn);
			adSizeDrpDwn.click();
			Thread.sleep(4000);
			String optioxpath="//label[contains(text(),'Ad Size')]/../div/form/div/select/option[contains(text(),'"+adSize+"')]";
			//select.selectByVisibleText(adSize);
			driver.findElement(By.xpath(optioxpath)).click();
			Thread.sleep(1000);
			Logger.info(adSize+" adSize is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectAdSizeByValue(int insertionNumber, String value) throws Exception
	{
		try{
			WebElement adSizeTxtBox = driver.findElement(By.xpath("(//label[contains(text(),'Ad Size')]/../div/a/span[@id='Span1']/span)["+insertionNumber+"]"));
			adSizeTxtBox.click();
			Thread.sleep(3000);
			Select select = new Select(adSizeDrpDwn);
			select.selectByValue(value);
			Logger.info(" adSize is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectAdSizeByIndex(int insertionNumber, int index) throws Exception
	{
		try{
			WebElement adSizeTxtBox = driver.findElement(By.xpath("(//label[contains(text(),'Ad Size')]/../div/a/span[@id='Span1']/span)["+insertionNumber+"]"));
			adSizeTxtBox.click();
			Select select = new Select(adSizeDrpDwn);
			select.selectByIndex(index);
			Logger.info(" adSize is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	public void selectAdSizeByIndexOnline(int insertionNumber, int index) throws Exception
	{
		try{
			WebElement adSizeTxtBox = driver.findElement(By.xpath("(//label[contains(text(),'Adsize')]/../div/a/span/span)["+insertionNumber+"]"));
			adSizeTxtBox.click();
			WebElement adSizeDrpDwn1 = driver.findElement(By.xpath("(//label[contains(text(),'Adsize')]/../div/form/div/select)"));
			Select select = new Select(adSizeDrpDwn1);
			select.selectByIndex(index);
			Logger.info(" adSize is selected");

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public String getAdSize(int insertionNumber) throws Exception
	{
		try{
			WebElement adSizeTxtBox = driver.findElement(By.xpath("(//label[contains(text(),'Ad Size')]/../div/a/span[@id='Span1']/span)["+insertionNumber+"]"));

			String selectedValue = adSizeTxtBox.getText();
			Logger.info(selectedValue+" adSize is selected");
			return selectedValue;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	//Code to check or uncheck own local opt out checkbox
	public void checkUncheckOwnLocalOptOut(boolean value) throws Exception
	{
		try{
			WebElement element = driver.findElement(By.xpath("//input[@ng-model='vm.order.DisableAutoInsertion']"));
			String checkCriteria = element.getAttribute("class");
			if(value)
			{
				if(checkCriteria.equalsIgnoreCase("ng-valid ng-dirty ng-valid-parse ng-touched ng-not-empty")){
					Logger.info("Own Local opt out is checked");
				}
				else {
					ownLocalOptOutCheckBox.click();
					Logger.info("Own Local opt out is checked");
				}
			}
			else{
				if(checkCriteria.equalsIgnoreCase("ng-valid ng-dirty ng-valid-parse ng-touched ng-not-empty")){
					ownLocalOptOutCheckBox.click();
					Logger.info("Own Local opt out is unchecked");
				}
				else {
					Logger.info("Own Local opt out is unchecked");
				}
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select business unit for zone selection
	public void selectBUZones(int row, int col) throws Exception
	{
		try
		{
			String value = TribuneUtils.getStringCellValues("Product",row, col);
			Select selectBU = new Select(multiInsertionBu);
			List<WebElement> listOfValuesBU = selectBU.getOptions();
			if(listOfValuesBU.size() !=0)
			{
				selectBU.selectByVisibleText(properties.getProperty(value));
				Logger.info(value+" business Unit is selected"); 
			}
			else{
				Logger.info("drop down is empty");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to enter pub date for multi insertion with zone creation
	public void enterPubDateZones(String date, String month, String year) throws Exception
	{

		multiInsertionPubDate.click();
		WebElement curentMonthElement = driver.findElement(By.xpath("(//th[@class='picker-switch'])[1]"));
		String currentMonthYear = curentMonthElement.getText();
		Logger.info("current month year from calendar "+currentMonthYear);
		String expectedDate = properties.get(month).toString() + " " + year;
		Logger.info("expected month year from user " +expectedDate);
		if(currentMonthYear.equalsIgnoreCase(expectedDate))
		{
			WebElement dateElement = driver.findElement(By.xpath("//td[@class='day'][text()='"+date+"']"));
			dateElement.click();
			Logger.info(date+"/"+month+"/"+year +" is entered");
		}
		else
		{
			int length = currentMonthYear.length();
			String currentyear = currentMonthYear.substring(length-4, length);
			if(currentyear.equalsIgnoreCase(year))
			{
				curentMonthElement.click();
				WebElement expectedMonthElement = driver.findElement(By.xpath("//td/span[text()='"+month+"']"));
				expectedMonthElement.click();
				WebElement dateElement = driver.findElement(By.xpath("//td[@class='day'][text()='"+date+"']"));
				dateElement.click();
				Logger.info(date+"/"+month+"/"+year +" is entered");
			}
			else
			{
				curentMonthElement.click();
				WebElement yearElement = driver.findElement(By.xpath("//div[@class='datepicker-months']/table/thead/tr/th[@class='picker-switch']"));
				yearElement.click();
				WebElement expectedYearElement = driver.findElement(By.xpath("//td/span[@class='year'][text()='"+year+"']"));
				if(expectedYearElement.isDisplayed())
				{
					expectedYearElement.click();
					WebElement expectedMonthElement = driver.findElement(By.xpath("//td/span[text()='"+month+"']"));
					expectedMonthElement.click();
					WebElement dateElement = driver.findElement(By.xpath("//td[@class='day'][text()='"+date+"']"));
					dateElement.click();
					Logger.info(date+"/"+month+"/"+year +" is entered");
				}
				else
				{
					WebElement next = driver.findElement(By.xpath("//th[@class='next']"));
					next.click();
					driver.findElement(By.xpath("//td/span[text()='"+year+"']")).click();
					driver.findElement(By.xpath("//td/span[text()='"+month+"']")).click();
					driver.findElement(By.xpath("//td[@class='day'][text()='"+date+"']")).click();
					Logger.info(date+"/"+month+"/"+year +" is entered");
				}
			}
		}
	}

	//code to select product type for zone selection
	public void selectProductTypeZones(int row, int col) throws Exception
	{
		try
		{
			String value = TribuneUtils.getStringCellValues("Product",row, col);
			Select selectProductType = new Select(multiInsertionProductType);
			List<WebElement> listOfProductType = selectProductType.getOptions();
			if(listOfProductType.size() !=0)
			{
				selectProductType.selectByVisibleText(value);
				Logger.info(value+" product type is selected"); 
			}
			else{
				Logger.info("drop down is empty");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select product for zone selection
	public void selectProductZones(int row, int col) throws Exception
	{
		try
		{
			String value = TribuneUtils.getStringCellValues("Product",row, col);
			Select selectProduct = new Select(multiInsertionProduct);
			List<WebElement> listOfProduct = selectProduct.getOptions();
			if(listOfProduct.size() !=0)
			{
				selectProduct.selectByVisibleText(value);
				Logger.info(value+" product is selected"); 
			}
			else{
				Logger.info("drop down is empty");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select the section for zone selection
	public void selectSectionZones(int row, int col) throws Exception
	{
		try
		{
			String value = TribuneUtils.getStringCellValues("Product",row, col);
			Select selectSection = new Select(multiInsertionSection);
			List<WebElement> listOfSection = selectSection.getOptions();
			if(listOfSection.size() !=0)
			{
				selectSection.selectByVisibleText(value);
				Logger.info(value+" section is selected"); 
			}
			else{
				Logger.info("drop down is empty");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	// code to select the ad type for zone selection
	public void selectAdTypeZones(int row, int col) throws Exception
	{
		try
		{
			String value = TribuneUtils.getStringCellValues("Product",row, col);
			Select selectAdType = new Select(multiInsertionAdType);
			List<WebElement> listOfAdType = selectAdType.getOptions();
			if(listOfAdType.size() !=0)
			{
				selectAdType.selectByVisibleText(value);
				Logger.info(value+" ad type is selected"); 
			}
			else{
				Logger.info("drop down is empty");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select the zone for multi insertion with zone
	public void selectZoneMultiInsrtn(String zone) throws Exception
	{
		try{
			WebElement zoneCheckBox = driver.findElement(By.xpath("//label[text()='"+zone+"']/../label/i"));
			zoneCheckBox.click();
			Logger.info(zone+" zone is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to save the zones selected for creating a multi insertion with zones
	public void saveZoneSelectionMultiInsrtn() throws Exception
	{
		try{
			if(saveZoneSelectionBtn.isDisplayed()){
				saveZoneSelectionBtn.click();
				Logger.info("Zones are saved");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to enter sales tax
	public void enterSalesTax(String insertionIndex, String salesTaxAmount) throws Exception
	{
		try{
			WebElement salesTaxElement  = driver.findElement(By.xpath("(//label[text()='Sales Tax']/../div/input)["+insertionIndex+"]"));
			if(salesTaxElement.isDisplayed()){
				salesTaxElement.click();
				salesTaxElement.clear();
				salesTaxElement.sendKeys(salesTaxAmount);
				Logger.info("sales Tax is entered");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to enter the agency commission 
	public void enterAgencyCommission(String insertionIndex, String agencyComm) throws Exception
	{
		try{
			WebElement agencyCommElement  = driver.findElement(By.xpath("(//label[text()='Agency Comm']/../div/input[2])["+insertionIndex+"]"));
			if(agencyCommElement.isDisplayed()){
				agencyCommElement.click();
				agencyCommElement.clear();
				agencyCommElement.sendKeys(agencyComm);
				Logger.info("Agency Commission is entered");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to get the agency commission that is calculated by the system and displayed in dollars
	public Double getAgencyComm(String insertionIndex) throws Exception
	{
		Double agencyComm = 0.0;
		try{
			WebElement agencyCommElement  = driver.findElement(By.xpath("(//label[text()='Agency Comm']/../div/input[1])["+insertionIndex+"]"));
			if(agencyCommElement.isDisplayed()){

				String agencyCommssion = agencyCommElement.getAttribute("value");
				agencyComm = Double.parseDouble(agencyCommssion.substring(1, agencyCommssion.length()));
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
		return agencyComm;
	}

	/**
	 * @description This method selects given promotion/program for the specified insertion
	 * @param insertionNumbe
	 * @param programName
	 */
	public void selectProgramPrice(int insertionIndex, String programName) throws Exception
	{
		try{
			WebElement programPrice = driver.findElement(By.xpath("(//label[contains(text(),'Program Price')]/../div/a/span[@id='Span8']/span)["+insertionIndex+"]"));
			if(programPrice.isDisplayed()){
				programPrice.click();
				WebElement programDrpDwn = driver.findElement(By.xpath("//label[contains(text(),'Program Price')]/../div/form/div/select"));
				Select select = new Select(programDrpDwn);
				select.selectByVisibleText(programName);
				Logger.info(programName+" program is selected");
			}
		} 
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @description This methods validates the visibility of promotion
	 * @param insertionIndex
	 * @param programName
	 */
	public boolean validatePromotionVisibility(int insertionIndex, String programName) throws Exception
	{
		try{
			WebElement programPrice = driver.findElement(By.xpath("(//label[contains(text(),'Program Price')]/../div/a/span[@id='Span8']/span)["+insertionIndex+"]"));
			programPrice.click();
			WebElement programDrpDwn = driver.findElement(By.xpath("//label[contains(text(),'Program Price')]/../div/form/div/select"));
			Select select = new Select(programDrpDwn);
			List<WebElement> list = select.getOptions();
			boolean flag;
			if(list.contains(programName))
			{
				flag = true;
			}
			else {
				flag = false;
			}
			return flag;
		} 
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Validate duplicate insertion made
	public void validateDuplicateInsertion(String originalInsertionIndex) throws Exception
	{
		try
		{
			String elementPath = "/div//span"; 
			int countOfInsertion = getInsertionsCount();


			WebElement originalElement = driver.findElement(By.xpath("//tbody["+originalInsertionIndex+"]/tr[1]/td[4]"+elementPath));
			String originalElementName = originalElement.getText();
			String duplicateInsertionIndex = "" +countOfInsertion;
			WebElement duplicateElement = driver.findElement(By.xpath("//tbody["+duplicateInsertionIndex+"]/tr[1]/td[4]"+elementPath));
			String duplicateElementName = duplicateElement.getText();
			Logger.info("Element values validation success "+duplicateElementName);
			boolean flag = false;
			if(originalElementName.equalsIgnoreCase(duplicateElementName))
			{
				flag = true;
				Logger.info("Element values validation success for column 4");
			}
			Assert.assertEquals(true, flag);


		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	//Code to get the number of versions available for an single insertion
	public int getVersionsInInsertion(String insertionIndex) throws Exception
	{
		String insertionsPath = "//tr[@class='overview']/td//div[@class='pointer']/../div[2]";
		int countOfVersions = 0;
		try
		{
			List<WebElement> insertionElement = driver.findElements(By.xpath(insertionsPath));
			Iterator<WebElement> iterator = insertionElement.iterator();
			while(iterator.hasNext())
			{
				WebElement element = iterator.next();
				String insertion = element.getText();
				int index = insertion.indexOf("-");
				String actualInsertionValue = insertion.substring(0,index);
				if(actualInsertionValue.contentEquals(insertionIndex))
				{
					String insertionVersion = insertion.substring(index+1, insertion.length());
					Logger.info("insertionVersion "+insertionVersion);
					countOfVersions = countOfVersions+1;
				}
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return countOfVersions;
	}

	//This method return the insertion number(excluding the version number) for the requested order line
	public int getInsertionNumber(int insertionIndex) throws Exception
	{
		try
		{
			WebElement element = driver.findElement(By.xpath("(//tr[@class='overview']/td//div[@class='pointer']/../div[2])["+insertionIndex+"]"));
			String insertion = element.getText();
			int index = insertion.indexOf("-");
			String actualInsertionNumber = insertion.substring(0,index);
			return Integer.parseInt(actualInsertionNumber);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//Validate the kill insertion operation
	public String getInsertionStatus(String insertionIndex) throws Exception
	{
		String insertionStatus = "";
		try
		{
			String statusPath = "/tr[1]/td[17]"; 
			WebElement status = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+statusPath));
			insertionStatus = status.getText();
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return insertionStatus;
	}

	//code to get the error message displayed
	public void displayErrorMessage() throws Exception {
		try {

			WebElement errorMessageCollapsed = driver.findElement(By.xpath("//div[@class='alert alert-danger notification-accordian ng-scope']/i[@class='pull-right glyphicon glyphicon-chevron-down']"));
			if (errorMessageCollapsed.isDisplayed())
			{
				Logger.info("errorMsgDisplayed is in collapsible format as expected");
			}

			else
			{
				Logger.info("errorMsgDisplayed is not in collapsible format");
			}

			if (errorMessage.size() > 0) {
				ListIterator<WebElement> iterator = errorMessage.listIterator();
				while (iterator.hasNext()) {
					WebElement errMsg = iterator.next();
					String errorMsgDisplayed = errMsg.getText();
					Logger.info("errorMsgDisplayed is " + errorMsgDisplayed);
				}
			}


		} catch (Exception e) {
			Logger.info("no error message is displayed");
		}
	}
	public void displayCompareErrorMessagePopUp(String expectedErr) throws Exception
	{
		WebElement errorMessage1 = driver.findElement(By.xpath(".//*[@id='toast-container']/div/div[3]/div"));
		try{
			if(errorMessage1.isDisplayed()){
				String errorMsgDisplayed = errorMessage1.getText();
				Logger.info("errorMsgDisplayed is "+errorMsgDisplayed);
				Assert.assertEquals(expectedErr, errorMsgDisplayed);
				WebDriverWait wait= new WebDriverWait(driver, 200);//swagata
				OrderEntryHomePage OrderEntryHomePageInstance = PageFactory.initElements(driver, OrderEntryHomePage.class);//swagata
				OrderEntryHomePageInstance.closeOrderSuccessSubmissionMessage();//swagata
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='toast-container']/div/div[3]/div")));//swagata
			}

		}
		catch(Exception e)
		{
			Logger.info("no error message is displayed");
		}
	}

	public void compareErrorMessagePopUp(String expectedErr) throws Exception
	{
		WebElement errorMessage1 = driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[2]/div/div/div/p"));
		try{
			if(errorMessage1.isDisplayed()){
				String errorMsgDisplayed = errorMessage1.getText();
				Logger.info("errorMsgDisplayed is "+errorMsgDisplayed);
				Assert.assertEquals(expectedErr, errorMsgDisplayed);
				Logger.info("Correct error displayed ");
			}


		}
		catch(Exception e)
		{
			Logger.info("no error message is displayed");
		}
	}
	public void verifyOopsrMessagePopUp(String expectedErr) throws Exception
	{

		WebElement errorMessage1 = driver.findElement(By.xpath("//*[@id='toast-container']/div/div[3]/div"));
		Thread.sleep(6000);//swagata
		try{
			if(errorMessage1.isEnabled()){
				Thread.sleep(6000);//swagata
				String errorMsgDisplayed = errorMessage1.getText();
				Logger.info("oopsMsgDisplayed is "+errorMsgDisplayed);
				Assert.assertEquals(expectedErr, errorMsgDisplayed);
			}

		}
		catch(Exception e)
		{
			Logger.info("no oopsMsgDisplayed");
		}
	}

	public void getOopsMessagePopUpError() throws Exception
	{
		WebElement errorMessage1 = driver.findElement(By.xpath(".//*[@id='toast-container']/div/div[3]/div"));
		try{
			if(errorMessage1.isDisplayed()){
				String errorMsgDisplayed = errorMessage1.getText();
				Logger.info("oopsMsgDisplayed is "+errorMsgDisplayed);

			}

		}
		catch(Exception e)
		{
			Logger.info("no oopsMsgDisplayed");
		}
	}

	public void displayErrorMessageMultiple(int index) throws Exception
	{

		WebElement errorMessage = driver.findElement(By.xpath("//section[@class='panel-body accordion-body ng-scope']/p["+index+"]/strong"));
		try{
			if(errorMessage.isDisplayed()){

				String errorMsgDisplayed = errorMessage.getText();
				Logger.info(index+" errorMsgDisplayed is "+errorMsgDisplayed);
			}		  
		}
		catch(Exception e)
		{
			Logger.info("no error message is displayed");
		}
	}

	public void displayWarningMessageConfirm() throws Exception
	{
		Thread.sleep(5000);

		WebElement errorMessage = driver.findElement(By.xpath("//html/body/div[1]/div/div/div[2]/div"));
		//WebElement errorMessage = driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div"));
		try{
			if(errorMessage.isDisplayed()){

				String errorMsgDisplayed = errorMessage.getText();
				Logger.info(" warningMsgDisplayed is "+errorMsgDisplayed);
				//  Assert.assertEquals("Ad Size, Material Source, Color, Pickup#, Version, Preprint Type, Page Count, Page Type or Ad Type has changed without reassigning Material Id for 01-00", errorMsgDisplayed);
				WebElement confirmButton = driver.findElement(By.xpath("//html/body/div[1]/div/div/div[3]/button[1]"));
				//WebElement confirmButton = driver.findElement(By.xpath("//button[contains(text(),'Yes')]"));
				confirmButton.click();
				Logger.info(" warning popup message"+errorMsgDisplayed);
			}		  
		}
		catch(Exception e)
		{
			Logger.info("no error message is displayed");
		}
	}

	public void displayWarningMessageVerifyConfirm(String message) throws Exception
	{

		WebElement errorMessage = driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div"));

		try{
			if(errorMessage.isDisplayed()){

				String errorMsgDisplayed = errorMessage.getText();
				Logger.info(" warningMsgDisplayed is "+errorMsgDisplayed);
				Logger.info(" warningMsgDisplayed expceted is "+message);//payel
				//Assert.assertEquals(message, errorMsgDisplayed);
				if(errorMsgDisplayed.equals(message)){
					System.out.println("Compare pass");
				}
				else {
					System.out.println("Compare Fail");
				}

				WebElement confirmButton = driver.findElement(By.xpath("//div/div[3]/button[contains(text(), 'Continue')]"));//payel
				//WebElement confirmButton = driver.findElement(By.xpath("html/body/div[1]/div/div/div[3]/button[1]"));//payel
				confirmButton.click();
				if(driver.getPageSource().contains("Your order contains one or more insertions that match auto insertion rules."))
				{

					Logger.info("Confirmation window is displayed requesting the user to either accept or reject the creation of legacy auto insertion");
					rejectLegacyAutoInsertion.click();
					String  text = displayMsg.getAttribute("value");
					Logger.info("Message is displayed in the pop up: " + text);
					Logger.info("'No' is clicked in confirmation window");
					Logger.info("Order is submitted successfully");

				}//swagata
				else {
					Logger.info("Order is submitted successfully");
				}//swagata

			}		  
		}
		catch(Exception e)
		{
			Logger.info("no error message is displayed");
		}
	}	  

	//code to enter the zip codes for a preprint order in an insertion order
	public void enterZipCodes(String insertionIndex, String zip) throws Exception
	{
		try{
			WebElement element = driver.findElement(By.xpath("(//label[text()='Zip Codes']/../div/a/span[@id = 'Span22']/span)["+insertionIndex+"]"));
			element.click();
			zipCodeTextArea.sendKeys(zip);
			Logger.info(zip+" zip code entered");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to click on the distributions button for the given insertion
	public void clickOnDistributions(int insertionNumber) throws Exception
	{
		try{
			WebElement  preprintDistributionSearchBtn = driver.findElement(By.xpath("(//label[text()='Distributions']/../div/span[@class='input-group-addon pointer']/i)["+insertionNumber+"]"));
			if(preprintDistributionSearchBtn.isDisplayed()){
				preprintDistributionSearchBtn.click();
				Thread.sleep(2000);
				Logger.info("distributions button is clicked");
				//Thread.sleep(40000);//swagata
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)						
						.withTimeout(200, TimeUnit.SECONDS) 			
						.pollingEvery(2, TimeUnit.SECONDS) 			
						.ignoring(NoSuchElementException.class);//swagata	
				WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){

					public WebElement apply(WebDriver driver ) {
						return 	driver.findElement(By.xpath("(//div[@class='panel-heading'][.//strong[text()='Available Zones']]//following-sibling::div[@class='panel-body']//div[@class='ui-grid-canvas'])[2]//div[text()='Full' or text()='SubZip']"));//swagata

					}
				});//swagata	
				System.out.println("distribution is loaded:"+clickseleniumlink.isDisplayed());//swagata
			}
			else{
				Logger.info("distributions button is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectVersionInDistribution(String version) throws Exception
	{
		try{
			WebElement  preprintDistributionVersionDrpdwn = driver.findElement(By.xpath("//*[@id='Select4']"));
			if(preprintDistributionVersionDrpdwn.isDisplayed()){
				Select selectVersion = new Select(preprintDistributionVersionDrpdwn);
				selectVersion.selectByVisibleText(version);
				Logger.info(version +" version is selected");
			}
			else{
				Logger.info("distributions button is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnMatchZip() throws Exception
	{
		try{
			WebElement  preprintDistributionSearchBtn = driver.findElement(By.xpath("//label[text()='Match Zip']"));
			if(preprintDistributionSearchBtn.isDisplayed()){
				preprintDistributionSearchBtn.click();
				Thread.sleep(2000);
				Logger.info("Match Zip button is clicked");
			}
			else{
				Logger.info("Match Zip button is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterAndIncludeZip(String Zip) throws Exception
	{
		try{
			WebElement  preprintDistributionSearchBtn = driver.findElement(By.xpath("//*[@id='collapse2']/div/div/div[1]/div[2]/textarea"));
			preprintDistributionSearchBtn.sendKeys(Zip);
			WebElement  includeBtn = driver.findElement(By.xpath("//button[text()='Include']"));
			if(includeBtn.isDisplayed()){
				includeBtn.click();
				Thread.sleep(2000);
				Logger.info("Include button is clicked");
			}
			else{
				Logger.info("Include button is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectVersionDistribution(String value) throws Exception
	{
		try{
			WebElement version = driver.findElement(By.xpath("//select[@id='Select4']"));			 
			Select select = new Select (version);
			select.selectByVisibleText(value);
			Logger.info(" version selected: "+value);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void verifyZipVersionSelected(String zip, String version) throws Exception
	{
		try{
			WebElement zipVersion = driver.findElement(By.xpath("(//div[text()='"+zip+"'])[1]/../../div[3]/div"));
			String versionID = zipVersion.getText();
			Logger.info("Version found for zip "+zip+" is "+versionID);
			Assert.assertEquals(version, versionID);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to click on the serac/browse zone in teh distributions window
	public void clickOnSearchZoneLink() throws Exception
	{
		try{
			if(distributionZoneSearchWindowLink.isDisplayed())
			{
				//WebElement selectionStatus = driver.findElement(By.xpath(""));
				String selectionStatus = distributionZoneSearchWindowLink.getAttribute("aria-expanded"); 
				if(selectionStatus.equalsIgnoreCase("true")){
					Logger.info("Search browse zone window is open");
				}
				else{
					distributionZoneSearchWindowLink.click();
					Logger.info("Search browse zone window is selected");
				}
			}
			else{
				Logger.info("serach/browse link is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to get the total items displayed on the distributions list
	public int getTotalDistributionOnList() throws Exception
	{
		String value = "";
		try{
			if(totalDistributionsDisplayed.isDisplayed()){
				value = totalDistributionsDisplayed.getText();
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return Integer.parseInt(value.substring(7));
	}

	public void clickOnEnterTextLink() throws Exception
	{
		try{
			if(distributionZoneEnterTextLink.isDisplayed())
			{
				//WebElement selectionStatus = driver.findElement(By.xpath(""));
				String selectionStatus = distributionZoneEnterTextLink.getAttribute("aria-expanded"); 
				if(selectionStatus.equalsIgnoreCase("true")){
					Logger.info("Enter Text window is open");
				}
				else{
					distributionZoneEnterTextLink.click();
					Logger.info("Enter Text window is selected");
				}
			}
			else{
				Logger.info("Enter Text link is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select the zone from search/browse of the distributions window for a preprint order
	public void selectZonePreprintOrder(String zone) throws Exception
	{
		try{
			/* if(searchDrawPreprintDistributions.isDisplayed())
		  {
			  searchDrawPreprintDistributions.click();
			  searchDrawPreprintDistributions.clear();
			  searchDrawPreprintDistributions.sendKeys(zone);
			  Logger.info("zone is entered");
			  Thread.sleep(2000);
		  }*/

			WebElement typeFilter = driver.findElement(By.xpath("//span[text()='Type']/../../div[3]/div/custom-multiselect/div/div/div/button"));
			typeFilter.click();
			WebElement typeFilterFull = driver.findElement(By.xpath("//span[text()='"+zone+"']"));
			typeFilterFull.click();
			typeFilter.click();
			WebElement zoneInclude = driver.findElement(By.xpath("(//*[text()='"+zone+"'])[2]"));
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(zoneInclude));
			zoneInclude.click();
			WebElement selectZone = driver.findElement(By.xpath("//span[@class = 'fa fa-forward']"));
			selectZone.click();
			Logger.info("Zone "+zone+" is included");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	//code to select the zone from search/browse of the distributions window for a preprint order
	public void selectZonePreprintOrder1(String zone) throws Exception
	{
		try{
			/* if(searchDrawPreprintDistributions.isDisplayed())
		  {
			  searchDrawPreprintDistributions.click();
			  searchDrawPreprintDistributions.clear();
			  searchDrawPreprintDistributions.sendKeys(zone);
			  Logger.info("zone is entered");
			  Thread.sleep(2000);
		  }*/

			WebElement typeFilter = driver.findElement(By.xpath("//span[text()='Type']/../../div[3]/div/custom-multiselect/div/div/div/button"));
			typeFilter.click();
			WebElement typeFilterFull = driver.findElement(By.xpath("//span[text()='"+zone+"']"));
			typeFilterFull.click();
			typeFilter.click();
			WebElement zoneInclude = driver.findElement(By.xpath("(//*[text()='"+zone+"'])[1]"));
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(zoneInclude));
			zoneInclude.click();
			WebElement selectZone = driver.findElement(By.xpath("//span[@class = 'fa fa-forward']"));
			selectZone.click();
			Logger.info("Zone "+zone+" is included");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectAllZonePreprintOrder() throws Exception
	{
		try{
			/* if(searchDrawPreprintDistributions.isDisplayed())
		  {
			  searchDrawPreprintDistributions.click();
			  searchDrawPreprintDistributions.clear();
			  searchDrawPreprintDistributions.sendKeys(zone);
			  Logger.info("zone is entered");
			  Thread.sleep(2000);
		  }*/

			WebElement selectAll = driver.findElement(By.xpath("//*[@id='distributionDropdown']/div[2]/div[2]/div/button[1]"));
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(selectAll));
			selectAll.click();		  
			WebElement selectZone = driver.findElement(By.xpath("//span[@class = 'fa fa-forward']"));
			selectZone.click();
			Logger.info("All Zones are included");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void verifyUnavailableZonesSection() throws Exception
	{
		try{

			WebElement sectionText = driver.findElement(By.xpath("//*[text()='Unavailable Zones']"));

			if(sectionText.isDisplayed())
			{

				Logger.info(" Unavailable zones section is displayed"); 
				WebElement zoneHeader = driver.findElement(By.xpath("//*[@id='collapse1']/div/div//*[text()='Zone']"));
				Assert.assertEquals(true, zoneHeader.isDisplayed());
				WebElement typeHeader = driver.findElement(By.xpath("//*[@id='collapse1']/div/div//*[text()='Type']"));
				Assert.assertEquals(true, typeHeader.isDisplayed());
				WebElement groupHeader = driver.findElement(By.xpath("//*[@id='collapse1']/div/div//*[text()='Group']"));
				Assert.assertEquals(true, groupHeader.isDisplayed());
				WebElement orderIdHeader = driver.findElement(By.xpath("//*[@id='collapse1']/div/div//*[text()='Order Id']"));
				Assert.assertEquals(true, orderIdHeader.isDisplayed());
				WebElement lineNoHeader = driver.findElement(By.xpath("//*[@id='collapse1']/div/div//*[text()='Line Number']"));
				Assert.assertEquals(true, lineNoHeader.isDisplayed());
				WebElement csrHeader = driver.findElement(By.xpath("//*[@id='collapse1']/div/div//*[text()='CSR']"));
				Assert.assertEquals(true, csrHeader.isDisplayed());
				Logger.info(" All headers present as expected"); 

				try{

					WebElement zoneSorter = driver.findElement(By.xpath("(//span[text()='Zone']/../..//i[@class='ui-grid-icon-angle-down'])[2]"));
					zoneSorter.click();
					WebElement zoneSorterAsc = driver.findElement(By.xpath("//*[@id='menuitem-0']/button"));
					zoneSorterAsc.click();
					WebElement verifyAscZoneSortIcon = driver.findElement(By.xpath("(//span[text()='Zone']/../..//i[@class='ui-grid-icon-up-dir'])[2]"));
					if (verifyAscZoneSortIcon.isDisplayed())
					{
						Logger.info(" Zone sorted in ascending order "); 
					}
					else
					{
						Logger.info(" Zone not sorted in ascending order ");
					}
					zoneSorter.click();
					WebElement zoneSorterDesc = driver.findElement(By.xpath("//*[@id='menuitem-1']/button"));
					zoneSorterDesc.click();
					WebElement verifyDescZoneSortIcon = driver.findElement(By.xpath("//span[text()='Zone']/../..//i[@class='ui-grid-icon-down-dir']"));
					if (verifyDescZoneSortIcon.isDisplayed())
					{
						Logger.info(" Zone sorted in descending order "); 
					}
					else
					{
						Logger.info(" Zone not sorted in descending order ");
					}

					zoneSorter.click();
					WebElement zoneSorterRemove = driver.findElement(By.xpath("//*[@id='menuitem-2']/button"));
					zoneSorterRemove.click();
					Logger.info(" Zone sort removed"); 	  

				}
				catch(Exception e)
				{
					Logger.error(e.getMessage());
					throw e;
				}
				Thread.sleep(10000);
				try{

					WebElement zoneSorter = driver.findElement(By.xpath("(//span[text()='Type']/../..//i[@class='ui-grid-icon-angle-down'])[2]"));
					zoneSorter.click();
					WebElement zoneSorterAsc = driver.findElement(By.xpath("//*[@id='menuitem-0']/button"));
					zoneSorterAsc.click();
					WebElement verifyAscZoneSortIcon = driver.findElement(By.xpath("(//span[text()='Type']/../..//i[@class='ui-grid-icon-up-dir'])"));
					if (verifyAscZoneSortIcon.isDisplayed())
					{
						Logger.info(" Type sorted in ascending order "); 
					}
					else
					{
						Logger.info(" Type not sorted in ascending order ");
					}
					zoneSorter.click();
					WebElement zoneSorterDesc = driver.findElement(By.xpath("//*[@id='menuitem-1']/button"));
					zoneSorterDesc.click();
					WebElement verifyDescZoneSortIcon = driver.findElement(By.xpath("//span[text()='Type']/../..//i[@class='ui-grid-icon-down-dir']"));
					if (verifyDescZoneSortIcon.isDisplayed())
					{
						Logger.info(" Type sorted in descending order "); 
					}
					else
					{
						Logger.info(" Type not sorted in descending order ");
					}

					zoneSorter.click();
					WebElement zoneSorterRemove = driver.findElement(By.xpath("//*[@id='menuitem-2']/button"));
					zoneSorterRemove.click();
					Logger.info(" Type sort removed"); 	  

				}
				catch(Exception e)
				{
					Logger.error(e.getMessage());
					throw e;
				}
				Thread.sleep(10000);
				try{

					WebElement zoneSorter = driver.findElement(By.xpath("(//span[text()='Group']/../..//i[@class='ui-grid-icon-angle-down'])[2]"));
					zoneSorter.click();
					WebElement zoneSorterAsc = driver.findElement(By.xpath("//*[@id='menuitem-0']/button"));
					zoneSorterAsc.click();
					WebElement verifyAscZoneSortIcon = driver.findElement(By.xpath("(//span[text()='Group']/../..//i[@class='ui-grid-icon-up-dir'])"));
					if (verifyAscZoneSortIcon.isDisplayed())
					{
						Logger.info(" Group sorted in ascending order "); 
					}
					else
					{
						Logger.info(" Group not sorted in ascending order ");
					}
					zoneSorter.click();
					WebElement zoneSorterDesc = driver.findElement(By.xpath("//*[@id='menuitem-1']/button"));
					zoneSorterDesc.click();
					WebElement verifyDescZoneSortIcon = driver.findElement(By.xpath("//span[text()='Group']/../..//i[@class='ui-grid-icon-down-dir']"));
					if (verifyDescZoneSortIcon.isDisplayed())
					{
						Logger.info(" Group sorted in descending order "); 
					}
					else
					{
						Logger.info(" Group not sorted in descending order ");
					}

					zoneSorter.click();
					WebElement zoneSorterRemove = driver.findElement(By.xpath("//*[@id='menuitem-2']/button"));
					zoneSorterRemove.click();
					Logger.info(" Group sort removed"); 	  

				}
				catch(Exception e)
				{
					Logger.error(e.getMessage());
					throw e;
				}
				Thread.sleep(10000);
				try{

					WebElement zoneSorter = driver.findElement(By.xpath("(//span[text()='Order Id']/../..//i[@class='ui-grid-icon-angle-down'])"));
					zoneSorter.click();
					WebElement zoneSorterAsc = driver.findElement(By.xpath("//*[@id='menuitem-0']/button"));
					zoneSorterAsc.click();
					WebElement verifyAscZoneSortIcon = driver.findElement(By.xpath("(//span[text()='Order Id']/../..//i[@class='ui-grid-icon-up-dir'])"));
					if (verifyAscZoneSortIcon.isDisplayed())
					{
						Logger.info(" Order Id sorted in ascending order "); 
					}
					else
					{
						Logger.info(" Order Id not sorted in ascending order ");
					}
					zoneSorter.click();
					WebElement zoneSorterDesc = driver.findElement(By.xpath("//*[@id='menuitem-1']/button"));
					zoneSorterDesc.click();
					WebElement verifyDescZoneSortIcon = driver.findElement(By.xpath("//span[text()='Order Id']/../..//i[@class='ui-grid-icon-down-dir']"));
					if (verifyDescZoneSortIcon.isDisplayed())
					{
						Logger.info(" Order Id sorted in descending order "); 
					}
					else
					{
						Logger.info(" Order Id not sorted in descending order ");
					}

					zoneSorter.click();
					WebElement zoneSorterRemove = driver.findElement(By.xpath("//*[@id='menuitem-2']/button"));
					zoneSorterRemove.click();
					Logger.info(" Order Id sort removed"); 	  

				}
				catch(Exception e)
				{
					Logger.error(e.getMessage());
					throw e;
				}
				Thread.sleep(10000);
				try{

					WebElement zoneSorter = driver.findElement(By.xpath("(//span[text()='Line Number']/../..//i[@class='ui-grid-icon-angle-down'])"));
					zoneSorter.click();
					WebElement zoneSorterAsc = driver.findElement(By.xpath("//*[@id='menuitem-0']/button"));
					zoneSorterAsc.click();
					WebElement verifyAscZoneSortIcon = driver.findElement(By.xpath("(//span[text()='Line Number']/../..//i[@class='ui-grid-icon-up-dir'])"));
					if (verifyAscZoneSortIcon.isDisplayed())
					{
						Logger.info(" Line Number sorted in ascending order "); 
					}
					else
					{
						Logger.info(" Line Number not sorted in ascending order ");
					}
					zoneSorter.click();
					WebElement zoneSorterDesc = driver.findElement(By.xpath("//*[@id='menuitem-1']/button"));
					zoneSorterDesc.click();
					WebElement verifyDescZoneSortIcon = driver.findElement(By.xpath("//span[text()='Line Number']/../..//i[@class='ui-grid-icon-down-dir']"));
					if (verifyDescZoneSortIcon.isDisplayed())
					{
						Logger.info(" Line Number sorted in descending order "); 
					}
					else
					{
						Logger.info(" Line Number not sorted in descending order ");
					}

					zoneSorter.click();
					WebElement zoneSorterRemove = driver.findElement(By.xpath("//*[@id='menuitem-2']/button"));
					zoneSorterRemove.click();
					Logger.info(" Line Number sort removed"); 	  

				}
				catch(Exception e)
				{
					Logger.error(e.getMessage());
					throw e;
				}
				Thread.sleep(10000);
				try{

					WebElement zoneSorter = driver.findElement(By.xpath("(//span[text()='CSR']/../..//i[@class='ui-grid-icon-angle-down'])"));
					zoneSorter.click();
					WebElement zoneSorterAsc = driver.findElement(By.xpath("//*[@id='menuitem-0']/button"));
					zoneSorterAsc.click();
					WebElement verifyAscZoneSortIcon = driver.findElement(By.xpath("(//span[text()='CSR']/../..//i[@class='ui-grid-icon-up-dir'])"));
					if (verifyAscZoneSortIcon.isDisplayed())
					{
						Logger.info(" CSR sorted in ascending order "); 
					}
					else
					{
						Logger.info(" CSR not sorted in ascending order ");
					}
					zoneSorter.click();
					WebElement zoneSorterDesc = driver.findElement(By.xpath("//*[@id='menuitem-1']/button"));
					zoneSorterDesc.click();
					WebElement verifyDescZoneSortIcon = driver.findElement(By.xpath("//span[text()='CSR']/../..//i[@class='ui-grid-icon-down-dir']"));
					if (verifyDescZoneSortIcon.isDisplayed())
					{
						Logger.info(" CSR sorted in descending order "); 
					}
					else
					{
						Logger.info(" CSR not sorted in descending order ");
					}

					zoneSorter.click();
					WebElement zoneSorterRemove = driver.findElement(By.xpath("//*[@id='menuitem-2']/button"));
					zoneSorterRemove.click();
					Logger.info(" CSR sort removed"); 	  

				}
				catch(Exception e)
				{
					Logger.error(e.getMessage());
					throw e;
				}
			}
			else
			{
				Logger.info("drop down is empty");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectZipAndZonePreprintOrder(String type, String zip, String zone) throws Exception
	{
		try{


			WebElement typeDrpDwn = driver.findElement(By.xpath("//span[text()='Type']/../..//select"));
			Select selectType = new Select(typeDrpDwn);
			List<WebElement> listOfTypes = selectType.getOptions();

			if(listOfTypes.size() !=0)
			{
				selectType.selectByVisibleText(type);
				Logger.info(type+" Zone Type is selected"); 
			}
			else
			{
				Logger.info("drop down is empty");
			}

			WebElement zipText = driver.findElement(By.xpath("//span[text()='Zip']/../..//input"));
			zipText.click();
			zipText.sendKeys(Keys.CONTROL,"a");
			zipText.clear();
			zipText.sendKeys(zip);

			Logger.info(zip+" Zip is entered"); 

			WebElement zoneInclude = driver.findElement(By.xpath("(//*[text()='"+zip+"']/..)[2]"));
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(zoneInclude));
			zoneInclude.click();
			WebElement selectZone = driver.findElement(By.xpath("//span[@class = 'fa fa-forward']"));
			selectZone.click();
			Logger.info("Zip "+zip+" is included");


			WebElement zoneText = driver.findElement(By.xpath("//span[text()='Zone']/../..//input"));
			zoneText.click();
			zoneText.sendKeys(Keys.CONTROL,"a");
			zoneText.clear();
			zoneText.sendKeys(zone);
			Logger.info(zone+" Zone is entered"); 

			WebElement zoneInclude1 = driver.findElement(By.xpath("(//*[text()='"+zone+"']/..)"));

			wait.until(ExpectedConditions.visibilityOf(zoneInclude1));
			zoneInclude1.click();
			WebElement selectZone1 = driver.findElement(By.xpath("//span[@class = 'fa fa-forward']"));
			selectZone1.click();
			Logger.info("Zone "+zone+" is included");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectTypeZipAndZonePreprintOrder(String type, String zip, String zone) throws Exception
	{
		try{


			WebElement typeFilter = driver.findElement(By.xpath("//span[text()='Type']/../../div[3]/div/custom-multiselect/div/div/div/button"));
			typeFilter.click();
			WebElement typeFilterFull = driver.findElement(By.xpath("//span[text()='"+type+"']"));
			typeFilterFull.click();
			typeFilter.click();

			WebElement zipFilter = driver.findElement(By.xpath("//span[text()='Zip']/../../div[3]/div/custom-multiselect/div/div/div/button"));
			zipFilter.click();
			WebElement zipValue = driver.findElement(By.xpath("//span[text()='"+zip+"']"));
			zipValue.click();
			zipFilter.click();



			WebElement zoneFilter = driver.findElement(By.xpath("//span[text()='Zone']/../../div[3]/div/custom-multiselect/div/div/div/button"));
			zoneFilter.click();
			WebElement zoneValue = driver.findElement(By.xpath("//span[text()='"+zone+"']"));
			zoneValue.click();
			zoneFilter.click();

			WebElement zoneInclude1 = driver.findElement(By.xpath("(//*[text()='"+zone+"']/..)"));

			zoneInclude1.click();
			WebElement selectZone1 = driver.findElement(By.xpath("//span[@class = 'fa fa-forward']"));
			selectZone1.click();
			Logger.info("Zone "+zone+" is included");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void removeAssignedZone(String type, String zone) throws Exception
	{
		try{


			WebElement typeFilter = driver.findElement(By.xpath("(//span[text()='Type']/../../div[3]/div/custom-multiselect/div/div/div/button)[2]"));
			typeFilter.click();
			WebElement typeFilterFull = driver.findElement(By.xpath("//span[text()='"+type+"']"));
			typeFilterFull.click();
			typeFilter.click();


			WebElement zoneFilter = driver.findElement(By.xpath("(//span[text()='Zone']/../../div[3]/div/custom-multiselect/div/div/div/button)[2]"));
			zoneFilter.click();
			WebElement zoneFilterSelect = driver.findElement(By.xpath("//span[text()='"+zone+"']"));
			zoneFilterSelect.click();
			zoneFilterSelect.click();

			WebElement zoneRemove = driver.findElement(By.xpath("(//div[text()='"+type+"']/..)"));

			zoneRemove.click();
			Thread.sleep(3000);
			WebElement selectZone1 = driver.findElement(By.xpath("//span[@class = 'fa fa-backward']"));
			selectZone1.click();
			Logger.info("Zone "+zone+" is removed");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	public void matchZipZoneAndSelectPreprintOrder(String zip, String zone) throws Exception
	{
		try{

			WebElement macthZone = driver.findElement(By.xpath("//label[text()= 'Match Zone']"));
			macthZone.click();
			WebElement zoneText = driver.findElement(By.xpath("//*[@id='collapse2']/div/div/div[1]/div[2]/textarea"));
			zoneText.sendKeys(zone);
			Logger.info(zone+" Zone is entered"); 
			WebElement includeButton = driver.findElement(By.xpath("//button[text() = 'Include']"));   

			includeButton.click();

			Logger.info("Zone "+zone+" is included");

			WebElement macthZip = driver.findElement(By.xpath("//label[text()= 'Match Zip']"));
			macthZip.click();
			// WebElement zoneText = driver.findElement(By.xpath("//*[@id='collapse2']/div/div/div[1]/div[2]/textarea"));
			zoneText.sendKeys(zip);
			Logger.info(zip+" Zip is entered"); 

			includeButton.click();

			Logger.info("Zip "+zip+" is included");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectCountyPreprintOrder(String county) throws Exception
	{
		try{


			WebElement zoneText = driver.findElement(By.xpath("//span[text()='County']/../..//input"));
			zoneText.click();
			zoneText.sendKeys(Keys.CONTROL,"a");
			zoneText.clear();
			zoneText.sendKeys(county);
			Logger.info(county+" Zone is entered"); 

			WebElement zoneInclude1 = driver.findElement(By.xpath("(//*[text()='"+county+"']/..)"));
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(zoneInclude1));
			zoneInclude1.click();
			WebElement selectZone1 = driver.findElement(By.xpath("//span[@class = 'fa fa-forward']"));
			selectZone1.click();
			Logger.info("Zone "+county+" is included");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void maximizeDistributionWindowPreprintOrder() throws Exception
	{
		try{


			WebElement zoneText = driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[1]/button"));
			if(zoneText.isDisplayed())
			{
				zoneText.click();
				Logger.info("Distribution Window Maximized");
			}
			else
			{
				Logger.info("Distribution Window not Maximized");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void checkUncheckForceGroupPreprintOrder() throws Exception
	{
		try{


			WebElement forceGroupCheckBox = driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[2]/div/div[1]/div/div[2]/div[2]/label/i"));
			if(forceGroupCheckBox.isDisplayed())
			{
				forceGroupCheckBox.click();
				Logger.info("Force Group Checkbox Clicked");
			}
			else
			{
				Logger.info("Force Group Checkbox not found");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void exportSelectedZonesPreprintOrder() throws Exception
	{
		try{


			WebElement exportSelected = driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[2]/div/div[3]/div[2]/div[2]/div[2]/div/button[2]"));
			if(exportSelected.isDisplayed())
			{
				exportSelected.click();
				Logger.info("Export To Excel Clicked");
			}
			else
			{
				Logger.info("Export To Excel button not available");
			}
			Thread.sleep(5000);
			Robot robot = new Robot();	
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void verifyZoneSort() throws Exception
	{
		try{

			WebElement zoneSorter = driver.findElement(By.xpath("//span[text()='Zone']/../..//i[@class='ui-grid-icon-angle-down']"));
			zoneSorter.click();
			WebElement zoneSorterAsc = driver.findElement(By.xpath("//*[@id='menuitem-0']/button"));
			zoneSorterAsc.click();
			WebElement verifyAscZoneSortIcon = driver.findElement(By.xpath("//span[text()='Zone']/../..//i[@class='ui-grid-icon-up-dir']"));
			if (verifyAscZoneSortIcon.isDisplayed())
			{
				Logger.info(" Zone sorted in ascending order "); 
			}
			else
			{
				Logger.info(" Zone not sorted in ascending order ");
			}
			zoneSorter.click();
			WebElement zoneSorterDesc = driver.findElement(By.xpath("//*[@id='menuitem-1']/button"));
			zoneSorterDesc.click();
			WebElement verifyDescZoneSortIcon = driver.findElement(By.xpath("//span[text()='Zone']/../..//i[@class='ui-grid-icon-down-dir']"));
			if (verifyDescZoneSortIcon.isDisplayed())
			{
				Logger.info(" Zone sorted in descending order "); 
			}
			else
			{
				Logger.info(" Zone not sorted in descending order ");
			}

			zoneSorter.click();
			WebElement zoneSorterRemove = driver.findElement(By.xpath("//*[@id='menuitem-2']/button"));
			zoneSorterRemove.click();
			Logger.info(" Zone sort removed"); 	  

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void verifyTypeSort() throws Exception
	{
		try{

			WebElement zoneSorter = driver.findElement(By.xpath("//span[text()='Type']/../..//i[@class='ui-grid-icon-angle-down']"));
			zoneSorter.click();
			WebElement zoneSorterAsc = driver.findElement(By.xpath("//*[@id='menuitem-0']/button"));
			zoneSorterAsc.click();
			WebElement verifyAscZoneSortIcon = driver.findElement(By.xpath("//span[text()='Type']/../..//i[@class='ui-grid-icon-up-dir']"));
			if (verifyAscZoneSortIcon.isDisplayed())
			{
				Logger.info(" Type sorted in ascending order "); 
			}
			else
			{
				Logger.info(" Type not sorted in ascending order ");
			}
			zoneSorter.click();
			WebElement zoneSorterDesc = driver.findElement(By.xpath("//*[@id='menuitem-1']/button"));
			zoneSorterDesc.click();
			WebElement verifyDescZoneSortIcon = driver.findElement(By.xpath("//span[text()='Type']/../..//i[@class='ui-grid-icon-down-dir']"));
			if (verifyDescZoneSortIcon.isDisplayed())
			{
				Logger.info(" Type sorted in descending order "); 
			}
			else
			{
				Logger.info(" Type not sorted in descending order ");
			}

			zoneSorter.click();
			WebElement zoneSorterRemove = driver.findElement(By.xpath("//*[@id='menuitem-2']/button"));
			zoneSorterRemove.click();
			Logger.info(" Type sort removed"); 	  

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void verifyGroupSort() throws Exception
	{
		try{

			WebElement zoneSorter = driver.findElement(By.xpath("//span[text()='Group']/../..//i[@class='ui-grid-icon-angle-down']"));
			zoneSorter.click();
			WebElement zoneSorterAsc = driver.findElement(By.xpath("//*[@id='menuitem-0']/button"));
			zoneSorterAsc.click();
			WebElement verifyAscZoneSortIcon = driver.findElement(By.xpath("//span[text()='Group']/../..//i[@class='ui-grid-icon-up-dir']"));
			if (verifyAscZoneSortIcon.isDisplayed())
			{
				Logger.info(" Group sorted in ascending order "); 
			}
			else
			{
				Logger.info(" Group not sorted in ascending order ");
			}
			zoneSorter.click();
			WebElement zoneSorterDesc = driver.findElement(By.xpath("//*[@id='menuitem-1']/button"));
			zoneSorterDesc.click();
			WebElement verifyDescZoneSortIcon = driver.findElement(By.xpath("//span[text()='Group']/../..//i[@class='ui-grid-icon-down-dir']"));
			if (verifyDescZoneSortIcon.isDisplayed())
			{
				Logger.info(" Group sorted in descending order "); 
			}
			else
			{
				Logger.info(" Group not sorted in descending order ");
			}

			zoneSorter.click();
			WebElement zoneSorterRemove = driver.findElement(By.xpath("//*[@id='menuitem-2']/button"));
			zoneSorterRemove.click();
			Logger.info(" Group sort removed"); 	  

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	public void verifyQuantitySort() throws Exception
	{
		try{

			WebElement zoneSorter = driver.findElement(By.xpath("//span[text()='Qty']/../..//i[@class='ui-grid-icon-angle-down']"));
			zoneSorter.click();
			WebElement zoneSorterAsc = driver.findElement(By.xpath("//*[@id='menuitem-0']/button"));
			zoneSorterAsc.click();
			WebElement verifyAscZoneSortIcon = driver.findElement(By.xpath("//span[text()='Qty']/../..//i[@class='ui-grid-icon-up-dir']"));
			if (verifyAscZoneSortIcon.isDisplayed())
			{
				Logger.info(" Qty sorted in ascending order "); 
			}
			else
			{
				Logger.info(" Qty not sorted in ascending order ");
			}
			zoneSorter.click();
			WebElement zoneSorterDesc = driver.findElement(By.xpath("//*[@id='menuitem-1']/button"));
			zoneSorterDesc.click();
			WebElement verifyDescZoneSortIcon = driver.findElement(By.xpath("//span[text()='Qty']/../..//i[@class='ui-grid-icon-down-dir']"));
			if (verifyDescZoneSortIcon.isDisplayed())
			{
				Logger.info(" Qty sorted in descending order "); 
			}
			else
			{
				Logger.info(" Qty not sorted in descending order ");
			}

			zoneSorter.click();
			WebElement zoneSorterRemove = driver.findElement(By.xpath("//*[@id='menuitem-2']/button"));
			zoneSorterRemove.click();
			Logger.info(" Qty sort removed"); 	  

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	public void verifyCitySort() throws Exception
	{
		try{

			WebElement zoneSorter = driver.findElement(By.xpath("//span[text()='City']/../..//i[@class='ui-grid-icon-angle-down']"));
			zoneSorter.click();
			WebElement zoneSorterAsc = driver.findElement(By.xpath("//*[@id='menuitem-0']/button"));
			zoneSorterAsc.click();
			WebElement verifyAscZoneSortIcon = driver.findElement(By.xpath("//span[text()='City']/../..//i[@class='ui-grid-icon-up-dir']"));
			if (verifyAscZoneSortIcon.isDisplayed())
			{
				Logger.info(" City sorted in ascending order "); 
			}
			else
			{
				Logger.info(" City not sorted in ascending order ");
			}
			zoneSorter.click();
			WebElement zoneSorterDesc = driver.findElement(By.xpath("//*[@id='menuitem-1']/button"));
			zoneSorterDesc.click();
			WebElement verifyDescZoneSortIcon = driver.findElement(By.xpath("//span[text()='City']/../..//i[@class='ui-grid-icon-down-dir']"));
			if (verifyDescZoneSortIcon.isDisplayed())
			{
				Logger.info(" City sorted in descending order "); 
			}
			else
			{
				Logger.info(" City not sorted in descending order ");
			}

			zoneSorter.click();
			WebElement zoneSorterRemove = driver.findElement(By.xpath("//*[@id='menuitem-2']/button"));
			zoneSorterRemove.click();
			Logger.info(" City sort removed"); 	  

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	public void verifyZipSort() throws Exception
	{
		try{

			WebElement zoneSorter = driver.findElement(By.xpath("//span[text()='Zip']/../..//i[@class='ui-grid-icon-angle-down']"));
			zoneSorter.click();
			WebElement zoneSorterAsc = driver.findElement(By.xpath("//*[@id='menuitem-0']/button"));
			zoneSorterAsc.click();
			WebElement verifyAscZoneSortIcon = driver.findElement(By.xpath("//span[text()='Zip']/../..//i[@class='ui-grid-icon-up-dir']"));
			if (verifyAscZoneSortIcon.isDisplayed())
			{
				Logger.info(" Zip sorted in ascending order "); 
			}
			else
			{
				Logger.info(" Zip not sorted in ascending order ");
			}
			zoneSorter.click();
			WebElement zoneSorterDesc = driver.findElement(By.xpath("//*[@id='menuitem-1']/button"));
			zoneSorterDesc.click();
			WebElement verifyDescZoneSortIcon = driver.findElement(By.xpath("//span[text()='Zip']/../..//i[@class='ui-grid-icon-down-dir']"));
			if (verifyDescZoneSortIcon.isDisplayed())
			{
				Logger.info(" Zip sorted in descending order "); 
			}
			else
			{
				Logger.info(" Zip not sorted in descending order ");
			}

			zoneSorter.click();
			WebElement zoneSorterRemove = driver.findElement(By.xpath("//*[@id='menuitem-2']/button"));
			zoneSorterRemove.click();
			Logger.info(" Zip sort removed"); 	  

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void verifyRegionSort() throws Exception
	{
		try{

			WebElement zoneSorter = driver.findElement(By.xpath("//span[text()='Region']/../..//i[@class='ui-grid-icon-angle-down']"));
			zoneSorter.click();
			WebElement zoneSorterAsc = driver.findElement(By.xpath("//*[@id='menuitem-0']/button"));
			zoneSorterAsc.click();
			WebElement verifyAscZoneSortIcon = driver.findElement(By.xpath("//span[text()='Region']/../..//i[@class='ui-grid-icon-up-dir']"));
			if (verifyAscZoneSortIcon.isDisplayed())
			{
				Logger.info(" Region sorted in ascending order "); 
			}
			else
			{
				Logger.info(" Region not sorted in ascending order ");
			}
			zoneSorter.click();
			WebElement zoneSorterDesc = driver.findElement(By.xpath("//*[@id='menuitem-1']/button"));
			zoneSorterDesc.click();
			WebElement verifyDescZoneSortIcon = driver.findElement(By.xpath("//span[text()='Region']/../..//i[@class='ui-grid-icon-down-dir']"));
			if (verifyDescZoneSortIcon.isDisplayed())
			{
				Logger.info(" Region sorted in descending order "); 
			}
			else
			{
				Logger.info(" Region not sorted in descending order ");
			}

			zoneSorter.click();
			WebElement zoneSorterRemove = driver.findElement(By.xpath("//*[@id='menuitem-2']/button"));
			zoneSorterRemove.click();
			Logger.info(" Region sort removed"); 	  

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void verifyCountySort() throws Exception
	{
		try{

			WebElement zoneSorter = driver.findElement(By.xpath("//span[text()='County']/../..//i[@class='ui-grid-icon-angle-down']"));
			zoneSorter.click();
			WebElement zoneSorterAsc = driver.findElement(By.xpath("//*[@id='menuitem-0']/button"));
			zoneSorterAsc.click();
			WebElement verifyAscZoneSortIcon = driver.findElement(By.xpath("//span[text()='County']/../..//i[@class='ui-grid-icon-up-dir']"));
			if (verifyAscZoneSortIcon.isDisplayed())
			{
				Logger.info(" County sorted in ascending order "); 
			}
			else
			{
				Logger.info(" County not sorted in ascending order ");
			}
			zoneSorter.click();
			WebElement zoneSorterDesc = driver.findElement(By.xpath("//*[@id='menuitem-1']/button"));
			zoneSorterDesc.click();
			WebElement verifyDescZoneSortIcon = driver.findElement(By.xpath("//span[text()='County']/../..//i[@class='ui-grid-icon-down-dir']"));
			if (verifyDescZoneSortIcon.isDisplayed())
			{
				Logger.info(" County sorted in descending order "); 
			}
			else
			{
				Logger.info(" County not sorted in descending order ");
			}

			zoneSorter.click();
			WebElement zoneSorterRemove = driver.findElement(By.xpath("//*[@id='menuitem-2']/button"));
			zoneSorterRemove.click();
			Logger.info(" County sort removed"); 	  

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	//code to select all the zones on the distributions list
	public void selectAllZones() throws Exception
	{
		try{
			if(includeAllZonesChckBx.isDisplayed()){
				includeAllZonesChckBx.click();
				Logger.info("All zones are selected");
			}
			else{
				Logger.info("All zones selection checkbox is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to click on match Zone link
	public void clickOnMatchZoneLink() throws Exception
	{
		try{
			if(enterTextMatchZoneBtn.isDisplayed())
			{
				String status = enterTextMatchZoneBtn.getAttribute("class");
				Logger.info(status);
				String className = "btn btn-default ng-pristine ng-untouched ng-valid";
				if(status.equalsIgnoreCase(className))
				{
					enterTextMatchZoneBtn.click();
					Logger.info("Match zone is clicked");
				}
				else{
					Logger.info("Match zone is already selected");
				}
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to click on match zip link
	public void clickOnMatchZipLink() throws Exception
	{
		try{
			if(enterTextMatchZipBtn.isDisplayed())
			{
				String status = enterTextMatchZipBtn.getAttribute("class");
				String className = "btn btn-default ng-valid ng-dirty ng-touched";
				if(status.equalsIgnoreCase(className))
				{
					enterTextMatchZipBtn.click();
					Logger.info("Match zip is clicked");
				}
				else{
					Logger.info("Match zip is already selected");
				}
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to enter the zone or zip in the text area of distributions window
	public void enterZoneOrZipDistributions(String zonezip) throws Exception
	{
		try{
			if(zoneZipEnterTextArea.isDisplayed()){
				zoneZipEnterTextArea.click();
				zoneZipEnterTextArea.clear();
				zoneZipEnterTextArea.sendKeys(zonezip);
				Logger.info("Zone/Zip value is entered");
			}
			else{
				Logger.info("zoneZipEnterTextArea is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select the group of the zone that shoudl be selected
	public void selectZoneGroup(String group) throws Exception
	{
		try{
			if(zoneGroupDrpDwn.isDisplayed()){
				zoneGroupDrpDwn.click();
				Select select = new Select(zoneGroupDrpDwn);
				select.selectByVisibleText(group);
				Logger.info(group+ " group is selected");
			}
			else{
				Logger.info("zone group drop down is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select the line version in which the zone needs to be added
	public void selectLineVersion(int versionIndex) throws Exception
	{
		try{
			if(lineVersionDrpDwn.isDisplayed())
			{
				lineVersionDrpDwn.click();
				Select select  = new Select(lineVersionDrpDwn);
				select.selectByIndex(versionIndex);
				Logger.info("line version is selected");
			}
			else{
				Logger.info("line version drop down is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to click on include button after entering the zone or zip code in enter text tab of distributions window
	public void clickOnIncludeZoneSelection() throws Exception
	{
		try{
			if(clickOnIncludeZoneSelectedBtn.isDisplayed()){
				clickOnIncludeZoneSelectedBtn.click();
				Thread.sleep(1000);
				Logger.info("the zone/zip is included");
			}else{
				Logger.info("include button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to click on include button after entering the zone or zip code in enter text tab of distributions window
	public void clickOnRemoveZoneSelection() throws Exception
	{
		try{
			if(clickOnRemoveZoneSelectedBtn.isDisplayed()){
				clickOnRemoveZoneSelectedBtn.click();
				Thread.sleep(1000);
				Logger.info("the zone/zip is removed");
			}else{
				Logger.info("remove button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to click on include button after entering the zone or zip code in enter text tab of distributions window
	public void clickOnCancelZoneSelection() throws Exception
	{
		try{
			if(clickOnRemoveZoneSelectedBtn.isDisplayed()){
				clickOnRemoveZoneSelectedBtn.click();
				Logger.info("the zone/zip entered is cancelled");
			}else{
				Logger.info("cancel button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to click on the assigned zones link
	public void clickOnAssignedZonesLink() throws Exception
	{
		try{
			if(assignedZonesLink.isDisplayed()){
				assignedZonesLink.click();
				Logger.info("Assigned zones link is clicked");
			}
			else{
				Logger.info("Assigned zones link is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to get the count of the assigned zones
	public int getAssignedZonesCount() throws Exception
	{
		String countOfZones = "";
		try{
			if(countOfAssignedZones.isDisplayed()){
				countOfZones = countOfAssignedZones.getText();
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return Integer.parseInt(countOfZones);
	}

	//code to click on zone confirmation button
	public void confirmZoneSelection() throws Exception
	{
		try{
			if(zoneSelectionConfirmBtn.isDisplayed()){
				zoneSelectionConfirmBtn.click();
				Thread.sleep(2000);
				Logger.info("zone selection is confirmed");
			}
			else{
				Logger.info("zone confirmation button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to get the distributions added to teh insertion
	public int getDistributionsAdded() throws Exception
	{
		String distributionsCount = "";
		try
		{
			if(preprintDistributionsTextBox.isDisplayed())
			{
				distributionsCount = preprintDistributionsTextBox.getAttribute("value");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return Integer.parseInt(distributionsCount);
	}

	//code to click on zone cancellation button
	public void cancelZoneSelection() throws Exception
	{
		try{
			if(zoneSelectionCancelBtn.isDisplayed()){
				zoneSelectionCancelBtn.click();
				Thread.sleep(2000);
				Logger.info("zone selection is canceled");
			}
			else{
				Logger.info("zone cancellation button is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to select the perforation in the P&D tab of an insertion
	public void selectPandDPerforation(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement perforation = driver.findElement(By.xpath("(//label[text()='Perforation']/../div/select)["+insertionIndex+"]"));
			perforation.click();
			Select select = new Select (perforation);
			select.selectByVisibleText(properties.getProperty(value));
			Logger.info(properties.getProperty(value)+ " perforation is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select the fold in the P&D tab of an insertion
	public void selectPandDFold(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement fold = driver.findElement(By.xpath("(//label[text()='Fold']/../div/select)["+insertionIndex+"]"));
			fold.click();
			Select select = new Select(fold);
			select.selectByVisibleText(properties.getProperty(value));
			Logger.info(properties.getProperty(value)+ " fold is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select the bindery in the P&D tab of an insertion
	public void selectPandDBindery(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement bindery = driver.findElement(By.xpath("(//label[text()='Bindery']/../div/select)["+insertionIndex+"]"));
			bindery.click();
			Select select = new Select (bindery);
			select.selectByVisibleText(properties.getProperty(value));
			Logger.info(properties.getProperty(value)+ " bindery is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select the creative location in the P&D tab of an insertion
	public void selectPandDCreativeLoc(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement creativeLoc = driver.findElement(By.xpath("(//label[text()='Creative Location']/../div/select)["+insertionIndex+"]"));
			//creativeLoc.click();
			Select select = new Select (creativeLoc);
			select.selectByVisibleText(properties.getProperty(value));
			Logger.info(properties.getProperty(value)+ " creative location is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectPandDCreativeLocByIndex(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement creativeLoc = driver.findElement(By.xpath("(//label[text()='Creative Location']/../div/select)["+insertionIndex+"]"));
			//creativeLoc.click();
			Select select = new Select (creativeLoc);
			select.selectByIndex(1);
			Logger.info(" creative location is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select the paper stock in the P&D tab of an insertion
	public void selectPandDPaperStock(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement paperStock = driver.findElement(By.xpath("(//label[text()='Paper Stock']/../div/select)["+insertionIndex+"]"));
			paperStock.click();
			Select select = new Select (paperStock);
			select.selectByVisibleText(properties.getProperty(value));
			Logger.info(properties.getProperty(value)+ " paper stock is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select the paper stock in the P&D tab of an insertion
	public void selectPandDPaperStock1(String insertionIndex, int index) throws Exception
	{
		try{
			WebElement paperStock = driver.findElement(By.xpath("(//label[text()='Paper Stock']/../div/select)["+insertionIndex+"]"));
			paperStock.click();
			Select select = new Select (paperStock);
			select.selectByIndex(index);
			Logger.info("paper stock is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select the paper color in the P&D tab of an insertion
	public void selectPandDPaperColor(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement paperColor = driver.findElement(By.xpath("(//label[text()='Paper Color']/../div/select)["+insertionIndex+"]"));
			paperColor.click();
			Select select = new Select (paperColor);
			select.selectByVisibleText(properties.getProperty(value));
			Logger.info(properties.getProperty(value)+ " paper color is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select the paper weight in the P&D tab of an insertion
	public void selectPandDPaperWeight(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement paperWeight = driver.findElement(By.xpath("(//label[text()='Paper Weight']/../div/select)["+insertionIndex+"]"));
			paperWeight.click();
			Select select = new Select (paperWeight);
			select.selectByVisibleText(properties.getProperty(value));
			Logger.info(properties.getProperty(value)+ " paper weight is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select the orientation front in the P&D tab of an insertion
	public void selectPandDOrientFront(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement orientFront = driver.findElement(By.xpath("(//label[text()='Orientation Front']/../div/select)["+insertionIndex+"]"));
			orientFront.click();
			Select select = new Select (orientFront);
			select.selectByVisibleText(properties.getProperty(value));
			Logger.info(properties.getProperty(value)+ " orientation front is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select the orientation back in the P&D tab of an insertion
	public void selectPandDOrientBack(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement orientBack = driver.findElement(By.xpath("(//label[text()='Orientation Back']/../div/select)["+insertionIndex+"]"));
			orientBack.click();
			Select select = new Select (orientBack);
			select.selectByVisibleText(properties.getProperty(value));
			Logger.info(properties.getProperty(value)+ " orientation Back is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectPandDOrientation(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement orientBack = driver.findElement(By.xpath("(//label[text()='Orientation']/../div/select)["+insertionIndex+"]"));
			orientBack.click();
			Select select = new Select (orientBack);
			select.selectByVisibleText((value));
			Logger.info((value)+ " orientation  is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectPandDOrientationException(String insertionIndex, String value, String pageNo) throws Exception
	{
		try{
			WebElement orientBack = driver.findElement(By.xpath("(//label[text()='Orientation']/../div/span)["+insertionIndex+"]"));
			orientBack.click();
			WebElement orientExceptionAdd = driver.findElement(By.xpath("html/body/ul/div/div/button"));
			orientExceptionAdd.click();
			WebElement orientException = driver.findElement(By.xpath("//*[@id='exception']/select[1]"));
			Select select = new Select (orientException);
			select.selectByVisibleText((value));
			Logger.info((value)+ " orientation exception is selected");
			WebElement orientExceptionPage = driver.findElement(By.xpath("//*[@id='exception']/div/button"));
			orientExceptionPage.click();
			WebElement orientExceptionPageNo = driver.findElement(By.xpath("//*[@id='exception']/div/ul/li["+pageNo+"]/a/label"));
			orientExceptionPageNo.click();

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	//code to select the ink front in the P&D tab of an insertion
	public void selectPandDInkFront(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement inkFront = driver.findElement(By.xpath("(//label[text()='Ink Front']/../div/select)["+insertionIndex+"]"));
			inkFront.click();
			Select select = new Select (inkFront);
			select.selectByVisibleText(properties.getProperty(value));
			Logger.info(properties.getProperty(value)+ " ink front is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select the ink back in the P&D tab of an insertion
	public void selectPandDInkBack(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement inkBack = driver.findElement(By.xpath("(//label[text()='Ink Back']/../div/select)["+insertionIndex+"]"));
			inkBack.click();
			Select select = new Select (inkBack);
			select.selectByVisibleText(properties.getProperty(value));
			Logger.info(properties.getProperty(value)+ " ink back is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	public void selectPandDInk(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement inkBack = driver.findElement(By.xpath("(//label[text()='Ink']/../div/select)["+insertionIndex+"]"));
			inkBack.click();
			Select select = new Select (inkBack);
			select.selectByVisibleText((value));
			Logger.info((value)+ " ink back is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectPandDInkException(String insertionIndex, String value, String pageNo) throws Exception
	{
		try{
			WebElement inkBack = driver.findElement(By.xpath("(//label[text()='Ink']/../div/span)["+insertionIndex+"]"));
			inkBack.click();
			WebElement inkExceptionAdd = driver.findElement(By.xpath("html/body/ul/div/div/button"));
			inkExceptionAdd.click();
			WebElement inkException = driver.findElement(By.xpath("//*[@id='exception']/select[1]"));
			Select select = new Select (inkException);
			select.selectByIndex(0);
			Logger.info((value)+ " ink exception is selected");
			WebElement inkExceptionPage = driver.findElement(By.xpath("//*[@id='exception']/div/button"));
			inkExceptionPage.click();
			WebElement inkExceptionPageNo = driver.findElement(By.xpath("//*[@id='exception']/div/ul/li["+pageNo+"]/a/label"));
			inkExceptionPageNo.click();

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	public void enterPandDColorException(int insertionIndex, String color1, String color2, String color3, String pageNo) throws Exception
	{
		try{
			WebElement colorExceptionButton = driver.findElement(By.xpath("(//label[text()='Colors']/../div/span)["+(insertionIndex+2)+"]"));
			colorExceptionButton.click();
			WebElement colorExceptionAdd = driver.findElement(By.xpath("html/body/ul/div/div/button"));
			colorExceptionAdd.click();
			WebElement colorException1 = driver.findElement(By.xpath("//*[@id='exception']/div[1]/input[1]"));
			colorException1.sendKeys(color1);
			Thread.sleep(3000);
			WebElement colorException2 = driver.findElement(By.xpath("//*[@id='exception']/div[1]/input[2]"));
			colorException2.sendKeys(color2);
			Thread.sleep(3000);
			WebElement colorException3 = driver.findElement(By.xpath("//*[@id='exception']/div[1]/input[3]"));
			colorException3.sendKeys(color3);
			Thread.sleep(3000);
			Logger.info(" color exceptions added");
			WebElement inkExceptionPage = driver.findElement(By.xpath("//*[@id='exception']/div[2]/button"));
			inkExceptionPage.click();
			WebElement inkExceptionPageNo = driver.findElement(By.xpath("//*[@id='exception']/div[2]/ul/li["+pageNo+"]/a/label"));
			inkExceptionPageNo.click();

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	//code to select the bleed in the P&D tab of an insertion
	public void selectPandDBleed(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement bleed = driver.findElement(By.xpath("(//label[text()='Bleed']/../div/select)["+insertionIndex+"]"));
			bleed.click();
			Select select = new Select (bleed);
			String bleed_value=properties.getProperty(value).trim();
			Logger.info("Bleed value:"+bleed_value);
			select.selectByVisibleText(bleed_value);
			Logger.info(properties.getProperty(value)+ " bleed is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	public void selectPandDBleedException(String insertionIndex, String value, String pageNo) throws Exception
	{
		try{
			WebElement bleedBack = driver.findElement(By.xpath("(//label[text()='Bleed']/../div/span)["+insertionIndex+"]"));
			bleedBack.click();
			WebElement bleedExceptionAdd = driver.findElement(By.xpath("html/body/ul/div/div/button"));
			bleedExceptionAdd.click();
			WebElement bleedException = driver.findElement(By.xpath("//*[@id='exception']/select[1]"));
			Select select = new Select (bleedException);
			select.selectByVisibleText((value));
			Logger.info((value)+ " bleed exception is selected");
			WebElement bleedExceptionPage = driver.findElement(By.xpath("//*[@id='exception']/div/button"));
			bleedExceptionPage.click();
			WebElement bleedExceptionPageNo = driver.findElement(By.xpath("//*[@id='exception']/div/ul/li["+pageNo+"]/a/label"));
			bleedExceptionPageNo.click();

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	//code to select the bag color in the P&D tab of an insertion
	public void selectPandDBagColor(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement bagColor = driver.findElement(By.xpath("(//label[text()='Bag Color']/../div/select)["+insertionIndex+"]"));
			bagColor.click();
			Select select = new Select (bagColor);
			select.selectByVisibleText(properties.getProperty(value));
			Logger.info(properties.getProperty(value)+ " bag color is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select the printer in the P&D tab of an insertion
	public void selectPandDPrinter(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement printer = driver.findElement(By.xpath("(//label[text()='Printer']/../div/select)["+insertionIndex+"]"));
			printer.click();
			Select select = new Select (printer);
			select.selectByVisibleText(properties.getProperty(value));
			Logger.info(properties.getProperty(value)+ " printer is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to select the page type in the settings tab of an insertion
	public void selectPageType(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement printer = driver.findElement(By.xpath("(//label[text()='Page Type']/../div/a/span[@id='Span1']/span)["+insertionIndex+"]"));
			//WebDriverWait wait= new WebDriverWait(driver, 20);//swagata
			//wait.until(ExpectedConditions.elementToBeClickable(printer));//swagata
			Thread.sleep(3000);
			printer.click();
			Thread.sleep(2000);
			Select select = new Select(pageTypeDrpDwn);
			//	  select.selectByVisibleText(value);//swagata
			//	  Logger.info(value+ " page type is selected");//swagata
			select.selectByVisibleText(properties.getProperty(value));
			//select.selectByVisibleText(value);
			Logger.info(properties.getProperty(value)+ " page type is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}



	//code to enter comments in the P&D tab of an insertion
	public void enterPandDComments(String insertionIndex) throws Exception
	{
		try{
			WebElement comments = driver.findElement(By.xpath("(//label[text()='Comments']/../div/textarea)["+insertionIndex+"]"));
			comments.click();
			TribuneUtils utils = new TribuneUtils(); 
			comments.sendKeys(utils.generateRandomString(15));
			Logger.info("comments are entered in the insertion");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * 
	 * @param index of the insertion 
	 * @description This method clicks on the sales rep section on a selected insertion
	 */
	public void clickOnInsertionSalesRepSection(int insertionIndex) throws Exception
	{

		// JavascriptExecutor js = ((JavascriptExecutor) driver);
		//  js.executeScript("scroll(0,400)");

		//WebElement salesRepSection = driver.findElement(By.xpath("//tbody["+insertionIndex+"]//a[@class='salesrep-info dropdown-toggle']/span[1]"));
		
		WebElement salesRepSection = driver.findElement(By.xpath("//tbody["+insertionIndex+"]//a[@class='salesrep-info dropdown-toggle']/span[1]"));

		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", salesRepSection);//swagata

		/*  try{

		  Thread.sleep(2000);
		  salesRepSection.click();
		  Logger.info("Sales Rep section on insertion "+insertionIndex+" is clicked");
	  }
	  catch(Exception e)
	  {
		  Logger.error(e.getMessage());
		  throw e;
	  } */
		Actions action=new Actions(driver);
		action.moveToElement(salesRepSection).click().build().perform();
		Logger.info("Sales Rep section on insertion "+insertionIndex+" is clicked");
	}
	//Partha
	public void ScrollToInsertionLine(int insertionIndex) throws Exception
	{

		// JavascriptExecutor js = ((JavascriptExecutor) driver);
		//  js.executeScript("scroll(0,400)");

		WebElement salesRepSection = driver.findElement(By.xpath("//tbody["+insertionIndex+"]//a[@class='salesrep-info dropdown-toggle']/span[1]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", salesRepSection);//swagata

		
		
		Logger.info("scroll to insertion line"+insertionIndex+" is done");
	}
	public void clickOnsalesrrepInInserionLine(int insertionIndex) throws Exception
	{

		WebElement salesRepSection = driver.findElement(By.xpath("//tbody["+insertionIndex+"]//a[@class='salesrep-info dropdown-toggle']/span[1]"));

		Actions action=new Actions(driver);
		action.moveToElement(salesRepSection).click().build().perform();
		Logger.info("Sales Rep section on insertion "+insertionIndex+" is clicked");
	}

	/**
	 * @param insertionIndex and salesRepNum
	 * @description This method is used to add sales rep on a specific insertion
	 */
	public void addNewSalesRepOnInsertion21(int i, String salesRepNum) throws Exception//Shalini
	{
		switch (salesRepNum)

		{
		case "SA02210":  salesRepNum = "SA01380";       break;
		case "SA00856":  salesRepNum = "SA01380";       break;
		case "SA02514":  salesRepNum = "SA01380";       break;
		case "SA02433":  salesRepNum = "SA01380";       break;
		case "SA01380":  salesRepNum = "SA01380";       break;
		case "SA00494":  salesRepNum = "SA01380";       break;
		case "SA03612":  salesRepNum = "SA01380";       break;
		case "SA01774":  salesRepNum = "SA01380";       break;
		case "SA02146":  salesRepNum = "SA01380";       break;     
		case "SA03390":  salesRepNum = "SA01380";       break;        

		} 
		try{
			Logger.info(salesRepNum +" Sales rep is adding to insertion "+i);
			Thread.sleep(4000);//Shalini
			WebElement searchSalesRepTextBox = driver.findElement(By.xpath("(//input[@ng-model='searchrep'])["+i+"]"));
			Thread.sleep(4000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchSalesRepTextBox);
			searchSalesRepTextBox.click();
			Thread.sleep(4000);
			searchSalesRepTextBox.sendKeys(salesRepNum);
			Thread.sleep(4000);
			WebElement salesRepSearchResult = driver.findElement(By.xpath("//a[@class='customer-aclist-item ng-scope']/div/span[1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", salesRepSearchResult);
			salesRepSearchResult.click();
			/*	  WebElement salesRepColumnName = driver.findElement(By.xpath("//th[text()='Salesrep']"));
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", salesRepColumnName);
		  Thread.sleep(4000);
		  salesRepColumnName.click(); */
			Logger.info(salesRepNum +" Sales rep is added to insertion "+i);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void addNewSalesRepOnInsertion(int i, String salesRepNum) throws Exception//Shalini
	{
		switch (salesRepNum)

		{
		case "SA02210":  salesRepNum = "SA02907";       break;
		case "SA00856":  salesRepNum = "SA02907";       break;
		case "SA02514":  salesRepNum = "SA02907";       break;
		case "SA02433":  salesRepNum = "SA02907";       break;
		case "SA01380":  salesRepNum = "SA02907";       break;
		case "SA00494":  salesRepNum = "SA02907";       break;
		case "SA03612":  salesRepNum = "SA02907";       break;
		case "SA01774":  salesRepNum = "SA02907";       break;
		case "SA02146":  salesRepNum = "SA02907";       break;     
		case "SA03390":  salesRepNum = "SA02907";       break;
		case "SA02907":  salesRepNum = "SA02907";       break;
		case "SA01634":  salesRepNum = "SA02907";       break;



		}//swagata

		try{

			Logger.info(salesRepNum +" Sales rep is adding to insertion "+i);
			Thread.sleep(4000);//Shalini
			WebElement searchSalesRepTextBox = driver.findElement(By.xpath("(//input[@ng-model='searchrep'])["+i+"]"));
			Thread.sleep(4000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchSalesRepTextBox);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchSalesRepTextBox);//swagata
			searchSalesRepTextBox.click();
			Thread.sleep(4000);
			searchSalesRepTextBox.sendKeys(salesRepNum);
			Thread.sleep(4000);
			WebElement salesRepSearchResult = driver.findElement(By.xpath("//a[@class='customer-aclist-item ng-scope']/div/span[1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", salesRepSearchResult);
			salesRepSearchResult.click();
			/*	  WebElement salesRepColumnName = driver.findElement(By.xpath("//th[text()='Salesrep']"));
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", salesRepColumnName);
		  Thread.sleep(4000);
		  salesRepColumnName.click(); */
			Logger.info(salesRepNum +" Sales rep is added to insertion "+i);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void addNewSalesRepOnInsertionClassified(int insertionIndex, String salesRepNum) throws Exception
	{
		try{
			WebElement searchSalesRepTextBox = driver.findElement(By.xpath("html/body/ul/li[1]/input"));
			//WebElement searchSalesRepTextBox = driver.findElement(By.xpath("(//input[@name='searchtext'])['"+insertionIndex+"']"));
			// WebElement searchSalesRepTextBox = driver.findElement(By.xpath("//tbody['"+insertionIndex+"']//a[@class='salesrep-info dropdown-toggle']/span[1]"));//swagata

			WebDriverWait wait = new WebDriverWait(driver,200);	//swagata	       
			wait.until(ExpectedConditions.elementToBeClickable(searchSalesRepTextBox));//swagata

			searchSalesRepTextBox.click();
			searchSalesRepTextBox.sendKeys(salesRepNum);
			WebElement salesRepSearchResult = driver.findElement(By.xpath("//a[@class='customer-aclist-item ng-scope']/div/span[1]"));
			salesRepSearchResult.click();
			WebElement salesRepColumnName = driver.findElement(By.xpath("//th[text()='Salesrep']"));
			salesRepColumnName.click();
			Logger.info(salesRepNum +" Sales rep is added to insertion "+insertionIndex);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void addNewSalesRep(String salesRepNum) throws Exception
	{
		try{
			WebElement searchSalesRepTextBox = driver.findElement(By.xpath("(//input[@ng-model='searchrep'])"));
			searchSalesRepTextBox.click();
			searchSalesRepTextBox.sendKeys(salesRepNum);
			WebElement salesRepSearchResult = driver.findElement(By.xpath("//a[@class='customer-aclist-item ng-scope']/div/span[1]"));
			salesRepSearchResult.click();
			WebElement salesRepColumnName = driver.findElement(By.xpath("//th[text()='Salesrep']"));
			salesRepColumnName.click();
			Logger.info(salesRepNum +" Sales rep is added to insertion ");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void applytoAllSalesRepOnInsertion(int insertionIndex) throws Exception
	{
		try{
			Thread.sleep(3000);//Shalini
			/*Actions scrol=new Actions(driver);
		  scrol.moveToElement(driver.findElement(By.xpath("(//input[@ng-model='searchrep'])["+insertionIndex+"]")));
		  WebElement searchSalesRepTextBox = driver.findElement(By.xpath("(//input[@ng-model='searchrep'])["+insertionIndex+"]"));
			 */
			clickOnInsertionSalesRepSection(1);
			Thread.sleep(3000);
			WebElement searchSalesRepTextBox = driver.findElement(By.xpath("(//input[@ng-model='searchrep'])["+insertionIndex+"]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchSalesRepTextBox);
			searchSalesRepTextBox.click();
			WebElement salesRepSearchResult = driver.findElement(By.xpath("html/body/ul/li[2]/label/i"));
			// WebElement salesRepSearchResult = driver.findElement(By.xpath("(//input[@ng-click='applyToAllInsertions(salesrep)'])[2]"));//swagata new

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", salesRepSearchResult); 
			Thread.sleep(4000);
			salesRepSearchResult.click();
			Logger.info(" Sales rep is applied to all insertion from insertion"+insertionIndex);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	public void applytoAllSalesRepOnInsertion2(int insertionIndex) throws Exception//Shalini
	{
		try{
			WebElement searchSalesRepTextBox = driver.findElement(By.xpath("(//input[@ng-model='searchrep'])[2]"));
			searchSalesRepTextBox.click();
			WebElement salesRepSearchResult = driver.findElement(By.xpath("html/body/ul/li[2]/label/i"));
			salesRepSearchResult.click();
			Logger.info(" Sales rep is applied to all insertion from insertion"+insertionIndex);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void applytoAllSalesRepOnInsertionClassified(int insertionIndex) throws Exception
	{
		try{
			WebElement salesRepSearchResult = driver.findElement(By.xpath("html/body/ul/li[2]/label/i"));
			salesRepSearchResult.click();
			Logger.info(" Sales rep is applied to all insertion from insertion"+insertionIndex);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void removeSalesRepOnInsertion(int i) throws Exception//Shalini
	{
		try{
			WebElement searchSalesRepTextBox = driver.findElement(By.xpath("(//input[@ng-model='searchrep'])["+i+"]"));
			searchSalesRepTextBox.click();
			/*  WebElement salesRepSearchResult = driver.findElement(By.xpath("html/body/ul/li[3]/div/a/i"));
		  if (salesRepSearchResult.isDisplayed())
		  {
		  salesRepSearchResult.click();
		  Logger.info(" Sales rep is removed from insertion"+insertionIndex);
		  }
		  else
		  {
			  searchSalesRepTextBox.click();
		  }*/
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public boolean validateNewSalesRepOnInsertion(int insertionIndex, String salesRepNum) throws Exception
	{
		try{
			WebElement searchSalesRepTextBox = driver.findElement(By.xpath("(//input[@ng-model='searchrep'])["+insertionIndex+"]"));
			searchSalesRepTextBox.click();
			searchSalesRepTextBox.sendKeys(salesRepNum);
			WebElement salesRepSearchResult = driver.findElement(By.xpath("//a[@class='customer-aclist-item ng-scope']/div/span[1]"));
			salesRepSearchResult.click();
			WebElement salesRepColumnName = driver.findElement(By.xpath("//th[text()='Salesrep']"));
			salesRepColumnName.click();
			Logger.info(salesRepNum +" Sales rep is added to insertion "+insertionIndex);
			return true;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			Logger.info(" Sales rep doesnt exist");
			return false;
		} 
	}

	/**
	 * @param insertionIndex and class code
	 * @description This method is used to enter class code for a specific insertion
	 */
	public void enterClassCodeForAnInsertion(int insertionIndex, String classCode) throws Exception//Shalini
	{
		try{
			WebElement classCodeElement = driver.findElement(By.xpath("//tbody["+insertionIndex+"]/tr/td[16]/a/span"));
			classCodeElement.click();
			Thread.sleep(4000);
			WebElement classCodeTextBox = driver.findElement(By.xpath("//tbody["+insertionIndex+"]/tr/td[16]//input"));
			classCodeTextBox.sendKeys(classCode);
			Thread.sleep(4000);
			WebElement classCodeSearchResult = driver.findElement(By.xpath("//tbody["+insertionIndex+"]//td[16]//a/strong"));
			classCodeSearchResult.click();
			Logger.info(classCode +" class code is entered ");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	public void enterClassCodeForAnInsertionByText(int insertionIndex, String classCode, String text) throws Exception//Shalini
	{
		try{
			WebElement classCodeElement = driver.findElement(By.xpath("//tbody["+insertionIndex+"]/tr/td[16]/a/span"));
			classCodeElement.click();
			WebElement classCodeTextBox = driver.findElement(By.xpath("//tbody["+insertionIndex+"]/tr/td[16]//input"));
			classCodeTextBox.sendKeys(classCode);
			WebElement classCodeSearchResult = driver.findElement(By.xpath("//tbody["+insertionIndex+"]//td[16]//a[contains(text(),'"+text+"')]"));
			classCodeSearchResult.click();
			Logger.info(classCode +" class code is entered ");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	} 
	/**
	 * @param insertionIndex
	 * @description This method is used to return the class code for a specific insertion
	 */
	public String getClassCodeForAnInsertion(int insertionIndex) throws Exception//Shalini
	{
		try{
			WebElement classCodeElement = driver.findElement(By.xpath("//tbody["+insertionIndex+"]/tr/td[16]/a/span/span"));
			//classCodeElement.click();
			Thread.sleep(2000);;
			String classcode = classCodeElement.getText();
			return classcode;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method clicks on yes button in the confirmation window to create a legacy auto insertion
	 */
	public String clickYesLegacyAutoInsertionCreation() throws Exception
	{
		String text ="";
		try{
			if(confirmLegacyAutoInsertion.isDisplayed())
			{
				Logger.info("Confirmation window is displayed requesting the user to either accept or reject the creation of legacy auto insertion");
				confirmLegacyAutoInsertion.click();
				//text = displayMsg.getText();
				Logger.info("Message is displayed in the pop up: " +displayMsg.getAttribute("value"));//swagata
				Logger.info("'Yes' is clicked in confirmation window");
			}
			else{
				Assert.fail("Legacy auto insertion confirmation window is not displayed");
			}
		} 
		catch(Exception e)
		{
			Logger.info("auto insertion pop up not came");
			//throw e;
		}
		return text; 
	}

	/**
	 * @return 
	 * @description This method clicks on No button in the confirmation window to reject creation of legacy auto insertion
	 */
	public String clickNoLegacyAutoInsertionCreation() throws Exception
	{
		String text ="";//swagata
		try{
			//if(driver.findElements(By.xpath("//button[text()='Yes']")).size()>0)
			if(confirmLegacyAutoInsertion.isDisplayed())
			{
				//Logger.info("Confirmation window is displayed requesting the user to either accept or reject the creation of legacy auto insertion");
				rejectLegacyAutoInsertion.click();
				//text = displayMsg.getAttribute("value");//swagata
				//Logger.info("Message is displayed in the pop up: " + text);//swagata
				Logger.info("'No' is clicked in confirmation window");
			}
			else{
				//Assert.fail("Legacy auto insertion confirmation window is not displayed");
				Logger.info("auto insertion popup not came");

			}
		} 
		catch(Exception e)
		{
			Logger.info("insertion line pop up not displayed");
			throw e;
		}
		return text;//swagata 

	}

	/**
	 * @description This method is to click on continue button in the past pub date confirmation window
	 */
	public void clickOnContinuePastPubDate() throws Exception
	{
		try
		{
			pastPubDateConfirmBtn.click();
			Logger.info("Continue button is clicked in the past pubdate confirmation window");
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @description This method is to click on continue button in the past deadline date confirmation window
	 */
	public void clickOnContinuePastDeadlineDate() throws Exception
	{
		try
		{
			if(driver.findElements(By.xpath("//button[text()='Continue']")).size()>0) {
			pastPubDeadlineConfirmBtn.click();
			Logger.info("Continue button is clicked in the past deadline date confirmation window");
			//Thread.sleep(2000);
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @description This method clicks on MAke Free button in the confirmation window to make the order free
	 */
	public void confirmToMakeOrderFree() throws Exception
	{
		try{
			confirmMakeOrderFreeBtn.click();
			Logger.info("confirmed to make the order a free order");
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @description This method clicks on "Keep As it is" button in the confirmation window to keep the price as it is and not to make the order a free order
	 */
	public void rejecttoMakeAnOrderFree() throws Exception
	{
		try{
			rejectFreeOrderKeepAsItis.click();
			Logger.info("order is kept as it is without making it free");
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @author cymkozalg6 - Priyanka
	 * @param insertionIndex
	 * @return SalesReps added on an insertion
	 */
	public String getSalesRepOnInsertion(int insertionIndex) throws Exception//Shalini
	{
		try{
			WebElement salesRep = driver.findElement(By.xpath("//tbody["+insertionIndex+"]//a[@class='salesrep-info dropdown-toggle']/span[2]"));
			String salesRepName = salesRep.getText();
			return salesRepName;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description Depending on the insertion number given, number of sales rep added to the insertion is returned
	 * @param insertionNumber
	 * @return salesRepCount on an insertion
	 */
	public int getNoOfSalesRepOnInsertion(int insertionNumber) throws Exception
	{
		try{
			WebElement salesRepCount = driver.findElement(By.xpath("(//a[@class='salesrep-info dropdown-toggle']/span[1])["+insertionNumber+"]"));
			String count = salesRepCount.getText();
			return Integer.parseInt(count);
		}  
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void validateSalesRepError() throws Exception
	{
		try{

			//	WebElement salesRepSection = driver.findElement(By.xpath("(//*[@id='Span4'])[1]"));
			Thread.sleep(2000);
			//	  salesRepSection.click();
			//	  Logger.info("First Sales Rep section on order level is clicked");
			//	  Thread.sleep(3000);
			WebElement salesRepPercentage = driver.findElement(By.xpath("(//*[@id='Span2'])[5]/span"));  
			WebDriverWait wait = new WebDriverWait(driver,20);             
			wait.until(ExpectedConditions.visibilityOf(salesRepPercentage));
			Thread.sleep(2000);
			salesRepPercentage.click();  
			Thread.sleep(10000);
			WebElement salesRepPercentageText = driver.findElement(By.xpath("//input[@percentage='percentage']"));  
			salesRepPercentageText.clear();
			Thread.sleep(2000);
			salesRepPercentageText.sendKeys("100");
			Thread.sleep(2000);
			salesRepPercentageText.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			WebElement errorMessage = driver.findElement(By.xpath("//div[text()='Total percentage has to be 100']"));
			Logger.info("Error Displayed: "+errorMessage.getText());		

		}	


		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description this method returns the bu for the requested order line
	 * @param insertionNumber
	 */
	public String getBUOnInsertion(int insertionNumber) throws Exception
	{
		try
		{
			//WebElement buElement = driver.findElement(By.xpath("//div[text()='0"+insertionNumber+"-00']/../../../td[4]//span"));
			WebElement buElement = driver.findElement(By.xpath("//tbody["+insertionNumber+"]/tr[1]/td[3]/following::span[1]"));
			String buOnInsertion = buElement.getText();
			return buOnInsertion;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description this method returns the pub date for the requested order line
	 * @param insertionNumber
	 */
	public String getPubDateOnInsertion(int insertionNumber) throws Exception
	{
		try
		{
			//WebElement pubDateElement = driver.findElement(By.xpath("//div[text()='0"+insertionNumber+"-00']/../../../td[5]//span[2]"));
			WebElement pubDateElement = driver.findElement(By.xpath("//tbody["+insertionNumber+"]/tr[1]/td[5]/div[1]/span[1]/span[1]"));
			String pubDateOnInsertion = pubDateElement.getText();
			return pubDateOnInsertion;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public String getPubDateOnInsertionVersion(int insertionNumber) throws Exception
	{
		try
		{
			WebElement pubDateElement = driver.findElement(By.xpath("(//div[text()='0"+insertionNumber+"-01']/../../../td[5]//span/span)[1]"));
			String pubDateOnInsertion = pubDateElement.getText();
			Logger.info("Pub Date for version is :" +pubDateOnInsertion);
			return pubDateOnInsertion;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description this method returns the product type for the requested order line
	 * @param insertionNumber
	 */
	public String getProductTypeOnInsertion(int insertionNumber) throws Exception
	{
		try
		{
			//WebElement productTypeElement = driver.findElement(By.xpath("//div[text()='0"+insertionNumber+"-00']/../../../td[6]//span"));
			WebElement productTypeElement = driver.findElement(By.xpath("//tbody["+insertionNumber+"]/tr[1]/td[5]/following::span[1]"));
			String productTypeOnInsertion = productTypeElement.getText();
			return productTypeOnInsertion;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description this method returns the product for the requested order line
	 * @param insertionNumber
	 */
	public String getProductOnInsertion(int insertionNumber) throws Exception
	{
		try
		{
			//WebElement productElement = driver.findElement(By.xpath("//div[text()='0"+insertionNumber+"-00']/../../../td[7]//span"));
			WebElement productElement = driver.findElement(By.xpath("//tbody["+insertionNumber+"]/tr[1]/td[6]/following::span[1]"));
			String productOnInsertion = productElement.getText();
			return productOnInsertion;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public String getProductOnInsertionNewVersion(int insertionNumber) throws Exception
	{
		try
		{
			WebElement productElement = driver.findElement(By.xpath("//div[text()='0"+insertionNumber+"-01']/../../../td[7]//span"));
			String productOnInsertion = productElement.getText();
			return productOnInsertion;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description this method returns the Adtype for the requested order line
	 * @param insertionNumber
	 */
	public String getAdTypeOnInsertion(int insertionNumber) throws Exception
	{
		try
		{
			//WebElement adTypeElement = driver.findElement(By.xpath("//div[text()='0"+insertionNumber+"-00']/../../../td[8]//span"));
			WebElement adTypeElement = driver.findElement(By.xpath("//tbody["+insertionNumber+"]/tr[1]/td[7]/following::span[1]"));
			String adTypeOnInsertion = adTypeElement.getText();
			return adTypeOnInsertion;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description this method returns the section for the requested order line
	 * @param insertionNumber
	 */
	public String getSectionOnInsertion(int insertionNumber) throws Exception
	{
		try
		{
			//WebElement sectionElement = driver.findElement(By.xpath("//div[text()='0"+insertionNumber+"-00']/../../../td[10]//span"));
			WebElement sectionElement = driver.findElement(By.xpath("//tbody["+insertionNumber+"]/tr[1]/td[8]/following::span[1]"));
			String sectionOnInsertion = sectionElement.getText();
			return sectionOnInsertion;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method clicks on save package button
	 */
	public void clickOnSavePackage() throws Exception
	{ ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", packageButton);
	try{
		packageButton.click();
		Logger.info("Package button is clicked");
		Thread.sleep(3000);
		savePackageButton.click();
		Logger.info("Save package button is clicked");
		Thread.sleep(3000);
	}
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
	}
	

	/**
	 * @description This method checks if save package option is available under Package button
	 */
	public boolean checkVisibilityOfSavePackage() throws Exception
	{ ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", packageButton);
	try
	{
		packageButton.click();
		Logger.info("Package button is clicked");
		Thread.sleep(3000);
		if(savePackageButton.isDisplayed())
		{
			return true;
		}
		else{
			return false;
		}
	}
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
	}

	/**
	 * @description This method checks if load package option is available under Package button
	 */
	public boolean checkVisibilityOfLoadPackage() throws Exception
	{((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", packageButton);
	try
	{
		packageButton.click();
		Logger.info("Package button is clicked");
		Thread.sleep(3000);
		if(loadPackageButton.isDisplayed())
		{
			return true;
		}
		else{
			return false;
		}
	}
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
	}

	/**
	 * @description This method clicks on load package button
	 */
	public void clickOnLoadPackage() throws Exception
	{((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", packageButton);
	try{
		packageButton.click();
		Logger.info("Package button is clicked");
		Thread.sleep(3000);
		loadPackageButton.click();
		Logger.info("Load package button is clicked");
	}
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
	}

	/**
	 * @description This method enters package name for a new package creation and returns the package name entered
	 * It enters the package name depending on the request from the user (if user wanted unique name or provide any name from user's end)
	 * Parameter pkgName takes  two values
	 *   - unique (this will create a unique name by the system)
	 *   - another other name given by the user
	 */
	public String enterPackageName(String pkgName) throws Exception
	{
		try{
			packageNameTextBox.click();
			Logger.info("Package name text box is clicked");
			String packageName = "";
			if(pkgName.equalsIgnoreCase("unique"))
			{
				packageName = "AutomationTestPkg_"+utils.generateRandomAlphaNumString(6);
				packageNameTextBox.clear();
				packageNameTextBox.sendKeys(packageName);
			}
			else
			{
				packageNameTextBox.clear();
				packageNameTextBox.sendKeys(pkgName);
			}
			Logger.info(packageName+ " package name is entered");
			return packageName;

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void  selectPackageBU(String value) throws Exception
	{
		try
		{

			WebElement buList = driver.findElement(By.xpath("//select[@name='BusinessUnitID']"));
			Select selectBU = new Select(buList);
			List<WebElement> listOfValuesBU = selectBU.getOptions();
			if(listOfValuesBU.size() !=0)
			{
				selectBU.selectByVisibleText(value);
				Logger.info(value+" business Unit is selected"); 
			}
			else
			{
				Logger.info("drop down is empty");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method enters package description for a new package creation
	 */
	public void enterPackageDescription() throws Exception
	{
		try{
			packageDescription.click();
			Logger.info("Package description text box is clicked");
			packageDescription.sendKeys("TestPkgDesc_"+utils.generateRandomAlphaNumString(10));
			Logger.info("package description is entered");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	/**
	 * @description This method enters package effective from date for a new package creation
	 */

	public void enterPackageEffectiveFromDate(int mm, int dd, int yyyy) throws Exception
	{
		try{
			packageEffectiveFromDate.click();
			packageEffectiveFromDate.sendKeys(mm+"/"+dd+"/"+yyyy);
			packageEffectiveFromDate.sendKeys(Keys.CONTROL, "a");
			packageEffectiveFromDate.sendKeys(Keys.CONTROL, "\b");
			Thread.sleep(2000);

			packageEffectiveFromDate.sendKeys(mm+"/"+dd+"/"+yyyy);
			Thread.sleep(2000);
			Logger.info("package effective from date is entered");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void  selectBUpackage(String value) throws Exception
	{
		try
		{

			WebElement buList = driver.findElement(By.xpath("//select[@ng-model='vm.package.BusinessUnitID']"));
			Select selectBU = new Select(buList);
			List<WebElement> listOfValuesBU = selectBU.getOptions();
			if(listOfValuesBU.size() !=0)
			{
				selectBU.selectByVisibleText(value);
				Logger.info(value+" business Unit is selected"); 
			}
			else
			{
				Logger.info("drop down is empty");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method enters package effective to date for a new package creation
	 */
	public void enterPackageEffectiveToDate(int mm, int dd, int yyyy) throws Exception
	{
		try{
			packageEffectiveToDate.click();
			packageEffectiveToDate.sendKeys(mm+"/"+dd+"/"+yyyy);
			Thread.sleep(2000);
			packageEffectiveToDate.sendKeys(Keys.CONTROL, "a");
			packageEffectiveToDate.sendKeys(Keys.CONTROL, "\b");
			Thread.sleep(2000);
			packageEffectiveToDate.sendKeys(mm+"/"+dd+"/"+yyyy);
			Logger.info("package effective to date is entered");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method clicks on create package button
	 */
	public void clickOnCreatePackage() throws Exception
	{((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", createPackageButton);
	try{
		createPackageButton.click();
		Logger.info("Create Package button is clicked");
	}
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	} 
	}

	/**
	 * @description This method clicks on cancel package button
	 */
	public void clickOnCancelPackage(String packageName) throws Exception
	{
		try{
			WebElement cancelPackage = driver.findElement(By.xpath("//h3[text()='"+packageName+"']/../..//button[text()='Cancel']"));
			cancelPackage.click();
			Logger.info("Cancel Package button is clicked");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method clicks on update package tab
	 */
	public void clickOnUpdatePackageTab() throws Exception
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", updatePackageTab);
		try{
			updatePackageTab.click();
			Logger.info("Update Package tab is clicked");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method clicks on update package button
	 */
	public void clickOnUpdatePackageButton() throws Exception
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", updatePackageButton);
		try{
			updatePackageButton.click();
			Logger.info("Update Package button is clicked");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method clicks on replace existing orderlines checkbox in load package window
	 */
	public void clickOnReplaceExistingInsertionsLoadPkg() throws Exception
	{
		try
		{
			replaceExistingInsertionsLoadPkg.click();
			Logger.info("replace existing package is clicked");
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description this method returns a boolean value after checking for the package name, effective from date 
	 * and effective to date given in the new package against the load package window
	 * @param packageName, effectiveFromDate(format - mm/dd/yyyy), effectiveToDate(format - mm/dd/yyyy)
	 */
	public boolean newPackageValidationInLoadPkg(String packageName, String effectiveFromDate, String effectiveToDate ) throws Exception
	{
		try{
			WebElement packageNameElement = driver.findElement(By.xpath("//div[text()='"+packageName+"']"));
			boolean flag = false;
			if(packageNameElement.isDisplayed())
			{
				Logger.info("Package Name is Displayed as expected");
				WebElement packageEffectiveFrom = driver.findElement(By.xpath("//div[text()='"+packageName+"']/../..//div[text()='"+effectiveFromDate+"']"));
				if(packageEffectiveFrom.isDisplayed())
				{
					Logger.info("Package Effective From is Displayed as expected");
					WebElement packageEffectiveTo = driver.findElement(By.xpath("//div[text()='"+packageName+"']/../..//div[text()='"+effectiveToDate+"']"));
					if(packageEffectiveTo.isDisplayed()){
						Logger.info("Package Effective To is Displayed as expected");
						flag = true;
					}

				}
				return flag;
			}
			else{
				return flag;
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method is selects a package from load package window
	 * @param packageName
	 */
	public void selectPackageToLoad(String packageName) throws Exception
	{
		try
		{
			//  WebElement packageSelectionRadioButtn = driver.findElement(By.xpath("//td[text()='"+packageName+"']/..//i"));
			//  packageSelectionRadioButtn.click();
			validatePackageNameDescriptionFilter(packageName, "Name");//swagata
			/*
			 * WebElement packageNameElementParent =
			 * driver.findElement(By.xpath("//div[text()='"+packageName+"']/.."));
			 * 
			 * String packageNameElementId =
			 * packageNameElementParent.getAttribute("data-rowid");
			 * Logger.info("(//*[@data-rowid='"+packageNameElementId+
			 * "']/div)[1]/div/div/div"); WebElement packageSelectionRadioButtn =
			 * driver.findElement(By.xpath("(//*[@data-rowid='"+packageNameElementId+
			 * "'])[1]/div/div/div"));
			 *///swagata
			WebElement packageSelectionRadioButtn = driver.findElement(By.xpath("//div[@role='rowgroup']//div[@class='ui-grid-cell-contents ui-grid-disable-selection clickable ng-scope']"));//swagata


			packageSelectionRadioButtn.click();

			Logger.info("Package is selected in the load package window");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void validatePackageAvailableForBUFilter(String BU, String packageName) throws Exception
	{
		try
		{
			WebElement packageNameElementParent = driver.findElement(By.xpath("//div[text()='"+packageName+"']/.."));
			boolean flag1 = false;
			boolean flag2 = false;


			if (packageNameElementParent.isDisplayed())
			{
				flag1 = true;
				Logger.info(packageName+ " available when default filter ALL is applied");
			}

			WebElement buList = driver.findElement(By.xpath("//label[text()='Business Unit']/../select"));
			Select selectBU = new Select(buList);
			List<WebElement> listOfValuesBU = selectBU.getOptions();
			if(listOfValuesBU.size() !=0)
			{
				selectBU.selectByVisibleText(BU);
				Logger.info(BU+" business Unit is selected"); 
			}
			else
			{
				Logger.info("drop down is empty");
			}

			Thread.sleep(10000);

			if (packageNameElementParent.isDisplayed())
			{
				flag2 = true;
				Logger.info(packageName+ "  available when filter is applied as expected");
			}
			else
			{

				Logger.info(packageName+ " not available when filter is applied which is not expected");
			}
			Assert.assertEquals(flag1, true);
			Assert.assertEquals(flag2, true);
			Logger.info("BU Filter working as expected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	public void selectPackageToUpdate(String packageName) throws Exception
	{
		WebElement packageSelectionRadioButtn = driver.findElement(By.xpath("//td[text()='"+packageName+"']/..//i"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", packageSelectionRadioButtn);
		try
		{

			packageSelectionRadioButtn.click();


			Logger.info("Package is selected in the update package window");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method is clicks on cancel button in a load package window
	 */
	public void cancelPackageToLoad() throws Exception
	{
		try
		{
			cancelLoadPackageButton.click();
			Logger.info("cancel button on load package window is clicked");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method is clicks on load button in a load package window
	 */
	public void loadPackageInPackageLoadWindow() throws Exception
	{
		try
		{
			loadPackageButtonLoadWindow.click();
			Logger.info("load button on load package window is clicked");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method clicks on Replace button in the confirmation window to replace existing package
	 */
	public void clickOnPackageReplaceConfirmationBtn() throws Exception
	{
		try
		{
			replacePackageButtonConfirmationWindow.click();
			Logger.info("Replace package button in confirmation window is clicked");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method validates the error message displayed when a duplicate package name is given for a new package
	 * @param packageName
	 */
	public void duplicatePackageMessageValidation(String packageName) throws Exception
	{
		try
		{
			String expectedErrorMessage = "Package name "+packageName+" exists. Please choose a new name";
			List<WebElement> OopsErrorMessage = driver.findElements(By.xpath("//*[@id='toast-container']/div/div[3]/div"));
			ListIterator<WebElement> iterator = OopsErrorMessage.listIterator();//swagata
			while(iterator.hasNext()){
				WebElement errMsg = iterator.next();
				String actualErrMsg = errMsg.getText();
				if(actualErrMsg.equalsIgnoreCase(expectedErrorMessage)){
					Logger.info("Validation success - correct error message is displayed");
					Assert.assertEquals(expectedErrorMessage, actualErrMsg);
				}
				else{
					Assert.fail("Validation failed");
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
	 * @description this method clicks on bundle button
	 */
	public void clickOnBundleButton() throws Exception
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", bundleButton);
		try{
			bundleButton.click();
			Logger.info("bundle button is clicked");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @description this method select or deselects an insertion in an order
	 * @param insertionNumber
	 * @param value 
	 * @throws Exception
	 */
	public void selectDeSelectInsertion(int insertionNumber, boolean value) throws Exception
	{
		try{
			WebElement element = driver.findElement(By.xpath("//tbody["+insertionNumber+"]//input[@ng-model='vm.orderLine.selected']"));
			WebElement insertionSelectionCheckBox = driver.findElement(By.xpath("//tbody["+insertionNumber+"]//input[@ng-model='vm.orderLine.selected']/../i"));
			String elementClassName = element.getAttribute("class");
			if(value)
			{
				if(elementClassName.equalsIgnoreCase("ng-pristine ng-untouched ng-valid ng-empty"))
				{
					insertionSelectionCheckBox.click();
					Logger.info(insertionNumber+" Insertion is selected");
				}else{
					Logger.info(insertionNumber+" Insertion is already selected");
				}
			}
			else{
				if(elementClassName.equalsIgnoreCase("ng-pristine ng-untouched ng-valid ng-empty"))
				{
					Logger.info(insertionNumber+" Insertion is already deselected");
				}else{
					insertionSelectionCheckBox.click();
					Logger.info(insertionNumber+" Insertion is deselected");
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
	 * @description This method clicks on create bundle button
	 */
	public void clickOnCreateBundleButton() throws Exception
	{((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", createBundleButton);
	try{
		createBundleButton.click();
		Logger.info("create bundle button is clicked");
		Thread.sleep(2000);
	}
	catch(Exception e)
	{
		Logger.error(e.getMessage());
		throw e;
	}
	}

	/**
	 * @description This method checks if create bundle button is displayed
	 */
	public boolean checkVisibilityOfCreateBundleButton() throws Exception
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", bundleButton);
		try{
			bundleButton.click();
			Logger.info("bundle button is clicked");
			if(createBundleButton.isDisplayed())
			{
				Logger.info("create bundle button is displayed");
				return true;
			}
			else{
				Logger.info("create bundle button is not displayed");
				return false;
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @description This method enters bundle name for a new bundle creation and returns the bundle name entered
	 * It enters the bundle name depending on the request from the user (if user wanted unique name or provide any name from user's end)
	 * Parameter uniqueOrExistingBundleName takes  two values
	 *   - unique (this will create a unique name by the system)
	 *   - name given by the user
	 */
	public String enterBundleName(String uniqueOrExistingBundleName) throws Exception
	{
		try{
			bundleNameTextBox.click();
			Logger.info("Bundle name text box is clicked");
			String bundleName = "";
			if(uniqueOrExistingBundleName.equalsIgnoreCase("unique"))
			{
				bundleName = "TestAutomationBundle_"+utils.generateRandomAlphaNumString(6);
				bundleNameTextBox.clear();
				bundleNameTextBox.sendKeys(bundleName);
			}
			else
			{
				bundleNameTextBox.clear();
				bundleNameTextBox.sendKeys(uniqueOrExistingBundleName);
			}
			Logger.info(bundleName+ " bundle name is entered");
			return bundleName;

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method enters the bundle percentage and returns the entered percentage
	 * @param bundleDiscountPercentage
	 */
	public Double enterBundleDiscountPercent(double bundleDiscountPercentage) throws Exception
	{
		try{
			bundleDiscountPercentTextBox.click();
			Logger.info("bundle discount percentage text box is clicked");
			bundleDiscountPercentTextBox.clear();
			bundleDiscountPercentTextBox.sendKeys(""+bundleDiscountPercentage);
			Logger.info(bundleDiscountPercentage+ " bundle discount percentage is entered");
			return bundleDiscountPercentage;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method enters the bundle amount and returns the entered amount
	 * @param bundleDiscountAmount
	 */
	public Double enterBundleDiscountAmount(double bundleDiscountAmount) throws Exception
	{
		try{
			bundleDiscountAmtTextBox.click();
			Logger.info("bundle discount amount text box is clicked");
			bundleDiscountAmtTextBox.clear();
			bundleDiscountAmtTextBox.sendKeys(""+bundleDiscountAmount);
			Logger.info(bundleDiscountAmount+ " bundle discount amount is entered");
			return bundleDiscountAmount;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method clicks on save button in a new bundle creation window
	 */
	public void clickOnSaveBundle() throws Exception
	{
		try{
			saveBundleButton.click();
			Thread.sleep(2000);
			Logger.info("Bundle is saved");
		}
		catch(Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @description This method clicks on cancel button in a new bundle creation window
	 */
	public void clickOnCancelBundle() throws Exception
	{
		try{
			cancelBundleButton.click();
			Thread.sleep(2000);
			Logger.info("Creation of new bundle is cancelled");
		}
		catch(Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @description This method return the bundle name on the insertion specified
	 * @param insertionNumber
	 */
	public String getBundleNameOnInsertion(int insertionNumber) throws Exception
	{
		try{
			WebElement bundleLabelElement = driver.findElement(By.xpath("(//span[@title='bundle'])["+insertionNumber+"]"));
			return bundleLabelElement.getText();
		}
		catch(Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @description This method validates if the bundle label is visible on the insertions
	 */
	public boolean validateVisibilityOfBundleName(int insertionNumber) throws Exception
	{
		try{
			WebElement bundleLabelElement = driver.findElement(By.xpath("(//span[@title='bundle'])["+insertionNumber+"]"));
			if(bundleLabelElement.isDisplayed()){
				Logger.info("Bundle label is dispalyed for insertion "+insertionNumber);
				return true;
			}
			else{
				Logger.info("Bundle label is not dispalyed for insertion "+insertionNumber);
				return false;
			}
		}
		catch(Exception e) {
			return false;
		}	  
	}

	/**
	 * @description This method returns total bundle price
	 * @return bundlePrice
	 */
	public double getTotalBundlePrice() throws Exception
	{
		try{
			double bundlePrice = Double.parseDouble(totalBundlePrice.getAttribute("value"));
			return bundlePrice;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @description This method returns base price displayed in the bundle window
	 * @return totalBundleBasePrice
	 */
	public double getTotalBundleBasePrice() throws Exception
	{
		try{
			double totalBasePrice = Double.parseDouble(totalBundleBasePrice.getAttribute("value"));
			return totalBasePrice;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @description This method validates bundle discount amount
	 */
	public boolean validateBundleDiscountAmount() throws Exception
	{
		try
		{
			double actualDicountAmount = Double.parseDouble(bundleDiscountAmtTextBox.getAttribute("value"));
			double expectedDiscountAmountValue = Double.parseDouble(totalBundleBasePrice.getAttribute("value"))* (Double.parseDouble(bundleDiscountPercentTextBox.getAttribute("value"))/100);
			double expectedDiscountAmount = (double)Math.round(expectedDiscountAmountValue*100)/100;
			double decimalValue = (expectedDiscountAmount*10 - ((int)expectedDiscountAmount *10));
			if((int)decimalValue==99)
			{
				expectedDiscountAmount = expectedDiscountAmount+1;
			}
			if(expectedDiscountAmount==actualDicountAmount)
			{
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @description This method is used to validate the bundle price after applying bundle discount
	 * @throws Exception
	 */
	public boolean validateBundlePriceAfterDiscount(int numberOfInsertions) throws Exception
	{
		try{
			boolean flag1 = false;
			boolean flag2 = false;
			DecimalFormat df2 = new DecimalFormat("###.##");
			Logger.info("Total Bundle BasePrice = "+Double.parseDouble(totalBundleBasePrice.getAttribute("value")));
			double totalbundleBasePrice = Double.parseDouble(totalBundleBasePrice.getAttribute("value"));
			Logger.info("Bundle Discount Amount = "+Double.parseDouble(bundleDiscountAmtTextBox.getAttribute("value")));
			double  bundleDiscountAmount = Double.parseDouble(bundleDiscountAmtTextBox.getAttribute("value"));
			Logger.info("Total bundle price = "+totalBundlePrice.getAttribute("value"));
			double totalBundlePriceValue = Double.parseDouble(totalBundlePrice.getAttribute("value"));
			double expectedBundlePriceValidaion1 = totalbundleBasePrice - bundleDiscountAmount;
			double expectedBundlePriceValidaion2 = 0.0;
			List<WebElement> list = driver.findElements(By.xpath("//form[@name='vm.createbundle']/../div/table/tbody/tr/td[6]"));
			Iterator<WebElement> iterator = list.iterator();
			Logger.info("number of interations selected for bundling "+list.size());
			while(iterator.hasNext())
			{
				WebElement iterationPriceElement = iterator.next();
				String iterationPrice = iterationPriceElement.getText();
				Logger.info(iterationPrice);
				if(iterationPrice.contains(","))
				{
					iterationPrice = iterationPrice.replace(",", "");
				}
				expectedBundlePriceValidaion2 = expectedBundlePriceValidaion2 + Double.parseDouble(iterationPrice.substring(1));
			}
			if(Double.parseDouble(df2.format(expectedBundlePriceValidaion1))==totalBundlePriceValue)
			{
				flag1 = true;
				Logger.info("1st logic : bundle price = bundle base price - bundle discount amount");
				if(expectedBundlePriceValidaion2==totalBundlePriceValue)
				{
					flag2 = true;				 
					Logger.info("2nd Logic : bundle price = sum of all the insertion prices selected for bundling");
				}
			}
			return flag2;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method returns the base price of a particular insertion in the bundle window
	 * @param insertionNumber
	 * @return base price of the specified insertion in the bundle window
	 */
	public Double getBundleInsertionBasePrice(int insertionNumber) throws Exception
	{
		try{
			WebElement bundleInsertionBasePriceElement = driver.findElement(By.xpath("//form[@name='vm.createbundle']/../div/table/tbody/tr["+insertionNumber+"]/td[5]"));
			String insertionPrice = bundleInsertionBasePriceElement.getText();
			if(insertionPrice.contains(","))
			{
				insertionPrice = insertionPrice.replace(",", "");
			}
			return Double.parseDouble(insertionPrice.substring(1));
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method returns the bundle price of a particular insertion in the bundle window
	 * @param insertionNumber
	 * @return bundle price of the specified insertion in the bundle window
	 */
	public Double getBundleInsertionBundlePrice(int insertionNumber) throws Exception
	{
		try{
			WebElement bundleInsertionBundlePriceElement = driver.findElement(By.xpath("//form[@name='vm.createbundle']/../div/table/tbody/tr["+insertionNumber+"]/td[6]"));
			String bundlePrice = bundleInsertionBundlePriceElement.getText();
			if(bundlePrice.contains(","))
			{
				bundlePrice = bundlePrice.replace(",", "");
			}
			return Double.parseDouble(bundlePrice.substring(1));
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	/**
	 * @description This method clicks on clear bundle button
	 */
	public void clickOnClearBundleButton() throws Exception
	{
		try{
			clearBundleButton.click();
			Logger.info("Clear bundle button is clicked");
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @description This method clicks on clear bundle button
	 */
	public void clickOnBundleClearOkButton() throws Exception
	{
		try{
			okButton.click();
			Logger.info("ok button to confirm bundle clearing is clicked");
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @description This method checks if clear bundle button is displayed
	 */
	public boolean checkVisibilityOfClearBundleButton() throws Exception
	{
		try{
			bundleButton.click();
			Logger.info("bundle button is clicked");
			if(clearBundleButton.isDisplayed())
			{
				Logger.info("clear bundle button is displayed");
				return true;
			}
			else{
				Logger.info("clear bundle button is not displayed");
				return false;
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//validate primary sales person
	public void validatePrimarySalesPerson(String salesPersonEmpNumber) throws Exception
	{
		try{
			List<WebElement> salesPerson = driver.findElements(By.xpath("//tr[@ng-repeat='salesperson in vm.order.SalesPersonList']/td[1]"));
			Iterator<WebElement> iterator = salesPerson.iterator();
			while(iterator.hasNext())
			{
				WebElement salesPersonElement = iterator.next();
				String salesPersonName = salesPersonElement.getText();
				int index = salesPersonName.lastIndexOf("SA");
				String actualSalesPerson = salesPersonName.substring(index,salesPersonName.length() );
				if(actualSalesPerson.equalsIgnoreCase(salesPersonEmpNumber))
				{
					WebElement primaryLink = driver.findElement(By.xpath("//div[contains(text(),'"+salesPersonEmpNumber+"')]/..//a/span/i"));
					String primaryCriteria = primaryLink.getAttribute("class");
					if(primaryCriteria.equalsIgnoreCase("fa  fa-star selected")){
						Logger.info("Sales person with num "+salesPersonEmpNumber+" is updated as primary");
					}
				}
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to compare the error message generated when there us only a single error for a single insertion
	public void compareErrorMessageSingleErr(Map<String,String> userData, String errorCondition) throws Exception
	{
		try{
			String expectedErrMsg = userData.get(errorCondition);
			if(errorMessage.size()>0){
				ListIterator<WebElement> iterator = errorMessage.listIterator();
				while(iterator.hasNext()){
					WebElement errMsg = iterator.next();
					String actualErrMsg = errMsg.getText();
					if(actualErrMsg.equalsIgnoreCase(expectedErrMsg)){
						Logger.info("Validation success - correct error message is displayed");
					}
					else{
						Logger.error("Validation failed");
					}
				}
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	//code to compare the error message generated when there us only a single error for a single insertion
	public void compareErrorMessageMultiple(String expectedErrMsg, int index) throws Exception
	{
		WebElement errorMessage = driver.findElement(By.xpath("//section[@class='panel-body accordion-body ng-scope']/p["+index+"]/strong"));
		try{
			if(errorMessage.isDisplayed()){

				String actualErrMsg = errorMessage.getText();

				Assert.assertEquals(expectedErrMsg, actualErrMsg);

				Logger.info("Validation success - correct error message is displayed");

			}


		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void displayWarningMsg() throws Exception
	{
		WebElement errorMessage = driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div"));
		try{
			if(errorMessage.isDisplayed()){

				String actualErrMsg = errorMessage.getText();
				Logger.info("Warning Msg : "+actualErrMsg);
				String text ="";
				if(driver.getPageSource().contains("Your order contains one or more insertions that match auto insertion rules."))
				{
					Logger.info("Confirmation window is displayed requesting the user to either accept or reject the creation of legacy auto insertion");
					rejectLegacyAutoInsertion.click();
					text = displayMsg.getText();
					Logger.info("Message is displayed in the pop up: " + text);
					Logger.info("'No' is clicked in confirmation window");
					Logger.info("Order is submitted successfully");
				}//swagata
				else {
					Logger.info("Confirmation window is displayed requesting the user to either accept or reject the creation of legacy auto insertion");

				}//swagata


			}


		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void compareErrorMessage(String expectedErrMsg) throws Exception
	{
		try{

			if(errorMessage.size()>0){
				ListIterator<WebElement> iterator = errorMessage.listIterator();
				while(iterator.hasNext()){
					WebElement errMsg = iterator.next();
					String actualErrMsg = errMsg.getText();
					if(expectedErrMsg == actualErrMsg)
					{
						Logger.info("Validation success - correct error message is displayed");
					}
				}
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//code to compare the error message generated when there us only a single error for a single insertion
	public void comparePartialMessage(String expectedErrMsg) throws Exception
	{
		try{

			if(errorMessage.size()>0){
				ListIterator<WebElement> iterator = errorMessage.listIterator();
				while(iterator.hasNext()){
					WebElement errMsg = iterator.next();
					String actualErrMsg = errMsg.getText();
					boolean flag1 = false;
					if( actualErrMsg.contains(expectedErrMsg))
					{
						flag1 = true;

					}
					Assert.assertEquals(flag1, true);

					Logger.info("Validation success - correct message displayed : "+actualErrMsg);

				}
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	//this method is to check or uncheck change history checkbox
	public void checkUncheckChangeHistoryCheckBox(boolean value) throws Exception
	{
		try
		{
			String selectionStatus = "";
			WebElement element = driver.findElement(By.xpath("//input[@ng-model='displayChangeHistory']"));
			if(value)
			{
				selectionStatus = element.getAttribute("aria-checked");
				Logger.info("selectionStatus "+selectionStatus);
				if(selectionStatus.equalsIgnoreCase("true"))
				{
					Logger.info("Change history checkbox is already selected");
				}
				else{
					checkToChangeHistoryCheckBox.click();
					Logger.info("Change history checkbox is selected");
				}
			}
			else{
				if(selectionStatus.equalsIgnoreCase("true"))
				{
					checkToChangeHistoryCheckBox.click();
					Logger.info("Change history checkbox is deselected");
				}
				else{
					Logger.info("Change history checkbox is already deselected");
				}
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	//code to compare the error message generated when there us only a single error for a single insertion
	public boolean compareErrorMsgMultiErr(String[] errorCondition) throws Exception
	{
		try{
			boolean flag = false;
			if(errorMessage.size()>0){

				for (int i=0;i<errorCondition.length; i++) {
					flag = false;
					ListIterator<WebElement> iterator = errorMessage.listIterator();
					while(iterator.hasNext()){
						WebElement errMsg = iterator.next();
						String expectedErrMsg = errorCondition[i];
						String actualErrMsg = errMsg.getText();
						if(actualErrMsg.contains(expectedErrMsg)){
							flag = true;
							Logger.info("Validation success - correct error message is displayed");
							break;
						}
					}
					if (!flag) {
						return false;
					}
				}
			}
			return flag;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void continueWithProvidedAddress() throws Exception
	{
		if(continueButton.isDisplayed()) 
		{
			continueButton.click();
		}
	}
	public void confirmProvidedAddress() throws Exception
	{
		if(confirmButton.isDisplayed()) 
		{
			confirmButton.click();
		}
	}

	public void clickCopyOrder() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);//swagata
		Logger.info("START OF COPY ORDER");//swagata
		wait.until(ExpectedConditions.elementToBeClickable(copyOrder));//swagata
		if(copyOrder.isDisplayed()) 
		{
			copyOrder.click();
		}
	}

	public void enterAchBankAccountInfoOrder(String sheetName) throws Exception
	{

		try{

			if (accountACH.isDisplayed())
			{
				accountACH.click();
				accountACH.clear();
				accountACH.sendKeys(System.getProperty("ACHaccount"));
				Logger.info("account is entered");
			}

			if (routingACH.isDisplayed())
			{Logger.info("INSIDE accountACH2");
			routingACH.click();
			routingACH.clear();
			routingACH.sendKeys(System.getProperty("ACHrouting"));
			Logger.info("routing is entered");
			}

			if (accountTypeACH.isDisplayed())
			{Logger.info("INSIDE accountACH3");
			accountTypeACH.click();
			Select valueFromBU = new Select(accountTypeACH);
			List<WebElement> listOfValuesBU = valueFromBU.getOptions();
			if(listOfValuesBU.size() !=0)
			{
				valueFromBU.selectByVisibleText((TribuneUtils.getStringCellValues(sheetName, 1, 4)));
				Logger.info("account type is selected"); 
			}
			}

			if (firstNameACH.isDisplayed())
			{Logger.info("INSIDE accountACH4");
			firstNameACH.click();
			firstNameACH.clear();
			firstNameACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 0));
			Logger.info("first name is entered");
			}
			if (lastNameACH.isDisplayed())
			{Logger.info("INSIDE accountACH5");
			lastNameACH.click();
			lastNameACH.clear();
			lastNameACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 1));
			Logger.info("last name is entered");
			}
			if (addressACH.isDisplayed())
			{Logger.info("INSIDE accountACH6");
			addressACH.click();
			addressACH.clear();
			addressACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 5));
			Logger.info("address is entered");
			}
			if (cityACH.isDisplayed())
			{Logger.info("INSIDE accountACH7");
			cityACH.click();
			cityACH.clear();
			cityACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 6));
			Logger.info("city is entered");
			}
			if (stateACH.isDisplayed())
			{Logger.info("INSIDE accountACH8");
			stateACH.click();
			stateACH.clear();
			stateACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 7));
			Logger.info("state is entered");
			} 
			if (zipACH.isDisplayed())
			{Logger.info("INSIDE accountACH9");
			zipACH.click();
			zipACH.clear();
			zipACH.sendKeys(""+TribuneUtils.getIntCellValues(sheetName, 1, 8));
			Logger.info("zip is entered");
			}
			if (countryACH.isDisplayed())
			{Logger.info("INSIDE accountACH10");
			countryACH.click();
			countryACH.clear();
			countryACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 9));
			Logger.info("country is entered");
			}
			if (emailACH.isDisplayed())
			{Logger.info("INSIDE accountACH11");
			emailACH.click();
			emailACH.clear();
			emailACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 10));
			Logger.info("email is entered");
			} 
			if (phoneACH.isDisplayed())
			{Logger.info("INSIDE accountACH12");
			phoneACH.click();
			phoneACH.clear();
			phoneACH.sendKeys(""+TribuneUtils.getIntCellValues(sheetName, 1, 11));
			Logger.info("phone is entered");
			}
			if (saveBtnACH.isDisplayed())
			{Logger.info("INSIDE accountACH13");
			saveBtnACH.click();
			Logger.info("Details Saved");
			}
			Thread.sleep(4000);


		}
		catch(Exception e)
		{Logger.info("Exception:"+e.toString());
		Logger.error(e.getMessage());
		throw e;
		}
	}
	public void enterCreditCardInfoOrder(String sheetName) throws Exception
	{

		try{

			if (creditCardNumber.isDisplayed())
			{
				creditCardNumber.click();
				creditCardNumber.clear();
				creditCardNumber.sendKeys(System.getProperty("CreditCardNo"));
				Logger.info("creditCardNumber is entered");
			}
			/*  
		  if (cVV.isDisplayed())
		  {
			  cVV.click();
			  cVV.clear();
			  cVV.sendKeys(System.getProperty("cVV"));
			  Logger.info("cVV is entered");
		  }
			 */
			if (expiryMonth.isDisplayed())
			{
				expiryMonth.click();
				Select valueFromBU = new Select(expiryMonth);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					valueFromBU.selectByVisibleText(System.getProperty("expiryMonth"));
					Logger.info("expiry Month is selected"); 
				}
			}

			if (expiryYear.isDisplayed())
			{
				expiryYear.click();
				Select valueFromBU = new Select(expiryYear);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					valueFromBU.selectByVisibleText(System.getProperty("expiryYear"));
					Logger.info("expiry Year is selected"); 
				}
			}

			if (firstNameACH.isDisplayed())
			{
				firstNameACH.click();
				firstNameACH.clear();
				firstNameACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 0));
				Logger.info("first name is entered");
			}
			if (lastNameACH.isDisplayed())
			{
				lastNameACH.click();
				lastNameACH.clear();
				lastNameACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 1));
				Logger.info("last name is entered");
			}
			if (addressACH.isDisplayed())
			{
				addressACH.click();
				addressACH.clear();
				addressACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 5));
				Logger.info("address is entered");
			}
			if (cityACH.isDisplayed())
			{
				cityACH.click();
				cityACH.clear();
				cityACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 6));
				Logger.info("city is entered");
			}
			if (stateACH.isDisplayed())
			{
				stateACH.click();
				stateACH.clear();
				stateACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 7));
				Logger.info("state is entered");
			} 
			if (zipACH.isDisplayed())
			{
				zipACH.click();
				zipACH.clear();
				zipACH.sendKeys(""+TribuneUtils.getIntCellValues(sheetName, 1, 8));
				Logger.info("zip is entered");
			}
			if (countryACH.isDisplayed())
			{
				countryACH.click();
				countryACH.clear();
				countryACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 9));
				Logger.info("country is entered");
			}
			if (emailACH.isDisplayed())
			{
				emailACH.click();
				emailACH.clear();
				emailACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 10));
				Logger.info("email is entered");
			} 
			if (phoneACH.isDisplayed())
			{
				phoneACH.click();
				phoneACH.clear();
				phoneACH.sendKeys(""+TribuneUtils.getIntCellValues(sheetName, 1, 11));
				Logger.info("phone is entered");
			}
			/*  if (saveBtnACH.isDisplayed())
		  {
			  saveBtnACH.click();
		  }
		  Thread.sleep(4000);
			 */

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}
	/**
	 * @param insertionIndex and class code written by payel
	 * @description This method is used to select non template position code for a specific insertion
	 */
	public void selectNontemplatepositionForAnInsertion(int insertionIndex, String template) throws Exception
	{
		try{

			WebElement templateEdit = driver.findElement(By.xpath("//div/div/a/span[@title='Click to edit' and @id='Span5']"));
			//WebElement colourEdit = driver.findElement(By.xpath("(//label[contains(text(),'Color & Spot')]/..//span//span"));
			templateEdit.click();
			Logger.info("non template element is clicked");
			WebElement templateTypeDrpDwn = driver.findElement(By.xpath("//div/div/a/span[@title='Click to edit' and @id='Span5']/../../form/div/select"));
			Select selecttemplateType = new Select(templateTypeDrpDwn);
			selecttemplateType.selectByVisibleText(template);			
			Logger.info(template +" template is selected ");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void enterCreditCardInfoDigitalOrder(String sheetName) throws Exception
	{

		try{

			if (creditCardNumber.isDisplayed())
			{
				creditCardNumber.click();
				creditCardNumber.clear();
				creditCardNumber.sendKeys(System.getProperty("CreditCardNo"));
				Logger.info("creditCardNumber is entered");
			}
			/*  
		  if (cVV.isDisplayed())
		  {
			  cVV.click();
			  cVV.clear();
			  cVV.sendKeys(System.getProperty("cVV"));
			  Logger.info("cVV is entered");
		  }
			 */
			if (expiryMonth.isDisplayed())
			{
				expiryMonth.click();
				Select valueFromBU = new Select(expiryMonth);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					valueFromBU.selectByVisibleText(System.getProperty("expiryMonth"));
					Logger.info("expiry Month is selected"); 
				}
			}

			if (expiryYear.isDisplayed())
			{
				expiryYear.click();
				Select valueFromBU = new Select(expiryYear);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					valueFromBU.selectByVisibleText(System.getProperty("expiryYear"));
					Logger.info("expiry Year is selected"); 
				}
			}

			if (firstNameACH.isDisplayed())
			{
				firstNameACH.click();
				firstNameACH.clear();
				firstNameACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 0));
				Logger.info("first name is entered");
			}
			if (lastNameACH.isDisplayed())
			{
				lastNameACH.click();
				lastNameACH.clear();
				lastNameACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 1));
				Logger.info("last name is entered");
			}
			if (addressACH.isDisplayed())
			{
				addressACH.click();
				addressACH.clear();
				addressACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 5));
				Logger.info("address is entered");
			}
			if (cityACH.isDisplayed())
			{
				cityACH.click();
				cityACH.clear();
				cityACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 6));
				Logger.info("city is entered");
			}
			if (stateACH.isDisplayed())
			{
				stateACH.click();
				stateACH.clear();
				stateACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 7));
				Logger.info("state is entered");
			} 
			if (zipACH.isDisplayed())
			{
				zipACH.click();
				zipACH.clear();
				zipACH.sendKeys(""+TribuneUtils.getIntCellValues(sheetName, 1, 8));
				Logger.info("zip is entered");
			}
			if (countryACH.isDisplayed())
			{
				countryACH.click();
				countryACH.clear();
				countryACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 9));
				Logger.info("country is entered");
			}
			if (emailACH.isDisplayed())
			{
				emailACH.click();
				emailACH.clear();
				emailACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 10));
				Logger.info("email is entered");
			} 
			if (phoneACH.isDisplayed())
			{
				phoneACH.click();
				phoneACH.clear();
				phoneACH.sendKeys(""+TribuneUtils.getIntCellValues(sheetName, 1, 11));
				Logger.info("phone is entered");
			}


		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}


	/**
	 * @param insertionIndex and class code
	 * @description This method is used to select colour code for a specific insertion
	 */
	public void selectColourForAnInsertion(int insertionIndex, String colour) throws Exception
	{
		try{
			WebElement colourEdit = driver.findElement(By.xpath("(//label[contains(text(),'Color & Spot')]/..//span[@id='Span4']/span)"));
			colourEdit.click();
			Logger.info("Colour element is clicked");
			WebElement colourTypeDrpDwn = driver.findElement(By.xpath("//label[contains(text(),'Color & Spot')]/../div/div/div[1]/form/div/select"));
			Select selectColourType = new Select(colourTypeDrpDwn);
			selectColourType.selectByVisibleText(colour);			
			Logger.info(colour +" colour is selected ");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public String getColourForAnInsertion(int insertionIndex) throws Exception
	{
		try{
			WebElement colourEdit = driver.findElement(By.xpath("(//label[contains(text(),'Color & Spot')]/..//span[@id='Span4']/span)["+insertionIndex+"]"));

			colourEdit.click();
			Logger.info("Colour element is clicked");

			Thread.sleep(2000);
			WebElement colourTypeDrpDwn = driver.findElement(By.xpath("//label[contains(text(),'Color & Spot')]/../div/div/div[1]/form/div/select/option[@selected='selected']"));			

			String colour = colourTypeDrpDwn.getText();
			Logger.info(colour +" colour is selected ");
			return colour;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public String getProgramPriceRateForAnInsertion(int insertionIndex) throws Exception
	{
		try{
			WebElement colourEdit = driver.findElement(By.xpath("(//label[text()='Program Price / Rate ']/../div[2]/span[2]/span)["+insertionIndex+"]"));

			String colour = colourEdit.getText();
			Logger.info(colour +" is Program Price Rate ");
			return colour;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public String getProgramPriceForAnInsertionDisplay(int insertionIndex) throws Exception
	{
		try{
			WebElement colourEdit = driver.findElement(By.xpath("(//label[text()='Program Price ']/../div/a/span/span[1])["+insertionIndex+"]"));

			String colour = colourEdit.getText();
			Logger.info(colour +" is Program Price ");
			return colour;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public String getProgramPriceForAnInsertion(int insertionIndex) throws Exception
	{
		try{
			WebElement colourEdit = driver.findElement(By.xpath("(//label[text()='Program Price / Rate ']/../div[2]/a/span/span[1])["+insertionIndex+"]"));

			String colour = colourEdit.getText();
			Logger.info(colour +" is Program Price ");
			return colour;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public String getProgramPriceForAnInsertionPreprint(int insertionIndex) throws Exception
	{
		try{
			WebElement colourEdit = driver.findElement(By.xpath("(//label[text()='Program Price / Rate']/../div/a/span/span[1])["+insertionIndex+"]"));

			String colour = colourEdit.getText();
			Logger.info(colour +" is Program Price ");
			return colour;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	public void selectProgramPriceForAnInsertion(int insertionIndex, String price) throws Exception
	{
		try{
			WebElement colourEdit = driver.findElement(By.xpath("//label[contains(text(),'Program Price')]/../..//*[@id='Span8']/span"));
			colourEdit.click();
			Logger.info("Program Price element is clicked");
			WebElement colourTypeDrpDwn = driver.findElement(By.xpath("//label[contains(text(),'Program Price')]/../../div[3]/div/form/div/select"));
			Select selectColourType = new Select(colourTypeDrpDwn);
			selectColourType.selectByVisibleText(price);			
			Logger.info(price +" program price is selected ");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void selectColourForAnInsertionAltDig(int insertionIndex, String colour) throws Exception
	{
		try{
			WebElement colourEdit = driver.findElement(By.xpath("(//label[contains(text(),'Color')]/..//span[@id='Span4']/span)"));
			colourEdit.click();
			Logger.info("Colour element is clicked");
			WebElement colourTypeDrpDwn = driver.findElement(By.xpath("//label[contains(text(),'Color')]/../div/form/div/select"));
			Select selectColourType = new Select(colourTypeDrpDwn);
			selectColourType.selectByVisibleText(colour);			
			Logger.info(colour +" colour is selected ");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//code to get the colour
	public String getValueofSelectedColourOption(int insertionIndex) throws Exception
	{
		WebElement colourEdit = driver.findElement(By.xpath("//label[contains(text(),'Color & Spot')]/..//span[@id='Span4']/span"));
		colourEdit.click();
		Logger.info("Colour element is clicked");
		String colour;
		WebElement colourElement = driver.findElement(By.xpath("//label[contains(text(),'Color & Spot')]/..//option[@selected='selected']"));
		colour = colourElement.getText();
		return colour;
	}

	public String getValueofSelectedColourOptionOnline(int insertionIndex) throws Exception
	{
		WebElement colourEdit = driver.findElement(By.xpath("(//label[contains(text(),'Color')]/..//span[@id='Span4']/span)["+insertionIndex+"]"));
		colourEdit.click();
		Logger.info("Colour element is clicked");
		String colour;
		WebElement colourElement = driver.findElement(By.xpath("//label[contains(text(),'Color')]/..//option[@selected='selected']"));
		colour = colourElement.getText();
		return colour;
	}

	/**
	 * @author Ritoban
	 * @param insertionIndex
	 * @description This method is used to click on APPLY TO ALL INSERTIONS in SALES REP section
	 */
	public void clickonApplyAllInsertions() throws Exception
	{
		try{
			Thread.sleep(4000); 

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

			Thread.sleep(4000); 
			WebElement allsalesrepcheckbox = driver.findElement(By.xpath(".//*[@id='order-detail-page']/div[2]/div[1]/div[2]/div/form/div[2]/div[3]/label/i"));
			if(!(allsalesrepcheckbox.isSelected())){
				allsalesrepcheckbox.click();
				Logger.info("Sales Rep check box is checked");
			}else
				Logger.info("Sales Rep check box is already checked");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	public String getExternalReferenceValue() throws Exception
	{
		try{
			String externalRefVal = externalReferenceValue.getAttribute("innerText");
			Logger.info("External Reference Value: "+externalRefVal);
			return externalRefVal;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}


	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void uploadDoc(String insertionIndex,int row, int col) throws Exception
	{
		try
		{
			String filename = TribuneUtils.getStringCellValues("DigitalOrder",row, col);
			Logger.info("filename:"+filename);
			String pathForImage = System.getProperty("user.dir")+ "\\ClassfiedFile\\"+filename;
			Thread.sleep(4000);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

			Thread.sleep(4000); 

			if (DocumentsTab.isDisplayed())
			{
				DocumentsTab.click();
				Logger.info("Documents Tab is clicked");
			}else{
				Logger.info("Document tab is not available");
				throw new NoSuchElementException("Document is not uploaded");
			}

			Thread.sleep(4000);
			if (UploadDocBtn.isDisplayed())
			{
				UploadDocBtn.click();
				Thread.sleep(2000);
				Logger.info("Upload Doc Button is clicked");
			}else{
				Logger.info("Upload Doc Button is not available");
				throw new NoSuchElementException("Upload Doc Button is not uploaded");
			}
			Robot robot = new Robot();							 						  
			//String text = System.getProperty("user.dir")+ "\\ClassfiedFile\\"+filename;
			Logger.info(pathForImage);
			StringSelection stringSelection = new StringSelection(pathForImage);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, stringSelection);

			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			Logger.info("Document is uploaded");
			/* }
					  else
					  {
						  Logger.info("Document is not uploaded");
						  throw new NoSuchElementException("Document is not uploaded");
					  }*/

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void verifyDocUpload() throws Exception
	{
		try
		{
			if (DocumentsTab.isDisplayed())
			{
				DocumentsTab.click();
				Logger.info("Documents Tab is clicked");
				int count=(driver.findElements(By.xpath(".//*[@id='order-documents']/div[2]/table/tbody/tr"))).size();

				if(count==2){
					Logger.info("Document is uploaded");
					Assert.assertEquals("str", "str");
				}else{
					Logger.info("Document is not uploaded");
					Assert.assertEquals("str", "str1");
				}							
			}
			else
			{
				Logger.info("Documents Tab is not displayed");
				throw new NoSuchElementException("Documents Tab is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	//Code to select package business Unit
	// Designed by rmukhopadhyay
	public void verifyUploadDocErrMsg() throws Exception
	{
		try
		{
			WebElement uploadErrMsg= driver.findElement(By.xpath("//*[@class='panel-body accordion-body ng-scope']/p/strong"));
			if (uploadErrMsg.isDisplayed())
			{
				Logger.info("Upload Document Error Message is displayed: "+uploadErrMsg.getText());
				Assert.assertEquals("Insertion is required.", uploadErrMsg.getText());
			}else{
				Logger.info("Upload Document Error Message  is not displayed");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickOnAddOnMagnifier() throws Exception
	{
		try
		{

			if (addOnChargeToolTipElement.isDisplayed())
			{
				addOnChargeToolTipElement.click();
				Logger.info("Add On Magnifier Clicked");

			}else{
				Logger.info("Add On Magnifier is not displayed");

			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void verifyFeesRemoveButtonDisplayed() throws Exception
	{
		try
		{

			if (feesRemoveButton.isDisplayed())
			{

				Logger.info("Fees Remove button is displayed");

			}else{
				Logger.info("Fees Remove button is not displayed");

			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickFeesRemoveButton() throws Exception
	{
		try
		{

			if (feesRemoveButton.isDisplayed())
			{
				feesRemoveButton.click();
				Logger.info("Fees Remove button is clicked");

			}else{
				Logger.info("Fees Remove button is not displayed");

			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void clickFirstFeesAddButton() throws Exception
	{
		try
		{

			if (feesFirstAddButton.isDisplayed())
			{
				feesFirstAddButton.click();
				Logger.info("Fees Add button is clicked");

			}else{
				Logger.info("Fees Add button is not displayed");

			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public void editFeesPercentage(String percentage) throws Exception
	{
		try
		{
			WebElement feesPercentage= driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[2]/div[1]/table/tbody/tr[1]/td[2]/a/span/span"));
			if (feesPercentage.isDisplayed())
			{
				feesPercentage.click();
				Thread.sleep(3000);
				WebElement feesPercent= driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[2]/div[1]/table/tbody/tr[1]/td[2]/form/div/input"));
				feesPercent.clear();
				feesPercent.sendKeys(percentage);
				driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[2]/div[1]/table/tbody/tr[1]/td[3]/span")).click();
				Logger.info("Fees percentage is modified");

			}else{
				Logger.info("Fees percentage is not displayed");

			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}

	public String getFeesAmount() throws Exception
	{
		String amount = "";
		try
		{

			WebElement feesAmount= driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[2]/div[1]/table/tbody/tr[1]/td[3]/span"));
			if (feesAmount.isDisplayed())
			{
				amount = feesAmount.getText();

				Logger.info("Fees Amount is: "+amount);

			}else{
				Logger.info("Fees Amount is not displayed");

			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return amount; 
	}

	public void clickOnConfirmFeesButton() throws Exception
	{
		try
		{
			WebElement confirmButton= driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[3]/button[1]"));
			if (confirmButton.isDisplayed())
			{
				confirmButton.click();

				Logger.info("confirmButton is clicked");

			}else{
				Logger.info("confirmButton is not displayed");

			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}
	public void ClickOnlineInsCalander() throws Exception
	{
		try
		{  WebDriverWait wait = new WebDriverWait(driver,20);
		driver.findElement(By.xpath("//span[text()='Online']"));
		Logger.info("online insertion is displayed");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Online']/../../../td[5]/div"))));
		driver.findElement(By.xpath("//span[text()='Online']/../../../td[5]/div")).click();
		Thread.sleep(3000);
		Logger.info("Calander is clicked in online insertion");
		driver.findElement(By.xpath("//span[text()='Online']/../../../td[5]/div/span[2]/span/button")).click();
		Logger.info("Calander is opened in online insertion"); 
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new
	public void selectBuInDigitalService(String BU) throws Exception
	{
		try
		{
			if (BuInDigitalServiceDropDown.isDisplayed())
			{
				BuInDigitalServiceDropDown.click();
				Logger.info("BU drop down is clicked");
				Select valueFromProductType = new Select(BuInDigitalServiceDropDown);
				List<WebElement> listOfProductTypes = valueFromProductType.getOptions();
				if(listOfProductTypes.size() !=0)
				{
					Logger.info("List of BU is not empty"); 

					valueFromProductType.selectByVisibleText(BU);

					Logger.info("'" + BU + "' BU is selected"); 
				}
			}
			else
			{
				Logger.info("BU drop down is not displayed");
				throw new NoSuchElementException("BU drop down is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new

	public boolean selectProductInDigitalService(String productName) throws Exception
	{
		try
		{

			ProductInDigitalServiceDropDown.click();
			Logger.info("Product drop down is clicked");
			Select valueFromProductType = new Select(ProductInDigitalServiceDropDown);


			valueFromProductType.selectByVisibleText(productName);

			Logger.info(" Product is selected"); 

			return true; 
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}

	}//swagata new

	public boolean validateProduct(String productName,String insertionIndex) throws Exception
	{
		try
		{

			String productPath = "/tr[1]/td/div/a/span[@id='Span5']/span"; 
			WebElement product = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+productPath));
			product.click();
			WebElement productDrpDwn = driver.findElement(By.xpath("//span[@id='Span5']/../../form/div/select"));
			Select selectProduct = new Select(productDrpDwn);

			selectProduct.selectByVisibleText(productName);
			Logger.info(productName+" product is selected"); 


			return true; 


		}
		catch(Exception e)
		{
			Logger.info(productName+" product is not there in the list"); 
			return false;
		}


	}//swagata new

	public void  selectBUWithoutExcel(String insertionIndex,String buname) throws Exception
	{
		try
		{
			String buElementPath = "/tr[1]/td/div/a/span[@id='Span4']/span"; 
			WebElement buInsertionElement = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+buElementPath));
			buInsertionElement.click();
			WebElement buList = driver.findElement(By.xpath("//div[@class='editable-controls form-group']/select"));
			Select selectBU = new Select(buList);
			List<WebElement> listOfValuesBU = selectBU.getOptions();
			if(listOfValuesBU.size() !=0)
			{
				//selectBU.selectByVisibleText(buname);//swagata
				selectBU.selectByVisibleText(properties.getProperty(buname));//swagata

				Logger.info(buname+" business Unit is selected"); 
			}
			else
			{
				Logger.info("drop down is empty");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new

	public String getBasePrice(String priceType) throws Exception
	{
		try
		{

			String price = "" ;
			if(priceType.equalsIgnoreCase("base")){
				WebElement priceElement = driver.findElement(By.xpath("//label[text()='Base Price / Rate']/../div/input"));
				price = priceElement.getAttribute("value");
				Logger.info("Got the base price");
			}
			return price;

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new

	public void clickOnConfirmationMsg(String value) throws Exception
	{
		try{
			WebElement YesOrNo= driver.findElement(By.xpath("//button[text()='"+value+"']"));
			YesOrNo.click();
			Logger.info(value+ " button is clicked on the confirmation window");
		}
		catch(Exception e)
		{

			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata new

	public void selectProductType(String insertionIndex,String name) throws Exception
	{
		try
		{
			// String value = TribuneUtils.getStringCellValues("Product",1);
			String producTypePath = "/tr[1]/td/div/a/span[@id='Span2']/span"; 
			WebElement productType = driver.findElement(By.xpath("//tbody["+insertionIndex+"]"+producTypePath));
			productType.click();
			WebElement productTypeDrpDwn = driver.findElement(By.xpath("//span[@id='Span2']/../../form/div/select"));
			Select selectProductType = new Select(productTypeDrpDwn);
			selectProductType.selectByVisibleText(name);
			Thread.sleep(2000);

			Logger.info(" product type is selected");
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new



	public void addFirstAddOn() throws Exception
	{
		try
		{
			WebElement add = driver.findElement(By.xpath("//button[text()='Add']"));
			Thread.sleep(2000);

			add.click();
			Logger.info("Add-On Price is Added");
			Thread.sleep(4000);


			WebElement confirm = driver.findElement(By.xpath("//div[@class='modal-footer']/button"));

			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",confirm );

			((JavascriptExecutor)driver).executeScript("scrollBy(0,1000)");
			Thread.sleep(4000);

			confirm.click();

			Logger.info("Add-On Price is applied");

			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new
	public double getValueFromPriceDetails()throws Exception
	{
		try
		{     orderMoreActionsBtn.click();

		WebElement priceDetailsOption=driver.findElement(By.xpath("//a[text()='Price Details']"));
		if(priceDetailsOption.isDisplayed())
		{
			Logger.info("Found "+priceDetailsOption);
			priceDetailsOption.click();
			Thread.sleep(4000);
		}
		WebElement clickOnDefaultMod= driver.findElement(By.xpath("//div[text()='ClassifiedSubcategory']/../..//div[contains(text(),'38.5000 %')]"));
		String colModelName = clickOnDefaultMod.getAttribute("innerText");
		//colModelName = colModelName.substring(0 , colModelName.lastIndexOf(" "));

		Logger.info("Got the Value Of ColumnModel");

		return Double.parseDouble(colModelName.substring(0));



		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new 

	public void enterPageweight(String Weight) throws Exception
	{
		try
		{
			if(pageWeightTextBox.isDisplayed())
			{
				pageWeightTextBox.clear();
				Thread.sleep(2000);
				pageWeightTextBox.sendKeys(Weight);


				Logger.info("entered page count");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata new

	public void selectTypeInSettingsPreprintOrderWOproperty(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement type = driver.findElement(By.xpath("(//label[text()='Type']/../div/a/span[@id='Span5']/span)["+insertionIndex+"]"));
			type.click();
			Select select = new Select (typeSettingsPreprintDrpDwn);
			select.selectByVisibleText(value);
			Logger.info(value+ " type is selected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata  
	public void selectPageTypeWOproperty(String insertionIndex, String value) throws Exception
	{
		try{
			WebElement printer = driver.findElement(By.xpath("(//label[text()='Page Type']/../div/a/span[@id='Span1']/span)["+insertionIndex+"]"));
			printer.click();
			Select select = new Select(pageTypeDrpDwn);
			select.selectByVisibleText(value);
			Logger.info(value+ " page type is selected");

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata  
	public void clearClassCodeForAnInsertion(String classCode) throws Exception
	{
		try{

			WebElement classCodeTextBox = driver.findElement(By.xpath("//span[@class='ng-binding'][contains(text(),'"+classCode+"')]//span"));
			classCodeTextBox.click();
			Thread.sleep(4000);
			Logger.info(classCode +" class code is deleted ");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata

	public String panddColorChange(){

		/* WebElement UpdateLine1 = driver.findElement(By.xpath("//b[text()='ORDER_UPDATE']//following::div[@class='row']//li"));
                  String FirstUpdateLine=UpdateLine1.getText();
                  WebElement UpdateLine2 = driver.findElement(By.xpath("(//b[text()='ORDER_UPDATE']//following::div[@class='row']//span)[1]"));
                  String SecondUpdateLine=UpdateLine2.getText();
                  WebElement UpdateLine3 = driver.findElement(By.xpath("(//b[text()='ORDER_UPDATE']//following::div[@class='row']//span)[2]"));
                  String ThirdUpdateLine=UpdateLine3.getText();
                  WebElement UpdateLine4 = driver.findElement(By.xpath("(//b[text()='ORDER_UPDATE']//following::div[@class='row']//span)[3]"));
                  String ForthUpdateLine=UpdateLine4.getText();*/
		List<WebElement> updateLine = driver.findElements(By.xpath("//b[text()='ORDER_UPDATE']//following::div[@class='row']//li"));
		String  orderUpdate= "";
		Logger.info("Size is:"+updateLine.size());
		for(int i=0;i<updateLine.size();i++){
			orderUpdate =orderUpdate+ updateLine.get(i).getText();}
		Logger.info("Order updated: "+orderUpdate);
		return orderUpdate;

	}//swagata

	public void searchOrderNoPickUpWindow(String orderNo) throws Exception {
		try {
			orderNoTextBoxPickUp.click();
			orderNoTextBoxPickUp.sendKeys(Keys.CONTROL,"a");
			orderNoTextBoxPickUp.clear();
			orderNoTextBoxPickUp.sendKeys(orderNo);
			orderNoTextBoxPickUp.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			orderSearchBtn.click();
			Thread.sleep(5000);
		}catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata
	public void clickOnSuccesOK() throws Exception
	{
		try{
			if(successOKLink.isDisplayed())
			{
				successOKLink.click();
				Logger.info("success ok  link is clicked");
			}
			else{
				Logger.info("success ok link is not displayed"); 
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//mousumi

	public void selectAdSizefromExcel(int insertionNumber,int row, int col) throws Exception
	{
		try
		{
			Logger.info("inside function");
			String value = TribuneUtils.getStringCellValues("Product",row, col);
			WebElement adSizeTxtBox = driver.findElement(By.xpath("(//div[@class='form-group field-item required'][.//label[text()='Ad Size']]//span[@class=\"shorten ng-binding\"])["+insertionNumber+"]"));
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(adSizeTxtBox));
			Actions action=new Actions(driver);
			action.moveToElement(adSizeTxtBox).click().build().perform();
			//adSizeTxtBox.click();
			Select selectAdSize = new Select(adSizeDrpDwn);
			action.moveToElement(adSizeDrpDwn).click().build().perform();
			List<WebElement> listOfAdsize = selectAdSize.getOptions();

			Logger.info("value="+value);
			Logger.info("Size of the list is="+listOfAdsize.size());


			if(listOfAdsize.size() !=0)
			{
				selectAdSize.selectByVisibleText(value);
				Logger.info(value+" AdSize is selected"); 
			}
			else
			{
				Logger.info("drop down is empty");
			}

			Logger.info(" adSize is selected");
		}catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata
	public void submitOrderWithoutSave() throws Exception
	{
		try
		{
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", submitOrderButton);
			WebDriverWait wait = new WebDriverWait(driver,300);		       
			wait.until(ExpectedConditions.elementToBeClickable(submitOrderButton));
			if(submitOrderButton.isDisplayed()){
				submitOrderButton.click();
				Logger.info("Order is submitted");
				Thread.sleep(1000);
			}
			else{
				Logger.info("submit order is not displayed");
			}

		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata

	public void killOrderNonProd() throws Exception {
		try
		{
			//	String	ProdUrlTest="adorders.tribqa.com/orders/";
			String	ProdUrlTest="adorders-test.tribpub.com/orders/";
			String	ProdUrl="adorders.tribpub.com/orders/";
			String currentURL = null;
			currentURL = driver.getCurrentUrl();
			currentURL = currentURL.substring(currentURL.indexOf("//")+2, currentURL.indexOf("/orders")+8);
			System.out.println(currentURL);
			//String ProdUrl = "http://adorders.tribstage.com/orders/";
			//String ProdUrl = "http://adorders.tribqa.com/orders/";
			if( !currentURL.equals(ProdUrl) )
			{

				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)						
						.withTimeout(500, TimeUnit.SECONDS) 			
						.pollingEvery(2, TimeUnit.SECONDS) 			
						.ignoring(NoSuchElementException.class);	
				WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){

					public WebElement apply(WebDriver driver ) {
						return 	driver.findElement(By.xpath("//span[text()='Processed ']"));
					

					}
				});
//				driver.findElement(By.xpath("//span[text()='Processed ' or 'Changed ']"));
				Thread.sleep(4000);

				String orderStatusProcessed = getOrdeStatusOrderViewPage();
				Logger.info("orderStatus "+orderStatusProcessed);
				clickOnKill();
				Thread.sleep(8000);
				clickOnKillOnConfirmation();
				Thread.sleep(8000);			
				String orderStatus = getOrdeStatusOrderViewPage();
				Logger.info("orderStatus "+orderStatus);
				Thread.sleep(4000);
				
			}
			else{
				String orderStatusProcessed = getOrdeStatusOrderViewPage();
				Logger.info("orderStatus "+orderStatusProcessed);
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata
	//Code to enter the Hive Id for an order
	public String enterHiveId() throws Exception
	{
		try
		{
			hiveIdTextBox.click();
			TribuneUtils utils = new TribuneUtils();
			int HiveId = utils.randomInteger(6);
			hiveIdElement.sendKeys(Keys.CONTROL,"a");
			hiveIdElement.clear();
			hiveIdElement.sendKeys(Integer.toString(HiveId));
			Logger.info("HiveId entered:"+HiveId);
			return Integer.toString(HiveId);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata
	//Code to enter the Hive line Id for an order
	public String enterHiveLineId() throws Exception
	{
		try
		{
			hiveLineIdTextBox.click();
			hiveLineIdTextBox.clear();
			TribuneUtils utils = new TribuneUtils();
			int HiveId = utils.randomInteger(6);
			hiveLineIdTextBox.sendKeys(Integer.toString(HiveId));
			Logger.info("Hive Line Id entered:"+HiveId);
			return Integer.toString(HiveId);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata
	public void collapseInsertionDetails(String insertionIndex) throws Exception
	{
		try
		{	JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement insertionLink = driver.findElement(By.xpath("//tbody["+insertionIndex+"]//div[@class='pointer']/i")); 

		if(insertionLink.getAttribute("class").contains("down")){

			Logger.info("It contains right");
			js.executeScript("arguments[0].click();", insertionLink);

		}
		Thread.sleep(4000);
		Assert.assertTrue(insertionLink.getAttribute("class").contains("right"));

		Logger.info("Expand insertion link is clicked");



		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		Thread.sleep(4000);
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata
	public String hiveIdHistoryLog(int index){
		WebElement statusdetails = driver.findElement( By.xpath("(//b[text()='ORDER_UPDATE']//following::span[@role='button'])["+index+"]"));
		statusdetails.click();
		List<WebElement> updateLine = driver.findElements(By.xpath("//b[text()='ORDER_UPDATE']//following::div[@class='row']//li"));
		String  HiveIdChange= "";
		Logger.info("Size is:"+updateLine.size());
		for(int i=0;i<updateLine.size();i++){
			HiveIdChange =HiveIdChange+ updateLine.get(i).getText();

		}
		Logger.info("Order updated: "+HiveIdChange+".");
		return HiveIdChange;

	}//swagata
	public void enterCreditCardInfoOrderWithOutMVN(String sheetName,String card) throws Exception
	{
		TribuneUtils utilities = new TribuneUtils();

		try{

			if (creditCardNumber.isDisplayed())
			{
				creditCardNumber.click();
				creditCardNumber.clear();
				Thread.sleep(3000);
				creditCardNumber.sendKeys(utilities.getCreditCardNumber(card));
				//creditCardNumber.sendKeys(System.getProperty("CreditCardNo"));

				Logger.info("creditCardNumber is entered");
			}
			/*  
					  if (cVV.isDisplayed())
					  {
						  cVV.click();
						  cVV.clear();
						  cVV.sendKeys(System.getProperty("cVV"));
						  Logger.info("cVV is entered");
					  }
			 */
			if (expiryMonth.isDisplayed())
			{
				expiryMonth.click();
				Select valueFromBU = new Select(expiryMonth);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					valueFromBU.selectByVisibleText(utilities.getCreditCardExpMonth(card));
					Logger.info("expiry Month is selected"); 
				}
			}

			if (expiryYear.isDisplayed())
			{
				expiryYear.click();
				Select valueFromBU = new Select(expiryYear);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if(listOfValuesBU.size() !=0)
				{
					valueFromBU.selectByVisibleText(utilities.getCreditCardExpYear(card));
					Logger.info("expiry Year is selected"); 
				}
			}

			if (firstNameACH.isDisplayed())
			{
				firstNameACH.click();
				firstNameACH.clear();
				firstNameACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 0));
				Logger.info("first name is entered");
			}
			if (lastNameACH.isDisplayed())
			{
				lastNameACH.click();
				lastNameACH.clear();
				lastNameACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 1));
				Logger.info("last name is entered");
			}
			if (addressACH.isDisplayed())
			{
				addressACH.click();
				addressACH.clear();
				addressACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 5));
				Logger.info("address is entered");
			}
			if (cityACH.isDisplayed())
			{
				cityACH.click();
				cityACH.clear();
				cityACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 6));
				Logger.info("city is entered");
			}
			if (stateACH.isDisplayed())
			{
				stateACH.click();
				stateACH.clear();
				stateACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 7));
				Logger.info("state is entered");
			} 
			if (zipACH.isDisplayed())
			{
				zipACH.click();
				zipACH.clear();
				zipACH.sendKeys(""+TribuneUtils.getIntCellValues(sheetName, 1, 8));
				Logger.info("zip is entered");
			}
			if (countryACH.isDisplayed())
			{
				countryACH.click();
				countryACH.clear();
				countryACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 9));
				Logger.info("country is entered");
			}
			if (emailACH.isDisplayed())
			{
				emailACH.click();
				emailACH.clear();
				emailACH.sendKeys(TribuneUtils.getStringCellValues(sheetName, 1, 10));
				Logger.info("email is entered");
			} 
			if (phoneACH.isDisplayed())
			{
				phoneACH.click();
				phoneACH.clear();
				phoneACH.sendKeys(""+TribuneUtils.getIntCellValues(sheetName, 1, 11));
				Logger.info("phone is entered");
			}
			if (saveBtnACH.isDisplayed())
			{
				saveBtnACH.click();
			}
			Thread.sleep(4000);


		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata
	public void cyberSourceChecking() throws Exception
	{
		try
		{
			paymentTab.click();
			Logger.info("Payment Routing dropdown is clicked");
			WebDriverWait wait= new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.textToBePresentInElement(acceptStatusCybersoure, "ACCEPT"));
			if(acceptStatusCybersoure.isDisplayed()) {
				Logger.info(" Payment is accepted in cybersource");
			}
			else {
				Assert.fail(" Payment is rejected in cybersource");
			}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata

	//Code to get the Hive Id for an order
	public String getHiveId() throws Exception
	{
		try
		{

			String HiveId= driver.findElement(By.xpath("(//dt[text()='Plus_Hive ID']//following::dd//a[contains(@editable-text,'HiveId')]//span)[2]")).getText();
			/*						String HiveId= hiveIdElement.getText();
			 */	
			Logger.info("HiveId entered:"+HiveId);
			 return HiveId;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata
	//Code to get the Hive line Id for an order
	public String getHiveLineId() throws Exception
	{
		try
		{
			String HiveLineId = hiveLineIdTextBox.getAttribute("value");
			Logger.info("Hive Line Id entered:"+HiveLineId);
			return HiveLineId;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
	}//swagata

	//Code to check the order type is disabled
	public int OrderTypeDisable() throws Exception
	{
		int Flag = 0;
		try
		{WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(orderType));
		orderType.click();
		WebElement orderTypeDrpDwn = driver.findElement(By.xpath("//div[@class='editable-controls form-group']/select"));
		if (orderTypeDrpDwn.isEnabled()) {
			Logger.info("Order type is enabled");
			Flag = 0;
		} else {
			Logger.info("Order type is disabled");
			Flag = 1;
		}
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		}
		return Flag;
	}//swagata
	public void validatePackageNameDescriptionFilter(String textTosearch, String FilterName) throws Exception
	{
		try
		{
			WebElement packageFilter = driver.findElement(By.xpath("(//span[text()='"+FilterName+"']/following::div//input[@type='text'])[1]"));
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(packageFilter));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", packageFilter);
			executor.executeScript("arguments[0].setAttribute('value', '" + textTosearch +"')", packageFilter);
			/*if (FilterName.equalsIgnoreCase("Description")) {
									WebElement findTextTosearch = driver.findElement(By.xpath("(//div[contains(text(),'"+textTosearch+"')])[2]"));
									wait.until(ExpectedConditions.visibilityOf(findTextTosearch));
								} else {
									WebElement findTextTosearch = driver.findElement(By.xpath("(//div[contains(text(),'"+textTosearch+"')])[1]"));
									wait.until(ExpectedConditions.visibilityOf(findTextTosearch));
								}*/


			Logger.info(" Filter working as expected");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata

	//code to click in request adjustment history button
	public void clickOnAdjustmentRequestHistory() throws Exception
	{
		try{
			WebElement moreActions = driver.findElement(By.xpath("//button[@title='More actions']")); //joy
			moreActions.click(); //joy
			Thread.sleep(2000); //joy
			if(requestAdjustmentHistoryButton.isDisplayed())
			{
				requestAdjustmentHistoryButton.click();
				Logger.info("requestAdjustment history Button is clicked");
			}
			else{
				Logger.info("requestAdjustment history Button is not displayed");
			}
			Thread.sleep(2000);//Joy
			driver.findElement(By.xpath("//div[@class='modal-footer']//button[2]")).click();//Joy
			Logger.info("Close button is clicked");
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata
	//code to click in request adjustment history button
	public void updateReasonAccountabilityAdjustment(String Reason, String Accountibility) throws Exception
	{
		String value="";
		try{
			WebElement reasonDropdown = driver.findElement(By.xpath("(//div[text()='"+Reason+" "+"']/i)[1]"));
			Actions action = new Actions(driver);
			action.moveToElement(reasonDropdown).doubleClick().build().perform();
			Select valueFromStatus = new Select(reasonDropdown);
			List<WebElement> listOfValuesStatus = valueFromStatus.getOptions();
			if(listOfValuesStatus.size() !=0)
			{
				Logger.info("List of Reason is not empty"); 
				value = "Goodwill";//swagata
				valueFromStatus.selectByVisibleText(value);//swagata
				Logger.info("reason is selected"); 
			}
			
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata


	public Double enterBundlePrice(double bundlePrice) throws Exception
	{
		try{
			bundlePriceAmtTextBox.click();
			Logger.info("bundle Price text box is clicked");
			bundlePriceAmtTextBox.clear();
			bundlePriceAmtTextBox.sendKeys(""+bundlePrice);
			Logger.info(bundlePrice+ " bundle Price is entered");
			return bundlePrice;
		}
		catch(Exception e)
		{
			Logger.error(e.getMessage());
			throw e;
		} 
	}//swagata

	public void undoDeleteOrder() {

		undoButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(YesButtonInUndo));
		YesButtonInUndo.click();
		wait.until(ExpectedConditions.visibilityOf(savedStatus));

	}//swagata

	public void deleteOrder() {
		deleteOrder.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(YesButtonInDelete));
		YesButtonInDelete.click();
		wait.until(ExpectedConditions.visibilityOf(deleteStatus));		
	}//swagata

	
	public void ClickContinueButton() {
		try {
			
			if(driver.findElements(By.xpath("//button[contains(text(),'Continue')]")).size()>0)
			{
				WebElement continuebutton = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
				Thread.sleep(2000);
				continuebutton.click();
				Logger.info("Click on Continue button");
			}
		}
		catch (Exception e) {
			e.getMessage();
		}
	}//joy
}


