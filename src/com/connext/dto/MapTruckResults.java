package com.connext.dto;
/**
 * 高德地图导航接口返回参数POJO
 * @开发者 tiddler
 * @编写时间 2018年8月14日 上午10:04:50
 * @文件名 MapNavResults.java
 * @类名 MapNavResults
 */
public class MapTruckResults {
	private String distance;//行驶距离
	private String duration;//行驶时间（单位：秒）
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getTolls() {
		return tolls;
	}
	public void setTolls(String tolls) {
		this.tolls = tolls;
	}
	public String getRestriction() {
		return restriction;
	}
	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}
	public String getTraffic_lights() {
		return traffic_lights;
	}
	public void setTraffic_lights(String traffic_lights) {
		this.traffic_lights = traffic_lights;
	}
	private String tolls;//道路收费（单位：元）
	private String restriction;//限行结果
	private String traffic_lights ;//此方案红绿灯总数 
	public MapTruckResults() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MapTruckResults(String distance, String duration, String tolls, String restriction, String traffic_lights) {
		super();
		this.distance = distance;
		this.duration = duration;
		this.tolls = tolls;
		this.restriction = restriction;
		this.traffic_lights = traffic_lights;
	}
	@Override
	public String toString() {
		return "MapTruckResults [行驶距离:=" + distance + ", 行驶时间:=" + duration + ",  限行结果:=" + restriction + ", 此方案红绿灯总数 :=" + traffic_lights + "]";
	}
	
	
	
	
}