package com.connext.utils;

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
public class TruckUtil {
	private String startCoordinate;
	private String endCoordinate;
	private String applicationKey;
	private String carsize;
	private String param;
	/**
	 * 必须要构造参数
	 * @param startCoordinate 起点经纬度 经度在前，纬度在后
	 * @param endCoordinate 终点经纬度 经度在前，纬度在后
	 * @param applicationKey 高德地图应用key，需要Web服务类型的key
	 */
	public TruckUtil(String startCoordinate, String endCoordinate,
			String applicationKey) {
		//出发地
		this.startCoordinate = startCoordinate;
		//目的地
		this.endCoordinate = endCoordinate;
//		key
		this.applicationKey = applicationKey;
		//车辆size 
		this.carsize="2";
		this.param="origin="+this.startCoordinate+"&destination="+this.endCoordinate+"&key="+this.applicationKey+"&size="+this.carsize;
	}
	/**
	 * 获取地图导航返回值
	 * @return
	 */
	public MapTruckResults getResults(){
		String sendGet = HttpRequest.sendGet("https://restapi.amap.com/v4/direction/truck", param);
		JSONObject jsonObject=JSONObject.fromObject(sendGet);
		String datejson = jsonObject.get("data").toString();
		JSONObject dateJsonObject = JSONObject.fromObject(datejson);
		
//		String routeJsonString = dateJsonObject.get("route").toString();
//		JSONObject routeObject = routeArray.getJSONObject(0);
		
		String routeJsonString = dateJsonObject.get("route").toString();
		JSONObject routeObject=JSONObject.fromObject(routeJsonString);
		JSONArray jsonArray = routeObject.getJSONArray("paths");
		JSONObject zuiJson = jsonArray.getJSONObject(0);
		MapTruckResults mapResult=new MapTruckResults();
		mapResult.setDistance(zuiJson.get("distance").toString());
		mapResult.setDuration(zuiJson.get("duration").toString());
		mapResult.setTolls(zuiJson.get("tolls").toString());
		mapResult.setTraffic_lights(zuiJson.getString("traffic_lights"));
		mapResult.setRestriction(zuiJson.getString("restriction"));
		return mapResult;
	}
	
	
}