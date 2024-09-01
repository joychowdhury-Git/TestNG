package com.tribune.adit2.GeneralSettings;

import java.util.ArrayList;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

/**
 * Page Class Modeling for Special Program
 * 
 * @author Sunny Mukherjee
 * @since February 2019
 */

public class Classified {

	@FindBy(id = "Type")
	public WebElement typeDrpDwn;

	@FindBy(id = "Status")
	public WebElement statusDrpDwn;

	@FindBy(xpath = "//input[@ng-model='vm.userModal.name']")
	public WebElement NameInput;

	@FindBy(xpath = "vm.userModal.attributeName']")
	public WebElement attributeNameInput;

	@FindBy(xpath = "//input[@ng-model='vm.userModal.displayName']")
	public WebElement displayNameInput;

	@FindBy(id = "Text1")
	public WebElement classCodeGroupNameInput;

	@FindBy(id = "btnSaveTemplate")
	public WebElement saveButton;

	@FindBy(id = "btnNewUser")
	public WebElement addButton;

	@FindBy(id = "btnAdd")
	public WebElement addGrpButton;

	@FindBy(id = "Button1")
	public WebElement addClassCodeGrpButton;

	@FindBy(id = "btnSaveAddress")
	public WebElement okButton;

	@FindBy(xpath = "(//span[text()='General Settings'])[1]")
	public WebElement generalSettingsSection;

	@FindBy(xpath = "(//span[text()='Classified'])")
	public WebElement classifiedSection;

	@FindBy(xpath = "//span[text()='Headers']")
	public WebElement headerSection;

	@FindBy(xpath = "//span[text()='Attributes']")
	public WebElement attributeSection;

	@FindBy(xpath = "//select[@ng-model='vm.userModal.attributeType']")
	public WebElement attributeTypeDrpdwn;

	@FindBy(xpath = "//span[text()='Groups']")
	public WebElement groupsSection;

	@FindBy(xpath = "//span[text()='Group Attributes']")
	public WebElement groupAttributeSection;

	@FindBy(xpath = "//span[text()='Group Mapping']")
	public WebElement groupMappingSection;

	@FindBy(xpath = "//span[text()='Group Range']")
	public WebElement groupRangeSection;

	@FindBy(xpath = "//span[text()='Classified Package']")
	public WebElement classifiedPkgSection;

	@FindBy(xpath = "//select[@ng-model='group.BusinessUnitId']")
	public WebElement buTypeDrpdwn;

	@FindBy(xpath = "//*[@id='BusinessUnitId']")
	public WebElement buDrpdwn;

	@FindBy(xpath = "//*[@id='ClassCodeGroupID']")
	public WebElement grpDrpdwn;

	@FindBy(xpath = "//*[@id='HeaderID']")
	public WebElement headerDrpdwn;

	@FindBy(xpath = "//*[@id='AttributeID']")
	public WebElement attributeDrpdwn;

	@FindBy(xpath = "//*[@id='productType']")
	public WebElement pdtTypeDrpdwn;

	@FindBy(xpath = "//*[@id='product']")
	public WebElement pdtDrpdwn;

	@FindBy(xpath = "//*[@id='section']")
	public WebElement sectionDrpdwn;

	@FindBy(xpath = "(//*[@id='BusinessUnitId'])[1]")
	public WebElement classCodeGrpDrpdwn;

	@FindBy(xpath = "//*[@id='Select1']")
	public WebElement fromClassCodeDrpdwn;

	@FindBy(xpath = "//*[@id='Select2']")
	public WebElement toClassCodeDrpdwn;

	@FindBy(xpath = "//*[@id='btnSaveTemplate']")
	public WebElement saveBtn;

	@FindBy(id = "Text1")
	public WebElement pkgDesc;

	@FindBy(id = "Text11")
	public WebElement pkgName;

	@FindBy(xpath = "//*[@id='Button1']")
	public WebElement addPkgBtn;

	@FindBy(xpath = "(//span[text()='Fonts'])[1]") // arka
	public WebElement font;

	@FindBy(xpath = "(//a[@id='btnNewUser'])") // arka
	public WebElement fontAddButton;

	@FindBy(xpath = "(//input[@name='name'])") // arka
	public WebElement fontName;

	@FindBy(xpath = "(//button[@id='btnSaveTemplate'])") // arka
	public WebElement fontSaveButton;

	@FindBy(xpath = "//*[@id='BusinessUnitId']") // arka
	public WebElement generalSettingsClassifiedBUSelect;

	@FindBy(xpath = "//*[@id='BusinessUnitId']//*[@label='HTF-CT1 Media']") // arka
	public WebElement generalSettingsClassifiedBUSelectHTF;

	@FindBy(xpath = "(//*[@ng-class='settings.buttonClasses'])[3]") // arka
	public WebElement generalSettingsClassifiedBUSelectHTFFilter;

	@FindBy(xpath = "//input[@type='text']") // arka
	public WebElement generalSettingsClassifiedBUSelectHTFFilterSearch;

	@FindBy(xpath = "//*[@class='ng-scope ng-binding']") // arka
	public WebElement generalSettingsClassifiedBUSelectHTFLegalNotice;

	@FindBy(xpath = "(//*[@ class='fa fa-pencil'])[5]") // arka
	public WebElement generalSettingsClassifiedBUSelectHTFLegalNoticeEdit;

	@FindBy(xpath = "/html/body/div[1]/div/div/div/div[3]/div[7]/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div[9]/div/span") // arka
	public WebElement generalSettingsClassifiedBUSelectHTFLegalNoticeZone;

	@FindBy(xpath = "(//*[@class='ng-scope ng-binding'])[4]") // arka
	public WebElement generalSettingsClassifiedBUSelectLegalNotices;
	

	private WebDriver driver;

	Properties properties = TribuneUtils.readProperties();

	public Classified(WebDriver driver) {
		this.driver = driver;
	}

	public void clickGeneralSettingsHTF_BU() throws Exception {
		try {
			generalSettingsClassifiedBUSelect.click();

			Thread.sleep(2000);
			generalSettingsClassifiedBUSelectHTF.click();
			Thread.sleep(2000);
			generalSettingsClassifiedBUSelectHTFFilter.click();
			Thread.sleep(2000);
			generalSettingsClassifiedBUSelectHTFFilterSearch.click();
			Thread.sleep(5000);
			Logger.info("HTF Filter clicked1");
			generalSettingsClassifiedBUSelectHTFFilterSearch.click();
			Thread.sleep(4000);
			Logger.info("HTF Filter clicked2");

			generalSettingsClassifiedBUSelectHTFFilterSearch.sendKeys("Legal: Notices");
			Thread.sleep(4000);

			// generalSettingsClassifiedBUSelectLegalNotices.click();
			// Thread.sleep(4000);

			// generalSettingsClassifiedBUSelectHTFLegalNotice.click();
			// Thread.sleep(4000);
			generalSettingsClassifiedBUSelectHTFLegalNoticeEdit.click();
			Thread.sleep(4000);

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectHTFZone(String text) throws Exception {
		try {
			Actions actions = new Actions(driver);
			actions.doubleClick(generalSettingsClassifiedBUSelectHTFLegalNoticeZone).perform();
			// generalSettingsClassifiedBUSelectHTFLegalNoticeZone.click();
			driver.findElement(By
					.xpath("//div[contains(@class,'ui-grid-cell-contents-hidden')]/following-sibling::div[@class='ng-scope']//select"))
					.click();
			Logger.info("Drop down selected");

			Select dropdown = new Select(driver.findElement(By.xpath(
					"//div[contains(@class,'ui-grid-cell-contents-hidden')]/following-sibling::div[@class='ng-scope']//select")));
			dropdown.selectByVisibleText(text);
			Logger.info(text + " product type is selected");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id='customMultiselectDropdown-btn']/div[1]/div")).click();
			Logger.info("clicked outside");
			Thread.sleep(2000);
		
			
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div[7]/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div[11]/div/span/input")).click();//mou
			
				driver.findElement(By.xpath("//*[@id='btnSaveAddress']")).click();
				Logger.info("clicked checkbox");
			
		
			//Logger.info("clicked checkbox");
			//Thread.sleep(6000);
			

			//driver.findElement(By.xpath("//*[@id='btnSaveAddress']")).click();
			//Logger.info("clicked checkbox");
			//Thread.sleep(3000);
			
			
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}

	}// arka

	private void getAllOptions(By id) {
		// TODO Auto-generated method stub

	}

	public void clickfontSaveButton() throws Exception {
		try {

			Actions action = new Actions(driver);
			action.moveToElement(fontSaveButton).click().build().perform();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// arka

	public void provideFontName() throws Exception {
		try {

			fontName.click();
			Thread.sleep(2000);
			fontName.sendKeys("AbcdTest");

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// arka

	public void clickfontAddButton() throws Exception {
		try {

			Actions action = new Actions(driver);
			action.moveToElement(fontAddButton).click().build().perform();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// arka

	public void clickOnFont() throws Exception {
		try {

			Actions action = new Actions(driver);
			action.moveToElement(font).click().build().perform();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}// arka

	public void clickOnGeneralSettingsSection() throws Exception {
		try {

			Actions action = new Actions(driver);
			action.moveToElement(generalSettingsSection).click().build().perform();

			/*
			 * if(generalSettingsSection.isEnabled()){ ((JavascriptExecutor)
			 * driver).executeScript("arguments[0].scrollIntoView();",
			 * generalSettingsSection); Thread.sleep(3000);
			 * generalSettingsSection.click(); try {
			 * if(classifiedSection.isEnabled()){
			 * generalSettingsSection.click();
			 * Logger.info("generalSettingsSection is clicked"); } else {
			 * Logger.info("generalSettingsSection is not enabled"); } }
			 * catch(Exception e) { Logger.error(e.getMessage()); throw e; }
			 * 
			 * } else { Logger.info("generalSettingsSection is not displayed");
			 * throw new
			 * NoSuchElementException("generalSettingsSection is not displayed"
			 * ); }
			 */
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnClassifiedSection() throws Exception {
		try {

			Actions action = new Actions(driver);
			action.moveToElement(classifiedSection).click().build().perform();
			/*
			 * if(classifiedSection.isEnabled()){ ((JavascriptExecutor)
			 * driver).executeScript("arguments[0].scrollIntoView();",
			 * classifiedSection); Thread.sleep(3000);
			 * classifiedSection.click(); try { if(headerSection.isEnabled()){
			 * classifiedSection.click();
			 * Logger.info("classifiedSection is clicked"); } else {
			 * Logger.info("classifiedSection is not enabled"); } }
			 * catch(Exception e) {
			 * Logger.info("classifiedSection is not enabled yo");
			 * Logger.error(e.getMessage()); throw e; }
			 * Logger.info("classifiedSection is clicked"); } else {
			 * Logger.info("classifiedSection is not displayed yeah"); throw new
			 * NoSuchElementException("classifiedSection is not displayed"); }
			 */
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnHeaderSection() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(headerSection).click().build().perform();
		/*
		 * try {
		 * 
		 * if(headerSection.isDisplayed()){ ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView();",
		 * headerSection); headerSection.click(); headerSection.click();
		 * Logger.info("headerSection is clicked"); } else {
		 * Logger.info("headerSection is not displayed"); throw new
		 * NoSuchElementException("headerSection is not displayed"); } }
		 * catch(Exception e) { Logger.error(e.getMessage()); throw e; }
		 */
	}

	public void clickOnSaveButton() throws Exception {
		try {
			if (saveButton.isDisplayed()) {
				saveButton.click();
				saveButton.click();
				Logger.info("saveButton is clicked");
			} else {
				Logger.info("saveButton not displayed");
				throw new NoSuchElementException("saveButton is not displayed");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterName(String name) throws Exception {
		try {
			if (NameInput.isEnabled()) {
				Logger.info("NameInput text box is visible");
				NameInput.click();
				NameInput.sendKeys(Keys.CONTROL, "a");
				NameInput.clear();
				NameInput.sendKeys(name);
				NameInput.sendKeys(Keys.ENTER);
				Thread.sleep(6000);
				Logger.info(name + " NameInput is entered");
			} else {
				Logger.info("NameInput text box is not visible");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnAddnBtn() throws Exception {
		try {
			if (addButton.isDisplayed()) {
				addButton.click();
				addButton.click();
				Logger.info("addButton is clicked");
			} else {
				Logger.info("addButtonis not displayed");
				throw new NoSuchElementException("addButton is not displayed");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterAttributeName(String name) throws Exception {
		try {
			if (attributeNameInput.isEnabled()) {
				Logger.info("attributeNameInput text box is visible");
				attributeNameInput.click();
				attributeNameInput.sendKeys(Keys.CONTROL, "a");
				attributeNameInput.clear();
				attributeNameInput.sendKeys(name);
				attributeNameInput.sendKeys(Keys.ENTER);
				Thread.sleep(6000);
				Logger.info(name + " attributeNameInput is entered");
			} else {
				Logger.info("attributeNameInput text box is not visible");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterDisplayName(String name) throws Exception {
		try {
			if (displayNameInput.isEnabled()) {
				Logger.info("displayNameInput text box is visible");
				displayNameInput.click();
				displayNameInput.sendKeys(Keys.CONTROL, "a");
				displayNameInput.clear();
				displayNameInput.sendKeys(name);
				displayNameInput.sendKeys(Keys.ENTER);
				Thread.sleep(6000);
				Logger.info(name + " displayNameInput is entered");
			} else {
				Logger.info("displayNameInput text box is not visible");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectAttributeType(String Filter) throws Exception {
		try {
			if (attributeTypeDrpdwn.isDisplayed()) {
				attributeTypeDrpdwn.click();
				Select valueFromBU = new Select(attributeTypeDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if (listOfValuesBU.size() != 0) {
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter) + " AttributeType is selected");
				} else {
					Logger.info("drop down is empty");
				}
			} else {
				Logger.info("AttributeType is not displayed");
				throw new NoSuchElementException("AttributeType is not displayed");
			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnAttributeSection() throws Exception {
		try {
			if (attributeSection.isDisplayed()) {
				attributeSection.click();
				attributeSection.click();
				Logger.info("attributeSection is clicked");
			} else {
				Logger.info("attributeSection is not displayed");
				throw new NoSuchElementException("attributeSection is not displayed");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnGroupSection() throws Exception {
		try {
			if (groupsSection.isDisplayed()) {
				groupsSection.click();
				groupsSection.click();
				Logger.info("groupsSection is clicked");
			} else {
				Logger.info("groupsSection is not displayed");
				throw new NoSuchElementException("groupsSection is not displayed");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnGroupAttributeSection() throws Exception {
		try {
			if (groupAttributeSection.isDisplayed()) {
				groupAttributeSection.click();
				groupAttributeSection.click();
				Logger.info("groupAttributeSection is clicked");
			} else {
				Logger.info("groupAttributeSection is not displayed");
				throw new NoSuchElementException("groupAttributeSection is not displayed");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnGroupMappingSection() throws Exception {
		try {
			if (groupMappingSection.isDisplayed()) {
				groupMappingSection.click();
				groupMappingSection.click();
				Logger.info("groupMappingSection is clicked");
			} else {
				Logger.info("groupMappingSection is not displayed");
				throw new NoSuchElementException("groupMappingSection is not displayed");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnGroupRangeSection() throws Exception {
		try {
			if (groupRangeSection.isDisplayed()) {
				groupRangeSection.click();
				groupRangeSection.click();
				Logger.info("groupRangeSection is clicked");
			} else {
				Logger.info("groupRangeSection is not displayed");
				throw new NoSuchElementException("groupRangeSection is not displayed");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnClassifiedPkgSection() throws Exception {
		try {
			if (classifiedPkgSection.isDisplayed()) {
				classifiedPkgSection.click();
				classifiedPkgSection.click();
				Logger.info("classifiedPkgSection is clicked");
			} else {
				Logger.info("classifiedPkgSection is not displayed");
				throw new NoSuchElementException("classifiedPkgSection is not displayed");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnAddGrpBtn() throws Exception {
		try {
			if (addGrpButton.isDisplayed()) {
				addGrpButton.click();
				addGrpButton.click();
				Logger.info("addGrpButton is clicked");
			} else {
				Logger.info("addGrpButton not displayed");
				throw new NoSuchElementException("addGrpButton is not displayed");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterClassCodeGroupName(String name) throws Exception {
		try {
			if (classCodeGroupNameInput.isEnabled()) {
				Logger.info("classCodeGroupNameInput text box is visible");
				classCodeGroupNameInput.click();
				classCodeGroupNameInput.sendKeys(Keys.CONTROL, "a");
				classCodeGroupNameInput.clear();
				classCodeGroupNameInput.sendKeys(name);
				classCodeGroupNameInput.sendKeys(Keys.ENTER);
				Thread.sleep(6000);
				Logger.info(name + " classCodeGroupNameInput is entered");
			} else {
				Logger.info("classCodeGroupNameInput text box is not visible");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectBuType(String Filter) throws Exception {
		try {
			if (buTypeDrpdwn.isDisplayed()) {
				buTypeDrpdwn.click();
				Select valueFromBU = new Select(buTypeDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if (listOfValuesBU.size() != 0) {
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter) + " buTypeDrpdwn is selected");
				} else {
					Logger.info("drop down is empty");
				}
			} else {
				Logger.info("buTypeDrpdwn is not displayed");
				throw new NoSuchElementException("buTypeDrpdwn is not displayed");
			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnAddClassCodeGrpBtn() throws Exception {
		try {
			if (addClassCodeGrpButton.isDisplayed()) {
				addClassCodeGrpButton.click();
				addClassCodeGrpButton.click();
				Logger.info("addClassCodeGrpButton is clicked");
			} else {
				Logger.info("addClassCodeGrpButton not displayed");
				throw new NoSuchElementException("addClassCodeGrpButton is not displayed");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnOkBtn() throws Exception {
		try {
			if (okButton.isDisplayed()) {
				okButton.click();
				okButton.click();
				Logger.info("okButton is clicked");
			} else {
				Logger.info("okButton not displayed");
				throw new NoSuchElementException("okButton is not displayed");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void setSequenceNumber(String number) throws Exception {
		try {
			WebElement clickSequenceNumber = driver
					.findElement(By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[3]"));
			Actions action = new Actions(driver);
			action.moveToElement(clickSequenceNumber).doubleClick().build().perform();
			Thread.sleep(3000);
			WebElement enterSequenceNumber = driver
					.findElement(By.xpath("//form[@class='ng-pristine ng-valid']/input"));
			enterSequenceNumber.click();
			enterSequenceNumber.clear();
			enterSequenceNumber.sendKeys("" + number);
			Logger.info("SequenceNumber entered");
			Thread.sleep(3000);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void setAttribute(String Filter) throws Exception {
		try {
			WebElement clickAttribute = driver
					.findElement(By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[1]"));
			Actions action = new Actions(driver);
			action.moveToElement(clickAttribute).doubleClick().build().perform();
			Thread.sleep(3000);
			WebElement attributeDrpdwn = driver.findElement(By.xpath("//form[@class='ng-pristine ng-valid']/select"));
			if (attributeDrpdwn.isDisplayed()) {
				attributeDrpdwn.click();
				Select valueFromBU = new Select(attributeDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if (listOfValuesBU.size() != 0) {
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter) + " attributeDrpdwn is selected");
				} else {
					Logger.info("drop down is empty");
				}
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectBu(String Filter) throws Exception {
		try {
			if (buDrpdwn.isDisplayed()) {
				buDrpdwn.click();
				Select valueFromBU = new Select(buDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if (listOfValuesBU.size() != 0) {
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter) + " buDrpdwn is selected");
				} else {
					Logger.info("drop down is empty");
				}
			} else {
				Logger.info("buDrpdwn is not displayed");
				throw new NoSuchElementException("buDrpdwn is not displayed");
			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectGroup(String Filter) throws Exception {
		try {
			if (grpDrpdwn.isDisplayed()) {
				grpDrpdwn.click();
				Select valueFromBU = new Select(grpDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if (listOfValuesBU.size() != 0) {
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter) + " grpDrpdwn is selected");
				} else {
					Logger.info("drop down is empty");
				}
			} else {
				Logger.info("grpDrpdwn is not displayed");
				throw new NoSuchElementException("grpDrpdwn is not displayed");
			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectHeader(String Filter) throws Exception {
		try {
			if (headerDrpdwn.isDisplayed()) {
				headerDrpdwn.click();
				Select valueFromBU = new Select(headerDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if (listOfValuesBU.size() != 0) {
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter) + " headerDrpdwn is selected");
				} else {
					Logger.info("drop down is empty");
				}
			} else {
				Logger.info("headerDrpdwn is not displayed");
				throw new NoSuchElementException("headerDrpdwn is not displayed");
			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectAttribute(String Filter) throws Exception {
		try {
			if (attributeDrpdwn.isDisplayed()) {
				attributeDrpdwn.click();
				Select valueFromBU = new Select(attributeDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if (listOfValuesBU.size() != 0) {
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter) + " attributeDrpdwn is selected");
				} else {
					Logger.info("drop down is empty");
				}
			} else {
				Logger.info("attributeDrpdwn is not displayed");
				throw new NoSuchElementException("attributeDrpdwn is not displayed");
			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectPdtType(String Filter) throws Exception {
		try {
			if (pdtTypeDrpdwn.isDisplayed()) {
				pdtTypeDrpdwn.click();
				Select valueFromBU = new Select(pdtTypeDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if (listOfValuesBU.size() != 0) {
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter) + " pdtTypeDrpdwn is selected");
				} else {
					Logger.info("drop down is empty");
				}
			} else {
				Logger.info("pdtTypeDrpdwn is not displayed");
				throw new NoSuchElementException("pdtTypeDrpdwn is not displayed");
			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectPdt(String Filter) throws Exception {
		try {
			if (pdtDrpdwn.isDisplayed()) {
				pdtDrpdwn.click();
				Select valueFromBU = new Select(pdtDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if (listOfValuesBU.size() != 0) {
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter) + " pdtDrpdwn is selected");
				} else {
					Logger.info("drop down is empty");
				}
			} else {
				Logger.info("pdtDrpdwn is not displayed");
				throw new NoSuchElementException("pdtDrpdwn is not displayed");
			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectSection(String Filter) throws Exception {
		try {
			if (sectionDrpdwn.isDisplayed()) {
				sectionDrpdwn.click();
				Select valueFromBU = new Select(sectionDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if (listOfValuesBU.size() != 0) {
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter) + " sectionDrpdwn is selected");
				} else {
					Logger.info("drop down is empty");
				}
			} else {
				Logger.info("sectionDrpdwn is not displayed");
				throw new NoSuchElementException("sectionDrpdwn is not displayed");
			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectClassCodeGrp(String Filter) throws Exception {
		try {
			if (classCodeGrpDrpdwn.isDisplayed()) {
				classCodeGrpDrpdwn.click();
				Select valueFromBU = new Select(classCodeGrpDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if (listOfValuesBU.size() != 0) {
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter) + " classCodeGrpDrpdwn is selected");
				} else {
					Logger.info("drop down is empty");
				}
			} else {
				Logger.info("classCodeGrpDrpdwn is not displayed");
				throw new NoSuchElementException("classCodeGrpDrpdwn is not displayed");
			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectFromClassCode(String Filter) throws Exception {
		try {
			if (fromClassCodeDrpdwn.isDisplayed()) {
				fromClassCodeDrpdwn.click();
				Select valueFromBU = new Select(fromClassCodeDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if (listOfValuesBU.size() != 0) {
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter) + " fromClassCodeDrpdwn is selected");
				} else {
					Logger.info("drop down is empty");
				}
			} else {
				Logger.info("fromClassCodeDrpdwn is not displayed");
				throw new NoSuchElementException("fromClassCodeDrpdwn is not displayed");
			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void selectToClassCode(String Filter) throws Exception {
		try {
			if (toClassCodeDrpdwn.isDisplayed()) {
				toClassCodeDrpdwn.click();
				Select valueFromBU = new Select(toClassCodeDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if (listOfValuesBU.size() != 0) {
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter) + " toClassCodeDrpdwn is selected");
				} else {
					Logger.info("drop down is empty");
				}
			} else {
				Logger.info("toClassCodeDrpdwn is not displayed");
				throw new NoSuchElementException("toClassCodeDrpdwn is not displayed");
			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnSaveBtn() throws Exception {
		try {
			if (saveBtn.isDisplayed()) {
				saveBtn.click();
				saveBtn.click();
				Logger.info("saveBtn is clicked");
			} else {
				Logger.info("saveBtn not displayed");
				throw new NoSuchElementException("saveBtn is not displayed");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterDescription(String name) throws Exception {
		try {
			if (pkgDesc.isEnabled()) {
				Logger.info("pkgDesc text box is visible");
				pkgDesc.click();
				pkgDesc.sendKeys(Keys.CONTROL, "a");
				pkgDesc.clear();
				pkgDesc.sendKeys(name);
				pkgDesc.sendKeys(Keys.ENTER);
				Thread.sleep(6000);
				Logger.info(name + " pkgDesc is entered");
			} else {
				Logger.info("pkgDesc text box is not visible");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void enterPackageName(String name) throws Exception {
		try {
			if (pkgName.isEnabled()) {
				Logger.info("pkgName text box is visible");
				pkgName.click();
				pkgName.sendKeys(Keys.CONTROL, "a");
				pkgName.clear();
				pkgName.sendKeys(name);
				pkgName.sendKeys(Keys.ENTER);
				Thread.sleep(6000);
				Logger.info(name + " pkgName is entered");
			} else {
				Logger.info("pkgName text box is not visible");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void clickOnAddPkgBtn() throws Exception {
		try {
			if (addPkgBtn.isDisplayed()) {
				addPkgBtn.click();
				addPkgBtn.click();
				Logger.info("addPkgBtn is clicked");
			} else {
				Logger.info("addPkgBtn not displayed");
				throw new NoSuchElementException("addPkgBtn is not displayed");
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void setProductType(String Filter) throws Exception {
		try {
			WebElement clickAttribute = driver
					.findElement(By.xpath("(//div[@class='ui-grid-cell-contents ng-scope'])[2]"));
			Actions action = new Actions(driver);
			action.moveToElement(clickAttribute).doubleClick().build().perform();
			Thread.sleep(3000);
			WebElement attributeDrpdwn = driver.findElement(By.xpath("//form[@class='ng-pristine ng-valid']/select"));
			if (attributeDrpdwn.isDisplayed()) {
				attributeDrpdwn.click();
				Select valueFromBU = new Select(attributeDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if (listOfValuesBU.size() != 0) {
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter) + " ProductTypeDrpdwn is selected");
				} else {
					Logger.info("drop down is empty");
				}
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void setProduct(String Filter) throws Exception {
		try {
			WebElement clickAttribute = driver
					.findElement(By.xpath("(//div[@class='ui-grid-cell-contents ng-scope'])[3]"));
			Actions action = new Actions(driver);
			action.moveToElement(clickAttribute).doubleClick().build().perform();
			Thread.sleep(3000);
			WebElement attributeDrpdwn = driver.findElement(By.xpath("//form[@class='ng-pristine ng-valid']/select"));
			if (attributeDrpdwn.isDisplayed()) {
				attributeDrpdwn.click();
				Select valueFromBU = new Select(attributeDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if (listOfValuesBU.size() != 0) {
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter) + " ProductDrpdwn is selected");
				} else {
					Logger.info("drop down is empty");
				}
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void setAdType(String Filter) throws Exception {
		try {
			WebElement clickAttribute = driver
					.findElement(By.xpath("(//div[@class='ui-grid-cell-contents ng-scope'])[4]"));
			Actions action = new Actions(driver);
			action.moveToElement(clickAttribute).doubleClick().build().perform();
			Thread.sleep(3000);
			WebElement attributeDrpdwn = driver.findElement(By.xpath("//form[@class='ng-pristine ng-valid']/select"));
			if (attributeDrpdwn.isDisplayed()) {
				attributeDrpdwn.click();
				Select valueFromBU = new Select(attributeDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if (listOfValuesBU.size() != 0) {
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter) + " AdTypeDrpdwn is selected");
				} else {
					Logger.info("drop down is empty");
				}
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void setSection(String Filter) throws Exception {
		try {
			WebElement clickAttribute = driver
					.findElement(By.xpath("(//div[@class='ui-grid-cell-contents ng-scope'])[5]"));
			Actions action = new Actions(driver);
			action.moveToElement(clickAttribute).doubleClick().build().perform();
			Thread.sleep(3000);
			WebElement attributeDrpdwn = driver.findElement(By.xpath("//form[@class='ng-pristine ng-valid']/select"));
			if (attributeDrpdwn.isDisplayed()) {
				attributeDrpdwn.click();
				Select valueFromBU = new Select(attributeDrpdwn);
				List<WebElement> listOfValuesBU = valueFromBU.getOptions();
				if (listOfValuesBU.size() != 0) {
					valueFromBU.selectByVisibleText((Filter));
					Logger.info((Filter) + " SectionDrpdwn is selected");
				} else {
					Logger.info("drop down is empty");
				}
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

	public void setPrimary() throws Exception {
		try {
			WebElement clickAttribute = driver
					.findElement(By.xpath("(//div[@class='ui-grid-cell-contents ng-scope'])[10]/span/input"));
			Actions action = new Actions(driver);
			action.moveToElement(clickAttribute).click().build().perform();
			Thread.sleep(3000);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}

}
