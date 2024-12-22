package utilities;

import java.lang.reflect.Method;


import org.testng.annotations.DataProvider;

import testcases.BaseTest;

public class DataUtil extends BaseTest{
	
	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {
		
		/* The Method m :
		 * The Method m parameter is used to dynamically retrieve the test method's name
		 * at runtime when the data provider is invoked. This is particularly useful in
		 * the context of the TestNG framework, where a data provider supplies test data
		 * for test methods.
		 * 
		 * Key Aspects of Method m: Dynamic Data Selection:
		 * 
		 * The Method object represents the test method that is currently being
		 * executed. The getName() method on the Method object retrieves the name of the
		 * test method. Purpose in the Code:
		 * 
		 * The sheetName variable is assigned the name of the test method. This allows
		 * you to dynamically choose test data (e.g., from an Excel sheet, database, or
		 * other source) based on the method name. This is useful for situations where
		 * different test methods require different sets of data, and the data provider
		 * can serve data conditionally. How It Works in TestNG:
		 * 
		 * When a test method annotated with @Test is executed, and it references
		 * a @DataProvider, TestNG passes the corresponding Method object to the getData
		 * method if it's defined as a parameter. This allows the data provider to
		 * adjust its behavior based on which test method is currently being executed.
		 */
		String sheetName = m.getName();
		System.out.println("Method/Sheet name is: " + sheetName);
		
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
		System.out.println("Row number is:" + rowNum + " Column number is: " + colNum);
		
		Object[][] data = new Object[rowNum-1][colNum];
	
		
		for(int rows=2;rows<=rowNum; rows++ ) {
			
			
			for(int cols=0; cols<colNum; cols++) {
				
					data[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
			}
			
		}
		
		return data;
		
	}

}
