package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static FileInputStream fis = null;
	public FileOutputStream fos = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Map<String, String>> readstringdata() throws IOException {
		List<Map<String, String>> data = null;
		Map<String, String> testdata = new HashMap<String, String>();
		try {
			fis = new FileInputStream(new File(
					"C:\\Users\\mrajendra\\eclipse-workspace\\allegisqa-allegis-automation-SeleniumTask\\allegisqa-allegis-automation-SeleniumTask\\src\\main\\resources\\data"));
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			int lastcolnum = sheet.getRow(0).getLastCellNum();

			List list = new ArrayList();

			for (int i = 0; i < lastcolnum; i++) {
				row = sheet.getRow(0);
				cell = row.getCell(i);
				String rowHeader = cell.getStringCellValue().trim();
				list.add(rowHeader);

			}
			
			data=new ArrayList<Map<String, String>>();
			for (int j = 0; j < lastcolnum; j++) {
				row = sheet.getRow(1);
				cell = row.getCell(j);
				String colvalue =(String) cell.getStringCellValue();
				 testdata.put((String) list.get(j), colvalue);
				 data.add(testdata);	 
			}

		} catch (Exception e) {
			System.out.println("Exception while reading data from Excel file");
			e.printStackTrace();
		} finally {
			fis.close();
			workbook.close();
		}
		return data;
	}
	
	
	

}
