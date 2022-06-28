package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class reportNames {
	public ArrayList<String> getdata() throws IOException {
		// file input stream argument
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Page Object Mapping.xlsx");
		ArrayList<String> a = new ArrayList<String>();
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheet = workbook.getNumberOfSheets();
		for (int i = 0; i < sheet; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Reportdata")) {
				XSSFSheet sheet1 = workbook.getSheetAt(i);
				// Identify TestCase column by scanning first row

				Iterator<Row> rows = sheet1.iterator(); // sheet is collection of rows

				Row firstrow = rows.next(); // get the control of first row

				Iterator<Cell> cells = firstrow.cellIterator();
				int k = 0;
				int column = 0;
				while (cells.hasNext()) {
					Cell value = cells.next();
					if (value.getStringCellValue().equalsIgnoreCase("report_name")) {
						// desire column value
						column = k;
					}
					k++;
				}
				System.out.println(column);

				// once column is identified then scan entire test case column to identify
				// purchase testcase row

				while (rows.hasNext()) {
					Row r = rows.next();
					System.out.println(r.getCell(column).getStringCellValue());
					a.add(r.getCell(column).getStringCellValue());
//					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {
//						// after you grab purchase testcase row = pull all the row data and feed in to
//						// test
//
//						Iterator<Cell> cv = r.cellIterator();
//						while (cv.hasNext()) {
//							Cell c=cv.next();
//							if(c.getCellType()==CellType.STRING)
//							{
//
//							/* System.out.println(cv.next().getStringCellValue()); */
//							a.add(c.getStringCellValue());
//							}
//							else
//							{
//								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
//								
//							}
//						}
//						
//					}
				}
			}

		}
		return a;
	}
	public static void main(String[] args) throws IOException {

		reportNames d=new reportNames();
		ArrayList<String> data= d.getdata();
		Iterator<String> e=data.iterator();
		System.out.println(data.size());
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		System.out.println(data.get(4));
		System.out.println(data.get(5));
		System.out.println(data.get(6));
		System.out.println(data.get(7));
		System.out.println(data.get(8));
		System.out.println(data.get(9));
		
}
}
