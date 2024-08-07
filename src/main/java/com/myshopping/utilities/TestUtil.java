package com.myshopping.utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.myshopping.base.Constants;

public class TestUtil {
/*
	@DataProvider(name="dp")
	public Object[][] getData(Method m){
		
		String sheetName = m.getName();
		int rows = Constants.excel.getRowCount(sheetName);
		int cols = Constants.excel.getColumnCount(sheetName);
		
		Object [][] data =  new Object[rows-1][1];
		
		Hashtable<String, String> table = null;
		for(int rowNum = 2; rowNum<= rows; rowNum++) {
		
			table = new Hashtable<String,String>();
		
			for(int colNum = 0; colNum<cols ;colNum++) {
				
				table.put(Constants.excel.getCellData(sheetName, colNum, 1), Constants.excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum-2][0] = table;
			}
		}
		
		return data;
	}
	
	public static boolean isTestRunnable(String testName,ExcelReader excel) {
		String sheetName= "test_suite";
		int rows = excel.getRowCount(sheetName);
		
		for (int rNum= 2;rNum<=rows; rNum++) {
			String testCase= excel.getCellData(sheetName, "TCID", rNum);
			if(testCase.equalsIgnoreCase(testName)) {
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
				System.out.print(testName + "-*****: runmode " + runmode);
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else return false;
			}
		}
		return false;
	}*/
	
	
}
