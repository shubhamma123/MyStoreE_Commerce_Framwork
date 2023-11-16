package com.myStore.UtilityLayer;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcelFile_DataPRovider {

	public static FileInputStream fileInputStream;
	public static 	XSSFWorkbook workbook;
	public static   XSSFSheet excelsheet;
	public static  XSSFRow row;
	public static 	XSSFCell cell;


public static String ReadDataExcelSheetcellvalue(String Filename,String sheetname,int rownumber,int cellnum) throws IOException {
	fileInputStream = new FileInputStream(Filename);
	workbook=new XSSFWorkbook(fileInputStream);
	cell=workbook.getSheet(sheetname).getRow(rownumber).getCell(cellnum);
	DataFormatter df =new DataFormatter();
	String value =df.formatCellValue(cell);
	return value;
	//another method use getstringcell value
	//return cell.getStringCellValue();
}
public static  int getrowcount(String Filename,String sheetnam) throws IOException {
	fileInputStream = new FileInputStream(Filename);
	workbook=new XSSFWorkbook(fileInputStream);
	excelsheet =workbook.getSheet(sheetnam);
	 int ttrow =excelsheet.getLastRowNum()+1;
	 workbook.close();
	return ttrow;
}
public static  int getcolmcunt(String Filename,String sheetname) throws IOException {
	fileInputStream = new FileInputStream(Filename);
	workbook=new XSSFWorkbook(fileInputStream);
	excelsheet =workbook.getSheet(sheetname);
	 int ttcell =excelsheet.getRow(0).getLastCellNum();
	 workbook.close();
	return ttcell;


}
@DataProvider(name="logindataprovider")
public String[][] dataprovide() throws IOException{
	String pathfile=System.getProperty("user.dir")+"\\TestDataStore\\DataExcel.xlsx";
	int ttrow=ReadExcelFile_DataPRovider.getrowcount(pathfile, "Sheet2");
	int ttcom=ReadExcelFile_DataPRovider.getcolmcunt(pathfile, "Sheet2");
	String [][] data=new String[ttrow-1][ttcom];
	 for(int i=1;i<ttrow;i++) {
		 for(int j=0;j<ttcom;j++) {
			 
			 data[i-1][j]=ReadExcelFile_DataPRovider.ReadDataExcelSheetcellvalue(pathfile,"Sheet2",i,j );
		 }
	 }
		 
	return data;
}
}