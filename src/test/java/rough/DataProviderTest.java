package rough;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;

/* Using Apache POI for Excel Data Provider
    Apache POI is a popular library for reading and writing Excel files in Java.
*/

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    @DataProvider(name = "testdata")
    public Object[][] testData() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook("testdata.xlsx");
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rows][cols];

        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return data;
    }

    @Test(dataProvider = "testdata")
    public void testLogin(String username, String password) {
        // Test login functionality with provided username and password
    	System.out.println("Test login functionality with provided username and password");
    }
}

