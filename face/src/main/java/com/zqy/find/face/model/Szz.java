package com.zqy.find.face.model;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.zqy.dao.mogo.GeneratedValue;


@Document
public class Szz implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -520477724211889205L;
	
	@GeneratedValue
	@Id
	private long id;//id
	private long xqzid;
	private String xm;
	private String nl;
	private Short xb;//0:男 1：女
	private Timestamp sr;//
	private Timestamp szrq;//
	private Integer faceid;//
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getXqzid() {
		return xqzid;
	}
	public void setXqzid(long xqzid) {
		this.xqzid = xqzid;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getNl() {
		return nl;
	}
	public void setNl(String nl) {
		this.nl = nl;
	}
	public Short getXb() {
		return xb;
	}
	public void setXb(Short xb) {
		this.xb = xb;
	}
	public Timestamp getSr() {
		return sr;
	}
	public void setSr(Timestamp sr) {
		this.sr = sr;
	}
	public Timestamp getSzrq() {
		return szrq;
	}
	public void setSzrq(Timestamp szrq) {
		this.szrq = szrq;
	}
	public Integer getFaceid() {
		return faceid;
	}
	public void setFaceid(Integer faceid) {
		this.faceid = faceid;
	}
}
