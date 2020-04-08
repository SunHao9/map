package com.connext.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcleUtil {

	public void getExcle() throws FileNotFoundException, IOException {

		// String filePath ="C:/Users/daojia/Desktop/test.xlsx";
		 String filePath ="E:\\upload\\sunhao.xlsx";

		 XSSFWorkbook wookbook = new XSSFWorkbook(new FileInputStream(filePath));

		  XSSFSheet sheet = wookbook.getSheetAt(0);
		  for (int j = 6; j < sheet.getPhysicalNumberOfRows(); j++){
			  
			  XSSFCell sheng = sheet.getRow(6).getCell(2);
			  String shengCellValue = sheng.getStringCellValue();
			  
			  XSSFCell shi = sheet.getRow(6).getCell(3);
			  String shiCellValue = shi.getStringCellValue();
			  
			  XSSFCell qu = sheet.getRow(6).getCell(4);
			  String quCellValue = qu.getStringCellValue();
			  
			  String address=shengCellValue+shiCellValue+quCellValue;
			  
			  System.out.println(address);
		  }
		 
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		new ExcleUtil().getExcle();
	}
}
