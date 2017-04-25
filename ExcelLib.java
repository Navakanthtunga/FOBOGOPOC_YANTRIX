package generic_lib;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.fabogo.project_specific_lib.Constants;

public class ExcelLib 
{
	public static String readCellData(String xlpath,String sheetName,int rownum,int cellnum)
	{
		try
		{
			FileInputStream fis = new FileInputStream(xlpath);
			Workbook w1 = WorkbookFactory.create(fis);
			return w1.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();	
		}
		catch(Exception rv)
		{
			return "";
		}
	}
	
	public static int getLastRowNum(String xlpath,String sheetName)
	{
		try
		{
			FileInputStream fis = new FileInputStream(xlpath);
			Workbook w1 = WorkbookFactory.create(fis);
			return w1.getSheet(sheetName).getLastRowNum();
		}
		catch(Exception rv)
		{
			return -1;
		}
	}
	
	public static int getLastCellNum(String xlpath,String sheetName,int rowNum)
	{
		try
		{
			FileInputStream fis = new FileInputStream(xlpath);
			Workbook w1 = WorkbookFactory.create(fis);
			return w1.getSheet(sheetName).getRow(rowNum).getLastCellNum()-1;
		}
		catch(Exception rv)
		{
			return -1;
		}
	}
	
	
	public static String[] getSheetNames(String xlPath)
	{
		try
		{
			FileInputStream fis = new FileInputStream(Constants.KEYWORD_PATH+xlPath+".xlsx");
			Workbook w1 = WorkbookFactory.create(fis);
			int num_of_sheets = w1.getNumberOfSheets();
			String[] sheetNames = new String[num_of_sheets];
			for(int i=0;i<=num_of_sheets-1;i++)
			{
				sheetNames[i]  = w1.getSheetName(i);
			}
			return sheetNames;
		}
		catch(Exception rv)
		{
			return null;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
	