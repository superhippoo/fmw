package com.fmw.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sw_center_ttable")
public class centerttableEntity {

	@Id
	@Column(name = "ctt_id")
	private String cttid;

	@Column(name = "center_id")
	private String centerid;

	@Column(name = "ctt_order_num")
	private int cttordernum;

	@Column(name = "ctt_day")
	private String cttday;

	@Column(name = "ctt_time")
	private String ctttime;

	@Column(name = "reg_dt")
	private Timestamp regdt;

	@Column(name = "mdfy_dt")
	private Timestamp mdfydt;

	public String getCttid() {
		return cttid;
	}

	public void setCttid(String cttid) {
		this.cttid = cttid;
	}

	public String getCenterid() {
		return centerid;
	}

	public void setCenterid(String centerid) {
		this.centerid = centerid;
	}

	public int getCttordernum() {
		return cttordernum;
	}

	public void setCttordernum(int cttordernum) {
		this.cttordernum = cttordernum;
	}

	public String getCttday() {
		return cttday;
	}

	public void setCttday(String cttday) {
		this.cttday = cttday;
	}

	public String getCtttime() {
		return ctttime;
	}

	public void setCtttime(String ctttime) {
		this.ctttime = ctttime;
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
