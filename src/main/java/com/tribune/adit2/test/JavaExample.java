package com.tribune.adit2.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.tribune.adit2.testng.Logger;
import com.tribune.adit2.util.TribuneUtils;

public class JavaExample {

	public static void main(String[] args) throws ParseException {
		
		 
		String noOfOrdersToKIll = "228";
		Integer result = Integer.valueOf(noOfOrdersToKIll);
		System.out.println("The value is " + result);
		 Scanner scan=new Scanner(System.in);
		 String string= scan.next();
		String url = "http://adorders.tribstage.com/orders/6564544";
		url = url.substring(url.indexOf("//")+2, url.indexOf("/orders")+8);
		System.out.println(url);
	/*	TribuneUtils utils= new TribuneUtils();
		System.out.println(utils.generateRandomString());*/
		 
	}
	


}