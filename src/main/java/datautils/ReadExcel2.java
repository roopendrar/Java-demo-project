package datautils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel2 {
	
	
	public static String[][] getExcelData() {

		String[][] data = null;
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\acer\\eclipse-workspace\\allegisqa-allegis-automation-SeleniumTask\\src\\main\\resources\\data\\DataProvider.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet("Sheet1");
			XSSFRow row = sh.getRow(0);
			int noOfRows = sh.getPhysicalNumberOfRows();
			int noOfCols = row.getLastCellNum();
			XSSFCell cell;
			data = new String[noOfRows - 1][noOfCols];

			for (int i = 1; i < noOfRows; i++) {
				for (int j = 0; j < noOfCols; j++) {
					row = sh.getRow(i);
					cell = row.getCell(j);
					data[i - 1][j] = cell.getStringCellValue();
				}
			}
		} catch (Exception e) {
			System.out.println("The exception is: " + e.getMessage());
		}

		return data;
	}
}
