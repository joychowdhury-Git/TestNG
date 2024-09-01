package com.tribune.adit2.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;


public class TribuneUserDataProvider {
	
	WebDriver driver;

	@DataProvider(name="userData")
	public static Object[][] userSampleData() 
	{
		Map<String,String> userDataMap = new HashMap<String,String>();
		
		/* Customer Details */
		userDataMap.put("CustomerName4", "Group 7 House Account");
		userDataMap.put("CustomerName5", "Daily Press Test Account");
		
		userDataMap.put("CustomerName", "Test 1107");
		userDataMap.put("CustomerName1", "Macy's (LAT)");
		userDataMap.put("CUNumber", "CU00380012");
		userDataMap.put("CustomerName2", "Suraj Mehta");
		userDataMap.put("CustomerName3", "Kit Jackson");
		userDataMap.put("zipCode", "23188");
		userDataMap.put("ContactName1", "Xavier's and Co.");
		userDataMap.put("StreetAddress", "124 Main St");
		userDataMap.put("Street2Address", "3909 Witmer Road.");
		userDataMap.put("City", "Niagara Falls");
		userDataMap.put("State", "NY");
		userDataMap.put("Zip", "14305");
		userDataMap.put("PhoneNumber", "1234567890");
		userDataMap.put("Fax", "987654321");
		userDataMap.put("Email", "abc@xyz.com");
		userDataMap.put("Additional Email", "abc23@xy34.com");

		/*Order Details */
		userDataMap.put("ClassCode", "50150");
		userDataMap.put("MMTag", "Demo Tag");
		
		
		/*Error Messages*/
		userDataMap.put("MandatorySoldTo", "Sold To customer is required");
		userDataMap.put("MandatoryBillTo", "Bill To customer is required");
		userDataMap.put("MandatoryPO#SpecificBillTo", "This Bill To customer requires a Purchase Order Number. please Enter a PO#.");
		userDataMap.put("ProspectSoldToCustNewOrder", "Can't submit order with a prospect Sold To customer. Replace Sold To customer with an actual customer");
		userDataMap.put("ProspectBillToCustNewOrder", "Can't submit order with a prospect Bill To customer. Replace Bill To customer with an actual customer");
		userDataMap.put("BillToCreditStatus", "Can't submit order due to Bill To customer credit status");
		userDataMap.put("MandatorySalesPerson", "Sales person is required");
		userDataMap.put("MandatoryPrimarySalesPerson", "One and only one primary sales person is required");
		userDataMap.put("MandatoryInsertion", "Insertion is required");
		userDataMap.put("ErrWithoutProduct", "Product is required for insertion");
		userDataMap.put("ErrWithoutAdType", "Ad Type is required for insertion");
		userDataMap.put("ErrWithoutSection", "Section is required for insertion");
		userDataMap.put("ErrWithoutZone", "Zone is required for insertion");
		userDataMap.put("ErrWithoutAdSize", "Ad size is required for insertion");
		userDataMap.put("ErrWithoutPandDSpec", "P&D specification for insertion  must be filled in");
		userDataMap.put("ErrRequiredFold","P&D specification: Fold for insertion  is required");
		userDataMap.put("ErrRequiredCreativeLoc","P&D specification: CreativeLocation for insertion  is required");
		userDataMap.put("MandatoryVersionID", "Version is required for insertion");
		userDataMap.put("MandatoryDistrb/BilledQty", "Distribution/Billed Quantity is required for insertion");
		userDataMap.put("MandatoryPositionTemp", "Templated Position is required for insertion");
		userDataMap.put("NoOrderlinePackageError", "There is no insertion to create a package");
		
		return new Object[][] { { userDataMap } };
	}
	
@DataProvider(name="devices")
	public static Object[][] deviceData() 
	{
	Map<String,String> userDataMap = new HashMap<String,String>();
	
	userDataMap.put("tags", "desktop");
	userDataMap.put("tags", "mobile");
	
	return new Object[][] { { userDataMap } };
		
	}

@DataProvider(name="devices")
public static String GalenDevices() 
{
	List<String> listOfDevices = Arrays.asList("desktop");
	return listOfDevices.get(0);
}

}
