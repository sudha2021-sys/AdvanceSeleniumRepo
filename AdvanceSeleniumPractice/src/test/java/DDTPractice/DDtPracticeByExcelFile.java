package DDTPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDtPracticeByExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
FileInputStream fis=new FileInputStream("C:\\Users\\sudha\\eclipse-workspace\\newjavaproject\\src\\sudha\\AdvanceSeleniumPractice\\src\\test\\resources\\BoTestScript.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String Campaign = wb.getSheet("DDT").getRow(1).getCell(2).getStringCellValue();
	System.out.println(Campaign);
 double targetSize = wb.getSheet("DDT").getRow(1).getCell(3).getNumericCellValue();
 System.out.println(targetSize);
 

	}
}