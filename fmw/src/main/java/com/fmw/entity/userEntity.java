package com.fmw.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sw_user")
public class userEntity {

	@Id
	@Column(name = "uid")
	private String uid;

	@Column(name = "nickname")
	private String nickname;

	@Column(name = "sns_login_ci")
	private String snsloginci;

	@Column(name = "report_num")
	private int reportnum;

	@Column(name = "act_yn")
	private String actyn;

	@Column(name = "user_type")
	private String usertype;

	@Column(name = "reg_dt")
	private Timestamp regdt;

	@Column(name = "mdfy_dt")
	private Timestamp mdfydt;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSnsloginci() {
		return snsloginci;
	}

	public void setSnsloginci(String snsloginci) {
		this.snsloginci = snsloginci;
	}

	public int getReportnum() {
		return reportnum;
	}

	public void setReportnum(int reportnum) {
		this.reportnum = reportnum;
	}

	public String getActyn() {
		return actyn;
	}

	public void setActyn(String actyn) {
		this.actyn = actyn;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
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
