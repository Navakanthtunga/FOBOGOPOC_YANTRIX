package generic_lib;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenericLib {
	
	public static String sDirPath=System.getProperty("user.dir");
	public static String testDataFilePath=sDirPath+"//testdata//TestData.xlsx";
	
	
	public static String toReadExcelData(String filePath,String sheetName,int rowNum,int cellNum)
	 {
		 String dataNew=null;
		 try{
		 	FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sheetName);
			dataNew=sht.getRow(rowNum).getCell(cellNum).getStringCellValue();
		 }
		 catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	return dataNew ;
}
}
