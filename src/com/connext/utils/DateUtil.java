package com.connext.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

//	public static String[] getStartDateAndEndDate() {
//		String[] strDate = new String[2];
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		// Date date = new Date(2013-1900,3-1,4);
//		Date date = new Date();
//
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(date);
//
//		int startDate = cal.get(Calendar.DAY_OF_YEAR);
//		cal.set(Calendar.DAY_OF_YEAR, startDate - 2);
//
//		strDate[1] = sdf.format(cal.getTime()) + " 23:59:59";
//
//		int endDate = cal.get(Calendar.DAY_OF_YEAR);
//		cal.set(Calendar.DAY_OF_YEAR, endDate - 7);
//
//		strDate[0] = sdf.format(cal.getTime()) + " 23:59:59";
//
//		return strDate;
//	}
	
	public static String[] getStartDateAndEndDate() {
		String[] strDate = new String[2];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();

		if (getAmOrPm() == 0) {
			strDate[0] = getStrYestoday(date) + " 17:00:00";
			strDate[1] = sdf.format(date) + " 9:00:00";
		}else {
			strDate[0] = sdf.format(date) + " 9:00:00";
			strDate[1] = sdf.format(date) + " 17:00:00";
		}

		return strDate;
	}
	
	public static String[] getStrStartDateAndEndDate() {
		String[] strDate = new String[2];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();

		if (getAmOrPm() == 0) {
			strDate[0] = getStrYestoday(date) + " 00:00:00";
			strDate[1] = getStrYestoday(date) + " 23:59:59";
		}else {
			strDate[0] = sdf.format(date) + " 00:00:00";
			strDate[1] = sdf.format(date) + " 23:59:59";
		}

		return strDate;
	}
	
	public static String[] getStrStartDateAndEndDateCarmen() {
		String[] strDate = new String[2];
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();

//		if (getAmOrPm() == 0) {
			strDate[0] = getStrYestoday(date) + " 00:00:00";
			strDate[1] = getStrYestoday(date) + " 23:59:59";
//		}else {
//			strDate[0] = sdf.format(date) + " 00:00:00";
//			strDate[1] = sdf.format(date) + " 23:59:59";
//		}

		return strDate;
	}
	
/*	public static Date[] getStartDateEndDate(String dirname) {
		Date[] date = new Date[2];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String[] strs = new String[2];
		if (dirname == null) {
			strs = DateUtil.getStartDateAndEndDate();
		}else if (dirname.equals(PropertyUtil.getProperty("wcpbak"))
			|| dirname.equals(PropertyUtil.getProperty("invalidbak")) 
			|| dirname.equals(PropertyUtil.getProperty("complaintbak"))){
			strs = DateUtil.getStrStartDateAndEndDate();
		}else{
			strs = DateUtil.getStartDateAndEndDate();
		}
		
			
			try {
				date[0] = sdf.parse(strs[0]);
				date[1] = sdf.parse(strs[1]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return date;
	}*/
	
	public static Date[] getStartDateEndDateCarmen(String dirname) {
		Date[] date = new Date[2];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String[] strs = new String[2];
		strs = getStrStartDateAndEndDateCarmen();
		
			try {
				date[0] = sdf.parse(strs[0]);
				date[1] = sdf.parse(strs[1]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return date;
	}
	
	public static int getAmOrPm(){
		GregorianCalendar ca = new GregorianCalendar();  
		return ca.get(GregorianCalendar.AM_PM);
	}
	
	public static String getStrDate(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	
	public static String getStrYestoday(Date date) {
		if (date == null) {
			return "";
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		int startDate = cal.get(Calendar.DAY_OF_YEAR);
		cal.set(Calendar.DAY_OF_YEAR, startDate - 1);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		return sdf.format(cal.getTime()); 

	}
	public static String getStrBeforeDays(Date date, int days) {
		if (date == null) {
			return "";
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		int startDate = cal.get(Calendar.DAY_OF_YEAR);
		cal.set(Calendar.DAY_OF_YEAR, startDate - days);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		return sdf.format(cal.getTime()); 

	}
	/*public static String getStrYestodayAMPM(Date date) {
		if (date == null) {
			return "";
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		int startDate = cal.get(Calendar.DAY_OF_YEAR);
		cal.set(Calendar.DAY_OF_YEAR, startDate - 1);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");

		return sdf.format(getStartDateEndDate(null)[0]) + "-" + sdf.format(getStartDateEndDate(null)[1]); 

	}*/
	/**
	 * 格式化时间
	 * 
	 * @param format
	 *            格式化显示样式
	 * @param date
	 *            时间
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String format(String format, Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	public static void main(String[] args) {
		System.out.println(getStrBeforeDays(new Date(), 1));
	}

}
