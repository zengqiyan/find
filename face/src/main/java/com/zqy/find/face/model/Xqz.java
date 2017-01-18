package com.zqy.find.face.model;

import java.io.Serializable;

public class Xqz implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9166061971204279663L;
	private Integer xqzid;//id
	private String xm;//姓名
	private String dh;//电话
	private String dz;//地址
	private String yx;//邮箱
	public Integer getXqzid() {
		return xqzid;
	}
	public void setXqzid(Integer xqzid) {
		this.xqzid = xqzid;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	public String getDz() {
		return dz;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
	public String getYx() {
		return yx;
	}
	public void setYx(String yx) {
		this.yx = yx;
	}
}