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
	@Column(name = "pool_id")
	private String poolid;

	@Column(name = "pool_nm")
	private String poolnm;

	@Column(name = "pool_location")
	private String poollocation;

	@Column(name = "pool_address_city")
	private String pooladdresscity;

	@Column(name = "pool_address_gu")
	private String pooladdressgu;

	@Column(name = "pool_address_detail")
	private String pooladdressdetail;

	@Column(name = "pool_phone")
	private String poolphone;

	@Column(name = "pool_website")
	private String poolwebsite;

	@Column(name = "pool_instargram")
	private String poolinstargram;

	@Column(name = "pool_parking_yn")
	private String poolparkingyn;

	@Column(name = "pool_image")
	private String poolimage;

	@Column(name = "pool_detail")
	private String pooldetail;

	@Column(name = "pool_lane_len")
	private int poollanelen;

	@Column(name = "pool_lane_num")
	private int poollanenum;

	@Column(name = "pool_lane_depth")
	private double poollanedepth;

	@Column(name = "pool_sea_yn")
	private String poolseayn;

	@Column(name = "pool_child_yn")
	private String poolchildyn;

	@Column(name = "pool_locker_yn")
	private String poollockeryn;

	@Column(name = "pool_locker_price")
	private String poollockerprice;

	@Column(name = "pool_tower_yn")
	private String pooltoweryn;

	@Column(name = "pool_tower_price")
	private String pooltowerprice;

	@Column(name = "pool_shuttle_yn")
	private String poolshuttleyn;

	@Column(name = "pool_shop_yn")
	private String poolshopyn;

	@Column(name = "pool_etc_yn")
	private String pooletcyn;

	@Column(name = "pool_break_yn")
	private String poolbreakyn;

	@Column(name = "pool_thumb_up")
	private int poolthumbup;

	@Column(name = "pool_thumb_down")
	private int poolthumbdown;

	@Column(name = "reg_dt")
	private Timestamp regdt;

	@Column(name = "mdfy_dt")
	private Timestamp mdfydt;

	public String getPoolid() {
		return poolid;
	}

	public void setPoolid(String poolid) {
		this.poolid = poolid;
	}

	public String getPoolnm() {
		return poolnm;
	}

	public void setPoolnm(String poolnm) {
		this.poolnm = poolnm;
	}

	public String getPoollocation() {
		return poollocation;
	}

	public void setPoollocation(String poollocation) {
		this.poollocation = poollocation;
	}

	public String getPooladdresscity() {
		return pooladdresscity;
	}

	public void setPooladdresscity(String pooladdresscity) {
		this.pooladdresscity = pooladdresscity;
	}

	public String getPooladdressgu() {
		return pooladdressgu;
	}

	public void setPooladdressgu(String pooladdressgu) {
		this.pooladdressgu = pooladdressgu;
	}

	public String getPooladdressdetail() {
		return pooladdressdetail;
	}

	public void setPooladdressdetail(String pooladdressdetail) {
		this.pooladdressdetail = pooladdressdetail;
	}

	public String getPoolphone() {
		return poolphone;
	}

	public void setPoolphone(String poolphone) {
		this.poolphone = poolphone;
	}

	public String getPoolwebsite() {
		return poolwebsite;
	}

	public void setPoolwebsite(String poolwebsite) {
		this.poolwebsite = poolwebsite;
	}

	public String getPoolinstargram() {
		return poolinstargram;
	}

	public void setPoolinstargram(String poolinstargram) {
		this.poolinstargram = poolinstargram;
	}

	public String getPoolparkingyn() {
		return poolparkingyn;
	}

	public void setPoolparkingyn(String poolparkingyn) {
		this.poolparkingyn = poolparkingyn;
	}

	public String getPoolimage() {
		return poolimage;
	}

	public void setPoolimage(String poolimage) {
		this.poolimage = poolimage;
	}

	public String getPooldetail() {
		return pooldetail;
	}

	public void setPooldetail(String pooldetail) {
		this.pooldetail = pooldetail;
	}

	public int getPoollanelen() {
		return poollanelen;
	}

	public void setPoollanelen(int poollanelen) {
		this.poollanelen = poollanelen;
	}

	public int getPoollanenum() {
		return poollanenum;
	}

	public void setPoollanenum(int poollanenum) {
		this.poollanenum = poollanenum;
	}

	public double getPoollanedepth() {
		return poollanedepth;
	}

	public void setPoollanedepth(double poollanedepth) {
		this.poollanedepth = poollanedepth;
	}

	public String getPoolseayn() {
		return poolseayn;
	}

	public void setPoolseayn(String poolseayn) {
		this.poolseayn = poolseayn;
	}

	public String getPoolchildyn() {
		return poolchildyn;
	}

	public void setPoolchildyn(String poolchildyn) {
		this.poolchildyn = poolchildyn;
	}

	public String getPoollockeryn() {
		return poollockeryn;
	}

	public void setPoollockeryn(String poollockeryn) {
		this.poollockeryn = poollockeryn;
	}

	public String getPoollockerprice() {
		return poollockerprice;
	}

	public void setPoollockerprice(String poollockerprice) {
		this.poollockerprice = poollockerprice;
	}

	public String getPooltoweryn() {
		return pooltoweryn;
	}

	public void setPooltoweryn(String pooltoweryn) {
		this.pooltoweryn = pooltoweryn;
	}

	public String getPooltowerprice() {
		return pooltowerprice;
	}

	public void setPooltowerprice(String pooltowerprice) {
		this.pooltowerprice = pooltowerprice;
	}

	public String getPoolshuttleyn() {
		return poolshuttleyn;
	}

	public void setPoolshuttleyn(String poolshuttleyn) {
		this.poolshuttleyn = poolshuttleyn;
	}

	public String getPoolshopyn() {
		return poolshopyn;
	}

	public void setPoolshopyn(String poolshopyn) {
		this.poolshopyn = poolshopyn;
	}

	public String getPooletcyn() {
		return pooletcyn;
	}

	public void setPooletcyn(String pooletcyn) {
		this.pooletcyn = pooletcyn;
	}

	public String getPoolbreakyn() {
		return poolbreakyn;
	}

	public void setPoolbreakyn(String poolbreakyn) {
		this.poolbreakyn = poolbreakyn;
	}

	public int getPoolthumbup() {
		return poolthumbup;
	}

	public void setPoolthumbup(int poolthumbup) {
		this.poolthumbup = poolthumbup;
	}

	public int getPoolthumbdown() {
		return poolthumbdown;
	}

	public void setPoolthumbdown(int poolthumbdown) {
		this.poolthumbdown = poolthumbdown;
	}

	public Timestamp getRegdt() {
		return regdt;
	}

	public void setRegdt(Timestamp regdt) {
		this.regdt = regdt;
	}

	public Timestamp getMdfydt() {
		return mdfydt;
	}

	public void setMdfydt(Timestamp mdfydt) {
		this.mdfydt = mdfydt;
	}

}
