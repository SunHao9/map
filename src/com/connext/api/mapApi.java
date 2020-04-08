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
public class mapApi {

	
	public static void main(String[] args) throws Exception {
		
		
		//获取经纬度
		//String key="e192eb1547f3c11149c4b7ccac70abd8";//高德用户key
		String key="3aa303267c4634a7a69ae8b114c60433";//高德用户key
		//new key  
		//679598793dff4a07867c14ddbf94206b
		//读取Excle
		String filePath ="E:\\upload\\sunhao.xlsx";
		

		 XSSFWorkbook wookbook = new XSSFWorkbook(new FileInputStream(filePath));

		  XSSFSheet sheet = wookbook.getSheetAt(0);
		  
		  String exportPath ="E:\\upload\\export\\sunhao_{date1}.xlsx";
		  InputStream  in = new FileInputStream(exportPath);
		  XSSFWorkbook wb = new XSSFWorkbook(in);
		  XSSFSheet outsheet = wb.getSheetAt(0);
		  
		  for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++){
			  XSSFCell sheng = sheet.getRow(j).getCell(2);
			  String shengCellValue = sheng.getStringCellValue();
			  
//			  XSSFCell shi = sheet.getRow(j).getCell(3);
//			  String shiCellValue = shi.getStringCellValue();
//			  
//			  XSSFCell qu = sheet.getRow(j).getCell(4);
//			  String quCellValue = qu.getStringCellValue();
			  
//			  String address=shengCellValue+shiCellValue+quCellValue;
			  String address=shengCellValue;
			  System.out.println(address);
			  
			  Double gongli;
			try {
				CodeUtil codeUtil = new CodeUtil(address, key); 
//			  北京 116.407526,39.904030
				//北京顺义机场 116.623689,40.051256
				  CodeResults results;
				
					results = codeUtil.getResults();
				
				  String destination = results.getLocation();
				  //TruckUtil mapResult = new TruckUtil("116.407526,39.904030", destination, key);
				  //固定起点 todo
				  MapNavUtil mapResult=new MapNavUtil("116.623689,40.051256", destination, key);
				  String distance = mapResult.getResults().getDistance();
				  int parseInt = Integer.parseInt(distance);
				  double parseDouble = Double.parseDouble(distance);
				  gongli = parseDouble/1000;
				  //int gongli=parseInt/1000;
				  //设置
				   XSSFCell createCell = outsheet.getRow(j).createCell(5);
				   createCell.setCellValue(gongli);
				   System.out.println(j);
					  System.out.println(gongli);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("错误行号:"+j);
				e.printStackTrace();
			}
			  
			  
		  }
		  
		  String path = exportPath.replace("{date1}", "new0906s");
		  wb.write(new FileOutputStream(path));
		/*//地理编码 API 服务地址
		CodeUtil codeUtil = new CodeUtil("常州市金坛区", key);
		
		CodeResults results = codeUtil.getResults();
		String location = results.getLocation();
		System.out.println(location);
		String origin="119.641255,31.720380";//出发点经纬度
		String destination="129.508946,42.891255";//目的地经纬度
		
		
		//MapNavUtil mapResult=new MapNavUtil(origin, destination, key);
		 TruckUtil mapResult = new TruckUtil(location, destination, key);
		System.out.println(mapResult.getResults().getDistance());*/
//2055860米  公里2055
		  System.out.println("================完成=====================");
	}
}
