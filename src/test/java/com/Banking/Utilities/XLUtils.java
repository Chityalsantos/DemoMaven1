package com.Banking.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fileInput;
	public static FileOutputStream fileOutput;
	public static XSSFWorkbook workbook;
	public static XSSFSheet workSheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException 
	{
		fileInput=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fileInput);
		workSheet=workbook.getSheet(xlsheet);
		int rowcount=workSheet.getLastRowNum();
		workbook.close();
		fileInput.close();
		return rowcount;		
	}
	
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fileInput=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fileInput);
		workSheet=workbook.getSheet(xlsheet);
		row=workSheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fileInput.close();
		return cellcount;
	}
	
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fileInput=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fileInput);
		workSheet=workbook.getSheet(xlsheet);
		row=workSheet.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		workbook.close();
		fileInput.close();
		return data;
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fileInput=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fileInput);
		workSheet=workbook.getSheet(xlsheet);
		row=workSheet.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fileOutput=new FileOutputStream(xlfile);
		workbook.write(fileOutput);		
		workbook.close();
		fileInput.close();
		fileOutput.close();
	}
	
	
}
