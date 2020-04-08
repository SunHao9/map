package com.connext.utils;

import com.connext.dto.CodeResults;
import com.connext.dto.MapNavResults;
import com.connext.dto.MapTruckResults;
import com.connext.http.HttpRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 高德地图导航工具类
 * @开发者 tiddler
 * @编写时间 2018年8月14日 上午10:01:05
 * @文件名 MapNavUtil.java
 * @类名 MapNavUtil
 */
public class CodeUtil {
	private String cityaddress;
	private String applicationKey;
	private String param;
	/**
	 * 必须要构造参数
	 * @param startCoordinate 起点经纬度 经度在前，纬度在后
	 * @param endCoordinate 终点经纬度 经度在前，纬度在后
	 * @param applicationKey 高德地图应用key，需要Web服务类型的key
	 */
	public CodeUtil(String cityaddress, 
			String applicationKey) {
		//城市
		this.cityaddress = cityaddress;
		
//		key
		this.applicationKey = applicationKey;
		//车辆size 
		this.param="address="+this.cityaddress+"&key="+this.applicationKey;
	}
	/**
	 * 获取地图导航返回值
	 * @return
	 */
	public CodeResults getResults() throws Exception{
		String sendGet = HttpRequest.sendGet("https://restapi.amap.com/v3/geocode/geo", param);
		JSONObject jsonObject=JSONObject.fromObject(sendGet);
		
		JSONArray jsonArray = jsonObject.getJSONArray("geocodes");
		JSONObject zuiJson = jsonArray.getJSONObject(0);
		
		
		CodeResults mapResult=new CodeResults();
		mapResult.setProvince(zuiJson.getString("province").toString());
		mapResult.setCity(zuiJson.getString("city").toString());
		mapResult.setLocation(zuiJson.getString("location").toString());
		
		return mapResult;
	}
	
	
}