package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class getReportOutputFormats {
	public static WebDriver driver;
	public getReportOutputFormats(WebDriver driver2) {
		this.driver=driver2;
	}

	public ArrayList<String> getdata(String reportname) throws IOException {
		// file input stream argument
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Page Object Mapping.xlsx");
		ArrayList<String> a = new ArrayList<String>();
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheet = workbook.getNumberOfSheets();
		for (int i = 0; i < sheet; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Report Format Data")) {
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
//				System.out.println(column);

				// once column is identified then scan entire test case column to identify
				// purchase testcase row

				while (rows.hasNext()) {
					Row r = rows.next();
//					System.out.println(r.getCell(column).getStringCellValue());
//					a.add(r.getCell(column).getStringCellValue());
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(reportname)) {
						// after you grab purchase testcase row = pull all the row data and feed in to
						// test

						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c=cv.next();
							if(c.getCellType()==CellType.STRING)
							{

							/* System.out.println(cv.next().getStringCellValue()); */
							a.add(c.getStringCellValue());
							}
							else
							{
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								
							}
						}
						
					}
				}
			}

		}
		return a;
	}
	public static void main(String[] args) throws IOException {
		
		getReportOutputFormats format=new getReportOutputFormats(driver);
		ArrayList<String> list= format.getdata("Customers details");
		System.out.println(list.get(1));
		
		String[] arrayoutputformats=list.get(1).split(",");
		for(String value:arrayoutputformats)
		{
			System.out.println(value);
		}

	}

}
