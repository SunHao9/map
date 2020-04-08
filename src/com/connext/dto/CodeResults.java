package com.connext.dto;

public class CodeResults {

	private String province; //省份
	private String city;//城市
	private String location;//坐标
	public CodeResults() {
		super();
	}
	public CodeResults(String province, String city, String location) {
		super();
		this.province = province;
		this.city = city;
		this.location = location;
	}
	@Override
	public String toString() {
		return "CodeResults [省份:=" + province + ", 城市:=" + city + ", 坐标:=" + location + "]";
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
