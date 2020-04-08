package com.connext.api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.connext.dto.CodeResults;
import com.connext.utils.CodeUtil;
import com.connext.utils.MapNavUtil;
import com.connext.utils.TruckUtil;
public class JwdApi {

	
	public static void main(String[] args) throws Exception {
		
		
		//获取经纬度
		//String key="e192eb1547f3c11149c4b7ccac70abd8";//高德用户key
		String key="3aa303267c4634a7a69ae8b114c60433";//高德用户key
		//new key  
		//679598793dff4a07867c14ddbf94206b
		//读取Excle
		String filePath ="E:\\upload\\weizhi.xlsx";
		

		 XSSFWorkbook wookbook = new XSSFWorkbook(new FileInputStream(filePath));

		  XSSFSheet sheet = wookbook.getSheetAt(0);
		  
		  String exportPath ="E:\\upload\\export\\weizhi_{date1}.xlsx";
		  InputStream  in = new FileInputStream(exportPath);
		  XSSFWorkbook wb = new XSSFWorkbook(in);
		  XSSFSheet outsheet = wb.getSheetAt(0);
		  
		  for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++){
			  XSSFCell sheng = sheet.getRow(j).getCell(3);
			  String shengCellValue = sheng.getStringCellValue();
			 
			  String address=shengCellValue;
			  System.out.println(address);
			  
			try {
				CodeUtil codeUtil = new CodeUtil(address, key); 
//			  北京 116.407526,39.904030
				//北京顺义机场 116.623689,40.051256
				  CodeResults results;
				
					results = codeUtil.getResults();
				
				  String destination = results.getLocation();
				  String[] split = destination.split(",");
				  String string1 = split[0];
				  System.out.println(string1);
				  String string2 = split[1];
				  System.out.println(string2);
				  //设置
				   XSSFCell createCell = outsheet.getRow(j).createCell(6);
				   XSSFCell createCell2 = outsheet.getRow(j).createCell(7);
				   createCell.setCellValue(string1);
				   createCell2.setCellValue(string2);
				   System.out.println(j);
					  System.out.println(destination);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("错误行号:"+j);
				e.printStackTrace();
			}
			  
			  
		  }
		  
		  String path = exportPath.replace("{date1}", "new0906s");
		  wb.write(new FileOutputStream(path));
		
		  System.out.println("================完成=====================");
	}
}
