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
	@Column
	private String uid;
	@Column
	private String nickname;
	@Column(name = "sns_login_ci")
	private String snsloginci;
	@Column
	private int report_num;
	@Column
	private String act_yn;
	@Column
	private String user_type;
	@Column
	private Timestamp reg_dt;
	@Column
	private Timestamp mdfy_dt;

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

	public int getReport_num() {
		return report_num;
	}

	public void setReport_num(int report_num) {
		this.report_num = report_num;
	}

	public String getAct_yn() {
		return act_yn;
	}

	public void setAct_yn(String act_yn) {
		this.act_yn = act_yn;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
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
	

	@Override
	public String toString() {
		return "userEntity [uid=" + uid + ", nickname=" + nickname + ", snsloginci=" + snsloginci + ", report_num="
				+ report_num + ", act_yn=" + act_yn + ", user_type=" + user_type + ", reg_dt=" + reg_dt + ", mdfy_dt="
				+ mdfy_dt + "]";
	}


}
