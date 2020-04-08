package com.connext.dto;

public class taoResults {

	//优惠券门槛金额	
	private String coupon_start_fee;
	//优惠券剩余量
	private String coupon_remain_count;
	//优惠券总量
	private String coupon_total_count;
	//优惠券结束时间
	private String coupon_end_time;
	//优惠券开始时间
	private String coupon_start_time;
	//优惠券金额
	private String coupon_amount;
	//券类型，1 表示全网公开券，4 表示妈妈渠道券
	private String coupon_src_scene;
	//券属性，0表示店铺券，1表示单品券
	private String coupon_type;
	//券ID
	private String coupon_activity_id;
	public String getCoupon_start_fee() {
		return coupon_start_fee;
	}
	public void setCoupon_start_fee(String coupon_start_fee) {
		this.coupon_start_fee = coupon_start_fee;
	}
	public String getCoupon_remain_count() {
		return coupon_remain_count;
	}
	public void setCoupon_remain_count(String coupon_remain_count) {
		this.coupon_remain_count = coupon_remain_count;
	}
	public String getCoupon_total_count() {
		return coupon_total_count;
	}
	public void setCoupon_total_count(String coupon_total_count) {
		this.coupon_total_count = coupon_total_count;
	}
	public String getCoupon_end_time() {
		return coupon_end_time;
	}
	public void setCoupon_end_time(String coupon_end_time) {
		this.coupon_end_time = coupon_end_time;
	}
	public String getCoupon_start_time() {
		return coupon_start_time;
	}
	public void setCoupon_start_time(String coupon_start_time) {
		this.coupon_start_time = coupon_start_time;
	}
	public String getCoupon_amount() {
		return coupon_amount;
	}
	public void setCoupon_amount(String coupon_amount) {
		this.coupon_amount = coupon_amount;
	}
	public String getCoupon_src_scene() {
		return coupon_src_scene;
	}
	public void setCoupon_src_scene(String coupon_src_scene) {
		this.coupon_src_scene = coupon_src_scene;
	}
	public String getCoupon_type() {
		return coupon_type;
	}
	public void setCoupon_type(String coupon_type) {
		this.coupon_type = coupon_type;
	}
	public String getCoupon_activity_id() {
		return coupon_activity_id;
	}
	public void setCoupon_activity_id(String coupon_activity_id) {
		this.coupon_activity_id = coupon_activity_id;
	}
	@Override
	public String toString() {
		return "taoResults [coupon_start_fee=" + coupon_start_fee + ", coupon_remain_count=" + coupon_remain_count
				+ ", coupon_total_count=" + coupon_total_count + ", coupon_end_time=" + coupon_end_time
				+ ", coupon_start_time=" + coupon_start_time + ", coupon_amount=" + coupon_amount
				+ ", coupon_src_scene=" + coupon_src_scene + ", coupon_type=" + coupon_type + ", coupon_activity_id="
				+ coupon_activity_id + "]";
	}
	
	
	
	
}
