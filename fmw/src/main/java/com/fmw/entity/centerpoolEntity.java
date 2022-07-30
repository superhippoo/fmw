package com.fmw.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sw_center_pool")
public class centerpoolEntity {

	@Id
	@Column(name = "pool_id")
	private String poolid;

	@Column(name = "center_id")
	private String centerid;

	@Column(name = "pool_nm")
	private String poolnm;

	@Column(name = "pool_lane_len")
	private String poollanelen;

	@Column(name = "pool_lane_num")
	private int poollanenum;

	@Column(name = "pool_lane_depth")
	private double poollanedepth;

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

	public String getCenterid() {
		return centerid;
	}

	public void setCenterid(String centerid) {
		this.centerid = centerid;
	}

	public String getPoolnm() {
		return poolnm;
	}

	public void setPoolnm(String poolnm) {
		this.poolnm = poolnm;
	}

	public String getPoollanelen() {
		return poollanelen;
	}

	public void setPoollanelen(String poollanelen) {
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
