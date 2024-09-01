package com.tribune.adit2.ProductAdmin;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;
/**
 * Page Class Modeling for ProductAdmin GeneralInfo Page
 * @author rrath
 * @since Jan 2018
 */
public class GeneralInfo {
	@FindBy(xpath = "//label[contains(@class,'checkbox-option')]/input")
	private List<WebElement> giChkboxes;
	
	@FindBy(xpath = "//a[contains(text(),'General')]")
	public WebElement genTab;

	private WebDriver driver;

	Properties properties = TribuneUtils.readProperties();
	TribuneUtils utils = new TribuneUtils();

	public GeneralInfo(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * @description This method is used to click on input checkbox
	 * @author rrath
	 * @param checkbox name
	 */
	public void selectCheckbox(String chkboxName, String action) throws Exception {
		try {			
			WebElement giCheckbox = driver.findElement(By.xpath("//label[text()='"+chkboxName+"']/input"));
			WebElement giCheckboxlabel = driver.findElement(By.xpath("//label[text()='"+chkboxName+"']"));
			utils.scroll(driver, giCheckbox);
			
			switch (action) {
			case "UnCheck":
				if (giCheckbox.isSelected()) {
					giCheckboxlabel.click();
					Logger.info(chkboxName+" checkbox is Unchecked");
				} 
				else Logger.info(chkboxName+" checkbox is already Unchecked");
				break;
			case "Check":
				if (!(giCheckbox.isSelected())) {
					giCheckboxlabel.click();
					Logger.info(chkboxName+" checkbox is checked");
				} 
				else Logger.info(chkboxName+" checkbox is already checked");
				break;

			default:
				Logger.info("Invalid action method: '"+action+"' provided for the checkbox: "+chkboxName);
				break;
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * @description This method is used to click on input checkbox
	 * @author rrath
	 * @param checkbox name
	 */
	public void selectRoundToNearestCheckbox(String chkboxName, String action) throws Exception {
		try {			
			WebElement ptCheckbox = driver.findElement(By
					.xpath("//div[@role='gridcell']/div[contains(string(),'"+chkboxName+"')]/../../div[2]//input"));
			utils.scroll(driver, ptCheckbox);
			
			switch (action) {
			case "UnCheck":
				if (ptCheckbox.isSelected()) {
					ptCheckbox.click();
					Logger.info(chkboxName+" checkbox is Unchecked");
				} 
				else Logger.info(chkboxName+" checkbox is already Unchecked");
				break;
			case "Check":
				if (!(ptCheckbox.isSelected())) {
					ptCheckbox.click();
					Logger.info(chkboxName+" checkbox is checked");
				} 
				else Logger.info(chkboxName+" checkbox is already checked");
				break;

			default:
				Logger.info("Invalid action method: '"+action+"' provided for the checkbox: "+chkboxName);
				break;
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
	
	public void selectTab(String tabName) throws Exception {
		try {
			WebElement selectedTab = driver.findElement(By
					.xpath("//div[@active='BUActiveTab']//li/a[text()='"+tabName+"']"));
			utils.clickWebElement(selectedTab);
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw e;
		}
	}
}
