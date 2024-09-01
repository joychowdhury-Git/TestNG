package com.tribune.adit2.test;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.tribune.adit2.Home.DashboardPage;
import com.tribune.adit2.Home.SignInPage;
import com.tribune.adit2.OrderEntry.NewOrderPage;
import com.tribune.adit2.OrderEntry.OrderEntryHomePage;
import com.tribune.adit2.PricingAdmin.PricingAdminPage;
import com.tribune.adit2.ProductAdmin.GeneralInfo;
import com.tribune.adit2.ProductAdmin.ProductAdminPage;
import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.testng.WebDriverManager;
import com.tribune.adit2.util.Configurator;
import com.tribune.adit2.util.TribuneUtils;

import junit.framework.Assert;


public class PricingAdminExcelUtility {
	TribuneUtils util = new TribuneUtils();

	private WebDriver driver;
	public PricingAdminExcelUtility(WebDriver driver)
	{
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}

	public void priceAdminExcelUtility() throws Exception
	{


		String dirPath="C:\\Users\\"+System.getProperty("user.name")+"\\Documents";
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) 
		{
			System.out.println("No file");
		}

		File lastModifiedFile = files[0];
		int i=0;
		for (i = 1; i < files.length; i++) 
		{
			if (lastModifiedFile.lastModified() < files[i].lastModified()) 
			{
				lastModifiedFile = files[i];
			}
		}
		i--;

		while(i>0)
		{



			if(lastModifiedFile.getName().equals("PricingFieldValidation.xlsx"))
				break;
			else
			{
				i--;
				lastModifiedFile = files[i];
			}

		}

		System.out.println(lastModifiedFile);

		String BU=null;
		String ProductType=null;
		String Product=null;


		FileInputStream inputStream = new FileInputStream(lastModifiedFile);

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);


		/*firstSheet.shiftRows(0, firstSheet.getLastRowNum(), 1);
		firstSheet.createRow(1);*/

		Iterator<Row> iterator = firstSheet.iterator();
		int column;
		int row=0;


		//Count number of rows and columns
		String EmployeeName=null;
		while (iterator.hasNext()) {
			row++;
			column=0;
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			int value=0;



			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				column++;

				/*if(row==1 && column==3)
				{

					firstSheet.getRow(row-1).createCell(column).setCellValue("Result");
					firstSheet.getRow(row-1).createCell(column+1).setCellValue("Baseline Value");
				}
				if(row>1 && column==3)
				{
					firstSheet.getRow(row-1).createCell(column+1).setCellValue("");
					firstSheet.getRow(row-1).createCell(column+1).setCellValue("");
				}*/




				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_BLANK:

					if(row==1 && column==3)
					{
						System.out.println(column);
						firstSheet.getRow(row-1).createCell(3).setCellValue("Baseline Validation");
						firstSheet.getRow(row-1).createCell(4).setCellValue("");
						firstSheet.getRow(row-1).createCell(5).setCellValue("");
						firstSheet.addMergedRegion(CellRangeAddress.valueOf("D1:F1"));

						firstSheet.getRow(row-1).createCell(6).setCellValue("Days of Week Modifier Validation");
						firstSheet.getRow(row-1).createCell(7).setCellValue("");
						firstSheet.getRow(row-1).createCell(8).setCellValue("");
						firstSheet.addMergedRegion(CellRangeAddress.valueOf("G1:I1"));

						firstSheet.getRow(row-1).createCell(9).setCellValue("Zone Modifier Validation");
						firstSheet.getRow(row-1).createCell(10).setCellValue("");
						firstSheet.getRow(row-1).createCell(11).setCellValue("");
						firstSheet.addMergedRegion(CellRangeAddress.valueOf("J1:L1"));

						firstSheet.getRow(row-1).createCell(12).setCellValue("AdType Modifier Validation");
						firstSheet.getRow(row-1).createCell(13).setCellValue("");
						firstSheet.getRow(row-1).createCell(14).setCellValue("");
						firstSheet.addMergedRegion(CellRangeAddress.valueOf("M1:O1"));

					}
					break;
				case Cell.CELL_TYPE_STRING:

					/*if(row==1 && column==1)
					{

						firstSheet.getRow(row-1).createCell(1).setCellValue("Baseline Validation");
						firstSheet.getRow(row-1).createCell(3).setCellValue("Baseline Validation");
						firstSheet.getRow(row-1).createCell(4).setCellValue("");
						firstSheet.getRow(row-1).createCell(5).setCellValue("");

						//firstSheet.addMergedRegion(new CellRangeAddress(0,0,3,3));
					}
					 */
					if(row==2 && column==3)
					{
						firstSheet.getRow(row-1).createCell(3).setCellValue("Result");
						firstSheet.getRow(row-1).createCell(4).setCellValue("Value");						
						firstSheet.getRow(row-1).createCell(5).setCellValue("Test Result for Updating Existing Data");
					
						firstSheet.getRow(row-1).createCell(6).setCellValue("Result");
						firstSheet.getRow(row-1).createCell(7).setCellValue("Value");
						firstSheet.getRow(row-1).createCell(8).setCellValue("Test Result for Updating Existing Data");

						firstSheet.getRow(row-1).createCell(9).setCellValue("Result");
						firstSheet.getRow(row-1).createCell(10).setCellValue("Value");
						firstSheet.getRow(row-1).createCell(11).setCellValue("Test Result for Updating Existing Data");
						
						firstSheet.getRow(row-1).createCell(12).setCellValue("Result");
						firstSheet.getRow(row-1).createCell(13).setCellValue("Value");
						firstSheet.getRow(row-1).createCell(14).setCellValue("Test Result for Updating Existing Data");
					}

					if(row>2 && column==1)
					{
						BU=firstSheet.getRow(row-1).getCell(column-1).getStringCellValue();
						Logger.info(BU);

						value++;
					}
					if(row>2 && column==2)
					{
						ProductType=firstSheet.getRow(row-1).getCell(column-1).getStringCellValue();
						Logger.info(ProductType);

						value++;

					}
					if(row>2 && column==3)
					{
						Product=firstSheet.getRow(row-1).getCell(column-1).getStringCellValue();
						Logger.info(Product);	

						value++;

					}
					if(value==3)
					{
						Logger.info(ProductType);

						//BaselineModifierValidation
						ArrayList<String> BaselineValue=BaselineModifierValidation(BU,ProductType,Product);
						if(!BaselineValue.get(1).equals(null) && !BaselineValue.get(2).equals(!BaselineValue.get(1).equals(null)))
						{
							if(BaselineValue.get(0).equals(BaselineValue.get(1)))
							{	
								if(row>2 && column==3)
								{
									firstSheet.getRow(row-1).createCell(3).setCellValue("Pass");
									firstSheet.getRow(row-1).createCell(4).setCellValue(BaselineValue.get(1));
									firstSheet.getRow(row-1).createCell(5).setCellValue(BaselineValue.get(0));
								}
							}
							else
							{
								if(row>2 && column==3)
								{
									firstSheet.getRow(row-1).createCell(3).setCellValue("Fail");
									firstSheet.getRow(row-1).createCell(4).setCellValue(BaselineValue.get(1));
									firstSheet.getRow(row-1).createCell(5).setCellValue(BaselineValue.get(0));
								}
							}
						}

						//DaysOfWeekModifierValidation
						/*String DaysOfWeekModifierValue=DaysOfWeekModifierValidation(BU,ProductType,Product);
						if(DaysOfWeekModifierValue.length()>1)
						{
							if(row>2 && column==3)
							{
								firstSheet.getRow(row-1).createCell(6).setCellValue("Pass");
								firstSheet.getRow(row-1).createCell(7).setCellValue(DaysOfWeekModifierValue);
								firstSheet.getRow(row-1).createCell(8).setCellValue("Pass");
							}
						}
						else
						{
							if(row>2 && column==3)
							{
								firstSheet.getRow(row-1).createCell(6).setCellValue("Fail");
								firstSheet.getRow(row-1).createCell(7).setCellValue(DaysOfWeekModifierValue);
								firstSheet.getRow(row-1).createCell(8).setCellValue("Fail");
							}
						}*/

						//ZoneModifierValidation
						/*String ZoneModifierValue=ZoneModifierValidation(BU,ProductType,Product);
						if(ZoneModifierValue.length()>1 && !ZoneModifierValue.equals("0"))
						{
							if(row>2 && column==3)
							{
								firstSheet.getRow(row-1).createCell(9).setCellValue("Pass");
								firstSheet.getRow(row-1).createCell(10).setCellValue(ZoneModifierValue);
								firstSheet.getRow(row-1).createCell(11).setCellValue("Pass");
							}
						}
						else
						{
							if(row>2 && column==3)
							{
								firstSheet.getRow(row-1).createCell(9).setCellValue("Fail");
								firstSheet.getRow(row-1).createCell(10).setCellValue(ZoneModifierValue);
								firstSheet.getRow(row-1).createCell(11).setCellValue("Fail");
								
							}
						}
						if(ZoneModifierValue.equals("0"))
						{
							if(row>2 && column==3)
							{
								firstSheet.getRow(row-1).createCell(9).setCellValue("Fail");
								firstSheet.getRow(row-1).createCell(10).setCellValue("Zone Modifier not available for the selected Product-combination");
								firstSheet.getRow(row-1).createCell(11).setCellValue("Fail");
							}
						}*/
						
						//AdTypeModifierValidation
						/*String AdTypeModifierValue=AdTypeModifierValidation(BU,ProductType,Product);
						if(AdTypeModifierValue.length()>1 && !AdTypeModifierValue.equals("0"))
						{
							if(row>2 && column==3)
							{
								firstSheet.getRow(row-1).createCell(12).setCellValue("Pass");
								firstSheet.getRow(row-1).createCell(13).setCellValue(AdTypeModifierValue);
								firstSheet.getRow(row-1).createCell(14).setCellValue("Pass");
							}
						}
						else
						{
							if(row>2 && column==3)
							{
								firstSheet.getRow(row-1).createCell(12).setCellValue("Fail");
								firstSheet.getRow(row-1).createCell(13).setCellValue(AdTypeModifierValue);
								firstSheet.getRow(row-1).createCell(14).setCellValue("Fail");
							}
						}
						if(AdTypeModifierValue.equals("0"))
						{
							if(row>2 && column==3)
							{
								firstSheet.getRow(row-1).createCell(12).setCellValue("Fail");
								firstSheet.getRow(row-1).createCell(13).setCellValue("AdType Modifier not available for the selected Product-combination");
								firstSheet.getRow(row-1).createCell(14).setCellValue("Fail");
							}
						}*/
						value=0;
					}

					break;
				case Cell.CELL_TYPE_BOOLEAN:
					//column++;
					/*if(column==8)
					{
						boolean data2=cell.getBooleanCellValue();
						firstSheet.getRow(row-1).createCell(column-2).setCellValue(data2);
						firstSheet.getRow(row-1).createCell(column-1).setCellValue("");
					}*/

					break;
				case Cell.CELL_TYPE_NUMERIC:	          
					//column++;
					break;
				}
				// System.out.print(" - ");
			}
		}

		String fileName="PricingFieldValidation_TestResults.xlsx";

		FileOutputStream fout=new FileOutputStream(new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\"+fileName));
		// finally write content 
		//FileOutputStream fout=new FileOutputStream(new File("\\\\FCWPFS01\\Technology\\Process\\"+fileName));

		workbook.write(fout);

		// close the file

		fout.close();
		workbook.close();
		inputStream.close();

	}
	public ArrayList<String> BaselineModifierValidation(String BU,String ProductType,String Product) throws InterruptedException
	{

		WebDriverWait wait = new WebDriverWait(driver, 120);

		ArrayList<String> baselineValue = new ArrayList<String>();

		try{
			PricingAdminPage pageObj1 = PageFactory.initElements(driver, PricingAdminPage.class);
			//ArrayList<String> prodCombo=
			pageObj1.gotoProduct(BU,ProductType,Product);

			//Validate Baseline Value
			WebElement baseLineButton=driver.findElement(By.xpath("//*[contains(text(),'Baseline')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", baseLineButton);
			baseLineButton.click();

			WebElement ManageButton=driver.findElement(By.xpath("//td[contains(text(),'Manage')]"));

			ManageButton.click();

			WebElement baseLineDisplayValue=driver.findElement(By.xpath("//*[contains(text(),'$')]"));
			String value1=baseLineDisplayValue.getText();		

			baseLineDisplayValue.click();

			WebElement baseLineStoredValue=driver.findElement(By.xpath("//input[@ng-model='popUpValue.BaselineValue']"));
			String value2=baseLineStoredValue.getAttribute("value");
			Logger.info(value2);
			
			//Update Data validation
			WebElement baseLineEnteredValue=driver.findElement(By.xpath("//*[@id='baselineAdPriceEdit']"));
			String tempvalue2="10000.00";
			baseLineStoredValue.clear();
			baseLineStoredValue.sendKeys(tempvalue2);
			Logger.info(tempvalue2);
			
			
			WebElement SubmitButton=driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			SubmitButton.click();
			Thread.sleep(5000);
			//Logger.info("Sumbit");
			
			//24,670.00
			pageObj1.btnRefresh.click();
			
			Thread.sleep(2000);
			//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()='Succussflly reloaded pricing data']"))));
			if(driver.findElement(By.xpath("//*[text()='Succussflly reloaded pricing data']")).isDisplayed())
			Logger.info("Successfully reloaded Pricing Data");
			
			String tempvalue1=baseLineDisplayValue.getText();		
			baseLineDisplayValue.click();
			
			tempvalue2=baseLineStoredValue.getAttribute("value");
			
			if(tempvalue1.equals(tempvalue2))
			{
				baselineValue.add("Pass");
			}
			else
				baselineValue.add("Fail");

			
			//Reset Original Value
			baseLineStoredValue.clear();
			baseLineStoredValue.sendKeys(value2);
			
			SubmitButton.click();
			Thread.sleep(5000);
			pageObj1.btnRefresh.click();
			
			Thread.sleep(2000);
			//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()='Succussflly reloaded pricing data']"))));
			if(driver.findElement(By.xpath("//*[text()='Succussflly reloaded pricing data']")).isDisplayed())
			Logger.info("Successfully reloaded Pricing Data");
			
			value1=baseLineDisplayValue.getText();		
			baseLineDisplayValue.click();
			
			value2=baseLineStoredValue.getAttribute("value");
			
			value2="$"+value2;
			Logger.info(value2);

			if(value1.equals(value2))
			{
				Logger.info(value1);
				baselineValue.add(value1);
				baselineValue.add(value2);
			}

			WebElement CloseButton=driver.findElement(By.xpath("//*[contains(text(),'Close')]"));
			CloseButton.click();
			
			Thread.sleep(5000);

			DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
			util.clickWebElement(dashboard.priceAdminLink);

		}
		catch(Exception e)
		{
			Logger.info(e.getMessage());
		}
		return baselineValue;

	}

	public String DaysOfWeekModifierValidation(String BU,String ProductType,String Product) throws Exception
	{

		WebDriverWait wait = new WebDriverWait(driver, 30);

		ArrayList<String> ActiveDaysValue = new ArrayList<String>();

		ArrayList<String> ActiveDaysProdAdminValue = new ArrayList<String>();
		ArrayList<String> ActiveDaysPriceAdminValue = new ArrayList<String>();

		//Goto Prod Admin
		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		util.clickWebElement(dashboard.prodAdminLink);

		//Goto product combination
		PricingAdminPage pageObj1 = PageFactory.initElements(driver, PricingAdminPage.class);
		//ArrayList<String> prodCombo1 = 
		pageObj1.gotoProduct(BU,ProductType,Product);

		//Validate Active Days of Week
		try{
			//Collect Active Days in Prod Admin
			WebElement ActiveDaysofWeekButton=driver.findElement(By.xpath("//*[text()='Active Days of Week']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ActiveDaysofWeekButton);
			ActiveDaysofWeekButton.click();


			for(int i=1;i<8;i++)
			{
				try
				{
					switch(i)
					{
					case 1:
						WebElement ActiveDay1=driver.findElement(By.xpath("(//*[(text()='Sunday')]/../following-sibling::div)//input[(@class='ng-pristine ng-untouched ng-valid ng-not-empty')]"));
						if(ActiveDay1.isDisplayed())
						{
							ActiveDaysProdAdminValue.add("Sunday");
						}
						break;
					case 2:
						WebElement ActiveDay2=driver.findElement(By.xpath("(//*[(text()='Monday')]/../following-sibling::div)//input[(@class='ng-pristine ng-untouched ng-valid ng-not-empty')]"));
						if(ActiveDay2.isDisplayed())
						{
							ActiveDaysProdAdminValue.add("Monday");
						}
						break;
					case 3:
						WebElement ActiveDay3=driver.findElement(By.xpath("(//*[(text()='Tuesday')]/../following-sibling::div)//input[(@class='ng-pristine ng-untouched ng-valid ng-not-empty')]"));
						if(ActiveDay3.isDisplayed())
						{
							ActiveDaysProdAdminValue.add("Tuesday");
						}
						break;
					case 4:
						WebElement ActiveDay4=driver.findElement(By.xpath("(//*[(text()='Wednesday')]/../following-sibling::div)//input[(@class='ng-pristine ng-untouched ng-valid ng-not-empty')]"));
						if(ActiveDay4.isDisplayed())
						{
							ActiveDaysProdAdminValue.add("Wednesday");
						}
						break;
					case 5:
						WebElement ActiveDay5=driver.findElement(By.xpath("(//*[(text()='Thursday')]/../following-sibling::div)//input[(@class='ng-pristine ng-untouched ng-valid ng-not-empty')]"));
						if(ActiveDay5.isDisplayed())
						{
							ActiveDaysProdAdminValue.add("Thursday");
						}
						break;
					case 6:
						WebElement ActiveDay6=driver.findElement(By.xpath("(//*[(text()='Friday')]/../following-sibling::div)//input[(@class='ng-pristine ng-untouched ng-valid ng-not-empty')]"));
						if(ActiveDay6.isDisplayed())
						{
							ActiveDaysProdAdminValue.add("Friday");
						}
						break;
					case 7:
						WebElement ActiveDay7=driver.findElement(By.xpath("(//*[(text()='Saturday')]/../following-sibling::div)//input[(@class='ng-pristine ng-untouched ng-valid ng-not-empty')]"));
						if(ActiveDay7.isDisplayed())
						{
							ActiveDaysProdAdminValue.add("Saturday");
						}
						break;
					}
				}
				catch(Exception e)
				{

				}
			}

			//pageObj1.resetProdCombo(prodCombo1);

			//Goto Price Admin and product combination
			DashboardPage dashboard1 = PageFactory.initElements(driver, DashboardPage.class);
			util.clickWebElement(dashboard1.priceAdminLink);

			//Goto product combination
			PricingAdminPage pageObj2 = PageFactory.initElements(driver, PricingAdminPage.class);
			//ArrayList<String> prodCombo2 = 
			pageObj2.gotoProduct(BU,ProductType,Product);


			//Check Active Days in Price Admin collected from Prod Admin
			WebElement DaysofWeekButton=driver.findElement(By.xpath("//*[contains(text(),'Days of Week')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", DaysofWeekButton);
			DaysofWeekButton.click();

			for(int i=1;i<8;i++)
			{
				try
				{
					switch(i)
					{
					case 1:
						String xpath01="(//*[contains(text(),'Days of Week')]/../../../../following-sibling::div//tr)["+1+"]/td";
						WebElement ActiveDay1=driver.findElement(By.xpath(xpath01));
						if(ActiveDay1.isDisplayed())
						{
							ActiveDaysPriceAdminValue.add(ActiveDay1.getText().trim());
						}
						break;
					case 2:
						String xpath02="(//*[contains(text(),'Days of Week')]/../../../../following-sibling::div//tr)["+2+"]/td";
						WebElement ActiveDay2=driver.findElement(By.xpath(xpath02));
						if(ActiveDay2.isDisplayed())
						{
							ActiveDaysPriceAdminValue.add(ActiveDay2.getText().trim());
						}
						break;
					case 3:
						String xpath03="(//*[contains(text(),'Days of Week')]/../../../../following-sibling::div//tr)["+3+"]/td";
						WebElement ActiveDay3=driver.findElement(By.xpath(xpath03));
						if(ActiveDay3.isDisplayed())
						{
							ActiveDaysPriceAdminValue.add(ActiveDay3.getText().trim());
						}
						break;
					case 4:
						String xpath04="(//*[contains(text(),'Days of Week')]/../../../../following-sibling::div//tr)["+4+"]/td";
						WebElement ActiveDay4=driver.findElement(By.xpath(xpath04));
						if(ActiveDay4.isDisplayed())
						{
							ActiveDaysPriceAdminValue.add(ActiveDay4.getText().trim());
						}
						break;
					case 5:
						String xpath05="(//*[contains(text(),'Days of Week')]/../../../../following-sibling::div//tr)["+5+"]/td";
						WebElement ActiveDay5=driver.findElement(By.xpath(xpath05));
						if(ActiveDay5.isDisplayed())
						{
							ActiveDaysPriceAdminValue.add(ActiveDay5.getText().trim());
						}
						break;
					case 6:
						String xpath06="(//*[contains(text(),'Days of Week')]/../../../../following-sibling::div//tr)["+6+"]/td";
						WebElement ActiveDay6=driver.findElement(By.xpath(xpath06));
						if(ActiveDay6.isDisplayed())
						{
							ActiveDaysPriceAdminValue.add(ActiveDay6.getText().trim());
						}
						break;
					case 7:
						String xpath07="(//*[contains(text(),'Days of Week')]/../../../../following-sibling::div//tr)["+7+"]/td";
						WebElement ActiveDay7=driver.findElement(By.xpath(xpath07));
						if(ActiveDay7.isDisplayed())
						{
							ActiveDaysPriceAdminValue.add(ActiveDay7.getText().trim());
						}
						break;
					}
				}
				catch(Exception e)
				{

				}
			}

			//pageObj2.resetProdCombo(prodCombo2);

			String ActiveDays="";

			if(ActiveDaysProdAdminValue.size()==ActiveDaysPriceAdminValue.size())
			{
				for(int p=0;p<ActiveDaysPriceAdminValue.size();p++)
				{
					if(ActiveDaysProdAdminValue.get(p).equals(ActiveDaysPriceAdminValue.get(p)))
					{
						//ActiveDaysValue.add(ActiveDaysProdAdminValue.get(p).substring(0,2));
						ActiveDays=ActiveDays+ActiveDaysProdAdminValue.get(p).substring(0,2)+" ";
					}

					if(p==(ActiveDaysPriceAdminValue.size()-1))
						return ActiveDays;
				}
			}

		}
		catch(Exception e)
		{
			Logger.info(e.getMessage());
		}
		return null;

	}
	@Test(groups = {"ZoneModifierValidation"}, dataProviderClass = com.tribune.adit2.data.TribuneUserDataProvider.class, dataProvider = "userData")
	 
	public String ZoneModifierValidation(String BU,String ProductType,String Product) throws Exception
	{

		WebDriverWait wait = new WebDriverWait(driver, 30);

		ArrayList<String> ZoneModifierValue = new ArrayList<String>();

		ArrayList<String> ZoneModifierProdAdminValue = new ArrayList<String>();
		ArrayList<String> ZoneModifierPriceAdminValue = new ArrayList<String>();

		

		//Validate Active Zones
		try{
			
			//Goto Prod Admin
			DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
			util.clickWebElement(dashboard.prodAdminLink);

			//Goto product combination
			PricingAdminPage pageObj1 = PageFactory.initElements(driver, PricingAdminPage.class);
			//ArrayList<String> prodCombo1 = 
			pageObj1.gotoProduct(BU,ProductType,Product);

			try{
				//Collect Active Zones in Prod Admin
				WebElement ZoneModifierButton=driver.findElement(By.xpath("//*[text()='Zone Management']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ZoneModifierButton);
				ZoneModifierButton.click();


				for(int i=1;i<10;i++)
				{
					try
					{
						String xpathProdAdminZone="((//div[(@class='ui-grid-top-panel')]//*[text()='Name']/../../../../../../../../../following-sibling::div//*[(@class='ui-grid-row ng-scope')])["+i+"]//*[@class='ng-isolate-scope']/div)[2]/div";
						WebElement prodAdminZones=driver.findElement(By.xpath(xpathProdAdminZone));
						//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", prodAdminZones);
						ZoneModifierProdAdminValue.add(prodAdminZones.getText());
					}
					catch(Exception e)
					{
						break;
						//Logger.info(e.getMessage());
					}
				}

				//pageObj1.resetProdCombo(prodCombo1);

				//Goto Price Admin and product combination
				DashboardPage dashboard1 = PageFactory.initElements(driver, DashboardPage.class);
				util.clickWebElement(dashboard1.priceAdminLink);

				//Goto product combination
				PricingAdminPage pageObj2 = PageFactory.initElements(driver, PricingAdminPage.class);
				//ArrayList<String> prodCombo2 = 
				pageObj2.gotoProduct(BU,ProductType,Product);


				//Collect Active Zones in Prod Admin
				WebElement ZonesButton=driver.findElement(By.xpath("//*[contains(text(),'Zones')]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ZonesButton);
				ZonesButton.click();


				for(int i=1;i<10;i++)
				{
					try
					{
						String xpathPriceAdminZone="(//*[contains(text(),'Zones')]/../../../../following-sibling::div//tr)["+i+"]";
						WebElement priceAdminZones=driver.findElement(By.xpath(xpathPriceAdminZone));
						//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", priceAdminZones);
						ZoneModifierPriceAdminValue.add(priceAdminZones.getText());
					}
					catch(Exception e)
					{
						break;
						//Logger.info(e.getMessage());
					}
				}
				//pageObj2.resetProdCombo(prodCombo2);

				String ZoneModifier="";

				if(ZoneModifierProdAdminValue.size()==ZoneModifierPriceAdminValue.size())
				{
					for(int p=0;p<ZoneModifierPriceAdminValue.size();p++)
					{
						/*Logger.info(ZoneModifierPriceAdminValue.get(p));
						Logger.info(ZoneModifierProdAdminValue.get(p));*/
						if(ZoneModifierProdAdminValue.get(p).equals(ZoneModifierPriceAdminValue.get(p)))
						{
							//ZoneModifierValue.add(ZoneModifierProdAdminValue.get(p).substring(0,2));
							ZoneModifier=ZoneModifier+ZoneModifierProdAdminValue.get(p)+", ";
						}

						if(p==(ZoneModifierPriceAdminValue.size()-1))
							return ZoneModifier;
					}
				}

			}
			catch(Exception e)
			{
				Logger.info(e.getMessage());
			}
		}
		catch(Exception e1)
		{
			Logger.info(e1.getMessage());
			return "0";
		}
		return null;

	}

	public String AdTypeModifierValidation(String BU,String ProductType,String Product) throws Exception
	{
	
		WebDriverWait wait = new WebDriverWait(driver, 30);
	
		ArrayList<String> AdTypeModifierValue = new ArrayList<String>();
	
		ArrayList<String> AdTypeModifierProdAdminValue = new ArrayList<String>();
		ArrayList<String> AdTypeModifierPriceAdminValue = new ArrayList<String>();
	
		
	
		//Validate Active AdType
		try{
			
			//Goto Prod Admin
			DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
			util.clickWebElement(dashboard.prodAdminLink);
	
			//Goto product combination
			PricingAdminPage pageObj1 = PageFactory.initElements(driver, PricingAdminPage.class);
			//ArrayList<String> prodCombo1 = 
			pageObj1.gotoProduct(BU,ProductType,Product);
	
			try{
				//Collect Active AdType in Prod Admin
				WebElement AdTypeModifierButton=driver.findElement(By.xpath("//*[text()='Ad Type Management']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AdTypeModifierButton);
				AdTypeModifierButton.click();
	
	
				for(int i=1;i<10;i++)
				{
					try
					{
						String xpathProdAdminAdType1="((//div[(@class='ui-grid-top-panel')]//*[text()='AdType']/../../../../../../../../../following-sibling::div//*[(@class='ui-grid-row ng-scope')])["+i+"]//*[@class='ng-isolate-scope']/div)//div";
						WebElement prodAdminAdType1=driver.findElement(By.xpath(xpathProdAdminAdType1));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", prodAdminAdType1);
						
						String xpathProdAdminAdType2="((//div[(@class='ui-grid-top-panel')]//*[text()='AdType']/../../../../../../../../../following-sibling::div//*[(@class='ui-grid-row ng-scope')])["+i+"]//*[@class='ng-isolate-scope']/div)//input[@class='ng-pristine ng-untouched ng-valid ng-not-empty']";
						WebElement prodAdminAdType2=driver.findElement(By.xpath(xpathProdAdminAdType2));
						//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", prodAdminAdType1);
						
						if(prodAdminAdType1.isDisplayed() && prodAdminAdType2.isDisplayed())						
						AdTypeModifierProdAdminValue.add(prodAdminAdType1.getText());
					}
					catch(Exception e)
					{
						String xpathProdAdminAdType2="((//div[(@class='ui-grid-top-panel')]//*[text()='AdType']/../../../../../../../../../following-sibling::div//*[(@class='ui-grid-row ng-scope')])["+i+"]//*[@class='ng-isolate-scope']/div)//input[@class='ng-pristine ng-untouched ng-valid ng-empty']";
						WebElement prodAdminAdType2=driver.findElement(By.xpath(xpathProdAdminAdType2));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", prodAdminAdType2);
						
					}
				}
	
				//pageObj1.resetProdCombo(prodCombo1);
	
				//Goto Price Admin and product combination
				DashboardPage dashboard1 = PageFactory.initElements(driver, DashboardPage.class);
				util.clickWebElement(dashboard1.priceAdminLink);
	
				//Goto product combination
				PricingAdminPage pageObj2 = PageFactory.initElements(driver, PricingAdminPage.class);
				//ArrayList<String> prodCombo2 = 
				pageObj2.gotoProduct(BU,ProductType,Product);
	
	
				//Collect Active AdType in Prod Admin
				WebElement AdTypeButton=driver.findElement(By.xpath("//*[contains(text(),'Ad Types')]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AdTypeButton);
				AdTypeButton.click();
	
	
				for(int i=1;i<10;i++)
				{
					try
					{
						String xpathPriceAdminAdType="(//*[contains(text(),'Ad Types')]/../../../../following-sibling::div//tr)["+i+"]";
						WebElement priceAdminAdType=driver.findElement(By.xpath(xpathPriceAdminAdType));
						//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", priceAdminAdType);
						AdTypeModifierPriceAdminValue.add(priceAdminAdType.getText());
					}
					catch(Exception e)
					{
						//Logger.info(e.getMessage());
						break;
					}
				}
				//pageObj2.resetProdCombo(prodCombo2);
	
				String AdTypeModifier="";
	
				if(AdTypeModifierProdAdminValue.size()==AdTypeModifierPriceAdminValue.size())
				{
					for(int p=0;p<AdTypeModifierPriceAdminValue.size();p++)
					{
						/*Logger.info(AdTypeModifierPriceAdminValue.get(p));
						Logger.info(AdTypeModifierProdAdminValue.get(p));*/
						if(AdTypeModifierProdAdminValue.get(p).equals(AdTypeModifierPriceAdminValue.get(p)))
						{
							//AdTypeModifierValue.add(AdTypeModifierProdAdminValue.get(p).substring(0,2));
							AdTypeModifier=AdTypeModifier+AdTypeModifierProdAdminValue.get(p)+", ";
						}
	
						if(p==(AdTypeModifierPriceAdminValue.size()-1))
							return AdTypeModifier;
					}
				}
	
			}
			catch(Exception e)
			{
				Logger.info(e.getMessage());
			}
		}
		catch(Exception e1)
		{
			Logger.info(e1.getMessage());
			return "0";
		}
		return null;
	
	}
	
		
	}





