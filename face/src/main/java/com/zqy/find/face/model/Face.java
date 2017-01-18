package com.zqy.find.face.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.zqy.dao.mogo.GeneratedValue;


@Document
public class Face implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3660372976788337778L;

	@GeneratedValue
	@Id
	private long id;//id
	private long szzid;
	private String faceFeat;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSzzid() {
		return szzid;
	}
	public void setSzzid(long szzid) {
		this.szzid = szzid;
	}
	public String getFaceFeat() {
		return faceFeat;
	}
	public void setFaceFeat(String faceFeat) {
		this.faceFeat = faceFeat;
	}
}
