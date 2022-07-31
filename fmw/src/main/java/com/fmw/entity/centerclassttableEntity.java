package com.fmw.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sw_center_class_ttable")
public class centerclassttableEntity {

	@Id
	@Column(name = "cctt_id")
	private String ccttid;

	@Column(name = "class_id")
	private String classid;

	@Column(name = "cctt_time")
	private int cctttime;

	@Column(name = "cctt_day")
	private String ccttday;

	@Column(name = "cctt_type")
	private String cctttype;

	@Column(name = "reg_dt")
	private Timestamp regdt;

	@Column(name = "mdfy_dt")
	private Timestamp mdfydt;

	public String getCcttid() {
		return ccttid;
	}

	public void setCcttid(String ccttid) {
		this.ccttid = ccttid;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public int getCctttime() {
		return cctttime;
	}

	public void setCctttime(int cctttime) {
		this.cctttime = cctttime;
	}

	public String getCcttday() {
		return ccttday;
	}

	public void setCcttday(String ccttday) {
		this.ccttday = ccttday;
	}

	public String getCctttype() {
		return cctttype;
	}

	public void setCctttype(String cctttype) {
		this.cctttype = cctttype;
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
