package dataReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Excel_Reader {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	String filepath = System.getProperty("user.dir")+"/src/main/java/testdata/PWData.xlsx";
	public String readExcel(WebDriver driver, String filepath, String sheetname, int rowNum, int colNum) throws IOException{
		
		
		FileInputStream fis = new FileInputStream(new File(filepath));
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		String cellValue = cell.toString();
		return cellValue;
		
	}

}
