package com.fmw.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sw_center")
public class centerEntity {

	@Column(name = "center_nm")
	private String centernm;

	@Column(name = "center_location")
	private String centerlocation;

	@Column(name = "center_address_city")
	private String centeraddresscity;

	@Column(name = "center_address_gu")
	private String centeraddressgu;

	@Column(name = "center_address_detail")
	private String centeraddressdetail;

	@Column(name = "center_phone")
	private String centerphone;

	@Column(name = "center_website")
	private String centerwebsite;

	@Column(name = "center_sns")
	private String centersns;

	@Column(name = "center_parking_yn")
	private String centerparkingyn;

	@Column(name = "center_image")
	private String centerimage;

	@Column(name = "center_detail")
	private String centerdetail;

	@Column(name = "center_holiday")
	private String centerholiday;

	@Column(name = "center_rule")
	private String centerrule;

	@Column(name = "center_lane_len")
	private String centerlanelen;

	@Column(name = "center_lane_num")
	private int centerlanenum;

	@Column(name = "center_lane_depth")
	private double centerlanedepth;

	@Column(name = "center_sea_yn")
	private String centerseayn;

	@Column(name = "center_warm_yn")
	private String centerwarmyn;

	@Column(name = "center_dv_yn")
	private String centerdvyn;

	@Column(name = "center_child_yn")
	private String centerchildyn;

	@Column(name = "center_locker_yn")
	private String centerlockeryn;

	@Column(name = "center_locker_price")
	private String centerlockerprice;

	@Column(name = "center_tower_yn")
	private String centertoweryn;

	@Column(name = "center_tower_price")
	private String centertowerprice;

	@Column(name = "center_shuttle_yn")
	private String centershuttleyn;

	@Column(name = "center_shop_yn")
	private String centershopyn;

	@Column(name = "center_etc_yn")
	private String centeretcyn;

	@Column(name = "center_break_yn")
	private String centerbreakyn;

	@Column(name = "center_thumb_up")
	private int centerthumbup;

	@Column(name = "center_thumb_down")
	private int centerthumbdown;

	@Column(name = "reg_dt")
	private Timestamp regdt;

	@Column(name = "mdfy_dt")
	private Timestamp mdfydt;

	@Id
	@Column(name = "center_id")
	private String centerid;

	public String getCenterid() {
		return centerid;
	}

	public void setCenterid(String centerid) {
		this.centerid = centerid;
	}

	public String getCenternm() {
		return centernm;
	}

	public void setCenternm(String centernm) {
		this.centernm = centernm;
	}

	public String getCenterlocation() {
		return centerlocation;
	}

	public void setCenterlocation(String centerlocation) {
		this.centerlocation = centerlocation;
	}

	public String getCenteraddresscity() {
		return centeraddresscity;
	}

	public void setCenteraddresscity(String centeraddresscity) {
		this.centeraddresscity = centeraddresscity;
	}

	public String getCenteraddressgu() {
		return centeraddressgu;
	}

	public void setCenteraddressgu(String centeraddressgu) {
		this.centeraddressgu = centeraddressgu;
	}

	public String getCenteraddressdetail() {
		return centeraddressdetail;
	}

	public void setCenteraddressdetail(String centeraddressdetail) {
		this.centeraddressdetail = centeraddressdetail;
	}

	public String getCenterphone() {
		return centerphone;
	}

	public void setCenterphone(String centerphone) {
		this.centerphone = centerphone;
	}

	public String getCenterwebsite() {
		return centerwebsite;
	}

	public void setCenterwebsite(String centerwebsite) {
		this.centerwebsite = centerwebsite;
	}

	public String getCentersns() {
		return centersns;
	}

	public void setCentersns(String centersns) {
		this.centersns = centersns;
	}

	public String getCenterparkingyn() {
		return centerparkingyn;
	}

	public void setCenterparkingyn(String centerparkingyn) {
		this.centerparkingyn = centerparkingyn;
	}

	public String getCenterimage() {
		return centerimage;
	}

	public void setCenterimage(String centerimage) {
		this.centerimage = centerimage;
	}

	public String getCenterdetail() {
		return centerdetail;
	}

	public void setCenterdetail(String centerdetail) {
		this.centerdetail = centerdetail;
	}

	public String getCenterholiday() {
		return centerholiday;
	}

	public void setCenterholiday(String centerholiday) {
		this.centerholiday = centerholiday;
	}

	public String getCenterrule() {
		return centerrule;
	}

	public void setCenterrule(String centerrule) {
		this.centerrule = centerrule;
	}

	public String getCenterlanelen() {
		return centerlanelen;
	}

	public void setCenterlanelen(String centerlanelen) {
		this.centerlanelen = centerlanelen;
	}

	public int getCenterlanenum() {
		return centerlanenum;
	}

	public void setCenterlanenum(int centerlanenum) {
		this.centerlanenum = centerlanenum;
	}

	public double getCenterlanedepth() {
		return centerlanedepth;
	}

	public void setCenterlanedepth(double centerlanedepth) {
		this.centerlanedepth = centerlanedepth;
	}

	public String getCenterseayn() {
		return centerseayn;
	}

	public void setCenterseayn(String centerseayn) {
		this.centerseayn = centerseayn;
	}

	public String getCenterwarmyn() {
		return centerwarmyn;
	}

	public void setCenterwarmyn(String centerwarmyn) {
		this.centerwarmyn = centerwarmyn;
	}

	public String getCenterdvyn() {
		return centerdvyn;
	}

	public void setCenterdvyn(String centerdvyn) {
		this.centerdvyn = centerdvyn;
	}

	public String getCenterchildyn() {
		return centerchildyn;
	}

	public void setCenterchildyn(String centerchildyn) {
		this.centerchildyn = centerchildyn;
	}

	public String getCenterlockeryn() {
		return centerlockeryn;
	}

	public void setCenterlockeryn(String centerlockeryn) {
		this.centerlockeryn = centerlockeryn;
	}

	public String getCenterlockerprice() {
		return centerlockerprice;
	}

	public void setCenterlockerprice(String centerlockerprice) {
		this.centerlockerprice = centerlockerprice;
	}

	public String getCentertoweryn() {
		return centertoweryn;
	}

	public void setCentertoweryn(String centertoweryn) {
		this.centertoweryn = centertoweryn;
	}

	public String getCentertowerprice() {
		return centertowerprice;
	}

	public void setCentertowerprice(String centertowerprice) {
		this.centertowerprice = centertowerprice;
	}

	public String getCentershuttleyn() {
		return centershuttleyn;
	}

	public void setCentershuttleyn(String centershuttleyn) {
		this.centershuttleyn = centershuttleyn;
	}

	public String getCentershopyn() {
		return centershopyn;
	}

	public void setCentershopyn(String centershopyn) {
		this.centershopyn = centershopyn;
	}

	public String getCenteretcyn() {
		return centeretcyn;
	}

	public void setCenteretcyn(String centeretcyn) {
		this.centeretcyn = centeretcyn;
	}

	public String getCenterbreakyn() {
		return centerbreakyn;
	}

	public void setCenterbreakyn(String centerbreakyn) {
		this.centerbreakyn = centerbreakyn;
	}

	public int getCenterthumbup() {
		return centerthumbup;
	}

	public void setCenterthumbup(int centerthumbup) {
		this.centerthumbup = centerthumbup;
	}

	public int getCenterthumbdown() {
		return centerthumbdown;
	}

	public void setCenterthumbdown(int centerthumbdown) {
		this.centerthumbdown = centerthumbdown;
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
