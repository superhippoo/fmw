package com.fmw.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sw_pool")
public class poolEntity {

	@Id
	@Column
	private String pool_id;
	@Column(name = "pool_nm")
	private String poolnm;
	@Column
	private String pool_location;
	@Column
	private String pool_address_city;
	@Column
	private String pool_address_gu;
	@Column
	private String pool_address_detail;
	@Column
	private String pool_phone;
	@Column
	private String pool_website;
	@Column
	private String pool_instargram;
	@Column
	private String pool_parking_yn;
	@Column
	private String pool_image;
	@Column
	private String pool_detail;
	@Column
	private int pool_lane_len;
	@Column
	private int pool_lane_num;
	@Column
	private double pool_lane_depth;
	@Column
	private String pool_sea_yn;
	@Column
	private String pool_child_yn;
	@Column
	private String pool_locker_yn;
	@Column
	private String pool_locker_price;
	@Column
	private String pool_tower_yn;
	@Column
	private String pool_tower_price;
	@Column
	private String pool_shuttle_yn;
	@Column
	private String pool_shop_yn;
	@Column
	private String pool_etc_yn;
	@Column
	private String pool_break_yn;
	@Column
	private int pool_thumb_up;
	@Column
	private int pool_thumb_down;
	@Column
	private Timestamp reg_dt;
	@Column
	private Timestamp mdfy_dt;

	public String getPool_id() {
		return pool_id;
	}

	public void setPool_id(String pool_id) {
		this.pool_id = pool_id;
	}

	public String getPoolnm() {
		return poolnm;
	}

	public void setPoolnm(String poolnm) {
		this.poolnm = poolnm;
	}

	public String getPool_location() {
		return pool_location;
	}

	public void setPool_location(String pool_location) {
		this.pool_location = pool_location;
	}

	public String getPool_address_city() {
		return pool_address_city;
	}

	public void setPool_address_city(String pool_address_city) {
		this.pool_address_city = pool_address_city;
	}

	public String getPool_address_gu() {
		return pool_address_gu;
	}

	public void setPool_address_gu(String pool_address_gu) {
		this.pool_address_gu = pool_address_gu;
	}

	public String getPool_address_detail() {
		return pool_address_detail;
	}

	public void setPool_address_detail(String pool_address_detail) {
		this.pool_address_detail = pool_address_detail;
	}

	public String getPool_phone() {
		return pool_phone;
	}

	public void setPool_phone(String pool_phone) {
		this.pool_phone = pool_phone;
	}

	public String getPool_website() {
		return pool_website;
	}

	public void setPool_website(String pool_website) {
		this.pool_website = pool_website;
	}

	public String getPool_instargram() {
		return pool_instargram;
	}

	public void setPool_instargram(String pool_instargram) {
		this.pool_instargram = pool_instargram;
	}

	public String getPool_parking_yn() {
		return pool_parking_yn;
	}

	public void setPool_parking_yn(String pool_parking_yn) {
		this.pool_parking_yn = pool_parking_yn;
	}

	public String getPool_image() {
		return pool_image;
	}

	public void setPool_image(String pool_image) {
		this.pool_image = pool_image;
	}

	public String getPool_detail() {
		return pool_detail;
	}

	public void setPool_detail(String pool_detail) {
		this.pool_detail = pool_detail;
	}

	public int getPool_lane_len() {
		return pool_lane_len;
	}

	public void setPool_lane_len(int pool_lane_len) {
		this.pool_lane_len = pool_lane_len;
	}

	public int getPool_lane_num() {
		return pool_lane_num;
	}

	public void setPool_lane_num(int pool_lane_num) {
		this.pool_lane_num = pool_lane_num;
	}

	public double getPool_lane_depth() {
		return pool_lane_depth;
	}

	public void setPool_lane_depth(int pool_lane_depth) {
		this.pool_lane_depth = pool_lane_depth;
	}

	public String getPool_sea_yn() {
		return pool_sea_yn;
	}

	public void setPool_sea_yn(String pool_sea_yn) {
		this.pool_sea_yn = pool_sea_yn;
	}

	public String getPool_child_yn() {
		return pool_child_yn;
	}

	public void setPool_child_yn(String pool_child_yn) {
		this.pool_child_yn = pool_child_yn;
	}

	public String getPool_locker_yn() {
		return pool_locker_yn;
	}

	public void setPool_locker_yn(String pool_locker_yn) {
		this.pool_locker_yn = pool_locker_yn;
	}

	public String getPool_locker_price() {
		return pool_locker_price;
	}

	public void setPool_locker_price(String pool_locker_price) {
		this.pool_locker_price = pool_locker_price;
	}

	public String getPool_tower_yn() {
		return pool_tower_yn;
	}

	public void setPool_tower_yn(String pool_tower_yn) {
		this.pool_tower_yn = pool_tower_yn;
	}

	public String getPool_tower_price() {
		return pool_tower_price;
	}

	public void setPool_tower_price(String pool_tower_price) {
		this.pool_tower_price = pool_tower_price;
	}

	public String getPool_shuttle_yn() {
		return pool_shuttle_yn;
	}

	public void setPool_shuttle_yn(String pool_shuttle_yn) {
		this.pool_shuttle_yn = pool_shuttle_yn;
	}

	public String getPool_shop_yn() {
		return pool_shop_yn;
	}

	public void setPool_shop_yn(String pool_shop_yn) {
		this.pool_shop_yn = pool_shop_yn;
	}

	public String getPool_etc_yn() {
		return pool_etc_yn;
	}

	public void setPool_etc_yn(String pool_etc_yn) {
		this.pool_etc_yn = pool_etc_yn;
	}

	public String getPool_break_yn() {
		return pool_break_yn;
	}

	public void setPool_break_yn(String pool_break_yn) {
		this.pool_break_yn = pool_break_yn;
	}

	public int getPool_thumb_up() {
		return pool_thumb_up;
	}

	public void setPool_thumb_up(int pool_thumb_up) {
		this.pool_thumb_up = pool_thumb_up;
	}

	public int getPool_thumb_down() {
		return pool_thumb_down;
	}

	public void setPool_thumb_down(int pool_thumb_down) {
		this.pool_thumb_down = pool_thumb_down;
	}

	public Timestamp getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Timestamp reg_dt) {
		this.reg_dt = reg_dt;
	}

	public Timestamp getMdfy_dt() {
		return mdfy_dt;
	}

	public void setMdfy_dt(Timestamp mdfy_dt) {
		this.mdfy_dt = mdfy_dt;
	}

}
