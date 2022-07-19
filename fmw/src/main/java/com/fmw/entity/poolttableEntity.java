package com.fmw.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sw_pool_ttable")
public class poolttableEntity {

	@Id
	@Column(name = "ptt_id")
	private String pttid;

	@Column(name = "pool_id")
	private String poolid;

	@Column(name = "ptt_order_num")
	private int pttordernum;

	@Column(name = "ptt_day")
	private String pttday;

	@Column(name = "ptt_time")
	private String ptttime;

	@Column(name = "reg_dt")
	private Timestamp regdt;

	@Column(name = "mdfy_dt")
	private Timestamp mdfydt;

	public String getPttid() {
		return pttid;
	}

	public void setPttid(String pttid) {
		this.pttid = pttid;
	}

	public String getPoolid() {
		return poolid;
	}

	public void setPoolid(String poolid) {
		this.poolid = poolid;
	}

	public int getPttordernum() {
		return pttordernum;
	}

	public void setPttordernum(int pttordernum) {
		this.pttordernum = pttordernum;
	}

	public String getPttday() {
		return pttday;
	}

	public void setPttday(String pttday) {
		this.pttday = pttday;
	}

	public String getPtttime() {
		return ptttime;
	}

	public void setPtttime(String ptttime) {
		this.ptttime = ptttime;
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
