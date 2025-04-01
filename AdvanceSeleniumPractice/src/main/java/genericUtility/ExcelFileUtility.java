package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	public String readingDatafromExcel(String sheet,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\sudha\\eclipse-workspace\\newjavaproject\\src\\sudha\\AdvanceSeleniumPractice\\src\\test\\resources\\BoTestScript.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(sheet).getRow(rowNum).getCell(cellNum).getStringCellValue();
	return data;
	}

}
