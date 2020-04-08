package com.connext.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class mapAction  extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware {



	private HttpServletRequest request;
    private HttpServletResponse response;
    
    private Map session;
	
	private File mapFile;
	private String excelFileFileName;
	

	public File getMapFile() {
		return mapFile;
	}

	public void setMapFile(File mapFile) {
		this.mapFile = mapFile;
	}

	public void uploadfile() throws Exception {

		String name = mapFile.getName();
		Workbook workBook=createWorkbook(new FileInputStream(mapFile));
		Sheet sheetAt = workBook.getSheetAt(0);
		System.out.println(name);
	}
	//判断文件类型创建Workbook对象
    public Workbook createWorkbook(InputStream is) throws Exception{
    	if(excelFileFileName.toLowerCase().endsWith("xls")){
    		return new HSSFWorkbook(is);
    	}
    	if(excelFileFileName.toLowerCase().endsWith("xlsx")){
    		return new XSSFWorkbook(is);
    	}
    	return null;
    }


	public String getExcelFileFileName() {
		return excelFileFileName;
	}

	public void setExcelFileFileName(String excelFileFileName) {
		this.excelFileFileName = excelFileFileName;
	}

	public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setSession(Map session) {
        this.session = session;
    }
	public static ServletContext getServletContext() {
        return ServletActionContext.getServletContext();
    }
}
