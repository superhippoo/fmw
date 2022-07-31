package com.fmw.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sw_center_class")
public class centerclassEntity {

	@Id
	@Column(name = "class_id")
	private String classid;

	@Column(name = "class_nm")
	private String classnm;

	@Column(name = "center_id")
	private String centerid;

	@Column(name = "class_type1")
	private String classtype1;

	@Column(name = "class_type1_fee")
	private String classtype1fee;

	@Column(name = "class_type2")
	private String classtype2;

	@Column(name = "class_type2_fee")
	private String classtype2fee;

	@Column(name = "class_type3")
	private String classtype3;

	@Column(name = "class_type3_fee")
	private String classtype3fee;

	@Column(name = "class_type4")
	private String classtype4;

	@Column(name = "class_type4_fee")
	private String classtype4fee;

	@Column(name = "class_use")
	private String classuse;

	@Column(name = "class_limit")
	private String classlimit;

	@Column(name = "reg_dt")
	private Timestamp regdt;

	@Column(name = "mdfy_dt")
	private Timestamp mdfydt;

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getClassnm() {
		return classnm;
	}

	public void setClassnm(String classnm) {
		this.classnm = classnm;
	}

	public String getCenterid() {
		return centerid;
	}

	public void setCenterid(String centerid) {
		this.centerid = centerid;
	}

	public String getClasstype1() {
		return classtype1;
	}

	public void setClasstype1(String classtype1) {
		this.classtype1 = classtype1;
	}

	public String getClasstype1fee() {
		return classtype1fee;
	}

	public void setClasstype1fee(String classtype1fee) {
		this.classtype1fee = classtype1fee;
	}

	public String getClasstype2() {
		return classtype2;
	}

	public void setClasstype2(String classtype2) {
		this.classtype2 = classtype2;
	}

	public String getClasstype2fee() {
		return classtype2fee;
	}

	public void setClasstype2fee(String classtype2fee) {
		this.classtype2fee = classtype2fee;
	}

	public String getClasstype3() {
		return classtype3;
	}

	public void setClasstype3(String classtype3) {
		this.classtype3 = classtype3;
	}

	public String getClasstype3fee() {
		return classtype3fee;
	}

	public void setClasstype3fee(String classtype3fee) {
		this.classtype3fee = classtype3fee;
	}

	public String getClasstype4() {
		return classtype4;
	}

	public void setClasstype4(String classtype4) {
		this.classtype4 = classtype4;
	}

	public String getClasstype4fee() {
		return classtype4fee;
	}

	public void setClasstype4fee(String classtype4fee) {
		this.classtype4fee = classtype4fee;
	}

	public String getClassuse() {
		return classuse;
	}

	public void setClassuse(String classuse) {
		this.classuse = classuse;
	}

	public String getClasslimit() {
		return classlimit;
	}

	public void setClasslimit(String classlimit) {
		this.classlimit = classlimit;
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
